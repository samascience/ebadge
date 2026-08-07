package io.reactivex;

import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    @NonNull
    ObservableSource<Downstream> apply(@NonNull Observable<Upstream> observable);
}
