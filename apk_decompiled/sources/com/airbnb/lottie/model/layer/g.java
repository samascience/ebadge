package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import defpackage.e23;
import defpackage.f6;
import defpackage.fe1;
import defpackage.g6;
import defpackage.ho0;
import defpackage.je1;
import defpackage.ko0;
import defpackage.ne1;
import defpackage.q6;
import defpackage.rc0;
import defpackage.re1;
import defpackage.tg;
import defpackage.u20;
import defpackage.ya3;
import defpackage.zn2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g extends com.airbnb.lottie.model.layer.a {
    private final Paint A;
    private final Map B;
    private final e23 C;
    private final je1 D;
    private final fe1 E;
    private tg F;
    private tg G;
    private tg H;
    private tg I;
    private final char[] w;
    private final RectF x;
    private final Matrix y;
    private final Paint z;

    class a extends Paint {
        a(int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    class b extends Paint {
        b(int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    g(je1 je1Var, Layer layer) {
        g6 g6Var;
        g6 g6Var2;
        f6 f6Var;
        f6 f6Var2;
        super(je1Var, layer);
        this.w = new char[1];
        this.x = new RectF();
        this.y = new Matrix();
        this.z = new a(1);
        this.A = new b(1);
        this.B = new HashMap();
        this.D = je1Var;
        this.E = layer.a();
        e23 e23VarA = layer.q().a();
        this.C = e23VarA;
        e23VarA.a(this);
        i(e23VarA);
        q6 q6VarR = layer.r();
        if (q6VarR != null && (f6Var2 = q6VarR.a) != null) {
            tg tgVarA = f6Var2.a();
            this.F = tgVarA;
            tgVarA.a(this);
            i(this.F);
        }
        if (q6VarR != null && (f6Var = q6VarR.b) != null) {
            tg tgVarA2 = f6Var.a();
            this.G = tgVarA2;
            tgVarA2.a(this);
            i(this.G);
        }
        if (q6VarR != null && (g6Var2 = q6VarR.c) != null) {
            tg tgVarA3 = g6Var2.a();
            this.H = tgVarA3;
            tgVarA3.a(this);
            i(this.H);
        }
        if (q6VarR == null || (g6Var = q6VarR.d) == null) {
            return;
        }
        tg tgVarA4 = g6Var.a();
        this.I = tgVarA4;
        tgVarA4.a(this);
        i(this.I);
    }

    private void D(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
    }

    private void E(ko0 ko0Var, Matrix matrix, float f, rc0 rc0Var, Canvas canvas) {
        List listJ = J(ko0Var);
        for (int i = 0; i < listJ.size(); i++) {
            Path pathC = ((u20) listJ.get(i)).c();
            pathC.computeBounds(this.x, false);
            this.y.set(matrix);
            this.y.preTranslate(0.0f, ((float) (-rc0Var.g)) * ya3.e());
            this.y.preScale(f, f);
            pathC.transform(this.y);
            if (rc0Var.k) {
                G(pathC, this.z, canvas);
                G(pathC, this.A, canvas);
            } else {
                G(pathC, this.A, canvas);
                G(pathC, this.z, canvas);
            }
        }
    }

    private void F(char c, rc0 rc0Var, Canvas canvas) {
        char[] cArr = this.w;
        cArr[0] = c;
        if (rc0Var.k) {
            D(cArr, this.z, canvas);
            D(this.w, this.A, canvas);
        } else {
            D(cArr, this.A, canvas);
            D(this.w, this.z, canvas);
        }
    }

    private void G(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void H(rc0 rc0Var, Matrix matrix, ho0 ho0Var, Canvas canvas) {
        float f = ((float) rc0Var.c) / 100.0f;
        float f2 = ya3.f(matrix);
        String str = rc0Var.a;
        for (int i = 0; i < str.length(); i++) {
            ko0 ko0Var = (ko0) this.E.c().d(ko0.c(str.charAt(i), ho0Var.a(), ho0Var.c()));
            if (ko0Var != null) {
                E(ko0Var, matrix, f, rc0Var, canvas);
                float fB = ((float) ko0Var.b()) * f * ya3.e() * f2;
                float fFloatValue = rc0Var.e / 10.0f;
                tg tgVar = this.I;
                if (tgVar != null) {
                    fFloatValue += ((Float) tgVar.h()).floatValue();
                }
                canvas.translate(fB + (fFloatValue * f2), 0.0f);
            }
        }
    }

    private void I(rc0 rc0Var, ho0 ho0Var, Matrix matrix, Canvas canvas) {
        float f = ya3.f(matrix);
        Typeface typefaceA = this.D.A(ho0Var.a(), ho0Var.c());
        if (typefaceA == null) {
            return;
        }
        String str = rc0Var.a;
        this.D.z();
        this.z.setTypeface(typefaceA);
        this.z.setTextSize((float) (rc0Var.c * ((double) ya3.e())));
        this.A.setTypeface(this.z.getTypeface());
        this.A.setTextSize(this.z.getTextSize());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            F(cCharAt, rc0Var, canvas);
            char[] cArr = this.w;
            cArr[0] = cCharAt;
            float fMeasureText = this.z.measureText(cArr, 0, 1);
            float fFloatValue = rc0Var.e / 10.0f;
            tg tgVar = this.I;
            if (tgVar != null) {
                fFloatValue += ((Float) tgVar.h()).floatValue();
            }
            canvas.translate(fMeasureText + (fFloatValue * f), 0.0f);
        }
    }

    private List J(ko0 ko0Var) {
        if (this.B.containsKey(ko0Var)) {
            return (List) this.B.get(ko0Var);
        }
        List listA = ko0Var.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new u20(this.D, this, (zn2) listA.get(i)));
        }
        this.B.put(ko0Var, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.e91
    public void f(Object obj, re1 re1Var) {
        tg tgVar;
        tg tgVar2;
        tg tgVar3;
        tg tgVar4;
        super.f(obj, re1Var);
        if (obj == ne1.a && (tgVar4 = this.F) != null) {
            tgVar4.m(re1Var);
            return;
        }
        if (obj == ne1.b && (tgVar3 = this.G) != null) {
            tgVar3.m(re1Var);
            return;
        }
        if (obj == ne1.k && (tgVar2 = this.H) != null) {
            tgVar2.m(re1Var);
        } else {
            if (obj != ne1.l || (tgVar = this.I) == null) {
                return;
            }
            tgVar.m(re1Var);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void n(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.D.W()) {
            canvas.setMatrix(matrix);
        }
        rc0 rc0Var = (rc0) this.C.h();
        ho0 ho0Var = (ho0) this.E.g().get(rc0Var.b);
        if (ho0Var == null) {
            canvas.restore();
            return;
        }
        tg tgVar = this.F;
        if (tgVar != null) {
            this.z.setColor(((Integer) tgVar.h()).intValue());
        } else {
            this.z.setColor(rc0Var.h);
        }
        tg tgVar2 = this.G;
        if (tgVar2 != null) {
            this.A.setColor(((Integer) tgVar2.h()).intValue());
        } else {
            this.A.setColor(rc0Var.i);
        }
        int iIntValue = (((Integer) this.u.g().h()).intValue() * 255) / 100;
        this.z.setAlpha(iIntValue);
        this.A.setAlpha(iIntValue);
        tg tgVar3 = this.H;
        if (tgVar3 != null) {
            this.A.setStrokeWidth(((Float) tgVar3.h()).floatValue());
        } else {
            this.A.setStrokeWidth((float) (rc0Var.j * ((double) ya3.e()) * ((double) ya3.f(matrix))));
        }
        if (this.D.W()) {
            H(rc0Var, matrix, ho0Var, canvas);
        } else {
            I(rc0Var, ho0Var, matrix, canvas);
        }
        canvas.restore();
    }
}
