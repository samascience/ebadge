package defpackage;

import androidx.recyclerview.widget.CompatItemTouchHelper;

/* JADX INFO: loaded from: classes.dex */
public class b80 extends CompatItemTouchHelper {
    private c80 a;

    public b80() {
        this(new c80());
    }

    public void a(boolean z) {
        this.a.a(z);
    }

    public void b(boolean z) {
        this.a.b(z);
    }

    public void c(hv1 hv1Var) {
        this.a.c(hv1Var);
    }

    public void d(iv1 iv1Var) {
        this.a.d(iv1Var);
    }

    public void e(lv1 lv1Var) {
        this.a.e(lv1Var);
    }

    private b80(c80 c80Var) {
        super(c80Var);
        this.a = (c80) getCallback();
    }
}
