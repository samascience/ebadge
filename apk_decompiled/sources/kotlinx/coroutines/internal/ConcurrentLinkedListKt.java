package kotlinx.coroutines.internal;

import defpackage.ar0;
import defpackage.cx;
import defpackage.or0;
import defpackage.q1;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes4.dex */
public final class ConcurrentLinkedListKt {
    private static final Symbol CLOSED = new Symbol("CLOSED");
    private static final int POINTERS_SHIFT = 16;

    private static final boolean addConditionally$atomicfu(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, int i, ar0 ar0Var) {
        int i2;
        do {
            i2 = atomicIntegerFieldUpdater.get(obj);
            if (!((Boolean) ar0Var.invoke(Integer.valueOf(i2))).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i2, i2 + i));
        return true;
    }

    private static final boolean addConditionally$atomicfu$array(Object obj, AtomicIntegerArray atomicIntegerArray, int i, int i2, ar0 ar0Var) {
        int i3;
        do {
            i3 = atomicIntegerArray.get(i);
            if (!((Boolean) ar0Var.invoke(Integer.valueOf(i3))).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerArray.compareAndSet(i, i3, i3 + i2));
        return true;
    }

    public static final <N extends ConcurrentLinkedListNode<N>> N close(N n) {
        while (true) {
            Object nextOrClosed = n.getNextOrClosed();
            if (nextOrClosed == CLOSED) {
                return n;
            }
            ConcurrentLinkedListNode concurrentLinkedListNode = (ConcurrentLinkedListNode) nextOrClosed;
            if (concurrentLinkedListNode != null) {
                n = (N) concurrentLinkedListNode;
            } else if (n.markAsClosed()) {
                return n;
            }
        }
    }

    public static final Object findSegmentAndMoveForward$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, long j, Segment segment, or0 or0Var) {
        Object objFindSegmentInternal;
        loop0: while (true) {
            objFindSegmentInternal = findSegmentInternal(segment, j, or0Var);
            if (!SegmentOrClosed.m157isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM155getSegmentimpl = SegmentOrClosed.m155getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    Segment segment2 = (Segment) atomicReferenceFieldUpdater.get(obj);
                    if (segment2.id >= segmentM155getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM155getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (q1.a(atomicReferenceFieldUpdater, obj, segment2, segmentM155getSegmentimpl)) {
                        if (!segment2.decPointers$kotlinx_coroutines_core()) {
                            break loop0;
                        }
                        segment2.remove();
                        break loop0;
                    }
                    if (segmentM155getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        segmentM155getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        return objFindSegmentInternal;
    }

    public static final Object findSegmentAndMoveForward$atomicfu$array(Object obj, AtomicReferenceArray atomicReferenceArray, int i, long j, Segment segment, or0 or0Var) {
        Object objFindSegmentInternal;
        loop0: while (true) {
            objFindSegmentInternal = findSegmentInternal(segment, j, or0Var);
            if (!SegmentOrClosed.m157isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM155getSegmentimpl = SegmentOrClosed.m155getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    Segment segment2 = (Segment) atomicReferenceArray.get(i);
                    if (segment2.id >= segmentM155getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM155getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (cx.a(atomicReferenceArray, i, segment2, segmentM155getSegmentimpl)) {
                        if (!segment2.decPointers$kotlinx_coroutines_core()) {
                            break loop0;
                        }
                        segment2.remove();
                        break loop0;
                    }
                    if (segmentM155getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        segmentM155getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        return objFindSegmentInternal;
    }

    public static final <S extends Segment<S>> Object findSegmentInternal(S s, long j, or0 or0Var) {
        while (true) {
            if (s.id >= j && !s.isRemoved()) {
                return SegmentOrClosed.m152constructorimpl(s);
            }
            Object nextOrClosed = s.getNextOrClosed();
            if (nextOrClosed == CLOSED) {
                return SegmentOrClosed.m152constructorimpl(CLOSED);
            }
            Segment segment = (Segment) ((ConcurrentLinkedListNode) nextOrClosed);
            if (segment == null) {
                segment = (Segment) or0Var.invoke(Long.valueOf(s.id + 1), s);
                if (s.trySetNext(segment)) {
                    if (s.isRemoved()) {
                        s.remove();
                    }
                }
            }
            s = (S) segment;
        }
    }

    public static final boolean moveForward$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Segment segment) {
        while (true) {
            Segment segment2 = (Segment) atomicReferenceFieldUpdater.get(obj);
            if (segment2.id >= segment.id) {
                return true;
            }
            if (!segment.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (q1.a(atomicReferenceFieldUpdater, obj, segment2, segment)) {
                if (segment2.decPointers$kotlinx_coroutines_core()) {
                    segment2.remove();
                }
                return true;
            }
            if (segment.decPointers$kotlinx_coroutines_core()) {
                segment.remove();
            }
        }
    }

    public static final boolean moveForward$atomicfu$array(Object obj, AtomicReferenceArray atomicReferenceArray, int i, Segment segment) {
        while (true) {
            Segment segment2 = (Segment) atomicReferenceArray.get(i);
            if (segment2.id >= segment.id) {
                return true;
            }
            if (!segment.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (cx.a(atomicReferenceArray, i, segment2, segment)) {
                if (segment2.decPointers$kotlinx_coroutines_core()) {
                    segment2.remove();
                }
                return true;
            }
            if (segment.decPointers$kotlinx_coroutines_core()) {
                segment.remove();
            }
        }
    }
}
