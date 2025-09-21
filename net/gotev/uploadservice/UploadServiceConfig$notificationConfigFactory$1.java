package net.gotev.uploadservice;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.view.PointerIconCompat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.data.UploadNotificationAction;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadNotificationStatusConfig;
import net.gotev.uploadservice.extensions.ContextExtensionsKt;
import net.gotev.uploadservice.placeholders.Placeholder;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "context", "Landroid/content/Context;", "uploadId", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadServiceConfig.kt */
final class UploadServiceConfig$notificationConfigFactory$1 extends Lambda implements Function2<Context, String, UploadNotificationConfig> {
    public static final UploadServiceConfig$notificationConfigFactory$1 INSTANCE = new UploadServiceConfig$notificationConfigFactory$1();

    UploadServiceConfig$notificationConfigFactory$1() {
        super(2);
    }

    public final UploadNotificationConfig invoke(Context context, String uploadId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uploadId, "uploadId");
        String defaultNotificationChannel = UploadServiceConfig.getDefaultNotificationChannel();
        Intrinsics.checkNotNull(defaultNotificationChannel);
        Placeholder placeholder = Placeholder.UploadRate;
        String str = "Upload";
        UploadNotificationStatusConfig uploadNotificationStatusConfig = new UploadNotificationStatusConfig(str, "Uploading at " + placeholder + " (" + Placeholder.Progress + ")", 0, 0, (Bitmap) null, (PendingIntent) null, CollectionsKt.arrayListOf(new UploadNotificationAction(17301560, "Cancel", ContextExtensionsKt.getCancelUploadIntent(context, uploadId))), false, false, (PendingIntent) null, 956, (DefaultConstructorMarker) null);
        String str2 = "Upload";
        return new UploadNotificationConfig(defaultNotificationChannel, true, uploadNotificationStatusConfig, new UploadNotificationStatusConfig(str2, "Upload completed successfully in " + Placeholder.ElapsedTime, 0, 0, (Bitmap) null, (PendingIntent) null, (ArrayList) null, false, false, (PendingIntent) null, PointerIconCompat.TYPE_GRAB, (DefaultConstructorMarker) null), new UploadNotificationStatusConfig(str2, "Error during upload", 0, 0, (Bitmap) null, (PendingIntent) null, (ArrayList) null, false, false, (PendingIntent) null, PointerIconCompat.TYPE_GRAB, (DefaultConstructorMarker) null), new UploadNotificationStatusConfig(str2, "Upload cancelled", 0, 0, (Bitmap) null, (PendingIntent) null, (ArrayList) null, false, false, (PendingIntent) null, PointerIconCompat.TYPE_GRAB, (DefaultConstructorMarker) null));
    }
}
