package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes.dex */
final class c extends Config.a {
    private final String a;
    private final Class b;
    private final Object c;

    c(String str, Class cls, Object obj) {
        if (str == null) {
            throw new NullPointerException("Null id");
        }
        this.a = str;
        if (cls == null) {
            throw new NullPointerException("Null valueClass");
        }
        this.b = cls;
        this.c = obj;
    }

    @Override // androidx.camera.core.impl.Config.a
    public String c() {
        return this.a;
    }

    @Override // androidx.camera.core.impl.Config.a
    public Object d() {
        return this.c;
    }

    @Override // androidx.camera.core.impl.Config.a
    public Class e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Config.a)) {
            return false;
        }
        Config.a aVar = (Config.a) obj;
        if (this.a.equals(aVar.c()) && this.b.equals(aVar.e())) {
            Object obj2 = this.c;
            if (obj2 == null) {
                if (aVar.d() == null) {
                    return true;
                }
            } else if (obj2.equals(aVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        Object obj = this.c;
        return iHashCode ^ (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "Option{id=" + this.a + ", valueClass=" + this.b + ", token=" + this.c + "}";
    }
}
