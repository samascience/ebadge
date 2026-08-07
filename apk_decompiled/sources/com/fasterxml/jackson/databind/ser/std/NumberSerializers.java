package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import defpackage.an2;
import defpackage.e41;
import defpackage.f71;
import defpackage.is1;
import defpackage.w30;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class NumberSerializers {

    public static abstract class Base<T> extends StdScalarSerializer<T> implements w30 {
        protected final boolean _isInt;
        protected final JsonParser.NumberType _numberType;
        protected final String _schemaType;

        protected Base(Class<?> cls, JsonParser.NumberType numberType, String str) {
            super(cls, false);
            this._numberType = numberType;
            this._schemaType = str;
            this._isInt = numberType == JsonParser.NumberType.INT || numberType == JsonParser.NumberType.LONG || numberType == JsonParser.NumberType.BIG_INTEGER;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
            if (this._isInt) {
                visitIntFormat(y51Var, javaType, this._numberType);
            } else {
                visitFloatFormat(y51Var, javaType, this._numberType);
            }
        }

        @Override // defpackage.w30
        public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
            JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(an2Var, beanProperty, handledType());
            if (valueFindFormatOverrides == null || a.a[valueFindFormatOverrides.getShape().ordinal()] != 1) {
                return this;
            }
            return handledType() == BigDecimal.class ? NumberSerializer.bigDecimalAsStringSerializer() : ToStringSerializer.instance;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
        public JsonNode getSchema(an2 an2Var, Type type) {
            return createSchemaNode(this._schemaType, true);
        }
    }

    @e41
    public static class DoubleSerializer extends Base<Object> {
        public DoubleSerializer(Class<?> cls) {
            super(cls, JsonParser.NumberType.DOUBLE, "number");
        }

        @Deprecated
        public static boolean notFinite(double d) {
            return is1.o(d);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            jsonGenerator.X0(((Double) obj).doubleValue());
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, defpackage.f71
        public void serializeWithType(Object obj, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
            Double d = (Double) obj;
            if (!is1.o(d.doubleValue())) {
                jsonGenerator.X0(d.doubleValue());
                return;
            }
            WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(obj, JsonToken.VALUE_NUMBER_FLOAT));
            jsonGenerator.X0(d.doubleValue());
            z63Var.h(jsonGenerator, writableTypeIdG);
        }
    }

    @e41
    public static class FloatSerializer extends Base<Object> {
        static final FloatSerializer instance = new FloatSerializer();

        public FloatSerializer() {
            super(Float.class, JsonParser.NumberType.FLOAT, "number");
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            jsonGenerator.Y0(((Float) obj).floatValue());
        }
    }

    @e41
    public static class IntLikeSerializer extends Base<Object> {
        static final IntLikeSerializer instance = new IntLikeSerializer();

        public IntLikeSerializer() {
            super(Number.class, JsonParser.NumberType.INT, "integer");
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            jsonGenerator.Z0(((Number) obj).intValue());
        }
    }

    @e41
    public static class IntegerSerializer extends Base<Object> {
        public IntegerSerializer(Class<?> cls) {
            super(cls, JsonParser.NumberType.INT, "integer");
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            jsonGenerator.Z0(((Integer) obj).intValue());
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, defpackage.f71
        public void serializeWithType(Object obj, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
            serialize(obj, jsonGenerator, an2Var);
        }
    }

    @e41
    public static class LongSerializer extends Base<Object> {
        public LongSerializer(Class<?> cls) {
            super(cls, JsonParser.NumberType.LONG, "number");
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            jsonGenerator.a1(((Long) obj).longValue());
        }
    }

    @e41
    public static class ShortSerializer extends Base<Object> {
        static final ShortSerializer instance = new ShortSerializer();

        public ShortSerializer() {
            super(Short.class, JsonParser.NumberType.INT, "number");
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            jsonGenerator.e1(((Short) obj).shortValue());
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonFormat.Shape.values().length];
            a = iArr;
            try {
                iArr[JsonFormat.Shape.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static void a(Map map) {
        map.put(Integer.class.getName(), new IntegerSerializer(Integer.class));
        Class cls = Integer.TYPE;
        map.put(cls.getName(), new IntegerSerializer(cls));
        map.put(Long.class.getName(), new LongSerializer(Long.class));
        Class cls2 = Long.TYPE;
        map.put(cls2.getName(), new LongSerializer(cls2));
        String name = Byte.class.getName();
        IntLikeSerializer intLikeSerializer = IntLikeSerializer.instance;
        map.put(name, intLikeSerializer);
        map.put(Byte.TYPE.getName(), intLikeSerializer);
        String name2 = Short.class.getName();
        ShortSerializer shortSerializer = ShortSerializer.instance;
        map.put(name2, shortSerializer);
        map.put(Short.TYPE.getName(), shortSerializer);
        map.put(Double.class.getName(), new DoubleSerializer(Double.class));
        Class cls3 = Double.TYPE;
        map.put(cls3.getName(), new DoubleSerializer(cls3));
        String name3 = Float.class.getName();
        FloatSerializer floatSerializer = FloatSerializer.instance;
        map.put(name3, floatSerializer);
        map.put(Float.TYPE.getName(), floatSerializer);
    }
}
