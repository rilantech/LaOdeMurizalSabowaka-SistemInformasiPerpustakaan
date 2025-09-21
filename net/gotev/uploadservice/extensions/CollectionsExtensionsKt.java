package net.gotev.uploadservice.extensions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.NameValue;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a8\u0010\b\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\n2\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\f"}, d2 = {"addHeader", "", "Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/data/NameValue;", "Lkotlin/collections/ArrayList;", "name", "", "value", "setOrRemove", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "key", "uploadservice_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CollectionsExtensions.kt */
public final class CollectionsExtensionsKt {
    public static final void addHeader(ArrayList<NameValue> $this$addHeader, String name, String value) {
        Intrinsics.checkNotNullParameter($this$addHeader, "<this>");
        Intrinsics.checkNotNullParameter(name, NameValue.Companion.CodingKeys.name);
        Intrinsics.checkNotNullParameter(value, NameValue.Companion.CodingKeys.value);
        $this$addHeader.add(new NameValue(name, value).validateAsHeader());
    }

    public static final void setOrRemove(LinkedHashMap<String, String> $this$setOrRemove, String key, String value) {
        Intrinsics.checkNotNullParameter($this$setOrRemove, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (value == null) {
            $this$setOrRemove.remove(key);
        } else {
            $this$setOrRemove.put(key, value);
        }
    }
}
