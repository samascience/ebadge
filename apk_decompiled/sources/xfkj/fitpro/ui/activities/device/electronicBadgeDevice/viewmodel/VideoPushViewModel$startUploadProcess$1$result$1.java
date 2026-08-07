package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.content.Context;
import android.util.Log;
import com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.CommandPool;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.ar0;
import defpackage.h70;
import defpackage.j70;
import defpackage.k83;
import defpackage.md3;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import xfkj.fitpro.manager.WatchThemeTransferManager;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel$startUploadProcess$1$result$1", f = "VideoPushViewModel.kt", l = {1767}, m = "invokeSuspend")
final class VideoPushViewModel$startUploadProcess$1$result$1 extends SuspendLambda implements or0 {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $filePath;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ VideoPushViewModel this$0;

    public static final class a implements WatchThemeTransferManager.c {
        final /* synthetic */ Context a;
        final /* synthetic */ VideoPushViewModel b;
        final /* synthetic */ CancellableContinuation c;

        /* JADX INFO: renamed from: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel$startUploadProcess$1$result$1$a$a, reason: collision with other inner class name */
        static final class C0179a implements ar0 {
            public static final C0179a a = new C0179a();

            C0179a() {
            }

            public final void a(Throwable th) {
                p31.f(th, "it");
            }

            @Override // defpackage.ar0
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return k83.a;
            }
        }

        static final class b implements ar0 {
            public static final b a = new b();

            b() {
            }

            public final void a(Throwable th) {
                p31.f(th, "it");
            }

            @Override // defpackage.ar0
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return k83.a;
            }
        }

        a(Context context, VideoPushViewModel videoPushViewModel, CancellableContinuation cancellableContinuation) {
            this.a = context;
            this.b = videoPushViewModel;
            this.c = cancellableContinuation;
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void a(String str) {
            p31.f(str, "error");
            Log.e("VideoPushViewModel", "表盘传输失败: " + str);
            this.b.o.o(new md3.g(str));
            this.c.resume(Boolean.FALSE, C0179a.a);
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void b() {
            Log.d("VideoPushViewModel", "表盘传输成功");
            this.b.o.o(md3.i.a);
            this.c.resume(Boolean.TRUE, b.a);
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void c() {
            Log.d("VideoPushViewModel", "表盘传输开始");
            CommandPool.n(2);
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void d(int i) {
            CommandPool.n(2);
            Log.d("VideoPushViewModel", "表盘传输进度: " + i + "%");
            String string = this.a.getString(R.string.transfer_progress_format_msg, Integer.valueOf(i));
            p31.e(string, "getString(...)");
            this.b.o.o(new md3.n(i, string));
        }
    }

    static final class b implements ar0 {
        public static final b a = new b();

        b() {
        }

        public final void a(Throwable th) {
            Log.d("VideoPushViewModel", "上传被取消");
        }

        @Override // defpackage.ar0
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return k83.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPushViewModel$startUploadProcess$1$result$1(VideoPushViewModel videoPushViewModel, Context context, String str, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = videoPushViewModel;
        this.$context = context;
        this.$filePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new VideoPushViewModel$startUploadProcess$1$result$1(this.this$0, this.$context, this.$filePath, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            VideoPushViewModel videoPushViewModel = this.this$0;
            Context context = this.$context;
            String str = this.$filePath;
            this.L$0 = videoPushViewModel;
            this.L$1 = context;
            this.L$2 = str;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.a.c(this), 1);
            cancellableContinuationImpl.initCancellability();
            videoPushViewModel.t.V(context, str, new a(context, videoPushViewModel, cancellableContinuationImpl));
            cancellableContinuationImpl.invokeOnCancellation(b.a);
            obj = cancellableContinuationImpl.getResult();
            if (obj == kotlin.coroutines.intrinsics.a.d()) {
                j70.c(this);
            }
            if (obj == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
        }
        return obj;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((VideoPushViewModel$startUploadProcess$1$result$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
