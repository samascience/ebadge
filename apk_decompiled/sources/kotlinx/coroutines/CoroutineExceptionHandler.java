package kotlinx.coroutines;

import defpackage.or0;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public interface CoroutineExceptionHandler extends d.b {
    public static final Key Key = Key.$$INSTANCE;

    public static final class DefaultImpls {
        public static <R> R fold(CoroutineExceptionHandler coroutineExceptionHandler, R r, or0 or0Var) {
            return (R) d.b.a.a(coroutineExceptionHandler, r, or0Var);
        }

        public static <E extends d.b> E get(CoroutineExceptionHandler coroutineExceptionHandler, d.c cVar) {
            return (E) d.b.a.b(coroutineExceptionHandler, cVar);
        }

        public static d minusKey(CoroutineExceptionHandler coroutineExceptionHandler, d.c cVar) {
            return d.b.a.c(coroutineExceptionHandler, cVar);
        }

        public static d plus(CoroutineExceptionHandler coroutineExceptionHandler, d dVar) {
            return d.b.a.d(coroutineExceptionHandler, dVar);
        }
    }

    public static final class Key implements d.c {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    @Override // kotlin.coroutines.d
    /* synthetic */ Object fold(Object obj, or0 or0Var);

    @Override // kotlin.coroutines.d.b, kotlin.coroutines.d
    /* synthetic */ d.b get(d.c cVar);

    @Override // kotlin.coroutines.d.b
    /* synthetic */ d.c getKey();

    void handleException(d dVar, Throwable th);

    @Override // kotlin.coroutines.d
    /* synthetic */ d minusKey(d.c cVar);

    @Override // kotlin.coroutines.d
    /* synthetic */ d plus(d dVar);
}
