package defpackage;

import android.graphics.Path;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bo2 extends tg {
    private final vn2 g;
    private final Path h;

    public bo2(List list) {
        super(list);
        this.g = new vn2();
        this.h = new Path();
    }

    @Override // defpackage.tg
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Path i(k91 k91Var, float f) {
        this.g.c((vn2) k91Var.b, (vn2) k91Var.c, f);
        ok1.h(this.g, this.h);
        return this.h;
    }
}
