package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.location.zzbb;
import com.google.android.gms.internal.location.zzbi;
import com.google.android.gms.internal.location.zzcm;
import com.google.android.gms.internal.location.zzco;
import com.google.android.gms.internal.location.zzcu;
import com.google.android.gms.internal.location.zzcv;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
public class LocationServices {
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> API = zzbi.zzb;
    @Deprecated
    public static final FusedLocationProviderApi FusedLocationApi = new zzbb();
    @Deprecated
    public static final GeofencingApi GeofencingApi = new zzcm();
    @Deprecated
    public static final SettingsApi SettingsApi = new zzcu();

    private LocationServices() {
    }

    public static FusedLocationProviderClient getFusedLocationProviderClient(Activity activity) {
        return new zzbi(activity);
    }

    public static GeofencingClient getGeofencingClient(Activity activity) {
        return new zzco(activity);
    }

    public static SettingsClient getSettingsClient(Activity activity) {
        return new zzcv(activity);
    }

    public static FusedLocationProviderClient getFusedLocationProviderClient(Context context) {
        return new zzbi(context);
    }

    public static GeofencingClient getGeofencingClient(Context context) {
        return new zzco(context);
    }

    public static SettingsClient getSettingsClient(Context context) {
        return new zzcv(context);
    }
}
