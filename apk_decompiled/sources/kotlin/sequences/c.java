package kotlin.sequences;

import defpackage.j70;
import defpackage.k81;
import defpackage.k83;
import defpackage.p31;
import defpackage.sm2;
import defpackage.x30;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
final class c extends sm2 implements Iterator, x30, k81 {
    private int a;
    private Object b;
    private Iterator c;
    private x30 d;

    private final Throwable d() {
        int i = this.a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.a);
    }

    private final Object e() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // defpackage.sm2
    public Object a(Object obj, x30 x30Var) {
        this.b = obj;
        this.a = 3;
        this.d = x30Var;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        if (objD == kotlin.coroutines.intrinsics.a.d()) {
            j70.c(x30Var);
        }
        return objD == kotlin.coroutines.intrinsics.a.d() ? objD : k83.a;
    }

    @Override // defpackage.sm2
    public Object c(Iterator it, x30 x30Var) {
        if (!it.hasNext()) {
            return k83.a;
        }
        this.c = it;
        this.a = 2;
        this.d = x30Var;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        if (objD == kotlin.coroutines.intrinsics.a.d()) {
            j70.c(x30Var);
        }
        return objD == kotlin.coroutines.intrinsics.a.d() ? objD : k83.a;
    }

    public final void f(x30 x30Var) {
        this.d = x30Var;
    }

    @Override // defpackage.x30
    public kotlin.coroutines.d getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw d();
                }
                Iterator it = this.c;
                p31.c(it);
                if (it.hasNext()) {
                    this.a = 2;
                    return true;
                }
                this.c = null;
            }
            this.a = 5;
            x30 x30Var = this.d;
            p31.c(x30Var);
            this.d = null;
            Result.a aVar = Result.Companion;
            x30Var.resumeWith(Result.m69constructorimpl(k83.a));
        }
    }

    @Override // java.util.Iterator
    public Object next() throws Throwable {
        int i = this.a;
        if (i == 0 || i == 1) {
            return e();
        }
        if (i == 2) {
            this.a = 1;
            Iterator it = this.c;
            p31.c(it);
            return it.next();
        }
        if (i != 3) {
            throw d();
        }
        this.a = 0;
        Object obj = this.b;
        this.b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // defpackage.x30
    public void resumeWith(Object obj) throws Throwable {
        kotlin.d.b(obj);
        this.a = 4;
    }
}
