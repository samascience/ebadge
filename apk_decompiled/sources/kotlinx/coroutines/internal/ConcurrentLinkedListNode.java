package kotlinx.coroutines.internal;

import defpackage.ar0;
import defpackage.p31;
import defpackage.q1;
import defpackage.yq0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {
    private static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next");
    private static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public ConcurrentLinkedListNode(N n) {
        this._prev = n;
    }

    private final N getAliveSegmentLeft() {
        N n = (N) getPrev();
        while (n != null && n.isRemoved()) {
            n = (N) _prev$FU.get(n);
        }
        return n;
    }

    private final N getAliveSegmentRight() {
        ConcurrentLinkedListNode next;
        N n = (N) getNext();
        p31.c(n);
        while (n.isRemoved() && (next = n.getNext()) != null) {
            n = (N) next;
        }
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getNextOrClosed() {
        return _next$FU.get(this);
    }

    private final void update$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ar0 ar0Var, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!q1.a(atomicReferenceFieldUpdater, obj, obj2, ar0Var.invoke(obj2)));
    }

    public final void cleanPrev() {
        _prev$FU.lazySet(this, null);
    }

    public final N getNext() {
        Object nextOrClosed = getNextOrClosed();
        if (nextOrClosed == ConcurrentLinkedListKt.CLOSED) {
            return null;
        }
        return (N) nextOrClosed;
    }

    public final N getPrev() {
        return (N) _prev$FU.get(this);
    }

    public abstract boolean isRemoved();

    public final boolean isTail() {
        return getNext() == null;
    }

    public final boolean markAsClosed() {
        return q1.a(_next$FU, this, null, ConcurrentLinkedListKt.CLOSED);
    }

    public final N nextOrIfClosed(yq0 yq0Var) {
        Object nextOrClosed = getNextOrClosed();
        if (nextOrClosed != ConcurrentLinkedListKt.CLOSED) {
            return (N) nextOrClosed;
        }
        yq0Var.invoke();
        throw new KotlinNothingValueException();
    }

    public final void remove() {
        Object obj;
        if (isTail()) {
            return;
        }
        while (true) {
            ConcurrentLinkedListNode aliveSegmentLeft = getAliveSegmentLeft();
            ConcurrentLinkedListNode aliveSegmentRight = getAliveSegmentRight();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _prev$FU;
            do {
                obj = atomicReferenceFieldUpdater.get(aliveSegmentRight);
            } while (!q1.a(atomicReferenceFieldUpdater, aliveSegmentRight, obj, ((ConcurrentLinkedListNode) obj) == null ? null : aliveSegmentLeft));
            if (aliveSegmentLeft != null) {
                _next$FU.set(aliveSegmentLeft, aliveSegmentRight);
            }
            if (!aliveSegmentRight.isRemoved() || aliveSegmentRight.isTail()) {
                if (aliveSegmentLeft == null || !aliveSegmentLeft.isRemoved()) {
                    return;
                }
            }
        }
    }

    public final boolean trySetNext(N n) {
        return q1.a(_next$FU, this, null, n);
    }
}
