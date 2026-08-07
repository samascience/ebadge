package defpackage;

import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class np3 {
    public static int i = cn3.c;
    protected static int j;
    public String a = null;
    public int b = 1;
    public String c = null;
    public Map d = null;
    public String e = null;
    public byte[] f = null;
    public byte[] g = null;
    public String h = null;

    public abstract void a();

    public void b(ExecutorService executorService, String str) {
        try {
            executorService.execute(new yp3(this, str));
        } catch (Throwable unused) {
            d(false);
        }
    }

    public void c(ExecutorService executorService, boolean z, String str) {
        try {
            executorService.execute(new rp3(this, str, z));
        } catch (Throwable unused) {
            d(false);
        }
    }

    public abstract void d(boolean z);

    public void e(String str) {
        try {
            new vp3(this, str).start();
        } catch (Throwable unused) {
            d(false);
        }
    }
}
