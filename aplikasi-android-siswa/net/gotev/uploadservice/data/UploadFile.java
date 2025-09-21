package net.gotev.uploadservice.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.persistence.Persistable;
import net.gotev.uploadservice.persistence.PersistableData;
import net.gotev.uploadservice.schemehandlers.SchemeHandler;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003J)\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0013\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020 HÖ\u0001J\b\u0010%\u001a\u00020&H\u0016J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020 HÖ\u0001R!\u0010\b\u001a\u00020\t8FX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R*\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006."}, d2 = {"Lnet/gotev/uploadservice/data/UploadFile;", "Landroid/os/Parcelable;", "Lnet/gotev/uploadservice/persistence/Persistable;", "path", "", "properties", "Ljava/util/LinkedHashMap;", "(Ljava/lang/String;Ljava/util/LinkedHashMap;)V", "handler", "Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "getHandler$annotations", "()V", "getHandler", "()Lnet/gotev/uploadservice/schemehandlers/SchemeHandler;", "handler$delegate", "Lkotlin/Lazy;", "getPath", "()Ljava/lang/String;", "getProperties", "()Ljava/util/LinkedHashMap;", "value", "", "successfullyUploaded", "getSuccessfullyUploaded$annotations", "getSuccessfullyUploaded", "()Z", "setSuccessfullyUploaded", "(Z)V", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toPersistableData", "Lnet/gotev/uploadservice/persistence/PersistableData;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadFile.kt */
public final class UploadFile implements Parcelable, Persistable {
    public static final Parcelable.Creator<UploadFile> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String successfulUpload = "successful_upload";
    private final Lazy handler$delegate;
    private final String path;
    private final LinkedHashMap<String, String> properties;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UploadFile.kt */
    public static final class Creator implements Parcelable.Creator<UploadFile> {
        public final UploadFile createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new UploadFile(readString, linkedHashMap);
        }

        public final UploadFile[] newArray(int i) {
            return new UploadFile[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadFile(String str) {
        this(str, (LinkedHashMap) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, Companion.CodingKeys.path);
    }

    public static /* synthetic */ UploadFile copy$default(UploadFile uploadFile, String str, LinkedHashMap<String, String> linkedHashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadFile.path;
        }
        if ((i & 2) != 0) {
            linkedHashMap = uploadFile.properties;
        }
        return uploadFile.copy(str, linkedHashMap);
    }

    public static /* synthetic */ void getHandler$annotations() {
    }

    public static /* synthetic */ void getSuccessfullyUploaded$annotations() {
    }

    public final String component1() {
        return this.path;
    }

    public final LinkedHashMap<String, String> component2() {
        return this.properties;
    }

    public final UploadFile copy(String str, LinkedHashMap<String, String> linkedHashMap) {
        Intrinsics.checkNotNullParameter(str, Companion.CodingKeys.path);
        Intrinsics.checkNotNullParameter(linkedHashMap, "properties");
        return new UploadFile(str, linkedHashMap);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadFile)) {
            return false;
        }
        UploadFile uploadFile = (UploadFile) obj;
        return Intrinsics.areEqual((Object) this.path, (Object) uploadFile.path) && Intrinsics.areEqual((Object) this.properties, (Object) uploadFile.properties);
    }

    public int hashCode() {
        return (this.path.hashCode() * 31) + this.properties.hashCode();
    }

    public String toString() {
        String str = this.path;
        return "UploadFile(path=" + str + ", properties=" + this.properties + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.path);
        LinkedHashMap<String, String> linkedHashMap = this.properties;
        parcel.writeInt(linkedHashMap.size());
        for (Map.Entry next : linkedHashMap.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    public UploadFile(String path2, LinkedHashMap<String, String> properties2) {
        Intrinsics.checkNotNullParameter(path2, Companion.CodingKeys.path);
        Intrinsics.checkNotNullParameter(properties2, "properties");
        this.path = path2;
        this.properties = properties2;
        this.handler$delegate = LazyKt.lazy(new UploadFile$handler$2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadFile(String str, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new LinkedHashMap() : linkedHashMap);
    }

    public final String getPath() {
        return this.path;
    }

    public final LinkedHashMap<String, String> getProperties() {
        return this.properties;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lnet/gotev/uploadservice/data/UploadFile$Companion;", "Lnet/gotev/uploadservice/persistence/Persistable$Creator;", "Lnet/gotev/uploadservice/data/UploadFile;", "()V", "successfulUpload", "", "createFromPersistableData", "data", "Lnet/gotev/uploadservice/persistence/PersistableData;", "CodingKeys", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UploadFile.kt */
    public static final class Companion implements Persistable.Creator<UploadFile> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lnet/gotev/uploadservice/data/UploadFile$Companion$CodingKeys;", "", "()V", "path", "", "properties", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: UploadFile.kt */
        private static final class CodingKeys {
            public static final CodingKeys INSTANCE = new CodingKeys();
            public static final String path = "path";
            public static final String properties = "props";

            private CodingKeys() {
            }
        }

        public UploadFile createFromPersistableData(PersistableData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            String string = data.getString(CodingKeys.path);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap $this$createFromPersistableData_u24lambda_u241 = linkedHashMap;
            Bundle bundle = data.getData(CodingKeys.properties).toBundle();
            Set<String> $this$forEach$iv = bundle.keySet();
            Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "bundle.keySet()");
            for (String propKey : $this$forEach$iv) {
                String string2 = bundle.getString(propKey);
                Intrinsics.checkNotNull(string2);
                $this$createFromPersistableData_u24lambda_u241.put(propKey, string2);
            }
            return new UploadFile(string, linkedHashMap);
        }
    }

    public final SchemeHandler getHandler() {
        return (SchemeHandler) this.handler$delegate.getValue();
    }

    public final boolean getSuccessfullyUploaded() {
        String str = this.properties.get(successfulUpload);
        if (str != null) {
            return Boolean.parseBoolean(str);
        }
        return false;
    }

    public final void setSuccessfullyUploaded(boolean value) {
        this.properties.put(successfulUpload, String.valueOf(value));
    }

    public PersistableData toPersistableData() {
        PersistableData persistableData = new PersistableData();
        PersistableData $this$toPersistableData_u24lambda_u242 = persistableData;
        $this$toPersistableData_u24lambda_u242.putString(Companion.CodingKeys.path, this.path);
        PersistableData persistableData2 = new PersistableData();
        PersistableData $this$toPersistableData_u24lambda_u242_u24lambda_u241 = persistableData2;
        Set<Map.Entry<String, String>> $this$forEach$iv = this.properties.entrySet();
        Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "properties.entries");
        for (Map.Entry entry : $this$forEach$iv) {
            Intrinsics.checkNotNullExpressionValue(entry, "(propKey, propVal)");
            String propKey = (String) entry.getKey();
            String propVal = (String) entry.getValue();
            Intrinsics.checkNotNullExpressionValue(propKey, "propKey");
            Intrinsics.checkNotNullExpressionValue(propVal, "propVal");
            $this$toPersistableData_u24lambda_u242_u24lambda_u241.putString(propKey, propVal);
        }
        Unit unit = Unit.INSTANCE;
        $this$toPersistableData_u24lambda_u242.putData(Companion.CodingKeys.properties, persistableData2);
        return persistableData;
    }
}
