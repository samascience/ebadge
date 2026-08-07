package androidx.constraintlayout.core;

import com.tencent.connect.common.Constants;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class g extends androidx.constraintlayout.core.b {
    private int g;
    private SolverVariable[] h;
    private SolverVariable[] i;
    private int j;
    b k;
    c l;

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return solverVariable.c - solverVariable2.c;
        }
    }

    class b {
        SolverVariable a;
        g b;

        public b(g gVar) {
            this.b = gVar;
        }

        public boolean a(SolverVariable solverVariable, float f) {
            boolean z = true;
            if (!this.a.a) {
                for (int i = 0; i < 9; i++) {
                    float f2 = solverVariable.i[i];
                    if (f2 != 0.0f) {
                        float f3 = f2 * f;
                        if (Math.abs(f3) < 1.0E-4f) {
                            f3 = 0.0f;
                        }
                        this.a.i[i] = f3;
                    } else {
                        this.a.i[i] = 0.0f;
                    }
                }
                return true;
            }
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.a.i;
                float f4 = fArr[i2] + (solverVariable.i[i2] * f);
                fArr[i2] = f4;
                if (Math.abs(f4) < 1.0E-4f) {
                    this.a.i[i2] = 0.0f;
                } else {
                    z = false;
                }
            }
            if (z) {
                g.this.G(this.a);
            }
            return false;
        }

        public void b(SolverVariable solverVariable) {
            this.a = solverVariable;
        }

        public final boolean c() {
            for (int i = 8; i >= 0; i--) {
                float f = this.a.i[i];
                if (f > 0.0f) {
                    return false;
                }
                if (f < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(SolverVariable solverVariable) {
            for (int i = 8; i >= 0; i--) {
                float f = solverVariable.i[i];
                float f2 = this.a.i[i];
                if (f2 != f) {
                    if (f2 < f) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.a.i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.a != null) {
                for (int i = 0; i < 9; i++) {
                    str = str + this.a.i[i] + " ";
                }
            }
            return str + "] " + this.a;
        }
    }

    public g(c cVar) {
        super(cVar);
        this.g = 128;
        this.h = new SolverVariable[128];
        this.i = new SolverVariable[128];
        this.j = 0;
        this.k = new b(this);
        this.l = cVar;
    }

    private final void F(SolverVariable solverVariable) {
        int i;
        int i2 = this.j + 1;
        SolverVariable[] solverVariableArr = this.h;
        if (i2 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.h = solverVariableArr2;
            this.i = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.h;
        int i3 = this.j;
        solverVariableArr3[i3] = solverVariable;
        int i4 = i3 + 1;
        this.j = i4;
        if (i4 > 1 && solverVariableArr3[i3].c > solverVariable.c) {
            int i5 = 0;
            while (true) {
                i = this.j;
                if (i5 >= i) {
                    break;
                }
                this.i[i5] = this.h[i5];
                i5++;
            }
            Arrays.sort(this.i, 0, i, new a());
            for (int i6 = 0; i6 < this.j; i6++) {
                this.h[i6] = this.i[i6];
            }
        }
        solverVariable.a = true;
        solverVariable.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(SolverVariable solverVariable) {
        int i = 0;
        while (i < this.j) {
            if (this.h[i] == solverVariable) {
                while (true) {
                    int i2 = this.j;
                    if (i >= i2 - 1) {
                        this.j = i2 - 1;
                        solverVariable.a = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.h;
                        int i3 = i + 1;
                        solverVariableArr[i] = solverVariableArr[i3];
                        i = i3;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b
    public void B(d dVar, androidx.constraintlayout.core.b bVar, boolean z) {
        SolverVariable solverVariable = bVar.a;
        if (solverVariable == null) {
            return;
        }
        androidx.constraintlayout.core.b.a aVar = bVar.e;
        int iA = aVar.a();
        for (int i = 0; i < iA; i++) {
            SolverVariable solverVariableE = aVar.e(i);
            float fH = aVar.h(i);
            this.k.b(solverVariableE);
            if (this.k.a(solverVariable, fH)) {
                F(solverVariableE);
            }
            this.b += bVar.b * fH;
        }
        G(solverVariable);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public SolverVariable b(d dVar, boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.j; i2++) {
            SolverVariable solverVariable = this.h[i2];
            if (!zArr[solverVariable.c]) {
                this.k.b(solverVariable);
                if (i == -1) {
                    if (this.k.c()) {
                        i = i2;
                    }
                } else if (this.k.d(this.h[i])) {
                    i = i2;
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.h[i];
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public void c(SolverVariable solverVariable) {
        this.k.b(solverVariable);
        this.k.e();
        solverVariable.i[solverVariable.e] = 1.0f;
        F(solverVariable);
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public void clear() {
        this.j = 0;
        this.b = 0.0f;
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public boolean isEmpty() {
        return this.j == 0;
    }

    @Override // androidx.constraintlayout.core.b
    public String toString() {
        String str = Constants.STR_EMPTY + " goal -> (" + this.b + ") : ";
        for (int i = 0; i < this.j; i++) {
            this.k.b(this.h[i]);
            str = str + this.k + " ";
        }
        return str;
    }
}
