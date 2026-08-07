package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends ng {
    private final String a;

    public e0(String str) {
        p31.f(str, "voiceTone");
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e0) && p31.a(this.a, ((e0) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "AIGlassesVoiceToneEvent(voiceTone=" + this.a + ")";
    }
}
