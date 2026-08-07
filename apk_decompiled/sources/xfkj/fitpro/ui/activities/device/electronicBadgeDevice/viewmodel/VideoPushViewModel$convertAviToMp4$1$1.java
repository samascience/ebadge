package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.net.Uri;
import android.util.Log;
import defpackage.h70;
import defpackage.im1;
import defpackage.k83;
import defpackage.md3;
import defpackage.nd3;
import defpackage.or0;
import defpackage.p31;
import defpackage.sh2;
import defpackage.x30;
import defpackage.yj0;
import java.io.File;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import lombok.eclipse.Eclipse;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel$convertAviToMp4$1$1", f = "VideoPushViewModel.kt", l = {}, m = "invokeSuspend")
final class VideoPushViewModel$convertAviToMp4$1$1 extends SuspendLambda implements or0 {
    final /* synthetic */ String $mp4Path;
    final /* synthetic */ yj0 $session;
    int label;
    final /* synthetic */ VideoPushViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPushViewModel$convertAviToMp4$1$1(yj0 yj0Var, String str, VideoPushViewModel videoPushViewModel, x30 x30Var) {
        super(2, x30Var);
        this.$session = yj0Var;
        this.$mp4Path = str;
        this.this$0 = videoPushViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new VideoPushViewModel$convertAviToMp4$1$1(this.$session, this.$mp4Path, this.this$0, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d.b(obj);
        if (sh2.b(this.$session.n())) {
            File file = new File(this.$mp4Path);
            if (!file.exists() || file.length() <= 0) {
                Log.e("VideoPushViewModel", "MP4文件不存在或为空，保持使用AVI预览");
            } else {
                Log.d("VideoPushViewModel", "AVI转MP4成功，文件大小: " + file.length() + " bytes");
                Uri uriFromFile = Uri.fromFile(file);
                nd3 nd3Var = (nd3) this.this$0.m.f();
                if (nd3Var == null) {
                    return k83.a;
                }
                this.this$0.m.o(nd3Var.a((4194299 & 1) != 0 ? nd3Var.a : uriFromFile, (4194299 & 2) != 0 ? nd3Var.b : false, (4194299 & 4) != 0 ? nd3Var.c : false, (4194299 & 8) != 0 ? nd3Var.d : false, (4194299 & 16) != 0 ? nd3Var.e : null, (4194299 & 32) != 0 ? nd3Var.f : 0L, (4194299 & 64) != 0 ? nd3Var.g : 0L, (4194299 & 128) != 0 ? nd3Var.h : null, (4194299 & 256) != 0 ? nd3Var.i : false, (4194299 & 512) != 0 ? nd3Var.j : null, (4194299 & 1024) != 0 ? nd3Var.k : 0L, (4194299 & 2048) != 0 ? nd3Var.l : 0L, (4194299 & 4096) != 0 ? nd3Var.m : false, (4194299 & 8192) != 0 ? nd3Var.n : false, (4194299 & 16384) != 0 ? nd3Var.o : null, (4194299 & 32768) != 0 ? nd3Var.p : false, (4194299 & 65536) != 0 ? nd3Var.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var.u : null, (4194299 & 2097152) != 0 ? nd3Var.v : false));
                im1 im1Var = this.this$0.o;
                p31.c(uriFromFile);
                im1Var.o(new md3.e(uriFromFile));
                Log.d("VideoPushViewModel", "预览已更新为MP4格式: " + uriFromFile);
            }
        } else {
            Log.e("VideoPushViewModel", "AVI转MP4失败: " + this.$session.m());
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((VideoPushViewModel$convertAviToMp4$1$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
