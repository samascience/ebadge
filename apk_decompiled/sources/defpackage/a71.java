package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class a71 implements Closeable {
    private final Reader a;
    private long i;
    private int j;
    private String k;
    private int[] l;
    private String[] n;
    private int[] o;
    private boolean b = false;
    private final char[] c = new char[1024];
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    int h = 0;
    private int m = 1;

    class a extends b71 {
        a() {
        }

        @Override // defpackage.b71
        public void a(a71 a71Var) throws IOException {
            if (a71Var instanceof l71) {
                ((l71) a71Var).d1();
                return;
            }
            int iC = a71Var.h;
            if (iC == 0) {
                iC = a71Var.C();
            }
            if (iC == 13) {
                a71Var.h = 9;
                return;
            }
            if (iC == 12) {
                a71Var.h = 8;
                return;
            }
            if (iC == 14) {
                a71Var.h = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + a71Var.M0() + a71Var.t0());
        }
    }

    static {
        b71.a = new a();
    }

    public a71(Reader reader) {
        int[] iArr = new int[32];
        this.l = iArr;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.a = reader;
    }

    private int H0(boolean z) throws IOException {
        char[] cArr = this.c;
        int i = this.d;
        int i2 = this.e;
        while (true) {
            if (i == i2) {
                this.d = i;
                if (!a0(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + t0());
                }
                i = this.d;
                i2 = this.e;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f++;
                this.g = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.d = i3;
                    if (i3 == i2) {
                        this.d = i;
                        boolean zA0 = a0(2);
                        this.d++;
                        if (!zA0) {
                            return c;
                        }
                    }
                    w();
                    int i4 = this.d;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.d = i4 + 1;
                        if (!T0("*/")) {
                            throw X0("Unterminated comment");
                        }
                        i = this.d + 2;
                        i2 = this.e;
                    } else {
                        if (c2 != '/') {
                            return c;
                        }
                        this.d = i4 + 1;
                        U0();
                        i = this.d;
                        i2 = this.e;
                    }
                } else {
                    if (c != '#') {
                        this.d = i3;
                        return c;
                    }
                    this.d = i3;
                    w();
                    U0();
                    i = this.d;
                    i2 = this.e;
                }
            }
            i = i3;
        }
    }

    private String J0(char c) throws IOException {
        int i;
        char[] cArr = this.c;
        StringBuilder sb = null;
        do {
            int i2 = this.d;
            int i3 = this.e;
            while (true) {
                int i4 = i3;
                i = i2;
                while (true) {
                    if (i2 < i4) {
                        int i5 = i2 + 1;
                        char c2 = cArr[i2];
                        if (c2 == c) {
                            this.d = i5;
                            int i6 = (i5 - i) - 1;
                            if (sb == null) {
                                return new String(cArr, i, i6);
                            }
                            sb.append(cArr, i, i6);
                            return sb.toString();
                        }
                        if (c2 == '\\') {
                            this.d = i5;
                            int i7 = i5 - i;
                            int i8 = i7 - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max(i7 * 2, 16));
                            }
                            sb.append(cArr, i, i8);
                            sb.append(Q0());
                            i2 = this.d;
                            i3 = this.e;
                        } else {
                            if (c2 == '\n') {
                                this.f++;
                                this.g = i5;
                            }
                            i2 = i5;
                        }
                    }
                }
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i2 - i) * 2, 16));
            }
            sb.append(cArr, i, i2 - i);
            this.d = i2;
        } while (a0(1));
        throw X0("Unterminated string");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    private String L0() throws IOException {
        String string;
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            int i2 = 0;
            while (true) {
                int i3 = this.d;
                if (i3 + i2 < this.e) {
                    char c = this.c[i3 + i2];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        w();
                    }
                    i = i2;
                } else if (i2 >= this.c.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(this.c, this.d, i2);
                    this.d += i2;
                    if (!a0(1)) {
                    }
                } else if (!a0(i2 + 1)) {
                    i = i2;
                }
                if (sb == null) {
                    string = new String(this.c, this.d, i);
                } else {
                    sb.append(this.c, this.d, i);
                    string = sb.toString();
                }
                this.d += i;
                return string;
            }
        }
    }

    private int N0() {
        String str;
        String str2;
        int i;
        char c = this.c[this.d];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else {
            if (c != 'n' && c != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.d + i2 >= this.e && !a0(i2 + 1)) {
                return 0;
            }
            char c2 = this.c[this.d + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.d + length < this.e || a0(length + 1)) && m0(this.c[this.d + length])) {
            return 0;
        }
        this.d += length;
        this.h = i;
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    /* JADX WARN: Code duplicated, block: B:90:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:92:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:97:0x00ec  */
    private int O0() {
        char c;
        char c2;
        char[] cArr = this.c;
        int i = this.d;
        int i2 = this.e;
        int i3 = 0;
        int i4 = 0;
        char c3 = 0;
        boolean z = false;
        boolean z2 = true;
        long j = 0;
        while (true) {
            if (i + i4 != i2) {
                c = cArr[i + i4];
                if (c != '+') {
                    if (c != 'E' || c == 'e') {
                        i3 = 0;
                        if (c3 == 2 && c3 != 4) {
                            return 0;
                        }
                        c3 = 5;
                    } else if (c != '-') {
                        c2 = 3;
                        if (c == '.') {
                            i3 = 0;
                            if (c3 != 2) {
                                return 0;
                            }
                        } else {
                            if (c < '0' || c > '9') {
                                if (!m0(c)) {
                                    break;
                                }
                                return 0;
                            }
                            if (c3 == 1 || c3 == 0) {
                                j = -(c - '0');
                                c3 = 2;
                            } else if (c3 == 2) {
                                if (j == 0) {
                                    return 0;
                                }
                                long j2 = (10 * j) - ((long) (c - '0'));
                                z2 &= j > -922337203685477580L || (j == -922337203685477580L && j2 < j);
                                j = j2;
                            } else if (c3 == 3) {
                                i3 = 0;
                                c3 = 4;
                            } else if (c3 == 5 || c3 == 6) {
                                i3 = 0;
                                c3 = 7;
                            }
                            i3 = 0;
                        }
                    } else {
                        c2 = 6;
                        i3 = 0;
                        if (c3 == 0) {
                            c3 = 1;
                            z = true;
                        } else if (c3 != 5) {
                            return 0;
                        }
                    }
                    i4++;
                } else {
                    c2 = 6;
                    i3 = 0;
                    if (c3 != 5) {
                        return 0;
                    }
                }
                c3 = c2;
                i4++;
            } else {
                if (i4 == cArr.length) {
                    return i3;
                }
                if (!a0(i4 + 1)) {
                    break;
                }
                i = this.d;
                i2 = this.e;
                c = cArr[i + i4];
                if (c != '+') {
                    if (c != 'E') {
                        i3 = 0;
                        if (c3 == 2) {
                        }
                        c3 = 5;
                    } else {
                        i3 = 0;
                        if (c3 == 2) {
                        }
                        c3 = 5;
                    }
                    i4++;
                } else {
                    c2 = 6;
                    i3 = 0;
                    if (c3 != 5) {
                        return 0;
                    }
                }
                c3 = c2;
                i4++;
            }
        }
        if (c3 == 2 && z2 && ((j != Long.MIN_VALUE || z) && (j != 0 || !z))) {
            if (!z) {
                j = -j;
            }
            this.i = j;
            this.d += i4;
            this.h = 15;
            return 15;
        }
        if (c3 != 2 && c3 != 4 && c3 != 7) {
            return 0;
        }
        this.j = i4;
        this.h = 16;
        return 16;
    }

    private void P0(int i) {
        int i2 = this.m;
        int[] iArr = this.l;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.l = Arrays.copyOf(iArr, i3);
            this.o = Arrays.copyOf(this.o, i3);
            this.n = (String[]) Arrays.copyOf(this.n, i3);
        }
        int[] iArr2 = this.l;
        int i4 = this.m;
        this.m = i4 + 1;
        iArr2[i4] = i;
    }

    private char Q0() throws IOException {
        int i;
        if (this.d == this.e && !a0(1)) {
            throw X0("Unterminated escape sequence");
        }
        char[] cArr = this.c;
        int i2 = this.d;
        int i3 = i2 + 1;
        this.d = i3;
        char c = cArr[i2];
        if (c == '\n') {
            this.f++;
            this.g = i3;
        } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
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
                throw X0("Invalid escape sequence");
            }
            if (i2 + 5 > this.e && !a0(4)) {
                throw X0("Unterminated escape sequence");
            }
            int i4 = this.d;
            int i5 = i4 + 4;
            char c2 = 0;
            while (i4 < i5) {
                char c3 = this.c[i4];
                char c4 = (char) (c2 << 4);
                if (c3 >= '0' && c3 <= '9') {
                    i = c3 - '0';
                } else if (c3 >= 'a' && c3 <= 'f') {
                    i = c3 - 'W';
                } else {
                    if (c3 < 'A' || c3 > 'F') {
                        throw new NumberFormatException("\\u" + new String(this.c, this.d, 4));
                    }
                    i = c3 - '7';
                }
                c2 = (char) (c4 + i);
                i4++;
            }
            this.d += 4;
            return c2;
        }
        return c;
    }

    private void S0(char c) throws IOException {
        char[] cArr = this.c;
        do {
            int i = this.d;
            int i2 = this.e;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.d = i3;
                    return;
                }
                if (c2 == '\\') {
                    this.d = i3;
                    Q0();
                    i = this.d;
                    i2 = this.e;
                } else {
                    if (c2 == '\n') {
                        this.f++;
                        this.g = i3;
                    }
                    i = i3;
                }
            }
            this.d = i;
        } while (a0(1));
        throw X0("Unterminated string");
    }

    private boolean T0(String str) {
        int length = str.length();
        while (true) {
            if (this.d + length > this.e && !a0(length)) {
                return false;
            }
            char[] cArr = this.c;
            int i = this.d;
            if (cArr[i] != '\n') {
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.c[this.d + i2] == str.charAt(i2)) {
                    }
                }
                return true;
            }
            this.f++;
            this.g = i + 1;
            this.d++;
        }
    }

    private void U0() {
        char c;
        do {
            if (this.d >= this.e && !a0(1)) {
                return;
            }
            char[] cArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            c = cArr[i];
            if (c == '\n') {
                this.f++;
                this.g = i2;
                return;
            }
        } while (c != '\r');
    }

    private void V0() throws IOException {
        do {
            int i = 0;
            while (true) {
                int i2 = this.d;
                if (i2 + i < this.e) {
                    char c = this.c[i2 + i];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i++;
                                                    break;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        w();
                    }
                    this.d += i;
                    return;
                }
                this.d = i2 + i;
            }
        } while (a0(1));
    }

    private IOException X0(String str) throws MalformedJsonException {
        throw new MalformedJsonException(str + t0());
    }

    private boolean a0(int i) throws IOException {
        int i2;
        int i3;
        char[] cArr = this.c;
        int i4 = this.g;
        int i5 = this.d;
        this.g = i4 - i5;
        int i6 = this.e;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.e = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.e = 0;
        }
        this.d = 0;
        do {
            Reader reader = this.a;
            int i8 = this.e;
            int i9 = reader.read(cArr, i8, cArr.length - i8);
            if (i9 == -1) {
                return false;
            }
            i2 = this.e + i9;
            this.e = i2;
            if (this.f == 0 && (i3 = this.g) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.d++;
                this.g = i3 + 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    private String e0(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (true) {
            int i2 = this.m;
            if (i >= i2) {
                return sb.toString();
            }
            int i3 = this.l[i];
            if (i3 == 1 || i3 == 2) {
                int i4 = this.o[i];
                if (z && i4 > 0 && i == i2 - 1) {
                    i4--;
                }
                sb.append('[');
                sb.append(i4);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = this.n[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    private boolean m0(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        w();
        return false;
    }

    private void w() throws IOException {
        if (!this.b) {
            throw X0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void y() throws IOException {
        H0(true);
        int i = this.d;
        this.d = i - 1;
        if (i + 4 <= this.e || a0(5)) {
            int i2 = this.d;
            char[] cArr = this.c;
            if (cArr[i2] == ')' && cArr[i2 + 1] == ']' && cArr[i2 + 2] == '}' && cArr[i2 + 3] == '\'' && cArr[i2 + 4] == '\n') {
                this.d = i2 + 5;
            }
        }
    }

    public int A0() throws IOException {
        int iC = this.h;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 15) {
            long j = this.i;
            int i = (int) j;
            if (j == i) {
                this.h = 0;
                int[] iArr = this.o;
                int i2 = this.m - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
            throw new NumberFormatException("Expected an int but was " + this.i + t0());
        }
        if (iC == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else {
            if (iC != 8 && iC != 9 && iC != 10) {
                throw new IllegalStateException("Expected an int but was " + M0() + t0());
            }
            if (iC == 10) {
                this.k = L0();
            } else {
                this.k = J0(iC == 8 ? '\'' : JsonFactory.DEFAULT_QUOTE_CHAR);
            }
            try {
                int i3 = Integer.parseInt(this.k);
                this.h = 0;
                int[] iArr2 = this.o;
                int i4 = this.m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        }
        this.h = 11;
        double d = Double.parseDouble(this.k);
        int i5 = (int) d;
        if (i5 != d) {
            throw new NumberFormatException("Expected an int but was " + this.k + t0());
        }
        this.k = null;
        this.h = 0;
        int[] iArr3 = this.o;
        int i6 = this.m - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    int C() throws IOException {
        int iH0;
        int[] iArr = this.l;
        int i = this.m;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int iH1 = H0(true);
            if (iH1 != 44) {
                if (iH1 != 59) {
                    if (iH1 != 93) {
                        throw X0("Unterminated array");
                    }
                    this.h = 4;
                    return 4;
                }
                w();
            }
        } else {
            if (i2 == 3 || i2 == 5) {
                iArr[i - 1] = 4;
                if (i2 == 5 && (iH0 = H0(true)) != 44) {
                    if (iH0 != 59) {
                        if (iH0 != 125) {
                            throw X0("Unterminated object");
                        }
                        this.h = 2;
                        return 2;
                    }
                    w();
                }
                int iH2 = H0(true);
                if (iH2 == 34) {
                    this.h = 13;
                    return 13;
                }
                if (iH2 == 39) {
                    w();
                    this.h = 12;
                    return 12;
                }
                if (iH2 == 125) {
                    if (i2 == 5) {
                        throw X0("Expected name");
                    }
                    this.h = 2;
                    return 2;
                }
                w();
                this.d--;
                if (!m0((char) iH2)) {
                    throw X0("Expected name");
                }
                this.h = 14;
                return 14;
            }
            if (i2 == 4) {
                iArr[i - 1] = 5;
                int iH3 = H0(true);
                if (iH3 != 58) {
                    if (iH3 != 61) {
                        throw X0("Expected ':'");
                    }
                    w();
                    if (this.d < this.e || a0(1)) {
                        char[] cArr = this.c;
                        int i3 = this.d;
                        if (cArr[i3] == '>') {
                            this.d = i3 + 1;
                        }
                    }
                }
            } else if (i2 == 6) {
                if (this.b) {
                    y();
                }
                this.l[this.m - 1] = 7;
            } else if (i2 == 7) {
                if (H0(false) == -1) {
                    this.h = 17;
                    return 17;
                }
                w();
                this.d--;
            } else if (i2 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iH4 = H0(true);
        if (iH4 == 34) {
            this.h = 9;
            return 9;
        }
        if (iH4 == 39) {
            w();
            this.h = 8;
            return 8;
        }
        if (iH4 != 44 && iH4 != 59) {
            if (iH4 == 91) {
                this.h = 3;
                return 3;
            }
            if (iH4 != 93) {
                if (iH4 == 123) {
                    this.h = 1;
                    return 1;
                }
                this.d--;
                int iN0 = N0();
                if (iN0 != 0) {
                    return iN0;
                }
                int iO0 = O0();
                if (iO0 != 0) {
                    return iO0;
                }
                if (!m0(this.c[this.d])) {
                    throw X0("Expected value");
                }
                w();
                this.h = 10;
                return 10;
            }
            if (i2 == 1) {
                this.h = 4;
                return 4;
            }
        }
        if (i2 != 1 && i2 != 2) {
            throw X0("Unexpected value");
        }
        w();
        this.d--;
        this.h = 7;
        return 7;
    }

    public void D() throws IOException {
        int iC = this.h;
        if (iC == 0) {
            iC = C();
        }
        if (iC != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + M0() + t0());
        }
        int i = this.m;
        this.m = i - 1;
        int[] iArr = this.o;
        int i2 = i - 2;
        iArr[i2] = iArr[i2] + 1;
        this.h = 0;
    }

    public long F0() throws IOException {
        int iC = this.h;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 15) {
            this.h = 0;
            int[] iArr = this.o;
            int i = this.m - 1;
            iArr[i] = iArr[i] + 1;
            return this.i;
        }
        if (iC == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else {
            if (iC != 8 && iC != 9 && iC != 10) {
                throw new IllegalStateException("Expected a long but was " + M0() + t0());
            }
            if (iC == 10) {
                this.k = L0();
            } else {
                this.k = J0(iC == 8 ? '\'' : JsonFactory.DEFAULT_QUOTE_CHAR);
            }
            try {
                long j = Long.parseLong(this.k);
                this.h = 0;
                int[] iArr2 = this.o;
                int i2 = this.m - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        }
        this.h = 11;
        double d = Double.parseDouble(this.k);
        long j2 = (long) d;
        if (j2 != d) {
            throw new NumberFormatException("Expected a long but was " + this.k + t0());
        }
        this.k = null;
        this.h = 0;
        int[] iArr3 = this.o;
        int i3 = this.m - 1;
        iArr3[i3] = iArr3[i3] + 1;
        return j2;
    }

    public String G0() throws IOException {
        String strJ0;
        int iC = this.h;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 14) {
            strJ0 = L0();
        } else if (iC == 12) {
            strJ0 = J0('\'');
        } else {
            if (iC != 13) {
                throw new IllegalStateException("Expected a name but was " + M0() + t0());
            }
            strJ0 = J0(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        this.h = 0;
        this.n[this.m - 1] = strJ0;
        return strJ0;
    }

    public void I0() throws IOException {
        int iC = this.h;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 7) {
            this.h = 0;
            int[] iArr = this.o;
            int i = this.m - 1;
            iArr[i] = iArr[i] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + M0() + t0());
    }

    public String K0() throws IOException {
        String str;
        int iC = this.h;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 10) {
            str = L0();
        } else if (iC == 8) {
            str = J0('\'');
        } else if (iC == 9) {
            str = J0(JsonFactory.DEFAULT_QUOTE_CHAR);
        } else if (iC == 11) {
            str = this.k;
            this.k = null;
        } else if (iC == 15) {
            str = Long.toString(this.i);
        } else {
            if (iC != 16) {
                throw new IllegalStateException("Expected a string but was " + M0() + t0());
            }
            str = new String(this.c, this.d, this.j);
            this.d += this.j;
        }
        this.h = 0;
        int[] iArr = this.o;
        int i = this.m - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }

    public JsonToken M0() throws IOException {
        int iC = this.h;
        if (iC == 0) {
            iC = C();
        }
        switch (iC) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void R0(boolean z) {
        this.b = z;
    }

    public void V() throws IOException {
        int iC = this.h;
        if (iC == 0) {
            iC = C();
        }
        if (iC != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + M0() + t0());
        }
        int i = this.m;
        int i2 = i - 1;
        this.m = i2;
        this.n[i2] = null;
        int[] iArr = this.o;
        int i3 = i - 2;
        iArr[i3] = iArr[i3] + 1;
        this.h = 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void W0() throws IOException {
        int i = 0;
        do {
            int iC = this.h;
            if (iC == 0) {
                iC = C();
            }
            switch (iC) {
                case 1:
                    P0(3);
                    i++;
                    this.h = 0;
                    break;
                case 2:
                    if (i == 0) {
                        this.n[this.m - 1] = null;
                    }
                    this.m--;
                    i--;
                    this.h = 0;
                    break;
                case 3:
                    P0(1);
                    i++;
                    this.h = 0;
                    break;
                case 4:
                    this.m--;
                    i--;
                    this.h = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.h = 0;
                    break;
                case 8:
                    S0('\'');
                    this.h = 0;
                    break;
                case 9:
                    S0(JsonFactory.DEFAULT_QUOTE_CHAR);
                    this.h = 0;
                    break;
                case 10:
                    V0();
                    this.h = 0;
                    break;
                case 12:
                    S0('\'');
                    if (i == 0) {
                        this.n[this.m - 1] = "<skipped>";
                    }
                    this.h = 0;
                    break;
                case 13:
                    S0(JsonFactory.DEFAULT_QUOTE_CHAR);
                    if (i == 0) {
                        this.n[this.m - 1] = "<skipped>";
                    }
                    this.h = 0;
                    break;
                case 14:
                    V0();
                    if (i == 0) {
                        this.n[this.m - 1] = "<skipped>";
                    }
                    this.h = 0;
                    break;
                case 16:
                    this.d += this.j;
                    this.h = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i > 0);
        int[] iArr = this.o;
        int i2 = this.m - 1;
        iArr[i2] = iArr[i2] + 1;
    }

    public String c() {
        return e0(false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.h = 0;
        this.l[0] = 8;
        this.m = 1;
        this.a.close();
    }

    public String g0() {
        return e0(true);
    }

    public boolean j0() throws IOException {
        int iC = this.h;
        if (iC == 0) {
            iC = C();
        }
        return (iC == 2 || iC == 4 || iC == 17) ? false : true;
    }

    public final boolean k0() {
        return this.b;
    }

    public void n() throws IOException {
        int iC = this.h;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 3) {
            P0(1);
            this.o[this.m - 1] = 0;
            this.h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + M0() + t0());
        }
    }

    String t0() {
        return " at line " + (this.f + 1) + " column " + ((this.d - this.g) + 1) + " path " + c();
    }

    public String toString() {
        return getClass().getSimpleName() + t0();
    }

    public void u() throws IOException {
        int iC = this.h;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 1) {
            P0(3);
            this.h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + M0() + t0());
        }
    }

    public boolean w0() throws IOException {
        int iC = this.h;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 5) {
            this.h = 0;
            int[] iArr = this.o;
            int i = this.m - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iC == 6) {
            this.h = 0;
            int[] iArr2 = this.o;
            int i2 = this.m - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + M0() + t0());
    }

    public double y0() throws IOException {
        int iC = this.h;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 15) {
            this.h = 0;
            int[] iArr = this.o;
            int i = this.m - 1;
            iArr[i] = iArr[i] + 1;
            return this.i;
        }
        if (iC == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else if (iC == 8 || iC == 9) {
            this.k = J0(iC == 8 ? '\'' : JsonFactory.DEFAULT_QUOTE_CHAR);
        } else if (iC == 10) {
            this.k = L0();
        } else if (iC != 11) {
            throw new IllegalStateException("Expected a double but was " + M0() + t0());
        }
        this.h = 11;
        double d = Double.parseDouble(this.k);
        if (!this.b && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + d + t0());
        }
        this.k = null;
        this.h = 0;
        int[] iArr2 = this.o;
        int i2 = this.m - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return d;
    }
}
