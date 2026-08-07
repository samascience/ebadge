package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsFailProvider;
import com.fasterxml.jackson.databind.exc.InvalidNullException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import defpackage.e41;
import defpackage.gs1;
import defpackage.m63;
import defpackage.p9;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class PrimitiveArrayDeserializers<T> extends StdDeserializer<T> implements v30 {
    private transient Object _emptyValue;
    protected final gs1 _nuller;
    protected final Boolean _unwrapSingle;

    @e41
    static final class BooleanDeser extends PrimitiveArrayDeserializers<boolean[]> {
        private static final long serialVersionUID = 1;

        public BooleanDeser() {
            super(boolean[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(gs1 gs1Var, Boolean bool) {
            return new BooleanDeser(this, gs1Var, bool);
        }

        protected BooleanDeser(BooleanDeser booleanDeser, gs1 gs1Var, Boolean bool) {
            super(booleanDeser, gs1Var, bool);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public boolean[] _concat(boolean[] zArr, boolean[] zArr2) {
            int length = zArr.length;
            int length2 = zArr2.length;
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + length2);
            System.arraycopy(zArr2, 0, zArrCopyOf, length, length2);
            return zArrCopyOf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public boolean[] _constructEmpty() {
            return new boolean[0];
        }

        @Override // defpackage.s51
        public boolean[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            boolean z_parseBooleanPrimitive;
            int i;
            if (!jsonParser.i1()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            p9.b bVarC = deserializationContext.getArrayBuilders().c();
            boolean[] zArr = (boolean[]) bVarC.f();
            int i2 = 0;
            while (true) {
                try {
                    JsonToken jsonTokenN1 = jsonParser.n1();
                    if (jsonTokenN1 == JsonToken.END_ARRAY) {
                        return (boolean[]) bVarC.e(zArr, i2);
                    }
                    try {
                        if (jsonTokenN1 == JsonToken.VALUE_TRUE) {
                            z_parseBooleanPrimitive = true;
                        } else {
                            if (jsonTokenN1 != JsonToken.VALUE_FALSE) {
                                if (jsonTokenN1 == JsonToken.VALUE_NULL) {
                                    gs1 gs1Var = this._nuller;
                                    if (gs1Var != null) {
                                        gs1Var.getNullValue(deserializationContext);
                                    } else {
                                        _verifyNullForPrimitive(deserializationContext);
                                    }
                                } else {
                                    z_parseBooleanPrimitive = _parseBooleanPrimitive(jsonParser, deserializationContext);
                                }
                            }
                            z_parseBooleanPrimitive = false;
                        }
                        zArr[i2] = z_parseBooleanPrimitive;
                        i2 = i;
                    } catch (Exception e) {
                        e = e;
                        i2 = i;
                        throw JsonMappingException.wrapWithPath(e, zArr, bVarC.d() + i2);
                    }
                    if (i2 >= zArr.length) {
                        boolean[] zArr2 = (boolean[]) bVarC.c(zArr, i2);
                        i2 = 0;
                        zArr = zArr2;
                    }
                    i = i2 + 1;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public boolean[] handleSingleElementUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return new boolean[]{_parseBooleanPrimitive(jsonParser, deserializationContext)};
        }
    }

    @e41
    static final class ByteDeser extends PrimitiveArrayDeserializers<byte[]> {
        private static final long serialVersionUID = 1;

        public ByteDeser() {
            super(byte[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers, defpackage.s51
        public LogicalType logicalType() {
            return LogicalType.Binary;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(gs1 gs1Var, Boolean bool) {
            return new ByteDeser(this, gs1Var, bool);
        }

        protected ByteDeser(ByteDeser byteDeser, gs1 gs1Var, Boolean bool) {
            super(byteDeser, gs1Var, bool);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public byte[] _concat(byte[] bArr, byte[] bArr2) {
            int length = bArr.length;
            int length2 = bArr2.length;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
            System.arraycopy(bArr2, 0, bArrCopyOf, length, length2);
            return bArrCopyOf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public byte[] _constructEmpty() {
            return new byte[0];
        }

        @Override // defpackage.s51
        public byte[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            byte bM0;
            int i;
            JsonToken jsonTokenD = jsonParser.D();
            if (jsonTokenD == JsonToken.VALUE_STRING) {
                try {
                    return jsonParser.j0(deserializationContext.getBase64Variant());
                } catch (StreamReadException e) {
                    String originalMessage = e.getOriginalMessage();
                    if (originalMessage.contains("base64")) {
                        return (byte[]) deserializationContext.handleWeirdStringValue(byte[].class, jsonParser.S0(), originalMessage, new Object[0]);
                    }
                }
            }
            if (jsonTokenD == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object objH0 = jsonParser.H0();
                if (objH0 == null) {
                    return null;
                }
                if (objH0 instanceof byte[]) {
                    return (byte[]) objH0;
                }
            }
            if (!jsonParser.i1()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            p9.c cVarD = deserializationContext.getArrayBuilders().d();
            byte[] bArr = (byte[]) cVarD.f();
            int i2 = 0;
            while (true) {
                try {
                    JsonToken jsonTokenN1 = jsonParser.n1();
                    if (jsonTokenN1 == JsonToken.END_ARRAY) {
                        return (byte[]) cVarD.e(bArr, i2);
                    }
                    try {
                        if (jsonTokenN1 == JsonToken.VALUE_NUMBER_INT) {
                            bM0 = jsonParser.m0();
                        } else if (jsonTokenN1 == JsonToken.VALUE_NULL) {
                            gs1 gs1Var = this._nuller;
                            if (gs1Var != null) {
                                gs1Var.getNullValue(deserializationContext);
                            } else {
                                _verifyNullForPrimitive(deserializationContext);
                                bM0 = 0;
                            }
                        } else {
                            bM0 = _parseBytePrimitive(jsonParser, deserializationContext);
                        }
                        bArr[i2] = bM0;
                        i2 = i;
                    } catch (Exception e2) {
                        e = e2;
                        i2 = i;
                        throw JsonMappingException.wrapWithPath(e, bArr, cVarD.d() + i2);
                    }
                    if (i2 >= bArr.length) {
                        byte[] bArr2 = (byte[]) cVarD.c(bArr, i2);
                        i2 = 0;
                        bArr = bArr2;
                    }
                    i = i2 + 1;
                } catch (Exception e3) {
                    e = e3;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public byte[] handleSingleElementUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            byte bByteValue;
            JsonToken jsonTokenD = jsonParser.D();
            if (jsonTokenD == JsonToken.VALUE_NUMBER_INT) {
                bByteValue = jsonParser.m0();
            } else {
                if (jsonTokenD == JsonToken.VALUE_NULL) {
                    gs1 gs1Var = this._nuller;
                    if (gs1Var != null) {
                        gs1Var.getNullValue(deserializationContext);
                        return (byte[]) getEmptyValue(deserializationContext);
                    }
                    _verifyNullForPrimitive(deserializationContext);
                    return null;
                }
                bByteValue = ((Number) deserializationContext.handleUnexpectedToken(this._valueClass.getComponentType(), jsonParser)).byteValue();
            }
            return new byte[]{bByteValue};
        }
    }

    @e41
    static final class CharDeser extends PrimitiveArrayDeserializers<char[]> {
        private static final long serialVersionUID = 1;

        public CharDeser() {
            super(char[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(gs1 gs1Var, Boolean bool) {
            return this;
        }

        protected CharDeser(CharDeser charDeser, gs1 gs1Var, Boolean bool) {
            super(charDeser, gs1Var, bool);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public char[] _concat(char[] cArr, char[] cArr2) {
            int length = cArr.length;
            int length2 = cArr2.length;
            char[] cArrCopyOf = Arrays.copyOf(cArr, length + length2);
            System.arraycopy(cArr2, 0, cArrCopyOf, length, length2);
            return cArrCopyOf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public char[] _constructEmpty() {
            return new char[0];
        }

        @Override // defpackage.s51
        public char[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String strS0;
            if (jsonParser.d1(JsonToken.VALUE_STRING)) {
                char[] cArrT0 = jsonParser.T0();
                int iV0 = jsonParser.V0();
                int iU0 = jsonParser.U0();
                char[] cArr = new char[iU0];
                System.arraycopy(cArrT0, iV0, cArr, 0, iU0);
                return cArr;
            }
            if (!jsonParser.i1()) {
                if (jsonParser.d1(JsonToken.VALUE_EMBEDDED_OBJECT)) {
                    Object objH0 = jsonParser.H0();
                    if (objH0 == null) {
                        return null;
                    }
                    if (objH0 instanceof char[]) {
                        return (char[]) objH0;
                    }
                    if (objH0 instanceof String) {
                        return ((String) objH0).toCharArray();
                    }
                    if (objH0 instanceof byte[]) {
                        return com.fasterxml.jackson.core.a.a().encode((byte[]) objH0, false).toCharArray();
                    }
                }
                return (char[]) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser);
            }
            StringBuilder sb = new StringBuilder(64);
            while (true) {
                JsonToken jsonTokenN1 = jsonParser.n1();
                if (jsonTokenN1 == JsonToken.END_ARRAY) {
                    return sb.toString().toCharArray();
                }
                if (jsonTokenN1 == JsonToken.VALUE_STRING) {
                    strS0 = jsonParser.S0();
                } else if (jsonTokenN1 == JsonToken.VALUE_NULL) {
                    gs1 gs1Var = this._nuller;
                    if (gs1Var != null) {
                        gs1Var.getNullValue(deserializationContext);
                    } else {
                        _verifyNullForPrimitive(deserializationContext);
                        strS0 = "\u0000";
                    }
                } else {
                    strS0 = ((CharSequence) deserializationContext.handleUnexpectedToken(Character.TYPE, jsonParser)).toString();
                }
                if (strS0.length() != 1) {
                    deserializationContext.reportInputMismatch(this, "Cannot convert a JSON String of length %d into a char element of char array", Integer.valueOf(strS0.length()));
                }
                sb.append(strS0.charAt(0));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public char[] handleSingleElementUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return (char[]) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser);
        }
    }

    @e41
    static final class DoubleDeser extends PrimitiveArrayDeserializers<double[]> {
        private static final long serialVersionUID = 1;

        public DoubleDeser() {
            super(double[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(gs1 gs1Var, Boolean bool) {
            return new DoubleDeser(this, gs1Var, bool);
        }

        protected DoubleDeser(DoubleDeser doubleDeser, gs1 gs1Var, Boolean bool) {
            super(doubleDeser, gs1Var, bool);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public double[] _concat(double[] dArr, double[] dArr2) {
            int length = dArr.length;
            int length2 = dArr2.length;
            double[] dArrCopyOf = Arrays.copyOf(dArr, length + length2);
            System.arraycopy(dArr2, 0, dArrCopyOf, length, length2);
            return dArrCopyOf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public double[] _constructEmpty() {
            return new double[0];
        }

        @Override // defpackage.s51
        public double[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            gs1 gs1Var;
            if (!jsonParser.i1()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            p9.d dVarE = deserializationContext.getArrayBuilders().e();
            double[] dArr = (double[]) dVarE.f();
            int i = 0;
            while (true) {
                try {
                    JsonToken jsonTokenN1 = jsonParser.n1();
                    if (jsonTokenN1 == JsonToken.END_ARRAY) {
                        return (double[]) dVarE.e(dArr, i);
                    }
                    if (jsonTokenN1 != JsonToken.VALUE_NULL || (gs1Var = this._nuller) == null) {
                        double d_parseDoublePrimitive = _parseDoublePrimitive(jsonParser, deserializationContext);
                        if (i >= dArr.length) {
                            double[] dArr2 = (double[]) dVarE.c(dArr, i);
                            i = 0;
                            dArr = dArr2;
                        }
                        int i2 = i + 1;
                        try {
                            dArr[i] = d_parseDoublePrimitive;
                            i = i2;
                        } catch (Exception e) {
                            e = e;
                            i = i2;
                            throw JsonMappingException.wrapWithPath(e, dArr, dVarE.d() + i);
                        }
                    } else {
                        gs1Var.getNullValue(deserializationContext);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public double[] handleSingleElementUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return new double[]{_parseDoublePrimitive(jsonParser, deserializationContext)};
        }
    }

    @e41
    static final class FloatDeser extends PrimitiveArrayDeserializers<float[]> {
        private static final long serialVersionUID = 1;

        public FloatDeser() {
            super(float[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(gs1 gs1Var, Boolean bool) {
            return new FloatDeser(this, gs1Var, bool);
        }

        protected FloatDeser(FloatDeser floatDeser, gs1 gs1Var, Boolean bool) {
            super(floatDeser, gs1Var, bool);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public float[] _concat(float[] fArr, float[] fArr2) {
            int length = fArr.length;
            int length2 = fArr2.length;
            float[] fArrCopyOf = Arrays.copyOf(fArr, length + length2);
            System.arraycopy(fArr2, 0, fArrCopyOf, length, length2);
            return fArrCopyOf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public float[] _constructEmpty() {
            return new float[0];
        }

        @Override // defpackage.s51
        public float[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            gs1 gs1Var;
            if (!jsonParser.i1()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            p9.e eVarF = deserializationContext.getArrayBuilders().f();
            float[] fArr = (float[]) eVarF.f();
            int i = 0;
            while (true) {
                try {
                    JsonToken jsonTokenN1 = jsonParser.n1();
                    if (jsonTokenN1 == JsonToken.END_ARRAY) {
                        return (float[]) eVarF.e(fArr, i);
                    }
                    if (jsonTokenN1 != JsonToken.VALUE_NULL || (gs1Var = this._nuller) == null) {
                        float f_parseFloatPrimitive = _parseFloatPrimitive(jsonParser, deserializationContext);
                        if (i >= fArr.length) {
                            float[] fArr2 = (float[]) eVarF.c(fArr, i);
                            i = 0;
                            fArr = fArr2;
                        }
                        int i2 = i + 1;
                        try {
                            fArr[i] = f_parseFloatPrimitive;
                            i = i2;
                        } catch (Exception e) {
                            e = e;
                            i = i2;
                            throw JsonMappingException.wrapWithPath(e, fArr, eVarF.d() + i);
                        }
                    } else {
                        gs1Var.getNullValue(deserializationContext);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public float[] handleSingleElementUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return new float[]{_parseFloatPrimitive(jsonParser, deserializationContext)};
        }
    }

    @e41
    static final class IntDeser extends PrimitiveArrayDeserializers<int[]> {
        public static final IntDeser instance = new IntDeser();
        private static final long serialVersionUID = 1;

        public IntDeser() {
            super(int[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(gs1 gs1Var, Boolean bool) {
            return new IntDeser(this, gs1Var, bool);
        }

        protected IntDeser(IntDeser intDeser, gs1 gs1Var, Boolean bool) {
            super(intDeser, gs1Var, bool);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public int[] _concat(int[] iArr, int[] iArr2) {
            int length = iArr.length;
            int length2 = iArr2.length;
            int[] iArrCopyOf = Arrays.copyOf(iArr, length + length2);
            System.arraycopy(iArr2, 0, iArrCopyOf, length, length2);
            return iArrCopyOf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public int[] _constructEmpty() {
            return new int[0];
        }

        @Override // defpackage.s51
        public int[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            int iJ0;
            int i;
            if (!jsonParser.i1()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            p9.f fVarG = deserializationContext.getArrayBuilders().g();
            int[] iArr = (int[]) fVarG.f();
            int i2 = 0;
            while (true) {
                try {
                    JsonToken jsonTokenN1 = jsonParser.n1();
                    if (jsonTokenN1 == JsonToken.END_ARRAY) {
                        return (int[]) fVarG.e(iArr, i2);
                    }
                    try {
                        if (jsonTokenN1 == JsonToken.VALUE_NUMBER_INT) {
                            iJ0 = jsonParser.J0();
                        } else if (jsonTokenN1 == JsonToken.VALUE_NULL) {
                            gs1 gs1Var = this._nuller;
                            if (gs1Var != null) {
                                gs1Var.getNullValue(deserializationContext);
                            } else {
                                _verifyNullForPrimitive(deserializationContext);
                                iJ0 = 0;
                            }
                        } else {
                            iJ0 = _parseIntPrimitive(jsonParser, deserializationContext);
                        }
                        iArr[i2] = iJ0;
                        i2 = i;
                    } catch (Exception e) {
                        e = e;
                        i2 = i;
                        throw JsonMappingException.wrapWithPath(e, iArr, fVarG.d() + i2);
                    }
                    if (i2 >= iArr.length) {
                        int[] iArr2 = (int[]) fVarG.c(iArr, i2);
                        i2 = 0;
                        iArr = iArr2;
                    }
                    i = i2 + 1;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public int[] handleSingleElementUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return new int[]{_parseIntPrimitive(jsonParser, deserializationContext)};
        }
    }

    @e41
    static final class LongDeser extends PrimitiveArrayDeserializers<long[]> {
        public static final LongDeser instance = new LongDeser();
        private static final long serialVersionUID = 1;

        public LongDeser() {
            super(long[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(gs1 gs1Var, Boolean bool) {
            return new LongDeser(this, gs1Var, bool);
        }

        protected LongDeser(LongDeser longDeser, gs1 gs1Var, Boolean bool) {
            super(longDeser, gs1Var, bool);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public long[] _concat(long[] jArr, long[] jArr2) {
            int length = jArr.length;
            int length2 = jArr2.length;
            long[] jArrCopyOf = Arrays.copyOf(jArr, length + length2);
            System.arraycopy(jArr2, 0, jArrCopyOf, length, length2);
            return jArrCopyOf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public long[] _constructEmpty() {
            return new long[0];
        }

        @Override // defpackage.s51
        public long[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            long jK0;
            int i;
            if (!jsonParser.i1()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            p9.g gVarH = deserializationContext.getArrayBuilders().h();
            long[] jArr = (long[]) gVarH.f();
            int i2 = 0;
            while (true) {
                try {
                    JsonToken jsonTokenN1 = jsonParser.n1();
                    if (jsonTokenN1 == JsonToken.END_ARRAY) {
                        return (long[]) gVarH.e(jArr, i2);
                    }
                    try {
                        if (jsonTokenN1 == JsonToken.VALUE_NUMBER_INT) {
                            jK0 = jsonParser.K0();
                        } else if (jsonTokenN1 == JsonToken.VALUE_NULL) {
                            gs1 gs1Var = this._nuller;
                            if (gs1Var != null) {
                                gs1Var.getNullValue(deserializationContext);
                            } else {
                                _verifyNullForPrimitive(deserializationContext);
                                jK0 = 0;
                            }
                        } else {
                            jK0 = _parseLongPrimitive(jsonParser, deserializationContext);
                        }
                        jArr[i2] = jK0;
                        i2 = i;
                    } catch (Exception e) {
                        e = e;
                        i2 = i;
                        throw JsonMappingException.wrapWithPath(e, jArr, gVarH.d() + i2);
                    }
                    if (i2 >= jArr.length) {
                        long[] jArr2 = (long[]) gVarH.c(jArr, i2);
                        i2 = 0;
                        jArr = jArr2;
                    }
                    i = i2 + 1;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public long[] handleSingleElementUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return new long[]{_parseLongPrimitive(jsonParser, deserializationContext)};
        }
    }

    @e41
    static final class ShortDeser extends PrimitiveArrayDeserializers<short[]> {
        private static final long serialVersionUID = 1;

        public ShortDeser() {
            super(short[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(gs1 gs1Var, Boolean bool) {
            return new ShortDeser(this, gs1Var, bool);
        }

        protected ShortDeser(ShortDeser shortDeser, gs1 gs1Var, Boolean bool) {
            super(shortDeser, gs1Var, bool);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public short[] _concat(short[] sArr, short[] sArr2) {
            int length = sArr.length;
            int length2 = sArr2.length;
            short[] sArrCopyOf = Arrays.copyOf(sArr, length + length2);
            System.arraycopy(sArr2, 0, sArrCopyOf, length, length2);
            return sArrCopyOf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public short[] _constructEmpty() {
            return new short[0];
        }

        @Override // defpackage.s51
        public short[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            short s_parseShortPrimitive;
            int i;
            if (!jsonParser.i1()) {
                return handleNonArray(jsonParser, deserializationContext);
            }
            p9.h hVarI = deserializationContext.getArrayBuilders().i();
            short[] sArr = (short[]) hVarI.f();
            int i2 = 0;
            while (true) {
                try {
                    JsonToken jsonTokenN1 = jsonParser.n1();
                    if (jsonTokenN1 == JsonToken.END_ARRAY) {
                        return (short[]) hVarI.e(sArr, i2);
                    }
                    try {
                        if (jsonTokenN1 == JsonToken.VALUE_NULL) {
                            gs1 gs1Var = this._nuller;
                            if (gs1Var != null) {
                                gs1Var.getNullValue(deserializationContext);
                            } else {
                                _verifyNullForPrimitive(deserializationContext);
                                s_parseShortPrimitive = 0;
                            }
                        } else {
                            s_parseShortPrimitive = _parseShortPrimitive(jsonParser, deserializationContext);
                        }
                        sArr[i2] = s_parseShortPrimitive;
                        i2 = i;
                    } catch (Exception e) {
                        e = e;
                        i2 = i;
                        throw JsonMappingException.wrapWithPath(e, sArr, hVarI.d() + i2);
                    }
                    if (i2 >= sArr.length) {
                        short[] sArr2 = (short[]) hVarI.c(sArr, i2);
                        i2 = 0;
                        sArr = sArr2;
                    }
                    i = i2 + 1;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public short[] handleSingleElementUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return new short[]{_parseShortPrimitive(jsonParser, deserializationContext)};
        }
    }

    protected PrimitiveArrayDeserializers(Class<T> cls) {
        super((Class<?>) cls);
        this._unwrapSingle = null;
        this._nuller = null;
    }

    public static s51 forType(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return IntDeser.instance;
        }
        if (cls == Long.TYPE) {
            return LongDeser.instance;
        }
        if (cls == Byte.TYPE) {
            return new ByteDeser();
        }
        if (cls == Short.TYPE) {
            return new ShortDeser();
        }
        if (cls == Float.TYPE) {
            return new FloatDeser();
        }
        if (cls == Double.TYPE) {
            return new DoubleDeser();
        }
        if (cls == Boolean.TYPE) {
            return new BooleanDeser();
        }
        if (cls == Character.TYPE) {
            return new CharDeser();
        }
        throw new IllegalStateException();
    }

    protected abstract T _concat(T t, T t2);

    protected abstract T _constructEmpty();

    protected void _failOnNull(DeserializationContext deserializationContext) throws IOException {
        throw InvalidNullException.from(deserializationContext, (PropertyName) null, deserializationContext.constructType(this._valueClass));
    }

    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        gs1 gs1VarConstructForRootValue;
        Boolean boolFindFormatFeature = findFormatFeature(deserializationContext, beanProperty, this._valueClass, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Nulls nullsFindContentNullStyle = findContentNullStyle(deserializationContext, beanProperty);
        if (nullsFindContentNullStyle == Nulls.SKIP) {
            gs1VarConstructForRootValue = NullsConstantProvider.skipper();
        } else if (nullsFindContentNullStyle == Nulls.FAIL) {
            gs1VarConstructForRootValue = beanProperty == null ? NullsFailProvider.constructForRootValue(deserializationContext.constructType(this._valueClass.getComponentType())) : NullsFailProvider.constructForProperty(beanProperty, beanProperty.getType().mo15getContentType());
        } else {
            gs1VarConstructForRootValue = null;
        }
        return (Objects.equals(boolFindFormatFeature, this._unwrapSingle) && gs1VarConstructForRootValue == this._nuller) ? this : withResolved(gs1VarConstructForRootValue, boolFindFormatFeature);
    }

    @Override // defpackage.s51
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, T t) throws IOException {
        T t2 = (T) deserialize(jsonParser, deserializationContext);
        return (t == null || Array.getLength(t) == 0) ? t2 : _concat(t, t2);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return m63Var.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    @Override // defpackage.s51
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.CONSTANT;
    }

    @Override // defpackage.s51
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        Object obj = this._emptyValue;
        if (obj != null) {
            return obj;
        }
        T t_constructEmpty = _constructEmpty();
        this._emptyValue = t_constructEmpty;
        return t_constructEmpty;
    }

    protected T handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.d1(JsonToken.VALUE_STRING)) {
            return _deserializeFromString(jsonParser, deserializationContext);
        }
        Boolean bool = this._unwrapSingle;
        return (bool == Boolean.TRUE || (bool == null && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) ? handleSingleElementUnwrapped(jsonParser, deserializationContext) : (T) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser);
    }

    protected abstract T handleSingleElementUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException;

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.Array;
    }

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return Boolean.TRUE;
    }

    protected abstract PrimitiveArrayDeserializers<?> withResolved(gs1 gs1Var, Boolean bool);

    protected PrimitiveArrayDeserializers(PrimitiveArrayDeserializers<?> primitiveArrayDeserializers, gs1 gs1Var, Boolean bool) {
        super(primitiveArrayDeserializers._valueClass);
        this._unwrapSingle = bool;
        this._nuller = gs1Var;
    }
}
