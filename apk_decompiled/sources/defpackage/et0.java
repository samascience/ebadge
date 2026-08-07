package defpackage;

import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.InputRequiredException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class et0 extends ft0 {
    private Boolean A;
    private Integer B;
    private Integer C;
    private List k;
    private Integer l;
    private Double m;
    private Integer n;
    private Boolean o;
    private Integer p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Float f327q;
    private Boolean r;

    @xm2("result_format")
    private String resultFormat;
    private Integer s;
    private Float t;

    @xm2("tool_choice")
    protected Object toolChoice;
    private List u;
    private List v;
    private List w;
    protected Boolean x;
    private Boolean y;
    private Integer z;

    public static abstract class b extends ft0.a {
        private Integer A;
        private Float B;
        private ArrayList C;
        private ArrayList D;
        private List E;
        private Object F;
        private Boolean G;
        private Boolean H;
        private Integer I;
        private Boolean J;
        private Integer K;
        private Integer L;
        private List p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private Integer f328q;
        private Double r;
        private Integer s;
        private boolean t;
        private Boolean u;
        private Integer v;
        private boolean w;
        private String x;
        private Float y;
        private Boolean z;

        static /* synthetic */ rl2 D(b bVar) {
            bVar.getClass();
            return null;
        }

        static /* synthetic */ gh2 E(b bVar) {
            bVar.getClass();
            return null;
        }

        static /* synthetic */ w53 L(b bVar) {
            bVar.getClass();
            return null;
        }

        public abstract et0 T();

        public b U(List list) {
            this.p = list;
            return q();
        }

        public b V(String str) {
            this.x = str;
            this.w = true;
            return q();
        }

        /* JADX INFO: renamed from: W */
        protected abstract b q();

        @Override // ft0.a, yv0.a, wv0.a
        public String toString() {
            return "GenerationParam.GenerationParamBuilder(super=" + super.toString() + ", messages=" + this.p + ", maxLength=" + this.f328q + ", topP=" + this.r + ", topK=" + this.s + ", enableSearch$value=" + this.u + ", seed=" + this.v + ", resultFormat$value=" + this.x + ", temperature=" + this.y + ", incrementalOutput=" + this.z + ", maxTokens=" + this.A + ", repetitionPenalty=" + this.B + ", stopStrings=" + this.C + ", stopTokens=" + this.D + ", tools=" + this.E + ", toolChoice=" + this.F + ", parallelToolCalls=" + this.G + ", searchOptions=" + ((Object) null) + ", responseFormat=" + ((Object) null) + ", enableThinking=" + this.H + ", thinkingBudget=" + this.I + ", logprobs=" + this.J + ", topLogprobs=" + this.K + ", n=" + this.L + ", translationOptions=" + ((Object) null) + ")";
        }
    }

    private static final class c extends b {
        private c() {
        }

        @Override // et0.b
        public et0 T() {
            return new et0(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // yv0.a
        /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public c q() {
            return this;
        }
    }

    public static class d {
        public static String a = "text";
        public static String b = "message";
    }

    protected et0(b bVar) {
        super(bVar);
        this.k = bVar.p;
        this.l = bVar.f328q;
        this.m = bVar.r;
        this.n = bVar.s;
        this.o = bVar.t ? bVar.u : u();
        this.p = bVar.v;
        this.resultFormat = bVar.w ? bVar.x : v();
        this.f327q = bVar.y;
        this.r = bVar.z;
        this.s = bVar.A;
        this.t = bVar.B;
        int size = bVar.C == null ? 0 : bVar.C.size();
        this.u = size != 0 ? size != 1 ? Collections.unmodifiableList(new ArrayList(bVar.C)) : Collections.singletonList(bVar.C.get(0)) : Collections.emptyList();
        int size2 = bVar.D == null ? 0 : bVar.D.size();
        this.v = size2 != 0 ? size2 != 1 ? Collections.unmodifiableList(new ArrayList(bVar.D)) : Collections.singletonList(bVar.D.get(0)) : Collections.emptyList();
        this.w = bVar.E;
        this.toolChoice = bVar.F;
        this.x = bVar.G;
        b.D(bVar);
        b.E(bVar);
        this.y = bVar.H;
        this.z = bVar.I;
        this.A = bVar.J;
        this.B = bVar.K;
        this.C = bVar.L;
        b.L(bVar);
    }

    private static Boolean u() {
        return Boolean.FALSE;
    }

    private static String v() {
        return d.a;
    }

    public static b w() {
        return new c();
    }

    public Boolean A() {
        return this.A;
    }

    public Integer B() {
        return this.l;
    }

    public Integer C() {
        return this.s;
    }

    public List D() {
        return this.k;
    }

    public Integer E() {
        return this.C;
    }

    public Boolean F() {
        return this.x;
    }

    public Float G() {
        return this.t;
    }

    public gh2 H() {
        return null;
    }

    public String I() {
        return this.resultFormat;
    }

    public rl2 J() {
        return null;
    }

    public Integer K() {
        return this.p;
    }

    public List L() {
        return this.u;
    }

    public List M() {
        return this.v;
    }

    public Float N() {
        return this.f327q;
    }

    public Integer O() {
        return this.z;
    }

    public Object P() {
        return this.toolChoice;
    }

    public List Q() {
        return this.w;
    }

    public Integer R() {
        return this.n;
    }

    public Integer S() {
        return this.B;
    }

    public Double T() {
        return this.m;
    }

    public w53 U() {
        return null;
    }

    @Override // defpackage.ft0, defpackage.yv0, defpackage.wv0
    protected boolean c(Object obj) {
        return obj instanceof et0;
    }

    @Override // defpackage.ft0, defpackage.yv0, defpackage.wv0
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof et0)) {
            return false;
        }
        et0 et0Var = (et0) obj;
        if (!et0Var.c(this) || !super.equals(obj)) {
            return false;
        }
        Integer numB = B();
        Integer numB2 = et0Var.B();
        if (numB != null ? !numB.equals(numB2) : numB2 != null) {
            return false;
        }
        Double dT = T();
        Double dT2 = et0Var.T();
        if (dT != null ? !dT.equals(dT2) : dT2 != null) {
            return false;
        }
        Integer numR = R();
        Integer numR2 = et0Var.R();
        if (numR != null ? !numR.equals(numR2) : numR2 != null) {
            return false;
        }
        Boolean boolX = x();
        Boolean boolX2 = et0Var.x();
        if (boolX != null ? !boolX.equals(boolX2) : boolX2 != null) {
            return false;
        }
        Integer numK = K();
        Integer numK2 = et0Var.K();
        if (numK != null ? !numK.equals(numK2) : numK2 != null) {
            return false;
        }
        Float fN = N();
        Float fN2 = et0Var.N();
        if (fN != null ? !fN.equals(fN2) : fN2 != null) {
            return false;
        }
        Boolean boolZ = z();
        Boolean boolZ2 = et0Var.z();
        if (boolZ != null ? !boolZ.equals(boolZ2) : boolZ2 != null) {
            return false;
        }
        Integer numC = C();
        Integer numC2 = et0Var.C();
        if (numC != null ? !numC.equals(numC2) : numC2 != null) {
            return false;
        }
        Float fG = G();
        Float fG2 = et0Var.G();
        if (fG != null ? !fG.equals(fG2) : fG2 != null) {
            return false;
        }
        Boolean boolF = F();
        Boolean boolF2 = et0Var.F();
        if (boolF != null ? !boolF.equals(boolF2) : boolF2 != null) {
            return false;
        }
        Boolean boolY = y();
        Boolean boolY2 = et0Var.y();
        if (boolY != null ? !boolY.equals(boolY2) : boolY2 != null) {
            return false;
        }
        Integer numO = O();
        Integer numO2 = et0Var.O();
        if (numO != null ? !numO.equals(numO2) : numO2 != null) {
            return false;
        }
        Boolean boolA = A();
        Boolean boolA2 = et0Var.A();
        if (boolA != null ? !boolA.equals(boolA2) : boolA2 != null) {
            return false;
        }
        Integer numS = S();
        Integer numS2 = et0Var.S();
        if (numS != null ? !numS.equals(numS2) : numS2 != null) {
            return false;
        }
        Integer numE = E();
        Integer numE2 = et0Var.E();
        if (numE != null ? !numE.equals(numE2) : numE2 != null) {
            return false;
        }
        List listD = D();
        List listD2 = et0Var.D();
        if (listD != null ? !listD.equals(listD2) : listD2 != null) {
            return false;
        }
        String strI = I();
        String strI2 = et0Var.I();
        if (strI != null ? !strI.equals(strI2) : strI2 != null) {
            return false;
        }
        List listL = L();
        List listL2 = et0Var.L();
        if (listL != null ? !listL.equals(listL2) : listL2 != null) {
            return false;
        }
        List listM = M();
        List listM2 = et0Var.M();
        if (listM != null ? !listM.equals(listM2) : listM2 != null) {
            return false;
        }
        List listQ = Q();
        List listQ2 = et0Var.Q();
        if (listQ != null ? !listQ.equals(listQ2) : listQ2 != null) {
            return false;
        }
        Object objP = P();
        Object objP2 = et0Var.P();
        if (objP != null ? !objP.equals(objP2) : objP2 != null) {
            return false;
        }
        J();
        et0Var.J();
        H();
        et0Var.H();
        U();
        et0Var.U();
        return true;
    }

    @Override // defpackage.ft0, defpackage.yv0, defpackage.wv0
    public int hashCode() {
        int iHashCode = super.hashCode();
        Integer numB = B();
        int iHashCode2 = (iHashCode * 59) + (numB == null ? 43 : numB.hashCode());
        Double dT = T();
        int iHashCode3 = (iHashCode2 * 59) + (dT == null ? 43 : dT.hashCode());
        Integer numR = R();
        int iHashCode4 = (iHashCode3 * 59) + (numR == null ? 43 : numR.hashCode());
        Boolean boolX = x();
        int iHashCode5 = (iHashCode4 * 59) + (boolX == null ? 43 : boolX.hashCode());
        Integer numK = K();
        int iHashCode6 = (iHashCode5 * 59) + (numK == null ? 43 : numK.hashCode());
        Float fN = N();
        int iHashCode7 = (iHashCode6 * 59) + (fN == null ? 43 : fN.hashCode());
        Boolean boolZ = z();
        int iHashCode8 = (iHashCode7 * 59) + (boolZ == null ? 43 : boolZ.hashCode());
        Integer numC = C();
        int iHashCode9 = (iHashCode8 * 59) + (numC == null ? 43 : numC.hashCode());
        Float fG = G();
        int iHashCode10 = (iHashCode9 * 59) + (fG == null ? 43 : fG.hashCode());
        Boolean boolF = F();
        int iHashCode11 = (iHashCode10 * 59) + (boolF == null ? 43 : boolF.hashCode());
        Boolean boolY = y();
        int iHashCode12 = (iHashCode11 * 59) + (boolY == null ? 43 : boolY.hashCode());
        Integer numO = O();
        int iHashCode13 = (iHashCode12 * 59) + (numO == null ? 43 : numO.hashCode());
        Boolean boolA = A();
        int iHashCode14 = (iHashCode13 * 59) + (boolA == null ? 43 : boolA.hashCode());
        Integer numS = S();
        int iHashCode15 = (iHashCode14 * 59) + (numS == null ? 43 : numS.hashCode());
        Integer numE = E();
        int iHashCode16 = (iHashCode15 * 59) + (numE == null ? 43 : numE.hashCode());
        List listD = D();
        int iHashCode17 = (iHashCode16 * 59) + (listD == null ? 43 : listD.hashCode());
        String strI = I();
        int iHashCode18 = (iHashCode17 * 59) + (strI == null ? 43 : strI.hashCode());
        List listL = L();
        int iHashCode19 = (iHashCode18 * 59) + (listL == null ? 43 : listL.hashCode());
        List listM = M();
        int iHashCode20 = (iHashCode19 * 59) + (listM == null ? 43 : listM.hashCode());
        List listQ = Q();
        int iHashCode21 = (iHashCode20 * 59) + (listQ == null ? 43 : listQ.hashCode());
        Object objP = P();
        int i = iHashCode21 * 59;
        int iHashCode22 = objP == null ? 43 : objP.hashCode();
        J();
        H();
        U();
        return ((((((i + iHashCode22) * 59) + 43) * 59) + 43) * 59) + 43;
    }

    @Override // defpackage.yv0, defpackage.wv0
    public Map k() {
        HashMap map = new HashMap();
        Integer num = this.l;
        if (num != null) {
            map.put("max_length", num);
        }
        Double d2 = this.m;
        if (d2 != null) {
            map.put("top_p", d2);
        }
        Integer num2 = this.n;
        if (num2 != null) {
            map.put("top_k", num2);
        }
        if (this.o.booleanValue()) {
            map.put("enable_search", this.o);
        }
        if (d.b.equals(I())) {
            map.put("result_format", I());
        }
        Integer num3 = this.p;
        if (num3 != null) {
            map.put("seed", num3);
        }
        Float f = this.f327q;
        if (f != null) {
            map.put("temperature", f);
        }
        if (bz1.a(j())) {
            Boolean bool = this.r;
            if (bool != null) {
                map.put("incremental_output", bool);
            }
        } else if (Boolean.TRUE.equals(this.r)) {
            map.put("incremental_output", this.r);
        }
        Float f2 = this.t;
        if (f2 != null) {
            map.put("repetition_penalty", f2);
        }
        Integer num4 = this.s;
        if (num4 != null) {
            map.put("max_tokens", num4);
        }
        List list = this.u;
        if (list == null || list.isEmpty()) {
            List list2 = this.v;
            if (list2 != null && !list2.isEmpty()) {
                map.put("stop", this.v);
            }
        } else {
            map.put("stop", this.u);
        }
        List list3 = this.w;
        if (list3 != null && !list3.isEmpty()) {
            map.put("tools", this.w);
        }
        Object obj = this.toolChoice;
        if (obj != null) {
            if (obj instanceof String) {
                map.put("tool_choice", (String) obj);
            } else {
                map.put("tool_choice", t71.i(obj));
            }
        }
        Boolean bool2 = this.x;
        if (bool2 != null) {
            map.put("parallel_tool_calls", bool2);
        }
        Boolean bool3 = this.y;
        if (bool3 != null) {
            map.put("enable_thinking", bool3);
        }
        Integer num5 = this.z;
        if (num5 != null) {
            map.put("thinking_budget", num5);
        }
        Boolean bool4 = this.A;
        if (bool4 != null) {
            map.put("logprobs", bool4);
        }
        Integer num6 = this.B;
        if (num6 != null) {
            map.put("top_logprobs", num6);
        }
        Integer num7 = this.C;
        if (num7 != null) {
            map.put("n", num7);
        }
        map.putAll(this.e);
        return map;
    }

    @Override // defpackage.wv0
    public void o() throws InputRequiredException {
        if (t() == null) {
            if (r() == null || r().isEmpty()) {
                if (D() == null || D().isEmpty()) {
                    throw new InputRequiredException("messages and prompt must not all null");
                }
            }
        }
    }

    @Override // defpackage.wv0
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public o61 i() {
        o61 o61Var = new o61();
        l51 l51Var = new l51();
        if (D() != null && !D().isEmpty()) {
            l51Var.k(t71.g(D()));
            if (t() != null) {
                l51Var.j(t71.h(xi1.a().k(Role.USER.getValue()).j(t()).i()));
            }
            o61Var.j("messages", l51Var);
        } else if (r() != null && !r().isEmpty()) {
            o61Var.j("history", t71.h(r()).b());
            if (t() != null) {
                o61Var.n("prompt", t());
            }
        } else if (t() != null) {
            o61Var.n("prompt", t());
        }
        return o61Var;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GenerationParam(messages=");
        sb.append(D());
        sb.append(", maxLength=");
        sb.append(B());
        sb.append(", topP=");
        sb.append(T());
        sb.append(", topK=");
        sb.append(R());
        sb.append(", enableSearch=");
        sb.append(x());
        sb.append(", seed=");
        sb.append(K());
        sb.append(", resultFormat=");
        sb.append(I());
        sb.append(", temperature=");
        sb.append(N());
        sb.append(", incrementalOutput=");
        sb.append(z());
        sb.append(", maxTokens=");
        sb.append(C());
        sb.append(", repetitionPenalty=");
        sb.append(G());
        sb.append(", stopStrings=");
        sb.append(L());
        sb.append(", stopTokens=");
        sb.append(M());
        sb.append(", tools=");
        sb.append(Q());
        sb.append(", toolChoice=");
        sb.append(P());
        sb.append(", parallelToolCalls=");
        sb.append(F());
        sb.append(", searchOptions=");
        J();
        sb.append((Object) null);
        sb.append(", responseFormat=");
        H();
        sb.append((Object) null);
        sb.append(", enableThinking=");
        sb.append(y());
        sb.append(", thinkingBudget=");
        sb.append(O());
        sb.append(", logprobs=");
        sb.append(A());
        sb.append(", topLogprobs=");
        sb.append(S());
        sb.append(", n=");
        sb.append(E());
        sb.append(", translationOptions=");
        U();
        sb.append((Object) null);
        sb.append(")");
        return sb.toString();
    }

    public Boolean x() {
        return this.o;
    }

    public Boolean y() {
        return this.y;
    }

    public Boolean z() {
        return this.r;
    }
}
