package net.gotev.uploadservice.extensions;

import android.content.Context;
import android.os.PowerManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00060\u0001R\u00020\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0018\u00010\u0001R\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0010\u0010\u0007\u001a\u00020\b*\b\u0018\u00010\u0001R\u00020\u0002¨\u0006\t"}, d2 = {"acquirePartialWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "Landroid/content/Context;", "currentWakeLock", "tag", "", "safeRelease", "", "uploadservice_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: WakeLockExtensions.kt */
public final class WakeLockExtensionsKt {
    public static final void safeRelease(PowerManager.WakeLock $this$safeRelease) {
        if ($this$safeRelease != null) {
            PowerManager.WakeLock $this$safeRelease_u24lambda_u240 = $this$safeRelease;
            if ($this$safeRelease_u24lambda_u240.isHeld()) {
                $this$safeRelease_u24lambda_u240.release();
            }
        }
    }

    public static final PowerManager.WakeLock acquirePartialWakeLock(Context $this$acquirePartialWakeLock, PowerManager.WakeLock currentWakeLock, String tag) {
        Intrinsics.checkNotNullParameter($this$acquirePartialWakeLock, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (currentWakeLock != null && currentWakeLock.isHeld()) {
            return currentWakeLock;
        }
        Object systemService = $this$acquirePartialWakeLock.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, tag);
        PowerManager.WakeLock $this$acquirePartialWakeLock_u24lambda_u241 = newWakeLock;
        $this$acquirePartialWakeLock_u24lambda_u241.setReferenceCounted(false);
        if (!$this$acquirePartialWakeLock_u24lambda_u241.isHeld()) {
            $this$acquirePartialWakeLock_u24lambda_u241.acquire();
        }
        Intrinsics.checkNotNullExpressionValue(newWakeLock, "powerManager.newWakeLock…(!isHeld) acquire()\n    }");
        return newWakeLock;
    }
}
