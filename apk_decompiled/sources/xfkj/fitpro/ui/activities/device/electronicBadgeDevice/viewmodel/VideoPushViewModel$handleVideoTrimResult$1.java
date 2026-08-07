package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.content.Context;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.h70;
import defpackage.im1;
import defpackage.k83;
import defpackage.md3;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel$handleVideoTrimResult$1", f = "VideoPushViewModel.kt", l = {1681}, m = "invokeSuspend")
final class VideoPushViewModel$handleVideoTrimResult$1 extends SuspendLambda implements or0 {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ VideoPushViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPushViewModel$handleVideoTrimResult$1(VideoPushViewModel videoPushViewModel, Context context, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = videoPushViewModel;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new VideoPushViewModel$handleVideoTrimResult$1(this.this$0, this.$context, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            this.label = 1;
            if (DelayKt.delay(100L, this) == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
        }
        if (this.this$0.u) {
            im1 im1Var = this.this$0.o;
            String string = this.$context.getString(R.string.gif_crop_success);
            p31.e(string, "getString(...)");
            im1Var.o(new md3.f(string));
        } else {
            im1 im1Var2 = this.this$0.o;
            String string2 = this.$context.getString(R.string.video_crop_complete_generating_preview);
            p31.e(string2, "getString(...)");
            im1Var2.o(new md3.f(string2));
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((VideoPushViewModel$handleVideoTrimResult$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
