package net.gotev.uploadservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.persistence.Persistable;
import net.gotev.uploadservice.persistence.PersistableData;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001dHÖ\u0001J\b\u0010\"\u001a\u00020#H\u0016J\t\u0010$\u001a\u00020\u0004HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "Landroid/os/Parcelable;", "Lnet/gotev/uploadservice/persistence/Persistable;", "method", "", "usesFixedLengthStreamingMode", "", "requestHeaders", "Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/data/NameValue;", "requestParameters", "(Ljava/lang/String;ZLjava/util/ArrayList;Ljava/util/ArrayList;)V", "getMethod", "()Ljava/lang/String;", "setMethod", "(Ljava/lang/String;)V", "getRequestHeaders", "()Ljava/util/ArrayList;", "getRequestParameters", "getUsesFixedLengthStreamingMode", "()Z", "setUsesFixedLengthStreamingMode", "(Z)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toPersistableData", "Lnet/gotev/uploadservice/persistence/PersistableData;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HttpUploadTaskParameters.kt */
public final class HttpUploadTaskParameters implements Parcelable, Persistable {
    public static final Parcelable.Creator<HttpUploadTaskParameters> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private String method;
    private final ArrayList<NameValue> requestHeaders;
    private final ArrayList<NameValue> requestParameters;
    private boolean usesFixedLengthStreamingMode;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HttpUploadTaskParameters.kt */
    public static final class Creator implements Parcelable.Creator<HttpUploadTaskParameters> {
        public final HttpUploadTaskParameters createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            boolean z = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(NameValue.CREATOR.createFromParcel(parcel));
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            for (int i2 = 0; i2 != readInt2; i2++) {
                arrayList2.add(NameValue.CREATOR.createFromParcel(parcel));
            }
            return new HttpUploadTaskParameters(readString, z, arrayList, arrayList2);
        }

