package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.v;
import defpackage.x01;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class b0 implements x01 {
    private final x01 d;
    private final Surface e;
    private l.a f;
    private final Object a = new Object();
    private int b = 0;
    private boolean c = false;
    private final l.a g = new l.a() { // from class: kj2
        @Override // androidx.camera.core.l.a
        public final void b(v vVar) {
            this.a.k(vVar);
        }
    };

    public b0(x01 x01Var) {
        this.d = x01Var;
        this.e = x01Var.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(v vVar) {
        l.a aVar;
        synchronized (this.a) {
            try {
                int i = this.b - 1;
                this.b = i;
                if (this.c && i == 0) {
                    close();
                }
                aVar = this.f;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            aVar.b(vVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(x01.a aVar, x01 x01Var) {
        aVar.a(this);
    }

    private v o(v vVar) {
        if (vVar == null) {
            return null;
        }
        this.b++;
        d0 d0Var = new d0(vVar);
        d0Var.n(this.g);
        return d0Var;
    }

    @Override // defpackage.x01
    public Surface a() {
        Surface surfaceA;
        synchronized (this.a) {
            surfaceA = this.d.a();
        }
        return surfaceA;
    }

    @Override // defpackage.x01
    public v c() {
        v vVarO;
        synchronized (this.a) {
            vVarO = o(this.d.c());
        }
        return vVarO;
    }

    @Override // defpackage.x01
    public void close() {
        synchronized (this.a) {
            try {
                Surface surface = this.e;
                if (surface != null) {
                    surface.release();
                }
                this.d.close();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.x01
    public int d() {
        int iD;
        synchronized (this.a) {
            iD = this.d.d();
        }
        return iD;
    }

    @Override // defpackage.x01
    public void e() {
        synchronized (this.a) {
            this.d.e();
        }
    }

    @Override // defpackage.x01
    public void f(final x01.a aVar, Executor executor) {
        synchronized (this.a) {
            this.d.f(new x01.a() { // from class: jj2
                @Override // x01.a
                public final void a(x01 x01Var) {
                    this.a.l(aVar, x01Var);
                }
            }, executor);
        }
    }

    @Override // defpackage.x01
    public int g() {
        int iG;
        synchronized (this.a) {
            iG = this.d.g();
        }
        return iG;
    }

    @Override // defpackage.x01
    public int getHeight() {
        int height;
        synchronized (this.a) {
            height = this.d.getHeight();
        }
        return height;
    }

    @Override // defpackage.x01
    public int getWidth() {
        int width;
        synchronized (this.a) {
            width = this.d.getWidth();
        }
        return width;
    }

    @Override // defpackage.x01
    public v h() {
        v vVarO;
        synchronized (this.a) {
            vVarO = o(this.d.h());
        }
        return vVarO;
    }

    public int j() {
        int iG;
        synchronized (this.a) {
            iG = this.d.g() - this.b;
        }
        return iG;
    }

    public void m() {
        synchronized (this.a) {
            try {
                this.c = true;
                this.d.e();
                if (this.b == 0) {
                    close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void n(l.a aVar) {
        synchronized (this.a) {
            this.f = aVar;
        }
    }
}
