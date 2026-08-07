package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.c;
import com.fasterxml.jackson.databind.type.LogicalType;
import defpackage.ay;
import defpackage.e41;
import defpackage.gs1;
import defpackage.m63;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@e41
public class CollectionDeserializer extends ContainerDeserializerBase<Collection<Object>> implements v30 {
    private static final long serialVersionUID = -1;
    protected final s51 _delegateDeserializer;
    protected final s51 _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final m63 _valueTypeDeserializer;

    private static final class a extends c.a {
        private final b c;
        public final List d;

        a(b bVar, UnresolvedForwardReference unresolvedForwardReference, Class cls) {
            super(unresolvedForwardReference, cls);
            this.d = new ArrayList();
            this.c = bVar;
        }
    }

    public static class b {
        private final Class a;
        private final Collection b;
        private List c = new ArrayList();

        public b(Class cls, Collection collection) {
            this.a = cls;
            this.b = collection;
        }

        public void a(Object obj) {
            if (this.c.isEmpty()) {
                this.b.add(obj);
            } else {
                List list = this.c;
                ((a) list.get(list.size() - 1)).d.add(obj);
            }
        }

        public c.a b(UnresolvedForwardReference unresolvedForwardReference) {
            a aVar = new a(this, unresolvedForwardReference, this.a);
            this.c.add(aVar);
            return aVar;
        }
    }

    public CollectionDeserializer(JavaType javaType, s51 s51Var, m63 m63Var, ValueInstantiator valueInstantiator) {
        this(javaType, s51Var, m63Var, valueInstantiator, null, null, null);
    }

