package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public class fw2 implements iy0 {
    volatile boolean a = false;
    final Map b = new ConcurrentHashMap();
    final LinkedBlockingQueue c = new LinkedBlockingQueue();

    @Override // defpackage.iy0
    public synchronized hd1 a(String str) {
        ew2 ew2Var;
        ew2Var = (ew2) this.b.get(str);
        if (ew2Var == null) {
            ew2Var = new ew2(str, this.c, this.a);
            this.b.put(str, ew2Var);
        }
        return ew2Var;
    }

    public void b() {
        this.b.clear();
        this.c.clear();
    }

    public LinkedBlockingQueue c() {
        return this.c;
    }

    public List d() {
        return new ArrayList(this.b.values());
    }

    public void e() {
        this.a = true;
    }
}
