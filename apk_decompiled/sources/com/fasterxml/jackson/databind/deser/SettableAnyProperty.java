package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators;
import com.fasterxml.jackson.databind.deser.impl.c;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import defpackage.a91;
import defpackage.ay;
import defpackage.m63;
import defpackage.s51;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class SettableAnyProperty implements Serializable {
    private static final long serialVersionUID = 1;
    protected final a91 _keyDeserializer;
    protected final BeanProperty _property;
    protected final AnnotatedMember _setter;
    protected final boolean _setterIsField;
    protected final JavaType _type;
    protected s51 _valueDeserializer;
    protected final m63 _valueTypeDeserializer;

    protected static class JsonNodeFieldAnyProperty extends SettableAnyProperty implements Serializable {
        private static final long serialVersionUID = 1;
        protected final JsonNodeFactory _nodeFactory;

        public JsonNodeFieldAnyProperty(BeanProperty beanProperty, AnnotatedMember annotatedMember, JavaType javaType, s51 s51Var, JsonNodeFactory jsonNodeFactory) {
            super(beanProperty, annotatedMember, javaType, null, s51Var, null);
            this._nodeFactory = jsonNodeFactory;
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableAnyProperty
        protected void _set(Object obj, Object obj2, Object obj3) throws Exception {
            setProperty(obj, (String) obj2, (JsonNode) obj3);
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableAnyProperty
        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return this._valueDeserializer.deserialize(jsonParser, deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableAnyProperty
        public void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException {
            setProperty(obj, str, (JsonNode) deserialize(jsonParser, deserializationContext));
        }

        protected void setProperty(Object obj, String str, JsonNode jsonNode) throws IOException {
            ObjectNode objectNode;
            AnnotatedField annotatedField = (AnnotatedField) this._setter;
            Object value = annotatedField.getValue(obj);
            if (value == null) {
                objectNode = this._nodeFactory.objectNode();
                annotatedField.setValue(obj, objectNode);
            } else {
                if (!(value instanceof ObjectNode)) {
                    throw JsonMappingException.from((DeserializationContext) null, String.format("Value \"any-setter\" '%s' not `ObjectNode` but %s", getPropertyName(), ay.X(value.getClass())));
                }
                objectNode = (ObjectNode) value;
            }
            objectNode.set(str, jsonNode);
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableAnyProperty
        public SettableAnyProperty withValueDeserializer(s51 s51Var) {
            return this;
        }
    }

    protected static class MapFieldAnyProperty extends SettableAnyProperty implements Serializable {
        private static final long serialVersionUID = 1;
        protected final ValueInstantiator _valueInstantiator;

        public MapFieldAnyProperty(BeanProperty beanProperty, AnnotatedMember annotatedMember, JavaType javaType, a91 a91Var, s51 s51Var, m63 m63Var, ValueInstantiator valueInstantiator) {
            super(beanProperty, annotatedMember, javaType, a91Var, s51Var, m63Var);
            this._valueInstantiator = valueInstantiator;
        }

        protected Map<Object, Object> _createAndSetMap(DeserializationContext deserializationContext, AnnotatedField annotatedField, Object obj, Object obj2) throws IOException {
            ValueInstantiator valueInstantiator = this._valueInstantiator;
            if (valueInstantiator == null) {
                throw JsonMappingException.from(deserializationContext, String.format("Cannot create an instance of %s for use as \"any-setter\" '%s'", ay.X(this._type.getRawClass()), this._property.getName()));
            }
            Map<Object, Object> map = (Map) valueInstantiator.createUsingDefault(deserializationContext);
            annotatedField.setValue(obj, map);
            return map;
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableAnyProperty
        protected void _set(Object obj, Object obj2, Object obj3) throws Exception {
            AnnotatedField annotatedField = (AnnotatedField) this._setter;
            Map<Object, Object> map_createAndSetMap = (Map) annotatedField.getValue(obj);
            if (map_createAndSetMap == null) {
                map_createAndSetMap = _createAndSetMap(null, annotatedField, obj, obj2);
            }
            map_createAndSetMap.put(obj2, obj3);
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableAnyProperty
        public SettableAnyProperty withValueDeserializer(s51 s51Var) {
            return new MapFieldAnyProperty(this._property, this._setter, this._type, this._keyDeserializer, s51Var, this._valueTypeDeserializer, this._valueInstantiator);
        }
    }

    protected static class MethodAnyProperty extends SettableAnyProperty implements Serializable {
        private static final long serialVersionUID = 1;

        public MethodAnyProperty(BeanProperty beanProperty, AnnotatedMember annotatedMember, JavaType javaType, a91 a91Var, s51 s51Var, m63 m63Var) {
            super(beanProperty, annotatedMember, javaType, a91Var, s51Var, m63Var);
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableAnyProperty
        protected void _set(Object obj, Object obj2, Object obj3) throws Exception {
            ((AnnotatedMethod) this._setter).callOnWith(obj, obj2, obj3);
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableAnyProperty
        public SettableAnyProperty withValueDeserializer(s51 s51Var) {
            return new MethodAnyProperty(this._property, this._setter, this._type, this._keyDeserializer, s51Var, this._valueTypeDeserializer);
        }
    }

    private static class a extends c.a {
        private final SettableAnyProperty c;
        private final Object d;
        private final String e;

        public a(SettableAnyProperty settableAnyProperty, UnresolvedForwardReference unresolvedForwardReference, Class cls, Object obj, String str) {
            super(unresolvedForwardReference, cls);
            this.c = settableAnyProperty;
            this.d = obj;
            this.e = str;
        }
    }

    public SettableAnyProperty(BeanProperty beanProperty, AnnotatedMember annotatedMember, JavaType javaType, a91 a91Var, s51 s51Var, m63 m63Var) {
        this._property = beanProperty;
        this._setter = annotatedMember;
        this._type = javaType;
        this._valueDeserializer = s51Var;
        this._valueTypeDeserializer = m63Var;
        this._keyDeserializer = a91Var;
        this._setterIsField = annotatedMember instanceof AnnotatedField;
    }

    public static SettableAnyProperty constructForJsonNodeField(DeserializationContext deserializationContext, BeanProperty beanProperty, AnnotatedMember annotatedMember, JavaType javaType, s51 s51Var) {
        return new JsonNodeFieldAnyProperty(beanProperty, annotatedMember, javaType, s51Var, deserializationContext.getNodeFactory());
    }

    public static SettableAnyProperty constructForMapField(DeserializationContext deserializationContext, BeanProperty beanProperty, AnnotatedMember annotatedMember, JavaType javaType, a91 a91Var, s51 s51Var, m63 m63Var) {
        Class<?> rawType = annotatedMember.getRawType();
        if (rawType == Map.class) {
            rawType = LinkedHashMap.class;
        }
        return new MapFieldAnyProperty(beanProperty, annotatedMember, javaType, a91Var, s51Var, m63Var, JDKValueInstantiators.a(deserializationContext.getConfig(), rawType));
    }

    public static SettableAnyProperty constructForMethod(DeserializationContext deserializationContext, BeanProperty beanProperty, AnnotatedMember annotatedMember, JavaType javaType, a91 a91Var, s51 s51Var, m63 m63Var) {
        return new MethodAnyProperty(beanProperty, annotatedMember, javaType, a91Var, s51Var, m63Var);
    }

    private String getClassName() {
        return ay.X(this._setter.getDeclaringClass());
    }

    protected abstract void _set(Object obj, Object obj2, Object obj3) throws Exception;

    protected void _throwAsIOE(Exception exc, Object obj, Object obj2) throws IOException {
        if (!(exc instanceof IllegalArgumentException)) {
            ay.i0(exc);
            ay.j0(exc);
            Throwable thF = ay.F(exc);
            throw new JsonMappingException((Closeable) null, ay.o(thF), thF);
        }
        String strH = ay.h(obj2);
        StringBuilder sb = new StringBuilder("Problem deserializing \"any-property\" '");
        sb.append(obj);
        sb.append("' of class " + getClassName() + " (expected type: ");
        sb.append(this._type);
        sb.append("; actual type: ");
        sb.append(strH);
        sb.append(")");
        String strO = ay.o(exc);
        if (strO != null) {
            sb.append(", problem: ");
            sb.append(strO);
        } else {
            sb.append(" (no error message provided)");
        }
        throw new JsonMappingException((Closeable) null, sb.toString(), exc);
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.d1(JsonToken.VALUE_NULL)) {
            return this._valueDeserializer.getNullValue(deserializationContext);
        }
        m63 m63Var = this._valueTypeDeserializer;
        return m63Var != null ? this._valueDeserializer.deserializeWithType(jsonParser, deserializationContext, m63Var) : this._valueDeserializer.deserialize(jsonParser, deserializationContext);
    }

    public void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException {
        try {
            a91 a91Var = this._keyDeserializer;
            set(obj, a91Var == null ? str : a91Var.deserializeKey(str, deserializationContext), deserialize(jsonParser, deserializationContext));
        } catch (UnresolvedForwardReference e) {
            if (this._valueDeserializer.getObjectIdReader() == null) {
                throw JsonMappingException.from(jsonParser, "Unresolved forward reference but no identity info.", e);
            }
            e.getRoid().a(new a(this, e, this._type.getRawClass(), obj, str));
        }
    }

    public void fixAccess(DeserializationConfig deserializationConfig) {
        this._setter.fixAccess(deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public BeanProperty getProperty() {
        return this._property;
    }

    public String getPropertyName() {
        return this._property.getName();
    }

    public JavaType getType() {
        return this._type;
    }

    public boolean hasValueDeserializer() {
        return this._valueDeserializer != null;
    }

    Object readResolve() {
        AnnotatedMember annotatedMember = this._setter;
        if (annotatedMember == null || annotatedMember.getAnnotated() == null) {
            throw new IllegalArgumentException("Missing method/field (broken JDK (de)serialization?)");
        }
        return this;
    }

    public void set(Object obj, Object obj2, Object obj3) throws IOException {
        try {
            _set(obj, obj2, obj3);
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            _throwAsIOE(e2, obj2, obj3);
        }
    }

    public String toString() {
        return "[any property on class " + getClassName() + "]";
    }

    public abstract SettableAnyProperty withValueDeserializer(s51 s51Var);
}