    protected Collection<Object> _deserializeFromArray(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException {
        Object objDeserialize;
        jsonParser.s1(collection);
        s51 s51Var = this._valueDeserializer;
        if (s51Var.getObjectIdReader() != null) {
            return _deserializeWithObjectId(jsonParser, deserializationContext, collection);
        }
        m63 m63Var = this._valueTypeDeserializer;
        while (true) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            if (jsonTokenN1 == JsonToken.END_ARRAY) {
                return collection;
            }
            try {
                if (jsonTokenN1 != JsonToken.VALUE_NULL) {
                    objDeserialize = m63Var == null ? s51Var.deserialize(jsonParser, deserializationContext) : s51Var.deserializeWithType(jsonParser, deserializationContext, m63Var);
                } else if (!this._skipNullValues) {
                    objDeserialize = this._nullProvider.getNullValue(deserializationContext);
                }
                collection.add(objDeserialize);
            } catch (Exception e) {
                if (deserializationContext != null && !deserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS)) {
                    ay.j0(e);
                }
                throw JsonMappingException.wrapWithPath(e, collection, collection.size());
            }
        }
    }

    protected Collection<Object> _deserializeFromString(JsonParser jsonParser, DeserializationContext deserializationContext, String str) throws IOException {
        Class<?> clsHandledType = handledType();
        if (str.isEmpty()) {
            CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(logicalType(), clsHandledType, CoercionInputShape.EmptyString);
            if (coercionActionFindCoercionAction != null && coercionActionFindCoercionAction != CoercionAction.Fail) {
                return (Collection) _deserializeFromEmptyString(jsonParser, deserializationContext, coercionActionFindCoercionAction, clsHandledType, "empty String (\"\")");
            }
        } else if (StdDeserializer._isBlank(str)) {
            LogicalType logicalType = logicalType();
            CoercionAction coercionAction = CoercionAction.Fail;
            CoercionAction coercionActionFindCoercionFromBlankString = deserializationContext.findCoercionFromBlankString(logicalType, clsHandledType, coercionAction);
            if (coercionActionFindCoercionFromBlankString != coercionAction) {
                return (Collection) _deserializeFromEmptyString(jsonParser, deserializationContext, coercionActionFindCoercionFromBlankString, clsHandledType, "blank String (all whitespace)");
            }
        }
        return handleNonArray(jsonParser, deserializationContext, createDefaultInstance(deserializationContext));
    }

    protected Collection<Object> _deserializeWithObjectId(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException {
        Object objDeserialize;
        if (!jsonParser.i1()) {
            return handleNonArray(jsonParser, deserializationContext, collection);
        }
        jsonParser.s1(collection);
        s51 s51Var = this._valueDeserializer;
        m63 m63Var = this._valueTypeDeserializer;
        b bVar = new b(this._containerType.mo15getContentType().getRawClass(), collection);
        while (true) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            if (jsonTokenN1 == JsonToken.END_ARRAY) {
                return collection;
            }
            try {
                if (jsonTokenN1 != JsonToken.VALUE_NULL) {
                    objDeserialize = m63Var == null ? s51Var.deserialize(jsonParser, deserializationContext) : s51Var.deserializeWithType(jsonParser, deserializationContext, m63Var);
                } else if (!this._skipNullValues) {
                    objDeserialize = this._nullProvider.getNullValue(deserializationContext);
                }
                bVar.a(objDeserialize);
            } catch (UnresolvedForwardReference e) {
                e.getRoid().a(bVar.b(e));
            } catch (Exception e2) {
                if (deserializationContext != null && !deserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS)) {
                    ay.j0(e2);
                }
                throw JsonMappingException.wrapWithPath(e2, collection, collection.size());
            }
        }
    }

    protected Collection<Object> createDefaultInstance(DeserializationContext deserializationContext) throws IOException {
        return (Collection) this._valueInstantiator.createUsingDefault(deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return m63Var.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public s51 getContentDeserializer() {
        return this._valueDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    protected final Collection<Object> handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException {
        Object objDeserialize;
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return (Collection) deserializationContext.handleUnexpectedToken(this._containerType, jsonParser);
        }
        s51 s51Var = this._valueDeserializer;
        m63 m63Var = this._valueTypeDeserializer;
        try {
            if (!jsonParser.d1(JsonToken.VALUE_NULL)) {
                objDeserialize = m63Var == null ? s51Var.deserialize(jsonParser, deserializationContext) : s51Var.deserializeWithType(jsonParser, deserializationContext, m63Var);
            } else {
                if (this._skipNullValues) {
                    return collection;
                }
                objDeserialize = this._nullProvider.getNullValue(deserializationContext);
            }
            collection.add(objDeserialize);
            return collection;
        } catch (Exception e) {
            if (!deserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS)) {
                ay.j0(e);
            }
            throw JsonMappingException.wrapWithPath(e, Object.class, collection.size());
        }
    }

    @Override // defpackage.s51
    public boolean isCachable() {
        return this._valueDeserializer == null && this._valueTypeDeserializer == null && this._delegateDeserializer == null;
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.Collection;
    }

    protected CollectionDeserializer withResolved(s51 s51Var, s51 s51Var2, m63 m63Var, gs1 gs1Var, Boolean bool) {
        return new CollectionDeserializer(this._containerType, s51Var2, m63Var, this._valueInstantiator, s51Var, gs1Var, bool);
    }

    protected CollectionDeserializer(JavaType javaType, s51 s51Var, m63 m63Var, ValueInstantiator valueInstantiator, s51 s51Var2, gs1 gs1Var, Boolean bool) {
        super(javaType, gs1Var, bool);
        this._valueDeserializer = s51Var;
        this._valueTypeDeserializer = m63Var;
        this._valueInstantiator = valueInstantiator;
        this._delegateDeserializer = s51Var2;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0067  */
    @Override // defpackage.v30
    public CollectionDeserializer createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        s51 s51VarFindDeserializer;
        ValueInstantiator valueInstantiator = this._valueInstantiator;
        if (valueInstantiator == null) {
            s51VarFindDeserializer = null;
        } else if (valueInstantiator.canCreateUsingDelegate()) {
            JavaType delegateType = this._valueInstantiator.getDelegateType(deserializationContext.getConfig());
            if (delegateType == null) {
                JavaType javaType = this._containerType;
                deserializationContext.reportBadDefinition(javaType, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", javaType, this._valueInstantiator.getClass().getName()));
            }
            s51VarFindDeserializer = findDeserializer(deserializationContext, delegateType, beanProperty);
        } else if (this._valueInstantiator.canCreateUsingArrayDelegate()) {
            JavaType arrayDelegateType = this._valueInstantiator.getArrayDelegateType(deserializationContext.getConfig());
            if (arrayDelegateType == null) {
                JavaType javaType2 = this._containerType;
                deserializationContext.reportBadDefinition(javaType2, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", javaType2, this._valueInstantiator.getClass().getName()));
            }
            s51VarFindDeserializer = findDeserializer(deserializationContext, arrayDelegateType, beanProperty);
        } else {
            s51VarFindDeserializer = null;
        }
        s51 s51Var = s51VarFindDeserializer;
        Boolean boolFindFormatFeature = findFormatFeature(deserializationContext, beanProperty, Collection.class, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        s51 s51VarFindConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, beanProperty, this._valueDeserializer);
        JavaType javaTypeMo15getContentType = this._containerType.mo15getContentType();
        s51 s51VarFindContextualValueDeserializer = s51VarFindConvertingContentDeserializer == null ? deserializationContext.findContextualValueDeserializer(javaTypeMo15getContentType, beanProperty) : deserializationContext.handleSecondaryContextualization(s51VarFindConvertingContentDeserializer, beanProperty, javaTypeMo15getContentType);
        m63 m63VarForProperty = this._valueTypeDeserializer;
        if (m63VarForProperty != null) {
            m63VarForProperty = m63VarForProperty.forProperty(beanProperty);
        }
        m63 m63Var = m63VarForProperty;
        gs1 gs1VarFindContentNullProvider = findContentNullProvider(deserializationContext, beanProperty, s51VarFindContextualValueDeserializer);
        return (Objects.equals(boolFindFormatFeature, this._unwrapSingle) && gs1VarFindContentNullProvider == this._nullProvider && s51Var == this._delegateDeserializer && s51VarFindContextualValueDeserializer == this._valueDeserializer && m63Var == this._valueTypeDeserializer) ? this : withResolved(s51Var, s51VarFindContextualValueDeserializer, m63Var, gs1VarFindContentNullProvider, boolFindFormatFeature);
    }

    @Override // defpackage.s51
    public Collection<Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        s51 s51Var = this._delegateDeserializer;
        if (s51Var != null) {
            return (Collection) this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var.deserialize(jsonParser, deserializationContext));
        }
        if (jsonParser.i1()) {
            return _deserializeFromArray(jsonParser, deserializationContext, createDefaultInstance(deserializationContext));
        }
        if (jsonParser.d1(JsonToken.VALUE_STRING)) {
            return _deserializeFromString(jsonParser, deserializationContext, jsonParser.S0());
        }
        return handleNonArray(jsonParser, deserializationContext, createDefaultInstance(deserializationContext));
    }

    protected CollectionDeserializer(CollectionDeserializer collectionDeserializer) {
        super(collectionDeserializer);
        this._valueDeserializer = collectionDeserializer._valueDeserializer;
        this._valueTypeDeserializer = collectionDeserializer._valueTypeDeserializer;
        this._valueInstantiator = collectionDeserializer._valueInstantiator;
        this._delegateDeserializer = collectionDeserializer._delegateDeserializer;
    }

    @Override // defpackage.s51
    public Collection<Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException {
        if (jsonParser.i1()) {
            return _deserializeFromArray(jsonParser, deserializationContext, collection);
        }
        return handleNonArray(jsonParser, deserializationContext, collection);
    }
}
