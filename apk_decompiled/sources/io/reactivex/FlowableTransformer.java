package io.reactivex;

import defpackage.i92;
import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public interface FlowableTransformer<Upstream, Downstream> {
    @NonNull
    i92 apply(@NonNull Flowable<Upstream> flowable);
}
