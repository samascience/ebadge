package kotlinx.coroutines;

import defpackage.p31;
import defpackage.y70;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public final class CoroutineName extends kotlin.coroutines.a {
    public static final Key Key = new Key(null);
    private final String name;

    public static final class Key implements d.c {
        public /* synthetic */ Key(y70 y70Var) {
            this();
        }

        private Key() {
        }
    }

    public CoroutineName(String str) {
        super(Key);
        this.name = str;
    }

    public static /* synthetic */ CoroutineName copy$default(CoroutineName coroutineName, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = coroutineName.name;
        }
        return coroutineName.copy(str);
    }

    public final String component1() {
        return this.name;
    }

    public final CoroutineName copy(String str) {
        return new CoroutineName(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CoroutineName) && p31.a(this.name, ((CoroutineName) obj).name);
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "CoroutineName(" + this.name + ')';
    }
}
