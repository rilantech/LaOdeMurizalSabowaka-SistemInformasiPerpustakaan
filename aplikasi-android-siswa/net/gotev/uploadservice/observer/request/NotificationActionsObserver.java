package net.gotev.uploadservice.observer.request;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.UploadService;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.extensions.ContextExtensionsKt;
import net.gotev.uploadservice.logger.UploadServiceLogger;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lnet/gotev/uploadservice/observer/request/NotificationActionsObserver;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onActionIntent", "", "intent", "Landroid/content/Intent;", "onReceive", "register", "unregister", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NotificationActionsObserver.kt */
public class NotificationActionsObserver extends BroadcastReceiver {
    private final Context context;

    public NotificationActionsObserver(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public void onReceive(Context context2, Intent intent) {
        if (Intrinsics.areEqual((Object) intent != null ? intent.getAction() : null, (Object) UploadServiceConfig.getBroadcastNotificationAction())) {
            onActionIntent(intent);
        }
    }

    public void onActionIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String it = ContextExtensionsKt.getUploadIdToCancel(intent);
        if (it != null) {
            String simpleName = NotificationActionsObserver.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "NotificationActionsObserver::class.java.simpleName");
            UploadServiceLogger.info(simpleName, it, NotificationActionsObserver$onActionIntent$1$1.INSTANCE);
            UploadService.Companion.stopUpload(it);
        }
    }

    public final void register() {
        ContextExtensionsKt.registerReceiverCompat(this.context, this, UploadServiceConfig.getBroadcastNotificationActionIntentFilter());
        String simpleName = NotificationActionsObserver.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "NotificationActionsObserver::class.java.simpleName");
        UploadServiceLogger.debug(simpleName, UploadServiceLogger.NA, NotificationActionsObserver$register$1.INSTANCE);
    }

    public final void unregister() {
        this.context.unregisterReceiver(this);
        String simpleName = NotificationActionsObserver.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "NotificationActionsObserver::class.java.simpleName");
        UploadServiceLogger.debug(simpleName, UploadServiceLogger.NA, NotificationActionsObserver$unregister$1.INSTANCE);
    }
}
