package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
public abstract class zzs extends zzb implements zzt {
    public zzs() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                int readInt = parcel.readInt();
                String[] createStringArray = parcel.createStringArray();
                zzc.zzd(parcel);
                zzb(readInt, createStringArray);
                return true;
            case 2:
                int readInt2 = parcel.readInt();
                String[] createStringArray2 = parcel.createStringArray();
                zzc.zzd(parcel);
                zzc(readInt2, createStringArray2);
                return true;
            case 3:
                zzc.zzd(parcel);
                zzd(parcel.readInt(), (PendingIntent) zzc.zza(parcel, PendingIntent.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
