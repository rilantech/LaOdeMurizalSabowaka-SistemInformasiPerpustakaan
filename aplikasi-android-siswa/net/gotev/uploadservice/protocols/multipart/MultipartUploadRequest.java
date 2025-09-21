package net.gotev.uploadservice.protocols.multipart;

import android.content.Context;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.gotev.uploadservice.HttpUploadRequest;
import net.gotev.uploadservice.UploadTask;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.data.UploadTaskParameters;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0007R\u001c\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b8TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lnet/gotev/uploadservice/protocols/multipart/MultipartUploadRequest;", "Lnet/gotev/uploadservice/HttpUploadRequest;", "context", "Landroid/content/Context;", "serverUrl", "", "(Landroid/content/Context;Ljava/lang/String;)V", "taskClass", "Ljava/lang/Class;", "Lnet/gotev/uploadservice/UploadTask;", "getTaskClass", "()Ljava/lang/Class;", "addFileToUpload", "filePath", "parameterName", "fileName", "contentType", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultipartUploadRequest.kt */
public final class MultipartUploadRequest extends HttpUploadRequest<MultipartUploadRequest> {
    public final MultipartUploadRequest addFileToUpload(String str, String str2) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(str2, "parameterName");
        return addFileToUpload$default(this, str, str2, (String) null, (String) null, 12, (Object) null);
    }

    public final MultipartUploadRequest addFileToUpload(String str, String str2, String str3) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(str2, "parameterName");
        return addFileToUpload$default(this, str, str2, str3, (String) null, 8, (Object) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultipartUploadRequest(Context context, String serverUrl) {
        super(context, serverUrl);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serverUrl, UploadTaskParameters.Companion.CodingKeys.serverUrl);
    }

    /* access modifiers changed from: protected */
    public Class<? extends UploadTask> getTaskClass() {
        return MultipartUploadTask.class;
    }

    public static /* synthetic */ MultipartUploadRequest addFileToUpload$default(MultipartUploadRequest multipartUploadRequest, String str, String str2, String str3, String str4, int i, Object obj) throws FileNotFoundException {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        return multipartUploadRequest.addFileToUpload(str, str2, str3, str4);
    }

    public final MultipartUploadRequest addFileToUpload(String filePath, String parameterName, String fileName, String contentType) throws FileNotFoundException {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(parameterName, "parameterName");
        boolean z = true;
        if ((StringsKt.isBlank(filePath) ^ true) && (StringsKt.isBlank(parameterName) ^ true)) {
            ArrayList<UploadFile> files = getFiles();
            UploadFile uploadFile = new UploadFile(filePath, (LinkedHashMap) null, 2, (DefaultConstructorMarker) null);
            UploadFile $this$addFileToUpload_u24lambda_u241 = uploadFile;
            UploadFileExtensionsKt.setParameterName($this$addFileToUpload_u24lambda_u241, parameterName);
            CharSequence charSequence = contentType;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                str = $this$addFileToUpload_u24lambda_u241.getHandler().contentType(getContext());
            } else {
                str = contentType;
            }
            UploadFileExtensionsKt.setContentType($this$addFileToUpload_u24lambda_u241, str);
            CharSequence charSequence2 = fileName;
            if (charSequence2 != null && !StringsKt.isBlank(charSequence2)) {
                z = false;
            }
            if (z) {
                str2 = $this$addFileToUpload_u24lambda_u241.getHandler().name(getContext());
            } else {
                str2 = fileName;
            }
            UploadFileExtensionsKt.setRemoteFileName($this$addFileToUpload_u24lambda_u241, str2);
            files.add(uploadFile);
            return this;
        }
        throw new IllegalArgumentException("Please specify valid filePath and parameterName. They cannot be blank.".toString());
    }
}
