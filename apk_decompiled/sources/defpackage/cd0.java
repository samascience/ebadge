package defpackage;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class cd0 implements ah2 {
    private final oi a;
    private final ah2 b;
    private final ah2 c;

    public cd0(oi oiVar, ah2 ah2Var, ah2 ah2Var2) {
        this.a = oiVar;
        this.b = ah2Var;
        this.c = ah2Var2;
    }

    private static qg2 b(qg2 qg2Var) {
        return qg2Var;
    }

    @Override // defpackage.ah2
    public qg2 a(qg2 qg2Var, rx1 rx1Var) {
        Drawable drawable = (Drawable) qg2Var.get();
        if (drawable instanceof BitmapDrawable) {
            return this.b.a(qi.d(((BitmapDrawable) drawable).getBitmap(), this.a), rx1Var);
        }
        if (drawable instanceof au0) {
            return this.c.a(b(qg2Var), rx1Var);
        }
        return null;
    }
}
