package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.node.ObjectNode;
import defpackage.an2;
import defpackage.p61;
import java.io.Serializable;
import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes.dex */
public abstract class PropertyWriter extends ConcreteBeanPropertyBase implements Serializable {
    private static final long serialVersionUID = 1;

    protected PropertyWriter(PropertyMetadata propertyMetadata) {
        super(propertyMetadata);
    }

    @Deprecated
    public abstract void depositSchemaProperty(ObjectNode objectNode, an2 an2Var) throws JsonMappingException;

    @Override // com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public abstract void depositSchemaProperty(p61 p61Var, an2 an2Var) throws JsonMappingException;

    public <A extends Annotation> A findAnnotation(Class<A> cls) {
        A a = (A) getAnnotation(cls);
        return a == null ? (A) getContextAnnotation(cls) : a;
    }

    @Override // com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public abstract <A extends Annotation> A getAnnotation(Class<A> cls);

    @Override // com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public abstract <A extends Annotation> A getContextAnnotation(Class<A> cls);

    @Override // com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public abstract PropertyName getFullName();

    @Override // com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public abstract /* synthetic */ AnnotatedMember getMember();

    @Override // com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty, defpackage.in1
    public abstract String getName();

    @Override // com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public abstract /* synthetic */ JavaType getType();

    @Override // com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public abstract /* synthetic */ PropertyName getWrapperName();

    public abstract void serializeAsElement(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception;

    public abstract void serializeAsField(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception;

    public abstract void serializeAsOmittedField(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception;

    public abstract void serializeAsPlaceholder(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception;

    protected PropertyWriter(g gVar) {
        super(gVar.getMetadata());
    }

    protected PropertyWriter(PropertyWriter propertyWriter) {
        super(propertyWriter);
    }
}
