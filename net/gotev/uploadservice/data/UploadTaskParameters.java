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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eHÆ\u0003J\t\u0010$\u001a\u00020\u0010HÆ\u0003J_\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\t\u0010&\u001a\u00020\bHÖ\u0001J\u0013\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\b\u0010+\u001a\u00020\u0010H\u0016J\t\u0010,\u001a\u00020\u0004HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\bHÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019¨\u00063"}, d2 = {"Lnet/gotev/uploadservice/data/UploadTaskParameters;", "Landroid/os/Parcelable;", "Lnet/gotev/uploadservice/persistence/Persistable;", "taskClass", "", "id", "serverUrl", "maxRetries", "", "autoDeleteSuccessfullyUploadedFiles", "", "files", "Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/data/UploadFile;", "Lkotlin/collections/ArrayList;", "additionalParameters", "Lnet/gotev/uploadservice/persistence/PersistableData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/util/ArrayList;Lnet/gotev/uploadservice/persistence/PersistableData;)V", "getAdditionalParameters", "()Lnet/gotev/uploadservice/persistence/PersistableData;", "getAutoDeleteSuccessfullyUploadedFiles", "()Z", "getFiles", "()Ljava/util/ArrayList;", "getId", "()Ljava/lang/String;", "getMaxRetries", "()I", "getServerUrl", "getTaskClass", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "toPersistableData", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UploadTaskParameters.kt */
public final class UploadTaskParameters implements Parcelable, Persistable {
    public static final Parcelable.Creator<UploadTaskParameters> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final PersistableData additionalParameters;
    private final boolean autoDeleteSuccessfullyUploadedFiles;
    private final ArrayList<UploadFile> files;
    private final String id;
    private final int maxRetries;
    private final String serverUrl;
    private final String taskClass;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UploadTaskParameters.kt */
    public static final class Creator implements Parcelable.Creator<UploadTaskParameters> {
        public final UploadTaskParameters createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            boolean z = parcel.readInt() != 0;
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i != readInt2; i++) {
                arrayList.add(UploadFile.CREATOR.createFromParcel(parcel));
            }
            return new UploadTaskParameters(readString, readString2, readString3, readInt, z, arrayList, (PersistableData) parcel.readParcelable(UploadTaskParameters.class.getClassLoader()));
        }

        public final UploadTaskParameters[] newArray(int i) {
            return new UploadTaskParameters[i];
        }
    }

    public static /* synthetic */ UploadTaskParameters copy$default(UploadTaskParameters uploadTaskParameters, String str, String str2, String str3, int i, boolean z, ArrayList<UploadFile> arrayList, PersistableData persistableData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = uploadTaskParameters.taskClass;
        }
        if ((i2 & 2) != 0) {
            str2 = uploadTaskParameters.id;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = uploadTaskParameters.serverUrl;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            i = uploadTaskParameters.maxRetries;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            z = uploadTaskParameters.autoDeleteSuccessfullyUploadedFiles;
        }
        boolean z2 = z;
        if ((i2 & 32) != 0) {
            arrayList = uploadTaskParameters.files;
        }
        ArrayList<UploadFile> arrayList2 = arrayList;
        if ((i2 & 64) != 0) {
            persistableData = uploadTaskParameters.additionalParameters;
        }
        return uploadTaskParameters.copy(str, str4, str5, i3, z2, arrayList2, persistableData);
    }

    public final String component1() {
        return this.taskClass;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.serverUrl;
    }

    public final int component4() {
        return this.maxRetries;
    }

    public final boolean component5() {
        return this.autoDeleteSuccessfullyUploadedFiles;
    }

    public final ArrayList<UploadFile> component6() {
        return this.files;
    }

    public final PersistableData component7() {
        return this.additionalParameters;
    }

    public final UploadTaskParameters copy(String str, String str2, String str3, int i, boolean z, ArrayList<UploadFile> arrayList, PersistableData persistableData) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str, Companion.CodingKeys.taskClass);
        Intrinsics.checkNotNullParameter(str2, Companion.CodingKeys.id);
        Intrinsics.checkNotNullParameter(str3, Companion.CodingKeys.serverUrl);
        Intrinsics.checkNotNullParameter(arrayList, Companion.CodingKeys.files);
        Intrinsics.checkNotNullParameter(persistableData, "additionalParameters");
        return new UploadTaskParameters(str, str2, str3, i, z, arrayList, persistableData);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadTaskParameters)) {
            return false;
        }
        UploadTaskParameters uploadTaskParameters = (UploadTaskParameters) obj;
        return Intrinsics.areEqual((Object) this.taskClass, (Object) uploadTaskParameters.taskClass) && Intrinsics.areEqual((Object) this.id, (Object) uploadTaskParameters.id) && Intrinsics.areEqual((Object) this.serverUrl, (Object) uploadTaskParameters.serverUrl) && this.maxRetries == uploadTaskParameters.maxRetries && this.autoDeleteSuccessfullyUploadedFiles == uploadTaskParameters.autoDeleteSuccessfullyUploadedFiles && Intrinsics.areEqual((Object) this.files, (Object) uploadTaskParameters.files) && Intrinsics.areEqual((Object) this.additionalParameters, (Object) uploadTaskParameters.additionalParameters);
    }

    public int hashCode() {
        int hashCode = ((((((this.taskClass.hashCode() * 31) + this.id.hashCode()) * 31) + this.serverUrl.hashCode()) * 31) + Integer.hashCode(this.maxRetries)) * 31;
        boolean z = this.autoDeleteSuccessfullyUploadedFiles;
        if (z) {
            z = true;
        }
        return ((((hashCode + (z ? 1 : 0)) * 31) + this.files.hashCode()) * 31) + this.additionalParameters.hashCode();
    }

    public String toString() {
        String str = this.taskClass;
        String str2 = this.id;
        String str3 = this.serverUrl;
        int i = this.maxRetries;
        boolean z = this.autoDeleteSuccessfullyUploadedFiles;
        ArrayList<UploadFile> arrayList = this.files;
        return "UploadTaskParameters(taskClass=" + str + ", id=" + str2 + ", serverUrl=" + str3 + ", maxRetries=" + i + ", autoDeleteSuccessfullyUploadedFiles=" + z + ", files=" + arrayList + ", additionalParameters=" + this.additionalParameters + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.taskClass);
        parcel.writeString(this.id);
        parcel.writeString(this.serverUrl);
        parcel.writeInt(this.maxRetries);
        parcel.writeInt(this.autoDeleteSuccessfullyUploadedFiles ? 1 : 0);
        ArrayList<UploadFile> arrayList = this.files;
        parcel.writeInt(arrayList.size());
        Iterator<UploadFile> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, i);
        }
        parcel.writeParcelable(this.additionalParameters, i);
    }

    public UploadTaskParameters(String taskClass2, String id2, String serverUrl2, int maxRetries2, boolean autoDeleteSuccessfullyUploadedFiles2, ArrayList<UploadFile> files2, PersistableData additionalParameters2) {
        Intrinsics.checkNotNullParameter(taskClass2, Companion.CodingKeys.taskClass);
        Intrinsics.checkNotNullParameter(id2, Companion.CodingKeys.id);
        Intrinsics.checkNotNullParameter(serverUrl2, Companion.CodingKeys.serverUrl);
        Intrinsics.checkNotNullParameter(files2, Companion.CodingKeys.files);
        Intrinsics.checkNotNullParameter(additionalParameters2, "additionalParameters");
        this.taskClass = taskClass2;
        this.id = id2;
        this.serverUrl = serverUrl2;
        this.maxRetries = maxRetries2;
        this.autoDeleteSuccessfullyUploadedFiles = autoDeleteSuccessfullyUploadedFiles2;
        this.files = files2;
        this.additionalParameters = additionalParameters2;
    }

    public final String getTaskClass() {
        return this.taskClass;
    }

    public final String getId() {
        return this.id;
    }

    public final String getServerUrl() {
        return this.serverUrl;
    }

    public final int getMaxRetries() {
        return this.maxRetries;
    }

    public final boolean getAutoDeleteSuccessfullyUploadedFiles() {
        return this.autoDeleteSuccessfullyUploadedFiles;
    }

    public final ArrayList<UploadFile> getFiles() {
        return this.files;
    }

    public final PersistableData getAdditionalParameters() {
        return this.additionalParameters;
    }

    public PersistableData toPersistableData() {
        PersistableData persistableData = new PersistableData();
        PersistableData $this$toPersistableData_u24lambda_u241 = persistableData;
        $this$toPersistableData_u24lambda_u241.putString(Companion.CodingKeys.taskClass, this.taskClass);
        $this$toPersistableData_u24lambda_u241.putString(Companion.CodingKeys.id, this.id);
        $this$toPersistableData_u24lambda_u241.putString(Companion.CodingKeys.serverUrl, this.serverUrl);
        $this$toPersistableData_u24lambda_u241.putInt(Companion.CodingKeys.maxRetries, this.maxRetries);
        $this$toPersistableData_u24lambda_u241.putBoolean(Companion.CodingKeys.autoDeleteFiles, this.autoDeleteSuccessfullyUploadedFiles);
        Iterable<UploadFile> $this$map$iv = this.files;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (UploadFile it : $this$map$iv) {
            destination$iv$iv.add(it.toPersistableData());
        }
        $this$toPersistableData_u24lambda_u241.putArrayData(Companion.CodingKeys.files, (List) destination$iv$iv);
        $this$toPersistableData_u24lambda_u241.putData("params", this.additionalParameters);
        return persistableData;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lnet/gotev/uploadservice/data/UploadTaskParameters$Companion;", "Lnet/gotev/uploadservice/persistence/Persistable$Creator;", "Lnet/gotev/uploadservice/data/UploadTaskParameters;", "()V", "createFromPersistableData", "data", "Lnet/gotev/uploadservice/persistence/PersistableData;", "CodingKeys", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UploadTaskParameters.kt */
    public static final class Companion implements Persistable.Creator<UploadTaskParameters> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lnet/gotev/uploadservice/data/UploadTaskParameters$Companion$CodingKeys;", "", "()V", "autoDeleteFiles", "", "files", "id", "maxRetries", "params", "serverUrl", "taskClass", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: UploadTaskParameters.kt */
        private static final class CodingKeys {
            public static final CodingKeys INSTANCE = new CodingKeys();
            public static final String autoDeleteFiles = "autoDeleteFiles";
            public static final String files = "files";
            public static final String id = "id";
            public static final String maxRetries = "maxRetries";
            public static final String params = "params";
            public static final String serverUrl = "serverUrl";
            public static final String taskClass = "taskClass";

            private CodingKeys() {
            }
        }

        private Companion() {
        }

        public UploadTaskParameters createFromPersistableData(PersistableData data) {
            PersistableData persistableData = data;
            Intrinsics.checkNotNullParameter(persistableData, "data");
            String string = persistableData.getString(CodingKeys.taskClass);
            String string2 = persistableData.getString(CodingKeys.id);
            String string3 = persistableData.getString(CodingKeys.serverUrl);
            int i = persistableData.getInt(CodingKeys.maxRetries);
            boolean z = persistableData.getBoolean(CodingKeys.autoDeleteFiles);
            Iterable<PersistableData> $this$map$iv = persistableData.getArrayData(CodingKeys.files);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (PersistableData it : $this$map$iv) {
                destination$iv$iv.add(UploadFile.Companion.createFromPersistableData(it));
            }
            return new UploadTaskParameters(string, string2, string3, i, z, new ArrayList((List) destination$iv$iv), persistableData.getData("params"));
        }
    }
}
