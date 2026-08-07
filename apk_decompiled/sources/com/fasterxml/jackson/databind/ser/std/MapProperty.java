package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import defpackage.an2;
import defpackage.f71;
import defpackage.p61;
import defpackage.z63;
import java.io.IOException;
import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes.dex */
public class MapProperty extends PropertyWriter {
    private static final BeanProperty BOGUS_PROP = new BeanProperty.a();
    private static final long serialVersionUID = 1;
    protected Object _key;
    protected f71 _keySerializer;
    protected final BeanProperty _property;
    protected final z63 _typeSerializer;
    protected Object _value;
    protected f71 _valueSerializer;

    public MapProperty(z63 z63Var, BeanProperty beanProperty) {
        super(beanProperty == null ? PropertyMetadata.STD_REQUIRED_OR_OPTIONAL : beanProperty.getMetadata());
        this._typeSerializer = z63Var;
        this._property = beanProperty == null ? BOGUS_PROP : beanProperty;
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public void depositSchemaProperty(p61 p61Var, an2 an2Var) throws JsonMappingException {
        this._property.depositSchemaProperty(p61Var, an2Var);
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this._property.getAnnotation(cls);
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public <A extends Annotation> A getContextAnnotation(Class<A> cls) {
        return (A) this._property.getContextAnnotation(cls);
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public PropertyName getFullName() {
        return new PropertyName(getName());
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public AnnotatedMember getMember() {
        return this._property.getMember();
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty, defpackage.in1
    public String getName() {
        Object obj = this._key;
        return obj instanceof String ? (String) obj : String.valueOf(obj);
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public JavaType getType() {
        return this._property.getType();
    }

    public Object getValue() {
        return this._value;
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public PropertyName getWrapperName() {
        return this._property.getWrapperName();
    }

    public void reset(Object obj, Object obj2, f71 f71Var, f71 f71Var2) {
        this._key = obj;
        this._value = obj2;
        this._keySerializer = f71Var;
        this._valueSerializer = f71Var2;
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter
    public void serializeAsElement(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
        z63 z63Var = this._typeSerializer;
        if (z63Var == null) {
            this._valueSerializer.serialize(this._value, jsonGenerator, an2Var);
        } else {
            this._valueSerializer.serializeWithType(this._value, jsonGenerator, an2Var, z63Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter
    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        this._keySerializer.serialize(this._key, jsonGenerator, an2Var);
        z63 z63Var = this._typeSerializer;
        if (z63Var == null) {
            this._valueSerializer.serialize(this._value, jsonGenerator, an2Var);
        } else {
            this._valueSerializer.serializeWithType(this._value, jsonGenerator, an2Var, z63Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter
    public void serializeAsOmittedField(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
        if (jsonGenerator.C()) {
            return;
        }
        jsonGenerator.i1(getName());
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter
    public void serializeAsPlaceholder(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
        jsonGenerator.W0();
    }

    public void setValue(Object obj) {
        this._value = obj;
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter
    @Deprecated
    public void depositSchemaProperty(ObjectNode objectNode, an2 an2Var) throws JsonMappingException {
    }

    @Deprecated
    public void reset(Object obj, f71 f71Var, f71 f71Var2) {
        reset(obj, this._value, f71Var, f71Var2);
    }
}
