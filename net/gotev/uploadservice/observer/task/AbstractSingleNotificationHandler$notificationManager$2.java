package net.gotev.uploadservice.observer.task;

import android.app.NotificationManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/NotificationManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AbstractSingleNotificationHandler.kt */
final class AbstractSingleNotificationHandler$notificationManager$2 extends Lambda implements Function0<NotificationManager> {
    final /* synthetic */ AbstractSingleNotificationHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractSingleNotificationHandler$notificationManager$2(AbstractSingleNotificationHandler abstractSingleNotificationHandler) {
        super(0);
        this.this$0 = abstractSingleNotificationHandler;
    }

    public final NotificationManager invoke() {
        Object systemService = this.this$0.service.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }
}
