package defpackage;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class q53 extends f53 {
    int T;
    ArrayList R = new ArrayList();
    private boolean S = true;
    boolean U = false;
    private int V = 0;

    class a extends n53 {
        final /* synthetic */ f53 a;

        a(f53 f53Var) {
            this.a = f53Var;
        }

        @Override // f53.f
        public void c(f53 f53Var) {
            this.a.W();
            f53Var.S(this);
        }
    }

    static class b extends n53 {
        q53 a;

        b(q53 q53Var) {
            this.a = q53Var;
        }

        @Override // defpackage.n53, f53.f
        public void a(f53 f53Var) {
            q53 q53Var = this.a;
            if (q53Var.U) {
                return;
            }
            q53Var.d0();
            this.a.U = true;
        }

        @Override // f53.f
        public void c(f53 f53Var) {
            q53 q53Var = this.a;
            int i = q53Var.T - 1;
            q53Var.T = i;
            if (i == 0) {
                q53Var.U = false;
                q53Var.p();
            }
            f53Var.S(this);
        }
    }

    private void i0(f53 f53Var) {
        this.R.add(f53Var);
        f53Var.r = this;
    }

    private void r0() {
        b bVar = new b(this);
        Iterator it = this.R.iterator();
        while (it.hasNext()) {
            ((f53) it.next()).a(bVar);
        }
        this.T = this.R.size();
    }

    @Override // defpackage.f53
    public void Q(View view) {
        super.Q(view);
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            ((f53) this.R.get(i)).Q(view);
        }
    }

    @Override // defpackage.f53
    public void U(View view) {
        super.U(view);
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            ((f53) this.R.get(i)).U(view);
        }
    }

    @Override // defpackage.f53
    protected void W() {
        if (this.R.isEmpty()) {
            d0();
            p();
            return;
        }
        r0();
        if (this.S) {
            Iterator it = this.R.iterator();
            while (it.hasNext()) {
                ((f53) it.next()).W();
            }
            return;
        }
        for (int i = 1; i < this.R.size(); i++) {
            ((f53) this.R.get(i - 1)).a(new a((f53) this.R.get(i)));
        }
        f53 f53Var = (f53) this.R.get(0);
        if (f53Var != null) {
            f53Var.W();
        }
    }

    @Override // defpackage.f53
    public void Y(f53.e eVar) {
        super.Y(eVar);
        this.V |= 8;
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            ((f53) this.R.get(i)).Y(eVar);
        }
    }

    @Override // defpackage.f53
    public void a0(nz1 nz1Var) {
        super.a0(nz1Var);
        this.V |= 4;
        if (this.R != null) {
            for (int i = 0; i < this.R.size(); i++) {
                ((f53) this.R.get(i)).a0(nz1Var);
            }
        }
    }

    @Override // defpackage.f53
    public void b0(p53 p53Var) {
        super.b0(p53Var);
        this.V |= 2;
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            ((f53) this.R.get(i)).b0(p53Var);
        }
    }

    @Override // defpackage.f53
    protected void cancel() {
        super.cancel();
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            ((f53) this.R.get(i)).cancel();
        }
    }

    @Override // defpackage.f53
    String e0(String str) {
        String strE0 = super.e0(str);
        for (int i = 0; i < this.R.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strE0);
            sb.append("\n");
            sb.append(((f53) this.R.get(i)).e0(str + "  "));
            strE0 = sb.toString();
        }
        return strE0;
    }

    @Override // defpackage.f53
    public void f(s53 s53Var) {
        if (H(s53Var.b)) {
            for (f53 f53Var : this.R) {
                if (f53Var.H(s53Var.b)) {
                    f53Var.f(s53Var);
                    s53Var.c.add(f53Var);
                }
            }
        }
    }

    @Override // defpackage.f53
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public q53 a(f53.f fVar) {
        return (q53) super.a(fVar);
    }

    @Override // defpackage.f53
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public q53 b(View view) {
        for (int i = 0; i < this.R.size(); i++) {
            ((f53) this.R.get(i)).b(view);
        }
        return (q53) super.b(view);
    }

    @Override // defpackage.f53
    void h(s53 s53Var) {
        super.h(s53Var);
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            ((f53) this.R.get(i)).h(s53Var);
        }
    }

    public q53 h0(f53 f53Var) {
        i0(f53Var);
        long j = this.c;
        if (j >= 0) {
            f53Var.X(j);
        }
        if ((this.V & 1) != 0) {
            f53Var.Z(s());
        }
        if ((this.V & 2) != 0) {
            w();
            f53Var.b0(null);
        }
        if ((this.V & 4) != 0) {
            f53Var.a0(v());
        }
        if ((this.V & 8) != 0) {
            f53Var.Y(r());
        }
        return this;
    }

    @Override // defpackage.f53
    public void i(s53 s53Var) {
        if (H(s53Var.b)) {
            for (f53 f53Var : this.R) {
                if (f53Var.H(s53Var.b)) {
                    f53Var.i(s53Var);
                    s53Var.c.add(f53Var);
                }
            }
        }
    }

    public f53 j0(int i) {
        if (i < 0 || i >= this.R.size()) {
            return null;
        }
        return (f53) this.R.get(i);
    }

    public int k0() {
        return this.R.size();
    }

    @Override // defpackage.f53
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public f53 clone() {
        q53 q53Var = (q53) super.clone();
        q53Var.R = new ArrayList();
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            q53Var.i0(((f53) this.R.get(i)).clone());
        }
        return q53Var;
    }

    @Override // defpackage.f53
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public q53 S(f53.f fVar) {
        return (q53) super.S(fVar);
    }

    @Override // defpackage.f53
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public q53 T(View view) {
        for (int i = 0; i < this.R.size(); i++) {
            ((f53) this.R.get(i)).T(view);
        }
        return (q53) super.T(view);
    }

    @Override // defpackage.f53
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public q53 X(long j) {
        ArrayList arrayList;
        super.X(j);
        if (this.c >= 0 && (arrayList = this.R) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((f53) this.R.get(i)).X(j);
            }
        }
        return this;
    }

    @Override // defpackage.f53
    void o(ViewGroup viewGroup, t53 t53Var, t53 t53Var2, ArrayList arrayList, ArrayList arrayList2) {
        long jZ = z();
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            f53 f53Var = (f53) this.R.get(i);
            if (jZ > 0 && (this.S || i == 0)) {
                long jZ2 = f53Var.z();
                if (jZ2 > 0) {
                    f53Var.c0(jZ2 + jZ);
                } else {
                    f53Var.c0(jZ);
                }
            }
            f53Var.o(viewGroup, t53Var, t53Var2, arrayList, arrayList2);
        }
    }

    @Override // defpackage.f53
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public q53 Z(TimeInterpolator timeInterpolator) {
        this.V |= 1;
        ArrayList arrayList = this.R;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((f53) this.R.get(i)).Z(timeInterpolator);
            }
        }
        return (q53) super.Z(timeInterpolator);
    }

    public q53 p0(int i) {
        if (i == 0) {
            this.S = true;
        } else {
            if (i != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
            }
            this.S = false;
        }
        return this;
    }

    @Override // defpackage.f53
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public q53 c0(long j) {
        return (q53) super.c0(j);
    }
}
