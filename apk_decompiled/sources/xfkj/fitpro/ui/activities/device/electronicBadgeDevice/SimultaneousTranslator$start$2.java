package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.util.Log;
import com.alibaba.idst.nui.Constants$LogLevel;
import com.alibaba.idst.nui.Constants$VadMode;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import defpackage.ar0;
import defpackage.cr2;
import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import java.io.File;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslator$start$2", f = "SimultaneousTranslator.kt", l = {}, m = "invokeSuspend")
final class SimultaneousTranslator$start$2 extends SuspendLambda implements or0 {
    final /* synthetic */ String $sourceLanguage;
    final /* synthetic */ String $targetLanguage;
    int label;
    final /* synthetic */ SimultaneousTranslator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimultaneousTranslator$start$2(SimultaneousTranslator simultaneousTranslator, String str, String str2, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = simultaneousTranslator;
        this.$sourceLanguage = str;
        this.$targetLanguage = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new SimultaneousTranslator$start$2(this.this$0, this.$sourceLanguage, this.$targetLanguage, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.d.b(obj);
        if (!this.this$0.s()) {
            ar0 ar0Var = this.this$0.d;
            if (ar0Var != null) {
                ar0Var.invoke("录音权限未授予");
            }
            return jn.a(false);
        }
        if (!this.this$0.t()) {
            ar0 ar0Var2 = this.this$0.d;
            if (ar0Var2 != null) {
                ar0Var2.invoke("网络连接失败，请检查网络设置");
            }
            return jn.a(false);
        }
        if (this.this$0.u()) {
            ar0 ar0Var3 = this.this$0.d;
            if (ar0Var3 != null) {
                ar0Var3.invoke("翻译器已经在运行");
            }
            return jn.a(false);
        }
        String strR = this.this$0.r(this.$sourceLanguage);
        String strR2 = this.this$0.r(this.$targetLanguage);
        Log.i("SimTranslator", "sourceLanguageCode: " + strR + ", targetLanguageCode: " + strR2);
        if (strR == null || strR2 == null) {
            ar0 ar0Var4 = this.this$0.d;
            if (ar0Var4 != null) {
                ar0Var4.invoke("不支持的语言名称");
            }
            return jn.a(false);
        }
        try {
            if (!this.this$0.m) {
                String absolutePath = new File(this.this$0.a.getExternalCacheDir(), "debug_nui").getAbsolutePath();
                File file = new File(absolutePath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("device_id", "empty_device_id");
                String strE = cr2.a.e();
                if (strE == null) {
                    strE = "wss://dashscope-intl.aliyuncs.com/api-ws/v1/realtime?model=qwen3-livetranslate-flash-realtime";
                }
                jSONObject.put(SocialConstants.PARAM_URL, strE);
                jSONObject.put("save_wav", "true");
                jSONObject.put("debug_path", absolutePath);
                jSONObject.put("log_track_level", String.valueOf(Constants$LogLevel.toInt(Constants$LogLevel.LOG_LEVEL_NONE)));
                jSONObject.put("service_mode", "1");
                String string = jSONObject.toString();
                p31.e(string, "toString(...)");
                Log.i("SimTranslator", "Initializing NativeNui with params: " + string);
                int iU = this.this$0.l.u(this.this$0, string, Constants$LogLevel.LOG_LEVEL_DEBUG, true);
                if (iU != 0) {
                    Log.e("SimTranslator", "NativeNui initialize failed: " + iU);
                    ar0 ar0Var5 = this.this$0.d;
                    if (ar0Var5 != null) {
                        ar0Var5.invoke("初始化失败: " + iU);
                    }
                    return jn.a(false);
                }
                this.this$0.m = true;
            }
            JSONObject jSONObject2 = new JSONObject();
            SimultaneousTranslator simultaneousTranslator = this.this$0;
            jSONObject2.put("sr_format", "pcm");
            jSONObject2.put("model", "qwen3-asr-flash-realtime");
            jSONObject2.put("model_basename", "qwen-livetranslate");
            jSONObject2.put("modalities", "[\"text\", \"audio\"]");
            jSONObject2.put("sample_rate", simultaneousTranslator.g);
            if (!p31.a(strR, DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                jSONObject2.put("source_language", strR);
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(strR2);
            jSONObject2.put("translation_target_languages", jSONArray.toString());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("nls_config", jSONObject2);
            jSONObject3.put("service_type", 4);
            String string2 = jSONObject3.toString();
            p31.e(string2, "toString(...)");
            Log.i("SimTranslator", "NativeNui setParams: " + string2);
            this.this$0.l.y(string2);
            this.this$0.o = Constants.STR_EMPTY;
            this.this$0.p = Constants.STR_EMPTY;
            this.this$0.f400q = false;
            this.this$0.r = false;
            this.this$0.n = false;
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("apikey", this.this$0.b);
            String string3 = jSONObject4.toString();
            p31.e(string3, "toString(...)");
            Log.i("SimTranslator", "NativeNui startDialog");
            int iC = this.this$0.l.C(Constants$VadMode.TYPE_P2T, string3);
            if (iC == 0) {
                this.this$0.w(true);
                return jn.a(true);
            }
            Log.e("SimTranslator", "NativeNui startDialog failed: " + iC);
            ar0 ar0Var6 = this.this$0.d;
            if (ar0Var6 != null) {
                ar0Var6.invoke("启动失败: " + iC);
            }
            return jn.a(false);
        } catch (Exception e) {
            Log.e("SimTranslator", "Start error: " + e.getMessage());
            ar0 ar0Var7 = this.this$0.d;
            if (ar0Var7 != null) {
                ar0Var7.invoke("启动失败: " + e.getMessage());
            }
            return jn.a(false);
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((SimultaneousTranslator$start$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
