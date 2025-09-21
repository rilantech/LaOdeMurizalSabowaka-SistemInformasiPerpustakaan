package net.gotev.uploadservice.observer.request;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.data.UploadInfo;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "uploadInfo", "Lnet/gotev/uploadservice/data/UploadInfo;", "invoke", "(Lnet/gotev/uploadservice/data/UploadInfo;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RequestObserver.kt */
final class RequestObserver$subscribe$1 extends Lambda implements Function1<UploadInfo, Boolean> {
    final /* synthetic */ RequestObserver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RequestObserver$subscribe$1(RequestObserver requestObserver) {
        super(1);
        this.this$0 = requestObserver;
    }

    public final Boolean invoke(UploadInfo uploadInfo) {
        Intrinsics.checkNotNullParameter(uploadInfo, "uploadInfo");
        String it = this.this$0.subscribedUploadID;
        return Boolean.valueOf(it != null ? Intrinsics.areEqual((Object) it, (Object) uploadInfo.getUploadId()) : false);
    }
}
