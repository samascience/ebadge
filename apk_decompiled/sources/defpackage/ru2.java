package defpackage;

import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;

/* JADX INFO: loaded from: classes.dex */
public class ru2 implements Runnable {
    private static final String d = fd1.f("StopWorkRunnable");
    private final nk3 a;
    private final String b;
    private final boolean c;

    public ru2(nk3 nk3Var, String str, boolean z) {
        this.a = nk3Var;
        this.b = str;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zO;
        WorkDatabase workDatabaseN = this.a.n();
        l72 l72VarL = this.a.l();
        yk3 yk3VarK = workDatabaseN.k();
        workDatabaseN.beginTransaction();
        try {
            boolean zH = l72VarL.h(this.b);
            if (this.c) {
                zO = this.a.l().n(this.b);
            } else {
                if (!zH && yk3VarK.l(this.b) == WorkInfo$State.RUNNING) {
                    yk3VarK.b(WorkInfo$State.ENQUEUED, this.b);
                }
                zO = this.a.l().o(this.b);
            }
            fd1.c().a(d, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.b, Boolean.valueOf(zO)), new Throwable[0]);
            workDatabaseN.setTransactionSuccessful();
        } finally {
            workDatabaseN.endTransaction();
        }
    }
}
