package defpackage;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class he0 implements x6.b {
    public static final p m = new f("translationX");
    public static final p n = new g("translationY");
    public static final p o = new h("translationZ");
    public static final p p = new i("scaleX");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final p f346q = new j("scaleY");
    public static final p r = new k("rotation");
    public static final p s = new l("rotationX");
    public static final p t = new m("rotationY");
    public static final p u = new n("x");
    public static final p v = new a("y");
    public static final p w = new b("z");
    public static final p x = new c("alpha");
    public static final p y = new d("scrollX");
    public static final p z = new e("scrollY");
    final Object d;
    final bo0 e;
    private float j;
    float a = 0.0f;
    float b = Float.MAX_VALUE;
    boolean c = false;
    boolean f = false;
    float g = Float.MAX_VALUE;
    float h = -Float.MAX_VALUE;
    private long i = 0;
    private final ArrayList k = new ArrayList();
    private final ArrayList l = new ArrayList();

    static class a extends p {
        a(String str) {
            super(str, null);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getY();
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setY(f);
        }
    }

    static class b extends p {
        b(String str) {
            super(str, null);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return be3.N(view);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            be3.N0(view, f);
        }
    }

    static class c extends p {
        c(String str) {
            super(str, null);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setAlpha(f);
        }
    }

    static class d extends p {
        d(String str) {
            super(str, null);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollX();
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setScrollX((int) f);
        }
    }

    static class e extends p {
        e(String str) {
            super(str, null);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollY();
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setScrollY((int) f);
        }
    }

    static class f extends p {
        f(String str) {
            super(str, null);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationX();
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setTranslationX(f);
        }
    }

    static class g extends p {
        g(String str) {
            super(str, null);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationY();
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setTranslationY(f);
        }
    }

    static class h extends p {
        h(String str) {
            super(str, null);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return be3.K(view);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            be3.L0(view, f);
        }
    }

    static class i extends p {
        i(String str) {
            super(str, null);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setScaleX(f);
        }
    }

    static class j extends p {
        j(String str) {
            super(str, null);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setScaleY(f);
        }
    }

    static class k extends p {
        k(String str) {
            super(str, null);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotation();
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setRotation(f);
        }
    }

    static class l extends p {
        l(String str) {
            super(str, null);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setRotationX(f);
        }
    }

    static class m extends p {
        m(String str) {
            super(str, null);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setRotationY(f);
        }
    }

    static class n extends p {
        n(String str) {
            super(str, null);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getX();
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setX(f);
        }
    }

    static class o {
        float a;
        float b;

        o() {
        }
    }

    public static abstract class p extends bo0 {
        /* synthetic */ p(String str, f fVar) {
            this(str);
        }

        private p(String str) {
            super(str);
        }
    }

    he0(Object obj, bo0 bo0Var) {
        this.d = obj;
        this.e = bo0Var;
        if (bo0Var == r || bo0Var == s || bo0Var == t) {
            this.j = 0.1f;
            return;
        }
        if (bo0Var == x) {
            this.j = 0.00390625f;
        } else if (bo0Var == p || bo0Var == f346q) {
            this.j = 0.00390625f;
        } else {
            this.j = 1.0f;
        }
    }

    private void b(boolean z2) {
        this.f = false;
        x6.d().g(this);
        this.i = 0L;
        this.c = false;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            if (this.k.get(i2) != null) {
                e43.a(this.k.get(i2));
                throw null;
            }
        }
        f(this.k);
    }

    private float c() {
        return this.e.a(this.d);
    }

    private static void f(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void j() {
        if (this.f) {
            return;
        }
        this.f = true;
        if (!this.c) {
            this.b = c();
        }
        float f2 = this.b;
        if (f2 > this.g || f2 < this.h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        x6.d().a(this, 0L);
    }

    @Override // x6.b
    public boolean a(long j2) {
        long j3 = this.i;
        if (j3 == 0) {
            this.i = j2;
            g(this.b);
            return false;
        }
        this.i = j2;
        boolean zK = k(j2 - j3);
        float fMin = Math.min(this.b, this.g);
        this.b = fMin;
        float fMax = Math.max(fMin, this.h);
        this.b = fMax;
        g(fMax);
        if (zK) {
            b(false);
        }
        return zK;
    }

    float d() {
        return this.j * 0.75f;
    }

    public boolean e() {
        return this.f;
    }

    void g(float f2) {
        this.e.b(this.d, f2);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            if (this.l.get(i2) != null) {
                e43.a(this.l.get(i2));
                throw null;
            }
        }
        f(this.l);
    }

    public he0 h(float f2) {
        this.b = f2;
        this.c = true;
        return this;
    }

    public void i() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f) {
            return;
        }
        j();
    }

    abstract boolean k(long j2);
}
