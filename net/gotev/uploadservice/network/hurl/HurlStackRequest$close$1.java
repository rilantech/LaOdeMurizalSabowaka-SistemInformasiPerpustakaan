package net.gotev.uploadservice.network.hurl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: HurlStackRequest.kt */
final class HurlStackRequest$close$1 extends Lambda implements Function0<String> {
    final /* synthetic */ HurlStackRequest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HurlStackRequest$close$1(HurlStackRequest hurlStackRequest) {
        super(0);
        this.this$0 = hurlStackRequest;
    }

    public final String invoke() {
        return "closing HttpURLConnection (uuid: " + this.this$0.uuid + ")";
    }
}
