package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ql1 {
    String a;
    List b;

    protected boolean a(Object obj) {
        return obj instanceof ql1;
    }

    public List b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public void d(List list) {
        this.b = list;
    }

    public void e(String str) {
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ql1)) {
            return false;
        }
        ql1 ql1Var = (ql1) obj;
        if (!ql1Var.a(this)) {
            return false;
        }
        String strC = c();
        String strC2 = ql1Var.c();
        if (strC != null ? !strC.equals(strC2) : strC2 != null) {
            return false;
        }
        List listB = b();
        List listB2 = ql1Var.b();
        return listB != null ? listB.equals(listB2) : listB2 == null;
    }

    public int hashCode() {
        String strC = c();
        int iHashCode = strC == null ? 43 : strC.hashCode();
        List listB = b();
        return ((iHashCode + 59) * 59) + (listB != null ? listB.hashCode() : 43);
    }

    public String toString() {
        return "MultiModalConversationMessage(role=" + c() + ", content=" + b() + ")";
    }
}
