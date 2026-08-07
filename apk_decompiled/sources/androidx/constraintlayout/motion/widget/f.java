package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import defpackage.cf3;
import defpackage.ye0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class f implements Comparable {
    static String[] I = {"position", "x", "y", "width", "height", "pathRotate"};
    int c;
    private ye0 p;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float a = 1.0f;
    int b = 0;
    private boolean d = false;
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 0.0f;
    public float h = 0.0f;
    private float i = 1.0f;
    private float j = 1.0f;
    private float k = Float.NaN;
    private float l = Float.NaN;
    private float m = 0.0f;
    private float n = 0.0f;
    private float o = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f174q = 0;
    private float w = Float.NaN;
    private float x = Float.NaN;
    private int y = -1;
    LinkedHashMap z = new LinkedHashMap();
    int F = 0;
    double[] G = new double[18];
    double[] H = new double[18];

    private boolean e(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            return Float.isNaN(f) != Float.isNaN(f2);
        }
        return Math.abs(f - f2) > 1.0E-6f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(HashMap map, int i) {
        for (String str : map.keySet()) {
            cf3 cf3Var = (cf3) map.get(str);
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        b = 0;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        b = 1;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        b = 2;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        b = 3;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        b = 4;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        b = 5;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        b = 6;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        b = 7;
                    }
                    break;
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        b = 8;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        b = 9;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        b = 10;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        b = AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        b = AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        b = AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    cf3Var.c(i, Float.isNaN(this.g) ? 0.0f : this.g);
                    break;
                case 1:
                    cf3Var.c(i, Float.isNaN(this.h) ? 0.0f : this.h);
                    break;
                case 2:
                    cf3Var.c(i, Float.isNaN(this.m) ? 0.0f : this.m);
                    break;
                case 3:
                    cf3Var.c(i, Float.isNaN(this.n) ? 0.0f : this.n);
                    break;
                case 4:
                    cf3Var.c(i, Float.isNaN(this.o) ? 0.0f : this.o);
                    break;
                case 5:
                    cf3Var.c(i, Float.isNaN(this.x) ? 0.0f : this.x);
                    break;
                case 6:
                    cf3Var.c(i, Float.isNaN(this.i) ? 1.0f : this.i);
                    break;
                case 7:
                    cf3Var.c(i, Float.isNaN(this.j) ? 1.0f : this.j);
                    break;
                case 8:
                    cf3Var.c(i, Float.isNaN(this.k) ? 0.0f : this.k);
                    break;
                case 9:
                    cf3Var.c(i, Float.isNaN(this.l) ? 0.0f : this.l);
                    break;
                case 10:
                    cf3Var.c(i, Float.isNaN(this.f) ? 0.0f : this.f);
                    break;
                case 11:
                    cf3Var.c(i, Float.isNaN(this.e) ? 0.0f : this.e);
                    break;
                case 12:
                    cf3Var.c(i, Float.isNaN(this.w) ? 0.0f : this.w);
                    break;
                case 13:
                    cf3Var.c(i, Float.isNaN(this.a) ? 1.0f : this.a);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.z.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.z.get(str2);
                            if (cf3Var instanceof cf3.b) {
                                ((cf3.b) cf3Var).i(i, constraintAttribute);
                            } else {
                                Log.e("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i + ", value" + constraintAttribute.d() + cf3Var);
                            }
                        }
                    } else {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                    }
                    break;
            }
        }
    }

    public void b(View view) {
        this.c = view.getVisibility();
        this.a = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.d = false;
        this.e = view.getElevation();
        this.f = view.getRotation();
        this.g = view.getRotationX();
        this.h = view.getRotationY();
        this.i = view.getScaleX();
        this.j = view.getScaleY();
        this.k = view.getPivotX();
        this.l = view.getPivotY();
        this.m = view.getTranslationX();
        this.n = view.getTranslationY();
        this.o = view.getTranslationZ();
    }

    public void c(androidx.constraintlayout.widget.b.a aVar) {
        androidx.constraintlayout.widget.b.d dVar = aVar.c;
        int i = dVar.c;
        this.b = i;
        int i2 = dVar.b;
        this.c = i2;
        this.a = (i2 == 0 || i != 0) ? dVar.d : 0.0f;
        androidx.constraintlayout.widget.b.e eVar = aVar.f;
        this.d = eVar.m;
        this.e = eVar.n;
        this.f = eVar.b;
        this.g = eVar.c;
        this.h = eVar.d;
        this.i = eVar.e;
        this.j = eVar.f;
        this.k = eVar.g;
        this.l = eVar.h;
        this.m = eVar.j;
        this.n = eVar.k;
        this.o = eVar.l;
        this.p = ye0.c(aVar.d.d);
        androidx.constraintlayout.widget.b.c cVar = aVar.d;
        this.w = cVar.i;
        this.f174q = cVar.f;
        this.y = cVar.b;
        this.x = aVar.c.e;
        for (String str : aVar.g.keySet()) {
            ConstraintAttribute constraintAttribute = (ConstraintAttribute) aVar.g.get(str);
            if (constraintAttribute.f()) {
                this.z.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        return Float.compare(this.r, fVar.r);
    }

    void f(f fVar, HashSet hashSet) {
        if (e(this.a, fVar.a)) {
            hashSet.add("alpha");
        }
        if (e(this.e, fVar.e)) {
            hashSet.add("elevation");
        }
        int i = this.c;
        int i2 = fVar.c;
        if (i != i2 && this.b == 0 && (i == 0 || i2 == 0)) {
            hashSet.add("alpha");
        }
        if (e(this.f, fVar.f)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.w) || !Float.isNaN(fVar.w)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.x) || !Float.isNaN(fVar.x)) {
            hashSet.add("progress");
        }
        if (e(this.g, fVar.g)) {
            hashSet.add("rotationX");
        }
        if (e(this.h, fVar.h)) {
            hashSet.add("rotationY");
        }
        if (e(this.k, fVar.k)) {
            hashSet.add("transformPivotX");
        }
        if (e(this.l, fVar.l)) {
            hashSet.add("transformPivotY");
        }
        if (e(this.i, fVar.i)) {
            hashSet.add("scaleX");
        }
        if (e(this.j, fVar.j)) {
            hashSet.add("scaleY");
        }
        if (e(this.m, fVar.m)) {
            hashSet.add("translationX");
        }
        if (e(this.n, fVar.n)) {
            hashSet.add("translationY");
        }
        if (e(this.o, fVar.o)) {
            hashSet.add("translationZ");
        }
    }

    void g(float f, float f2, float f3, float f4) {
        this.s = f;
        this.t = f2;
        this.u = f3;
        this.v = f4;
    }

    public void h(Rect rect, androidx.constraintlayout.widget.b bVar, int i, int i2) {
        g(rect.left, rect.top, rect.width(), rect.height());
        c(bVar.y(i2));
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                }
            }
            float f = this.f + 90.0f;
            this.f = f;
            if (f > 180.0f) {
                this.f = f - 360.0f;
                return;
            }
            return;
        }
        this.f -= 90.0f;
    }

    public void i(View view) {
        g(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        b(view);
    }
}
