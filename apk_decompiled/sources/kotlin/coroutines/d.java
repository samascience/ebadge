package kotlin.coroutines;

import defpackage.or0;
import defpackage.p31;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public interface d {

    public static final class a {
        public static d b(d dVar, d dVar2) {
            p31.f(dVar2, "context");
            return dVar2 == EmptyCoroutineContext.INSTANCE ? dVar : (d) dVar2.fold(dVar, new or0() { // from class: n40
                @Override // defpackage.or0
                public final Object invoke(Object obj, Object obj2) {
                    return d.a.c((d) obj, (d.b) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static d c(d dVar, b bVar) {
            CombinedContext combinedContext;
            p31.f(dVar, "acc");
            p31.f(bVar, "element");
            d dVarMinusKey = dVar.minusKey(bVar.getKey());
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
            if (dVarMinusKey == emptyCoroutineContext) {
                return bVar;
            }
            kotlin.coroutines.c.b bVar2 = kotlin.coroutines.c.E;
            kotlin.coroutines.c cVar = (kotlin.coroutines.c) dVarMinusKey.get(bVar2);
            if (cVar == null) {
                combinedContext = new CombinedContext(dVarMinusKey, bVar);
            } else {
                d dVarMinusKey2 = dVarMinusKey.minusKey(bVar2);
                if (dVarMinusKey2 == emptyCoroutineContext) {
                    return new CombinedContext(bVar, cVar);
                }
                combinedContext = new CombinedContext(new CombinedContext(dVarMinusKey2, bVar), cVar);
            }
            return combinedContext;
        }
    }

    public interface b extends d {

        public static final class a {
            public static Object a(b bVar, Object obj, or0 or0Var) {
                p31.f(or0Var, "operation");
                return or0Var.invoke(obj, bVar);
            }

            public static b b(b bVar, c cVar) {
                p31.f(cVar, "key");
                if (!p31.a(bVar.getKey(), cVar)) {
                    return null;
                }
                p31.d(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static d c(b bVar, c cVar) {
                p31.f(cVar, "key");
                return p31.a(bVar.getKey(), cVar) ? EmptyCoroutineContext.INSTANCE : bVar;
            }

            public static d d(b bVar, d dVar) {
                p31.f(dVar, "context");
                return a.b(bVar, dVar);
            }
        }

        @Override // kotlin.coroutines.d
        b get(c cVar);

        c getKey();
    }

    public interface c {
    }

    Object fold(Object obj, or0 or0Var);

    b get(c cVar);

    d minusKey(c cVar);

    d plus(d dVar);
}
