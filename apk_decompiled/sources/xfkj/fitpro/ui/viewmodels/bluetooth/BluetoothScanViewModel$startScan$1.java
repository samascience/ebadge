package xfkj.fitpro.ui.viewmodels.bluetooth;

import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.viewmodels.bluetooth.BluetoothScanViewModel$startScan$1", f = "BluetoothScanViewModel.kt", l = {272}, m = "invokeSuspend")
final class BluetoothScanViewModel$startScan$1 extends SuspendLambda implements or0 {
    int label;
    final /* synthetic */ BluetoothScanViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BluetoothScanViewModel$startScan$1(BluetoothScanViewModel bluetoothScanViewModel, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = bluetoothScanViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new BluetoothScanViewModel$startScan$1(this.this$0, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            long j = this.this$0.x * ((long) 1000);
            this.label = 1;
            if (DelayKt.delay(j, this) == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
        }
        if (p31.a(this.this$0.T().f(), jn.a(true))) {
            this.this$0.i("扫描超时，暂停扫描");
            this.this$0.W();
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((BluetoothScanViewModel$startScan$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
