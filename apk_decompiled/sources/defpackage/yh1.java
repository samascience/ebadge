package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
class yh1 implements uh1 {
    private String a;
    private int b;
    private int c;

    yh1(String str, int i, int i2) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yh1)) {
            return false;
        }
        yh1 yh1Var = (yh1) obj;
        return TextUtils.equals(this.a, yh1Var.a) && this.b == yh1Var.b && this.c == yh1Var.c;
    }

    public int hashCode() {
        return tt1.b(this.a, Integer.valueOf(this.b), Integer.valueOf(this.c));
    }
}
