package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationFeature;
import defpackage.an2;
import defpackage.f71;
import defpackage.z63;
import java.io.IOException;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes.dex */
public class EnumSetSerializer extends AsArraySerializerBase<EnumSet<? extends Enum<?>>> {
    public EnumSetSerializer(JavaType javaType) {
        super((Class<?>) EnumSet.class, javaType, true, (z63) null, (f71) null);
    }

    public EnumSetSerializer(EnumSetSerializer enumSetSerializer, BeanProperty beanProperty, z63 z63Var, f71 f71Var, Boolean bool) {
        super(enumSetSerializer, beanProperty, z63Var, f71Var, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public EnumSetSerializer _withValueTypeSerializer(z63 z63Var) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(EnumSet<? extends Enum<?>> enumSet) {
        return enumSet.size() == 1;
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, EnumSet<? extends Enum<?>> enumSet) {
        return enumSet.isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public final void serialize(EnumSet<? extends Enum<?>> enumSet, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        int size = enumSet.size();
        if (size == 1 && ((this._unwrapSingle == null && an2Var.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents(enumSet, jsonGenerator, an2Var);
            return;
        }
        jsonGenerator.r1(enumSet, size);
        serializeContents(enumSet, jsonGenerator, an2Var);
        jsonGenerator.R0();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public void serializeContents(EnumSet<? extends Enum<?>> enumSet, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        f71 f71VarFindContentValueSerializer = this._elementSerializer;
        for (Enum<?> r1 : enumSet) {
            if (f71VarFindContentValueSerializer == null) {
                f71VarFindContentValueSerializer = an2Var.findContentValueSerializer(r1.getDeclaringClass(), this._property);
            }
            f71VarFindContentValueSerializer.serialize(r1, jsonGenerator, an2Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public AsArraySerializerBase<EnumSet<? extends Enum<?>>> withResolved(BeanProperty beanProperty, z63 z63Var, f71 f71Var, Boolean bool) {
        return new EnumSetSerializer(this, beanProperty, z63Var, f71Var, bool);
    }
}
