package net.gotev.uploadservice.protocols.multipart;

import com.android.volley.toolbox.HttpHeaderParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.HttpUploadTask;
import net.gotev.uploadservice.data.NameValue;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.extensions.CollectionsExtensionsKt;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
import net.gotev.uploadservice.network.BodyWriter;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\f\u0010\u001f\u001a\u00020\u001b*\u00020\u001dH\u0002J\f\u0010 \u001a\u00020\u001b*\u00020\u001dH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u000e\u0010\u0010\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\u00020\n*\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0011\u001a\u00020\n*\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0016R\u0018\u0010\u0017\u001a\u00020\u0004*\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lnet/gotev/uploadservice/protocols/multipart/MultipartUploadTask;", "Lnet/gotev/uploadservice/HttpUploadTask;", "()V", "bodyLength", "", "getBodyLength", "()J", "boundary", "", "boundaryBytes", "", "filesLength", "getFilesLength", "newLineBytes", "requestParametersLength", "getRequestParametersLength", "trailerBytes", "multipartHeader", "Lnet/gotev/uploadservice/data/NameValue;", "getMultipartHeader", "(Lnet/gotev/uploadservice/data/NameValue;)[B", "Lnet/gotev/uploadservice/data/UploadFile;", "(Lnet/gotev/uploadservice/data/UploadFile;)[B", "totalMultipartBytes", "getTotalMultipartBytes", "(Lnet/gotev/uploadservice/data/UploadFile;)J", "onWriteRequestBody", "", "bodyWriter", "Lnet/gotev/uploadservice/network/BodyWriter;", "performInitialization", "writeFiles", "writeRequestParameters", "Companion", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultipartUploadTask.kt */
public final class MultipartUploadTask extends HttpUploadTask {
    private static final String BOUNDARY_SIGNATURE = "-------UploadService4.9.2-";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String NEW_LINE = "\r\n";
    private static final String TWO_HYPHENS = "--";
    private final String boundary;
    private final byte[] boundaryBytes;
    private final byte[] newLineBytes = StringExtensionsKt.getUtf8Bytes(NEW_LINE);
    private final byte[] trailerBytes;

    public MultipartUploadTask() {
        String str = BOUNDARY_SIGNATURE + System.nanoTime();
        this.boundary = str;
        this.boundaryBytes = StringExtensionsKt.getAsciiBytes(TWO_HYPHENS + str + NEW_LINE);
        this.trailerBytes = StringExtensionsKt.getAsciiBytes(TWO_HYPHENS + str + "--\r\n");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lnet/gotev/uploadservice/protocols/multipart/MultipartUploadTask$Companion;", "", "()V", "BOUNDARY_SIGNATURE", "", "NEW_LINE", "TWO_HYPHENS", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MultipartUploadTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final byte[] getMultipartHeader(NameValue $this$multipartHeader) {
        byte[] bArr = this.boundaryBytes;
        String name = $this$multipartHeader.getName();
        return ArraysKt.plus(bArr, StringExtensionsKt.getUtf8Bytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n\r\n" + $this$multipartHeader.getValue() + NEW_LINE));
    }

    private final byte[] getMultipartHeader(UploadFile $this$multipartHeader) {
        byte[] bArr = this.boundaryBytes;
        String parameterName = UploadFileExtensionsKt.getParameterName($this$multipartHeader);
        String remoteFileName = UploadFileExtensionsKt.getRemoteFileName($this$multipartHeader);
        return ArraysKt.plus(bArr, StringExtensionsKt.getUtf8Bytes("Content-Disposition: form-data; name=\"" + parameterName + "\"; filename=\"" + remoteFileName + "\"\r\nContent-Type: " + UploadFileExtensionsKt.getContentType($this$multipartHeader) + "\r\n\r\n"));
    }

    private final long getTotalMultipartBytes(UploadFile $this$totalMultipartBytes) {
        return ((long) getMultipartHeader($this$totalMultipartBytes).length) + $this$totalMultipartBytes.getHandler().size(getContext()) + ((long) this.newLineBytes.length);
    }

    private final void writeRequestParameters(BodyWriter $this$writeRequestParameters) {
        for (NameValue it : getHttpParams().getRequestParameters()) {
            $this$writeRequestParameters.write(getMultipartHeader(it));
        }
    }

    private final void writeFiles(BodyWriter $this$writeFiles) {
        Iterator<UploadFile> it = getParams().getFiles().iterator();
        while (it.hasNext()) {
            UploadFile file = it.next();
            if (getShouldContinue()) {
                Intrinsics.checkNotNullExpressionValue(file, "file");
                $this$writeFiles.write(getMultipartHeader(file));
                $this$writeFiles.writeStream(file.getHandler().stream(getContext()));
                $this$writeFiles.write(this.newLineBytes);
            } else {
                return;
            }
        }
    }

    private final long getRequestParametersLength() {
        Iterable<NameValue> $this$map$iv = getHttpParams().getRequestParameters();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (NameValue it : $this$map$iv) {
            destination$iv$iv.add(Long.valueOf((long) getMultipartHeader(it).length));
        }
        return CollectionsKt.sumOfLong((List) destination$iv$iv);
    }

    private final long getFilesLength() {
        Iterable<UploadFile> $this$map$iv = getParams().getFiles();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (UploadFile it : $this$map$iv) {
            destination$iv$iv.add(Long.valueOf(getTotalMultipartBytes(it)));
        }
        return CollectionsKt.sumOfLong((List) destination$iv$iv);
    }

    public long getBodyLength() {
        return getRequestParametersLength() + getFilesLength() + ((long) this.trailerBytes.length);
    }

    public void performInitialization() {
        ArrayList $this$performInitialization_u24lambda_u243 = getHttpParams().getRequestHeaders();
        CollectionsExtensionsKt.addHeader($this$performInitialization_u24lambda_u243, HttpHeaderParser.HEADER_CONTENT_TYPE, "multipart/form-data; boundary=" + this.boundary);
        CollectionsExtensionsKt.addHeader($this$performInitialization_u24lambda_u243, "Connection", getParams().getFiles().size() <= 1 ? "close" : "Keep-Alive");
    }

    public void onWriteRequestBody(BodyWriter bodyWriter) {
        Intrinsics.checkNotNullParameter(bodyWriter, "bodyWriter");
        resetUploadedBytes();
        setAllFilesHaveBeenSuccessfullyUploaded(false);
        BodyWriter $this$onWriteRequestBody_u24lambda_u244 = bodyWriter;
        writeRequestParameters($this$onWriteRequestBody_u24lambda_u244);
        writeFiles($this$onWriteRequestBody_u24lambda_u244);
        $this$onWriteRequestBody_u24lambda_u244.write(this.trailerBytes);
    }
}
