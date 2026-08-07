package defpackage;

import com.alibaba.dashscope.common.OutputMode;
import com.alibaba.dashscope.protocol.HttpMethod;
import com.alibaba.dashscope.protocol.Protocol;
import com.alibaba.dashscope.protocol.StreamingMode;
import com.jieli.jl_rcsp.constant.WatchConstant;

/* JADX INFO: loaded from: classes.dex */
public final class h8 implements gn2 {
    private StreamingMode a;
    private OutputMode b;
    private Protocol c;
    private HttpMethod d;
    private String e;
    private String f;
    private String g;
    private Boolean h;
    private Boolean i;
    private Boolean j;
    private String k;
    private String l;
    private boolean m;

    public static abstract class b {
        private boolean a;
        private StreamingMode b;
        private boolean c;
        private OutputMode d;
        private boolean e;
        private Protocol f;
        private boolean g;
        private HttpMethod h;
        private String i;
        private String j;
        private String k;
        private boolean l;
        private Boolean m;
        private boolean n;
        private Boolean o;
        private boolean p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private Boolean f344q;
        private boolean r;
        private String s;
        private boolean t;
        private String u;
        private boolean v;
        private boolean w;

        public b A(OutputMode outputMode) {
            this.d = outputMode;
            this.c = true;
            return C();
        }

        public b B(Protocol protocol) {
            this.f = protocol;
            this.e = true;
            return C();
        }

        protected abstract b C();

        public b D(StreamingMode streamingMode) {
            this.b = streamingMode;
            this.a = true;
            return C();
        }

        public b E(String str) {
            this.j = str;
            return C();
        }

        public b F(String str) {
            this.i = str;
            return C();
        }

        public String toString() {
            return "ApiServiceOption.ApiServiceOptionBuilder(streamingMode$value=" + this.b + ", outputMode$value=" + this.d + ", protocol$value=" + this.f + ", httpMethod$value=" + this.h + ", taskGroup=" + this.i + ", task=" + this.j + ", function=" + this.k + ", isAsyncTask$value=" + this.m + ", isSSE$value=" + this.o + ", isService$value=" + this.f344q + ", baseHttpUrl$value=" + this.s + ", baseWebSocketUrl$value=" + this.u + ", passTaskStarted$value=" + this.w + ")";
        }

        public abstract h8 x();

        public b y(String str) {
            this.k = str;
            return C();
        }

        public b z(HttpMethod httpMethod) {
            this.h = httpMethod;
            this.g = true;
            return C();
        }
    }

    private static final class c extends b {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // h8.b
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public c C() {
            return this;
        }

        @Override // h8.b
        public h8 x() {
            return new h8(this);
        }
    }

    protected h8(b bVar) {
        this.a = bVar.a ? bVar.b : v();
        this.b = bVar.c ? bVar.d : s();
        this.c = bVar.e ? bVar.f : u();
        this.d = bVar.g ? bVar.h : o();
        this.e = bVar.i;
        this.f = bVar.j;
        this.g = bVar.k;
        this.h = bVar.l ? bVar.m : p();
        this.i = bVar.n ? bVar.o : q();
        this.j = bVar.p ? bVar.f344q : r();
        this.k = bVar.r ? bVar.s : m();
        this.l = bVar.t ? bVar.u : n();
        this.m = bVar.v ? bVar.w : t();
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
        return Boolean.TRUE;
    }

    private static OutputMode s() {
        return OutputMode.ACCUMULATE;
    }

    private static boolean t() {
        return false;
    }

    private static Protocol u() {
        return Protocol.HTTP;
    }

    private static StreamingMode v() {
        return StreamingMode.NONE;
    }

    public static b w() {
        return new c();
    }

    public void A(Boolean bool) {
        this.i = bool;
    }

    public void B(StreamingMode streamingMode) {
        this.a = streamingMode;
    }

    @Override // defpackage.gn2
    public Boolean a() {
        return this.i;
    }

    @Override // defpackage.gn2
    public String b() {
        return this.g;
    }

    @Override // defpackage.gn2
    public String c() {
        return this.f;
    }

