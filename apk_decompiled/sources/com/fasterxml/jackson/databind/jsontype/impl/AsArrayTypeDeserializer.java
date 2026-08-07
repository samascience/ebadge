package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import defpackage.m63;
import defpackage.n63;
import defpackage.q33;
import defpackage.s51;
import defpackage.t61;
import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class AsArrayTypeDeserializer extends TypeDeserializerBase implements Serializable {
    private static final long serialVersionUID = 1;

    public AsArrayTypeDeserializer(JavaType javaType, n63 n63Var, String str, boolean z, JavaType javaType2) {
        super(javaType, n63Var, str, z, javaType2);
    }

    protected Object _deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objX0;
        if (jsonParser.w() && (objX0 = jsonParser.X0()) != null) {
            return _deserializeWithNativeTypeId(jsonParser, deserializationContext, objX0);
        }
        boolean zI1 = jsonParser.i1();
        String str_locateTypeId = _locateTypeId(jsonParser, deserializationContext);
        s51 s51Var_findDeserializer = _findDeserializer(deserializationContext, str_locateTypeId);
        if (this._typeIdVisible && !_usesExternalId() && jsonParser.d1(JsonToken.START_OBJECT)) {
            q33 q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
            q33VarBufferForInputBuffering.s1();
            q33VarBufferForInputBuffering.V0(this._typePropertyName);
            q33VarBufferForInputBuffering.w1(str_locateTypeId);
            jsonParser.y();
            jsonParser = t61.x1(false, q33VarBufferForInputBuffering.P1(jsonParser), jsonParser);
            jsonParser.n1();
        }
        if (zI1 && jsonParser.D() == JsonToken.END_ARRAY) {
            return s51Var_findDeserializer.getNullValue(deserializationContext);
        }
        Object objDeserialize = s51Var_findDeserializer.deserialize(jsonParser, deserializationContext);
        if (zI1) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            if (jsonTokenN1 != jsonToken) {
                deserializationContext.reportWrongTokenException(baseType(), jsonToken, "expected closing END_ARRAY after type information and deserialized value", new Object[0]);
            }
        }
        return objDeserialize;
    }

    protected String _locateTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (!jsonParser.i1()) {
            if (this._defaultImpl != null) {
                return this._idResolver.f();
            }
            deserializationContext.reportWrongTokenException(baseType(), JsonToken.START_ARRAY, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + baseTypeName(), new Object[0]);
            return null;
        }
        JsonToken jsonTokenN1 = jsonParser.n1();
        JsonToken jsonToken = JsonToken.VALUE_STRING;
        if (jsonTokenN1 != jsonToken && (jsonTokenN1 == null || !jsonTokenN1.isScalarValue())) {
            deserializationContext.reportWrongTokenException(baseType(), jsonToken, "need JSON String, Number of Boolean that contains type id (for subtype of %s)", baseTypeName());
            return null;
        }
        String strS0 = jsonParser.S0();
        jsonParser.n1();
        return strS0;
    }

    protected boolean _usesExternalId() {
        return false;
    }

    @Override // defpackage.m63
    public Object deserializeTypedFromAny(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    @Override // defpackage.m63
    public Object deserializeTypedFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    @Override // defpackage.m63
    public Object deserializeTypedFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    @Override // defpackage.m63
    public Object deserializeTypedFromScalar(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.TypeDeserializerBase, defpackage.m63
    public m63 forProperty(BeanProperty beanProperty) {
        return beanProperty == this._property ? this : new AsArrayTypeDeserializer(this, beanProperty);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.TypeDeserializerBase, defpackage.m63
    public JsonTypeInfo.As getTypeInclusion() {
        return JsonTypeInfo.As.WRAPPER_ARRAY;
    }

    public AsArrayTypeDeserializer(AsArrayTypeDeserializer asArrayTypeDeserializer, BeanProperty beanProperty) {
        super(asArrayTypeDeserializer, beanProperty);
    }
}
