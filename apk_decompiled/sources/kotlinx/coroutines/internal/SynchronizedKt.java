package kotlinx.coroutines.internal;

import defpackage.j21;
import defpackage.yq0;
import kotlinx.coroutines.InternalCoroutinesApi;

/* JADX INFO: loaded from: classes4.dex */
public final class SynchronizedKt {
    @InternalCoroutinesApi
    public static /* synthetic */ void SynchronizedObject$annotations() {
    }

    @InternalCoroutinesApi
    public static final <T> T synchronizedImpl(Object obj, yq0 yq0Var) {
        T t;
        synchronized (obj) {
            try {
                t = (T) yq0Var.invoke();
                j21.b(1);
            } finally {
                j21.b(1);
                j21.a(1);
            }
        }
        return t;
    }
}
