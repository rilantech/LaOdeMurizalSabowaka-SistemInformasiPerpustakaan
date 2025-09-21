package net.gotev.uploadservice.protocols.multipart;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.extensions.CollectionsExtensionsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\",\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00018@@@X\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\",\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00018@@@X\u000e¢\u0006\f\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n\",\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00018@@@X\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"PROPERTY_CONTENT_TYPE", "", "PROPERTY_PARAM_NAME", "PROPERTY_REMOTE_FILE_NAME", "value", "contentType", "Lnet/gotev/uploadservice/data/UploadFile;", "getContentType", "(Lnet/gotev/uploadservice/data/UploadFile;)Ljava/lang/String;", "setContentType", "(Lnet/gotev/uploadservice/data/UploadFile;Ljava/lang/String;)V", "parameterName", "getParameterName", "setParameterName", "remoteFileName", "getRemoteFileName", "setRemoteFileName", "uploadservice_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadFileExtensions.kt */
public final class UploadFileExtensionsKt {
    private static final String PROPERTY_CONTENT_TYPE = "multipartContentType";
    private static final String PROPERTY_PARAM_NAME = "multipartParamName";
    private static final String PROPERTY_REMOTE_FILE_NAME = "multipartRemoteFileName";

    public static final String getParameterName(UploadFile $this$parameterName) {
        Intrinsics.checkNotNullParameter($this$parameterName, "<this>");
        return $this$parameterName.getProperties().get(PROPERTY_PARAM_NAME);
    }

    public static final void setParameterName(UploadFile $this$parameterName, String value) {
        Intrinsics.checkNotNullParameter($this$parameterName, "<this>");
        CollectionsExtensionsKt.setOrRemove($this$parameterName.getProperties(), PROPERTY_PARAM_NAME, value);
    }

    public static final String getRemoteFileName(UploadFile $this$remoteFileName) {
        Intrinsics.checkNotNullParameter($this$remoteFileName, "<this>");
        return $this$remoteFileName.getProperties().get(PROPERTY_REMOTE_FILE_NAME);
    }

    public static final void setRemoteFileName(UploadFile $this$remoteFileName, String value) {
        Intrinsics.checkNotNullParameter($this$remoteFileName, "<this>");
        CollectionsExtensionsKt.setOrRemove($this$remoteFileName.getProperties(), PROPERTY_REMOTE_FILE_NAME, value);
    }

    public static final String getContentType(UploadFile $this$contentType) {
        Intrinsics.checkNotNullParameter($this$contentType, "<this>");
        return $this$contentType.getProperties().get(PROPERTY_CONTENT_TYPE);
    }

    public static final void setContentType(UploadFile $this$contentType, String value) {
        Intrinsics.checkNotNullParameter($this$contentType, "<this>");
        CollectionsExtensionsKt.setOrRemove($this$contentType.getProperties(), PROPERTY_CONTENT_TYPE, value);
    }
}
