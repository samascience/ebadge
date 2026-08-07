package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class kk0 {
    private static final tc0 a = new tc0();
    private static final uc0 b = new uc0();

    public static double a(CharSequence charSequence) {
        return b(charSequence, 0, charSequence.length());
    }

    public static double b(CharSequence charSequence, int i, int i2) {
        long jE = b.e(charSequence, i, i2);
        if (jE != -1) {
            return Double.longBitsToDouble(jE);
        }
        throw new NumberFormatException("Illegal input");
    }
}
