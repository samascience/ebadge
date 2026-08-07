package defpackage;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class ff3 extends b33 {

    static class a extends ff3 {
        a() {
        }

        @Override // defpackage.ff3
        public boolean h(View view, float f, long j, x81 x81Var) {
            view.setAlpha(e(f, j, view, x81Var));
            return this.h;
        }
    }

    public static class b extends ff3 {
        String l;
        SparseArray m;
        SparseArray n = new SparseArray();
        float[] o;
        float[] p;

        public b(String str, SparseArray sparseArray) {
            this.l = str.split(",")[1];
            this.m = sparseArray;
        }

        @Override // defpackage.b33
        public void d(int i) {
            int size = this.m.size();
            int iG = ((ConstraintAttribute) this.m.valueAt(0)).g();
            double[] dArr = new double[size];
            int i2 = iG + 2;
            this.o = new float[i2];
            this.p = new float[iG];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i2);
            for (int i3 = 0; i3 < size; i3++) {
                int iKeyAt = this.m.keyAt(i3);
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.m.valueAt(i3);
                float[] fArr = (float[]) this.n.valueAt(i3);
                dArr[i3] = ((double) iKeyAt) * 0.01d;
                constraintAttribute.e(this.o);
                int i4 = 0;
                while (true) {
                    float[] fArr2 = this.o;
                    if (i4 < fArr2.length) {
                        dArr2[i3][i4] = fArr2[i4];
                        i4++;
                    }
                }
                double[] dArr3 = dArr2[i3];
                dArr3[iG] = fArr[0];
                dArr3[iG + 1] = fArr[1];
            }
            this.a = j50.a(i, dArr, dArr2);
        }

        @Override // defpackage.ff3
        public boolean h(View view, float f, long j, x81 x81Var) {
            this.a.e(f, this.o);
            float[] fArr = this.o;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = j - this.i;
            if (Float.isNaN(this.j)) {
                float fA = x81Var.a(view, this.l, 0);
                this.j = fA;
                if (Float.isNaN(fA)) {
                    this.j = 0.0f;
                }
            }
            float f4 = (float) ((((double) this.j) + ((j2 * 1.0E-9d) * ((double) f2))) % 1.0d);
            this.j = f4;
            this.i = j;
            float fA2 = a(f4);
            this.h = false;
            int i = 0;
            while (true) {
                float[] fArr2 = this.p;
                if (i >= fArr2.length) {
                    break;
                }
                boolean z = this.h;
                float f5 = this.o[i];
                this.h = z | (((double) f5) != 0.0d);
                fArr2[i] = (f5 * fA2) + f3;
                i++;
            }
            n50.b((ConstraintAttribute) this.m.valueAt(0), view, this.p);
            if (f2 != 0.0f) {
                this.h = true;
            }
            return this.h;
        }
    }

    static class c extends ff3 {
        c() {
        }

        @Override // defpackage.ff3
        public boolean h(View view, float f, long j, x81 x81Var) {
            view.setElevation(e(f, j, view, x81Var));
            return this.h;
        }
    }

    public static class d extends ff3 {
        @Override // defpackage.ff3
        public boolean h(View view, float f, long j, x81 x81Var) {
            return this.h;
        }

        public boolean i(View view, x81 x81Var, float f, long j, double d, double d2) {
            view.setRotation(e(f, j, view, x81Var) + ((float) Math.toDegrees(Math.atan2(d2, d))));
            return this.h;
        }
    }

    static class e extends ff3 {
        boolean l = false;

        e() {
        }

        @Override // defpackage.ff3
        public boolean h(View view, float f, long j, x81 x81Var) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(e(f, j, view, x81Var));
            } else {
                if (this.l) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.l = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(e(f, j, view, x81Var)));
                    } catch (IllegalAccessException e) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e2);
                    }
                }
            }
            return this.h;
        }
    }

    static class f extends ff3 {
        f() {
        }

        @Override // defpackage.ff3
        public boolean h(View view, float f, long j, x81 x81Var) {
            view.setRotation(e(f, j, view, x81Var));
            return this.h;
        }
    }

    static class g extends ff3 {
        g() {
        }

        @Override // defpackage.ff3
        public boolean h(View view, float f, long j, x81 x81Var) {
            view.setRotationX(e(f, j, view, x81Var));
            return this.h;
        }
    }

    static class h extends ff3 {
        h() {
        }

        @Override // defpackage.ff3
        public boolean h(View view, float f, long j, x81 x81Var) {
            view.setRotationY(e(f, j, view, x81Var));
            return this.h;
        }
    }

    static class i extends ff3 {
        i() {
        }

        @Override // defpackage.ff3
        public boolean h(View view, float f, long j, x81 x81Var) {
            view.setScaleX(e(f, j, view, x81Var));
            return this.h;
        }
    }

    static class j extends ff3 {
        j() {
        }

        @Override // defpackage.ff3
        public boolean h(View view, float f, long j, x81 x81Var) {
            view.setScaleY(e(f, j, view, x81Var));
            return this.h;
        }
    }

    static class k extends ff3 {
        k() {
        }

        @Override // defpackage.ff3
        public boolean h(View view, float f, long j, x81 x81Var) {
            view.setTranslationX(e(f, j, view, x81Var));
            return this.h;
        }
    }

    static class l extends ff3 {
        l() {
        }

        @Override // defpackage.ff3
        public boolean h(View view, float f, long j, x81 x81Var) {
            view.setTranslationY(e(f, j, view, x81Var));
            return this.h;
        }
    }

    static class m extends ff3 {
        m() {
        }

        @Override // defpackage.ff3
        public boolean h(View view, float f, long j, x81 x81Var) {
            view.setTranslationZ(e(f, j, view, x81Var));
            return this.h;
        }
    }

    public static ff3 f(String str, SparseArray sparseArray) {
        return new b(str, sparseArray);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static ff3 g(String str, long j2) {
        ff3 gVar;
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    b2 = 0;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    b2 = 1;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    b2 = 2;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    b2 = 3;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    b2 = 4;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    b2 = 5;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b2 = 6;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b2 = 7;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    b2 = 8;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b2 = 9;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b2 = 10;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b2 = AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS;
                }
                break;
        }
        switch (b2) {
            case 0:
                gVar = new g();
                break;
            case 1:
                gVar = new h();
                break;
            case 2:
                gVar = new k();
                break;
            case 3:
                gVar = new l();
                break;
            case 4:
                gVar = new m();
                break;
            case 5:
                gVar = new e();
                break;
            case 6:
                gVar = new i();
                break;
            case 7:
                gVar = new j();
                break;
            case 8:
                gVar = new f();
                break;
            case 9:
                gVar = new c();
                break;
            case 10:
                gVar = new d();
                break;
            case 11:
                gVar = new a();
                break;
            default:
                return null;
        }
        gVar.b(j2);
        return gVar;
    }

    public float e(float f2, long j2, View view, x81 x81Var) {
        this.a.e(f2, this.g);
        float[] fArr = this.g;
        float f3 = fArr[1];
        if (f3 == 0.0f) {
            this.h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.j)) {
            float fA = x81Var.a(view, this.f, 0);
            this.j = fA;
            if (Float.isNaN(fA)) {
                this.j = 0.0f;
            }
        }
        float f4 = (float) ((((double) this.j) + (((j2 - this.i) * 1.0E-9d) * ((double) f3))) % 1.0d);
        this.j = f4;
        x81Var.b(view, this.f, 0, f4);
        this.i = j2;
        float f5 = this.g[0];
        float fA2 = (a(this.j) * f5) + this.g[2];
        this.h = (f5 == 0.0f && f3 == 0.0f) ? false : true;
        return fA2;
    }

    public abstract boolean h(View view, float f2, long j2, x81 x81Var);
}
