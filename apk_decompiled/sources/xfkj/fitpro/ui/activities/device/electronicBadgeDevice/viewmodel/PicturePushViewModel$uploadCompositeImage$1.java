package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import com.baji.protocol.BajiProtocolManager;
import com.baji.protocol.model.TransferFileInfo;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.s22;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.PicturePushViewModel$uploadCompositeImage$1", f = "PicturePushViewModel.kt", l = {}, m = "invokeSuspend")
final class PicturePushViewModel$uploadCompositeImage$1 extends SuspendLambda implements or0 {
    final /* synthetic */ String $filePath;
    final /* synthetic */ long $fileSize;
    final /* synthetic */ int $mediaId;
    final /* synthetic */ BajiProtocolManager $protocolManager;
    final /* synthetic */ TransferFileInfo $transferInfo;
    int label;
    final /* synthetic */ PicturePushViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PicturePushViewModel$uploadCompositeImage$1(PicturePushViewModel picturePushViewModel, String str, long j, int i, BajiProtocolManager bajiProtocolManager, TransferFileInfo transferFileInfo, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = picturePushViewModel;
        this.$filePath = str;
        this.$fileSize = j;
        this.$mediaId = i;
        this.$protocolManager = bajiProtocolManager;
        this.$transferInfo = transferFileInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new PicturePushViewModel$uploadCompositeImage$1(this.this$0, this.$filePath, this.$fileSize, this.$mediaId, this.$protocolManager, this.$transferInfo, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d.b(obj);
        try {
            this.this$0.i("开始上传合成图片: " + this.$filePath + ", 大小: " + this.$fileSize + " bytes, 媒体ID: " + this.$mediaId);
            this.$protocolManager.startFileTransfer(this.$transferInfo);
            this.this$0.i("文件传输命令已发送");
        } catch (Exception e) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this.this$0, "上传合成图片失败: " + e.getMessage(), null, 2, null);
            this.this$0.u0("上传失败: " + e.getMessage());
            s22 s22Var = (s22) this.this$0.m.f();
            if (s22Var == null) {
                s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
            }
            s22 s22Var2 = s22Var;
            this.this$0.m.m(s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : null, (16335 & 16) != 0 ? s22Var2.e : false, (16335 & 32) != 0 ? s22Var2.f : null, (16335 & 64) != 0 ? s22Var2.g : null, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false));
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((PicturePushViewModel$uploadCompositeImage$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
