package defpackage;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class p3 {
    public static volatile p3 b;
    private final List a = new ArrayList();

    public static p3 c() {
        if (b == null) {
            synchronized (p3.class) {
                try {
                    if (b == null) {
                        b = new p3();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void a(Activity activity) {
        if (activity != null) {
            this.a.add(activity);
        }
    }

    public void b() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((Activity) it.next()).finish();
        }
    }
}
