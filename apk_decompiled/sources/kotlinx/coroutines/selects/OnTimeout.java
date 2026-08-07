package kotlinx.coroutines.selects;

import defpackage.k83;
import defpackage.p31;
import defpackage.p63;
import defpackage.pr0;
import kotlin.coroutines.d;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes4.dex */
final class OnTimeout {
    private final long timeMillis;

    public OnTimeout(long j) {
        this.timeMillis = j;
    }

    public static /* synthetic */ void getSelectClause$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void register(final SelectInstance<?> selectInstance, Object obj) {
        if (this.timeMillis <= 0) {
            selectInstance.selectInRegistrationPhase(k83.a);
            return;
        }
        Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.selects.OnTimeout$register$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                selectInstance.trySelect(this, k83.a);
            }
        };
        p31.d(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        d context = selectInstance.getContext();
        selectInstance.disposeOnCompletion(DelayKt.getDelay(context).invokeOnTimeout(this.timeMillis, runnable, context));
    }

    public final SelectClause0 getSelectClause() {
        OnTimeout$selectClause$1 onTimeout$selectClause$1 = OnTimeout$selectClause$1.INSTANCE;
        p31.d(onTimeout$selectClause$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new SelectClause0Impl(this, (pr0) p63.a(onTimeout$selectClause$1, 3), null, 4, null);
    }
}
