package defpackage;

import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.load.engine.o;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class ec1 {
    private static final o c = new o(Object.class, Object.class, Object.class, Collections.singletonList(new g(Object.class, Object.class, Object.class, Collections.emptyList(), new p83(), null)), null);
    private final u9 a = new u9();
    private final AtomicReference b = new AtomicReference();

    private gl1 b(Class cls, Class cls2, Class cls3) {
        gl1 gl1Var = (gl1) this.b.getAndSet(null);
        if (gl1Var == null) {
            gl1Var = new gl1();
        }
        gl1Var.a(cls, cls2, cls3);
        return gl1Var;
    }

    public o a(Class cls, Class cls2, Class cls3) {
        o oVar;
        gl1 gl1VarB = b(cls, cls2, cls3);
        synchronized (this.a) {
            oVar = (o) this.a.get(gl1VarB);
        }
        this.b.set(gl1VarB);
        return oVar;
    }

    public boolean c(o oVar) {
        return c.equals(oVar);
    }

    public void d(Class cls, Class cls2, Class cls3, o oVar) {
        synchronized (this.a) {
            u9 u9Var = this.a;
            gl1 gl1Var = new gl1(cls, cls2, cls3);
            if (oVar == null) {
                oVar = c;
            }
            u9Var.put(gl1Var, oVar);
        }
    }
}
