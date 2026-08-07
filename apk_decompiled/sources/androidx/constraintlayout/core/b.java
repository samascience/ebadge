package androidx.constraintlayout.core;

import com.tencent.connect.common.Constants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.a {
    public a e;
    SolverVariable a = null;
    float b = 0.0f;
    boolean c = false;
    ArrayList d = new ArrayList();
    boolean f = false;

    public interface a {
        int a();

        boolean b(SolverVariable solverVariable);

        float c(b bVar, boolean z);

        void clear();

        void d(SolverVariable solverVariable, float f);

        SolverVariable e(int i);

        void f(SolverVariable solverVariable, float f, boolean z);

        void g();

        float h(int i);

        float i(SolverVariable solverVariable, boolean z);

        float j(SolverVariable solverVariable);

        void k(float f);
    }

    public b() {
    }

    private boolean u(SolverVariable solverVariable, d dVar) {
        return solverVariable.m <= 1;
    }

    private SolverVariable w(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int iA = this.e.a();
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        for (int i = 0; i < iA; i++) {
            float fH = this.e.h(i);
            if (fH < 0.0f) {
                SolverVariable solverVariableE = this.e.e(i);
                if ((zArr == null || !zArr[solverVariableE.c]) && solverVariableE != solverVariable && (((type = solverVariableE.j) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && fH < f)) {
                    f = fH;
                    solverVariable2 = solverVariableE;
                }
            }
        }
        return solverVariable2;
    }

    public void A(d dVar, SolverVariable solverVariable, boolean z) {
        if (solverVariable == null || !solverVariable.g) {
            return;
        }
        this.b += solverVariable.f * this.e.j(solverVariable);
        this.e.i(solverVariable, z);
        if (z) {
            solverVariable.d(this);
        }
        if (d.t && this.e.a() == 0) {
            this.f = true;
            dVar.a = true;
        }
    }

    public void B(d dVar, b bVar, boolean z) {
        this.b += bVar.b * this.e.c(bVar, z);
        if (z) {
            bVar.a.d(this);
        }
        if (d.t && this.a != null && this.e.a() == 0) {
            this.f = true;
            dVar.a = true;
        }
    }

    public void C(d dVar, SolverVariable solverVariable, boolean z) {
        if (solverVariable == null || !solverVariable.n) {
            return;
        }
        float fJ = this.e.j(solverVariable);
        this.b += solverVariable.p * fJ;
        this.e.i(solverVariable, z);
        if (z) {
            solverVariable.d(this);
        }
        this.e.f(dVar.n.d[solverVariable.o], fJ, z);
        if (d.t && this.e.a() == 0) {
            this.f = true;
            dVar.a = true;
        }
    }

    public void D(d dVar) {
        if (dVar.g.length == 0) {
            return;
        }
        boolean z = false;
        while (!z) {
            int iA = this.e.a();
            for (int i = 0; i < iA; i++) {
                SolverVariable solverVariableE = this.e.e(i);
                if (solverVariableE.d != -1 || solverVariableE.g || solverVariableE.n) {
                    this.d.add(solverVariableE);
                }
            }
            int size = this.d.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    SolverVariable solverVariable = (SolverVariable) this.d.get(i2);
                    if (solverVariable.g) {
                        A(dVar, solverVariable, true);
                    } else if (solverVariable.n) {
                        C(dVar, solverVariable, true);
                    } else {
                        B(dVar, dVar.g[solverVariable.d], true);
                    }
                }
                this.d.clear();
            } else {
                z = true;
            }
        }
        if (d.t && this.a != null && this.e.a() == 0) {
            this.f = true;
            dVar.a = true;
        }
    }

    @Override // androidx.constraintlayout.core.d.a
    public void a(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.a = null;
            this.e.clear();
            for (int i = 0; i < bVar.e.a(); i++) {
                this.e.f(bVar.e.e(i), bVar.e.h(i), true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.d.a
    public SolverVariable b(d dVar, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // androidx.constraintlayout.core.d.a
    public void c(SolverVariable solverVariable) {
        int i = solverVariable.e;
        float f = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
        }
        this.e.d(solverVariable, f);
    }

    @Override // androidx.constraintlayout.core.d.a
    public void clear() {
        this.e.clear();
        this.a = null;
        this.b = 0.0f;
    }

    public b d(d dVar, int i) {
        this.e.d(dVar.o(i, "ep"), 1.0f);
        this.e.d(dVar.o(i, "em"), -1.0f);
        return this;
    }

    b e(SolverVariable solverVariable, int i) {
        this.e.d(solverVariable, i);
        return this;
    }

    boolean f(d dVar) {
        boolean z;
        SolverVariable solverVariableG = g(dVar);
        if (solverVariableG == null) {
            z = true;
        } else {
            x(solverVariableG);
            z = false;
        }
        if (this.e.a() == 0) {
            this.f = true;
        }
        return z;
    }

    SolverVariable g(d dVar) {
        int iA = this.e.a();
        SolverVariable solverVariable = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        SolverVariable solverVariable2 = null;
        for (int i = 0; i < iA; i++) {
            float fH = this.e.h(i);
            SolverVariable solverVariableE = this.e.e(i);
            if (solverVariableE.j == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null || f > fH) {
                    boolean zU = u(solverVariableE, dVar);
                    z = zU;
                    f = fH;
                    solverVariable = solverVariableE;
                } else if (!z && u(solverVariableE, dVar)) {
                    f = fH;
                    solverVariable = solverVariableE;
                    z = true;
                }
            } else if (solverVariable == null && fH < 0.0f) {
                if (solverVariable2 == null || f2 > fH) {
                    boolean zU2 = u(solverVariableE, dVar);
                    z2 = zU2;
                    f2 = fH;
                    solverVariable2 = solverVariableE;
                } else if (!z2 && u(solverVariableE, dVar)) {
                    f2 = fH;
                    solverVariable2 = solverVariableE;
                    z2 = true;
                }
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    @Override // androidx.constraintlayout.core.d.a
    public SolverVariable getKey() {
        return this.a;
    }

    b h(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        if (solverVariable2 == solverVariable3) {
            this.e.d(solverVariable, 1.0f);
            this.e.d(solverVariable4, 1.0f);
            this.e.d(solverVariable2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.e.d(solverVariable, 1.0f);
            this.e.d(solverVariable2, -1.0f);
            this.e.d(solverVariable3, -1.0f);
            this.e.d(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.b = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            this.e.d(solverVariable, -1.0f);
            this.e.d(solverVariable2, 1.0f);
            this.b = i;
        } else if (f >= 1.0f) {
            this.e.d(solverVariable4, -1.0f);
            this.e.d(solverVariable3, 1.0f);
            this.b = -i2;
        } else {
            float f2 = 1.0f - f;
            this.e.d(solverVariable, f2 * 1.0f);
            this.e.d(solverVariable2, f2 * (-1.0f));
            this.e.d(solverVariable3, (-1.0f) * f);
            this.e.d(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.b = ((-i) * f2) + (i2 * f);
            }
        }
        return this;
    }

    b i(SolverVariable solverVariable, int i) {
        this.a = solverVariable;
        float f = i;
        solverVariable.f = f;
        this.b = f;
        this.f = true;
        return this;
    }

    @Override // androidx.constraintlayout.core.d.a
    public boolean isEmpty() {
        return this.a == null && this.b == 0.0f && this.e.a() == 0;
    }

    b j(SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        this.e.d(solverVariable, -1.0f);
        this.e.d(solverVariable2, f);
        return this;
    }

    public b k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.e.d(solverVariable, -1.0f);
        this.e.d(solverVariable2, 1.0f);
        this.e.d(solverVariable3, f);
        this.e.d(solverVariable4, -f);
        return this;
    }

    public b l(float f, float f2, float f3, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.b = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.e.d(solverVariable, 1.0f);
            this.e.d(solverVariable2, -1.0f);
            this.e.d(solverVariable4, 1.0f);
            this.e.d(solverVariable3, -1.0f);
        } else if (f == 0.0f) {
            this.e.d(solverVariable, 1.0f);
            this.e.d(solverVariable2, -1.0f);
        } else if (f3 == 0.0f) {
            this.e.d(solverVariable3, 1.0f);
            this.e.d(solverVariable4, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.e.d(solverVariable, 1.0f);
            this.e.d(solverVariable2, -1.0f);
            this.e.d(solverVariable4, f4);
            this.e.d(solverVariable3, -f4);
        }
        return this;
    }

    public b m(SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.b = i * (-1);
            this.e.d(solverVariable, 1.0f);
        } else {
            this.b = i;
            this.e.d(solverVariable, -1.0f);
        }
        return this;
    }

    public b n(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.e.d(solverVariable, 1.0f);
            this.e.d(solverVariable2, -1.0f);
        } else {
            this.e.d(solverVariable, -1.0f);
            this.e.d(solverVariable2, 1.0f);
        }
        return this;
    }

    public b o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.e.d(solverVariable, 1.0f);
            this.e.d(solverVariable2, -1.0f);
            this.e.d(solverVariable3, -1.0f);
        } else {
            this.e.d(solverVariable, -1.0f);
            this.e.d(solverVariable2, 1.0f);
            this.e.d(solverVariable3, 1.0f);
        }
        return this;
    }

    public b p(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.e.d(solverVariable, 1.0f);
            this.e.d(solverVariable2, -1.0f);
            this.e.d(solverVariable3, 1.0f);
        } else {
            this.e.d(solverVariable, -1.0f);
            this.e.d(solverVariable2, 1.0f);
            this.e.d(solverVariable3, -1.0f);
        }
        return this;
    }

    public b q(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.e.d(solverVariable3, 0.5f);
        this.e.d(solverVariable4, 0.5f);
        this.e.d(solverVariable, -0.5f);
        this.e.d(solverVariable2, -0.5f);
        this.b = -f;
        return this;
    }

    void r() {
        float f = this.b;
        if (f < 0.0f) {
            this.b = f * (-1.0f);
            this.e.g();
        }
    }

    boolean s() {
        SolverVariable solverVariable = this.a;
        return solverVariable != null && (solverVariable.j == SolverVariable.Type.UNRESTRICTED || this.b >= 0.0f);
    }

    boolean t(SolverVariable solverVariable) {
        return this.e.b(solverVariable);
    }

    public String toString() {
        return z();
    }

    public SolverVariable v(SolverVariable solverVariable) {
        return w(null, solverVariable);
    }

    void x(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.a;
        if (solverVariable2 != null) {
            this.e.d(solverVariable2, -1.0f);
            this.a.d = -1;
            this.a = null;
        }
        float fI = this.e.i(solverVariable, true) * (-1.0f);
        this.a = solverVariable;
        if (fI == 1.0f) {
            return;
        }
        this.b /= fI;
        this.e.k(fI);
    }

    public void y() {
        this.a = null;
        this.e.clear();
        this.b = 0.0f;
        this.f = false;
    }

    String z() {
        boolean z;
        String str = (this.a == null ? Constants.STR_EMPTY + "0" : Constants.STR_EMPTY + this.a) + " = ";
        if (this.b != 0.0f) {
            str = str + this.b;
            z = true;
        } else {
            z = false;
        }
        int iA = this.e.a();
        for (int i = 0; i < iA; i++) {
            SolverVariable solverVariableE = this.e.e(i);
            if (solverVariableE != null) {
                float fH = this.e.h(i);
                if (fH != 0.0f) {
                    String string = solverVariableE.toString();
                    if (z) {
                        if (fH > 0.0f) {
                            str = str + " + ";
                        } else {
                            str = str + " - ";
                            fH *= -1.0f;
                        }
                    } else if (fH < 0.0f) {
                        str = str + "- ";
                        fH *= -1.0f;
                    }
                    str = fH == 1.0f ? str + string : str + fH + " " + string;
                    z = true;
                }
            }
        }
        if (z) {
            return str;
        }
        return str + "0.0";
    }

    public b(c cVar) {
        this.e = new androidx.constraintlayout.core.a(this, cVar);
    }
}
