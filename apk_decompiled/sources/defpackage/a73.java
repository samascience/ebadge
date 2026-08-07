package defpackage;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;

/* JADX INFO: loaded from: classes.dex */
public abstract class a73 extends z63 {
    protected final n63 a;
    protected final BeanProperty b;

    protected a73(n63 n63Var, BeanProperty beanProperty) {
        this.a = n63Var;
        this.b = beanProperty;
    }

    @Override // defpackage.z63
    public String b() {
        return null;
    }

    @Override // defpackage.z63
    public WritableTypeId g(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) {
        i(writableTypeId);
        if (writableTypeId.c == null) {
            return null;
        }
        return jsonGenerator.A1(writableTypeId);
    }

    @Override // defpackage.z63
    public WritableTypeId h(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) {
        if (writableTypeId == null) {
            return null;
        }
        return jsonGenerator.B1(writableTypeId);
    }

    protected void i(WritableTypeId writableTypeId) {
        if (writableTypeId.c == null) {
            Object obj = writableTypeId.a;
            Class cls = writableTypeId.b;
            writableTypeId.c = cls == null ? k(obj) : l(obj, cls);
        }
    }

    protected void j(Object obj) {
    }

    protected String k(Object obj) {
        String strA = this.a.a(obj);
        if (strA == null) {
            j(obj);
        }
        return strA;
    }

    protected String l(Object obj, Class cls) {
        String strE = this.a.e(obj, cls);
        if (strE == null) {
            j(obj);
        }
        return strE;
    }
}
