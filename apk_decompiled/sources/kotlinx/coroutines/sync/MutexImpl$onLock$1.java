package kotlinx.coroutines.sync;

import defpackage.k83;
import defpackage.pr0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class MutexImpl$onLock$1 extends FunctionReferenceImpl implements pr0 {
    public static final MutexImpl$onLock$1 INSTANCE = new MutexImpl$onLock$1();

    MutexImpl$onLock$1() {
        super(3, MutexImpl.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // defpackage.pr0
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((MutexImpl) obj, (SelectInstance<?>) obj2, obj3);
        return k83.a;
    }

    public final void invoke(MutexImpl mutexImpl, SelectInstance<?> selectInstance, Object obj) {
        mutexImpl.onLockRegFunction(selectInstance, obj);
    }
}
