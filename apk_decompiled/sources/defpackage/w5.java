package defpackage;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes4.dex */
public final class w5 extends r32 {
    public static final a f = new a(null);
    private static final boolean g;
    private final List d;
    private final qy e;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final r32 a() {
            if (b()) {
                return new w5();
            }
            return null;
        }

        public final boolean b() {
            return w5.g;
        }

        private a() {
        }
    }

    public static final class b implements c63 {
        private final X509TrustManager a;
        private final Method b;

        public b(X509TrustManager x509TrustManager, Method method) {
            p31.f(x509TrustManager, "trustManager");
            p31.f(method, "findByIssuerAndSignatureMethod");
            this.a = x509TrustManager;
            this.b = method;
        }

        @Override // defpackage.c63
        public X509Certificate a(X509Certificate x509Certificate) {
            p31.f(x509Certificate, "cert");
            try {
                Object objInvoke = this.b.invoke(this.a, x509Certificate);
                p31.d(objInvoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
                return ((TrustAnchor) objInvoke).getTrustedCert();
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return p31.a(this.a, bVar.a) && p31.a(this.b, bVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.a + ", findByIssuerAndSignatureMethod=" + this.b + ')';
        }
    }

    static {
        boolean z = false;
        if (r32.a.h() && Build.VERSION.SDK_INT < 30) {
            z = true;
        }
        g = z;
    }

    public w5() {
        List listN = j.n(lt2.a.b(lt2.j, null, 1, null), new e90(b6.f.d()), new e90(c20.a.a()), new e90(in.a.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listN) {
            if (((ur2) obj).b()) {
                arrayList.add(obj);
            }
        }
        this.d = arrayList;
        this.e = qy.d.a();
    }

    @Override // defpackage.r32
    public yw c(X509TrustManager x509TrustManager) {
        p31.f(x509TrustManager, "trustManager");
        s5 s5VarA = s5.d.a(x509TrustManager);
        return s5VarA != null ? s5VarA : super.c(x509TrustManager);
    }

    @Override // defpackage.r32
    public c63 d(X509TrustManager x509TrustManager) {
        p31.f(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            p31.e(declaredMethod, "method");
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.d(x509TrustManager);
        }
    }

    @Override // defpackage.r32
    public void e(SSLSocket sSLSocket, String str, List list) {
        Object next;
        p31.f(sSLSocket, "sslSocket");
        p31.f(list, "protocols");
        Iterator it = this.d.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((ur2) next).a(sSLSocket));
        ur2 ur2Var = (ur2) next;
        if (ur2Var != null) {
            ur2Var.d(sSLSocket, str, list);
        }
    }

    @Override // defpackage.r32
    public void f(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        p31.f(socket, "socket");
        p31.f(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e;
            }
            throw new IOException("Exception in connect", e);
        }
    }

    @Override // defpackage.r32
    public String g(SSLSocket sSLSocket) {
        Object next;
        p31.f(sSLSocket, "sslSocket");
        Iterator it = this.d.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((ur2) next).a(sSLSocket));
        ur2 ur2Var = (ur2) next;
        if (ur2Var != null) {
            return ur2Var.c(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.r32
    public Object h(String str) {
        p31.f(str, "closer");
        return this.e.a(str);
    }

    @Override // defpackage.r32
    public boolean i(String str) {
        p31.f(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    @Override // defpackage.r32
    public void l(String str, Object obj) {
        p31.f(str, "message");
        if (this.e.b(obj)) {
            return;
        }
        r32.k(this, str, 5, null, 4, null);
    }
}
