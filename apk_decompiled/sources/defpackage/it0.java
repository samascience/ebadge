package defpackage;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public abstract class it0 extends JsonGenerator {
    protected static final int j = (JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.getMask() | JsonGenerator.Feature.ESCAPE_NON_ASCII.getMask()) | JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.getMask();
    protected jt1 e;
    protected int f;
    protected boolean g;
    protected z71 h;
    protected boolean i;

    protected it0(int i, jt1 jt1Var) {
        this.f = i;
        this.e = jt1Var;
        this.h = z71.t(JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i) ? ae0.e(this) : null);
        this.g = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.enabledIn(i);
    }

    protected String C1(BigDecimal bigDecimal) throws JsonGenerationException {
        if (!JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN.enabledIn(this.f)) {
            return bigDecimal.toString();
        }
        int iScale = bigDecimal.scale();
        if (iScale < -9999 || iScale > 9999) {
            n(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(iScale), 9999, 9999));
        }
        return bigDecimal.toPlainString();
    }

    protected void D1(byte[] bArr, int i, int i2) throws JsonGenerationException {
        if (bArr == null) {
            n("Invalid `byte[]` argument: `null`");
        }
        int length = bArr.length;
        int i3 = i + i2;
        if (((length - i3) | i | i2 | i3) < 0) {
            n(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `byte[]` of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(length)));
        }
    }

    protected void E1(char[] cArr, int i, int i2) throws JsonGenerationException {
        if (cArr == null) {
            n("Invalid `char[]` argument: `null`");
        }
        int length = cArr.length;
        int i3 = i + i2;
        if (((length - i3) | i | i2 | i3) < 0) {
            n(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `char[]` of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(length)));
        }
    }

    protected void F1(String str, int i, int i2) throws JsonGenerationException {
        if (str == null) {
            n("Invalid `String` argument: `null`");
        }
        int length = str.length();
        int i3 = i + i2;
        if (((length - i3) | i | i2 | i3) < 0) {
            n(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `String` of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(length)));
        }
    }

    protected void G1(int i, int i2) {
        if ((j & i2) == 0) {
            return;
        }
        this.g = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.enabledIn(i);
        JsonGenerator.Feature feature = JsonGenerator.Feature.ESCAPE_NON_ASCII;
        if (feature.enabledIn(i2)) {
            if (feature.enabledIn(i)) {
                A0(127);
            } else {
                A0(0);
            }
        }
        JsonGenerator.Feature feature2 = JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION;
        if (feature2.enabledIn(i2)) {
            if (!feature2.enabledIn(i)) {
                this.h = this.h.y(null);
            } else if (this.h.u() == null) {
                this.h = this.h.y(ae0.e(this));
            }
        }
    }

    protected final int H1(int i, int i2) throws JsonGenerationException {
        if (i2 < 56320 || i2 > 57343) {
            n(String.format("Incomplete surrogate pair: first char 0x%04X, second 0x%04X", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        return ((i - 55296) << 10) + 65536 + (i2 - 56320);
    }

    protected abstract void I1(String str);

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.i = true;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator e0(JsonGenerator.Feature feature) {
        int mask = feature.getMask();
        this.f &= ~mask;
        if ((mask & j) != 0) {
            if (feature == JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS) {
                this.g = false;
            } else if (feature == JsonGenerator.Feature.ESCAPE_NON_ASCII) {
                A0(0);
            } else if (feature == JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION) {
                this.h = this.h.y(null);
            }
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void f1(Object obj) {
        if (obj == null) {
            W0();
            return;
        }
        jt1 jt1Var = this.e;
        if (jt1Var != null) {
            jt1Var.writeValue(this, obj);
        } else {
            y(obj);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public h71 g0() {
        return this.h;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final boolean k0(JsonGenerator.Feature feature) {
        return (feature.getMask() & this.f) != 0;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void n1(vm2 vm2Var) {
        I1("write raw value");
        k1(vm2Var);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void o1(String str) {
        I1("write raw value");
        l1(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator t0(int i, int i2) {
        int i3 = this.f;
        int i4 = (i & i2) | ((~i2) & i3);
        int i5 = i3 ^ i4;
        if (i5 != 0) {
            this.f = i4;
            G1(i4, i5);
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void y0(Object obj) {
        z71 z71Var = this.h;
        if (z71Var != null) {
            z71Var.l(obj);
        }
    }
}
