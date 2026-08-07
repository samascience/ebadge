package defpackage;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public class x9 implements xh2 {
    private final int a;
    private final ArrayDeque b;
    private final Object c;
    final xh2.a d;

    public x9(int i) {
        this(i, null);
    }

    @Override // defpackage.xh2
    public Object a() {
        Object objRemoveLast;
        synchronized (this.c) {
            objRemoveLast = this.b.removeLast();
        }
        return objRemoveLast;
    }

    @Override // defpackage.xh2
    public void b(Object obj) {
        Object objA;
        synchronized (this.c) {
            try {
                objA = this.b.size() >= this.a ? a() : null;
                this.b.addFirst(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        xh2.a aVar = this.d;
        if (aVar == null || objA == null) {
            return;
        }
        aVar.a(objA);
    }

    @Override // defpackage.xh2
    public boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (this.c) {
            zIsEmpty = this.b.isEmpty();
        }
        return zIsEmpty;
    }

    public x9(int i, xh2.a aVar) {
        this.c = new Object();
        this.a = i;
        this.b = new ArrayDeque(i);
        this.d = aVar;
    }
}
