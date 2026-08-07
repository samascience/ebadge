package kotlinx.coroutines.debug.internal;

import defpackage.p31;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes4.dex */
public final class ConcurrentWeakMapKt {
    private static final int MAGIC = -1640531527;
    private static final int MIN_CAPACITY = 16;
    private static final Symbol REHASH = new Symbol("REHASH");
    private static final Marked MARKED_NULL = new Marked(null);
    private static final Marked MARKED_TRUE = new Marked(Boolean.TRUE);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Marked mark(Object obj) {
        if (obj == null) {
            return MARKED_NULL;
        }
        return p31.a(obj, Boolean.TRUE) ? MARKED_TRUE : new Marked(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void noImpl() {
        throw new UnsupportedOperationException("not implemented");
    }
}
