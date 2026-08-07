package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.f;
import defpackage.db1;

/* JADX INFO: loaded from: classes.dex */
class FragmentStateAdapter$5 implements f {
    final /* synthetic */ Handler a;
    final /* synthetic */ Runnable b;

    @Override // androidx.lifecycle.f
    public void c(db1 db1Var, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.a.removeCallbacks(this.b);
            db1Var.getLifecycle().d(this);
        }
    }
}
