package com.legend.smartwatch.app.base.viewmodel;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@h70(c = "com.legend.smartwatch.app.base.viewmodel.BaseViewModel$launchIO$1", f = "BaseViewModel.kt", l = {393}, m = "invokeSuspend")
final class BaseViewModel$launchIO$1 extends SuspendLambda implements or0 {
    final /* synthetic */ or0 $block;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseViewModel$launchIO$1(or0 or0Var, a aVar, x30 x30Var) {
        super(2, x30Var);
        this.$block = or0Var;
        this.this$0 = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        BaseViewModel$launchIO$1 baseViewModel$launchIO$1 = new BaseViewModel$launchIO$1(this.$block, this.this$0, x30Var);
        baseViewModel$launchIO$1.L$0 = obj;
        return baseViewModel$launchIO$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        try {
            if (i == 0) {
                d.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                or0 or0Var = this.$block;
                this.label = 1;
                if (or0Var.invoke(coroutineScope, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
        } catch (Throwable th) {
            this.this$0.f().m(new a.AbstractC0097a.b(th));
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((BaseViewModel$launchIO$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
