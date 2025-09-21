package net.gotev.uploadservice.extensions;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Parcelable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.UploadService;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.UploadTask;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadTaskParameters;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import net.gotev.uploadservice.observer.task.UploadTaskObserver;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u001a\u0010\u0011\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001\u001a5\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0019\"\u00020\u001a¢\u0006\u0002\u0010\u001b\u001a\u000e\u0010\u001c\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u0007\u001a(\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u001f*\u00020\u00072\u0006\u0010 \u001a\u00020\u0001H\b¢\u0006\u0002\u0010!\u001a\u001c\u0010\"\u001a\u00020#*\u00020\u000f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0007\u001a\u001a\u0010(\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006-"}, d2 = {"actionKey", "", "cancelUploadAction", "taskNotificationConfig", "taskParametersKey", "uploadIdKey", "uploadIdToCancel", "Landroid/content/Intent;", "getUploadIdToCancel", "(Landroid/content/Intent;)Ljava/lang/String;", "flagsCompat", "", "flags", "getCancelUploadIntent", "Landroid/app/PendingIntent;", "Landroid/content/Context;", "uploadId", "getNotificationActionIntent", "action", "getUploadTask", "Lnet/gotev/uploadservice/UploadTask;", "creationParameters", "Lnet/gotev/uploadservice/extensions/UploadTaskCreationParameters;", "notificationId", "observers", "", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "(Landroid/content/Context;Lnet/gotev/uploadservice/extensions/UploadTaskCreationParameters;I[Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;)Lnet/gotev/uploadservice/UploadTask;", "getUploadTaskCreationParameters", "parcelableCompat", "T", "Landroid/os/Parcelable;", "key", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/os/Parcelable;", "registerReceiverCompat", "", "receiver", "Landroid/content/BroadcastReceiver;", "filter", "Landroid/content/IntentFilter;", "startNewUpload", "params", "Lnet/gotev/uploadservice/data/UploadTaskParameters;", "notificationConfig", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "uploadservice_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContextExtensions.kt */
public final class ContextExtensionsKt {
    private static final String actionKey = "action";
    private static final String cancelUploadAction = "cancelUpload";
    private static final String taskNotificationConfig = "taskUploadConfig";
    private static final String taskParametersKey = "taskParameters";
    private static final String uploadIdKey = "uploadId";

    public static final String startNewUpload(Context $this$startNewUpload, UploadTaskParameters params, UploadNotificationConfig notificationConfig) {
        Intrinsics.checkNotNullParameter($this$startNewUpload, "<this>");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
        Intent intent = new Intent($this$startNewUpload, UploadService.class);
        Intent $this$startNewUpload_u24lambda_u240 = intent;
        $this$startNewUpload_u24lambda_u240.setAction(UploadServiceConfig.getUploadAction());
        $this$startNewUpload_u24lambda_u240.putExtra(taskParametersKey, params);
        $this$startNewUpload_u24lambda_u240.putExtra(taskNotificationConfig, notificationConfig);
        try {
            $this$startNewUpload.startService(intent);
        } catch (Throwable exc) {
            if (Build.VERSION.SDK_INT < 26 || !(exc instanceof IllegalStateException)) {
                UploadServiceLogger.error("UploadService", params.getId(), exc, ContextExtensionsKt$startNewUpload$1.INSTANCE);
            } else {
                $this$startNewUpload.startForegroundService(intent);
            }
        }
        return params.getId();
    }

    public static final UploadTaskCreationParameters getUploadTaskCreationParameters(Intent $this$getUploadTaskCreationParameters) {
        Parcelable parcelable;
        Class taskClass;
        Parcelable parcelable2;
        if ($this$getUploadTaskCreationParameters == null || !Intrinsics.areEqual((Object) $this$getUploadTaskCreationParameters.getAction(), (Object) UploadServiceConfig.getUploadAction())) {
            String tAG$uploadservice_release = UploadService.Companion.getTAG$uploadservice_release();
            Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release, "UploadService.TAG");
            UploadServiceLogger.error$default(tAG$uploadservice_release, UploadServiceLogger.NA, (Throwable) null, ContextExtensionsKt$getUploadTaskCreationParameters$1.INSTANCE, 4, (Object) null);
            return null;
        }
        Intent $this$parcelableCompat$iv = $this$getUploadTaskCreationParameters;
        if (Build.VERSION.SDK_INT >= 34) {
            parcelable = (Parcelable) $this$parcelableCompat$iv.getParcelableExtra(taskParametersKey, UploadTaskParameters.class);
        } else {
            Parcelable parcelableExtra = $this$parcelableCompat$iv.getParcelableExtra(taskParametersKey);
            if (!(parcelableExtra instanceof UploadTaskParameters)) {
                parcelableExtra = null;
            }
            parcelable = (UploadTaskParameters) parcelableExtra;
        }
        UploadTaskParameters uploadTaskParameters = (UploadTaskParameters) parcelable;
        if (uploadTaskParameters == null) {
            Intent intent = $this$getUploadTaskCreationParameters;
            String tAG$uploadservice_release2 = UploadService.Companion.getTAG$uploadservice_release();
            Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release2, "UploadService.TAG");
            UploadServiceLogger.error$default(tAG$uploadservice_release2, UploadServiceLogger.NA, (Throwable) null, ContextExtensionsKt$getUploadTaskCreationParameters$params$1$1.INSTANCE, 4, (Object) null);
            return null;
        }
        UploadTaskParameters params = uploadTaskParameters;
        try {
            taskClass = Class.forName(params.getTaskClass());
        } catch (Throwable exc) {
            String tAG$uploadservice_release3 = UploadService.Companion.getTAG$uploadservice_release();
            Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release3, "UploadService.TAG");
            UploadServiceLogger.error(tAG$uploadservice_release3, UploadServiceLogger.NA, exc, new ContextExtensionsKt$getUploadTaskCreationParameters$taskClass$1(params));
            taskClass = null;
        }
        if (taskClass == null) {
            return null;
        }
        if (!UploadTask.class.isAssignableFrom(taskClass)) {
            String tAG$uploadservice_release4 = UploadService.Companion.getTAG$uploadservice_release();
            Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release4, "UploadService.TAG");
            UploadServiceLogger.error$default(tAG$uploadservice_release4, UploadServiceLogger.NA, (Throwable) null, new ContextExtensionsKt$getUploadTaskCreationParameters$2(params), 4, (Object) null);
            return null;
        }
        Intent $this$parcelableCompat$iv2 = $this$getUploadTaskCreationParameters;
        if (Build.VERSION.SDK_INT >= 34) {
            parcelable2 = (Parcelable) $this$parcelableCompat$iv2.getParcelableExtra(taskNotificationConfig, UploadNotificationConfig.class);
        } else {
            Parcelable parcelableExtra2 = $this$parcelableCompat$iv2.getParcelableExtra(taskNotificationConfig);
            if (!(parcelableExtra2 instanceof UploadNotificationConfig)) {
                parcelableExtra2 = null;
            }
            parcelable2 = (UploadNotificationConfig) parcelableExtra2;
        }
        UploadNotificationConfig notificationConfig = (UploadNotificationConfig) parcelable2;
        if (notificationConfig != null) {
            return new UploadTaskCreationParameters(params, notificationConfig);
        }
        Intent intent2 = $this$getUploadTaskCreationParameters;
        String tAG$uploadservice_release5 = UploadService.Companion.getTAG$uploadservice_release();
        Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release5, "UploadService.TAG");
        UploadServiceLogger.error$default(tAG$uploadservice_release5, UploadServiceLogger.NA, (Throwable) null, ContextExtensionsKt$getUploadTaskCreationParameters$notificationConfig$1$1.INSTANCE, 4, (Object) null);
        return null;
    }

    public static final UploadTask getUploadTask(Context $this$getUploadTask, UploadTaskCreationParameters creationParameters, int notificationId, UploadTaskObserver... observers) {
        Intrinsics.checkNotNullParameter($this$getUploadTask, "<this>");
        Intrinsics.checkNotNullParameter(creationParameters, "creationParameters");
        Intrinsics.checkNotNullParameter(observers, "observers");
        try {
            Class taskClass = Class.forName(creationParameters.getParams().getTaskClass());
            Intrinsics.checkNotNull(taskClass, "null cannot be cast to non-null type java.lang.Class<out net.gotev.uploadservice.UploadTask>");
            Object newInstance = taskClass.newInstance();
            ((UploadTask) newInstance).init($this$getUploadTask, creationParameters.getParams(), creationParameters.getNotificationConfig(), notificationId, (UploadTaskObserver[]) Arrays.copyOf(observers, observers.length));
            UploadTask uploadTask = (UploadTask) newInstance;
            String tAG$uploadservice_release = UploadService.Companion.getTAG$uploadservice_release();
            Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release, "UploadService.TAG");
            UploadServiceLogger.debug(tAG$uploadservice_release, UploadServiceLogger.NA, new ContextExtensionsKt$getUploadTask$1(taskClass));
            return uploadTask;
        } catch (Throwable exc) {
            String tAG$uploadservice_release2 = UploadService.Companion.getTAG$uploadservice_release();
            Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release2, "UploadService.TAG");
            UploadServiceLogger.error(tAG$uploadservice_release2, UploadServiceLogger.NA, exc, ContextExtensionsKt$getUploadTask$2.INSTANCE);
            return null;
        }
    }

    public static final PendingIntent getNotificationActionIntent(Context $this$getNotificationActionIntent, String uploadId, String action) {
        Intrinsics.checkNotNullParameter($this$getNotificationActionIntent, "<this>");
        Intrinsics.checkNotNullParameter(uploadId, uploadIdKey);
        Intrinsics.checkNotNullParameter(action, actionKey);
        Intent intent = new Intent(UploadServiceConfig.getBroadcastNotificationAction());
        Intent $this$getNotificationActionIntent_u24lambda_u244 = intent;
        $this$getNotificationActionIntent_u24lambda_u244.setPackage(UploadServiceConfig.getNamespace());
        $this$getNotificationActionIntent_u24lambda_u244.putExtra(actionKey, action);
        $this$getNotificationActionIntent_u24lambda_u244.putExtra(uploadIdKey, uploadId);
        PendingIntent broadcast = PendingIntent.getBroadcast($this$getNotificationActionIntent, uploadId.hashCode(), intent, flagsCompat(BasicMeasure.EXACTLY));
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(\n        th…tent.FLAG_ONE_SHOT)\n    )");
        return broadcast;
    }

    public static final PendingIntent getCancelUploadIntent(Context $this$getCancelUploadIntent, String uploadId) {
        Intrinsics.checkNotNullParameter($this$getCancelUploadIntent, "<this>");
        Intrinsics.checkNotNullParameter(uploadId, uploadIdKey);
        return getNotificationActionIntent($this$getCancelUploadIntent, uploadId, cancelUploadAction);
    }

    public static final String getUploadIdToCancel(Intent $this$uploadIdToCancel) {
        Intrinsics.checkNotNullParameter($this$uploadIdToCancel, "<this>");
        if (!Intrinsics.areEqual((Object) $this$uploadIdToCancel.getStringExtra(actionKey), (Object) cancelUploadAction)) {
            return null;
        }
        return $this$uploadIdToCancel.getStringExtra(uploadIdKey);
    }

    public static final int flagsCompat(int flags) {
        if (Build.VERSION.SDK_INT > 30) {
            return 67108864 | flags;
        }
        return flags;
    }

    public static final /* synthetic */ <T extends Parcelable> T parcelableCompat(Intent $this$parcelableCompat, String key) {
        Intrinsics.checkNotNullParameter($this$parcelableCompat, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 34) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            Class<Parcelable> cls = Parcelable.class;
            Class cls2 = cls;
            return (Parcelable) $this$parcelableCompat.getParcelableExtra(key, cls);
        }
        T parcelableExtra = $this$parcelableCompat.getParcelableExtra(key);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        Parcelable parcelable = (Parcelable) parcelableExtra;
        Parcelable parcelable2 = (Parcelable) parcelableExtra;
        return parcelableExtra;
    }

    public static final void registerReceiverCompat(Context $this$registerReceiverCompat, BroadcastReceiver receiver, IntentFilter filter) {
        Intrinsics.checkNotNullParameter($this$registerReceiverCompat, "<this>");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (Build.VERSION.SDK_INT >= 34) {
            $this$registerReceiverCompat.registerReceiver(receiver, filter, 4);
        } else {
            $this$registerReceiverCompat.registerReceiver(receiver, filter);
        }
    }
}
