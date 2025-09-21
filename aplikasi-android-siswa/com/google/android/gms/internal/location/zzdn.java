package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final class zzdn implements ListenerHolder.Notifier {
    final /* synthetic */ LocationResult zza;

    zzdn(zzdq zzdq, LocationResult locationResult) {
        this.zza = locationResult;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((LocationCallback) obj).onLocationResult(this.zza);
    }

    public final void onNotifyListenerFailed() {
    }
}
