package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.location.zzem;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
public final class DeviceOrientationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceOrientationRequest> CREATOR = new zzn();
    public static final long OUTPUT_PERIOD_DEFAULT = 20000;
    public static final long OUTPUT_PERIOD_FAST = 5000;
    public static final long OUTPUT_PERIOD_MEDIUM = 10000;
    private final long zza;
    private final boolean zzb;

    /* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
    public static final class Builder {
        private long zza;
        private final boolean zzb;

        public Builder(long samplingPeriodMicros) {
            this.zzb = false;
            setSamplingPeriodMicros(samplingPeriodMicros);
        }

        public DeviceOrientationRequest build() {
            return new DeviceOrientationRequest(this.zza, this.zzb);
        }

        public Builder setSamplingPeriodMicros(long samplingPeriodMicros) {
            boolean z = false;
            if (samplingPeriodMicros >= 0 && samplingPeriodMicros < Long.MAX_VALUE) {
                z = true;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(samplingPeriodMicros).length() + 102);
            sb.append("Invalid interval: ");
            sb.append(samplingPeriodMicros);
            sb.append(" should be greater than or equal to 0. Note: Long.MAX_VALUE is not a valid interval.");
            zzem.zzb(z, sb.toString());
            this.zza = samplingPeriodMicros;
            return this;
        }

        public Builder(DeviceOrientationRequest src) {
            this.zza = src.zza();
            this.zzb = src.zzb();
        }
    }

    DeviceOrientationRequest(long j, boolean z) {
        this.zza = j;
        this.zzb = z;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DeviceOrientationRequest)) {
            return false;
        }
        DeviceOrientationRequest deviceOrientationRequest = (DeviceOrientationRequest) object;
        return this.zza == deviceOrientationRequest.zza && this.zzb == deviceOrientationRequest.zzb;
    }

    @Pure
    public long getSamplingPeriodMicros() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Boolean.valueOf(this.zzb));
    }

    public String toString() {
        long j = this.zza;
        int length = String.valueOf(j).length();
        String str = true != this.zzb ? "" : ", withVelocity";
        StringBuilder sb = new StringBuilder(length + 46 + str.length() + 1);
        sb.append("DeviceOrientationRequest[samplingPeriodMicros=");
        sb.append(j);
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getSamplingPeriodMicros());
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ long zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzb() {
        return this.zzb;
    }
}
