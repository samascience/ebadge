package io.reactivex.internal.fuseable;

import defpackage.dw2;

/* JADX INFO: loaded from: classes4.dex */
public interface QueueSubscription<T> extends QueueFuseable<T>, dw2 {
    @Override // defpackage.dw2
    /* synthetic */ void cancel();

    @Override // defpackage.dw2
    /* synthetic */ void request(long j);
}
