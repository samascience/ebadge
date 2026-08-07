package defpackage;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.w;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface p23 extends w {
    public static final Config.a d = Config.a.a("camerax.core.thread.backgroundExecutor", Executor.class);

    default Executor S(Executor executor) {
        return (Executor) f(d, executor);
    }
}
