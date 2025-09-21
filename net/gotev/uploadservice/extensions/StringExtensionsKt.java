package net.gotev.uploadservice.extensions;

import android.webkit.MimeTypeMap;
import java.net.URL;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0001\u001a\f\u0010\n\u001a\u00020\u000b*\u0004\u0018\u00010\u0001\u001a\n\u0010\f\u001a\u00020\u000b*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\u0007\u001a\u00020\u0004*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\r"}, d2 = {"APPLICATION_OCTET_STREAM", "", "VIDEO_MP4", "asciiBytes", "", "getAsciiBytes", "(Ljava/lang/String;)[B", "utf8Bytes", "getUtf8Bytes", "autoDetectMimeType", "isASCII", "", "isValidHttpUrl", "uploadservice_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: StringExtensions.kt */
public final class StringExtensionsKt {
    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    public static final String VIDEO_MP4 = "video/mp4";

    public static final String autoDetectMimeType(String $this$autoDetectMimeType) {
        Intrinsics.checkNotNullParameter($this$autoDetectMimeType, "<this>");
        int index = StringsKt.lastIndexOf$default((CharSequence) $this$autoDetectMimeType, ".", 0, false, 6, (Object) null);
        boolean z = false;
        if (index >= 0 && index < StringsKt.getLastIndex($this$autoDetectMimeType)) {
            z = true;
        }
        if (!z) {
            return APPLICATION_OCTET_STREAM;
        }
        String substring = $this$autoDetectMimeType.substring(index + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        String extension = substring.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(extension, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (Intrinsics.areEqual((Object) extension, (Object) "mp4")) {
            return VIDEO_MP4;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        if (mimeTypeFromExtension == null) {
            return APPLICATION_OCTET_STREAM;
        }
        return mimeTypeFromExtension;
    }

    public static final boolean isASCII(String $this$isASCII) {
        CharSequence charSequence = $this$isASCII;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return false;
        }
        int length = $this$isASCII.length();
        for (int index = 0; index < length; index++) {
            if ($this$isASCII.charAt(index) > 127) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isValidHttpUrl(String $this$isValidHttpUrl) {
        Intrinsics.checkNotNullParameter($this$isValidHttpUrl, "<this>");
        if (!StringsKt.startsWith$default($this$isValidHttpUrl, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default($this$isValidHttpUrl, "https://", false, 2, (Object) null)) {
            return false;
        }
        try {
            new URL($this$isValidHttpUrl);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static final byte[] getAsciiBytes(String $this$asciiBytes) {
        Intrinsics.checkNotNullParameter($this$asciiBytes, "<this>");
        byte[] bytes = $this$asciiBytes.getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final byte[] getUtf8Bytes(String $this$utf8Bytes) {
        Intrinsics.checkNotNullParameter($this$utf8Bytes, "<this>");
        byte[] bytes = $this$utf8Bytes.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }
}
