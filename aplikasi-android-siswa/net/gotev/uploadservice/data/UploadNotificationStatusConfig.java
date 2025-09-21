package net.gotev.uploadservice.data;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.PointerIconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.extensions.ContextExtensionsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bs\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u0010,\u001a\u00020\u0010HÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003Jy\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010/\u001a\u00020\u0006HÖ\u0001J\u0013\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u00103\u001a\u000204J\t\u00105\u001a\u00020\u0006HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!¨\u0006<"}, d2 = {"Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "Landroid/os/Parcelable;", "title", "", "message", "iconResourceID", "", "iconColorResourceID", "largeIcon", "Landroid/graphics/Bitmap;", "clickIntent", "Landroid/app/PendingIntent;", "actions", "Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/data/UploadNotificationAction;", "clearOnAction", "", "autoClear", "onDismissed", "(Ljava/lang/String;Ljava/lang/String;IILandroid/graphics/Bitmap;Landroid/app/PendingIntent;Ljava/util/ArrayList;ZZLandroid/app/PendingIntent;)V", "getActions", "()Ljava/util/ArrayList;", "getAutoClear", "()Z", "getClearOnAction", "getClickIntent", "()Landroid/app/PendingIntent;", "getIconColorResourceID", "()I", "getIconResourceID", "getLargeIcon", "()Landroid/graphics/Bitmap;", "getMessage", "()Ljava/lang/String;", "getOnDismissed", "getTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "context", "Landroid/content/Context;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadNotificationStatusConfig.kt */
public final class UploadNotificationStatusConfig implements Parcelable {
    public static final Parcelable.Creator<UploadNotificationStatusConfig> CREATOR = new Creator();
    private final ArrayList<UploadNotificationAction> actions;
    private final boolean autoClear;
    private final boolean clearOnAction;
    private final PendingIntent clickIntent;
    private final int iconColorResourceID;
    private final int iconResourceID;
    private final Bitmap largeIcon;
    private final String message;
    private final PendingIntent onDismissed;
    private final String title;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UploadNotificationStatusConfig.kt */
    public static final class Creator implements Parcelable.Creator<UploadNotificationStatusConfig> {
        public final UploadNotificationStatusConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            Bitmap bitmap = (Bitmap) parcel.readParcelable(UploadNotificationStatusConfig.class.getClassLoader());
            PendingIntent pendingIntent = (PendingIntent) parcel.readParcelable(UploadNotificationStatusConfig.class.getClassLoader());
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i != readInt3; i++) {
                arrayList.add(UploadNotificationAction.CREATOR.createFromParcel(parcel));
            }
            return new UploadNotificationStatusConfig(readString, readString2, readInt, readInt2, bitmap, pendingIntent, arrayList, parcel.readInt() != 0, parcel.readInt() != 0, (PendingIntent) parcel.readParcelable(UploadNotificationStatusConfig.class.getClassLoader()));
        }

        public final UploadNotificationStatusConfig[] newArray(int i) {
            return new UploadNotificationStatusConfig[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadNotificationStatusConfig(String str, String str2) {
        this(str, str2, 0, 0, (Bitmap) null, (PendingIntent) null, (ArrayList) null, false, false, (PendingIntent) null, PointerIconCompat.TYPE_GRAB, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadNotificationStatusConfig(String str, String str2, int i) {
        this(str, str2, i, 0, (Bitmap) null, (PendingIntent) null, (ArrayList) null, false, false, (PendingIntent) null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadNotificationStatusConfig(String str, String str2, int i, int i2) {
        this(str, str2, i, i2, (Bitmap) null, (PendingIntent) null, (ArrayList) null, false, false, (PendingIntent) null, PointerIconCompat.TYPE_TEXT, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadNotificationStatusConfig(String str, String str2, int i, int i2, Bitmap bitmap) {
        this(str, str2, i, i2, bitmap, (PendingIntent) null, (ArrayList) null, false, false, (PendingIntent) null, 992, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadNotificationStatusConfig(String str, String str2, int i, int i2, Bitmap bitmap, PendingIntent pendingIntent) {
        this(str, str2, i, i2, bitmap, pendingIntent, (ArrayList) null, false, false, (PendingIntent) null, 960, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadNotificationStatusConfig(String str, String str2, int i, int i2, Bitmap bitmap, PendingIntent pendingIntent, ArrayList<UploadNotificationAction> arrayList) {
        this(str, str2, i, i2, bitmap, pendingIntent, arrayList, false, false, (PendingIntent) null, 896, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(arrayList, "actions");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadNotificationStatusConfig(String str, String str2, int i, int i2, Bitmap bitmap, PendingIntent pendingIntent, ArrayList<UploadNotificationAction> arrayList, boolean z) {
        this(str, str2, i, i2, bitmap, pendingIntent, arrayList, z, false, (PendingIntent) null, 768, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(arrayList, "actions");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadNotificationStatusConfig(String str, String str2, int i, int i2, Bitmap bitmap, PendingIntent pendingIntent, ArrayList<UploadNotificationAction> arrayList, boolean z, boolean z2) {
        this(str, str2, i, i2, bitmap, pendingIntent, arrayList, z, z2, (PendingIntent) null, 512, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(arrayList, "actions");
    }

    public static /* synthetic */ UploadNotificationStatusConfig copy$default(UploadNotificationStatusConfig uploadNotificationStatusConfig, String str, String str2, int i, int i2, Bitmap bitmap, PendingIntent pendingIntent, ArrayList arrayList, boolean z, boolean z2, PendingIntent pendingIntent2, int i3, Object obj) {
        UploadNotificationStatusConfig uploadNotificationStatusConfig2 = uploadNotificationStatusConfig;
        int i4 = i3;
        return uploadNotificationStatusConfig.copy((i4 & 1) != 0 ? uploadNotificationStatusConfig2.title : str, (i4 & 2) != 0 ? uploadNotificationStatusConfig2.message : str2, (i4 & 4) != 0 ? uploadNotificationStatusConfig2.iconResourceID : i, (i4 & 8) != 0 ? uploadNotificationStatusConfig2.iconColorResourceID : i2, (i4 & 16) != 0 ? uploadNotificationStatusConfig2.largeIcon : bitmap, (i4 & 32) != 0 ? uploadNotificationStatusConfig2.clickIntent : pendingIntent, (i4 & 64) != 0 ? uploadNotificationStatusConfig2.actions : arrayList, (i4 & 128) != 0 ? uploadNotificationStatusConfig2.clearOnAction : z, (i4 & 256) != 0 ? uploadNotificationStatusConfig2.autoClear : z2, (i4 & 512) != 0 ? uploadNotificationStatusConfig2.onDismissed : pendingIntent2);
    }

    public final String component1() {
        return this.title;
    }

    public final PendingIntent component10() {
        return this.onDismissed;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.iconResourceID;
    }

    public final int component4() {
        return this.iconColorResourceID;
    }

    public final Bitmap component5() {
        return this.largeIcon;
    }

    public final PendingIntent component6() {
        return this.clickIntent;
    }

    public final ArrayList<UploadNotificationAction> component7() {
        return this.actions;
    }

    public final boolean component8() {
        return this.clearOnAction;
    }

    public final boolean component9() {
        return this.autoClear;
    }

    public final UploadNotificationStatusConfig copy(String str, String str2, int i, int i2, Bitmap bitmap, PendingIntent pendingIntent, ArrayList<UploadNotificationAction> arrayList, boolean z, boolean z2, PendingIntent pendingIntent2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(arrayList, "actions");
        return new UploadNotificationStatusConfig(str, str2, i, i2, bitmap, pendingIntent, arrayList, z, z2, pendingIntent2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadNotificationStatusConfig)) {
            return false;
        }
        UploadNotificationStatusConfig uploadNotificationStatusConfig = (UploadNotificationStatusConfig) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) uploadNotificationStatusConfig.title) && Intrinsics.areEqual((Object) this.message, (Object) uploadNotificationStatusConfig.message) && this.iconResourceID == uploadNotificationStatusConfig.iconResourceID && this.iconColorResourceID == uploadNotificationStatusConfig.iconColorResourceID && Intrinsics.areEqual((Object) this.largeIcon, (Object) uploadNotificationStatusConfig.largeIcon) && Intrinsics.areEqual((Object) this.clickIntent, (Object) uploadNotificationStatusConfig.clickIntent) && Intrinsics.areEqual((Object) this.actions, (Object) uploadNotificationStatusConfig.actions) && this.clearOnAction == uploadNotificationStatusConfig.clearOnAction && this.autoClear == uploadNotificationStatusConfig.autoClear && Intrinsics.areEqual((Object) this.onDismissed, (Object) uploadNotificationStatusConfig.onDismissed);
    }

    public int hashCode() {
        int hashCode = ((((((this.title.hashCode() * 31) + this.message.hashCode()) * 31) + Integer.hashCode(this.iconResourceID)) * 31) + Integer.hashCode(this.iconColorResourceID)) * 31;
        Bitmap bitmap = this.largeIcon;
        int i = 0;
        int hashCode2 = (hashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
        PendingIntent pendingIntent = this.clickIntent;
        int hashCode3 = (((hashCode2 + (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 31) + this.actions.hashCode()) * 31;
        boolean z = this.clearOnAction;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        boolean z3 = this.autoClear;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        PendingIntent pendingIntent2 = this.onDismissed;
        if (pendingIntent2 != null) {
            i = pendingIntent2.hashCode();
        }
        return i3 + i;
    }

    public String toString() {
        String str = this.title;
        String str2 = this.message;
        int i = this.iconResourceID;
        int i2 = this.iconColorResourceID;
        Bitmap bitmap = this.largeIcon;
        PendingIntent pendingIntent = this.clickIntent;
        ArrayList<UploadNotificationAction> arrayList = this.actions;
        boolean z = this.clearOnAction;
        boolean z2 = this.autoClear;
        return "UploadNotificationStatusConfig(title=" + str + ", message=" + str2 + ", iconResourceID=" + i + ", iconColorResourceID=" + i2 + ", largeIcon=" + bitmap + ", clickIntent=" + pendingIntent + ", actions=" + arrayList + ", clearOnAction=" + z + ", autoClear=" + z2 + ", onDismissed=" + this.onDismissed + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.message);
        parcel.writeInt(this.iconResourceID);
        parcel.writeInt(this.iconColorResourceID);
        parcel.writeParcelable(this.largeIcon, i);
        parcel.writeParcelable(this.clickIntent, i);
        ArrayList<UploadNotificationAction> arrayList = this.actions;
        parcel.writeInt(arrayList.size());
        Iterator<UploadNotificationAction> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, i);
        }
        parcel.writeInt(this.clearOnAction ? 1 : 0);
        parcel.writeInt(this.autoClear ? 1 : 0);
        parcel.writeParcelable(this.onDismissed, i);
    }

    public UploadNotificationStatusConfig(String title2, String message2, int iconResourceID2, int iconColorResourceID2, Bitmap largeIcon2, PendingIntent clickIntent2, ArrayList<UploadNotificationAction> actions2, boolean clearOnAction2, boolean autoClear2, PendingIntent onDismissed2) {
        Intrinsics.checkNotNullParameter(title2, "title");
        Intrinsics.checkNotNullParameter(message2, "message");
        Intrinsics.checkNotNullParameter(actions2, "actions");
        this.title = title2;
        this.message = message2;
        this.iconResourceID = iconResourceID2;
        this.iconColorResourceID = iconColorResourceID2;
        this.largeIcon = largeIcon2;
        this.clickIntent = clickIntent2;
        this.actions = actions2;
        this.clearOnAction = clearOnAction2;
        this.autoClear = autoClear2;
        this.onDismissed = onDismissed2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UploadNotificationStatusConfig(java.lang.String r14, java.lang.String r15, int r16, int r17, android.graphics.Bitmap r18, android.app.PendingIntent r19, java.util.ArrayList r20, boolean r21, boolean r22, android.app.PendingIntent r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 4
            if (r1 == 0) goto L_0x000b
            r1 = 17301589(0x1080055, float:2.4979493E-38)
            r5 = r1
            goto L_0x000d
        L_0x000b:
            r5 = r16
        L_0x000d:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r6 = r2
            goto L_0x0016
        L_0x0014:
            r6 = r17
        L_0x0016:
            r1 = r0 & 16
            r3 = 0
            if (r1 == 0) goto L_0x001d
            r7 = r3
            goto L_0x001f
        L_0x001d:
            r7 = r18
        L_0x001f:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0025
            r8 = r3
            goto L_0x0027
        L_0x0025:
            r8 = r19
        L_0x0027:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0033
            java.util.ArrayList r1 = new java.util.ArrayList
            r4 = 3
            r1.<init>(r4)
            r9 = r1
            goto L_0x0035
        L_0x0033:
            r9 = r20
        L_0x0035:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x003b
            r10 = r2
            goto L_0x003d
        L_0x003b:
            r10 = r21
        L_0x003d:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0043
            r11 = r2
            goto L_0x0045
        L_0x0043:
            r11 = r22
        L_0x0045:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004b
            r12 = r3
            goto L_0x004d
        L_0x004b:
            r12 = r23
        L_0x004d:
            r2 = r13
            r3 = r14
            r4 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.data.UploadNotificationStatusConfig.<init>(java.lang.String, java.lang.String, int, int, android.graphics.Bitmap, android.app.PendingIntent, java.util.ArrayList, boolean, boolean, android.app.PendingIntent, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getIconResourceID() {
        return this.iconResourceID;
    }

    public final int getIconColorResourceID() {
        return this.iconColorResourceID;
    }

    public final Bitmap getLargeIcon() {
        return this.largeIcon;
    }

    public final PendingIntent getClickIntent() {
        return this.clickIntent;
    }

    public final ArrayList<UploadNotificationAction> getActions() {
        return this.actions;
    }

    public final boolean getClearOnAction() {
        return this.clearOnAction;
    }

    public final boolean getAutoClear() {
        return this.autoClear;
    }

    public final PendingIntent getOnDismissed() {
        return this.onDismissed;
    }

    public final PendingIntent getClickIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PendingIntent pendingIntent = this.clickIntent;
        if (pendingIntent != null) {
            return pendingIntent;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(), ContextExtensionsKt.flagsCompat(134217728));
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(\n          …UPDATE_CURRENT)\n        )");
        return broadcast;
    }
}
