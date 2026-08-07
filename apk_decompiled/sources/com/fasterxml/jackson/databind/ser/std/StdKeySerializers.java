package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.a;
import com.fasterxml.jackson.databind.util.EnumValues;
import defpackage.an2;
import defpackage.ay;
import defpackage.f71;
import defpackage.y51;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class StdKeySerializers {
    protected static final f71 a = new StdKeySerializer();
    protected static final f71 b = new StringKeySerializer();

    public static class Default extends StdSerializer<Object> {
        static final int TYPE_BYTE_ARRAY = 7;
        static final int TYPE_CALENDAR = 2;
        static final int TYPE_CLASS = 3;
        static final int TYPE_DATE = 1;
        static final int TYPE_ENUM = 4;
        static final int TYPE_INTEGER = 5;
        static final int TYPE_LONG = 6;
        static final int TYPE_TO_STRING = 8;
        protected final int _typeId;

        public Default(int i, Class<?> cls) {
            super(cls, false);
            this._typeId = i;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            String strValueOf;
            switch (this._typeId) {
                case 1:
                    an2Var.defaultSerializeDateKey((Date) obj, jsonGenerator);
                    break;
                case 2:
                    an2Var.defaultSerializeDateKey(((Calendar) obj).getTimeInMillis(), jsonGenerator);
                    break;
                case 3:
                    jsonGenerator.V0(((Class) obj).getName());
                    break;
                case 4:
                    if (an2Var.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
                        strValueOf = obj.toString();
                    } else {
                        Enum r3 = (Enum) obj;
                        strValueOf = an2Var.isEnabled(SerializationFeature.WRITE_ENUM_KEYS_USING_INDEX) ? String.valueOf(r3.ordinal()) : r3.name();
                    }
                    jsonGenerator.V0(strValueOf);
                    break;
                case 5:
                case 6:
                    jsonGenerator.T0(((Number) obj).longValue());
                    break;
                case 7:
                    jsonGenerator.V0(an2Var.getConfig().getBase64Variant().encode((byte[]) obj));
                    break;
                default:
                    jsonGenerator.V0(obj.toString());
                    break;
            }
        }
    }

    public static class Dynamic extends StdSerializer<Object> {
        protected transient a _dynamicSerializers;

        public Dynamic() {
            super(String.class, false);
            this._dynamicSerializers = a.c();
        }

        protected f71 _findAndAddDynamic(a aVar, Class<?> cls, an2 an2Var) throws JsonMappingException {
            if (cls == Object.class) {
                Default r4 = new Default(8, cls);
                this._dynamicSerializers = aVar.j(cls, r4);
                return r4;
            }
            a.d dVarE = aVar.e(cls, an2Var, null);
            a aVar2 = dVarE.b;
            if (aVar != aVar2) {
                this._dynamicSerializers = aVar2;
            }
            return dVarE.a;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
            visitStringFormat(y51Var, javaType);
        }

        Object readResolve() {
            this._dynamicSerializers = a.c();
            return this;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            Class<?> cls = obj.getClass();
            a aVar = this._dynamicSerializers;
            f71 f71VarK = aVar.k(cls);
            if (f71VarK == null) {
                f71VarK = _findAndAddDynamic(aVar, cls, an2Var);
            }
            f71VarK.serialize(obj, jsonGenerator, an2Var);
        }
    }

    public static class EnumKeySerializer extends StdSerializer<Object> {
        protected final EnumValues _values;

        protected EnumKeySerializer(Class<?> cls, EnumValues enumValues) {
            super(cls, false);
            this._values = enumValues;
        }

        public static EnumKeySerializer construct(Class<?> cls, EnumValues enumValues) {
            return new EnumKeySerializer(cls, enumValues);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            if (an2Var.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
                jsonGenerator.V0(obj.toString());
                return;
            }
            Enum<?> r2 = (Enum) obj;
            if (an2Var.isEnabled(SerializationFeature.WRITE_ENUM_KEYS_USING_INDEX)) {
                jsonGenerator.V0(String.valueOf(r2.ordinal()));
            } else {
                jsonGenerator.U0(this._values.serializedValueFor(r2));
            }
        }
    }

    public static class StringKeySerializer extends StdSerializer<Object> {
        public StringKeySerializer() {
            super(String.class, false);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            jsonGenerator.V0((String) obj);
        }
    }

    public static f71 a(SerializationConfig serializationConfig, Class cls) {
        if (cls != null) {
            if (cls == Enum.class) {
                return new Dynamic();
            }
            if (ay.L(cls)) {
                return EnumKeySerializer.construct(cls, EnumValues.constructFromName(serializationConfig, cls));
            }
        }
        return new Default(8, cls);
    }

    public static f71 b(SerializationConfig serializationConfig, Class cls, boolean z) {
        if (cls == null || cls == Object.class) {
            return new Dynamic();
        }
        if (cls == String.class) {
            return b;
        }
        if (cls.isPrimitive()) {
            cls = ay.o0(cls);
        }
        if (cls == Integer.class) {
            return new Default(5, cls);
        }
        if (cls == Long.class) {
            return new Default(6, cls);
        }
        if (cls.isPrimitive() || Number.class.isAssignableFrom(cls)) {
            return new Default(8, cls);
        }
        if (cls == Class.class) {
            return new Default(3, cls);
        }
        if (Date.class.isAssignableFrom(cls)) {
            return new Default(1, cls);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            return new Default(2, cls);
        }
        if (cls == UUID.class) {
            return new Default(8, cls);
        }
        if (cls == byte[].class) {
            return new Default(7, cls);
        }
        if (z) {
            return new Default(8, cls);
        }
        return null;
    }
}
