package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.zzy;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final class zzdt extends zzy {
    private final zzdm zza;

    zzdt(zzdm zzdm) {
        this.zza = zzdm;
    }

    /* access modifiers changed from: package-private */
    public final zzdt zzc(ListenerHolder listenerHolder) {
        this.zza.zzb(listenerHolder);
        return this;
    }

    public final void zzd(Location location) {
        this.zza.zza().notifyListener(new zzdr(this, location));
    }

    public final void zze() {
        this.zza.zza().notifyListener(new zzds(this));
    }

    /* access modifiers changed from: package-private */
    public final void zzf() {
        this.zza.zza().clear();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdm zzg() {
        return this.zza;
    }
}
