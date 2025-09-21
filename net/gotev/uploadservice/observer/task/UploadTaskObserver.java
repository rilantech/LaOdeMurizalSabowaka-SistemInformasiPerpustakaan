package net.gotev.uploadservice.observer.task;

import kotlin.Metadata;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.network.ServerResponse;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "", "onCompleted", "", "info", "Lnet/gotev/uploadservice/data/UploadInfo;", "notificationId", "", "notificationConfig", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "onError", "exception", "", "onProgress", "onStart", "onSuccess", "response", "Lnet/gotev/uploadservice/network/ServerResponse;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadTaskObserver.kt */
public interface UploadTaskObserver {
    void onCompleted(UploadInfo uploadInfo, int i, UploadNotificationConfig uploadNotificationConfig);

    void onError(UploadInfo uploadInfo, int i, UploadNotificationConfig uploadNotificationConfig, Throwable th);

    void onProgress(UploadInfo uploadInfo, int i, UploadNotificationConfig uploadNotificationConfig);

    void onStart(UploadInfo uploadInfo, int i, UploadNotificationConfig uploadNotificationConfig);

    void onSuccess(UploadInfo uploadInfo, int i, UploadNotificationConfig uploadNotificationConfig, ServerResponse serverResponse);
}
