package defpackage;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class l72 implements yi0, dp0 {
    private static final String l = fd1.f("Processor");
    private Context b;
    private androidx.work.a c;
    private w03 d;
    private WorkDatabase e;
    private List h;
    private Map g = new HashMap();
    private Map f = new HashMap();
    private Set i = new HashSet();
    private final List j = new ArrayList();
    private PowerManager.WakeLock a = null;
    private final Object k = new Object();

    private static class a implements Runnable {
        private yi0 a;
        private String b;
        private ub1 c;

        a(yi0 yi0Var, String str, ub1 ub1Var) {
            this.a = yi0Var;
            this.b = str;
            this.c = ub1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zBooleanValue;
            try {
                zBooleanValue = ((Boolean) this.c.get()).booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                zBooleanValue = true;
            }
            this.a.c(this.b, zBooleanValue);
        }
    }

    public l72(Context context, androidx.work.a aVar, w03 w03Var, WorkDatabase workDatabase, List list) {
        this.b = context;
        this.c = aVar;
        this.d = w03Var;
        this.e = workDatabase;
        this.h = list;
    }

    private static boolean e(String str, gl3 gl3Var) {
        if (gl3Var == null) {
            fd1.c().a(l, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
            return false;
        }
        gl3Var.d();
        fd1.c().a(l, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
        return true;
    }

    private void m() {
        synchronized (this.k) {
            try {
                if (this.f.isEmpty()) {
                    try {
                        this.b.startService(androidx.work.impl.foreground.a.e(this.b));
                    } catch (Throwable th) {
                        fd1.c().b(l, "Unable to stop foreground service", th);
                    }
                    PowerManager.WakeLock wakeLock = this.a;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.a = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // defpackage.dp0
    public void a(String str, cp0 cp0Var) {
        synchronized (this.k) {
            try {
                fd1.c().d(l, String.format("Moving WorkSpec (%s) to the foreground", str), new Throwable[0]);
                gl3 gl3Var = (gl3) this.g.remove(str);
                if (gl3Var != null) {
                    if (this.a == null) {
                        PowerManager.WakeLock wakeLockB = lg3.b(this.b, "ProcessorForegroundLck");
                        this.a = wakeLockB;
                        wakeLockB.acquire();
                    }
                    this.f.put(str, gl3Var);
                    q30.l(this.b, androidx.work.impl.foreground.a.d(this.b, str, cp0Var));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.dp0
    public void b(String str) {
        synchronized (this.k) {
            this.f.remove(str);
            m();
        }
    }

    @Override // defpackage.yi0
    public void c(String str, boolean z) {
        synchronized (this.k) {
            try {
                this.g.remove(str);
                fd1.c().a(l, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z)), new Throwable[0]);
                Iterator it = this.j.iterator();
                while (it.hasNext()) {
                    ((yi0) it.next()).c(str, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(yi0 yi0Var) {
        synchronized (this.k) {
            this.j.add(yi0Var);
        }
    }

    public boolean f(String str) {
        boolean zContains;
        synchronized (this.k) {
            zContains = this.i.contains(str);
        }
        return zContains;
    }

    public boolean g(String str) {
        boolean z;
        synchronized (this.k) {
            try {
                z = this.g.containsKey(str) || this.f.containsKey(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public boolean h(String str) {
        boolean zContainsKey;
        synchronized (this.k) {
            zContainsKey = this.f.containsKey(str);
        }
        return zContainsKey;
    }

    public void i(yi0 yi0Var) {
        synchronized (this.k) {
            this.j.remove(yi0Var);
        }
    }

    public boolean j(String str) {
        return k(str, null);
    }

    public boolean k(String str, WorkerParameters.a aVar) {
        synchronized (this.k) {
            try {
                if (g(str)) {
                    fd1.c().a(l, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                    return false;
                }
                gl3 gl3VarA = new gl3.c(this.b, this.c, this.d, this, this.e, str).c(this.h).b(aVar).a();
                ub1 ub1VarB = gl3VarA.b();
                ub1VarB.a(new a(this, str, ub1VarB), this.d.a());
                this.g.put(str, gl3VarA);
                this.d.c().execute(gl3VarA);
                fd1.c().a(l, String.format("%s: processing %s", getClass().getSimpleName(), str), new Throwable[0]);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean l(String str) {
        boolean zE;
        synchronized (this.k) {
            try {
                fd1.c().a(l, String.format("Processor cancelling %s", str), new Throwable[0]);
                this.i.add(str);
                gl3 gl3Var = (gl3) this.f.remove(str);
                boolean z = gl3Var != null;
                if (gl3Var == null) {
                    gl3Var = (gl3) this.g.remove(str);
                }
                zE = e(str, gl3Var);
                if (z) {
                    m();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zE;
    }

    public boolean n(String str) {
        boolean zE;
        synchronized (this.k) {
            fd1.c().a(l, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            zE = e(str, (gl3) this.f.remove(str));
        }
        return zE;
    }

    public boolean o(String str) {
        boolean zE;
        synchronized (this.k) {
            fd1.c().a(l, String.format("Processor stopping background work %s", str), new Throwable[0]);
            zE = e(str, (gl3) this.g.remove(str));
        }
        return zE;
    }
}
