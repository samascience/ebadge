package defpackage;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

/* JADX INFO: loaded from: classes.dex */
public class dd2 extends dz1 {
    private static final int i0 = JsonParser.Feature.ALLOW_TRAILING_COMMA.getMask();
    private static final int j0 = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS.getMask();
    private static final int k0 = JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS.getMask();
    private static final int l0 = JsonParser.Feature.ALLOW_MISSING_VALUES.getMask();
    private static final int m0 = JsonParser.Feature.ALLOW_SINGLE_QUOTES.getMask();
    private static final int n0 = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask();
    private static final int o0 = JsonParser.Feature.ALLOW_COMMENTS.getMask();
    private static final int p0 = JsonParser.Feature.ALLOW_YAML_COMMENTS.getMask();
    protected static final int[] q0 = ex.h();
    protected Reader Y;
    protected char[] Z;
    protected boolean a0;
    protected jt1 b0;
    protected final fx c0;
    protected final int d0;
    protected boolean e0;
    protected long f0;
    protected int g0;
    protected int h0;

    public dd2(oy0 oy0Var, int i, Reader reader, jt1 jt1Var, fx fxVar, char[] cArr, int i2, int i3, boolean z) {
        super(oy0Var, i);
        this.Y = reader;
        this.b0 = jt1Var;
        this.Z = cArr;
        this.r = i2;
        this.s = i3;
        this.v = i2;
        this.t = -i2;
        this.c0 = fxVar;
        this.d0 = fxVar.m();
        this.a0 = z;
    }

    private boolean A3() {
        if ((this.a & p0) == 0) {
            return false;
        }
        w3();
        return true;
    }

    private final void B3() {
        int i = this.r;
        this.w = this.t + ((long) i);
        this.x = this.u;
        this.y = i - this.v;
    }

    private final void C3() {
        int i = this.r;
        this.f0 = i;
        this.g0 = this.u;
        this.h0 = i - this.v;
    }

    private char D3() {
        char c;
        if ((this.r >= this.s && !V2()) || (c = this.Z[this.r]) < '0' || c > '9') {
            return '0';
        }
        if ((this.a & j0) == 0) {
            T1("Leading zeroes not allowed");
        }
        this.r++;
        if (c == '0') {
            do {
                if (this.r >= this.s && !V2()) {
                    break;
                }
                char[] cArr = this.Z;
                int i = this.r;
                c = cArr[i];
                if (c < '0' || c > '9') {
                    return '0';
                }
                this.r = i + 1;
            } while (c == '0');
        }
        return c;
    }

    private final char E3() {
        char c;
        int i = this.r;
        if (i >= this.s || ((c = this.Z[i]) >= '0' && c <= '9')) {
            return D3();
        }
        return '0';
    }

    private final void F3(int i) {
        int i2 = this.r;
        int i3 = i2 + 1;
        this.r = i3;
        if (i != 9) {
            if (i == 10) {
                this.u++;
                this.v = i3;
            } else if (i == 13) {
                this.r = i2;
            } else if (i != 32) {
                K1(i);
            }
        }
    }

    private final void J2(String str, int i, int i2) {
        if (Character.isJavaIdentifierPart((char) i2)) {
            n3(str.substring(0, i));
        }
    }

