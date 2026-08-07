package kotlinx.coroutines.flow;

import defpackage.ar0;
import defpackage.h70;
import defpackage.j21;
import defpackage.k83;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes4.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2<T> implements Flow<T> {
    final /* synthetic */ ar0 $this_asFlow$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2", f = "Builders.kt", l = {114, 114}, m = "collect")
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(ar0 ar0Var) {
        this.$this_asFlow$inlined = ar0Var;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, x30 x30Var) throws Throwable {
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
        Object objInvoke = anonymousClass1.result;
        Object objD = a.d();
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                flowCollector = (FlowCollector) anonymousClass1.L$0;
                d.b(objInvoke);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(objInvoke);
            }
            return k83.a;
        }
        d.b(objInvoke);
        ar0 ar0Var = this.$this_asFlow$inlined;
        anonymousClass1.L$0 = flowCollector;
        anonymousClass1.label = 1;
        j21.c(6);
        objInvoke = ar0Var.invoke(anonymousClass1);
        j21.c(7);
        if (objInvoke == objD) {
            return objD;
        }
        anonymousClass1.L$0 = null;
        anonymousClass1.label = 2;
        if (flowCollector.emit(objInvoke, anonymousClass1) == objD) {
            return objD;
        }
        return k83.a;
    }
}
