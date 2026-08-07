package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import defpackage.an2;
import defpackage.y51;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class StdJdkSerializers {

    public static class AtomicBooleanSerializer extends StdScalarSerializer<AtomicBoolean> {
        public AtomicBooleanSerializer() {
            super(AtomicBoolean.class, false);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
            y51Var.k(javaType);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
        public JsonNode getSchema(an2 an2Var, Type type) {
            return createSchemaNode("boolean", true);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(AtomicBoolean atomicBoolean, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            jsonGenerator.P0(atomicBoolean.get());
        }
    }

    public static class AtomicIntegerSerializer extends StdScalarSerializer<AtomicInteger> {
        public AtomicIntegerSerializer() {
            super(AtomicInteger.class, false);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
            visitIntFormat(y51Var, javaType, JsonParser.NumberType.INT);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
        public JsonNode getSchema(an2 an2Var, Type type) {
            return createSchemaNode("integer", true);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(AtomicInteger atomicInteger, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            jsonGenerator.Z0(atomicInteger.get());
        }
    }

    public static class AtomicLongSerializer extends StdScalarSerializer<AtomicLong> {
        public AtomicLongSerializer() {
            super(AtomicLong.class, false);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
            visitIntFormat(y51Var, javaType, JsonParser.NumberType.LONG);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
        public JsonNode getSchema(an2 an2Var, Type type) {
            return createSchemaNode("integer", true);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(AtomicLong atomicLong, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            jsonGenerator.a1(atomicLong.get());
        }
    }

    public static Collection a() {
        HashMap map = new HashMap();
        map.put(URL.class, new ToStringSerializer(URL.class));
        map.put(URI.class, new ToStringSerializer(URI.class));
        map.put(Currency.class, new ToStringSerializer(Currency.class));
        map.put(UUID.class, new UUIDSerializer());
        map.put(Pattern.class, new ToStringSerializer(Pattern.class));
        map.put(Locale.class, new ToStringSerializer(Locale.class));
        map.put(AtomicBoolean.class, AtomicBooleanSerializer.class);
        map.put(AtomicInteger.class, AtomicIntegerSerializer.class);
        map.put(AtomicLong.class, AtomicLongSerializer.class);
        map.put(File.class, FileSerializer.class);
        map.put(Class.class, ClassSerializer.class);
        NullSerializer nullSerializer = NullSerializer.instance;
        map.put(Void.class, nullSerializer);
        map.put(Void.TYPE, nullSerializer);
        return map.entrySet();
    }
}
