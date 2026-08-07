package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.content.Context;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.h70;
import defpackage.im1;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.r22;
import defpackage.rv2;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import xfkj.fitpro.manager.WatchThemeTransferManager;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.PicturePushViewModel$prepareAndUploadWithComposite$1", f = "PicturePushViewModel.kt", l = {234}, m = "invokeSuspend")
final class PicturePushViewModel$prepareAndUploadWithComposite$1 extends SuspendLambda implements or0 {
    final /* synthetic */ String $compositePath;
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ PicturePushViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PicturePushViewModel$prepareAndUploadWithComposite$1(PicturePushViewModel picturePushViewModel, Context context, String str, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = picturePushViewModel;
        this.$context = context;
        this.$compositePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new PicturePushViewModel$prepareAndUploadWithComposite$1(this.this$0, this.$context, this.$compositePath, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            im1 im1Var = this.this$0.o;
            String strD = rv2.d(R.string.preparing_for_upload);
            p31.e(strD, "getString(...)");
            im1Var.o(new r22.h(strD, 0));
            PicturePushViewModel picturePushViewModel = this.this$0;
            Context context = this.$context;
            String str = this.$compositePath;
            this.label = 1;
            obj = picturePushViewModel.p0(context, str, false, this);
            if (obj == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
        }
        WatchThemeTransferManager.b bVar = (WatchThemeTransferManager.b) obj;
        if (bVar != null) {
            if (!this.this$0.z0(this.$context, bVar.b())) {
                return k83.a;
            }
            this.this$0.x0(this.$context, bVar);
            return k83.a;
        }
        String strM = this.this$0.s.M();
        if (strM == null) {
            strM = rv2.d(R.string.watch_theme_build_failed);
        }
        PicturePushViewModel picturePushViewModel2 = this.this$0;
        p31.c(strM);
        picturePushViewModel2.u0(strM);
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((PicturePushViewModel$prepareAndUploadWithComposite$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
