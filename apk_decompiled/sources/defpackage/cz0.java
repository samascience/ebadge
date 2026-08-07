package defpackage;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public class cz0 implements bz0 {
    private final vd1 a = new vd1();
    private final ReentrantLock b = new ReentrantLock();

    @Override // defpackage.bz0
    public void c(int i) {
        this.a.e(i);
    }

    @Override // defpackage.bz0
    public void clear() {
        this.b.lock();
        try {
            this.a.a();
        } finally {
            this.b.unlock();
        }
    }

    @Override // defpackage.bz0
    public void e(Iterable iterable) {
        this.b.lock();
        try {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                this.a.d(((Long) it.next()).longValue());
            }
            this.b.unlock();
        } catch (Throwable th) {
            this.b.unlock();
            throw th;
        }
    }

    @Override // defpackage.bz0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean d(Long l, Object obj) {
        ReentrantLock reentrantLock;
        this.b.lock();
        try {
            if (get(l) != obj || obj == null) {
                return false;
            }
            remove(l);
            return true;
        } finally {
            this.b.unlock();
        }
    }

    @Override // defpackage.bz0
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Object get(Long l) {
        return h(l.longValue());
    }

    public Object h(long j) {
        this.b.lock();
        try {
            Reference reference = (Reference) this.a.b(j);
            this.b.unlock();
            if (reference != null) {
                return reference.get();
            }
            return null;
        } catch (Throwable th) {
            this.b.unlock();
            throw th;
        }
    }

    public Object i(long j) {
        Reference reference = (Reference) this.a.b(j);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    @Override // defpackage.bz0
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object b(Long l) {
        return i(l.longValue());
    }

    @Override // defpackage.bz0
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void put(Long l, Object obj) {
        l(l.longValue(), obj);
    }

    public void l(long j, Object obj) {
        this.b.lock();
        try {
            this.a.c(j, new WeakReference(obj));
        } finally {
            this.b.unlock();
        }
    }

    @Override // defpackage.bz0
    public void lock() {
        this.b.lock();
    }

    public void m(long j, Object obj) {
        this.a.c(j, new WeakReference(obj));
    }

    @Override // defpackage.bz0
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void a(Long l, Object obj) {
        m(l.longValue(), obj);
    }

    @Override // defpackage.bz0
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void remove(Long l) {
        this.b.lock();
        try {
            this.a.d(l.longValue());
        } finally {
            this.b.unlock();
        }
    }

    @Override // defpackage.bz0
    public void unlock() {
        this.b.unlock();
    }
}
