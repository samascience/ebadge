package defpackage;

import com.google.gson.ToNumberPolicy;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class qt1 extends e63 {
    private static final f63 c = g(ToNumberPolicy.DOUBLE);
    private final qv0 a;
    private final n33 b;

    class a implements f63 {
        final /* synthetic */ n33 a;

        a(n33 n33Var) {
            this.a = n33Var;
        }

        @Override // defpackage.f63
        public e63 a(qv0 qv0Var, TypeToken typeToken) {
            a aVar = null;
            if (typeToken.getRawType() == Object.class) {
                return new qt1(qv0Var, this.a, aVar);
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
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* synthetic */ qt1(qv0 qv0Var, n33 n33Var, a aVar) {
        this(qv0Var, n33Var);
    }

    public static f63 f(n33 n33Var) {
        return n33Var == ToNumberPolicy.DOUBLE ? c : g(n33Var);
    }

    private static f63 g(n33 n33Var) {
        return new a(n33Var);
    }

    private Object h(a71 a71Var, JsonToken jsonToken) throws IOException {
        int i = b.a[jsonToken.ordinal()];
        if (i == 3) {
            return a71Var.K0();
        }
        if (i == 4) {
            return this.b.readNumber(a71Var);
        }
        if (i == 5) {
            return Boolean.valueOf(a71Var.w0());
        }
        if (i == 6) {
            a71Var.I0();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + jsonToken);
    }

    private Object i(a71 a71Var, JsonToken jsonToken) throws IOException {
        int i = b.a[jsonToken.ordinal()];
        if (i == 1) {
            a71Var.n();
            return new ArrayList();
        }
        if (i != 2) {
            return null;
        }
        a71Var.u();
        return new LinkedTreeMap();
    }

    @Override // defpackage.e63
    public Object b(a71 a71Var) throws IOException {
        JsonToken jsonTokenM0 = a71Var.M0();
        Object objI = i(a71Var, jsonTokenM0);
        if (objI == null) {
            return h(a71Var, jsonTokenM0);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (a71Var.j0()) {
                String strG0 = objI instanceof Map ? a71Var.G0() : null;
                JsonToken jsonTokenM1 = a71Var.M0();
                Object objI2 = i(a71Var, jsonTokenM1);
                boolean z = objI2 != null;
                if (objI2 == null) {
                    objI2 = h(a71Var, jsonTokenM1);
                }
                if (objI instanceof List) {
                    ((List) objI).add(objI2);
                } else {
                    ((Map) objI).put(strG0, objI2);
                }
                if (z) {
                    arrayDeque.addLast(objI);
                    objI = objI2;
                }
            } else {
                if (objI instanceof List) {
                    a71Var.D();
                } else {
                    a71Var.V();
                }
                if (arrayDeque.isEmpty()) {
                    return objI;
                }
                objI = arrayDeque.removeLast();
            }
        }
    }

    @Override // defpackage.e63
    public void e(a81 a81Var, Object obj) throws IOException {
        if (obj == null) {
            a81Var.t0();
            return;
        }
        e63 e63VarH = this.a.h(obj.getClass());
        if (!(e63VarH instanceof qt1)) {
            e63VarH.e(a81Var, obj);
        } else {
            a81Var.y();
            a81Var.V();
        }
    }

    private qt1(qv0 qv0Var, n33 n33Var) {
        this.a = qv0Var;
        this.b = n33Var;
    }
}
