package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.zzz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final class zzdj extends zzq {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzz zzb;

    zzdj(TaskCompletionSource taskCompletionSource, zzz zzz) {
        this.zza = taskCompletionSource;
        this.zzb = zzz;
    }

    public final void zzd(zzl zzl) {
        TaskUtil.setResultOrApiException(zzl.getStatus(), this.zza);
    }

    public final void zze() throws RemoteException {
        this.zzb.zze();
    }
}
