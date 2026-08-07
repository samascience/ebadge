package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import defpackage.n01;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends l {
    private final Object d;
    private final n01 e;
    private Rect f;
    private final int g;
    private final int h;

    c0(v vVar, n01 n01Var) {
        this(vVar, null, n01Var);
    }

    @Override // androidx.camera.core.l, androidx.camera.core.v
    public void d0(Rect rect) {
        if (rect != null) {
            Rect rect2 = new Rect(rect);
            if (!rect2.intersect(0, 0, getWidth(), getHeight())) {
                rect2.setEmpty();
            }
            rect = rect2;
        }
        synchronized (this.d) {
            this.f = rect;
        }
    }

    @Override // androidx.camera.core.l, androidx.camera.core.v
    public int getHeight() {
        return this.h;
    }

    @Override // androidx.camera.core.l, androidx.camera.core.v
    public int getWidth() {
        return this.g;
    }

    @Override // androidx.camera.core.l, androidx.camera.core.v
    public n01 h0() {
        return this.e;
    }

    public c0(v vVar, Size size, n01 n01Var) {
        super(vVar);
        this.d = new Object();
        if (size == null) {
            this.g = super.getWidth();
            this.h = super.getHeight();
        } else {
            this.g = size.getWidth();
            this.h = size.getHeight();
        }
        this.e = n01Var;
    }
}
