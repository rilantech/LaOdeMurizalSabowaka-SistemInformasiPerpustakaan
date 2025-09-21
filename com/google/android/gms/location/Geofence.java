package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.location.zzef;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    /* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
    public static final class Builder {
        private String zza = null;
        private int zzb = 3;
        private long zzc = -1;
        private short zzd = -1;
        private double zze;
        private double zzf;
        private float zzg;
        private int zzh = 0;
        private int zzi = -1;

        public Geofence build() {
            if (this.zza != null) {
                int i = this.zzb;
                if (i == 0) {
                    throw new IllegalArgumentException("Transitions types not set.");
                } else if ((i & 4) != 0 && this.zzi < 0) {
                    throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELL.");
                } else if (this.zzc == Long.MIN_VALUE) {
                    throw new IllegalArgumentException("Expiration not set.");
                } else if (this.zzd == -1) {
                    throw new IllegalArgumentException("Geofence region not set.");
                } else if (this.zzh >= 0) {
                    return new zzef(this.zza, this.zzb, 1, this.zze, this.zzf, this.zzg, this.zzc, this.zzh, this.zzi);
                } else {
                    throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
                }
            } else {
                throw new IllegalArgumentException("Request ID not set.");
            }
        }

        public Builder setCircularRegion(double latitude, double longitude, float radius) {
            boolean z;
            boolean z2;
            boolean z3 = false;
            if (latitude < -90.0d || latitude > 90.0d) {
                z = false;
            } else {
                z = true;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(latitude).length() + 18);
            sb.append("Invalid latitude: ");
            sb.append(latitude);
            Preconditions.checkArgument(z, sb.toString());
            if (longitude < -180.0d || longitude > 180.0d) {
                z2 = false;
            } else {
                z2 = true;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(longitude).length() + 19);
            sb2.append("Invalid longitude: ");
            sb2.append(longitude);
            Preconditions.checkArgument(z2, sb2.toString());
            if (radius > 0.0f) {
                z3 = true;
            }
            StringBuilder sb3 = new StringBuilder(String.valueOf(radius).length() + 16);
            sb3.append("Invalid radius: ");
            sb3.append(radius);
            Preconditions.checkArgument(z3, sb3.toString());
            this.zzd = 1;
            this.zze = latitude;
            this.zzf = longitude;
            this.zzg = radius;
            return this;
        }

        public Builder setExpirationDuration(long durationMillis) {
            if (durationMillis < 0) {
                this.zzc = -1;
            } else {
                this.zzc = DefaultClock.getInstance().elapsedRealtime() + durationMillis;
            }
            return this;
        }

        public Builder setLoiteringDelay(int i) {
            this.zzi = i;
            return this;
        }

        public Builder setNotificationResponsiveness(int i) {
            this.zzh = i;
            return this;
        }

        public Builder setRequestId(String requestId) {
            this.zza = (String) Preconditions.checkNotNull(requestId, "Request ID can't be set to null");
            return this;
        }

        public Builder setTransitionTypes(int i) {
            this.zzb = i;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
    public @interface GeofenceTransition {
    }

    /* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
    public @interface TransitionTypes {
    }

    long getExpirationTime();

    double getLatitude();

    int getLoiteringDelay();

    double getLongitude();

    int getNotificationResponsiveness();

    float getRadius();

    String getRequestId();

    int getTransitionTypes();
}
