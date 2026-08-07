package defpackage;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class oe3 extends z81 {

    static class a extends oe3 {
        a() {
        }

        @Override // defpackage.oe3
        public void g(View view, float f) {
            view.setAlpha(a(f));
        }
    }

    static class b extends oe3 {
        float[] h = new float[1];
        protected ConstraintAttribute i;

        b() {
        }

        @Override // defpackage.oe3
        public void g(View view, float f) {
            this.h[0] = a(f);
            n50.b(this.i, view, this.h);
        }
    }

    static class c extends oe3 {
        c() {
        }

        @Override // defpackage.oe3
        public void g(View view, float f) {
            view.setElevation(a(f));
        }
    }

    public static class d extends oe3 {
        @Override // defpackage.oe3
        public void g(View view, float f) {
        }

        public void h(View view, float f, double d, double d2) {
            view.setRotation(a(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }
    }

    static class e extends oe3 {
        boolean h = false;

        e() {
        }

        @Override // defpackage.oe3
        public void g(View view, float f) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f));
                return;
            }
            if (this.h) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.h = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f)));
                } catch (IllegalAccessException e) {
                    Log.e("ViewOscillator", "unable to setProgress", e);
                } catch (InvocationTargetException e2) {
                    Log.e("ViewOscillator", "unable to setProgress", e2);
                }
            }
        }
    }

    static class f extends oe3 {
        f() {
        }

        @Override // defpackage.oe3
        public void g(View view, float f) {
            view.setRotation(a(f));
        }
    }

    static class g extends oe3 {
        g() {
        }

        @Override // defpackage.oe3
        public void g(View view, float f) {
            view.setRotationX(a(f));
        }
    }

    static class h extends oe3 {
        h() {
        }

        @Override // defpackage.oe3
        public void g(View view, float f) {
            view.setRotationY(a(f));
        }
    }

    static class i extends oe3 {
        i() {
        }

        @Override // defpackage.oe3
        public void g(View view, float f) {
            view.setScaleX(a(f));
        }
    }

    static class j extends oe3 {
        j() {
        }

        @Override // defpackage.oe3
        public void g(View view, float f) {
            view.setScaleY(a(f));
        }
    }

    static class k extends oe3 {
        k() {
        }

        @Override // defpackage.oe3
        public void g(View view, float f) {
            view.setTranslationX(a(f));
        }
    }

    static class l extends oe3 {
        l() {
        }

        @Override // defpackage.oe3
        public void g(View view, float f) {
            view.setTranslationY(a(f));
        }
    }

    static class m extends oe3 {
        m() {
        }

        @Override // defpackage.oe3
        public void g(View view, float f) {
            view.setTranslationZ(a(f));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static oe3 f(String str) {
        if (str.startsWith("CUSTOM")) {
            return new b();
        }
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
            case -40300674:
                if (str.equals("rotation")) {
                    b2 = 9;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b2 = 10;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b2 = AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b2 = AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    b2 = AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE;
                }
                break;
        }
        switch (b2) {
            case 0:
                return new g();
            case 1:
                return new h();
            case 2:
                return new k();
            case 3:
                return new l();
            case 4:
                return new m();
            case 5:
                return new e();
            case 6:
                return new i();
            case 7:
                return new j();
            case 8:
                return new a();
            case 9:
                return new f();
            case 10:
                return new c();
            case 11:
                return new d();
            case 12:
                return new a();
            case 13:
                return new a();
            default:
                return null;
        }
    }

    public abstract void g(View view, float f2);
}
