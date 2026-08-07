package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import defpackage.cp0;
import defpackage.fd1;
import defpackage.fk3;
import defpackage.gk3;
import defpackage.nk3;
import defpackage.w03;
import defpackage.xk3;
import defpackage.yi0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class a implements fk3, yi0 {
    static final String k = fd1.f("SystemFgDispatcher");
    private Context a;
    private nk3 b;
    private final w03 c;
    final Object d = new Object();
    String e;
    final Map f;
    final Map g;
    final Set h;
    final gk3 i;
    private b j;

    /* JADX INFO: renamed from: androidx.work.impl.foreground.a$a, reason: collision with other inner class name */
    class RunnableC0044a implements Runnable {
        final /* synthetic */ WorkDatabase a;
        final /* synthetic */ String b;

        RunnableC0044a(WorkDatabase workDatabase, String str) {
            this.a = workDatabase;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            xk3 xk3VarM = this.a.k().m(this.b);
            if (xk3VarM == null || !xk3VarM.b()) {
                return;
            }
            synchronized (a.this.d) {
                a.this.g.put(this.b, xk3VarM);
                a.this.h.add(xk3VarM);
                a aVar = a.this;
                aVar.i.d(aVar.h);
            }
        }
    }

    interface b {
        void b(int i, int i2, Notification notification);

        void c(int i, Notification notification);

        void d(int i);

        void stop();
    }

    a(Context context) {
        this.a = context;
        nk3 nk3VarJ = nk3.j(context);
        this.b = nk3VarJ;
        w03 w03VarO = nk3VarJ.o();
        this.c = w03VarO;
        this.e = null;
        this.f = new LinkedHashMap();
        this.h = new HashSet();
        this.g = new HashMap();
        this.i = new gk3(this.a, w03VarO, this);
        this.b.l().d(this);
    }

    public static Intent a(Context context, String str, cp0 cp0Var) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", cp0Var.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", cp0Var.a());
        intent.putExtra("KEY_NOTIFICATION", cp0Var.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent d(Context context, String str, cp0 cp0Var) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", cp0Var.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", cp0Var.a());
        intent.putExtra("KEY_NOTIFICATION", cp0Var.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent e(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    private void g(Intent intent) {
        fd1.c().d(k, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.b.e(UUID.fromString(stringExtra));
    }

    private void h(Intent intent) {
        int iA = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        fd1.c().a(k, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (notification == null || this.j == null) {
            return;
        }
        this.f.put(stringExtra, new cp0(intExtra, notification, intExtra2));
        if (TextUtils.isEmpty(this.e)) {
            this.e = stringExtra;
            this.j.b(intExtra, intExtra2, notification);
            return;
        }
        this.j.c(intExtra, notification);
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            iA |= ((cp0) ((Map.Entry) it.next()).getValue()).a();
        }
        cp0 cp0Var = (cp0) this.f.get(this.e);
        if (cp0Var != null) {
            this.j.b(cp0Var.c(), iA, cp0Var.b());
        }
    }

    private void i(Intent intent) {
        fd1.c().d(k, String.format("Started foreground service %s", intent), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        this.c.b(new RunnableC0044a(this.b.n(), stringExtra));
    }

    @Override // defpackage.fk3
    public void b(List list) {
        if (list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            fd1.c().a(k, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
            this.b.v(str);
        }
    }

    @Override // defpackage.yi0
    public void c(String str, boolean z) {
        Map.Entry entry;
        synchronized (this.d) {
            try {
                xk3 xk3Var = (xk3) this.g.remove(str);
                if (xk3Var != null ? this.h.remove(xk3Var) : false) {
                    this.i.d(this.h);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        cp0 cp0Var = (cp0) this.f.remove(str);
        if (str.equals(this.e) && this.f.size() > 0) {
            Iterator it = this.f.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it.hasNext()) {
                    break;
                } else {
                    next = it.next();
                }
            }
            this.e = (String) entry.getKey();
            if (this.j != null) {
                cp0 cp0Var2 = (cp0) entry.getValue();
                this.j.b(cp0Var2.c(), cp0Var2.a(), cp0Var2.b());
                this.j.d(cp0Var2.c());
            }
        }
        b bVar = this.j;
        if (cp0Var == null || bVar == null) {
            return;
        }
        fd1.c().a(k, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(cp0Var.c()), str, Integer.valueOf(cp0Var.a())), new Throwable[0]);
        bVar.d(cp0Var.c());
    }

    @Override // defpackage.fk3
    public void f(List list) {
    }

    void j(Intent intent) {
        fd1.c().d(k, "Stopping foreground service", new Throwable[0]);
        b bVar = this.j;
        if (bVar != null) {
            bVar.stop();
        }
    }

    void k() {
        this.j = null;
        synchronized (this.d) {
            this.i.e();
        }
        this.b.l().i(this);
    }

    void l(Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            i(intent);
            h(intent);
        } else if ("ACTION_NOTIFY".equals(action)) {
            h(intent);
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            g(intent);
        } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
            j(intent);
        }
    }

    void m(b bVar) {
        if (this.j != null) {
            fd1.c().b(k, "A callback already exists.", new Throwable[0]);
        } else {
            this.j = bVar;
        }
    }
}
