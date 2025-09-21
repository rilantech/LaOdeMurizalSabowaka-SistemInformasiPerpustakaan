package net.gotev.uploadservice;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.gotev.uploadservice.UploadRequest;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadTaskParameters;
import net.gotev.uploadservice.extensions.ContextExtensionsKt;
import net.gotev.uploadservice.observer.request.RequestObserver;
import net.gotev.uploadservice.observer.request.RequestObserverDelegate;
import net.gotev.uploadservice.persistence.Persistable;
import net.gotev.uploadservice.persistence.PersistableData;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u00103\u001a\u000204H$J\r\u00105\u001a\u00028\u0000H\u0004¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00028\u00002\u0006\u00108\u001a\u00020\t¢\u0006\u0002\u00109J\u0013\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010:JC\u0010#\u001a\u00028\u000026\u0010;\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u001c¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00028\u00002\u0006\u0010>\u001a\u00020\u0006¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020\u0006H\u0016J\u001e\u0010A\u001a\u00020B2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FJ\u000e\u0010A\u001a\u00020G2\u0006\u0010H\u001a\u00020BJ\b\u0010I\u001a\u000204H\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRJ\u0010\u001b\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020,0+X¤\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u0002008BX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u0006J"}, d2 = {"Lnet/gotev/uploadservice/UploadRequest;", "B", "Lnet/gotev/uploadservice/persistence/Persistable;", "context", "Landroid/content/Context;", "serverUrl", "", "(Landroid/content/Context;Ljava/lang/String;)V", "autoDeleteSuccessfullyUploadedFiles", "", "getAutoDeleteSuccessfullyUploadedFiles", "()Z", "setAutoDeleteSuccessfullyUploadedFiles", "(Z)V", "getContext", "()Landroid/content/Context;", "files", "Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/data/UploadFile;", "getFiles", "()Ljava/util/ArrayList;", "maxRetries", "", "getMaxRetries", "()I", "setMaxRetries", "(I)V", "notificationConfig", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "uploadId", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "getNotificationConfig", "()Lkotlin/jvm/functions/Function2;", "setNotificationConfig", "(Lkotlin/jvm/functions/Function2;)V", "getServerUrl", "()Ljava/lang/String;", "setServerUrl", "(Ljava/lang/String;)V", "started", "taskClass", "Ljava/lang/Class;", "Lnet/gotev/uploadservice/UploadTask;", "getTaskClass", "()Ljava/lang/Class;", "uploadTaskParameters", "Lnet/gotev/uploadservice/data/UploadTaskParameters;", "getUploadTaskParameters", "()Lnet/gotev/uploadservice/data/UploadTaskParameters;", "getAdditionalParameters", "Lnet/gotev/uploadservice/persistence/PersistableData;", "self", "()Lnet/gotev/uploadservice/UploadRequest;", "setAutoDeleteFilesAfterSuccessfulUpload", "autoDeleteFiles", "(Z)Lnet/gotev/uploadservice/UploadRequest;", "(I)Lnet/gotev/uploadservice/UploadRequest;", "config", "(Lkotlin/jvm/functions/Function2;)Lnet/gotev/uploadservice/UploadRequest;", "setUploadID", "uploadID", "(Ljava/lang/String;)Lnet/gotev/uploadservice/UploadRequest;", "startUpload", "subscribe", "Lnet/gotev/uploadservice/observer/request/RequestObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "delegate", "Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;", "", "observer", "toPersistableData", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadRequest.kt */
public abstract class UploadRequest<B extends UploadRequest<B>> implements Persistable {
    private boolean autoDeleteSuccessfullyUploadedFiles;
    private final Context context;
    private final ArrayList<UploadFile> files = new ArrayList<>();
    private int maxRetries = UploadServiceConfig.getRetryPolicy().getDefaultMaxRetries();
    private Function2<? super Context, ? super String, UploadNotificationConfig> notificationConfig = UploadServiceConfig.getNotificationConfigFactory();
    private String serverUrl;
    private boolean started;
    private String uploadId;

    /* access modifiers changed from: protected */
    public abstract PersistableData getAdditionalParameters();

