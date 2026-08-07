package defpackage;

import java.util.List;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes4.dex */
public abstract class yw {
    public static final a a = new a(null);

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final yw a(X509TrustManager x509TrustManager) {
            p31.f(x509TrustManager, "trustManager");
            return r32.a.g().c(x509TrustManager);
        }

        private a() {
        }
    }

    public abstract List a(List list, String str);
}
