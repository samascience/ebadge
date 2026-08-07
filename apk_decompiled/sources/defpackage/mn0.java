package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class mn0 {
    private final int a;
    private final int[] b;
    private final nh2[] c;

    public mn0(int i, int[] iArr, int i2, int i3, int i4) {
        this.a = i;
        this.b = iArr;
        float f = i2;
        float f2 = i4;
        this.c = new nh2[]{new nh2(f, f2), new nh2(i3, f2)};
    }

    public nh2[] a() {
        return this.c;
    }

    public int[] b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof mn0) && this.a == ((mn0) obj).a;
    }

    public int hashCode() {
        return this.a;
    }
}
