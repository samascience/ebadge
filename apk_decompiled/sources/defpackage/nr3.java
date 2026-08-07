package defpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public abstract class nr3 {
    private static final ExecutorService a = Executors.newFixedThreadPool(2, new ms1("GAC_Executor"));

    public static ExecutorService a() {
        return a;
    }
}
