package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.h70;
import defpackage.im1;
import defpackage.k83;
import defpackage.nd3;
import defpackage.or0;
import defpackage.p31;
import defpackage.u73;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import lombok.eclipse.Eclipse;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel$requestDeviceFreeStorage$1", f = "VideoPushViewModel.kt", l = {240}, m = "invokeSuspend")
final class VideoPushViewModel$requestDeviceFreeStorage$1 extends SuspendLambda implements or0 {
    int label;
    final /* synthetic */ VideoPushViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPushViewModel$requestDeviceFreeStorage$1(VideoPushViewModel videoPushViewModel, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = videoPushViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new VideoPushViewModel$requestDeviceFreeStorage$1(this.this$0, x30Var);
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
        if (this.this$0.r) {
            this.this$0.r = false;
            im1 im1Var = this.this$0.m;
            nd3 nd3Var = (nd3) this.this$0.m.f();
            if (nd3Var == null) {
                nd3Var = new nd3(null, false, false, false, null, 0L, 0L, null, false, null, 0L, 0L, false, false, null, false, false, null, false, null, null, false, 4194303, null);
            }
            nd3 nd3Var2 = nd3Var;
            im1Var.o(nd3Var2.a((4194299 & 1) != 0 ? nd3Var2.a : null, (4194299 & 2) != 0 ? nd3Var2.b : false, (4194299 & 4) != 0 ? nd3Var2.c : false, (4194299 & 8) != 0 ? nd3Var2.d : false, (4194299 & 16) != 0 ? nd3Var2.e : null, (4194299 & 32) != 0 ? nd3Var2.f : 0L, (4194299 & 64) != 0 ? nd3Var2.g : 0L, (4194299 & 128) != 0 ? nd3Var2.h : null, (4194299 & 256) != 0 ? nd3Var2.i : false, (4194299 & 512) != 0 ? nd3Var2.j : null, (4194299 & 1024) != 0 ? nd3Var2.k : 0L, (4194299 & 2048) != 0 ? nd3Var2.l : 0L, (4194299 & 4096) != 0 ? nd3Var2.m : false, (4194299 & 8192) != 0 ? nd3Var2.n : false, (4194299 & 16384) != 0 ? nd3Var2.o : null, (4194299 & 32768) != 0 ? nd3Var2.p : false, (4194299 & 65536) != 0 ? nd3Var2.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var2.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var2.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var2.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var2.u : null, (4194299 & 2097152) != 0 ? nd3Var2.v : false));
            VideoPushViewModel videoPushViewModel = this.this$0;
            String strB = u73.b(R.string.device_storage_fetch_timeout);
            p31.e(strB, "getString(...)");
            videoPushViewModel.o0(strB);
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((VideoPushViewModel$requestDeviceFreeStorage$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