    /* access modifiers changed from: protected */
    public abstract Class<? extends UploadTask> getTaskClass();

    public UploadRequest(Context context2, String serverUrl2) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(serverUrl2, UploadTaskParameters.Companion.CodingKeys.serverUrl);
        this.context = context2;
        this.serverUrl = serverUrl2;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.uploadId = uuid;
        if (!(!StringsKt.isBlank(this.serverUrl))) {
            throw new IllegalArgumentException("Server URL cannot be empty".toString());
        }
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: protected */
    public final String getServerUrl() {
        return this.serverUrl;
    }

    /* access modifiers changed from: protected */
    public final void setServerUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serverUrl = str;
    }

    /* access modifiers changed from: protected */
    public final int getMaxRetries() {
        return this.maxRetries;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setMaxRetries  reason: collision with other method in class */
    public final void m299setMaxRetries(int i) {
        this.maxRetries = i;
    }

    /* access modifiers changed from: protected */
    public final boolean getAutoDeleteSuccessfullyUploadedFiles() {
        return this.autoDeleteSuccessfullyUploadedFiles;
    }

    /* access modifiers changed from: protected */
    public final void setAutoDeleteSuccessfullyUploadedFiles(boolean z) {
        this.autoDeleteSuccessfullyUploadedFiles = z;
    }

    /* access modifiers changed from: protected */
    public final Function2<Context, String, UploadNotificationConfig> getNotificationConfig() {
        return this.notificationConfig;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setNotificationConfig  reason: collision with other method in class */
    public final void m300setNotificationConfig(Function2<? super Context, ? super String, UploadNotificationConfig> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.notificationConfig = function2;
    }

    /* access modifiers changed from: protected */
    public final ArrayList<UploadFile> getFiles() {
        return this.files;
    }

    private final UploadTaskParameters getUploadTaskParameters() {
        String name = getTaskClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "taskClass.name");
        return new UploadTaskParameters(name, this.uploadId, this.serverUrl, this.maxRetries, this.autoDeleteSuccessfullyUploadedFiles, this.files, getAdditionalParameters());
    }

    public String startUpload() {
        if (!(!this.started)) {
            throw new IllegalStateException("You have already called startUpload() on this Upload request instance once and you cannot call it multiple times. Check your code.".toString());
        } else if (!UploadService.Companion.getTaskList().contains(getUploadTaskParameters().getId())) {
            this.started = true;
            return ContextExtensionsKt.startNewUpload(this.context, getUploadTaskParameters(), this.notificationConfig.invoke(this.context, this.uploadId));
        } else {
            throw new IllegalStateException("You have tried to perform startUpload() using the same uploadID of an already running task. You're trying to use the same ID for multiple uploads.".toString());
        }
    }

    public final void subscribe(RequestObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        observer.subscribe(this);
    }

    public final RequestObserver subscribe(Context context2, LifecycleOwner lifecycleOwner, RequestObserverDelegate delegate) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        RequestObserver $this$subscribe_u24lambda_u243 = new RequestObserver(context2, lifecycleOwner, delegate, (Function1) null, 8, (DefaultConstructorMarker) null);
        $this$subscribe_u24lambda_u243.subscribe(this);
        return $this$subscribe_u24lambda_u243;
    }

    /* access modifiers changed from: protected */
    public final B self() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of net.gotev.uploadservice.UploadRequest");
        return this;
    }

    public final B setNotificationConfig(Function2<? super Context, ? super String, UploadNotificationConfig> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.notificationConfig = config;
        return self();
    }

    public final B setAutoDeleteFilesAfterSuccessfulUpload(boolean autoDeleteFiles) {
        this.autoDeleteSuccessfullyUploadedFiles = autoDeleteFiles;
        return self();
    }

    public final B setMaxRetries(int maxRetries2) {
        this.maxRetries = maxRetries2;
        return self();
    }

    public final B setUploadID(String uploadID) {
        Intrinsics.checkNotNullParameter(uploadID, "uploadID");
        this.uploadId = uploadID;
        return self();
    }

    public PersistableData toPersistableData() {
        return getUploadTaskParameters().toPersistableData();
    }
}
