package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.legend.mywatch.sdk.mywatchsdklib.android.sdk.SDKInitState;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.i;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class tg3 {
    public static final a g = new a(null);
    private static final String h;
    private static Application i;
    private static tg3 j;
    private b b;
    private wj d;
    private i10 a = new i10();
    private List c = new ArrayList();
    private SDKInitState e = SDKInitState.NOT_INITIALIZED;
    private List f = new ArrayList();

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final synchronized void a(int i, String str) {
            p31.f(str, "mac");
            if (d().l().i()) {
                yc1.a(tg3.h, "doConnectStatusBroadCast:" + i);
                return;
            }
            yc1.a(tg3.h, "doConnectStatusBroadCast:" + i);
            if (e20.d != i) {
                yc1.a(tg3.h, "oldState:" + e20.d + ";currentState:" + i);
                e20.d = i;
                o10 o10Var = new o10(i);
                o10Var.setMacAddress(str);
                c(o10Var, str);
            } else {
                yc1.a(tg3.h, "oldState:" + e20.d + ";currentState:" + i);
            }
        }

        public final void b(ng ngVar) {
            String strP;
            p31.f(ngVar, "event");
            com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.c cVarO = com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.c.o();
            if (cVarO == null || (strP = cVarO.p()) == null) {
                strP = Constants.STR_EMPTY;
            }
            c(ngVar, strP);
        }

        public final void c(ng ngVar, String str) {
            p31.f(ngVar, "event");
            p31.f(str, "mac");
            ngVar.setMacAddress(str);
            if (d().b != null) {
                b bVar = d().b;
                p31.c(bVar);
                bVar.a(ngVar);
            }
            Iterator it = d().c.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(ngVar);
            }
        }

        public final tg3 d() {
            if (tg3.j == null) {
                tg3.j = new tg3();
            }
            tg3 tg3Var = tg3.j;
            p31.c(tg3Var);
            return tg3Var;
        }

        public final Context e() {
            return tg3.i;
        }

        private a() {
        }
    }

    public interface b {
        void a(ng ngVar);
    }

    public static final class c implements i.b {
        c() {
        }

        @Override // com.legend.mywatch.sdk.mywatchsdklib.android.utils.i.b
        public void a(Activity activity) {
            p31.f(activity, "activity");
            zi2.p(true);
            wj wjVar = tg3.this.d;
            p31.c(wjVar);
            wjVar.l();
        }

        @Override // com.legend.mywatch.sdk.mywatchsdklib.android.utils.i.b
        public void b(Activity activity) {
            p31.f(activity, "activity");
            zi2.p(false);
        }
    }

    static {
        String simpleName = tg3.class.getSimpleName();
        p31.e(simpleName, "getSimpleName(...)");
        h = simpleName;
    }

    public static final synchronized void i(int i2, String str) {
        g.a(i2, str);
    }

    public static final void j(ng ngVar) {
        g.b(ngVar);
    }

    public static final void k(ng ngVar, String str) {
        g.c(ngVar, str);
    }

    public static final tg3 m() {
        return g.d();
    }

    public static final Context n() {
        return g.e();
    }

    private final void p() {
        com.legend.mywatch.sdk.mywatchsdklib.android.utils.c.b(new c());
    }

    private final void r(SDKInitState sDKInitState, SDKInitState sDKInitState2) {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            e43.a(it.next());
            try {
                throw null;
            } catch (Exception e) {
                yc1.a(h, "初始化状态监听器回调异常: " + e.getMessage());
            }
        }
    }

    private final void u(SDKInitState sDKInitState) {
        SDKInitState sDKInitState2 = this.e;
        this.e = sDKInitState;
        if (sDKInitState2 != sDKInitState) {
            r(sDKInitState2, sDKInitState);
        }
    }

    public final tg3 h(b bVar) {
        if (bVar != null && !this.c.contains(bVar)) {
            this.c.add(bVar);
        }
        return this;
    }

    public final i10 l() {
        return this.a;
    }

    public final tg3 o(Application application) {
        u(SDKInitState.INITIALIZING);
        try {
            i = application;
            e20.c = new Handler(Looper.getMainLooper());
            sj2.a(i);
            i.b(i);
            com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.a.Z().c0();
            this.d = wj.m();
            p();
            u(SDKInitState.INITIALIZED);
            yc1.a(h, "SDK初始化成功");
        } catch (Exception e) {
            u(SDKInitState.INITIALIZE_FAILED);
            yc1.a(h, "SDK初始化失败: " + e.getMessage());
        }
        return this;
    }

    public final boolean q() {
        return this.e == SDKInitState.INITIALIZED;
    }

    public final tg3 s(b bVar) {
        if (bVar != null) {
            this.c.remove(bVar);
        }
        return this;
    }

    public final tg3 t(i10 i10Var) {
        p31.f(i10Var, "config");
        this.a = i10Var;
        return this;
    }

    public final tg3 v(b bVar) {
        this.b = bVar;
        if (bVar != null) {
            h(bVar);
        }
        return this;
    }
}
