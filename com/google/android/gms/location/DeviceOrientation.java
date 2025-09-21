package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.location.zzem;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
public class DeviceOrientation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceOrientation> CREATOR = new zzm();
    private final float[] zza;
    private final float zzb;
    private final float zzc;
    private final long zzd;
    private final byte zze;
    private final float zzf;
    private final float zzg;

    DeviceOrientation(float[] fArr, float f, float f2, long j, byte b, float f3, float f4) {
        boolean z;
        boolean z2;
        boolean z3;
        zzj(fArr);
        boolean z4 = true;
        if (f < 0.0f || f >= 360.0f) {
            z = false;
        } else {
            z = true;
        }
        zzem.zza(z);
        if (f2 < 0.0f || f2 > 180.0f) {
            z2 = false;
        } else {
            z2 = true;
        }
        zzem.zza(z2);
        if (f4 < 0.0f || f4 > 180.0f) {
            z3 = false;
        } else {
            z3 = true;
        }
        zzem.zza(z3);
        zzem.zza(j < 0 ? false : z4);
        this.zza = fArr;
        this.zzb = f;
        this.zzc = f2;
        this.zzf = f3;
        this.zzg = f4;
        this.zzd = j;
        this.zze = (byte) (((byte) (((byte) (b | 16)) | 4)) | 8);
    }

    /* access modifiers changed from: private */
    public static void zzj(float[] fArr) {
        boolean z;
        boolean z2 = true;
        if (fArr == null || fArr.length != 4) {
            z = false;
        } else {
            z = true;
        }
        zzem.zzb(z, "Input attitude array should be of length 4.");
        if (Float.isNaN(fArr[0]) || Float.isNaN(fArr[1]) || Float.isNaN(fArr[2]) || Float.isNaN(fArr[3])) {
            z2 = false;
        }
        zzem.zzb(z2, "Input attitude cannot contain NaNs.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    @org.checkerframework.dataflow.qual.Pure
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r7 != r8) goto L_0x0005
            return r0
        L_0x0005:
            boolean r1 = r8 instanceof com.google.android.gms.location.DeviceOrientation
            r2 = 0
            if (r1 != 0) goto L_0x000b
            return r2
        L_0x000b:
            com.google.android.gms.location.DeviceOrientation r8 = (com.google.android.gms.location.DeviceOrientation) r8
            boolean r1 = r7.zza()
            boolean r3 = r8.zza()
            if (r1 != r3) goto L_0x002b
            boolean r1 = r7.zza()
            if (r1 == 0) goto L_0x0029
            float r1 = r7.zzf
            float r3 = r8.zzf
            int r1 = java.lang.Float.compare(r1, r3)
            if (r1 != 0) goto L_0x002b
            r1 = r0
            goto L_0x002c
        L_0x0029:
            r1 = r0
            goto L_0x002c
        L_0x002b:
            r1 = r2
        L_0x002c:
            boolean r3 = r7.hasConservativeHeadingErrorDegrees()
            boolean r4 = r8.hasConservativeHeadingErrorDegrees()
            if (r3 != r4) goto L_0x004e
            boolean r3 = r7.hasConservativeHeadingErrorDegrees()
            if (r3 == 0) goto L_0x004c
            float r3 = r7.getConservativeHeadingErrorDegrees()
            float r4 = r8.getConservativeHeadingErrorDegrees()
            int r3 = java.lang.Float.compare(r3, r4)
            if (r3 != 0) goto L_0x004e
            r3 = r0
            goto L_0x004f
        L_0x004c:
            r3 = r0
            goto L_0x004f
        L_0x004e:
            r3 = r2
        L_0x004f:
            float r4 = r7.zzb
            float r5 = r8.zzb
            int r4 = java.lang.Float.compare(r4, r5)
            if (r4 != 0) goto L_0x007a
            float r4 = r7.zzc
            float r5 = r8.zzc
            int r4 = java.lang.Float.compare(r4, r5)
            if (r4 != 0) goto L_0x007a
            if (r1 == 0) goto L_0x007a
            if (r3 == 0) goto L_0x007a
            long r3 = r7.zzd
            long r5 = r8.zzd
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x007a
            float[] r1 = r7.zza
            float[] r8 = r8.zza
            boolean r8 = java.util.Arrays.equals(r1, r8)
            if (r8 == 0) goto L_0x007a
            return r0
        L_0x007a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.DeviceOrientation.equals(java.lang.Object):boolean");
    }

    @Pure
    public float[] getAttitude() {
        return (float[]) this.zza.clone();
    }

    @Pure
    public float getConservativeHeadingErrorDegrees() {
        return this.zzg;
    }

    @Pure
    public long getElapsedRealtimeNs() {
        return this.zzd;
    }

    @Pure
    public float getHeadingDegrees() {
        return this.zzb;
    }

    @Pure
    public float getHeadingErrorDegrees() {
        return this.zzc;
    }

    @Pure
    public boolean hasConservativeHeadingErrorDegrees() {
        return (this.zze & 64) != 0;
    }

    @Pure
    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.zzb), Float.valueOf(this.zzc), Float.valueOf(this.zzg), Long.valueOf(this.zzd), this.zza, Byte.valueOf(this.zze));
    }

    @Pure
    public String toString() {
        StringBuilder sb = new StringBuilder("DeviceOrientation[");
        sb.append("attitude=");
        sb.append(Arrays.toString(this.zza));
        sb.append(", headingDegrees=");
        sb.append(this.zzb);
        sb.append(", headingErrorDegrees=");
        sb.append(this.zzc);
        if (hasConservativeHeadingErrorDegrees()) {
            sb.append(", conservativeHeadingErrorDegrees=");
            sb.append(this.zzg);
        }
        sb.append(", elapsedRealtimeNs=");
        sb.append(this.zzd);
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloatArray(parcel, 1, getAttitude(), false);
        SafeParcelWriter.writeFloat(parcel, 4, getHeadingDegrees());
        SafeParcelWriter.writeFloat(parcel, 5, getHeadingErrorDegrees());
        SafeParcelWriter.writeLong(parcel, 6, getElapsedRealtimeNs());
        SafeParcelWriter.writeByte(parcel, 7, this.zze);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzf);
        SafeParcelWriter.writeFloat(parcel, 9, getConservativeHeadingErrorDegrees());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Pure
    public final boolean zza() {
        return (this.zze & 32) != 0;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ float[] zzc() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ float zzd() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ float zze() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ long zzf() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ byte zzg() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ float zzh() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ float zzi() {
        return this.zzg;
    }

    /* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
    public static final class Builder {
        private final float[] zza;
        private float zzb;
        private float zzc;
        private long zzd;
        private byte zze = 0;
        private float zzf;
        private float zzg;

        public Builder(DeviceOrientation src) {
            DeviceOrientation.zzj(src.zzc());
            this.zza = Arrays.copyOf(src.zzc(), src.zzc().length);
            setHeadingDegrees(src.zzd());
            setHeadingErrorDegrees(src.zze());
            setConservativeHeadingErrorDegrees(src.zzi());
            setElapsedRealtimeNs(src.zzf());
            this.zzf = src.zzh();
            this.zze = src.zzg();
        }

        public DeviceOrientation build() {
            return new DeviceOrientation(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
        }

        public Builder clearConservativeHeadingErrorDegrees() {
            this.zzg = 180.0f;
            this.zzf = 0.0f;
            this.zze = (byte) (((byte) (this.zze & -65)) & -33);
            return this;
        }

        public Builder setAttitude(float[] attitude) {
            DeviceOrientation.zzj(attitude);
            System.arraycopy(attitude, 0, this.zza, 0, attitude.length);
            return this;
        }

        public Builder setConservativeHeadingErrorDegrees(float conservativeHeadingErrorDegrees) {
            float f = 0.0f;
            boolean z = false;
            if (conservativeHeadingErrorDegrees >= 0.0f && conservativeHeadingErrorDegrees <= 180.0f) {
                z = true;
            }
            zzem.zzb(z, "conservativeHeadingErrorDegrees should be between 0 and 180.");
            this.zzg = conservativeHeadingErrorDegrees;
            this.zze = (byte) (this.zze | 64);
            Parcelable.Creator<DeviceOrientation> creator = DeviceOrientation.CREATOR;
            if (conservativeHeadingErrorDegrees < 180.0f) {
                f = (float) (2.0d / (1.0d - Math.cos(Math.toRadians((double) conservativeHeadingErrorDegrees))));
            }
            this.zzf = f;
            this.zze = (byte) (this.zze | 32);
            return this;
        }

        public Builder setElapsedRealtimeNs(long elapsedRealtimeNs) {
            zzem.zzb(elapsedRealtimeNs >= 0, "elapsedRealtimeNs should be greater than or equal to 0.");
            this.zzd = elapsedRealtimeNs;
            return this;
        }

        public Builder setHeadingDegrees(float headingDegrees) {
            boolean z = false;
            if (headingDegrees >= 0.0f && headingDegrees < 360.0f) {
                z = true;
            }
            zzem.zzb(z, "headingDegrees should be greater than or equal to 0 and less than 360.");
            this.zzb = headingDegrees;
            return this;
        }

        public Builder setHeadingErrorDegrees(float headingErrorDegrees) {
            boolean z = false;
            if (headingErrorDegrees >= 0.0f && headingErrorDegrees <= 180.0f) {
                z = true;
            }
            zzem.zzb(z, "headingErrorDegrees should be between 0 and 180.");
            this.zzc = headingErrorDegrees;
            return this;
        }

        public Builder(float[] attitude, float headingDegrees, float headingErrorDegrees, long elapsedRealtimeNs) {
            DeviceOrientation.zzj(attitude);
            this.zza = Arrays.copyOf(attitude, attitude.length);
            setHeadingDegrees(headingDegrees);
            setHeadingErrorDegrees(headingErrorDegrees);
            setElapsedRealtimeNs(elapsedRealtimeNs);
            this.zzf = 0.0f;
            this.zzg = 180.0f;
            this.zze = 0;
        }
    }
}
