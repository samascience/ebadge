package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import defpackage.ek1;
import defpackage.hp2;
import defpackage.l9;
import defpackage.ow2;
import defpackage.pw2;
import defpackage.rq0;
import defpackage.rw2;
import defpackage.sw2;
import defpackage.tr2;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoomDatabase {
    private static final String DB_IMPL_SUFFIX = "_Impl";
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;

    @Deprecated
    protected List<b> mCallbacks;

    @Deprecated
    protected volatile ow2 mDatabase;
    private pw2 mOpenHelper;
    private Executor mQueryExecutor;
    private Executor mTransactionExecutor;
    boolean mWriteAheadLoggingEnabled;
    private final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    private final ThreadLocal<Integer> mSuspendingTransactionId = new ThreadLocal<>();
    private final Map<String, Object> mBackingFieldMap = new ConcurrentHashMap();
    private final e mInvalidationTracker = createInvalidationTracker();

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean isLowRamDevice(ActivityManager activityManager) {
            return activityManager.isLowRamDevice();
        }

        @SuppressLint({"NewApi"})
        JournalMode resolve(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (activityManager == null || isLowRamDevice(activityManager)) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }
    }

    public static class a {
        private final Class a;
        private final String b;
        private final Context c;
        private ArrayList d;
        private Executor e;
        private Executor f;
        private pw2.c g;
        private boolean h;
        private boolean j;
        private boolean l;
        private Set n;
        private Set o;
        private String p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private File f199q;
        private JournalMode i = JournalMode.AUTOMATIC;
        private boolean k = true;
        private final c m = new c();

        a(Context context, Class cls, String str) {
            this.c = context;
            this.a = cls;
            this.b = str;
        }

        public a a(b bVar) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(bVar);
            return this;
        }

        public a b(ek1... ek1VarArr) {
            if (this.o == null) {
                this.o = new HashSet();
            }
            for (ek1 ek1Var : ek1VarArr) {
                this.o.add(Integer.valueOf(ek1Var.startVersion));
                this.o.add(Integer.valueOf(ek1Var.endVersion));
            }
            this.m.b(ek1VarArr);
            return this;
        }

        public a c() {
            this.h = true;
            return this;
        }

        public RoomDatabase d() {
            Executor executor;
            if (this.c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            }
            if (this.a == null) {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            Executor executor2 = this.e;
            if (executor2 == null && this.f == null) {
                Executor executorF = l9.f();
                this.f = executorF;
                this.e = executorF;
            } else if (executor2 != null && this.f == null) {
                this.f = executor2;
            } else if (executor2 == null && (executor = this.f) != null) {
                this.e = executor;
            }
            Set<Integer> set = this.o;
            if (set != null && this.n != null) {
                for (Integer num : set) {
                    if (this.n.contains(num)) {
                        throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                    }
                }
            }
            if (this.g == null) {
                this.g = new rq0();
            }
            String str = this.p;
            if (str != null || this.f199q != null) {
                if (this.b == null) {
                    throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                }
                if (str != null && this.f199q != null) {
                    throw new IllegalArgumentException("Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations.");
                }
                this.g = new j(str, this.f199q, this.g);
            }
            Context context = this.c;
            androidx.room.a aVar = new androidx.room.a(context, this.b, this.g, this.m, this.d, this.h, this.i.resolve(context), this.e, this.f, this.j, this.k, this.l, this.n, this.p, this.f199q);
            RoomDatabase roomDatabase = (RoomDatabase) g.b(this.a, RoomDatabase.DB_IMPL_SUFFIX);
            roomDatabase.init(aVar);
            return roomDatabase;
        }

        public a e() {
            this.k = false;
            this.l = true;
            return this;
        }

        public a f(pw2.c cVar) {
            this.g = cVar;
            return this;
        }

        public a g(Executor executor) {
            this.e = executor;
            return this;
        }
    }

    public static abstract class b {
        public void a(ow2 ow2Var) {
        }

        public void b(ow2 ow2Var) {
        }

        public void c(ow2 ow2Var) {
        }
    }

    public static class c {
        private HashMap a = new HashMap();

        private void a(ek1 ek1Var) {
            int i = ek1Var.startVersion;
            int i2 = ek1Var.endVersion;
            TreeMap treeMap = (TreeMap) this.a.get(Integer.valueOf(i));
            if (treeMap == null) {
                treeMap = new TreeMap();
                this.a.put(Integer.valueOf(i), treeMap);
            }
            ek1 ek1Var2 = (ek1) treeMap.get(Integer.valueOf(i2));
            if (ek1Var2 != null) {
                Log.w("ROOM", "Overriding migration " + ek1Var2 + " with " + ek1Var);
            }
            treeMap.put(Integer.valueOf(i2), ek1Var);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0019  */
        /* JADX WARN: Code duplicated, block: B:11:0x001e  */
        /* JADX WARN: Code duplicated, block: B:15:0x002c  */
        /* JADX WARN: Code duplicated, block: B:26:0x0050 A[LOOP:0: B:2:0x0000->B:26:0x0050, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:30:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:31:0x004f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:32:0x003d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:34:0x004a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:36:0x0038 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:9:0x0017 A[DONT_INVERT] */
        private List d(List list, boolean z, int i, int i2) {
            TreeMap treeMap;
            Set setKeySet;
            Iterator it;
            int iIntValue;
            boolean z2;
            while (true) {
                if (z) {
                    if (i >= i2) {
                        break;
                    }
                    treeMap = (TreeMap) this.a.get(Integer.valueOf(i));
                    if (treeMap == null) {
                        return null;
                    }
                    if (z) {
                        setKeySet = treeMap.descendingKeySet();
                    } else {
                        setKeySet = treeMap.keySet();
                    }
                    it = setKeySet.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            iIntValue = i;
                            z2 = false;
                            break;
                        }
                        Integer num = (Integer) it.next();
                        iIntValue = num.intValue();
                        if (!z) {
                            if (iIntValue >= i2 && iIntValue < i) {
                                list.add(treeMap.get(num));
                                z2 = true;
                                break;
                            }
                        } else if (iIntValue <= i2 && iIntValue > i) {
                            list.add(treeMap.get(num));
                            z2 = true;
                            break;
                        }
                    }
                    if (!z2) {
                        return null;
                    }
                    i = iIntValue;
                } else {
                    if (i <= i2) {
                        break;
                    }
                    treeMap = (TreeMap) this.a.get(Integer.valueOf(i));
                    if (treeMap == null) {
                        return null;
                    }
                    if (z) {
                        setKeySet = treeMap.descendingKeySet();
                    } else {
                        setKeySet = treeMap.keySet();
                    }
                    it = setKeySet.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            iIntValue = i;
                            z2 = false;
                            break;
                        }
                        Integer num2 = (Integer) it.next();
                        iIntValue = num2.intValue();
                        if (!z) {
                            if (iIntValue <= i2) {
                                continue;
                            }
                        } else if (iIntValue >= i2) {
                            continue;
                        }
                    }
                    if (!z2) {
                        return null;
                    }
                    i = iIntValue;
                }
            }
            return list;
        }

        public void b(ek1... ek1VarArr) {
            for (ek1 ek1Var : ek1VarArr) {
                a(ek1Var);
            }
        }

        public List c(int i, int i2) {
            if (i == i2) {
                return Collections.emptyList();
            }
            return d(new ArrayList(), i2 > i, i, i2);
        }
    }

    private static boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void assertNotMainThread() {
        if (!this.mAllowMainThreadQueries && a()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        ow2 ow2VarU = this.mOpenHelper.U();
        this.mInvalidationTracker.n(ow2VarU);
        ow2VarU.d();
    }

    public abstract void clearAllTables();

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.mCloseLock.writeLock();
            try {
                writeLock.lock();
                this.mInvalidationTracker.k();
                this.mOpenHelper.close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public sw2 compileStatement(String str) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.U().g(str);
    }

    protected abstract e createInvalidationTracker();

    protected abstract pw2 createOpenHelper(androidx.room.a aVar);

    @Deprecated
    public void endTransaction() {
        this.mOpenHelper.U().l();
        if (inTransaction()) {
            return;
        }
        this.mInvalidationTracker.f();
    }

    Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    public e getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    public pw2 getOpenHelper() {
        return this.mOpenHelper;
    }

    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    public boolean inTransaction() {
        return this.mOpenHelper.U().r0();
    }

    public void init(androidx.room.a aVar) {
        pw2 pw2VarCreateOpenHelper = createOpenHelper(aVar);
        this.mOpenHelper = pw2VarCreateOpenHelper;
        if (pw2VarCreateOpenHelper instanceof i) {
            ((i) pw2VarCreateOpenHelper).u(aVar);
        }
        boolean z = aVar.g == JournalMode.WRITE_AHEAD_LOGGING;
        this.mOpenHelper.setWriteAheadLoggingEnabled(z);
        this.mCallbacks = aVar.e;
        this.mQueryExecutor = aVar.h;
        this.mTransactionExecutor = new k(aVar.i);
        this.mAllowMainThreadQueries = aVar.f;
        this.mWriteAheadLoggingEnabled = z;
        if (aVar.j) {
            this.mInvalidationTracker.i(aVar.b, aVar.c);
        }
    }

    protected void internalInitInvalidationTracker(ow2 ow2Var) {
        this.mInvalidationTracker.d(ow2Var);
    }

    public boolean isOpen() {
        ow2 ow2Var = this.mDatabase;
        return ow2Var != null && ow2Var.isOpen();
    }

    public Cursor query(String str, Object[] objArr) {
        return this.mOpenHelper.U().t(new hp2(str, objArr));
    }

    public void runInTransaction(Runnable runnable) {
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Deprecated
    public void setTransactionSuccessful() {
        this.mOpenHelper.U().j();
    }

    public Cursor query(rw2 rw2Var) {
        return query(rw2Var, (CancellationSignal) null);
    }

    public Cursor query(rw2 rw2Var, CancellationSignal cancellationSignal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return this.mOpenHelper.U().P(rw2Var, cancellationSignal);
        }
        return this.mOpenHelper.U().t(rw2Var);
    }

    public <V> V runInTransaction(Callable<V> callable) {
        beginTransaction();
        try {
            try {
                V vCall = callable.call();
                setTransactionSuccessful();
                endTransaction();
                return vCall;
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                tr2.a(e2);
                endTransaction();
                return null;
            }
        } catch (Throwable th) {
            endTransaction();
            throw th;
        }
    }
}
