package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class jm2 {
    public static final jm2 a = new jm2();
    private static final int b = 65536;
    private static final im2 c = new im2(new byte[0], 0, 0, false, false);
    private static final int d;
    private static final AtomicReference[] e;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        d = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        e = atomicReferenceArr;
    }

    private jm2() {
    }

    private final AtomicReference a() {
        return e[(int) (Thread.currentThread().getId() & (((long) d) - 1))];
    }

    public static final void b(im2 im2Var) {
        p31.f(im2Var, "segment");
        if (im2Var.f != null || im2Var.g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (im2Var.d) {
            return;
        }
        AtomicReference atomicReferenceA = a.a();
        im2 im2Var2 = c;
        im2 im2Var3 = (im2) atomicReferenceA.getAndSet(im2Var2);
        if (im2Var3 == im2Var2) {
            return;
        }
        int i = im2Var3 != null ? im2Var3.c : 0;
        if (i >= b) {
            atomicReferenceA.set(im2Var3);
            return;
        }
        im2Var.f = im2Var3;
        im2Var.b = 0;
        im2Var.c = i + 8192;
        atomicReferenceA.set(im2Var);
    }

    public static final im2 c() {
        AtomicReference atomicReferenceA = a.a();
        im2 im2Var = c;
        im2 im2Var2 = (im2) atomicReferenceA.getAndSet(im2Var);
        if (im2Var2 == im2Var) {
            return new im2();
        }
        if (im2Var2 == null) {
            atomicReferenceA.set(null);
            return new im2();
        }
        atomicReferenceA.set(im2Var2.f);
        im2Var2.f = null;
        im2Var2.c = 0;
        return im2Var2;
    }
}
