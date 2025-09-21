package net.gotev.uploadservice.observer.request;

import android.content.Context;
import kotlin.Metadata;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.network.ServerResponse;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;", "", "onCompleted", "", "context", "Landroid/content/Context;", "uploadInfo", "Lnet/gotev/uploadservice/data/UploadInfo;", "onCompletedWhileNotObserving", "onError", "exception", "", "onProgress", "onSuccess", "serverResponse", "Lnet/gotev/uploadservice/network/ServerResponse;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RequestObserverDelegate.kt */
public interface RequestObserverDelegate {
    void onCompleted(Context context, UploadInfo uploadInfo);

    void onCompletedWhileNotObserving();

    void onError(Context context, UploadInfo uploadInfo, Throwable th);

    void onProgress(Context context, UploadInfo uploadInfo);

    void onSuccess(Context context, UploadInfo uploadInfo, ServerResponse serverResponse);
}
