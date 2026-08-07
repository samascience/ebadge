package kotlinx.coroutines.flow;

import defpackage.x30;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface SharedFlow<T> extends Flow<T> {
    @Override // kotlinx.coroutines.flow.Flow
    Object collect(FlowCollector<? super T> flowCollector, x30 x30Var);

    List<T> getReplayCache();
}
