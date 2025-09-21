package net.gotev.uploadservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.UploadRate;
import net.gotev.uploadservice.data.UploadTaskParameters;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JK\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\t\u00100\u001a\u00020\tHÖ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\tHÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\tHÖ\u0001R\u0017\u0010\u000e\u001a\u00020\u000f8F¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u00020\t8F¢\u0006\f\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\u00020\t8F¢\u0006\f\u0012\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\u00020$8F¢\u0006\f\u0012\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010'R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001c¨\u0006<"}, d2 = {"Lnet/gotev/uploadservice/data/UploadInfo;", "Landroid/os/Parcelable;", "uploadId", "", "startTime", "", "uploadedBytes", "totalBytes", "numberOfRetries", "", "files", "Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/data/UploadFile;", "(Ljava/lang/String;JJJILjava/util/ArrayList;)V", "elapsedTime", "Lnet/gotev/uploadservice/data/UploadElapsedTime;", "getElapsedTime$annotations", "()V", "getElapsedTime", "()Lnet/gotev/uploadservice/data/UploadElapsedTime;", "getFiles", "()Ljava/util/ArrayList;", "getNumberOfRetries", "()I", "progressPercent", "getProgressPercent$annotations", "getProgressPercent", "getStartTime", "()J", "successfullyUploadedFiles", "getSuccessfullyUploadedFiles$annotations", "getSuccessfullyUploadedFiles", "getTotalBytes", "getUploadId", "()Ljava/lang/String;", "uploadRate", "Lnet/gotev/uploadservice/data/UploadRate;", "getUploadRate$annotations", "getUploadRate", "()Lnet/gotev/uploadservice/data/UploadRate;", "getUploadedBytes", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadInfo.kt */
public final class UploadInfo implements Parcelable {
    public static final Parcelable.Creator<UploadInfo> CREATOR = new Creator();
    private final ArrayList<UploadFile> files;
    private final int numberOfRetries;
    private final long startTime;
    private final long totalBytes;
    private final String uploadId;
    private final long uploadedBytes;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UploadInfo.kt */
    public static final class Creator implements Parcelable.Creator<UploadInfo> {
        public final UploadInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            long readLong3 = parcel.readLong();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i != readInt2; i++) {
                arrayList.add(UploadFile.CREATOR.createFromParcel(parcel));
            }
            return new UploadInfo(readString, readLong, readLong2, readLong3, readInt, arrayList);
        }

        public final UploadInfo[] newArray(int i) {
            return new UploadInfo[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadInfo(String str) {
        this(str, 0, 0, 0, 0, (ArrayList) null, 62, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "uploadId");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadInfo(String str, long j) {
        this(str, j, 0, 0, 0, (ArrayList) null, 60, (DefaultConstructorMarker) null);
        String str2 = str;
        Intrinsics.checkNotNullParameter(str, "uploadId");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadInfo(String str, long j, long j2) {
        this(str, j, j2, 0, 0, (ArrayList) null, 56, (DefaultConstructorMarker) null);
        String str2 = str;
        Intrinsics.checkNotNullParameter(str, "uploadId");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadInfo(String str, long j, long j2, long j3) {
        this(str, j, j2, j3, 0, (ArrayList) null, 48, (DefaultConstructorMarker) null);
        String str2 = str;
        Intrinsics.checkNotNullParameter(str, "uploadId");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadInfo(String str, long j, long j2, long j3, int i) {
        this(str, j, j2, j3, i, (ArrayList) null, 32, (DefaultConstructorMarker) null);
        String str2 = str;
        Intrinsics.checkNotNullParameter(str, "uploadId");
    }

    public static /* synthetic */ UploadInfo copy$default(UploadInfo uploadInfo, String str, long j, long j2, long j3, int i, ArrayList arrayList, int i2, Object obj) {
        UploadInfo uploadInfo2 = uploadInfo;
        return uploadInfo.copy((i2 & 1) != 0 ? uploadInfo2.uploadId : str, (i2 & 2) != 0 ? uploadInfo2.startTime : j, (i2 & 4) != 0 ? uploadInfo2.uploadedBytes : j2, (i2 & 8) != 0 ? uploadInfo2.totalBytes : j3, (i2 & 16) != 0 ? uploadInfo2.numberOfRetries : i, (i2 & 32) != 0 ? uploadInfo2.files : arrayList);
    }

    public static /* synthetic */ void getElapsedTime$annotations() {
    }

    public static /* synthetic */ void getProgressPercent$annotations() {
    }

    public static /* synthetic */ void getSuccessfullyUploadedFiles$annotations() {
    }

    public static /* synthetic */ void getUploadRate$annotations() {
    }

    public final String component1() {
        return this.uploadId;
    }

    public final long component2() {
        return this.startTime;
    }

    public final long component3() {
        return this.uploadedBytes;
    }

    public final long component4() {
        return this.totalBytes;
    }

    public final int component5() {
        return this.numberOfRetries;
    }

    public final ArrayList<UploadFile> component6() {
        return this.files;
    }

    public final UploadInfo copy(String str, long j, long j2, long j3, int i, ArrayList<UploadFile> arrayList) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str, "uploadId");
        Intrinsics.checkNotNullParameter(arrayList, UploadTaskParameters.Companion.CodingKeys.files);
        return new UploadInfo(str, j, j2, j3, i, arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadInfo)) {
            return false;
        }
        UploadInfo uploadInfo = (UploadInfo) obj;
        return Intrinsics.areEqual((Object) this.uploadId, (Object) uploadInfo.uploadId) && this.startTime == uploadInfo.startTime && this.uploadedBytes == uploadInfo.uploadedBytes && this.totalBytes == uploadInfo.totalBytes && this.numberOfRetries == uploadInfo.numberOfRetries && Intrinsics.areEqual((Object) this.files, (Object) uploadInfo.files);
    }

    public int hashCode() {
        return (((((((((this.uploadId.hashCode() * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.uploadedBytes)) * 31) + Long.hashCode(this.totalBytes)) * 31) + Integer.hashCode(this.numberOfRetries)) * 31) + this.files.hashCode();
    }

    public String toString() {
        String str = this.uploadId;
        long j = this.startTime;
        long j2 = this.uploadedBytes;
        long j3 = this.totalBytes;
        int i = this.numberOfRetries;
        return "UploadInfo(uploadId=" + str + ", startTime=" + j + ", uploadedBytes=" + j2 + ", totalBytes=" + j3 + ", numberOfRetries=" + i + ", files=" + this.files + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.uploadId);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.uploadedBytes);
        parcel.writeLong(this.totalBytes);
        parcel.writeInt(this.numberOfRetries);
        ArrayList<UploadFile> arrayList = this.files;
        parcel.writeInt(arrayList.size());
        Iterator<UploadFile> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, i);
        }
    }

    public UploadInfo(String uploadId2, long startTime2, long uploadedBytes2, long totalBytes2, int numberOfRetries2, ArrayList<UploadFile> files2) {
        Intrinsics.checkNotNullParameter(uploadId2, "uploadId");
        Intrinsics.checkNotNullParameter(files2, UploadTaskParameters.Companion.CodingKeys.files);
        this.uploadId = uploadId2;
        this.startTime = startTime2;
        this.uploadedBytes = uploadedBytes2;
        this.totalBytes = totalBytes2;
        this.numberOfRetries = numberOfRetries2;
        this.files = files2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UploadInfo(java.lang.String r9, long r10, long r12, long r14, int r16, java.util.ArrayList r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r8 = this;
            r0 = r18 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r10
        L_0x0009:
            r0 = r18 & 4
            if (r0 == 0) goto L_0x000f
            r5 = r1
            goto L_0x0010
        L_0x000f:
            r5 = r12
        L_0x0010:
            r0 = r18 & 8
            if (r0 == 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r1 = r14
        L_0x0016:
            r0 = r18 & 16
            if (r0 == 0) goto L_0x001c
            r0 = 0
            goto L_0x001e
        L_0x001c:
            r0 = r16
        L_0x001e:
            r7 = r18 & 32
            if (r7 == 0) goto L_0x0028
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            goto L_0x002a
        L_0x0028:
            r7 = r17
        L_0x002a:
            r10 = r8
            r11 = r9
            r12 = r3
            r14 = r5
            r16 = r1
            r18 = r0
            r19 = r7
            r10.<init>(r11, r12, r14, r16, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.data.UploadInfo.<init>(java.lang.String, long, long, long, int, java.util.ArrayList, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getUploadId() {
        return this.uploadId;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final long getUploadedBytes() {
        return this.uploadedBytes;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final int getNumberOfRetries() {
        return this.numberOfRetries;
    }

    public final ArrayList<UploadFile> getFiles() {
        return this.files;
    }

    public final UploadElapsedTime getElapsedTime() {
        int seconds = (int) ((new Date().getTime() - this.startTime) / ((long) 1000));
        int minutes = seconds / 60;
        return new UploadElapsedTime(minutes, seconds - (minutes * 60));
    }

    public final UploadRate getUploadRate() {
        double kilobitPerSecond;
        int elapsedSeconds = getElapsedTime().getTotalSeconds();
        if (elapsedSeconds < 1) {
            kilobitPerSecond = 0.0d;
        } else {
            kilobitPerSecond = ((((double) this.uploadedBytes) / ((double) 1000)) * ((double) 8)) / ((double) elapsedSeconds);
        }
        if (kilobitPerSecond < 1.0d) {
            return new UploadRate((int) (((double) 1000) * kilobitPerSecond), UploadRate.UploadRateUnit.BitPerSecond);
        }
        if (kilobitPerSecond >= 1000.0d) {
            return new UploadRate((int) (kilobitPerSecond / ((double) 1000)), UploadRate.UploadRateUnit.MegabitPerSecond);
        }
        return new UploadRate((int) kilobitPerSecond, UploadRate.UploadRateUnit.KilobitPerSecond);
    }

    public final int getProgressPercent() {
        long j = this.totalBytes;
        if (j == 0) {
            return 0;
        }
        return (int) ((this.uploadedBytes * ((long) 100)) / j);
    }

    public final int getSuccessfullyUploadedFiles() {
        Iterable<UploadFile> $this$count$iv = this.files;
        if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
            return 0;
        }
        int count$iv = 0;
        for (UploadFile it : $this$count$iv) {
            if (it.getSuccessfullyUploaded() && (count$iv = count$iv + 1) < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return count$iv;
    }
}
