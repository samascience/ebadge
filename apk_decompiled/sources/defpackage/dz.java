package defpackage;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class dz implements f63 {
    private final p20 a;

    private static final class a extends e63 {
        private final e63 a;
        private final kt1 b;

        public a(qv0 qv0Var, Type type, e63 e63Var, kt1 kt1Var) {
            this.a = new g63(qv0Var, e63Var, type);
            this.b = kt1Var;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            Collection collection = (Collection) this.b.a();
            a71Var.n();
            while (a71Var.j0()) {
                collection.add(this.a.b(a71Var));
            }
            a71Var.D();
            return collection;
        }

        @Override // defpackage.e63
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(a81 a81Var, Collection collection) throws IOException {
            if (collection == null) {
                a81Var.t0();
                return;
            }
            a81Var.w();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                this.a.e(a81Var, it.next());
            }
            a81Var.D();
        }
    }

    public dz(p20 p20Var) {
        this.a = p20Var;
    }

    @Override // defpackage.f63
    public e63 a(qv0 qv0Var, TypeToken typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type typeH = C$Gson$Types.h(type, rawType);
        return new a(qv0Var, typeH, qv0Var.g(TypeToken.get(typeH)), this.a.b(typeToken));
    }
}
