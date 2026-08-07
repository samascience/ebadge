package defpackage;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class rg2 implements ug2 {
    private final wg2 a;
    private final oi b;

    public rg2(wg2 wg2Var, oi oiVar) {
        this.a = wg2Var;
        this.b = oiVar;
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public qg2 b(Uri uri, int i, int i2, rx1 rx1Var) {
        qg2 qg2VarB = this.a.b(uri, i, i2, rx1Var);
        if (qg2VarB == null) {
            return null;
        }
        return hd0.a(this.b, (Drawable) qg2VarB.get(), i, i2);
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri, rx1 rx1Var) {
        return "android.resource".equals(uri.getScheme());
    }
}
