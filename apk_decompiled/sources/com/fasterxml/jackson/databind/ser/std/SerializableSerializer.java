package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.a;
import defpackage.an2;
import defpackage.e41;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@e41
public class SerializableSerializer extends StdSerializer<a> {
    public static final SerializableSerializer instance = new SerializableSerializer();

    protected SerializableSerializer() {
        super(a.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        y51Var.e(javaType);
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, a aVar) {
        if (aVar instanceof a.AbstractC0067a) {
            return ((a.AbstractC0067a) aVar).isEmpty(an2Var);
        }
        return false;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(a aVar, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        aVar.serialize(jsonGenerator, an2Var);
    }

    @Override // defpackage.f71
    public final void serializeWithType(a aVar, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        aVar.serializeWithType(jsonGenerator, an2Var, z63Var);
    }
}
