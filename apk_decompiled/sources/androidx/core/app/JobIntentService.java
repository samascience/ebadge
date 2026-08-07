package androidx.core.app;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class JobIntentService extends Service {
    static final Object h = new Object();
    static final HashMap i = new HashMap();
    b a;
    f b;
    a c;
    boolean d = false;
    boolean e = false;
    boolean f = false;
    final ArrayList g = null;

    final class a extends AsyncTask {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                d dVarA = JobIntentService.this.a();
                if (dVarA == null) {
                    return null;
                }
                JobIntentService.this.d(dVarA.getIntent());
                dVarA.complete();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r1) {
            JobIntentService.this.f();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r1) {
            JobIntentService.this.f();
        }
    }

    interface b {
        IBinder a();

        d b();
    }

    final class c implements d {
        final Intent a;
        final int b;

        c(Intent intent, int i) {
            this.a = intent;
            this.b = i;
        }

        @Override // androidx.core.app.JobIntentService.d
        public void complete() {
            JobIntentService.this.stopSelf(this.b);
        }

        @Override // androidx.core.app.JobIntentService.d
        public Intent getIntent() {
            return this.a;
        }
    }

    interface d {
        void complete();

        Intent getIntent();
    }

    static final class e extends JobServiceEngine implements b {
        final JobIntentService a;
        final Object b;
        JobParameters c;

        final class a implements d {
            final JobWorkItem a;

            a(JobWorkItem jobWorkItem) {
                this.a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.d
            public void complete() {
                synchronized (e.this.b) {
                    try {
                        JobParameters jobParameters = e.this.c;
                        if (jobParameters != null) {
                            jobParameters.completeWork(this.a);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.d
            public Intent getIntent() {
                return this.a.getIntent();
            }
        }

        e(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.b = new Object();
            this.a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.b
        public IBinder a() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.b
        public d b() {
            synchronized (this.b) {
                try {
                    JobParameters jobParameters = this.c;
                    if (jobParameters == null) {
                        return null;
                    }
                    JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                    if (jobWorkItemDequeueWork == null) {
                        return null;
                    }
                    jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.a.getClassLoader());
                    return new a(jobWorkItemDequeueWork);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.c = jobParameters;
            this.a.c(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean zB = this.a.b();
            synchronized (this.b) {
                this.c = null;
            }
            return zB;
        }
    }

    static abstract class f {
        public abstract void a();

        public abstract void b();

        public abstract void c();
    }

    d a() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.g) {
            try {
                if (this.g.size() <= 0) {
                    return null;
                }
                return (d) this.g.remove(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean b() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.cancel(this.d);
        }
        this.e = true;
        return e();
    }

    void c(boolean z) {
        if (this.c == null) {
            this.c = new a();
            this.c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    protected abstract void d(Intent intent);

    public boolean e() {
        return true;
    }

    void f() {
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.c = null;
                    ArrayList arrayList2 = this.g;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        c(false);
                    } else if (!this.f) {
                        this.b.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.a = new e(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f = true;
                this.b.a();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (this.g == null) {
            return 2;
        }
        this.b.c();
        synchronized (this.g) {
            ArrayList arrayList = this.g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new c(intent, i3));
            c(true);
        }
        return 3;
    }
}
