package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import com.jieli.jl_rcsp.util.CHexConver;
import org.greenrobot.greendao.DaoException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ht2 {
    private static final char[] a = CHexConver.b.toCharArray();

    public static StringBuilder a(StringBuilder sb, String str) {
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        sb.append(str);
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        return sb;
    }

    public static StringBuilder b(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        return sb;
    }

    public static StringBuilder c(StringBuilder sb, String str, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            b(sb, str, strArr[i]);
            if (i < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder d(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            sb.append(strArr[i]);
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            if (i < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder e(StringBuilder sb, String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            b(sb, str, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder f(StringBuilder sb, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            a(sb, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder g(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static StringBuilder h(StringBuilder sb, String str, h82 h82Var) {
        if (str != null) {
            sb.append(str);
            sb.append('.');
        }
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        sb.append(h82Var.e);
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        return sb;
    }

    public static String i(String str) {
        return "SELECT COUNT(*) FROM \"" + str + JsonFactory.DEFAULT_QUOTE_CHAR;
    }

    public static String j(String str, String[] strArr) {
        String str2 = JsonFactory.DEFAULT_QUOTE_CHAR + str + JsonFactory.DEFAULT_QUOTE_CHAR;
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            e(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String k(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        sb.append(str2);
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        sb.append(" (");
        d(sb, strArr);
        sb.append(") VALUES (");
        g(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String l(String str, String str2, String[] strArr, boolean z) {
        if (str2 == null || str2.length() < 0) {
            throw new DaoException("Table alias required");
        }
        StringBuilder sb = new StringBuilder(z ? "SELECT DISTINCT " : "SELECT ");
        c(sb, str2, strArr).append(" FROM ");
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        sb.append(str);
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        sb.append(' ');
        sb.append(str2);
        sb.append(' ');
        return sb.toString();
    }

    public static String m(String str, String[] strArr, String[] strArr2) {
        String str2 = JsonFactory.DEFAULT_QUOTE_CHAR + str + JsonFactory.DEFAULT_QUOTE_CHAR;
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2);
        sb.append(" SET ");
        f(sb, strArr);
        sb.append(" WHERE ");
        e(sb, str2, strArr2);
        return sb.toString();
    }
}
