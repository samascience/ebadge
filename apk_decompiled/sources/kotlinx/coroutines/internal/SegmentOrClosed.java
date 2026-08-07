package kotlinx.coroutines.internal;

import defpackage.p31;
import kotlinx.coroutines.internal.Segment;

/* JADX INFO: loaded from: classes4.dex */
public final class SegmentOrClosed<S extends Segment<S>> {
    private final Object value;

    private /* synthetic */ SegmentOrClosed(Object obj) {
        this.value = obj;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SegmentOrClosed m151boximpl(Object obj) {
        return new SegmentOrClosed(obj);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <S extends Segment<S>> Object m152constructorimpl(Object obj) {
        return obj;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m153equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof SegmentOrClosed) && p31.a(obj, ((SegmentOrClosed) obj2).m159unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m154equalsimpl0(Object obj, Object obj2) {
        return p31.a(obj, obj2);
    }

    public static /* synthetic */ void getSegment$annotations() {
    }

    /* JADX INFO: renamed from: getSegment-impl, reason: not valid java name */
    public static final S m155getSegmentimpl(Object obj) {
        if (obj == ConcurrentLinkedListKt.CLOSED) {
            throw new IllegalStateException("Does not contain segment");
        }
        p31.d(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (S) obj;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m156hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* JADX INFO: renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m157isClosedimpl(Object obj) {
        return obj == ConcurrentLinkedListKt.CLOSED;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m158toStringimpl(Object obj) {
        return "SegmentOrClosed(value=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m153equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m156hashCodeimpl(this.value);
    }

    public String toString() {
        return m158toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m159unboximpl() {
        return this.value;
    }
}
