package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import com.jieli.jl_rcsp.constant.WatchConstant;

/* JADX INFO: loaded from: classes.dex */
public abstract class h71 {
    protected int a;
    protected int b;

    protected h71() {
    }

    public final int a() {
        int i = this.b;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public abstract String b();

    public abstract Object c();

    public final int d() {
        return this.b + 1;
    }

    public abstract h71 e();

    public boolean f() {
        return this.b >= 0;
    }

    public boolean g() {
        return b() != null;
    }

    public boolean h() {
        int i = this.a;
        if (i == 2) {
            return g();
        }
        if (i == 1) {
            return f();
        }
        return false;
    }

    public final boolean i() {
        return this.a == 1;
    }

    public final boolean j() {
        return this.a == 2;
    }

    public final boolean k() {
        return this.a == 0;
    }

    public abstract void l(Object obj);

    public String m() {
        int i = this.a;
        if (i == 0) {
            return "root";
        }
        if (i != 1) {
            return i != 2 ? "?" : "Object";
        }
        return "Array";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i = this.a;
        if (i == 0) {
            sb.append(WatchConstant.FAT_FS_ROOT);
        } else if (i != 1) {
            sb.append('{');
            String strB = b();
            if (strB != null) {
                sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                ex.a(sb, strB);
                sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            } else {
                sb.append('?');
            }
            sb.append('}');
        } else {
            sb.append('[');
            sb.append(a());
            sb.append(']');
        }
        return sb.toString();
    }

    protected h71(h71 h71Var) {
        this.a = h71Var.a;
        this.b = h71Var.b;
    }

    protected h71(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
