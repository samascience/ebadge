package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import defpackage.mn2;
import defpackage.ub1;

/* JADX INFO: loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {
    mn2 f;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Worker.this.f.p(Worker.this.q());
            } catch (Throwable th) {
                Worker.this.f.q(th);
            }
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    public final ub1 o() {
        this.f = mn2.t();
        c().execute(new a());
        return this.f;
    }

    public abstract ListenableWorker.a q();
}
