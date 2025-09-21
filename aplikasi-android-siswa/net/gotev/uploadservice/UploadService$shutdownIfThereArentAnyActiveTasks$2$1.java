package net.gotev.uploadservice;

import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.logger.UploadServiceLogger;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"net/gotev/uploadservice/UploadService$shutdownIfThereArentAnyActiveTasks$2$1", "Ljava/util/TimerTask;", "run", "", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadService.kt */
public final class UploadService$shutdownIfThereArentAnyActiveTasks$2$1 extends TimerTask {
    final /* synthetic */ UploadService this$0;

    UploadService$shutdownIfThereArentAnyActiveTasks$2$1(UploadService $receiver) {
        this.this$0 = $receiver;
    }

    public void run() {
        String tAG$uploadservice_release = UploadService.Companion.getTAG$uploadservice_release();
        Intrinsics.checkNotNullExpressionValue(tAG$uploadservice_release, "TAG");
        UploadServiceLogger.info(tAG$uploadservice_release, UploadServiceLogger.NA, UploadService$shutdownIfThereArentAnyActiveTasks$2$1$run$1.INSTANCE);
        this.this$0.stopSelf();
    }
}
