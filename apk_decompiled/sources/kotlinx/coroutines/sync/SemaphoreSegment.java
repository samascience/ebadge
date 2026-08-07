package kotlinx.coroutines.sync;

import defpackage.cx;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.Segment;

/* JADX INFO: loaded from: classes4.dex */
final class SemaphoreSegment extends Segment<SemaphoreSegment> {
    private final AtomicReferenceArray acquirers;

    public SemaphoreSegment(long j, SemaphoreSegment semaphoreSegment, int i) {
        super(j, semaphoreSegment, i);
        this.acquirers = new AtomicReferenceArray(SemaphoreKt.SEGMENT_SIZE);
    }

    public final boolean cas(int i, Object obj, Object obj2) {
        return cx.a(getAcquirers(), i, obj, obj2);
    }

    public final Object get(int i) {
        return getAcquirers().get(i);
    }

    public final AtomicReferenceArray getAcquirers() {
        return this.acquirers;
    }

    public final Object getAndSet(int i, Object obj) {
        return getAcquirers().getAndSet(i, obj);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public int getNumberOfSlots() {
        return SemaphoreKt.SEGMENT_SIZE;
    }

    @Override // kotlinx.coroutines.internal.Segment
    public void onCancellation(int i, Throwable th, d dVar) {
        getAcquirers().set(i, SemaphoreKt.CANCELLED);
        onSlotCleaned();
    }

    public final void set(int i, Object obj) {
        getAcquirers().set(i, obj);
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.id + ", hashCode=" + hashCode() + ']';
    }
}
