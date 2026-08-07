package com.alibaba.dashscope.aigc.multimodalconversation;

import com.alibaba.dashscope.exception.InputRequiredException;
import defpackage.bz1;
import defpackage.gh2;
import defpackage.o61;
import defpackage.rl2;
import defpackage.t71;
import defpackage.yv0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends yv0 {
    protected Boolean A;
    protected Boolean B;
    protected Boolean C;
    private String D;
    private Boolean E;
    private Boolean F;
    private String G;
    private Integer H;
    private String I;
    private Boolean J;
    private Integer K;
    private List i;
    private Integer j;
    private Double k;
    private Integer l;
    private Float m;
    private Float n;
    private Boolean o;
    private Integer p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Float f211q;
    private Integer r;
    private Boolean s;
    private List t;
    private AudioParameters u;
    private OcrOptions v;
    private String w;
    private AudioParameters.Voice x;
    private List y;
    protected Object z;

    public static abstract class b extends yv0.a {
        private AudioParameters A;
        private OcrOptions B;
        private String C;
        private AudioParameters.Voice D;
        private List E;
        private Object F;
        private Boolean G;
        private Boolean H;
        private Boolean I;
        private String J;
        private Boolean K;
        private Boolean L;
        private String M;
        private Integer N;
        private String O;
        private Boolean P;
        private Integer Q;
        private ArrayList n;
        private Integer o;
        private Double p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private Integer f212q;
        private Float r;
        private Float s;
        private boolean t;
        private Boolean u;
        private Integer v;
        private Float w;
        private Integer x;
        private Boolean y;
        private List z;

        static /* synthetic */ gh2 H(b bVar) {
            bVar.getClass();
            return null;
        }

        static /* synthetic */ rl2 V(b bVar) {
            bVar.getClass();
            return null;
        }

        public abstract a X();

        public b Y(String str) {
            this.O = str;
            return l();
        }

        /* JADX INFO: renamed from: Z */
        protected abstract b l();

        public b a0(String str) {
            this.C = str;
            return l();
        }

        public b b0(AudioParameters.Voice voice) {
            this.D = voice;
            return l();
        }

        @Override // yv0.a, wv0.a
        public String toString() {
            return "MultiModalConversationParam.MultiModalConversationParamBuilder(super=" + super.toString() + ", messages=" + this.n + ", maxLength=" + this.o + ", topP=" + this.p + ", topK=" + this.f212q + ", repetitionPenalty=" + this.r + ", presencePenalty=" + this.s + ", enableSearch$value=" + this.u + ", searchOptions=" + ((Object) null) + ", seed=" + this.v + ", temperature=" + this.w + ", maxTokens=" + this.x + ", incrementalOutput=" + this.y + ", modalities=" + this.z + ", audio=" + this.A + ", ocrOptions=" + this.B + ", text=" + this.C + ", voice=" + this.D + ", tools=" + this.E + ", toolChoice=" + this.F + ", parallelToolCalls=" + this.G + ", vlHighResolutionImages=" + this.H + ", vlEnableImageHwOutput=" + this.I + ", responseFormat=" + ((Object) null) + ", negativePrompt=" + this.J + ", promptExtend=" + this.K + ", watermark=" + this.L + ", size=" + this.M + ", n=" + this.N + ", languageType=" + this.O + ", enableThinking=" + this.P + ", thinkingBudget=" + this.Q + ")";
        }
    }

    private static final class c extends b {
        private c() {
        }

        @Override // com.alibaba.dashscope.aigc.multimodalconversation.a.b
        public a X() {
            return new a(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // yv0.a
        /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public c q() {
            return this;
        }
    }

    protected a(b bVar) {
        super(bVar);
        int size = bVar.n == null ? 0 : bVar.n.size();
        this.i = size != 0 ? size != 1 ? Collections.unmodifiableList(new ArrayList(bVar.n)) : Collections.singletonList(bVar.n.get(0)) : Collections.emptyList();
        this.j = bVar.o;
        this.k = bVar.p;
        this.l = bVar.f212q;
        this.m = bVar.r;
        this.n = bVar.s;
        this.o = bVar.t ? bVar.u : r();
        b.V(bVar);
        this.p = bVar.v;
        this.f211q = bVar.w;
        this.r = bVar.x;
        this.s = bVar.y;
        this.t = bVar.z;
        this.u = bVar.A;
        this.v = bVar.B;
        this.w = bVar.C;
        this.x = bVar.D;
        this.y = bVar.E;
        this.z = bVar.F;
        this.A = bVar.G;
        this.B = bVar.H;
        this.C = bVar.I;
        b.H(bVar);
        this.D = bVar.J;
        this.E = bVar.K;
        this.F = bVar.L;
        this.G = bVar.M;
        this.H = bVar.N;
        this.I = bVar.O;
        this.J = bVar.P;
        this.K = bVar.Q;
    }

    private static Boolean r() {
        return Boolean.FALSE;
    }

    public static b s() {
        return new c();
    }

    public Integer A() {
        return this.r;
    }

    public List B() {
        return this.i;
    }

    public List C() {
        return this.t;
    }

    public Integer D() {
        return this.H;
    }

    public String E() {
        return this.D;
    }

    public OcrOptions F() {
        return this.v;
    }

    public Boolean G() {
        return this.A;
    }

    public Float H() {
        return this.n;
    }

    public Boolean I() {
        return this.E;
    }

    public Float J() {
        return this.m;
    }

    public gh2 K() {
        return null;
    }

    public rl2 L() {
        return null;
    }

    public Integer M() {
        return this.p;
    }

    public String N() {
        return this.G;
    }

    public Float O() {
        return this.f211q;
    }

    public String P() {
        return this.w;
    }

    public Integer Q() {
        return this.K;
    }

    public Object R() {
        return this.z;
    }

    public List S() {
        return this.y;
    }

    public Integer T() {
        return this.l;
    }

    public Double U() {
        return this.k;
    }

    public Boolean V() {
        return this.C;
    }

    public Boolean W() {
        return this.B;
    }

    public AudioParameters.Voice X() {
        return this.x;
    }

    public Boolean Y() {
        return this.F;
    }

    public void Z(Boolean bool) {
        this.s = bool;
    }

    @Override // defpackage.yv0, defpackage.wv0
    protected boolean c(Object obj) {
        return obj instanceof a;
    }

    @Override // defpackage.wv0
    public ByteBuffer e() {
        return null;
    }

    @Override // defpackage.yv0, defpackage.wv0
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.c(this) || !super.equals(obj)) {
            return false;
        }
        Integer numZ = z();
        Integer numZ2 = aVar.z();
        if (numZ != null ? !numZ.equals(numZ2) : numZ2 != null) {
            return false;
        }
        Double dU = U();
        Double dU2 = aVar.U();
        if (dU != null ? !dU.equals(dU2) : dU2 != null) {
            return false;
        }
        Integer numT = T();
        Integer numT2 = aVar.T();
        if (numT != null ? !numT.equals(numT2) : numT2 != null) {
            return false;
        }
        Float fJ = J();
        Float fJ2 = aVar.J();
        if (fJ != null ? !fJ.equals(fJ2) : fJ2 != null) {
            return false;
        }
        Float fH = H();
        Float fH2 = aVar.H();
        if (fH != null ? !fH.equals(fH2) : fH2 != null) {
            return false;
        }
        Boolean boolU = u();
        Boolean boolU2 = aVar.u();
        if (boolU != null ? !boolU.equals(boolU2) : boolU2 != null) {
            return false;
        }
        Integer numM = M();
        Integer numM2 = aVar.M();
        if (numM != null ? !numM.equals(numM2) : numM2 != null) {
            return false;
        }
        Float fO = O();
        Float fO2 = aVar.O();
        if (fO != null ? !fO.equals(fO2) : fO2 != null) {
            return false;
        }
        Integer numA = A();
        Integer numA2 = aVar.A();
        if (numA != null ? !numA.equals(numA2) : numA2 != null) {
            return false;
        }
        Boolean boolW = w();
        Boolean boolW2 = aVar.w();
        if (boolW != null ? !boolW.equals(boolW2) : boolW2 != null) {
            return false;
        }
        Boolean boolG = G();
        Boolean boolG2 = aVar.G();
        if (boolG != null ? !boolG.equals(boolG2) : boolG2 != null) {
            return false;
        }
        Boolean boolW3 = W();
        Boolean boolW4 = aVar.W();
        if (boolW3 != null ? !boolW3.equals(boolW4) : boolW4 != null) {
            return false;
        }
        Boolean boolV = V();
        Boolean boolV2 = aVar.V();
        if (boolV != null ? !boolV.equals(boolV2) : boolV2 != null) {
            return false;
        }
        Boolean boolI = I();
        Boolean boolI2 = aVar.I();
        if (boolI != null ? !boolI.equals(boolI2) : boolI2 != null) {
            return false;
        }
        Boolean boolY = Y();
        Boolean boolY2 = aVar.Y();
        if (boolY != null ? !boolY.equals(boolY2) : boolY2 != null) {
            return false;
        }
        Integer numD = D();
        Integer numD2 = aVar.D();
        if (numD != null ? !numD.equals(numD2) : numD2 != null) {
            return false;
        }
        Boolean boolV3 = v();
        Boolean boolV4 = aVar.v();
        if (boolV3 != null ? !boolV3.equals(boolV4) : boolV4 != null) {
            return false;
        }
        Integer numQ = Q();
        Integer numQ2 = aVar.Q();
        if (numQ != null ? !numQ.equals(numQ2) : numQ2 != null) {
            return false;
        }
        List listB = B();
        List listB2 = aVar.B();
        if (listB != null ? !listB.equals(listB2) : listB2 != null) {
            return false;
        }
        L();
        aVar.L();
        List listC = C();
        List listC2 = aVar.C();
        if (listC != null ? !listC.equals(listC2) : listC2 != null) {
            return false;
        }
        AudioParameters audioParametersT = t();
        AudioParameters audioParametersT2 = aVar.t();
        if (audioParametersT != null ? !audioParametersT.equals(audioParametersT2) : audioParametersT2 != null) {
            return false;
        }
        OcrOptions ocrOptionsF = F();
        OcrOptions ocrOptionsF2 = aVar.F();
        if (ocrOptionsF != null ? !ocrOptionsF.equals(ocrOptionsF2) : ocrOptionsF2 != null) {
            return false;
        }
        String strP = P();
        String strP2 = aVar.P();
        if (strP != null ? !strP.equals(strP2) : strP2 != null) {
            return false;
        }
        AudioParameters.Voice voiceX = X();
        AudioParameters.Voice voiceX2 = aVar.X();
        if (voiceX != null ? !voiceX.equals(voiceX2) : voiceX2 != null) {
            return false;
        }
        List listS = S();
        List listS2 = aVar.S();
        if (listS != null ? !listS.equals(listS2) : listS2 != null) {
            return false;
        }
        Object objR = R();
        Object objR2 = aVar.R();
        if (objR != null ? !objR.equals(objR2) : objR2 != null) {
            return false;
        }
        K();
        aVar.K();
        String strE = E();
        String strE2 = aVar.E();
        if (strE != null ? !strE.equals(strE2) : strE2 != null) {
            return false;
        }
        String strN = N();
        String strN2 = aVar.N();
        if (strN != null ? !strN.equals(strN2) : strN2 != null) {
            return false;
        }
        String strY = y();
        String strY2 = aVar.y();
        return strY != null ? strY.equals(strY2) : strY2 == null;
    }

    @Override // defpackage.wv0
    public o61 h() {
        o61 o61Var = new o61();
        o61Var.n("model", j());
        o61Var.j("input", i());
        Map mapK = k();
        if (mapK != null && !mapK.isEmpty()) {
            o61Var.j("parameters", t71.b(mapK));
        }
        return o61Var;
    }

    @Override // defpackage.yv0, defpackage.wv0
    public int hashCode() {
        int iHashCode = super.hashCode();
        Integer numZ = z();
        int iHashCode2 = (iHashCode * 59) + (numZ == null ? 43 : numZ.hashCode());
        Double dU = U();
        int iHashCode3 = (iHashCode2 * 59) + (dU == null ? 43 : dU.hashCode());
        Integer numT = T();
        int iHashCode4 = (iHashCode3 * 59) + (numT == null ? 43 : numT.hashCode());
        Float fJ = J();
        int iHashCode5 = (iHashCode4 * 59) + (fJ == null ? 43 : fJ.hashCode());
        Float fH = H();
        int iHashCode6 = (iHashCode5 * 59) + (fH == null ? 43 : fH.hashCode());
        Boolean boolU = u();
        int iHashCode7 = (iHashCode6 * 59) + (boolU == null ? 43 : boolU.hashCode());
        Integer numM = M();
        int iHashCode8 = (iHashCode7 * 59) + (numM == null ? 43 : numM.hashCode());
        Float fO = O();
        int iHashCode9 = (iHashCode8 * 59) + (fO == null ? 43 : fO.hashCode());
        Integer numA = A();
        int iHashCode10 = (iHashCode9 * 59) + (numA == null ? 43 : numA.hashCode());
        Boolean boolW = w();
        int iHashCode11 = (iHashCode10 * 59) + (boolW == null ? 43 : boolW.hashCode());
        Boolean boolG = G();
        int iHashCode12 = (iHashCode11 * 59) + (boolG == null ? 43 : boolG.hashCode());
        Boolean boolW2 = W();
        int iHashCode13 = (iHashCode12 * 59) + (boolW2 == null ? 43 : boolW2.hashCode());
        Boolean boolV = V();
        int iHashCode14 = (iHashCode13 * 59) + (boolV == null ? 43 : boolV.hashCode());
        Boolean boolI = I();
        int iHashCode15 = (iHashCode14 * 59) + (boolI == null ? 43 : boolI.hashCode());
        Boolean boolY = Y();
        int iHashCode16 = (iHashCode15 * 59) + (boolY == null ? 43 : boolY.hashCode());
        Integer numD = D();
        int iHashCode17 = (iHashCode16 * 59) + (numD == null ? 43 : numD.hashCode());
        Boolean boolV2 = v();
        int iHashCode18 = (iHashCode17 * 59) + (boolV2 == null ? 43 : boolV2.hashCode());
        Integer numQ = Q();
        int iHashCode19 = (iHashCode18 * 59) + (numQ == null ? 43 : numQ.hashCode());
        List listB = B();
        int i = iHashCode19 * 59;
        int iHashCode20 = listB == null ? 43 : listB.hashCode();
        L();
        int i2 = ((i + iHashCode20) * 59) + 43;
        List listC = C();
        int iHashCode21 = (i2 * 59) + (listC == null ? 43 : listC.hashCode());
        AudioParameters audioParametersT = t();
        int iHashCode22 = (iHashCode21 * 59) + (audioParametersT == null ? 43 : audioParametersT.hashCode());
        OcrOptions ocrOptionsF = F();
        int iHashCode23 = (iHashCode22 * 59) + (ocrOptionsF == null ? 43 : ocrOptionsF.hashCode());
        String strP = P();
        int iHashCode24 = (iHashCode23 * 59) + (strP == null ? 43 : strP.hashCode());
        AudioParameters.Voice voiceX = X();
        int iHashCode25 = (iHashCode24 * 59) + (voiceX == null ? 43 : voiceX.hashCode());
        List listS = S();
        int iHashCode26 = (iHashCode25 * 59) + (listS == null ? 43 : listS.hashCode());
        Object objR = R();
        int i3 = iHashCode26 * 59;
        int iHashCode27 = objR == null ? 43 : objR.hashCode();
        K();
        int i4 = ((i3 + iHashCode27) * 59) + 43;
        String strE = E();
        int iHashCode28 = (i4 * 59) + (strE == null ? 43 : strE.hashCode());
        String strN = N();
        int iHashCode29 = (iHashCode28 * 59) + (strN == null ? 43 : strN.hashCode());
        String strY = y();
        return (iHashCode29 * 59) + (strY != null ? strY.hashCode() : 43);
    }

    @Override // defpackage.yv0, defpackage.wv0
    public Map k() {
        HashMap map = new HashMap();
        Integer num = this.j;
        if (num != null) {
            map.put("max_length", num);
        }
        Integer num2 = this.r;
        if (num2 != null) {
            map.put("max_tokens", num2);
        }
        Double d = this.k;
        if (d != null) {
            map.put("top_p", d);
        }
        Integer num3 = this.l;
        if (num3 != null) {
            map.put("top_k", num3);
        }
        map.put("enable_search", this.o);
        Integer num4 = this.p;
        if (num4 != null) {
            map.put("seed", num4);
        }
        Float f = this.f211q;
        if (f != null) {
            map.put("temperature", f);
        }
        Float f2 = this.m;
        if (f2 != null) {
            map.put("repetition_penalty", f2);
        }
        Float f3 = this.n;
        if (f3 != null) {
            map.put("presence_penalty", f3);
        }
        if (bz1.a(j())) {
            Boolean bool = this.s;
            if (bool != null) {
                map.put("incremental_output", bool);
            }
        } else if (Boolean.TRUE.equals(this.s)) {
            map.put("incremental_output", this.s);
        }
        List list = this.t;
        if (list != null) {
            map.put("modalities", list);
        }
        AudioParameters audioParameters = this.u;
        if (audioParameters != null) {
            map.put("audio", audioParameters);
        }
        OcrOptions ocrOptions = this.v;
        if (ocrOptions != null) {
            map.put("ocr_options", ocrOptions);
        }
        List list2 = this.y;
        if (list2 != null && !list2.isEmpty()) {
            map.put("tools", this.y);
        }
        Object obj = this.z;
        if (obj != null) {
            if (obj instanceof String) {
                map.put("tool_choice", (String) obj);
            } else {
                map.put("tool_choice", t71.i(obj));
            }
        }
        Boolean bool2 = this.A;
        if (bool2 != null) {
            map.put("parallel_tool_calls", bool2);
        }
        Boolean bool3 = this.B;
        if (bool3 != null) {
            map.put("vl_high_resolution_images", bool3);
        }
        Boolean bool4 = this.C;
        if (bool4 != null) {
            map.put("vl_enable_image_hw_output", bool4);
        }
        String str = this.D;
        if (str != null) {
            map.put("negative_prompt", str);
        }
        Boolean bool5 = this.E;
        if (bool5 != null) {
            map.put("prompt_extend", bool5);
        }
        Boolean bool6 = this.F;
        if (bool6 != null) {
            map.put("watermark", bool6);
        }
        String str2 = this.G;
        if (str2 != null) {
            map.put("size", str2);
        }
        Integer num5 = this.H;
        if (num5 != null) {
            map.put("n", num5);
        }
        Boolean bool7 = this.J;
        if (bool7 != null) {
            map.put("enable_thinking", bool7);
        }
        Integer num6 = this.K;
        if (num6 != null) {
            map.put("thinking_budget", num6);
        }
        map.putAll(this.e);
        return map;
    }

    @Override // defpackage.wv0
    public void o() throws InputRequiredException {
        List list = this.i;
        if (list != null) {
            if (!list.isEmpty()) {
                return;
            }
            String str = this.w;
            if (str != null && !str.isEmpty()) {
                return;
            }
        }
        throw new InputRequiredException("Message or text must not null or empty!");
    }

    public AudioParameters t() {
        return this.u;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiModalConversationParam(messages=");
        sb.append(B());
        sb.append(", maxLength=");
        sb.append(z());
        sb.append(", topP=");
        sb.append(U());
        sb.append(", topK=");
        sb.append(T());
        sb.append(", repetitionPenalty=");
        sb.append(J());
        sb.append(", presencePenalty=");
        sb.append(H());
        sb.append(", enableSearch=");
        sb.append(u());
        sb.append(", searchOptions=");
        L();
        sb.append((Object) null);
        sb.append(", seed=");
        sb.append(M());
        sb.append(", temperature=");
        sb.append(O());
        sb.append(", maxTokens=");
        sb.append(A());
        sb.append(", incrementalOutput=");
        sb.append(w());
        sb.append(", modalities=");
        sb.append(C());
        sb.append(", audio=");
        sb.append(t());
        sb.append(", ocrOptions=");
        sb.append(F());
        sb.append(", text=");
        sb.append(P());
        sb.append(", voice=");
        sb.append(X());
        sb.append(", tools=");
        sb.append(S());
        sb.append(", toolChoice=");
        sb.append(R());
        sb.append(", parallelToolCalls=");
        sb.append(G());
        sb.append(", vlHighResolutionImages=");
        sb.append(W());
        sb.append(", vlEnableImageHwOutput=");
        sb.append(V());
        sb.append(", responseFormat=");
        K();
        sb.append((Object) null);
        sb.append(", negativePrompt=");
        sb.append(E());
        sb.append(", promptExtend=");
        sb.append(I());
        sb.append(", watermark=");
        sb.append(Y());
        sb.append(", size=");
        sb.append(N());
        sb.append(", n=");
        sb.append(D());
        sb.append(", languageType=");
        sb.append(y());
        sb.append(", enableThinking=");
        sb.append(v());
        sb.append(", thinkingBudget=");
        sb.append(Q());
        sb.append(")");
        return sb.toString();
    }

    public Boolean u() {
        return this.o;
    }

    public Boolean v() {
        return this.J;
    }

    public Boolean w() {
        return this.s;
    }

    @Override // defpackage.wv0
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public o61 i() {
        o61 o61Var = new o61();
        o61Var.j("messages", t71.g(this.i));
        String str = this.w;
        if (str != null) {
            o61Var.n("text", str);
        }
        AudioParameters.Voice voice = this.x;
        if (voice != null) {
            o61Var.n("voice", voice.getValue());
        }
        Map map = this.e;
        if (map != null && !map.isEmpty() && this.e.containsKey("voice")) {
            o61Var.n("voice", (String) this.e.get("voice"));
        }
        String str2 = this.I;
        if (str2 != null) {
            o61Var.n("language_type", str2);
        }
        return o61Var;
    }

    public String y() {
        return this.I;
    }

    public Integer z() {
        return this.j;
    }
}
