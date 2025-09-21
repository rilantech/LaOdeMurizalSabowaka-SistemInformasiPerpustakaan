package net.gotev.uploadservice.data;

import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.network.ServerResponse;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\u0006\u0010\u001f\u001a\u00020 J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lnet/gotev/uploadservice/data/BroadcastData;", "Landroid/os/Parcelable;", "status", "Lnet/gotev/uploadservice/data/UploadStatus;", "uploadInfo", "Lnet/gotev/uploadservice/data/UploadInfo;", "serverResponse", "Lnet/gotev/uploadservice/network/ServerResponse;", "exception", "", "(Lnet/gotev/uploadservice/data/UploadStatus;Lnet/gotev/uploadservice/data/UploadInfo;Lnet/gotev/uploadservice/network/ServerResponse;Ljava/lang/Throwable;)V", "getException", "()Ljava/lang/Throwable;", "getServerResponse", "()Lnet/gotev/uploadservice/network/ServerResponse;", "getStatus", "()Lnet/gotev/uploadservice/data/UploadStatus;", "getUploadInfo", "()Lnet/gotev/uploadservice/data/UploadInfo;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toIntent", "Landroid/content/Intent;", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BroadcastData.kt */
public final class BroadcastData implements Parcelable {
    public static final Parcelable.Creator<BroadcastData> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String paramName = "broadcastData";
    private final Throwable exception;
    private final ServerResponse serverResponse;
    private final UploadStatus status;
    private final UploadInfo uploadInfo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BroadcastData.kt */
    public static final class Creator implements Parcelable.Creator<BroadcastData> {
        public final BroadcastData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BroadcastData(UploadStatus.valueOf(parcel.readString()), UploadInfo.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ServerResponse.CREATOR.createFromParcel(parcel), (Throwable) parcel.readSerializable());
        }

