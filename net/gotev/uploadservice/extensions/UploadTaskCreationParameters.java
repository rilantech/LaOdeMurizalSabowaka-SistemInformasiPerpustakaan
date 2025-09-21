package net.gotev.uploadservice.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadTaskParameters;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lnet/gotev/uploadservice/extensions/UploadTaskCreationParameters;", "", "params", "Lnet/gotev/uploadservice/data/UploadTaskParameters;", "notificationConfig", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "(Lnet/gotev/uploadservice/data/UploadTaskParameters;Lnet/gotev/uploadservice/data/UploadNotificationConfig;)V", "getNotificationConfig", "()Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "getParams", "()Lnet/gotev/uploadservice/data/UploadTaskParameters;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextExtensions.kt */
public final class UploadTaskCreationParameters {
    private final UploadNotificationConfig notificationConfig;
    private final UploadTaskParameters params;

    public static /* synthetic */ UploadTaskCreationParameters copy$default(UploadTaskCreationParameters uploadTaskCreationParameters, UploadTaskParameters uploadTaskParameters, UploadNotificationConfig uploadNotificationConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            uploadTaskParameters = uploadTaskCreationParameters.params;
        }
        if ((i & 2) != 0) {
            uploadNotificationConfig = uploadTaskCreationParameters.notificationConfig;
        }
        return uploadTaskCreationParameters.copy(uploadTaskParameters, uploadNotificationConfig);
    }

    public final UploadTaskParameters component1() {
        return this.params;
    }

    public final UploadNotificationConfig component2() {
        return this.notificationConfig;
    }

    public final UploadTaskCreationParameters copy(UploadTaskParameters uploadTaskParameters, UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(uploadTaskParameters, "params");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        return new UploadTaskCreationParameters(uploadTaskParameters, uploadNotificationConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadTaskCreationParameters)) {
            return false;
        }
        UploadTaskCreationParameters uploadTaskCreationParameters = (UploadTaskCreationParameters) obj;
        return Intrinsics.areEqual((Object) this.params, (Object) uploadTaskCreationParameters.params) && Intrinsics.areEqual((Object) this.notificationConfig, (Object) uploadTaskCreationParameters.notificationConfig);
    }

    public int hashCode() {
        return (this.params.hashCode() * 31) + this.notificationConfig.hashCode();
    }

    public String toString() {
        UploadTaskParameters uploadTaskParameters = this.params;
        return "UploadTaskCreationParameters(params=" + uploadTaskParameters + ", notificationConfig=" + this.notificationConfig + ")";
    }

    public UploadTaskCreationParameters(UploadTaskParameters params2, UploadNotificationConfig notificationConfig2) {
        Intrinsics.checkNotNullParameter(params2, "params");
        Intrinsics.checkNotNullParameter(notificationConfig2, "notificationConfig");
        this.params = params2;
        this.notificationConfig = notificationConfig2;
    }

    public final UploadTaskParameters getParams() {
        return this.params;
    }

    public final UploadNotificationConfig getNotificationConfig() {
        return this.notificationConfig;
    }
}