        public final HttpUploadTaskParameters[] newArray(int i) {
            return new HttpUploadTaskParameters[i];
        }
    }

    public HttpUploadTaskParameters() {
        this((String) null, false, (ArrayList) null, (ArrayList) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HttpUploadTaskParameters copy$default(HttpUploadTaskParameters httpUploadTaskParameters, String str, boolean z, ArrayList<NameValue> arrayList, ArrayList<NameValue> arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = httpUploadTaskParameters.method;
        }
        if ((i & 2) != 0) {
            z = httpUploadTaskParameters.usesFixedLengthStreamingMode;
        }
        if ((i & 4) != 0) {
            arrayList = httpUploadTaskParameters.requestHeaders;
        }
        if ((i & 8) != 0) {
            arrayList2 = httpUploadTaskParameters.requestParameters;
        }
        return httpUploadTaskParameters.copy(str, z, arrayList, arrayList2);
    }

    public final String component1() {
        return this.method;
    }

    public final boolean component2() {
        return this.usesFixedLengthStreamingMode;
    }

    public final ArrayList<NameValue> component3() {
        return this.requestHeaders;
    }

    public final ArrayList<NameValue> component4() {
        return this.requestParameters;
    }

    public final HttpUploadTaskParameters copy(String str, boolean z, ArrayList<NameValue> arrayList, ArrayList<NameValue> arrayList2) {
        Intrinsics.checkNotNullParameter(str, Companion.CodingKeys.method);
        Intrinsics.checkNotNullParameter(arrayList, "requestHeaders");
        Intrinsics.checkNotNullParameter(arrayList2, "requestParameters");
        return new HttpUploadTaskParameters(str, z, arrayList, arrayList2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpUploadTaskParameters)) {
            return false;
        }
        HttpUploadTaskParameters httpUploadTaskParameters = (HttpUploadTaskParameters) obj;
        return Intrinsics.areEqual((Object) this.method, (Object) httpUploadTaskParameters.method) && this.usesFixedLengthStreamingMode == httpUploadTaskParameters.usesFixedLengthStreamingMode && Intrinsics.areEqual((Object) this.requestHeaders, (Object) httpUploadTaskParameters.requestHeaders) && Intrinsics.areEqual((Object) this.requestParameters, (Object) httpUploadTaskParameters.requestParameters);
    }

    public int hashCode() {
        int hashCode = this.method.hashCode() * 31;
        boolean z = this.usesFixedLengthStreamingMode;
        if (z) {
            z = true;
        }
        return ((((hashCode + (z ? 1 : 0)) * 31) + this.requestHeaders.hashCode()) * 31) + this.requestParameters.hashCode();
    }

    public String toString() {
        String str = this.method;
        boolean z = this.usesFixedLengthStreamingMode;
        ArrayList<NameValue> arrayList = this.requestHeaders;
        return "HttpUploadTaskParameters(method=" + str + ", usesFixedLengthStreamingMode=" + z + ", requestHeaders=" + arrayList + ", requestParameters=" + this.requestParameters + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.method);
        parcel.writeInt(this.usesFixedLengthStreamingMode ? 1 : 0);
        ArrayList<NameValue> arrayList = this.requestHeaders;
        parcel.writeInt(arrayList.size());
        Iterator<NameValue> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, i);
        }
        ArrayList<NameValue> arrayList2 = this.requestParameters;
        parcel.writeInt(arrayList2.size());
        Iterator<NameValue> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, i);
        }
    }

    public HttpUploadTaskParameters(String method2, boolean usesFixedLengthStreamingMode2, ArrayList<NameValue> requestHeaders2, ArrayList<NameValue> requestParameters2) {
        Intrinsics.checkNotNullParameter(method2, Companion.CodingKeys.method);
        Intrinsics.checkNotNullParameter(requestHeaders2, "requestHeaders");
        Intrinsics.checkNotNullParameter(requestParameters2, "requestParameters");
        this.method = method2;
        this.usesFixedLengthStreamingMode = usesFixedLengthStreamingMode2;
        this.requestHeaders = requestHeaders2;
        this.requestParameters = requestParameters2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HttpUploadTaskParameters(String str, boolean z, ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "POST" : str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? new ArrayList(5) : arrayList, (i & 8) != 0 ? new ArrayList(5) : arrayList2);
    }

    public final String getMethod() {
        return this.method;
    }

    public final void setMethod(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.method = str;
    }

    public final boolean getUsesFixedLengthStreamingMode() {
        return this.usesFixedLengthStreamingMode;
    }

    public final void setUsesFixedLengthStreamingMode(boolean z) {
        this.usesFixedLengthStreamingMode = z;
    }

    public final ArrayList<NameValue> getRequestHeaders() {
        return this.requestHeaders;
    }

    public final ArrayList<NameValue> getRequestParameters() {
        return this.requestParameters;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b*\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0002¨\u0006\r"}, d2 = {"Lnet/gotev/uploadservice/data/HttpUploadTaskParameters$Companion;", "Lnet/gotev/uploadservice/persistence/Persistable$Creator;", "Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "()V", "createFromPersistableData", "data", "Lnet/gotev/uploadservice/persistence/PersistableData;", "toNameValueArrayList", "Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/data/NameValue;", "kotlin.jvm.PlatformType", "", "CodingKeys", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HttpUploadTaskParameters.kt */
    public static final class Companion implements Persistable.Creator<HttpUploadTaskParameters> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lnet/gotev/uploadservice/data/HttpUploadTaskParameters$Companion$CodingKeys;", "", "()V", "fixedLength", "", "headers", "method", "parameters", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: HttpUploadTaskParameters.kt */
        private static final class CodingKeys {
            public static final CodingKeys INSTANCE = new CodingKeys();
            public static final String fixedLength = "fixedLength";
            public static final String headers = "headers";
            public static final String method = "method";
            public static final String parameters = "params";

            private CodingKeys() {
            }
        }

        private Companion() {
        }

        private final ArrayList<NameValue> toNameValueArrayList(List<? extends PersistableData> $this$toNameValueArrayList) {
            Iterable<PersistableData> $this$map$iv = $this$toNameValueArrayList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (PersistableData it : $this$map$iv) {
                destination$iv$iv.add(NameValue.Companion.createFromPersistableData(it));
            }
            return new ArrayList<>((List) destination$iv$iv);
        }

        public HttpUploadTaskParameters createFromPersistableData(PersistableData data) {
            ArrayList<NameValue> arrayList;
            ArrayList<NameValue> arrayList2;
            Intrinsics.checkNotNullParameter(data, "data");
            String string = data.getString(CodingKeys.method);
            boolean z = data.getBoolean(CodingKeys.fixedLength);
            try {
                arrayList = toNameValueArrayList(data.getArrayData(CodingKeys.headers));
            } catch (Throwable th) {
                arrayList = new ArrayList<>();
            }
            try {
                arrayList2 = toNameValueArrayList(data.getArrayData("params"));
            } catch (Throwable th2) {
                arrayList2 = new ArrayList<>();
            }
            return new HttpUploadTaskParameters(string, z, arrayList, arrayList2);
        }
    }

    public PersistableData toPersistableData() {
        PersistableData persistableData = new PersistableData();
        PersistableData $this$toPersistableData_u24lambda_u242 = persistableData;
        $this$toPersistableData_u24lambda_u242.putString(Companion.CodingKeys.method, this.method);
        $this$toPersistableData_u24lambda_u242.putBoolean(Companion.CodingKeys.fixedLength, this.usesFixedLengthStreamingMode);
        Iterable<NameValue> $this$map$iv = this.requestHeaders;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (NameValue it : $this$map$iv) {
            destination$iv$iv.add(it.toPersistableData());
        }
        $this$toPersistableData_u24lambda_u242.putArrayData(Companion.CodingKeys.headers, (List) destination$iv$iv);
        Iterable<NameValue> $this$map$iv2 = this.requestParameters;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (NameValue it2 : $this$map$iv2) {
            destination$iv$iv2.add(it2.toPersistableData());
        }
        $this$toPersistableData_u24lambda_u242.putArrayData("params", (List) destination$iv$iv2);
        return persistableData;
    }
}
