package defpackage;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public final class d31 extends b31 {
    private final int a;
    private final int b;
    private boolean c;
    private int d;

    public d31(int i, int i2, int i3) {
        this.a = i3;
        this.b = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.c = z;
        this.d = z ? i : i2;
    }

    @Override // defpackage.b31
    public int a() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.a + i;
        } else {
            if (!this.c) {
                throw new NoSuchElementException();
            }
            this.c = false;
        }
        return i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }
}
