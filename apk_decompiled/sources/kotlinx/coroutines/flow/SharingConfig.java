package kotlinx.coroutines.flow;

import kotlin.coroutines.d;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes4.dex */
final class SharingConfig<T> {
    public final d context;
    public final int extraBufferCapacity;
    public final BufferOverflow onBufferOverflow;
    public final Flow<T> upstream;

    /* JADX WARN: Multi-variable type inference failed */
    public SharingConfig(Flow<? extends T> flow, int i, BufferOverflow bufferOverflow, d dVar) {
        this.upstream = flow;
        this.extraBufferCapacity = i;
        this.onBufferOverflow = bufferOverflow;
        this.context = dVar;
    }
}
