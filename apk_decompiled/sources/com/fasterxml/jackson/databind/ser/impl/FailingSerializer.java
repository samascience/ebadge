package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import defpackage.an2;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class FailingSerializer extends StdSerializer<Object> {
    protected final String _msg;

    public FailingSerializer(String str) {
        super(Object.class);
        this._msg = str;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        an2Var.reportMappingProblem(this._msg, new Object[0]);
    }
}
