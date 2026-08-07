package defpackage;

import com.alibaba.dashscope.protocol.Protocol;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public class u50 extends lh2 {
    private Object g;
    private String h;

    @Override // defpackage.lh2
    protected boolean a(Object obj) {
        return obj instanceof u50;
    }

    @Override // defpackage.lh2
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u50)) {
            return false;
        }
        u50 u50Var = (u50) obj;
        if (!u50Var.a(this) || !super.equals(obj)) {
            return false;
        }
        Object objQ = q();
        Object objQ2 = u50Var.q();
        if (objQ != null ? !objQ.equals(objQ2) : objQ2 != null) {
            return false;
        }
        String strP = p();
        String strP2 = u50Var.p();
        return strP != null ? strP.equals(strP2) : strP2 == null;
    }

    @Override // defpackage.lh2
    public int hashCode() {
        int iHashCode = super.hashCode();
        Object objQ = q();
        int iHashCode2 = (iHashCode * 59) + (objQ == null ? 43 : objQ.hashCode());
        String strP = p();
        return (iHashCode2 * 59) + (strP != null ? strP.hashCode() : 43);
    }

    protected lh2 m(Protocol protocol, sq1 sq1Var) {
        Protocol protocol2 = Protocol.WEBSOCKET;
        String strE = Constants.STR_EMPTY;
        if (protocol != protocol2) {
            o61 o61VarC = t71.c(sq1Var.i());
            if (sq1Var.h() != null) {
                k(sq1Var.h());
            }
            if (o61VarC.r("output")) {
                this.g = o61VarC.p("output").g() ? null : o61VarC.p("output").c();
            }
            if (o61VarC.r("usage")) {
                l(o61VarC.p("usage").g() ? null : o61VarC.p("usage").c());
            }
            if (o61VarC.r("request_id")) {
                j(o61VarC.p("request_id").e());
            }
            if (o61VarC.r("status_code")) {
                k(o61VarC.p("status_code").g() ? null : Integer.valueOf(o61VarC.p("status_code").a()));
            }
            if (o61VarC.r("code")) {
                h(o61VarC.p("code").g() ? Constants.STR_EMPTY : o61VarC.p("code").e());
            } else {
                h(Constants.STR_EMPTY);
            }
            if (o61VarC.r("message")) {
                if (!o61VarC.p("message").g()) {
                    strE = o61VarC.p("message").e();
                }
                i(strE);
            } else {
                i(Constants.STR_EMPTY);
            }
            if (o61VarC.r("data")) {
                if (o61VarC.r("request_id")) {
                    o61VarC.s("request_id");
                }
                this.g = o61VarC;
            }
        } else if (sq1Var.e() == null) {
            o61 o61VarC2 = t71.c(sq1Var.i());
            if (o61VarC2.r("header")) {
                o61 o61VarC3 = o61VarC2.p("header").c();
                if (o61VarC3.r("task_id")) {
                    j(o61VarC3.p("task_id").e());
                }
                if (o61VarC3.r("status_code")) {
                    k(o61VarC3.p("status_code").g() ? null : Integer.valueOf(o61VarC3.p("status_code").a()));
                } else {
                    k(200);
                }
                if (o61VarC3.r("error_code")) {
                    h(o61VarC3.p("error_code").g() ? Constants.STR_EMPTY : o61VarC3.p("error_code").e());
                } else {
                    h(Constants.STR_EMPTY);
                }
                if (o61VarC3.r("error_message")) {
                    if (!o61VarC3.p("error_message").g()) {
                        strE = o61VarC3.p("error_message").e();
                    }
                    i(strE);
                } else {
                    i(Constants.STR_EMPTY);
                }
            }
            if (o61VarC2.r("payload")) {
                o61 o61VarQ = o61VarC2.q("payload");
                if (o61VarQ.r("output")) {
                    this.g = o61VarQ.p("output").g() ? null : o61VarQ.p("output");
                }
                if (o61VarQ.r("usage")) {
                    l(o61VarQ.p("usage").g() ? null : o61VarQ.p("usage"));
                }
            }
        } else {
            this.g = sq1Var.e();
        }
        return this;
    }

    public lh2 n(Protocol protocol, sq1 sq1Var, boolean z) {
        if (!z) {
            return m(protocol, sq1Var);
        }
        if (protocol != Protocol.WEBSOCKET) {
            this.g = t71.c(sq1Var.i());
            this.h = sq1Var.f();
        } else if (sq1Var.e() == null) {
            this.g = t71.c(sq1Var.i());
        } else {
            this.g = sq1Var.e();
        }
        return this;
    }

    public lh2 o(Protocol protocol, sq1 sq1Var, boolean z, xv0 xv0Var) {
        if ((!sq1Var.g().containsKey("X-DashScope-OutputEncrypted".toLowerCase()) && !xv0Var.o().booleanValue()) || protocol != Protocol.HTTP) {
            return n(protocol, sq1Var, z);
        }
        if (sq1Var.h() != null) {
            k(sq1Var.h());
        }
        o61 o61VarC = t71.c(sq1Var.i());
        String strE = o61VarC.p("output").g() ? null : o61VarC.p("output").e();
        if (strE != null) {
            this.g = t71.c(qh0.a(strE, xv0Var.c().b(), xv0Var.c().d()));
        } else {
            this.g = null;
        }
        if (o61VarC.r("usage")) {
            l(o61VarC.p("usage").g() ? null : o61VarC.p("usage").c());
        }
        if (o61VarC.r("request_id")) {
            j(o61VarC.p("request_id").e());
        }
        if (o61VarC.r("status_code")) {
            k(o61VarC.p("status_code").g() ? null : Integer.valueOf(o61VarC.p("status_code").a()));
        }
        boolean zR = o61VarC.r("code");
        String strE2 = Constants.STR_EMPTY;
        if (zR) {
            h(o61VarC.p("code").g() ? Constants.STR_EMPTY : o61VarC.p("code").e());
        } else {
            h(Constants.STR_EMPTY);
        }
        if (o61VarC.r("message")) {
            if (!o61VarC.p("message").g()) {
                strE2 = o61VarC.p("message").e();
            }
            i(strE2);
        } else {
            i(Constants.STR_EMPTY);
        }
        if (o61VarC.r("data") && o61VarC.r("request_id")) {
            o61VarC.s("request_id");
        }
        return this;
    }

    public String p() {
        return this.h;
    }

    public Object q() {
        return this.g;
    }

    public String toString() {
        return "DashScopeResult(output=" + q() + ", event=" + p() + ")";
    }
}
