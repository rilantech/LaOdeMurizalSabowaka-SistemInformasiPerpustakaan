package net.gotev.uploadservice.logger;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0007J2\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0007J&\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lnet/gotev/uploadservice/logger/UploadServiceLogger;", "", "()V", "NA", "", "defaultLogger", "Lnet/gotev/uploadservice/logger/DefaultLoggerDelegate;", "logLevel", "Lnet/gotev/uploadservice/logger/UploadServiceLogger$LogLevel;", "loggerDelegate", "Lnet/gotev/uploadservice/logger/UploadServiceLogger$Delegate;", "debug", "", "component", "uploadId", "message", "Lkotlin/Function0;", "error", "exception", "", "info", "loggerWithLevel", "minLevel", "setDelegate", "delegate", "setDevelopmentMode", "devModeOn", "", "setLogLevel", "level", "Delegate", "LogLevel", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadServiceLogger.kt */
public final class UploadServiceLogger {
    public static final UploadServiceLogger INSTANCE = new UploadServiceLogger();
    public static final String NA = "N/A";
    private static final DefaultLoggerDelegate defaultLogger;
    private static LogLevel logLevel = LogLevel.Off;
    private static Delegate loggerDelegate;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J*\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lnet/gotev/uploadservice/logger/UploadServiceLogger$Delegate;", "", "debug", "", "component", "", "uploadId", "message", "error", "exception", "", "info", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UploadServiceLogger.kt */
    public interface Delegate {
        void debug(String str, String str2, String str3);

        void error(String str, String str2, String str3, Throwable th);

        void info(String str, String str2, String str3);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lnet/gotev/uploadservice/logger/UploadServiceLogger$LogLevel;", "", "(Ljava/lang/String;I)V", "Debug", "Info", "Error", "Off", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UploadServiceLogger.kt */
    public enum LogLevel {
        Debug,
        Info,
        Error,
        Off
    }

    @JvmStatic
    public static final void error(String str, String str2, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(str, "component");
        Intrinsics.checkNotNullParameter(str2, "uploadId");
        Intrinsics.checkNotNullParameter(function0, "message");
        error$default(str, str2, (Throwable) null, function0, 4, (Object) null);
    }

    private UploadServiceLogger() {
    }

    static {
        DefaultLoggerDelegate defaultLoggerDelegate = new DefaultLoggerDelegate();
        defaultLogger = defaultLoggerDelegate;
        loggerDelegate = defaultLoggerDelegate;
    }

    @JvmStatic
    public static final synchronized void setDelegate(Delegate delegate) {
        synchronized (UploadServiceLogger.class) {
            loggerDelegate = delegate == null ? defaultLogger : delegate;
        }
    }

    @JvmStatic
    public static final synchronized void setLogLevel(LogLevel level) {
        synchronized (UploadServiceLogger.class) {
            Intrinsics.checkNotNullParameter(level, "level");
            logLevel = level;
        }
    }

    @JvmStatic
    public static final synchronized void setDevelopmentMode(boolean devModeOn) {
        synchronized (UploadServiceLogger.class) {
            logLevel = devModeOn ? LogLevel.Debug : LogLevel.Off;
        }
    }

    private final Delegate loggerWithLevel(LogLevel minLevel) {
        if (logLevel.compareTo(minLevel) > 0 || logLevel == LogLevel.Off) {
            return null;
        }
        return loggerDelegate;
    }

    public static /* synthetic */ void error$default(String str, String str2, Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        error(str, str2, th, function0);
    }

    @JvmStatic
    public static final void error(String component, String uploadId, Throwable exception, Function0<String> message) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(uploadId, "uploadId");
        Intrinsics.checkNotNullParameter(message, "message");
        Delegate loggerWithLevel = INSTANCE.loggerWithLevel(LogLevel.Error);
        if (loggerWithLevel != null) {
            loggerWithLevel.error(component, uploadId, message.invoke(), exception);
        }
    }

    @JvmStatic
    public static final void info(String component, String uploadId, Function0<String> message) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(uploadId, "uploadId");
        Intrinsics.checkNotNullParameter(message, "message");
        Delegate loggerWithLevel = INSTANCE.loggerWithLevel(LogLevel.Info);
        if (loggerWithLevel != null) {
            loggerWithLevel.info(component, uploadId, message.invoke());
        }
    }

    @JvmStatic
    public static final void debug(String component, String uploadId, Function0<String> message) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(uploadId, "uploadId");
        Intrinsics.checkNotNullParameter(message, "message");
        Delegate loggerWithLevel = INSTANCE.loggerWithLevel(LogLevel.Debug);
        if (loggerWithLevel != null) {
            loggerWithLevel.debug(component, uploadId, message.invoke());
        }
    }
}
