package defpackage;

import com.tencent.connect.common.Constants;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public class s41 extends r32 {
    public static final a d = new a(null);
    private static final boolean e;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final s41 a() {
            if (b()) {
                return new s41();
            }
            return null;
        }

        public final boolean b() {
            return s41.e;
        }

        private a() {
        }
    }

    static {
        String property = System.getProperty("java.specification.version");
        Integer numM = property != null ? i.m(property) : null;
        boolean z = false;
        if (numM == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", null);
                z = true;
            } catch (NoSuchMethodException unused) {
            }
        } else if (numM.intValue() >= 9) {
            z = true;
        }
        e = z;
    }

    @Override // defpackage.r32
    public void e(SSLSocket sSLSocket, String str, List list) {
        p31.f(sSLSocket, "sslSocket");
        p31.f(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        sSLParameters.setApplicationProtocols((String[]) r32.a.b(list).toArray(new String[0]));
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // defpackage.r32
    public String g(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null ? true : p31.a(applicationProtocol, Constants.STR_EMPTY)) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
