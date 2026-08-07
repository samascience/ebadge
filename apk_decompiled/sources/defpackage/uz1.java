package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: loaded from: classes.dex */
public abstract class uz1 {

    private static final class a extends BasePendingResult {
        private final jh2 o;

        public a(c cVar, jh2 jh2Var) {
            super(cVar);
            this.o = jh2Var;
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        protected final jh2 g(Status status) {
            return this.o;
        }
    }

    public static tz1 a(jh2 jh2Var, c cVar) {
        a52.h(jh2Var, "Result must not be null");
        a52.b(!jh2Var.n().K0(), "Status code must not be SUCCESS");
        a aVar = new a(cVar, jh2Var);
        aVar.j(jh2Var);
        return aVar;
    }
}
