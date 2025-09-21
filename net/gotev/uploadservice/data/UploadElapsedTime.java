package net.gotev.uploadservice.data;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lnet/gotev/uploadservice/data/UploadElapsedTime;", "", "minutes", "", "seconds", "(II)V", "getMinutes", "()I", "getSeconds", "totalSeconds", "getTotalSeconds", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadElapsedTime.kt */
public final class UploadElapsedTime {
    private final int minutes;
    private final int seconds;

    public static /* synthetic */ UploadElapsedTime copy$default(UploadElapsedTime uploadElapsedTime, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = uploadElapsedTime.minutes;
        }
        if ((i3 & 2) != 0) {
            i2 = uploadElapsedTime.seconds;
        }
        return uploadElapsedTime.copy(i, i2);
    }

    public final int component1() {
        return this.minutes;
    }

    public final int component2() {
        return this.seconds;
    }

    public final UploadElapsedTime copy(int i, int i2) {
        return new UploadElapsedTime(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadElapsedTime)) {
            return false;
        }
        UploadElapsedTime uploadElapsedTime = (UploadElapsedTime) obj;
        return this.minutes == uploadElapsedTime.minutes && this.seconds == uploadElapsedTime.seconds;
    }

    public int hashCode() {
        return (Integer.hashCode(this.minutes) * 31) + Integer.hashCode(this.seconds);
    }

    public String toString() {
        int i = this.minutes;
        return "UploadElapsedTime(minutes=" + i + ", seconds=" + this.seconds + ")";
    }

    public UploadElapsedTime(int minutes2, int seconds2) {
        this.minutes = minutes2;
        this.seconds = seconds2;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    public final int getSeconds() {
        return this.seconds;
    }

    public final int getTotalSeconds() {
        return (this.minutes * 60) + this.seconds;
    }
}
