package net.gotev.uploadservice.placeholders;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lnet/gotev/uploadservice/placeholders/Placeholder;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toString", "ElapsedTime", "UploadRate", "Progress", "UploadedFiles", "RemainingFiles", "TotalFiles", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Placeholder.kt */
public enum Placeholder {
    ElapsedTime("[[ELAPSED_TIME]]"),
    UploadRate("[[UPLOAD_RATE]]"),
    Progress("[[PROGRESS]]"),
    UploadedFiles("[[UPLOADED_FILES]]"),
    RemainingFiles("[[REMAINING_FILES]]"),
    TotalFiles("[[TOTAL_FILES]]");
    
    private final String value;

    private Placeholder(String value2) {
        this.value = value2;
    }

    public final String getValue() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }
}
