package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.introspect.g;
import defpackage.kh;

/* JADX INFO: loaded from: classes.dex */
public class InvalidDefinitionException extends JsonMappingException {
    protected transient kh _beanDesc;
    protected transient g _property;
    protected final JavaType _type;

    protected InvalidDefinitionException(JsonParser jsonParser, String str, JavaType javaType) {
        super(jsonParser, str);
        this._type = javaType;
        this._beanDesc = null;
        this._property = null;
    }

    public static InvalidDefinitionException from(JsonParser jsonParser, String str, kh khVar, g gVar) {
        return new InvalidDefinitionException(jsonParser, str, khVar, gVar);
    }

    public kh getBeanDescription() {
        return this._beanDesc;
    }

    public g getProperty() {
        return this._property;
    }

    public JavaType getType() {
        return this._type;
    }

    public static InvalidDefinitionException from(JsonParser jsonParser, String str, JavaType javaType) {
        return new InvalidDefinitionException(jsonParser, str, javaType);
    }

    public static InvalidDefinitionException from(JsonGenerator jsonGenerator, String str, kh khVar, g gVar) {
        return new InvalidDefinitionException(jsonGenerator, str, khVar, gVar);
    }

    public static InvalidDefinitionException from(JsonGenerator jsonGenerator, String str, JavaType javaType) {
        return new InvalidDefinitionException(jsonGenerator, str, javaType);
    }

    protected InvalidDefinitionException(JsonGenerator jsonGenerator, String str, JavaType javaType) {
        super(jsonGenerator, str);
        this._type = javaType;
        this._beanDesc = null;
        this._property = null;
    }

    protected InvalidDefinitionException(JsonParser jsonParser, String str, kh khVar, g gVar) {
        super(jsonParser, str);
        this._type = khVar == null ? null : khVar.A();
        this._beanDesc = khVar;
        this._property = gVar;
    }

    protected InvalidDefinitionException(JsonGenerator jsonGenerator, String str, kh khVar, g gVar) {
        super(jsonGenerator, str);
        this._type = khVar == null ? null : khVar.A();
        this._beanDesc = khVar;
        this._property = gVar;
    }
}
