package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import defpackage.n01;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class l implements v {
    protected final v b;
    private final Object a = new Object();
    private final Set c = new HashSet();

    public interface a {
        void b(v vVar);
    }

    protected l(v vVar) {
        this.b = vVar;
    }

    @Override // androidx.camera.core.v, java.lang.AutoCloseable
    public void close() {
        this.b.close();
        u();
    }

    @Override // androidx.camera.core.v
    public void d0(Rect rect) {
        this.b.d0(rect);
    }

    @Override // androidx.camera.core.v
    public int getHeight() {
        return this.b.getHeight();
    }

    @Override // androidx.camera.core.v
    public int getWidth() {
        return this.b.getWidth();
    }

    @Override // androidx.camera.core.v
    public n01 h0() {
        return this.b.h0();
    }

    public void n(a aVar) {
        synchronized (this.a) {
            this.c.add(aVar);
        }
    }

    @Override // androidx.camera.core.v
    public int q() {
        return this.b.q();
    }

    @Override // androidx.camera.core.v
    public v.a[] r() {
        return this.b.r();
    }

    @Override // androidx.camera.core.v
    public Image s0() {
        return this.b.s0();
    }

    protected void u() {
        HashSet hashSet;
        synchronized (this.a) {
            hashSet = new HashSet(this.c);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(this);
        }
    }
}
