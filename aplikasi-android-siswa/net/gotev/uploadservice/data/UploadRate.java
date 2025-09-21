package net.gotev.uploadservice.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lnet/gotev/uploadservice/data/UploadRate;", "", "value", "", "unit", "Lnet/gotev/uploadservice/data/UploadRate$UploadRateUnit;", "(ILnet/gotev/uploadservice/data/UploadRate$UploadRateUnit;)V", "getUnit", "()Lnet/gotev/uploadservice/data/UploadRate$UploadRateUnit;", "getValue", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "UploadRateUnit", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadRate.kt */
public final class UploadRate {
    private final UploadRateUnit unit;
    private final int value;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lnet/gotev/uploadservice/data/UploadRate$UploadRateUnit;", "", "(Ljava/lang/String;I)V", "BitPerSecond", "KilobitPerSecond", "MegabitPerSecond", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UploadRate.kt */
    public enum UploadRateUnit {
        BitPerSecond,
        KilobitPerSecond,
        MegabitPerSecond
    }

    public UploadRate() {
        this(0, (UploadRateUnit) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UploadRate copy$default(UploadRate uploadRate, int i, UploadRateUnit uploadRateUnit, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = uploadRate.value;
        }
        if ((i2 & 2) != 0) {
            uploadRateUnit = uploadRate.unit;
        }
        return uploadRate.copy(i, uploadRateUnit);
    }

    public final int component1() {
        return this.value;
    }

    public final UploadRateUnit component2() {
        return this.unit;
    }

    public final UploadRate copy(int i, UploadRateUnit uploadRateUnit) {
        Intrinsics.checkNotNullParameter(uploadRateUnit, "unit");
        return new UploadRate(i, uploadRateUnit);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadRate)) {
            return false;
        }
        UploadRate uploadRate = (UploadRate) obj;
        return this.value == uploadRate.value && this.unit == uploadRate.unit;
    }

    public int hashCode() {
        return (Integer.hashCode(this.value) * 31) + this.unit.hashCode();
    }

    public String toString() {
        int i = this.value;
        return "UploadRate(value=" + i + ", unit=" + this.unit + ")";
    }

    public UploadRate(int value2, UploadRateUnit unit2) {
        Intrinsics.checkNotNullParameter(unit2, "unit");
        this.value = value2;
        this.unit = unit2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadRate(int i, UploadRateUnit uploadRateUnit, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? UploadRateUnit.BitPerSecond : uploadRateUnit);
    }

    public final UploadRateUnit getUnit() {
        return this.unit;
    }

    public final int getValue() {
        return this.value;
    }
}
