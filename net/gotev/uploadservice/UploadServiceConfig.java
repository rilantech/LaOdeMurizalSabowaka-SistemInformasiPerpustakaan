package net.gotev.uploadservice;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.gotev.uploadservice.data.RetryPolicyConfig;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import net.gotev.uploadservice.network.HttpStack;
import net.gotev.uploadservice.network.hurl.HurlStack;
import net.gotev.uploadservice.observer.request.NotificationActionsObserver;
import net.gotev.uploadservice.observer.task.UploadTaskObserver;
import net.gotev.uploadservice.placeholders.DefaultPlaceholdersProcessor;
import net.gotev.uploadservice.placeholders.PlaceholdersProcessor;
import net.gotev.uploadservice.schemehandlers.SchemeHandler;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020\u00042\u000e\u0010~\u001a\n\u0012\u0006\b\u0001\u0012\u00020d0cH\u0007J\u0011\u0010\u001a\u00020d2\u0007\u0010\u0001\u001a\u00020\u0004H\u0007J#\u0010\u0001\u001a\u00020|2\u0007\u0010F\u001a\u00030\u00012\u0006\u0010\u001e\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020/H\u0007J\t\u0010\u0001\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0007R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\fR,\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158\u0006@FX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00048F@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0007R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020$8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\u0002\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R,\u0010*\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158\u0006@FX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b+\u0010\u0002\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR$\u0010.\u001a\u00020/8F@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u0002\u001a\u0004\b.\u00101\"\u0004\b2\u00103R*\u00104\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00048F@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u0002\u001a\u0004\b6\u0010\u0007R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R0\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;098\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b<\u0010\u0002\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@RT\u0010A\u001a2\u0012\u0013\u0012\u00110C¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020H0B8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bI\u0010\u0002\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR0\u0010N\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020O098\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bP\u0010\u0002\u001a\u0004\bQ\u0010>\"\u0004\bR\u0010@R$\u0010S\u001a\u00020T8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bU\u0010\u0002\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010Z\u001a\u00020[8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\\\u0010\u0002\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R/\u0010a\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020d0c0b8BX\u0002¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\be\u0010fR$\u0010i\u001a\u00020j8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bk\u0010\u0002\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u001a\u0010p\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\bq\u0010\u0002\u001a\u0004\br\u0010\u0007R\u000e\u0010s\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R$\u0010t\u001a\u00020u8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bv\u0010\u0002\u001a\u0004\bw\u0010x\"\u0004\by\u0010z¨\u0006\u0001"}, d2 = {"Lnet/gotev/uploadservice/UploadServiceConfig;", "", "()V", "broadcastNotificationAction", "", "getBroadcastNotificationAction$annotations", "getBroadcastNotificationAction", "()Ljava/lang/String;", "broadcastNotificationActionIntentFilter", "Landroid/content/IntentFilter;", "getBroadcastNotificationActionIntentFilter$annotations", "getBroadcastNotificationActionIntentFilter", "()Landroid/content/IntentFilter;", "broadcastStatusAction", "getBroadcastStatusAction$annotations", "getBroadcastStatusAction", "broadcastStatusActionSuffix", "broadcastStatusIntentFilter", "getBroadcastStatusIntentFilter$annotations", "getBroadcastStatusIntentFilter", "value", "", "bufferSizeBytes", "getBufferSizeBytes$annotations", "getBufferSizeBytes", "()I", "setBufferSizeBytes", "(I)V", "contentScheme", "<set-?>", "defaultNotificationChannel", "getDefaultNotificationChannel$annotations", "getDefaultNotificationChannel", "defaultUserAgent", "fileScheme", "httpStack", "Lnet/gotev/uploadservice/network/HttpStack;", "getHttpStack$annotations", "getHttpStack", "()Lnet/gotev/uploadservice/network/HttpStack;", "setHttpStack", "(Lnet/gotev/uploadservice/network/HttpStack;)V", "idleTimeoutSeconds", "getIdleTimeoutSeconds$annotations", "getIdleTimeoutSeconds", "setIdleTimeoutSeconds", "isForegroundService", "", "isForegroundService$annotations", "()Z", "setForegroundService", "(Z)V", "namespace", "getNamespace$annotations", "getNamespace", "notificationActionSuffix", "notificationActionsObserverFactory", "Lkotlin/Function1;", "Lnet/gotev/uploadservice/UploadService;", "Lnet/gotev/uploadservice/observer/request/NotificationActionsObserver;", "getNotificationActionsObserverFactory$annotations", "getNotificationActionsObserverFactory", "()Lkotlin/jvm/functions/Function1;", "setNotificationActionsObserverFactory", "(Lkotlin/jvm/functions/Function1;)V", "notificationConfigFactory", "Lkotlin/Function2;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "uploadId", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "getNotificationConfigFactory$annotations", "getNotificationConfigFactory", "()Lkotlin/jvm/functions/Function2;", "setNotificationConfigFactory", "(Lkotlin/jvm/functions/Function2;)V", "notificationHandlerFactory", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "getNotificationHandlerFactory$annotations", "getNotificationHandlerFactory", "setNotificationHandlerFactory", "placeholdersProcessor", "Lnet/gotev/uploadservice/placeholders/PlaceholdersProcessor;", "getPlaceholdersProcessor$annotations", "getPlaceholdersProcessor", "()Lnet/gotev/uploadservice/placeholders/PlaceholdersProcessor;", "setPlaceholdersProcessor", "(Lnet/gotev/uploadservice/placeholders/PlaceholdersProcessor;)V", "retryPolicy", "Lnet/gotev/uploadservice/data/RetryPolicyConfig;", "getRetryPolicy$annotations", "getRetryPolicy", "()Lnet/gotev/uploadservice/data/RetryPolicyConfig;", "setRetryPolicy", "(Lnet/gotev/uploadservice/data/RetryPolicyConfig;)V", "schemeHandlers", "Ljava/util/LinkedHashMap;", "Ljava/lang/Class;", "Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "getSchemeHandlers", "()Ljava/util/LinkedHashMap;", "schemeHandlers$delegate", "Lkotlin/Lazy;", "threadPool", "Ljava/util/concurrent/AbstractExecutorService;", "getThreadPool$annotations", "getThreadPool", "()Ljava/util/concurrent/AbstractExecutorService;", "setThreadPool", "(Ljava/util/concurrent/AbstractExecutorService;)V", "uploadAction", "getUploadAction$annotations", "getUploadAction", "uploadActionSuffix", "uploadProgressNotificationIntervalMillis", "", "getUploadProgressNotificationIntervalMillis$annotations", "getUploadProgressNotificationIntervalMillis", "()J", "setUploadProgressNotificationIntervalMillis", "(J)V", "addSchemeHandler", "", "scheme", "handler", "getSchemeHandler", "path", "initialize", "Landroid/app/Application;", "debug", "toString", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadServiceConfig.kt */
public final class UploadServiceConfig {
    public static final UploadServiceConfig INSTANCE = new UploadServiceConfig();
    private static final String broadcastStatusActionSuffix = ".uploadservice.broadcast.status";
    private static int bufferSizeBytes = 4096;
    private static final String contentScheme = "content://";
    private static String defaultNotificationChannel = null;
    public static final String defaultUserAgent = "AndroidUploadService/4.9.2";
    private static final String fileScheme = "/";
    private static HttpStack httpStack = new HurlStack((String) null, false, false, 0, 0, 31, (DefaultConstructorMarker) null);
    private static int idleTimeoutSeconds = 10;
    private static boolean isForegroundService = true;
    private static String namespace = null;
    private static final String notificationActionSuffix = ".uploadservice.broadcast.notification.action";
    private static Function1<? super UploadService, ? extends NotificationActionsObserver> notificationActionsObserverFactory = UploadServiceConfig$notificationActionsObserverFactory$1.INSTANCE;
    private static Function2<? super Context, ? super String, UploadNotificationConfig> notificationConfigFactory = UploadServiceConfig$notificationConfigFactory$1.INSTANCE;
    private static Function1<? super UploadService, ? extends UploadTaskObserver> notificationHandlerFactory = UploadServiceConfig$notificationHandlerFactory$1.INSTANCE;
    private static PlaceholdersProcessor placeholdersProcessor = new DefaultPlaceholdersProcessor();
    private static RetryPolicyConfig retryPolicy = new RetryPolicyConfig(1, 100, 2, 3);
    private static final Lazy schemeHandlers$delegate = LazyKt.lazy(UploadServiceConfig$schemeHandlers$2.INSTANCE);
    private static AbstractExecutorService threadPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), 5, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private static final String uploadActionSuffix = ".uploadservice.action.upload";
    private static long uploadProgressNotificationIntervalMillis = 333;

    @JvmStatic
    public static /* synthetic */ void getBroadcastNotificationAction$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBroadcastNotificationActionIntentFilter$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBroadcastStatusAction$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBroadcastStatusIntentFilter$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBufferSizeBytes$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDefaultNotificationChannel$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getHttpStack$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getIdleTimeoutSeconds$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getNamespace$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getNotificationActionsObserverFactory$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getNotificationConfigFactory$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getNotificationHandlerFactory$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getPlaceholdersProcessor$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getRetryPolicy$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getThreadPool$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getUploadAction$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getUploadProgressNotificationIntervalMillis$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isForegroundService$annotations() {
    }

    private UploadServiceConfig() {
    }

    private final LinkedHashMap<String, Class<? extends SchemeHandler>> getSchemeHandlers() {
        return (LinkedHashMap) schemeHandlers$delegate.getValue();
    }

    @JvmStatic
    public static final void initialize(Application context, String defaultNotificationChannel2, boolean debug) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultNotificationChannel2, "defaultNotificationChannel");
        namespace = context.getPackageName();
        defaultNotificationChannel = defaultNotificationChannel2;
        UploadServiceLogger.setDevelopmentMode(debug);
    }

    public static final String getNamespace() {
        String str = namespace;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("You have to set namespace to your app package name (context.packageName) in your Application subclass");
    }

    public static final String getDefaultNotificationChannel() {
        String str = defaultNotificationChannel;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("You have to set defaultNotificationChannel in your Application subclass");
    }

    public static final AbstractExecutorService getThreadPool() {
        return threadPool;
    }

    public static final void setThreadPool(AbstractExecutorService abstractExecutorService) {
        Intrinsics.checkNotNullParameter(abstractExecutorService, "<set-?>");
        threadPool = abstractExecutorService;
    }

    public static final Function1<UploadService, NotificationActionsObserver> getNotificationActionsObserverFactory() {
        return notificationActionsObserverFactory;
    }

    public static final void setNotificationActionsObserverFactory(Function1<? super UploadService, ? extends NotificationActionsObserver> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        notificationActionsObserverFactory = function1;
    }

    public static final Function1<UploadService, UploadTaskObserver> getNotificationHandlerFactory() {
        return notificationHandlerFactory;
    }

    public static final void setNotificationHandlerFactory(Function1<? super UploadService, ? extends UploadTaskObserver> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        notificationHandlerFactory = function1;
    }

    public static final Function2<Context, String, UploadNotificationConfig> getNotificationConfigFactory() {
        return notificationConfigFactory;
    }

    public static final void setNotificationConfigFactory(Function2<? super Context, ? super String, UploadNotificationConfig> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        notificationConfigFactory = function2;
    }

    public static final int getIdleTimeoutSeconds() {
        return idleTimeoutSeconds;
    }

    public static final void setIdleTimeoutSeconds(int value) {
        boolean z = true;
        if (value < 1) {
            z = false;
        }
        if (z) {
            idleTimeoutSeconds = value;
            return;
        }
        throw new IllegalArgumentException(("Idle timeout min allowable value is 1. It cannot be " + value).toString());
    }

    public static final int getBufferSizeBytes() {
        return bufferSizeBytes;
    }

    public static final void setBufferSizeBytes(int value) {
        if (value >= 256) {
            bufferSizeBytes = value;
            return;
        }
        throw new IllegalArgumentException("You can't set buffer size lower than 256 bytes".toString());
    }

    public static final HttpStack getHttpStack() {
        return httpStack;
    }

    public static final void setHttpStack(HttpStack httpStack2) {
        Intrinsics.checkNotNullParameter(httpStack2, "<set-?>");
        httpStack = httpStack2;
    }

    public static final long getUploadProgressNotificationIntervalMillis() {
        return uploadProgressNotificationIntervalMillis;
    }

    public static final void setUploadProgressNotificationIntervalMillis(long j) {
        uploadProgressNotificationIntervalMillis = j;
    }

    public static final RetryPolicyConfig getRetryPolicy() {
        return retryPolicy;
    }

    public static final void setRetryPolicy(RetryPolicyConfig retryPolicyConfig) {
        Intrinsics.checkNotNullParameter(retryPolicyConfig, "<set-?>");
        retryPolicy = retryPolicyConfig;
    }

    public static final void setForegroundService(boolean z) {
        isForegroundService = z;
    }

    public static final boolean isForegroundService() {
        return Build.VERSION.SDK_INT >= 26 || isForegroundService;
    }

    public static final String getUploadAction() {
        return getNamespace() + uploadActionSuffix;
    }

    public static final String getBroadcastStatusAction() {
        return getNamespace() + broadcastStatusActionSuffix;
    }

    public static final String getBroadcastNotificationAction() {
        return getNamespace() + notificationActionSuffix;
    }

    public static final IntentFilter getBroadcastStatusIntentFilter() {
        return new IntentFilter(getBroadcastStatusAction());
    }

    public static final IntentFilter getBroadcastNotificationActionIntentFilter() {
        return new IntentFilter(getBroadcastNotificationAction());
    }

    public static final PlaceholdersProcessor getPlaceholdersProcessor() {
        return placeholdersProcessor;
    }

    public static final void setPlaceholdersProcessor(PlaceholdersProcessor placeholdersProcessor2) {
        Intrinsics.checkNotNullParameter(placeholdersProcessor2, "<set-?>");
        placeholdersProcessor = placeholdersProcessor2;
    }

    @JvmStatic
    public static final void addSchemeHandler(String scheme, Class<? extends SchemeHandler> handler) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (!Intrinsics.areEqual((Object) scheme, (Object) fileScheme) && !Intrinsics.areEqual((Object) scheme, (Object) contentScheme)) {
            INSTANCE.getSchemeHandlers().put(scheme, handler);
            return;
        }
        throw new IllegalArgumentException(("Cannot override bundled scheme: " + scheme + "! If you found a bug in a bundled scheme handler, please open an issue: https://github.com/gotev/android-upload-service").toString());
    }

    @JvmStatic
    public static final SchemeHandler getSchemeHandler(String path) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Intrinsics.checkNotNullParameter(path, UploadFile.Companion.CodingKeys.path);
        String trimmedPath = StringsKt.trim((CharSequence) path).toString();
        for (Map.Entry entry : INSTANCE.getSchemeHandlers().entrySet()) {
            Class handler = (Class) entry.getValue();
            if (StringsKt.startsWith(trimmedPath, (String) entry.getKey(), true)) {
                Object newInstance = handler.newInstance();
                ((SchemeHandler) newInstance).init(trimmedPath);
                Intrinsics.checkNotNullExpressionValue(newInstance, "handler.newInstance().ap…edPath)\n                }");
                return (SchemeHandler) newInstance;
            }
        }
        throw new UnsupportedOperationException("Unsupported scheme for " + path + ". Currently supported schemes are " + INSTANCE.getSchemeHandlers().keySet());
    }

    public String toString() {
        int i = Build.VERSION.SDK_INT;
        String namespace2 = getNamespace();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int i2 = idleTimeoutSeconds;
        int i3 = bufferSizeBytes;
        String name = httpStack.getClass().getName();
        long j = uploadProgressNotificationIntervalMillis;
        RetryPolicyConfig retryPolicyConfig = retryPolicy;
        boolean isForegroundService2 = isForegroundService();
        Set<Map.Entry<String, Class<? extends SchemeHandler>>> entrySet = getSchemeHandlers().entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "schemeHandlers.entries");
        return StringsKt.trimIndent("\n            {\n                \"uploadServiceVersion\": \"4.9.2\",\n                \"androidApiVersion\": " + i + ",\n                \"namespace\": \"" + namespace2 + "\",\n                \"deviceProcessors\": " + availableProcessors + ",\n                \"idleTimeoutSeconds\": " + i2 + ",\n                \"bufferSizeBytes\": " + i3 + ",\n                \"httpStack\": \"" + name + "\",\n                \"uploadProgressNotificationIntervalMillis\": " + j + ",\n                \"retryPolicy\": " + retryPolicyConfig + ",\n                \"isForegroundService\": " + isForegroundService2 + ",\n                \"schemeHandlers\": {" + CollectionsKt.joinToString$default(entrySet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, UploadServiceConfig$toString$1.INSTANCE, 31, (Object) null) + "}\n            }\n        ");
    }
}
