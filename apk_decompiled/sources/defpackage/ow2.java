package defpackage;

import android.database.Cursor;
import android.os.CancellationSignal;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ow2 extends Closeable {
    Cursor P(rw2 rw2Var, CancellationSignal cancellationSignal);

    Cursor W(String str);

    String c();

    void d();

    void e(String str);

    sw2 g(String str);

    boolean isOpen();

    void j();

    void k(String str, Object[] objArr);

    void l();

    boolean r0();

    Cursor t(rw2 rw2Var);

    List v();
}
