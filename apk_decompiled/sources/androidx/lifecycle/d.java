package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d;
import com.tencent.open.SocialConstants;
import defpackage.db1;
import defpackage.gc0;
import defpackage.p31;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private final Lifecycle a;
    private final Lifecycle.State b;
    private final gc0 c;
    private final f d;

    public d(Lifecycle lifecycle, Lifecycle.State state, gc0 gc0Var, final Job job) {
        p31.f(lifecycle, "lifecycle");
        p31.f(state, "minState");
        p31.f(gc0Var, "dispatchQueue");
        p31.f(job, "parentJob");
        this.a = lifecycle;
        this.b = state;
        this.c = gc0Var;
        f fVar = new f() { // from class: xa1
            @Override // androidx.lifecycle.f
            public final void c(db1 db1Var, Lifecycle.Event event) {
                d.c(this.a, job, db1Var, event);
            }
        };
        this.d = fVar;
        if (lifecycle.b() != Lifecycle.State.DESTROYED) {
            lifecycle.a(fVar);
        } else {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(d dVar, Job job, db1 db1Var, Lifecycle.Event event) {
        p31.f(dVar, "this$0");
        p31.f(job, "$parentJob");
        p31.f(db1Var, SocialConstants.PARAM_SOURCE);
        p31.f(event, "<anonymous parameter 1>");
        if (db1Var.getLifecycle().b() == Lifecycle.State.DESTROYED) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            dVar.b();
        } else if (db1Var.getLifecycle().b().compareTo(dVar.b) < 0) {
            dVar.c.h();
        } else {
            dVar.c.i();
        }
    }

    public final void b() {
        this.a.d(this.d);
        this.c.g();
    }
}
