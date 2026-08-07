package defpackage;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes4.dex */
public final class o5 extends r32 {
    public static final a e = new a(null);
    private static final boolean f;
    private final List d;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final r32 a() {
            if (b()) {
                return new o5();
            }
            return null;
        }

        public final boolean b() {
            return o5.f;
        }

        private a() {
        }
    }

    static {
        f = r32.a.h() && Build.VERSION.SDK_INT >= 29;
    }

    public o5() {
        List listN = j.n(r5.a.a(), new e90(b6.f.d()), new e90(c20.a.a()), new e90(in.a.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listN) {
            if (((ur2) obj).b()) {
                arrayList.add(obj);
            }
        }
        this.d = arrayList;
    }

    @Override // defpackage.r32
    public yw c(X509TrustManager x509TrustManager) {
        p31.f(x509TrustManager, "trustManager");
        s5 s5VarA = s5.d.a(x509TrustManager);
        return s5VarA != null ? s5VarA : super.c(x509TrustManager);
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
    public boolean i(String str) {
        p31.f(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
