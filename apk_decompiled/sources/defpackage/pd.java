package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class pd extends rt2.a {
    private final Throwable a;

    pd(Throwable th) {
        if (th == null) {
            throw new NullPointerException("Null error");
        }
        this.a = th;
    }

    @Override // rt2.a
    public Throwable a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof rt2.a) {
            return this.a.equals(((rt2.a) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ErrorWrapper{error=" + this.a + "}";
    }
}
