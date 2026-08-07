package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import defpackage.an2;
import defpackage.e41;
import defpackage.f71;
import defpackage.w30;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
@e41
public final class BooleanSerializer extends StdScalarSerializer<Object> implements w30 {
    private static final long serialVersionUID = 1;
    protected final boolean _forPrimitive;

    static final class AsNumber extends StdScalarSerializer<Object> implements w30 {
        private static final long serialVersionUID = 1;
        protected final boolean _forPrimitive;

        public AsNumber(boolean z) {
            super(z ? Boolean.TYPE : Boolean.class, false);
            this._forPrimitive = z;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
            visitIntFormat(y51Var, javaType, JsonParser.NumberType.INT);
        }

        @Override // defpackage.w30
        public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
            JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(an2Var, beanProperty, Boolean.class);
            return (valueFindFormatOverrides == null || valueFindFormatOverrides.getShape().isNumeric()) ? this : new BooleanSerializer(this._forPrimitive);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            jsonGenerator.Z0(!Boolean.FALSE.equals(obj) ? 1 : 0);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, defpackage.f71
        public final void serializeWithType(Object obj, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
            jsonGenerator.P0(Boolean.TRUE.equals(obj));
        }
    }

    public BooleanSerializer(boolean z) {
        super(z ? Boolean.TYPE : Boolean.class, false);
        this._forPrimitive = z;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        y51Var.k(javaType);
    }

    @Override // defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(an2Var, beanProperty, handledType());
        if (valueFindFormatOverrides != null) {
            JsonFormat.Shape shape = valueFindFormatOverrides.getShape();
            if (shape.isNumeric()) {
                return new AsNumber(this._forPrimitive);
            }
            if (shape == JsonFormat.Shape.STRING) {
                return new ToStringSerializer(this._handledType);
            }
        }
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) {
        return createSchemaNode("boolean", !this._forPrimitive);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        jsonGenerator.P0(Boolean.TRUE.equals(obj));
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, defpackage.f71
    public final void serializeWithType(Object obj, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        jsonGenerator.P0(Boolean.TRUE.equals(obj));
    }
}
