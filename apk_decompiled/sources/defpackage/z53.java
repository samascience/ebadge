package defpackage;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class z53 extends ez1 {
    protected jt1 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected hr1 f458q;
    protected boolean r;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonToken.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonToken.FIELD_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[JsonToken.VALUE_STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public z53(JsonNode jsonNode) {
        this(jsonNode, null);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigDecimal F0() {
        return b2().decimalValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double G0() {
        return b2().doubleValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object H0() {
        JsonNode jsonNodeA2;
        if (this.r || (jsonNodeA2 = a2()) == null) {
            return null;
        }
        if (jsonNodeA2.isPojo()) {
            return ((POJONode) jsonNodeA2).getPojo();
        }
        if (jsonNodeA2.isBinary()) {
            return ((BinaryNode) jsonNodeA2).binaryValue();
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public float I0() {
        return (float) b2().doubleValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int J0() {
        NumericNode numericNode = (NumericNode) b2();
        if (!numericNode.canConvertToInt()) {
            U1();
        }
        return numericNode.intValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long K0() {
        NumericNode numericNode = (NumericNode) b2();
        if (!numericNode.canConvertToLong()) {
            X1();
        }
        return numericNode.longValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberType L0() throws JsonParseException {
        JsonNode jsonNodeB2 = b2();
        if (jsonNodeB2 == null) {
            return null;
        }
        return jsonNodeB2.numberType();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Number M0() {
        return b2().numberValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public h71 P0() {
        return this.f458q;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public d41 Q0() {
        return JsonParser.c;
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public String S0() {
        JsonToken jsonToken = this.d;
        if (jsonToken == null) {
            return null;
        }
        switch (a.a[jsonToken.ordinal()]) {
            case 5:
                return this.f458q.b();
            case 6:
                return a2().textValue();
            case 7:
            case 8:
                return String.valueOf(a2().numberValue());
            case 9:
                JsonNode jsonNodeA2 = a2();
                if (jsonNodeA2 != null && jsonNodeA2.isBinary()) {
                    return jsonNodeA2.asText();
                }
                break;
        }
        return this.d.asString();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public char[] T0() {
        return S0().toCharArray();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int U0() {
        return S0().length();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int V0() {
        return 0;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation W0() {
        return JsonLocation.NA;
    }

    protected JsonNode a2() {
        hr1 hr1Var;
        if (this.r || (hr1Var = this.f458q) == null) {
            return null;
        }
        return hr1Var.n();
    }

    protected JsonNode b2() throws JsonParseException {
        JsonNode jsonNodeA2 = a2();
        if (jsonNodeA2 != null && jsonNodeA2.isNumber()) {
            return jsonNodeA2;
        }
        throw n("Current token (" + (jsonNodeA2 == null ? null : jsonNodeA2.asToken()) + ") not numeric, cannot use numeric value accessors");
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean c1() {
        return false;
    }

    @Override // com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.r) {
            return;
        }
        this.r = true;
        this.f458q = null;
        this.d = null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigInteger e0() {
        return b2().bigIntegerValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public byte[] j0(Base64Variant base64Variant) {
        JsonNode jsonNodeA2 = a2();
        if (jsonNodeA2 != null) {
            return jsonNodeA2 instanceof TextNode ? ((TextNode) jsonNodeA2).getBinaryValue(base64Variant) : jsonNodeA2.binaryValue();
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean k1() {
        if (this.r) {
            return false;
        }
        JsonNode jsonNodeA2 = a2();
        if (jsonNodeA2 instanceof NumericNode) {
            return ((NumericNode) jsonNodeA2).isNaN();
        }
        return false;
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public JsonToken n1() {
        JsonToken jsonTokenP = this.f458q.p();
        this.d = jsonTokenP;
        if (jsonTokenP == null) {
            this.r = true;
            return null;
        }
        int i = a.a[jsonTokenP.ordinal()];
        if (i == 1) {
            this.f458q = this.f458q.r();
        } else if (i == 2) {
            this.f458q = this.f458q.q();
        } else if (i == 3 || i == 4) {
            this.f458q = this.f458q.o();
        }
        return this.d;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int q1(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        byte[] bArrJ0 = j0(base64Variant);
        if (bArrJ0 == null) {
            return 0;
        }
        outputStream.write(bArrJ0, 0, bArrJ0.length);
        return bArrJ0.length;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public jt1 t0() {
        return this.p;
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public JsonParser v1() {
        JsonToken jsonToken = this.d;
        if (jsonToken == JsonToken.START_OBJECT) {
            this.f458q = this.f458q.o();
            this.d = JsonToken.END_OBJECT;
        } else if (jsonToken == JsonToken.START_ARRAY) {
            this.f458q = this.f458q.o();
            this.d = JsonToken.END_ARRAY;
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation w0() {
        return JsonLocation.NA;
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public String y0() {
        hr1 hr1VarO = this.f458q;
        JsonToken jsonToken = this.d;
        if (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) {
            hr1VarO = hr1VarO.o();
        }
        if (hr1VarO == null) {
            return null;
        }
        return hr1VarO.b();
    }

    @Override // defpackage.ez1
    protected void z1() {
        N1();
    }

    public z53(JsonNode jsonNode, jt1 jt1Var) {
        super(0);
        this.p = jt1Var;
        this.f458q = new hr1.c(jsonNode, null);
    }
}
