package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.media.AudioRecord;
import android.util.Log;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslator$stop$2", f = "SimultaneousTranslator.kt", l = {}, m = "invokeSuspend")
final class SimultaneousTranslator$stop$2 extends SuspendLambda implements or0 {
    int label;
    final /* synthetic */ SimultaneousTranslator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimultaneousTranslator$stop$2(SimultaneousTranslator simultaneousTranslator, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = simultaneousTranslator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new SimultaneousTranslator$stop$2(this.this$0, x30Var);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0060 A[Catch: Exception -> 0x005c, TRY_LEAVE, TryCatch #0 {Exception -> 0x005c, blocks: (B:15:0x0058, B:19:0x0060), top: B:26:0x0058 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.d.b(obj);
        if (!this.this$0.u()) {
            return k83.a;
        }
        this.this$0.n = false;
        this.this$0.w(false);
        try {
            Log.i("SimTranslator", "NativeNui stopDialog");
            this.this$0.l.D();
        } catch (Exception e) {
            Log.e("SimTranslator", "Stop dialog error: " + e.getMessage());
        }
        AudioRecord audioRecord = this.this$0.j;
        this.this$0.j = null;
        if (audioRecord != null) {
            try {
                audioRecord.stop();
                if (audioRecord != null) {
                    audioRecord.release();
                }
            } catch (Exception e2) {
                Log.e("SimTranslator", "Stop audio record error: " + e2.getMessage());
            }
        } else if (audioRecord != null) {
            audioRecord.release();
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((SimultaneousTranslator$stop$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
