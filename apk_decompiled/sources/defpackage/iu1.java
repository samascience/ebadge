package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
abstract /* synthetic */ class iu1 {
    private static final Logger a = Logger.getLogger("okio.Okio");

    public static final boolean b(AssertionError assertionError) {
        p31.f(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? i.M(message, "getsockname failed", false, 2, null) : false;
    }

    public static final er2 c(Socket socket) throws IOException {
        p31.f(socket, "<this>");
        vr2 vr2Var = new vr2(socket);
        OutputStream outputStream = socket.getOutputStream();
        p31.e(outputStream, "getOutputStream(...)");
        return vr2Var.z(new hy1(outputStream, vr2Var));
    }

    public static final ks2 d(File file) {
        p31.f(file, "<this>");
        return new x21(new FileInputStream(file), h33.e);
    }

    public static final ks2 e(InputStream inputStream) {
        p31.f(inputStream, "<this>");
        return new x21(inputStream, new h33());
    }

    public static final ks2 f(Socket socket) throws IOException {
        p31.f(socket, "<this>");
        vr2 vr2Var = new vr2(socket);
        InputStream inputStream = socket.getInputStream();
        p31.e(inputStream, "getInputStream(...)");
        return vr2Var.A(new x21(inputStream, vr2Var));
    }
}
