package pl.droidsonroids.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes4.dex */
final class c extends ScheduledThreadPoolExecutor {

    private static final class b {
        private static final c a = new c();
    }

    static c a() {
        return b.a;
    }

    private c() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }
}
