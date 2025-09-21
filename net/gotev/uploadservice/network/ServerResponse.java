package net.gotev.uploadservice.network;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import net.gotev.uploadservice.data.HttpUploadTaskParameters;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J%\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\nHÆ\u0003JC\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\nHÆ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\u0013\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\t\u0010$\u001a\u00020\tHÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8F¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\u00020\u00188F¢\u0006\f\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0017\u0010\u001a¨\u0006+"}, d2 = {"Lnet/gotev/uploadservice/network/ServerResponse;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "code", "", "body", "", "headers", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "(I[BLjava/util/LinkedHashMap;)V", "getBody", "()[B", "bodyString", "getBodyString$annotations", "()V", "getBodyString", "()Ljava/lang/String;", "getCode", "()I", "getHeaders", "()Ljava/util/LinkedHashMap;", "isSuccessful", "", "isSuccessful$annotations", "()Z", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ServerResponse.kt */
public final class ServerResponse implements Parcelable, Serializable {
    public static final Parcelable.Creator<ServerResponse> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final byte[] body;
    private final int code;
    private final LinkedHashMap<String, String> headers;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ServerResponse.kt */
    public static final class Creator implements Parcelable.Creator<ServerResponse> {
        public final ServerResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            byte[] createByteArray = parcel.createByteArray();
            int readInt2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
            for (int i = 0; i != readInt2; i++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new ServerResponse(readInt, createByteArray, linkedHashMap);
        }

        public final ServerResponse[] newArray(int i) {
            return new ServerResponse[i];
        }
    }

    public static /* synthetic */ ServerResponse copy$default(ServerResponse serverResponse, int i, byte[] bArr, LinkedHashMap<String, String> linkedHashMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = serverResponse.code;
        }
        if ((i2 & 2) != 0) {
            bArr = serverResponse.body;
        }
        if ((i2 & 4) != 0) {
            linkedHashMap = serverResponse.headers;
        }
        return serverResponse.copy(i, bArr, linkedHashMap);
    }

    public static /* synthetic */ void getBodyString$annotations() {
    }

    public static /* synthetic */ void isSuccessful$annotations() {
    }

    public final int component1() {
        return this.code;
    }

    public final byte[] component2() {
        return this.body;
    }

    public final LinkedHashMap<String, String> component3() {
        return this.headers;
    }

    public final ServerResponse copy(int i, byte[] bArr, LinkedHashMap<String, String> linkedHashMap) {
        Intrinsics.checkNotNullParameter(bArr, "body");
        Intrinsics.checkNotNullParameter(linkedHashMap, HttpUploadTaskParameters.Companion.CodingKeys.headers);
        return new ServerResponse(i, bArr, linkedHashMap);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServerResponse)) {
            return false;
        }
        ServerResponse serverResponse = (ServerResponse) obj;
        return this.code == serverResponse.code && Intrinsics.areEqual((Object) this.body, (Object) serverResponse.body) && Intrinsics.areEqual((Object) this.headers, (Object) serverResponse.headers);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.code) * 31) + Arrays.hashCode(this.body)) * 31) + this.headers.hashCode();
    }

    public String toString() {
        int i = this.code;
        String arrays = Arrays.toString(this.body);
        return "ServerResponse(code=" + i + ", body=" + arrays + ", headers=" + this.headers + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.code);
        parcel.writeByteArray(this.body);
        LinkedHashMap<String, String> linkedHashMap = this.headers;
        parcel.writeInt(linkedHashMap.size());
        for (Map.Entry next : linkedHashMap.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    public ServerResponse(int code2, byte[] body2, LinkedHashMap<String, String> headers2) {
        Intrinsics.checkNotNullParameter(body2, "body");
        Intrinsics.checkNotNullParameter(headers2, HttpUploadTaskParameters.Companion.CodingKeys.headers);
        this.code = code2;
        this.body = body2;
        this.headers = headers2;
    }

    public final int getCode() {
        return this.code;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final LinkedHashMap<String, String> getHeaders() {
        return this.headers;
    }

    public final String getBodyString() {
        return new String(this.body, Charsets.UTF_8);
    }

    public final boolean isSuccessful() {
        int i = this.code;
        return 200 <= i && i < 400;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lnet/gotev/uploadservice/network/ServerResponse$Companion;", "", "()V", "successfulEmpty", "Lnet/gotev/uploadservice/network/ServerResponse;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ServerResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ServerResponse successfulEmpty() {
            return new ServerResponse(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, new byte[1], new LinkedHashMap());
        }
    }
}
