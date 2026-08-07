package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import com.tencent.connect.common.Constants;
import java.util.concurrent.TimeUnit;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public final class tp {
    public static final b n = new b(null);
    public static final tp o = new a().d().a();
    public static final tp p = new a().e().c(Integer.MAX_VALUE, TimeUnit.SECONDS).a();
    private final boolean a;
    private final boolean b;
    private final int c;
    private final int d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private String m;

    public static final class a {
        private boolean a;
        private boolean b;
        private int c = -1;
        private int d = -1;
        private int e = -1;
        private boolean f;
        private boolean g;
        private boolean h;

        private final int b(long j) {
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j;
        }

        public final tp a() {
            return new tp(this.a, this.b, this.c, -1, false, false, false, this.d, this.e, this.f, this.g, this.h, null, null);
        }

        public final a c(int i, TimeUnit timeUnit) {
            p31.f(timeUnit, "timeUnit");
            if (i >= 0) {
                this.d = b(timeUnit.toSeconds(i));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + i).toString());
        }

        public final a d() {
            this.a = true;
            return this;
        }

        public final a e() {
            this.f = true;
            return this;
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        private final int a(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (i.L(str2, str.charAt(i), false, 2, null)) {
                    return i;
                }
                i++;
            }
            return str.length();
        }

        /* JADX WARN: Code duplicated, block: B:15:0x004b  */
        /* JADX WARN: Code duplicated, block: B:17:0x0068  */
        /* JADX WARN: Code duplicated, block: B:28:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:32:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:34:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:36:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:37:0x00e5  */
        /* JADX WARN: Code duplicated, block: B:39:0x00ed  */
        /* JADX WARN: Code duplicated, block: B:41:0x00f6  */
        /* JADX WARN: Code duplicated, block: B:43:0x00fe  */
        /* JADX WARN: Code duplicated, block: B:44:0x0104  */
        /* JADX WARN: Code duplicated, block: B:46:0x010c  */
        /* JADX WARN: Code duplicated, block: B:47:0x0111  */
        /* JADX WARN: Code duplicated, block: B:49:0x0119  */
        /* JADX WARN: Code duplicated, block: B:50:0x011e  */
        /* JADX WARN: Code duplicated, block: B:52:0x0126  */
        /* JADX WARN: Code duplicated, block: B:53:0x012c  */
        /* JADX WARN: Code duplicated, block: B:55:0x0134  */
        /* JADX WARN: Code duplicated, block: B:56:0x013c  */
        /* JADX WARN: Code duplicated, block: B:58:0x0144  */
        /* JADX WARN: Code duplicated, block: B:59:0x014a  */
        /* JADX WARN: Code duplicated, block: B:61:0x0153  */
        /* JADX WARN: Code duplicated, block: B:62:0x015a  */
        /* JADX WARN: Code duplicated, block: B:64:0x0162  */
        /* JADX WARN: Code duplicated, block: B:65:0x0169  */
        /* JADX WARN: Code duplicated, block: B:67:0x0171  */
        public final tp b(iw0 iw0Var) {
            int iA;
            int iA2;
            String string;
            int i;
            String string2;
            iw0 iw0Var2 = iw0Var;
            p31.f(iw0Var2, "headers");
            int size = iw0Var.size();
            boolean z = true;
            boolean z2 = true;
            int i2 = 0;
            String str = null;
            boolean z3 = false;
            boolean z4 = false;
            int iX = -1;
            int iX2 = -1;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            int iX3 = -1;
            int iX4 = -1;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            while (i2 < size) {
                String strB = iw0Var2.b(i2);
                String strG = iw0Var2.g(i2);
                if (i.v(strB, "Cache-Control", z)) {
                    if (str == null) {
                        str = strG;
                    }
                    iA = 0;
                    while (iA < strG.length()) {
                        iA2 = a(strG, "=,;", iA);
                        String strSubstring = strG.substring(iA, iA2);
                        p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        string = i.O0(strSubstring).toString();
                        if (iA2 != strG.length()) {
                            i = size;
                            if (strG.charAt(iA2) == ',' && strG.charAt(iA2) != ';') {
                                int iD = pa3.D(strG, iA2 + 1);
                                if (iD >= strG.length() || strG.charAt(iD) != '\"') {
                                    iA = a(strG, ",;", iD);
                                    String strSubstring2 = strG.substring(iD, iA);
                                    p31.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                    string2 = i.O0(strSubstring2).toString();
                                } else {
                                    int i3 = iD + 1;
                                    int iV = i.V(strG, JsonFactory.DEFAULT_QUOTE_CHAR, i3, false, 4, null);
                                    string2 = strG.substring(i3, iV);
                                    p31.e(string2, "this as java.lang.String…ing(startIndex, endIndex)");
                                    iA = iV + 1;
                                }
                            }
                            z = true;
                            if (i.v("no-cache", string, true)) {
                                z3 = true;
                            } else if (i.v("no-store", string, true)) {
                                z4 = true;
                            } else if (i.v("max-age", string, true)) {
                                iX = pa3.X(string2, -1);
                            } else if (i.v("s-maxage", string, true)) {
                                iX2 = pa3.X(string2, -1);
                            } else if (i.v("private", string, true)) {
                                z5 = true;
                            } else if (i.v("public", string, true)) {
                                z6 = true;
                            } else if (i.v("must-revalidate", string, true)) {
                                z7 = true;
                            } else if (i.v("max-stale", string, true)) {
                                iX3 = pa3.X(string2, Integer.MAX_VALUE);
                            } else if (i.v("min-fresh", string, true)) {
                                iX4 = pa3.X(string2, -1);
                            } else if (i.v("only-if-cached", string, true)) {
                                z8 = true;
                            } else if (i.v("no-transform", string, true)) {
                                z9 = true;
                            } else if (i.v("immutable", string, true)) {
                                z10 = true;
                            }
                            size = i;
                        } else {
                            i = size;
                        }
                        iA = iA2 + 1;
                        string2 = null;
                        z = true;
                        if (i.v("no-cache", string, true)) {
                            z3 = true;
                        } else if (i.v("no-store", string, true)) {
                            z4 = true;
                        } else if (i.v("max-age", string, true)) {
                            iX = pa3.X(string2, -1);
                        } else if (i.v("s-maxage", string, true)) {
                            iX2 = pa3.X(string2, -1);
                        } else if (i.v("private", string, true)) {
                            z5 = true;
                        } else if (i.v("public", string, true)) {
                            z6 = true;
                        } else if (i.v("must-revalidate", string, true)) {
                            z7 = true;
                        } else if (i.v("max-stale", string, true)) {
                            iX3 = pa3.X(string2, Integer.MAX_VALUE);
                        } else if (i.v("min-fresh", string, true)) {
                            iX4 = pa3.X(string2, -1);
                        } else if (i.v("only-if-cached", string, true)) {
                            z8 = true;
                        } else if (i.v("no-transform", string, true)) {
                            z9 = true;
                        } else if (i.v("immutable", string, true)) {
                            z10 = true;
                        }
                        size = i;
                    }
                    i2++;
                    iw0Var2 = iw0Var;
                    size = size;
                } else {
                    if (i.v(strB, "Pragma", z)) {
                    }
                    i2++;
                    iw0Var2 = iw0Var;
                    size = size;
                }
                z2 = false;
                iA = 0;
                while (iA < strG.length()) {
                    iA2 = a(strG, "=,;", iA);
                    String strSubstring3 = strG.substring(iA, iA2);
                    p31.e(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    string = i.O0(strSubstring3).toString();
                    if (iA2 != strG.length()) {
                        i = size;
                        if (strG.charAt(iA2) == ',') {
                        }
                        z = true;
                        if (i.v("no-cache", string, true)) {
                            z3 = true;
                        } else if (i.v("no-store", string, true)) {
                            z4 = true;
                        } else if (i.v("max-age", string, true)) {
                            iX = pa3.X(string2, -1);
                        } else if (i.v("s-maxage", string, true)) {
                            iX2 = pa3.X(string2, -1);
                        } else if (i.v("private", string, true)) {
                            z5 = true;
                        } else if (i.v("public", string, true)) {
                            z6 = true;
                        } else if (i.v("must-revalidate", string, true)) {
                            z7 = true;
                        } else if (i.v("max-stale", string, true)) {
                            iX3 = pa3.X(string2, Integer.MAX_VALUE);
                        } else if (i.v("min-fresh", string, true)) {
                            iX4 = pa3.X(string2, -1);
                        } else if (i.v("only-if-cached", string, true)) {
                            z8 = true;
                        } else if (i.v("no-transform", string, true)) {
                            z9 = true;
                        } else if (i.v("immutable", string, true)) {
                            z10 = true;
                        }
                        size = i;
                    } else {
                        i = size;
                    }
                    iA = iA2 + 1;
                    string2 = null;
                    z = true;
                    if (i.v("no-cache", string, true)) {
                        z3 = true;
                    } else if (i.v("no-store", string, true)) {
                        z4 = true;
                    } else if (i.v("max-age", string, true)) {
                        iX = pa3.X(string2, -1);
                    } else if (i.v("s-maxage", string, true)) {
                        iX2 = pa3.X(string2, -1);
                    } else if (i.v("private", string, true)) {
                        z5 = true;
                    } else if (i.v("public", string, true)) {
                        z6 = true;
                    } else if (i.v("must-revalidate", string, true)) {
                        z7 = true;
                    } else if (i.v("max-stale", string, true)) {
                        iX3 = pa3.X(string2, Integer.MAX_VALUE);
                    } else if (i.v("min-fresh", string, true)) {
                        iX4 = pa3.X(string2, -1);
                    } else if (i.v("only-if-cached", string, true)) {
                        z8 = true;
                    } else if (i.v("no-transform", string, true)) {
                        z9 = true;
                    } else if (i.v("immutable", string, true)) {
                        z10 = true;
                    }
                    size = i;
                }
                i2++;
                iw0Var2 = iw0Var;
                size = size;
            }
            return new tp(z3, z4, iX, iX2, z5, z6, z7, iX3, iX4, z8, z9, z10, !z2 ? null : str, null);
        }

        private b() {
        }
    }

    public /* synthetic */ tp(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str, y70 y70Var) {
        this(z, z2, i, i2, z3, z4, z5, i3, i4, z6, z7, z8, str);
    }

    public final boolean a() {
        return this.e;
    }

    public final boolean b() {
        return this.f;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.h;
    }

    public final int e() {
        return this.i;
    }

    public final boolean f() {
        return this.g;
    }

    public final boolean g() {
        return this.a;
    }

    public final boolean h() {
        return this.b;
    }

    public final boolean i() {
        return this.j;
    }

    public String toString() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.a) {
            sb.append("no-cache, ");
        }
        if (this.b) {
            sb.append("no-store, ");
        }
        if (this.c != -1) {
            sb.append("max-age=");
            sb.append(this.c);
            sb.append(", ");
        }
        if (this.d != -1) {
            sb.append("s-maxage=");
            sb.append(this.d);
            sb.append(", ");
        }
        if (this.e) {
            sb.append("private, ");
        }
        if (this.f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        if (this.h != -1) {
            sb.append("max-stale=");
            sb.append(this.h);
            sb.append(", ");
        }
        if (this.i != -1) {
            sb.append("min-fresh=");
            sb.append(this.i);
            sb.append(", ");
        }
        if (this.j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return Constants.STR_EMPTY;
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        p31.e(string, "StringBuilder().apply(builderAction).toString()");
        this.m = string;
        return string;
    }

    private tp(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.a = z;
        this.b = z2;
        this.c = i;
        this.d = i2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = i3;
        this.i = i4;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }
}
