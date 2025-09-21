package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationCallback;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final class zzdp implements ListenerHolder.Notifier {
    final /* synthetic */ zzdq zza;

    zzdp(zzdq zzdq) {
        this.zza = zzdq;
    }

    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        LocationCallback locationCallback = (LocationCallback) obj;
        this.zza.zzh().zzc();
    }

    public final void onNotifyListenerFailed() {
    }
}
