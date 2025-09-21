package net.gotev.uploadservice.observer.task;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.media.RingtoneManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.UploadService;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.data.UploadNotificationAction;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadNotificationStatusConfig;
import net.gotev.uploadservice.exceptions.UserCancelledUploadException;
import net.gotev.uploadservice.extensions.NotificationManagerExtensionsKt;
import net.gotev.uploadservice.network.ServerResponse;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J(\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J(\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J0\u0010\"\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0014\u0010)\u001a\u00020!*\u00020!2\u0006\u0010*\u001a\u00020(H\u0002J\u001c\u0010+\u001a\u00020\u0011*\u00020!2\u0006\u0010,\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010-\u001a\u00020!*\u00020!2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0016\u0010.\u001a\u00020!*\u00020!2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0014\u00101\u001a\u00020!*\u00020!2\u0006\u0010%\u001a\u00020&H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lnet/gotev/uploadservice/observer/task/NotificationHandler;", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "service", "Lnet/gotev/uploadservice/UploadService;", "(Lnet/gotev/uploadservice/UploadService;)V", "notificationCreationTimeMillis", "", "getNotificationCreationTimeMillis", "()J", "notificationCreationTimeMillis$delegate", "Lkotlin/Lazy;", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "notificationManager$delegate", "onCompleted", "", "info", "Lnet/gotev/uploadservice/data/UploadInfo;", "notificationId", "", "notificationConfig", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "onError", "exception", "", "onProgress", "onStart", "onSuccess", "response", "Lnet/gotev/uploadservice/network/ServerResponse;", "ongoingNotification", "Landroidx/core/app/NotificationCompat$Builder;", "updateNotification", "notificationChannelId", "", "isRingToneEnabled", "", "statusConfig", "Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "addActions", "config", "notify", "uploadId", "setCommonParameters", "setDeleteIntentIfPresent", "intent", "Landroid/app/PendingIntent;", "setRingtoneCompat", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NotificationHandler.kt */
public final class NotificationHandler implements UploadTaskObserver {
    private final Lazy notificationCreationTimeMillis$delegate = LazyKt.lazy(NotificationHandler$notificationCreationTimeMillis$2.INSTANCE);
    private final Lazy notificationManager$delegate = LazyKt.lazy(new NotificationHandler$notificationManager$2(this));
    /* access modifiers changed from: private */
    public final UploadService service;

    public NotificationHandler(UploadService service2) {
        Intrinsics.checkNotNullParameter(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    private final long getNotificationCreationTimeMillis() {
        return ((Number) this.notificationCreationTimeMillis$delegate.getValue()).longValue();
    }

    private final NotificationManager getNotificationManager() {
        return (NotificationManager) this.notificationManager$delegate.getValue();
    }

    private final NotificationCompat.Builder addActions(NotificationCompat.Builder $this$addActions, UploadNotificationStatusConfig config) {
        for (UploadNotificationAction it : config.getActions()) {
            $this$addActions.addAction(it.asAction());
        }
        return $this$addActions;
    }

    private final NotificationCompat.Builder setRingtoneCompat(NotificationCompat.Builder $this$setRingtoneCompat, boolean isRingToneEnabled) {
        if (isRingToneEnabled && Build.VERSION.SDK_INT < 26) {
            $this$setRingtoneCompat.setSound(RingtoneManager.getActualDefaultRingtoneUri(this.service, 2));
        }
        return $this$setRingtoneCompat;
    }

    private final void notify(NotificationCompat.Builder $this$notify, String uploadId, int notificationId) {
        Notification $this$notify_u24lambda_u241 = $this$notify.build();
        UploadService uploadService = this.service;
        Intrinsics.checkNotNullExpressionValue($this$notify_u24lambda_u241, "this");
        if (uploadService.holdForegroundNotification(uploadId, $this$notify_u24lambda_u241)) {
            getNotificationManager().cancel(notificationId);
        } else {
            getNotificationManager().notify(notificationId, $this$notify_u24lambda_u241);
        }
    }

    private final NotificationCompat.Builder setCommonParameters(NotificationCompat.Builder $this$setCommonParameters, UploadNotificationStatusConfig statusConfig, UploadInfo info) {
        NotificationCompat.Builder color = $this$setCommonParameters.setGroup(UploadServiceConfig.getNamespace()).setContentTitle(UploadServiceConfig.getPlaceholdersProcessor().processPlaceholders(statusConfig.getTitle(), info)).setContentText(UploadServiceConfig.getPlaceholdersProcessor().processPlaceholders(statusConfig.getMessage(), info)).setContentIntent(statusConfig.getClickIntent(this.service)).setSmallIcon(statusConfig.getIconResourceID()).setLargeIcon(statusConfig.getLargeIcon()).setColor(statusConfig.getIconColorResourceID());
        Intrinsics.checkNotNullExpressionValue(color, "setGroup(namespace)\n    …nfig.iconColorResourceID)");
        return addActions(color, statusConfig);
    }

    private final NotificationCompat.Builder ongoingNotification(UploadNotificationConfig notificationConfig, UploadInfo info) {
        NotificationCompat.Builder when = new NotificationCompat.Builder((Context) this.service, notificationConfig.getNotificationChannelId()).setWhen(getNotificationCreationTimeMillis());
        Intrinsics.checkNotNullExpressionValue(when, "Builder(service, notific…cationCreationTimeMillis)");
        NotificationCompat.Builder ongoing = setCommonParameters(when, notificationConfig.getProgress(), info).setOngoing(true);
        Intrinsics.checkNotNullExpressionValue(ongoing, "Builder(service, notific…        .setOngoing(true)");
        return ongoing;
    }

    private final NotificationCompat.Builder setDeleteIntentIfPresent(NotificationCompat.Builder $this$setDeleteIntentIfPresent, PendingIntent intent) {
        NotificationCompat.Builder deleteIntent = intent != null ? $this$setDeleteIntentIfPresent.setDeleteIntent(intent) : null;
        return deleteIntent == null ? $this$setDeleteIntentIfPresent : deleteIntent;
    }

    private final void updateNotification(int notificationId, UploadInfo info, String notificationChannelId, boolean isRingToneEnabled, UploadNotificationStatusConfig statusConfig) {
        getNotificationManager().cancel(notificationId);
        if (!statusConfig.getAutoClear()) {
            NotificationCompat.Builder ongoing = setCommonParameters(new NotificationCompat.Builder((Context) this.service, notificationChannelId), statusConfig, info).setProgress(0, 0, false).setOngoing(false);
            Intrinsics.checkNotNullExpressionValue(ongoing, "Builder(service, notific…       .setOngoing(false)");
            NotificationCompat.Builder autoCancel = setDeleteIntentIfPresent(ongoing, statusConfig.getOnDismissed()).setAutoCancel(statusConfig.getClearOnAction());
            Intrinsics.checkNotNullExpressionValue(autoCancel, "Builder(service, notific…atusConfig.clearOnAction)");
            Notification notification = setRingtoneCompat(autoCancel, isRingToneEnabled).build();
            Intrinsics.checkNotNullExpressionValue(notification, "Builder(service, notific…led)\n            .build()");
            getNotificationManager().notify(notificationId + 1, notification);
        }
    }

    public void onStart(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
        NotificationManagerExtensionsKt.validateNotificationChannel(getNotificationManager(), notificationConfig.getNotificationChannelId());
        NotificationCompat.Builder progress = ongoingNotification(notificationConfig, info).setProgress(100, 0, true);
        Intrinsics.checkNotNullExpressionValue(progress, "ongoingNotification(noti…setProgress(100, 0, true)");
        notify(progress, info.getUploadId(), notificationId);
    }

    public void onProgress(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
        NotificationCompat.Builder progress = ongoingNotification(notificationConfig, info).setProgress(100, info.getProgressPercent(), false);
        Intrinsics.checkNotNullExpressionValue(progress, "ongoingNotification(noti…o.progressPercent, false)");
        notify(progress, info.getUploadId(), notificationId);
    }

    public void onSuccess(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig, ServerResponse response) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
        Intrinsics.checkNotNullParameter(response, "response");
        updateNotification(notificationId, info, notificationConfig.getNotificationChannelId(), notificationConfig.isRingToneEnabled(), notificationConfig.getSuccess());
    }

    public void onError(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig, Throwable exception) {
        UploadNotificationStatusConfig statusConfig;
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (exception instanceof UserCancelledUploadException) {
            statusConfig = notificationConfig.getCancelled();
        } else {
            statusConfig = notificationConfig.getError();
        }
        updateNotification(notificationId, info, notificationConfig.getNotificationChannelId(), notificationConfig.isRingToneEnabled(), statusConfig);
    }

    public void onCompleted(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
    }
}
