package net.gotev.uploadservice.protocols.binary;

import android.content.Context;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.HttpUploadRequest;
import net.gotev.uploadservice.UploadTask;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.data.UploadTaskParameters;
import net.gotev.uploadservice.logger.UploadServiceLogger;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00052\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000f\"\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0010J\u001e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0005J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u001c\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b8TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lnet/gotev/uploadservice/protocols/binary/BinaryUploadRequest;", "Lnet/gotev/uploadservice/HttpUploadRequest;", "context", "Landroid/content/Context;", "serverUrl", "", "(Landroid/content/Context;Ljava/lang/String;)V", "taskClass", "Ljava/lang/Class;", "Lnet/gotev/uploadservice/UploadTask;", "getTaskClass", "()Ljava/lang/Class;", "addArrayParameter", "paramName", "array", "", "(Ljava/lang/String;[Ljava/lang/String;)Lnet/gotev/uploadservice/protocols/binary/BinaryUploadRequest;", "list", "", "addParameter", "paramValue", "logDoesNotSupportParameters", "", "setFileToUpload", "path", "startUpload", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BinaryUploadRequest.kt */
public final class BinaryUploadRequest extends HttpUploadRequest<BinaryUploadRequest> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BinaryUploadRequest(Context context, String serverUrl) {
        super(context, serverUrl);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serverUrl, UploadTaskParameters.Companion.CodingKeys.serverUrl);
    }

    /* access modifiers changed from: protected */
    public Class<? extends UploadTask> getTaskClass() {
        return BinaryUploadTask.class;
    }

    public final BinaryUploadRequest setFileToUpload(String path) throws IOException {
        Intrinsics.checkNotNullParameter(path, UploadFile.Companion.CodingKeys.path);
        getFiles().clear();
        getFiles().add(new UploadFile(path, (LinkedHashMap) null, 2, (DefaultConstructorMarker) null));
        return this;
    }

    public BinaryUploadRequest addParameter(String paramName, String paramValue) {
        Intrinsics.checkNotNullParameter(paramName, "paramName");
        Intrinsics.checkNotNullParameter(paramValue, "paramValue");
        logDoesNotSupportParameters();
        return this;
    }

    public BinaryUploadRequest addArrayParameter(String paramName, String... array) {
        Intrinsics.checkNotNullParameter(paramName, "paramName");
        Intrinsics.checkNotNullParameter(array, "array");
        logDoesNotSupportParameters();
        return this;
    }

    public BinaryUploadRequest addArrayParameter(String paramName, List<String> list) {
        Intrinsics.checkNotNullParameter(paramName, "paramName");
        Intrinsics.checkNotNullParameter(list, "list");
        logDoesNotSupportParameters();
        return this;
    }

    public String startUpload() {
        if (!getFiles().isEmpty()) {
            return super.startUpload();
        }
        throw new IllegalArgumentException("Set the file to be used in the request body first!".toString());
    }

    private final void logDoesNotSupportParameters() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        UploadServiceLogger.error$default(simpleName, UploadServiceLogger.NA, (Throwable) null, BinaryUploadRequest$logDoesNotSupportParameters$1.INSTANCE, 4, (Object) null);
    }
}
