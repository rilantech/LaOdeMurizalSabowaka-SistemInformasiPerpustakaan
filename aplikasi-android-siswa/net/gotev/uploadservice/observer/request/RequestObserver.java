package net.gotev.uploadservice.observer.request;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.UploadRequest;
import net.gotev.uploadservice.UploadService;
import net.gotev.uploadservice.data.UploadInfo;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BD\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012#\b\u0002\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0002\u0010\u0010J\b\u0010\u0013\u001a\u00020\u0014H\u0017J\u0012\u0010\u0015\u001a\u00020\u00142\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017J\b\u0010\u0018\u001a\u00020\u0014H\u0017R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lnet/gotev/uploadservice/observer/request/RequestObserver;", "Lnet/gotev/uploadservice/observer/request/BaseRequestObserver;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "delegate", "Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;", "shouldAcceptEventsFrom", "Lkotlin/Function1;", "Lnet/gotev/uploadservice/data/UploadInfo;", "Lkotlin/ParameterName;", "name", "uploadInfo", "", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;Lkotlin/jvm/functions/Function1;)V", "subscribedUploadID", "", "register", "", "subscribe", "request", "Lnet/gotev/uploadservice/UploadRequest;", "unregister", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RequestObserver.kt */
public final class RequestObserver extends BaseRequestObserver implements LifecycleObserver {
    /* access modifiers changed from: private */
    public String subscribedUploadID;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RequestObserver(Context context, LifecycleOwner lifecycleOwner, RequestObserverDelegate requestObserverDelegate) {
        this(context, lifecycleOwner, requestObserverDelegate, (Function1) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(requestObserverDelegate, "delegate");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RequestObserver(Context context, LifecycleOwner lifecycleOwner, RequestObserverDelegate requestObserverDelegate, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, lifecycleOwner, requestObserverDelegate, (i & 8) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RequestObserver(Context context, LifecycleOwner lifecycleOwner, RequestObserverDelegate delegate, Function1<? super UploadInfo, Boolean> shouldAcceptEventsFrom) {
        super(context, delegate, shouldAcceptEventsFrom);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(shouldAcceptEventsFrom, "shouldAcceptEventsFrom");
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void register() {
        super.register();
        String it = this.subscribedUploadID;
        if (it != null && !UploadService.Companion.getTaskList().contains(it)) {
            getDelegate$uploadservice_release().onCompletedWhileNotObserving();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void unregister() {
        super.unregister();
    }

    public final void subscribe(UploadRequest<?> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.subscribedUploadID = request.startUpload();
        setShouldAcceptEventsFrom$uploadservice_release(new RequestObserver$subscribe$1(this));
    }
}
