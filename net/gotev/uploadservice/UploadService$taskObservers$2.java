package net.gotev.uploadservice;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.observer.task.BroadcastEmitter;
import net.gotev.uploadservice.observer.task.TaskCompletionNotifier;
import net.gotev.uploadservice.observer.task.UploadTaskObserver;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "invoke", "()[Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadService.kt */
final class UploadService$taskObservers$2 extends Lambda implements Function0<UploadTaskObserver[]> {
    final /* synthetic */ UploadService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UploadService$taskObservers$2(UploadService uploadService) {
        super(0);
        this.this$0 = uploadService;
    }

    public final UploadTaskObserver[] invoke() {
        return new UploadTaskObserver[]{new BroadcastEmitter(this.this$0), UploadServiceConfig.getNotificationHandlerFactory().invoke(this.this$0), new TaskCompletionNotifier(this.this$0)};
    }
}
