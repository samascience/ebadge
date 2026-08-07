package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;
import defpackage.an2;
import defpackage.f71;
import defpackage.mt1;
import defpackage.z63;
import java.io.IOException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BeanAsArraySerializer extends BeanSerializerBase {
    private static final long serialVersionUID = 1;
    protected final BeanSerializerBase _defaultSerializer;

    public BeanAsArraySerializer(BeanSerializerBase beanSerializerBase) {
        super(beanSerializerBase, (mt1) null);
        this._defaultSerializer = beanSerializerBase;
    }

    private boolean hasSingleElement(an2 an2Var) {
        return ((this._filteredProps == null || an2Var.getActiveView() == null) ? this._props : this._filteredProps).length == 1;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    protected BeanSerializerBase asArraySerializer() {
        return this;
    }

    @Override // defpackage.f71
    public boolean isUnwrappingSerializer() {
        return false;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public final void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        if (an2Var.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && hasSingleElement(an2Var)) {
            serializeAsArray(obj, jsonGenerator, an2Var);
            return;
        }
        jsonGenerator.q1(obj);
        serializeAsArray(obj, jsonGenerator, an2Var);
        jsonGenerator.R0();
    }

    protected final void serializeAsArray(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        BeanPropertyWriter[] beanPropertyWriterArr = (this._filteredProps == null || an2Var.getActiveView() == null) ? this._props : this._filteredProps;
        int i = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i < length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
                if (beanPropertyWriter == null) {
                    jsonGenerator.W0();
                } else {
                    beanPropertyWriter.serializeAsElement(obj, jsonGenerator, an2Var);
                }
                i++;
            }
        } catch (Exception e) {
            wrapAndThrow(an2Var, e, obj, beanPropertyWriterArr[i].getName());
        } catch (StackOverflowError e2) {
            JsonMappingException jsonMappingExceptionFrom = JsonMappingException.from(jsonGenerator, "Infinite recursion (StackOverflowError)", e2);
            jsonMappingExceptionFrom.prependPath(obj, beanPropertyWriterArr[i].getName());
            throw jsonMappingExceptionFrom;
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase, defpackage.f71
    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        if (this._objectIdWriter != null) {
            _serializeWithObjectId(obj, jsonGenerator, an2Var, z63Var);
            return;
        }
        WritableTypeId writableTypeId_typeIdDef = _typeIdDef(z63Var, obj, JsonToken.START_ARRAY);
        z63Var.g(jsonGenerator, writableTypeId_typeIdDef);
        jsonGenerator.y0(obj);
        serializeAsArray(obj, jsonGenerator, an2Var);
        z63Var.h(jsonGenerator, writableTypeId_typeIdDef);
    }

    public String toString() {
        return "BeanAsArraySerializer for " + handledType().getName();
    }

    @Override // defpackage.f71
    public f71 unwrappingSerializer(NameTransformer nameTransformer) {
        return this._defaultSerializer.unwrappingSerializer(nameTransformer);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    protected /* bridge */ /* synthetic */ BeanSerializerBase withByNameInclusion(Set set, Set set2) {
        return withByNameInclusion((Set<String>) set, (Set<String>) set2);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public BeanSerializerBase withObjectIdWriter(mt1 mt1Var) {
        return this._defaultSerializer.withObjectIdWriter(mt1Var);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    protected BeanSerializerBase withProperties(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    protected BeanAsArraySerializer withByNameInclusion(Set<String> set, Set<String> set2) {
        return new BeanAsArraySerializer(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase, defpackage.f71
    public BeanSerializerBase withFilterId(Object obj) {
        return new BeanAsArraySerializer(this, this._objectIdWriter, obj);
    }

    protected BeanAsArraySerializer(BeanSerializerBase beanSerializerBase, Set<String> set) {
        this(beanSerializerBase, set, (Set<String>) null);
    }

    protected BeanAsArraySerializer(BeanSerializerBase beanSerializerBase, Set<String> set, Set<String> set2) {
        super(beanSerializerBase, set, set2);
        this._defaultSerializer = beanSerializerBase;
    }

    protected BeanAsArraySerializer(BeanSerializerBase beanSerializerBase, mt1 mt1Var, Object obj) {
        super(beanSerializerBase, mt1Var, obj);
        this._defaultSerializer = beanSerializerBase;
    }
}
