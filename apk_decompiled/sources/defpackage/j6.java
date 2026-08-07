package defpackage;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class j6 implements u6 {
    private final List a;

    public j6() {
        this.a = Collections.singletonList(new k91(new PointF(0.0f, 0.0f)));
    }

    @Override // defpackage.u6
    public tg a() {
        return ((k91) this.a.get(0)).d() ? new z32(this.a) : new lz1(this.a);
    }

    public j6(List list) {
        this.a = list;
    }
}
