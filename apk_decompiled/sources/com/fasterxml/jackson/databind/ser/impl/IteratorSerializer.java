package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import defpackage.an2;
import defpackage.e41;
import defpackage.f71;
import defpackage.z63;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@e41
public class IteratorSerializer extends AsArraySerializerBase<Iterator<?>> {
    public IteratorSerializer(JavaType javaType, boolean z, z63 z63Var) {
        super((Class<?>) Iterator.class, javaType, z, z63Var, (f71) null);
    }

    protected void _serializeDynamicContents(Iterator<?> it, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        z63 z63Var = this._valueTypeSerializer;
        a aVar = this._dynamicSerializers;
        do {
            Object next = it.next();
            if (next == null) {
                an2Var.defaultSerializeNull(jsonGenerator);
            } else {
                Class<?> cls = next.getClass();
                f71 f71VarK = aVar.k(cls);
                if (f71VarK == null) {
                    f71VarK = this._elementType.hasGenericTypes() ? _findAndAddDynamic(aVar, an2Var.constructSpecializedType(this._elementType, cls), an2Var) : _findAndAddDynamic(aVar, cls, an2Var);
                    aVar = this._dynamicSerializers;
                }
                if (z63Var == null) {
                    f71VarK.serialize(next, jsonGenerator, an2Var);
                } else {
                    f71VarK.serializeWithType(next, jsonGenerator, an2Var, z63Var);
                }
            }
        } while (it.hasNext());
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public ContainerSerializer<?> _withValueTypeSerializer(z63 z63Var) {
        return new IteratorSerializer(this, this._property, z63Var, this._elementSerializer, this._unwrapSingle);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(Iterator<?> it) {
        return false;
    }

    public IteratorSerializer(IteratorSerializer iteratorSerializer, BeanProperty beanProperty, z63 z63Var, f71 f71Var, Boolean bool) {
        super(iteratorSerializer, beanProperty, z63Var, f71Var, bool);
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, Iterator<?> it) {
        return !it.hasNext();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public final void serialize(Iterator<?> it, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        jsonGenerator.q1(it);
        serializeContents(it, jsonGenerator, an2Var);
        jsonGenerator.R0();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public void serializeContents(Iterator<?> it, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        if (it.hasNext()) {
            f71 f71Var = this._elementSerializer;
            if (f71Var == null) {
                _serializeDynamicContents(it, jsonGenerator, an2Var);
                return;
            }
            z63 z63Var = this._valueTypeSerializer;
            do {
                Object next = it.next();
                if (next == null) {
                    an2Var.defaultSerializeNull(jsonGenerator);
                } else if (z63Var == null) {
                    f71Var.serialize(next, jsonGenerator, an2Var);
                } else {
                    f71Var.serializeWithType(next, jsonGenerator, an2Var, z63Var);
                }
            } while (it.hasNext());
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public AsArraySerializerBase<Iterator<?>> withResolved(BeanProperty beanProperty, z63 z63Var, f71 f71Var, Boolean bool) {
        return new IteratorSerializer(this, beanProperty, z63Var, f71Var, bool);
    }
}
