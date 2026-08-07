package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.DaoException;

/* JADX INFO: loaded from: classes4.dex */
public class u92 {
    public static boolean k;
    public static boolean l;
    private final fi3 a;
    private StringBuilder b;
    private final List c;
    private final List d;
    private final y0 e;
    private final String f;
    private Integer g;
    private Integer h;
    private boolean i;
    private String j;

    protected u92(y0 y0Var) {
        this(y0Var, "T");
    }

    private void b(StringBuilder sb, String str) {
        this.c.clear();
        Iterator it = this.d.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            sb.append(" JOIN ");
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            throw null;
        }
        if (!this.a.e()) {
            sb.append(" WHERE ");
            this.a.b(sb, str, this.c);
        }
        Iterator it2 = this.d.iterator();
        if (it2.hasNext()) {
            e43.a(it2.next());
            throw null;
        }
    }

    private int e(StringBuilder sb) {
        if (this.g == null) {
            return -1;
        }
        sb.append(" LIMIT ?");
        this.c.add(this.g);
        return this.c.size() - 1;
    }

    private int f(StringBuilder sb) {
        if (this.h == null) {
            return -1;
        }
        if (this.g == null) {
            throw new IllegalStateException("Offset cannot be set without limit");
        }
        sb.append(" OFFSET ?");
        this.c.add(this.h);
        return this.c.size() - 1;
    }

    private void g(String str) {
        if (k) {
            s50.a("Built SQL for query: " + str);
        }
        if (l) {
            s50.a("Values for query: " + this.c);
        }
    }

    private void h() {
        StringBuilder sb = this.b;
        if (sb == null) {
            this.b = new StringBuilder();
        } else if (sb.length() > 0) {
            this.b.append(",");
        }
    }

    private StringBuilder i() {
        StringBuilder sb = new StringBuilder(ht2.l(this.e.getTablename(), this.f, this.e.getAllColumns(), this.i));
        b(sb, this.f);
        StringBuilder sb2 = this.b;
        if (sb2 != null && sb2.length() > 0) {
            sb.append(" ORDER BY ");
            sb.append((CharSequence) this.b);
        }
        return sb;
    }

    public static u92 j(y0 y0Var) {
        return new u92(y0Var);
    }

    private void n(String str, h82... h82VarArr) {
        String str2;
        for (h82 h82Var : h82VarArr) {
            h();
            a(this.b, h82Var);
            if (String.class.equals(h82Var.b) && (str2 = this.j) != null) {
                this.b.append(str2);
            }
            this.b.append(str);
        }
    }

    protected StringBuilder a(StringBuilder sb, h82 h82Var) {
        this.a.d(h82Var);
        sb.append(this.f);
        sb.append('.');
        sb.append('\'');
        sb.append(h82Var.e);
        sb.append('\'');
        return sb;
    }

    public t92 c() {
        StringBuilder sbI = i();
        int iE = e(sbI);
        int iF = f(sbI);
        String string = sbI.toString();
        g(string);
        return t92.e(this.e, string, this.c.toArray(), iE, iF);
    }

    public h90 d() {
        if (!this.d.isEmpty()) {
            throw new DaoException("JOINs are not supported for DELETE queries");
        }
        String tablename = this.e.getTablename();
        StringBuilder sb = new StringBuilder(ht2.j(tablename, null));
        b(sb, this.f);
        String strReplace = sb.toString().replace(this.f + ".\"", JsonFactory.DEFAULT_QUOTE_CHAR + tablename + "\".\"");
        g(strReplace);
        return h90.d(this.e, strReplace, this.c.toArray());
    }

    public u92 k(int i) {
        this.g = Integer.valueOf(i);
        return this;
    }

    public List l() {
        return c().h();
    }

    public u92 m(h82... h82VarArr) {
        n(" ASC", h82VarArr);
        return this;
    }

    public u92 o(h82... h82VarArr) {
        n(" DESC", h82VarArr);
        return this;
    }

    public u92 p(String str) {
        h();
        this.b.append(str);
        return this;
    }

    public Object q() {
        return c().j();
    }

    public u92 r(gi3 gi3Var, gi3... gi3VarArr) {
        this.a.a(gi3Var, gi3VarArr);
        return this;
    }

    protected u92(y0 y0Var, String str) {
        this.e = y0Var;
        this.f = str;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.a = new fi3(y0Var, str);
        this.j = " COLLATE NOCASE";
    }
}
