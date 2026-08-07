package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.EnumValues;
import defpackage.an2;
import defpackage.e41;
import defpackage.f71;
import defpackage.kh;
import defpackage.vm2;
import defpackage.w30;
import defpackage.y51;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@e41
public class EnumSerializer extends StdScalarSerializer<Enum<?>> implements w30 {
    private static final long serialVersionUID = 1;
    protected final Boolean _serializeAsIndex;
    protected final EnumValues _values;

    public EnumSerializer(EnumValues enumValues, Boolean bool) {
        super(enumValues.getEnumClass(), false);
        this._values = enumValues;
        this._serializeAsIndex = bool;
    }

    protected static Boolean _isShapeWrittenUsingIndex(Class<?> cls, JsonFormat.Value value, boolean z, Boolean bool) {
        JsonFormat.Shape shape = value == null ? null : value.getShape();
        if (shape == null || shape == JsonFormat.Shape.ANY || shape == JsonFormat.Shape.SCALAR) {
            return bool;
        }
        if (shape == JsonFormat.Shape.STRING || shape == JsonFormat.Shape.NATURAL) {
            return Boolean.FALSE;
        }
        if (shape.isNumeric() || shape == JsonFormat.Shape.ARRAY) {
            return Boolean.TRUE;
        }
        throw new IllegalArgumentException(String.format("Unsupported serialization shape (%s) for Enum %s, not supported as %s annotation", shape, cls.getName(), z ? "class" : "property"));
    }

    public static EnumSerializer construct(Class<?> cls, SerializationConfig serializationConfig, kh khVar, JsonFormat.Value value) {
        return new EnumSerializer(EnumValues.constructFromName(serializationConfig, cls), _isShapeWrittenUsingIndex(cls, value, true, null));
    }

    protected final boolean _serializeAsIndex(an2 an2Var) {
        Boolean bool = this._serializeAsIndex;
        return bool != null ? bool.booleanValue() : an2Var.isEnabled(SerializationFeature.WRITE_ENUMS_USING_INDEX);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        if (_serializeAsIndex(y51Var.b())) {
            visitIntFormat(y51Var, javaType, JsonParser.NumberType.INT);
        } else {
            y51Var.d(javaType);
        }
    }

    @Override // defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(an2Var, beanProperty, handledType());
        if (valueFindFormatOverrides != null) {
            Boolean bool_isShapeWrittenUsingIndex = _isShapeWrittenUsingIndex(handledType(), valueFindFormatOverrides, false, this._serializeAsIndex);
            if (!Objects.equals(bool_isShapeWrittenUsingIndex, this._serializeAsIndex)) {
                return new EnumSerializer(this._values, bool_isShapeWrittenUsingIndex);
            }
        }
        return this;
    }

    public EnumValues getEnumValues() {
        return this._values;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) {
        if (_serializeAsIndex(an2Var)) {
            return createSchemaNode("integer", true);
        }
        ObjectNode objectNodeCreateSchemaNode = createSchemaNode("string", true);
        if (type != null && an2Var.constructType(type).isEnumType()) {
            ArrayNode arrayNodePutArray = objectNodeCreateSchemaNode.putArray("enum");
            Iterator<vm2> it = this._values.values().iterator();
            while (it.hasNext()) {
                arrayNodePutArray.add(it.next().getValue());
            }
        }
        return objectNodeCreateSchemaNode;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public final void serialize(Enum<?> r2, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        if (_serializeAsIndex(an2Var)) {
            jsonGenerator.Z0(r2.ordinal());
        } else if (an2Var.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
            jsonGenerator.w1(r2.toString());
        } else {
            jsonGenerator.v1(this._values.serializedValueFor(r2));
        }
    }
}
