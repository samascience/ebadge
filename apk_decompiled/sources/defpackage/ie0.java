package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ie0 {
    public static final ie0 c = new ie0(0, 0);
    public static final ie0 d = new ie0(1, 8);
    public static final ie0 e = new ie0(2, 10);
    public static final ie0 f = new ie0(3, 10);
    public static final ie0 g = new ie0(4, 10);
    public static final ie0 h = new ie0(5, 10);
    public static final ie0 i = new ie0(6, 10);
    public static final ie0 j = new ie0(6, 8);
    private final int a;
    private final int b;

    public ie0(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    private static String c(int i2) {
        switch (i2) {
            case 0:
                return "UNSPECIFIED";
            case 1:
                return "SDR";
            case 2:
                return "HDR_UNSPECIFIED";
            case 3:
                return "HLG";
            case 4:
                return "HDR10";
            case 5:
                return "HDR10_PLUS";
            case 6:
                return "DOLBY_VISION";
            default:
                return "<Unknown>";
        }
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public boolean d() {
        return e() && b() != 1 && a() == 10;
    }

    public boolean e() {
        return (b() == 0 || b() == 2 || a() == 0) ? false : true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ie0)) {
            return false;
        }
        ie0 ie0Var = (ie0) obj;
        return this.a == ie0Var.b() && this.b == ie0Var.a();
    }

    public int hashCode() {
        return ((this.a ^ 1000003) * 1000003) ^ this.b;
    }

    public String toString() {
        return "DynamicRange@" + Integer.toHexString(System.identityHashCode(this)) + "{encoding=" + c(this.a) + ", bitDepth=" + this.b + "}";
    }
}
