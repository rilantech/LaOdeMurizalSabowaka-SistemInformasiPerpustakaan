package net.gotev.uploadservice.extensions;

import android.app.NotificationManager;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"validateNotificationChannel", "", "Landroid/app/NotificationManager;", "channelID", "", "uploadservice_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NotificationManagerExtensions.kt */
public final class NotificationManagerExtensionsKt {
    public static final void validateNotificationChannel(NotificationManager $this$validateNotificationChannel, String channelID) {
        Intrinsics.checkNotNullParameter($this$validateNotificationChannel, "<this>");
        Intrinsics.checkNotNullParameter(channelID, "channelID");
        if (Build.VERSION.SDK_INT >= 26 && $this$validateNotificationChannel.getNotificationChannel(channelID) == null) {
            throw new IllegalArgumentException("The provided notification channel ID " + channelID + " does not exist! You must create it at app startup and before Upload Service!");
        }
    }
}
