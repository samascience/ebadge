package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public final class lt2 extends b6 {
    public static final a j = new a(null);
    private final Class h;
    private final Class i;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public static /* synthetic */ ur2 b(a aVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return aVar.a(str);
        }

        public final ur2 a(String str) {
            p31.f(str, "packageName");
            try {
                Class<?> cls = Class.forName(str + ".OpenSSLSocketImpl");
                p31.d(cls, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");
                Class<?> cls2 = Class.forName(str + ".OpenSSLSocketFactoryImpl");
                p31.d(cls2, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");
                Class<?> cls3 = Class.forName(str + ".SSLParametersImpl");
                p31.e(cls3, "paramsClass");
                return new lt2(cls, cls2, cls3);
            } catch (Exception e) {
                r32.a.g().j("unable to load android socket classes", 5, e);
                return null;
            }
        }

        private a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lt2(Class cls, Class cls2, Class cls3) {
        super(cls);
        p31.f(cls, "sslSocketClass");
        p31.f(cls2, "sslSocketFactoryClass");
        p31.f(cls3, "paramClass");
        this.h = cls2;
        this.i = cls3;
    }
}