    @Override // defpackage.gn2
    public String d() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.j.booleanValue()) {
            stringBuffer.append("/services");
        }
        if (this.e != null) {
            stringBuffer.append(WatchConstant.FAT_FS_ROOT);
            stringBuffer.append(this.e);
        }
        if (this.f != null) {
            stringBuffer.append(WatchConstant.FAT_FS_ROOT);
            stringBuffer.append(this.f);
        }
        if (this.g != null) {
            stringBuffer.append(WatchConstant.FAT_FS_ROOT);
            stringBuffer.append(this.g);
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
        if (!(obj instanceof h8)) {
            return false;
        }
        h8 h8Var = (h8) obj;
        if (z() != h8Var.z()) {
            return false;
        }
        Boolean boolF = f();
        Boolean boolF2 = h8Var.f();
        if (boolF != null ? !boolF.equals(boolF2) : boolF2 != null) {
            return false;
        }
        Boolean boolA = a();
        Boolean boolA2 = h8Var.a();
        if (boolA != null ? !boolA.equals(boolA2) : boolA2 != null) {
            return false;
        }
        Boolean boolX = x();
        Boolean boolX2 = h8Var.x();
        if (boolX != null ? !boolX.equals(boolX2) : boolX2 != null) {
            return false;
        }
        StreamingMode streamingModeE = e();
        StreamingMode streamingModeE2 = h8Var.e();
        if (streamingModeE != null ? !streamingModeE.equals(streamingModeE2) : streamingModeE2 != null) {
            return false;
        }
        OutputMode outputModeY = y();
        OutputMode outputModeY2 = h8Var.y();
        if (outputModeY != null ? !outputModeY.equals(outputModeY2) : outputModeY2 != null) {
            return false;
        }
        Protocol protocolH = h();
        Protocol protocolH2 = h8Var.h();
        if (protocolH != null ? !protocolH.equals(protocolH2) : protocolH2 != null) {
            return false;
        }
        HttpMethod httpMethodG = g();
        HttpMethod httpMethodG2 = h8Var.g();
        if (httpMethodG != null ? !httpMethodG.equals(httpMethodG2) : httpMethodG2 != null) {
            return false;
        }
        String strI = i();
        String strI2 = h8Var.i();
        if (strI != null ? !strI.equals(strI2) : strI2 != null) {
            return false;
        }
        String strC = c();
        String strC2 = h8Var.c();
        if (strC != null ? !strC.equals(strC2) : strC2 != null) {
            return false;
        }
        String strB = b();
        String strB2 = h8Var.b();
        if (strB != null ? !strB.equals(strB2) : strB2 != null) {
            return false;
        }
        String strJ = j();
        String strJ2 = h8Var.j();
        if (strJ != null ? !strJ.equals(strJ2) : strJ2 != null) {
            return false;
        }
        String strL = l();
        String strL2 = h8Var.l();
        return strL != null ? strL.equals(strL2) : strL2 == null;
    }

    @Override // defpackage.gn2
    public Boolean f() {
        return this.h;
    }

    @Override // defpackage.gn2
    public HttpMethod g() {
        return this.d;
    }

    @Override // defpackage.gn2
    public Protocol h() {
        return this.c;
    }

    public int hashCode() {
        int i = z() ? 79 : 97;
        Boolean boolF = f();
        int iHashCode = ((i + 59) * 59) + (boolF == null ? 43 : boolF.hashCode());
        Boolean boolA = a();
        int iHashCode2 = (iHashCode * 59) + (boolA == null ? 43 : boolA.hashCode());
        Boolean boolX = x();
        int iHashCode3 = (iHashCode2 * 59) + (boolX == null ? 43 : boolX.hashCode());
        StreamingMode streamingModeE = e();
        int iHashCode4 = (iHashCode3 * 59) + (streamingModeE == null ? 43 : streamingModeE.hashCode());
        OutputMode outputModeY = y();
        int iHashCode5 = (iHashCode4 * 59) + (outputModeY == null ? 43 : outputModeY.hashCode());
        Protocol protocolH = h();
        int iHashCode6 = (iHashCode5 * 59) + (protocolH == null ? 43 : protocolH.hashCode());
        HttpMethod httpMethodG = g();
        int iHashCode7 = (iHashCode6 * 59) + (httpMethodG == null ? 43 : httpMethodG.hashCode());
        String strI = i();
        int iHashCode8 = (iHashCode7 * 59) + (strI == null ? 43 : strI.hashCode());
        String strC = c();
        int iHashCode9 = (iHashCode8 * 59) + (strC == null ? 43 : strC.hashCode());
        String strB = b();
        int iHashCode10 = (iHashCode9 * 59) + (strB == null ? 43 : strB.hashCode());
        String strJ = j();
        int iHashCode11 = (iHashCode10 * 59) + (strJ == null ? 43 : strJ.hashCode());
        String strL = l();
        return (iHashCode11 * 59) + (strL != null ? strL.hashCode() : 43);
    }

    @Override // defpackage.gn2
    public String i() {
        return this.e;
    }

    @Override // defpackage.gn2
    public String j() {
        return this.k;
    }

    @Override // defpackage.gn2
    public String l() {
        return this.l;
    }

    public String toString() {
        return "ApiServiceOption(streamingMode=" + e() + ", outputMode=" + y() + ", protocol=" + h() + ", httpMethod=" + g() + ", taskGroup=" + i() + ", task=" + c() + ", function=" + b() + ", isAsyncTask=" + f() + ", isSSE=" + a() + ", isService=" + x() + ", baseHttpUrl=" + j() + ", baseWebSocketUrl=" + l() + ", passTaskStarted=" + z() + ")";
    }

    public Boolean x() {
        return this.j;
    }

    public OutputMode y() {
        return this.b;
    }

    public boolean z() {
        return this.m;
    }
}
