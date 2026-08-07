package com.baidu.location.d;

import android.util.Log;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ WeakReference a;
    final /* synthetic */ a b;

    b(a aVar, WeakReference weakReference) {
        this.b = aVar;
        this.a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = (a) this.a.get();
        if (aVar == null || aVar.e != 3) {
            return;
        }
        Log.d("baidu_location_service", "baidu location service force stopped ...");
        aVar.f = false;
        aVar.h();
    }
}
