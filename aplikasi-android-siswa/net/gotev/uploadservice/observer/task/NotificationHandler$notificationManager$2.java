package net.gotev.uploadservice.observer.task;

import android.app.NotificationManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/NotificationManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NotificationHandler.kt */
final class NotificationHandler$notificationManager$2 extends Lambda implements Function0<NotificationManager> {
    final /* synthetic */ NotificationHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationHandler$notificationManager$2(NotificationHandler notificationHandler) {
        super(0);
        this.this$0 = notificationHandler;
    }

    public final NotificationManager invoke() {
        Object systemService = this.this$0.service.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }
}
