package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class js1 extends e63 {
    private static final f63 b = g(ToNumberPolicy.LAZILY_PARSED_NUMBER);
    private final n33 a;

    class a implements f63 {
        a() {
        }

        @Override // defpackage.f63
        public e63 a(qv0 qv0Var, TypeToken typeToken) {
            if (typeToken.getRawType() == Number.class) {
                return js1.this;
            }
            return null;
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private js1(n33 n33Var) {
        this.a = n33Var;
    }

    public static f63 f(n33 n33Var) {
        return n33Var == ToNumberPolicy.LAZILY_PARSED_NUMBER ? b : g(n33Var);
    }

    private static f63 g(n33 n33Var) {
        return new js1(n33Var).new a();
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Number b(a71 a71Var) throws IOException {
        JsonToken jsonTokenM0 = a71Var.M0();
        int i = b.a[jsonTokenM0.ordinal()];
        if (i == 1) {
            a71Var.I0();
            return null;
        }
        if (i == 2 || i == 3) {
            return this.a.readNumber(a71Var);
        }
        throw new JsonSyntaxException("Expecting number, got: " + jsonTokenM0 + "; at path " + a71Var.c());
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e(a81 a81Var, Number number) throws IOException {
        a81Var.O0(number);
    }
}
