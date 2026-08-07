package com.bumptech.glide.request;

import defpackage.ef2;

/* JADX INFO: loaded from: classes.dex */
public interface RequestCoordinator {

    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        RequestState(boolean z) {
            this.isComplete = z;
        }

        boolean isComplete() {
            return this.isComplete;
        }
    }

    void a(ef2 ef2Var);

    boolean b();

    void c(ef2 ef2Var);

    boolean d(ef2 ef2Var);

    boolean g(ef2 ef2Var);

    RequestCoordinator getRoot();

    boolean h(ef2 ef2Var);
}
