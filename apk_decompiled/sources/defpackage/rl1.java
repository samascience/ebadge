package defpackage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class rl1 extends e63 {
    @Override // defpackage.e63
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public ql1 b(a71 a71Var) {
        Map map = (Map) t71.a.fromJson(a71Var, Map.class);
        ql1 ql1Var = new ql1();
        if (map.containsKey("role")) {
            ql1Var.e((String) map.get("role"));
            map.remove("role");
        }
        if (map.containsKey("content")) {
            ql1Var.d((List) map.get("content"));
            map.remove("content");
        }
        return ql1Var;
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(a81 a81Var, ql1 ql1Var) throws IOException {
        a81Var.y();
        a81Var.k0("role");
        a81Var.P0(ql1Var.c());
        a81Var.k0("content");
        a81Var.w();
        Iterator it = ql1Var.b.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            a81Var.y();
            throw null;
        }
        a81Var.D();
        a81Var.V();
    }
}
