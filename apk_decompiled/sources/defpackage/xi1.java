package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class xi1 {
    String a;
    String b;
    private List c;

    @xm2("name")
    String name;

    @xm2("partial")
    Boolean partial;

    @xm2("reasoning_content")
    String reasoningContent;

    @xm2("tool_call_id")
    String toolCallId;

    @xm2("tool_calls")
    List<t33> toolCalls;

    public static abstract class b {
        private String a;
        private String b;
        private List c;
        private String d;
        private String e;
        private List f;
        private String g;
        private Boolean h;

        public abstract xi1 i();

        public b j(String str) {
            this.b = str;
            return l();
        }

        public b k(String str) {
            this.a = str;
            return l();
        }

        protected abstract b l();

        public String toString() {
            return "Message.MessageBuilder(role=" + this.a + ", content=" + this.b + ", toolCalls=" + this.c + ", toolCallId=" + this.d + ", name=" + this.e + ", contents=" + this.f + ", reasoningContent=" + this.g + ", partial=" + this.h + ")";
        }
    }

    private static final class c extends b {
        private c() {
        }

        @Override // xi1.b
        public xi1 i() {
            return new xi1(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // xi1.b
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public c l() {
            return this;
        }
    }

    protected xi1(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.toolCalls = bVar.c;
        this.toolCallId = bVar.d;
        this.name = bVar.e;
        this.c = bVar.f;
        this.reasoningContent = bVar.g;
        this.partial = bVar.h;
    }

    public static b a() {
        return new c();
    }

    protected boolean b(Object obj) {
        return obj instanceof xi1;
    }

    public String c() {
        return this.b;
    }

    public List d() {
        return this.c;
    }

    public String e() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof xi1)) {
            return false;
        }
        xi1 xi1Var = (xi1) obj;
        if (!xi1Var.b(this)) {
            return false;
        }
        Boolean boolF = f();
        Boolean boolF2 = xi1Var.f();
        if (boolF != null ? !boolF.equals(boolF2) : boolF2 != null) {
            return false;
        }
        String strH = h();
        String strH2 = xi1Var.h();
        if (strH != null ? !strH.equals(strH2) : strH2 != null) {
            return false;
        }
        String strC = c();
        String strC2 = xi1Var.c();
        if (strC != null ? !strC.equals(strC2) : strC2 != null) {
            return false;
        }
        List listJ = j();
        List listJ2 = xi1Var.j();
        if (listJ != null ? !listJ.equals(listJ2) : listJ2 != null) {
            return false;
        }
        String strI = i();
        String strI2 = xi1Var.i();
        if (strI != null ? !strI.equals(strI2) : strI2 != null) {
            return false;
        }
        String strE = e();
        String strE2 = xi1Var.e();
        if (strE != null ? !strE.equals(strE2) : strE2 != null) {
            return false;
        }
        List listD = d();
        List listD2 = xi1Var.d();
        if (listD != null ? !listD.equals(listD2) : listD2 != null) {
            return false;
        }
        String strG = g();
        String strG2 = xi1Var.g();
        return strG != null ? strG.equals(strG2) : strG2 == null;
    }

    public Boolean f() {
        return this.partial;
    }

    public String g() {
        return this.reasoningContent;
    }

    public String h() {
        return this.a;
    }

    public int hashCode() {
        Boolean boolF = f();
        int iHashCode = boolF == null ? 43 : boolF.hashCode();
        String strH = h();
        int iHashCode2 = ((iHashCode + 59) * 59) + (strH == null ? 43 : strH.hashCode());
        String strC = c();
        int iHashCode3 = (iHashCode2 * 59) + (strC == null ? 43 : strC.hashCode());
        List listJ = j();
        int iHashCode4 = (iHashCode3 * 59) + (listJ == null ? 43 : listJ.hashCode());
        String strI = i();
        int iHashCode5 = (iHashCode4 * 59) + (strI == null ? 43 : strI.hashCode());
        String strE = e();
        int iHashCode6 = (iHashCode5 * 59) + (strE == null ? 43 : strE.hashCode());
        List listD = d();
        int iHashCode7 = (iHashCode6 * 59) + (listD == null ? 43 : listD.hashCode());
        String strG = g();
        return (iHashCode7 * 59) + (strG != null ? strG.hashCode() : 43);
    }

    public String i() {
        return this.toolCallId;
    }

    public List j() {
        return this.toolCalls;
    }

    public void k(String str) {
        this.b = str;
    }

    public void l(List list) {
        this.c = list;
    }

    public void m(String str) {
        this.reasoningContent = str;
    }

    public void n(String str) {
        this.a = str;
    }

    public String toString() {
        return "Message(role=" + h() + ", content=" + c() + ", toolCalls=" + j() + ", toolCallId=" + i() + ", name=" + e() + ", contents=" + d() + ", reasoningContent=" + g() + ", partial=" + f() + ")";
    }

    public xi1() {
    }
}
