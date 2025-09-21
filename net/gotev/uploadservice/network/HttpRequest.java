package net.gotev.uploadservice.network;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import net.gotev.uploadservice.data.NameValue;
import net.gotev.uploadservice.network.BodyWriter;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0012"}, d2 = {"Lnet/gotev/uploadservice/network/HttpRequest;", "Ljava/io/Closeable;", "getResponse", "Lnet/gotev/uploadservice/network/ServerResponse;", "delegate", "Lnet/gotev/uploadservice/network/HttpRequest$RequestBodyDelegate;", "listener", "Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;", "setHeaders", "requestHeaders", "", "Lnet/gotev/uploadservice/data/NameValue;", "setTotalBodyBytes", "totalBodyBytes", "", "isFixedLengthStreamingMode", "", "RequestBodyDelegate", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpRequest.kt */
public interface HttpRequest extends Closeable {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lnet/gotev/uploadservice/network/HttpRequest$RequestBodyDelegate;", "", "onWriteRequestBody", "", "bodyWriter", "Lnet/gotev/uploadservice/network/BodyWriter;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HttpRequest.kt */
    public interface RequestBodyDelegate {
        void onWriteRequestBody(BodyWriter bodyWriter) throws IOException;
    }

    ServerResponse getResponse(RequestBodyDelegate requestBodyDelegate, BodyWriter.OnStreamWriteListener onStreamWriteListener) throws IOException;

    HttpRequest setHeaders(List<NameValue> list) throws IOException;

    HttpRequest setTotalBodyBytes(long j, boolean z);
}
