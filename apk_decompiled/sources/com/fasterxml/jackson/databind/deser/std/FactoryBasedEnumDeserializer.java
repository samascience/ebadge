package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.b;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.tencent.connect.common.Constants;
import defpackage.ay;
import defpackage.m63;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class FactoryBasedEnumDeserializer extends StdDeserializer<Object> implements v30 {
    private static final long serialVersionUID = 1;
    protected final SettableBeanProperty[] _creatorProps;
    protected final s51 _deser;
    protected final AnnotatedMethod _factory;
    protected final boolean _hasArgs;
    protected final JavaType _inputType;
    private transient PropertyBasedCreator _propCreator;
    protected final ValueInstantiator _valueInstantiator;

    public FactoryBasedEnumDeserializer(Class<?> cls, AnnotatedMethod annotatedMethod, JavaType javaType, ValueInstantiator valueInstantiator, SettableBeanProperty[] settableBeanPropertyArr) {
        super(cls);
        this._factory = annotatedMethod;
        this._hasArgs = true;
        this._inputType = (javaType.hasRawClass(String.class) || javaType.hasRawClass(CharSequence.class)) ? null : javaType;
        this._deser = null;
        this._valueInstantiator = valueInstantiator;
        this._creatorProps = settableBeanPropertyArr;
    }

    private Throwable throwOrReturnThrowable(Throwable th, DeserializationContext deserializationContext) throws IOException {
        Throwable thF = ay.F(th);
        ay.h0(thF);
        boolean z = deserializationContext == null || deserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS);
        if (thF instanceof IOException) {
            if (!z || !(thF instanceof JacksonException)) {
                throw ((IOException) thF);
            }
        } else if (!z) {
            ay.j0(thF);
        }
        return thF;
    }

    protected final Object _deserializeWithErrorWrapping(JsonParser jsonParser, DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) throws IOException {
        try {
            return settableBeanProperty.deserialize(jsonParser, deserializationContext);
        } catch (Exception e) {
            return wrapAndThrow(e, handledType(), settableBeanProperty.getName(), deserializationContext);
        }
    }

    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        JavaType javaType;
        return (this._deser == null && (javaType = this._inputType) != null && this._creatorProps == null) ? new FactoryBasedEnumDeserializer(this, deserializationContext.findContextualValueDeserializer(javaType, beanProperty)) : this;
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String strA1;
        Object objDeserialize;
        s51 s51Var = this._deser;
        if (s51Var != null) {
            objDeserialize = s51Var.deserialize(jsonParser, deserializationContext);
        } else {
            if (!this._hasArgs) {
                jsonParser.v1();
                try {
                    return this._factory.call();
                } catch (Exception e) {
                    return deserializationContext.handleInstantiationProblem(this._valueClass, null, ay.k0(e));
                }
            }
            if (this._creatorProps != null) {
                if (!jsonParser.j1()) {
                    JavaType valueType = getValueType(deserializationContext);
                    deserializationContext.reportInputMismatch(valueType, "Input mismatch reading Enum %s: properties-based `@JsonCreator` (%s) expects JSON Object (JsonToken.START_OBJECT), got JsonToken.%s", ay.G(valueType), this._factory, jsonParser.D());
                }
                if (this._propCreator == null) {
                    this._propCreator = PropertyBasedCreator.c(deserializationContext, this._valueInstantiator, this._creatorProps, deserializationContext.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
                }
                jsonParser.n1();
                return deserializeEnumUsingPropertyBased(jsonParser, deserializationContext, this._propCreator);
            }
            JsonToken jsonTokenD = jsonParser.D();
            boolean z = jsonTokenD == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
            if (z) {
                jsonTokenD = jsonParser.n1();
            }
            if (jsonTokenD == null || !jsonTokenD.isScalarValue()) {
                jsonParser.v1();
                strA1 = Constants.STR_EMPTY;
            } else {
                strA1 = jsonParser.a1();
            }
            if (z && jsonParser.n1() != JsonToken.END_ARRAY) {
                handleMissingEndArrayForSingle(jsonParser, deserializationContext);
            }
            objDeserialize = strA1;
        }
        try {
            return this._factory.callOnWith(this._valueClass, objDeserialize);
        } catch (Exception e2) {
            Throwable thK0 = ay.k0(e2);
            if ((thK0 instanceof IllegalArgumentException) && deserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return null;
            }
            return deserializationContext.handleInstantiationProblem(this._valueClass, objDeserialize, thK0);
        }
    }

    protected Object deserializeEnumUsingPropertyBased(JsonParser jsonParser, DeserializationContext deserializationContext, PropertyBasedCreator propertyBasedCreator) throws IOException {
        b bVarG = propertyBasedCreator.g(jsonParser, deserializationContext, null);
        JsonToken jsonTokenD = jsonParser.D();
        while (jsonTokenD == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            jsonParser.n1();
            SettableBeanProperty settableBeanPropertyE = propertyBasedCreator.e(strC);
            if (!bVarG.i(strC) || settableBeanPropertyE != null) {
                if (settableBeanPropertyE != null) {
                    bVarG.b(settableBeanPropertyE, _deserializeWithErrorWrapping(jsonParser, deserializationContext, settableBeanPropertyE));
                } else {
                    jsonParser.v1();
                }
            }
            jsonTokenD = jsonParser.n1();
        }
        return propertyBasedCreator.a(deserializationContext, bVarG);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return this._deser == null ? deserialize(jsonParser, deserializationContext) : m63Var.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // defpackage.s51
    public boolean isCachable() {
        return true;
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.Enum;
    }

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return Boolean.FALSE;
    }

    protected Object wrapAndThrow(Throwable th, Object obj, String str, DeserializationContext deserializationContext) throws IOException {
        throw JsonMappingException.wrapWithPath(throwOrReturnThrowable(th, deserializationContext), obj, str);
    }

    public FactoryBasedEnumDeserializer(Class<?> cls, AnnotatedMethod annotatedMethod) {
        super(cls);
        this._factory = annotatedMethod;
        this._hasArgs = false;
        this._inputType = null;
        this._deser = null;
        this._valueInstantiator = null;
        this._creatorProps = null;
    }

    protected FactoryBasedEnumDeserializer(FactoryBasedEnumDeserializer factoryBasedEnumDeserializer, s51 s51Var) {
        super(factoryBasedEnumDeserializer._valueClass);
        this._inputType = factoryBasedEnumDeserializer._inputType;
        this._factory = factoryBasedEnumDeserializer._factory;
        this._hasArgs = factoryBasedEnumDeserializer._hasArgs;
        this._valueInstantiator = factoryBasedEnumDeserializer._valueInstantiator;
        this._creatorProps = factoryBasedEnumDeserializer._creatorProps;
        this._deser = s51Var;
    }
}
