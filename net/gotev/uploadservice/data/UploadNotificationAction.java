package net.gotev.uploadservice.data;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lnet/gotev/uploadservice/data/UploadNotificationAction;", "Landroid/os/Parcelable;", "icon", "", "title", "", "intent", "Landroid/app/PendingIntent;", "(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)V", "getIcon", "()I", "getIntent", "()Landroid/app/PendingIntent;", "getTitle", "()Ljava/lang/CharSequence;", "asAction", "Landroidx/core/app/NotificationCompat$Action;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadNotificationAction.kt */
public final class UploadNotificationAction implements Parcelable {
    public static final Parcelable.Creator<UploadNotificationAction> CREATOR = new Creator();
    private final int icon;
    private final PendingIntent intent;
    private final CharSequence title;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UploadNotificationAction.kt */
    public static final class Creator implements Parcelable.Creator<UploadNotificationAction> {
        public final UploadNotificationAction createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UploadNotificationAction(parcel.readInt(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (PendingIntent) parcel.readParcelable(UploadNotificationAction.class.getClassLoader()));
        }

        public final UploadNotificationAction[] newArray(int i) {
            return new UploadNotificationAction[i];
        }
    }

    public static /* synthetic */ UploadNotificationAction copy$default(UploadNotificationAction uploadNotificationAction, int i, CharSequence charSequence, PendingIntent pendingIntent, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = uploadNotificationAction.icon;
        }
        if ((i2 & 2) != 0) {
            charSequence = uploadNotificationAction.title;
        }
        if ((i2 & 4) != 0) {
            pendingIntent = uploadNotificationAction.intent;
        }
        return uploadNotificationAction.copy(i, charSequence, pendingIntent);
    }

    public final int component1() {
        return this.icon;
    }

    public final CharSequence component2() {
        return this.title;
    }

    public final PendingIntent component3() {
        return this.intent;
    }

    public final UploadNotificationAction copy(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        Intrinsics.checkNotNullParameter(pendingIntent, "intent");
        return new UploadNotificationAction(i, charSequence, pendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadNotificationAction)) {
            return false;
        }
        UploadNotificationAction uploadNotificationAction = (UploadNotificationAction) obj;
        return this.icon == uploadNotificationAction.icon && Intrinsics.areEqual((Object) this.title, (Object) uploadNotificationAction.title) && Intrinsics.areEqual((Object) this.intent, (Object) uploadNotificationAction.intent);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.icon) * 31) + this.title.hashCode()) * 31) + this.intent.hashCode();
    }

    public String toString() {
        int i = this.icon;
        CharSequence charSequence = this.title;
        return "UploadNotificationAction(icon=" + i + ", title=" + charSequence + ", intent=" + this.intent + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.icon);
        TextUtils.writeToParcel(this.title, parcel, i);
        parcel.writeParcelable(this.intent, i);
    }

    public UploadNotificationAction(int icon2, CharSequence title2, PendingIntent intent2) {
        Intrinsics.checkNotNullParameter(title2, "title");
        Intrinsics.checkNotNullParameter(intent2, "intent");
        this.icon = icon2;
        this.title = title2;
        this.intent = intent2;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final PendingIntent getIntent() {
        return this.intent;
    }

    public final NotificationCompat.Action asAction() {
        NotificationCompat.Action build = new NotificationCompat.Action.Builder(this.icon, this.title, this.intent).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(icon, title, intent).build()");
        return build;
    }
}
