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
import xfkj.fitpro.model.BluetoothDeviceInfo;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.viewmodels.bluetooth.BluetoothScanViewModel$connectDevice$1", f = "BluetoothScanViewModel.kt", l = {346}, m = "invokeSuspend")
final class BluetoothScanViewModel$connectDevice$1 extends SuspendLambda implements or0 {
    final /* synthetic */ BluetoothDeviceInfo $deviceInfo;
    int label;
    final /* synthetic */ BluetoothScanViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BluetoothScanViewModel$connectDevice$1(BluetoothScanViewModel bluetoothScanViewModel, BluetoothDeviceInfo bluetoothDeviceInfo, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = bluetoothScanViewModel;
        this.$deviceInfo = bluetoothDeviceInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new BluetoothScanViewModel$connectDevice$1(this.this$0, this.$deviceInfo, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            long j = this.this$0.y * ((long) 1000);
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
        if (this.this$0.F().f() == BluetoothScanViewModel.ConnectionState.CONNECTING) {
            this.this$0.i("连接超时，设置连接失败状态");
            this.this$0.F().o(BluetoothScanViewModel.ConnectionState.CONNECT_FAILED);
            BluetoothScanViewModel.i0(this.this$0, this.$deviceInfo.getAddress(), false, false, 2, null);
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((BluetoothScanViewModel$connectDevice$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
