package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final /* synthetic */ class zzcp implements RemoteCall {
    private final /* synthetic */ PendingIntent zza;

    /* synthetic */ zzcp(PendingIntent pendingIntent) {
        this.zza = pendingIntent;
    }

    public final /* synthetic */ void accept(Object obj, Object obj2) {
        int i = zzco.zza;
        ((zzdu) obj).zzF(zzeh.zzb(this.zza), (TaskCompletionSource) obj2);
    }
}
