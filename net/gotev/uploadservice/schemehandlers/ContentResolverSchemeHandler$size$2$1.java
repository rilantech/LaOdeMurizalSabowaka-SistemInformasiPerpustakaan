package net.gotev.uploadservice.schemehandlers;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentResolverSchemeHandler.kt */
final class ContentResolverSchemeHandler$size$2$1 extends Lambda implements Function0<String> {
    final /* synthetic */ ContentResolverSchemeHandler $this_run;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentResolverSchemeHandler$size$2$1(ContentResolverSchemeHandler contentResolverSchemeHandler) {
        super(0);
        this.$this_run = contentResolverSchemeHandler;
    }

    public final String invoke() {
        Uri access$getUri$p = this.$this_run.uri;
        if (access$getUri$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uri");
            access$getUri$p = null;
        }
        return "no cursor data for " + access$getUri$p + ", returning size 0";
    }
}
