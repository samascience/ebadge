package defpackage;

import com.jieli.lib.gif.GifError;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import com.tencent.connect.common.Constants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.j;
import kotlin.text.Regex;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;

/* JADX INFO: loaded from: classes4.dex */
public final class ph2 implements l31 {
    public static final a b = new a(null);
    private final zt1 a;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public ph2(zt1 zt1Var) {
        p31.f(zt1Var, "client");
        this.a = zt1Var;
    }

    private final df2 a(eh2 eh2Var, String str) {
        String strG0;
        tx0 tx0VarQ;
        if (!this.a.r() || (strG0 = eh2.g0(eh2Var, "Location", null, 2, null)) == null || (tx0VarQ = eh2Var.G0().i().q(strG0)) == null) {
            return null;
        }
        if (!p31.a(tx0VarQ.r(), eh2Var.G0().i().r()) && !this.a.s()) {
            return null;
        }
        df2.a aVarH = eh2Var.G0().h();
        if (rx0.a(str)) {
            int iC = eh2Var.C();
            rx0 rx0Var = rx0.a;
            boolean z = rx0Var.c(str) || iC == 308 || iC == 307;
            if (!rx0Var.b(str) || iC == 308 || iC == 307) {
                aVarH.i(str, z ? eh2Var.G0().a() : null);
            } else {
                aVarH.i(Constants.HTTP_GET, null);
            }
            if (!z) {
                aVarH.k("Transfer-Encoding");
                aVarH.k("Content-Length");
                aVarH.k("Content-Type");
            }
        }
        if (!pa3.j(eh2Var.G0().i(), tx0VarQ)) {
            aVarH.k("Authorization");
        }
        return aVarH.l(tx0VarQ).b();
    }

    private final df2 b(eh2 eh2Var, qi0 qi0Var) throws ProtocolException {
        RealConnection realConnectionH;
        ki2 ki2VarB = (qi0Var == null || (realConnectionH = qi0Var.h()) == null) ? null : realConnectionH.B();
        int iC = eh2Var.C();
        String strG = eh2Var.G0().g();
        if (iC != 307 && iC != 308) {
            if (iC == 401) {
                return this.a.e().a(ki2VarB, eh2Var);
            }
            if (iC == 421) {
                ff2 ff2VarA = eh2Var.G0().a();
                if ((ff2VarA != null && ff2VarA.isOneShot()) || qi0Var == null || !qi0Var.l()) {
                    return null;
                }
                qi0Var.h().z();
                return eh2Var.G0();
            }
            if (iC == 503) {
                eh2 eh2VarY0 = eh2Var.y0();
                if ((eh2VarY0 == null || eh2VarY0.C() != 503) && f(eh2Var, Integer.MAX_VALUE) == 0) {
                    return eh2Var.G0();
                }
                return null;
            }
            if (iC == 407) {
                p31.c(ki2VarB);
                if (ki2VarB.b().type() == Proxy.Type.HTTP) {
                    return this.a.D().a(ki2VarB, eh2Var);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iC == 408) {
                if (!this.a.G()) {
                    return null;
                }
                ff2 ff2VarA2 = eh2Var.G0().a();
                if (ff2VarA2 != null && ff2VarA2.isOneShot()) {
                    return null;
                }
                eh2 eh2VarY1 = eh2Var.y0();
                if ((eh2VarY1 == null || eh2VarY1.C() != 408) && f(eh2Var, 0) <= 0) {
                    return eh2Var.G0();
                }
                return null;
            }
            switch (iC) {
                case ChartCoordinateportAnimator.FAST_ANIMATION_DURATION /* 300 */:
                case GifError.ERR_INVALID_PARAM /* 301 */:
                case GifError.ERR_OP_IN_PROGRESS /* 302 */:
                case GifError.ERR_SAVE_FILE /* 303 */:
                    break;
                default:
                    return null;
            }
        }
        return a(eh2Var, strG);
    }

    private final boolean c(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return (iOException instanceof SocketTimeoutException) && !z;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean d(IOException iOException, gd2 gd2Var, df2 df2Var, boolean z) {
        if (this.a.G()) {
            return !(z && e(iOException, df2Var)) && c(iOException, z) && gd2Var.w();
        }
        return false;
    }

    private final boolean e(IOException iOException, df2 df2Var) {
        ff2 ff2VarA = df2Var.a();
        return (ff2VarA != null && ff2VarA.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private final int f(eh2 eh2Var, int i) {
        String strG0 = eh2.g0(eh2Var, "Retry-After", null, 2, null);
        if (strG0 == null) {
            return i;
        }
        if (!new Regex("\\d+").matches(strG0)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strG0);
        p31.e(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }

    @Override // defpackage.l31
    public eh2 intercept(l31.a aVar) {
        eh2 eh2VarA;
        p31.f(aVar, "chain");
        jd2 jd2Var = (jd2) aVar;
        df2 df2VarI = jd2Var.i();
        gd2 gd2VarE = jd2Var.e();
        List listJ = j.j();
        int i = 0;
        eh2 eh2Var = null;
        while (true) {
            boolean z = true;
            while (true) {
                gd2VarE.h(df2VarI, z);
                try {
                    if (gd2VarE.isCanceled()) {
                        throw new IOException("Canceled");
                    }
                    try {
                        eh2VarA = jd2Var.a(df2VarI);
                    } catch (IOException e) {
                        if (!d(e, gd2VarE, df2VarI, !(e instanceof ConnectionShutdownException))) {
                            throw pa3.a0(e, listJ);
                        }
                        listJ = j.R(listJ, e);
                        gd2VarE.i(true);
                        z = false;
                    } catch (RouteException e2) {
                        if (!d(e2.getLastConnectException(), gd2VarE, df2VarI, false)) {
                            throw pa3.a0(e2.getFirstConnectException(), listJ);
                        }
                        listJ = j.R(listJ, e2.getFirstConnectException());
                        gd2VarE.i(true);
                        z = false;
                    }
                    gd2VarE.i(true);
                    z = false;
                } catch (Throwable th) {
                    gd2VarE.i(true);
                    throw th;
                }
            }
            if (eh2Var != null) {
                eh2VarA = eh2VarA.w0().o(eh2Var.w0().b(null).c()).c();
            }
            eh2Var = eh2VarA;
            qi0 qi0VarO = gd2VarE.o();
            df2 df2VarB = b(eh2Var, qi0VarO);
            if (df2VarB == null) {
                if (qi0VarO != null && qi0VarO.m()) {
                    gd2VarE.y();
                }
                gd2VarE.i(false);
                return eh2Var;
            }
            ff2 ff2VarA = df2VarB.a();
            if (ff2VarA != null && ff2VarA.isOneShot()) {
                gd2VarE.i(false);
                return eh2Var;
            }
            fh2 fh2VarN = eh2Var.n();
            if (fh2VarN != null) {
                pa3.m(fh2VarN);
            }
            i++;
            if (i > 20) {
                throw new ProtocolException("Too many follow-up requests: " + i);
            }
            gd2VarE.i(true);
            df2VarI = df2VarB;
        }
    }
}
