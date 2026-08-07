package defpackage;

import com.alibaba.dashscope.aigc.multimodalconversation.a;
import com.alibaba.dashscope.common.Function;
import com.alibaba.dashscope.common.OutputMode;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.common.Task;
import com.alibaba.dashscope.common.TaskGroup;
import com.alibaba.dashscope.exception.UploadFileException;
import com.alibaba.dashscope.protocol.HttpMethod;
import com.alibaba.dashscope.protocol.Protocol;
import com.alibaba.dashscope.protocol.StreamingMode;
import io.reactivex.Flowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class pl1 {
    private static final hd1 d = ld1.k(pl1.class);
    private final yy2 a;
    private final h8 b;
    private final ThreadLocal c = ThreadLocal.withInitial(new bt0());

    public pl1() {
        h8 h8VarE = e();
        this.b = h8VarE;
        this.a = new yy2(h8VarE);
    }

    private void d() {
        ((Map) this.c.get()).clear();
        this.c.remove();
    }

    private h8 e() {
        return h8.w().B(Protocol.HTTP).z(HttpMethod.POST).D(StreamingMode.NONE).A(OutputMode.ACCUMULATE).F(TaskGroup.AIGC.getValue()).E(Task.MULTIMODAL_GENERATION.getValue()).y(Function.GENERATION.getValue()).x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(boolean z) {
        if (z) {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(boolean z, Throwable th) {
        if (z) {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public tl1 f(tl1 tl1Var, boolean z) {
        if (z && tl1Var != null) {
            tl1Var.e();
        }
        return tl1Var;
    }

    private boolean j(a aVar) {
        Boolean boolW = aVar.w();
        if (!bz1.b(aVar.j()) || !Boolean.FALSE.equals(boolW)) {
            return false;
        }
        aVar.Z(Boolean.TRUE);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x006b  */
    private void k(a aVar) throws UploadFileException {
        boolean zB;
        ns1 ns1VarA = null;
        boolean z = false;
        for (Object obj : aVar.B()) {
            if (obj instanceof ql1) {
                ql1 ql1Var = (ql1) obj;
                if (ql1Var.c().equals(Role.USER.getValue())) {
                    j52.c cVarE = j52.e(aVar.j(), ql1Var.b(), aVar.d(), ns1VarA);
                    zB = cVarE.b();
                    ns1VarA = cVarE.a();
                } else {
                    zB = false;
                }
            } else {
                vl1 vl1Var = (vl1) obj;
                if (vl1Var.f().equals(Role.USER.getValue())) {
                    j52.c cVarF = j52.f(aVar.j(), vl1Var, aVar.d(), ns1VarA);
                    zB = cVarF.b();
                    ns1VarA = cVarF.a();
                } else {
                    zB = false;
                }
            }
            if (zB && !z) {
                z = true;
            }
        }
        if (z) {
            aVar.q("X-DashScope-OssResourceResolve", "enable");
        }
    }

    public Flowable l(a aVar) throws UploadFileException {
        final boolean zJ = j(aVar);
        aVar.q("user-agent", uv2.a("incremental_to_full/%d", Integer.valueOf(zJ ? 1 : 0)));
        this.b.A(Boolean.TRUE);
        this.b.B(StreamingMode.OUT);
        k(aVar);
        return this.a.b(aVar).map(new io.reactivex.functions.Function() { // from class: ll1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return tl1.b((u50) obj);
            }
        }).map(new io.reactivex.functions.Function() { // from class: ml1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.a.f(zJ, (tl1) obj);
            }
        }).doOnComplete(new Action() { // from class: nl1
            @Override // io.reactivex.functions.Action
            public final void run() {
                this.a.g(zJ);
            }
        }).doOnError(new Consumer() { // from class: ol1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.a.h(zJ, (Throwable) obj);
            }
        });
    }
}
