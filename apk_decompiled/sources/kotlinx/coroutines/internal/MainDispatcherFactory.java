package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes4.dex */
@InternalCoroutinesApi
public interface MainDispatcherFactory {

    public static final class DefaultImpls {
        public static String hintOnError(MainDispatcherFactory mainDispatcherFactory) {
            return null;
        }
    }

    MainCoroutineDispatcher createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
