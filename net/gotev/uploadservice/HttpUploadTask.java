package net.gotev.uploadservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.HttpUploadTaskParameters;
import net.gotev.uploadservice.data.NameValue;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import net.gotev.uploadservice.network.BodyWriter;
import net.gotev.uploadservice.network.HttpRequest;
import net.gotev.uploadservice.network.HttpStack;
import net.gotev.uploadservice.network.ServerResponse;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0015R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8DX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lnet/gotev/uploadservice/HttpUploadTask;", "Lnet/gotev/uploadservice/UploadTask;", "Lnet/gotev/uploadservice/network/HttpRequest$RequestBodyDelegate;", "Lnet/gotev/uploadservice/network/BodyWriter$OnStreamWriteListener;", "()V", "bodyLength", "", "getBodyLength", "()J", "httpParams", "Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "getHttpParams", "()Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "httpParams$delegate", "Lkotlin/Lazy;", "onBytesWritten", "", "bytesWritten", "", "shouldContinueWriting", "", "upload", "httpStack", "Lnet/gotev/uploadservice/network/HttpStack;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpUploadTask.kt */
public abstract class HttpUploadTask extends UploadTask implements HttpRequest.RequestBodyDelegate, BodyWriter.OnStreamWriteListener {
    private final Lazy httpParams$delegate = LazyKt.lazy(new HttpUploadTask$httpParams$2(this));

    public abstract long getBodyLength();

    /* access modifiers changed from: protected */
    public final HttpUploadTaskParameters getHttpParams() {
        return (HttpUploadTaskParameters) this.httpParams$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void upload(HttpStack httpStack) throws Exception {
        Intrinsics.checkNotNullParameter(httpStack, "httpStack");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        UploadServiceLogger.debug(simpleName, getParams().getId(), HttpUploadTask$upload$1.INSTANCE);
        setAllFilesHaveBeenSuccessfullyUploaded(false);
        setTotalBytes(getBodyLength());
        HttpRequest newRequest = httpStack.newRequest(getParams().getId(), getHttpParams().getMethod(), getParams().getServerUrl());
        Iterable<NameValue> $this$map$iv = getHttpParams().getRequestHeaders();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (NameValue it : $this$map$iv) {
            destination$iv$iv.add(it.validateAsHeader());
        }
        ServerResponse response = newRequest.setHeaders((List) destination$iv$iv).setTotalBodyBytes(getTotalBytes(), getHttpParams().getUsesFixedLengthStreamingMode()).getResponse(this, this);
        String simpleName2 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName2, "javaClass.simpleName");
        UploadServiceLogger.debug(simpleName2, getParams().getId(), new HttpUploadTask$upload$2(response));
        if (getShouldContinue()) {
            if (response.isSuccessful()) {
                UploadTask.setAllFilesHaveBeenSuccessfullyUploaded$default(this, false, 1, (Object) null);
            }
            onResponseReceived(response);
        }
    }

    public boolean shouldContinueWriting() {
        return getShouldContinue();
    }

    public final void onBytesWritten(int bytesWritten) {
        onProgress((long) bytesWritten);
    }
}
