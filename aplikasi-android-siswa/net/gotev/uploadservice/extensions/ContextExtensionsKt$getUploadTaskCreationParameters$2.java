package net.gotev.uploadservice.extensions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.data.UploadTaskParameters;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextExtensions.kt */
final class ContextExtensionsKt$getUploadTaskCreationParameters$2 extends Lambda implements Function0<String> {
    final /* synthetic */ UploadTaskParameters $params;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextExtensionsKt$getUploadTaskCreationParameters$2(UploadTaskParameters uploadTaskParameters) {
        super(0);
        this.$params = uploadTaskParameters;
    }

    public final String invoke() {
        return "Error while instantiating new task. " + this.$params.getTaskClass() + " does not extend UploadTask.";
    }
}
