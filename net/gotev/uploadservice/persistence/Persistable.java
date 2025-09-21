package net.gotev.uploadservice.persistence;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lnet/gotev/uploadservice/persistence/Persistable;", "", "toPersistableData", "Lnet/gotev/uploadservice/persistence/PersistableData;", "Creator", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Persistable.kt */
public interface Persistable {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lnet/gotev/uploadservice/persistence/Persistable$Creator;", "T", "", "createFromPersistableData", "data", "Lnet/gotev/uploadservice/persistence/PersistableData;", "(Lnet/gotev/uploadservice/persistence/PersistableData;)Ljava/lang/Object;", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Persistable.kt */
    public interface Creator<T> {
        T createFromPersistableData(PersistableData persistableData);
    }

    PersistableData toPersistableData();
}
