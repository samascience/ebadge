package defpackage;

import com.alibaba.dashscope.protocol.HttpMethod;
import com.alibaba.dashscope.protocol.Protocol;
import com.alibaba.dashscope.protocol.StreamingMode;
import com.jieli.jl_rcsp.constant.WatchConstant;

/* JADX INFO: loaded from: classes.dex */
public final class zs0 implements gn2 {
    private StreamingMode a;
    private Protocol b;
    private HttpMethod c;
    private String d;
    private Boolean e;
    private Boolean f;
    private Boolean g;
    private String h;
    private String i;

    public static abstract class b {
        private boolean a;
        private StreamingMode b;
        private boolean c;
        private Protocol d;
        private boolean e;
        private HttpMethod f;
        private String g;
        private boolean h;
        private Boolean i;
        private boolean j;
        private Boolean k;
        private boolean l;
        private Boolean m;
        private boolean n;
        private String o;
        private boolean p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private String f461q;

        public abstract zs0 r();

        public b s(HttpMethod httpMethod) {
            this.f = httpMethod;
            this.e = true;
            return v();
        }

        public b t(String str) {
            this.g = str;
            return v();
        }

        public String toString() {
            return "GeneralServiceOption.GeneralServiceOptionBuilder(streamingMode$value=" + this.b + ", protocol$value=" + this.d + ", httpMethod$value=" + this.f + ", path=" + this.g + ", isAsyncTask$value=" + this.i + ", isSSE$value=" + this.k + ", isService$value=" + this.m + ", baseHttpUrl$value=" + this.o + ", baseWebSocketUrl$value=" + this.f461q + ")";
        }

        public b u(Protocol protocol) {
            this.d = protocol;
            this.c = true;
            return v();
        }

        protected abstract b v();

        public b w(StreamingMode streamingMode) {
            this.b = streamingMode;
            this.a = true;
            return v();
        }
    }

    private static final class c extends b {
        private c() {
        }

        @Override // zs0.b
        public zs0 r() {
            return new zs0(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // zs0.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public c v() {
            return this;
        }
    }

    protected zs0(b bVar) {
        this.a = bVar.a ? bVar.b : t();
        this.b = bVar.c ? bVar.d : s();
        this.c = bVar.e ? bVar.f : o();
        this.d = bVar.g;
        this.e = bVar.h ? bVar.i : p();
        this.f = bVar.j ? bVar.k : q();
        this.g = bVar.l ? bVar.m : r();
        this.h = bVar.n ? bVar.o : m();
        this.i = bVar.p ? bVar.f461q : n();
    }

    private static String m() {
        return null;
    }

    private static String n() {
        return null;
    }

    private static HttpMethod o() {
        return HttpMethod.POST;
    }

    private static Boolean p() {
        return Boolean.FALSE;
    }

    private static Boolean q() {
        return Boolean.FALSE;
    }

    private static Boolean r() {
        return Boolean.FALSE;
    }

    private static Protocol s() {
        return Protocol.HTTP;
    }

    private static StreamingMode t() {
        return StreamingMode.NONE;
    }

    public static b u() {
        return new c();
    }

    @Override // defpackage.gn2
    public Boolean a() {
        return this.f;
    }

    @Override // defpackage.gn2
    public String d() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.g.booleanValue()) {
            stringBuffer.append("/services");
        }
        if (this.d != null) {
            stringBuffer.append(WatchConstant.FAT_FS_ROOT);
            stringBuffer.append(this.d);
        }
        return stringBuffer.toString();
    }

    @Override // defpackage.gn2
    public StreamingMode e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zs0)) {
            return false;
        }
        zs0 zs0Var = (zs0) obj;
        Boolean boolF = f();
        Boolean boolF2 = zs0Var.f();
        if (boolF != null ? !boolF.equals(boolF2) : boolF2 != null) {
            return false;
        }
        Boolean boolA = a();
        Boolean boolA2 = zs0Var.a();
        if (boolA != null ? !boolA.equals(boolA2) : boolA2 != null) {
            return false;
        }
        Boolean boolV = v();
        Boolean boolV2 = zs0Var.v();
        if (boolV != null ? !boolV.equals(boolV2) : boolV2 != null) {
            return false;
        }
        StreamingMode streamingModeE = e();
        StreamingMode streamingModeE2 = zs0Var.e();
        if (streamingModeE != null ? !streamingModeE.equals(streamingModeE2) : streamingModeE2 != null) {
            return false;
        }
        Protocol protocolH = h();
        Protocol protocolH2 = zs0Var.h();
        if (protocolH != null ? !protocolH.equals(protocolH2) : protocolH2 != null) {
            return false;
        }
        HttpMethod httpMethodG = g();
        HttpMethod httpMethodG2 = zs0Var.g();
        if (httpMethodG != null ? !httpMethodG.equals(httpMethodG2) : httpMethodG2 != null) {
            return false;
        }
        String strW = w();
        String strW2 = zs0Var.w();
        if (strW != null ? !strW.equals(strW2) : strW2 != null) {
            return false;
        }
        String strJ = j();
        String strJ2 = zs0Var.j();
        if (strJ != null ? !strJ.equals(strJ2) : strJ2 != null) {
            return false;
        }
        String strL = l();
        String strL2 = zs0Var.l();
        return strL != null ? strL.equals(strL2) : strL2 == null;
    }

    @Override // defpackage.gn2
    public Boolean f() {
        return this.e;
    }

    @Override // defpackage.gn2
    public HttpMethod g() {
        return this.c;
    }

    @Override // defpackage.gn2
    public Protocol h() {
        return this.b;
    }

    public int hashCode() {
        Boolean boolF = f();
        int iHashCode = boolF == null ? 43 : boolF.hashCode();
        Boolean boolA = a();
        int iHashCode2 = ((iHashCode + 59) * 59) + (boolA == null ? 43 : boolA.hashCode());
        Boolean boolV = v();
        int iHashCode3 = (iHashCode2 * 59) + (boolV == null ? 43 : boolV.hashCode());
        StreamingMode streamingModeE = e();
        int iHashCode4 = (iHashCode3 * 59) + (streamingModeE == null ? 43 : streamingModeE.hashCode());
        Protocol protocolH = h();
        int iHashCode5 = (iHashCode4 * 59) + (protocolH == null ? 43 : protocolH.hashCode());
        HttpMethod httpMethodG = g();
        int iHashCode6 = (iHashCode5 * 59) + (httpMethodG == null ? 43 : httpMethodG.hashCode());
        String strW = w();
        int iHashCode7 = (iHashCode6 * 59) + (strW == null ? 43 : strW.hashCode());
        String strJ = j();
        int iHashCode8 = (iHashCode7 * 59) + (strJ == null ? 43 : strJ.hashCode());
        String strL = l();
        return (iHashCode8 * 59) + (strL != null ? strL.hashCode() : 43);
    }

    @Override // defpackage.gn2
    public String j() {
        return this.h;
    }

    @Override // defpackage.gn2
    public boolean k() {
        return true;
    }

    @Override // defpackage.gn2
    public String l() {
        return this.i;
    }

    public String toString() {
        return "GeneralServiceOption(streamingMode=" + e() + ", protocol=" + h() + ", httpMethod=" + g() + ", path=" + w() + ", isAsyncTask=" + f() + ", isSSE=" + a() + ", isService=" + v() + ", baseHttpUrl=" + j() + ", baseWebSocketUrl=" + l() + ")";
    }

    public Boolean v() {
        return this.g;
    }

    public String w() {
        return this.d;
    }
}
