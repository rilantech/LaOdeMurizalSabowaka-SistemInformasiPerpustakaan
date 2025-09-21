package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.DeviceOrientation;
import com.google.android.gms.location.DeviceOrientationListener;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final class zzdk implements ListenerHolder.Notifier {
    final /* synthetic */ DeviceOrientation zza;

    zzdk(zzdl zzdl, DeviceOrientation deviceOrientation) {
        this.zza = deviceOrientation;
    }

    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((DeviceOrientationListener) obj).onDeviceOrientationChanged(this.zza);
    }

    public final void onNotifyListenerFailed() {
    }
}
