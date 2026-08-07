package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import defpackage.an2;
import defpackage.l7;

/* JADX INFO: loaded from: classes.dex */
public class AttributePropertyWriter extends VirtualBeanPropertyWriter {
    private static final long serialVersionUID = 1;
    protected final String _attrName;

    protected AttributePropertyWriter(String str, g gVar, l7 l7Var, JavaType javaType) {
        this(str, gVar, l7Var, javaType, gVar.c());
    }

    public static AttributePropertyWriter construct(String str, g gVar, l7 l7Var, JavaType javaType) {
        return new AttributePropertyWriter(str, gVar, l7Var, javaType);
    }

    @Override // com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter
    protected Object value(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
        return an2Var.getAttribute(this._attrName);
    }

    @Override // com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter
    public VirtualBeanPropertyWriter withConfig(MapperConfig<?> mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar, g gVar, JavaType javaType) {
        throw new IllegalStateException("Should not be called on this type");
    }

    protected AttributePropertyWriter(String str, g gVar, l7 l7Var, JavaType javaType, JsonInclude.Value value) {
        super(gVar, l7Var, javaType, null, null, null, value, null);
        this._attrName = str;
    }

    protected AttributePropertyWriter(AttributePropertyWriter attributePropertyWriter) {
        super(attributePropertyWriter);
        this._attrName = attributePropertyWriter._attrName;
    }
}
