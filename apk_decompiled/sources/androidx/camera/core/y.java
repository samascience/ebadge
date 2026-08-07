package androidx.camera.core;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import defpackage.as;
import defpackage.b52;
import defpackage.cs;
import defpackage.ds;
import defpackage.n01;
import defpackage.x01;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class y implements x01, l.a {
    private final Object a;
    private as b;
    private int c;
    private x01.a d;
    private boolean e;
    private final x01 f;
    x01.a g;
    private Executor h;
    private final LongSparseArray i;
    private final LongSparseArray j;
    private int k;
    private final List l;
    private final List m;

    class a extends as {
        a() {
        }

        @Override // defpackage.as
        public void b(int i, cs csVar) {
            super.b(i, csVar);
            y.this.t(csVar);
        }
    }

    public y(int i, int i2, int i3, int i4) {
        this(k(i, i2, i3, i4));
    }

    private static x01 k(int i, int i2, int i3, int i4) {
        return new d(ImageReader.newInstance(i, i2, i3, i4));
    }

    private void l(v vVar) {
        synchronized (this.a) {
            try {
                int iIndexOf = this.l.indexOf(vVar);
                if (iIndexOf >= 0) {
                    this.l.remove(iIndexOf);
                    int i = this.k;
                    if (iIndexOf <= i) {
                        this.k = i - 1;
                    }
                }
                this.m.remove(vVar);
                if (this.c > 0) {
                    o(this.f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void m(c0 c0Var) {
        final x01.a aVar;
        Executor executor;
        synchronized (this.a) {
            try {
                if (this.l.size() < g()) {
                    c0Var.n(this);
                    this.l.add(c0Var);
                    aVar = this.g;
                    executor = this.h;
                } else {
                    x.a("TAG", "Maximum image number reached.");
                    c0Var.close();
                    aVar = null;
                    executor = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            if (executor != null) {
                executor.execute(new Runnable() { // from class: rj1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.p(aVar);
                    }
                });
            } else {
                aVar.a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(x01.a aVar) {
        aVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(x01 x01Var) {
        synchronized (this.a) {
            this.c++;
        }
        o(x01Var);
    }

    private void r() {
        synchronized (this.a) {
            try {
                for (int size = this.i.size() - 1; size >= 0; size--) {
                    n01 n01Var = (n01) this.i.valueAt(size);
                    long jC = n01Var.c();
                    v vVar = (v) this.j.get(jC);
                    if (vVar != null) {
                        this.j.remove(jC);
                        this.i.removeAt(size);
                        m(new c0(vVar, n01Var));
                    }
                }
                s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void s() {
        synchronized (this.a) {
            try {
                if (this.j.size() != 0 && this.i.size() != 0) {
                    long jKeyAt = this.j.keyAt(0);
                    Long lValueOf = Long.valueOf(jKeyAt);
                    long jKeyAt2 = this.i.keyAt(0);
                    b52.a(!Long.valueOf(jKeyAt2).equals(lValueOf));
                    if (jKeyAt2 > jKeyAt) {
                        for (int size = this.j.size() - 1; size >= 0; size--) {
                            if (this.j.keyAt(size) < jKeyAt2) {
                                ((v) this.j.valueAt(size)).close();
                                this.j.removeAt(size);
                            }
                        }
                    } else {
                        for (int size2 = this.i.size() - 1; size2 >= 0; size2--) {
                            if (this.i.keyAt(size2) < jKeyAt) {
                                this.i.removeAt(size2);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.x01
    public Surface a() {
        Surface surfaceA;
        synchronized (this.a) {
            surfaceA = this.f.a();
        }
        return surfaceA;
    }

    @Override // androidx.camera.core.l.a
    public void b(v vVar) {
        synchronized (this.a) {
            l(vVar);
        }
    }

    @Override // defpackage.x01
    public v c() {
        synchronized (this.a) {
            try {
                if (this.l.isEmpty()) {
                    return null;
                }
                if (this.k >= this.l.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.l.size() - 1; i++) {
                    if (!this.m.contains(this.l.get(i))) {
                        arrayList.add((v) this.l.get(i));
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((v) it.next()).close();
                }
                int size = this.l.size();
                List list = this.l;
                this.k = size;
                v vVar = (v) list.get(size - 1);
                this.m.add(vVar);
                return vVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.x01
    public void close() {
        synchronized (this.a) {
            try {
                if (this.e) {
                    return;
                }
                Iterator it = new ArrayList(this.l).iterator();
                while (it.hasNext()) {
                    ((v) it.next()).close();
                }
                this.l.clear();
                this.f.close();
                this.e = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.x01
    public int d() {
        int iD;
        synchronized (this.a) {
            iD = this.f.d();
        }
        return iD;
    }

    @Override // defpackage.x01
    public void e() {
        synchronized (this.a) {
            this.f.e();
            this.g = null;
            this.h = null;
            this.c = 0;
        }
    }

    @Override // defpackage.x01
    public void f(x01.a aVar, Executor executor) {
        synchronized (this.a) {
            this.g = (x01.a) b52.g(aVar);
            this.h = (Executor) b52.g(executor);
            this.f.f(this.d, executor);
        }
    }

    @Override // defpackage.x01
    public int g() {
        int iG;
        synchronized (this.a) {
            iG = this.f.g();
        }
        return iG;
    }

    @Override // defpackage.x01
    public int getHeight() {
        int height;
        synchronized (this.a) {
            height = this.f.getHeight();
        }
        return height;
    }

    @Override // defpackage.x01
    public int getWidth() {
        int width;
        synchronized (this.a) {
            width = this.f.getWidth();
        }
        return width;
    }

    @Override // defpackage.x01
    public v h() {
        synchronized (this.a) {
            try {
                if (this.l.isEmpty()) {
                    return null;
                }
                if (this.k >= this.l.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                List list = this.l;
                int i = this.k;
                this.k = i + 1;
                v vVar = (v) list.get(i);
                this.m.add(vVar);
                return vVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public as n() {
        return this.b;
    }

    void o(x01 x01Var) {
        v vVarH;
        synchronized (this.a) {
            try {
                if (this.e) {
                    return;
                }
                int size = this.j.size() + this.l.size();
                if (size >= x01Var.g()) {
                    x.a("MetadataImageReader", "Skip to acquire the next image because the acquired image count has reached the max images count.");
                    return;
                }
                do {
                    try {
                        vVarH = x01Var.h();
                        if (vVarH != null) {
                            this.c--;
                            size++;
                            this.j.put(vVarH.h0().c(), vVarH);
                            r();
                        }
                    } catch (IllegalStateException e) {
                        x.b("MetadataImageReader", "Failed to acquire next image.", e);
                        vVarH = null;
                    }
                    if (vVarH == null || this.c <= 0) {
                        break;
                    }
                } while (size < x01Var.g());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void t(cs csVar) {
        synchronized (this.a) {
            try {
                if (this.e) {
                    return;
                }
                this.i.put(csVar.c(), new ds(csVar));
                r();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    y(x01 x01Var) {
        this.a = new Object();
        this.b = new a();
        this.c = 0;
        this.d = new x01.a() { // from class: qj1
            @Override // x01.a
            public final void a(x01 x01Var2) {
                this.a.q(x01Var2);
            }
        };
        this.e = false;
        this.i = new LongSparseArray();
        this.j = new LongSparseArray();
        this.m = new ArrayList();
        this.f = x01Var;
        this.k = 0;
        this.l = new ArrayList(g());
    }
}
