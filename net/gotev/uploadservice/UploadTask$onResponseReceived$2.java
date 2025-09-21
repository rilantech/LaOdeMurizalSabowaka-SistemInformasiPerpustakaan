package net.gotev.uploadservice;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.data.UploadFile;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadTask.kt */
final class UploadTask$onResponseReceived$2 extends Lambda implements Function0<String> {
    final /* synthetic */ UploadFile $file;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UploadTask$onResponseReceived$2(UploadFile uploadFile) {
        super(0);
        this.$file = uploadFile;
    }

    public final String invoke() {
        return "successfully deleted: " + this.$file.getPath();
    }
}
