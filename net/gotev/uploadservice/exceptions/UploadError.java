package net.gotev.uploadservice.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.network.ServerResponse;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lnet/gotev/uploadservice/exceptions/UploadError;", "", "serverResponse", "Lnet/gotev/uploadservice/network/ServerResponse;", "(Lnet/gotev/uploadservice/network/ServerResponse;)V", "getServerResponse", "()Lnet/gotev/uploadservice/network/ServerResponse;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Exceptions.kt */
public final class UploadError extends Throwable {
    private final ServerResponse serverResponse;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadError(ServerResponse serverResponse2) {
        super("Upload error");
        Intrinsics.checkNotNullParameter(serverResponse2, "serverResponse");
        this.serverResponse = serverResponse2;
    }

    public final ServerResponse getServerResponse() {
        return this.serverResponse;
    }
}
