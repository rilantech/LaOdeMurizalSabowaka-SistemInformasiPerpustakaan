package net.gotev.uploadservice;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.schemehandlers.SchemeHandler;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010'\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "", "", "Ljava/lang/Class;", "Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadServiceConfig.kt */
final class UploadServiceConfig$toString$1 extends Lambda implements Function1<Map.Entry<String, Class<? extends SchemeHandler>>, CharSequence> {
    public static final UploadServiceConfig$toString$1 INSTANCE = new UploadServiceConfig$toString$1();

    UploadServiceConfig$toString$1() {
        super(1);
    }

    public final CharSequence invoke(Map.Entry<String, Class<? extends SchemeHandler>> entry) {
        Intrinsics.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
        return "\"" + entry.getKey() + "\": \"" + entry.getValue().getName() + "\"";
    }
}
