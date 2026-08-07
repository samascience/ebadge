package defpackage;

import com.tencent.open.SocialConstants;
import java.net.Proxy;

/* JADX INFO: loaded from: classes4.dex */
public final class hf2 {
    public static final hf2 a = new hf2();

    private hf2() {
    }

    private final boolean b(df2 df2Var, Proxy.Type type) {
        return !df2Var.f() && type == Proxy.Type.HTTP;
    }

    public final String a(df2 df2Var, Proxy.Type type) {
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        p31.f(type, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(df2Var.g());
        sb.append(' ');
        hf2 hf2Var = a;
        if (hf2Var.b(df2Var, type)) {
            sb.append(df2Var.i());
        } else {
            sb.append(hf2Var.c(df2Var.i()));
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        p31.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String c(tx0 tx0Var) {
        p31.f(tx0Var, SocialConstants.PARAM_URL);
        String strD = tx0Var.d();
        String strF = tx0Var.f();
        if (strF == null) {
            return strD;
        }
        return strD + '?' + strF;
    }
}
