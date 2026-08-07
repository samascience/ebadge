package defpackage;

import com.alibaba.dashscope.protocol.HttpMethod;
import com.alibaba.dashscope.protocol.Protocol;
import com.alibaba.dashscope.protocol.StreamingMode;

/* JADX INFO: loaded from: classes.dex */
public class ph0 {
    private final zs0 b = a();
    private final ws0 a = new ws0();

    private zs0 a() {
        return zs0.u().u(Protocol.HTTP).s(HttpMethod.GET).w(StreamingMode.NONE).t("public-keys/latest").r();
    }

    public oh0 b(String str) {
        oh0.a(this.a.a(((xs0.b) xs0.p().k(str)).m(), this.b));
        return null;
    }
}
