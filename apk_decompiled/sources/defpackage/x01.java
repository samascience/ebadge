package defpackage;

import android.view.Surface;
import androidx.camera.core.v;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface x01 {

    public interface a {
        void a(x01 x01Var);
    }

    Surface a();

    v c();

    void close();

    int d();

    void e();

    void f(a aVar, Executor executor);

    int g();

    int getHeight();

    int getWidth();

    v h();
}
