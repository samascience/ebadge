package com.tenmeter.smlibrary.banner.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.j;
import defpackage.cb1;
import defpackage.db1;

/* JADX INFO: loaded from: classes3.dex */
public class BannerLifecycleObserverAdapter implements cb1 {
    private final db1 mLifecycleOwner;
    private final BannerLifecycleObserver mObserver;

    public BannerLifecycleObserverAdapter(db1 db1Var, BannerLifecycleObserver bannerLifecycleObserver) {
        this.mLifecycleOwner = db1Var;
        this.mObserver = bannerLifecycleObserver;
    }

    @j(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        LogUtils.i("onDestroy");
        this.mObserver.onDestroy(this.mLifecycleOwner);
    }

    @j(Lifecycle.Event.ON_START)
    public void onStart() {
        LogUtils.i("onStart");
        this.mObserver.onStart(this.mLifecycleOwner);
    }

    @j(Lifecycle.Event.ON_STOP)
    public void onStop() {
        LogUtils.i("onStop");
        this.mObserver.onStop(this.mLifecycleOwner);
    }
}
