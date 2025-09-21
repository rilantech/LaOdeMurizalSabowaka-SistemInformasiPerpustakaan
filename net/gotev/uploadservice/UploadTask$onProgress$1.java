package net.gotev.uploadservice;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadTask.kt */
final class UploadTask$onProgress$1 extends Lambda implements Function0<String> {
    final /* synthetic */ UploadTask this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UploadTask$onProgress$1(UploadTask uploadTask) {
        super(0);
        this.this$0 = uploadTask;
    }

    public final String invoke() {
        long access$getUploadedBytes$p = (this.this$0.uploadedBytes * ((long) 100)) / this.this$0.getTotalBytes();
        long access$getUploadedBytes$p2 = this.this$0.uploadedBytes;
        return "uploaded " + access$getUploadedBytes$p + "%, " + access$getUploadedBytes$p2 + " of " + this.this$0.getTotalBytes() + " bytes";
    }
}
