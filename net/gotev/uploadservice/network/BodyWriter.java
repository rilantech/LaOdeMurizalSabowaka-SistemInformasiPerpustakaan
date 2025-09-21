package net.gotev.uploadservice.network;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lnet/gotev/uploadservice/network/BodyWriter;", "Ljava/io/Closeable;", "listener", "Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;", "(Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;)V", "flush", "", "internalWrite", "bytes", "", "lengthToWriteFromStart", "", "write", "writeStream", "stream", "Ljava/io/InputStream;", "OnStreamWriteListener", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BodyWriter.kt */
public abstract class BodyWriter implements Closeable {
    private final OnStreamWriteListener listener;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;", "", "onBytesWritten", "", "bytesWritten", "", "shouldContinueWriting", "", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BodyWriter.kt */
    public interface OnStreamWriteListener {
        void onBytesWritten(int i);

        boolean shouldContinueWriting();
    }

    public abstract void flush() throws IOException;

    public abstract void internalWrite(byte[] bArr) throws IOException;

    public abstract void internalWrite(byte[] bArr, int i) throws IOException;

    public BodyWriter(OnStreamWriteListener listener2) {
        Intrinsics.checkNotNullParameter(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = listener2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeStream(java.io.InputStream r7) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "stream"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int r0 = net.gotev.uploadservice.UploadServiceConfig.getBufferSizeBytes()
            byte[] r0 = new byte[r0]
            r1 = r7
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2 = r1
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x002e }
            r3 = 0
        L_0x0012:
            net.gotev.uploadservice.network.BodyWriter$OnStreamWriteListener r4 = r6.listener     // Catch:{ all -> 0x002e }
            boolean r4 = r4.shouldContinueWriting()     // Catch:{ all -> 0x002e }
            if (r4 == 0) goto L_0x0026
            r4 = 0
            int r5 = r0.length     // Catch:{ all -> 0x002e }
            int r4 = r2.read(r0, r4, r5)     // Catch:{ all -> 0x002e }
            if (r4 <= 0) goto L_0x0026
            r6.write(r0, r4)     // Catch:{ all -> 0x002e }
            goto L_0x0012
        L_0x0026:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002e }
            r2 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            return
        L_0x002e:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0030 }
        L_0x0030:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.network.BodyWriter.writeStream(java.io.InputStream):void");
    }

    public final void write(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        internalWrite(bytes);
        flush();
        this.listener.onBytesWritten(bytes.length);
    }

    public final void write(byte[] bytes, int lengthToWriteFromStart) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        internalWrite(bytes, lengthToWriteFromStart);
        flush();
        this.listener.onBytesWritten(lengthToWriteFromStart);
    }
}
