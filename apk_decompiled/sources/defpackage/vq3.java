package defpackage;

import android.os.HandlerThread;

/* JADX INFO: loaded from: classes.dex */
public abstract class vq3 {
    private static HandlerThread a;

    public static synchronized HandlerThread a() {
        try {
            if (a == null) {
                try {
                    HandlerThread handlerThread = new HandlerThread("ServiceStartArguments", 10);
                    a = handlerThread;
                    handlerThread.start();
                } catch (Throwable th) {
                    th.printStackTrace();
                    a = null;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return a;
    }
}
