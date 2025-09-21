package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zze;
import com.google.android.gms.internal.location.zzej;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzaf();
    @Deprecated
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    @Deprecated
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    @Deprecated
    public static final int PRIORITY_LOW_POWER = 104;
    @Deprecated
    public static final int PRIORITY_NO_POWER = 105;
    private int zza;
    private long zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private int zzf;
    private float zzg;
    private boolean zzh;
    private long zzi;
    private final int zzj;
    private final int zzk;
    private final boolean zzl;
    private final WorkSource zzm;
    private final zze zzn;

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocationRequest() {
        /*
            r22 = this;
            r0 = r22
            android.os.WorkSource r1 = new android.os.WorkSource
            r20 = r1
            r1.<init>()
            r1 = 102(0x66, float:1.43E-43)
            r2 = 3600000(0x36ee80, double:1.7786363E-317)
            r4 = 600000(0x927c0, double:2.964394E-318)
            r6 = 0
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r8 = r10
            r12 = 2147483647(0x7fffffff, float:NaN)
            r13 = 0
            r14 = 1
            r15 = 3600000(0x36ee80, double:1.7786363E-317)
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r0.<init>(r1, r2, r4, r6, r8, r10, r12, r13, r14, r15, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.LocationRequest.<init>():void");
    }

    @Deprecated
    public static LocationRequest create() {
        WorkSource workSource = r1;
        WorkSource workSource2 = new WorkSource();
        return new LocationRequest(102, 3600000, 600000, 0, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, 0.0f, true, 3600000, 0, 0, false, workSource, (zze) null);
    }

    private static String zze(long j) {
        return j == Long.MAX_VALUE ? "∞" : zzej.zzb(j);
    }

    public boolean equals(Object object) {
        if (object instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) object;
            if (this.zza == locationRequest.zza && ((isPassive() || this.zzb == locationRequest.zzb) && this.zzc == locationRequest.zzc && isBatched() == locationRequest.isBatched() && ((!isBatched() || this.zzd == locationRequest.zzd) && this.zze == locationRequest.zze && this.zzf == locationRequest.zzf && this.zzg == locationRequest.zzg && this.zzh == locationRequest.zzh && this.zzj == locationRequest.zzj && this.zzk == locationRequest.zzk && this.zzl == locationRequest.zzl && this.zzm.equals(locationRequest.zzm) && Objects.equal(this.zzn, locationRequest.zzn)))) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Pure
    public long getDurationMillis() {
        return this.zze;
    }

    @Deprecated
    @Pure
    public long getExpirationTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.zze;
        long j2 = elapsedRealtime + j;
        if (((elapsedRealtime ^ j2) & (j ^ j2)) < 0) {
            return Long.MAX_VALUE;
        }
        return j2;
    }

    @Deprecated
    @Pure
    public long getFastestInterval() {
        return getMinUpdateIntervalMillis();
    }

    @Pure
    public int getGranularity() {
        return this.zzj;
    }

    @Deprecated
    @Pure
    public long getInterval() {
        return getIntervalMillis();
    }

    @Pure
    public long getIntervalMillis() {
        return this.zzb;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.zzi;
    }

    @Pure
    public long getMaxUpdateDelayMillis() {
        return this.zzd;
    }

    @Pure
    public int getMaxUpdates() {
        return this.zzf;
    }

    @Deprecated
    @Pure
    public long getMaxWaitTime() {
        return Math.max(this.zzd, this.zzb);
    }

    @Pure
    public float getMinUpdateDistanceMeters() {
        return this.zzg;
    }

    @Pure
    public long getMinUpdateIntervalMillis() {
        return this.zzc;
    }

    @Deprecated
    @Pure
    public int getNumUpdates() {
        return getMaxUpdates();
    }

    @Pure
    public int getPriority() {
        return this.zza;
    }

    @Deprecated
    @Pure
    public float getSmallestDisplacement() {
        return getMinUpdateDistanceMeters();
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc), this.zzm);
    }

    @Pure
    public boolean isBatched() {
        long j = this.zzd;
        return j > 0 && (j >> 1) >= this.zzb;
    }

    @Deprecated
    @Pure
    public boolean isFastestIntervalExplicitlySet() {
        return true;
    }

    @Pure
    public boolean isPassive() {
        return this.zza == 105;
    }

    public boolean isWaitForAccurateLocation() {
        return this.zzh;
    }

    @Deprecated
    public LocationRequest setExpirationDuration(long durationMillis) {
        Preconditions.checkArgument(durationMillis > 0, "durationMillis must be greater than 0");
        this.zze = durationMillis;
        return this;
    }

    @Deprecated
    public LocationRequest setExpirationTime(long elapsedRealtime) {
        this.zze = Math.max(1, elapsedRealtime - SystemClock.elapsedRealtime());
        return this;
    }

    @Deprecated
    public LocationRequest setFastestInterval(long fastestIntervalMillis) {
        boolean z = true;
        Object[] objArr = {Long.valueOf(fastestIntervalMillis)};
        if (fastestIntervalMillis < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "illegal fastest interval: %d", objArr);
        this.zzc = fastestIntervalMillis;
        return this;
    }

    @Deprecated
    public LocationRequest setInterval(long intervalMillis) {
        Preconditions.checkArgument(intervalMillis >= 0, "intervalMillis must be greater than or equal to 0");
        long j = this.zzc;
        long j2 = this.zzb;
        if (j == j2 / 6) {
            this.zzc = intervalMillis / 6;
        }
        if (this.zzi == j2) {
            this.zzi = intervalMillis;
        }
        this.zzb = intervalMillis;
        return this;
    }

    @Deprecated
    public LocationRequest setMaxWaitTime(long maxWaitTimeMillis) {
        boolean z = true;
        Object[] objArr = {Long.valueOf(maxWaitTimeMillis)};
        if (maxWaitTimeMillis < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "illegal max wait time: %d", objArr);
        this.zzd = maxWaitTimeMillis;
        return this;
    }

    @Deprecated
    public LocationRequest setNumUpdates(int maxUpdates) {
        if (maxUpdates > 0) {
            this.zzf = maxUpdates;
            return this;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(maxUpdates).length() + 20);
        sb.append("invalid numUpdates: ");
        sb.append(maxUpdates);
        throw new IllegalArgumentException(sb.toString());
    }

    @Deprecated
    public LocationRequest setPriority(int priority) {
        zzan.zza(priority);
        this.zza = priority;
        return this;
    }

    @Deprecated
    public LocationRequest setSmallestDisplacement(float smallestDisplacementMeters) {
        if (smallestDisplacementMeters >= 0.0f) {
            this.zzg = smallestDisplacementMeters;
            return this;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(smallestDisplacementMeters).length() + 22);
        sb.append("invalid displacement: ");
        sb.append(smallestDisplacementMeters);
        throw new IllegalArgumentException(sb.toString());
    }

    @Deprecated
    public LocationRequest setWaitForAccurateLocation(boolean z) {
        this.zzh = z;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (isPassive()) {
            sb.append(zzan.zzb(this.zza));
            if (this.zzd > 0) {
                sb.append("/");
                zzej.zzc(this.zzd, sb);
            }
        } else {
            sb.append("@");
            if (isBatched()) {
                zzej.zzc(this.zzb, sb);
                sb.append("/");
                zzej.zzc(this.zzd, sb);
            } else {
                zzej.zzc(this.zzb, sb);
            }
            sb.append(" ");
            sb.append(zzan.zzb(this.zza));
        }
        if (isPassive() || this.zzc != this.zzb) {
            sb.append(", minUpdateInterval=");
            sb.append(zze(this.zzc));
        }
        if (((double) this.zzg) > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.zzg);
        }
        if (!isPassive() ? this.zzi != this.zzb : this.zzi != Long.MAX_VALUE) {
            sb.append(", maxUpdateAge=");
            sb.append(zze(this.zzi));
        }
        if (this.zze != Long.MAX_VALUE) {
            sb.append(", duration=");
            zzej.zzc(this.zze, sb);
        }
        if (this.zzf != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.zzf);
        }
        if (this.zzk != 0) {
            sb.append(", ");
            sb.append(zzar.zzb(this.zzk));
        }
        if (this.zzj != 0) {
            sb.append(", ");
            sb.append(zzq.zzb(this.zzj));
        }
        if (this.zzh) {
            sb.append(", waitForAccurateLocation");
        }
        if (this.zzl) {
            sb.append(", bypass");
        }
        if (!WorkSourceUtil.isEmpty(this.zzm)) {
            sb.append(", ");
            sb.append(this.zzm);
        }
        if (this.zzn != null) {
            sb.append(", impersonation=");
            sb.append(this.zzn);
        }
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getPriority());
        SafeParcelWriter.writeLong(parcel, 2, getIntervalMillis());
        SafeParcelWriter.writeLong(parcel, 3, getMinUpdateIntervalMillis());
        SafeParcelWriter.writeInt(parcel, 6, getMaxUpdates());
        SafeParcelWriter.writeFloat(parcel, 7, getMinUpdateDistanceMeters());
        SafeParcelWriter.writeLong(parcel, 8, getMaxUpdateDelayMillis());
        SafeParcelWriter.writeBoolean(parcel, 9, isWaitForAccurateLocation());
        SafeParcelWriter.writeLong(parcel, 10, getDurationMillis());
        SafeParcelWriter.writeLong(parcel, 11, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 12, getGranularity());
        SafeParcelWriter.writeInt(parcel, 13, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzl);
        SafeParcelWriter.writeParcelable(parcel, 16, this.zzm, flags, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzn, flags, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Pure
    public final int zza() {
        return this.zzk;
    }

    @Pure
    public final boolean zzb() {
        return this.zzl;
    }

    @Pure
    public final WorkSource zzc() {
        return this.zzm;
    }

    @Pure
    public final zze zzd() {
        return this.zzn;
    }

    /* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
    public static final class Builder {
        public static final long IMPLICIT_MAX_UPDATE_AGE = -1;
        public static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1;
        private int zza;
        private long zzb;
        private long zzc;
        private long zzd;
        private long zze;
        private int zzf;
        private float zzg;
        private boolean zzh;
        private long zzi;
        private int zzj;
        private int zzk;
        private boolean zzl;
        private WorkSource zzm;
        private zze zzn;

        public Builder(int priority, long intervalMillis) {
            this(intervalMillis);
            setPriority(priority);
        }

        public LocationRequest build() {
            long j;
            int i = this.zza;
            long j2 = this.zzb;
            long j3 = this.zzc;
            if (j3 == -1) {
                j3 = j2;
            } else if (i != 105) {
                j3 = Math.min(j3, j2);
            }
            long max = Math.max(this.zzd, this.zzb);
            long j4 = this.zze;
            int i2 = this.zzf;
            float f = this.zzg;
            boolean z = this.zzh;
            long j5 = this.zzi;
            if (j5 == -1) {
                j = this.zzb;
            } else {
                j = j5;
            }
            int i3 = this.zzj;
            int i4 = this.zzk;
            boolean z2 = this.zzl;
            WorkSource workSource = r7;
            WorkSource workSource2 = new WorkSource(this.zzm);
            return new LocationRequest(i, j2, j3, max, Long.MAX_VALUE, j4, i2, f, z, j, i3, i4, z2, workSource, this.zzn);
        }

        public Builder setDurationMillis(long durationMillis) {
            Preconditions.checkArgument(durationMillis > 0, "durationMillis must be greater than 0");
            this.zze = durationMillis;
            return this;
        }

        public Builder setGranularity(int granularity) {
            zzq.zza(granularity);
            this.zzj = granularity;
            return this;
        }

        public Builder setIntervalMillis(long intervalMillis) {
            Preconditions.checkArgument(intervalMillis >= 0, "intervalMillis must be greater than or equal to 0");
            this.zzb = intervalMillis;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long maxUpdateAgeMillis) {
            boolean z = true;
            if (maxUpdateAgeMillis != -1 && maxUpdateAgeMillis < 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.zzi = maxUpdateAgeMillis;
            return this;
        }

        public Builder setMaxUpdateDelayMillis(long maxUpdateDelayMillis) {
            Preconditions.checkArgument(maxUpdateDelayMillis >= 0, "maxUpdateDelayMillis must be greater than or equal to 0");
            this.zzd = maxUpdateDelayMillis;
            return this;
        }

        public Builder setMaxUpdates(int maxUpdates) {
            Preconditions.checkArgument(maxUpdates > 0, "maxUpdates must be greater than 0");
            this.zzf = maxUpdates;
            return this;
        }

        public Builder setMinUpdateDistanceMeters(float minUpdateDistanceMeters) {
            Preconditions.checkArgument(minUpdateDistanceMeters >= 0.0f, "minUpdateDistanceMeters must be greater than or equal to 0");
            this.zzg = minUpdateDistanceMeters;
            return this;
        }

        public Builder setMinUpdateIntervalMillis(long minUpdateIntervalMillis) {
            boolean z = true;
            if (minUpdateIntervalMillis != -1 && minUpdateIntervalMillis < 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
            this.zzc = minUpdateIntervalMillis;
            return this;
        }

        public Builder setPriority(int priority) {
            zzan.zza(priority);
            this.zza = priority;
            return this;
        }

        public Builder setWaitForAccurateLocation(boolean z) {
            this.zzh = z;
            return this;
        }

        public final Builder zza(int i) {
            zzar.zza(i);
            this.zzk = i;
            return this;
        }

        public final Builder zzb(boolean z) {
            this.zzl = z;
            return this;
        }

        public final Builder zzc(WorkSource workSource) {
            this.zzm = workSource;
            return this;
        }

        public Builder(long intervalMillis) {
            this.zza = 102;
            this.zzc = -1;
            this.zzd = 0;
            this.zze = Long.MAX_VALUE;
            this.zzf = Integer.MAX_VALUE;
            this.zzg = 0.0f;
            this.zzh = true;
            this.zzi = -1;
            this.zzj = 0;
            this.zzk = 0;
            this.zzl = false;
            this.zzm = null;
            this.zzn = null;
            setIntervalMillis(intervalMillis);
        }

        public Builder(LocationRequest request) {
            this(request.getPriority(), request.getIntervalMillis());
            setMinUpdateIntervalMillis(request.getMinUpdateIntervalMillis());
            setMaxUpdateDelayMillis(request.getMaxUpdateDelayMillis());
            setDurationMillis(request.getDurationMillis());
            setMaxUpdates(request.getMaxUpdates());
            setMinUpdateDistanceMeters(request.getMinUpdateDistanceMeters());
            setWaitForAccurateLocation(request.isWaitForAccurateLocation());
            setMaxUpdateAgeMillis(request.getMaxUpdateAgeMillis());
            setGranularity(request.getGranularity());
            int zza2 = request.zza();
            zzar.zza(zza2);
            this.zzk = zza2;
            this.zzl = request.zzb();
            this.zzm = request.zzc();
            zze zzd2 = request.zzd();
            boolean z = true;
            if (zzd2 != null && zzd2.zza()) {
                z = false;
            }
            Preconditions.checkArgument(z);
            this.zzn = zzd2;
        }
    }

    LocationRequest(int i, long j, long j2, long j3, long j4, long j5, int i2, float f, boolean z, long j6, int i3, int i4, boolean z2, WorkSource workSource, zze zze2) {
        long j7;
        long j8;
        int i5 = i;
        this.zza = i5;
        if (i5 == 105) {
            this.zzb = Long.MAX_VALUE;
            j7 = j;
        } else {
            j7 = j;
            this.zzb = j7;
        }
        this.zzc = j2;
        this.zzd = j3;
        if (j4 == Long.MAX_VALUE) {
            j8 = j5;
        } else {
            j8 = Math.min(Math.max(1, j4 - SystemClock.elapsedRealtime()), j5);
        }
        this.zze = j8;
        this.zzf = i2;
        this.zzg = f;
        this.zzh = z;
        this.zzi = j6 != -1 ? j6 : j7;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = z2;
        this.zzm = workSource;
        this.zzn = zze2;
    }
}
