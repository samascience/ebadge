package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class w90 extends ng {
    private final int a;
    private final int b;
    private final boolean c;

    public w90(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.c && (this.b & 1) != 0;
    }

    public boolean isValid() {
        return this.c;
    }

    public String toString() {
        return "DeviceCapabilityEvent{capVersion=0x" + Integer.toHexString(this.a) + ", mask0=0x" + Integer.toHexString(this.b) + ", valid=" + this.c + '}';
    }
}
