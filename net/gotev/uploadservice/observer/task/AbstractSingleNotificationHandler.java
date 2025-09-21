package net.gotev.uploadservice.observer.task;

import android.app.NotificationManager;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.UploadService;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadNotificationStatusConfig;
import net.gotev.uploadservice.exceptions.UserCancelledUploadException;
import net.gotev.uploadservice.extensions.NotificationManagerExtensionsKt;
import net.gotev.uploadservice.network.ServerResponse;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002*+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J(\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J(\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\rJ.\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0$H&J \u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler;", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "service", "Lnet/gotev/uploadservice/UploadService;", "(Lnet/gotev/uploadservice/UploadService;)V", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "notificationManager$delegate", "Lkotlin/Lazy;", "tasks", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskData;", "onCompleted", "", "info", "Lnet/gotev/uploadservice/data/UploadInfo;", "notificationId", "", "notificationConfig", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "onError", "exception", "", "onProgress", "onStart", "onSuccess", "response", "Lnet/gotev/uploadservice/network/ServerResponse;", "removeTask", "uploadId", "updateNotification", "Landroidx/core/app/NotificationCompat$Builder;", "notificationBuilder", "", "updateTask", "status", "Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskStatus;", "config", "Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "TaskData", "TaskStatus", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AbstractSingleNotificationHandler.kt */
public abstract class AbstractSingleNotificationHandler implements UploadTaskObserver {
    private final Lazy notificationManager$delegate = LazyKt.lazy(new AbstractSingleNotificationHandler$notificationManager$2(this));
    /* access modifiers changed from: private */
    public final UploadService service;
    private final ConcurrentHashMap<String, TaskData> tasks = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskStatus;", "", "(Ljava/lang/String;I)V", "InProgress", "Succeeded", "Failed", "Cancelled", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AbstractSingleNotificationHandler.kt */
    public enum TaskStatus {
        InProgress,
        Succeeded,
        Failed,
        Cancelled
    }

    public abstract NotificationCompat.Builder updateNotification(NotificationManager notificationManager, NotificationCompat.Builder builder, Map<String, TaskData> map);

    public AbstractSingleNotificationHandler(UploadService service2) {
        Intrinsics.checkNotNullParameter(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
        NotificationManager notificationManager = getNotificationManager();
        String defaultNotificationChannel = UploadServiceConfig.getDefaultNotificationChannel();
        Intrinsics.checkNotNull(defaultNotificationChannel);
        NotificationManagerExtensionsKt.validateNotificationChannel(notificationManager, defaultNotificationChannel);
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskData;", "Landroid/os/Parcelable;", "status", "Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskStatus;", "info", "Lnet/gotev/uploadservice/data/UploadInfo;", "config", "Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "(Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskStatus;Lnet/gotev/uploadservice/data/UploadInfo;Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;)V", "getConfig", "()Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "getInfo", "()Lnet/gotev/uploadservice/data/UploadInfo;", "getStatus", "()Lnet/gotev/uploadservice/observer/task/AbstractSingleNotificationHandler$TaskStatus;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AbstractSingleNotificationHandler.kt */
    public static final class TaskData implements Parcelable {
        public static final Parcelable.Creator<TaskData> CREATOR = new Creator();
        private final UploadNotificationStatusConfig config;
        private final UploadInfo info;
        private final TaskStatus status;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AbstractSingleNotificationHandler.kt */
        public static final class Creator implements Parcelable.Creator<TaskData> {
            public final TaskData createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new TaskData(TaskStatus.valueOf(parcel.readString()), UploadInfo.CREATOR.createFromParcel(parcel), UploadNotificationStatusConfig.CREATOR.createFromParcel(parcel));
            }

            public final TaskData[] newArray(int i) {
                return new TaskData[i];
            }
        }

        public static /* synthetic */ TaskData copy$default(TaskData taskData, TaskStatus taskStatus, UploadInfo uploadInfo, UploadNotificationStatusConfig uploadNotificationStatusConfig, int i, Object obj) {
            if ((i & 1) != 0) {
                taskStatus = taskData.status;
            }
            if ((i & 2) != 0) {
                uploadInfo = taskData.info;
            }
            if ((i & 4) != 0) {
                uploadNotificationStatusConfig = taskData.config;
            }
            return taskData.copy(taskStatus, uploadInfo, uploadNotificationStatusConfig);
        }

        public final TaskStatus component1() {
            return this.status;
        }

        public final UploadInfo component2() {
            return this.info;
        }

        public final UploadNotificationStatusConfig component3() {
            return this.config;
        }

        public final TaskData copy(TaskStatus taskStatus, UploadInfo uploadInfo, UploadNotificationStatusConfig uploadNotificationStatusConfig) {
            Intrinsics.checkNotNullParameter(taskStatus, NotificationCompat.CATEGORY_STATUS);
            Intrinsics.checkNotNullParameter(uploadInfo, "info");
            Intrinsics.checkNotNullParameter(uploadNotificationStatusConfig, "config");
            return new TaskData(taskStatus, uploadInfo, uploadNotificationStatusConfig);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskData)) {
                return false;
            }
            TaskData taskData = (TaskData) obj;
            return this.status == taskData.status && Intrinsics.areEqual((Object) this.info, (Object) taskData.info) && Intrinsics.areEqual((Object) this.config, (Object) taskData.config);
        }

        public int hashCode() {
            return (((this.status.hashCode() * 31) + this.info.hashCode()) * 31) + this.config.hashCode();
        }

        public String toString() {
            TaskStatus taskStatus = this.status;
            UploadInfo uploadInfo = this.info;
            return "TaskData(status=" + taskStatus + ", info=" + uploadInfo + ", config=" + this.config + ")";
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.status.name());
            this.info.writeToParcel(parcel, i);
            this.config.writeToParcel(parcel, i);
        }

        public TaskData(TaskStatus status2, UploadInfo info2, UploadNotificationStatusConfig config2) {
            Intrinsics.checkNotNullParameter(status2, NotificationCompat.CATEGORY_STATUS);
            Intrinsics.checkNotNullParameter(info2, "info");
            Intrinsics.checkNotNullParameter(config2, "config");
            this.status = status2;
            this.info = info2;
            this.config = config2;
        }

        public final TaskStatus getStatus() {
            return this.status;
        }

        public final UploadInfo getInfo() {
            return this.info;
        }

        public final UploadNotificationStatusConfig getConfig() {
            return this.config;
        }
    }

    private final NotificationManager getNotificationManager() {
        return (NotificationManager) this.notificationManager$delegate.getValue();
    }

    public final void removeTask(String uploadId) {
        Intrinsics.checkNotNullParameter(uploadId, "uploadId");
        this.tasks.remove(uploadId);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0066, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void updateTask(net.gotev.uploadservice.observer.task.AbstractSingleNotificationHandler.TaskStatus r6, net.gotev.uploadservice.data.UploadInfo r7, net.gotev.uploadservice.data.UploadNotificationStatusConfig r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, net.gotev.uploadservice.observer.task.AbstractSingleNotificationHandler$TaskData> r0 = r5.tasks     // Catch:{ all -> 0x0067 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0067 }
            java.lang.String r1 = r7.getUploadId()     // Catch:{ all -> 0x0067 }
            net.gotev.uploadservice.observer.task.AbstractSingleNotificationHandler$TaskData r2 = new net.gotev.uploadservice.observer.task.AbstractSingleNotificationHandler$TaskData     // Catch:{ all -> 0x0067 }
            r2.<init>(r6, r7, r8)     // Catch:{ all -> 0x0067 }
            r0.put(r1, r2)     // Catch:{ all -> 0x0067 }
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder     // Catch:{ all -> 0x0067 }
            net.gotev.uploadservice.UploadService r1 = r5.service     // Catch:{ all -> 0x0067 }
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ all -> 0x0067 }
            java.lang.String r2 = net.gotev.uploadservice.UploadServiceConfig.getDefaultNotificationChannel()     // Catch:{ all -> 0x0067 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x0067 }
            r0.<init>((android.content.Context) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0067 }
            android.app.NotificationManager r1 = r5.getNotificationManager()     // Catch:{ all -> 0x0067 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0067 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, net.gotev.uploadservice.observer.task.AbstractSingleNotificationHandler$TaskData> r3 = r5.tasks     // Catch:{ all -> 0x0067 }
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ all -> 0x0067 }
            r2.<init>(r3)     // Catch:{ all -> 0x0067 }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x0067 }
            androidx.core.app.NotificationCompat$Builder r1 = r5.updateNotification(r1, r0, r2)     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x0065
            java.lang.String r2 = net.gotev.uploadservice.UploadServiceConfig.getNamespace()     // Catch:{ all -> 0x0067 }
            androidx.core.app.NotificationCompat$Builder r1 = r1.setGroup(r2)     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x0065
            r2 = 1
            androidx.core.app.NotificationCompat$Builder r1 = r1.setOngoing(r2)     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x0065
            android.app.Notification r1 = r1.build()     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x0065
            net.gotev.uploadservice.UploadService r2 = r5.service     // Catch:{ all -> 0x0067 }
            java.lang.Class r3 = r5.getClass()     // Catch:{ all -> 0x0067 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x0067 }
            java.lang.String r4 = "javaClass.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x0067 }
            r2.holdForegroundNotification(r3, r1)     // Catch:{ all -> 0x0067 }
            monitor-exit(r5)
            return
        L_0x0065:
            monitor-exit(r5)
            return
        L_0x0067:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.observer.task.AbstractSingleNotificationHandler.updateTask(net.gotev.uploadservice.observer.task.AbstractSingleNotificationHandler$TaskStatus, net.gotev.uploadservice.data.UploadInfo, net.gotev.uploadservice.data.UploadNotificationStatusConfig):void");
    }

    public void onStart(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
        updateTask(TaskStatus.InProgress, info, notificationConfig.getProgress());
    }

    public void onProgress(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
        updateTask(TaskStatus.InProgress, info, notificationConfig.getProgress());
    }

    public void onSuccess(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig, ServerResponse response) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
        Intrinsics.checkNotNullParameter(response, "response");
        updateTask(TaskStatus.Succeeded, info, notificationConfig.getSuccess());
    }

    public void onError(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig, Throwable exception) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (exception instanceof UserCancelledUploadException) {
            updateTask(TaskStatus.Cancelled, info, notificationConfig.getCancelled());
        } else {
            updateTask(TaskStatus.Failed, info, notificationConfig.getCancelled());
        }
    }

    public void onCompleted(UploadInfo info, int notificationId, UploadNotificationConfig notificationConfig) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(notificationConfig, "notificationConfig");
    }
}
