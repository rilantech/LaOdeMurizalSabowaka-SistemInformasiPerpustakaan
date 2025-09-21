package net.gotev.uploadservice.observer.task;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.UploadService;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.network.ServerResponse;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lnet/gotev/uploadservice/observer/task/TaskCompletionNotifier;", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "service", "Lnet/gotev/uploadservice/UploadService;", "(Lnet/gotev/uploadservice/UploadService;)V", "onCompleted", "", "info", "Lnet/gotev/uploadservice/data/UploadInfo;", "notificationId", "", "notificationConfig", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "onError", "exception", "", "onProgress", "onStart", "onSuccess", "response", "Lnet/gotev/uploadservice/network/ServerResponse;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TaskCompletionNotifier.kt */
public final class TaskCompletionNotifier implements UploadTaskObserver {
    private final UploadService service;

    public TaskCompletionNotifier(UploadService service2) {
        Intrinsics.checkNotNullParameter(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    public void onStart(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
    }

    public void onProgress(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
    }

    public void onSuccess(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig, ServerResponse response) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public void onError(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig, Throwable exception) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
        Intrinsics.checkNotNullParameter(exception, "exception");
    }

    public void onCompleted(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
        this.service.taskCompleted(info.getUploadId());
    }
}
