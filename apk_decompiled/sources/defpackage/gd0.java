package defpackage;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public abstract class gd0 implements qg2, e21 {
    protected final Drawable a;

    public gd0(Drawable drawable) {
        this.a = (Drawable) z42.d(drawable);
    }

    public void b() {
        Drawable drawable = this.a;
        if (drawable instanceof BitmapDrawable) {
            ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
        } else if (drawable instanceof au0) {
            ((au0) drawable).e().prepareToDraw();
        }
    }

    @Override // defpackage.qg2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Drawable get() {
        Drawable.ConstantState constantState = this.a.getConstantState();
        return constantState == null ? this.a : constantState.newDrawable();
    }
}
