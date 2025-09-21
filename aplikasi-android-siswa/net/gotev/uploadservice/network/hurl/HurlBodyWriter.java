package net.gotev.uploadservice.network.hurl;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.network.BodyWriter;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lnet/gotev/uploadservice/network/hurl/HurlBodyWriter;", "Lnet/gotev/uploadservice/network/BodyWriter;", "stream", "Ljava/io/OutputStream;", "listener", "Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;", "(Ljava/io/OutputStream;Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;)V", "close", "", "flush", "internalWrite", "bytes", "", "lengthToWriteFromStart", "", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HurlBodyWriter.kt */
public final class HurlBodyWriter extends BodyWriter {
    private final OutputStream stream;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HurlBodyWriter(OutputStream stream2, BodyWriter.OnStreamWriteListener listener) {
        super(listener);
        Intrinsics.checkNotNullParameter(stream2, "stream");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.stream = stream2;
    }

    public void internalWrite(byte[] bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.stream.write(bytes);
    }

    public void internalWrite(byte[] bytes, int lengthToWriteFromStart) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.stream.write(bytes, 0, lengthToWriteFromStart);
    }

    public void flush() throws IOException {
        this.stream.flush();
    }

    public void close() throws IOException {
        this.stream.close();
    }
}
