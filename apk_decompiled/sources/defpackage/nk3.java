package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.work.R$bool;
import androidx.work.WorkerParameters;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.ForceStopRunnable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class nk3 extends mk3 {
    private static final String j = fd1.f("WorkManagerImpl");
    private static nk3 k = null;
    private static nk3 l = null;
    private static final Object m = new Object();
    private Context a;
    private a b;
    private WorkDatabase c;
    private w03 d;
    private List e;
    private l72 f;
    private i52 g;
    private boolean h;
    private BroadcastReceiver.PendingResult i;

    public nk3(Context context, a aVar, w03 w03Var) {
        this(context, aVar, w03Var, context.getResources().getBoolean(R$bool.workmanager_test_configuration));
    }

    public static void d(Context context, a aVar) {
        synchronized (m) {
            try {
                nk3 nk3Var = k;
                if (nk3Var != null && l != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (nk3Var == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (l == null) {
                        l = new nk3(applicationContext, aVar, new ok3(aVar.l()));
                    }
                    k = l;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static nk3 i() {
        synchronized (m) {
            try {
                nk3 nk3Var = k;
                if (nk3Var != null) {
                    return nk3Var;
                }
                return l;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static nk3 j(Context context) {
        nk3 nk3VarI;
        synchronized (m) {
            try {
                nk3VarI = i();
                if (nk3VarI == null) {
                    context.getApplicationContext();
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nk3VarI;
    }

    private void p(Context context, a aVar, w03 w03Var, WorkDatabase workDatabase, List list, l72 l72Var) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = aVar;
        this.d = w03Var;
        this.c = workDatabase;
        this.e = list;
        this.f = l72Var;
        this.g = new i52(workDatabase);
        this.h = false;
        if (applicationContext.isDeviceProtectedStorage()) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        this.d.b(new ForceStopRunnable(applicationContext, this));
    }

    @Override // defpackage.mk3
    public tw1 b(List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new ik3(this, list).a();
    }

    public tw1 e(UUID uuid) {
        gv gvVarB = gv.b(uuid, this);
        this.d.b(gvVarB);
        return gvVarB.d();
    }

    public List f(Context context, a aVar, w03 w03Var) {
        return Arrays.asList(sk2.a(context, this), new kv0(context, aVar, w03Var, this));
    }

    public Context g() {
        return this.a;
    }

    public a h() {
        return this.b;
    }

    public i52 k() {
        return this.g;
    }

    public l72 l() {
        return this.f;
    }

    public List m() {
        return this.e;
    }

    public WorkDatabase n() {
        return this.c;
    }

    public w03 o() {
        return this.d;
    }

    public void q() {
        synchronized (m) {
            try {
                this.h = true;
                BroadcastReceiver.PendingResult pendingResult = this.i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void r() {
        nz2.b(g());
        n().k().t();
        sk2.b(h(), n(), m());
    }

    public void s(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (m) {
            try {
                this.i = pendingResult;
                if (this.h) {
                    pendingResult.finish();
                    this.i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void t(String str) {
        u(str, null);
    }

    public void u(String str, WorkerParameters.a aVar) {
        this.d.b(new pt2(this, str, aVar));
    }

    public void v(String str) {
        this.d.b(new ru2(this, str, true));
    }

    public void w(String str) {
        this.d.b(new ru2(this, str, false));
    }

    public nk3(Context context, a aVar, w03 w03Var, boolean z) {
        this(context, aVar, w03Var, WorkDatabase.b(context.getApplicationContext(), w03Var.c(), z));
    }

    public nk3(Context context, a aVar, w03 w03Var, WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        fd1.e(new fd1.a(aVar.j()));
        List listF = f(applicationContext, aVar, w03Var);
        p(context, aVar, w03Var, workDatabase, listF, new l72(context, aVar, w03Var, workDatabase, listF));
    }
}
