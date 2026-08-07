package defpackage;

import com.alibaba.dashscope.protocol.HttpMethod;
import com.alibaba.dashscope.protocol.Protocol;
import com.alibaba.dashscope.protocol.StreamingMode;
import com.alibaba.dashscope.protocol.WebSocketEventType;
import com.jieli.jl_rcsp.constant.WatchConstant;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class xv0 {
    private static final hd1 d = ld1.k(xv0.class);
    wv0 a;
    gn2 b;
    nh0 c;

    public xv0(wv0 wv0Var, gn2 gn2Var) {
        this.a = wv0Var;
        this.b = gn2Var;
    }

    private String d(nh0 nh0Var) {
        return uv2.a("{\"public_key_id\":\"%s\",\"encrypt_key\":\"%s\",\"iv\":\"%s\"}", nh0Var.e(), qh0.c(Base64.getEncoder().encodeToString(nh0Var.b().getEncoded()), nh0Var.c()), Base64.getEncoder().encodeToString(nh0Var.d()));
    }

    public String a() {
        return this.a.d();
    }

    public String b() {
        return this.b.l();
    }

    public nh0 c() {
        return this.c;
    }

    public Map e() {
        return this.a.g();
    }

    public HttpMethod f() {
        return this.b.g();
    }

    public sx0 g() {
        Map mapG = this.a.g();
        String str = mapG != null ? (String) mapG.get("user-agent") : null;
        HashMap map = mapG != null ? new HashMap(mapG) : new HashMap();
        map.remove("user-agent");
        Map mapB = t50.b(this.a.d(), Boolean.valueOf(this.a.n()), Protocol.HTTP, this.b.a(), this.b.f(), this.a.m(), map, str);
        if (f() == HttpMethod.GET) {
            return sx0.a().l(h()).i(f()).h(mapB).j(this.a.k()).i(f()).g();
        }
        if (f() != HttpMethod.POST && f() != HttpMethod.DELETE) {
            return sx0.a().i(f()).g();
        }
        o61 o61VarH = this.a.h();
        if (o().booleanValue() && o61VarH != null) {
            mapB.put("X-DashScope-EncryptionKey", d(qh0.d(this.a.d())));
            o61VarH.n("input", qh0.b(t71.toJson(o61VarH.p("input").c()), this.c.b(), this.c.d()));
        }
        return sx0.a().l(h()).h(mapB).f(o61VarH != null ? t71.toJson(o61VarH) : null).i(f()).g();
    }

    public String h() {
        String strSubstring = i20.j;
        if (this.b.j() != null) {
            strSubstring = this.b.j();
        }
        if (strSubstring.endsWith(WatchConstant.FAT_FS_ROOT)) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        return strSubstring + this.b.d();
    }

    public boolean i() {
        return this.b.k();
    }

    public o61 j() {
        o61 o61Var = new o61();
        o61Var.n("action", WebSocketEventType.RUN_TASK.getValue());
        if (this.a.k() == null || !this.a.k().containsKey("pre_task_id")) {
            o61Var.n("task_id", UUID.randomUUID().toString());
        } else {
            o61Var.n("task_id", (String) this.a.k().get("pre_task_id"));
        }
        o61Var.n("streaming", this.b.e().getValue());
        o61 o61Var2 = new o61();
        o61Var2.j("header", o61Var);
        o61Var2.j("payload", l());
        return o61Var2;
    }

    public StreamingMode k() {
        return this.b.e();
    }

    public o61 l() {
        o61 o61Var = new o61();
        o61Var.n("model", this.a.j());
        o61Var.n("task_group", this.b.i());
        o61Var.n("task", this.b.c());
        o61Var.n("function", this.b.b());
        if (this.a.e() == null) {
            o61Var.j("input", (o61) this.a.i());
        }
        if (this.a.k() != null) {
            o61Var.j("parameters", t71.b(this.a.k()));
        }
        if (this.a.l() != null) {
            o61Var.j("resources", (u51) this.a.l());
        }
        return o61Var;
    }

    public ByteBuffer m() {
        return this.a.e();
    }

    public String n() {
        return this.a.m();
    }

    public Boolean o() {
        return this.a.f();
    }

    public boolean p() {
        return this.a.n();
    }
}
