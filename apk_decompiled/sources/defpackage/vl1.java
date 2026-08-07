package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class vl1 {
    private String a;
    private List b;
    private List c;

    @xm2("name")
    String name;

    @xm2("reasoning_content")
    String reasoningContent;

    @xm2("tool_call_id")
    String toolCallId;

    @xm2("tool_calls")
    List<t33> toolCalls;

    protected boolean a(Object obj) {
        return obj instanceof vl1;
    }

    public List b() {
        return this.c;
    }

    public List c() {
        return this.b;
    }

    public String d() {
        return this.name;
    }

    public String e() {
        return this.reasoningContent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof vl1)) {
            return false;
        }
        vl1 vl1Var = (vl1) obj;
        if (!vl1Var.a(this)) {
            return false;
        }
        String strF = f();
        String strF2 = vl1Var.f();
        if (strF != null ? !strF.equals(strF2) : strF2 != null) {
            return false;
        }
        List listC = c();
        List listC2 = vl1Var.c();
        if (listC != null ? !listC.equals(listC2) : listC2 != null) {
            return false;
        }
        List listH = h();
        List listH2 = vl1Var.h();
        if (listH != null ? !listH.equals(listH2) : listH2 != null) {
            return false;
        }
        String strG = g();
        String strG2 = vl1Var.g();
        if (strG != null ? !strG.equals(strG2) : strG2 != null) {
            return false;
        }
        String strD = d();
        String strD2 = vl1Var.d();
        if (strD != null ? !strD.equals(strD2) : strD2 != null) {
            return false;
        }
        String strE = e();
        String strE2 = vl1Var.e();
        if (strE != null ? !strE.equals(strE2) : strE2 != null) {
            return false;
        }
        List listB = b();
        List listB2 = vl1Var.b();
        return listB != null ? listB.equals(listB2) : listB2 == null;
    }

    public String f() {
        return this.a;
    }

    public String g() {
        return this.toolCallId;
    }

    public List h() {
        return this.toolCalls;
    }

    public int hashCode() {
        String strF = f();
        int iHashCode = strF == null ? 43 : strF.hashCode();
        List listC = c();
        int iHashCode2 = ((iHashCode + 59) * 59) + (listC == null ? 43 : listC.hashCode());
        List listH = h();
        int iHashCode3 = (iHashCode2 * 59) + (listH == null ? 43 : listH.hashCode());
        String strG = g();
        int iHashCode4 = (iHashCode3 * 59) + (strG == null ? 43 : strG.hashCode());
        String strD = d();
        int iHashCode5 = (iHashCode4 * 59) + (strD == null ? 43 : strD.hashCode());
        String strE = e();
        int iHashCode6 = (iHashCode5 * 59) + (strE == null ? 43 : strE.hashCode());
        List listB = b();
        return (iHashCode6 * 59) + (listB != null ? listB.hashCode() : 43);
    }

    public void i(List list) {
        this.c = list;
    }

    public void j(List list) {
        this.b = list;
    }

    public void k(String str) {
        this.name = str;
    }

    public void l(String str) {
        this.reasoningContent = str;
    }

    public void m(String str) {
        this.a = str;
    }

    public void n(String str) {
        this.toolCallId = str;
    }

    public void o(List list) {
        this.toolCalls = list;
    }

    public String toString() {
        return "MultiModalMessage(role=" + f() + ", content=" + c() + ", toolCalls=" + h() + ", toolCallId=" + g() + ", name=" + d() + ", reasoningContent=" + e() + ", annotations=" + b() + ")";
    }
}
