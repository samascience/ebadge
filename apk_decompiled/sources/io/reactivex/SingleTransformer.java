package io.reactivex;

import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public interface SingleTransformer<Upstream, Downstream> {
    @NonNull
    SingleSource<Downstream> apply(@NonNull Single<Upstream> single);
}
