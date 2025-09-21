package net.gotev.uploadservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
import net.gotev.uploadservice.persistence.Persistable;
import net.gotev.uploadservice.persistence.PersistableData;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0000J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001e"}, d2 = {"Lnet/gotev/uploadservice/data/NameValue;", "Landroid/os/Parcelable;", "Lnet/gotev/uploadservice/persistence/Persistable;", "name", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toPersistableData", "Lnet/gotev/uploadservice/persistence/PersistableData;", "toString", "validateAsHeader", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NameValue.kt */
public final class NameValue implements Parcelable, Persistable {
    public static final Parcelable.Creator<NameValue> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String name;
    private final String value;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NameValue.kt */
    public static final class Creator implements Parcelable.Creator<NameValue> {
        public final NameValue createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NameValue(parcel.readString(), parcel.readString());
        }

        public final NameValue[] newArray(int i) {
            return new NameValue[i];
        }
    }

    public static /* synthetic */ NameValue copy$default(NameValue nameValue, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nameValue.name;
        }
        if ((i & 2) != 0) {
            str2 = nameValue.value;
        }
        return nameValue.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.value;
    }

    public final NameValue copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, Companion.CodingKeys.name);
        Intrinsics.checkNotNullParameter(str2, Companion.CodingKeys.value);
        return new NameValue(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NameValue)) {
            return false;
        }
        NameValue nameValue = (NameValue) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) nameValue.name) && Intrinsics.areEqual((Object) this.value, (Object) nameValue.value);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        String str = this.name;
        return "NameValue(name=" + str + ", value=" + this.value + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.value);
    }

    public NameValue(String name2, String value2) {
        Intrinsics.checkNotNullParameter(name2, Companion.CodingKeys.name);
        Intrinsics.checkNotNullParameter(value2, Companion.CodingKeys.value);
        this.name = name2;
        this.value = value2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public final NameValue validateAsHeader() {
        if (StringExtensionsKt.isASCII(this.name) && StringExtensionsKt.isASCII(this.value)) {
            return this;
        }
        throw new IllegalArgumentException(("Header " + this.name + " and its value " + this.value + " must be ASCII only! Read http://stackoverflow.com/a/4410331").toString());
    }

    public PersistableData toPersistableData() {
        PersistableData persistableData = new PersistableData();
        PersistableData $this$toPersistableData_u24lambda_u241 = persistableData;
        $this$toPersistableData_u24lambda_u241.putString(Companion.CodingKeys.name, this.name);
        $this$toPersistableData_u24lambda_u241.putString(Companion.CodingKeys.value, this.value);
        return persistableData;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lnet/gotev/uploadservice/data/NameValue$Companion;", "Lnet/gotev/uploadservice/persistence/Persistable$Creator;", "Lnet/gotev/uploadservice/data/NameValue;", "()V", "createFromPersistableData", "data", "Lnet/gotev/uploadservice/persistence/PersistableData;", "CodingKeys", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NameValue.kt */
    public static final class Companion implements Persistable.Creator<NameValue> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lnet/gotev/uploadservice/data/NameValue$Companion$CodingKeys;", "", "()V", "name", "", "value", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: NameValue.kt */
        private static final class CodingKeys {
            public static final CodingKeys INSTANCE = new CodingKeys();
            public static final String name = "name";
            public static final String value = "value";

            private CodingKeys() {
            }
        }

        private Companion() {
        }

        public NameValue createFromPersistableData(PersistableData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new NameValue(data.getString(CodingKeys.name), data.getString(CodingKeys.value));
        }
    }
}
