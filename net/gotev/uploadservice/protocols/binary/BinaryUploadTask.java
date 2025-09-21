package net.gotev.uploadservice.protocols.binary;

import com.android.volley.toolbox.HttpHeaderParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.HttpUploadTask;
import net.gotev.uploadservice.data.NameValue;
import net.gotev.uploadservice.extensions.CollectionsExtensionsKt;
import net.gotev.uploadservice.network.BodyWriter;
import net.gotev.uploadservice.schemehandlers.SchemeHandler;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lnet/gotev/uploadservice/protocols/binary/BinaryUploadTask;", "Lnet/gotev/uploadservice/HttpUploadTask;", "()V", "bodyLength", "", "getBodyLength", "()J", "file", "Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "getFile", "()Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "file$delegate", "Lkotlin/Lazy;", "onWriteRequestBody", "", "bodyWriter", "Lnet/gotev/uploadservice/network/BodyWriter;", "performInitialization", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BinaryUploadTask.kt */
public final class BinaryUploadTask extends HttpUploadTask {
    private final Lazy file$delegate = LazyKt.lazy(new BinaryUploadTask$file$2(this));

    private final SchemeHandler getFile() {
        return (SchemeHandler) this.file$delegate.getValue();
    }

    public long getBodyLength() {
        return getFile().size(getContext());
    }

    public void performInitialization() {
        ArrayList<NameValue> requestHeaders = getHttpParams().getRequestHeaders();
        Iterable $this$none$iv = requestHeaders;
        boolean z = true;
        if (!($this$none$iv instanceof Collection) || !((Collection) $this$none$iv).isEmpty()) {
            Iterator it = $this$none$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String lowerCase = ((NameValue) it.next()).getName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (Intrinsics.areEqual((Object) lowerCase, (Object) "content-type")) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            CollectionsExtensionsKt.addHeader(requestHeaders, HttpHeaderParser.HEADER_CONTENT_TYPE, getFile().contentType(getContext()));
        }
    }

    public void onWriteRequestBody(BodyWriter bodyWriter) {
        Intrinsics.checkNotNullParameter(bodyWriter, "bodyWriter");
        bodyWriter.writeStream(getFile().stream(getContext()));
    }
}
