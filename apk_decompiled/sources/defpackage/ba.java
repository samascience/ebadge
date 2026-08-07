package defpackage;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class ba extends e63 {
    public static final f63 c = new a();
    private final Class a;
    private final e63 b;

    class a implements f63 {
        a() {
        }

        @Override // defpackage.f63
        public e63 a(qv0 qv0Var, TypeToken typeToken) {
            Type type = typeToken.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type typeG = C$Gson$Types.g(type);
            return new ba(qv0Var, qv0Var.g(TypeToken.get(typeG)), C$Gson$Types.k(typeG));
        }
    }

    public ba(qv0 qv0Var, e63 e63Var, Class cls) {
        this.b = new g63(qv0Var, e63Var, cls);
        this.a = cls;
    }

    @Override // defpackage.e63
    public Object b(a71 a71Var) throws IOException {
        if (a71Var.M0() == JsonToken.NULL) {
            a71Var.I0();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        a71Var.n();
        while (a71Var.j0()) {
            arrayList.add(this.b.b(a71Var));
        }
        a71Var.D();
        int size = arrayList.size();
        if (!this.a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.a, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.a, size);
        for (int i = 0; i < size; i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // defpackage.e63
    public void e(a81 a81Var, Object obj) throws IOException {
        if (obj == null) {
            a81Var.t0();
            return;
        }
        a81Var.w();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.b.e(a81Var, Array.get(obj, i));
        }
        a81Var.D();
    }
}
