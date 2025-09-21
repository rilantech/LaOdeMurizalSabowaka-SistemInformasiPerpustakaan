package net.gotev.uploadservice;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadTaskParameters;
import net.gotev.uploadservice.exceptions.UploadError;
import net.gotev.uploadservice.exceptions.UserCancelledUploadException;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import net.gotev.uploadservice.network.HttpStack;
import net.gotev.uploadservice.network.ServerResponse;
import net.gotev.uploadservice.observer.task.UploadTaskObserver;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00108\u001a\u000209J\"\u0010:\u001a\u0002092\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u0002090<¢\u0006\u0002\b=H\bJ?\u0010>\u001a\u0002092\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0012\u0010@\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0A\"\u00020\u001b¢\u0006\u0002\u0010BJ\u0010\u0010C\u001a\u0002092\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u0002092\u0006\u0010G\u001a\u00020\fH\u0004J\u0010\u0010H\u001a\u0002092\u0006\u0010I\u001a\u00020JH\u0004J\b\u0010K\u001a\u000209H\u0002J\b\u0010L\u001a\u000209H\u0016J\b\u0010M\u001a\u000209H\u0002J\b\u0010N\u001a\u000209H\u0004J\b\u0010O\u001a\u000209H\u0016J\u0012\u0010P\u001a\u0002092\b\b\u0002\u0010Q\u001a\u00020#H\u0004J\u0018\u0010R\u001a\u00020#2\u0006\u00107\u001a\u00020\f2\u0006\u0010.\u001a\u00020\fH\u0002J!\u0010S\u001a\u0002092\b\b\u0002\u0010T\u001a\u00020\f2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020#0VH\bJ\u0010\u0010W\u001a\u0002092\u0006\u0010X\u001a\u00020YH$R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*8DX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00103\u001a\u0002048BX\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u000e\u00107\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lnet/gotev/uploadservice/UploadTask;", "Ljava/lang/Runnable;", "()V", "attempts", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "errorDelay", "", "lastProgressNotificationTime", "notificationConfig", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "getNotificationConfig", "()Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "setNotificationConfig", "(Lnet/gotev/uploadservice/data/UploadNotificationConfig;)V", "notificationId", "getNotificationId", "()I", "setNotificationId", "(I)V", "observers", "Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "params", "Lnet/gotev/uploadservice/data/UploadTaskParameters;", "getParams", "()Lnet/gotev/uploadservice/data/UploadTaskParameters;", "setParams", "(Lnet/gotev/uploadservice/data/UploadTaskParameters;)V", "shouldContinue", "", "getShouldContinue", "()Z", "setShouldContinue", "(Z)V", "startTime", "successfullyUploadedFiles", "", "Lnet/gotev/uploadservice/data/UploadFile;", "getSuccessfullyUploadedFiles", "()Ljava/util/List;", "totalBytes", "getTotalBytes", "()J", "setTotalBytes", "(J)V", "uploadInfo", "Lnet/gotev/uploadservice/data/UploadInfo;", "getUploadInfo", "()Lnet/gotev/uploadservice/data/UploadInfo;", "uploadedBytes", "cancel", "", "doForEachObserver", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init", "taskParams", "taskObservers", "", "(Landroid/content/Context;Lnet/gotev/uploadservice/data/UploadTaskParameters;Lnet/gotev/uploadservice/data/UploadNotificationConfig;I[Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;)V", "onError", "exception", "", "onProgress", "bytesSent", "onResponseReceived", "response", "Lnet/gotev/uploadservice/network/ServerResponse;", "onUserCancelledUpload", "performInitialization", "resetAttempts", "resetUploadedBytes", "run", "setAllFilesHaveBeenSuccessfullyUploaded", "value", "shouldThrottle", "sleepWhile", "millis", "condition", "Lkotlin/Function0;", "upload", "httpStack", "Lnet/gotev/uploadservice/network/HttpStack;", "Companion", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadTask.kt */
public abstract class UploadTask implements Runnable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = UploadTask.class.getSimpleName();
    /* access modifiers changed from: private */
    public int attempts;
    protected Context context;
    /* access modifiers changed from: private */
    public long errorDelay = ((long) UploadServiceConfig.getRetryPolicy().getInitialWaitTimeSeconds());
    private long lastProgressNotificationTime;
    public UploadNotificationConfig notificationConfig;
    private int notificationId;
    private final ArrayList<UploadTaskObserver> observers = new ArrayList<>(2);
    public UploadTaskParameters params;
    private boolean shouldContinue = true;
    private final long startTime = new Date().getTime();
    private long totalBytes;
    /* access modifiers changed from: private */
    public long uploadedBytes;

    /* access modifiers changed from: protected */
    public abstract void upload(HttpStack httpStack) throws Exception;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lnet/gotev/uploadservice/UploadTask$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UploadTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        Context context2 = this.context;
        if (context2 != null) {
            return context2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final UploadTaskParameters getParams() {
        UploadTaskParameters uploadTaskParameters = this.params;
        if (uploadTaskParameters != null) {
            return uploadTaskParameters;
        }
        Intrinsics.throwUninitializedPropertyAccessException("params");
        return null;
    }

    public final void setParams(UploadTaskParameters uploadTaskParameters) {
        Intrinsics.checkNotNullParameter(uploadTaskParameters, "<set-?>");
        this.params = uploadTaskParameters;
    }

    public final UploadNotificationConfig getNotificationConfig() {
        UploadNotificationConfig uploadNotificationConfig = this.notificationConfig;
        if (uploadNotificationConfig != null) {
            return uploadNotificationConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notificationConfig");
        return null;
    }

    public final void setNotificationConfig(UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "<set-?>");
        this.notificationConfig = uploadNotificationConfig;
    }

    public final int getNotificationId() {
        return this.notificationId;
    }

    public final void setNotificationId(int i) {
        this.notificationId = i;
    }

    public final boolean getShouldContinue() {
        return this.shouldContinue;
    }

    public final void setShouldContinue(boolean z) {
        this.shouldContinue = z;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    private final UploadInfo getUploadInfo() {
        return new UploadInfo(getParams().getId(), this.startTime, this.uploadedBytes, this.totalBytes, this.attempts, getParams().getFiles());
    }

    private final void doForEachObserver(Function1<? super UploadTaskObserver, Unit> action) {
        for (UploadTaskObserver it : this.observers) {
            try {
                action.invoke(it);
            } catch (Throwable exc) {
                String str = TAG;
                Intrinsics.checkNotNullExpressionValue(str, "TAG");
                UploadServiceLogger.error(str, getParams().getId(), exc, UploadTask$doForEachObserver$1$1.INSTANCE);
            }
        }
    }

    public final void init(Context context2, UploadTaskParameters taskParams, UploadNotificationConfig notificationConfig2, int notificationId2, UploadTaskObserver... taskObservers) throws IOException {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(taskParams, "taskParams");
        Intrinsics.checkNotNullParameter(notificationConfig2, "notificationConfig");
        Intrinsics.checkNotNullParameter(taskObservers, "taskObservers");
        setContext(context2);
        setParams(taskParams);
        this.notificationId = notificationId2;
        setNotificationConfig(notificationConfig2);
        for (UploadTaskObserver it : taskObservers) {
            this.observers.add(it);
        }
        performInitialization();
    }

    public void performInitialization() {
    }

    private final void resetAttempts() {
        this.attempts = 0;
        this.errorDelay = (long) UploadServiceConfig.getRetryPolicy().getInitialWaitTimeSeconds();
    }

    public void run() {
        for (UploadTaskObserver $this$run_u24lambda_u242 : this.observers) {
            try {
                $this$run_u24lambda_u242.onStart(getUploadInfo(), this.notificationId, getNotificationConfig());
            } catch (Throwable exc$iv) {
                String str = TAG;
                Intrinsics.checkNotNullExpressionValue(str, "TAG");
                UploadServiceLogger.error(str, getParams().getId(), exc$iv, UploadTask$doForEachObserver$1$1.INSTANCE);
            }
        }
        resetAttempts();
        while (true) {
            if (this.attempts > getParams().getMaxRetries() || !this.shouldContinue) {
                break;
            }
            try {
                resetUploadedBytes();
                upload(UploadServiceConfig.getHttpStack());
                break;
            } catch (Throwable th) {
            }
        }
        if (!this.shouldContinue) {
            onUserCancelledUpload();
        }
    }

    static /* synthetic */ void sleepWhile$default(UploadTask $this, long millis, Function0 condition, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                millis = 1000;
            }
            while (((Boolean) condition.invoke()).booleanValue()) {
                try {
                    Thread.sleep(millis);
                } catch (Throwable th) {
                }
            }
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sleepWhile");
    }

    private final void sleepWhile(long millis, Function0<Boolean> condition) {
        while (condition.invoke().booleanValue()) {
            try {
                Thread.sleep(millis);
            } catch (Throwable th) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void resetUploadedBytes() {
        this.uploadedBytes = 0;
    }

    /* access modifiers changed from: protected */
    public final void onProgress(long bytesSent) {
        long j = this.uploadedBytes + bytesSent;
        this.uploadedBytes = j;
        if (!shouldThrottle(j, this.totalBytes)) {
            String str = TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            UploadServiceLogger.debug(str, getParams().getId(), new UploadTask$onProgress$1(this));
            for (UploadTaskObserver $this$onProgress_u24lambda_u244 : this.observers) {
                try {
                    $this$onProgress_u24lambda_u244.onProgress(getUploadInfo(), this.notificationId, getNotificationConfig());
                } catch (Throwable exc$iv) {
                    String str2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                    UploadServiceLogger.error(str2, getParams().getId(), exc$iv, UploadTask$doForEachObserver$1$1.INSTANCE);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onResponseReceived(ServerResponse response) {
        int $i$f$doForEachObserver;
        ServerResponse serverResponse = response;
        Intrinsics.checkNotNullParameter(serverResponse, "response");
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        UploadServiceLogger.debug(str, getParams().getId(), new UploadTask$onResponseReceived$1(serverResponse));
        if (response.isSuccessful()) {
            if (getParams().getAutoDeleteSuccessfullyUploadedFiles()) {
                for (UploadFile file : getSuccessfullyUploadedFiles()) {
                    if (file.getHandler().delete(getContext())) {
                        String str2 = TAG;
                        Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                        UploadServiceLogger.info(str2, getParams().getId(), new UploadTask$onResponseReceived$2(file));
                    } else {
                        String str3 = TAG;
                        Intrinsics.checkNotNullExpressionValue(str3, "TAG");
                        UploadServiceLogger.error$default(str3, getParams().getId(), (Throwable) null, new UploadTask$onResponseReceived$3(file), 4, (Object) null);
                    }
                }
            }
            for (UploadTaskObserver $this$onResponseReceived_u24lambda_u245 : this.observers) {
                try {
                    $this$onResponseReceived_u24lambda_u245.onSuccess(getUploadInfo(), this.notificationId, getNotificationConfig(), serverResponse);
                } catch (Throwable exc$iv) {
                    String str4 = TAG;
                    Intrinsics.checkNotNullExpressionValue(str4, "TAG");
                    UploadServiceLogger.error(str4, getParams().getId(), exc$iv, UploadTask$doForEachObserver$1$1.INSTANCE);
                }
            }
        } else {
            int $i$f$doForEachObserver2 = 0;
            for (UploadTaskObserver $this$onResponseReceived_u24lambda_u246 : this.observers) {
                try {
                    $i$f$doForEachObserver = $i$f$doForEachObserver2;
                    try {
                        $this$onResponseReceived_u24lambda_u246.onError(getUploadInfo(), this.notificationId, getNotificationConfig(), new UploadError(serverResponse));
                    } catch (Throwable th) {
                        exc$iv = th;
                    }
                } catch (Throwable th2) {
                    exc$iv = th2;
                    $i$f$doForEachObserver = $i$f$doForEachObserver2;
                    String str5 = TAG;
                    Intrinsics.checkNotNullExpressionValue(str5, "TAG");
                    UploadServiceLogger.error(str5, getParams().getId(), exc$iv, UploadTask$doForEachObserver$1$1.INSTANCE);
                    $i$f$doForEachObserver2 = $i$f$doForEachObserver;
                }
                $i$f$doForEachObserver2 = $i$f$doForEachObserver;
            }
        }
        for (UploadTaskObserver $this$onResponseReceived_u24lambda_u247 : this.observers) {
            try {
                $this$onResponseReceived_u24lambda_u247.onCompleted(getUploadInfo(), this.notificationId, getNotificationConfig());
            } catch (Throwable exc$iv2) {
                String str6 = TAG;
                Intrinsics.checkNotNullExpressionValue(str6, "TAG");
                UploadServiceLogger.error(str6, getParams().getId(), exc$iv2, UploadTask$doForEachObserver$1$1.INSTANCE);
            }
        }
    }

    private final void onUserCancelledUpload() {
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        UploadServiceLogger.debug(str, getParams().getId(), UploadTask$onUserCancelledUpload$1.INSTANCE);
        onError(new UserCancelledUploadException());
    }

    private final void onError(Throwable exception) {
        int i;
        Throwable th = exception;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        UploadServiceLogger.error(str, getParams().getId(), th, UploadTask$onError$1.INSTANCE);
        UploadInfo it = getUploadInfo();
        int i2 = 0;
        for (UploadTaskObserver $this$onError_u24lambda_u2410_u24lambda_u248 : this.observers) {
            try {
                i = i2;
                try {
                    $this$onError_u24lambda_u2410_u24lambda_u248.onError(it, this.notificationId, getNotificationConfig(), th);
                } catch (Throwable th2) {
                    exc$iv = th2;
                }
            } catch (Throwable th3) {
                exc$iv = th3;
                i = i2;
                String str2 = TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                UploadServiceLogger.error(str2, getParams().getId(), exc$iv, UploadTask$doForEachObserver$1$1.INSTANCE);
                i2 = i;
            }
            i2 = i;
        }
        int i3 = i2;
        for (UploadTaskObserver $this$onError_u24lambda_u2410_u24lambda_u249 : this.observers) {
            try {
                $this$onError_u24lambda_u2410_u24lambda_u249.onCompleted(it, this.notificationId, getNotificationConfig());
            } catch (Throwable exc$iv) {
                String str3 = TAG;
                Intrinsics.checkNotNullExpressionValue(str3, "TAG");
                UploadServiceLogger.error(str3, getParams().getId(), exc$iv, UploadTask$doForEachObserver$1$1.INSTANCE);
            }
        }
    }

    public static /* synthetic */ void setAllFilesHaveBeenSuccessfullyUploaded$default(UploadTask uploadTask, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            uploadTask.setAllFilesHaveBeenSuccessfullyUploaded(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAllFilesHaveBeenSuccessfullyUploaded");
    }

    /* access modifiers changed from: protected */
    public final void setAllFilesHaveBeenSuccessfullyUploaded(boolean value) {
        for (UploadFile it : getParams().getFiles()) {
            it.setSuccessfullyUploaded(value);
        }
    }

    /* access modifiers changed from: protected */
    public final List<UploadFile> getSuccessfullyUploadedFiles() {
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : getParams().getFiles()) {
            if (((UploadFile) element$iv$iv).getSuccessfullyUploaded()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public final void cancel() {
        this.shouldContinue = false;
    }

    private final boolean shouldThrottle(long uploadedBytes2, long totalBytes2) {
        long currentTime = System.currentTimeMillis();
        if (uploadedBytes2 < totalBytes2 && currentTime < this.lastProgressNotificationTime + UploadServiceConfig.getUploadProgressNotificationIntervalMillis()) {
            return true;
        }
        this.lastProgressNotificationTime = currentTime;
        return false;
    }
}
