package net.gotev.uploadservice.schemehandlers;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
import net.gotev.uploadservice.logger.UploadServiceLogger;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lnet/gotev/uploadservice/schemehandlers/FileSchemeHandler;", "Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "()V", "file", "Ljava/io/File;", "contentType", "", "context", "Landroid/content/Context;", "delete", "", "init", "", "path", "name", "size", "", "stream", "Ljava/io/FileInputStream;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FileSchemeHandler.kt */
public final class FileSchemeHandler implements SchemeHandler {
    private File file;

    public void init(String path) {
        Intrinsics.checkNotNullParameter(path, UploadFile.Companion.CodingKeys.path);
        this.file = new File(path);
    }

    public long size(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file2 = this.file;
        if (file2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("file");
            file2 = null;
        }
        return file2.length();
    }

    public FileInputStream stream(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file2 = this.file;
        if (file2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("file");
            file2 = null;
        }
        return new FileInputStream(file2);
    }

    public String contentType(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file2 = this.file;
        if (file2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("file");
            file2 = null;
        }
        String absolutePath = file2.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        return StringExtensionsKt.autoDetectMimeType(absolutePath);
    }

    public String name(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file2 = this.file;
        File file3 = null;
        if (file2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("file");
            file2 = null;
        }
        String name = file2.getName();
        if (name != null) {
            return name;
        }
        File file4 = this.file;
        if (file4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("file");
        } else {
            file3 = file4;
        }
        throw new IOException("Can't get file name for " + file3.getAbsolutePath());
    }

    public boolean delete(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            File file2 = this.file;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("file");
                file2 = null;
            }
            return file2.delete();
        } catch (Throwable exc) {
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            UploadServiceLogger.error(simpleName, UploadServiceLogger.NA, exc, FileSchemeHandler$delete$1.INSTANCE);
            return false;
        }
    }
}
