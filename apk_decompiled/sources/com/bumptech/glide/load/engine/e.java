package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import defpackage.w81;
import defpackage.y50;

/* JADX INFO: loaded from: classes.dex */
interface e {

    public interface a {
        void b(w81 w81Var, Object obj, y50 y50Var, DataSource dataSource, w81 w81Var2);

        void c(w81 w81Var, Exception exc, y50 y50Var, DataSource dataSource);

        void d();
    }

    boolean a();

    void cancel();
}
