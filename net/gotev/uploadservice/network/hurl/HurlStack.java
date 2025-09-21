package net.gotev.uploadservice.network.hurl;

import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.HttpUploadTaskParameters;
import net.gotev.uploadservice.network.HttpRequest;
import net.gotev.uploadservice.network.HttpStack;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lnet/gotev/uploadservice/network/hurl/HurlStack;", "Lnet/gotev/uploadservice/network/HttpStack;", "userAgent", "", "followRedirects", "", "useCaches", "connectTimeoutMillis", "", "readTimeoutMillis", "(Ljava/lang/String;ZZII)V", "newRequest", "Lnet/gotev/uploadservice/network/HttpRequest;", "uploadId", "method", "url", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HurlStack.kt */
public final class HurlStack implements HttpStack {
    private final int connectTimeoutMillis;
    private final boolean followRedirects;
    private final int readTimeoutMillis;
    private final boolean useCaches;
    private final String userAgent;

    public HurlStack() {
        this((String) null, false, false, 0, 0, 31, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HurlStack(String str) {
        this(str, false, false, 0, 0, 30, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "userAgent");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HurlStack(String str, boolean z) {
        this(str, z, false, 0, 0, 28, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "userAgent");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HurlStack(String str, boolean z, boolean z2) {
        this(str, z, z2, 0, 0, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "userAgent");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HurlStack(String str, boolean z, boolean z2, int i) {
        this(str, z, z2, i, 0, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "userAgent");
    }

    public HurlStack(String userAgent2, boolean followRedirects2, boolean useCaches2, int connectTimeoutMillis2, int readTimeoutMillis2) {
        Intrinsics.checkNotNullParameter(userAgent2, "userAgent");
        this.userAgent = userAgent2;
        this.followRedirects = followRedirects2;
        this.useCaches = useCaches2;
        this.connectTimeoutMillis = connectTimeoutMillis2;
        this.readTimeoutMillis = readTimeoutMillis2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HurlStack(java.lang.String r4, boolean r5, boolean r6, int r7, int r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            java.lang.String r4 = "AndroidUploadService/4.9.2"
        L_0x0006:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000d
            r5 = 1
            r10 = r5
            goto L_0x000e
        L_0x000d:
            r10 = r5
        L_0x000e:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0015
            r6 = 0
            r0 = r6
            goto L_0x0016
        L_0x0015:
            r0 = r6
        L_0x0016:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001e
            r7 = 15000(0x3a98, float:2.102E-41)
            r1 = r7
            goto L_0x001f
        L_0x001e:
            r1 = r7
        L_0x001f:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0027
            r8 = 30000(0x7530, float:4.2039E-41)
            r2 = r8
            goto L_0x0028
        L_0x0027:
            r2 = r8
        L_0x0028:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.network.hurl.HurlStack.<init>(java.lang.String, boolean, boolean, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public HttpRequest newRequest(String uploadId, String method, String url) throws IOException {
        Intrinsics.checkNotNullParameter(uploadId, "uploadId");
        Intrinsics.checkNotNullParameter(method, HttpUploadTaskParameters.Companion.CodingKeys.method);
        Intrinsics.checkNotNullParameter(url, ImagesContract.URL);
        return new HurlStackRequest(this.userAgent, uploadId, method, url, this.followRedirects, this.useCaches, this.connectTimeoutMillis, this.readTimeoutMillis);
    }
}