    private void K2(int i) {
        if (i == 93) {
            B3();
            if (!this.z.i()) {
                r2(i, '}');
            }
            this.z = this.z.o();
            this.d = JsonToken.END_ARRAY;
        }
        if (i == 125) {
            B3();
            if (!this.z.j()) {
                r2(i, ']');
            }
            this.z = this.z.o();
            this.d = JsonToken.END_OBJECT;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0061 A[SYNTHETIC] */
    private String T2(int i, int i2, int[] iArr) {
        int i3;
        this.G.A(this.Z, i, this.r - i);
        char[] cArrS = this.G.s();
        int iT = this.G.t();
        int length = iArr.length;
        while (true) {
            if (this.r >= this.s && !V2()) {
                break;
            }
            char c = this.Z[this.r];
            if (c < length) {
                if (iArr[c] != 0) {
                    break;
                }
                this.r++;
                i2 = (i2 * 33) + c;
                i3 = iT + 1;
                cArrS[iT] = c;
                if (i3 >= cArrS.length) {
                    cArrS = this.G.p();
                    iT = 0;
                } else {
                    iT = i3;
                }
            } else {
                if (!Character.isJavaIdentifierPart(c)) {
                    break;
                }
                this.r++;
                i2 = (i2 * 33) + c;
                i3 = iT + 1;
                cArrS[iT] = c;
                if (i3 >= cArrS.length) {
                    cArrS = this.G.p();
                    iT = 0;
                } else {
                    iT = i3;
                }
            }
        }
        this.G.E(iT);
        w13 w13Var = this.G;
        return this.c0.l(w13Var.u(), w13Var.v(), w13Var.F(), i2);
    }

    private final void X2() {
        int i;
        char c;
        int i2 = this.r;
        if (i2 + 4 < this.s) {
            char[] cArr = this.Z;
            if (cArr[i2] == 'a' && cArr[i2 + 1] == 'l' && cArr[i2 + 2] == 's' && cArr[i2 + 3] == 'e' && ((c = cArr[(i = i2 + 4)]) < '0' || c == ']' || c == '}')) {
                this.r = i;
                return;
            }
        }
        Z2("false", 1);
    }

    private final void Y2() {
        int i;
        char c;
        int i2 = this.r;
        if (i2 + 3 < this.s) {
            char[] cArr = this.Z;
            if (cArr[i2] == 'u' && cArr[i2 + 1] == 'l' && cArr[i2 + 2] == 'l' && ((c = cArr[(i = i2 + 3)]) < '0' || c == ']' || c == '}')) {
                this.r = i;
                return;
            }
        }
        Z2("null", 1);
    }

    private final void a3(String str, int i) {
        int i2;
        char c;
        int length = str.length();
        do {
            if ((this.r >= this.s && !V2()) || this.Z[this.r] != str.charAt(i)) {
                n3(str.substring(0, i));
            }
            i2 = this.r + 1;
            this.r = i2;
            i++;
        } while (i < length);
        if ((i2 < this.s || V2()) && (c = this.Z[this.r]) >= '0' && c != ']' && c != '}') {
            J2(str, i, c);
        }
    }

    private final void b3() {
        int i;
        char c;
        int i2 = this.r;
        if (i2 + 3 < this.s) {
            char[] cArr = this.Z;
            if (cArr[i2] == 'r' && cArr[i2 + 1] == 'u' && cArr[i2 + 2] == 'e' && ((c = cArr[(i = i2 + 3)]) < '0' || c == ']' || c == '}')) {
                this.r = i;
                return;
            }
        }
        Z2("true", 1);
    }

    private final JsonToken c3() {
        this.I = false;
        JsonToken jsonToken = this.F;
        this.F = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            this.z = this.z.p(this.x, this.y);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this.z = this.z.q(this.x, this.y);
        }
        this.d = jsonToken;
        return jsonToken;
    }

    private final JsonToken d3(int i) {
        if (i == 34) {
            this.e0 = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this.d = jsonToken;
            return jsonToken;
        }
        if (i == 91) {
            this.z = this.z.p(this.x, this.y);
            JsonToken jsonToken2 = JsonToken.START_ARRAY;
            this.d = jsonToken2;
            return jsonToken2;
        }
        if (i == 102) {
            Z2("false", 1);
            JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
            this.d = jsonToken3;
            return jsonToken3;
        }
        if (i == 110) {
            Z2("null", 1);
            JsonToken jsonToken4 = JsonToken.VALUE_NULL;
            this.d = jsonToken4;
            return jsonToken4;
        }
        if (i == 116) {
            Z2("true", 1);
            JsonToken jsonToken5 = JsonToken.VALUE_TRUE;
            this.d = jsonToken5;
            return jsonToken5;
        }
        if (i == 123) {
            this.z = this.z.q(this.x, this.y);
            JsonToken jsonToken6 = JsonToken.START_OBJECT;
            this.d = jsonToken6;
            return jsonToken6;
        }
        switch (i) {
            case 44:
                if (!this.z.k() && (this.a & l0) != 0) {
                    this.r--;
                    JsonToken jsonToken7 = JsonToken.VALUE_NULL;
                    this.d = jsonToken7;
                    return jsonToken7;
                }
                break;
            case 45:
                JsonToken jsonTokenK3 = k3(true);
                this.d = jsonTokenK3;
                return jsonTokenK3;
            case 46:
                JsonToken jsonTokenG3 = g3(false);
                this.d = jsonTokenG3;
                return jsonTokenG3;
            default:
                switch (i) {
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        JsonToken jsonTokenL3 = l3(i);
                        this.d = jsonTokenL3;
                        return jsonTokenL3;
                }
        }
        JsonToken jsonTokenU2 = U2(i);
        this.d = jsonTokenU2;
        return jsonTokenU2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v18 ??, r10v12 ??, r10v6 ??, r10v5 ??, r10v3 ??, r10v10 ??, r10v9 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    private final com.fasterxml.jackson.core.JsonToken f3(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v18 ??, r10v12 ??, r10v6 ??, r10v5 ??, r10v3 ??, r10v10 ??, r10v9 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    private String i3(int i, int i2, int i3) {
        this.G.A(this.Z, i, this.r - i);
        char[] cArrS = this.G.s();
        int iT = this.G.t();
        while (true) {
            if (this.r >= this.s && !V2()) {
                I1(" in field name", JsonToken.FIELD_NAME);
            }
            char[] cArr = this.Z;
            int i4 = this.r;
            this.r = i4 + 1;
            char cF2 = cArr[i4];
            if (cF2 <= '\\') {
                if (cF2 == '\\') {
                    cF2 = f2();
                } else if (cF2 <= i3) {
                    if (cF2 == i3) {
                        this.G.E(iT);
                        w13 w13Var = this.G;
                        return this.c0.l(w13Var.u(), w13Var.v(), w13Var.F(), i2);
                    }
                    if (cF2 < ' ') {
                        t2(cF2, "name");
                    }
                }
            }
            i2 = (i2 * 33) + cF2;
            int i5 = iT + 1;
            cArrS[iT] = cF2;
            if (i5 >= cArrS.length) {
                cArrS = this.G.p();
                iT = 0;
            } else {
                iT = i5;
            }
        }
    }

    private final JsonToken j3(boolean z, int i) {
        int i2;
        char cG3;
        boolean z2;
        int i3;
        char cG4;
        if (z) {
            i++;
        }
        this.r = i;
        char[] cArrM = this.G.m();
        if (z) {
            cArrM[0] = '-';
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i4 = this.r;
        if (i4 < this.s) {
            char[] cArr = this.Z;
            this.r = i4 + 1;
            cG3 = cArr[i4];
        } else {
            cG3 = G3("No digit following minus sign", JsonToken.VALUE_NUMBER_INT);
        }
        if (cG3 == '0') {
            cG3 = E3();
        }
        int i5 = 0;
        while (true) {
            if (cG3 >= '0' && cG3 <= '9') {
                i5++;
                if (i2 >= cArrM.length) {
                    cArrM = this.G.p();
                    i2 = 0;
                }
                int i6 = i2 + 1;
                cArrM[i2] = cG3;
                if (this.r >= this.s && !V2()) {
                    cG3 = 0;
                    i2 = i6;
                    z2 = true;
                    break;
                }
                char[] cArr2 = this.Z;
                int i7 = this.r;
                this.r = i7 + 1;
                cG3 = cArr2[i7];
                i2 = i6;
            } else {
                z2 = false;
                break;
            }
        }
        if (i5 == 0 && !f1(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
            return Q2(cG3, z);
        }
        int i8 = -1;
        if (cG3 == '.') {
            if (i2 >= cArrM.length) {
                cArrM = this.G.p();
                i2 = 0;
            }
            cArrM[i2] = cG3;
            i2++;
            i3 = 0;
            while (true) {
                if (this.r >= this.s && !V2()) {
                    z2 = true;
                    break;
                }
                char[] cArr3 = this.Z;
                int i9 = this.r;
                this.r = i9 + 1;
                cG3 = cArr3[i9];
                if (cG3 < '0' || cG3 > '9') {
                    break;
                }
                i3++;
                if (i2 >= cArrM.length) {
                    cArrM = this.G.p();
                    i2 = 0;
                }
                cArrM[i2] = cG3;
                i2++;
            }
            if (i3 == 0 && !f1(JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
                M1(cG3, "Decimal point not followed by a digit");
            }
        } else {
            i3 = -1;
        }
        if (cG3 == 'e' || cG3 == 'E') {
            if (i2 >= cArrM.length) {
                cArrM = this.G.p();
                i2 = 0;
            }
            int i10 = i2 + 1;
            cArrM[i2] = cG3;
            int i11 = this.r;
            if (i11 < this.s) {
                char[] cArr4 = this.Z;
                this.r = i11 + 1;
                cG4 = cArr4[i11];
            } else {
                cG4 = G3("expected a digit for number exponent", JsonToken.VALUE_NUMBER_FLOAT);
            }
            if (cG4 == '-' || cG4 == '+') {
                if (i10 >= cArrM.length) {
                    cArrM = this.G.p();
                    i10 = 0;
                }
                int i12 = i10 + 1;
                cArrM[i10] = cG4;
                int i13 = this.r;
                if (i13 < this.s) {
                    char[] cArr5 = this.Z;
                    this.r = i13 + 1;
                    cG4 = cArr5[i13];
                } else {
                    cG4 = G3("expected a digit for number exponent", JsonToken.VALUE_NUMBER_FLOAT);
                }
                i10 = i12;
            }
            int i14 = 0;
            cG3 = cG4;
            while (true) {
                if (cG3 <= '9' && cG3 >= '0') {
                    i14++;
                    if (i10 >= cArrM.length) {
                        cArrM = this.G.p();
                        i10 = 0;
                    }
                    i2 = i10 + 1;
                    cArrM[i10] = cG3;
                    if (this.r >= this.s && !V2()) {
                        i8 = i14;
                        z2 = true;
                        break;
                    }
                    char[] cArr6 = this.Z;
                    int i15 = this.r;
                    this.r = i15 + 1;
                    cG3 = cArr6[i15];
                    i10 = i2;
                } else {
                    i2 = i10;
                    i8 = i14;
                    break;
                }
            }
            if (i8 == 0) {
                M1(cG3, "Exponent indicator not followed by a digit");
            }
        }
        if (!z2) {
            this.r--;
            if (this.z.k()) {
                F3(cG3);
            }
        }
        this.G.E(i2);
        return (i3 >= 0 || i8 >= 0) ? H2(z, i5, i3, i8) : I2(z, i5);
    }

    private final JsonToken k3(boolean z) {
        int i = this.r;
        int i2 = z ? i - 1 : i;
        int i3 = this.s;
        if (i >= i3) {
            return j3(z, i2);
        }
        int i4 = i + 1;
        char c = this.Z[i];
        if (c > '9' || c < '0') {
            this.r = i4;
            return c == '.' ? g3(z) : R2(c, z, true);
        }
        if (c == '0') {
            return j3(z, i2);
        }
        int i5 = 1;
        while (i4 < i3) {
            int i6 = i4 + 1;
            char c2 = this.Z[i4];
            if (c2 < '0' || c2 > '9') {
                if (c2 == '.' || c2 == 'e' || c2 == 'E') {
                    this.r = i6;
                    return f3(c2, i2, i6, z, i5);
                }
                this.r = i4;
                if (this.z.k()) {
                    F3(c2);
                }
                this.G.A(this.Z, i2, i4 - i2);
                return I2(z, i5);
            }
            i5++;
            i4 = i6;
        }
        return j3(z, i2);
    }

    private final int p3() throws JsonParseException {
        while (true) {
            if (this.r >= this.s && !V2()) {
                throw n("Unexpected end-of-input within/between " + this.z.m() + " entries");
            }
            char[] cArr = this.Z;
            int i = this.r;
            int i2 = i + 1;
            this.r = i2;
            char c = cArr[i];
            if (c > ' ') {
                if (c == '/') {
                    v3();
                } else if (c != '#' || !A3()) {
                    return c;
                }
            } else if (c < ' ') {
                if (c == '\n') {
                    this.u++;
                    this.v = i2;
                } else if (c == '\r') {
                    r3();
                } else if (c != '\t') {
                    O1(c);
                }
            }
        }
    }

    private void q3() {
        while (true) {
            if (this.r >= this.s && !V2()) {
                break;
            }
            char[] cArr = this.Z;
            int i = this.r;
            int i2 = i + 1;
            this.r = i2;
            char c = cArr[i];
            if (c <= '*') {
                if (c == '*') {
                    if (i2 >= this.s && !V2()) {
                        break;
                    }
                    char[] cArr2 = this.Z;
                    int i3 = this.r;
                    if (cArr2[i3] == '/') {
                        this.r = i3 + 1;
                        return;
                    }
                } else if (c < ' ') {
                    if (c == '\n') {
                        this.u++;
                        this.v = i2;
                    } else if (c == '\r') {
                        r3();
                    } else if (c != '\t') {
                        O1(c);
                    }
                }
            }
        }
        I1(" in a comment", null);
    }

    private final int s3() {
        int i = this.r;
        if (i + 4 >= this.s) {
            return t3(false);
        }
        char[] cArr = this.Z;
        char c = cArr[i];
        if (c == ':') {
            int i2 = i + 1;
            this.r = i2;
            char c2 = cArr[i2];
            if (c2 > ' ') {
                if (c2 == '/' || c2 == '#') {
                    return t3(true);
                }
                this.r = i + 2;
                return c2;
            }
            if (c2 == ' ' || c2 == '\t') {
                int i3 = i + 2;
                this.r = i3;
                char c3 = cArr[i3];
                if (c3 > ' ') {
                    if (c3 == '/' || c3 == '#') {
                        return t3(true);
                    }
                    this.r = i + 3;
                    return c3;
                }
            }
            return t3(true);
        }
        if (c == ' ' || c == '\t') {
            int i4 = i + 1;
            this.r = i4;
            c = cArr[i4];
        }
        if (c != ':') {
            return t3(false);
        }
        int i5 = this.r;
        int i6 = i5 + 1;
        this.r = i6;
        char c4 = cArr[i6];
        if (c4 > ' ') {
            if (c4 == '/' || c4 == '#') {
                return t3(true);
            }
            this.r = i5 + 2;
            return c4;
        }
        if (c4 == ' ' || c4 == '\t') {
            int i7 = i5 + 2;
            this.r = i7;
            char c5 = cArr[i7];
            if (c5 > ' ') {
                if (c5 == '/' || c5 == '#') {
                    return t3(true);
                }
                this.r = i5 + 3;
                return c5;
            }
        }
        return t3(true);
    }

    private final int t3(boolean z) {
        while (true) {
            if (this.r >= this.s && !V2()) {
                I1(" within/between " + this.z.m() + " entries", null);
                return -1;
            }
            char[] cArr = this.Z;
            int i = this.r;
            int i2 = i + 1;
            this.r = i2;
            char c = cArr[i];
            if (c > ' ') {
                if (c == '/') {
                    v3();
                } else if (c != '#' || !A3()) {
                    if (z) {
                        return c;
                    }
                    if (c != ':') {
                        L1(c, "was expecting a colon to separate field name and value");
                    }
                    z = true;
                }
            } else if (c < ' ') {
                if (c == '\n') {
                    this.u++;
                    this.v = i2;
                } else if (c == '\r') {
                    r3();
                } else if (c != '\t') {
                    O1(c);
                }
            }
        }
    }

    private final int u3(int i) {
        if (i != 44) {
            L1(i, "was expecting comma to separate " + this.z.m() + " entries");
        }
        while (true) {
            int i2 = this.r;
            if (i2 >= this.s) {
                return p3();
            }
            char[] cArr = this.Z;
            int i3 = i2 + 1;
            this.r = i3;
            char c = cArr[i2];
            if (c > ' ') {
                if (c != '/' && c != '#') {
                    return c;
                }
                this.r = i2;
                return p3();
            }
            if (c < ' ') {
                if (c == '\n') {
                    this.u++;
                    this.v = i3;
                } else if (c == '\r') {
                    r3();
                } else if (c != '\t') {
                    O1(c);
                }
            }
        }
    }

    private void v3() {
        if ((this.a & o0) == 0) {
            L1(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.r >= this.s && !V2()) {
            I1(" in a comment", null);
        }
        char[] cArr = this.Z;
        int i = this.r;
        this.r = i + 1;
        char c = cArr[i];
        if (c == '/') {
            w3();
        } else if (c == '*') {
            q3();
        } else {
            L1(c, "was expecting either '*' or '/' for a comment");
        }
    }

    private void w3() {
        while (true) {
            if (this.r >= this.s && !V2()) {
                return;
            }
            char[] cArr = this.Z;
            int i = this.r;
            int i2 = i + 1;
            this.r = i2;
            char c = cArr[i];
            if (c < ' ') {
                if (c == '\n') {
                    this.u++;
                    this.v = i2;
                    return;
                } else if (c == '\r') {
                    r3();
                    return;
                } else if (c != '\t') {
                    O1(c);
                }
            }
        }
    }

    private final int y3() {
        if (this.r >= this.s && !V2()) {
            return g2();
        }
        char[] cArr = this.Z;
        int i = this.r;
        int i2 = i + 1;
        this.r = i2;
        char c = cArr[i];
        if (c > ' ') {
            if (c != '/' && c != '#') {
                return c;
            }
            this.r = i;
            return z3();
        }
        if (c != ' ') {
            if (c == '\n') {
                this.u++;
                this.v = i2;
            } else if (c == '\r') {
                r3();
            } else if (c != '\t') {
                O1(c);
            }
        }
        while (true) {
            int i3 = this.r;
            if (i3 >= this.s) {
                return z3();
            }
            char[] cArr2 = this.Z;
            int i4 = i3 + 1;
            this.r = i4;
            char c2 = cArr2[i3];
            if (c2 > ' ') {
                if (c2 != '/' && c2 != '#') {
                    return c2;
                }
                this.r = i3;
                return z3();
            }
            if (c2 != ' ') {
                if (c2 == '\n') {
                    this.u++;
                    this.v = i4;
                } else if (c2 == '\r') {
                    r3();
                } else if (c2 != '\t') {
                    O1(c2);
                }
            }
        }
    }

    private int z3() {
        while (true) {
            if (this.r >= this.s && !V2()) {
                return g2();
            }
            char[] cArr = this.Z;
            int i = this.r;
            int i2 = i + 1;
            this.r = i2;
            char c = cArr[i];
            if (c > ' ') {
                if (c == '/') {
                    v3();
                } else if (c != '#' || !A3()) {
                    return c;
                }
            } else if (c != ' ') {
                if (c == '\n') {
                    this.u++;
                    this.v = i2;
                } else if (c == '\r') {
                    r3();
                } else if (c != '\t') {
                    O1(c);
                }
            }
        }
    }

    protected char G3(String str, JsonToken jsonToken) {
        if (this.r >= this.s && !V2()) {
            I1(str, jsonToken);
        }
        char[] cArr = this.Z;
        int i = this.r;
        this.r = i + 1;
        return cArr[i];
    }

    protected byte[] L2(Base64Variant base64Variant) {
        zo zoVarJ2 = j2();
        while (true) {
            if (this.r >= this.s) {
                W2();
            }
            char[] cArr = this.Z;
            int i = this.r;
            this.r = i + 1;
            char c = cArr[i];
            if (c > ' ') {
                int iDecodeBase64Char = base64Variant.decodeBase64Char(c);
                if (iDecodeBase64Char < 0) {
                    if (c == '\"') {
                        return zoVarJ2.t0();
                    }
                    iDecodeBase64Char = d2(base64Variant, c, 0);
                    if (iDecodeBase64Char < 0) {
                        continue;
                    }
                }
                if (this.r >= this.s) {
                    W2();
                }
                char[] cArr2 = this.Z;
                int i2 = this.r;
                this.r = i2 + 1;
                char c2 = cArr2[i2];
                int iDecodeBase64Char2 = base64Variant.decodeBase64Char(c2);
                if (iDecodeBase64Char2 < 0) {
                    iDecodeBase64Char2 = d2(base64Variant, c2, 1);
                }
                int i3 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                if (this.r >= this.s) {
                    W2();
                }
                char[] cArr3 = this.Z;
                int i4 = this.r;
                this.r = i4 + 1;
                char c3 = cArr3[i4];
                int iDecodeBase64Char3 = base64Variant.decodeBase64Char(c3);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        if (c3 == '\"') {
                            zoVarJ2.u(i3 >> 4);
                            if (base64Variant.usesPadding()) {
                                this.r--;
                                k2(base64Variant);
                            }
                            return zoVarJ2.t0();
                        }
                        iDecodeBase64Char3 = d2(base64Variant, c3, 2);
                    }
                    if (iDecodeBase64Char3 == -2) {
                        if (this.r >= this.s) {
                            W2();
                        }
                        char[] cArr4 = this.Z;
                        int i5 = this.r;
                        this.r = i5 + 1;
                        char c4 = cArr4[i5];
                        if (!base64Variant.usesPaddingChar(c4) && d2(base64Variant, c4, 3) != -2) {
                            throw F2(base64Variant, c4, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                        zoVarJ2.u(i3 >> 4);
                    }
                }
                int i6 = (i3 << 6) | iDecodeBase64Char3;
                if (this.r >= this.s) {
                    W2();
                }
                char[] cArr5 = this.Z;
                int i7 = this.r;
                this.r = i7 + 1;
                char c5 = cArr5[i7];
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(c5);
                if (iDecodeBase64Char4 < 0) {
                    if (iDecodeBase64Char4 != -2) {
                        if (c5 == '\"') {
                            zoVarJ2.y(i6 >> 2);
                            if (base64Variant.usesPadding()) {
                                this.r--;
                                k2(base64Variant);
                            }
                            return zoVarJ2.t0();
                        }
                        iDecodeBase64Char4 = d2(base64Variant, c5, 3);
                    }
                    if (iDecodeBase64Char4 == -2) {
                        zoVarJ2.y(i6 >> 2);
                    }
                }
                zoVarJ2.w((i6 << 6) | iDecodeBase64Char4);
            }
        }
    }

    protected final void M2() {
        int i = this.r;
        int i2 = this.s;
        if (i < i2) {
            int[] iArr = q0;
            int length = iArr.length;
            do {
                char[] cArr = this.Z;
                char c = cArr[i];
                if (c < length && iArr[c] != 0) {
                    if (c != '\"') {
                        break;
                    }
                    w13 w13Var = this.G;
                    int i3 = this.r;
                    w13Var.A(cArr, i3, i - i3);
                    this.r = i + 1;
                    return;
                }
                i++;
            } while (i < i2);
        }
        w13 w13Var2 = this.G;
        char[] cArr2 = this.Z;
        int i4 = this.r;
        w13Var2.z(cArr2, i4, i - i4);
        this.r = i;
        N2();
    }

    protected void N2() {
        char[] cArrS = this.G.s();
        int iT = this.G.t();
        int[] iArr = q0;
        int length = iArr.length;
        while (true) {
            if (this.r >= this.s && !V2()) {
                I1(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
            }
            char[] cArr = this.Z;
            int i = this.r;
            this.r = i + 1;
            char cF2 = cArr[i];
            if (cF2 < length && iArr[cF2] != 0) {
                if (cF2 == '\"') {
                    this.G.E(iT);
                    return;
                } else if (cF2 == '\\') {
                    cF2 = f2();
                } else if (cF2 < ' ') {
                    t2(cF2, "string value");
                }
            }
            if (iT >= cArrS.length) {
                cArrS = this.G.p();
                iT = 0;
            }
            cArrS[iT] = cF2;
            iT++;
        }
    }

    protected final String O2(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        int iId = jsonToken.id();
        if (iId != 5) {
            return (iId == 6 || iId == 7 || iId == 8) ? this.G.l() : jsonToken.asString();
        }
        return this.z.b();
    }

    protected JsonToken P2() {
        char[] cArrM = this.G.m();
        int iT = this.G.t();
        while (true) {
            if (this.r >= this.s && !V2()) {
                I1(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
            }
            char[] cArr = this.Z;
            int i = this.r;
            this.r = i + 1;
            char cF2 = cArr[i];
            if (cF2 <= '\\') {
                if (cF2 == '\\') {
                    cF2 = f2();
                } else if (cF2 <= '\'') {
                    if (cF2 == '\'') {
                        this.G.E(iT);
                        return JsonToken.VALUE_STRING;
                    }
                    if (cF2 < ' ') {
                        t2(cF2, "string value");
                    }
                }
            }
            if (iT >= cArrM.length) {
                cArrM = this.G.p();
                iT = 0;
            }
            cArrM[iT] = cF2;
            iT++;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public d41 Q0() {
        return dz1.X;
    }

    protected JsonToken Q2(int i, boolean z) {
        return R2(i, z, false);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v5 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    protected com.fasterxml.jackson.core.JsonToken R2(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v5 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public final String S0() {
        JsonToken jsonToken = this.d;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return O2(jsonToken);
        }
        if (this.e0) {
            this.e0 = false;
            M2();
        }
        return this.G.l();
    }

    @Override // defpackage.ez1
    public final String S1(String str) {
        JsonToken jsonToken = this.d;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return jsonToken == JsonToken.FIELD_NAME ? y0() : super.S1(str);
        }
        if (this.e0) {
            this.e0 = false;
            M2();
        }
        return this.G.l();
    }

    protected String S2(int i) {
        boolean zIsJavaIdentifierPart;
        if (i == 39 && (this.a & m0) != 0) {
            return e3();
        }
        if ((this.a & n0) == 0) {
            L1(i, "was expecting double-quote to start field name");
        }
        int[] iArrI = ex.i();
        int length = iArrI.length;
        if (i < length) {
            zIsJavaIdentifierPart = iArrI[i] == 0;
        } else {
            zIsJavaIdentifierPart = Character.isJavaIdentifierPart((char) i);
        }
        if (!zIsJavaIdentifierPart) {
            L1(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i2 = this.r;
        int i3 = this.d0;
        int i4 = this.s;
        if (i2 < i4) {
            do {
                char[] cArr = this.Z;
                char c = cArr[i2];
                if (c < length) {
                    if (iArrI[c] != 0) {
                        int i5 = this.r - 1;
                        this.r = i2;
                        return this.c0.l(cArr, i5, i2 - i5, i3);
                    }
                } else if (!Character.isJavaIdentifierPart(c)) {
                    int i6 = this.r - 1;
                    this.r = i2;
                    return this.c0.l(this.Z, i6, i2 - i6, i3);
                }
                i3 = (i3 * 33) + c;
                i2++;
            } while (i2 < i4);
        }
        int i7 = this.r - 1;
        this.r = i2;
        return T2(i7, i3, iArrI);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final char[] T0() {
        JsonToken jsonToken = this.d;
        if (jsonToken == null) {
            return null;
        }
        int iId = jsonToken.id();
        if (iId != 5) {
            if (iId != 6) {
                if (iId != 7 && iId != 8) {
                    return this.d.asCharArray();
                }
            } else if (this.e0) {
                this.e0 = false;
                M2();
            }
            return this.G.u();
        }
        if (!this.I) {
            String strB = this.z.b();
            int length = strB.length();
            char[] cArr = this.H;
            if (cArr == null) {
                this.H = this.p.f(length);
            } else if (cArr.length < length) {
                this.H = new char[length];
            }
            strB.getChars(0, length, this.H, 0);
            this.I = true;
        }
        return this.H;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final int U0() {
        JsonToken jsonToken = this.d;
        if (jsonToken == null) {
            return 0;
        }
        int iId = jsonToken.id();
        if (iId == 5) {
            return this.z.b().length();
        }
        if (iId != 6) {
            if (iId != 7 && iId != 8) {
                return this.d.asCharArray().length;
            }
        } else if (this.e0) {
            this.e0 = false;
            M2();
        }
        return this.G.F();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0045  */
    protected JsonToken U2(int i) {
        if (i != 39) {
            if (i == 73) {
                Z2("Infinity", 1);
                if ((this.a & k0) != 0) {
                    return G2("Infinity", Double.POSITIVE_INFINITY);
                }
                D1("Non-standard token 'Infinity': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow");
            } else if (i == 78) {
                Z2("NaN", 1);
                if ((this.a & k0) != 0) {
                    return G2("NaN", Double.NaN);
                }
                D1("Non-standard token 'NaN': enable `JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS` to allow");
            } else if (i != 93) {
                if (i == 43) {
                    if (this.r >= this.s && !V2()) {
                        J1(JsonToken.VALUE_NUMBER_INT);
                    }
                    char[] cArr = this.Z;
                    int i2 = this.r;
                    this.r = i2 + 1;
                    return R2(cArr[i2], false, true);
                }
                if (i == 44) {
                    if (!this.z.k() && (this.a & l0) != 0) {
                        this.r--;
                        return JsonToken.VALUE_NULL;
                    }
                }
            } else if (this.z.i()) {
                if (!this.z.k()) {
                    this.r--;
                    return JsonToken.VALUE_NULL;
                }
            }
        } else if ((this.a & m0) != 0) {
            return P2();
        }
        if (Character.isJavaIdentifierStart(i)) {
            o3(Constants.STR_EMPTY + ((char) i), u2());
        }
        L1(i, "expected a valid value " + v2());
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
    
        if (r0 != 8) goto L16;
     */
    @Override // com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int V0() {
        /*
            r3 = this;
            com.fasterxml.jackson.core.JsonToken r0 = r3.d
            r1 = 0
            if (r0 == 0) goto L24
            int r0 = r0.id()
            r2 = 6
            if (r0 == r2) goto L14
            r2 = 7
            if (r0 == r2) goto L1d
            r2 = 8
            if (r0 == r2) goto L1d
            goto L24
        L14:
            boolean r0 = r3.e0
            if (r0 == 0) goto L1d
            r3.e0 = r1
            r3.M2()
        L1d:
            w13 r0 = r3.G
            int r0 = r0.v()
            return r0
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dd2.V0():int");
    }

    protected boolean V2() throws IOException {
        Reader reader = this.Y;
        if (reader != null) {
            char[] cArr = this.Z;
            int i = reader.read(cArr, 0, cArr.length);
            if (i > 0) {
                int i2 = this.s;
                long j = i2;
                this.t += j;
                this.v -= i2;
                this.f0 -= j;
                this.r = 0;
                this.s = i;
                return true;
            }
            b2();
            if (i == 0) {
                throw new IOException("Reader returned 0 characters when trying to read " + this.s);
            }
        }
        return false;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation W0() {
        if (this.d != JsonToken.FIELD_NAME) {
            return new JsonLocation(c2(), -1L, this.w - 1, this.x, this.y);
        }
        return new JsonLocation(c2(), -1L, this.t + (this.f0 - 1), this.g0, this.h0);
    }

    protected void W2() {
        if (V2()) {
            return;
        }
        H1();
    }

    protected final void Z2(String str, int i) {
        int i2;
        int length = str.length();
        if (this.r + length >= this.s) {
            a3(str, i);
            return;
        }
        do {
            if (this.Z[this.r] != str.charAt(i)) {
                n3(str.substring(0, i));
            }
            i2 = this.r + 1;
            this.r = i2;
            i++;
        } while (i < length);
        char c = this.Z[i2];
        if (c < '0' || c == ']' || c == '}') {
            return;
        }
        J2(str, i, c);
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public final String a1() {
        JsonToken jsonToken = this.d;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return jsonToken == JsonToken.FIELD_NAME ? y0() : super.S1(null);
        }
        if (this.e0) {
            this.e0 = false;
            M2();
        }
        return this.G.l();
    }

    @Override // defpackage.dz1
    protected void b2() throws IOException {
        if (this.Y != null) {
            if (this.p.n() || f1(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this.Y.close();
            }
            this.Y = null;
        }
    }

    protected String e3() {
        int i = this.r;
        int i2 = this.d0;
        int i3 = this.s;
        if (i < i3) {
            int[] iArr = q0;
            int length = iArr.length;
            do {
                char[] cArr = this.Z;
                char c = cArr[i];
                if (c != '\'') {
                    if (c < length && iArr[c] != 0) {
                        break;
                    }
                    i2 = (i2 * 33) + c;
                    i++;
                } else {
                    int i4 = this.r;
                    this.r = i + 1;
                    return this.c0.l(cArr, i4, i - i4, i2);
                }
            } while (i < i3);
        }
        int i5 = this.r;
        this.r = i;
        return i3(i5, i2, 39);
    }

    @Override // defpackage.dz1
    protected char f2() {
        if (this.r >= this.s && !V2()) {
            I1(" in character escape sequence", JsonToken.VALUE_STRING);
        }
        char[] cArr = this.Z;
        int i = this.r;
        this.r = i + 1;
        char c = cArr[i];
        if (c == '\"' || c == '/' || c == '\\') {
            return c;
        }
        if (c == 'b') {
            return '\b';
        }
        if (c == 'f') {
            return '\f';
        }
        if (c == 'n') {
            return '\n';
        }
        if (c == 'r') {
            return '\r';
        }
        if (c == 't') {
            return '\t';
        }
        if (c != 'u') {
            return l2(c);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            if (this.r >= this.s && !V2()) {
                I1(" in character escape sequence", JsonToken.VALUE_STRING);
            }
            char[] cArr2 = this.Z;
            int i4 = this.r;
            this.r = i4 + 1;
            char c2 = cArr2[i4];
            int iB = ex.b(c2);
            if (iB < 0) {
                L1(c2, "expected a hex-digit for character escape sequence");
            }
            i2 = (i2 << 4) | iB;
        }
        return (char) i2;
    }

    protected final JsonToken g3(boolean z) {
        if (!f1(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
            return U2(46);
        }
        int i = this.r;
        int i2 = i - 1;
        if (z) {
            i2 = i - 2;
        }
        return f3(46, i2, i, z, 0);
    }

    protected final String h3() {
        int i = this.r;
        int i2 = this.d0;
        int[] iArr = q0;
        while (i < this.s) {
            char[] cArr = this.Z;
            char c = cArr[i];
            if (c < iArr.length && iArr[c] != 0) {
                if (c != '\"') {
                    break;
                }
                int i3 = this.r;
                this.r = i + 1;
                return this.c0.l(cArr, i3, i - i3, i2);
            }
            i2 = (i2 * 33) + c;
            i++;
        }
        int i4 = this.r;
        this.r = i;
        return i3(i4, i2, 34);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public byte[] j0(Base64Variant base64Variant) throws JsonParseException {
        byte[] bArr;
        JsonToken jsonToken = this.d;
        if (jsonToken == JsonToken.VALUE_EMBEDDED_OBJECT && (bArr = this.K) != null) {
            return bArr;
        }
        if (jsonToken != JsonToken.VALUE_STRING) {
            D1("Current token (" + this.d + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this.e0) {
            try {
                this.K = L2(base64Variant);
                this.e0 = false;
            } catch (IllegalArgumentException e) {
                throw n("Failed to decode VALUE_STRING as base64 (" + base64Variant + "): " + e.getMessage());
            }
        } else if (this.K == null) {
            zo zoVarJ2 = j2();
            x1(S0(), zoVarJ2, base64Variant);
            this.K = zoVarJ2.t0();
        }
        return this.K;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String l1() throws JsonParseException {
        JsonToken jsonTokenK3;
        this.L = 0;
        JsonToken jsonToken = this.d;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            c3();
            return null;
        }
        if (this.e0) {
            x3();
        }
        int iY3 = y3();
        if (iY3 < 0) {
            close();
            this.d = null;
            return null;
        }
        this.K = null;
        if (iY3 == 93 || iY3 == 125) {
            K2(iY3);
            return null;
        }
        if (this.z.s()) {
            iY3 = u3(iY3);
            if ((this.a & i0) != 0 && (iY3 == 93 || iY3 == 125)) {
                K2(iY3);
                return null;
            }
        }
        if (!this.z.j()) {
            B3();
            d3(iY3);
            return null;
        }
        C3();
        String strH3 = iY3 == 34 ? h3() : S2(iY3);
        this.z.w(strH3);
        this.d = jsonToken2;
        int iS3 = s3();
        B3();
        if (iS3 == 34) {
            this.e0 = true;
            this.F = JsonToken.VALUE_STRING;
            return strH3;
        }
        if (iS3 == 43) {
            jsonTokenK3 = f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? k3(false) : U2(iS3);
        } else if (iS3 == 91) {
            jsonTokenK3 = JsonToken.START_ARRAY;
        } else if (iS3 == 102) {
            X2();
            jsonTokenK3 = JsonToken.VALUE_FALSE;
        } else if (iS3 == 110) {
            Y2();
            jsonTokenK3 = JsonToken.VALUE_NULL;
        } else if (iS3 == 116) {
            b3();
            jsonTokenK3 = JsonToken.VALUE_TRUE;
        } else if (iS3 == 123) {
            jsonTokenK3 = JsonToken.START_OBJECT;
        } else if (iS3 == 45) {
            jsonTokenK3 = k3(true);
        } else if (iS3 != 46) {
            switch (iS3) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    jsonTokenK3 = l3(iS3);
                    break;
                default:
                    jsonTokenK3 = U2(iS3);
                    break;
            }
        } else {
            jsonTokenK3 = g3(false);
        }
        this.F = jsonTokenK3;
        return strH3;
    }

    protected final JsonToken l3(int i) {
        int i2 = this.r;
        int i3 = i2 - 1;
        int i4 = this.s;
        if (i == 48) {
            return j3(false, i3);
        }
        int i5 = 1;
        while (i2 < i4) {
            int i6 = i2 + 1;
            char c = this.Z[i2];
            if (c < '0' || c > '9') {
                if (c == '.' || c == 'e' || c == 'E') {
                    this.r = i6;
                    return f3(c, i3, i6, false, i5);
                }
                this.r = i2;
                if (this.z.k()) {
                    F3(c);
                }
                this.G.A(this.Z, i3, i2 - i3);
                return I2(false, i5);
            }
            i5++;
            i2 = i6;
        }
        this.r = i3;
        return j3(false, i3);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final String m1() {
        if (this.d != JsonToken.FIELD_NAME) {
            if (n1() == JsonToken.VALUE_STRING) {
                return S0();
            }
            return null;
        }
        this.I = false;
        JsonToken jsonToken = this.F;
        this.F = null;
        this.d = jsonToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this.e0) {
                this.e0 = false;
                M2();
            }
            return this.G.l();
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            this.z = this.z.p(this.x, this.y);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this.z = this.z.q(this.x, this.y);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003a A[DONT_INVERT, PHI: r10
      0x003a: PHI (r10v4 int) = (r10v3 int), (r10v22 int) binds: [B:9:0x002b, B:13:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0047  */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0068  */
    /* JADX WARN: Code duplicated, block: B:28:0x007d  */
    /* JADX WARN: Code duplicated, block: B:29:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x008e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0099  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:52:0x0104 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0106 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x011b A[EDGE_INSN: B:56:0x011b->B:57:0x0123 BREAK  A[LOOP:0: B:3:0x000e->B:77:0x000e]] */
    /* JADX WARN: Code duplicated, block: B:61:0x012c  */
    /* JADX WARN: Code duplicated, block: B:62:0x0132  */
    /* JADX WARN: Code duplicated, block: B:64:0x0135  */
    /* JADX WARN: Code duplicated, block: B:66:0x0146  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x009f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0108 A[SYNTHETIC] */
    protected int m3(Base64Variant base64Variant, OutputStream outputStream, byte[] bArr) throws IOException {
        int i;
        char c;
        int iDecodeBase64Char;
        int i2;
        char c2;
        int iDecodeBase64Char2;
        int i3;
        char c3;
        int iDecodeBase64Char3;
        char c4;
        int i4 = 3;
        int length = bArr.length - 3;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (this.r >= this.s) {
                W2();
            }
            char[] cArr = this.Z;
            int i7 = this.r;
            this.r = i7 + 1;
            char c5 = cArr[i7];
            if (c5 > ' ') {
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(c5);
                if (iDecodeBase64Char4 < 0) {
                    if (c5 == '\"') {
                        break;
                    }
                    iDecodeBase64Char4 = d2(base64Variant, c5, 0);
                    if (iDecodeBase64Char4 >= 0) {
                        if (i5 > length) {
                            i6 += i5;
                            outputStream.write(bArr, 0, i5);
                            i5 = 0;
                        }
                        if (this.r >= this.s) {
                            W2();
                        }
                        char[] cArr2 = this.Z;
                        int i8 = this.r;
                        this.r = i8 + 1;
                        c = cArr2[i8];
                        iDecodeBase64Char = base64Variant.decodeBase64Char(c);
                        if (iDecodeBase64Char < 0) {
                            iDecodeBase64Char = d2(base64Variant, c, 1);
                        }
                        i2 = (iDecodeBase64Char4 << 6) | iDecodeBase64Char;
                        if (this.r >= this.s) {
                            W2();
                        }
                        char[] cArr3 = this.Z;
                        int i9 = this.r;
                        this.r = i9 + 1;
                        c2 = cArr3[i9];
                        iDecodeBase64Char2 = base64Variant.decodeBase64Char(c2);
                        if (iDecodeBase64Char2 >= 0) {
                            if (iDecodeBase64Char2 != -2) {
                                if (c2 == '\"') {
                                    int i10 = i5 + 1;
                                    bArr[i5] = (byte) (i2 >> 4);
                                    if (base64Variant.usesPadding()) {
                                        this.r--;
                                        k2(base64Variant);
                                    }
                                    i5 = i10;
                                    break;
                                }
                                iDecodeBase64Char2 = d2(base64Variant, c2, 2);
                            }
                            if (iDecodeBase64Char2 == -2) {
                                if (this.r >= this.s) {
                                    W2();
                                }
                                char[] cArr4 = this.Z;
                                int i11 = this.r;
                                this.r = i11 + 1;
                                c4 = cArr4[i11];
                                if (base64Variant.usesPaddingChar(c4)) {
                                }
                                bArr[i5] = (byte) (i2 >> 4);
                                i5++;
                            }
                        }
                        i3 = (i2 << 6) | iDecodeBase64Char2;
                        if (this.r >= this.s) {
                            W2();
                        }
                        char[] cArr5 = this.Z;
                        int i12 = this.r;
                        this.r = i12 + 1;
                        c3 = cArr5[i12];
                        iDecodeBase64Char3 = base64Variant.decodeBase64Char(c3);
                        if (iDecodeBase64Char3 < 0) {
                            if (iDecodeBase64Char3 != -2) {
                                i = 3;
                            } else {
                                if (c3 == '\"') {
                                    int i13 = i5 + 1;
                                    bArr[i5] = (byte) (i3 >> 10);
                                    i5 += 2;
                                    bArr[i13] = (byte) (i3 >> 2);
                                    if (base64Variant.usesPadding()) {
                                        break;
                                    }
                                    this.r--;
                                    k2(base64Variant);
                                    break;
                                }
                                i = 3;
                                iDecodeBase64Char3 = d2(base64Variant, c3, 3);
                            }
                            if (iDecodeBase64Char3 == -2) {
                                int i14 = i5 + 1;
                                bArr[i5] = (byte) (i3 >> 10);
                                i5 += 2;
                                bArr[i14] = (byte) (i3 >> 2);
                            }
                            i4 = i;
                        } else {
                            i = 3;
                        }
                        int i15 = (i3 << 6) | iDecodeBase64Char3;
                        bArr[i5] = (byte) (i15 >> 16);
                        int i16 = i5 + 2;
                        bArr[i5 + 1] = (byte) (i15 >> 8);
                        i5 += 3;
                        bArr[i16] = (byte) i15;
                        i4 = i;
                    }
                } else {
                    if (i5 > length) {
                        i6 += i5;
                        outputStream.write(bArr, 0, i5);
                        i5 = 0;
                    }
                    if (this.r >= this.s) {
                        W2();
                    }
                    char[] cArr6 = this.Z;
                    int i17 = this.r;
                    this.r = i17 + 1;
                    c = cArr6[i17];
                    iDecodeBase64Char = base64Variant.decodeBase64Char(c);
                    if (iDecodeBase64Char < 0) {
                        iDecodeBase64Char = d2(base64Variant, c, 1);
                    }
                    i2 = (iDecodeBase64Char4 << 6) | iDecodeBase64Char;
                    if (this.r >= this.s) {
                        W2();
                    }
                    char[] cArr7 = this.Z;
                    int i18 = this.r;
                    this.r = i18 + 1;
                    c2 = cArr7[i18];
                    iDecodeBase64Char2 = base64Variant.decodeBase64Char(c2);
                    if (iDecodeBase64Char2 >= 0) {
                        if (iDecodeBase64Char2 != -2) {
                            if (c2 == '\"') {
                                int i19 = i5 + 1;
                                bArr[i5] = (byte) (i2 >> 4);
                                if (base64Variant.usesPadding()) {
                                    this.r--;
                                    k2(base64Variant);
                                }
                                i5 = i19;
                                break;
                            }
                            iDecodeBase64Char2 = d2(base64Variant, c2, 2);
                        }
                        if (iDecodeBase64Char2 == -2) {
                            if (this.r >= this.s) {
                                W2();
                            }
                            char[] cArr8 = this.Z;
                            int i110 = this.r;
                            this.r = i110 + 1;
                            c4 = cArr8[i110];
                            if (base64Variant.usesPaddingChar(c4) && d2(base64Variant, c4, i4) != -2) {
                                throw F2(base64Variant, c4, i4, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                            }
                            bArr[i5] = (byte) (i2 >> 4);
                            i5++;
                        }
                    }
                    i3 = (i2 << 6) | iDecodeBase64Char2;
                    if (this.r >= this.s) {
                        W2();
                    }
                    char[] cArr9 = this.Z;
                    int i111 = this.r;
                    this.r = i111 + 1;
                    c3 = cArr9[i111];
                    iDecodeBase64Char3 = base64Variant.decodeBase64Char(c3);
                    if (iDecodeBase64Char3 < 0) {
                        if (iDecodeBase64Char3 != -2) {
                            i = 3;
                        } else {
                            if (c3 == '\"') {
                                int i112 = i5 + 1;
                                bArr[i5] = (byte) (i3 >> 10);
                                i5 += 2;
                                bArr[i112] = (byte) (i3 >> 2);
                                if (base64Variant.usesPadding()) {
                                    break;
                                }
                                this.r--;
                                k2(base64Variant);
                                break;
                            }
                            i = 3;
                            iDecodeBase64Char3 = d2(base64Variant, c3, 3);
                        }
                        if (iDecodeBase64Char3 == -2) {
                            int i113 = i5 + 1;
                            bArr[i5] = (byte) (i3 >> 10);
                            i5 += 2;
                            bArr[i113] = (byte) (i3 >> 2);
                        }
                        i4 = i;
                    } else {
                        i = 3;
                    }
                    int i114 = (i3 << 6) | iDecodeBase64Char3;
                    bArr[i5] = (byte) (i114 >> 16);
                    int i115 = i5 + 2;
                    bArr[i5 + 1] = (byte) (i114 >> 8);
                    i5 += 3;
                    bArr[i115] = (byte) i114;
                    i4 = i;
                }
            }
            i = i4;
            i4 = i;
        }
        this.e0 = false;
        if (i5 <= 0) {
            return i6;
        }
        int i20 = i6 + i5;
        outputStream.write(bArr, 0, i5);
        return i20;
    }

    @Override // defpackage.ez1, com.fasterxml.jackson.core.JsonParser
    public final JsonToken n1() throws JsonParseException {
        JsonToken jsonTokenK3;
        JsonToken jsonToken = this.d;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            return c3();
        }
        this.L = 0;
        if (this.e0) {
            x3();
        }
        int iY3 = y3();
        if (iY3 < 0) {
            close();
            this.d = null;
            return null;
        }
        this.K = null;
        if (iY3 == 93 || iY3 == 125) {
            K2(iY3);
            return this.d;
        }
        if (this.z.s()) {
            iY3 = u3(iY3);
            if ((this.a & i0) != 0 && (iY3 == 93 || iY3 == 125)) {
                K2(iY3);
                return this.d;
            }
        }
        boolean zJ = this.z.j();
        if (zJ) {
            C3();
            this.z.w(iY3 == 34 ? h3() : S2(iY3));
            this.d = jsonToken2;
            iY3 = s3();
        }
        B3();
        if (iY3 == 34) {
            this.e0 = true;
            jsonTokenK3 = JsonToken.VALUE_STRING;
        } else if (iY3 == 43) {
            jsonTokenK3 = f1(JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS.mappedFeature()) ? k3(false) : U2(iY3);
        } else if (iY3 == 91) {
            if (!zJ) {
                this.z = this.z.p(this.x, this.y);
            }
            jsonTokenK3 = JsonToken.START_ARRAY;
        } else if (iY3 == 102) {
            X2();
            jsonTokenK3 = JsonToken.VALUE_FALSE;
        } else if (iY3 == 110) {
            Y2();
            jsonTokenK3 = JsonToken.VALUE_NULL;
        } else if (iY3 == 116) {
            b3();
            jsonTokenK3 = JsonToken.VALUE_TRUE;
        } else if (iY3 == 123) {
            if (!zJ) {
                this.z = this.z.q(this.x, this.y);
            }
            jsonTokenK3 = JsonToken.START_OBJECT;
        } else if (iY3 == 125) {
            L1(iY3, "expected a value");
            b3();
            jsonTokenK3 = JsonToken.VALUE_TRUE;
        } else if (iY3 == 45) {
            jsonTokenK3 = k3(true);
        } else if (iY3 != 46) {
            switch (iY3) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    jsonTokenK3 = l3(iY3);
                    break;
                default:
                    jsonTokenK3 = U2(iY3);
                    break;
            }
        } else {
            jsonTokenK3 = g3(false);
        }
        if (zJ) {
            this.F = jsonTokenK3;
            return this.d;
        }
        this.d = jsonTokenK3;
        return jsonTokenK3;
    }

    protected void n3(String str) {
        o3(str, u2());
    }

    protected void o3(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        do {
            if (this.r < this.s || V2()) {
                char c = this.Z[this.r];
                if (Character.isJavaIdentifierPart(c)) {
                    this.r++;
                    sb.append(c);
                }
            }
            F1("Unrecognized token '%s': was expecting %s", sb, str2);
        } while (sb.length() < 256);
        sb.append("...");
        F1("Unrecognized token '%s': was expecting %s", sb, str2);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int q1(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        if (!this.e0 || this.d != JsonToken.VALUE_STRING) {
            byte[] bArrJ0 = j0(base64Variant);
            outputStream.write(bArrJ0);
            return bArrJ0.length;
        }
        byte[] bArrD = this.p.d();
        try {
            return m3(base64Variant, outputStream, bArrD);
        } finally {
            this.p.o(bArrD);
        }
    }

    @Override // defpackage.dz1
    protected void q2() {
        char[] cArr;
        super.q2();
        this.c0.r();
        if (!this.a0 || (cArr = this.Z) == null) {
            return;
        }
        this.Z = null;
        this.p.s(cArr);
    }

    protected final void r3() {
        if (this.r < this.s || V2()) {
            char[] cArr = this.Z;
            int i = this.r;
            if (cArr[i] == '\n') {
                this.r = i + 1;
            }
        }
        this.u++;
        this.v = this.r;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public jt1 t0() {
        return this.b0;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation w0() {
        int i = (this.r - this.v) + 1;
        return new JsonLocation(c2(), -1L, ((long) this.r) + this.t, this.u, i);
    }

    protected final void x3() {
        this.e0 = false;
        int i = this.r;
        int i2 = this.s;
        char[] cArr = this.Z;
        while (true) {
            if (i >= i2) {
                this.r = i;
                if (!V2()) {
                    I1(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
                }
                i = this.r;
                i2 = this.s;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    this.r = i3;
                    f2();
                    i = this.r;
                    i2 = this.s;
                } else if (c <= '\"') {
                    if (c == '\"') {
                        this.r = i3;
                        return;
                    } else if (c < ' ') {
                        this.r = i3;
                        t2(c, "string value");
                    }
                }
            }
            i = i3;
        }
    }

    public dd2(oy0 oy0Var, int i, Reader reader, jt1 jt1Var, fx fxVar) {
        super(oy0Var, i);
        this.Y = reader;
        this.Z = oy0Var.h();
        this.r = 0;
        this.s = 0;
        this.b0 = jt1Var;
        this.c0 = fxVar;
        this.d0 = fxVar.m();
        this.a0 = true;
    }
}
