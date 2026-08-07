package defpackage;

import androidx.room.RoomDatabase;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class th0 extends no2 {
    public th0(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    protected abstract void bind(sw2 sw2Var, Object obj);

    public final int handle(Object obj) {
        sw2 sw2VarAcquire = acquire();
        try {
            bind(sw2VarAcquire, obj);
            return sw2VarAcquire.E();
        } finally {
            release(sw2VarAcquire);
        }
    }

    public final int handleMultiple(Iterable<Object> iterable) {
        sw2 sw2VarAcquire = acquire();
        try {
            Iterator<Object> it = iterable.iterator();
            int iE = 0;
            while (it.hasNext()) {
                bind(sw2VarAcquire, it.next());
                iE += sw2VarAcquire.E();
            }
            release(sw2VarAcquire);
            return iE;
        } catch (Throwable th) {
            release(sw2VarAcquire);
            throw th;
        }
    }

    public final int handleMultiple(Object[] objArr) {
        sw2 sw2VarAcquire = acquire();
        try {
            int iE = 0;
            for (Object obj : objArr) {
                bind(sw2VarAcquire, obj);
                iE += sw2VarAcquire.E();
            }
            release(sw2VarAcquire);
            return iE;
        } catch (Throwable th) {
            release(sw2VarAcquire);
            throw th;
        }
    }
}
