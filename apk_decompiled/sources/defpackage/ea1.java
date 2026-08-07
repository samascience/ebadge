package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public final class ea1 {
    private final String a;
    private final String b;

    public ea1(String str, String str2) {
        p31.f(str, "sourceLanguageName");
        p31.f(str2, "targetLanguageName");
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ea1)) {
            return false;
        }
        ea1 ea1Var = (ea1) obj;
        return p31.a(this.a, ea1Var.a) && p31.a(this.b, ea1Var.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "LanguageItem(sourceLanguageName=" + this.a + ", targetLanguageName=" + this.b + ")";
    }
}
