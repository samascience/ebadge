package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class je1 extends Drawable implements Drawable.Callback, Animatable {
    private final Matrix a = new Matrix();
    private fe1 b;
    private final qe1 c;
    private float d;
    private final Set e;
    private final ArrayList f;
    private lz0 g;
    private String h;
    private jo0 i;
    private boolean j;
    private com.airbnb.lottie.model.layer.b k;
    private int l;
    private boolean m;

    class a implements j {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // je1.j
        public void a(fe1 fe1Var) {
            je1.this.H(this.a);
        }
    }

    class b implements j {
        final /* synthetic */ float a;

        b(float f) {
            this.a = f;
        }

        @Override // je1.j
        public void a(fe1 fe1Var) {
            je1.this.P(this.a);
        }
    }

    class c implements j {
        final /* synthetic */ d91 a;
        final /* synthetic */ Object b;
        final /* synthetic */ re1 c;

        c(d91 d91Var, Object obj, re1 re1Var) {
            this.a = d91Var;
            this.b = obj;
            this.c = re1Var;
        }

        @Override // je1.j
        public void a(fe1 fe1Var) {
            je1.this.c(this.a, this.b, this.c);
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (je1.this.k != null) {
                je1.this.k.A(je1.this.c.h());
            }
        }
    }

    class e implements j {
        e() {
        }

        @Override // je1.j
        public void a(fe1 fe1Var) {
            je1.this.C();
        }
    }

    class f implements j {
        final /* synthetic */ int a;

        f(int i) {
            this.a = i;
        }

        @Override // je1.j
        public void a(fe1 fe1Var) {
            je1.this.M(this.a);
        }
    }

    class g implements j {
        final /* synthetic */ float a;

        g(float f) {
            this.a = f;
        }

        @Override // je1.j
        public void a(fe1 fe1Var) {
            je1.this.N(this.a);
        }
    }

    class h implements j {
        final /* synthetic */ int a;

        h(int i) {
            this.a = i;
        }

        @Override // je1.j
        public void a(fe1 fe1Var) {
            je1.this.K(this.a);
        }
    }

    class i implements j {
        final /* synthetic */ float a;

        i(float f) {
            this.a = f;
        }

        @Override // je1.j
        public void a(fe1 fe1Var) {
            je1.this.L(this.a);
        }
    }

    private interface j {
        void a(fe1 fe1Var);
    }

    public je1() {
        qe1 qe1Var = new qe1();
        this.c = qe1Var;
        this.d = 1.0f;
        this.e = new HashSet();
        this.f = new ArrayList();
        this.l = 255;
        qe1Var.addUpdateListener(new d());
    }

    private void V() {
        if (this.b == null) {
            return;
        }
        float fX = x();
        setBounds(0, 0, (int) (this.b.b().width() * fX), (int) (this.b.b().height() * fX));
    }

    private void d() {
        this.k = new com.airbnb.lottie.model.layer.b(this, ha1.a(this.b), this.b.j(), this.b);
    }

    private Context k() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private jo0 l() {
        if (getCallback() == null) {
            return null;
        }
        if (this.i == null) {
            this.i = new jo0(getCallback(), null);
        }
        return this.i;
    }

    private lz0 o() {
        if (getCallback() == null) {
            return null;
        }
        lz0 lz0Var = this.g;
        if (lz0Var != null && !lz0Var.b(k())) {
            this.g.d();
            this.g = null;
        }
        if (this.g == null) {
            this.g = new lz0(getCallback(), this.h, null, this.b.i());
        }
        return this.g;
    }

    private float r(Canvas canvas) {
        return Math.min(canvas.getWidth() / this.b.b().width(), canvas.getHeight() / this.b.b().height());
    }

    public Typeface A(String str, String str2) {
        jo0 jo0VarL = l();
        if (jo0VarL != null) {
            return jo0VarL.b(str, str2);
        }
        return null;
    }

    public boolean B() {
        return this.c.isRunning();
    }

    public void C() {
        if (this.k == null) {
            this.f.add(new e());
        } else {
            this.c.p();
        }
    }

    public void D() {
        lz0 lz0Var = this.g;
        if (lz0Var != null) {
            lz0Var.d();
        }
    }

    public List E(d91 d91Var) {
        if (this.k == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.k.g(d91Var, 0, arrayList, new d91(new String[0]));
        return arrayList;
    }

    public boolean F(fe1 fe1Var) {
        if (this.b == fe1Var) {
            return false;
        }
        f();
        this.b = fe1Var;
        d();
        this.c.u(fe1Var);
        P(this.c.getAnimatedFraction());
        S(this.d);
        V();
        Iterator it = new ArrayList(this.f).iterator();
        while (it.hasNext()) {
            ((j) it.next()).a(fe1Var);
            it.remove();
        }
        this.f.clear();
        fe1Var.p(this.m);
        return true;
    }

    public void G(io0 io0Var) {
        jo0 jo0Var = this.i;
        if (jo0Var != null) {
            jo0Var.c(io0Var);
        }
    }

    public void H(int i2) {
        if (this.b == null) {
            this.f.add(new a(i2));
        } else {
            this.c.v(i2);
        }
    }

    public void I(kz0 kz0Var) {
        lz0 lz0Var = this.g;
        if (lz0Var != null) {
            lz0Var.e(kz0Var);
        }
    }

    public void J(String str) {
        this.h = str;
    }

    public void K(int i2) {
        if (this.b == null) {
            this.f.add(new h(i2));
        } else {
            this.c.w(i2);
        }
    }

    public void L(float f2) {
        fe1 fe1Var = this.b;
        if (fe1Var == null) {
            this.f.add(new i(f2));
        } else {
            K((int) ok1.j(fe1Var.m(), this.b.f(), f2));
        }
    }

    public void M(int i2) {
        if (this.b == null) {
            this.f.add(new f(i2));
        } else {
            this.c.y(i2);
        }
    }

    public void N(float f2) {
        fe1 fe1Var = this.b;
        if (fe1Var == null) {
            this.f.add(new g(f2));
        } else {
            M((int) ok1.j(fe1Var.m(), this.b.f(), f2));
        }
    }

    public void O(boolean z) {
        this.m = z;
        fe1 fe1Var = this.b;
        if (fe1Var != null) {
            fe1Var.p(z);
        }
    }

    public void P(float f2) {
        fe1 fe1Var = this.b;
        if (fe1Var == null) {
            this.f.add(new b(f2));
        } else {
            H((int) ok1.j(fe1Var.m(), this.b.f(), f2));
        }
    }

    public void Q(int i2) {
        this.c.setRepeatCount(i2);
    }

    public void R(int i2) {
        this.c.setRepeatMode(i2);
    }

    public void S(float f2) {
        this.d = f2;
        V();
    }

    public void T(float f2) {
        this.c.z(f2);
    }

    public void U(x13 x13Var) {
    }

    public boolean W() {
        return this.b.c().h() > 0;
    }

    public void c(d91 d91Var, Object obj, re1 re1Var) {
        if (this.k == null) {
            this.f.add(new c(d91Var, obj, re1Var));
            return;
        }
        boolean zIsEmpty = true;
        if (d91Var.d() != null) {
            d91Var.d().f(obj, re1Var);
        } else {
            List listE = E(d91Var);
            for (int i2 = 0; i2 < listE.size(); i2++) {
                ((d91) listE.get(i2)).d().f(obj, re1Var);
            }
            zIsEmpty = true ^ listE.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (obj == ne1.w) {
                P(u());
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f2;
        o91.a("Drawable#draw");
        if (this.k == null) {
            return;
        }
        float f3 = this.d;
        float fR = r(canvas);
        if (f3 > fR) {
            f2 = this.d / fR;
        } else {
            fR = f3;
            f2 = 1.0f;
        }
        if (f2 > 1.0f) {
            canvas.save();
            float fWidth = this.b.b().width() / 2.0f;
            float fHeight = this.b.b().height() / 2.0f;
            float f4 = fWidth * fR;
            float f5 = fHeight * fR;
            canvas.translate((x() * fWidth) - f4, (x() * fHeight) - f5);
            canvas.scale(f2, f2, f4, f5);
        }
        this.a.reset();
        this.a.preScale(fR, fR);
        this.k.h(canvas, this.a, this.l);
        o91.c("Drawable#draw");
        if (f2 > 1.0f) {
            canvas.restore();
        }
    }

    public void e() {
        this.f.clear();
        this.c.cancel();
    }

    public void f() {
        D();
        if (this.c.isRunning()) {
            this.c.cancel();
        }
        this.b = null;
        this.k = null;
        this.g = null;
        this.c.f();
        invalidateSelf();
    }

    public void g(boolean z) {
        if (this.j == z) {
            return;
        }
        this.j = z;
        if (this.b != null) {
            d();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        fe1 fe1Var = this.b;
        if (fe1Var == null) {
            return -1;
        }
        return (int) (fe1Var.b().height() * x());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        fe1 fe1Var = this.b;
        if (fe1Var == null) {
            return -1;
        }
        return (int) (fe1Var.b().width() * x());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h() {
        return this.j;
    }

    public void i() {
        this.f.clear();
        this.c.g();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return B();
    }

    public fe1 j() {
        return this.b;
    }

    public int m() {
        return (int) this.c.i();
    }

    public Bitmap n(String str) {
        lz0 lz0VarO = o();
        if (lz0VarO != null) {
            return lz0VarO.a(str);
        }
        return null;
    }

    public String p() {
        return this.h;
    }

    public float q() {
        return this.c.k();
    }

    public float s() {
        return this.c.l();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.l = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Log.w("LOTTIE", "Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        C();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        i();
    }

    public vz1 t() {
        fe1 fe1Var = this.b;
        if (fe1Var != null) {
            return fe1Var.k();
        }
        return null;
    }

    public float u() {
        return this.c.h();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public int v() {
        return this.c.getRepeatCount();
    }

    public int w() {
        return this.c.getRepeatMode();
    }

    public float x() {
        return this.d;
    }

    public float y() {
        return this.c.m();
    }

    public x13 z() {
        return null;
    }
}
