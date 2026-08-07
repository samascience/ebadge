package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okhttp3.b;

/* JADX INFO: loaded from: classes4.dex */
public final class u10 {
    private final List a;
    private int b;
    private boolean c;
    private boolean d;

    public u10(List list) {
        p31.f(list, "connectionSpecs");
        this.a = list;
    }

    private final boolean c(SSLSocket sSLSocket) {
        int size = this.a.size();
        for (int i = this.b; i < size; i++) {
            if (((b) this.a.get(i)).e(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public final b a(SSLSocket sSLSocket) throws UnknownServiceException {
        b bVar;
        p31.f(sSLSocket, "sslSocket");
        int i = this.b;
        int size = this.a.size();
        while (true) {
            if (i >= size) {
                bVar = null;
                break;
            }
            bVar = (b) this.a.get(i);
            if (bVar.e(sSLSocket)) {
                this.b = i + 1;
                break;
            }
            i++;
        }
        if (bVar != null) {
            this.c = c(sSLSocket);
            bVar.c(sSLSocket, this.d);
            return bVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.d);
        sb.append(", modes=");
        sb.append(this.a);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        p31.c(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        p31.e(string, "toString(this)");
        sb.append(string);
        throw new UnknownServiceException(sb.toString());
    }

    public final boolean b(IOException iOException) {
        p31.f(iOException, "e");
        this.d = true;
        return (!this.c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException) || ((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) || !(iOException instanceof SSLException)) ? false : true;
    }
}
