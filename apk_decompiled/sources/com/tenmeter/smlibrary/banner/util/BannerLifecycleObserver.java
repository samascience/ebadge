package com.tenmeter.smlibrary.banner.util;

import defpackage.cb1;
import defpackage.db1;

/* JADX INFO: loaded from: classes3.dex */
public interface BannerLifecycleObserver extends cb1 {
    void onDestroy(db1 db1Var);

    void onStart(db1 db1Var);

    void onStop(db1 db1Var);
}
