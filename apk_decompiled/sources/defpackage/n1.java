package defpackage;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
abstract class n1 {
    final String a;
    final y0 b;
    final String[] c;
    final Map d = new HashMap();

    n1(y0 y0Var, String str, String[] strArr) {
        this.b = y0Var;
        this.a = str;
        this.c = strArr;
    }

    protected abstract m1 a();

    m1 b() {
        m1 m1VarA;
        long id = Thread.currentThread().getId();
        synchronized (this.d) {
            try {
                WeakReference weakReference = (WeakReference) this.d.get(Long.valueOf(id));
                m1VarA = weakReference != null ? (m1) weakReference.get() : null;
                if (m1VarA == null) {
                    d();
                    m1VarA = a();
                    this.d.put(Long.valueOf(id), new WeakReference(m1VarA));
                } else {
                    String[] strArr = this.c;
                    System.arraycopy(strArr, 0, m1VarA.d, 0, strArr.length);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return m1VarA;
    }

    m1 c(m1 m1Var) {
        if (Thread.currentThread() != m1Var.e) {
            return b();
        }
        String[] strArr = this.c;
        System.arraycopy(strArr, 0, m1Var.d, 0, strArr.length);
        return m1Var;
    }

    void d() {
        synchronized (this.d) {
            try {
                Iterator it = this.d.entrySet().iterator();
                while (it.hasNext()) {
                    if (((WeakReference) ((Map.Entry) it.next()).getValue()).get() == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
