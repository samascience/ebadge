package defpackage;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;

/* JADX INFO: loaded from: classes.dex */
public final class k11 extends DeferrableSurface {
    private final Surface o;

    public k11(Surface surface, Size size, int i) {
        super(size, i);
        this.o = surface;
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    public ub1 r() {
        return os0.p(this.o);
    }

    public k11(Surface surface) {
        this.o = surface;
    }
}
