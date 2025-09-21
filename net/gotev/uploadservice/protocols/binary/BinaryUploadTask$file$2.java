package net.gotev.uploadservice.protocols.binary;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.schemehandlers.SchemeHandler;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BinaryUploadTask.kt */
final class BinaryUploadTask$file$2 extends Lambda implements Function0<SchemeHandler> {
    final /* synthetic */ BinaryUploadTask this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BinaryUploadTask$file$2(BinaryUploadTask binaryUploadTask) {
        super(0);
        this.this$0 = binaryUploadTask;
    }

    public final SchemeHandler invoke() {
        return ((UploadFile) CollectionsKt.first(this.this$0.getParams().getFiles())).getHandler();
    }
}
