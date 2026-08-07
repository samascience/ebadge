package kotlin.contracts;

import defpackage.vh0;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes4.dex */
public enum InvocationKind {
    AT_MOST_ONCE,
    AT_LEAST_ONCE,
    EXACTLY_ONCE,
    UNKNOWN;

    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());

    public static vh0 getEntries() {
        return $ENTRIES;
    }
}
