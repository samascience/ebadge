package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class ys0 {
    private String a;
    private boolean b = false;
    private int c = 0;

    public String a() {
        return this.a;
    }

    public Integer b() {
        if (d()) {
            try {
                return Integer.valueOf(Integer.parseInt(this.a));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        String str = this.a;
        return str != null && str.matches("^\\d+$");
    }

    public boolean e() {
        return this.b;
    }

    public void f(String str) {
        this.a = str;
    }

    public void g(boolean z) {
        this.b = z;
    }

    public void h(int i) {
        this.c = i;
    }

    public String toString() {
        return "GeneralResponse{imageUrl='" + this.a + "'}";
    }
}
