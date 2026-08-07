package kotlinx.coroutines;

/* JADX INFO: loaded from: classes4.dex */
@InternalCoroutinesApi
public interface ChildHandle extends DisposableHandle {

    public static final class DefaultImpls {
        @InternalCoroutinesApi
        public static /* synthetic */ void getParent$annotations() {
        }
    }

    @InternalCoroutinesApi
    boolean childCancelled(Throwable th);

    Job getParent();
}
