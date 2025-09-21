package net.gotev.uploadservice.persistence;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.gotev.uploadservice.data.NameValue;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\b\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u00132\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u001c\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013J\u0016\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0010J\u0016\u0010!\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0000J\u0016\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0017J\u0016\u0010#\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000eJ\u0016\u0010$\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001aJ\u0016\u0010%\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bJ\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\bJ\u0018\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u000eH\u0016J\u0016\u0010,\u001a\u00020\b*\u00020\b2\b\b\u0002\u0010-\u001a\u00020\u0010H\u0002R0\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006/"}, d2 = {"Lnet/gotev/uploadservice/persistence/PersistableData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "data", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getData", "()Ljava/util/HashMap;", "describeContents", "", "equals", "", "other", "getArrayData", "", "key", "getBoolean", "getDouble", "", "getInt", "getLong", "", "getString", "hashCode", "putArrayData", "", "putBoolean", "value", "putData", "putDouble", "putInt", "putLong", "putString", "toBundle", "Landroid/os/Bundle;", "toJson", "writeToParcel", "dest", "flags", "validated", "checkExists", "CREATOR", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PersistableData.kt */
public class PersistableData implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private static final String separator = "$";
    private final HashMap<String, Object> data;

    public /* synthetic */ PersistableData(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @JvmStatic
    public static final PersistableData fromJson(String str) {
        return CREATOR.fromJson(str);
    }

    public PersistableData() {
        this.data = new HashMap<>();
    }

    /* access modifiers changed from: protected */
    public final HashMap<String, Object> getData() {
        return this.data;
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof PersistableData)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.data, (Object) ((PersistableData) other).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    private PersistableData(Parcel parcel) {
        this();
        Bundle bundle = parcel.readBundle();
        if (bundle != null) {
            Set<String> $this$forEach$iv = bundle.keySet();
            Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "bundle.keySet()");
            for (String key : $this$forEach$iv) {
                Object value = bundle.get(key);
                if (!(value instanceof Boolean ? true : value instanceof Double ? true : value instanceof Integer ? true : value instanceof Long) ? value instanceof String : true) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    this.data.put(key, value);
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        toBundle().writeToParcel(dest, flags);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lnet/gotev/uploadservice/persistence/PersistableData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lnet/gotev/uploadservice/persistence/PersistableData;", "()V", "separator", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "fromJson", "rawJsonString", "newArray", "", "size", "", "(I)[Lnet/gotev/uploadservice/persistence/PersistableData;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PersistableData.kt */
    public static final class CREATOR implements Parcelable.Creator<PersistableData> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public PersistableData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PersistableData(parcel, (DefaultConstructorMarker) null);
        }

        public PersistableData[] newArray(int size) {
            return new PersistableData[size];
        }

        @JvmStatic
        public final PersistableData fromJson(String rawJsonString) {
            Intrinsics.checkNotNullParameter(rawJsonString, "rawJsonString");
            JSONObject json = new JSONObject(rawJsonString);
            PersistableData data = new PersistableData();
            Iterator $this$forEach$iv = json.keys();
            Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "json.keys()");
            while ($this$forEach$iv.hasNext()) {
                String key = $this$forEach$iv.next();
                Object value = json.get(key);
                boolean z = true;
                if (!(value instanceof Boolean ? true : value instanceof Double ? true : value instanceof Integer ? true : value instanceof Long)) {
                    z = value instanceof String;
                }
                if (z) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    Intrinsics.checkNotNullExpressionValue(value, NameValue.Companion.CodingKeys.value);
                    data.getData().put(key, value);
                }
            }
            return data;
        }
    }

    static /* synthetic */ String validated$default(PersistableData persistableData, String str, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            return persistableData.validated(str, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validated");
    }

    private final String validated(String $this$validated, boolean checkExists) {
        if (StringsKt.contains$default((CharSequence) $this$validated, (CharSequence) separator, false, 2, (Object) null)) {
            throw new IllegalArgumentException("key cannot contain $ as it's a reserved character, used for nested data");
        } else if (!checkExists || this.data.containsKey($this$validated)) {
            return $this$validated;
        } else {
            throw new IllegalArgumentException("no data found for key \"" + $this$validated + "\"");
        }
    }

    public final void putBoolean(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.data.put(validated$default(this, key, false, 1, (Object) null), Boolean.valueOf(value));
    }

    public final boolean getBoolean(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.data.get(validated(key, true));
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) obj).booleanValue();
    }

    public final void putDouble(String key, double value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.data.put(validated$default(this, key, false, 1, (Object) null), Double.valueOf(value));
    }

    public final double getDouble(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.data.get(validated(key, true));
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) obj).doubleValue();
    }

    public final void putInt(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.data.put(validated$default(this, key, false, 1, (Object) null), Integer.valueOf(value));
    }

    public final int getInt(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.data.get(validated(key, true));
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) obj).intValue();
    }

    public final void putLong(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.data.put(validated$default(this, key, false, 1, (Object) null), Long.valueOf(value));
    }

    public final long getLong(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.data.get(validated(key, true));
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) obj).longValue();
    }

    public final void putString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, NameValue.Companion.CodingKeys.value);
        this.data.put(validated$default(this, key, false, 1, (Object) null), value);
    }

    public final String getString(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.data.get(validated(key, true));
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        return (String) obj;
    }

    public final void putData(String key, PersistableData data2) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data2, "data");
        for (Map.Entry element$iv : data2.data.entrySet()) {
            this.data.put(key + separator + ((String) element$iv.getKey()), element$iv.getValue());
        }
    }

    public final PersistableData getData(String key) {
        String str = key;
        Intrinsics.checkNotNullParameter(str, "key");
        Set<Map.Entry<String, Object>> $this$filter$iv = this.data.entrySet();
        Intrinsics.checkNotNullExpressionValue($this$filter$iv, "data.entries");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Object key2 = ((Map.Entry) element$iv$iv).getKey();
            Intrinsics.checkNotNullExpressionValue(key2, "it.key");
            if (StringsKt.startsWith$default((String) key2, str + separator, false, 2, (Object) null)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List<Map.Entry> entries = (List) destination$iv$iv;
        if (entries.isEmpty()) {
            return new PersistableData();
        }
        PersistableData persistableData = new PersistableData();
        PersistableData extractedData = persistableData;
        for (Map.Entry entry : entries) {
            Intrinsics.checkNotNullExpressionValue(entry, "(entryKey, entryValue)");
            String entryKey = (String) entry.getKey();
            Object entryValue = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(entryKey, "entryKey");
            String removePrefix = StringsKt.removePrefix(entryKey, (CharSequence) str + separator);
            Intrinsics.checkNotNullExpressionValue(entryValue, "entryValue");
            extractedData.data.put(removePrefix, entryValue);
            str = key;
        }
        return persistableData;
    }

    public final void putArrayData(String key, List<? extends PersistableData> data2) {
        String str = key;
        List<? extends PersistableData> list = data2;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(list, "data");
        Iterable $this$forEachIndexed$iv = list;
        int $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            for (Map.Entry element$iv : ((PersistableData) item$iv).data.entrySet()) {
                this.data.put(str + separator + index$iv + separator + ((String) element$iv.getKey()), element$iv.getValue());
                str = key;
                List<? extends PersistableData> list2 = data2;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv;
                $i$f$forEachIndexed = $i$f$forEachIndexed;
            }
            int i = $i$f$forEachIndexed;
            str = key;
            List<? extends PersistableData> list3 = data2;
            index$iv = index$iv2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<net.gotev.uploadservice.persistence.PersistableData> getArrayData(java.lang.String r23) {
        /*
            r22 = this;
            r0 = r23
            java.lang.String r1 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = r22
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r1.data
            java.util.Set r2 = r2.entrySet()
            java.lang.String r3 = "data.entries"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            r5 = r2
            r6 = 0
            java.util.Iterator r7 = r5.iterator()
        L_0x0024:
            boolean r8 = r7.hasNext()
            r10 = 2
            r11 = 0
            java.lang.String r12 = "it.key"
            java.lang.String r13 = "$"
            if (r8 == 0) goto L_0x005d
            java.lang.Object r8 = r7.next()
            r14 = r8
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r15 = 0
            java.lang.Object r9 = r14.getKey()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r12)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.StringBuilder r12 = r12.append(r0)
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r12 = r12.toString()
            r13 = 0
            boolean r9 = kotlin.text.StringsKt.startsWith$default(r9, r12, r11, r10, r13)
            if (r9 == 0) goto L_0x0024
            r4.add(r8)
            goto L_0x0024
        L_0x005d:
            java.util.List r4 = (java.util.List) r4
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r4)
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x0073
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
            return r3
        L_0x0073:
            r3 = 0
            r4 = 0
            r5 = r2
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            r8 = r5
            r9 = 0
            java.util.Iterator r14 = r8.iterator()
        L_0x0086:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x00d1
            java.lang.Object r15 = r14.next()
            r17 = r15
            java.util.Map$Entry r17 = (java.util.Map.Entry) r17
            r18 = 0
            java.lang.Object r10 = r17.getKey()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            java.lang.String r10 = (java.lang.String) r10
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.StringBuilder r11 = r11.append(r0)
            java.lang.StringBuilder r11 = r11.append(r13)
            java.lang.StringBuilder r11 = r11.append(r3)
            java.lang.StringBuilder r11 = r11.append(r13)
            java.lang.String r11 = r11.toString()
            r20 = r3
            r21 = r4
            r1 = 0
            r3 = 2
            r4 = 0
            boolean r10 = kotlin.text.StringsKt.startsWith$default(r10, r11, r4, r3, r1)
            if (r10 == 0) goto L_0x00c8
            r7.add(r15)
        L_0x00c8:
            r3 = r20
            r4 = r21
            r10 = 2
            r11 = 0
            r1 = r22
            goto L_0x0086
        L_0x00d1:
            r20 = r3
            r21 = r4
            r1 = r7
            java.util.List r1 = (java.util.List) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = r20
        L_0x00e1:
            r5 = r1
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x01df
            net.gotev.uploadservice.persistence.PersistableData r5 = new net.gotev.uploadservice.persistence.PersistableData
            r5.<init>()
            r6 = r5
            r7 = 0
            r8 = r1
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            r9 = 0
            java.util.Iterator r10 = r8.iterator()
        L_0x00fb:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0158
            java.lang.Object r11 = r10.next()
            r14 = r11
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r15 = 0
            r17 = r7
            java.lang.String r7 = "(entryKey, entryValue)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r7)
            java.lang.Object r7 = r14.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r14 = r14.getValue()
            r18 = r8
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r6.data
            java.util.Map r8 = (java.util.Map) r8
            r20 = r6
            java.lang.String r6 = "entryKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.StringBuilder r6 = r6.append(r13)
            java.lang.StringBuilder r6 = r6.append(r4)
            java.lang.StringBuilder r6 = r6.append(r13)
            java.lang.String r6 = r6.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.String r6 = kotlin.text.StringsKt.removePrefix((java.lang.String) r7, (java.lang.CharSequence) r6)
            r21 = r7
            java.lang.String r7 = "entryValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r7)
            r8.put(r6, r14)
            r7 = r17
            r8 = r18
            r6 = r20
            goto L_0x00fb
        L_0x0158:
            r20 = r6
            r17 = r7
            r18 = r8
            r6 = r1
            java.util.Collection r6 = (java.util.Collection) r6
            r2.removeAll(r6)
            r3.add(r5)
            int r4 = r4 + 1
            r5 = r2
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            r8 = r5
            r9 = 0
            java.util.Iterator r10 = r8.iterator()
        L_0x017b:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x01ca
            java.lang.Object r11 = r10.next()
            r14 = r11
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r15 = 0
            r17 = r1
            java.lang.Object r1 = r14.getKey()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)
            java.lang.String r1 = (java.lang.String) r1
            r18 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.StringBuilder r2 = r2.append(r13)
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r2 = r2.append(r13)
            java.lang.String r2 = r2.toString()
            r16 = r4
            r19 = r5
            r0 = 0
            r4 = 2
            r5 = 0
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r1, r2, r5, r4, r0)
            if (r1 == 0) goto L_0x01bf
            r7.add(r11)
        L_0x01bf:
            r0 = r23
            r4 = r16
            r1 = r17
            r2 = r18
            r5 = r19
            goto L_0x017b
        L_0x01ca:
            r17 = r1
            r18 = r2
            r16 = r4
            r19 = r5
            r0 = 0
            r4 = 2
            r5 = 0
            r1 = r7
            java.util.List r1 = (java.util.List) r1
            r0 = r23
            r4 = r16
            goto L_0x00e1
        L_0x01df:
            r0 = r3
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gotev.uploadservice.persistence.PersistableData.getArrayData(java.lang.String):java.util.List");
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = bundle;
        Set<String> $this$forEach$iv = this.data.keySet();
        Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "data.keys");
        for (String key : $this$forEach$iv) {
            Object value = this.data.get(key);
            if (value instanceof Boolean) {
                bundle2.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Double) {
                bundle2.putDouble(key, ((Number) value).doubleValue());
            } else if (value instanceof Integer) {
                bundle2.putInt(key, ((Number) value).intValue());
            } else if (value instanceof Long) {
                bundle2.putLong(key, ((Number) value).longValue());
            } else if (value instanceof String) {
                bundle2.putString(key, (String) value);
            }
        }
        return bundle;
    }

    public final String toJson() {
        JSONObject jSONObject = new JSONObject();
        JSONObject json = jSONObject;
        Set<String> $this$forEach$iv = this.data.keySet();
        Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "data.keys");
        for (String key : $this$forEach$iv) {
            Object value = this.data.get(key);
            boolean z = true;
            if (!(value instanceof Boolean ? true : value instanceof Double ? true : value instanceof Integer ? true : value instanceof Long)) {
                z = value instanceof String;
            }
            if (z) {
                json.put(key, value);
            }
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().also { json…       }\n    }.toString()");
        return jSONObject2;
    }
}
