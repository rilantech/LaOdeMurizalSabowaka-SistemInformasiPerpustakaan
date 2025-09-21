package net.gotev.uploadservice.logger;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.logger.UploadServiceLogger;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J*\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lnet/gotev/uploadservice/logger/DefaultLoggerDelegate;", "Lnet/gotev/uploadservice/logger/UploadServiceLogger$Delegate;", "()V", "debug", "", "component", "", "uploadId", "message", "error", "exception", "", "info", "Companion", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultLoggerDelegate.kt */
public final class DefaultLoggerDelegate implements UploadServiceLogger.Delegate {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "UploadService";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lnet/gotev/uploadservice/logger/DefaultLoggerDelegate$Companion;", "", "()V", "TAG", "", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultLoggerDelegate.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void error(String component, String uploadId, String message, Throwable exception) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(uploadId, "uploadId");
        Intrinsics.checkNotNullParameter(message, "message");
        Log.e(TAG, component + " - (uploadId: " + uploadId + ") - " + message, exception);
    }

    public void debug(String component, String uploadId, String message) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(uploadId, "uploadId");
        Intrinsics.checkNotNullParameter(message, "message");
        Log.i(TAG, component + " - (uploadId: " + uploadId + ") - " + message);
    }

    public void info(String component, String uploadId, String message) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(uploadId, "uploadId");
        Intrinsics.checkNotNullParameter(message, "message");
        Log.i(TAG, component + " - (uploadId: " + uploadId + ") - " + message);
    }
}
