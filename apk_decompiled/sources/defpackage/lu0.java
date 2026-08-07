package defpackage;

import android.content.Context;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes4.dex */
public abstract class lu0 extends nl2 {
    protected final OverScroller a;

    public lu0(Context context) {
        this.a = new OverScroller(context);
    }

    @Override // defpackage.nl2
    public void b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.a.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    @Override // defpackage.nl2
    public void c(boolean z) {
        this.a.forceFinished(z);
    }

    @Override // defpackage.nl2
    public int d() {
        return this.a.getCurrX();
    }

    @Override // defpackage.nl2
    public int e() {
        return this.a.getCurrY();
    }

    @Override // defpackage.nl2
    public boolean g() {
        return this.a.isFinished();
    }
}
