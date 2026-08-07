package defpackage;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class g20 implements ut1 {
    private static final g20 b = new g20(null);
    private final ub1 a;

    private g20(Object obj) {
        this.a = os0.p(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(ut1.a aVar) {
        try {
            aVar.a(this.a.get());
        } catch (InterruptedException | ExecutionException e) {
            aVar.onError(e);
        }
    }

    public static ut1 g(Object obj) {
        return obj == null ? b : new g20(obj);
    }

    @Override // defpackage.ut1
    public void a(Executor executor, final ut1.a aVar) {
        this.a.a(new Runnable() { // from class: f20
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f(aVar);
            }
        }, executor);
    }

    @Override // defpackage.ut1
    public ub1 d() {
        return this.a;
    }

    @Override // defpackage.ut1
    public void e(ut1.a aVar) {
    }
}
