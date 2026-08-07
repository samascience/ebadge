package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.a;
import defpackage.an2;
import defpackage.f71;
import defpackage.z63;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CollectionSerializer extends AsArraySerializerBase<Collection<?>> {
    private static final long serialVersionUID = 1;

    public CollectionSerializer(JavaType javaType, boolean z, z63 z63Var, f71 f71Var) {
        super((Class<?>) Collection.class, javaType, z, z63Var, f71Var);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public ContainerSerializer<?> _withValueTypeSerializer(z63 z63Var) {
        return new CollectionSerializer(this, this._property, z63Var, this._elementSerializer, this._unwrapSingle);
    }

    public void serializeContentsUsing(Collection<?> collection, JsonGenerator jsonGenerator, an2 an2Var, f71 f71Var) throws IOException {
        Iterator<?> it = collection.iterator();
        if (it.hasNext()) {
            z63 z63Var = this._valueTypeSerializer;
            int i = 0;
            do {
                Object next = it.next();
                if (next == null) {
                    try {
                        an2Var.defaultSerializeNull(jsonGenerator);
                    } catch (Exception e) {
                        wrapAndThrow(an2Var, e, collection, i);
                    }
                } else if (z63Var == null) {
                    f71Var.serialize(next, jsonGenerator, an2Var);
                } else {
                    f71Var.serializeWithType(next, jsonGenerator, an2Var, z63Var);
                }
                i++;
            } while (it.hasNext());
        }
    }

    @Deprecated
    public CollectionSerializer(JavaType javaType, boolean z, z63 z63Var, BeanProperty beanProperty, f71 f71Var) {
        this(javaType, z, z63Var, f71Var);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(Collection<?> collection) {
        return collection.size() == 1;
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, Collection<?> collection) {
        return collection.isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public final void serialize(Collection<?> collection, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        int size = collection.size();
        if (size == 1 && ((this._unwrapSingle == null && an2Var.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents(collection, jsonGenerator, an2Var);
            return;
        }
        jsonGenerator.r1(collection, size);
        serializeContents(collection, jsonGenerator, an2Var);
        jsonGenerator.R0();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public void serializeContents(Collection<?> collection, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        jsonGenerator.y0(collection);
        f71 f71Var = this._elementSerializer;
        if (f71Var != null) {
            serializeContentsUsing(collection, jsonGenerator, an2Var, f71Var);
            return;
        }
        Iterator<?> it = collection.iterator();
        if (it.hasNext()) {
            a aVar = this._dynamicSerializers;
            z63 z63Var = this._valueTypeSerializer;
            int i = 0;
            do {
                try {
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
                    i++;
                } catch (Exception e) {
                    wrapAndThrow(an2Var, e, collection, i);
                    return;
                }
            } while (it.hasNext());
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public AsArraySerializerBase<Collection<?>> withResolved(BeanProperty beanProperty, z63 z63Var, f71 f71Var, Boolean bool) {
        return new CollectionSerializer(this, beanProperty, z63Var, f71Var, bool);
    }

    public CollectionSerializer(CollectionSerializer collectionSerializer, BeanProperty beanProperty, z63 z63Var, f71 f71Var, Boolean bool) {
        super(collectionSerializer, beanProperty, z63Var, f71Var, bool);
    }
}
