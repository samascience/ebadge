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
public abstract class cf3 extends rs2 {

    static class a extends cf3 {
        a() {
        }

        @Override // defpackage.cf3
        public void h(View view, float f) {
            view.setAlpha(a(f));
        }
    }

    public static class b extends cf3 {
        String f;
        SparseArray g;
        float[] h;

        public b(String str, SparseArray sparseArray) {
            this.f = str.split(",")[1];
            this.g = sparseArray;
        }

        @Override // defpackage.rs2
        public void c(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // defpackage.rs2
        public void e(int i) {
            int size = this.g.size();
            int iG = ((ConstraintAttribute) this.g.valueAt(0)).g();
            double[] dArr = new double[size];
            this.h = new float[iG];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, iG);
            for (int i2 = 0; i2 < size; i2++) {
                int iKeyAt = this.g.keyAt(i2);
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.g.valueAt(i2);
                dArr[i2] = ((double) iKeyAt) * 0.01d;
                constraintAttribute.e(this.h);
                int i3 = 0;
                while (true) {
                    float[] fArr = this.h;
                    if (i3 < fArr.length) {
                        dArr2[i2][i3] = fArr[i3];
                        i3++;
                    }
                }
            }
            this.a = j50.a(i, dArr, dArr2);
        }

        @Override // defpackage.cf3
        public void h(View view, float f) {
            this.a.e(f, this.h);
            n50.b((ConstraintAttribute) this.g.valueAt(0), view, this.h);
        }

        public void i(int i, ConstraintAttribute constraintAttribute) {
            this.g.append(i, constraintAttribute);
        }
    }

    static class c extends cf3 {
        c() {
        }

        @Override // defpackage.cf3
        public void h(View view, float f) {
            view.setElevation(a(f));
        }
    }

    public static class d extends cf3 {
        @Override // defpackage.cf3
        public void h(View view, float f) {
        }

        public void i(View view, float f, double d, double d2) {
            view.setRotation(a(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }
    }

    static class e extends cf3 {
        e() {
        }

        @Override // defpackage.cf3
        public void h(View view, float f) {
            view.setPivotX(a(f));
        }
    }

    static class f extends cf3 {
        f() {
        }

        @Override // defpackage.cf3
        public void h(View view, float f) {
            view.setPivotY(a(f));
        }
    }

    static class g extends cf3 {
        boolean f = false;

        g() {
        }

        @Override // defpackage.cf3
        public void h(View view, float f) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f));
                return;
            }
            if (this.f) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f)));
                } catch (IllegalAccessException e) {
                    Log.e("ViewSpline", "unable to setProgress", e);
                } catch (InvocationTargetException e2) {
                    Log.e("ViewSpline", "unable to setProgress", e2);
                }
            }
        }
    }

    static class h extends cf3 {
        h() {
        }

        @Override // defpackage.cf3
        public void h(View view, float f) {
            view.setRotation(a(f));
        }
    }

    static class i extends cf3 {
        i() {
        }

        @Override // defpackage.cf3
        public void h(View view, float f) {
            view.setRotationX(a(f));
        }
    }

    static class j extends cf3 {
        j() {
        }

        @Override // defpackage.cf3
        public void h(View view, float f) {
            view.setRotationY(a(f));
        }
    }

    static class k extends cf3 {
        k() {
        }

        @Override // defpackage.cf3
        public void h(View view, float f) {
            view.setScaleX(a(f));
        }
    }

    static class l extends cf3 {
        l() {
        }

        @Override // defpackage.cf3
        public void h(View view, float f) {
            view.setScaleY(a(f));
        }
    }

    static class m extends cf3 {
        m() {
        }

        @Override // defpackage.cf3
        public void h(View view, float f) {
            view.setTranslationX(a(f));
        }
    }

    static class n extends cf3 {
        n() {
        }

        @Override // defpackage.cf3
        public void h(View view, float f) {
            view.setTranslationY(a(f));
        }
    }

    static class o extends cf3 {
        o() {
        }

        @Override // defpackage.cf3
        public void h(View view, float f) {
            view.setTranslationZ(a(f));
        }
    }

    public static cf3 f(String str, SparseArray sparseArray) {
        return new b(str, sparseArray);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static cf3 g(String str) {
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
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    b2 = 8;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    b2 = 9;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    b2 = 10;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    b2 = AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b2 = AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b2 = AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b2 = AttrAndFunCode.SYS_INFO_ATTR_ALL_NOISE_MODE;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    b2 = AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS;
                }
                break;
        }
        switch (b2) {
            case 0:
                return new i();
            case 1:
                return new j();
            case 2:
                return new m();
            case 3:
                return new n();
            case 4:
                return new o();
            case 5:
                return new g();
            case 6:
                return new k();
            case 7:
                return new l();
            case 8:
                return new a();
            case 9:
                return new e();
            case 10:
                return new f();
            case 11:
                return new h();
            case 12:
                return new c();
            case 13:
                return new d();
            case 14:
                return new a();
            case 15:
                return new a();
            default:
                return null;
        }
    }

    public abstract void h(View view, float f2);
}
