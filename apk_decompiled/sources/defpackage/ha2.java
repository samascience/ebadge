package defpackage;

/* JADX INFO: loaded from: classes4.dex */
abstract class ha2 {
    public static final void a(boolean z, Number number) {
        p31.f(number, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }
}
