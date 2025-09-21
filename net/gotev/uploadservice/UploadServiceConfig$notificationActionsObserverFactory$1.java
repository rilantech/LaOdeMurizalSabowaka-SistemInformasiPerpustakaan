package net.gotev.uploadservice;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.observer.request.NotificationActionsObserver;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lnet/gotev/uploadservice/observer/request/NotificationActionsObserver;", "it", "Lnet/gotev/uploadservice/UploadService;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadServiceConfig.kt */
final class UploadServiceConfig$notificationActionsObserverFactory$1 extends Lambda implements Function1<UploadService, NotificationActionsObserver> {
    public static final UploadServiceConfig$notificationActionsObserverFactory$1 INSTANCE = new UploadServiceConfig$notificationActionsObserverFactory$1();

    UploadServiceConfig$notificationActionsObserverFactory$1() {
        super(1);
    }

    public final NotificationActionsObserver invoke(UploadService it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new NotificationActionsObserver(it);
    }
}
