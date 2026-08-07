package defpackage;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class uk1 {
    private final AtomicReference a = new AtomicReference();
    private final u9 b = new u9();

    public List a(Class cls, Class cls2, Class cls3) {
        List list;
        gl1 gl1Var = (gl1) this.a.getAndSet(null);
        if (gl1Var == null) {
            gl1Var = new gl1(cls, cls2, cls3);
        } else {
            gl1Var.a(cls, cls2, cls3);
        }
        synchronized (this.b) {
            list = (List) this.b.get(gl1Var);
        }
        this.a.set(gl1Var);
        return list;
    }

    public void b(Class cls, Class cls2, Class cls3, List list) {
        synchronized (this.b) {
            this.b.put(new gl1(cls, cls2, cls3), list);
        }
    }
}
