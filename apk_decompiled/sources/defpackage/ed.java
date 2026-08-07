package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class ed extends az0 {
    private final Object a;

    ed(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null value");
        }
        this.a = obj;
    }

    @Override // defpackage.az0
    public Object b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof az0) {
            return this.a.equals(((az0) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Identifier{value=" + this.a + "}";
    }
}
