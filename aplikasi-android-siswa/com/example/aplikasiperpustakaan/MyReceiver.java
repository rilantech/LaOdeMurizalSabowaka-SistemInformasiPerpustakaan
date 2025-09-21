package com.example.aplikasiperpustakaan;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public class MyReceiver extends BroadcastReceiver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    String channelid = "default";
    String channelnotif = "channelku";

    public void onReceive(Context context, Intent intent) {
        if (intent.getStringExtra("myAction") != null && intent.getStringExtra("myAction").equals("notify")) {
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, this.channelid).setSmallIcon((int) R.drawable.logokemendikbud).setContentText("Silahkan Anda Kembalikan Buku Anda").setContentTitle("Notifikasi").setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2));
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(this.channelnotif, "contoh channel", 4);
                notificationChannel.enableLights(true);
                notificationBuilder.setChannelId(this.channelnotif);
                if (notificationManager != null) {
                    notificationManager.createNotificationChannel(notificationChannel);
                } else {
                    throw new AssertionError();
                }
            }
            if (notificationManager != null) {
                notificationManager.notify((int) System.currentTimeMillis(), notificationBuilder.build());
                return;
            }
            throw new AssertionError();
        }
    }
}
