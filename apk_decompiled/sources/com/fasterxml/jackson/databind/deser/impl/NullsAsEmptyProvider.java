package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.util.AccessPattern;
import defpackage.gs1;
import defpackage.s51;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class NullsAsEmptyProvider implements gs1, Serializable {
    private static final long serialVersionUID = 1;
    protected final s51 _deserializer;

    public NullsAsEmptyProvider(s51 s51Var) {
        this._deserializer = s51Var;
    }

    @Override // defpackage.gs1
    public /* bridge */ /* synthetic */ Object getAbsentValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return super.getAbsentValue(deserializationContext);
    }

    public AccessPattern getNullAccessPattern() {
        return AccessPattern.DYNAMIC;
    }

    @Override // defpackage.gs1
    public Object getNullValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return this._deserializer.getEmptyValue(deserializationContext);
    }
}
