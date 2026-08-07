package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class sa1 {
    public static int a(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        throw new IllegalArgumentException("The given lens facing integer: " + i + " can not be recognized.");
    }
}
