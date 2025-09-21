package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final class zzds implements ListenerHolder.Notifier {
    final /* synthetic */ zzdt zza;

    zzds(zzdt zzdt) {
        this.zza = zzdt;
    }

    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        LocationListener locationListener = (LocationListener) obj;
        this.zza.zzg().zzc();
    }

    public final void onNotifyListenerFailed() {
    }
}
