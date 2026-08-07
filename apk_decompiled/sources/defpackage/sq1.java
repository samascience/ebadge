package defpackage;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class sq1 {
    private Map a;
    private String b;
    private String c;
    private ByteBuffer d;
    private Integer e;

    public static class a {
        private boolean a;
        private Map b;
        private String c;
        private String d;
        private ByteBuffer e;
        private Integer f;

        a() {
        }

        public a a(ByteBuffer byteBuffer) {
            this.e = byteBuffer;
            return this;
        }

        public sq1 b() {
            Map mapA = this.b;
            if (!this.a) {
                mapA = sq1.a();
            }
            return new sq1(mapA, this.c, this.d, this.e, this.f);
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a d(Map map) {
            this.b = map;
            this.a = true;
            return this;
        }

        public a e(Integer num) {
            this.f = num;
            return this;
        }

        public a f(String str) {
            this.c = str;
            return this;
        }

        public String toString() {
            return "NetworkResponse.NetworkResponseBuilder(headers$value=" + this.b + ", message=" + this.c + ", event=" + this.d + ", binary=" + this.e + ", httpStatusCode=" + this.f + ")";
        }
    }

    sq1(Map map, String str, String str2, ByteBuffer byteBuffer, Integer num) {
        this.a = map;
        this.b = str;
        this.c = str2;
        this.d = byteBuffer;
        this.e = num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map a() {
        return new HashMap();
    }

    public static a c() {
        return new a();
    }

    protected boolean d(Object obj) {
        return obj instanceof sq1;
    }

    public ByteBuffer e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof sq1)) {
            return false;
        }
        sq1 sq1Var = (sq1) obj;
        if (!sq1Var.d(this)) {
            return false;
        }
        Integer numH = h();
        Integer numH2 = sq1Var.h();
        if (numH != null ? !numH.equals(numH2) : numH2 != null) {
            return false;
        }
        Map mapG = g();
        Map mapG2 = sq1Var.g();
        if (mapG != null ? !mapG.equals(mapG2) : mapG2 != null) {
            return false;
        }
        String strI = i();
        String strI2 = sq1Var.i();
        if (strI != null ? !strI.equals(strI2) : strI2 != null) {
            return false;
        }
        String strF = f();
        String strF2 = sq1Var.f();
        if (strF != null ? !strF.equals(strF2) : strF2 != null) {
            return false;
        }
        ByteBuffer byteBufferE = e();
        ByteBuffer byteBufferE2 = sq1Var.e();
        return byteBufferE != null ? byteBufferE.equals(byteBufferE2) : byteBufferE2 == null;
    }

    public String f() {
        return this.c;
    }

    public Map g() {
        return this.a;
    }

    public Integer h() {
        return this.e;
    }

    public int hashCode() {
        Integer numH = h();
        int iHashCode = numH == null ? 43 : numH.hashCode();
        Map mapG = g();
        int iHashCode2 = ((iHashCode + 59) * 59) + (mapG == null ? 43 : mapG.hashCode());
        String strI = i();
        int iHashCode3 = (iHashCode2 * 59) + (strI == null ? 43 : strI.hashCode());
        String strF = f();
        int iHashCode4 = (iHashCode3 * 59) + (strF == null ? 43 : strF.hashCode());
        ByteBuffer byteBufferE = e();
        return (iHashCode4 * 59) + (byteBufferE != null ? byteBufferE.hashCode() : 43);
    }

    public String i() {
        return this.b;
    }

    public String toString() {
        return "NetworkResponse(headers=" + g() + ", message=" + i() + ", event=" + f() + ", binary=" + e() + ", httpStatusCode=" + h() + ")";
    }
}
