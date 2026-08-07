package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import defpackage.an2;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class StdKeySerializer extends StdSerializer<Object> {
    public StdKeySerializer() {
        super(Object.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        jsonGenerator.V0(obj.toString());
    }
}
