package defpackage;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class t71 {
    public static final qv0 a = new rv0().e(xi1.class, new yi1()).e(ql1.class, new rl1()).e(vl1.class, new wl1()).e(s33.class, new y33()).e(t20.class, new aj1()).e(g7.class, new h7()).e(eu2.class, new fu2()).e(t33.class, new v33()).a(new i7()).i(ToNumberPolicy.LONG_OR_DOUBLE).d().c();

    public static Object a(u51 u51Var, Class cls) {
        return a.fromJson(u51Var, cls);
    }

    public static o61 b(Map map) {
        if (map == null) {
            return null;
        }
        o61 o61Var = new o61();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() instanceof String) {
                o61Var.n((String) entry.getKey(), (String) entry.getValue());
            } else if (entry.getValue() instanceof Integer) {
                o61Var.m((String) entry.getKey(), (Integer) entry.getValue());
            } else if (entry.getValue() instanceof Double) {
                o61Var.m((String) entry.getKey(), (Double) entry.getValue());
            } else if (entry.getValue() instanceof Boolean) {
                o61Var.k((String) entry.getKey(), (Boolean) entry.getValue());
            } else if (entry.getValue() instanceof Character) {
                o61Var.l((String) entry.getKey(), (Character) entry.getValue());
            } else if (entry.getValue() instanceof List) {
                o61Var.j((String) entry.getKey(), g(entry.getValue()));
            } else if (entry.getValue() instanceof Map) {
                o61Var.j((String) entry.getKey(), i(entry.getValue()));
            } else {
                o61Var.j((String) entry.getKey(), h(entry.getValue()));
            }
        }
        return o61Var;
    }

    public static o61 c(String str) {
        return f(str).c();
    }

    public static u51 d(a71 a71Var) {
        boolean zK0 = a71Var.k0();
        a71Var.R0(true);
        try {
            try {
                u51 u51VarA = iv2.a(a71Var);
                a71Var.R0(zK0);
                return u51VarA;
            } catch (OutOfMemoryError e) {
                throw new JsonParseException("Failed parsing JSON source: " + a71Var + " to Json", e);
            } catch (StackOverflowError e2) {
                throw new JsonParseException("Failed parsing JSON source: " + a71Var + " to Json", e2);
            }
        } catch (Throwable th) {
            a71Var.R0(zK0);
            throw th;
        }
    }

    public static u51 e(Reader reader) {
        try {
            a71 a71Var = new a71(reader);
            u51 u51VarD = d(a71Var);
            if (!u51VarD.g() && a71Var.M0() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return u51VarD;
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException(e);
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        } catch (NumberFormatException e3) {
            throw new JsonSyntaxException(e3);
        }
    }

    public static u51 f(String str) {
        return e(new StringReader(str));
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        return (T) a.fromJson(str, (Class) cls);
    }

    public static l51 g(Object obj) {
        return a.q(obj).b();
    }

    public static u51 h(Object obj) {
        return a.q(obj);
    }

    public static o61 i(Object obj) {
        return a.q(obj).c();
    }

    public static String toJson(Object obj) {
        return a.toJson(obj);
    }

    public static <T> T fromJson(String str, Type type) {
        return (T) a.fromJson(str, type);
    }

    public static <T> T fromJson(u51 u51Var, Type type) {
        return (T) a.fromJson(u51Var, type);
    }
}
