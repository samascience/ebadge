package com.legend.smartwatch.app.base.viewmodel;

import defpackage.ar0;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
@h70(c = "com.legend.smartwatch.app.base.viewmodel.BaseViewModel$TempAckListener$onAckReceived$1", f = "BaseViewModel.kt", l = {432, 433}, m = "invokeSuspend")
final class BaseViewModel$TempAckListener$onAckReceived$1 extends SuspendLambda implements or0 {
    int label;
    final /* synthetic */ a.b this$0;

    BaseViewModel$TempAckListener$onAckReceived$1(a.b bVar, x30 x30Var) {
        super(2, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new BaseViewModel$TempAckListener$onAckReceived$1(null, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                d.b(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
            return k83.a;
        }
        d.b(obj);
        long jA = a.b.a(null);
        this.label = 1;
        if (DelayKt.delay(jA, this) == objD) {
            return objD;
        }
        ar0 ar0VarB = a.b.b(null);
        this.label = 2;
        if (ar0VarB.invoke(this) == objD) {
            return objD;
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((BaseViewModel$TempAckListener$onAckReceived$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
