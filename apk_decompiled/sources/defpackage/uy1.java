package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public final class uy1 implements ux {
    private final Class a;
    private final String b;

    public uy1(Class cls, String str) {
        p31.f(cls, "jClass");
        p31.f(str, "moduleName");
        this.a = cls;
        this.b = str;
    }

    @Override // defpackage.ux
    public Class c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof uy1) && p31.a(c(), ((uy1) obj).c());
    }

    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c() + " (Kotlin reflection is not available)";
    }
}
