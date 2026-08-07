package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.async.b;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a1 {
    private final r60 db;
    private final Map<Class<?>, y0> entityToDao = new HashMap();
    private volatile wi2 rxTxIo;
    private volatile wi2 rxTxPlain;

    public a1(r60 r60Var) {
        this.db = r60Var;
    }

    public <V> V callInTx(Callable<V> callable) throws Exception {
        this.db.d();
        try {
            V vCall = callable.call();
            this.db.j();
            return vCall;
        } finally {
            this.db.l();
        }
    }

    public <V> V callInTxNoException(Callable<V> callable) {
        this.db.d();
        try {
            try {
                V vCall = callable.call();
                this.db.j();
                this.db.l();
                return vCall;
            } catch (Exception e) {
                throw new DaoException("Callable failed", e);
            }
        } catch (Throwable th) {
            this.db.l();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void delete(T t) {
        getDao(t.getClass()).delete(t);
    }

    public <T> void deleteAll(Class<T> cls) {
        getDao(cls).deleteAll();
    }

    public Collection<y0> getAllDaos() {
        return Collections.unmodifiableCollection(this.entityToDao.values());
    }

    public y0 getDao(Class<? extends Object> cls) {
        y0 y0Var = this.entityToDao.get(cls);
        if (y0Var != null) {
            return y0Var;
        }
        throw new DaoException("No DAO registered for " + cls);
    }

    public r60 getDatabase() {
        return this.db;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> long insert(T t) {
        return getDao(t.getClass()).insert(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> long insertOrReplace(T t) {
        return getDao(t.getClass()).insertOrReplace(t);
    }

    public <T, K> T load(Class<T> cls, K k) {
        return (T) getDao(cls).load(k);
    }

    public <T, K> List<T> loadAll(Class<T> cls) {
        return (List<T>) getDao(cls).loadAll();
    }

    public <T> u92 queryBuilder(Class<T> cls) {
        return getDao(cls).queryBuilder();
    }

    public <T, K> List<T> queryRaw(Class<T> cls, String str, String... strArr) {
        return (List<T>) getDao(cls).queryRaw(str, strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void refresh(T t) {
        getDao(t.getClass()).refresh(t);
    }

    protected <T> void registerDao(Class<T> cls, y0 y0Var) {
        this.entityToDao.put(cls, y0Var);
    }

    public void runInTx(Runnable runnable) {
        this.db.d();
        try {
            runnable.run();
            this.db.j();
        } finally {
            this.db.l();
        }
    }

    public wi2 rxTx() {
        if (this.rxTxIo == null) {
            this.rxTxIo = new wi2(this, Schedulers.io());
        }
        return this.rxTxIo;
    }

    public wi2 rxTxPlain() {
        if (this.rxTxPlain == null) {
            this.rxTxPlain = new wi2(this);
        }
        return this.rxTxPlain;
    }

    public b startAsyncSession() {
        return new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void update(T t) {
        getDao(t.getClass()).update(t);
    }
}
