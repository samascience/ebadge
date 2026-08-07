package kotlin.coroutines;

import defpackage.p31;
import defpackage.x30;

/* JADX INFO: loaded from: classes4.dex */
public interface c extends d.b {
    public static final b E = b.a;

    public static final class a {
        public static d.b a(c cVar, d.c cVar2) {
            d.b bVarTryCast$kotlin_stdlib;
            p31.f(cVar2, "key");
            if (!(cVar2 instanceof kotlin.coroutines.b)) {
                if (c.E != cVar2) {
                    return null;
                }
                p31.d(cVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return cVar;
            }
            kotlin.coroutines.b bVar = (kotlin.coroutines.b) cVar2;
            if (!bVar.isSubKey$kotlin_stdlib(cVar.getKey()) || (bVarTryCast$kotlin_stdlib = bVar.tryCast$kotlin_stdlib(cVar)) == null) {
                return null;
            }
            return bVarTryCast$kotlin_stdlib;
        }

        public static d b(c cVar, d.c cVar2) {
            p31.f(cVar2, "key");
            if (!(cVar2 instanceof kotlin.coroutines.b)) {
                return c.E == cVar2 ? EmptyCoroutineContext.INSTANCE : cVar;
            }
            kotlin.coroutines.b bVar = (kotlin.coroutines.b) cVar2;
            return (!bVar.isSubKey$kotlin_stdlib(cVar.getKey()) || bVar.tryCast$kotlin_stdlib(cVar) == null) ? cVar : EmptyCoroutineContext.INSTANCE;
        }
    }

    public static final class b implements d.c {
        static final /* synthetic */ b a = new b();

        private b() {
        }
    }

    x30 interceptContinuation(x30 x30Var);

    void releaseInterceptedContinuation(x30 x30Var);
}
