package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.k83;
import defpackage.x30;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class FlowKt__CollectionKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", f = "Collection.kt", l = {26}, m = "toCollection")
    static final class AnonymousClass1<T, C extends Collection<? super T>> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.toCollection(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T, C extends Collection<? super T>> Object toCollection(Flow<? extends T> flow, final C c, x30 x30Var) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (x30Var instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) x30Var;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(x30Var);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(x30Var);
        }
        Object obj = anonymousClass1.result;
        Object objD = a.d();
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Collection collection = (Collection) anonymousClass1.L$0;
            d.b(obj);
            return collection;
        }
        d.b(obj);
        FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__CollectionKt.toCollection.2
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T t, x30 x30Var2) {
                c.add(t);
                return k83.a;
            }
        };
        anonymousClass1.L$0 = c;
        anonymousClass1.label = 1;
        return flow.collect(flowCollector, anonymousClass1) == objD ? objD : c;
    }

    public static final <T> Object toList(Flow<? extends T> flow, List<T> list, x30 x30Var) {
        return FlowKt.toCollection(flow, list, x30Var);
    }

    public static /* synthetic */ Object toList$default(Flow flow, List list, x30 x30Var, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return FlowKt.toList(flow, list, x30Var);
    }

    public static final <T> Object toSet(Flow<? extends T> flow, Set<T> set, x30 x30Var) {
        return FlowKt.toCollection(flow, set, x30Var);
    }

    public static /* synthetic */ Object toSet$default(Flow flow, Set set, x30 x30Var, int i, Object obj) {
        if ((i & 1) != 0) {
            set = new LinkedHashSet();
        }
        return FlowKt.toSet(flow, set, x30Var);
    }
}
