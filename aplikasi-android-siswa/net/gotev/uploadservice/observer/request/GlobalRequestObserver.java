package net.gotev.uploadservice.observer.request;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.UploadInfo;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B<\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lnet/gotev/uploadservice/observer/request/GlobalRequestObserver;", "Lnet/gotev/uploadservice/observer/request/BaseRequestObserver;", "application", "Landroid/app/Application;", "delegate", "Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;", "shouldAcceptEventsFrom", "Lkotlin/Function1;", "Lnet/gotev/uploadservice/data/UploadInfo;", "Lkotlin/ParameterName;", "name", "uploadInfo", "", "(Landroid/app/Application;Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;Lkotlin/jvm/functions/Function1;)V", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GlobalRequestObserver.kt */
public final class GlobalRequestObserver extends BaseRequestObserver {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GlobalRequestObserver(Application application, RequestObserverDelegate requestObserverDelegate) {
        this(application, requestObserverDelegate, (Function1) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(requestObserverDelegate, "delegate");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalRequestObserver(Application application, RequestObserverDelegate requestObserverDelegate, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, requestObserverDelegate, (i & 4) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalRequestObserver(Application application, RequestObserverDelegate delegate, Function1<? super UploadInfo, Boolean> shouldAcceptEventsFrom) {
        super(application, delegate, shouldAcceptEventsFrom);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(shouldAcceptEventsFrom, "shouldAcceptEventsFrom");
        register();
    }
}
