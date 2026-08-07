package defpackage;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.jieli.jl_rcsp.constant.WatchConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.DaoException;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes4.dex */
public abstract class y0 {
    protected final r50 config;
    protected final r60 db;
    protected final bz0 identityScope;
    protected final cz0 identityScopeLong;
    protected final boolean isStandardSQLite;
    protected final int pkOrdinal;
    private volatile ti2 rxDao;
    private volatile ti2 rxDaoPlain;
    protected final a1 session;
    protected final uz2 statements;

    public y0(r50 r50Var) {
        this(r50Var, null);
    }

    private void a(Object obj, s60 s60Var) {
        if (obj instanceof Long) {
            s60Var.i(1, ((Long) obj).longValue());
        } else {
            if (obj == null) {
                throw new DaoException("Cannot delete entity, key is null");
            }
            s60Var.f(1, obj.toString());
        }
        s60Var.execute();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0040 A[Catch: all -> 0x003c, TryCatch #1 {all -> 0x003c, blocks: (B:12:0x0021, B:13:0x0025, B:15:0x002b, B:17:0x0038, B:21:0x0040, B:22:0x0044, B:24:0x004a, B:26:0x0053), top: B:51:0x0021, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x004a A[Catch: all -> 0x003c, TryCatch #1 {all -> 0x003c, blocks: (B:12:0x0021, B:13:0x0025, B:15:0x002b, B:17:0x0038, B:21:0x0040, B:22:0x0044, B:24:0x004a, B:26:0x0053), top: B:51:0x0021, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0063 A[Catch: all -> 0x001c, TryCatch #2 {, blocks: (B:4:0x000f, B:6:0x0013, B:32:0x005f, B:34:0x0063, B:35:0x0066, B:28:0x0057, B:30:0x005b, B:31:0x005e, B:12:0x0021, B:13:0x0025, B:15:0x002b, B:17:0x0038, B:21:0x0040, B:22:0x0044, B:24:0x004a, B:26:0x0053), top: B:53:0x000f, outer: #0, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0044 A[SYNTHETIC] */
    private void b(Iterable iterable, Iterable iterable2) {
        ArrayList arrayList;
        bz0 bz0Var;
        bz0 bz0Var2;
        assertSinglePk();
        s60 s60VarB = this.statements.b();
        this.db.d();
        try {
            synchronized (s60VarB) {
                bz0 bz0Var3 = this.identityScope;
                if (bz0Var3 != null) {
                    bz0Var3.lock();
                    arrayList = new ArrayList();
                } else {
                    arrayList = null;
                }
                if (iterable != null) {
                    try {
                        Iterator it = iterable.iterator();
                        while (it.hasNext()) {
                            Object keyVerified = getKeyVerified(it.next());
                            a(keyVerified, s60VarB);
                            if (arrayList != null) {
                                arrayList.add(keyVerified);
                            }
                        }
                        if (iterable2 != null) {
                            for (Object obj : iterable2) {
                                a(obj, s60VarB);
                                if (arrayList != null) {
                                    arrayList.add(obj);
                                }
                            }
                        }
                        bz0Var = this.identityScope;
                        if (bz0Var != null) {
                            bz0Var.unlock();
                        }
                    } catch (Throwable th) {
                        bz0 bz0Var4 = this.identityScope;
                        if (bz0Var4 != null) {
                            bz0Var4.unlock();
                        }
                        throw th;
                    }
                } else {
                    if (iterable2 != null) {
                        while (r4.hasNext()) {
                            a(obj, s60VarB);
                            if (arrayList != null) {
                                arrayList.add(obj);
                            }
                        }
                    }
                    bz0Var = this.identityScope;
                    if (bz0Var != null) {
                        bz0Var.unlock();
                    }
                }
                throw th;
            }
            this.db.j();
            if (arrayList != null && (bz0Var2 = this.identityScope) != null) {
                bz0Var2.e(arrayList);
            }
            this.db.l();
        } catch (Throwable th2) {
            this.db.l();
            throw th2;
        }
    }

    private long c(Object obj, s60 s60Var, boolean z) {
        long jE;
        if (this.db.o()) {
            jE = e(obj, s60Var);
        } else {
            this.db.d();
            try {
                jE = e(obj, s60Var);
                this.db.j();
                this.db.l();
            } catch (Throwable th) {
                this.db.l();
                throw th;
            }
        }
        if (z) {
            updateKeyAfterInsertAndAttach(obj, jE, true);
        }
        return jE;
    }

    private void d(s60 s60Var, Iterable iterable, boolean z) {
        this.db.d();
        try {
            synchronized (s60Var) {
                try {
                    bz0 bz0Var = this.identityScope;
                    if (bz0Var != null) {
                        bz0Var.lock();
                    }
                    try {
                        if (this.isStandardSQLite) {
                            SQLiteStatement sQLiteStatement = (SQLiteStatement) s60Var.s();
                            for (Object obj : iterable) {
                                bindValues(sQLiteStatement, obj);
                                if (z) {
                                    updateKeyAfterInsertAndAttach(obj, sQLiteStatement.executeInsert(), false);
                                } else {
                                    sQLiteStatement.execute();
                                }
                            }
                        } else {
                            for (Object obj2 : iterable) {
                                bindValues(s60Var, obj2);
                                if (z) {
                                    updateKeyAfterInsertAndAttach(obj2, s60Var.p(), false);
                                } else {
                                    s60Var.execute();
                                }
                            }
                        }
                        bz0 bz0Var2 = this.identityScope;
                        if (bz0Var2 != null) {
                            bz0Var2.unlock();
                        }
                    } catch (Throwable th) {
                        bz0 bz0Var3 = this.identityScope;
                        if (bz0Var3 != null) {
                            bz0Var3.unlock();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.db.j();
            this.db.l();
        } catch (Throwable th3) {
            this.db.l();
            throw th3;
        }
    }

    private long e(Object obj, s60 s60Var) {
        synchronized (s60Var) {
            try {
                if (!this.isStandardSQLite) {
                    bindValues(s60Var, obj);
                    return s60Var.p();
                }
                SQLiteStatement sQLiteStatement = (SQLiteStatement) s60Var.s();
                bindValues(sQLiteStatement, obj);
                return sQLiteStatement.executeInsert();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void f(Cursor cursor, CursorWindow cursorWindow, List list) {
        int startPosition = cursorWindow.getStartPosition() + cursorWindow.getNumRows();
        int i = 0;
        while (true) {
            list.add(loadCurrent(cursor, 0, false));
            if (i + 1 >= startPosition) {
                CursorWindow cursorWindowG = g(cursor);
                if (cursorWindowG == null) {
                    return;
                } else {
                    startPosition = cursorWindowG.getStartPosition() + cursorWindowG.getNumRows();
                }
            } else if (!cursor.moveToNext()) {
                return;
            }
            i += 2;
        }
    }

    private CursorWindow g(Cursor cursor) {
        this.identityScope.unlock();
        try {
            if (cursor.moveToNext()) {
                return ((CrossProcessCursor) cursor).getWindow();
            }
            return null;
        } finally {
            this.identityScope.lock();
        }
    }

    protected void assertSinglePk() {
        if (this.config.e.length == 1) {
            return;
        }
        throw new DaoException(this + " (" + this.config.b + ") does not have a single-column primary key");
    }

    protected final void attachEntity(Object obj, Object obj2, boolean z) {
        attachEntity(obj2);
        bz0 bz0Var = this.identityScope;
        if (bz0Var == null || obj == null) {
            return;
        }
        if (z) {
            bz0Var.put(obj, obj2);
        } else {
            bz0Var.a(obj, obj2);
        }
    }

    protected abstract void bindValues(SQLiteStatement sQLiteStatement, Object obj);

    protected abstract void bindValues(s60 s60Var, Object obj);

    public long count() {
        return this.statements.a().q();
    }

    public void delete(Object obj) {
        assertSinglePk();
        deleteByKey(getKeyVerified(obj));
    }

    public void deleteAll() {
        this.db.e("DELETE FROM '" + this.config.b + "'");
        bz0 bz0Var = this.identityScope;
        if (bz0Var != null) {
            bz0Var.clear();
        }
    }

    public void deleteByKey(Object obj) {
        assertSinglePk();
        s60 s60VarB = this.statements.b();
        if (this.db.o()) {
            synchronized (s60VarB) {
                a(obj, s60VarB);
            }
        } else {
            this.db.d();
            try {
                synchronized (s60VarB) {
                    a(obj, s60VarB);
                }
                this.db.j();
                this.db.l();
            } catch (Throwable th) {
                this.db.l();
                throw th;
            }
        }
        bz0 bz0Var = this.identityScope;
        if (bz0Var != null) {
            bz0Var.remove(obj);
        }
    }

    public void deleteByKeyInTx(Iterable<Object> iterable) {
        b(null, iterable);
    }

    public void deleteInTx(Iterable<Object> iterable) {
        b(iterable, null);
    }

    public boolean detach(Object obj) {
        if (this.identityScope == null) {
            return false;
        }
        return this.identityScope.d(getKeyVerified(obj), obj);
    }

    public void detachAll() {
        bz0 bz0Var = this.identityScope;
        if (bz0Var != null) {
            bz0Var.clear();
        }
    }

    public String[] getAllColumns() {
        return this.config.d;
    }

    public r60 getDatabase() {
        return this.db;
    }

    protected abstract Object getKey(Object obj);

    protected Object getKeyVerified(Object obj) {
        Object key = getKey(obj);
        if (key != null) {
            return key;
        }
        if (obj == null) {
            throw new NullPointerException("Entity may not be null");
        }
        throw new DaoException("Entity has no key");
    }

    public String[] getNonPkColumns() {
        return this.config.f;
    }

    public String[] getPkColumns() {
        return this.config.e;
    }

    public h82 getPkProperty() {
        return this.config.g;
    }

    public h82[] getProperties() {
        return this.config.c;
    }

    public a1 getSession() {
        return this.session;
    }

    uz2 getStatements() {
        return this.config.i;
    }

    public String getTablename() {
        return this.config.b;
    }

    protected abstract boolean hasKey(Object obj);

    public long insert(Object obj) {
        return c(obj, this.statements.d(), true);
    }

    public void insertInTx(Iterable<Object> iterable) {
        insertInTx(iterable, isEntityUpdateable());
    }

    public long insertOrReplace(Object obj) {
        return c(obj, this.statements.c(), true);
    }

    public void insertOrReplaceInTx(Iterable<Object> iterable, boolean z) {
        d(this.statements.c(), iterable, z);
    }

    public long insertWithoutSettingPk(Object obj) {
        return c(obj, this.statements.c(), false);
    }

    protected abstract boolean isEntityUpdateable();

    public Object load(Object obj) {
        Object obj2;
        assertSinglePk();
        if (obj == null) {
            return null;
        }
        bz0 bz0Var = this.identityScope;
        return (bz0Var == null || (obj2 = bz0Var.get(obj)) == null) ? loadUniqueAndCloseCursor(this.db.n(this.statements.f(), new String[]{obj.toString()})) : obj2;
    }

    public List<Object> loadAll() {
        return loadAllAndCloseCursor(this.db.n(this.statements.e(), null));
    }

    protected List<Object> loadAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0056  */
    /* JADX WARN: Code duplicated, block: B:20:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0081 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:41:? A[SYNTHETIC] */
    protected List<Object> loadAllFromCursor(Cursor cursor) {
        CursorWindow window;
        boolean z;
        bz0 bz0Var;
        int count = cursor.getCount();
        if (count == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(count);
        if (cursor instanceof CrossProcessCursor) {
            window = ((CrossProcessCursor) cursor).getWindow();
            if (window != null) {
                if (window.getNumRows() == count) {
                    cursor = new ik0(window);
                    z = true;
                } else {
                    s50.a("Window vs. result size: " + window.getNumRows() + WatchConstant.FAT_FS_ROOT + count);
                }
            }
            if (cursor.moveToFirst()) {
                bz0Var = this.identityScope;
                if (bz0Var != null) {
                    bz0Var.lock();
                    this.identityScope.c(count);
                }
                if (!z || window == null) {
                    do {
                        arrayList.add(loadCurrent(cursor, 0, false));
                    } while (cursor.moveToNext());
                } else {
                    try {
                        if (this.identityScope != null) {
                            f(cursor, window, arrayList);
                        } else {
                            do {
                                arrayList.add(loadCurrent(cursor, 0, false));
                            } while (cursor.moveToNext());
                        }
                    } finally {
                        bz0 bz0Var2 = this.identityScope;
                        if (bz0Var2 != null) {
                            bz0Var2.unlock();
                        }
                    }
                }
            }
            return arrayList;
        }
        window = null;
        z = false;
        if (cursor.moveToFirst()) {
            bz0Var = this.identityScope;
            if (bz0Var != null) {
                bz0Var.lock();
                this.identityScope.c(count);
            }
            if (z) {
                do {
                    arrayList.add(loadCurrent(cursor, 0, false));
                } while (cursor.moveToNext());
            } else {
                do {
                    arrayList.add(loadCurrent(cursor, 0, false));
                } while (cursor.moveToNext());
            }
        }
        return arrayList;
    }

    public Object loadByRowId(long j) {
        return loadUniqueAndCloseCursor(this.db.n(this.statements.g(), new String[]{Long.toString(j)}));
    }

    protected final Object loadCurrent(Cursor cursor, int i, boolean z) {
        if (this.identityScopeLong != null) {
            if (i != 0 && cursor.isNull(this.pkOrdinal + i)) {
                return null;
            }
            long j = cursor.getLong(this.pkOrdinal + i);
            cz0 cz0Var = this.identityScopeLong;
            Object objH = z ? cz0Var.h(j) : cz0Var.i(j);
            if (objH != null) {
                return objH;
            }
            Object entity = readEntity(cursor, i);
            attachEntity(entity);
            if (z) {
                this.identityScopeLong.l(j, entity);
            } else {
                this.identityScopeLong.m(j, entity);
            }
            return entity;
        }
        if (this.identityScope == null) {
            if (i != 0 && readKey(cursor, i) == null) {
                return null;
            }
            Object entity2 = readEntity(cursor, i);
            attachEntity(entity2);
            return entity2;
        }
        Object key = readKey(cursor, i);
        if (i != 0 && key == null) {
            return null;
        }
        bz0 bz0Var = this.identityScope;
        Object objB = z ? bz0Var.get(key) : bz0Var.b(key);
        if (objB != null) {
            return objB;
        }
        Object entity3 = readEntity(cursor, i);
        attachEntity(key, entity3, z);
        return entity3;
    }

    protected final <O> O loadCurrentOther(y0 y0Var, Cursor cursor, int i) {
        return (O) y0Var.loadCurrent(cursor, i, true);
    }

    protected Object loadUnique(Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return null;
        }
        if (cursor.isLast()) {
            return loadCurrent(cursor, 0, true);
        }
        throw new DaoException("Expected unique result, but count was " + cursor.getCount());
    }

    protected Object loadUniqueAndCloseCursor(Cursor cursor) {
        try {
            return loadUnique(cursor);
        } finally {
            cursor.close();
        }
    }

    public u92 queryBuilder() {
        return u92.j(this);
    }

    public List<Object> queryRaw(String str, String... strArr) {
        return loadAllAndCloseCursor(this.db.n(this.statements.e() + str, strArr));
    }

    public t92 queryRawCreate(String str, Object... objArr) {
        return queryRawCreateListArgs(str, Arrays.asList(objArr));
    }

    public t92 queryRawCreateListArgs(String str, Collection<Object> collection) {
        return t92.g(this, this.statements.e() + str, collection.toArray());
    }

    protected abstract Object readEntity(Cursor cursor, int i);

    protected abstract void readEntity(Cursor cursor, Object obj, int i);

    protected abstract Object readKey(Cursor cursor, int i);

    public void refresh(Object obj) {
        assertSinglePk();
        Object keyVerified = getKeyVerified(obj);
        Cursor cursorN = this.db.n(this.statements.f(), new String[]{keyVerified.toString()});
        try {
            if (!cursorN.moveToFirst()) {
                throw new DaoException("Entity does not exist in the database anymore: " + obj.getClass() + " with key " + keyVerified);
            }
            if (cursorN.isLast()) {
                readEntity(cursorN, obj, 0);
                attachEntity(keyVerified, obj, true);
                cursorN.close();
            } else {
                throw new DaoException("Expected unique result, but count was " + cursorN.getCount());
            }
        } catch (Throwable th) {
            cursorN.close();
            throw th;
        }
    }

    public ti2 rx() {
        if (this.rxDao == null) {
            this.rxDao = new ti2(this, Schedulers.io());
        }
        return this.rxDao;
    }

    public ti2 rxPlain() {
        if (this.rxDaoPlain == null) {
            this.rxDaoPlain = new ti2(this);
        }
        return this.rxDaoPlain;
    }

    public void save(Object obj) {
        if (hasKey(obj)) {
            update(obj);
        } else {
            insert(obj);
        }
    }

    public void saveInTx(Object... objArr) {
        saveInTx(Arrays.asList(objArr));
    }

    public void update(Object obj) {
        assertSinglePk();
        s60 s60VarH = this.statements.h();
        if (this.db.o()) {
            synchronized (s60VarH) {
                try {
                    if (this.isStandardSQLite) {
                        updateInsideSynchronized(obj, (SQLiteStatement) s60VarH.s(), true);
                    } else {
                        updateInsideSynchronized(obj, s60VarH, true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        this.db.d();
        try {
            synchronized (s60VarH) {
                updateInsideSynchronized(obj, s60VarH, true);
            }
            this.db.j();
            this.db.l();
        } catch (Throwable th2) {
            this.db.l();
            throw th2;
        }
    }

    public void updateInTx(Iterable<Object> iterable) {
        s60 s60VarH = this.statements.h();
        this.db.d();
        try {
            synchronized (s60VarH) {
                bz0 bz0Var = this.identityScope;
                if (bz0Var != null) {
                    bz0Var.lock();
                }
                try {
                    if (this.isStandardSQLite) {
                        SQLiteStatement sQLiteStatement = (SQLiteStatement) s60VarH.s();
                        Iterator<Object> it = iterable.iterator();
                        while (it.hasNext()) {
                            updateInsideSynchronized(it.next(), sQLiteStatement, false);
                        }
                    } else {
                        Iterator<Object> it2 = iterable.iterator();
                        while (it2.hasNext()) {
                            updateInsideSynchronized(it2.next(), s60VarH, false);
                        }
                    }
                    bz0 bz0Var2 = this.identityScope;
                    if (bz0Var2 != null) {
                        bz0Var2.unlock();
                    }
                } catch (Throwable th) {
                    bz0 bz0Var3 = this.identityScope;
                    if (bz0Var3 != null) {
                        bz0Var3.unlock();
                    }
                    throw th;
                }
            }
            this.db.j();
            this.db.l();
            e = null;
        } catch (RuntimeException e) {
            e = e;
            try {
                this.db.l();
            } catch (RuntimeException e2) {
                s50.d("Could not end transaction (rethrowing initial exception)", e2);
                throw e;
            }
        } catch (Throwable th2) {
            this.db.l();
            throw th2;
        }
        if (e != null) {
            throw e;
        }
    }

    protected void updateInsideSynchronized(Object obj, s60 s60Var, boolean z) {
        bindValues(s60Var, obj);
        int length = this.config.d.length + 1;
        Object key = getKey(obj);
        if (key instanceof Long) {
            s60Var.i(length, ((Long) key).longValue());
        } else {
            if (key == null) {
                throw new DaoException("Cannot update entity without key - was it inserted before?");
            }
            s60Var.f(length, key.toString());
        }
        s60Var.execute();
        attachEntity(key, obj, z);
    }

    protected abstract Object updateKeyAfterInsert(Object obj, long j);

    protected void updateKeyAfterInsertAndAttach(Object obj, long j, boolean z) {
        if (j != -1) {
            attachEntity(updateKeyAfterInsert(obj, j), obj, z);
        } else {
            s50.c("Could not insert row (executeInsert returned -1)");
        }
    }

    public y0(r50 r50Var, a1 a1Var) {
        this.config = r50Var;
        this.session = a1Var;
        r60 r60Var = r50Var.a;
        this.db = r60Var;
        this.isStandardSQLite = r60Var.m() instanceof SQLiteDatabase;
        bz0 bz0VarC = r50Var.c();
        this.identityScope = bz0VarC;
        if (bz0VarC instanceof cz0) {
            this.identityScopeLong = (cz0) bz0VarC;
        } else {
            this.identityScopeLong = null;
        }
        this.statements = r50Var.i;
        h82 h82Var = r50Var.g;
        this.pkOrdinal = h82Var != null ? h82Var.a : -1;
    }

    public void deleteByKeyInTx(Object... objArr) {
        b(null, Arrays.asList(objArr));
    }

    public void deleteInTx(Object... objArr) {
        b(Arrays.asList(objArr), null);
    }

    public void insertInTx(Object... objArr) {
        insertInTx(Arrays.asList(objArr), isEntityUpdateable());
    }

    public void saveInTx(Iterable<Object> iterable) {
        Iterator<Object> it = iterable.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            if (hasKey(it.next())) {
                i++;
            } else {
                i2++;
            }
        }
        if (i <= 0 || i2 <= 0) {
            if (i2 > 0) {
                insertInTx(iterable);
                return;
            } else {
                if (i > 0) {
                    updateInTx(iterable);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList(i);
        ArrayList arrayList2 = new ArrayList(i2);
        for (Object obj : iterable) {
            if (hasKey(obj)) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        this.db.d();
        try {
            updateInTx(arrayList);
            insertInTx(arrayList2);
            this.db.j();
        } finally {
            this.db.l();
        }
    }

    public void insertInTx(Iterable<Object> iterable, boolean z) {
        d(this.statements.d(), iterable, z);
    }

    public void insertOrReplaceInTx(Iterable<Object> iterable) {
        insertOrReplaceInTx(iterable, isEntityUpdateable());
    }

    public void insertOrReplaceInTx(Object... objArr) {
        insertOrReplaceInTx(Arrays.asList(objArr), isEntityUpdateable());
    }

    protected void attachEntity(Object obj) {
    }

    protected void updateInsideSynchronized(Object obj, SQLiteStatement sQLiteStatement, boolean z) {
        bindValues(sQLiteStatement, obj);
        int length = this.config.d.length + 1;
        Object key = getKey(obj);
        if (key instanceof Long) {
            sQLiteStatement.bindLong(length, ((Long) key).longValue());
        } else if (key != null) {
            sQLiteStatement.bindString(length, key.toString());
        } else {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        }
        sQLiteStatement.execute();
        attachEntity(key, obj, z);
    }

    public void updateInTx(Object... objArr) {
        updateInTx(Arrays.asList(objArr));
    }
}
