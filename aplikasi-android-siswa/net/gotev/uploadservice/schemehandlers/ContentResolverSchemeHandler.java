package net.gotev.uploadservice.schemehandlers;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
import net.gotev.uploadservice.logger.UploadServiceLogger;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lnet/gotev/uploadservice/schemehandlers/ContentResolverSchemeHandler;", "Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "()V", "uri", "Landroid/net/Uri;", "contentType", "", "context", "Landroid/content/Context;", "delete", "", "init", "", "path", "name", "size", "", "stream", "Ljava/io/InputStream;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentResolverSchemeHandler.kt */
public final class ContentResolverSchemeHandler implements SchemeHandler {
    /* access modifiers changed from: private */
    public Uri uri;

    public void init(String path) {
        Intrinsics.checkNotNullParameter(path, UploadFile.Companion.CodingKeys.path);
        Uri parse = Uri.parse(path);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(path)");
        this.uri = parse;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long size(android.content.Context r10) {
        /*
            r9 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            android.content.ContentResolver r1 = r10.getContentResolver()
            android.net.Uri r0 = r9.uri
            r7 = 0
            if (r0 != 0) goto L_0x0015
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r2 = r7
            goto L_0x0016
        L_0x0015:
            r2 = r0
        L_0x0016:
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x0052
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = r0
            android.database.Cursor r1 = (android.database.Cursor) r1     // Catch:{ all -> 0x004b }
            r2 = 0
            boolean r3 = r1.moveToFirst()     // Catch:{ all -> 0x004b }
            if (r3 == 0) goto L_0x003f
            java.lang.String r3 = "_size"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x004b }
            if (r3 < 0) goto L_0x003d
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x004b }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x004b }
            goto L_0x0040
        L_0x003d:
            r4 = r7
            goto L_0x0040
        L_0x003f:
            r4 = r7
        L_0x0040:
            kotlin.io.CloseableKt.closeFinally(r0, r7)
            if (r4 == 0) goto L_0x0052
            long r0 = r4.longValue()
            goto L_0x0076
        L_0x004b:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x004d }
        L_0x004d:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        L_0x0052:
            r0 = r9
            net.gotev.uploadservice.schemehandlers.ContentResolverSchemeHandler r0 = (net.gotev.uploadservice.schemehandlers.ContentResolverSchemeHandler) r0
            r1 = 0
            java.lang.Class r2 = r0.getClass()
            java.lang.String r3 = r2.getSimpleName()
            java.lang.String r2 = "javaClass.simpleName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            r5 = 0
            net.gotev.uploadservice.schemehandlers.ContentResolverSchemeHandler$size$2$1 r2 = new net.gotev.uploadservice.schemehandlers.ContentResolverSchemeHandler$size$2$1
            r2.<init>(r0)
            r6 = r2
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r7 = 4
            r8 = 0
            java.lang.String r4 = "N/A"
            net.gotev.uploadservice.logger.UploadServiceLogger.error$default(r3, r4, r5, r6, r7, r8)
            r0 = 0
        L_0x0076:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.schemehandlers.ContentResolverSchemeHandler.size(android.content.Context):long");
    }

    public InputStream stream(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri2 = this.uri;
        Uri uri3 = null;
        if (uri2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uri");
            uri2 = null;
        }
        InputStream openInputStream = contentResolver.openInputStream(uri2);
        if (openInputStream != null) {
            return openInputStream;
        }
        Uri uri4 = this.uri;
        if (uri4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uri");
        } else {
            uri3 = uri4;
        }
        throw new IOException("can't open input stream for " + uri3);
    }

    public String contentType(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri2 = this.uri;
        if (uri2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uri");
            uri2 = null;
        }
        String type = contentResolver.getType(uri2);
        CharSequence charSequence = type;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return StringExtensionsKt.APPLICATION_OCTET_STREAM;
        }
        return type;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String name(android.content.Context r10) {
        /*
            r9 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            android.content.ContentResolver r1 = r10.getContentResolver()
            android.net.Uri r0 = r9.uri
            java.lang.String r7 = "uri"
            r8 = 0
            if (r0 != 0) goto L_0x0015
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r2 = r8
            goto L_0x0016
        L_0x0015:
            r2 = r0
        L_0x0016:
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x004a
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = r0
            android.database.Cursor r1 = (android.database.Cursor) r1     // Catch:{ all -> 0x0043 }
            r2 = 0
            boolean r3 = r1.moveToFirst()     // Catch:{ all -> 0x0043 }
            if (r3 == 0) goto L_0x003b
            java.lang.String r3 = "_display_name"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0043 }
            if (r3 < 0) goto L_0x0039
            java.lang.String r4 = r1.getString(r3)     // Catch:{ all -> 0x0043 }
            goto L_0x003c
        L_0x0039:
            r4 = r8
            goto L_0x003c
        L_0x003b:
            r4 = r8
        L_0x003c:
            kotlin.io.CloseableKt.closeFinally(r0, r8)
            if (r4 != 0) goto L_0x007b
            goto L_0x004a
        L_0x0043:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        L_0x004a:
            android.net.Uri r0 = r9.uri
            if (r0 != 0) goto L_0x0052
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            goto L_0x0053
        L_0x0052:
            r8 = r0
        L_0x0053:
            java.lang.String r0 = r8.toString()
            java.lang.String r1 = "uri.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]
            r0 = 0
            java.lang.String r1 = java.io.File.separator
            java.lang.String r4 = "separator"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            r3[r0] = r1
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r2, (java.lang.String[]) r3, (boolean) r4, (int) r5, (int) r6, (java.lang.Object) r7)
            java.lang.Object r0 = kotlin.collections.CollectionsKt.last(r0)
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
        L_0x007b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.schemehandlers.ContentResolverSchemeHandler.name(android.content.Context):java.lang.String");
    }

    public boolean delete(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri2 = this.uri;
            if (uri2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uri");
                uri2 = null;
            }
            return contentResolver.delete(uri2, (String) null, (String[]) null) > 0;
        } catch (Throwable exc) {
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            UploadServiceLogger.error(simpleName, UploadServiceLogger.NA, exc, ContentResolverSchemeHandler$delete$1.INSTANCE);
            return false;
        }
    }
}
