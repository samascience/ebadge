package org.libjpegturbo.turbojpeg;

/* JADX INFO: loaded from: classes4.dex */
public class TJScalingFactor {
    private int denom;
    private int num;

    public TJScalingFactor(int i, int i2) {
        this.num = 1;
        this.denom = 1;
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Numerator and denominator must be >= 1");
        }
        this.num = i;
        this.denom = i2;
    }

    public boolean equals(TJScalingFactor tJScalingFactor) {
        return this.num == tJScalingFactor.num && this.denom == tJScalingFactor.denom;
    }

    public int getDenom() {
        return this.denom;
    }

    public int getNum() {
        return this.num;
    }

    public int getScaled(int i) {
        int i2 = i * this.num;
        int i3 = this.denom;
        return ((i2 + i3) - 1) / i3;
    }

    public boolean isOne() {
        return this.num == 1 && this.denom == 1;
    }
}
