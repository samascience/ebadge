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
@h70(c = "xfkj.fitpro.ui.viewmodels.bluetooth.BluetoothScanViewModel$updateDeviceListWithDebounce$1", f = "BluetoothScanViewModel.kt", l = {520}, m = "invokeSuspend")
final class BluetoothScanViewModel$updateDeviceListWithDebounce$1 extends SuspendLambda implements or0 {
    final /* synthetic */ long $remainingDelay;
    int label;
    final /* synthetic */ BluetoothScanViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BluetoothScanViewModel$updateDeviceListWithDebounce$1(long j, BluetoothScanViewModel bluetoothScanViewModel, x30 x30Var) {
        super(2, x30Var);
        this.$remainingDelay = j;
        this.this$0 = bluetoothScanViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new BluetoothScanViewModel$updateDeviceListWithDebounce$1(this.$remainingDelay, this.this$0, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            long j = this.$remainingDelay;
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
        this.this$0.j0();
        this.this$0.G = System.currentTimeMillis();
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((BluetoothScanViewModel$updateDeviceListWithDebounce$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
