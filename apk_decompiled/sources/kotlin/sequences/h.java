package kotlin.sequences;

import defpackage.ar0;
import defpackage.j20;
import defpackage.p31;
import defpackage.rm2;
import defpackage.yq0;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h extends f {

    public static final class a implements rm2 {
        final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        @Override // defpackage.rm2
        public Iterator iterator() {
            return this.a;
        }
    }

    public static rm2 d(Iterator it) {
        p31.f(it, "<this>");
        return e(new a(it));
    }

    public static final rm2 e(rm2 rm2Var) {
        p31.f(rm2Var, "<this>");
        return rm2Var instanceof j20 ? rm2Var : new j20(rm2Var);
    }

    public static rm2 f() {
        return kotlin.sequences.a.a;
    }

    public static rm2 g(yq0 yq0Var, ar0 ar0Var) {
        p31.f(yq0Var, "seedFunction");
        p31.f(ar0Var, "nextFunction");
        return new b(yq0Var, ar0Var);
    }

    public static rm2 h(final Object obj, ar0 ar0Var) {
        p31.f(ar0Var, "nextFunction");
        return obj == null ? kotlin.sequences.a.a : new b(new yq0() { // from class: kotlin.sequences.g
            @Override // defpackage.yq0
            public final Object invoke() {
                return h.i(obj);
            }
        }, ar0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object i(Object obj) {
        return obj;
    }
}
