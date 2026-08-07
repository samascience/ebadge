package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import defpackage.an2;
import defpackage.e41;
import defpackage.f71;
import defpackage.z63;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@e41
public final class IndexedListSerializer extends AsArraySerializerBase<List<?>> {
    private static final long serialVersionUID = 1;

    public IndexedListSerializer(JavaType javaType, boolean z, z63 z63Var, f71 f71Var) {
        super((Class<?>) List.class, javaType, z, z63Var, f71Var);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public ContainerSerializer<?> _withValueTypeSerializer(z63 z63Var) {
        return new IndexedListSerializer(this, this._property, z63Var, this._elementSerializer, this._unwrapSingle);
    }

    public void serializeContentsUsing(List<?> list, JsonGenerator jsonGenerator, an2 an2Var, f71 f71Var) throws IOException {
        int size = list.size();
        if (size == 0) {
            return;
        }
        z63 z63Var = this._valueTypeSerializer;
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj == null) {
                try {
                    an2Var.defaultSerializeNull(jsonGenerator);
                } catch (Exception e) {
                    wrapAndThrow(an2Var, e, list, i);
                }
            } else if (z63Var == null) {
                f71Var.serialize(obj, jsonGenerator, an2Var);
            } else {
                f71Var.serializeWithType(obj, jsonGenerator, an2Var, z63Var);
            }
        }
    }

    public void serializeTypedContents(List<?> list, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        int size = list.size();
        if (size == 0) {
            return;
        }
        int i = 0;
        try {
            z63 z63Var = this._valueTypeSerializer;
            a aVar = this._dynamicSerializers;
            while (i < size) {
                Object obj = list.get(i);
                if (obj == null) {
                    an2Var.defaultSerializeNull(jsonGenerator);
                } else {
                    Class<?> cls = obj.getClass();
                    f71 f71VarK = aVar.k(cls);
                    if (f71VarK == null) {
                        f71VarK = this._elementType.hasGenericTypes() ? _findAndAddDynamic(aVar, an2Var.constructSpecializedType(this._elementType, cls), an2Var) : _findAndAddDynamic(aVar, cls, an2Var);
                        aVar = this._dynamicSerializers;
                    }
                    f71VarK.serializeWithType(obj, jsonGenerator, an2Var, z63Var);
                }
                i++;
            }
        } catch (Exception e) {
            wrapAndThrow(an2Var, e, list, i);
        }
    }

    public IndexedListSerializer(IndexedListSerializer indexedListSerializer, BeanProperty beanProperty, z63 z63Var, f71 f71Var, Boolean bool) {
        super(indexedListSerializer, beanProperty, z63Var, f71Var, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(List<?> list) {
        return list.size() == 1;
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, List<?> list) {
        return list.isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public final void serialize(List<?> list, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        int size = list.size();
        if (size == 1 && ((this._unwrapSingle == null && an2Var.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents(list, jsonGenerator, an2Var);
            return;
        }
        jsonGenerator.r1(list, size);
        serializeContents(list, jsonGenerator, an2Var);
        jsonGenerator.R0();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public void serializeContents(List<?> list, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        f71 f71Var = this._elementSerializer;
        if (f71Var != null) {
            serializeContentsUsing(list, jsonGenerator, an2Var, f71Var);
            return;
        }
        if (this._valueTypeSerializer != null) {
            serializeTypedContents(list, jsonGenerator, an2Var);
            return;
        }
        int size = list.size();
        if (size == 0) {
            return;
        }
        int i = 0;
        try {
            a aVar = this._dynamicSerializers;
            while (i < size) {
                Object obj = list.get(i);
                if (obj == null) {
                    an2Var.defaultSerializeNull(jsonGenerator);
                } else {
                    Class<?> cls = obj.getClass();
                    f71 f71VarK = aVar.k(cls);
                    if (f71VarK == null) {
                        f71VarK = this._elementType.hasGenericTypes() ? _findAndAddDynamic(aVar, an2Var.constructSpecializedType(this._elementType, cls), an2Var) : _findAndAddDynamic(aVar, cls, an2Var);
                        aVar = this._dynamicSerializers;
                    }
                    f71VarK.serialize(obj, jsonGenerator, an2Var);
                }
                i++;
            }
        } catch (Exception e) {
            wrapAndThrow(an2Var, e, list, i);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public AsArraySerializerBase<List<?>> withResolved(BeanProperty beanProperty, z63 z63Var, f71 f71Var, Boolean bool) {
        return new IndexedListSerializer(this, beanProperty, z63Var, f71Var, bool);
    }
}