        public final BroadcastData[] newArray(int i) {
            return new BroadcastData[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BroadcastData(UploadStatus uploadStatus, UploadInfo uploadInfo2) {
        this(uploadStatus, uploadInfo2, (ServerResponse) null, (Throwable) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(uploadStatus, NotificationCompat.CATEGORY_STATUS);
        Intrinsics.checkNotNullParameter(uploadInfo2, "uploadInfo");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BroadcastData(UploadStatus uploadStatus, UploadInfo uploadInfo2, ServerResponse serverResponse2) {
        this(uploadStatus, uploadInfo2, serverResponse2, (Throwable) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(uploadStatus, NotificationCompat.CATEGORY_STATUS);
        Intrinsics.checkNotNullParameter(uploadInfo2, "uploadInfo");
    }

    public static /* synthetic */ BroadcastData copy$default(BroadcastData broadcastData, UploadStatus uploadStatus, UploadInfo uploadInfo2, ServerResponse serverResponse2, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            uploadStatus = broadcastData.status;
        }
        if ((i & 2) != 0) {
            uploadInfo2 = broadcastData.uploadInfo;
        }
        if ((i & 4) != 0) {
            serverResponse2 = broadcastData.serverResponse;
        }
        if ((i & 8) != 0) {
            th = broadcastData.exception;
        }
        return broadcastData.copy(uploadStatus, uploadInfo2, serverResponse2, th);
    }

    public final UploadStatus component1() {
        return this.status;
    }

    public final UploadInfo component2() {
        return this.uploadInfo;
    }

    public final ServerResponse component3() {
        return this.serverResponse;
    }

    public final Throwable component4() {
        return this.exception;
    }

    public final BroadcastData copy(UploadStatus uploadStatus, UploadInfo uploadInfo2, ServerResponse serverResponse2, Throwable th) {
        Intrinsics.checkNotNullParameter(uploadStatus, NotificationCompat.CATEGORY_STATUS);
        Intrinsics.checkNotNullParameter(uploadInfo2, "uploadInfo");
        return new BroadcastData(uploadStatus, uploadInfo2, serverResponse2, th);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BroadcastData)) {
            return false;
        }
        BroadcastData broadcastData = (BroadcastData) obj;
        return this.status == broadcastData.status && Intrinsics.areEqual((Object) this.uploadInfo, (Object) broadcastData.uploadInfo) && Intrinsics.areEqual((Object) this.serverResponse, (Object) broadcastData.serverResponse) && Intrinsics.areEqual((Object) this.exception, (Object) broadcastData.exception);
    }

    public int hashCode() {
        int hashCode = ((this.status.hashCode() * 31) + this.uploadInfo.hashCode()) * 31;
        ServerResponse serverResponse2 = this.serverResponse;
        int i = 0;
        int hashCode2 = (hashCode + (serverResponse2 == null ? 0 : serverResponse2.hashCode())) * 31;
        Throwable th = this.exception;
        if (th != null) {
            i = th.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        UploadStatus uploadStatus = this.status;
        UploadInfo uploadInfo2 = this.uploadInfo;
        ServerResponse serverResponse2 = this.serverResponse;
        return "BroadcastData(status=" + uploadStatus + ", uploadInfo=" + uploadInfo2 + ", serverResponse=" + serverResponse2 + ", exception=" + this.exception + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.status.name());
        this.uploadInfo.writeToParcel(parcel, i);
        ServerResponse serverResponse2 = this.serverResponse;
        if (serverResponse2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            serverResponse2.writeToParcel(parcel, i);
        }
        parcel.writeSerializable(this.exception);
    }

    public BroadcastData(UploadStatus status2, UploadInfo uploadInfo2, ServerResponse serverResponse2, Throwable exception2) {
        Intrinsics.checkNotNullParameter(status2, NotificationCompat.CATEGORY_STATUS);
        Intrinsics.checkNotNullParameter(uploadInfo2, "uploadInfo");
        this.status = status2;
        this.uploadInfo = uploadInfo2;
        this.serverResponse = serverResponse2;
        this.exception = exception2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BroadcastData(UploadStatus uploadStatus, UploadInfo uploadInfo2, ServerResponse serverResponse2, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uploadStatus, uploadInfo2, (i & 4) != 0 ? null : serverResponse2, (i & 8) != 0 ? null : th);
    }

    public final UploadStatus getStatus() {
        return this.status;
    }

    public final UploadInfo getUploadInfo() {
        return this.uploadInfo;
    }

    public final ServerResponse getServerResponse() {
        return this.serverResponse;
    }

    public final Throwable getException() {
        return this.exception;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lnet/gotev/uploadservice/data/BroadcastData$Companion;", "", "()V", "paramName", "", "fromIntent", "Lnet/gotev/uploadservice/data/BroadcastData;", "intent", "Landroid/content/Intent;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BroadcastData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BroadcastData fromIntent(Intent intent) {
            Parcelable parcelable;
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intent $this$parcelableCompat$iv = intent;
            if (Build.VERSION.SDK_INT >= 34) {
                parcelable = (Parcelable) $this$parcelableCompat$iv.getParcelableExtra(BroadcastData.paramName, BroadcastData.class);
            } else {
                Parcelable parcelableExtra = $this$parcelableCompat$iv.getParcelableExtra(BroadcastData.paramName);
                if (!(parcelableExtra instanceof BroadcastData)) {
                    parcelableExtra = null;
                }
                parcelable = (BroadcastData) parcelableExtra;
            }
            return (BroadcastData) parcelable;
        }
    }

    public final Intent toIntent() {
        Intent intent = new Intent(UploadServiceConfig.getBroadcastStatusAction());
        Intent $this$toIntent_u24lambda_u240 = intent;
        $this$toIntent_u24lambda_u240.setPackage(UploadServiceConfig.getNamespace());
        $this$toIntent_u24lambda_u240.putExtra(paramName, this);
        return intent;
    }
}
