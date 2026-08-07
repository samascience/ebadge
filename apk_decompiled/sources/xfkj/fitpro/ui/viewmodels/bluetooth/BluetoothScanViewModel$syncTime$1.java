package xfkj.fitpro.ui.viewmodels.bluetooth;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.viewmodels.bluetooth.BluetoothScanViewModel$syncTime$1", f = "BluetoothScanViewModel.kt", l = {688, 692}, m = "invokeSuspend")
final class BluetoothScanViewModel$syncTime$1 extends SuspendLambda implements or0 {
    int label;
    final /* synthetic */ BluetoothScanViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BluetoothScanViewModel$syncTime$1(BluetoothScanViewModel bluetoothScanViewModel, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = bluetoothScanViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new BluetoothScanViewModel$syncTime$1(this.this$0, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = a.d();
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
            this.this$0.g0();
            return k83.a;
        }
        d.b(obj);
        this.label = 1;
        if (DelayKt.delay(2000L, this) == objD) {
            return objD;
        }
        this.this$0.l0("time", BluetoothScanViewModel.SyncState.COMPLETED);
        this.label = 2;
        if (DelayKt.delay(1000L, this) == objD) {
            return objD;
        }
        this.this$0.g0();
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((BluetoothScanViewModel$syncTime$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
