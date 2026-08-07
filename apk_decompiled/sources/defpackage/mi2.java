package defpackage;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes4.dex */
public final class mi2 {
    public static final a i = new a(null);
    private final v4 a;
    private final li2 b;
    private final eq c;
    private final fi0 d;
    private List e;
    private int f;
    private List g;
    private final List h;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final String a(InetSocketAddress inetSocketAddress) {
            p31.f(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                String hostName = inetSocketAddress.getHostName();
                p31.e(hostName, "hostName");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            p31.e(hostAddress, "address.hostAddress");
            return hostAddress;
        }

        private a() {
        }
    }

    public static final class b {
        private final List a;
        private int b;

        public b(List list) {
            p31.f(list, "routes");
            this.a = list;
        }

        public final List a() {
            return this.a;
        }

        public final boolean b() {
            return this.b < this.a.size();
        }

        public final ki2 c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List list = this.a;
            int i = this.b;
            this.b = i + 1;
            return (ki2) list.get(i);
        }
    }

    public mi2(v4 v4Var, li2 li2Var, eq eqVar, fi0 fi0Var) {
        p31.f(v4Var, "address");
        p31.f(li2Var, "routeDatabase");
        p31.f(eqVar, "call");
        p31.f(fi0Var, "eventListener");
        this.a = v4Var;
        this.b = li2Var;
        this.c = eqVar;
        this.d = fi0Var;
        this.e = j.j();
        this.g = j.j();
        this.h = new ArrayList();
        f(v4Var.l(), v4Var.g());
    }

    private final boolean b() {
        return this.f < this.e.size();
    }

    private final Proxy d() throws SocketException, UnknownHostException {
        if (b()) {
            List list = this.e;
            int i2 = this.f;
            this.f = i2 + 1;
            Proxy proxy = (Proxy) list.get(i2);
            e(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.a.l().h() + "; exhausted proxy configurations: " + this.e);
    }

    private final void e(Proxy proxy) throws SocketException, UnknownHostException {
        String strH;
        int iN;
        List listA;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strH = this.a.l().h();
            iN = this.a.l().n();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
            }
            a aVar = i;
            p31.e(socketAddressAddress, "proxyAddress");
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strH = aVar.a(inetSocketAddress);
            iN = inetSocketAddress.getPort();
        }
        if (1 > iN || iN >= 65536) {
            throw new SocketException("No route to " + strH + ':' + iN + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(strH, iN));
            return;
        }
        if (pa3.i(strH)) {
            listA = j.e(InetAddress.getByName(strH));
        } else {
            this.d.m(this.c, strH);
            listA = this.a.c().a(strH);
            if (listA.isEmpty()) {
                throw new UnknownHostException(this.a.c() + " returned no addresses for " + strH);
            }
            this.d.l(this.c, strH, listA);
        }
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(new InetSocketAddress((InetAddress) it.next(), iN));
        }
    }

    private final void f(tx0 tx0Var, Proxy proxy) {
        this.d.o(this.c, tx0Var);
        List listG = g(proxy, tx0Var, this);
        this.e = listG;
        this.f = 0;
        this.d.n(this.c, tx0Var, listG);
    }

    private static final List g(Proxy proxy, tx0 tx0Var, mi2 mi2Var) {
        if (proxy != null) {
            return j.e(proxy);
        }
        URI uriS = tx0Var.s();
        if (uriS.getHost() == null) {
            return pa3.w(Proxy.NO_PROXY);
        }
        List<Proxy> listSelect = mi2Var.a.i().select(uriS);
        if (listSelect == null || listSelect.isEmpty()) {
            return pa3.w(Proxy.NO_PROXY);
        }
        p31.e(listSelect, "proxiesOrNull");
        return pa3.U(listSelect);
    }

    public final boolean a() {
        return b() || !this.h.isEmpty();
    }

    public final b c() {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (b()) {
            Proxy proxyD = d();
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                ki2 ki2Var = new ki2(this.a, proxyD, (InetSocketAddress) it.next());
                if (this.b.c(ki2Var)) {
                    this.h.add(ki2Var);
                } else {
                    arrayList.add(ki2Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            j.w(arrayList, this.h);
            this.h.clear();
        }
        return new b(arrayList);
    }
}
