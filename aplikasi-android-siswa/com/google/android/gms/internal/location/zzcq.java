package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final /* synthetic */ class zzcq implements RemoteCall {
    private final /* synthetic */ List zza;

    /* synthetic */ zzcq(List list) {
        this.zza = list;
    }

    public final /* synthetic */ void accept(Object obj, Object obj2) {
        int i = zzco.zza;
        ((zzdu) obj).zzF(zzeh.zza(this.zza), (TaskCompletionSource) obj2);
    }
}
