package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final /* synthetic */ class zzdy implements OnTokenCanceledListener {
    private final /* synthetic */ ICancelToken zza;

    /* synthetic */ zzdy(ICancelToken iCancelToken) {
        this.zza = iCancelToken;
    }

    public final /* synthetic */ void onCanceled() {
        int i = zzdu.zze;
        try {
            this.zza.cancel();
        } catch (RemoteException e) {
        }
    }
}
