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
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
@e41
public class NumberSerializer extends StdScalarSerializer<Number> implements w30 {
    protected static final int MAX_BIG_DECIMAL_SCALE = 9999;
    public static final NumberSerializer instance = new NumberSerializer(Number.class);
    protected final boolean _isInt;

    static final class BigDecimalAsStringSerializer extends ToStringSerializerBase {
        static final BigDecimalAsStringSerializer BD_INSTANCE = new BigDecimalAsStringSerializer();

        public BigDecimalAsStringSerializer() {
            super(BigDecimal.class);
        }

        protected boolean _verifyBigDecimalRange(JsonGenerator jsonGenerator, BigDecimal bigDecimal) throws IOException {
            int iScale = bigDecimal.scale();
            return iScale >= -9999 && iScale <= NumberSerializer.MAX_BIG_DECIMAL_SCALE;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase, defpackage.f71
        public boolean isEmpty(an2 an2Var, Object obj) {
            return false;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
        public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
            String string;
            if (jsonGenerator.k0(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)) {
                BigDecimal bigDecimal = (BigDecimal) obj;
                if (!_verifyBigDecimalRange(jsonGenerator, bigDecimal)) {
                    an2Var.reportMappingProblem(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(bigDecimal.scale()), Integer.valueOf(NumberSerializer.MAX_BIG_DECIMAL_SCALE), Integer.valueOf(NumberSerializer.MAX_BIG_DECIMAL_SCALE)), new Object[0]);
                }
                string = bigDecimal.toPlainString();
            } else {
                string = obj.toString();
            }
            jsonGenerator.w1(string);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase
        public String valueToString(Object obj) {
            throw new IllegalStateException();
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

    public NumberSerializer(Class<? extends Number> cls) {
        super(cls, false);
        this._isInt = cls == BigInteger.class;
    }

    public static f71 bigDecimalAsStringSerializer() {
        return BigDecimalAsStringSerializer.BD_INSTANCE;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        if (this._isInt) {
            visitIntFormat(y51Var, javaType, JsonParser.NumberType.BIG_INTEGER);
        } else if (handledType() == BigDecimal.class) {
            visitFloatFormat(y51Var, javaType, JsonParser.NumberType.BIG_DECIMAL);
        } else {
            y51Var.f(javaType);
        }
    }

    @Override // defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(an2Var, beanProperty, handledType());
        if (valueFindFormatOverrides == null || a.a[valueFindFormatOverrides.getShape().ordinal()] != 1) {
            return this;
        }
        return handledType() == BigDecimal.class ? bigDecimalAsStringSerializer() : ToStringSerializer.instance;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) {
        return createSchemaNode(this._isInt ? "integer" : "number", true);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(Number number, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        if (number instanceof BigDecimal) {
            jsonGenerator.c1((BigDecimal) number);
            return;
        }
        if (number instanceof BigInteger) {
            jsonGenerator.d1((BigInteger) number);
            return;
        }
        if (number instanceof Long) {
            jsonGenerator.a1(number.longValue());
            return;
        }
        if (number instanceof Double) {
            jsonGenerator.X0(number.doubleValue());
            return;
        }
        if (number instanceof Float) {
            jsonGenerator.Y0(number.floatValue());
        } else if ((number instanceof Integer) || (number instanceof Byte) || (number instanceof Short)) {
            jsonGenerator.Z0(number.intValue());
        } else {
            jsonGenerator.b1(number.toString());
        }
    }
}
