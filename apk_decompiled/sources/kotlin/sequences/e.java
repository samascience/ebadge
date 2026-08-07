package kotlin.sequences;

import defpackage.or0;
import defpackage.p31;
import defpackage.rm2;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e {

    public static final class a implements rm2 {
        final /* synthetic */ or0 a;

        public a(or0 or0Var) {
            this.a = or0Var;
        }

        @Override // defpackage.rm2
        public Iterator iterator() {
            return e.a(this.a);
        }
    }

    public static final Iterator a(or0 or0Var) {
        p31.f(or0Var, "block");
        c cVar = new c();
        cVar.f(kotlin.coroutines.intrinsics.a.b(or0Var, cVar, cVar));
        return cVar;
    }

    public static rm2 b(or0 or0Var) {
        p31.f(or0Var, "block");
        return new a(or0Var);
    }
}
