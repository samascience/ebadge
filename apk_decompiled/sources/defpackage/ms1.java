package defpackage;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ms1 implements ThreadFactory {
    private final String a;
    private final AtomicInteger b = new AtomicInteger();
    private final ThreadFactory c = Executors.defaultThreadFactory();

    public ms1(String str) {
        a52.h(str, "Name must not be null");
        this.a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.c.newThread(new bt3(runnable, 0));
        threadNewThread.setName(this.a + "[" + this.b.getAndIncrement() + "]");
        return threadNewThread;
    }
}
