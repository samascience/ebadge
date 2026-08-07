package defpackage;

import android.util.Log;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.k;
import androidx.camera.core.impl.utils.executor.c;
import androidx.camera.core.l;
import androidx.camera.core.v;
import androidx.camera.core.x;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class d03 implements l.a, i03.a {
    final rz0 b;
    r01 c;
    private sf2 d;
    private final List e;
    final Deque a = new ArrayDeque();
    boolean f = false;

    class a implements bs0 {
        final /* synthetic */ su a;

        a(su suVar) {
            this.a = suVar;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            if (this.a.b()) {
                return;
            }
            int iF = ((k) this.a.a().get(0)).f();
            if (th instanceof ImageCaptureException) {
                d03.this.c.j(b.c(iF, (ImageCaptureException) th));
            } else {
                d03.this.c.j(b.c(iF, new ImageCaptureException(2, "Failed to submit capture request", th)));
            }
            d03.this.b.c();
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r1) {
            d03.this.b.c();
        }
    }

    static abstract class b {
        b() {
        }

        static b c(int i, ImageCaptureException imageCaptureException) {
            return new sd(i, imageCaptureException);
        }

        abstract ImageCaptureException a();

        abstract int b();
    }

    public d03(rz0 rz0Var) {
        t23.a();
        this.b = rz0Var;
        this.e = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.d = null;
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(sf2 sf2Var) {
        this.e.remove(sf2Var);
    }

    private ub1 n(su suVar) {
        t23.a();
        this.b.b();
        ub1 ub1VarA = this.b.a(suVar.a());
        os0.j(ub1VarA, new a(suVar), c.e());
        return ub1VarA;
    }

    private void o(final sf2 sf2Var) {
        b52.i(!f());
        this.d = sf2Var;
        sf2Var.o().a(new Runnable() { // from class: a03
            @Override // java.lang.Runnable
            public final void run() {
                this.a.h();
            }
        }, c.b());
        this.e.add(sf2Var);
        sf2Var.p().a(new Runnable() { // from class: b03
            @Override // java.lang.Runnable
            public final void run() {
                this.a.i(sf2Var);
            }
        }, c.b());
    }

    @Override // i03.a
    public void a(i03 i03Var) {
        t23.a();
        x.a("TakePictureManager", "Add a new request for retrying.");
        this.a.addFirst(i03Var);
        g();
    }

    @Override // androidx.camera.core.l.a
    public void b(v vVar) {
        c.e().execute(new Runnable() { // from class: c03
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g();
            }
        });
    }

    public void e() {
        t23.a();
        ImageCaptureException imageCaptureException = new ImageCaptureException(3, "Camera is closed.", null);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((i03) it.next()).u(imageCaptureException);
        }
        this.a.clear();
        Iterator it2 = new ArrayList(this.e).iterator();
        while (it2.hasNext()) {
            ((sf2) it2.next()).l(imageCaptureException);
        }
    }

    boolean f() {
        return this.d != null;
    }

    void g() {
        t23.a();
        Log.d("TakePictureManager", "Issue the next TakePictureRequest.");
        if (f()) {
            Log.d("TakePictureManager", "There is already a request in-flight.");
            return;
        }
        if (this.f) {
            Log.d("TakePictureManager", "The class is paused.");
            return;
        }
        if (this.c.h() == 0) {
            Log.d("TakePictureManager", "Too many acquire images. Close image to be able to process next.");
            return;
        }
        i03 i03Var = (i03) this.a.poll();
        if (i03Var == null) {
            Log.d("TakePictureManager", "No new request.");
            return;
        }
        sf2 sf2Var = new sf2(i03Var, this);
        o(sf2Var);
        az1 az1VarE = this.c.e(i03Var, sf2Var, sf2Var.o());
        su suVar = (su) az1VarE.a;
        Objects.requireNonNull(suVar);
        k72 k72Var = (k72) az1VarE.b;
        Objects.requireNonNull(k72Var);
        this.c.m(k72Var);
        sf2Var.u(n(suVar));
    }

    public void j(i03 i03Var) {
        t23.a();
        this.a.offer(i03Var);
        g();
    }

    public void k() {
        t23.a();
        this.f = true;
        sf2 sf2Var = this.d;
        if (sf2Var != null) {
            sf2Var.m();
        }
    }

    public void l() {
        t23.a();
        this.f = false;
        g();
    }

    public void m(r01 r01Var) {
        t23.a();
        this.c = r01Var;
        r01Var.k(this);
    }
}
