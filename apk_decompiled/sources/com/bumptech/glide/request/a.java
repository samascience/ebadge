package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.jieli.lib.gif.GifError;
import defpackage.ac0;
import defpackage.au0;
import defpackage.bg0;
import defpackage.eu0;
import defpackage.id0;
import defpackage.na3;
import defpackage.pn0;
import defpackage.px1;
import defpackage.rx1;
import defpackage.w81;
import defpackage.ww;
import defpackage.xp;
import defpackage.xw;
import defpackage.z42;
import defpackage.z43;
import java.util.Map;
import lombok.eclipse.Eclipse;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Cloneable {
    private int a;
    private Drawable e;
    private int f;
    private Drawable g;
    private int h;
    private boolean m;
    private Drawable o;
    private int p;
    private boolean t;
    private Resources.Theme u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean z;
    private float b = 1.0f;
    private ac0 c = ac0.e;
    private Priority d = Priority.NORMAL;
    private boolean i = true;
    private int j = -1;
    private int k = -1;
    private w81 l = bg0.a();
    private boolean n = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private rx1 f228q = new rx1();
    private Map r = new xp();
    private Class s = Object.class;
    private boolean y = true;

    private boolean H(int i) {
        return I(this.a, i);
    }

    private static boolean I(int i, int i2) {
        return (i & i2) != 0;
    }

    private a R(DownsampleStrategy downsampleStrategy, z43 z43Var) {
        return X(downsampleStrategy, z43Var, false);
    }

    private a X(DownsampleStrategy downsampleStrategy, z43 z43Var, boolean z) {
        a aVarG0 = z ? g0(downsampleStrategy, z43Var) : S(downsampleStrategy, z43Var);
        aVarG0.y = true;
        return aVarG0;
    }

    private a Y() {
        return this;
    }

    public final Map A() {
        return this.r;
    }

    public final boolean B() {
        return this.z;
    }

    public final boolean C() {
        return this.w;
    }

    protected final boolean D() {
        return this.v;
    }

    public final boolean E() {
        return this.i;
    }

    public final boolean F() {
        return H(8);
    }

    boolean G() {
        return this.y;
    }

    public final boolean J() {
        return this.n;
    }

    public final boolean K() {
        return this.m;
    }

    public final boolean L() {
        return H(2048);
    }

    public final boolean M() {
        return na3.s(this.k, this.j);
    }

    public a N() {
        this.t = true;
        return Y();
    }

    public a O() {
        return S(DownsampleStrategy.e, new ww());
    }

    public a P() {
        return R(DownsampleStrategy.d, new xw());
    }

    public a Q() {
        return R(DownsampleStrategy.c, new pn0());
    }

    final a S(DownsampleStrategy downsampleStrategy, z43 z43Var) {
        if (this.v) {
            return clone().S(downsampleStrategy, z43Var);
        }
        g(downsampleStrategy);
        return f0(z43Var, false);
    }

    public a T(int i, int i2) {
        if (this.v) {
            return clone().T(i, i2);
        }
        this.k = i;
        this.j = i2;
        this.a |= 512;
        return Z();
    }

    public a U(int i) {
        if (this.v) {
            return clone().U(i);
        }
        this.h = i;
        int i2 = this.a | 128;
        this.g = null;
        this.a = i2 & (-65);
        return Z();
    }

    public a V(Drawable drawable) {
        if (this.v) {
            return clone().V(drawable);
        }
        this.g = drawable;
        int i = this.a | 64;
        this.h = 0;
        this.a = i & GifError.ERR_UNKNOWN_CHIP;
        return Z();
    }

    public a W(Priority priority) {
        if (this.v) {
            return clone().W(priority);
        }
        this.d = (Priority) z42.d(priority);
        this.a |= 8;
        return Z();
    }

    protected final a Z() {
        if (this.t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return Y();
    }

    public a a(a aVar) {
        if (this.v) {
            return clone().a(aVar);
        }
        if (I(aVar.a, 2)) {
            this.b = aVar.b;
        }
        if (I(aVar.a, Opcodes.ASM4)) {
            this.w = aVar.w;
        }
        if (I(aVar.a, Eclipse.HasTypeAnnotations)) {
            this.z = aVar.z;
        }
        if (I(aVar.a, 4)) {
            this.c = aVar.c;
        }
        if (I(aVar.a, 8)) {
            this.d = aVar.d;
        }
        if (I(aVar.a, 16)) {
            this.e = aVar.e;
            this.f = 0;
            this.a &= -33;
        }
        if (I(aVar.a, 32)) {
            this.f = aVar.f;
            this.e = null;
            this.a &= -17;
        }
        if (I(aVar.a, 64)) {
            this.g = aVar.g;
            this.h = 0;
            this.a &= GifError.ERR_UNKNOWN_CHIP;
        }
        if (I(aVar.a, 128)) {
            this.h = aVar.h;
            this.g = null;
            this.a &= -65;
        }
        if (I(aVar.a, 256)) {
            this.i = aVar.i;
        }
        if (I(aVar.a, 512)) {
            this.k = aVar.k;
            this.j = aVar.j;
        }
        if (I(aVar.a, 1024)) {
            this.l = aVar.l;
        }
        if (I(aVar.a, 4096)) {
            this.s = aVar.s;
        }
        if (I(aVar.a, 8192)) {
            this.o = aVar.o;
            this.p = 0;
            this.a &= -16385;
        }
        if (I(aVar.a, 16384)) {
            this.p = aVar.p;
            this.o = null;
            this.a &= -8193;
        }
        if (I(aVar.a, 32768)) {
            this.u = aVar.u;
        }
        if (I(aVar.a, 65536)) {
            this.n = aVar.n;
        }
        if (I(aVar.a, Opcodes.ACC_DEPRECATED)) {
            this.m = aVar.m;
        }
        if (I(aVar.a, 2048)) {
            this.r.putAll(aVar.r);
            this.y = aVar.y;
        }
        if (I(aVar.a, Opcodes.ASM8)) {
            this.x = aVar.x;
        }
        if (!this.n) {
            this.r.clear();
            int i = this.a;
            this.m = false;
            this.a = i & (-133121);
            this.y = true;
        }
        this.a |= aVar.a;
        this.f228q.b(aVar.f228q);
        return Z();
    }

    public a a0(px1 px1Var, Object obj) {
        if (this.v) {
            return clone().a0(px1Var, obj);
        }
        z42.d(px1Var);
        z42.d(obj);
        this.f228q.c(px1Var, obj);
        return Z();
    }

    public a b() {
        if (this.t && !this.v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.v = true;
        return N();
    }

    public a b0(w81 w81Var) {
        if (this.v) {
            return clone().b0(w81Var);
        }
        this.l = (w81) z42.d(w81Var);
        this.a |= 1024;
        return Z();
    }

    public a c() {
        return g0(DownsampleStrategy.e, new ww());
    }

    public a c0(float f) {
        if (this.v) {
            return clone().c0(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.b = f;
        this.a |= 2;
        return Z();
    }

    @Override // 
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public a clone() {
        try {
            a aVar = (a) super.clone();
            rx1 rx1Var = new rx1();
            aVar.f228q = rx1Var;
            rx1Var.b(this.f228q);
            xp xpVar = new xp();
            aVar.r = xpVar;
            xpVar.putAll(this.r);
            aVar.t = false;
            aVar.v = false;
            return aVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public a d0(boolean z) {
        if (this.v) {
            return clone().d0(true);
        }
        this.i = !z;
        this.a |= 256;
        return Z();
    }

    public a e(Class cls) {
        if (this.v) {
            return clone().e(cls);
        }
        this.s = (Class) z42.d(cls);
        this.a |= 4096;
        return Z();
    }

    public a e0(z43 z43Var) {
        return f0(z43Var, true);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.b, this.b) == 0 && this.f == aVar.f && na3.c(this.e, aVar.e) && this.h == aVar.h && na3.c(this.g, aVar.g) && this.p == aVar.p && na3.c(this.o, aVar.o) && this.i == aVar.i && this.j == aVar.j && this.k == aVar.k && this.m == aVar.m && this.n == aVar.n && this.w == aVar.w && this.x == aVar.x && this.c.equals(aVar.c) && this.d == aVar.d && this.f228q.equals(aVar.f228q) && this.r.equals(aVar.r) && this.s.equals(aVar.s) && na3.c(this.l, aVar.l) && na3.c(this.u, aVar.u);
    }

    public a f(ac0 ac0Var) {
        if (this.v) {
            return clone().f(ac0Var);
        }
        this.c = (ac0) z42.d(ac0Var);
        this.a |= 4;
        return Z();
    }

    a f0(z43 z43Var, boolean z) {
        if (this.v) {
            return clone().f0(z43Var, z);
        }
        id0 id0Var = new id0(z43Var, z);
        h0(Bitmap.class, z43Var, z);
        h0(Drawable.class, id0Var, z);
        h0(BitmapDrawable.class, id0Var.a(), z);
        h0(au0.class, new eu0(z43Var), z);
        return Z();
    }

    public a g(DownsampleStrategy downsampleStrategy) {
        return a0(DownsampleStrategy.h, z42.d(downsampleStrategy));
    }

    final a g0(DownsampleStrategy downsampleStrategy, z43 z43Var) {
        if (this.v) {
            return clone().g0(downsampleStrategy, z43Var);
        }
        g(downsampleStrategy);
        return e0(z43Var);
    }

    public a h(int i) {
        if (this.v) {
            return clone().h(i);
        }
        this.f = i;
        int i2 = this.a | 32;
        this.e = null;
        this.a = i2 & (-17);
        return Z();
    }

    a h0(Class cls, z43 z43Var, boolean z) {
        if (this.v) {
            return clone().h0(cls, z43Var, z);
        }
        z42.d(cls);
        z42.d(z43Var);
        this.r.put(cls, z43Var);
        int i = this.a;
        this.n = true;
        this.a = 67584 | i;
        this.y = false;
        if (z) {
            this.a = i | 198656;
            this.m = true;
        }
        return Z();
    }

    public int hashCode() {
        return na3.n(this.u, na3.n(this.l, na3.n(this.s, na3.n(this.r, na3.n(this.f228q, na3.n(this.d, na3.n(this.c, na3.o(this.x, na3.o(this.w, na3.o(this.n, na3.o(this.m, na3.m(this.k, na3.m(this.j, na3.o(this.i, na3.n(this.o, na3.m(this.p, na3.n(this.g, na3.m(this.h, na3.n(this.e, na3.m(this.f, na3.k(this.b)))))))))))))))))))));
    }

    public a i(Drawable drawable) {
        if (this.v) {
            return clone().i(drawable);
        }
        this.e = drawable;
        int i = this.a | 16;
        this.f = 0;
        this.a = i & (-33);
        return Z();
    }

    public a i0(boolean z) {
        if (this.v) {
            return clone().i0(z);
        }
        this.z = z;
        this.a |= Eclipse.HasTypeAnnotations;
        return Z();
    }

    public final ac0 j() {
        return this.c;
    }

    public final int k() {
        return this.f;
    }

    public final Drawable l() {
        return this.e;
    }

    public final Drawable m() {
        return this.o;
    }

    public final int o() {
        return this.p;
    }

    public final boolean p() {
        return this.x;
    }

    public final rx1 q() {
        return this.f228q;
    }

    public final int r() {
        return this.j;
    }

    public final int s() {
        return this.k;
    }

    public final Drawable t() {
        return this.g;
    }

    public final int u() {
        return this.h;
    }

    public final Priority v() {
        return this.d;
    }

    public final Class w() {
        return this.s;
    }

    public final w81 x() {
        return this.l;
    }

    public final float y() {
        return this.b;
    }

    public final Resources.Theme z() {
        return this.u;
    }
}
