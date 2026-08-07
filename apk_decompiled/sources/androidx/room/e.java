package androidx.room;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import defpackage.hp2;
import defpackage.lj2;
import defpackage.ow2;
import defpackage.sw2;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final String[] m = {"UPDATE", "DELETE", "INSERT"};
    final String[] b;
    private Map c;
    final RoomDatabase d;
    volatile sw2 g;
    private b h;
    private final androidx.room.d i;
    private f k;
    AtomicBoolean e = new AtomicBoolean(false);
    private volatile boolean f = false;
    final lj2 j = new lj2();
    Runnable l = new a();
    final HashMap a = new HashMap();

    class a implements Runnable {
        a() {
        }

        private Set a() {
            HashSet hashSet = new HashSet();
            Cursor cursorQuery = e.this.d.query(new hp2("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (cursorQuery.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(cursorQuery.getInt(0)));
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            cursorQuery.close();
            if (!hashSet.isEmpty()) {
                e.this.g.E();
            }
            return hashSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            Lock closeLock = e.this.d.getCloseLock();
            Set setA = null;
            try {
                try {
                    closeLock.lock();
                    if (!e.this.c()) {
                        closeLock.unlock();
                        return;
                    }
                    if (!e.this.e.compareAndSet(true, false)) {
                        closeLock.unlock();
                        return;
                    }
                    if (e.this.d.inTransaction()) {
                        closeLock.unlock();
                        return;
                    }
                    RoomDatabase roomDatabase = e.this.d;
                    if (roomDatabase.mWriteAheadLoggingEnabled) {
                        ow2 ow2VarU = roomDatabase.getOpenHelper().U();
                        ow2VarU.d();
                        try {
                            setA = a();
                            ow2VarU.j();
                            ow2VarU.l();
                        } catch (Throwable th) {
                            ow2VarU.l();
                            throw th;
                        }
                    } else {
                        setA = a();
                    }
                    closeLock.unlock();
                    if (setA == null || setA.isEmpty()) {
                        return;
                    }
                    synchronized (e.this.j) {
                        try {
                            Iterator it = e.this.j.iterator();
                            while (it.hasNext()) {
                                ((d) ((Map.Entry) it.next()).getValue()).a(setA);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    closeLock.unlock();
                    throw th3;
                }
            } catch (SQLiteException e) {
                e = e;
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
            } catch (IllegalStateException e2) {
                e = e2;
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
            }
        }
    }

    static class b {
        final long[] a;
        final boolean[] b;
        final int[] c;
        boolean d;
        boolean e;

        b(int i) {
            long[] jArr = new long[i];
            this.a = jArr;
            boolean[] zArr = new boolean[i];
            this.b = zArr;
            this.c = new int[i];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        int[] a() {
            synchronized (this) {
                try {
                    if (this.d && !this.e) {
                        int length = this.a.length;
                        int i = 0;
                        while (true) {
                            int i2 = 1;
                            if (i >= length) {
                                this.e = true;
                                this.d = false;
                                return this.c;
                            }
                            boolean z = this.a[i] > 0;
                            boolean[] zArr = this.b;
                            if (z != zArr[i]) {
                                int[] iArr = this.c;
                                if (!z) {
                                    i2 = 2;
                                }
                                iArr[i] = i2;
                            } else {
                                this.c[i] = 0;
                            }
                            zArr[i] = z;
                            i++;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        boolean b(int... iArr) {
            boolean z;
            synchronized (this) {
                try {
                    z = false;
                    for (int i : iArr) {
                        long[] jArr = this.a;
                        long j = jArr[i];
                        jArr[i] = 1 + j;
                        if (j == 0) {
                            z = true;
                            this.d = true;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }

        boolean c(int... iArr) {
            boolean z;
            synchronized (this) {
                try {
                    z = false;
                    for (int i : iArr) {
                        long[] jArr = this.a;
                        long j = jArr[i];
                        jArr[i] = j - 1;
                        if (j == 1) {
                            z = true;
                            this.d = true;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }

        void d() {
            synchronized (this) {
                this.e = false;
            }
        }
    }

    public static abstract class c {
        final String[] a;

        public c(String[] strArr) {
            this.a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        abstract boolean a();

        public abstract void b(Set set);
    }

    static class d {
        final int[] a;
        private final String[] b;
        final c c;
        private final Set d;

        d(c cVar, int[] iArr, String[] strArr) {
            this.c = cVar;
            this.a = iArr;
            this.b = strArr;
            if (iArr.length != 1) {
                this.d = null;
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(strArr[0]);
            this.d = Collections.unmodifiableSet(hashSet);
        }

        void a(Set set) {
            int length = this.a.length;
            Set hashSet = null;
            for (int i = 0; i < length; i++) {
                if (set.contains(Integer.valueOf(this.a[i]))) {
                    if (length == 1) {
                        hashSet = this.d;
                    } else {
                        if (hashSet == null) {
                            hashSet = new HashSet(length);
                        }
                        hashSet.add(this.b[i]);
                    }
                }
            }
            if (hashSet != null) {
                this.c.b(hashSet);
            }
        }

        void b(String[] strArr) {
            Set set = null;
            if (this.b.length == 1) {
                for (String str : strArr) {
                    if (str.equalsIgnoreCase(this.b[0])) {
                        set = this.d;
                        break;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str2 : strArr) {
                    for (String str3 : this.b) {
                        if (str3.equalsIgnoreCase(str2)) {
                            hashSet.add(str3);
                            break;
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.c.b(set);
            }
        }
    }

    public e(RoomDatabase roomDatabase, Map map, Map map2, String... strArr) {
        this.d = roomDatabase;
        this.h = new b(strArr.length);
        this.c = map2;
        this.i = new androidx.room.d(roomDatabase);
        int length = strArr.length;
        this.b = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.a.put(lowerCase, Integer.valueOf(i));
            String str2 = (String) map.get(strArr[i]);
            if (str2 != null) {
                this.b[i] = str2.toLowerCase(locale);
            } else {
                this.b[i] = lowerCase;
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            String lowerCase2 = str3.toLowerCase(locale2);
            if (this.a.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) entry.getKey()).toLowerCase(locale2);
                HashMap map3 = this.a;
                map3.put(lowerCase3, map3.get(lowerCase2));
            }
        }
    }

    private static void b(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private String[] h(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.c.containsKey(lowerCase)) {
                hashSet.addAll((Collection) this.c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private void j(ow2 ow2Var, int i) {
        ow2Var.e("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        String str = this.b[i];
        StringBuilder sb = new StringBuilder();
        for (String str2 : m) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            b(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            ow2Var.e(sb.toString());
        }
    }

    private void l(ow2 ow2Var, int i) {
        String str = this.b[i];
        StringBuilder sb = new StringBuilder();
        for (String str2 : m) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            b(sb, str, str2);
            ow2Var.e(sb.toString());
        }
    }

    public void a(c cVar) {
        d dVar;
        String[] strArrH = h(cVar.a);
        int[] iArr = new int[strArrH.length];
        int length = strArrH.length;
        for (int i = 0; i < length; i++) {
            Integer num = (Integer) this.a.get(strArrH[i].toLowerCase(Locale.US));
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + strArrH[i]);
            }
            iArr[i] = num.intValue();
        }
        d dVar2 = new d(cVar, iArr, strArrH);
        synchronized (this.j) {
            dVar = (d) this.j.f(cVar, dVar2);
        }
        if (dVar == null && this.h.b(iArr)) {
            m();
        }
    }

    boolean c() {
        if (!this.d.isOpen()) {
            return false;
        }
        if (!this.f) {
            this.d.getOpenHelper().U();
        }
        if (this.f) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    void d(ow2 ow2Var) {
        synchronized (this) {
            try {
                if (this.f) {
                    Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                    return;
                }
                ow2Var.e("PRAGMA temp_store = MEMORY;");
                ow2Var.e("PRAGMA recursive_triggers='ON';");
                ow2Var.e("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                n(ow2Var);
                this.g = ow2Var.g("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
                this.f = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(String... strArr) {
        synchronized (this.j) {
            try {
                for (Map.Entry entry : this.j) {
                    if (!((c) entry.getKey()).a()) {
                        ((d) entry.getValue()).b(strArr);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f() {
        if (this.e.compareAndSet(false, true)) {
            this.d.getQueryExecutor().execute(this.l);
        }
    }

    public void g(c cVar) {
        d dVar;
        synchronized (this.j) {
            dVar = (d) this.j.g(cVar);
        }
        if (dVar == null || !this.h.c(dVar.a)) {
            return;
        }
        m();
    }

    void i(Context context, String str) {
        this.k = new f(context, str, this, this.d.getQueryExecutor());
    }

    void k() {
        f fVar = this.k;
        if (fVar != null) {
            fVar.a();
            this.k = null;
        }
    }

    void m() {
        if (this.d.isOpen()) {
            n(this.d.getOpenHelper().U());
        }
    }

    void n(ow2 ow2Var) {
        if (ow2Var.r0()) {
            return;
        }
        while (true) {
            try {
                Lock closeLock = this.d.getCloseLock();
                closeLock.lock();
                try {
                    int[] iArrA = this.h.a();
                    if (iArrA == null) {
                        closeLock.unlock();
                        return;
                    }
                    int length = iArrA.length;
                    ow2Var.d();
                    for (int i = 0; i < length; i++) {
                        try {
                            int i2 = iArrA[i];
                            if (i2 == 1) {
                                j(ow2Var, i);
                            } else if (i2 == 2) {
                                l(ow2Var, i);
                            }
                        } catch (Throwable th) {
                            ow2Var.l();
                            throw th;
                        }
                    }
                    ow2Var.j();
                    ow2Var.l();
                    this.h.d();
                    closeLock.unlock();
                } catch (Throwable th2) {
                    closeLock.unlock();
                    throw th2;
                }
            } catch (SQLiteException | IllegalStateException e) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                return;
            }
        }
    }
}
