package defpackage;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: loaded from: classes3.dex */
class pe3 implements qe3 {
    private final ViewOverlay a;

    pe3(View view) {
        this.a = view.getOverlay();
    }

    @Override // defpackage.qe3
    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // defpackage.qe3
    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }
}
