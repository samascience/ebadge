package defpackage;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;

/* JADX INFO: loaded from: classes.dex */
public final class jl3 {
    public final ObjectIdGenerator a;
    public Object b;
    protected boolean c = false;

    public jl3(ObjectIdGenerator objectIdGenerator) {
        this.a = objectIdGenerator;
    }

    public Object a(Object obj) {
        if (this.b == null) {
            this.b = this.a.generateId(obj);
        }
        return this.b;
    }

    public void b(JsonGenerator jsonGenerator, an2 an2Var, mt1 mt1Var) throws JsonGenerationException {
        this.c = true;
        if (jsonGenerator.V()) {
            Object obj = this.b;
            jsonGenerator.g1(obj == null ? null : String.valueOf(obj));
            return;
        }
        vm2 vm2Var = mt1Var.b;
        if (vm2Var != null) {
            jsonGenerator.U0(vm2Var);
            mt1Var.d.serialize(this.b, jsonGenerator, an2Var);
        }
    }

    public boolean c(JsonGenerator jsonGenerator, an2 an2Var, mt1 mt1Var) throws JsonGenerationException {
        if (this.b == null) {
            return false;
        }
        if (!this.c && !mt1Var.e) {
            return false;
        }
        if (jsonGenerator.V()) {
            jsonGenerator.h1(String.valueOf(this.b));
            return true;
        }
        mt1Var.d.serialize(this.b, jsonGenerator, an2Var);
        return true;
    }
}
