package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import defpackage.dl3;
import defpackage.fd1;
import defpackage.l72;
import defpackage.lg3;
import defpackage.nk3;
import defpackage.um2;
import defpackage.w03;
import defpackage.yi0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e implements yi0 {
    static final String k = fd1.f("SystemAlarmDispatcher");
    final Context a;
    private final w03 b;
    private final dl3 c;
    private final l72 d;
    private final nk3 e;
    final androidx.work.impl.background.systemalarm.b f;
    private final Handler g;
    final List h;
    Intent i;
    private c j;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            d dVar;
            synchronized (e.this.h) {
                e eVar2 = e.this;
                eVar2.i = (Intent) eVar2.h.get(0);
            }
            Intent intent = e.this.i;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = e.this.i.getIntExtra("KEY_START_ID", 0);
                fd1 fd1VarC = fd1.c();
                String str = e.k;
                fd1VarC.a(str, String.format("Processing command %s, %s", e.this.i, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock wakeLockB = lg3.b(e.this.a, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    fd1.c().a(str, String.format("Acquiring operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                    wakeLockB.acquire();
                    e eVar3 = e.this;
                    eVar3.f.o(eVar3.i, intExtra, eVar3);
                    fd1.c().a(str, String.format("Releasing operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                    wakeLockB.release();
                    eVar = e.this;
                    dVar = new d(eVar);
                } catch (Throwable th) {
                    try {
                        fd1 fd1VarC2 = fd1.c();
                        String str2 = e.k;
                        fd1VarC2.b(str2, "Unexpected error in onHandleIntent", th);
                        fd1.c().a(str2, String.format("Releasing operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                        wakeLockB.release();
                        eVar = e.this;
                        dVar = new d(eVar);
                    } catch (Throwable th2) {
                        fd1.c().a(e.k, String.format("Releasing operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                        wakeLockB.release();
                        e eVar4 = e.this;
                        eVar4.k(new d(eVar4));
                        throw th2;
                    }
                }
                eVar.k(dVar);
            }
        }
    }

    static class b implements Runnable {
        private final e a;
        private final Intent b;
        private final int c;

        b(e eVar, Intent intent, int i) {
            this.a = eVar;
            this.b = intent;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b, this.c);
        }
    }

    interface c {
        void a();
    }

    static class d implements Runnable {
        private final e a;

        d(e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.d();
        }
    }

    e(Context context) {
        this(context, null, null);
    }

    private void b() {
        if (this.g.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    private boolean i(String str) {
        b();
        synchronized (this.h) {
            try {
                Iterator it = this.h.iterator();
                while (it.hasNext()) {
                    if (str.equals(((Intent) it.next()).getAction())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void l() {
        b();
        PowerManager.WakeLock wakeLockB = lg3.b(this.a, "ProcessCommand");
        try {
            wakeLockB.acquire();
            this.e.o().b(new a());
        } finally {
            wakeLockB.release();
        }
    }

    public boolean a(Intent intent, int i) {
        fd1 fd1VarC = fd1.c();
        String str = k;
        fd1VarC.a(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i)), new Throwable[0]);
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            fd1.c().h(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && i("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        }
        intent.putExtra("KEY_START_ID", i);
        synchronized (this.h) {
            try {
                boolean zIsEmpty = this.h.isEmpty();
                this.h.add(intent);
                if (zIsEmpty) {
                    l();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    @Override // defpackage.yi0
    public void c(String str, boolean z) {
        k(new b(this, androidx.work.impl.background.systemalarm.b.d(this.a, str, z), 0));
    }

    void d() {
        fd1 fd1VarC = fd1.c();
        String str = k;
        fd1VarC.a(str, "Checking if commands are complete.", new Throwable[0]);
        b();
        synchronized (this.h) {
            try {
                if (this.i != null) {
                    fd1.c().a(str, String.format("Removing command %s", this.i), new Throwable[0]);
                    if (!((Intent) this.h.remove(0)).equals(this.i)) {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                    this.i = null;
                }
                um2 um2VarC = this.b.c();
                if (!this.f.n() && this.h.isEmpty() && !um2VarC.a()) {
                    fd1.c().a(str, "No more commands & intents.", new Throwable[0]);
                    c cVar = this.j;
                    if (cVar != null) {
                        cVar.a();
                    }
                } else if (!this.h.isEmpty()) {
                    l();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    l72 e() {
        return this.d;
    }

    w03 f() {
        return this.b;
    }

    nk3 g() {
        return this.e;
    }

    dl3 h() {
        return this.c;
    }

    void j() {
        fd1.c().a(k, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.d.i(this);
        this.c.a();
        this.j = null;
    }

    void k(Runnable runnable) {
        this.g.post(runnable);
    }

    void m(c cVar) {
        if (this.j != null) {
            fd1.c().b(k, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.j = cVar;
        }
    }

    e(Context context, l72 l72Var, nk3 nk3Var) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f = new androidx.work.impl.background.systemalarm.b(applicationContext);
        this.c = new dl3();
        nk3Var = nk3Var == null ? nk3.j(context) : nk3Var;
        this.e = nk3Var;
        l72Var = l72Var == null ? nk3Var.l() : l72Var;
        this.d = l72Var;
        this.b = nk3Var.o();
        l72Var.d(this);
        this.h = new ArrayList();
        this.i = null;
        this.g = new Handler(Looper.getMainLooper());
    }
}
