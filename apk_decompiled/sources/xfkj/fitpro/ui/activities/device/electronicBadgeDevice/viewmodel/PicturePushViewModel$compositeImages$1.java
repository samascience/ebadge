package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.graphics.Bitmap;
import defpackage.aw2;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.s22;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.PicturePushViewModel$compositeImages$1", f = "PicturePushViewModel.kt", l = {677}, m = "invokeSuspend")
final class PicturePushViewModel$compositeImages$1 extends SuspendLambda implements or0 {
    final /* synthetic */ Bitmap $backgroundBitmap;
    final /* synthetic */ aw2 $styleItem;
    int label;
    final /* synthetic */ PicturePushViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PicturePushViewModel$compositeImages$1(PicturePushViewModel picturePushViewModel, Bitmap bitmap, aw2 aw2Var, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = picturePushViewModel;
        this.$backgroundBitmap = bitmap;
        this.$styleItem = aw2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new PicturePushViewModel$compositeImages$1(this.this$0, this.$backgroundBitmap, this.$styleItem, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objK;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        try {
            if (i == 0) {
                d.b(obj);
                PicturePushViewModel picturePushViewModel = this.this$0;
                Bitmap bitmap = this.$backgroundBitmap;
                aw2 aw2Var = this.$styleItem;
                this.label = 1;
                objK = picturePushViewModel.K(bitmap, aw2Var, this);
                if (objK == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
                objK = obj;
            }
            Bitmap bitmap2 = (Bitmap) objK;
            s22 s22Var = (s22) this.this$0.m.f();
            if (s22Var == null) {
                s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
            }
            s22 s22Var2 = s22Var;
            this.this$0.m.m(s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : bitmap2, (16335 & 8) != 0 ? s22Var2.d : null, (16335 & 16) != 0 ? s22Var2.e : false, (16335 & 32) != 0 ? s22Var2.f : null, (16335 & 64) != 0 ? s22Var2.g : null, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false));
            this.this$0.i("图片合成完成");
        } catch (Exception e) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this.this$0, "图片合成失败: " + e.getMessage(), null, 2, null);
            this.this$0.u0("图片合成失败");
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((PicturePushViewModel$compositeImages$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
