package defpackage;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class oi2 {
    private final List a = new CopyOnWriteArrayList();
    private volatile boolean b = false;

    public void a(ni2 ni2Var) {
        if (ni2Var == null) {
            throw new NullPointerException("Cannot add a null listener");
        }
        this.a.add(b(ni2Var));
    }

    ni2 b(ni2 ni2Var) {
        return ni2Var.getClass().isAnnotationPresent(ni2.a.class) ? ni2Var : new zy2(ni2Var, this);
    }
}
