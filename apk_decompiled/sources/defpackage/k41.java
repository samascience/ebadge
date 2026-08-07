package defpackage;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kotlin.collections.j;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public final class k41 implements mc {
    private final qc0 d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    public k41(qc0 qc0Var) {
        p31.f(qc0Var, "defaultDns");
        this.d = qc0Var;
    }

    private final InetAddress b(Proxy proxy, tx0 tx0Var, qc0 qc0Var) {
        Proxy.Type type = proxy.type();
        if ((type == null ? -1 : a.a[type.ordinal()]) == 1) {
            return (InetAddress) j.G(qc0Var.a(tx0Var.h()));
        }
        SocketAddress socketAddressAddress = proxy.address();
        p31.d(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        p31.e(address, "address() as InetSocketAddress).address");
        return address;
    }

    @Override // defpackage.mc
    public df2 a(ki2 ki2Var, eh2 eh2Var) {
        Proxy proxyB;
        qc0 qc0VarC;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        v4 v4VarA;
        p31.f(eh2Var, "response");
        List<ax> listY = eh2Var.y();
        df2 df2VarG0 = eh2Var.G0();
        tx0 tx0VarI = df2VarG0.i();
        boolean z = eh2Var.C() == 407;
        if (ki2Var == null || (proxyB = ki2Var.b()) == null) {
            proxyB = Proxy.NO_PROXY;
        }
        for (ax axVar : listY) {
            if (i.v("Basic", axVar.c(), true)) {
                if (ki2Var == null || (v4VarA = ki2Var.a()) == null || (qc0VarC = v4VarA.c()) == null) {
                    qc0VarC = this.d;
                }
                if (z) {
                    SocketAddress socketAddressAddress = proxyB.address();
                    p31.d(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                    String hostName = inetSocketAddress.getHostName();
                    p31.e(proxyB, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, b(proxyB, tx0VarI, qc0VarC), inetSocketAddress.getPort(), tx0VarI.r(), axVar.b(), axVar.c(), tx0VarI.t(), Authenticator.RequestorType.PROXY);
                } else {
                    String strH = tx0VarI.h();
                    p31.e(proxyB, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(strH, b(proxyB, tx0VarI, qc0VarC), tx0VarI.n(), tx0VarI.r(), axVar.b(), axVar.c(), tx0VarI.t(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    String str = z ? "Proxy-Authorization" : "Authorization";
                    String userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                    p31.e(userName, "auth.userName");
                    char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                    p31.e(password, "auth.password");
                    return df2VarG0.h().g(str, y40.a(userName, new String(password), axVar.a())).b();
                }
            }
        }
        return null;
    }

    public /* synthetic */ k41(qc0 qc0Var, int i, y70 y70Var) {
        this((i & 1) != 0 ? qc0.b : qc0Var);
    }
}
