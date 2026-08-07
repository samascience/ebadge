package xfkj.fitpro.ui.activities.debug.viewmodel;

import defpackage.d92;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import xfkj.fitpro.ui.activities.debug.model.LogType;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.debug.viewmodel.ProtocolDebugViewModel$connectDevice$1", f = "ProtocolDebugViewModel.kt", l = {232}, m = "invokeSuspend")
final class ProtocolDebugViewModel$connectDevice$1 extends SuspendLambda implements or0 {
    int label;
    final /* synthetic */ ProtocolDebugViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProtocolDebugViewModel$connectDevice$1(ProtocolDebugViewModel protocolDebugViewModel, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = protocolDebugViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new ProtocolDebugViewModel$connectDevice$1(this.this$0, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            this.label = 1;
            if (DelayKt.delay(2000L, this) == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
        }
        this.this$0.K(true, "测试设备");
        ProtocolDebugViewModel protocolDebugViewModel = this.this$0;
        protocolDebugViewModel.t(new d92(protocolDebugViewModel.B(), LogType.INFO, System.currentTimeMillis(), "设备连接成功", "设备名称: 测试设备", null, 32, null));
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((ProtocolDebugViewModel$connectDevice$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
