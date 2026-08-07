package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.h70;
import defpackage.im1;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.rv2;
import defpackage.s22;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.PicturePushViewModel$requestDeviceFreeStorage$1", f = "PicturePushViewModel.kt", l = {Opcodes.L2D}, m = "invokeSuspend")
final class PicturePushViewModel$requestDeviceFreeStorage$1 extends SuspendLambda implements or0 {
    int label;
    final /* synthetic */ PicturePushViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PicturePushViewModel$requestDeviceFreeStorage$1(PicturePushViewModel picturePushViewModel, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = picturePushViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new PicturePushViewModel$requestDeviceFreeStorage$1(this.this$0, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            this.label = 1;
            if (DelayKt.delay(5000L, this) == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
        }
        if (this.this$0.u) {
            this.this$0.u = false;
            im1 im1Var = this.this$0.m;
            s22 s22Var = (s22) this.this$0.m.f();
            if (s22Var == null) {
                s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
            }
            s22 s22Var2 = s22Var;
            im1Var.m(s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : null, (16335 & 16) != 0 ? s22Var2.e : false, (16335 & 32) != 0 ? s22Var2.f : null, (16335 & 64) != 0 ? s22Var2.g : null, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false));
            PicturePushViewModel picturePushViewModel = this.this$0;
            String strD = rv2.d(R.string.device_storage_fetch_timeout);
            p31.e(strD, "getString(...)");
            picturePushViewModel.u0(strD);
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((PicturePushViewModel$requestDeviceFreeStorage$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
