package androidx.emoji2.text.flatbuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class Utf8 {
    private static Utf8 a;

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    public static Utf8 a() {
        if (a == null) {
            a = new Utf8Safe();
        }
        return a;
    }
}
