package defpackage;

import com.alibaba.dashscope.common.ErrorType;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.protocol.HttpMethod;
import com.alibaba.dashscope.protocol.Protocol;
import com.tencent.connect.common.Constants;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class cu1 implements vv0 {
    private static final hd1 b = ld1.k(cu1.class);
    private static final fi1 c = fi1.g("application/json; charset=utf-8");
    private final zt1 a;

    class a extends ii0 {
        private eh2 a;
        final /* synthetic */ FlowableEmitter b;
        final /* synthetic */ xv0 c;

        a(FlowableEmitter flowableEmitter, xv0 xv0Var) {
            this.b = flowableEmitter;
            this.c = xv0Var;
        }

        @Override // defpackage.ii0
        public void a(hi0 hi0Var) {
            super.a(hi0Var);
            this.b.onComplete();
        }

        @Override // defpackage.ii0
        public void b(hi0 hi0Var, String str, String str2, String str3) {
            cu1.this.g(this.b, str, str2, str3, this.c.i(), this.a, this.c);
        }

        @Override // defpackage.ii0
        public void c(hi0 hi0Var, Throwable th, eh2 eh2Var) {
            this.a = eh2Var;
            super.c(hi0Var, th, eh2Var);
            this.b.onError(new ApiException(cu1.this.i(eh2Var, th), th));
        }

        @Override // defpackage.ii0
        public void d(hi0 hi0Var, eh2 eh2Var) {
            this.a = eh2Var;
            super.d(hi0Var, eh2Var);
        }
    }

    public cu1(zt1 zt1Var) {
        this.a = zt1Var;
    }

    private df2 f(sx0 sx0Var) {
        if (sx0Var.e() == HttpMethod.GET) {
            tx0.a aVarJ = tx0.l(sx0Var.g()).j();
            if (sx0Var.f() != null) {
                for (Map.Entry entry : sx0Var.f().entrySet()) {
                    aVarJ.b((String) entry.getKey(), entry.getValue().toString());
                }
            }
            return new df2.a().l(aVarJ.c()).h(iw0.d(sx0Var.d())).b();
        }
        if (sx0Var.e() == HttpMethod.POST) {
            df2.a aVar = new df2.a();
            aVar.m(sx0Var.g()).h(iw0.d(sx0Var.d()));
            if (sx0Var.c() != null) {
                aVar.j(ff2.create(c, (String) sx0Var.c()));
            } else {
                aVar.j(ff2.create(c, Constants.STR_EMPTY));
            }
            return aVar.b();
        }
        if (sx0Var.e() != HttpMethod.DELETE) {
            throw new ApiException(xt2.c().f(400).b("BadRequest").d(uv2.a("Unsupported method: %s", sx0Var.e())).a());
        }
        df2.a aVar2 = new df2.a();
        aVar2.m(sx0Var.g()).h(iw0.d(sx0Var.d()));
        if (sx0Var.c() != null) {
            aVar2.d(ff2.create(c, (String) sx0Var.c()));
        } else {
            aVar2.c();
        }
        return aVar2.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(FlowableEmitter flowableEmitter, String str, String str2, String str3, boolean z, eh2 eh2Var, xv0 xv0Var) {
        hd1 hd1Var = b;
        hd1Var.debug(uv2.a("Event: id %s, type: %s, data: %s", str, str2, str3));
        if ("error".equals(str2)) {
            flowableEmitter.onError(new ApiException(k(str3)));
            return;
        }
        if ("data".equals(str2) || "result".equals(str2)) {
            flowableEmitter.onNext(new u50().o(Protocol.HTTP, sq1.c().d(eh2Var.j0().f()).f(str3).c(str2).e(Integer.valueOf(eh2Var.C())).b(), z, xv0Var));
            return;
        }
        if ("done".equals(str2)) {
            hd1Var.debug(uv2.a("Ignore event id: %s, type: %s, data: %s", str, str2, str3));
            return;
        }
        if (str2 != null) {
            flowableEmitter.onNext(new u50().o(Protocol.HTTP, sq1.c().d(eh2Var.j0().f()).f(str3).c(str2).e(Integer.valueOf(eh2Var.C())).b(), z, xv0Var));
        } else if (str2 == null) {
            if (str3.equals("[DONE]")) {
                flowableEmitter.onComplete();
            } else {
                flowableEmitter.onNext(new u50().o(Protocol.HTTP, sq1.c().d(eh2Var.j0().f()).f(str3).e(Integer.valueOf(eh2Var.C())).b(), z, xv0Var));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(xv0 xv0Var, FlowableEmitter flowableEmitter) {
        ki0.b(this.a).a(f(xv0Var.g()), new a(flowableEmitter, xv0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public xt2 i(eh2 eh2Var, Throwable th) {
        if (eh2Var == null) {
            return xt2.c().f(-1).b(ErrorType.NETWORK_ERROR.getValue()).d(th == null ? "Get response failed!" : th.getMessage()).c(false).a();
        }
        String strA0 = eh2Var.a0("Content-Type");
        if (strA0 != null && strA0.toLowerCase().contains("application/json")) {
            try {
                return j(eh2Var.C(), eh2Var.n().string());
            } catch (IOException e) {
                return xt2.c().f(eh2Var.C()).b(ErrorType.RESPONSE_ERROR.getValue()).d("Failed read response body: " + e.getMessage()).c(true).a();
            }
        }
        if (strA0 == null || !strA0.toLowerCase().contains("text/event-stream")) {
            return xt2.c().f(eh2Var.C()).b(ErrorType.RESPONSE_ERROR.getValue()).d(eh2Var.m0()).c(false).a();
        }
        try {
            String strString = eh2Var.n().string();
            for (String str : strString.split("\n")) {
                String strTrim = str.trim();
                if (strTrim.startsWith("data:")) {
                    return j(eh2Var.C(), strTrim.replace("data:", Constants.STR_EMPTY));
                }
            }
            return xt2.c().f(eh2Var.C()).b(ErrorType.RESPONSE_ERROR.getValue()).d(strString).c(false).a();
        } catch (IOException e2) {
            return xt2.c().f(eh2Var.C()).b(ErrorType.RESPONSE_ERROR.getValue()).d("Failed read response body: " + e2.getMessage()).c(true).a();
        }
    }

    private xt2 j(int i, String str) {
        try {
            o61 o61VarC = t71.c(str);
            boolean zR = o61VarC.r("request_id");
            String strE = Constants.STR_EMPTY;
            String strE2 = zR ? o61VarC.p("request_id").e() : Constants.STR_EMPTY;
            String strE3 = o61VarC.r("code") ? o61VarC.p("code").e() : Constants.STR_EMPTY;
            if (o61VarC.r("message")) {
                strE = o61VarC.p("message").e();
            }
            return xt2.c().f(i).b(strE3).d(strE).e(strE2).c(true).a();
        } catch (Throwable unused) {
            return xt2.c().f(i).b(ErrorType.RESPONSE_ERROR.getValue()).d(str).c(true).a();
        }
    }

    private xt2 k(String str) {
        try {
            o61 o61VarC = t71.c(str);
            boolean zR = o61VarC.r("request_id");
            String strE = Constants.STR_EMPTY;
            String strE2 = zR ? o61VarC.p("request_id").e() : Constants.STR_EMPTY;
            String strE3 = o61VarC.r("code") ? o61VarC.p("code").e() : Constants.STR_EMPTY;
            if (o61VarC.r("message")) {
                strE = o61VarC.p("message").e();
            }
            return xt2.c().f(400).b(strE3).d(strE).e(strE2).c(true).a();
        } catch (Throwable unused) {
            return xt2.c().f(400).b(ErrorType.RESPONSE_ERROR.getValue()).d(str).c(false).a();
        }
    }

    @Override // defpackage.vv0
    public Flowable a(final xv0 xv0Var) {
        return Flowable.create(new FlowableOnSubscribe() { // from class: bu1
            @Override // io.reactivex.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) {
                this.a.h(xv0Var, flowableEmitter);
            }
        }, BackpressureStrategy.BUFFER);
    }

    @Override // defpackage.vv0
    public u50 b(xv0 xv0Var) {
        try {
            eh2 eh2VarExecute = this.a.a(f(xv0Var.g())).execute();
            if (eh2VarExecute.k0()) {
                return (u50) new u50().o(Protocol.HTTP, sq1.c().d(eh2VarExecute.j0().f()).f(eh2VarExecute.n().string()).e(Integer.valueOf(eh2VarExecute.C())).b(), xv0Var.i(), xv0Var);
            }
            throw new ApiException(i(eh2VarExecute, null));
        } catch (Throwable th) {
            throw new ApiException(th);
        }
    }
}
