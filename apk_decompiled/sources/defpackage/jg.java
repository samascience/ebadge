package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class jg implements n90 {
    private n90 f(String str, String str2, String str3, Iterator it) {
        d(str);
        boolean z = false;
        while (it.hasNext()) {
            if (z) {
                d(str2);
            }
            e((nm2) it.next());
            z = true;
        }
        d(str3);
        return this;
    }

    private n90 g(String str, String str2, String str3, Iterator it) {
        return f(str, str2, str3, new pm2(it));
    }

    private String h(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception unused) {
            return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
        }
    }

    private void i(char c) {
        if (c == '\t') {
            d("\\t");
            return;
        }
        if (c == '\n') {
            d("\\n");
            return;
        }
        if (c == '\r') {
            d("\\r");
        } else if (c != '\"') {
            c(c);
        } else {
            d("\\\"");
        }
    }

    private void j(String str) {
        c(JsonFactory.DEFAULT_QUOTE_CHAR);
        for (int i = 0; i < str.length(); i++) {
            i(str.charAt(i));
        }
        c(JsonFactory.DEFAULT_QUOTE_CHAR);
    }

    @Override // defpackage.n90
    public n90 a(String str) {
        d(str);
        return this;
    }

    @Override // defpackage.n90
    public n90 b(Object obj) {
        if (obj == null) {
            d("null");
        } else if (obj instanceof String) {
            j((String) obj);
        } else if (obj instanceof Character) {
            c(JsonFactory.DEFAULT_QUOTE_CHAR);
            i(((Character) obj).charValue());
            c(JsonFactory.DEFAULT_QUOTE_CHAR);
        } else if (obj instanceof Short) {
            c('<');
            d(h(obj));
            d("s>");
        } else if (obj instanceof Long) {
            c('<');
            d(h(obj));
            d("L>");
        } else if (obj instanceof Float) {
            c('<');
            d(h(obj));
            d("F>");
        } else if (obj.getClass().isArray()) {
            g("[", ", ", "]", new r9(obj));
        } else {
            c('<');
            d(h(obj));
            c('>');
        }
        return this;
    }

    protected abstract void c(char c);

    protected abstract void d(String str);

    public n90 e(nm2 nm2Var) {
        nm2Var.describeTo(this);
        return this;
    }
}
