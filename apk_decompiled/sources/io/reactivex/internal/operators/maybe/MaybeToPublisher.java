package io.reactivex.internal.operators.maybe;

import defpackage.i92;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes4.dex */
public enum MaybeToPublisher implements Function<MaybeSource<Object>, i92> {
    INSTANCE;

    public static <T> Function<MaybeSource<T>, i92> instance() {
        return INSTANCE;
    }

    @Override // io.reactivex.functions.Function
    public i92 apply(MaybeSource<Object> maybeSource) throws Exception {
        return new MaybeToFlowable(maybeSource);
    }
}
