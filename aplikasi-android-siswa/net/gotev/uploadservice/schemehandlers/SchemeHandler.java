package net.gotev.uploadservice.schemehandlers;

import android.content.Context;
import java.io.InputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "", "contentType", "", "context", "Landroid/content/Context;", "delete", "", "init", "", "path", "name", "size", "", "stream", "Ljava/io/InputStream;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SchemeHandler.kt */
public interface SchemeHandler {
    String contentType(Context context);

    boolean delete(Context context);

    void init(String str);

    String name(Context context);

    long size(Context context);

    InputStream stream(Context context);
}
