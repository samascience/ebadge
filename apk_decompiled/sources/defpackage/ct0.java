package defpackage;

import com.alibaba.dashscope.common.Function;
import com.alibaba.dashscope.common.OutputMode;
import com.alibaba.dashscope.common.Task;
import com.alibaba.dashscope.common.TaskGroup;
import com.alibaba.dashscope.protocol.HttpMethod;
import com.alibaba.dashscope.protocol.Protocol;
import com.alibaba.dashscope.protocol.StreamingMode;

/* JADX INFO: loaded from: classes.dex */
public final class ct0 {
    private static final hd1 d = ld1.k(ct0.class);
    private final yy2 a;
    private final h8 b;
    private final ThreadLocal c = ThreadLocal.withInitial(new bt0());

    public ct0() {
        h8 h8VarB = b();
        this.b = h8VarB;
        this.a = new yy2(h8VarB);
    }

    private h8 b() {
        return h8.w().B(Protocol.HTTP).z(HttpMethod.POST).D(StreamingMode.OUT).A(OutputMode.ACCUMULATE).F(TaskGroup.AIGC.getValue()).E(Task.TEXT_GENERATION.getValue()).y(Function.GENERATION.getValue()).x();
    }

    public gt0 a(yv0 yv0Var) {
        yv0Var.o();
        this.b.A(Boolean.FALSE);
        this.b.B(StreamingMode.NONE);
        return gt0.a(this.a.a(yv0Var));
    }
}
