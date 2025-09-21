package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final /* synthetic */ class zzcx implements RemoteCall {
    static final /* synthetic */ zzcx zza = new zzcx();

    private /* synthetic */ zzcx() {
    }

    public final /* synthetic */ void accept(Object obj, Object obj2) {
        ((zzv) ((zzdu) obj).getService()).zzE(new zzdh((TaskCompletionSource) obj2));
    }
}
