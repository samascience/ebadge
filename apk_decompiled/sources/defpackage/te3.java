package defpackage;

import android.util.Rational;

/* JADX INFO: loaded from: classes.dex */
public final class te3 {
    private int a;
    private Rational b;
    private int c;
    private int d;

    public static final class a {
        private final Rational b;
        private final int c;
        private int a = 1;
        private int d = 0;

        public a(Rational rational, int i) {
            this.b = rational;
            this.c = i;
        }

        public te3 a() {
            b52.h(this.b, "The crop aspect ratio must be set.");
            return new te3(this.a, this.b, this.c, this.d);
        }

        public a b(int i) {
            this.d = i;
            return this;
        }

        public a c(int i) {
            this.a = i;
            return this;
        }
    }

    te3(int i, Rational rational, int i2, int i3) {
        this.a = i;
        this.b = rational;
        this.c = i2;
        this.d = i3;
    }

    public Rational a() {
        return this.b;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.a;
    }
}
