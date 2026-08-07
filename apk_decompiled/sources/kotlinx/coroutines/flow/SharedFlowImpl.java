package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.j70;
import defpackage.k83;
import defpackage.p31;
import defpackage.x30;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Result;
import kotlin.collections.j;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes4.dex */
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private Object[] buffer;
    private final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;
    private final BufferOverflow onBufferOverflow;
    private int queueSize;
    private final int replay;
    private long replayIndex;

    private static final class Emitter implements DisposableHandle {
        public final x30 cont;
        public final SharedFlowImpl<?> flow;
        public long index;
        public final Object value;

        public Emitter(SharedFlowImpl<?> sharedFlowImpl, long j, Object obj, x30 x30Var) {
            this.flow = sharedFlowImpl;
            this.index = j;
            this.value = obj;
            this.cont = x30Var;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.flow.cancelEmitter(this);
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.SharedFlowImpl$collect$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {372, 379, 382}, m = "collect$suspendImpl")
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SharedFlowImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SharedFlowImpl<T> sharedFlowImpl, x30 x30Var) {
            super(x30Var);
            this.this$0 = sharedFlowImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedFlowImpl.collect$suspendImpl(this.this$0, null, this);
        }
    }

    public SharedFlowImpl(int i, int i2, BufferOverflow bufferOverflow) {
        this.replay = i;
        this.bufferCapacity = i2;
        this.onBufferOverflow = bufferOverflow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitValue(SharedFlowSlot sharedFlowSlot, x30 x30Var) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(a.c(x30Var), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            try {
                if (tryPeekLocked(sharedFlowSlot) < 0) {
                    sharedFlowSlot.cont = cancellableContinuationImpl;
                } else {
                    Result.a aVar = Result.Companion;
                    cancellableContinuationImpl.resumeWith(Result.m69constructorimpl(k83.a));
                }
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == a.d()) {
            j70.c(x30Var);
        }
        return result == a.d() ? result : k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelEmitter(Emitter emitter) {
        synchronized (this) {
            if (emitter.index < getHead()) {
                return;
            }
            Object[] objArr = this.buffer;
            p31.c(objArr);
            if (SharedFlowKt.getBufferAt(objArr, emitter.index) != emitter) {
                return;
            }
            SharedFlowKt.setBufferAt(objArr, emitter.index, SharedFlowKt.NO_VALUE);
            cleanupTailLocked();
            k83 k83Var = k83.a;
        }
    }

    private final void cleanupTailLocked() {
        if (this.bufferCapacity != 0 || this.queueSize > 1) {
            Object[] objArr = this.buffer;
            p31.c(objArr);
            while (this.queueSize > 0 && SharedFlowKt.getBufferAt(objArr, (getHead() + ((long) getTotalSize())) - 1) == SharedFlowKt.NO_VALUE) {
                this.queueSize--;
                SharedFlowKt.setBufferAt(objArr, getHead() + ((long) getTotalSize()), null);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    static /* synthetic */ <T> Object collect$suspendImpl(SharedFlowImpl<T> sharedFlowImpl, FlowCollector<? super T> flowCollector, x30 x30Var) throws Throwable {
        AnonymousClass1 anonymousClass1;
        SharedFlowImpl<T> sharedFlowImpl2;
        Throwable th;
        SharedFlowSlot sharedFlowSlot;
        FlowCollector<? super T> flowCollector2;
        Job job;
        if (x30Var instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) x30Var;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(sharedFlowImpl, x30Var);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(sharedFlowImpl, x30Var);
        }
        Object obj = anonymousClass1.result;
        Object objD = a.d();
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                sharedFlowSlot = (SharedFlowSlot) anonymousClass1.L$2;
                FlowCollector<? super T> flowCollector3 = (FlowCollector) anonymousClass1.L$1;
                SharedFlowImpl<T> sharedFlowImpl3 = (SharedFlowImpl) anonymousClass1.L$0;
                try {
                    d.b(obj);
                    flowCollector2 = flowCollector3;
                    sharedFlowImpl = sharedFlowImpl3;
                    try {
                        job = (Job) anonymousClass1.getContext().get(Job.Key);
                    } catch (Throwable th2) {
                        sharedFlowImpl2 = sharedFlowImpl;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    sharedFlowImpl2 = sharedFlowImpl3;
                }
            } else {
                if (i2 != 2 && i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Job job2 = (Job) anonymousClass1.L$3;
                sharedFlowSlot = (SharedFlowSlot) anonymousClass1.L$2;
                FlowCollector<? super T> flowCollector4 = (FlowCollector) anonymousClass1.L$1;
                sharedFlowImpl2 = (SharedFlowImpl) anonymousClass1.L$0;
                try {
                    d.b(obj);
                    flowCollector2 = flowCollector4;
                    job = job2;
                    sharedFlowImpl = sharedFlowImpl2;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            sharedFlowImpl2.freeSlot(sharedFlowSlot);
            throw th;
        }
        d.b(obj);
        SharedFlowSlot sharedFlowSlotAllocateSlot = sharedFlowImpl.allocateSlot();
        try {
            if (flowCollector instanceof SubscribedFlowCollector) {
                anonymousClass1.L$0 = sharedFlowImpl;
                anonymousClass1.L$1 = flowCollector;
                anonymousClass1.L$2 = sharedFlowSlotAllocateSlot;
                anonymousClass1.label = 1;
                if (((SubscribedFlowCollector) flowCollector).onSubscription(anonymousClass1) == objD) {
                    return objD;
                }
            }
            flowCollector2 = flowCollector;
            sharedFlowSlot = sharedFlowSlotAllocateSlot;
            job = (Job) anonymousClass1.getContext().get(Job.Key);
        } catch (Throwable th5) {
            sharedFlowImpl2 = sharedFlowImpl;
            th = th5;
            sharedFlowSlot = sharedFlowSlotAllocateSlot;
        }
        while (true) {
            Symbol symbol = (Object) sharedFlowImpl.tryTakeValue(sharedFlowSlot);
            if (symbol == SharedFlowKt.NO_VALUE) {
                anonymousClass1.L$0 = sharedFlowImpl;
                anonymousClass1.L$1 = flowCollector2;
                anonymousClass1.L$2 = sharedFlowSlot;
                anonymousClass1.L$3 = job;
                anonymousClass1.label = 2;
                if (sharedFlowImpl.awaitValue(sharedFlowSlot, anonymousClass1) == objD) {
                    return objD;
                }
            } else {
                if (job != null) {
                    JobKt.ensureActive(job);
                }
                anonymousClass1.L$0 = sharedFlowImpl;
                anonymousClass1.L$1 = flowCollector2;
                anonymousClass1.L$2 = sharedFlowSlot;
                anonymousClass1.L$3 = job;
                anonymousClass1.label = 3;
                if (flowCollector2.emit(symbol, anonymousClass1) == objD) {
                    return objD;
                }
            }
        }
    }

    private final void correctCollectorIndexesOnDropOldest(long j) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    long j2 = sharedFlowSlot.index;
                    if (j2 >= 0 && j2 < j) {
                        sharedFlowSlot.index = j;
                    }
                }
            }
        }
        this.minCollectorIndex = j;
    }

    private final void dropOldestLocked() {
        Object[] objArr = this.buffer;
        p31.c(objArr);
        SharedFlowKt.setBufferAt(objArr, getHead(), null);
        this.bufferSize--;
        long head = getHead() + 1;
        if (this.replayIndex < head) {
            this.replayIndex = head;
        }
        if (this.minCollectorIndex < head) {
            correctCollectorIndexesOnDropOldest(head);
        }
    }

    static /* synthetic */ <T> Object emit$suspendImpl(SharedFlowImpl<T> sharedFlowImpl, T t, x30 x30Var) {
        Object objEmitSuspend;
        return (!sharedFlowImpl.tryEmit(t) && (objEmitSuspend = sharedFlowImpl.emitSuspend(t, x30Var)) == a.d()) ? objEmitSuspend : k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object emitSuspend(T t, x30 x30Var) {
        x30[] x30VarArrFindSlotsToResumeLocked;
        Emitter emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(a.c(x30Var), 1);
        cancellableContinuationImpl.initCancellability();
        x30[] x30VarArrFindSlotsToResumeLocked2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                if (tryEmitLocked(t)) {
                    Result.a aVar = Result.Companion;
                    cancellableContinuationImpl.resumeWith(Result.m69constructorimpl(k83.a));
                    x30VarArrFindSlotsToResumeLocked = findSlotsToResumeLocked(x30VarArrFindSlotsToResumeLocked2);
                    emitter = null;
                } else {
                    Emitter emitter2 = new Emitter(this, ((long) getTotalSize()) + getHead(), t, cancellableContinuationImpl);
                    enqueueLocked(emitter2);
                    this.queueSize++;
                    if (this.bufferCapacity == 0) {
                        x30VarArrFindSlotsToResumeLocked2 = findSlotsToResumeLocked(x30VarArrFindSlotsToResumeLocked2);
                    }
                    x30VarArrFindSlotsToResumeLocked = x30VarArrFindSlotsToResumeLocked2;
                    emitter = emitter2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, emitter);
        }
        for (x30 x30Var2 : x30VarArrFindSlotsToResumeLocked) {
            if (x30Var2 != null) {
                Result.a aVar2 = Result.Companion;
                x30Var2.resumeWith(Result.m69constructorimpl(k83.a));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == a.d()) {
            j70.c(x30Var);
        }
        return result == a.d() ? result : k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueueLocked(Object obj) {
        int totalSize = getTotalSize();
        Object[] objArrGrowBuffer = this.buffer;
        if (objArrGrowBuffer == null) {
            objArrGrowBuffer = growBuffer(null, 0, 2);
        } else if (totalSize >= objArrGrowBuffer.length) {
            objArrGrowBuffer = growBuffer(objArrGrowBuffer, totalSize, objArrGrowBuffer.length * 2);
        }
        SharedFlowKt.setBufferAt(objArrGrowBuffer, getHead() + ((long) totalSize), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [x30[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final x30[] findSlotsToResumeLocked(x30[] x30VarArr) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        SharedFlowSlot sharedFlowSlot;
        x30 x30Var;
        int length = x30VarArr.length;
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            int length2 = abstractSharedFlowSlotArr.length;
            int i = 0;
            while (i < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArr[i];
                if (abstractSharedFlowSlot == null || (x30Var = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).cont) == null || tryPeekLocked(sharedFlowSlot) < 0) {
                    x30VarArr = x30VarArr;
                } else {
                    if (length >= x30VarArr.length) {
                        x30VarArr = x30VarArr;
                        x30VarArr = x30VarArr;
                        Object[] objArrCopyOf = Arrays.copyOf((Object[]) x30VarArr, Math.max(2, x30VarArr.length * 2));
                        p31.e(objArrCopyOf, "copyOf(this, newSize)");
                        x30VarArr = objArrCopyOf;
                    }
                    x30VarArr = x30VarArr;
                    x30VarArr = x30VarArr;
                    ((x30[]) x30VarArr)[length] = x30Var;
                    sharedFlowSlot.cont = null;
                    length++;
                }
                i++;
                x30VarArr = x30VarArr;
            }
            x30VarArr = x30VarArr;
        }
        return (x30[]) x30VarArr;
    }

    private final long getBufferEndIndex() {
        return getHead() + ((long) this.bufferSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    protected static /* synthetic */ void getLastReplayedLocked$annotations() {
    }

    private final Object getPeekedValueLockedAt(long j) {
        Object[] objArr = this.buffer;
        p31.c(objArr);
        Object bufferAt = SharedFlowKt.getBufferAt(objArr, j);
        return bufferAt instanceof Emitter ? ((Emitter) bufferAt).value : bufferAt;
    }

    private final long getQueueEndIndex() {
        return getHead() + ((long) this.bufferSize) + ((long) this.queueSize);
    }

    private final int getReplaySize() {
        return (int) ((getHead() + ((long) this.bufferSize)) - this.replayIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final Object[] growBuffer(Object[] objArr, int i, int i2) {
        if (i2 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i2];
        this.buffer = objArr2;
        if (objArr == null) {
            return objArr2;
        }
        long head = getHead();
        for (int i3 = 0; i3 < i; i3++) {
            long j = ((long) i3) + head;
            SharedFlowKt.setBufferAt(objArr2, j, SharedFlowKt.getBufferAt(objArr, j));
        }
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean tryEmitLocked(T t) {
        if (getNCollectors() == 0) {
            return tryEmitNoCollectorsLocked(t);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
        }
        enqueueLocked(t);
        int i2 = this.bufferSize + 1;
        this.bufferSize = i2;
        if (i2 > this.bufferCapacity) {
            dropOldestLocked();
        }
        if (getReplaySize() > this.replay) {
            updateBufferLocked(this.replayIndex + 1, this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
        }
        return true;
    }

    private final boolean tryEmitNoCollectorsLocked(T t) {
        if (this.replay == 0) {
            return true;
        }
        enqueueLocked(t);
        int i = this.bufferSize + 1;
        this.bufferSize = i;
        if (i > this.replay) {
            dropOldestLocked();
        }
        this.minCollectorIndex = getHead() + ((long) this.bufferSize);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long tryPeekLocked(SharedFlowSlot sharedFlowSlot) {
        long j = sharedFlowSlot.index;
        if (j < getBufferEndIndex()) {
            return j;
        }
        if (this.bufferCapacity <= 0 && j <= getHead() && this.queueSize != 0) {
            return j;
        }
        return -1L;
    }

    private final Object tryTakeValue(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        x30[] x30VarArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                long jTryPeekLocked = tryPeekLocked(sharedFlowSlot);
                if (jTryPeekLocked < 0) {
                    obj = SharedFlowKt.NO_VALUE;
                } else {
                    long j = sharedFlowSlot.index;
                    Object peekedValueLockedAt = getPeekedValueLockedAt(jTryPeekLocked);
                    sharedFlowSlot.index = jTryPeekLocked + 1;
                    x30VarArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = updateCollectorIndexLocked$kotlinx_coroutines_core(j);
                    obj = peekedValueLockedAt;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (x30 x30Var : x30VarArrUpdateCollectorIndexLocked$kotlinx_coroutines_core) {
            if (x30Var != null) {
                Result.a aVar = Result.Companion;
                x30Var.resumeWith(Result.m69constructorimpl(k83.a));
            }
        }
        return obj;
    }

    private final void updateBufferLocked(long j, long j2, long j3, long j4) {
        long jMin = Math.min(j2, j);
        for (long head = getHead(); head < jMin; head++) {
            Object[] objArr = this.buffer;
            p31.c(objArr);
            SharedFlowKt.setBufferAt(objArr, head, null);
        }
        this.replayIndex = j;
        this.minCollectorIndex = j2;
        this.bufferSize = (int) (j3 - jMin);
        this.queueSize = (int) (j4 - j3);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, x30 x30Var) {
        return collect$suspendImpl(this, flowCollector, x30Var);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, x30 x30Var) {
        return emit$suspendImpl(this, t, x30Var);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(kotlin.coroutines.d dVar, int i, BufferOverflow bufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, dVar, i, bufferOverflow);
    }

    protected final T getLastReplayedLocked() {
        Object[] objArr = this.buffer;
        p31.c(objArr);
        return (T) SharedFlowKt.getBufferAt(objArr, (this.replayIndex + ((long) getReplaySize())) - 1);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        synchronized (this) {
            int replaySize = getReplaySize();
            if (replaySize == 0) {
                return j.j();
            }
            ArrayList arrayList = new ArrayList(replaySize);
            Object[] objArr = this.buffer;
            p31.c(objArr);
            for (int i = 0; i < replaySize; i++) {
                arrayList.add(SharedFlowKt.getBufferAt(objArr, this.replayIndex + ((long) i)));
            }
            return arrayList;
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        synchronized (this) {
            updateBufferLocked(getBufferEndIndex(), this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
            k83 k83Var = k83.a;
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T t) {
        int i;
        boolean z;
        x30[] x30VarArrFindSlotsToResumeLocked = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (tryEmitLocked(t)) {
                x30VarArrFindSlotsToResumeLocked = findSlotsToResumeLocked(x30VarArrFindSlotsToResumeLocked);
                z = true;
            } else {
                z = false;
            }
        }
        for (x30 x30Var : x30VarArrFindSlotsToResumeLocked) {
            if (x30Var != null) {
                Result.a aVar = Result.Companion;
                x30Var.resumeWith(Result.m69constructorimpl(k83.a));
            }
        }
        return z;
    }

    public final x30[] updateCollectorIndexLocked$kotlinx_coroutines_core(long j) {
        long j2;
        long j3;
        long j4;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (j > this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long head = getHead();
        long j5 = ((long) this.bufferSize) + head;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            j5++;
        }
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    long j6 = ((SharedFlowSlot) abstractSharedFlowSlot).index;
                    if (j6 >= 0 && j6 < j5) {
                        j5 = j6;
                    }
                }
            }
        }
        if (j5 <= this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long bufferEndIndex = getBufferEndIndex();
        int iMin = getNCollectors() > 0 ? Math.min(this.queueSize, this.bufferCapacity - ((int) (bufferEndIndex - j5))) : this.queueSize;
        x30[] x30VarArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        long j7 = ((long) this.queueSize) + bufferEndIndex;
        if (iMin > 0) {
            x30VarArr = new x30[iMin];
            Object[] objArr = this.buffer;
            p31.c(objArr);
            long j8 = bufferEndIndex;
            int i = 0;
            while (true) {
                if (bufferEndIndex >= j7) {
                    j2 = j5;
                    j3 = j7;
                    break;
                }
                Object bufferAt = SharedFlowKt.getBufferAt(objArr, bufferEndIndex);
                j2 = j5;
                Symbol symbol = SharedFlowKt.NO_VALUE;
                if (bufferAt != symbol) {
                    p31.d(bufferAt, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    Emitter emitter = (Emitter) bufferAt;
                    int i2 = i + 1;
                    j3 = j7;
                    x30VarArr[i] = emitter.cont;
                    SharedFlowKt.setBufferAt(objArr, bufferEndIndex, symbol);
                    SharedFlowKt.setBufferAt(objArr, j8, emitter.value);
                    j4 = 1;
                    j8++;
                    if (i2 >= iMin) {
                        break;
                    }
                    i = i2;
                } else {
                    j3 = j7;
                    j4 = 1;
                }
                bufferEndIndex += j4;
                j5 = j2;
                j7 = j3;
            }
            bufferEndIndex = j8;
        } else {
            j2 = j5;
            j3 = j7;
        }
        int i3 = (int) (bufferEndIndex - head);
        long j9 = getNCollectors() == 0 ? bufferEndIndex : j2;
        long jMax = Math.max(this.replayIndex, bufferEndIndex - ((long) Math.min(this.replay, i3)));
        if (this.bufferCapacity == 0 && jMax < j3) {
            Object[] objArr2 = this.buffer;
            p31.c(objArr2);
            if (p31.a(SharedFlowKt.getBufferAt(objArr2, jMax), SharedFlowKt.NO_VALUE)) {
                bufferEndIndex++;
                jMax++;
            }
        }
        updateBufferLocked(jMax, j9, bufferEndIndex, j3);
        cleanupTailLocked();
        return !(x30VarArr.length == 0) ? findSlotsToResumeLocked(x30VarArr) : x30VarArr;
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long j = this.replayIndex;
        if (j < this.minCollectorIndex) {
            this.minCollectorIndex = j;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot[] createSlotArray(int i) {
        return new SharedFlowSlot[i];
    }
}
