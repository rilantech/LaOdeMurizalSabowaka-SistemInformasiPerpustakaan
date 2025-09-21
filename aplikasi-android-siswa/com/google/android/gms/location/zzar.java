package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
public final class zzar {
    public static int zza(int i) {
        boolean z;
        if (i == 0 || i == 1) {
            z = true;
        } else if (i == 2) {
            i = 2;
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i));
        return i;
    }

    public static String zzb(int i) {
        switch (i) {
            case 0:
                return "THROTTLE_BACKGROUND";
            case 1:
                return "THROTTLE_ALWAYS";
            case 2:
                return "THROTTLE_NEVER";
            default:
                throw new IllegalArgumentException();
        }
    }
}
