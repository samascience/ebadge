package defpackage;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class s61 extends JsonParser {
    protected JsonParser d;

    public s61(JsonParser jsonParser) {
        this.d = jsonParser;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken A0() {
        return this.d.A0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String C() {
        return this.d.C();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken D() {
        return this.d.D();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigDecimal F0() {
        return this.d.F0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double G0() {
        return this.d.G0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object H0() {
        return this.d.H0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public float I0() {
        return this.d.I0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int J0() {
        return this.d.J0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long K0() {
        return this.d.K0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberType L0() {
        return this.d.L0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Number M0() {
        return this.d.M0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Number N0() {
        return this.d.N0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object O0() {
        return this.d.O0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public h71 P0() {
        return this.d.P0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public d41 Q0() {
        return this.d.Q0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public short R0() {
        return this.d.R0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String S0() {
        return this.d.S0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public char[] T0() {
        return this.d.T0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int U0() {
        return this.d.U0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int V() {
        return this.d.V();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int V0() {
        return this.d.V0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation W0() {
        return this.d.W0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object X0() {
        return this.d.X0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int Y0() {
        return this.d.Y0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long Z0() {
        return this.d.Z0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser a0(JsonParser.Feature feature) {
        this.d.a0(feature);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String a1() {
        return this.d.a1();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean b1() {
        return this.d.b1();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean c1() {
        return this.d.c1();
    }

    @Override // com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d.close();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean d1(JsonToken jsonToken) {
        return this.d.d1(jsonToken);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigInteger e0() {
        return this.d.e0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean e1(int i) {
        return this.d.e1(i);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean h1() {
        return this.d.h1();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean i1() {
        return this.d.i1();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public byte[] j0(Base64Variant base64Variant) {
        return this.d.j0(base64Variant);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean j1() {
        return this.d.j1();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean k0() {
        return this.d.k0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean k1() {
        return this.d.k1();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public byte m0() {
        return this.d.m0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser o1(int i, int i2) {
        this.d.o1(i, i2);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser p1(int i, int i2) {
        this.d.p1(i, i2);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int q1(Base64Variant base64Variant, OutputStream outputStream) {
        return this.d.q1(base64Variant, outputStream);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean r1() {
        return this.d.r1();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void s1(Object obj) {
        this.d.s1(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public jt1 t0() {
        return this.d.t0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser t1(int i) {
        this.d.t1(i);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean u() {
        return this.d.u();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void u1(ip0 ip0Var) {
        this.d.u1(ip0Var);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean w() {
        return this.d.w();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation w0() {
        return this.d.w0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void y() {
        this.d.y();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String y0() {
        return this.d.y0();
    }
}
