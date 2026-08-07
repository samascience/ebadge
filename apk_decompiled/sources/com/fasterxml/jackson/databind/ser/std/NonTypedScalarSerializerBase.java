package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import defpackage.an2;
import defpackage.z63;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class NonTypedScalarSerializerBase<T> extends StdScalarSerializer<T> {
    protected NonTypedScalarSerializerBase(Class<T> cls) {
        super(cls);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, defpackage.f71
    public final void serializeWithType(T t, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        serialize(t, jsonGenerator, an2Var);
    }

    protected NonTypedScalarSerializerBase(Class<?> cls, boolean z) {
        super(cls, z);
    }
}
