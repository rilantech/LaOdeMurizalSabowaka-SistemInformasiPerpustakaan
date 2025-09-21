package net.gotev.uploadservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u001b"}, d2 = {"Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "Landroid/os/Parcelable;", "notificationChannelId", "", "isRingToneEnabled", "", "progress", "Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "success", "error", "cancelled", "(Ljava/lang/String;ZLnet/gotev/uploadservice/data/UploadNotificationStatusConfig;Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;)V", "getCancelled", "()Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "getError", "()Z", "getNotificationChannelId", "()Ljava/lang/String;", "getProgress", "getSuccess", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadNotificationConfig.kt */
public final class UploadNotificationConfig implements Parcelable {
    public static final Parcelable.Creator<UploadNotificationConfig> CREATOR = new Creator();
    private final UploadNotificationStatusConfig cancelled;
    private final UploadNotificationStatusConfig error;
    private final boolean isRingToneEnabled;
    private final String notificationChannelId;
    private final UploadNotificationStatusConfig progress;
    private final UploadNotificationStatusConfig success;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UploadNotificationConfig.kt */
    public static final class Creator implements Parcelable.Creator<UploadNotificationConfig> {
        public final UploadNotificationConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UploadNotificationConfig(parcel.readString(), parcel.readInt() != 0, UploadNotificationStatusConfig.CREATOR.createFromParcel(parcel), UploadNotificationStatusConfig.CREATOR.createFromParcel(parcel), UploadNotificationStatusConfig.CREATOR.createFromParcel(parcel), UploadNotificationStatusConfig.CREATOR.createFromParcel(parcel));
        }

        public final UploadNotificationConfig[] newArray(int i) {
            return new UploadNotificationConfig[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.notificationChannelId);
        parcel.writeInt(this.isRingToneEnabled ? 1 : 0);
        this.progress.writeToParcel(parcel, i);
        this.success.writeToParcel(parcel, i);
        this.error.writeToParcel(parcel, i);
        this.cancelled.writeToParcel(parcel, i);
    }

    public UploadNotificationConfig(String notificationChannelId2, boolean isRingToneEnabled2, UploadNotificationStatusConfig progress2, UploadNotificationStatusConfig success2, UploadNotificationStatusConfig error2, UploadNotificationStatusConfig cancelled2) {
        Intrinsics.checkNotNullParameter(notificationChannelId2, "notificationChannelId");
        Intrinsics.checkNotNullParameter(progress2, "progress");
        Intrinsics.checkNotNullParameter(success2, "success");
        Intrinsics.checkNotNullParameter(error2, "error");
        Intrinsics.checkNotNullParameter(cancelled2, "cancelled");
        this.notificationChannelId = notificationChannelId2;
        this.isRingToneEnabled = isRingToneEnabled2;
        this.progress = progress2;
        this.success = success2;
        this.error = error2;
        this.cancelled = cancelled2;
    }

    public final String getNotificationChannelId() {
        return this.notificationChannelId;
    }

    public final boolean isRingToneEnabled() {
        return this.isRingToneEnabled;
    }

    public final UploadNotificationStatusConfig getProgress() {
        return this.progress;
    }

    public final UploadNotificationStatusConfig getSuccess() {
        return this.success;
    }

    public final UploadNotificationStatusConfig getError() {
        return this.error;
    }

    public final UploadNotificationStatusConfig getCancelled() {
        return this.cancelled;
    }
}
