package net.gotev.uploadservice.placeholders;

import kotlin.Metadata;
import net.gotev.uploadservice.data.UploadInfo;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lnet/gotev/uploadservice/placeholders/PlaceholdersProcessor;", "", "processPlaceholders", "", "message", "uploadInfo", "Lnet/gotev/uploadservice/data/UploadInfo;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PlaceholdersProcessor.kt */
public interface PlaceholdersProcessor {
    String processPlaceholders(String str, UploadInfo uploadInfo);
}
