package defpackage;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public class dz0 implements bz0 {
    private final HashMap a = new HashMap();
    private final ReentrantLock b = new ReentrantLock();

    @Override // defpackage.bz0
    public void a(Object obj, Object obj2) {
        this.a.put(obj, new WeakReference(obj2));
    }

    @Override // defpackage.bz0
    public Object b(Object obj) {
        Reference reference = (Reference) this.a.get(obj);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    @Override // defpackage.bz0
    public void c(int i) {
    }

    @Override // defpackage.bz0
    public void clear() {
        this.b.lock();
        try {
            this.a.clear();
        } finally {
            this.b.unlock();
        }
    }

    @Override // defpackage.bz0
    public boolean d(Object obj, Object obj2) {
        ReentrantLock reentrantLock;
        this.b.lock();
        try {
            if (get(obj) != obj2 || obj2 == null) {
                return false;
            }
            remove(obj);
            return true;
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
                this.a.remove(it.next());
            }
            this.b.unlock();
        } catch (Throwable th) {
            this.b.unlock();
            throw th;
        }
    }

    @Override // defpackage.bz0
    public Object get(Object obj) {
        this.b.lock();
        try {
            Reference reference = (Reference) this.a.get(obj);
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

    @Override // defpackage.bz0
    public void lock() {
        this.b.lock();
    }

    @Override // defpackage.bz0
    public void put(Object obj, Object obj2) {
        this.b.lock();
        try {
            this.a.put(obj, new WeakReference(obj2));
        } finally {
            this.b.unlock();
        }
    }

    @Override // defpackage.bz0
    public void remove(Object obj) {
        this.b.lock();
        try {
            this.a.remove(obj);
        } finally {
            this.b.unlock();
        }
    }

    @Override // defpackage.bz0
    public void unlock() {
        this.b.unlock();
    }
}
