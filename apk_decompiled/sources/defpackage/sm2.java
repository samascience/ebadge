package defpackage;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.a;

/* JADX INFO: loaded from: classes4.dex */
public abstract class sm2 {
    public abstract Object a(Object obj, x30 x30Var);

    public final Object b(rm2 rm2Var, x30 x30Var) {
        Object objC = c(rm2Var.iterator(), x30Var);
        return objC == a.d() ? objC : k83.a;
    }

    public abstract Object c(Iterator it, x30 x30Var);
}
