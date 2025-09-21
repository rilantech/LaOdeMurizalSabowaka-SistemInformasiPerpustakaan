package net.gotev.uploadservice;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.schemehandlers.ContentResolverSchemeHandler;
import net.gotev.uploadservice.schemehandlers.FileSchemeHandler;
import net.gotev.uploadservice.schemehandlers.SchemeHandler;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/LinkedHashMap;", "", "Ljava/lang/Class;", "Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadServiceConfig.kt */
final class UploadServiceConfig$schemeHandlers$2 extends Lambda implements Function0<LinkedHashMap<String, Class<? extends SchemeHandler>>> {
    public static final UploadServiceConfig$schemeHandlers$2 INSTANCE = new UploadServiceConfig$schemeHandlers$2();

    UploadServiceConfig$schemeHandlers$2() {
        super(0);
    }

    public final LinkedHashMap<String, Class<? extends SchemeHandler>> invoke() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap $this$invoke_u24lambda_u240 = linkedHashMap;
        $this$invoke_u24lambda_u240.put("/", FileSchemeHandler.class);
        $this$invoke_u24lambda_u240.put("content://", ContentResolverSchemeHandler.class);
        return linkedHashMap;
    }
}
