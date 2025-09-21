package com.google.android.gms.location;

import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.location.LocationCompat;
import com.google.android.gms.internal.location.zzej;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
public final class zzak {
    public static final /* synthetic */ int zza = 0;
    private static final DecimalFormat zzb = new DecimalFormat(".000000", DecimalFormatSymbols.getInstance(Locale.ROOT));
    private static final DecimalFormat zzc;
    private static final StringBuilder zzd = new StringBuilder();

    static {
        DecimalFormat decimalFormat = new DecimalFormat(".##", DecimalFormatSymbols.getInstance(Locale.ROOT));
        zzc = decimalFormat;
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
    }

    public static StringBuilder zza(Location location, StringBuilder sb) {
        String str;
        sb.ensureCapacity(100);
        String str2 = null;
        if (location == null) {
            sb.append((String) null);
            return sb;
        }
        sb.append("{");
        sb.append(location.getProvider());
        sb.append(", ");
        if (LocationCompat.isMock(location)) {
            sb.append("mock, ");
        }
        DecimalFormat decimalFormat = zzb;
        sb.append(decimalFormat.format(location.getLatitude()));
        sb.append(",");
        sb.append(decimalFormat.format(location.getLongitude()));
        if (location.hasAccuracy()) {
            sb.append("±");
            sb.append(zzc.format((double) location.getAccuracy()));
            sb.append("m");
        }
        if (location.hasAltitude()) {
            sb.append(", alt=");
            DecimalFormat decimalFormat2 = zzc;
            sb.append(decimalFormat2.format(location.getAltitude()));
            if (LocationCompat.hasVerticalAccuracy(location)) {
                sb.append("±");
                sb.append(decimalFormat2.format((double) LocationCompat.getVerticalAccuracyMeters(location)));
            }
            sb.append("m");
        }
        if (location.hasSpeed()) {
            sb.append(", spd=");
            DecimalFormat decimalFormat3 = zzc;
            sb.append(decimalFormat3.format((double) location.getSpeed()));
            if (LocationCompat.hasSpeedAccuracy(location)) {
                sb.append("±");
                sb.append(decimalFormat3.format((double) LocationCompat.getSpeedAccuracyMetersPerSecond(location)));
            }
            sb.append("m/s");
        }
        if (location.hasBearing()) {
            sb.append(", brg=");
            DecimalFormat decimalFormat4 = zzc;
            sb.append(decimalFormat4.format((double) location.getBearing()));
            if (LocationCompat.hasBearingAccuracy(location)) {
                sb.append("±");
                sb.append(decimalFormat4.format((double) LocationCompat.getBearingAccuracyDegrees(location)));
            }
            sb.append("°");
        }
        Bundle extras = location.getExtras();
        if (extras != null) {
            str = extras.getString("floorLabel");
        } else {
            str = null;
        }
        if (str != null) {
            sb.append(", fl=");
            sb.append(str);
        }
        Bundle extras2 = location.getExtras();
        if (extras2 != null) {
            str2 = extras2.getString("levelId");
        }
        if (str2 != null) {
            sb.append(", lv=");
            sb.append(str2);
        }
        long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        sb.append(", ert=");
        sb.append(zzej.zza(LocationCompat.getElapsedRealtimeMillis(location) + currentTimeMillis));
        sb.append('}');
        return sb;
    }
}
