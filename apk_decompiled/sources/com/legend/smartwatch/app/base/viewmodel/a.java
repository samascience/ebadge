package com.legend.smartwatch.app.base.viewmodel;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.o;
import defpackage.ar0;
import defpackage.di0;
import defpackage.e43;
import defpackage.im1;
import defpackage.mg;
import defpackage.p31;
import defpackage.y70;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.collections.j;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes3.dex */
public class a extends o {
    private final CompletableJob d;
    private final CoroutineScope e;
    private final CoroutineScope f;
    private final String g;
    private final Handler h;
    private final Map i;
    private final im1 j;
    private final List k;
    private final Map l;

    /* JADX INFO: renamed from: com.legend.smartwatch.app.base.viewmodel.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0097a {

        /* JADX INFO: renamed from: com.legend.smartwatch.app.base.viewmodel.a$a$a, reason: collision with other inner class name */
        public static final class C0098a extends AbstractC0097a {
            private final Object a;

            public C0098a(Object obj) {
                super(null);
                this.a = obj;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0098a) && p31.a(this.a, ((C0098a) obj).a);
            }

            public int hashCode() {
                Object obj = this.a;
                if (obj == null) {
                    return 0;
                }
                return obj.hashCode();
            }

            public String toString() {
                return "Done(data=" + this.a + ")";
            }
        }

        /* JADX INFO: renamed from: com.legend.smartwatch.app.base.viewmodel.a$a$b */
        public static final class b extends AbstractC0097a {
            private final Throwable a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Throwable th) {
                super(null);
                p31.f(th, "error");
                this.a = th;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && p31.a(this.a, ((b) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "Error(error=" + this.a + ")";
            }
        }

        /* JADX INFO: renamed from: com.legend.smartwatch.app.base.viewmodel.a$a$c */
        public static final class c extends AbstractC0097a {
            public static final c a = new c();

            private c() {
                super(null);
            }
        }

        public /* synthetic */ AbstractC0097a(y70 y70Var) {
            this();
        }

        private AbstractC0097a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class b {
        public static final /* synthetic */ long a(b bVar) {
            throw null;
        }

        public static final /* synthetic */ ar0 b(b bVar) {
            throw null;
        }
    }

    public a() {
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.d = completableJobSupervisorJob$default;
        this.e = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(completableJobSupervisorJob$default));
        this.f = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(completableJobSupervisorJob$default));
        this.g = getClass().getSimpleName();
        Looper looperMyLooper = Looper.myLooper();
        p31.c(looperMyLooper);
        this.h = new Handler(looperMyLooper);
        this.i = new LinkedHashMap();
        this.j = new im1();
        di0.b(this);
        this.k = new ArrayList();
        this.l = new LinkedHashMap();
    }

    public static /* synthetic */ void k(a aVar, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logE");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        aVar.j(str, th);
    }

    @Override // androidx.lifecycle.o
    protected void d() {
        super.d();
        i("onCleared: ");
        Job.DefaultImpls.cancel$default((Job) this.d, (CancellationException) null, 1, (Object) null);
        di0.c(this);
        o();
        this.k.clear();
        n();
    }

    public final im1 f() {
        return this.j;
    }

    protected final String h() {
        return this.g;
    }

    public final void i(String str) {
        p31.f(str, "message");
        Log.d(this.g, str);
    }

    protected final void j(String str, Throwable th) {
        p31.f(str, "message");
        if (th != null) {
            Log.e(this.g, str, th);
        } else {
            Log.e(this.g, str);
        }
    }

    protected final void l(String str) {
        p31.f(str, "message");
        Log.w(this.g, str);
    }

    protected void m(mg mgVar) {
    }

    protected final void n() {
        this.l.clear();
    }

    protected final void o() {
        this.i.clear();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvents(mg mgVar) {
        List listX;
        if (mgVar != null) {
            List list = (List) this.l.get(mgVar.getClass());
            if (list != null && (listX = j.X(list)) != null) {
                Iterator it = listX.iterator();
                if (it.hasNext()) {
                    e43.a(it.next());
                    p31.d(null, "null cannot be cast to non-null type com.legend.smartwatch.app.base.viewmodel.BaseViewModel.OnEventListener<xfkj.fitpro.event.BaseEvent>");
                    throw null;
                }
            }
        }
        m(mgVar);
    }
}
