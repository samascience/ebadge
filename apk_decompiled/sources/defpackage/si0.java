package defpackage;

import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* JADX INFO: loaded from: classes4.dex */
public final class si0 {
    private final hd2 a;
    private final v4 b;
    private final gd2 c;
    private final fi0 d;
    private mi2.b e;
    private mi2 f;
    private int g;
    private int h;
    private int i;
    private ki2 j;

    public si0(hd2 hd2Var, v4 v4Var, gd2 gd2Var, fi0 fi0Var) {
        p31.f(hd2Var, "connectionPool");
        p31.f(v4Var, "address");
        p31.f(gd2Var, "call");
        p31.f(fi0Var, "eventListener");
        this.a = hd2Var;
        this.b = v4Var;
        this.c = gd2Var;
        this.d = fi0Var;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x012f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0149  */
    /* JADX WARN: Code duplicated, block: B:77:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private final RealConnection b(int i, int i2, int i3, int i4, boolean z) throws IOException {
        List listA;
        RealConnection realConnection;
        Socket socketV;
        if (this.c.isCanceled()) {
            throw new IOException("Canceled");
        }
        RealConnection realConnectionK = this.c.k();
        if (realConnectionK != null) {
            synchronized (realConnectionK) {
                try {
                    socketV = (realConnectionK.q() || !g(realConnectionK.B().a().l())) ? this.c.v() : null;
                    k83 k83Var = k83.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.c.k() != null) {
                if (socketV == null) {
                    return realConnectionK;
                }
                throw new IllegalStateException("Check failed.");
            }
            if (socketV != null) {
                pa3.n(socketV);
            }
            this.d.k(this.c, realConnectionK);
        }
        this.g = 0;
        this.h = 0;
        this.i = 0;
        if (this.a.a(this.b, this.c, null, false)) {
            RealConnection realConnectionK2 = this.c.k();
            p31.c(realConnectionK2);
            this.d.j(this.c, realConnectionK2);
            return realConnectionK2;
        }
        ki2 ki2VarC = this.j;
        try {
            if (ki2VarC == null) {
                mi2.b bVar = this.e;
                if (bVar != null) {
                    p31.c(bVar);
                    if (bVar.b()) {
                        mi2.b bVar2 = this.e;
                        p31.c(bVar2);
                        ki2VarC = bVar2.c();
                    }
                    realConnection = new RealConnection(this.a, ki2VarC);
                    this.c.x(realConnection);
                    realConnection.g(i, i2, i3, i4, z, this.c, this.d);
                    this.c.x(null);
                    this.c.j().t().a(realConnection.B());
                    if (this.a.a(this.b, this.c, listA, true)) {
                        RealConnection realConnectionK3 = this.c.k();
                        p31.c(realConnectionK3);
                        this.j = ki2VarC;
                        pa3.n(realConnection.F());
                        this.d.j(this.c, realConnectionK3);
                        return realConnectionK3;
                    }
                    synchronized (realConnection) {
                        this.a.e(realConnection);
                        this.c.c(realConnection);
                        k83 k83Var2 = k83.a;
                    }
                    this.d.j(this.c, realConnection);
                    return realConnection;
                }
                mi2 mi2Var = this.f;
                if (mi2Var == null) {
                    mi2Var = new mi2(this.b, this.c.j().t(), this.c, this.d);
                    this.f = mi2Var;
                }
                mi2.b bVarC = mi2Var.c();
                this.e = bVarC;
                listA = bVarC.a();
                if (this.c.isCanceled()) {
                    throw new IOException("Canceled");
                }
                if (this.a.a(this.b, this.c, listA, false)) {
                    RealConnection realConnectionK4 = this.c.k();
                    p31.c(realConnectionK4);
                    this.d.j(this.c, realConnectionK4);
                    return realConnectionK4;
                }
                ki2VarC = bVarC.c();
                realConnection = new RealConnection(this.a, ki2VarC);
                this.c.x(realConnection);
                realConnection.g(i, i2, i3, i4, z, this.c, this.d);
                this.c.x(null);
                this.c.j().t().a(realConnection.B());
                if (this.a.a(this.b, this.c, listA, true)) {
                    RealConnection realConnectionK5 = this.c.k();
                    p31.c(realConnectionK5);
                    this.j = ki2VarC;
                    pa3.n(realConnection.F());
                    this.d.j(this.c, realConnectionK5);
                    return realConnectionK5;
                }
                synchronized (realConnection) {
                    this.a.e(realConnection);
                    this.c.c(realConnection);
                    k83 k83Var3 = k83.a;
                    this.d.j(this.c, realConnection);
                    return realConnection;
                }
            }
            p31.c(ki2VarC);
            this.j = null;
            realConnection.g(i, i2, i3, i4, z, this.c, this.d);
            this.c.x(null);
            this.c.j().t().a(realConnection.B());
            if (this.a.a(this.b, this.c, listA, true)) {
                RealConnection realConnectionK6 = this.c.k();
                p31.c(realConnectionK6);
                this.j = ki2VarC;
                pa3.n(realConnection.F());
                this.d.j(this.c, realConnectionK6);
                return realConnectionK6;
            }
            synchronized (realConnection) {
                this.a.e(realConnection);
                this.c.c(realConnection);
                k83 k83Var4 = k83.a;
                this.d.j(this.c, realConnection);
                return realConnection;
            }
        } catch (Throwable th2) {
            this.c.x(null);
            throw th2;
        }
        listA = null;
        realConnection = new RealConnection(this.a, ki2VarC);
        this.c.x(realConnection);
    }

    private final RealConnection c(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            RealConnection realConnectionB = b(i, i2, i3, i4, z);
            if (realConnectionB.v(z2)) {
                return realConnectionB;
            }
            realConnectionB.A();
            if (this.j == null) {
                mi2.b bVar = this.e;
                if (bVar != null ? bVar.b() : true) {
                    continue;
                } else {
                    mi2 mi2Var = this.f;
                    if (!(mi2Var != null ? mi2Var.a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    private final ki2 f() {
        RealConnection realConnectionK;
        if (this.g > 1 || this.h > 1 || this.i > 0 || (realConnectionK = this.c.k()) == null) {
            return null;
        }
        synchronized (realConnectionK) {
            if (realConnectionK.r() != 0) {
                return null;
            }
            if (pa3.j(realConnectionK.B().a().l(), this.b.l())) {
                return realConnectionK.B();
            }
            return null;
        }
    }

    public final ri0 a(zt1 zt1Var, jd2 jd2Var) {
        p31.f(zt1Var, "client");
        p31.f(jd2Var, "chain");
        try {
            return c(jd2Var.f(), jd2Var.h(), jd2Var.j(), zt1Var.A(), zt1Var.G(), !p31.a(jd2Var.i().g(), Constants.HTTP_GET)).x(zt1Var, jd2Var);
        } catch (IOException e) {
            h(e);
            throw new RouteException(e);
        } catch (RouteException e2) {
            h(e2.getLastConnectException());
            throw e2;
        }
    }

    public final v4 d() {
        return this.b;
    }

    public final boolean e() {
        mi2 mi2Var;
        if (this.g == 0 && this.h == 0 && this.i == 0) {
            return false;
        }
        if (this.j != null) {
            return true;
        }
        ki2 ki2VarF = f();
        if (ki2VarF != null) {
            this.j = ki2VarF;
            return true;
        }
        mi2.b bVar = this.e;
        if ((bVar == null || !bVar.b()) && (mi2Var = this.f) != null) {
            return mi2Var.a();
        }
        return true;
    }

    public final boolean g(tx0 tx0Var) {
        p31.f(tx0Var, SocialConstants.PARAM_URL);
        tx0 tx0VarL = this.b.l();
        return tx0Var.n() == tx0VarL.n() && p31.a(tx0Var.h(), tx0VarL.h());
    }

    public final void h(IOException iOException) {
        p31.f(iOException, "e");
        this.j = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
            this.g++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.h++;
        } else {
            this.i++;
        }
    }
}
