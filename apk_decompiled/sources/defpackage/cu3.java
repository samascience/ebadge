package defpackage;

import android.content.Context;
import android.util.Log;
import androidx.loader.content.a;
import com.google.android.gms.common.api.c;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class cu3 extends a implements wo2 {
    private Semaphore o;
    private Set p;

    public cu3(Context context, Set set) {
        super(context);
        this.o = new Semaphore(0);
        this.p = set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.loader.content.a
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public final Void A() {
        Iterator it = this.p.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((c) it.next()).o(this)) {
                i++;
            }
        }
        try {
            this.o.tryAcquire(i, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // androidx.loader.content.b
    protected final void o() {
        this.o.drainPermits();
        h();
    }

    @Override // defpackage.wo2
    public final void onComplete() {
        this.o.release();
    }
}
