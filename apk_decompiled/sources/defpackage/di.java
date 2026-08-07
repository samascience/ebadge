package defpackage;

import android.content.res.Resources;

/* JADX INFO: loaded from: classes.dex */
public class di implements ug2 {
    private final ug2 a;
    private final Resources b;

    public di(Resources resources, ug2 ug2Var) {
        this.b = (Resources) z42.d(resources);
        this.a = (ug2) z42.d(ug2Var);
    }

    @Override // defpackage.ug2
    public boolean a(Object obj, rx1 rx1Var) {
        return this.a.a(obj, rx1Var);
    }

    @Override // defpackage.ug2
    public qg2 b(Object obj, int i, int i2, rx1 rx1Var) {
        return ka1.d(this.b, this.a.b(obj, i, i2, rx1Var));
    }
}
