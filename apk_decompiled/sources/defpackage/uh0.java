package defpackage;

import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class uh0 extends no2 {
    public uh0(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    protected abstract void bind(sw2 sw2Var, Object obj);

    public final void insert(Object obj) {
        sw2 sw2VarAcquire = acquire();
        try {
            bind(sw2VarAcquire, obj);
            sw2VarAcquire.p();
        } finally {
            release(sw2VarAcquire);
        }
    }

    public final long insertAndReturnId(Object obj) {
        sw2 sw2VarAcquire = acquire();
        try {
            bind(sw2VarAcquire, obj);
            return sw2VarAcquire.p();
        } finally {
            release(sw2VarAcquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<Object> collection) {
        sw2 sw2VarAcquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            Iterator<Object> it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                bind(sw2VarAcquire, it.next());
                jArr[i] = sw2VarAcquire.p();
                i++;
            }
            release(sw2VarAcquire);
            return jArr;
        } catch (Throwable th) {
            release(sw2VarAcquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<Object> collection) {
        sw2 sw2VarAcquire = acquire();
        try {
            Long[] lArr = new Long[collection.size()];
            Iterator<Object> it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                bind(sw2VarAcquire, it.next());
                lArr[i] = Long.valueOf(sw2VarAcquire.p());
                i++;
            }
            release(sw2VarAcquire);
            return lArr;
        } catch (Throwable th) {
            release(sw2VarAcquire);
            throw th;
        }
    }

    public final List<Long> insertAndReturnIdsList(Object[] objArr) {
        sw2 sw2VarAcquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(objArr.length);
            int i = 0;
            for (Object obj : objArr) {
                bind(sw2VarAcquire, obj);
                arrayList.add(i, Long.valueOf(sw2VarAcquire.p()));
                i++;
            }
            release(sw2VarAcquire);
            return arrayList;
        } catch (Throwable th) {
            release(sw2VarAcquire);
            throw th;
        }
    }

    public final void insert(Object[] objArr) {
        sw2 sw2VarAcquire = acquire();
        try {
            for (Object obj : objArr) {
                bind(sw2VarAcquire, obj);
                sw2VarAcquire.p();
            }
            release(sw2VarAcquire);
        } catch (Throwable th) {
            release(sw2VarAcquire);
            throw th;
        }
    }

    public final long[] insertAndReturnIdsArray(Object[] objArr) {
        sw2 sw2VarAcquire = acquire();
        try {
            long[] jArr = new long[objArr.length];
            int i = 0;
            for (Object obj : objArr) {
                bind(sw2VarAcquire, obj);
                jArr[i] = sw2VarAcquire.p();
                i++;
            }
            release(sw2VarAcquire);
            return jArr;
        } catch (Throwable th) {
            release(sw2VarAcquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Object[] objArr) {
        sw2 sw2VarAcquire = acquire();
        try {
            Long[] lArr = new Long[objArr.length];
            int i = 0;
            for (Object obj : objArr) {
                bind(sw2VarAcquire, obj);
                lArr[i] = Long.valueOf(sw2VarAcquire.p());
                i++;
            }
            release(sw2VarAcquire);
            return lArr;
        } catch (Throwable th) {
            release(sw2VarAcquire);
            throw th;
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<Object> collection) {
        sw2 sw2VarAcquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<Object> it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                bind(sw2VarAcquire, it.next());
                arrayList.add(i, Long.valueOf(sw2VarAcquire.p()));
                i++;
            }
            release(sw2VarAcquire);
            return arrayList;
        } catch (Throwable th) {
            release(sw2VarAcquire);
            throw th;
        }
    }

    public final void insert(Iterable<Object> iterable) {
        sw2 sw2VarAcquire = acquire();
        try {
            Iterator<Object> it = iterable.iterator();
            while (it.hasNext()) {
                bind(sw2VarAcquire, it.next());
                sw2VarAcquire.p();
            }
            release(sw2VarAcquire);
        } catch (Throwable th) {
            release(sw2VarAcquire);
            throw th;
        }
    }
}
