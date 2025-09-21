package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.Map;

public class RequestManagerRetriever implements Handler.Callback {
    private static final RequestManagerFactory DEFAULT_FACTORY = new RequestManagerFactory() {
        public RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private volatile RequestManager applicationManager;
    private final RequestManagerFactory factory;
    private final FrameWaiter frameWaiter;
    private final LifecycleRequestManagerRetriever lifecycleRequestManagerRetriever;
    private final ArrayMap<View, Fragment> tempViewToSupportFragment = new ArrayMap<>();

    public interface RequestManagerFactory {
        RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context);
    }

    public RequestManagerRetriever(RequestManagerFactory factory2) {
        RequestManagerFactory requestManagerFactory = factory2 != null ? factory2 : DEFAULT_FACTORY;
        this.factory = requestManagerFactory;
        this.lifecycleRequestManagerRetriever = new LifecycleRequestManagerRetriever(requestManagerFactory);
        this.frameWaiter = buildFrameWaiter();
    }

    private static FrameWaiter buildFrameWaiter() {
        if (!HardwareConfigState.HARDWARE_BITMAPS_SUPPORTED || !HardwareConfigState.BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED) {
            return new DoNothingFirstFrameWaiter();
        }
        return new FirstFrameWaiter();
    }

    private RequestManager getApplicationManager(Context context) {
        if (this.applicationManager == null) {
            synchronized (this) {
                if (this.applicationManager == null) {
                    this.applicationManager = this.factory.build(Glide.get(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                }
            }
        }
        return this.applicationManager;
    }

    public RequestManager get(Context context) {
        if (context != null) {
            if (Util.isOnMainThread() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return get((FragmentActivity) context);
                }
                if ((context instanceof ContextWrapper) && ((ContextWrapper) context).getBaseContext().getApplicationContext() != null) {
                    return get(((ContextWrapper) context).getBaseContext());
                }
            }
            return getApplicationManager(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public RequestManager get(FragmentActivity activity) {
        if (Util.isOnBackgroundThread()) {
            return get(activity.getApplicationContext());
        }
        assertNotDestroyed(activity);
        this.frameWaiter.registerSelf(activity);
        boolean isActivityVisible = isActivityVisible(activity);
        return this.lifecycleRequestManagerRetriever.getOrCreate(activity, Glide.get(activity.getApplicationContext()), activity.getLifecycle(), activity.getSupportFragmentManager(), isActivityVisible);
    }

    public RequestManager get(Fragment fragment) {
        Preconditions.checkNotNull(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.isOnBackgroundThread()) {
            return get(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.frameWaiter.registerSelf(fragment.getActivity());
        }
        FragmentManager fm = fragment.getChildFragmentManager();
        Context context = fragment.getContext();
        return this.lifecycleRequestManagerRetriever.getOrCreate(context, Glide.get(context.getApplicationContext()), fragment.getLifecycle(), fm, fragment.isVisible());
    }

    @Deprecated
    public RequestManager get(Activity activity) {
        return get(activity.getApplicationContext());
    }

    public RequestManager get(View view) {
        if (Util.isOnBackgroundThread()) {
            return get(view.getContext().getApplicationContext());
        }
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activity = findActivity(view.getContext());
        if (activity == null) {
            return get(view.getContext().getApplicationContext());
        }
        if (!(activity instanceof FragmentActivity)) {
            return get(view.getContext().getApplicationContext());
        }
        Fragment fragment = findSupportFragment(view, (FragmentActivity) activity);
        return fragment != null ? get(fragment) : get((FragmentActivity) activity);
    }

    private static void findAllSupportFragmentsWithViews(Collection<Fragment> topLevelFragments, Map<View, Fragment> result) {
        if (topLevelFragments != null) {
            for (Fragment fragment : topLevelFragments) {
                if (!(fragment == null || fragment.getView() == null)) {
                    result.put(fragment.getView(), fragment);
                    findAllSupportFragmentsWithViews(fragment.getChildFragmentManager().getFragments(), result);
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v6, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.fragment.app.Fragment findSupportFragment(android.view.View r5, androidx.fragment.app.FragmentActivity r6) {
        /*
            r4 = this;
            androidx.collection.ArrayMap<android.view.View, androidx.fragment.app.Fragment> r0 = r4.tempViewToSupportFragment
            r0.clear()
            androidx.fragment.app.FragmentManager r0 = r6.getSupportFragmentManager()
            java.util.List r0 = r0.getFragments()
            androidx.collection.ArrayMap<android.view.View, androidx.fragment.app.Fragment> r1 = r4.tempViewToSupportFragment
            findAllSupportFragmentsWithViews(r0, r1)
            r0 = 0
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r6.findViewById(r1)
            r2 = r5
        L_0x001c:
            boolean r3 = r2.equals(r1)
            if (r3 != 0) goto L_0x003e
            androidx.collection.ArrayMap<android.view.View, androidx.fragment.app.Fragment> r3 = r4.tempViewToSupportFragment
            java.lang.Object r3 = r3.get(r2)
            r0 = r3
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            if (r0 == 0) goto L_0x002e
            goto L_0x003e
        L_0x002e:
            android.view.ViewParent r3 = r2.getParent()
            boolean r3 = r3 instanceof android.view.View
            if (r3 == 0) goto L_0x003e
            android.view.ViewParent r3 = r2.getParent()
            r2 = r3
            android.view.View r2 = (android.view.View) r2
            goto L_0x001c
        L_0x003e:
            androidx.collection.ArrayMap<android.view.View, androidx.fragment.app.Fragment> r3 = r4.tempViewToSupportFragment
            r3.clear()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.manager.RequestManagerRetriever.findSupportFragment(android.view.View, androidx.fragment.app.FragmentActivity):androidx.fragment.app.Fragment");
    }

    private static Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return findActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private static void assertNotDestroyed(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Deprecated
    public RequestManager get(android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            return get(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    private static boolean isActivityVisible(Context context) {
        Activity activity = findActivity(context);
        return activity == null || !activity.isFinishing();
    }

    @Deprecated
    public boolean handleMessage(Message message) {
        return false;
    }
}
