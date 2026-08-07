package io.reactivex;

import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public interface MaybeOperator<Downstream, Upstream> {
    @NonNull
    MaybeObserver<? super Upstream> apply(@NonNull MaybeObserver<? super Downstream> maybeObserver) throws Exception;
}
