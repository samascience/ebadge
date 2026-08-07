package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class h82 {
    public final int a;
    public final Class b;
    public final String c;
    public final boolean d;
    public final String e;

    public h82(int i, Class cls, String str, boolean z, String str2) {
        this.a = i;
        this.b = cls;
        this.c = str;
        this.d = z;
        this.e = str2;
    }

    public gi3 a(Object obj, Object obj2) {
        return new gi3.b(this, " BETWEEN ? AND ?", new Object[]{obj, obj2});
    }

    public gi3 b(Object obj) {
        return new gi3.b(this, "=?", obj);
    }

    public gi3 c(Object... objArr) {
        StringBuilder sb = new StringBuilder(" IN (");
        ht2.g(sb, objArr.length).append(')');
        return new gi3.b(this, sb.toString(), objArr);
    }

    public gi3 d(Object obj) {
        return new gi3.b(this, "<>?", obj);
    }
}
