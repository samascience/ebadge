package defpackage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class mj2 {
    private final ze1 a = new ze1(1000);
    private final h42 b = ak0.d(10, new a());

    class a implements ak0.d {
        a() {
        }

        @Override // ak0.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b create() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static final class b implements ak0.f {
        final MessageDigest a;
        private final tt2 b = tt2.a();

        b(MessageDigest messageDigest) {
            this.a = messageDigest;
        }

        @Override // ak0.f
        public tt2 e() {
            return this.b;
        }
    }

    private String a(w81 w81Var) {
        b bVar = (b) z42.d(this.b.b());
        try {
            w81Var.updateDiskCacheKey(bVar.a);
            return na3.v(bVar.a.digest());
        } finally {
            this.b.a(bVar);
        }
    }

    public String b(w81 w81Var) {
        String strA;
        synchronized (this.a) {
            strA = (String) this.a.g(w81Var);
        }
        if (strA == null) {
            strA = a(w81Var);
        }
        synchronized (this.a) {
            this.a.k(w81Var, strA);
        }
        return strA;
    }
}
