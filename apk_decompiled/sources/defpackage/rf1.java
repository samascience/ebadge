package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class rf1 implements f63 {
    private final p20 a;
    final boolean b;

    private final class a extends e63 {
        private final e63 a;
        private final e63 b;
        private final kt1 c;

        public a(qv0 qv0Var, Type type, e63 e63Var, Type type2, e63 e63Var2, kt1 kt1Var) {
            this.a = new g63(qv0Var, e63Var, type);
            this.b = new g63(qv0Var, e63Var2, type2);
            this.c = kt1Var;
        }

        private String f(u51 u51Var) {
            if (!u51Var.i()) {
                if (u51Var.g()) {
                    return "null";
                }
                throw new AssertionError();
            }
            v61 v61VarD = u51Var.d();
            if (v61VarD.p()) {
                return String.valueOf(v61VarD.m());
            }
            if (v61VarD.n()) {
                return Boolean.toString(v61VarD.j());
            }
            if (v61VarD.q()) {
                return v61VarD.e();
            }
            throw new AssertionError();
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map b(a71 a71Var) throws IOException {
            JsonToken jsonTokenM0 = a71Var.M0();
            if (jsonTokenM0 == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            Map map = (Map) this.c.a();
            if (jsonTokenM0 == JsonToken.BEGIN_ARRAY) {
                a71Var.n();
                while (a71Var.j0()) {
                    a71Var.n();
                    Object objB = this.a.b(a71Var);
                    if (map.put(objB, this.b.b(a71Var)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + objB);
                    }
                    a71Var.D();
                }
                a71Var.D();
            } else {
                a71Var.u();
                while (a71Var.j0()) {
                    b71.a.a(a71Var);
                    Object objB2 = this.a.b(a71Var);
                    if (map.put(objB2, this.b.b(a71Var)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + objB2);
                    }
                }
                a71Var.V();
            }
            return map;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Map map) throws IOException {
            if (map == null) {
                a81Var.t0();
                return;
            }
            if (!rf1.this.b) {
                a81Var.y();
                for (Map.Entry entry : map.entrySet()) {
                    a81Var.k0(String.valueOf(entry.getKey()));
                    this.b.e(a81Var, entry.getValue());
                }
                a81Var.V();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i = 0;
            boolean z = false;
            for (Map.Entry entry2 : map.entrySet()) {
                u51 u51VarD = this.a.d(entry2.getKey());
                arrayList.add(u51VarD);
                arrayList2.add(entry2.getValue());
                z |= u51VarD.f() || u51VarD.h();
            }
            if (!z) {
                a81Var.y();
                int size = arrayList.size();
                while (i < size) {
                    a81Var.k0(f((u51) arrayList.get(i)));
                    this.b.e(a81Var, arrayList2.get(i));
                    i++;
                }
                a81Var.V();
                return;
            }
            a81Var.w();
            int size2 = arrayList.size();
            while (i < size2) {
                a81Var.w();
                iv2.b((u51) arrayList.get(i), a81Var);
                this.b.e(a81Var, arrayList2.get(i));
                a81Var.D();
                i++;
            }
            a81Var.D();
        }
    }

    public rf1(p20 p20Var, boolean z) {
        this.a = p20Var;
        this.b = z;
    }

    private e63 b(qv0 qv0Var, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? h63.f : qv0Var.g(TypeToken.get(type));
    }

    @Override // defpackage.f63
    public e63 a(qv0 qv0Var, TypeToken typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type[] typeArrJ = C$Gson$Types.j(type, rawType);
        return new a(qv0Var, typeArrJ[0], b(qv0Var, typeArrJ[0]), typeArrJ[1], qv0Var.g(TypeToken.get(typeArrJ[1])), this.a.b(typeToken));
    }
}
