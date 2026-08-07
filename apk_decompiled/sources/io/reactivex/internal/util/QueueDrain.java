package io.reactivex.internal.util;

import defpackage.cw2;

/* JADX INFO: loaded from: classes4.dex */
public interface QueueDrain<T, U> {
    boolean accept(cw2 cw2Var, T t);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int i);

    long produced(long j);

    long requested();
}
