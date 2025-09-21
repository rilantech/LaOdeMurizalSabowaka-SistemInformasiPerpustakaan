package net.gotev.uploadservice;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.data.HttpUploadTaskParameters;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpUploadTask.kt */
final class HttpUploadTask$httpParams$2 extends Lambda implements Function0<HttpUploadTaskParameters> {
    final /* synthetic */ HttpUploadTask this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpUploadTask$httpParams$2(HttpUploadTask httpUploadTask) {
        super(0);
        this.this$0 = httpUploadTask;
    }

    public final HttpUploadTaskParameters invoke() {
        return HttpUploadTaskParameters.Companion.createFromPersistableData(this.this$0.getParams().getAdditionalParameters());
    }
}
