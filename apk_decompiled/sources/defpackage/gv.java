package defpackage;

import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class gv implements Runnable {
    private final vw1 a = new vw1();

    class a extends gv {
        final /* synthetic */ nk3 b;
        final /* synthetic */ UUID c;

        a(nk3 nk3Var, UUID uuid) {
            this.b = nk3Var;
            this.c = uuid;
        }

        @Override // defpackage.gv
        void g() {
            WorkDatabase workDatabaseN = this.b.n();
            workDatabaseN.beginTransaction();
            try {
                a(this.b, this.c.toString());
                workDatabaseN.setTransactionSuccessful();
                workDatabaseN.endTransaction();
                f(this.b);
            } catch (Throwable th) {
                workDatabaseN.endTransaction();
                throw th;
            }
        }
    }

    class b extends gv {
        final /* synthetic */ nk3 b;
        final /* synthetic */ String c;
        final /* synthetic */ boolean d;

        b(nk3 nk3Var, String str, boolean z) {
            this.b = nk3Var;
            this.c = str;
            this.d = z;
        }

        @Override // defpackage.gv
        void g() {
            WorkDatabase workDatabaseN = this.b.n();
            workDatabaseN.beginTransaction();
            try {
                Iterator it = workDatabaseN.k().k(this.c).iterator();
                while (it.hasNext()) {
                    a(this.b, (String) it.next());
                }
                workDatabaseN.setTransactionSuccessful();
                workDatabaseN.endTransaction();
                if (this.d) {
                    f(this.b);
                }
            } catch (Throwable th) {
                workDatabaseN.endTransaction();
                throw th;
            }
        }
    }

    public static gv b(UUID uuid, nk3 nk3Var) {
        return new a(nk3Var, uuid);
    }

    public static gv c(String str, nk3 nk3Var, boolean z) {
        return new b(nk3Var, str, z);
    }

    private void e(WorkDatabase workDatabase, String str) {
        yk3 yk3VarK = workDatabase.k();
        k90 k90VarC = workDatabase.c();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo$State workInfo$StateL = yk3VarK.l(str2);
            if (workInfo$StateL != WorkInfo$State.SUCCEEDED && workInfo$StateL != WorkInfo$State.FAILED) {
                yk3VarK.b(WorkInfo$State.CANCELLED, str2);
            }
            linkedList.addAll(k90VarC.a(str2));
        }
    }

    void a(nk3 nk3Var, String str) {
        e(nk3Var.n(), str);
        nk3Var.l().l(str);
        Iterator it = nk3Var.m().iterator();
        while (it.hasNext()) {
            ((rk2) it.next()).d(str);
        }
    }

    public tw1 d() {
        return this.a;
    }

    void f(nk3 nk3Var) {
        sk2.b(nk3Var.h(), nk3Var.n(), nk3Var.m());
    }

    abstract void g();

    @Override // java.lang.Runnable
    public void run() {
        try {
            g();
            this.a.a(tw1.a);
        } catch (Throwable th) {
            this.a.a(new tw1.b.a(th));
        }
    }
}
