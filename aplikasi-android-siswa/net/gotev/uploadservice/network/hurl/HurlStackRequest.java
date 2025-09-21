package net.gotev.uploadservice.network.hurl;

import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.gotev.uploadservice.data.HttpUploadTaskParameters;
import net.gotev.uploadservice.data.NameValue;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import net.gotev.uploadservice.network.HttpRequest;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0016\u0010\"\u001a\u00020\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u0018\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\bH\u0016J\f\u0010*\u001a\u00020\u000f*\u00020\u0003H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0015j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lnet/gotev/uploadservice/network/hurl/HurlStackRequest;", "Lnet/gotev/uploadservice/network/HttpRequest;", "userAgent", "", "uploadId", "method", "url", "followRedirects", "", "useCaches", "connectTimeoutMillis", "", "readTimeoutMillis", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZII)V", "connection", "Ljava/net/HttpURLConnection;", "responseBody", "", "getResponseBody", "()[B", "responseHeaders", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "getResponseHeaders", "()Ljava/util/LinkedHashMap;", "uuid", "close", "", "getResponse", "Lnet/gotev/uploadservice/network/ServerResponse;", "delegate", "Lnet/gotev/uploadservice/network/HttpRequest$RequestBodyDelegate;", "listener", "Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;", "setHeaders", "requestHeaders", "", "Lnet/gotev/uploadservice/data/NameValue;", "setTotalBodyBytes", "totalBodyBytes", "", "isFixedLengthStreamingMode", "createConnection", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HurlStackRequest.kt */
public final class HurlStackRequest implements HttpRequest {
    private final HttpURLConnection connection;
    private final String uploadId;
    private final String userAgent;
    /* access modifiers changed from: private */
    public final String uuid;

    public HurlStackRequest(String userAgent2, String uploadId2, String method, String url, boolean followRedirects, boolean useCaches, int connectTimeoutMillis, int readTimeoutMillis) {
        Intrinsics.checkNotNullParameter(userAgent2, "userAgent");
        Intrinsics.checkNotNullParameter(uploadId2, "uploadId");
        Intrinsics.checkNotNullParameter(method, HttpUploadTaskParameters.Companion.CodingKeys.method);
        Intrinsics.checkNotNullParameter(url, ImagesContract.URL);
        this.userAgent = userAgent2;
        this.uploadId = uploadId2;
        String uuid2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid2, "randomUUID().toString()");
        this.uuid = uuid2;
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        UploadServiceLogger.debug(simpleName, uploadId2, new Function0<String>(this) {
            final /* synthetic */ HurlStackRequest this$0;

            {
                this.this$0 = r2;
            }

            public final String invoke() {
                return "creating new HttpURLConnection (uuid: " + this.this$0.uuid + ")";
            }
        });
        HttpURLConnection createConnection = createConnection(url);
        HttpURLConnection $this$_init__u24lambda_u240 = createConnection;
        $this$_init__u24lambda_u240.setDoInput(true);
        $this$_init__u24lambda_u240.setDoOutput(true);
        $this$_init__u24lambda_u240.setConnectTimeout(connectTimeoutMillis);
        $this$_init__u24lambda_u240.setReadTimeout(readTimeoutMillis);
        $this$_init__u24lambda_u240.setUseCaches(useCaches);
        $this$_init__u24lambda_u240.setInstanceFollowRedirects(followRedirects);
        $this$_init__u24lambda_u240.setRequestMethod(method);
        this.connection = createConnection;
    }

    private final HttpURLConnection createConnection(String $this$createConnection) {
        URL url = new URL(StringsKt.trim((CharSequence) $this$createConnection).toString());
        if (StringsKt.equals("https", url.getProtocol(), true)) {
            URLConnection openConnection = url.openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            return (HttpsURLConnection) openConnection;
        }
        URLConnection openConnection2 = url.openConnection();
        Intrinsics.checkNotNull(openConnection2, "null cannot be cast to non-null type java.net.HttpURLConnection");
        return (HttpURLConnection) openConnection2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final byte[] getResponseBody() throws java.io.IOException {
        /*
            r5 = this;
            java.net.HttpURLConnection r0 = r5.connection
            int r0 = r0.getResponseCode()
            int r0 = r0 / 100
            r1 = 2
            if (r0 != r1) goto L_0x0012
            java.net.HttpURLConnection r0 = r5.connection
            java.io.InputStream r0 = r0.getInputStream()
            goto L_0x0018
        L_0x0012:
            java.net.HttpURLConnection r0 = r5.connection
            java.io.InputStream r0 = r0.getErrorStream()
        L_0x0018:
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            r2 = r0
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x002c }
            r3 = 0
            java.lang.String r4 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ all -> 0x002c }
            byte[] r4 = kotlin.io.ByteStreamsKt.readBytes(r2)     // Catch:{ all -> 0x002c }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return r4
        L_0x002c:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x002e }
        L_0x002e:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.network.hurl.HurlStackRequest.getResponseBody():byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005e, code lost:
        if ((!((java.util.Collection) r15).isEmpty()) != false) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.LinkedHashMap<java.lang.String, java.lang.String> getResponseHeaders() throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            java.net.HttpURLConnection r1 = r0.connection
            java.util.Map r1 = r1.getHeaderFields()
            r2 = 0
            if (r1 != 0) goto L_0x0011
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>(r2)
            return r1
        L_0x0011:
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            int r4 = r1.size()
            r3.<init>(r4)
            r4 = r3
            r5 = 0
            java.util.Set r6 = r1.entrySet()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r7 = 0
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            r9 = r6
            r10 = 0
            java.util.Iterator r11 = r9.iterator()
        L_0x0031:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x006a
            java.lang.Object r12 = r11.next()
            r13 = r12
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            r14 = 0
            java.lang.Object r15 = r13.getKey()
            r16 = 1
            if (r15 == 0) goto L_0x0061
            java.lang.Object r15 = r13.getValue()
            if (r15 == 0) goto L_0x0061
            java.lang.Object r15 = r13.getValue()
            java.lang.String r2 = "it.value"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r2)
            java.util.Collection r15 = (java.util.Collection) r15
            boolean r2 = r15.isEmpty()
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r16 = 0
        L_0x0063:
            if (r16 == 0) goto L_0x0068
            r8.add(r12)
        L_0x0068:
            r2 = 0
            goto L_0x0031
        L_0x006a:
            r2 = r8
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r6 = 0
            java.util.Iterator r7 = r2.iterator()
        L_0x0077:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00ad
            java.lang.Object r8 = r7.next()
            r9 = r8
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            r10 = 0
            java.lang.Object r11 = r9.getKey()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r9 = r9.getValue()
            java.util.List r9 = (java.util.List) r9
            r12 = r4
            java.util.Map r12 = (java.util.Map) r12
            java.lang.String r13 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r13)
            java.lang.String r13 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r13)
            java.lang.Object r13 = kotlin.collections.CollectionsKt.first(r9)
            java.lang.String r14 = "values.first()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            r12.put(r11, r13)
            goto L_0x0077
        L_0x00ad:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.network.hurl.HurlStackRequest.getResponseHeaders():java.util.LinkedHashMap");
    }

    public HttpRequest setHeaders(List<NameValue> requestHeaders) throws IOException {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        this.connection.setRequestProperty("User-Agent", this.userAgent);
        for (NameValue param : requestHeaders) {
            this.connection.setRequestProperty(StringsKt.trim((CharSequence) param.getName()).toString(), StringsKt.trim((CharSequence) param.getValue()).toString());
        }
        return this;
    }

    public HttpRequest setTotalBodyBytes(long totalBodyBytes, boolean isFixedLengthStreamingMode) {
        HttpURLConnection $this$setTotalBodyBytes_u24lambda_u245 = this.connection;
        if (isFixedLengthStreamingMode) {
            $this$setTotalBodyBytes_u24lambda_u245.setFixedLengthStreamingMode(totalBodyBytes);
        } else {
            $this$setTotalBodyBytes_u24lambda_u245.setChunkedStreamingMode(0);
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.gotev.uploadservice.network.ServerResponse getResponse(net.gotev.uploadservice.network.HttpRequest.RequestBodyDelegate r9, net.gotev.uploadservice.network.BodyWriter.OnStreamWriteListener r10) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.String r0 = "delegate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = r8
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = r0
            net.gotev.uploadservice.network.hurl.HurlStackRequest r1 = (net.gotev.uploadservice.network.hurl.HurlStackRequest) r1     // Catch:{ all -> 0x0052 }
            r2 = 0
            net.gotev.uploadservice.network.hurl.HurlBodyWriter r3 = new net.gotev.uploadservice.network.hurl.HurlBodyWriter     // Catch:{ all -> 0x0052 }
            java.net.HttpURLConnection r4 = r8.connection     // Catch:{ all -> 0x0052 }
            java.io.OutputStream r4 = r4.getOutputStream()     // Catch:{ all -> 0x0052 }
            java.lang.String r5 = "connection.outputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ all -> 0x0052 }
            r3.<init>(r4, r10)     // Catch:{ all -> 0x0052 }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x0052 }
            r4 = r3
            net.gotev.uploadservice.network.hurl.HurlBodyWriter r4 = (net.gotev.uploadservice.network.hurl.HurlBodyWriter) r4     // Catch:{ all -> 0x004b }
            r5 = 0
            r6 = r4
            net.gotev.uploadservice.network.BodyWriter r6 = (net.gotev.uploadservice.network.BodyWriter) r6     // Catch:{ all -> 0x004b }
            r9.onWriteRequestBody(r6)     // Catch:{ all -> 0x004b }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004b }
            r4 = 0
            kotlin.io.CloseableKt.closeFinally(r3, r4)     // Catch:{ all -> 0x0052 }
            net.gotev.uploadservice.network.ServerResponse r3 = new net.gotev.uploadservice.network.ServerResponse     // Catch:{ all -> 0x0052 }
            java.net.HttpURLConnection r5 = r8.connection     // Catch:{ all -> 0x0052 }
            int r5 = r5.getResponseCode()     // Catch:{ all -> 0x0052 }
            byte[] r6 = r8.getResponseBody()     // Catch:{ all -> 0x0052 }
            java.util.LinkedHashMap r7 = r8.getResponseHeaders()     // Catch:{ all -> 0x0052 }
            r3.<init>(r5, r6, r7)     // Catch:{ all -> 0x0052 }
            kotlin.io.CloseableKt.closeFinally(r0, r4)
            return r3
        L_0x004b:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x004d }
        L_0x004d:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r4)     // Catch:{ all -> 0x0052 }
            throw r5     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.network.hurl.HurlStackRequest.getResponse(net.gotev.uploadservice.network.HttpRequest$RequestBodyDelegate, net.gotev.uploadservice.network.BodyWriter$OnStreamWriteListener):net.gotev.uploadservice.network.ServerResponse");
    }

    public void close() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        UploadServiceLogger.debug(simpleName, this.uploadId, new HurlStackRequest$close$1(this));
        try {
            this.connection.getInputStream().close();
        } catch (Throwable th) {
        }
        try {
            this.connection.getOutputStream().flush();
        } catch (Throwable th2) {
        }
        try {
            this.connection.getOutputStream().close();
        } catch (Throwable th3) {
        }
        try {
            this.connection.disconnect();
        } catch (Throwable th4) {
        }
    }
}
