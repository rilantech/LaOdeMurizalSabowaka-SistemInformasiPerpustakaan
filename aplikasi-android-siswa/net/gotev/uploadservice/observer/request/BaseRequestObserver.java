package net.gotev.uploadservice.observer.request;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.data.BroadcastData;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.data.UploadStatus;
import net.gotev.uploadservice.extensions.ContextExtensionsKt;
import net.gotev.uploadservice.network.ServerResponse;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\rJ\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR5\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lnet/gotev/uploadservice/observer/request/BaseRequestObserver;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "delegate", "Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;", "shouldAcceptEventsFrom", "Lkotlin/Function1;", "Lnet/gotev/uploadservice/data/UploadInfo;", "Lkotlin/ParameterName;", "name", "uploadInfo", "", "(Landroid/content/Context;Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;Lkotlin/jvm/functions/Function1;)V", "getDelegate$uploadservice_release", "()Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;", "getShouldAcceptEventsFrom$uploadservice_release", "()Lkotlin/jvm/functions/Function1;", "setShouldAcceptEventsFrom$uploadservice_release", "(Lkotlin/jvm/functions/Function1;)V", "onReceive", "", "intent", "Landroid/content/Intent;", "register", "unregister", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BaseRequestObserver.kt */
public class BaseRequestObserver extends BroadcastReceiver {
    private final Context context;
    private final RequestObserverDelegate delegate;
    private Function1<? super UploadInfo, Boolean> shouldAcceptEventsFrom;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BaseRequestObserver.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UploadStatus.values().length];
            try {
                iArr[UploadStatus.InProgress.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[UploadStatus.Error.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[UploadStatus.Success.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[UploadStatus.Completed.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final RequestObserverDelegate getDelegate$uploadservice_release() {
        return this.delegate;
    }

    public final Function1<UploadInfo, Boolean> getShouldAcceptEventsFrom$uploadservice_release() {
        return this.shouldAcceptEventsFrom;
    }

    public final void setShouldAcceptEventsFrom$uploadservice_release(Function1<? super UploadInfo, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.shouldAcceptEventsFrom = function1;
    }

    public BaseRequestObserver(Context context2, RequestObserverDelegate delegate2, Function1<? super UploadInfo, Boolean> shouldAcceptEventsFrom2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(delegate2, "delegate");
        Intrinsics.checkNotNullParameter(shouldAcceptEventsFrom2, "shouldAcceptEventsFrom");
        this.context = context2;
        this.delegate = delegate2;
        this.shouldAcceptEventsFrom = shouldAcceptEventsFrom2;
    }

    public void onReceive(Context context2, Intent intent) {
        BroadcastData data;
        Intrinsics.checkNotNullParameter(context2, "context");
        if (intent != null) {
            Intent safeIntent = intent;
            if (Intrinsics.areEqual((Object) safeIntent.getAction(), (Object) UploadServiceConfig.getBroadcastStatusAction()) && (data = BroadcastData.Companion.fromIntent(safeIntent)) != null) {
                UploadInfo uploadInfo = data.getUploadInfo();
                if (this.shouldAcceptEventsFrom.invoke(uploadInfo).booleanValue()) {
                    switch (WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()]) {
                        case 1:
                            this.delegate.onProgress(context2, uploadInfo);
                            return;
                        case 2:
                            RequestObserverDelegate requestObserverDelegate = this.delegate;
                            Throwable exception = data.getException();
                            Intrinsics.checkNotNull(exception);
                            requestObserverDelegate.onError(context2, uploadInfo, exception);
                            return;
                        case 3:
                            RequestObserverDelegate requestObserverDelegate2 = this.delegate;
                            ServerResponse serverResponse = data.getServerResponse();
                            Intrinsics.checkNotNull(serverResponse);
                            requestObserverDelegate2.onSuccess(context2, uploadInfo, serverResponse);
                            return;
                        case 4:
                            this.delegate.onCompleted(context2, uploadInfo);
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    public void register() {
        ContextExtensionsKt.registerReceiverCompat(this.context, this, UploadServiceConfig.getBroadcastStatusIntentFilter());
    }

    public void unregister() {
        this.context.unregisterReceiver(this);
    }
}
