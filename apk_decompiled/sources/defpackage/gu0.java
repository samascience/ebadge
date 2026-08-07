package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.e;
import com.bumptech.glide.f;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class gu0 {
    private final zt0 a;
    private final Handler b;
    private final List c;
    final f d;
    private final oi e;
    private boolean f;
    private boolean g;
    private boolean h;
    private e i;
    private a j;
    private boolean k;
    private a l;
    private Bitmap m;
    private z43 n;
    private a o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f340q;
    private int r;

    static class a extends o50 {
        private final Handler d;
        final int e;
        private final long f;
        private Bitmap g;

        a(Handler handler, int i, long j) {
            this.d = handler;
            this.e = i;
            this.f = j;
        }

        @Override // defpackage.j03
        public void h(Drawable drawable) {
            this.g = null;
        }

        Bitmap i() {
            return this.g;
        }

        @Override // defpackage.j03
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, l53 l53Var) {
            this.g = bitmap;
            this.d.sendMessageAtTime(this.d.obtainMessage(1, this), this.f);
        }
    }

    public interface b {
        void a();
    }

    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                gu0.this.m((a) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            gu0.this.d.m((a) message.obj);
            return false;
        }
    }

    gu0(com.bumptech.glide.a aVar, zt0 zt0Var, int i, int i2, z43 z43Var, Bitmap bitmap) {
        this(aVar.f(), com.bumptech.glide.a.u(aVar.h()), zt0Var, null, i(com.bumptech.glide.a.u(aVar.h()), i, i2), z43Var, bitmap);
    }

    private static w81 g() {
        return new nt1(Double.valueOf(Math.random()));
    }

    private static e i(f fVar, int i, int i2) {
        return fVar.j().a(((of2) ((of2) of2.l0(ac0.b).i0(true)).d0(true)).T(i, i2));
    }

    private void l() {
        if (!this.f || this.g) {
            return;
        }
        if (this.h) {
            z42.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.a.g();
            this.h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            m(aVar);
            return;
        }
        this.g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.a.d());
        this.a.b();
        this.l = new a(this.b, this.a.h(), jUptimeMillis);
        this.i.a(of2.m0(g())).y0(this.a).r0(this.l);
    }

    private void n() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.e.c(bitmap);
            this.m = null;
        }
    }

    private void p() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.k = false;
        l();
    }

    private void q() {
        this.f = false;
    }

    void a() {
        this.c.clear();
        n();
        q();
        a aVar = this.j;
        if (aVar != null) {
            this.d.m(aVar);
            this.j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.d.m(aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.d.m(aVar3);
            this.o = null;
        }
        this.a.clear();
        this.k = true;
    }

    ByteBuffer b() {
        return this.a.f().asReadOnlyBuffer();
    }

    Bitmap c() {
        a aVar = this.j;
        return aVar != null ? aVar.i() : this.m;
    }

    int d() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.e;
        }
        return -1;
    }

    Bitmap e() {
        return this.m;
    }

    int f() {
        return this.a.c();
    }

    int h() {
        return this.r;
    }

    int j() {
        return this.a.i() + this.p;
    }

    int k() {
        return this.f340q;
    }

    void m(a aVar) {
        this.g = false;
        if (this.k) {
            this.b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f) {
            if (this.h) {
                this.b.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.o = aVar;
                return;
            }
        }
        if (aVar.i() != null) {
            n();
            a aVar2 = this.j;
            this.j = aVar;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                ((b) this.c.get(size)).a();
            }
            if (aVar2 != null) {
                this.b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        l();
    }

    void o(z43 z43Var, Bitmap bitmap) {
        this.n = (z43) z42.d(z43Var);
        this.m = (Bitmap) z42.d(bitmap);
        this.i = this.i.a(new of2().e0(z43Var));
        this.p = na3.g(bitmap);
        this.f340q = bitmap.getWidth();
        this.r = bitmap.getHeight();
    }

    void r(b bVar) {
        if (this.k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.c.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.c.isEmpty();
        this.c.add(bVar);
        if (zIsEmpty) {
            p();
        }
    }

    void s(b bVar) {
        this.c.remove(bVar);
        if (this.c.isEmpty()) {
            q();
        }
    }

    gu0(oi oiVar, f fVar, zt0 zt0Var, Handler handler, e eVar, z43 z43Var, Bitmap bitmap) {
        this.c = new ArrayList();
        this.d = fVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.e = oiVar;
        this.b = handler;
        this.i = eVar;
        this.a = zt0Var;
        o(z43Var, bitmap);
    }
}
