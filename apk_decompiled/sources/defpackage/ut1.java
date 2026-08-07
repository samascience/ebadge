package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface ut1 {

    public interface a {
        void a(Object obj);

        void onError(Throwable th);
    }

    void a(Executor executor, a aVar);

    ub1 d();

    void e(a aVar);
}
