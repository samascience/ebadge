package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public class b6 implements ur2 {
    public static final a f;
    private static final e90.a g;
    private final Class a;
    private final Method b;
    private final Method c;
    private final Method d;
    private final Method e;

    public static final class a {

        /* JADX INFO: renamed from: b6$a$a, reason: collision with other inner class name */
        public static final class C0046a implements e90.a {
            final /* synthetic */ String a;

            C0046a(String str) {
                this.a = str;
            }

            @Override // e90.a
            public boolean a(SSLSocket sSLSocket) {
                p31.f(sSLSocket, "sslSocket");
                String name = sSLSocket.getClass().getName();
                p31.e(name, "sslSocket.javaClass.name");
                return i.G(name, this.a + '.', false, 2, null);
            }

            @Override // e90.a
            public ur2 b(SSLSocket sSLSocket) {
                p31.f(sSLSocket, "sslSocket");
                return b6.f.b(sSLSocket.getClass());
            }
        }

        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final b6 b(Class cls) {
            Class superclass = cls;
            while (superclass != null && !p31.a(superclass.getSimpleName(), "OpenSSLSocketImpl")) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
                }
            }
            p31.c(superclass);
            return new b6(superclass);
        }

        public final e90.a c(String str) {
            p31.f(str, "packageName");
            return new C0046a(str);
        }

        public final e90.a d() {
            return b6.g;
        }

        private a() {
        }
    }

    static {
        a aVar = new a(null);
        f = aVar;
        g = aVar.c("com.google.android.gms.org.conscrypt");
    }

    public b6(Class cls) throws NoSuchMethodException {
        p31.f(cls, "sslSocketClass");
        this.a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        p31.e(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.b = declaredMethod;
        this.c = cls.getMethod("setHostname", String.class);
        this.d = cls.getMethod("getAlpnSelectedProtocol", null);
        this.e = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // defpackage.ur2
    public boolean a(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        return this.a.isInstance(sSLSocket);
    }

    @Override // defpackage.ur2
    public boolean b() {
        return w5.f.b();
    }

    @Override // defpackage.ur2
    public String c(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        if (!a(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.d.invoke(sSLSocket, null);
            if (bArr != null) {
                return new String(bArr, gx.b);
            }
            return null;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if ((cause instanceof NullPointerException) && p31.a(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e2);
        }
    }

    @Override // defpackage.ur2
    public void d(SSLSocket sSLSocket, String str, List list) {
        p31.f(sSLSocket, "sslSocket");
        p31.f(list, "protocols");
        if (a(sSLSocket)) {
            try {
                this.b.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.c.invoke(sSLSocket, str);
                }
                this.e.invoke(sSLSocket, r32.a.c(list));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }
}
