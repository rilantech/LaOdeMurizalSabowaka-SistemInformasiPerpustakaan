package net.gotev.uploadservice;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.observer.request.NotificationActionsObserver;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lnet/gotev/uploadservice/observer/request/NotificationActionsObserver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadService.kt */
final class UploadService$notificationActionsObserver$2 extends Lambda implements Function0<NotificationActionsObserver> {
    final /* synthetic */ UploadService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UploadService$notificationActionsObserver$2(UploadService uploadService) {
        super(0);
        this.this$0 = uploadService;
    }

    public final NotificationActionsObserver invoke() {
        return UploadServiceConfig.getNotificationActionsObserverFactory().invoke(this.this$0);
    }
}
