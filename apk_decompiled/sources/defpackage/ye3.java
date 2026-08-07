package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ye3 {
    private Interpolator c;
    ze3 d;
    private boolean e;
    private long b = -1;
    private final af3 f = new a();
    final ArrayList a = new ArrayList();

    class a extends af3 {
        private boolean a = false;
        private int b = 0;

        a() {
        }

        @Override // defpackage.ze3
        public void b(View view) {
            int i = this.b + 1;
            this.b = i;
            if (i == ye3.this.a.size()) {
                ze3 ze3Var = ye3.this.d;
                if (ze3Var != null) {
                    ze3Var.b(null);
                }
                d();
            }
        }

        @Override // defpackage.af3, defpackage.ze3
        public void c(View view) {
            if (this.a) {
                return;
            }
            this.a = true;
            ze3 ze3Var = ye3.this.d;
            if (ze3Var != null) {
                ze3Var.c(null);
            }
        }

        void d() {
            this.b = 0;
            this.a = false;
            ye3.this.b();
        }
    }

    public void a() {
        if (this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((xe3) it.next()).c();
            }
            this.e = false;
        }
    }

    void b() {
        this.e = false;
    }

    public ye3 c(xe3 xe3Var) {
        if (!this.e) {
            this.a.add(xe3Var);
        }
        return this;
    }

    public ye3 d(xe3 xe3Var, xe3 xe3Var2) {
        this.a.add(xe3Var);
        xe3Var2.j(xe3Var.d());
        this.a.add(xe3Var2);
        return this;
    }

    public ye3 e(long j) {
        if (!this.e) {
            this.b = j;
        }
        return this;
    }

    public ye3 f(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public ye3 g(ze3 ze3Var) {
        if (!this.e) {
            this.d = ze3Var;
        }
        return this;
    }

    public void h() {
        if (this.e) {
            return;
        }
        for (xe3 xe3Var : this.a) {
            long j = this.b;
            if (j >= 0) {
                xe3Var.f(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null) {
                xe3Var.g(interpolator);
            }
            if (this.d != null) {
                xe3Var.h(this.f);
            }
            xe3Var.l();
        }
        this.e = true;
    }
}
