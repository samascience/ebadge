package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.type.LogicalType;
import defpackage.a91;
import defpackage.e41;
import defpackage.m63;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@e41
public class MapEntryDeserializer extends ContainerDeserializerBase<Map.Entry<Object, Object>> implements v30 {
    private static final long serialVersionUID = 1;
    protected final a91 _keyDeserializer;
    protected final s51 _valueDeserializer;
    protected final m63 _valueTypeDeserializer;

    public MapEntryDeserializer(JavaType javaType, a91 a91Var, s51 s51Var, m63 m63Var) {
        super(javaType);
        if (javaType.containedTypeCount() == 2) {
            this._keyDeserializer = a91Var;
            this._valueDeserializer = s51Var;
            this._valueTypeDeserializer = m63Var;
        } else {
            throw new IllegalArgumentException("Missing generic type information for " + javaType);
        }
    }

    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        a91 a91VarFindKeyDeserializer = this._keyDeserializer;
        if (a91VarFindKeyDeserializer == null) {
            a91VarFindKeyDeserializer = deserializationContext.findKeyDeserializer(this._containerType.mo14containedType(0), beanProperty);
        }
        s51 s51VarFindConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, beanProperty, this._valueDeserializer);
        JavaType javaTypeMo14containedType = this._containerType.mo14containedType(1);
        s51 s51VarFindContextualValueDeserializer = s51VarFindConvertingContentDeserializer == null ? deserializationContext.findContextualValueDeserializer(javaTypeMo14containedType, beanProperty) : deserializationContext.handleSecondaryContextualization(s51VarFindConvertingContentDeserializer, beanProperty, javaTypeMo14containedType);
        m63 m63VarForProperty = this._valueTypeDeserializer;
        if (m63VarForProperty != null) {
            m63VarForProperty = m63VarForProperty.forProperty(beanProperty);
        }
        return withResolved(a91VarFindKeyDeserializer, m63VarForProperty, s51VarFindContextualValueDeserializer);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return m63Var.deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public s51 getContentDeserializer() {
        return this._valueDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public JavaType getContentType() {
        return this._containerType.mo14containedType(1);
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.Map;
    }

    protected MapEntryDeserializer withResolved(a91 a91Var, m63 m63Var, s51 s51Var) {
        return (this._keyDeserializer == a91Var && this._valueDeserializer == s51Var && this._valueTypeDeserializer == m63Var) ? this : new MapEntryDeserializer(this, a91Var, s51Var, m63Var);
    }

    @Override // defpackage.s51
    public Map.Entry<Object, Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objDeserializeWithType;
        JsonToken jsonTokenD = jsonParser.D();
        if (jsonTokenD == JsonToken.START_OBJECT) {
            jsonTokenD = jsonParser.n1();
        } else if (jsonTokenD != JsonToken.FIELD_NAME && jsonTokenD != JsonToken.END_OBJECT) {
            if (jsonTokenD == JsonToken.START_ARRAY) {
                return _deserializeFromArray(jsonParser, deserializationContext);
            }
            return (Map.Entry) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
        }
        if (jsonTokenD != JsonToken.FIELD_NAME) {
            if (jsonTokenD == JsonToken.END_OBJECT) {
                return (Map.Entry) deserializationContext.reportInputMismatch(this, "Cannot deserialize a Map.Entry out of empty JSON Object", new Object[0]);
            }
            return (Map.Entry) deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
        }
        a91 a91Var = this._keyDeserializer;
        s51 s51Var = this._valueDeserializer;
        m63 m63Var = this._valueTypeDeserializer;
        String strC = jsonParser.C();
        Object objDeserializeKey = a91Var.deserializeKey(strC, deserializationContext);
        try {
            if (jsonParser.n1() == JsonToken.VALUE_NULL) {
                objDeserializeWithType = s51Var.getNullValue(deserializationContext);
            } else if (m63Var == null) {
                objDeserializeWithType = s51Var.deserialize(jsonParser, deserializationContext);
            } else {
                objDeserializeWithType = s51Var.deserializeWithType(jsonParser, deserializationContext, m63Var);
            }
        } catch (Exception e) {
            wrapAndThrow(deserializationContext, e, Map.Entry.class, strC);
            objDeserializeWithType = null;
        }
        JsonToken jsonTokenN1 = jsonParser.n1();
        if (jsonTokenN1 != JsonToken.END_OBJECT) {
            if (jsonTokenN1 == JsonToken.FIELD_NAME) {
                deserializationContext.reportInputMismatch(this, "Problem binding JSON into Map.Entry: more than one entry in JSON (second field: '%s')", jsonParser.C());
            } else {
                deserializationContext.reportInputMismatch(this, "Problem binding JSON into Map.Entry: unexpected content after JSON Object entry: " + jsonTokenN1, new Object[0]);
            }
            return null;
        }
        return new AbstractMap.SimpleEntry(objDeserializeKey, objDeserializeWithType);
    }

    protected MapEntryDeserializer(MapEntryDeserializer mapEntryDeserializer) {
        super(mapEntryDeserializer);
        this._keyDeserializer = mapEntryDeserializer._keyDeserializer;
        this._valueDeserializer = mapEntryDeserializer._valueDeserializer;
        this._valueTypeDeserializer = mapEntryDeserializer._valueTypeDeserializer;
    }

    protected MapEntryDeserializer(MapEntryDeserializer mapEntryDeserializer, a91 a91Var, s51 s51Var, m63 m63Var) {
        super(mapEntryDeserializer);
        this._keyDeserializer = a91Var;
        this._valueDeserializer = s51Var;
        this._valueTypeDeserializer = m63Var;
    }

    @Override // defpackage.s51
    public Map.Entry<Object, Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Map.Entry<Object, Object> entry) throws IOException {
        throw new IllegalStateException("Cannot update Map.Entry values");
    }
}
