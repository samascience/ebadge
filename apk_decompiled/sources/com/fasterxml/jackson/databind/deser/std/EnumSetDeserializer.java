package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import defpackage.gs1;
import defpackage.m63;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class EnumSetDeserializer extends StdDeserializer<EnumSet<?>> implements v30 {
    private static final long serialVersionUID = 1;
    protected s51 _enumDeserializer;
    protected final JavaType _enumType;
    protected final gs1 _nullProvider;
    protected final boolean _skipNullValues;
    protected final Boolean _unwrapSingle;

    public EnumSetDeserializer(JavaType javaType, s51 s51Var) {
        super((Class<?>) EnumSet.class);
        this._enumType = javaType;
        if (javaType.isEnumType()) {
            this._enumDeserializer = s51Var;
            this._unwrapSingle = null;
            this._nullProvider = null;
            this._skipNullValues = false;
            return;
        }
        throw new IllegalArgumentException("Type " + javaType + " not Java Enum type");
    }

    private EnumSet constructSet() {
        return EnumSet.noneOf(this._enumType.getRawClass());
    }

    protected final EnumSet<?> _deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, EnumSet enumSet) throws IOException {
        Enum r0;
        while (true) {
            try {
                JsonToken jsonTokenN1 = jsonParser.n1();
                if (jsonTokenN1 == JsonToken.END_ARRAY) {
                    return enumSet;
                }
                if (jsonTokenN1 != JsonToken.VALUE_NULL) {
                    r0 = (Enum) this._enumDeserializer.deserialize(jsonParser, deserializationContext);
                } else if (!this._skipNullValues) {
                    r0 = (Enum) this._nullProvider.getNullValue(deserializationContext);
                }
                if (r0 != null) {
                    enumSet.add(r0);
                }
            } catch (Exception e) {
                throw JsonMappingException.wrapWithPath(e, enumSet, enumSet.size());
            }
        }
    }

    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        Boolean boolFindFormatFeature = findFormatFeature(deserializationContext, beanProperty, EnumSet.class, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        s51 s51Var = this._enumDeserializer;
        s51 s51VarFindContextualValueDeserializer = s51Var == null ? deserializationContext.findContextualValueDeserializer(this._enumType, beanProperty) : deserializationContext.handleSecondaryContextualization(s51Var, beanProperty, this._enumType);
        return withResolved(s51VarFindContextualValueDeserializer, findContentNullProvider(deserializationContext, beanProperty, s51VarFindContextualValueDeserializer), boolFindFormatFeature);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return m63Var.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    @Override // defpackage.s51
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.DYNAMIC;
    }

    @Override // defpackage.s51
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return constructSet();
    }

    protected EnumSet<?> handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext, EnumSet enumSet) throws IOException {
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return (EnumSet) deserializationContext.handleUnexpectedToken(EnumSet.class, jsonParser);
        }
        if (jsonParser.d1(JsonToken.VALUE_NULL)) {
            return (EnumSet) deserializationContext.handleUnexpectedToken(this._enumType, jsonParser);
        }
        try {
            Enum r3 = (Enum) this._enumDeserializer.deserialize(jsonParser, deserializationContext);
            if (r3 != null) {
                enumSet.add(r3);
            }
            return enumSet;
        } catch (Exception e) {
            throw JsonMappingException.wrapWithPath(e, enumSet, enumSet.size());
        }
    }

    @Override // defpackage.s51
    public boolean isCachable() {
        return this._enumType.getValueHandler() == null;
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.Collection;
    }

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return Boolean.TRUE;
    }

    public EnumSetDeserializer withDeserializer(s51 s51Var) {
        return this._enumDeserializer == s51Var ? this : new EnumSetDeserializer(this, s51Var, this._nullProvider, this._unwrapSingle);
    }

    @Deprecated
    public EnumSetDeserializer withResolved(s51 s51Var, Boolean bool) {
        return withResolved(s51Var, this._nullProvider, bool);
    }

    public EnumSetDeserializer withResolved(s51 s51Var, gs1 gs1Var, Boolean bool) {
        return (Objects.equals(this._unwrapSingle, bool) && this._enumDeserializer == s51Var && this._nullProvider == s51Var) ? this : new EnumSetDeserializer(this, s51Var, gs1Var, bool);
    }

    @Override // defpackage.s51
    public EnumSet<?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        EnumSet enumSetConstructSet = constructSet();
        if (!jsonParser.i1()) {
            return handleNonArray(jsonParser, deserializationContext, enumSetConstructSet);
        }
        return _deserialize(jsonParser, deserializationContext, enumSetConstructSet);
    }

    @Override // defpackage.s51
    public EnumSet<?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, EnumSet<?> enumSet) throws IOException {
        if (!jsonParser.i1()) {
            return handleNonArray(jsonParser, deserializationContext, enumSet);
        }
        return _deserialize(jsonParser, deserializationContext, enumSet);
    }

    @Deprecated
    protected EnumSetDeserializer(EnumSetDeserializer enumSetDeserializer, s51 s51Var, Boolean bool) {
        this(enumSetDeserializer, s51Var, enumSetDeserializer._nullProvider, bool);
    }

    protected EnumSetDeserializer(EnumSetDeserializer enumSetDeserializer, s51 s51Var, gs1 gs1Var, Boolean bool) {
        super(enumSetDeserializer);
        this._enumType = enumSetDeserializer._enumType;
        this._enumDeserializer = s51Var;
        this._nullProvider = gs1Var;
        this._skipNullValues = NullsConstantProvider.isSkipper(gs1Var);
        this._unwrapSingle = bool;
    }
}
