package kotlin.enums;

import defpackage.p31;
import defpackage.y70;
import java.io.Serializable;
import java.lang.Enum;

/* JADX INFO: loaded from: classes4.dex */
public final class EnumEntriesSerializationProxy<E extends Enum<E>> implements Serializable {
    private static final a Companion = new a(null);
    private static final long serialVersionUID = 0;
    private final Class<E> c;

    private static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public EnumEntriesSerializationProxy(E[] eArr) {
        p31.f(eArr, "entries");
        Class<E> cls = (Class<E>) eArr.getClass().getComponentType();
        p31.c(cls);
        this.c = cls;
    }

    private final Object readResolve() {
        E[] enumConstants = this.c.getEnumConstants();
        p31.e(enumConstants, "getEnumConstants(...)");
        return kotlin.enums.a.a(enumConstants);
    }
}
