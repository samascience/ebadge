package kotlinx.coroutines;

import defpackage.ar0;
import defpackage.y70;
import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.coroutines.b;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {
    public static final Key Key = new Key(null);

    public static final class Key extends b {
        public /* synthetic */ Key(y70 y70Var) {
            this();
        }

        private Key() {
            super(CoroutineDispatcher.Key, new ar0() { // from class: kotlinx.coroutines.ExecutorCoroutineDispatcher.Key.1
                @Override // defpackage.ar0
                public final ExecutorCoroutineDispatcher invoke(d.b bVar) {
                    if (bVar instanceof ExecutorCoroutineDispatcher) {
                        return (ExecutorCoroutineDispatcher) bVar;
                    }
                    return null;
                }
            });
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract Executor getExecutor();
}
