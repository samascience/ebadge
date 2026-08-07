package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import defpackage.m63;
import defpackage.n63;
import defpackage.q33;
import defpackage.s51;
import defpackage.t61;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class AsPropertyTypeDeserializer extends AsArrayTypeDeserializer {
    private static final long serialVersionUID = 1;
    protected final JsonTypeInfo.As _inclusion;
    protected final String _msgForMissingId;

    public AsPropertyTypeDeserializer(JavaType javaType, n63 n63Var, String str, boolean z, JavaType javaType2) {
        this(javaType, n63Var, str, z, javaType2, JsonTypeInfo.As.PROPERTY);
    }

    protected Object _deserializeTypedForId(JsonParser jsonParser, DeserializationContext deserializationContext, q33 q33Var, String str) throws IOException {
        s51 s51Var_findDeserializer = _findDeserializer(deserializationContext, str);
        if (this._typeIdVisible) {
            if (q33Var == null) {
                q33Var = deserializationContext.bufferForInputBuffering(jsonParser);
            }
            q33Var.V0(jsonParser.C());
            q33Var.w1(str);
        }
        if (q33Var != null) {
            jsonParser.y();
            jsonParser = t61.x1(false, q33Var.P1(jsonParser), jsonParser);
        }
        if (jsonParser.D() != JsonToken.END_OBJECT) {
            jsonParser.n1();
        }
        return s51Var_findDeserializer.deserialize(jsonParser, deserializationContext);
    }

    @Deprecated
    protected Object _deserializeTypedUsingDefaultImpl(JsonParser jsonParser, DeserializationContext deserializationContext, q33 q33Var) throws IOException {
        return _deserializeTypedUsingDefaultImpl(jsonParser, deserializationContext, q33Var, null);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, defpackage.m63
    public Object deserializeTypedFromAny(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return jsonParser.d1(JsonToken.START_ARRAY) ? super.deserializeTypedFromArray(jsonParser, deserializationContext) : deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, defpackage.m63
    public Object deserializeTypedFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String strA1;
        Object objX0;
        if (jsonParser.w() && (objX0 = jsonParser.X0()) != null) {
            return _deserializeWithNativeTypeId(jsonParser, deserializationContext, objX0);
        }
        JsonToken jsonTokenD = jsonParser.D();
        q33 q33VarBufferForInputBuffering = null;
        if (jsonTokenD == JsonToken.START_OBJECT) {
            jsonTokenD = jsonParser.n1();
        } else if (jsonTokenD != JsonToken.FIELD_NAME) {
            return _deserializeTypedUsingDefaultImpl(jsonParser, deserializationContext, null, this._msgForMissingId);
        }
        boolean zIsEnabled = deserializationContext.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        while (jsonTokenD == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            jsonParser.n1();
            if ((strC.equals(this._typePropertyName) || (zIsEnabled && strC.equalsIgnoreCase(this._typePropertyName))) && (strA1 = jsonParser.a1()) != null) {
                return _deserializeTypedForId(jsonParser, deserializationContext, q33VarBufferForInputBuffering, strA1);
            }
            if (q33VarBufferForInputBuffering == null) {
                q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
            }
            q33VarBufferForInputBuffering.V0(strC);
            q33VarBufferForInputBuffering.R1(jsonParser);
            jsonTokenD = jsonParser.n1();
        }
        return _deserializeTypedUsingDefaultImpl(jsonParser, deserializationContext, q33VarBufferForInputBuffering, this._msgForMissingId);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, com.fasterxml.jackson.databind.jsontype.impl.TypeDeserializerBase, defpackage.m63
    public m63 forProperty(BeanProperty beanProperty) {
        return beanProperty == this._property ? this : new AsPropertyTypeDeserializer(this, beanProperty);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, com.fasterxml.jackson.databind.jsontype.impl.TypeDeserializerBase, defpackage.m63
    public JsonTypeInfo.As getTypeInclusion() {
        return this._inclusion;
    }

    public AsPropertyTypeDeserializer(JavaType javaType, n63 n63Var, String str, boolean z, JavaType javaType2, JsonTypeInfo.As as) {
        super(javaType, n63Var, str, z, javaType2);
        BeanProperty beanProperty = this._property;
        this._msgForMissingId = beanProperty == null ? String.format("missing type id property '%s'", this._typePropertyName) : String.format("missing type id property '%s' (for POJO property '%s')", this._typePropertyName, beanProperty.getName());
        this._inclusion = as;
    }

    protected Object _deserializeTypedUsingDefaultImpl(JsonParser jsonParser, DeserializationContext deserializationContext, q33 q33Var, String str) throws IOException {
        if (!hasDefaultImpl()) {
            Object objDeserializeIfNatural = m63.deserializeIfNatural(jsonParser, deserializationContext, this._baseType);
            if (objDeserializeIfNatural != null) {
                return objDeserializeIfNatural;
            }
            if (jsonParser.i1()) {
                return super.deserializeTypedFromAny(jsonParser, deserializationContext);
            }
            if (jsonParser.d1(JsonToken.VALUE_STRING) && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.S0().trim().isEmpty()) {
                return null;
            }
        }
        s51 s51Var_findDefaultImplDeserializer = _findDefaultImplDeserializer(deserializationContext);
        if (s51Var_findDefaultImplDeserializer == null) {
            JavaType javaType_handleMissingTypeId = _handleMissingTypeId(deserializationContext, str);
            if (javaType_handleMissingTypeId == null) {
                return null;
            }
            s51Var_findDefaultImplDeserializer = deserializationContext.findContextualValueDeserializer(javaType_handleMissingTypeId, this._property);
        }
        if (q33Var != null) {
            q33Var.S0();
            jsonParser = q33Var.P1(jsonParser);
            jsonParser.n1();
        }
        return s51Var_findDefaultImplDeserializer.deserialize(jsonParser, deserializationContext);
    }

    public AsPropertyTypeDeserializer(AsPropertyTypeDeserializer asPropertyTypeDeserializer, BeanProperty beanProperty) {
        String str;
        super(asPropertyTypeDeserializer, beanProperty);
        BeanProperty beanProperty2 = this._property;
        if (beanProperty2 == null) {
            str = String.format("missing type id property '%s'", this._typePropertyName);
        } else {
            str = String.format("missing type id property '%s' (for POJO property '%s')", this._typePropertyName, beanProperty2.getName());
        }
        this._msgForMissingId = str;
        this._inclusion = asPropertyTypeDeserializer._inclusion;
    }
}
