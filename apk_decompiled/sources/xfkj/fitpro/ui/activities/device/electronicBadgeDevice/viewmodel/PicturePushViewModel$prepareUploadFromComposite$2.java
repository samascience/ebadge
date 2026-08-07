package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.content.Context;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.s22;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import xfkj.fitpro.manager.WatchThemeTransferManager;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.PicturePushViewModel$prepareUploadFromComposite$2", f = "PicturePushViewModel.kt", l = {261, 266}, m = "invokeSuspend")
final class PicturePushViewModel$prepareUploadFromComposite$2 extends SuspendLambda implements or0 {
    final /* synthetic */ String $compositePath;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $showExceedsToast;
    Object L$0;
    int label;
    final /* synthetic */ PicturePushViewModel this$0;

    /* JADX INFO: renamed from: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.PicturePushViewModel$prepareUploadFromComposite$2$1, reason: invalid class name */
    @h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.PicturePushViewModel$prepareUploadFromComposite$2$1", f = "PicturePushViewModel.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements or0 {
        final /* synthetic */ Context $context;
        final /* synthetic */ WatchThemeTransferManager.b $prepared;
        final /* synthetic */ boolean $showExceedsToast;
        int label;
        final /* synthetic */ PicturePushViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PicturePushViewModel picturePushViewModel, WatchThemeTransferManager.b bVar, boolean z, Context context, x30 x30Var) {
            super(2, x30Var);
            this.this$0 = picturePushViewModel;
            this.$prepared = bVar;
            this.$showExceedsToast = z;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new AnonymousClass1(this.this$0, this.$prepared, this.$showExceedsToast, this.$context, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
            s22 s22Var = (s22) this.this$0.m.f();
            if (s22Var == null) {
                s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
            }
            this.this$0.m.o(this.this$0.E(s22Var, this.$prepared.a(), this.$prepared.b(), this.$showExceedsToast ? this.$context : null));
            return k83.a;
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PicturePushViewModel$prepareUploadFromComposite$2(PicturePushViewModel picturePushViewModel, Context context, String str, boolean z, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = picturePushViewModel;
        this.$context = context;
        this.$compositePath = str;
        this.$showExceedsToast = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new PicturePushViewModel$prepareUploadFromComposite$2(this.this$0, this.$context, this.$compositePath, this.$showExceedsToast, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            this.this$0.O();
            WatchThemeTransferManager watchThemeTransferManager = this.this$0.s;
            Context context = this.$context;
            String str = this.$compositePath;
            this.label = 1;
            obj = watchThemeTransferManager.P(context, str, this);
            if (obj == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                WatchThemeTransferManager.b bVar = (WatchThemeTransferManager.b) this.L$0;
                d.b(obj);
                return bVar;
            }
            d.b(obj);
        }
        WatchThemeTransferManager.b bVar2 = (WatchThemeTransferManager.b) obj;
        if (bVar2 == null) {
            return null;
        }
        this.this$0.x = bVar2.a();
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, bVar2, this.$showExceedsToast, this.$context, null);
        this.L$0 = bVar2;
        this.label = 2;
        return BuildersKt.withContext(main, anonymousClass1, this) == objD ? objD : bVar2;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((PicturePushViewModel$prepareUploadFromComposite$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
