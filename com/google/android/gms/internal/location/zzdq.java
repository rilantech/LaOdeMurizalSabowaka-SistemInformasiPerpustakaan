package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzv;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final class zzdq extends zzv {
    private final zzdm zza;

    zzdq(zzdm zzdm) {
        this.zza = zzdm;
    }

    /* access modifiers changed from: package-private */
    public final zzdq zzc(ListenerHolder listenerHolder) {
        this.zza.zzb(listenerHolder);
        return this;
    }

    public final void zzd(LocationResult locationResult) throws RemoteException {
        this.zza.zza().notifyListener(new zzdn(this, locationResult));
    }

    public final void zze(LocationAvailability locationAvailability) throws RemoteException {
        this.zza.zza().notifyListener(new zzdo(this, locationAvailability));
    }

    public final void zzf() {
        this.zza.zza().notifyListener(new zzdp(this));
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        this.zza.zza().clear();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdm zzh() {
        return this.zza;
    }
}
