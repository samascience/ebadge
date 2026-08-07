package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class ThreadLocalKt {
    public static /* synthetic */ void CommonThreadLocal$annotations() {
    }

    public static final <T> ThreadLocal<T> commonThreadLocal(Symbol symbol) {
        return new ThreadLocal<>();
    }
}
