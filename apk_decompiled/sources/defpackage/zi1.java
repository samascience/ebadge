package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class zi1 {

    public static abstract class a {
        public String toString() {
            return "MessageContentBase.MessageContentBaseBuilder()";
        }
    }

    protected zi1(a aVar) {
    }

    protected abstract boolean a(Object obj);

    public abstract String b();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof zi1) && ((zi1) obj).a(this);
    }

    public int hashCode() {
        return 1;
    }
}
