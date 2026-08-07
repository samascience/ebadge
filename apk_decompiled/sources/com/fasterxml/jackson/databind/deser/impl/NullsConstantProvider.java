package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.util.AccessPattern;
import defpackage.gs1;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class NullsConstantProvider implements gs1, Serializable {
    private static final long serialVersionUID = 1;
    protected final AccessPattern _access;
    protected final Object _nullValue;
    private static final NullsConstantProvider SKIPPER = new NullsConstantProvider(null);
    private static final NullsConstantProvider NULLER = new NullsConstantProvider(null);

    protected NullsConstantProvider(Object obj) {
        this._nullValue = obj;
        this._access = obj == null ? AccessPattern.ALWAYS_NULL : AccessPattern.CONSTANT;
    }

    public static NullsConstantProvider forValue(Object obj) {
        return obj == null ? NULLER : new NullsConstantProvider(obj);
    }

    public static boolean isNuller(gs1 gs1Var) {
        return gs1Var == NULLER;
    }

    public static boolean isSkipper(gs1 gs1Var) {
        return gs1Var == SKIPPER;
    }

    public static NullsConstantProvider nuller() {
        return NULLER;
    }

    public static NullsConstantProvider skipper() {
        return SKIPPER;
    }

    @Override // defpackage.gs1
    public /* bridge */ /* synthetic */ Object getAbsentValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return super.getAbsentValue(deserializationContext);
    }

    public AccessPattern getNullAccessPattern() {
        return this._access;
    }

    @Override // defpackage.gs1
    public Object getNullValue(DeserializationContext deserializationContext) {
        return this._nullValue;
    }
}
