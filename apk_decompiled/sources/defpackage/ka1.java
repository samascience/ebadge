package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: loaded from: classes.dex */
public final class ka1 implements qg2, e21 {
    private final Resources a;
    private final qg2 b;

    private ka1(Resources resources, qg2 qg2Var) {
        this.a = (Resources) z42.d(resources);
        this.b = (qg2) z42.d(qg2Var);
    }

    public static qg2 d(Resources resources, qg2 qg2Var) {
        if (qg2Var == null) {
            return null;
        }
        return new ka1(resources, qg2Var);
    }

    @Override // defpackage.qg2
    public void a() {
        this.b.a();
    }

    @Override // defpackage.e21
    public void b() {
        qg2 qg2Var = this.b;
        if (qg2Var instanceof e21) {
            ((e21) qg2Var).b();
        }
    }

    @Override // defpackage.qg2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.a, (Bitmap) this.b.get());
    }

    @Override // defpackage.qg2
    public int o() {
        return this.b.o();
    }

    @Override // defpackage.qg2
    public Class p() {
        return BitmapDrawable.class;
    }
}
