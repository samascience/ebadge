package defpackage;

import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes4.dex */
public final class e90 implements ur2 {
    private final a a;
    private ur2 b;

    public interface a {
        boolean a(SSLSocket sSLSocket);

        ur2 b(SSLSocket sSLSocket);
    }

    public e90(a aVar) {
        p31.f(aVar, "socketAdapterFactory");
        this.a = aVar;
    }

    private final synchronized ur2 e(SSLSocket sSLSocket) {
        try {
            if (this.b == null && this.a.a(sSLSocket)) {
                this.b = this.a.b(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }

    @Override // defpackage.ur2
    public boolean a(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        return this.a.a(sSLSocket);
    }

    @Override // defpackage.ur2
    public boolean b() {
        return true;
    }

    @Override // defpackage.ur2
    public String c(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        ur2 ur2VarE = e(sSLSocket);
        if (ur2VarE != null) {
            return ur2VarE.c(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.ur2
    public void d(SSLSocket sSLSocket, String str, List list) {
        p31.f(sSLSocket, "sslSocket");
        p31.f(list, "protocols");
        ur2 ur2VarE = e(sSLSocket);
        if (ur2VarE != null) {
            ur2VarE.d(sSLSocket, str, list);
        }
    }
}
