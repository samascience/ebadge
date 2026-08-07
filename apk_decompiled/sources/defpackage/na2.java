package defpackage;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.a;

/* JADX INFO: loaded from: classes.dex */
public class na2 implements a {
    protected Object a;

    public na2(String str) {
        this.a = str;
    }

    protected void a(JsonGenerator jsonGenerator) {
        Object obj = this.a;
        if (obj instanceof vm2) {
            jsonGenerator.n1((vm2) obj);
        } else {
            jsonGenerator.o1(String.valueOf(obj));
        }
    }

    public void b(JsonGenerator jsonGenerator) {
        Object obj = this.a;
        if (obj instanceof a) {
            jsonGenerator.f1(obj);
        } else {
            a(jsonGenerator);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof na2)) {
            return false;
        }
        Object obj2 = this.a;
        Object obj3 = ((na2) obj).a;
        if (obj2 == obj3) {
            return true;
        }
        return obj2 != null && obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // com.fasterxml.jackson.databind.a
    public void serialize(JsonGenerator jsonGenerator, an2 an2Var) {
        Object obj = this.a;
        if (obj instanceof a) {
            ((a) obj).serialize(jsonGenerator, an2Var);
        } else {
            a(jsonGenerator);
        }
    }

    @Override // com.fasterxml.jackson.databind.a
    public void serializeWithType(JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) {
        Object obj = this.a;
        if (obj instanceof a) {
            ((a) obj).serializeWithType(jsonGenerator, an2Var, z63Var);
        } else if (obj instanceof vm2) {
            serialize(jsonGenerator, an2Var);
        }
    }

    public String toString() {
        return String.format("[RawValue of type %s]", ay.h(this.a));
    }
}
