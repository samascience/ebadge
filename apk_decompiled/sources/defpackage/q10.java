package defpackage;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.Duration;

/* JADX INFO: loaded from: classes.dex */
public final class q10 {
    private static final Integer l = 443;
    private static final Duration m = Duration.ofSeconds(120);
    private static final Duration n = Duration.ofSeconds(60);
    private static final Duration o = Duration.ofSeconds(300);
    private static final Duration p = Duration.ofSeconds(300);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Integer f373q = 32;
    private static final Integer r = 32;
    private static final Integer s = 32;
    private String a;
    private Integer b;
    private mc c;
    private Duration d;
    private Duration e;
    private Duration f;
    private Duration g;
    private Duration h;
    private Integer i;
    private Integer j;
    private Integer k;

    public static abstract class b {
        private String a;
        private Integer b;
        private mc c;
        private Duration d;
        private Duration e;
        private Duration f;
        private Duration g;
        private Duration h;
        private Integer i;
        private Integer j;
        private Integer k;

        public abstract q10 l();

        public String toString() {
            return "ConnectionConfigurations.ConnectionConfigurationsBuilder(proxyHost=" + this.a + ", proxyPort=" + this.b + ", proxyAuthenticator=" + this.c + ", connectTimeout=" + this.d + ", writeTimeout=" + this.e + ", responseTimeout=" + this.f + ", readTimeout=" + this.g + ", connectionIdleTimeout=" + this.h + ", connectionPoolSize=" + this.i + ", maximumAsyncRequests=" + this.j + ", maximumAsyncRequestsPerHost=" + this.k + ")";
        }
    }

    private static final class c extends b {
        private c() {
        }

        @Override // q10.b
        public q10 l() {
            return new q10(this);
        }
    }

    protected q10(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
    }

    public static b a() {
        return new c();
    }

    private Duration e(Duration duration, Duration duration2, String str) {
        if (duration != null) {
            return duration;
        }
        try {
            return Duration.ofSeconds(Integer.parseInt(System.getenv(str)));
        } catch (NumberFormatException unused) {
            return duration2;
        }
    }

    public Duration b() {
        return e(this.d, m, "DASHSCOPE_CONNECTION_TIMEOUT");
    }

    public Duration c() {
        return e(this.h, p, "DASHSCOPE_CONNECTION_IDLE_TIME");
    }

