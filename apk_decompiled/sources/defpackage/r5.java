package defpackage;

import android.net.ssl.SSLSockets;
import android.os.Build;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes4.dex */
public final class r5 implements ur2 {
    public static final a a = new a(null);

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final ur2 a() {
            if (b()) {
                return new r5();
            }
            return null;
        }

        public final boolean b() {
            return r32.a.h() && Build.VERSION.SDK_INT >= 29;
        }

        private a() {
        }
    }

    @Override // defpackage.ur2
    public boolean a(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override // defpackage.ur2
    public boolean b() {
        return a.b();
    }

    @Override // defpackage.ur2
    public String c(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null ? true : p31.a(applicationProtocol, Constants.STR_EMPTY)) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // defpackage.ur2
    public void d(SSLSocket sSLSocket, String str, List list) throws IOException {
        p31.f(sSLSocket, "sslSocket");
        p31.f(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) r32.a.b(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }
}
