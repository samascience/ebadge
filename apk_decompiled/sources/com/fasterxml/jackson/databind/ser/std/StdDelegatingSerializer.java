package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import defpackage.an2;
import defpackage.ay;
import defpackage.cg2;
import defpackage.f40;
import defpackage.f71;
import defpackage.tk2;
import defpackage.w30;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class StdDelegatingSerializer extends StdSerializer<Object> implements w30, cg2, tk2 {
    protected final f40 _converter;
    protected final f71 _delegateSerializer;
    protected final JavaType _delegateType;

    public StdDelegatingSerializer(f40 f40Var) {
        super(Object.class);
        this._converter = f40Var;
        this._delegateType = null;
        this._delegateSerializer = null;
    }

    protected f71 _findSerializer(Object obj, an2 an2Var) throws JsonMappingException {
        return an2Var.findValueSerializer(obj.getClass());
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        f71 f71Var = this._delegateSerializer;
        if (f71Var != null) {
            f71Var.acceptJsonFormatVisitor(y51Var, javaType);
        }
    }

    protected Object convertValue(Object obj) {
        return this._converter.convert(obj);
    }

    @Override // defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarHandleSecondaryContextualization = this._delegateSerializer;
        JavaType javaTypeB = this._delegateType;
        if (f71VarHandleSecondaryContextualization == null) {
            if (javaTypeB == null) {
                javaTypeB = this._converter.b(an2Var.getTypeFactory());
            }
            if (!javaTypeB.isJavaLangObject()) {
                f71VarHandleSecondaryContextualization = an2Var.findValueSerializer(javaTypeB);
            }
        }
        if (f71VarHandleSecondaryContextualization instanceof w30) {
            f71VarHandleSecondaryContextualization = an2Var.handleSecondaryContextualization(f71VarHandleSecondaryContextualization, beanProperty);
        }
        return (f71VarHandleSecondaryContextualization == this._delegateSerializer && javaTypeB == this._delegateType) ? this : withDelegate(this._converter, javaTypeB, f71VarHandleSecondaryContextualization);
    }

    protected f40 getConverter() {
        return this._converter;
    }

    @Override // defpackage.f71
    public f71 getDelegatee() {
        return this._delegateSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) throws JsonMappingException {
        Object obj = this._delegateSerializer;
        return obj instanceof tk2 ? ((tk2) obj).getSchema(an2Var, type) : super.getSchema(an2Var, type);
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, Object obj) {
        Object objConvertValue = convertValue(obj);
        if (objConvertValue == null) {
            return true;
        }
        f71 f71Var = this._delegateSerializer;
        if (f71Var == null) {
            return obj == null;
        }
        return f71Var.isEmpty(an2Var, objConvertValue);
    }

    @Override // defpackage.cg2
    public void resolve(an2 an2Var) throws JsonMappingException {
        Object obj = this._delegateSerializer;
        if (obj == null || !(obj instanceof cg2)) {
            return;
        }
        ((cg2) obj).resolve(an2Var);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        Object objConvertValue = convertValue(obj);
        if (objConvertValue == null) {
            an2Var.defaultSerializeNull(jsonGenerator);
            return;
        }
        f71 f71Var_findSerializer = this._delegateSerializer;
        if (f71Var_findSerializer == null) {
            f71Var_findSerializer = _findSerializer(objConvertValue, an2Var);
        }
        f71Var_findSerializer.serialize(objConvertValue, jsonGenerator, an2Var);
    }

    @Override // defpackage.f71
    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        Object objConvertValue = convertValue(obj);
        f71 f71Var_findSerializer = this._delegateSerializer;
        if (f71Var_findSerializer == null) {
            f71Var_findSerializer = _findSerializer(obj, an2Var);
        }
        f71Var_findSerializer.serializeWithType(objConvertValue, jsonGenerator, an2Var, z63Var);
    }

    protected StdDelegatingSerializer withDelegate(f40 f40Var, JavaType javaType, f71 f71Var) {
        ay.n0(StdDelegatingSerializer.class, this, "withDelegate");
        return new StdDelegatingSerializer(f40Var, javaType, f71Var);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type, boolean z) throws JsonMappingException {
        Object obj = this._delegateSerializer;
        if (obj instanceof tk2) {
            return ((tk2) obj).getSchema(an2Var, type, z);
        }
        return super.getSchema(an2Var, type);
    }

    public <T> StdDelegatingSerializer(Class<T> cls, f40 f40Var) {
        super(cls, false);
        this._converter = f40Var;
        this._delegateType = null;
        this._delegateSerializer = null;
    }

    public StdDelegatingSerializer(f40 f40Var, JavaType javaType, f71 f71Var) {
        super(javaType);
        this._converter = f40Var;
        this._delegateType = javaType;
        this._delegateSerializer = f71Var;
    }
}
