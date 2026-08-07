package defpackage;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public final class rx0 {
    public static final rx0 a = new rx0();

    private rx0() {
    }

    public static final boolean a(String str) {
        p31.f(str, "method");
        return (p31.a(str, Constants.HTTP_GET) || p31.a(str, "HEAD")) ? false : true;
    }

    public static final boolean d(String str) {
        p31.f(str, "method");
        return p31.a(str, Constants.HTTP_POST) || p31.a(str, "PUT") || p31.a(str, "PATCH") || p31.a(str, "PROPPATCH") || p31.a(str, "REPORT");
    }

    public final boolean b(String str) {
        p31.f(str, "method");
        return !p31.a(str, "PROPFIND");
    }

    public final boolean c(String str) {
        p31.f(str, "method");
        return p31.a(str, "PROPFIND");
    }
}
