package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.media.AudioDeviceInfo;
import android.os.Build;
import android.util.Log;
import com.alibaba.dashscope.aigc.multimodalconversation.AudioParameters;
import defpackage.ar0;
import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.pl1;
import defpackage.tl1;
import defpackage.x30;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1", f = "SimultaneousTranslationActivity.kt", l = {563, 566}, m = "invokeSuspend")
final class SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1 extends SuspendLambda implements or0 {
    final /* synthetic */ boolean $forcePhoneFallback;
    final /* synthetic */ String $language;
    final /* synthetic */ long $sessionId;
    final /* synthetic */ String $text;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SimultaneousTranslationActivity this$0;

    /* JADX INFO: renamed from: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1$1, reason: invalid class name */
    @h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1$1", f = "SimultaneousTranslationActivity.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements or0 {
        final /* synthetic */ boolean $forcePhoneFallback;
        int label;
        final /* synthetic */ SimultaneousTranslationActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, SimultaneousTranslationActivity simultaneousTranslationActivity, x30 x30Var) {
            super(2, x30Var);
            this.$forcePhoneFallback = z;
            this.this$0 = simultaneousTranslationActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new AnonymousClass1(this.$forcePhoneFallback, this.this$0, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AudioDeviceInfo audioDeviceInfo;
            kotlin.coroutines.intrinsics.a.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.d.b(obj);
            if (!this.$forcePhoneFallback) {
                this.this$0.q1();
            } else if (Build.VERSION.SDK_INT >= 28) {
                try {
                    AudioDeviceInfo[] devices = this.this$0.T1().getDevices(2);
                    p31.e(devices, "getDevices(...)");
                    int length = devices.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            audioDeviceInfo = null;
                            break;
                        }
                        audioDeviceInfo = devices[i];
                        if (audioDeviceInfo.getType() == 2) {
                            break;
                        }
                        i++;
                    }
                    if (audioDeviceInfo == null) {
                        jn.b(Log.w(this.this$0.K(), "forcePhoneFallback: No TYPE_BUILTIN_SPEAKER output device found"));
                    } else if (!this.this$0.f399q.setPreferredDevice(audioDeviceInfo)) {
                        Log.w(this.this$0.K(), "forcePhoneFallback setPreferredDevice(speaker) returned false");
                    }
                } catch (Exception e) {
                    jn.b(Log.w(this.this$0.K(), "forcePhoneFallback: " + e.getMessage()));
                }
            }
            return k83.a;
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1(SimultaneousTranslationActivity simultaneousTranslationActivity, String str, String str2, boolean z, long j, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = simultaneousTranslationActivity;
        this.$text = str;
        this.$language = str2;
        this.$forcePhoneFallback = z;
        this.$sessionId = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 invokeSuspend$lambda$0(CoroutineScope coroutineScope, Ref$BooleanRef ref$BooleanRef, SimultaneousTranslationActivity simultaneousTranslationActivity, tl1 tl1Var) {
        CoroutineScopeKt.ensureActive(coroutineScope);
        tl1Var.e();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$2(long j, SimultaneousTranslationActivity simultaneousTranslationActivity) {
        if (j == simultaneousTranslationActivity.O) {
            simultaneousTranslationActivity.g2();
            return;
        }
        Log.d(simultaneousTranslationActivity.K(), "旧会话完成回调被丢弃 session=" + j + " current=" + simultaneousTranslationActivity.O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$3(long j, SimultaneousTranslationActivity simultaneousTranslationActivity) {
        if (j == simultaneousTranslationActivity.O) {
            simultaneousTranslationActivity.X2();
            simultaneousTranslationActivity.x1();
            return;
        }
        Log.d(simultaneousTranslationActivity.K(), "旧会话取消回调被丢弃 session=" + j + " current=" + simultaneousTranslationActivity.O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$4(long j, SimultaneousTranslationActivity simultaneousTranslationActivity) {
        if (j == simultaneousTranslationActivity.O) {
            simultaneousTranslationActivity.g2();
            return;
        }
        Log.d(simultaneousTranslationActivity.K(), "旧会话错误回调被丢弃 session=" + j + " current=" + simultaneousTranslationActivity.O);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1 simultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1 = new SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1(this.this$0, this.$text, this.$language, this.$forcePhoneFallback, this.$sessionId, x30Var);
        simultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1.L$0 = obj;
        return simultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x006b A[Catch: Exception -> 0x0017, CancellationException -> 0x001a, TRY_ENTER, TryCatch #2 {CancellationException -> 0x001a, Exception -> 0x0017, blocks: (B:7:0x0013, B:26:0x005e, B:29:0x006b, B:30:0x006f, B:32:0x007f, B:34:0x0087, B:35:0x008b, B:37:0x009b, B:39:0x00a3, B:41:0x00a8, B:44:0x00b9, B:46:0x00be, B:45:0x00bc, B:16:0x0029, B:22:0x0042, B:19:0x0035), top: B:52:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x007f A[Catch: Exception -> 0x0017, CancellationException -> 0x001a, TryCatch #2 {CancellationException -> 0x001a, Exception -> 0x0017, blocks: (B:7:0x0013, B:26:0x005e, B:29:0x006b, B:30:0x006f, B:32:0x007f, B:34:0x0087, B:35:0x008b, B:37:0x009b, B:39:0x00a3, B:41:0x00a8, B:44:0x00b9, B:46:0x00be, B:45:0x00bc, B:16:0x0029, B:22:0x0042, B:19:0x0035), top: B:52:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0087 A[Catch: Exception -> 0x0017, CancellationException -> 0x001a, TryCatch #2 {CancellationException -> 0x001a, Exception -> 0x0017, blocks: (B:7:0x0013, B:26:0x005e, B:29:0x006b, B:30:0x006f, B:32:0x007f, B:34:0x0087, B:35:0x008b, B:37:0x009b, B:39:0x00a3, B:41:0x00a8, B:44:0x00b9, B:46:0x00be, B:45:0x00bc, B:16:0x0029, B:22:0x0042, B:19:0x0035), top: B:52:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x009b A[Catch: Exception -> 0x0017, CancellationException -> 0x001a, TryCatch #2 {CancellationException -> 0x001a, Exception -> 0x0017, blocks: (B:7:0x0013, B:26:0x005e, B:29:0x006b, B:30:0x006f, B:32:0x007f, B:34:0x0087, B:35:0x008b, B:37:0x009b, B:39:0x00a3, B:41:0x00a8, B:44:0x00b9, B:46:0x00be, B:45:0x00bc, B:16:0x0029, B:22:0x0042, B:19:0x0035), top: B:52:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a3 A[Catch: Exception -> 0x0017, CancellationException -> 0x001a, TryCatch #2 {CancellationException -> 0x001a, Exception -> 0x0017, blocks: (B:7:0x0013, B:26:0x005e, B:29:0x006b, B:30:0x006f, B:32:0x007f, B:34:0x0087, B:35:0x008b, B:37:0x009b, B:39:0x00a3, B:41:0x00a8, B:44:0x00b9, B:46:0x00be, B:45:0x00bc, B:16:0x0029, B:22:0x0042, B:19:0x0035), top: B:52:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b9 A[Catch: Exception -> 0x0017, CancellationException -> 0x001a, TryCatch #2 {CancellationException -> 0x001a, Exception -> 0x0017, blocks: (B:7:0x0013, B:26:0x005e, B:29:0x006b, B:30:0x006f, B:32:0x007f, B:34:0x0087, B:35:0x008b, B:37:0x009b, B:39:0x00a3, B:41:0x00a8, B:44:0x00b9, B:46:0x00be, B:45:0x00bc, B:16:0x0029, B:22:0x0042, B:19:0x0035), top: B:52:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00bc A[Catch: Exception -> 0x0017, CancellationException -> 0x001a, TryCatch #2 {CancellationException -> 0x001a, Exception -> 0x0017, blocks: (B:7:0x0013, B:26:0x005e, B:29:0x006b, B:30:0x006f, B:32:0x007f, B:34:0x0087, B:35:0x008b, B:37:0x009b, B:39:0x00a3, B:41:0x00a8, B:44:0x00b9, B:46:0x00be, B:45:0x00bc, B:16:0x0029, B:22:0x0042, B:19:0x0035), top: B:52:0x0009 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineScope coroutineScope;
        final CoroutineScope coroutineScope2;
        String str;
        AudioParameters.Voice voice;
        String str2;
        String str3;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        String str4 = null;
        try {
            if (i != 0) {
                if (i == 1) {
                    CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                    kotlin.d.b(obj);
                    coroutineScope = coroutineScope3;
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    kotlin.d.b(obj);
                }
                CoroutineScopeKt.ensureActive(coroutineScope2);
                str = this.this$0.t;
                if (str == null) {
                    p31.t("targetLanguage");
                    str = null;
                }
                if (p31.a(kotlin.text.i.O0(str).toString(), "粤语")) {
                    voice = AudioParameters.Voice.KIKI;
                } else {
                    str2 = this.this$0.t;
                    if (str2 == null) {
                        p31.t("targetLanguage");
                        str2 = null;
                    }
                    if (p31.a(kotlin.text.i.O0(str2).toString(), "粵語")) {
                        voice = AudioParameters.Voice.KIKI;
                    } else {
                        str3 = this.this$0.t;
                        if (str3 == null) {
                            p31.t("targetLanguage");
                        } else {
                            str4 = str3;
                        }
                        if (kotlin.text.i.v(kotlin.text.i.O0(str4).toString(), "Cantonese", true)) {
                            voice = AudioParameters.Voice.KIKI;
                        } else {
                            voice = AudioParameters.Voice.ELIAS;
                        }
                    }
                }
                Flowable flowableL = new pl1().l(((com.alibaba.dashscope.aigc.multimodalconversation.a.b) ((com.alibaba.dashscope.aigc.multimodalconversation.a.b) com.alibaba.dashscope.aigc.multimodalconversation.a.s().k(this.this$0.F)).p("qwen3-tts-flash")).a0(this.$text).b0(voice).Y(this.$language).X());
                final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                ref$BooleanRef.element = true;
                final SimultaneousTranslationActivity simultaneousTranslationActivity = this.this$0;
                final ar0 ar0Var = new ar0() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.g
                    @Override // defpackage.ar0
                    public final Object invoke(Object obj2) {
                        return SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1.invokeSuspend$lambda$0(coroutineScope2, ref$BooleanRef, simultaneousTranslationActivity, (tl1) obj2);
                    }
                };
                flowableL.blockingForEach(new Consumer() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.h
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj2) {
                        ar0Var.invoke(obj2);
                    }
                });
                final SimultaneousTranslationActivity simultaneousTranslationActivity2 = this.this$0;
                final long j = this.$sessionId;
                simultaneousTranslationActivity2.runOnUiThread(new Runnable() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1.invokeSuspend$lambda$2(j, simultaneousTranslationActivity2);
                    }
                });
                return k83.a;
            }
            kotlin.d.b(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (DelayKt.delay(55L, this) == objD) {
                return objD;
            }
            CoroutineScopeKt.ensureActive(coroutineScope);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$forcePhoneFallback, this.this$0, null);
            this.L$0 = coroutineScope;
            this.label = 2;
            if (BuildersKt.withContext(main, anonymousClass1, this) == objD) {
                return objD;
            }
            coroutineScope2 = coroutineScope;
            CoroutineScopeKt.ensureActive(coroutineScope2);
            str = this.this$0.t;
            if (str == null) {
                p31.t("targetLanguage");
                str = null;
            }
            if (p31.a(kotlin.text.i.O0(str).toString(), "粤语")) {
                voice = AudioParameters.Voice.KIKI;
            } else {
                str2 = this.this$0.t;
                if (str2 == null) {
                    p31.t("targetLanguage");
                    str2 = null;
                }
                if (p31.a(kotlin.text.i.O0(str2).toString(), "粵語")) {
                    voice = AudioParameters.Voice.KIKI;
                } else {
                    str3 = this.this$0.t;
                    if (str3 == null) {
                        p31.t("targetLanguage");
                    } else {
                        str4 = str3;
                    }
                    if (kotlin.text.i.v(kotlin.text.i.O0(str4).toString(), "Cantonese", true)) {
                        voice = AudioParameters.Voice.KIKI;
                    } else {
                        voice = AudioParameters.Voice.ELIAS;
                    }
                }
            }
            Flowable flowableL2 = new pl1().l(((com.alibaba.dashscope.aigc.multimodalconversation.a.b) ((com.alibaba.dashscope.aigc.multimodalconversation.a.b) com.alibaba.dashscope.aigc.multimodalconversation.a.s().k(this.this$0.F)).p("qwen3-tts-flash")).a0(this.$text).b0(voice).Y(this.$language).X());
            final Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
            ref$BooleanRef2.element = true;
            final SimultaneousTranslationActivity simultaneousTranslationActivity3 = this.this$0;
            final ar0 ar0Var2 = new ar0() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.g
                @Override // defpackage.ar0
                public final Object invoke(Object obj2) {
                    return SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1.invokeSuspend$lambda$0(coroutineScope2, ref$BooleanRef2, simultaneousTranslationActivity3, (tl1) obj2);
                }
            };
            flowableL2.blockingForEach(new Consumer() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.h
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj2) {
                    ar0Var2.invoke(obj2);
                }
            });
            final SimultaneousTranslationActivity simultaneousTranslationActivity4 = this.this$0;
            final long j2 = this.$sessionId;
            simultaneousTranslationActivity4.runOnUiThread(new Runnable() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.i
                @Override // java.lang.Runnable
                public final void run() {
                    SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1.invokeSuspend$lambda$2(j2, simultaneousTranslationActivity4);
                }
            });
            return k83.a;
        } catch (CancellationException e) {
            Log.d(this.this$0.K(), "音频播放被取消: " + e.getMessage());
            final SimultaneousTranslationActivity simultaneousTranslationActivity5 = this.this$0;
            final long j3 = this.$sessionId;
            simultaneousTranslationActivity5.runOnUiThread(new Runnable() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.j
                @Override // java.lang.Runnable
                public final void run() {
                    SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1.invokeSuspend$lambda$3(j3, simultaneousTranslationActivity5);
                }
            });
        } catch (Exception e2) {
            Log.e(this.this$0.K(), "音频播放错误: " + e2.getMessage());
            final SimultaneousTranslationActivity simultaneousTranslationActivity6 = this.this$0;
            final long j4 = this.$sessionId;
            simultaneousTranslationActivity6.runOnUiThread(new Runnable() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.k
                @Override // java.lang.Runnable
                public final void run() {
                    SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1.invokeSuspend$lambda$4(j4, simultaneousTranslationActivity6);
                }
            });
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
