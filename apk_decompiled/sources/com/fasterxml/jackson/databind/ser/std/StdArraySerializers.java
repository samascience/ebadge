package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.tencent.open.SocialConstants;
import defpackage.an2;
import defpackage.e41;
import defpackage.f71;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class StdArraySerializers {
    protected static final HashMap a;

    @e41
    public static class BooleanArraySerializer extends ArraySerializerBase<boolean[]> {
        private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Boolean.class);

        public BooleanArraySerializer() {
            super(boolean[].class);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public f71 _withResolved(BeanProperty beanProperty, Boolean bool) {
            return new BooleanArraySerializer(this, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public ContainerSerializer<?> _withValueTypeSerializer(z63 z63Var) {
            return this;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
            visitArrayFormat(y51Var, javaType, JsonFormatTypes.BOOLEAN);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public f71 getContentSerializer() {
            return null;
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public JavaType getContentType() {
            return VALUE_TYPE;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
        public JsonNode getSchema(an2 an2Var, Type type) {
            ObjectNode objectNodeCreateSchemaNode = createSchemaNode("array", true);
            objectNodeCreateSchemaNode.set("items", createSchemaNode("boolean"));
            return objectNodeCreateSchemaNode;
        }

        protected BooleanArraySerializer(BooleanArraySerializer booleanArraySerializer, BeanProperty beanProperty, Boolean bool) {
            super(booleanArraySerializer, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public boolean hasSingleElement(boolean[] zArr) {
            return zArr.length == 1;
        }

        @Override // defpackage.f71
        public boolean isEmpty(an2 an2Var, boolean[] zArr) {
            return zArr.length == 0;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public final void serialize(boolean[] zArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            int length = zArr.length;
            if (length == 1 && _shouldUnwrapSingle(an2Var)) {
                serializeContents(zArr, jsonGenerator, an2Var);
                return;
            }
            jsonGenerator.r1(zArr, length);
            serializeContents(zArr, jsonGenerator, an2Var);
            jsonGenerator.R0();
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public void serializeContents(boolean[] zArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            for (boolean z : zArr) {
                jsonGenerator.P0(z);
            }
        }
    }

    @e41
    public static class CharArraySerializer extends StdSerializer<char[]> {
        public CharArraySerializer() {
            super(char[].class);
        }

        private final void _writeArrayContents(JsonGenerator jsonGenerator, char[] cArr) throws IOException {
            int length = cArr.length;
            for (int i = 0; i < length; i++) {
                jsonGenerator.x1(cArr, i, 1);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
            visitArrayFormat(y51Var, javaType, JsonFormatTypes.STRING);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
        public JsonNode getSchema(an2 an2Var, Type type) {
            ObjectNode objectNodeCreateSchemaNode = createSchemaNode("array", true);
            ObjectNode objectNodeCreateSchemaNode2 = createSchemaNode("string");
            objectNodeCreateSchemaNode2.put(SocialConstants.PARAM_TYPE, "string");
            return objectNodeCreateSchemaNode.set("items", objectNodeCreateSchemaNode2);
        }

        @Override // defpackage.f71
        public boolean isEmpty(an2 an2Var, char[] cArr) {
            return cArr.length == 0;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(char[] cArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            if (!an2Var.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                jsonGenerator.x1(cArr, 0, cArr.length);
                return;
            }
            jsonGenerator.r1(cArr, cArr.length);
            _writeArrayContents(jsonGenerator, cArr);
            jsonGenerator.R0();
        }

        @Override // defpackage.f71
        public void serializeWithType(char[] cArr, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
            WritableTypeId writableTypeIdG;
            if (an2Var.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(cArr, JsonToken.START_ARRAY));
                _writeArrayContents(jsonGenerator, cArr);
            } else {
                writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(cArr, JsonToken.VALUE_STRING));
                jsonGenerator.x1(cArr, 0, cArr.length);
            }
            z63Var.h(jsonGenerator, writableTypeIdG);
        }
    }

    @e41
    public static class DoubleArraySerializer extends ArraySerializerBase<double[]> {
        private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Double.TYPE);

        public DoubleArraySerializer() {
            super(double[].class);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public f71 _withResolved(BeanProperty beanProperty, Boolean bool) {
            return new DoubleArraySerializer(this, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public ContainerSerializer<?> _withValueTypeSerializer(z63 z63Var) {
            return this;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
            visitArrayFormat(y51Var, javaType, JsonFormatTypes.NUMBER);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public f71 getContentSerializer() {
            return null;
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public JavaType getContentType() {
            return VALUE_TYPE;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
        public JsonNode getSchema(an2 an2Var, Type type) {
            return createSchemaNode("array", true).set("items", createSchemaNode("number"));
        }

        protected DoubleArraySerializer(DoubleArraySerializer doubleArraySerializer, BeanProperty beanProperty, Boolean bool) {
            super(doubleArraySerializer, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public boolean hasSingleElement(double[] dArr) {
            return dArr.length == 1;
        }

        @Override // defpackage.f71
        public boolean isEmpty(an2 an2Var, double[] dArr) {
            return dArr.length == 0;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public final void serialize(double[] dArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            if (dArr.length == 1 && _shouldUnwrapSingle(an2Var)) {
                serializeContents(dArr, jsonGenerator, an2Var);
            } else {
                jsonGenerator.H0(dArr, 0, dArr.length);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public void serializeContents(double[] dArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            for (double d : dArr) {
                jsonGenerator.X0(d);
            }
        }
    }

    @e41
    public static class FloatArraySerializer extends TypedPrimitiveArraySerializer<float[]> {
        private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Float.TYPE);

        public FloatArraySerializer() {
            super(float[].class);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public f71 _withResolved(BeanProperty beanProperty, Boolean bool) {
            return new FloatArraySerializer(this, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
            visitArrayFormat(y51Var, javaType, JsonFormatTypes.NUMBER);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public f71 getContentSerializer() {
            return null;
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public JavaType getContentType() {
            return VALUE_TYPE;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
        public JsonNode getSchema(an2 an2Var, Type type) {
            return createSchemaNode("array", true).set("items", createSchemaNode("number"));
        }

        public FloatArraySerializer(FloatArraySerializer floatArraySerializer, BeanProperty beanProperty, Boolean bool) {
            super(floatArraySerializer, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public boolean hasSingleElement(float[] fArr) {
            return fArr.length == 1;
        }

        @Override // defpackage.f71
        public boolean isEmpty(an2 an2Var, float[] fArr) {
            return fArr.length == 0;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public final void serialize(float[] fArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            int length = fArr.length;
            if (length == 1 && _shouldUnwrapSingle(an2Var)) {
                serializeContents(fArr, jsonGenerator, an2Var);
                return;
            }
            jsonGenerator.r1(fArr, length);
            serializeContents(fArr, jsonGenerator, an2Var);
            jsonGenerator.R0();
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public void serializeContents(float[] fArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            for (float f : fArr) {
                jsonGenerator.Y0(f);
            }
        }
    }

    @e41
    public static class IntArraySerializer extends ArraySerializerBase<int[]> {
        private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Integer.TYPE);

        public IntArraySerializer() {
            super(int[].class);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public f71 _withResolved(BeanProperty beanProperty, Boolean bool) {
            return new IntArraySerializer(this, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public ContainerSerializer<?> _withValueTypeSerializer(z63 z63Var) {
            return this;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
            visitArrayFormat(y51Var, javaType, JsonFormatTypes.INTEGER);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public f71 getContentSerializer() {
            return null;
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public JavaType getContentType() {
            return VALUE_TYPE;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
        public JsonNode getSchema(an2 an2Var, Type type) {
            return createSchemaNode("array", true).set("items", createSchemaNode("integer"));
        }

        protected IntArraySerializer(IntArraySerializer intArraySerializer, BeanProperty beanProperty, Boolean bool) {
            super(intArraySerializer, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public boolean hasSingleElement(int[] iArr) {
            return iArr.length == 1;
        }

        @Override // defpackage.f71
        public boolean isEmpty(an2 an2Var, int[] iArr) {
            return iArr.length == 0;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public final void serialize(int[] iArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            if (iArr.length == 1 && _shouldUnwrapSingle(an2Var)) {
                serializeContents(iArr, jsonGenerator, an2Var);
            } else {
                jsonGenerator.I0(iArr, 0, iArr.length);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public void serializeContents(int[] iArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            for (int i : iArr) {
                jsonGenerator.Z0(i);
            }
        }
    }

    @e41
    public static class LongArraySerializer extends TypedPrimitiveArraySerializer<long[]> {
        private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Long.TYPE);

        public LongArraySerializer() {
            super(long[].class);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public f71 _withResolved(BeanProperty beanProperty, Boolean bool) {
            return new LongArraySerializer(this, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
            visitArrayFormat(y51Var, javaType, JsonFormatTypes.NUMBER);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public f71 getContentSerializer() {
            return null;
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public JavaType getContentType() {
            return VALUE_TYPE;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
        public JsonNode getSchema(an2 an2Var, Type type) {
            return createSchemaNode("array", true).set("items", createSchemaNode("number", true));
        }

        public LongArraySerializer(LongArraySerializer longArraySerializer, BeanProperty beanProperty, Boolean bool) {
            super(longArraySerializer, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public boolean hasSingleElement(long[] jArr) {
            return jArr.length == 1;
        }

        @Override // defpackage.f71
        public boolean isEmpty(an2 an2Var, long[] jArr) {
            return jArr.length == 0;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public final void serialize(long[] jArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            if (jArr.length == 1 && _shouldUnwrapSingle(an2Var)) {
                serializeContents(jArr, jsonGenerator, an2Var);
            } else {
                jsonGenerator.J0(jArr, 0, jArr.length);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public void serializeContents(long[] jArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            for (long j : jArr) {
                jsonGenerator.a1(j);
            }
        }
    }

    @e41
    public static class ShortArraySerializer extends TypedPrimitiveArraySerializer<short[]> {
        private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Short.TYPE);

        public ShortArraySerializer() {
            super(short[].class);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public f71 _withResolved(BeanProperty beanProperty, Boolean bool) {
            return new ShortArraySerializer(this, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
            visitArrayFormat(y51Var, javaType, JsonFormatTypes.INTEGER);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public f71 getContentSerializer() {
            return null;
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public JavaType getContentType() {
            return VALUE_TYPE;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
        public JsonNode getSchema(an2 an2Var, Type type) {
            return createSchemaNode("array", true).set("items", createSchemaNode("integer"));
        }

        public ShortArraySerializer(ShortArraySerializer shortArraySerializer, BeanProperty beanProperty, Boolean bool) {
            super(shortArraySerializer, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public boolean hasSingleElement(short[] sArr) {
            return sArr.length == 1;
        }

        @Override // defpackage.f71
        public boolean isEmpty(an2 an2Var, short[] sArr) {
            return sArr.length == 0;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public final void serialize(short[] sArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            int length = sArr.length;
            if (length == 1 && _shouldUnwrapSingle(an2Var)) {
                serializeContents(sArr, jsonGenerator, an2Var);
                return;
            }
            jsonGenerator.r1(sArr, length);
            serializeContents(sArr, jsonGenerator, an2Var);
            jsonGenerator.R0();
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public void serializeContents(short[] sArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            for (short s : sArr) {
                jsonGenerator.Z0(s);
            }
        }
    }

    protected static abstract class TypedPrimitiveArraySerializer<T> extends ArraySerializerBase<T> {
        protected TypedPrimitiveArraySerializer(Class<T> cls) {
            super(cls);
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public final ContainerSerializer<?> _withValueTypeSerializer(z63 z63Var) {
            return this;
        }

        protected TypedPrimitiveArraySerializer(TypedPrimitiveArraySerializer<T> typedPrimitiveArraySerializer, BeanProperty beanProperty, Boolean bool) {
            super(typedPrimitiveArraySerializer, beanProperty, bool);
        }
    }

    static {
        HashMap map = new HashMap();
        a = map;
        map.put(boolean[].class.getName(), new BooleanArraySerializer());
        map.put(byte[].class.getName(), new ByteArraySerializer());
        map.put(char[].class.getName(), new CharArraySerializer());
        map.put(short[].class.getName(), new ShortArraySerializer());
        map.put(int[].class.getName(), new IntArraySerializer());
        map.put(long[].class.getName(), new LongArraySerializer());
        map.put(float[].class.getName(), new FloatArraySerializer());
        map.put(double[].class.getName(), new DoubleArraySerializer());
    }

    public static f71 a(Class cls) {
        return (f71) a.get(cls.getName());
    }
}
