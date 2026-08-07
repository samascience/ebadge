package defpackage;

import android.content.Context;
import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class lk3 implements ep0 {
    private static final String d = fd1.f("WMFgUpdater");
    private final w03 a;
    final dp0 b;
    final yk3 c;

    class a implements Runnable {
        final /* synthetic */ mn2 a;
        final /* synthetic */ UUID b;
        final /* synthetic */ cp0 c;
        final /* synthetic */ Context d;

        a(mn2 mn2Var, UUID uuid, cp0 cp0Var, Context context) {
            this.a = mn2Var;
            this.b = uuid;
            this.c = cp0Var;
            this.d = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.a.isCancelled()) {
                    String string = this.b.toString();
                    WorkInfo$State workInfo$StateL = lk3.this.c.l(string);
                    if (workInfo$StateL == null || workInfo$StateL.isFinished()) {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    lk3.this.b.a(string, this.c);
                    this.d.startService(androidx.work.impl.foreground.a.a(this.d, string, this.c));
                }
                this.a.p(null);
            } catch (Throwable th) {
                this.a.q(th);
            }
        }
    }

    public lk3(WorkDatabase workDatabase, dp0 dp0Var, w03 w03Var) {
        this.b = dp0Var;
        this.a = w03Var;
        this.c = workDatabase.k();
    }

    @Override // defpackage.ep0
    public ub1 a(Context context, UUID uuid, cp0 cp0Var) {
        mn2 mn2VarT = mn2.t();
        this.a.b(new a(mn2VarT, uuid, cp0Var, context));
        return mn2VarT;
    }
}
