package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final /* synthetic */ class zzdx implements OnTokenCanceledListener {
    private final /* synthetic */ zzdu zza;
    private final /* synthetic */ ListenerHolder.ListenerKey zzb;

    /* synthetic */ zzdx(zzdu zzdu, ListenerHolder.ListenerKey listenerKey) {
        this.zza = zzdu;
        this.zzb = listenerKey;
    }

    public final /* synthetic */ void onCanceled() {
        try {
            this.zza.zzw(this.zzb, true, new TaskCompletionSource());
        } catch (RemoteException e) {
        }
    }
}
