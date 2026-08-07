package kotlin.uuid;

import defpackage.or0;
import defpackage.p31;
import defpackage.v73;
import defpackage.y70;
import java.io.Serializable;
import java.util.Comparator;
import kotlin.text.i;
import kotlin.uuid.Uuid;

/* JADX INFO: loaded from: classes4.dex */
public final class Uuid implements Serializable {
    public static final int SIZE_BITS = 128;
    public static final int SIZE_BYTES = 16;
    private final long leastSignificantBits;
    private final long mostSignificantBits;
    public static final a Companion = new a(null);
    private static final Uuid NIL = new Uuid(0, 0);
    private static final Comparator<Uuid> LEXICAL_ORDER = new Comparator() { // from class: za3
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Uuid.LEXICAL_ORDER$lambda$0((Uuid) obj, (Uuid) obj2);
        }
    };

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final Uuid a(long j, long j2) {
            return (j == 0 && j2 == 0) ? b() : new Uuid(j, j2);
        }

        public final Uuid b() {
            return Uuid.NIL;
        }

        private a() {
        }
    }

    public Uuid(long j, long j2) {
        this.mostSignificantBits = j;
        this.leastSignificantBits = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int LEXICAL_ORDER$lambda$0(Uuid uuid, Uuid uuid2) {
        p31.f(uuid, "a");
        p31.f(uuid2, "b");
        long j = uuid.mostSignificantBits;
        return j != uuid2.mostSignificantBits ? Long.compareUnsigned(v73.b(j), v73.b(uuid2.mostSignificantBits)) : Long.compareUnsigned(v73.b(uuid.leastSignificantBits), v73.b(uuid2.leastSignificantBits));
    }

    public static /* synthetic */ void getLeastSignificantBits$annotations() {
    }

    public static /* synthetic */ void getMostSignificantBits$annotations() {
    }

    private final <T> T toLongs(or0 or0Var) {
        p31.f(or0Var, "action");
        return (T) or0Var.invoke(Long.valueOf(getMostSignificantBits()), Long.valueOf(getLeastSignificantBits()));
    }

    private final <T> T toULongs(or0 or0Var) {
        p31.f(or0Var, "action");
        return (T) or0Var.invoke(v73.a(v73.b(getMostSignificantBits())), v73.a(v73.b(getLeastSignificantBits())));
    }

    private final Object writeReplace() {
        return kotlin.uuid.a.a(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uuid)) {
            return false;
        }
        Uuid uuid = (Uuid) obj;
        return this.mostSignificantBits == uuid.mostSignificantBits && this.leastSignificantBits == uuid.leastSignificantBits;
    }

    public final long getLeastSignificantBits() {
        return this.leastSignificantBits;
    }

    public final long getMostSignificantBits() {
        return this.mostSignificantBits;
    }

    public int hashCode() {
        long j = this.mostSignificantBits ^ this.leastSignificantBits;
        return ((int) j) ^ ((int) (j >> 32));
    }

    public final byte[] toByteArray() {
        byte[] bArr = new byte[16];
        b.e(this.mostSignificantBits, bArr, 0);
        b.e(this.leastSignificantBits, bArr, 8);
        return bArr;
    }

    public final String toHexString() {
        byte[] bArr = new byte[32];
        b.d(this.leastSignificantBits, bArr, 16, 8);
        b.d(this.mostSignificantBits, bArr, 0, 8);
        return i.s(bArr);
    }

    public String toString() {
        byte[] bArr = new byte[36];
        b.d(this.leastSignificantBits, bArr, 24, 6);
        bArr[23] = 45;
        b.d(this.leastSignificantBits >>> 48, bArr, 19, 2);
        bArr[18] = 45;
        b.d(this.mostSignificantBits, bArr, 14, 2);
        bArr[13] = 45;
        b.d(this.mostSignificantBits >>> 16, bArr, 9, 2);
        bArr[8] = 45;
        b.d(this.mostSignificantBits >>> 32, bArr, 0, 4);
        return i.s(bArr);
    }
}
