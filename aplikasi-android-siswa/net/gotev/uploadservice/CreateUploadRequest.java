package net.gotev.uploadservice;

import android.content.Context;
import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.UploadTaskParameters;
import net.gotev.uploadservice.persistence.PersistableData;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b8TX\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lnet/gotev/uploadservice/CreateUploadRequest;", "Lnet/gotev/uploadservice/UploadRequest;", "context", "Landroid/content/Context;", "params", "Lnet/gotev/uploadservice/data/UploadTaskParameters;", "(Landroid/content/Context;Lnet/gotev/uploadservice/data/UploadTaskParameters;)V", "taskClass", "Ljava/lang/Class;", "Lnet/gotev/uploadservice/UploadTask;", "getTaskClass$annotations", "()V", "getTaskClass", "()Ljava/lang/Class;", "getAdditionalParameters", "Lnet/gotev/uploadservice/persistence/PersistableData;", "Companion", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CreateUploadRequest.kt */
public final class CreateUploadRequest extends UploadRequest<CreateUploadRequest> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final UploadTaskParameters params;

    public /* synthetic */ CreateUploadRequest(Context context, UploadTaskParameters uploadTaskParameters, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, uploadTaskParameters);
    }

    @JvmStatic
    public static final CreateUploadRequest fromJson(Context context, String str) {
        return Companion.fromJson(context, str);
    }

    @JvmStatic
    public static final CreateUploadRequest fromParcel(Context context, Parcel parcel) {
        return Companion.fromParcel(context, parcel);
    }

    @JvmStatic
    public static final CreateUploadRequest fromPersistableData(Context context, PersistableData persistableData) {
        return Companion.fromPersistableData(context, persistableData);
    }

    protected static /* synthetic */ void getTaskClass$annotations() {
    }

    private CreateUploadRequest(Context context, UploadTaskParameters params2) {
        super(context, "https://empty");
        this.params = params2;
        setUploadID(params2.getId());
        setAutoDeleteSuccessfullyUploadedFiles(params2.getAutoDeleteSuccessfullyUploadedFiles());
        getFiles().addAll(params2.getFiles());
        setMaxRetries(params2.getMaxRetries());
        setServerUrl(params2.getServerUrl());
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lnet/gotev/uploadservice/CreateUploadRequest$Companion;", "", "()V", "fromJson", "Lnet/gotev/uploadservice/CreateUploadRequest;", "context", "Landroid/content/Context;", "json", "", "fromParcel", "parcel", "Landroid/os/Parcel;", "fromPersistableData", "data", "Lnet/gotev/uploadservice/persistence/PersistableData;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CreateUploadRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CreateUploadRequest fromJson(Context context, String json) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(json, "json");
            return fromPersistableData(context, PersistableData.CREATOR.fromJson(json));
        }

        @JvmStatic
        public final CreateUploadRequest fromParcel(Context context, Parcel parcel) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return fromPersistableData(context, PersistableData.CREATOR.createFromParcel(parcel));
        }

        @JvmStatic
        public final CreateUploadRequest fromPersistableData(Context context, PersistableData data) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            return new CreateUploadRequest(context, UploadTaskParameters.Companion.createFromPersistableData(data), (DefaultConstructorMarker) null);
        }
    }

    /* access modifiers changed from: protected */
    public Class<? extends UploadTask> getTaskClass() {
        Class<?> cls = Class.forName(this.params.getTaskClass());
        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<out net.gotev.uploadservice.UploadTask>");
        return cls;
    }

    /* access modifiers changed from: protected */
    public PersistableData getAdditionalParameters() {
        return this.params.getAdditionalParameters();
    }
}
