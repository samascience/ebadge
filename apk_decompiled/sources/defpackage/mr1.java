package defpackage;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
final class mr1 extends gd0 {
    private mr1(Drawable drawable) {
        super(drawable);
    }

    static qg2 d(Drawable drawable) {
        if (drawable != null) {
            return new mr1(drawable);
        }
        return null;
    }

    @Override // defpackage.qg2
    public void a() {
    }

    @Override // defpackage.qg2
    public int o() {
        return Math.max(1, this.a.getIntrinsicWidth() * this.a.getIntrinsicHeight() * 4);
    }

    @Override // defpackage.qg2
    public Class p() {
        return this.a.getClass();
    }
}
