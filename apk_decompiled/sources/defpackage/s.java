package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends ng {
    private final String a;

    public s(String str) {
        p31.f(str, "languageCode");
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s) && p31.a(this.a, ((s) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "AIGlassesLanguageEvent(languageCode=" + this.a + ")";
    }
}
