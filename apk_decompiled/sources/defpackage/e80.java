package defpackage;

import java.util.List;
import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes4.dex */
public class e80 implements md1 {
    hd1 a;
    Level b;
    String c;
    List d;
    List e;
    Throwable f;

    public e80(Level level, hd1 hd1Var) {
        this.a = hd1Var;
        this.b = level;
    }

    @Override // defpackage.md1
    public String a() {
        return this.c;
    }

    @Override // defpackage.md1
    public Object[] b() {
        List list = this.e;
        if (list == null) {
            return null;
        }
        return list.toArray();
    }

    @Override // defpackage.md1
    public Level c() {
        return this.b;
    }

    @Override // defpackage.md1
    public List d() {
        return this.d;
    }

    @Override // defpackage.md1
    public Throwable e() {
        return this.f;
    }
}
