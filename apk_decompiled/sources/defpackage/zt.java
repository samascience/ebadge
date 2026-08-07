package defpackage;

import androidx.camera.core.impl.Timebase;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface zt extends yt {
    Set b();

    boolean c();

    String d();

    default zt e() {
        return this;
    }

    void g(Executor executor, as asVar);

    Timebase h();

    List j(int i);

    dh0 l();

    w92 m();

    List n(int i);

    void o(as asVar);
}
