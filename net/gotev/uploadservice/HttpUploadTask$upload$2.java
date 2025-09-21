package net.gotev.uploadservice;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.network.ServerResponse;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpUploadTask.kt */
final class HttpUploadTask$upload$2 extends Lambda implements Function0<String> {
    final /* synthetic */ ServerResponse $response;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpUploadTask$upload$2(ServerResponse serverResponse) {
        super(0);
        this.$response = serverResponse;
    }

    public final String invoke() {
        int code = this.$response.getCode();
        return "Server response: code " + code + ", body " + this.$response.getBodyString();
    }
}
