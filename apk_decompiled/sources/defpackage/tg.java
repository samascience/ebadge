package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class tg {
    private final List c;
    protected re1 e;
    private k91 f;
    final List a = new ArrayList();
    private boolean b = false;
    private float d = 0.0f;

    public interface a {
        void a();
    }

    tg(List list) {
        this.c = list;
    }

    private k91 b() {
        k91 k91Var = this.f;
        if (k91Var != null && k91Var.a(this.d)) {
            return this.f;
        }
        List list = this.c;
        k91 k91Var2 = (k91) list.get(list.size() - 1);
        if (this.d < k91Var2.c()) {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                k91Var2 = (k91) this.c.get(size);
                if (k91Var2.a(this.d)) {
                    break;
                }
            }
        }
        this.f = k91Var2;
        return k91Var2;
    }

    private float d() {
        k91 k91VarB = b();
        if (k91VarB.d()) {
            return 0.0f;
        }
        return k91VarB.d.getInterpolation(e());
    }

    private float g() {
        if (this.c.isEmpty()) {
            return 0.0f;
        }
        return ((k91) this.c.get(0)).c();
    }

    public void a(a aVar) {
        this.a.add(aVar);
    }

    float c() {
        if (this.c.isEmpty()) {
            return 1.0f;
        }
        List list = this.c;
        return ((k91) list.get(list.size() - 1)).b();
    }

    float e() {
        if (this.b) {
            return 0.0f;
        }
        k91 k91VarB = b();
        if (k91VarB.d()) {
            return 0.0f;
        }
        return (this.d - k91VarB.c()) / (k91VarB.b() - k91VarB.c());
    }

    public float f() {
        return this.d;
    }

    public Object h() {
        return i(b(), d());
    }

    abstract Object i(k91 k91Var, float f);

    public void j() {
        for (int i = 0; i < this.a.size(); i++) {
            ((a) this.a.get(i)).a();
        }
    }

    public void k() {
        this.b = true;
    }

    public void l(float f) {
        if (f < g()) {
            f = g();
        } else if (f > c()) {
            f = c();
        }
        if (f == this.d) {
            return;
        }
        this.d = f;
        j();
    }

    public void m(re1 re1Var) {
        re1 re1Var2 = this.e;
        if (re1Var2 != null) {
            re1Var2.c(null);
        }
        this.e = re1Var;
        if (re1Var != null) {
            re1Var.c(this);
        }
    }
}
