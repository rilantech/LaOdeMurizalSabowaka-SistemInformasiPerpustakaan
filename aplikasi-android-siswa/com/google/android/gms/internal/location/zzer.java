package com.google.android.gms.internal.location;

import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
final class zzer extends zzes {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzes zzc;

    zzer(zzes zzes, int i, int i2) {
        this.zzc = zzes;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzem.zzc(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* access modifiers changed from: package-private */
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return true;
    }

    public final zzes zzh(int i, int i2) {
        zzem.zze(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
