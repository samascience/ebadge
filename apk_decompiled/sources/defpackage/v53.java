package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public final class v53 {
    private String a;
    private String b;

    public v53(String str, String str2) {
        p31.f(str, "sourceContent");
        p31.f(str2, "targetContent");
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final void c(String str) {
        p31.f(str, "<set-?>");
        this.a = str;
    }

    public final void d(String str) {
        p31.f(str, "<set-?>");
        this.b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v53)) {
            return false;
        }
        v53 v53Var = (v53) obj;
        return p31.a(this.a, v53Var.a) && p31.a(this.b, v53Var.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "TranslationItem(sourceContent=" + this.a + ", targetContent=" + this.b + ")";
    }
}
