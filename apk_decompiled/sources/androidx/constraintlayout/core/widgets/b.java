package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    /* JADX WARN: Code duplicated, block: B:100:0x016d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0173  */
    /* JADX WARN: Code duplicated, block: B:104:0x0194  */
    /* JADX WARN: Code duplicated, block: B:16:0x0033 A[PHI: r8 r16
      0x0033: PHI (r8v39 boolean) = (r8v1 boolean), (r8v41 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0033: PHI (r16v6 boolean) = (r16v1 boolean), (r16v8 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:17:0x0035 A[PHI: r8 r16
      0x0035: PHI (r8v3 boolean) = (r8v1 boolean), (r8v41 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r16v3 boolean) = (r16v1 boolean), (r16v8 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:202:0x034e  */
    /* JADX WARN: Code duplicated, block: B:222:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:323:0x03a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x016a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [androidx.constraintlayout.core.d] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28, types: [androidx.constraintlayout.core.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    static void a(d dVar, androidx.constraintlayout.core.d dVar2, int i, int i2, c cVar) {
        boolean z;
        boolean z2;
        boolean z3;
        Object obj;
        int i3;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable3;
        ?? r5;
        SolverVariable solverVariable4;
        int size;
        ConstraintAnchor constraintAnchor3;
        int i4;
        int i5 = i;
        ConstraintWidget constraintWidget = cVar.a;
        ConstraintWidget constraintWidget2 = cVar.c;
        ConstraintWidget constraintWidget3 = cVar.b;
        ConstraintWidget constraintWidget4 = cVar.d;
        ConstraintWidget constraintWidget5 = cVar.e;
        float f = cVar.k;
        boolean z4 = dVar.b0[i5] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i5 == 0) {
            int i6 = constraintWidget5.J0;
            z = i6 == 0;
            z2 = i6 == 1;
            if (i6 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            int i7 = constraintWidget5.K0;
            z = i7 == 0;
            z2 = i7 == 1;
            if (i7 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        boolean z5 = z2;
        boolean z6 = false;
        boolean z7 = z;
        ?? r8 = constraintWidget;
        while (true) {
            obj = null;
            if (z6) {
                break;
            }
            ConstraintAnchor constraintAnchor4 = r8.Y[i2];
            int i8 = z3 ? 1 : 4;
            int iF = constraintAnchor4.f();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = r8.b0[i5];
            float f2 = f;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z8 = dimensionBehaviour == dimensionBehaviour2 && r8.y[i5] == 0;
            ConstraintAnchor constraintAnchor5 = constraintAnchor4.f;
            if (constraintAnchor5 != null && r8 != constraintWidget) {
                iF += constraintAnchor5.f();
            }
            int i9 = iF;
            if (z3 && r8 != constraintWidget && r8 != constraintWidget3) {
                i8 = 8;
            }
            ConstraintAnchor constraintAnchor6 = constraintAnchor4.f;
            if (constraintAnchor6 != null) {
                if (r8 == constraintWidget3) {
                    dVar2.h(constraintAnchor4.i, constraintAnchor6.i, i9, 6);
                } else {
                    dVar2.h(constraintAnchor4.i, constraintAnchor6.i, i9, 8);
                }
                if (z8 && !z3) {
                    i8 = 5;
                }
                dVar2.e(constraintAnchor4.i, constraintAnchor4.f.i, i9, (r8 == constraintWidget3 && z3 && r8.j0(i5)) ? 5 : i8);
            } else {
                constraintWidget = constraintWidget;
            }
            if (z4) {
                if (r8.X() == 8 || r8.b0[i5] != dimensionBehaviour2) {
                    i4 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = r8.Y;
                    i4 = 0;
                    dVar2.h(constraintAnchorArr[i2 + 1].i, constraintAnchorArr[i2].i, 0, 5);
                }
                dVar2.h(r8.Y[i2].i, dVar.Y[i2].i, i4, 8);
            }
            ConstraintAnchor constraintAnchor7 = r8.Y[i2 + 1].f;
            if (constraintAnchor7 != null) {
                ConstraintWidget constraintWidget6 = constraintAnchor7.d;
                ConstraintAnchor constraintAnchor8 = constraintWidget6.Y[i2].f;
                if (constraintAnchor8 != null && constraintAnchor8.d == r8) {
                    obj = constraintWidget6;
                }
            }
            if (obj != null) {
                r8 = obj;
                z6 = z6;
            } else {
                z6 = true;
            }
            constraintWidget5 = constraintWidget5;
            f = f2;
            constraintWidget = constraintWidget;
            r8 = r8;
        }
        ConstraintWidget constraintWidget7 = constraintWidget5;
        float f3 = f;
        ConstraintWidget constraintWidget8 = constraintWidget;
        if (constraintWidget4 != null) {
            int i10 = i2 + 1;
            if (constraintWidget2.Y[i10].f != null) {
                ConstraintAnchor constraintAnchor9 = constraintWidget4.Y[i10];
                if (constraintWidget4.b0[i5] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget4.y[i5] == 0 && !z3) {
                    ConstraintAnchor constraintAnchor10 = constraintAnchor9.f;
                    if (constraintAnchor10.d == dVar) {
                        dVar2.e(constraintAnchor9.i, constraintAnchor10.i, -constraintAnchor9.f(), 5);
                    } else if (z3) {
                        constraintAnchor3 = constraintAnchor9.f;
                        if (constraintAnchor3.d == dVar) {
                            dVar2.e(constraintAnchor9.i, constraintAnchor3.i, -constraintAnchor9.f(), 4);
                        }
                    }
                } else if (z3) {
                    constraintAnchor3 = constraintAnchor9.f;
                    if (constraintAnchor3.d == dVar) {
                        dVar2.e(constraintAnchor9.i, constraintAnchor3.i, -constraintAnchor9.f(), 4);
                    }
                }
                dVar2.j(constraintAnchor9.i, constraintWidget2.Y[i10].f.i, -constraintAnchor9.f(), 6);
            }
        }
        if (z4) {
            int i11 = i2 + 1;
            SolverVariable solverVariable5 = dVar.Y[i11].i;
            ConstraintAnchor constraintAnchor11 = constraintWidget2.Y[i11];
            dVar2.h(solverVariable5, constraintAnchor11.i, constraintAnchor11.f(), 8);
        }
        ArrayList arrayList = cVar.h;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            float f4 = (!cVar.r || cVar.t) ? f3 : cVar.j;
            float f5 = 0.0f;
            float f6 = 0.0f;
            ConstraintWidget constraintWidget9 = null;
            int i12 = 0;
            while (i12 < size) {
                ConstraintWidget constraintWidget10 = (ConstraintWidget) arrayList.get(i12);
                float f7 = constraintWidget10.N0[i5];
                if (f7 < f5) {
                    if (cVar.t) {
                        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget10.Y;
                        dVar2.e(constraintAnchorArr2[i2 + 1].i, constraintAnchorArr2[i2].i, 0, 4);
                    } else {
                        f7 = 1.0f;
                    }
                    arrayList = arrayList;
                    size = size;
                    i12++;
                    size = size;
                    arrayList = arrayList;
                    f5 = 0.0f;
                }
                if (f7 == 0.0f) {
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget10.Y;
                    dVar2.e(constraintAnchorArr3[i2 + 1].i, constraintAnchorArr3[i2].i, 0, 8);
                    arrayList = arrayList;
                    size = size;
                } else {
                    if (constraintWidget9 != null) {
                        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget9.Y;
                        SolverVariable solverVariable6 = constraintAnchorArr4[i2].i;
                        int i13 = i2 + 1;
                        SolverVariable solverVariable7 = constraintAnchorArr4[i13].i;
                        ConstraintAnchor[] constraintAnchorArr5 = constraintWidget10.Y;
                        SolverVariable solverVariable8 = constraintAnchorArr5[i2].i;
                        SolverVariable solverVariable9 = constraintAnchorArr5[i13].i;
                        androidx.constraintlayout.core.b bVarR = dVar2.r();
                        bVarR.l(f6, f4, f7, solverVariable6, solverVariable7, solverVariable8, solverVariable9);
                        dVar2.d(bVarR);
                    }
                    constraintWidget9 = constraintWidget10;
                    f6 = f7;
                }
                i12++;
                size = size;
                arrayList = arrayList;
                f5 = 0.0f;
            }
        }
        if (constraintWidget3 != null && (constraintWidget3 == constraintWidget4 || z3)) {
            ConstraintAnchor constraintAnchor12 = constraintWidget8.Y[i2];
            int i14 = i2 + 1;
            ConstraintAnchor constraintAnchor13 = constraintWidget2.Y[i14];
            ConstraintAnchor constraintAnchor14 = constraintAnchor12.f;
            SolverVariable solverVariable10 = constraintAnchor14 != null ? constraintAnchor14.i : null;
            ConstraintAnchor constraintAnchor15 = constraintAnchor13.f;
            SolverVariable solverVariable11 = constraintAnchor15 != null ? constraintAnchor15.i : null;
            ConstraintAnchor constraintAnchor16 = constraintWidget3.Y[i2];
            if (constraintWidget4 != null) {
                constraintAnchor13 = constraintWidget4.Y[i14];
            }
            if (solverVariable10 != null && solverVariable11 != null) {
                dVar2.c(constraintAnchor16.i, solverVariable10, constraintAnchor16.f(), i5 == 0 ? constraintWidget7.q0 : constraintWidget7.r0, solverVariable11, constraintAnchor13.i, constraintAnchor13.f(), 7);
            }
        } else if (!z7 || constraintWidget3 == null) {
            int i15 = 8;
            if (z5 && constraintWidget3 != null) {
                int i16 = cVar.j;
                boolean z9 = i16 > 0 && cVar.i == i16;
                ConstraintWidget constraintWidget11 = constraintWidget3;
                ConstraintWidget constraintWidget12 = constraintWidget11;
                while (constraintWidget12 != null) {
                    ConstraintWidget constraintWidget13 = constraintWidget12.P0[i5];
                    while (constraintWidget13 != null && constraintWidget13.X() == i15) {
                        constraintWidget13 = constraintWidget13.P0[i5];
                    }
                    if (constraintWidget12 == constraintWidget3 || constraintWidget12 == constraintWidget4 || constraintWidget13 == null) {
                        constraintWidget11 = constraintWidget11;
                        i3 = i15;
                    } else {
                        ConstraintWidget constraintWidget14 = constraintWidget13 == constraintWidget4 ? null : constraintWidget13;
                        ConstraintAnchor constraintAnchor17 = constraintWidget12.Y[i2];
                        SolverVariable solverVariable12 = constraintAnchor17.i;
                        ConstraintAnchor constraintAnchor18 = constraintAnchor17.f;
                        if (constraintAnchor18 != null) {
                            SolverVariable solverVariable13 = constraintAnchor18.i;
                        }
                        int i17 = i2 + 1;
                        SolverVariable solverVariable14 = constraintWidget11.Y[i17].i;
                        int iF2 = constraintAnchor17.f();
                        int iF3 = constraintWidget12.Y[i17].f();
                        if (constraintWidget14 != null) {
                            constraintAnchor = constraintWidget14.Y[i2];
                            SolverVariable solverVariable15 = constraintAnchor.i;
                            ConstraintAnchor constraintAnchor19 = constraintAnchor.f;
                            solverVariable2 = constraintAnchor19 != null ? constraintAnchor19.i : null;
                            solverVariable = solverVariable15;
                        } else {
                            constraintAnchor = constraintWidget4.Y[i2];
                            solverVariable = constraintAnchor != null ? constraintAnchor.i : null;
                            solverVariable2 = constraintWidget12.Y[i17].i;
                        }
                        if (constraintAnchor != null) {
                            iF3 += constraintAnchor.f();
                        }
                        int i18 = iF3;
                        int iF4 = constraintWidget11.Y[i17].f() + iF2;
                        int i19 = z9 ? 8 : 4;
                        if (solverVariable12 == null || solverVariable14 == null || solverVariable == null || solverVariable2 == null) {
                            i3 = 8;
                        } else {
                            i3 = 8;
                            dVar2.c(solverVariable12, solverVariable14, iF4, 0.5f, solverVariable, solverVariable2, i18, i19);
                        }
                        constraintWidget13 = constraintWidget14;
                    }
                    constraintWidget11 = constraintWidget12.X() != i3 ? constraintWidget12 : constraintWidget11;
                    constraintWidget12 = constraintWidget13;
                    i15 = i3;
                    i5 = i;
                }
                ConstraintAnchor constraintAnchor20 = constraintWidget3.Y[i2];
                ConstraintAnchor constraintAnchor21 = constraintWidget8.Y[i2].f;
                int i20 = i2 + 1;
                ConstraintAnchor constraintAnchor22 = constraintWidget4.Y[i20];
                ConstraintAnchor constraintAnchor23 = constraintWidget2.Y[i20].f;
                if (constraintAnchor21 != null) {
                    if (constraintWidget3 != constraintWidget4) {
                        dVar2.e(constraintAnchor20.i, constraintAnchor21.i, constraintAnchor20.f(), 5);
                    } else if (constraintAnchor23 != null) {
                        dVar2.c(constraintAnchor20.i, constraintAnchor21.i, constraintAnchor20.f(), 0.5f, constraintAnchor22.i, constraintAnchor23.i, constraintAnchor22.f(), 5);
                    }
                }
                if (constraintAnchor23 != null && constraintWidget3 != constraintWidget4) {
                    dVar2.e(constraintAnchor22.i, constraintAnchor23.i, -constraintAnchor22.f(), 5);
                }
            }
        } else {
            int i21 = cVar.j;
            boolean z10 = i21 > 0 && cVar.i == i21;
            ConstraintWidget constraintWidget15 = constraintWidget3;
            ConstraintWidget constraintWidget16 = constraintWidget15;
            while (constraintWidget16 != null) {
                ConstraintWidget constraintWidget17 = constraintWidget16.P0[i5];
                while (constraintWidget17 != null && constraintWidget17.X() == 8) {
                    constraintWidget17 = constraintWidget17.P0[i5];
                }
                if (constraintWidget17 != null || constraintWidget16 == constraintWidget4) {
                    ConstraintAnchor constraintAnchor24 = constraintWidget16.Y[i2];
                    SolverVariable solverVariable16 = constraintAnchor24.i;
                    ConstraintAnchor constraintAnchor25 = constraintAnchor24.f;
                    SolverVariable solverVariable17 = constraintAnchor25 != null ? constraintAnchor25.i : null;
                    if (constraintWidget15 != constraintWidget16) {
                        solverVariable17 = constraintWidget15.Y[i2 + 1].i;
                    } else if (constraintWidget16 == constraintWidget3) {
                        ConstraintAnchor constraintAnchor26 = constraintWidget8.Y[i2].f;
                        solverVariable17 = constraintAnchor26 != null ? constraintAnchor26.i : null;
                    }
                    int iF5 = constraintAnchor24.f();
                    int i22 = i2 + 1;
                    int iF6 = constraintWidget16.Y[i22].f();
                    if (constraintWidget17 != null) {
                        constraintAnchor2 = constraintWidget17.Y[i2];
                        solverVariable3 = constraintAnchor2.i;
                    } else {
                        constraintAnchor2 = constraintWidget2.Y[i22].f;
                        if (constraintAnchor2 != null) {
                            solverVariable3 = constraintAnchor2.i;
                        } else {
                            solverVariable3 = null;
                        }
                        SolverVariable solverVariable18 = constraintWidget16.Y[i22].i;
                        if (constraintAnchor2 != null) {
                            iF6 += constraintAnchor2.f();
                        }
                        int iF7 = iF5 + constraintWidget15.Y[i22].f();
                        if (solverVariable16 == null && solverVariable17 != null && solverVariable3 != null && solverVariable18 != null) {
                            if (constraintWidget16 == constraintWidget3) {
                                iF7 = constraintWidget3.Y[i2].f();
                            }
                            constraintWidget17 = constraintWidget17;
                            dVar2.c(solverVariable16, solverVariable17, iF7, 0.5f, solverVariable3, solverVariable18, constraintWidget16 == constraintWidget4 ? constraintWidget4.Y[i22].f() : iF6, z10 ? 8 : 5);
                        }
                        if (constraintWidget16.X() != 8) {
                            constraintWidget16 = constraintWidget15;
                        }
                        constraintWidget15 = constraintWidget16;
                        constraintWidget16 = constraintWidget17;
                    }
                    SolverVariable solverVariable19 = constraintWidget16.Y[i22].i;
                    if (constraintAnchor2 != null) {
                        iF6 += constraintAnchor2.f();
                    }
                    int iF8 = iF5 + constraintWidget15.Y[i22].f();
                    if (solverVariable16 == null) {
                    }
                }
                if (constraintWidget16.X() != 8) {
                    constraintWidget16 = constraintWidget15;
                }
                constraintWidget15 = constraintWidget16;
                constraintWidget16 = constraintWidget17;
            }
        }
        if ((!z7 && !z5) || constraintWidget3 == null || constraintWidget3 == constraintWidget4) {
            return;
        }
        ConstraintAnchor[] constraintAnchorArr6 = constraintWidget3.Y;
        ConstraintAnchor constraintAnchor27 = constraintAnchorArr6[i2];
        if (constraintWidget4 == null) {
            constraintWidget4 = constraintWidget3;
        }
        int i23 = i2 + 1;
        ConstraintAnchor constraintAnchor28 = constraintWidget4.Y[i23];
        ConstraintAnchor constraintAnchor29 = constraintAnchor27.f;
        SolverVariable solverVariable20 = constraintAnchor29 != null ? constraintAnchor29.i : null;
        ConstraintAnchor constraintAnchor30 = constraintAnchor28.f;
        if (constraintAnchor30 != null) {
            solverVariable4 = constraintAnchor30.i;
        } else {
            r5 = 0;
        }
        if (constraintWidget2 != constraintWidget4) {
            ConstraintAnchor constraintAnchor31 = constraintWidget2.Y[i23].f;
            if (constraintAnchor31 != null) {
                r5 = solverVariable4;
                obj = constraintAnchor31.i;
            }
            r5 = solverVariable4;
            r5 = obj;
        }
        if (constraintWidget3 == constraintWidget4) {
            constraintAnchor28 = constraintAnchorArr6[i23];
        }
        if (solverVariable20 == null || r5 == 0) {
            return;
        }
        dVar2.c(constraintAnchor27.i, solverVariable20, constraintAnchor27.f(), 0.5f, r5, constraintAnchor28.i, constraintWidget4.Y[i23].f(), 5);
    }

    public static void b(d dVar, androidx.constraintlayout.core.d dVar2, ArrayList arrayList, int i) {
        int i2;
        c[] cVarArr;
        int i3;
        if (i == 0) {
            i2 = dVar.g1;
            cVarArr = dVar.j1;
            i3 = 0;
        } else {
            i2 = dVar.h1;
            cVarArr = dVar.i1;
            i3 = 2;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            c cVar = cVarArr[i4];
            cVar.a();
            if (arrayList == null || arrayList.contains(cVar.a)) {
                a(dVar, dVar2, i, i3, cVar);
            }
        }
    }
}