    public Integer d() {
        try {
            Integer num = this.i;
            return num != null ? num : Integer.valueOf(Integer.parseInt(System.getenv("DASHSCOPE_CONNECTION_POOL_SIZE")));
        } catch (NumberFormatException unused) {
            return f373q;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q10)) {
            return false;
        }
        q10 q10Var = (q10) obj;
        Integer numK = k();
        Integer numK2 = q10Var.k();
        if (numK != null ? !numK.equals(numK2) : numK2 != null) {
            return false;
        }
        Integer numD = d();
        Integer numD2 = q10Var.d();
        if (numD != null ? !numD.equals(numD2) : numD2 != null) {
            return false;
        }
        Integer numF = f();
        Integer numF2 = q10Var.f();
        if (numF != null ? !numF.equals(numF2) : numF2 != null) {
            return false;
        }
        Integer numG = g();
        Integer numG2 = q10Var.g();
        if (numG != null ? !numG.equals(numG2) : numG2 != null) {
            return false;
        }
        String strJ = j();
        String strJ2 = q10Var.j();
        if (strJ != null ? !strJ.equals(strJ2) : strJ2 != null) {
            return false;
        }
        mc mcVarI = i();
        mc mcVarI2 = q10Var.i();
        if (mcVarI != null ? !mcVarI.equals(mcVarI2) : mcVarI2 != null) {
            return false;
        }
        Duration durationB = b();
        Duration durationB2 = q10Var.b();
        if (durationB != null ? !durationB.equals(durationB2) : durationB2 != null) {
            return false;
        }
        Duration durationN = n();
        Duration durationN2 = q10Var.n();
        if (durationN != null ? !durationN.equals(durationN2) : durationN2 != null) {
            return false;
        }
        Duration durationM = m();
        Duration durationM2 = q10Var.m();
        if (durationM != null ? !durationM.equals(durationM2) : durationM2 != null) {
            return false;
        }
        Duration durationL = l();
        Duration durationL2 = q10Var.l();
        if (durationL != null ? !durationL.equals(durationL2) : durationL2 != null) {
            return false;
        }
        Duration durationC = c();
        Duration durationC2 = q10Var.c();
        return durationC != null ? durationC.equals(durationC2) : durationC2 == null;
    }

    public Integer f() {
        try {
            Integer num = this.j;
            return num != null ? num : Integer.valueOf(Integer.parseInt(System.getenv("DASHSCOPE_MAXIMUM_ASYNC_REQUESTS")));
        } catch (NumberFormatException unused) {
            return r;
        }
    }

    public Integer g() {
        try {
            Integer num = this.k;
            return num != null ? num : Integer.valueOf(Integer.parseInt(System.getenv("DASHSCOPE_MAXIMUM_ASYNC_REQUESTS_PER_HOST")));
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    public Proxy h() {
        String strJ = j();
        if (strJ != null) {
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(strJ, k().intValue()));
        }
        return null;
    }

    public int hashCode() {
        Integer numK = k();
        int iHashCode = numK == null ? 43 : numK.hashCode();
        Integer numD = d();
        int iHashCode2 = ((iHashCode + 59) * 59) + (numD == null ? 43 : numD.hashCode());
        Integer numF = f();
        int iHashCode3 = (iHashCode2 * 59) + (numF == null ? 43 : numF.hashCode());
        Integer numG = g();
        int iHashCode4 = (iHashCode3 * 59) + (numG == null ? 43 : numG.hashCode());
        String strJ = j();
        int iHashCode5 = (iHashCode4 * 59) + (strJ == null ? 43 : strJ.hashCode());
        mc mcVarI = i();
        int iHashCode6 = (iHashCode5 * 59) + (mcVarI == null ? 43 : mcVarI.hashCode());
        Duration durationB = b();
        int iHashCode7 = (iHashCode6 * 59) + (durationB == null ? 43 : durationB.hashCode());
        Duration durationN = n();
        int iHashCode8 = (iHashCode7 * 59) + (durationN == null ? 43 : durationN.hashCode());
        Duration durationM = m();
        int iHashCode9 = (iHashCode8 * 59) + (durationM == null ? 43 : durationM.hashCode());
        Duration durationL = l();
        int iHashCode10 = (iHashCode9 * 59) + (durationL == null ? 43 : durationL.hashCode());
        Duration durationC = c();
        return (iHashCode10 * 59) + (durationC != null ? durationC.hashCode() : 43);
    }

    public mc i() {
        return this.c;
    }

    public String j() {
        String str = this.a;
        return str != null ? str : System.getenv("DASHSCOPE_PROXY_HOST");
    }

    public Integer k() {
        Integer num = this.b;
        if (num != null) {
            return num;
        }
        String str = System.getenv("DASHSCOPE_PROXY_PORT");
        return str == null ? l : Integer.valueOf(Integer.parseInt(str));
    }

    public Duration l() {
        return e(this.g, o, "DASHSCOPE_READ_TIMEOUT");
    }

    public Duration m() {
        return this.f;
    }

    public Duration n() {
        return e(this.e, n, "DASHSCOPE_WRITE_TIMEOUT");
    }

    public String toString() {
        return "ConnectionConfigurations(proxyHost=" + j() + ", proxyPort=" + k() + ", proxyAuthenticator=" + i() + ", connectTimeout=" + b() + ", writeTimeout=" + n() + ", responseTimeout=" + m() + ", readTimeout=" + l() + ", connectionIdleTimeout=" + c() + ", connectionPoolSize=" + d() + ", maximumAsyncRequests=" + f() + ", maximumAsyncRequestsPerHost=" + g() + ")";
    }
}
