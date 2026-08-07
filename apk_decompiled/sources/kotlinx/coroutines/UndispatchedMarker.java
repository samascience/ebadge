package kotlinx.coroutines;

import defpackage.or0;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
final class UndispatchedMarker implements d.b, d.c {
    public static final UndispatchedMarker INSTANCE = new UndispatchedMarker();

    private UndispatchedMarker() {
    }

    @Override // kotlin.coroutines.d
    public <R> R fold(R r, or0 or0Var) {
        return (R) d.b.a.a(this, r, or0Var);
    }

    @Override // kotlin.coroutines.d.b, kotlin.coroutines.d
    public <E extends d.b> E get(d.c cVar) {
        return (E) d.b.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.d.b
    public d.c getKey() {
        return this;
    }

    @Override // kotlin.coroutines.d
    public d minusKey(d.c cVar) {
        return d.b.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.d
    public d plus(d dVar) {
        return d.b.a.d(this, dVar);
    }
}
