package net.gotev.uploadservice;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.extensions.ContextExtensionsKt;
import net.gotev.uploadservice.extensions.UploadTaskCreationParameters;
import net.gotev.uploadservice.extensions.WakeLockExtensionsKt;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import net.gotev.uploadservice.observer.request.NotificationActionsObserver;
import net.gotev.uploadservice.observer.task.UploadTaskObserver;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J\"\u0010\"\u001a\u00020#2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020\u0015H\u0002J\u000e\u0010(\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lnet/gotev/uploadservice/UploadService;", "Landroid/app/Service;", "()V", "idleTimer", "Ljava/util/Timer;", "notificationActionsObserver", "Lnet/gotev/uploadservice/observer/request/NotificationActionsObserver;", "getNotificationActionsObserver", "()Lnet/gotev/uploadservice/observer/request/NotificationActionsObserver;", "notificationActionsObserver$delegate", "Lkotlin/Lazy;", "taskObservers", "", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "getTaskObservers", "()[Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "taskObservers$delegate", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "clearIdleTimer", "", "holdForegroundNotification", "", "uploadId", "", "notification", "Landroid/app/Notification;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "", "flags", "startId", "shutdownIfThereArentAnyActiveTasks", "stopServiceForeground", "taskCompleted", "Companion", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadService.kt */
public final class UploadService extends Service {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG = UploadService.class.getSimpleName();
    private static final int UPLOAD_NOTIFICATION_BASE_ID = 1234;
    private static volatile String foregroundUploadId;
    private static int notificationIncrementalId;
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap<String, UploadTask> uploadTasksMap = new ConcurrentHashMap<>();
    private Timer idleTimer;
    private final Lazy notificationActionsObserver$delegate = LazyKt.lazy(new UploadService$notificationActionsObserver$2(this));
    private final Lazy taskObservers$delegate = LazyKt.lazy(new UploadService$taskObservers$2(this));
    private PowerManager.WakeLock wakeLock;

    public static final synchronized List<String> getTaskList() {
        List<String> taskList;
        synchronized (UploadService.class) {
            taskList = Companion.getTaskList();
        }
        return taskList;
    }

    @JvmStatic
    public static final synchronized boolean stop(Context context) {
        boolean stop;
        synchronized (UploadService.class) {
            stop = Companion.stop(context);
        }
        return stop;
    }

    @JvmStatic
    public static final synchronized boolean stop(Context context, boolean z) {
        boolean stop;
        synchronized (UploadService.class) {
            stop = Companion.stop(context, z);
        }
        return stop;
    }

    @JvmStatic
    public static final synchronized void stopAllUploads() {
        synchronized (UploadService.class) {
            Companion.stopAllUploads();
        }
    }

    @JvmStatic
    public static final synchronized void stopUpload(String str) {
        synchronized (UploadService.class) {
            Companion.stopUpload(str);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0015H\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0004H\u0007R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r8FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lnet/gotev/uploadservice/UploadService$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$uploadservice_release", "()Ljava/lang/String;", "UPLOAD_NOTIFICATION_BASE_ID", "", "foregroundUploadId", "notificationIncrementalId", "taskList", "", "getTaskList$annotations", "getTaskList", "()Ljava/util/List;", "uploadTasksMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lnet/gotev/uploadservice/UploadTask;", "stop", "", "context", "Landroid/content/Context;", "forceStop", "stopAllUploads", "", "stopUpload", "uploadId", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UploadService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getTaskList$annotations() {
        }

        @JvmStatic
        public final boolean stop(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return stop$default(this, context, false, 2, (Object) null);
        }

        private Companion() {
        }

        public final String getTAG$uploadservice_release() {
            return UploadService.TAG;
        }

        @JvmStatic
        public final synchronized void stopUpload(String uploadId) {
            Intrinsics.checkNotNullParameter(uploadId, "uploadId");
            UploadTask uploadTask = (UploadTask) UploadService.uploadTasksMap.get(uploadId);
            if (uploadTask != null) {
                uploadTask.cancel();
            }
        }

        public final synchronized List<String> getTaskList() {
            List<String> list;
            if (UploadService.uploadTasksMap.isEmpty()) {
                list = CollectionsKt.emptyList();
            } else {
                Enumeration keys = UploadService.uploadTasksMap.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "uploadTasksMap.keys()");
                ArrayList list2 = Collections.list(keys);
                Intrinsics.checkNotNullExpressionValue(list2, "list(this)");
                list = list2;
            }
            return list;
        }

