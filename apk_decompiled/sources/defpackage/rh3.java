package defpackage;

import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public final class rh3 {
    public static final a g = new a(null);
    public final boolean a;
    public final Integer b;
    public final boolean c;
    public final Integer d;
    public final boolean e;
    public final boolean f;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final rh3 a(iw0 iw0Var) {
            p31.f(iw0Var, "responseHeaders");
            int size = iw0Var.size();
            boolean z = false;
            Integer numM = null;
            boolean z2 = false;
            Integer numM2 = null;
            boolean z3 = false;
            boolean z4 = false;
            for (int i = 0; i < size; i++) {
                if (i.v(iw0Var.b(i), "Sec-WebSocket-Extensions", true)) {
                    String strG = iw0Var.g(i);
                    int i2 = 0;
                    while (i2 < strG.length()) {
                        int iR = pa3.r(strG, ',', i2, 0, 4, null);
                        int iP = pa3.p(strG, ';', i2, iR);
                        String strY = pa3.Y(strG, i2, iP);
                        int i3 = iP + 1;
                        if (i.v(strY, "permessage-deflate", true)) {
                            if (z) {
                                z4 = true;
                            }
                            i2 = i3;
                            while (i2 < iR) {
                                int iP2 = pa3.p(strG, ';', i2, iR);
                                int iP3 = pa3.p(strG, '=', i2, iP2);
                                String strY2 = pa3.Y(strG, i2, iP3);
                                String strR0 = iP3 < iP2 ? i.r0(pa3.Y(strG, iP3 + 1, iP2), "\"") : null;
                                i2 = iP2 + 1;
                                if (i.v(strY2, "client_max_window_bits", true)) {
                                    if (numM != null) {
                                        z4 = true;
                                    }
                                    numM = strR0 != null ? i.m(strR0) : null;
                                    if (numM == null) {
                                        z4 = true;
                                    }
                                } else if (i.v(strY2, "client_no_context_takeover", true)) {
                                    if (z2) {
                                        z4 = true;
                                    }
                                    if (strR0 != null) {
                                        z4 = true;
                                    }
                                    z2 = true;
                                } else if (i.v(strY2, "server_max_window_bits", true)) {
                                    if (numM2 != null) {
                                        z4 = true;
                                    }
                                    numM2 = strR0 != null ? i.m(strR0) : null;
                                    if (numM2 == null) {
                                        z4 = true;
                                    }
                                } else if (i.v(strY2, "server_no_context_takeover", true)) {
                                    if (z3) {
                                        z4 = true;
                                    }
                                    if (strR0 != null) {
                                        z4 = true;
                                    }
                                    z3 = true;
                                } else {
                                    z4 = true;
                                }
                            }
                            z = true;
                        } else {
                            i2 = i3;
                            z4 = true;
                        }
                    }
                }
            }
            return new rh3(z, numM, z2, numM2, z3, z4);
        }

        private a() {
        }
    }

    public rh3(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        this.a = z;
        this.b = num;
        this.c = z2;
        this.d = num2;
        this.e = z3;
        this.f = z4;
    }

    public final boolean a(boolean z) {
        return z ? this.c : this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rh3)) {
            return false;
        }
        rh3 rh3Var = (rh3) obj;
        return this.a == rh3Var.a && p31.a(this.b, rh3Var.b) && this.c == rh3Var.c && p31.a(this.d, rh3Var.d) && this.e == rh3Var.e && this.f == rh3Var.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z = this.a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        Integer num = this.b;
        int iHashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        boolean z2 = this.c;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (iHashCode + r2) * 31;
        Integer num2 = this.d;
        int iHashCode2 = (i2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z3 = this.e;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i3 = (iHashCode2 + r3) * 31;
        boolean z4 = this.f;
        return i3 + (z4 ? 1 : z4);
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.a + ", clientMaxWindowBits=" + this.b + ", clientNoContextTakeover=" + this.c + ", serverMaxWindowBits=" + this.d + ", serverNoContextTakeover=" + this.e + ", unknownValues=" + this.f + ')';
    }
}
