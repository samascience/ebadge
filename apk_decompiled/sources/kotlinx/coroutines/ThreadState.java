package kotlinx.coroutines;

import defpackage.ar0;
import defpackage.k83;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;

/* JADX INFO: loaded from: classes4.dex */
final class ThreadState implements ar0 {
    private static final AtomicIntegerFieldUpdater _state$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state");
    private volatile int _state;
    private DisposableHandle cancelHandle;
    private final Job job;
    private final Thread targetThread = Thread.currentThread();

    public ThreadState(Job job) {
        this.job = job;
    }

    private final Void invalidState(int i) {
        throw new IllegalStateException(("Illegal state " + i).toString());
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, ar0 ar0Var, Object obj) {
        while (true) {
            ar0Var.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    public final void clearInterrupt() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _state$FU;
        while (true) {
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 2) {
                    if (i == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        invalidState(i);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (_state$FU.compareAndSet(this, i, 1)) {
                DisposableHandle disposableHandle = this.cancelHandle;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                    return;
                }
                return;
            }
        }
    }

    @Override // defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return k83.a;
    }

    public final void setup() {
        int i;
        this.cancelHandle = this.job.invokeOnCompletion(true, true, this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _state$FU;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 2 || i == 3) {
                    return;
                }
                invalidState(i);
                throw new KotlinNothingValueException();
            }
        } while (!_state$FU.compareAndSet(this, i, 0));
    }

    public void invoke(Throwable th) {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = _state$FU;
        do {
            i = atomicIntegerFieldUpdater2.get(this);
            if (i != 0) {
                if (i == 1 || i == 2 || i == 3) {
                    return;
                }
                invalidState(i);
                throw new KotlinNothingValueException();
            }
            atomicIntegerFieldUpdater = _state$FU;
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 2));
        this.targetThread.interrupt();
        atomicIntegerFieldUpdater.set(this, 3);
    }
}
