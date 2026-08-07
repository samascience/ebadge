package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import defpackage.an2;
import defpackage.e41;
import defpackage.f71;
import defpackage.z63;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@e41
public class IterableSerializer extends AsArraySerializerBase<Iterable<?>> {
    public IterableSerializer(JavaType javaType, boolean z, z63 z63Var) {
        super((Class<?>) Iterable.class, javaType, z, z63Var, (f71) null);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public ContainerSerializer<?> _withValueTypeSerializer(z63 z63Var) {
        return new IterableSerializer(this, this._property, z63Var, this._elementSerializer, this._unwrapSingle);
    }

    public IterableSerializer(IterableSerializer iterableSerializer, BeanProperty beanProperty, z63 z63Var, f71 f71Var, Boolean bool) {
        super(iterableSerializer, beanProperty, z63Var, f71Var, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(Iterable<?> iterable) {
        if (iterable == null) {
            return false;
        }
        Iterator<?> it = iterable.iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        return !it.hasNext();
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, Iterable<?> iterable) {
        return !iterable.iterator().hasNext();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public final void serialize(Iterable<?> iterable, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        if (((this._unwrapSingle == null && an2Var.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE) && hasSingleElement(iterable)) {
            serializeContents(iterable, jsonGenerator, an2Var);
            return;
        }
        jsonGenerator.q1(iterable);
        serializeContents(iterable, jsonGenerator, an2Var);
        jsonGenerator.R0();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public void serializeContents(Iterable<?> iterable, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        f71 f71Var;
        Iterator<?> it = iterable.iterator();
        if (it.hasNext()) {
            z63 z63Var = this._valueTypeSerializer;
            Class<?> cls = null;
            f71 f71VarFindValueSerializer = null;
            do {
                Object next = it.next();
                if (next == null) {
                    an2Var.defaultSerializeNull(jsonGenerator);
                } else {
                    f71 f71Var2 = this._elementSerializer;
                    if (f71Var2 == null) {
                        Class<?> cls2 = next.getClass();
                        if (cls2 != cls) {
                            f71VarFindValueSerializer = an2Var.findValueSerializer(cls2, this._property);
                            cls = cls2;
                        }
                        f71Var = f71VarFindValueSerializer;
                    } else {
                        f71Var = f71VarFindValueSerializer;
                        f71VarFindValueSerializer = f71Var2;
                    }
                    if (z63Var == null) {
                        f71VarFindValueSerializer.serialize(next, jsonGenerator, an2Var);
                    } else {
                        f71VarFindValueSerializer.serializeWithType(next, jsonGenerator, an2Var, z63Var);
                    }
                    f71VarFindValueSerializer = f71Var;
                }
            } while (it.hasNext());
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public AsArraySerializerBase<Iterable<?>> withResolved(BeanProperty beanProperty, z63 z63Var, f71 f71Var, Boolean bool) {
        return new IterableSerializer(this, beanProperty, z63Var, f71Var, bool);
    }
}
