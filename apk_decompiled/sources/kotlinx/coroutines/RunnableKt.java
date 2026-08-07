package kotlinx.coroutines;

import defpackage.yq0;

/* JADX INFO: loaded from: classes4.dex */
public final class RunnableKt {
    public static final Runnable Runnable(final yq0 yq0Var) {
        return new Runnable() { // from class: kotlinx.coroutines.RunnableKt.Runnable.1
            @Override // java.lang.Runnable
            public final void run() {
                yq0Var.invoke();
            }
        };
    }
}
