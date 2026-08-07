package defpackage;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class b73 extends f71 implements w30 {
    protected final z63 a;
    protected final f71 b;

    public b73(z63 z63Var, f71 f71Var) {
        this.a = z63Var;
        this.b = f71Var;
    }

    public z63 a() {
        return this.a;
    }

    @Override // defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarHandleSecondaryContextualization = this.b;
        if (f71VarHandleSecondaryContextualization instanceof w30) {
            f71VarHandleSecondaryContextualization = an2Var.handleSecondaryContextualization(f71VarHandleSecondaryContextualization, beanProperty);
        }
        return f71VarHandleSecondaryContextualization == this.b ? this : new b73(this.a, f71VarHandleSecondaryContextualization);
    }

    @Override // defpackage.f71
    public Class handledType() {
        return Object.class;
    }

    @Override // defpackage.f71
    public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        this.b.serializeWithType(obj, jsonGenerator, an2Var, this.a);
    }

    @Override // defpackage.f71
    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        this.b.serializeWithType(obj, jsonGenerator, an2Var, z63Var);
    }
}