        @JvmStatic
        public final synchronized void stopAllUploads() {
            for (Object obj : UploadService.uploadTasksMap.keySet()) {
                UploadTask uploadTask = (UploadTask) UploadService.uploadTasksMap.get(obj);
                if (uploadTask != null) {
                    uploadTask.cancel();
                }
            }
        }

        public static /* synthetic */ boolean stop$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.stop(context, z);
        }

        @JvmStatic
        public final synchronized boolean stop(Context context, boolean forceStop) {
            boolean z;
            Intrinsics.checkNotNullParameter(context, "context");
            if (forceStop) {
                stopAllUploads();
                z = context.stopService(new Intent(context, UploadService.class));
            } else {
                z = UploadService.uploadTasksMap.isEmpty() && context.stopService(new Intent(context, UploadService.class));
            }
            return z;
        }
    }

    private final UploadTaskObserver[] getTaskObservers() {
        return (UploadTaskObserver[]) this.taskObservers$delegate.getValue();
    }

    private final NotificationActionsObserver getNotificationActionsObserver() {
        return (NotificationActionsObserver) this.notificationActionsObserver$delegate.getValue();
    }

    private final synchronized void clearIdleTimer() {
        Timer $this$clearIdleTimer_u24lambda_u240 = this.idleTimer;
        if ($this$clearIdleTimer_u24lambda_u240 != null) {
            String str = TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            UploadServiceLogger.info(str, UploadServiceLogger.NA, UploadService$clearIdleTimer$1$1.INSTANCE);
            $this$clearIdleTimer_u24lambda_u240.cancel();
        }
        this.idleTimer = null;
    }

    private final synchronized int shutdownIfThereArentAnyActiveTasks() {
        if (!uploadTasksMap.isEmpty()) {
            return 1;
        }
        clearIdleTimer();
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        UploadServiceLogger.info(str, UploadServiceLogger.NA, UploadService$shutdownIfThereArentAnyActiveTasks$1.INSTANCE);
        Timer $this$shutdownIfThereArentAnyActiveTasks_u24lambda_u241 = new Timer(str + "IdleTimer");
        $this$shutdownIfThereArentAnyActiveTasks_u24lambda_u241.schedule(new UploadService$shutdownIfThereArentAnyActiveTasks$2$1(this), (long) (UploadServiceConfig.getIdleTimeoutSeconds() * 1000));
        this.idleTimer = $this$shutdownIfThereArentAnyActiveTasks_u24lambda_u241;
        return 2;
    }

    public final synchronized boolean holdForegroundNotification(String uploadId, Notification notification) {
        Intrinsics.checkNotNullParameter(uploadId, "uploadId");
        Intrinsics.checkNotNullParameter(notification, "notification");
        if (!UploadServiceConfig.isForegroundService()) {
            return false;
        }
        if (foregroundUploadId == null) {
            foregroundUploadId = uploadId;
            String str = TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            UploadServiceLogger.debug(str, uploadId, UploadService$holdForegroundNotification$1.INSTANCE);
        }
        if (!Intrinsics.areEqual((Object) uploadId, (Object) foregroundUploadId)) {
            return false;
        }
        startForeground(UPLOAD_NOTIFICATION_BASE_ID, notification);
        return true;
    }

    private final void stopServiceForeground() {
        if (Build.VERSION.SDK_INT >= 24) {
            stopForeground(1);
        } else {
            stopForeground(true);
        }
    }

    public final synchronized void taskCompleted(String uploadId) {
        Intrinsics.checkNotNullParameter(uploadId, "uploadId");
        ConcurrentHashMap<String, UploadTask> concurrentHashMap = uploadTasksMap;
        UploadTask task = concurrentHashMap.remove(uploadId);
        if (UploadServiceConfig.isForegroundService() && task != null && Intrinsics.areEqual((Object) task.getParams().getId(), (Object) foregroundUploadId)) {
            String str = TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            UploadServiceLogger.debug(str, uploadId, UploadService$taskCompleted$1.INSTANCE);
            foregroundUploadId = null;
        }
        if (UploadServiceConfig.isForegroundService() && concurrentHashMap.isEmpty()) {
            String str2 = TAG;
            Intrinsics.checkNotNullExpressionValue(str2, "TAG");
            UploadServiceLogger.debug(str2, UploadServiceLogger.NA, UploadService$taskCompleted$2.INSTANCE);
            stopServiceForeground();
            shutdownIfThereArentAnyActiveTasks();
        }
    }

    public void onCreate() {
        super.onCreate();
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        this.wakeLock = WakeLockExtensionsKt.acquirePartialWakeLock(this, wakeLock2, str);
        getNotificationActionsObserver().register();
    }

    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        UploadServiceLogger.debug(str, UploadServiceLogger.NA, UploadService$onStartCommand$1.INSTANCE);
        String defaultNotificationChannel = UploadServiceConfig.getDefaultNotificationChannel();
        Intrinsics.checkNotNull(defaultNotificationChannel);
        NotificationCompat.Builder group = new NotificationCompat.Builder((Context) this, defaultNotificationChannel).setSmallIcon(17301589).setOngoing(true).setGroup(UploadServiceConfig.getNamespace());
        Intrinsics.checkNotNullExpressionValue(group, "Builder(this, UploadServ…dServiceConfig.namespace)");
        NotificationCompat.Builder builder = group;
        if (Build.VERSION.SDK_INT >= 31) {
            builder.setForegroundServiceBehavior(1);
        }
        Notification notification = builder.build();
        Intrinsics.checkNotNullExpressionValue(notification, "builder.build()");
        startForeground(UPLOAD_NOTIFICATION_BASE_ID, notification);
        UploadTaskCreationParameters uploadTaskCreationParameters = ContextExtensionsKt.getUploadTaskCreationParameters(intent);
        if (uploadTaskCreationParameters == null) {
            return shutdownIfThereArentAnyActiveTasks();
        }
        UploadTaskCreationParameters taskCreationParameters = uploadTaskCreationParameters;
        ConcurrentHashMap<String, UploadTask> concurrentHashMap = uploadTasksMap;
        if (concurrentHashMap.containsKey(taskCreationParameters.getParams().getId())) {
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            UploadServiceLogger.error$default(str, taskCreationParameters.getParams().getId(), (Throwable) null, UploadService$onStartCommand$2.INSTANCE, 4, (Object) null);
            return shutdownIfThereArentAnyActiveTasks();
        }
        int i = notificationIncrementalId + 2;
        notificationIncrementalId = i;
        int i2 = i + UPLOAD_NOTIFICATION_BASE_ID;
        UploadTaskObserver[] taskObservers = getTaskObservers();
        UploadTask currentTask = ContextExtensionsKt.getUploadTask(this, taskCreationParameters, i2, (UploadTaskObserver[]) Arrays.copyOf(taskObservers, taskObservers.length));
        if (currentTask == null) {
            return shutdownIfThereArentAnyActiveTasks();
        }
        clearIdleTimer();
        concurrentHashMap.put(currentTask.getParams().getId(), currentTask);
        UploadServiceConfig.getThreadPool().execute(currentTask);
        return 1;
    }

    public void onDestroy() {
        super.onDestroy();
        getNotificationActionsObserver().unregister();
        Companion.stopAllUploads();
        if (UploadServiceConfig.isForegroundService()) {
            String str = TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            UploadServiceLogger.debug(str, UploadServiceLogger.NA, UploadService$onDestroy$1.INSTANCE);
            stopServiceForeground();
        }
        WakeLockExtensionsKt.safeRelease(this.wakeLock);
        uploadTasksMap.clear();
        String str2 = TAG;
        Intrinsics.checkNotNullExpressionValue(str2, "TAG");
        UploadServiceLogger.debug(str2, UploadServiceLogger.NA, UploadService$onDestroy$2.INSTANCE);
    }
}
