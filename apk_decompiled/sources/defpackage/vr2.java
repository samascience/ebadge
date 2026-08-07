package defpackage;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
final class vr2 extends bb {
    private final Socket o;

    public vr2(Socket socket) {
        p31.f(socket, "socket");
        this.o = socket;
    }

    @Override // defpackage.bb
    protected void B() {
        try {
            this.o.close();
        } catch (AssertionError e) {
            if (!hu1.c(e)) {
                throw e;
            }
            iu1.a.log(Level.WARNING, "Failed to close timed out socket " + this.o, (Throwable) e);
        } catch (Exception e2) {
            iu1.a.log(Level.WARNING, "Failed to close timed out socket " + this.o, (Throwable) e2);
        }
    }

    @Override // defpackage.bb
    protected IOException x(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
