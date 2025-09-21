package net.gotev.uploadservice;

import android.content.Context;
import android.util.Base64;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import net.gotev.uploadservice.HttpUploadRequest;
import net.gotev.uploadservice.data.HttpUploadTaskParameters;
import net.gotev.uploadservice.data.NameValue;
import net.gotev.uploadservice.data.UploadTaskParameters;
import net.gotev.uploadservice.extensions.CollectionsExtensionsKt;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
import net.gotev.uploadservice.persistence.PersistableData;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J)\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u00062\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000f\"\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0010J#\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0002\u0010\u0017J\u001d\u0010\u0018\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\u001b\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0002\u0010\u0017J\u0013\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u0006¢\u0006\u0002\u0010!J\u0013\u0010$\u001a\u00028\u00002\u0006\u0010%\u001a\u00020&¢\u0006\u0002\u0010'R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006("}, d2 = {"Lnet/gotev/uploadservice/HttpUploadRequest;", "B", "Lnet/gotev/uploadservice/UploadRequest;", "context", "Landroid/content/Context;", "serverUrl", "", "(Landroid/content/Context;Ljava/lang/String;)V", "httpParams", "Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "getHttpParams", "()Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "addArrayParameter", "paramName", "array", "", "(Ljava/lang/String;[Ljava/lang/String;)Lnet/gotev/uploadservice/HttpUploadRequest;", "list", "", "(Ljava/lang/String;Ljava/util/List;)Lnet/gotev/uploadservice/HttpUploadRequest;", "addHeader", "headerName", "headerValue", "(Ljava/lang/String;Ljava/lang/String;)Lnet/gotev/uploadservice/HttpUploadRequest;", "addParameter", "paramValue", "getAdditionalParameters", "Lnet/gotev/uploadservice/persistence/PersistableData;", "setBasicAuth", "username", "password", "setBearerAuth", "bearerToken", "(Ljava/lang/String;)Lnet/gotev/uploadservice/HttpUploadRequest;", "setMethod", "method", "setUsesFixedLengthStreamingMode", "fixedLength", "", "(Z)Lnet/gotev/uploadservice/HttpUploadRequest;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpUploadRequest.kt */
public abstract class HttpUploadRequest<B extends HttpUploadRequest<B>> extends UploadRequest<B> {
    private final HttpUploadTaskParameters httpParams = new HttpUploadTaskParameters((String) null, false, (ArrayList) null, (ArrayList) null, 15, (DefaultConstructorMarker) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpUploadRequest(Context context, String serverUrl) {
        super(context, serverUrl);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serverUrl, UploadTaskParameters.Companion.CodingKeys.serverUrl);
        if (!StringExtensionsKt.isValidHttpUrl(serverUrl)) {
            throw new IllegalArgumentException("Specify either http:// or https:// as protocol".toString());
        }
    }

    /* access modifiers changed from: protected */
    public final HttpUploadTaskParameters getHttpParams() {
        return this.httpParams;
    }

    /* access modifiers changed from: protected */
    public PersistableData getAdditionalParameters() {
        return this.httpParams.toPersistableData();
    }

    public final B addHeader(String headerName, String headerValue) {
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        Intrinsics.checkNotNullParameter(headerValue, "headerValue");
        CollectionsExtensionsKt.addHeader(this.httpParams.getRequestHeaders(), headerName, headerValue);
        return (HttpUploadRequest) self();
    }

    public final B setBasicAuth(String username, String password) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        byte[] bytes = (username + ":" + password).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return addHeader("Authorization", "Basic " + Base64.encodeToString(bytes, 2));
    }

    public final B setBearerAuth(String bearerToken) {
        Intrinsics.checkNotNullParameter(bearerToken, "bearerToken");
        return addHeader("Authorization", "Bearer " + bearerToken);
    }

    public B addParameter(String paramName, String paramValue) {
        Intrinsics.checkNotNullParameter(paramName, "paramName");
        Intrinsics.checkNotNullParameter(paramValue, "paramValue");
        this.httpParams.getRequestParameters().add(new NameValue(paramName, paramValue));
        return (HttpUploadRequest) self();
    }

    public B addArrayParameter(String paramName, String... array) {
        Intrinsics.checkNotNullParameter(paramName, "paramName");
        Intrinsics.checkNotNullParameter(array, "array");
        for (String value : array) {
            this.httpParams.getRequestParameters().add(new NameValue(paramName, value));
        }
        return (HttpUploadRequest) self();
    }

    public B addArrayParameter(String paramName, List<String> list) {
        Intrinsics.checkNotNullParameter(paramName, "paramName");
        Intrinsics.checkNotNullParameter(list, "list");
        for (String value : list) {
            this.httpParams.getRequestParameters().add(new NameValue(paramName, value));
        }
        return (HttpUploadRequest) self();
    }

    public final B setMethod(String method) {
        Intrinsics.checkNotNullParameter(method, HttpUploadTaskParameters.Companion.CodingKeys.method);
        HttpUploadTaskParameters httpUploadTaskParameters = this.httpParams;
        String upperCase = method.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        httpUploadTaskParameters.setMethod(upperCase);
        return (HttpUploadRequest) self();
    }

    public final B setUsesFixedLengthStreamingMode(boolean fixedLength) {
        this.httpParams.setUsesFixedLengthStreamingMode(fixedLength);
        return (HttpUploadRequest) self();
    }
}
