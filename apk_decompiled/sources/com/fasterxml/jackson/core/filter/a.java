package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import defpackage.h71;
import defpackage.s61;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class a extends s61 {
    protected TokenFilter e;
    protected boolean f;
    protected TokenFilter.Inclusion g;
    protected JsonToken h;
    protected JsonToken i;
    protected b j;
    protected b k;
    protected TokenFilter l;
    protected int m;

    public a(JsonParser jsonParser, TokenFilter tokenFilter, TokenFilter.Inclusion inclusion, boolean z) {
        super(jsonParser);
        this.e = tokenFilter;
        this.l = tokenFilter;
        this.j = b.r(tokenFilter);
        this.g = inclusion;
        this.f = z;
    }

    private final boolean A1() {
        int i = this.m;
        if (i != 0 && !this.f) {
            return false;
        }
        this.m = i + 1;
        return true;
    }

    private JsonToken x1(b bVar) throws JsonParseException {
        this.k = bVar;
        JsonToken jsonTokenW = bVar.w();
        if (jsonTokenW != null) {
            return jsonTokenW;
        }
        while (bVar != this.j) {
            bVar = this.k.s(bVar);
            this.k = bVar;
            if (bVar == null) {
                throw n("Unexpected problem: chain of filtered context broken");
            }
            JsonToken jsonTokenW2 = bVar.w();
            if (jsonTokenW2 != null) {
                return jsonTokenW2;
            }
        }
        throw n("Internal error: failed to locate expected buffered tokens");
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public JsonToken A0() {
        return this.h;
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public String C() {
        h71 h71VarW1 = w1();
        JsonToken jsonToken = this.h;
        if (jsonToken != JsonToken.START_OBJECT && jsonToken != JsonToken.START_ARRAY) {
            return h71VarW1.b();
        }
        h71 h71VarE = h71VarW1.e();
        if (h71VarE == null) {
            return null;
        }
        return h71VarE.b();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public JsonToken D() {
        return this.h;
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public BigDecimal F0() {
        return this.d.F0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public double G0() {
        return this.d.G0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public Object H0() {
        return this.d.H0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public float I0() {
        return this.d.I0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public int J0() {
        return this.d.J0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public long K0() {
        return this.d.K0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberType L0() {
        return this.d.L0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public Number M0() {
        return this.d.M0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public h71 P0() {
        return w1();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public short R0() {
        return this.d.R0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public String S0() {
        return this.h == JsonToken.FIELD_NAME ? C() : this.d.S0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public char[] T0() {
        return this.h == JsonToken.FIELD_NAME ? C().toCharArray() : this.d.T0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public int U0() {
        return this.h == JsonToken.FIELD_NAME ? C().length() : this.d.U0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public final int V() {
        JsonToken jsonToken = this.h;
        if (jsonToken == null) {
            return 0;
        }
        return jsonToken.id();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public int V0() {
        if (this.h == JsonToken.FIELD_NAME) {
            return 0;
        }
        return this.d.V0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public JsonLocation W0() {
        return this.d.W0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public int Y0() {
        return this.d.Y0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public long Z0() {
        return this.d.Z0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public String a1() {
        return this.h == JsonToken.FIELD_NAME ? C() : this.d.a1();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public boolean b1() {
        return this.h != null;
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public boolean c1() {
        if (this.h == JsonToken.FIELD_NAME) {
            return false;
        }
        return this.d.c1();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public final boolean d1(JsonToken jsonToken) {
        return this.h == jsonToken;
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public BigInteger e0() {
        return this.d.e0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public boolean e1(int i) {
        JsonToken jsonToken = this.h;
        if (jsonToken == null) {
            return i == 0;
        }
        return jsonToken.id() == i;
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public boolean i1() {
        return this.h == JsonToken.START_ARRAY;
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public byte[] j0(Base64Variant base64Variant) {
        return this.d.j0(base64Variant);
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public boolean j1() {
        return this.h == JsonToken.START_OBJECT;
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public boolean k0() {
        return this.d.k0();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public byte m0() {
        return this.d.m0();
    }

    /* JADX WARN: Code duplicated, block: B:122:0x019d  */
    /* JADX WARN: Code duplicated, block: B:129:0x01c2  */
    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken n1() throws JsonParseException {
        TokenFilter tokenFilterO;
        JsonToken jsonTokenZ1;
        boolean zV;
        TokenFilter tokenFilterT;
        TokenFilter tokenFilterO2;
        JsonToken jsonTokenZ2;
        TokenFilter tokenFilterI;
        JsonToken jsonTokenZ3;
        TokenFilter tokenFilterO3;
        JsonToken jsonToken;
        if (!this.f && (jsonToken = this.h) != null && this.k == null && jsonToken.isScalarValue() && !this.j.v() && this.g == TokenFilter.Inclusion.ONLY_INCLUDE_ALL && this.l == TokenFilter.a) {
            this.h = null;
            return null;
        }
        b bVarS = this.k;
        if (bVarS != null) {
            while (true) {
                JsonToken jsonTokenW = bVarS.w();
                if (jsonTokenW != null) {
                    this.h = jsonTokenW;
                    return jsonTokenW;
                }
                b bVar = this.j;
                if (bVarS == bVar) {
                    this.k = null;
                    if (!bVarS.i()) {
                        JsonToken jsonTokenD = this.d.D();
                        if (jsonTokenD == JsonToken.END_OBJECT) {
                            b bVarE = this.j.e();
                            this.j = bVarE;
                            this.l = bVarE.t();
                        }
                        if (jsonTokenD == JsonToken.FIELD_NAME) {
                            break;
                        }
                        this.h = jsonTokenD;
                        return jsonTokenD;
                    }
                    JsonToken jsonTokenA0 = this.d.A0();
                    this.h = jsonTokenA0;
                    if (jsonTokenA0 == JsonToken.END_ARRAY) {
                        b bVarE2 = this.j.e();
                        this.j = bVarE2;
                        this.l = bVarE2.t();
                    }
                    return jsonTokenA0;
                }
                bVarS = bVar.s(bVarS);
                this.k = bVarS;
                if (bVarS == null) {
                    throw n("Unexpected problem: chain of filtered context broken");
                }
            }
        }
        JsonToken jsonTokenN1 = this.d.n1();
        if (jsonTokenN1 == null) {
            this.h = jsonTokenN1;
            return jsonTokenN1;
        }
        int iId = jsonTokenN1.id();
        if (iId == 1) {
            TokenFilter tokenFilter = this.l;
            TokenFilter tokenFilter2 = TokenFilter.a;
            if (tokenFilter == tokenFilter2) {
                this.j = this.j.q(tokenFilter, true);
                this.h = jsonTokenN1;
                return jsonTokenN1;
            }
            if (tokenFilter == null || (tokenFilterO = this.j.o(tokenFilter)) == null) {
                this.d.v1();
            } else {
                if (tokenFilterO != tokenFilter2) {
                    tokenFilterO = tokenFilterO.e();
                }
                this.l = tokenFilterO;
                if (tokenFilterO == tokenFilter2) {
                    this.j = this.j.q(tokenFilterO, true);
                    this.h = jsonTokenN1;
                    return jsonTokenN1;
                }
                if (tokenFilterO != null && this.g == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                    this.j = this.j.q(tokenFilterO, true);
                    this.h = jsonTokenN1;
                    return jsonTokenN1;
                }
                b bVarQ = this.j.q(tokenFilterO, false);
                this.j = bVarQ;
                if (this.g == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH && (jsonTokenZ1 = z1(bVarQ)) != null) {
                    this.h = jsonTokenZ1;
                    return jsonTokenZ1;
                }
            }
        } else if (iId == 2) {
            zV = this.j.v();
            tokenFilterT = this.j.t();
            if (tokenFilterT != null && tokenFilterT != TokenFilter.a) {
                tokenFilterT.b();
            }
            b bVarE3 = this.j.e();
            this.j = bVarE3;
            this.l = bVarE3.t();
            if (zV) {
                this.h = jsonTokenN1;
                return jsonTokenN1;
            }
        } else if (iId == 3) {
            TokenFilter tokenFilter3 = this.l;
            TokenFilter tokenFilter4 = TokenFilter.a;
            if (tokenFilter3 == tokenFilter4) {
                this.j = this.j.p(tokenFilter3, true);
                this.h = jsonTokenN1;
                return jsonTokenN1;
            }
            if (tokenFilter3 == null || (tokenFilterO2 = this.j.o(tokenFilter3)) == null) {
                this.d.v1();
            } else {
                if (tokenFilterO2 != tokenFilter4) {
                    tokenFilterO2 = tokenFilterO2.d();
                }
                this.l = tokenFilterO2;
                if (tokenFilterO2 == tokenFilter4) {
                    this.j = this.j.p(tokenFilterO2, true);
                    this.h = jsonTokenN1;
                    return jsonTokenN1;
                }
                if (tokenFilterO2 != null && this.g == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                    this.j = this.j.p(tokenFilterO2, true);
                    this.h = jsonTokenN1;
                    return jsonTokenN1;
                }
                b bVarP = this.j.p(tokenFilterO2, false);
                this.j = bVarP;
                if (this.g == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH && (jsonTokenZ2 = z1(bVarP)) != null) {
                    this.h = jsonTokenZ2;
                    return jsonTokenZ2;
                }
            }
        } else if (iId == 4) {
            zV = this.j.v();
            tokenFilterT = this.j.t();
            if (tokenFilterT != null) {
                tokenFilterT.b();
            }
            b bVarE4 = this.j.e();
            this.j = bVarE4;
            this.l = bVarE4.t();
            if (zV) {
                this.h = jsonTokenN1;
                return jsonTokenN1;
            }
        } else if (iId != 5) {
            TokenFilter tokenFilter5 = this.l;
            TokenFilter tokenFilter6 = TokenFilter.a;
            if (tokenFilter5 == tokenFilter6) {
                this.h = jsonTokenN1;
                return jsonTokenN1;
            }
            if (tokenFilter5 != null && (((tokenFilterO3 = this.j.o(tokenFilter5)) == tokenFilter6 || (tokenFilterO3 != null && tokenFilterO3.k(this.d))) && A1())) {
                this.h = jsonTokenN1;
                return jsonTokenN1;
            }
        } else {
            String strY0 = this.d.y0();
            TokenFilter tokenFilterY = this.j.y(strY0);
            TokenFilter tokenFilter7 = TokenFilter.a;
            if (tokenFilterY == tokenFilter7) {
                this.l = tokenFilterY;
                this.h = jsonTokenN1;
                return jsonTokenN1;
            }
            if (tokenFilterY == null || (tokenFilterI = tokenFilterY.i(strY0)) == null) {
                this.d.n1();
                this.d.v1();
            } else {
                this.l = tokenFilterI;
                if (tokenFilterI == tokenFilter7) {
                    if (!A1()) {
                        this.d.n1();
                        this.d.v1();
                    } else if (this.g == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH) {
                        this.h = jsonTokenN1;
                        return jsonTokenN1;
                    }
                }
                if (this.g != TokenFilter.Inclusion.ONLY_INCLUDE_ALL && (jsonTokenZ3 = z1(this.j)) != null) {
                    this.h = jsonTokenZ3;
                    return jsonTokenZ3;
                }
            }
        }
        return y1();
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public int q1(Base64Variant base64Variant, OutputStream outputStream) {
        return this.d.q1(base64Variant, outputStream);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser v1() throws JsonParseException {
        JsonToken jsonToken = this.h;
        if (jsonToken != JsonToken.START_OBJECT && jsonToken != JsonToken.START_ARRAY) {
            return this;
        }
        int i = 1;
        while (true) {
            JsonToken jsonTokenN1 = n1();
            if (jsonTokenN1 == null) {
                return this;
            }
            if (jsonTokenN1.isStructStart()) {
                i++;
            } else if (jsonTokenN1.isStructEnd() && (i = i - 1) == 0) {
                return this;
            }
        }
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public JsonLocation w0() {
        return this.d.w0();
    }

    protected h71 w1() {
        b bVar = this.k;
        return bVar != null ? bVar : this.j;
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public void y() {
        JsonToken jsonToken = this.h;
        if (jsonToken != null) {
            this.i = jsonToken;
            this.h = null;
        }
    }

    @Override // defpackage.s61, com.fasterxml.jackson.core.JsonParser
    public String y0() {
        h71 h71VarW1 = w1();
        JsonToken jsonToken = this.h;
        if (jsonToken != JsonToken.START_OBJECT && jsonToken != JsonToken.START_ARRAY) {
            return h71VarW1.b();
        }
        h71 h71VarE = h71VarW1.e();
        if (h71VarE == null) {
            return null;
        }
        return h71VarE.b();
    }

    protected final JsonToken y1() {
        TokenFilter tokenFilterO;
        JsonToken jsonTokenZ1;
        JsonToken jsonTokenZ2;
        JsonToken jsonTokenZ3;
        while (true) {
            JsonToken jsonTokenN1 = this.d.n1();
            if (jsonTokenN1 == null) {
                this.h = jsonTokenN1;
                return jsonTokenN1;
            }
            int iId = jsonTokenN1.id();
            if (iId == 1) {
                TokenFilter tokenFilter = this.l;
                TokenFilter tokenFilter2 = TokenFilter.a;
                if (tokenFilter == tokenFilter2) {
                    this.j = this.j.q(tokenFilter, true);
                    this.h = jsonTokenN1;
                    return jsonTokenN1;
                }
                if (tokenFilter == null) {
                    this.d.v1();
                } else {
                    TokenFilter tokenFilterO2 = this.j.o(tokenFilter);
                    if (tokenFilterO2 == null) {
                        this.d.v1();
                    } else {
                        if (tokenFilterO2 != tokenFilter2) {
                            tokenFilterO2 = tokenFilterO2.e();
                        }
                        this.l = tokenFilterO2;
                        if (tokenFilterO2 == tokenFilter2) {
                            this.j = this.j.q(tokenFilterO2, true);
                            this.h = jsonTokenN1;
                            return jsonTokenN1;
                        }
                        if (tokenFilterO2 != null && this.g == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                            this.j = this.j.q(tokenFilterO2, true);
                            this.h = jsonTokenN1;
                            return jsonTokenN1;
                        }
                        b bVarQ = this.j.q(tokenFilterO2, false);
                        this.j = bVarQ;
                        if (this.g == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH && (jsonTokenZ3 = z1(bVarQ)) != null) {
                            this.h = jsonTokenZ3;
                            return jsonTokenZ3;
                        }
                    }
                }
            } else if (iId == 2) {
                boolean zV = this.j.v();
                TokenFilter tokenFilterT = this.j.t();
                if (tokenFilterT != null && tokenFilterT != TokenFilter.a) {
                    boolean zG = tokenFilterT.g(this.j.g());
                    tokenFilterT.c();
                    if (zG) {
                        return x1(this.j);
                    }
                }
                b bVarE = this.j.e();
                this.j = bVarE;
                this.l = bVarE.t();
                if (zV) {
                    this.h = jsonTokenN1;
                    return jsonTokenN1;
                }
            } else if (iId == 3) {
                TokenFilter tokenFilter3 = this.l;
                TokenFilter tokenFilter4 = TokenFilter.a;
                if (tokenFilter3 == tokenFilter4) {
                    this.j = this.j.p(tokenFilter3, true);
                    this.h = jsonTokenN1;
                    return jsonTokenN1;
                }
                if (tokenFilter3 == null) {
                    this.d.v1();
                } else {
                    TokenFilter tokenFilterO3 = this.j.o(tokenFilter3);
                    if (tokenFilterO3 == null) {
                        this.d.v1();
                    } else {
                        if (tokenFilterO3 != tokenFilter4) {
                            tokenFilterO3 = tokenFilterO3.d();
                        }
                        this.l = tokenFilterO3;
                        if (tokenFilterO3 == tokenFilter4) {
                            this.j = this.j.p(tokenFilterO3, true);
                            this.h = jsonTokenN1;
                            return jsonTokenN1;
                        }
                        if (tokenFilterO3 != null && this.g == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                            this.j = this.j.p(tokenFilterO3, true);
                            this.h = jsonTokenN1;
                            return jsonTokenN1;
                        }
                        b bVarP = this.j.p(tokenFilterO3, false);
                        this.j = bVarP;
                        if (this.g == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH && (jsonTokenZ2 = z1(bVarP)) != null) {
                            this.h = jsonTokenZ2;
                            return jsonTokenZ2;
                        }
                    }
                }
            } else if (iId == 4) {
                boolean zV2 = this.j.v();
                TokenFilter tokenFilterT2 = this.j.t();
                if (tokenFilterT2 != null && tokenFilterT2 != TokenFilter.a) {
                    boolean zG2 = tokenFilterT2.g(this.j.f());
                    tokenFilterT2.b();
                    if (zG2) {
                        return x1(this.j);
                    }
                }
                b bVarE2 = this.j.e();
                this.j = bVarE2;
                this.l = bVarE2.t();
                if (zV2) {
                    this.h = jsonTokenN1;
                    return jsonTokenN1;
                }
            } else if (iId != 5) {
                TokenFilter tokenFilter5 = this.l;
                TokenFilter tokenFilter6 = TokenFilter.a;
                if (tokenFilter5 == tokenFilter6) {
                    this.h = jsonTokenN1;
                    return jsonTokenN1;
                }
                if (tokenFilter5 != null && ((tokenFilterO = this.j.o(tokenFilter5)) == tokenFilter6 || (tokenFilterO != null && tokenFilterO.k(this.d)))) {
                    if (A1()) {
                        this.h = jsonTokenN1;
                        return jsonTokenN1;
                    }
                }
            } else {
                String strY0 = this.d.y0();
                TokenFilter tokenFilterY = this.j.y(strY0);
                TokenFilter tokenFilter7 = TokenFilter.a;
                if (tokenFilterY == tokenFilter7) {
                    this.l = tokenFilterY;
                    this.h = jsonTokenN1;
                    return jsonTokenN1;
                }
                if (tokenFilterY == null) {
                    this.d.n1();
                    this.d.v1();
                } else {
                    TokenFilter tokenFilterI = tokenFilterY.i(strY0);
                    if (tokenFilterI == null) {
                        this.d.n1();
                        this.d.v1();
                    } else {
                        this.l = tokenFilterI;
                        if (tokenFilterI == tokenFilter7) {
                            if (!A1()) {
                                this.d.n1();
                                this.d.v1();
                            } else if (this.g == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH) {
                                this.h = jsonTokenN1;
                                return jsonTokenN1;
                            }
                        } else if (this.g != TokenFilter.Inclusion.ONLY_INCLUDE_ALL && (jsonTokenZ1 = z1(this.j)) != null) {
                            this.h = jsonTokenZ1;
                            return jsonTokenZ1;
                        }
                    }
                }
            }
        }
    }

    protected final JsonToken z1(b bVar) {
        TokenFilter tokenFilterO;
        while (true) {
            JsonToken jsonTokenN1 = this.d.n1();
            if (jsonTokenN1 == null) {
                return jsonTokenN1;
            }
            int iId = jsonTokenN1.id();
            boolean z = false;
            if (iId != 1) {
                if (iId == 2) {
                    TokenFilter tokenFilterT = this.j.t();
                    if (tokenFilterT != null && tokenFilterT != TokenFilter.a) {
                        boolean zH = tokenFilterT.h(this.j.g());
                        tokenFilterT.c();
                        if (zH) {
                            b bVar2 = this.j;
                            b bVar3 = bVar2.c;
                            bVar2.e = bVar3 != null ? bVar3.e : null;
                            bVar2.h = false;
                            return x1(bVar);
                        }
                    }
                    b bVar4 = this.j;
                    boolean z2 = bVar4 == bVar;
                    if (z2 && bVar4.v()) {
                        z = true;
                    }
                    b bVarE = this.j.e();
                    this.j = bVarE;
                    this.l = bVarE.t();
                    if (z) {
                        return jsonTokenN1;
                    }
                    if (z2) {
                        return null;
                    }
                } else if (iId == 3) {
                    TokenFilter tokenFilterO2 = this.j.o(this.l);
                    if (tokenFilterO2 == null) {
                        this.d.v1();
                    } else {
                        TokenFilter tokenFilter = TokenFilter.a;
                        if (tokenFilterO2 != tokenFilter) {
                            tokenFilterO2 = tokenFilterO2.d();
                        }
                        this.l = tokenFilterO2;
                        if (tokenFilterO2 == tokenFilter) {
                            this.j = this.j.p(tokenFilterO2, true);
                            return x1(bVar);
                        }
                        if (tokenFilterO2 != null && this.g == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                            this.j = this.j.p(tokenFilterO2, true);
                            return x1(bVar);
                        }
                        this.j = this.j.p(tokenFilterO2, false);
                    }
                } else if (iId == 4) {
                    TokenFilter tokenFilterT2 = this.j.t();
                    if (tokenFilterT2 != null && tokenFilterT2 != TokenFilter.a) {
                        boolean zG = tokenFilterT2.g(this.j.f());
                        tokenFilterT2.b();
                        if (zG) {
                            return x1(bVar);
                        }
                    }
                    b bVar5 = this.j;
                    boolean z3 = bVar5 == bVar;
                    if (z3 && bVar5.v()) {
                        z = true;
                    }
                    b bVarE2 = this.j.e();
                    this.j = bVarE2;
                    this.l = bVarE2.t();
                    if (z) {
                        return jsonTokenN1;
                    }
                    if (z3) {
                        return null;
                    }
                } else if (iId != 5) {
                    TokenFilter tokenFilter2 = this.l;
                    TokenFilter tokenFilter3 = TokenFilter.a;
                    if (tokenFilter2 == tokenFilter3) {
                        return x1(bVar);
                    }
                    if (tokenFilter2 != null && ((tokenFilterO = this.j.o(tokenFilter2)) == tokenFilter3 || (tokenFilterO != null && tokenFilterO.k(this.d)))) {
                        if (A1()) {
                            return x1(bVar);
                        }
                    }
                } else {
                    String strY0 = this.d.y0();
                    TokenFilter tokenFilterY = this.j.y(strY0);
                    TokenFilter tokenFilter4 = TokenFilter.a;
                    if (tokenFilterY == tokenFilter4) {
                        this.l = tokenFilterY;
                        return x1(bVar);
                    }
                    if (tokenFilterY == null) {
                        this.d.n1();
                        this.d.v1();
                    } else {
                        TokenFilter tokenFilterI = tokenFilterY.i(strY0);
                        if (tokenFilterI == null) {
                            this.d.n1();
                            this.d.v1();
                        } else {
                            this.l = tokenFilterI;
                            if (tokenFilterI != tokenFilter4) {
                                continue;
                            } else {
                                if (A1()) {
                                    return x1(bVar);
                                }
                                this.l = this.j.y(strY0);
                            }
                        }
                    }
                }
            } else {
                TokenFilter tokenFilter5 = this.l;
                TokenFilter tokenFilter6 = TokenFilter.a;
                if (tokenFilter5 == tokenFilter6) {
                    this.j = this.j.q(tokenFilter5, true);
                    return jsonTokenN1;
                }
                if (tokenFilter5 == null) {
                    this.d.v1();
                } else {
                    TokenFilter tokenFilterO3 = this.j.o(tokenFilter5);
                    if (tokenFilterO3 == null) {
                        this.d.v1();
                    } else {
                        if (tokenFilterO3 != tokenFilter6) {
                            tokenFilterO3 = tokenFilterO3.e();
                        }
                        this.l = tokenFilterO3;
                        if (tokenFilterO3 == tokenFilter6) {
                            this.j = this.j.q(tokenFilterO3, true);
                            return x1(bVar);
                        }
                        if (tokenFilterO3 != null && this.g == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                            this.j = this.j.p(tokenFilterO3, true);
                            return x1(bVar);
                        }
                        this.j = this.j.q(tokenFilterO3, false);
                    }
                }
            }
        }
    }
}
