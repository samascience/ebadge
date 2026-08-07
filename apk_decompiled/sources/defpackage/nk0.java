package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class nk0 {
    private static final wn0 a = new wn0();
    private static final xn0 b = new xn0();

    public static float a(CharSequence charSequence) {
        return b(charSequence, 0, charSequence.length());
    }

    public static float b(CharSequence charSequence, int i, int i2) {
        long jE = b.e(charSequence, i, i2);
        if (jE != -1) {
            return Float.intBitsToFloat((int) jE);
        }
        throw new NumberFormatException("Illegal input");
    }
}
