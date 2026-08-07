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
public class AsWrapperTypeDeserializer extends TypeDeserializerBase implements Serializable {
    private static final long serialVersionUID = 1;

    public AsWrapperTypeDeserializer(JavaType javaType, n63 n63Var, String str, boolean z, JavaType javaType2) {
        super(javaType, n63Var, str, z, javaType2);
    }

    protected Object _deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objX0;
        if (jsonParser.w() && (objX0 = jsonParser.X0()) != null) {
            return _deserializeWithNativeTypeId(jsonParser, deserializationContext, objX0);
        }
        JsonToken jsonTokenD = jsonParser.D();
        JsonToken jsonToken = JsonToken.START_OBJECT;
        if (jsonTokenD == jsonToken) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            JsonToken jsonToken2 = JsonToken.FIELD_NAME;
            if (jsonTokenN1 != jsonToken2) {
                deserializationContext.reportWrongTokenException(baseType(), jsonToken2, "need JSON String that contains type id (for subtype of " + baseTypeName() + ")", new Object[0]);
            }
        } else if (jsonTokenD != JsonToken.FIELD_NAME) {
            deserializationContext.reportWrongTokenException(baseType(), jsonToken, "need JSON Object to contain As.WRAPPER_OBJECT type information for class " + baseTypeName(), new Object[0]);
        }
        String strS0 = jsonParser.S0();
        s51 s51Var_findDeserializer = _findDeserializer(deserializationContext, strS0);
        jsonParser.n1();
        if (this._typeIdVisible && jsonParser.d1(jsonToken)) {
            q33 q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
            q33VarBufferForInputBuffering.s1();
            q33VarBufferForInputBuffering.V0(this._typePropertyName);
            q33VarBufferForInputBuffering.w1(strS0);
            jsonParser.y();
            jsonParser = t61.x1(false, q33VarBufferForInputBuffering.P1(jsonParser), jsonParser);
            jsonParser.n1();
        }
        Object objDeserialize = s51Var_findDeserializer.deserialize(jsonParser, deserializationContext);
        JsonToken jsonTokenN2 = jsonParser.n1();
        JsonToken jsonToken3 = JsonToken.END_OBJECT;
        if (jsonTokenN2 != jsonToken3) {
            deserializationContext.reportWrongTokenException(baseType(), jsonToken3, "expected closing END_OBJECT after type information and deserialized value", new Object[0]);
        }
        return objDeserialize;
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
        return beanProperty == this._property ? this : new AsWrapperTypeDeserializer(this, beanProperty);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.TypeDeserializerBase, defpackage.m63
    public JsonTypeInfo.As getTypeInclusion() {
        return JsonTypeInfo.As.WRAPPER_OBJECT;
    }

    protected AsWrapperTypeDeserializer(AsWrapperTypeDeserializer asWrapperTypeDeserializer, BeanProperty beanProperty) {
        super(asWrapperTypeDeserializer, beanProperty);
    }
}
