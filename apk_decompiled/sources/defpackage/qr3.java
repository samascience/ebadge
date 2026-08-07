package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public interface qr3 {
    void connect();

    b d(b bVar);

    void disconnect();

    void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    boolean f(wo2 wo2Var);

    void g();

    ConnectionResult h();

    boolean isConnected();
}
