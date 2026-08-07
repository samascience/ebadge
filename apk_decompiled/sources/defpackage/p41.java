package defpackage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes4.dex */
public final class p41 extends r32 {
    public static final b i = new b(null);
    private final Method d;
    private final Method e;
    private final Method f;
    private final Class g;
    private final Class h;

    private static final class a implements InvocationHandler {
        private final List a;
        private boolean b;
        private String c;

        public a(List list) {
            p31.f(list, "protocols");
            this.a = list;
        }

        public final String a() {
            return this.c;
        }

        public final boolean b() {
            return this.b;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            p31.f(obj, "proxy");
            p31.f(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (p31.a(name, "supports") && p31.a(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (p31.a(name, "unsupported") && p31.a(Void.TYPE, returnType)) {
                this.b = true;
                return null;
            }
            if (p31.a(name, "protocols") && objArr.length == 0) {
                return this.a;
            }
            if ((p31.a(name, "selectProtocol") || p31.a(name, "select")) && p31.a(String.class, returnType) && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    p31.d(obj2, "null cannot be cast to non-null type kotlin.collections.List<*>");
                    List list = (List) obj2;
                    int size = list.size();
                    if (size >= 0) {
                        int i = 0;
                        while (true) {
                            Object obj3 = list.get(i);
                            p31.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj3;
                            if (this.a.contains(str)) {
                                this.c = str;
                                return str;
                            }
                            if (i != size) {
                                i++;
                            }
                        }
                    }
                    String str2 = (String) this.a.get(0);
                    this.c = str2;
                    return str2;
                }
            }
            if ((!p31.a(name, "protocolSelected") && !p31.a(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj4 = objArr[0];
            p31.d(obj4, "null cannot be cast to non-null type kotlin.String");
            this.c = (String) obj4;
            return null;
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        public final r32 a() {
            String property = System.getProperty("java.specification.version", "unknown");
            try {
                p31.e(property, "jvmVersion");
                if (Integer.parseInt(property) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                Method method = cls.getMethod("put", SSLSocket.class, cls2);
                Method method2 = cls.getMethod("get", SSLSocket.class);
                Method method3 = cls.getMethod("remove", SSLSocket.class);
                p31.e(method, "putMethod");
                p31.e(method2, "getMethod");
                p31.e(method3, "removeMethod");
                p31.e(cls3, "clientProviderClass");
                p31.e(cls4, "serverProviderClass");
                return new p41(method, method2, method3, cls3, cls4);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }

        private b() {
        }
    }

    public p41(Method method, Method method2, Method method3, Class cls, Class cls2) {
        p31.f(method, "putMethod");
        p31.f(method2, "getMethod");
        p31.f(method3, "removeMethod");
        p31.f(cls, "clientProviderClass");
        p31.f(cls2, "serverProviderClass");
        this.d = method;
        this.e = method2;
        this.f = method3;
        this.g = cls;
        this.h = cls2;
    }

    @Override // defpackage.r32
    public void b(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        try {
            this.f.invoke(null, sSLSocket);
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to remove ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }

    @Override // defpackage.r32
    public void e(SSLSocket sSLSocket, String str, List list) {
        p31.f(sSLSocket, "sslSocket");
        p31.f(list, "protocols");
        try {
            this.d.invoke(null, sSLSocket, Proxy.newProxyInstance(r32.class.getClassLoader(), new Class[]{this.g, this.h}, new a(r32.a.b(list))));
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to set ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    @Override // defpackage.r32
    public String g(SSLSocket sSLSocket) {
        p31.f(sSLSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.e.invoke(null, sSLSocket));
            p31.d(invocationHandler, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            a aVar = (a) invocationHandler;
            if (!aVar.b() && aVar.a() == null) {
                r32.k(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (aVar.b()) {
                return null;
            }
            return aVar.a();
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }
}
