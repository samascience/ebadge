package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class ok3 implements w03 {
    private final um2 a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private final Executor c = new a();

    class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ok3.this.d(runnable);
        }
    }

    public ok3(Executor executor) {
        this.a = new um2(executor);
    }

    @Override // defpackage.w03
    public Executor a() {
        return this.c;
    }

    @Override // defpackage.w03
    public void b(Runnable runnable) {
        this.a.execute(runnable);
    }

    @Override // defpackage.w03
    public um2 c() {
        return this.a;
    }

    public void d(Runnable runnable) {
        this.b.post(runnable);
    }
}
