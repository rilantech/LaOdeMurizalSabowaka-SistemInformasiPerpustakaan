package com.google.android.gms.internal.location;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
public final class zzey {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(java.util.concurrent.CountDownLatch r4, long r5, java.util.concurrent.TimeUnit r7) {
        /*
            r5 = 30
            r0 = 1
            r1 = 0
            long r5 = r7.toNanos(r5)     // Catch:{ all -> 0x002b }
            long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x002b }
            long r2 = r2 + r5
        L_0x000d:
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x0020, all -> 0x001d }
            boolean r4 = r4.await(r5, r7)     // Catch:{ InterruptedException -> 0x0020, all -> 0x001d }
            if (r1 == 0) goto L_0x001c
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            r5.interrupt()
        L_0x001c:
            return r4
        L_0x001d:
            r4 = move-exception
            r0 = r1
            goto L_0x002d
        L_0x0020:
            r5 = move-exception
            long r5 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0029 }
            long r5 = r2 - r5
            r1 = r0
            goto L_0x000d
        L_0x0029:
            r4 = move-exception
            goto L_0x002d
        L_0x002b:
            r4 = move-exception
            r0 = r1
        L_0x002d:
            if (r0 == 0) goto L_0x0036
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            r5.interrupt()
        L_0x0036:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzey.zza(java.util.concurrent.CountDownLatch, long, java.util.concurrent.TimeUnit):boolean");
    }
}
