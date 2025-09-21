package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final /* synthetic */ class zzcw implements RemoteCall {
    private final /* synthetic */ LocationSettingsRequest zza;

    /* synthetic */ zzcw(LocationSettingsRequest locationSettingsRequest) {
        this.zza = locationSettingsRequest;
    }

    public final /* synthetic */ void accept(Object obj, Object obj2) {
        boolean z;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        zzdu zzdu = (zzdu) obj;
        int i = zzcv.zza;
        LocationSettingsRequest locationSettingsRequest = this.zza;
        if (locationSettingsRequest != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "locationSettingsRequest can't be null");
        ((zzv) zzdu.getService()).zzD(locationSettingsRequest, new zzcz(taskCompletionSource), (String) null);
    }
}
