package defpackage;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class ss2 extends tg {
    private final PointF g;
    private final tg h;
    private final tg i;

    public ss2(tg tgVar, tg tgVar2) {
        super(Collections.emptyList());
        this.g = new PointF();
        this.h = tgVar;
        this.i = tgVar2;
        l(f());
    }

    @Override // defpackage.tg
    public void l(float f) {
        this.h.l(f);
        this.i.l(f);
        this.g.set(((Float) this.h.h()).floatValue(), ((Float) this.i.h()).floatValue());
        for (int i = 0; i < this.a.size(); i++) {
            ((tg.a) this.a.get(i)).a();
        }
    }

    @Override // defpackage.tg
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.tg
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public PointF i(k91 k91Var, float f) {
        return this.g;
    }
}
