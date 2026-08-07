package kotlinx.coroutines.debug.internal;

import defpackage.p40;
import java.util.List;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public final class DebugCoroutineInfo {
    private final d context;
    private final p40 creationStackBottom;
    private final List<StackTraceElement> creationStackTrace;
    private final p40 lastObservedFrame;
    private final List<StackTraceElement> lastObservedStackTrace;
    private final Thread lastObservedThread;
    private final long sequenceNumber;
    private final String state;

    public DebugCoroutineInfo(DebugCoroutineInfoImpl debugCoroutineInfoImpl, d dVar) {
        this.context = dVar;
        this.creationStackBottom = debugCoroutineInfoImpl.getCreationStackBottom$kotlinx_coroutines_core();
        this.sequenceNumber = debugCoroutineInfoImpl.sequenceNumber;
        this.creationStackTrace = debugCoroutineInfoImpl.getCreationStackTrace();
        this.state = debugCoroutineInfoImpl.getState$kotlinx_coroutines_core();
        this.lastObservedThread = debugCoroutineInfoImpl.lastObservedThread;
        this.lastObservedFrame = debugCoroutineInfoImpl.getLastObservedFrame$kotlinx_coroutines_core();
        this.lastObservedStackTrace = debugCoroutineInfoImpl.lastObservedStackTrace$kotlinx_coroutines_core();
    }

    public final d getContext() {
        return this.context;
    }

    public final p40 getCreationStackBottom$kotlinx_coroutines_core() {
        return this.creationStackBottom;
    }

    public final List<StackTraceElement> getCreationStackTrace() {
        return this.creationStackTrace;
    }

    public final p40 getLastObservedFrame() {
        return this.lastObservedFrame;
    }

    public final Thread getLastObservedThread() {
        return this.lastObservedThread;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public final String getState() {
        return this.state;
    }

    public final List<StackTraceElement> lastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }
}
