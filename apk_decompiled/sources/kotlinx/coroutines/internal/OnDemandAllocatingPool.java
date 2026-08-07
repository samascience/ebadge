package kotlinx.coroutines.internal;

import com.tencent.connect.common.Constants;
import defpackage.ar0;
import defpackage.b31;
import defpackage.e31;
import defpackage.ga2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes4.dex */
public final class OnDemandAllocatingPool<T> {
    private static final AtomicIntegerFieldUpdater controlState$FU = AtomicIntegerFieldUpdater.newUpdater(OnDemandAllocatingPool.class, "controlState");
    private volatile int controlState;
    private final ar0 create;
    private final AtomicReferenceArray elements;
    private final int maxCapacity;

    public OnDemandAllocatingPool(int i, ar0 ar0Var) {
        this.maxCapacity = i;
        this.create = ar0Var;
        this.elements = new AtomicReferenceArray(i);
    }

    private final boolean isClosed(int i) {
        return (i & Integer.MIN_VALUE) != 0;
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, ar0 ar0Var, Object obj) {
        while (true) {
            ar0Var.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    private final int tryForbidNewElements() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = controlState$FU;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if ((i & Integer.MIN_VALUE) != 0) {
                return 0;
            }
        } while (!controlState$FU.compareAndSet(this, i, Integer.MIN_VALUE | i));
        return i;
    }

    public final boolean allocate() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = controlState$FU;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if ((Integer.MIN_VALUE & i) != 0) {
                return false;
            }
            if (i >= this.maxCapacity) {
                return true;
            }
        } while (!controlState$FU.compareAndSet(this, i, i + 1));
        this.elements.set(i, this.create.invoke(Integer.valueOf(i)));
        return true;
    }

    public final List<T> close() {
        int i;
        Object andSet;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = controlState$FU;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if ((i & Integer.MIN_VALUE) != 0) {
                i = 0;
                break;
            }
        } while (!controlState$FU.compareAndSet(this, i, Integer.MIN_VALUE | i));
        e31 e31VarK = ga2.k(0, i);
        ArrayList arrayList = new ArrayList(j.t(e31VarK, 10));
        Iterator<T> it = e31VarK.iterator();
        while (it.hasNext()) {
            int iA = ((b31) it).a();
            do {
                andSet = this.elements.getAndSet(iA, null);
            } while (andSet == null);
            arrayList.add(andSet);
        }
        return arrayList;
    }

    public final String stateRepresentation$kotlinx_coroutines_core() {
        int i = controlState$FU.get(this);
        e31 e31VarK = ga2.k(0, Integer.MAX_VALUE & i);
        ArrayList arrayList = new ArrayList(j.t(e31VarK, 10));
        Iterator<T> it = e31VarK.iterator();
        while (it.hasNext()) {
            arrayList.add(this.elements.get(((b31) it).a()));
        }
        return arrayList.toString() + ((i & Integer.MIN_VALUE) != 0 ? "[closed]" : Constants.STR_EMPTY);
    }

    public String toString() {
        return "OnDemandAllocatingPool(" + stateRepresentation$kotlinx_coroutines_core() + ')';
    }
}
