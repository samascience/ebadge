package defpackage;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class xq3 {
    private ExecutorService a;
    private ExecutorService b;

    private static class a {
        private static xq3 a = new xq3();
    }

    private xq3() {
        this.a = null;
        this.b = null;
    }

    public static xq3 a() {
        return a.a;
    }

    public synchronized ExecutorService b() {
        return this.a;
    }

    public synchronized ExecutorService c() {
        return this.b;
    }

    public void d() {
        ExecutorService executorService = this.a;
        if (executorService != null) {
            executorService.shutdown();
        }
        ExecutorService executorService2 = this.b;
        if (executorService2 != null) {
            executorService2.shutdown();
        }
    }
}
