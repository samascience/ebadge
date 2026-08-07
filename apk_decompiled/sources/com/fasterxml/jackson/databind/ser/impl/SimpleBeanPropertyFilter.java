package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import defpackage.an2;
import defpackage.i82;
import defpackage.nh;
import defpackage.p61;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class SimpleBeanPropertyFilter implements nh, i82 {

    public static class FilterExceptFilter extends SimpleBeanPropertyFilter implements Serializable {
        private static final long serialVersionUID = 1;
        protected final Set<String> _propertiesToInclude;

        public FilterExceptFilter(Set<String> set) {
            this._propertiesToInclude = set;
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
        protected boolean include(BeanPropertyWriter beanPropertyWriter) {
            return this._propertiesToInclude.contains(beanPropertyWriter.getName());
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
        protected boolean include(PropertyWriter propertyWriter) {
            return this._propertiesToInclude.contains(propertyWriter.getName());
        }
    }

    public static class SerializeExceptFilter extends SimpleBeanPropertyFilter implements Serializable {
        static final SerializeExceptFilter INCLUDE_ALL = new SerializeExceptFilter();
        private static final long serialVersionUID = 1;
        protected final Set<String> _propertiesToExclude;

        SerializeExceptFilter() {
            this._propertiesToExclude = Collections.emptySet();
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
        protected boolean include(BeanPropertyWriter beanPropertyWriter) {
            return !this._propertiesToExclude.contains(beanPropertyWriter.getName());
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
        protected boolean include(PropertyWriter propertyWriter) {
            return !this._propertiesToExclude.contains(propertyWriter.getName());
        }

        public SerializeExceptFilter(Set<String> set) {
            this._propertiesToExclude = set;
        }
    }

    static class a implements i82 {
        final /* synthetic */ nh a;

        a(nh nhVar) {
            this.a = nhVar;
        }

        @Override // defpackage.i82
        public void depositSchemaProperty(PropertyWriter propertyWriter, ObjectNode objectNode, an2 an2Var) {
            this.a.depositSchemaProperty((BeanPropertyWriter) propertyWriter, objectNode, an2Var);
        }

        @Override // defpackage.i82
        public void serializeAsField(Object obj, JsonGenerator jsonGenerator, an2 an2Var, PropertyWriter propertyWriter) {
            this.a.serializeAsField(obj, jsonGenerator, an2Var, (BeanPropertyWriter) propertyWriter);
        }
    }

    protected SimpleBeanPropertyFilter() {
    }

    public static SimpleBeanPropertyFilter filterOutAllExcept(Set<String> set) {
        return new FilterExceptFilter(set);
    }

    public static i82 from(nh nhVar) {
        return new a(nhVar);
    }

    public static SimpleBeanPropertyFilter serializeAll() {
        return SerializeExceptFilter.INCLUDE_ALL;
    }

    public static SimpleBeanPropertyFilter serializeAllExcept(Set<String> set) {
        return new SerializeExceptFilter(set);
    }

    @Override // defpackage.nh
    @Deprecated
    public void depositSchemaProperty(BeanPropertyWriter beanPropertyWriter, ObjectNode objectNode, an2 an2Var) throws JsonMappingException {
        if (include(beanPropertyWriter)) {
            beanPropertyWriter.depositSchemaProperty(objectNode, an2Var);
        }
    }

    protected abstract boolean include(BeanPropertyWriter beanPropertyWriter);

    protected abstract boolean include(PropertyWriter propertyWriter);

    protected boolean includeElement(Object obj) {
        return true;
    }

    public void serializeAsElement(Object obj, JsonGenerator jsonGenerator, an2 an2Var, PropertyWriter propertyWriter) throws Exception {
        if (includeElement(obj)) {
            propertyWriter.serializeAsElement(obj, jsonGenerator, an2Var);
        }
    }

    @Override // defpackage.nh
    @Deprecated
    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, an2 an2Var, BeanPropertyWriter beanPropertyWriter) throws Exception {
        if (include(beanPropertyWriter)) {
            beanPropertyWriter.serializeAsField(obj, jsonGenerator, an2Var);
        } else {
            if (jsonGenerator.C()) {
                return;
            }
            beanPropertyWriter.serializeAsOmittedField(obj, jsonGenerator, an2Var);
        }
    }

    public static SimpleBeanPropertyFilter filterOutAllExcept(String... strArr) {
        HashSet hashSet = new HashSet(strArr.length);
        Collections.addAll(hashSet, strArr);
        return new FilterExceptFilter(hashSet);
    }

    @Deprecated
    public static SimpleBeanPropertyFilter serializeAll(Set<String> set) {
        return new FilterExceptFilter(set);
    }

    public static SimpleBeanPropertyFilter serializeAllExcept(String... strArr) {
        HashSet hashSet = new HashSet(strArr.length);
        Collections.addAll(hashSet, strArr);
        return new SerializeExceptFilter(hashSet);
    }

    @Deprecated
    public void depositSchemaProperty(BeanPropertyWriter beanPropertyWriter, p61 p61Var, an2 an2Var) throws JsonMappingException {
        if (include(beanPropertyWriter)) {
            beanPropertyWriter.depositSchemaProperty(p61Var, an2Var);
        }
    }

    @Override // defpackage.i82
    @Deprecated
    public void depositSchemaProperty(PropertyWriter propertyWriter, ObjectNode objectNode, an2 an2Var) throws JsonMappingException {
        if (include(propertyWriter)) {
            propertyWriter.depositSchemaProperty(objectNode, an2Var);
        }
    }

    @Override // defpackage.i82
    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, an2 an2Var, PropertyWriter propertyWriter) throws Exception {
        if (include(propertyWriter)) {
            propertyWriter.serializeAsField(obj, jsonGenerator, an2Var);
        } else {
            if (jsonGenerator.C()) {
                return;
            }
            propertyWriter.serializeAsOmittedField(obj, jsonGenerator, an2Var);
        }
    }

    public void depositSchemaProperty(PropertyWriter propertyWriter, p61 p61Var, an2 an2Var) throws JsonMappingException {
        if (include(propertyWriter)) {
            propertyWriter.depositSchemaProperty(p61Var, an2Var);
        }
    }
}
