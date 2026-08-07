package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class iy {
    private String a;
    private String b;
    private String c;

    public static abstract class b {
        private String a;
        private String b;
        private String c;

        public abstract iy d();

        public String toString() {
            return "ClientOptions.ClientOptionsBuilder(implementation=" + this.a + ", networkLoggingLevel=" + this.b + ", sdkLoggingLevel=" + this.c + ")";
        }
    }

    private static final class c extends b {
        private c() {
        }

        @Override // iy.b
        public iy d() {
            return new iy(this);
        }
    }

    protected iy(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
    }

    public static b a() {
        return new c();
    }

    public String b() {
        return this.a;
    }

    public String c() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        String orDefault = System.getenv().getOrDefault("DASHSCOPE_NETWORK_LOGGING_LEVEL", "NONE");
        return Arrays.asList("NONE", "BASIC", "HEADERS", "BODY").contains(orDefault) ? orDefault : "NONE";
    }

    public String d() {
        String str = this.c;
        return str != null ? str : System.getenv().getOrDefault("DASHSCOPE_SDK_LOGGING_LEVEL", "WARN");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof iy)) {
            return false;
        }
        iy iyVar = (iy) obj;
        String strB = b();
        String strB2 = iyVar.b();
        if (strB != null ? !strB.equals(strB2) : strB2 != null) {
            return false;
        }
        String strC = c();
        String strC2 = iyVar.c();
        if (strC != null ? !strC.equals(strC2) : strC2 != null) {
            return false;
        }
        String strD = d();
        String strD2 = iyVar.d();
        return strD != null ? strD.equals(strD2) : strD2 == null;
    }

    public int hashCode() {
        String strB = b();
        int iHashCode = strB == null ? 43 : strB.hashCode();
        String strC = c();
        int iHashCode2 = ((iHashCode + 59) * 59) + (strC == null ? 43 : strC.hashCode());
        String strD = d();
        return (iHashCode2 * 59) + (strD != null ? strD.hashCode() : 43);
    }

    public String toString() {
        return "ClientOptions(implementation=" + b() + ", networkLoggingLevel=" + c() + ", sdkLoggingLevel=" + d() + ")";
    }
}
