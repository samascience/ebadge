package kotlinx.coroutines.internal;

import defpackage.yq0;

/* JADX INFO: loaded from: classes4.dex */
public final class OnDemandAllocatingPoolKt {
    private static final int IS_CLOSED_MASK = Integer.MIN_VALUE;

    private static final Void loop(yq0 yq0Var) {
        while (true) {
            yq0Var.invoke();
        }
    }
}
