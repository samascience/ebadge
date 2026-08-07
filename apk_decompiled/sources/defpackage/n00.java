package defpackage;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class n00 {
    private int a;
    private String b;
    private String c;
    private int d;
    private int e;

    public n00(int i, String str, String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    private boolean a() {
        return this.b.equals(this.c);
    }

    private String c(String str) {
        String str2 = "[" + str.substring(this.d, (str.length() - this.e) + 1) + "]";
        if (this.d > 0) {
            str2 = d() + str2;
        }
        if (this.e <= 0) {
            return str2;
        }
        return str2 + e();
    }

    private String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d > this.a ? "..." : Constants.STR_EMPTY);
        sb.append(this.b.substring(Math.max(0, this.d - this.a), this.d));
        return sb.toString();
    }

    private String e() {
        int iMin = Math.min((this.b.length() - this.e) + 1 + this.a, this.b.length());
        StringBuilder sb = new StringBuilder();
        String str = this.b;
        sb.append(str.substring((str.length() - this.e) + 1, iMin));
        sb.append((this.b.length() - this.e) + 1 < this.b.length() - this.a ? "..." : Constants.STR_EMPTY);
        return sb.toString();
    }

    private void f() {
        this.d = 0;
        int iMin = Math.min(this.b.length(), this.c.length());
        while (true) {
            int i = this.d;
            if (i >= iMin || this.b.charAt(i) != this.c.charAt(this.d)) {
                return;
            } else {
                this.d++;
            }
        }
    }

    private void g() {
        int length = this.b.length() - 1;
        int length2 = this.c.length() - 1;
        while (true) {
            int i = this.d;
            if (length2 < i || length < i || this.b.charAt(length) != this.c.charAt(length2)) {
                break;
            }
            length2--;
            length--;
        }
        this.e = this.b.length() - length;
    }

    public String b(String str) {
        if (this.b == null || this.c == null || a()) {
            return sa.a(str, this.b, this.c);
        }
        f();
        g();
        return sa.a(str, c(this.b), c(this.c));
    }
}
