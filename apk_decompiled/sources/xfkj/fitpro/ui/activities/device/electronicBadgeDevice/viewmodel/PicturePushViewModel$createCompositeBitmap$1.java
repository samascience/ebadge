package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import defpackage.h70;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.PicturePushViewModel", f = "PicturePushViewModel.kt", l = {716}, m = "createCompositeBitmap")
final class PicturePushViewModel$createCompositeBitmap$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PicturePushViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PicturePushViewModel$createCompositeBitmap$1(PicturePushViewModel picturePushViewModel, x30 x30Var) {
        super(x30Var);
        this.this$0 = picturePushViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.K(null, null, this);
    }
}
