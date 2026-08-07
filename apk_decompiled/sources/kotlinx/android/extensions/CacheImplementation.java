package kotlinx.android.extensions;

import defpackage.vh0;
import defpackage.y70;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 kotlinx.android.extensions.CacheImplementation, still in use, count: 1, list:
  (r0v1 kotlinx.android.extensions.CacheImplementation) from 0x0032: SPUT (r0v1 kotlinx.android.extensions.CacheImplementation) kotlinx.android.extensions.CacheImplementation.DEFAULT kotlinx.android.extensions.CacheImplementation
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
public final class CacheImplementation {
    SPARSE_ARRAY,
    HASH_MAP,
    NO_CACHE;

    private static final /* synthetic */ vh0 $ENTRIES = kotlin.enums.a.a(values());
    public static final a Companion = new a(null);
    private static final CacheImplementation DEFAULT = new CacheImplementation();

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    static {
    }

    private CacheImplementation() {
        super(str, i);
    }

    public static vh0 getEntries() {
        return $ENTRIES;
    }

    public static CacheImplementation valueOf(String str) {
        return (CacheImplementation) Enum.valueOf(CacheImplementation.class, str);
    }

    public static CacheImplementation[] values() {
        return (CacheImplementation[]) $VALUES.clone();
    }
}
