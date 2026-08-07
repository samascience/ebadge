package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.content.Context;
import android.util.Log;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import defpackage.h70;
import defpackage.im1;
import defpackage.k83;
import defpackage.md3;
import defpackage.nd3;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import defpackage.zi2;
import java.io.File;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import lombok.eclipse.Eclipse;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel$startUploadProcess$1", f = "VideoPushViewModel.kt", l = {559}, m = "invokeSuspend")
final class VideoPushViewModel$startUploadProcess$1 extends SuspendLambda implements or0 {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $filePath;
    int label;
    final /* synthetic */ VideoPushViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPushViewModel$startUploadProcess$1(VideoPushViewModel videoPushViewModel, String str, Context context, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = videoPushViewModel;
        this.$filePath = str;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new VideoPushViewModel$startUploadProcess$1(this.this$0, this.$filePath, this.$context, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objWithContext;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        try {
            if (i == 0) {
                d.b(obj);
                VideoPushViewModel.b bVarS0 = this.this$0.s0(this.$filePath, this.$context);
                if (!bVarS0.b()) {
                    this.this$0.j0(false);
                    this.this$0.o0(bVarS0.a());
                    return k83.a;
                }
                if (!zi2.i()) {
                    this.this$0.j0(false);
                    VideoPushViewModel videoPushViewModel = this.this$0;
                    String string = this.$context.getString(R.string.bluetooth_not_connected_error);
                    p31.e(string, "getString(...)");
                    videoPushViewModel.o0(string);
                    return k83.a;
                }
                Log.d("VideoPushViewModel", "开始使用表盘传输方式上传文件: " + this.$filePath);
                im1 im1Var = this.this$0.o;
                String string2 = this.$context.getString(R.string.uploading_file_progress);
                p31.e(string2, "getString(...)");
                im1Var.o(new md3.h(string2, 0));
                CoroutineDispatcher io2 = Dispatchers.getIO();
                VideoPushViewModel$startUploadProcess$1$result$1 videoPushViewModel$startUploadProcess$1$result$1 = new VideoPushViewModel$startUploadProcess$1$result$1(this.this$0, this.$context, this.$filePath, null);
                this.label = 1;
                objWithContext = BuildersKt.withContext(io2, videoPushViewModel$startUploadProcess$1$result$1, this);
                if (objWithContext == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
                objWithContext = obj;
            }
            if (((Boolean) objWithContext).booleanValue()) {
                nd3 nd3Var = (nd3) this.this$0.m.f();
                if (nd3Var == null) {
                    return k83.a;
                }
                this.this$0.m.o(nd3Var.a((4194299 & 1) != 0 ? nd3Var.a : null, (4194299 & 2) != 0 ? nd3Var.b : false, (4194299 & 4) != 0 ? nd3Var.c : false, (4194299 & 8) != 0 ? nd3Var.d : true, (4194299 & 16) != 0 ? nd3Var.e : null, (4194299 & 32) != 0 ? nd3Var.f : 0L, (4194299 & 64) != 0 ? nd3Var.g : new File(this.$filePath).length(), (4194299 & 128) != 0 ? nd3Var.h : this.$filePath, (4194299 & 256) != 0 ? nd3Var.i : false, (4194299 & 512) != 0 ? nd3Var.j : null, (4194299 & 1024) != 0 ? nd3Var.k : 0L, (4194299 & 2048) != 0 ? nd3Var.l : 0L, (4194299 & 4096) != 0 ? nd3Var.m : false, (4194299 & 8192) != 0 ? nd3Var.n : false, (4194299 & 16384) != 0 ? nd3Var.o : null, (4194299 & 32768) != 0 ? nd3Var.p : false, (4194299 & 65536) != 0 ? nd3Var.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var.u : null, (4194299 & 2097152) != 0 ? nd3Var.v : false));
                this.this$0.o.o(md3.o.a);
                Log.d("VideoPushViewModel", "文件上传成功: " + this.$filePath);
            } else {
                this.this$0.j0(false);
                String string3 = this.$context.getString(R.string.watch_theme_transfer_failed_error);
                p31.e(string3, "getString(...)");
                this.this$0.o0(string3);
                this.this$0.o.o(new md3.m(string3));
                Log.e("VideoPushViewModel", "文件上传失败: " + this.$filePath);
            }
        } catch (Exception e) {
            this.this$0.j0(false);
            Context context = this.$context;
            String message = e.getMessage();
            if (message == null) {
                message = Constants.STR_EMPTY;
            }
            String string4 = context.getString(R.string.upload_failed_error_msg, message);
            p31.e(string4, "getString(...)");
            this.this$0.o0(string4);
            this.this$0.o.o(new md3.m(string4));
            Log.e("VideoPushViewModel", "上传失败", e);
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((VideoPushViewModel$startUploadProcess$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
