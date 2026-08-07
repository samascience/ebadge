package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatButton;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baji.network.manager.AuthManager;
import com.baji.network.model.BaseResponse;
import com.baji.network.model.NetworkError;
import com.baji.network.model.SimultaneousTranslationResponse;
import com.blankj.utilcode.util.ToastUtils;
import com.legend.smartwatch.app.base.acitivity.BaseMvvmActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import defpackage.a4;
import defpackage.ar0;
import defpackage.cr2;
import defpackage.ct0;
import defpackage.d4;
import defpackage.e4;
import defpackage.eb1;
import defpackage.et0;
import defpackage.f4;
import defpackage.gt0;
import defpackage.h70;
import defpackage.ja1;
import defpackage.k83;
import defpackage.l3;
import defpackage.l42;
import defpackage.or0;
import defpackage.p31;
import defpackage.q30;
import defpackage.qr0;
import defpackage.u53;
import defpackage.u8;
import defpackage.v53;
import defpackage.x30;
import defpackage.xi1;
import defpackage.y70;
import defpackage.yq0;
import defpackage.zm1;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.UninitializedPropertyAccessException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity;

/* JADX INFO: loaded from: classes4.dex */
public final class SimultaneousTranslationActivity extends BaseMvvmActivity<l3, Object> {
    public static final b X = new b(null);
    private String F;
    private final Channel G;
    private Job H;
    private boolean I;
    private List J;
    private boolean K;
    private long L;
    private int M;
    private Job N;
    private long O;
    private boolean P;
    private final ja1 Q;
    private AudioFocusRequest R;
    private int S;
    private TextToSpeech T;
    private boolean U;
    private final f4 V;
    private final f4 W;
    private final int m;
    private final int n;
    private final int o;
    private final int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AudioTrack f399q;
    private SimultaneousTranslator r;
    private String s;
    private String t;
    private u53 u;
    private final List v;
    private int w;
    private boolean x;
    private boolean y;
    private volatile boolean z;

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {
        private final boolean a;
        private final boolean b;

        public a(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        public final boolean a() {
            return this.b;
        }

        public final boolean b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            return "BrGateSnapshot(shouldShowConnected=" + this.a + ", canPlayback=" + this.b + ")";
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface c {

        public static final class a implements c {
            public static final a a = new a();

            private a() {
            }
        }

        public static final class b implements c {
            private final boolean a;
            private final yq0 b;

            public b(boolean z, yq0 yq0Var) {
                this.a = z;
                this.b = yq0Var;
            }

            public final boolean a() {
                return this.a;
            }

            public final yq0 b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return this.a == bVar.a && p31.a(this.b, bVar.b);
            }

            public int hashCode() {
                int iHashCode = Boolean.hashCode(this.a) * 31;
                yq0 yq0Var = this.b;
                return iHashCode + (yq0Var == null ? 0 : yq0Var.hashCode());
            }

            public String toString() {
                return "Stop(fromUserRelease=" + this.a + ", onStopped=" + this.b + ")";
            }
        }
    }

    /* JADX INFO: renamed from: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$onDestroy$1, reason: invalid class name */
    @h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$onDestroy$1", f = "SimultaneousTranslationActivity.kt", l = {1420}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements or0 {
        final /* synthetic */ SimultaneousTranslator $trans;
        int label;

        /* JADX INFO: renamed from: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$onDestroy$1$1, reason: invalid class name and collision with other inner class name */
        @h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$onDestroy$1$1", f = "SimultaneousTranslationActivity.kt", l = {1421}, m = "invokeSuspend")
        static final class C01781 extends SuspendLambda implements or0 {
            final /* synthetic */ SimultaneousTranslator $trans;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01781(SimultaneousTranslator simultaneousTranslator, x30 x30Var) {
                super(2, x30Var);
                this.$trans = simultaneousTranslator;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final x30 create(Object obj, x30 x30Var) {
                return new C01781(this.$trans, x30Var);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = kotlin.coroutines.intrinsics.a.d();
                int i = this.label;
                if (i == 0) {
                    kotlin.d.b(obj);
                    SimultaneousTranslator simultaneousTranslator = this.$trans;
                    if (simultaneousTranslator == null) {
                        return null;
                    }
                    this.label = 1;
                    if (simultaneousTranslator.z(this) == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.d.b(obj);
                }
                return k83.a;
            }

            @Override // defpackage.or0
            public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
                return ((C01781) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SimultaneousTranslator simultaneousTranslator, x30 x30Var) {
            super(2, x30Var);
            this.$trans = simultaneousTranslator;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return SimultaneousTranslationActivity.this.new AnonymousClass1(this.$trans, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = kotlin.coroutines.intrinsics.a.d();
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.d.b(obj);
                    C01781 c01781 = new C01781(this.$trans, null);
                    this.label = 1;
                    if (TimeoutKt.withTimeoutOrNull(5000L, c01781, this) == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.d.b(obj);
                }
            } catch (UninitializedPropertyAccessException e) {
                Log.e(SimultaneousTranslationActivity.this.K(), "translator未初始化: " + e.getMessage());
            } catch (Exception e2) {
                Log.e(SimultaneousTranslationActivity.this.K(), "停止翻译失败: " + e2.getMessage());
            }
            return k83.a;
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    public SimultaneousTranslationActivity() {
        super(R.layout.activity_home_voice_assistant_simultaneous_translation);
        this.m = 24000;
        this.n = 4;
        this.o = 2;
        int minBufferSize = AudioTrack.getMinBufferSize(24000, 4, 2);
        this.p = minBufferSize;
        this.f399q = new AudioTrack(3, 24000, 4, 2, minBufferSize, 1);
        this.v = new ArrayList();
        this.w = -1;
        this.F = Constants.STR_EMPTY;
        this.G = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.J = new ArrayList();
        this.Q = kotlin.a.a(new yq0() { // from class: vp2
            @Override // defpackage.yq0
            public final Object invoke() {
                return SimultaneousTranslationActivity.t1(this.a);
            }
        });
        this.S = -1;
        f4 f4VarRegisterForActivityResult = registerForActivityResult(new d4(), new a4() { // from class: gq2
            @Override // defpackage.a4
            public final void a(Object obj) {
                SimultaneousTranslationActivity.t2(this.a, (Boolean) obj);
            }
        });
        p31.e(f4VarRegisterForActivityResult, "registerForActivityResult(...)");
        this.V = f4VarRegisterForActivityResult;
        f4 f4VarRegisterForActivityResult2 = registerForActivityResult(new e4(), new a4() { // from class: rq2
            @Override // defpackage.a4
            public final void a(Object obj) {
                SimultaneousTranslationActivity.E2(this.a, (ActivityResult) obj);
            }
        });
        p31.e(f4VarRegisterForActivityResult2, "registerForActivityResult(...)");
        this.W = f4VarRegisterForActivityResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 A1(final SimultaneousTranslationActivity simultaneousTranslationActivity, final String str, final String str2, final Boolean bool, final Boolean bool2) {
        p31.f(str, "original");
        p31.f(str2, "translated");
        simultaneousTranslationActivity.runOnUiThread(new Runnable() { // from class: mq2
            @Override // java.lang.Runnable
            public final void run() {
                SimultaneousTranslationActivity.B1(this.a, bool, bool2, str, str2);
            }
        });
        return k83.a;
    }

    static /* synthetic */ void A2(SimultaneousTranslationActivity simultaneousTranslationActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = Constants.STR_EMPTY;
        }
        simultaneousTranslationActivity.z2(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(SimultaneousTranslationActivity simultaneousTranslationActivity, Boolean bool, Boolean bool2, String str, String str2) {
        if (!simultaneousTranslationActivity.f2()) {
            simultaneousTranslationActivity.V1();
            return;
        }
        Boolean bool3 = Boolean.TRUE;
        if (p31.a(bool, bool3) && p31.a(bool2, bool3)) {
            simultaneousTranslationActivity.y1(str, str2);
        } else {
            simultaneousTranslationActivity.d3(str, str2);
        }
    }

    private final void B2() {
        if (this.S < 0) {
            return;
        }
        try {
            try {
                T1().setStreamVolume(3, this.S, 0);
                Log.d(K(), "STREAM_MUSIC 音量恢复: " + this.S);
            } catch (Exception e) {
                Log.w(K(), "restoreTranslationStreamVolume: " + e.getMessage());
            }
        } finally {
            this.S = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 C1(final SimultaneousTranslationActivity simultaneousTranslationActivity, final String str) {
        p31.f(str, "errorMessage");
        simultaneousTranslationActivity.runOnUiThread(new Runnable() { // from class: hq2
            @Override // java.lang.Runnable
            public final void run() {
                SimultaneousTranslationActivity.D1(this.a, str);
            }
        });
        return k83.a;
    }

    private final Object C2(x30 x30Var) {
        return BuildersKt.withContext(Dispatchers.getIO(), new SimultaneousTranslationActivity$runTranslatorStartBlocking$2(this, null), x30Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(SimultaneousTranslationActivity simultaneousTranslationActivity, String str) {
        Log.i(simultaneousTranslationActivity.K(), "createTranslator: " + str);
        if (!simultaneousTranslationActivity.z) {
            ((l3) simultaneousTranslationActivity.I()).H.setVisibility(8);
        }
        if (!simultaneousTranslationActivity.f2() || kotlin.text.i.M(str, "network error", false, 2, null) || p31.a(str, "网络连接失败，请检查网络设置")) {
            T2(simultaneousTranslationActivity, false, 1, null);
        }
    }

    private final Object D2(x30 x30Var) throws Throwable {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new SimultaneousTranslationActivity$runTranslatorStopBlocking$2(this, null), x30Var);
        return objWithContext == kotlin.coroutines.intrinsics.a.d() ? objWithContext : k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 E1(SimultaneousTranslationActivity simultaneousTranslationActivity, String str) {
        p31.f(str, "original");
        simultaneousTranslationActivity.N1(str);
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(SimultaneousTranslationActivity simultaneousTranslationActivity, ActivityResult activityResult) {
        if (activityResult.b() == -1) {
            simultaneousTranslationActivity.U1(activityResult.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 F1(final SimultaneousTranslationActivity simultaneousTranslationActivity, final float f) {
        simultaneousTranslationActivity.runOnUiThread(new Runnable() { // from class: bq2
            @Override // java.lang.Runnable
            public final void run() {
                SimultaneousTranslationActivity.G1(this.a, f);
            }
        });
        return k83.a;
    }

    private final void F2() {
        ((l3) I()).P.setOnClickListener(new View.OnClickListener() { // from class: wp2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimultaneousTranslationActivity.G2(this.a, view);
            }
        });
        ((l3) I()).N.setOnClickListener(new View.OnClickListener() { // from class: xp2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimultaneousTranslationActivity.H2(this.a, view);
            }
        });
        ((l3) I()).O.setOnClickListener(new View.OnClickListener() { // from class: yp2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimultaneousTranslationActivity.I2(this.a, view);
            }
        });
        ((l3) I()).z.setOnClickListener(new View.OnClickListener() { // from class: zp2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimultaneousTranslationActivity.J2(this.a, view);
            }
        });
        ((l3) I()).M.setOnTouchListener(new View.OnTouchListener() { // from class: aq2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return SimultaneousTranslationActivity.K2(this.a, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(SimultaneousTranslationActivity simultaneousTranslationActivity, float f) {
        ((l3) simultaneousTranslationActivity.I()).S.i(f);
        ((l3) simultaneousTranslationActivity.I()).G.f(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G2(SimultaneousTranslationActivity simultaneousTranslationActivity, View view) {
        if (simultaneousTranslationActivity.d2()) {
            return;
        }
        simultaneousTranslationActivity.b3();
    }

    private final void H1() {
        Job job = this.H;
        if (job == null || !job.isActive()) {
            this.H = BuildersKt__Builders_commonKt.launch$default(eb1.a(this), null, null, new SimultaneousTranslationActivity$ensurePttWorker$1(this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H2(SimultaneousTranslationActivity simultaneousTranslationActivity, View view) {
        if (simultaneousTranslationActivity.d2()) {
            return;
        }
        l2(simultaneousTranslationActivity, 1001, null, 2, null);
    }

    private final void I1() {
        Pair pairD;
        String str = this.s;
        String str2 = null;
        if (str == null) {
            p31.t("sourceLanguage");
            str = null;
        }
        String str3 = this.t;
        if (str3 == null) {
            p31.t("targetLanguage");
        } else {
            str2 = str3;
        }
        if (e2(str, str2) || (pairD = cr2.a.d()) == null) {
            return;
        }
        e3((String) pairD.getFirst());
        g3((String) pairD.getSecond());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I2(SimultaneousTranslationActivity simultaneousTranslationActivity, View view) {
        if (simultaneousTranslationActivity.d2()) {
            return;
        }
        simultaneousTranslationActivity.k2(1002, ((l3) simultaneousTranslationActivity.I()).N.getText().toString());
    }

    private final void J1() {
        String str = this.s;
        String str2 = null;
        if (str == null) {
            p31.t("sourceLanguage");
            str = null;
        }
        String str3 = this.t;
        if (str3 == null) {
            p31.t("targetLanguage");
        } else {
            str2 = str3;
        }
        if (!e2(str, str2)) {
            ToastUtils.v(getString(R.string.simultaneous_translation_tips2), new Object[0]);
            return;
        }
        if (!this.K) {
            b2();
            ToastUtils.v(getString(R.string.simultaneous_translation_tips4), new Object[0]);
            return;
        }
        this.y = true;
        this.x = false;
        this.z = false;
        H1();
        h3();
        ((l3) I()).M.setImageResource(R.drawable.ic_mic_white);
        ((l3) I()).Q.setVisibility(0);
        ((l3) I()).S.setBaseLineRatio(0.3f);
        ((l3) I()).S.setWaveAnimationRunning(false);
        ((l3) I()).G.setWaveAnimationRunning(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(SimultaneousTranslationActivity simultaneousTranslationActivity, View view) {
        if (simultaneousTranslationActivity.d2()) {
            return;
        }
        simultaneousTranslationActivity.w1();
    }

    private final void K0() {
        AudioFocusRequest audioFocusRequest = this.R;
        if (audioFocusRequest == null) {
            return;
        }
        try {
            T1().abandonAudioFocusRequest(audioFocusRequest);
        } catch (Exception e) {
            Log.w(K(), "abandonAudioFocusRequest: " + e.getMessage());
        }
        this.R = null;
        B2();
    }

    private final void K1(final ar0 ar0Var) {
        O1(new ar0() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.b
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return SimultaneousTranslationActivity.L1(ar0Var, (SimultaneousTranslationActivity.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean K2(SimultaneousTranslationActivity simultaneousTranslationActivity, View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            view.setPressed(true);
            simultaneousTranslationActivity.i2();
            return true;
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return false;
        }
        view.setPressed(false);
        simultaneousTranslationActivity.j2();
        view.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 L1(ar0 ar0Var, a aVar) {
        p31.f(aVar, "snap");
        ar0Var.invoke(Boolean.valueOf(aVar.a()));
        return k83.a;
    }

    private final void L2() {
        U(R.mipmap.home_va_ts_voiceswitch, new View.OnClickListener() { // from class: fq2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimultaneousTranslationActivity.M2(this.a, view);
            }
        });
    }

    private final void M1(ar0 ar0Var) {
        if (isFinishing()) {
            return;
        }
        ar0Var.invoke(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M2(final SimultaneousTranslationActivity simultaneousTranslationActivity, View view) {
        if (simultaneousTranslationActivity.d2()) {
            return;
        }
        ImageView imageView = ((l3) simultaneousTranslationActivity.I()).L.f;
        p31.e(imageView, "imgRight");
        final l42 l42Var = new l42(simultaneousTranslationActivity, imageView);
        l42Var.b(true);
        MenuItem menuItemAdd = l42Var.a().add(0, 10001, 0, R.string.simultaneous_translation_output_phone);
        menuItemAdd.setCheckable(true);
        menuItemAdd.setIcon(R.drawable.ic_phone_black);
        MenuItem menuItemAdd2 = l42Var.a().add(0, CameraAccessExceptionCompat.CAMERA_CHARACTERISTICS_CREATION_ERROR, 0, R.string.simultaneous_translation_output_headset);
        menuItemAdd2.setCheckable(true);
        menuItemAdd2.setIcon(R.drawable.ic_glasses_black);
        boolean zL = zm1.L();
        l42Var.a().findItem(10001).setChecked(zL);
        l42Var.a().findItem(CameraAccessExceptionCompat.CAMERA_CHARACTERISTICS_CREATION_ERROR).setChecked(true ^ zL);
        final MenuItem menuItemFindItem = l42Var.a().findItem(CameraAccessExceptionCompat.CAMERA_CHARACTERISTICS_CREATION_ERROR);
        l42Var.c(new l42.c() { // from class: nq2
            @Override // l42.c
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return SimultaneousTranslationActivity.N2(this.a, menuItem);
            }
        });
        simultaneousTranslationActivity.M1(new ar0() { // from class: oq2
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return SimultaneousTranslationActivity.Q2(this.a, menuItemFindItem, l42Var, ((Boolean) obj).booleanValue());
            }
        });
    }

    private final void N1(String str) {
        String str2;
        String str3;
        String string = kotlin.text.i.O0(str).toString();
        if (kotlin.text.i.Y(string) || !this.K) {
            return;
        }
        String str4 = this.s;
        if (str4 == null) {
            p31.t("sourceLanguage");
            str2 = null;
        } else {
            str2 = str4;
        }
        String str5 = this.t;
        if (str5 == null) {
            p31.t("targetLanguage");
            str3 = null;
        } else {
            str3 = str5;
        }
        BuildersKt__Builders_commonKt.launch$default(eb1.a(this), Dispatchers.getIO(), null, new SimultaneousTranslationActivity$fallbackTranslateAndPlay$1(this, string, str2, str3, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean N2(final SimultaneousTranslationActivity simultaneousTranslationActivity, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 10001) {
            if (itemId != 10002) {
                return false;
            }
            if (!zm1.L()) {
                return true;
            }
            simultaneousTranslationActivity.O1(new ar0() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.a
                @Override // defpackage.ar0
                public final Object invoke(Object obj) {
                    return SimultaneousTranslationActivity.O2(this.a, (SimultaneousTranslationActivity.a) obj);
                }
            });
            return true;
        }
        if (zm1.L()) {
            return true;
        }
        zm1.g0(true);
        simultaneousTranslationActivity.W2();
        simultaneousTranslationActivity.q1();
        return true;
    }

    private final void O1(ar0 ar0Var) {
        ar0Var.invoke(new a(false, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 O2(final SimultaneousTranslationActivity simultaneousTranslationActivity, final a aVar) {
        p31.f(aVar, "snap");
        simultaneousTranslationActivity.runOnUiThread(new Runnable() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.c
            @Override // java.lang.Runnable
            public final void run() {
                SimultaneousTranslationActivity.P2(this.a, aVar);
            }
        });
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1() {
        AuthManager.Companion.getInstance().getSimultaneousTranslationTokens(new ar0() { // from class: kq2
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return SimultaneousTranslationActivity.Q1(this.a, (BaseResponse) obj);
            }
        }, new ar0() { // from class: lq2
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return SimultaneousTranslationActivity.S1(this.a, (NetworkError) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P2(SimultaneousTranslationActivity simultaneousTranslationActivity, a aVar) {
        if (simultaneousTranslationActivity.isFinishing()) {
            return;
        }
        if (aVar.a()) {
            zm1.g0(false);
            simultaneousTranslationActivity.W2();
            simultaneousTranslationActivity.q1();
        } else if (aVar.b()) {
            ToastUtils.v(simultaneousTranslationActivity.getString(R.string.simultaneous_translation_output_headset_audio_not_ready), new Object[0]);
        } else {
            ToastUtils.v(simultaneousTranslationActivity.getString(R.string.simultaneous_translation_output_headset_need_br), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 Q1(final SimultaneousTranslationActivity simultaneousTranslationActivity, BaseResponse baseResponse) {
        String token;
        p31.f(baseResponse, "response");
        String strK = simultaneousTranslationActivity.K();
        SimultaneousTranslationResponse simultaneousTranslationResponse = (SimultaneousTranslationResponse) baseResponse.getData();
        Log.i(strK, "通过同声翻译接口获取令牌: " + (simultaneousTranslationResponse != null ? simultaneousTranslationResponse.getToken() : null));
        SimultaneousTranslationResponse simultaneousTranslationResponse2 = (SimultaneousTranslationResponse) baseResponse.getData();
        simultaneousTranslationActivity.o1(simultaneousTranslationResponse2 != null ? simultaneousTranslationResponse2.getLangConfig() : null);
        String strK2 = simultaneousTranslationActivity.K();
        SimultaneousTranslationResponse simultaneousTranslationResponse3 = (SimultaneousTranslationResponse) baseResponse.getData();
        Log.i(strK2, "同声翻译接口获取到的语言配置: " + (simultaneousTranslationResponse3 != null ? simultaneousTranslationResponse3.getLangConfig() : null));
        SimultaneousTranslationResponse simultaneousTranslationResponse4 = (SimultaneousTranslationResponse) baseResponse.getData();
        if (simultaneousTranslationResponse4 == null || (token = simultaneousTranslationResponse4.getToken()) == null) {
            token = Constants.STR_EMPTY;
        }
        simultaneousTranslationActivity.F = token;
        simultaneousTranslationActivity.runOnUiThread(new Runnable() { // from class: pq2
            @Override // java.lang.Runnable
            public final void run() {
                SimultaneousTranslationActivity.R1(this.a);
            }
        });
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 Q2(final SimultaneousTranslationActivity simultaneousTranslationActivity, final MenuItem menuItem, final l42 l42Var, final boolean z) {
        simultaneousTranslationActivity.runOnUiThread(new Runnable() { // from class: uq2
            @Override // java.lang.Runnable
            public final void run() {
                SimultaneousTranslationActivity.R2(this.a, menuItem, z, l42Var);
            }
        });
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(SimultaneousTranslationActivity simultaneousTranslationActivity) {
        simultaneousTranslationActivity.z1(simultaneousTranslationActivity.F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R2(SimultaneousTranslationActivity simultaneousTranslationActivity, MenuItem menuItem, boolean z, l42 l42Var) {
        if (simultaneousTranslationActivity.isFinishing()) {
            return;
        }
        menuItem.setEnabled(z || !zm1.L());
        l42Var.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 S1(SimultaneousTranslationActivity simultaneousTranslationActivity, NetworkError networkError) {
        p31.f(networkError, "error");
        Log.e(simultaneousTranslationActivity.K(), "获取同声翻译令牌最终失败: " + networkError.getErrorMessage());
        return k83.a;
    }

    private final void S2(final boolean z) {
        final u8 u8Var = new u8(this);
        u8Var.setContentView(R.layout.dialog_confirm_cancel);
        u8Var.setCancelable(false);
        TextView textView = (TextView) u8Var.findViewById(R.id.dialog_title);
        TextView textView2 = (TextView) u8Var.findViewById(R.id.dialog_message);
        AppCompatButton appCompatButton = (AppCompatButton) u8Var.findViewById(R.id.dialog_cancel);
        AppCompatButton appCompatButton2 = (AppCompatButton) u8Var.findViewById(R.id.dialog_confirm);
        if (textView != null) {
            textView.setText(getString(R.string.no_network_available));
        }
        if (textView2 != null) {
            textView2.setText(getString(R.string.simultaneous_translation_no_network_tips));
        }
        if (appCompatButton != null) {
            appCompatButton.setText(getString(R.string.cancel));
        }
        if (appCompatButton2 != null) {
            appCompatButton2.setText(getString(R.string.confirm_txt));
        }
        if (appCompatButton2 != null) {
            appCompatButton2.setOnClickListener(new View.OnClickListener() { // from class: iq2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SimultaneousTranslationActivity.U2(this.a, z, u8Var, view);
                }
            });
        }
        if (appCompatButton != null) {
            appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: jq2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SimultaneousTranslationActivity.V2(z, this, u8Var, view);
                }
            });
        }
        u8Var.show();
        Window window = u8Var.getWindow();
        if (window != null) {
            window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.85d), -2);
        }
        Window window2 = u8Var.getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawableResource(R.drawable.dialog_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AudioManager T1() {
        return (AudioManager) this.Q.getValue();
    }

    static /* synthetic */ void T2(SimultaneousTranslationActivity simultaneousTranslationActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        simultaneousTranslationActivity.S2(z);
    }

    private final void U1(Intent intent) {
        String stringExtra = intent != null ? intent.getStringExtra("selected_language") : null;
        int intExtra = intent != null ? intent.getIntExtra("request_code", -1) : -1;
        if (stringExtra != null) {
            if (intExtra == 1001) {
                e3(stringExtra);
            } else {
                if (intExtra != 1002) {
                    return;
                }
                g3(stringExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U2(SimultaneousTranslationActivity simultaneousTranslationActivity, boolean z, u8 u8Var, View view) {
        simultaneousTranslationActivity.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        if (!z) {
            ToastUtils.v(simultaneousTranslationActivity.getString(R.string.simultaneous_translation_click_to_start), new Object[0]);
            if (simultaneousTranslationActivity.y) {
                ((l3) simultaneousTranslationActivity.I()).M.setImageResource(R.drawable.ic_mic_white);
            }
        }
        u8Var.dismiss();
    }

    private final void V1() {
        if (this.y && this.K) {
            if (!this.x) {
                SimultaneousTranslator simultaneousTranslator = this.r;
                if (simultaneousTranslator == null) {
                    p31.t("translator");
                    simultaneousTranslator = null;
                }
                if (!simultaneousTranslator.u()) {
                    return;
                }
            }
            a3(this, null, 1, null);
            runOnUiThread(new Runnable() { // from class: qq2
                @Override // java.lang.Runnable
                public final void run() {
                    SimultaneousTranslationActivity.W1(this.a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V2(boolean z, SimultaneousTranslationActivity simultaneousTranslationActivity, u8 u8Var, View view) {
        if (!z) {
            ToastUtils.v(simultaneousTranslationActivity.getString(R.string.simultaneous_translation_click_to_start), new Object[0]);
            if (simultaneousTranslationActivity.y) {
                ((l3) simultaneousTranslationActivity.I()).M.setImageResource(R.drawable.ic_mic_white);
            }
        }
        u8Var.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(SimultaneousTranslationActivity simultaneousTranslationActivity) {
        ToastUtils.v(simultaneousTranslationActivity.getString(R.string.simultaneous_translation_network_disconnected), new Object[0]);
        T2(simultaneousTranslationActivity, false, 1, null);
    }

    private final void W2() {
        try {
            Job job = this.N;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.N = null;
            this.O++;
            X2();
            x1();
            Log.d(K(), "输出模式切换，已停止当前音频");
        } catch (Exception e) {
            Log.e(K(), "stopAudioPlaybackForOutputModeChange: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x009b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object X1(x30 x30Var) throws Throwable {
        SimultaneousTranslationActivity$handlePttStart$1 simultaneousTranslationActivity$handlePttStart$1;
        SimultaneousTranslationActivity simultaneousTranslationActivity;
        MainCoroutineDispatcher main;
        SimultaneousTranslationActivity$handlePttStart$2 simultaneousTranslationActivity$handlePttStart$2;
        if (x30Var instanceof SimultaneousTranslationActivity$handlePttStart$1) {
            simultaneousTranslationActivity$handlePttStart$1 = (SimultaneousTranslationActivity$handlePttStart$1) x30Var;
            int i = simultaneousTranslationActivity$handlePttStart$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                simultaneousTranslationActivity$handlePttStart$1.label = i - Integer.MIN_VALUE;
            } else {
                simultaneousTranslationActivity$handlePttStart$1 = new SimultaneousTranslationActivity$handlePttStart$1(this, x30Var);
            }
        } else {
            simultaneousTranslationActivity$handlePttStart$1 = new SimultaneousTranslationActivity$handlePttStart$1(this, x30Var);
        }
        Object objC2 = simultaneousTranslationActivity$handlePttStart$1.result;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i2 = simultaneousTranslationActivity$handlePttStart$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                simultaneousTranslationActivity = (SimultaneousTranslationActivity) simultaneousTranslationActivity$handlePttStart$1.L$0;
                kotlin.d.b(objC2);
            } else if (i2 == 2) {
                simultaneousTranslationActivity = (SimultaneousTranslationActivity) simultaneousTranslationActivity$handlePttStart$1.L$0;
                kotlin.d.b(objC2);
                boolean zBooleanValue = ((Boolean) objC2).booleanValue();
                main = Dispatchers.getMain();
                simultaneousTranslationActivity$handlePttStart$2 = new SimultaneousTranslationActivity$handlePttStart$2(zBooleanValue, simultaneousTranslationActivity, null);
                simultaneousTranslationActivity$handlePttStart$1.L$0 = null;
                simultaneousTranslationActivity$handlePttStart$1.label = 3;
                if (BuildersKt.withContext(main, simultaneousTranslationActivity$handlePttStart$2, simultaneousTranslationActivity$handlePttStart$1) == objD) {
                    return objD;
                }
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.d.b(objC2);
            }
            return k83.a;
        }
        kotlin.d.b(objC2);
        if (!this.K || !this.y || isFinishing()) {
            return k83.a;
        }
        SimultaneousTranslator simultaneousTranslator = this.r;
        if (simultaneousTranslator == null) {
            p31.t("translator");
            simultaneousTranslator = null;
        }
        if (simultaneousTranslator.u()) {
            simultaneousTranslationActivity$handlePttStart$1.L$0 = this;
            simultaneousTranslationActivity$handlePttStart$1.label = 1;
            if (D2(simultaneousTranslationActivity$handlePttStart$1) == objD) {
                return objD;
            }
        }
        simultaneousTranslationActivity = this;
        simultaneousTranslationActivity$handlePttStart$1.L$0 = simultaneousTranslationActivity;
        simultaneousTranslationActivity$handlePttStart$1.label = 2;
        objC2 = simultaneousTranslationActivity.C2(simultaneousTranslationActivity$handlePttStart$1);
        if (objC2 == objD) {
            return objD;
        }
        boolean zBooleanValue2 = ((Boolean) objC2).booleanValue();
        main = Dispatchers.getMain();
        simultaneousTranslationActivity$handlePttStart$2 = new SimultaneousTranslationActivity$handlePttStart$2(zBooleanValue2, simultaneousTranslationActivity, null);
        simultaneousTranslationActivity$handlePttStart$1.L$0 = null;
        simultaneousTranslationActivity$handlePttStart$1.label = 3;
        if (BuildersKt.withContext(main, simultaneousTranslationActivity$handlePttStart$2, simultaneousTranslationActivity$handlePttStart$1) == objD) {
            return objD;
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X2() {
        try {
            if (this.f399q.getState() != 1) {
                Log.w(K(), "AudioTrack未初始化，跳过停止操作");
            } else if (this.f399q.getPlayState() == 3) {
                this.f399q.stop();
                this.f399q.flush();
            }
            this.I = false;
        } catch (IllegalStateException e) {
            Log.e(K(), "AudioTrack状态异常，无法停止: " + e.getMessage());
            this.I = false;
        } catch (Exception e2) {
            Log.e(K(), "安全停止音频轨道失败: " + e2.getMessage());
            this.I = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x00a0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object Y1(boolean z, yq0 yq0Var, x30 x30Var) throws Throwable {
        SimultaneousTranslationActivity$handlePttStop$1 simultaneousTranslationActivity$handlePttStop$1;
        SimultaneousTranslationActivity simultaneousTranslationActivity;
        yq0 yq0Var2;
        if (x30Var instanceof SimultaneousTranslationActivity$handlePttStop$1) {
            simultaneousTranslationActivity$handlePttStop$1 = (SimultaneousTranslationActivity$handlePttStop$1) x30Var;
            int i = simultaneousTranslationActivity$handlePttStop$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                simultaneousTranslationActivity$handlePttStop$1.label = i - Integer.MIN_VALUE;
            } else {
                simultaneousTranslationActivity$handlePttStop$1 = new SimultaneousTranslationActivity$handlePttStop$1(this, x30Var);
            }
        } else {
            simultaneousTranslationActivity$handlePttStop$1 = new SimultaneousTranslationActivity$handlePttStop$1(this, x30Var);
        }
        Object objWithContext = simultaneousTranslationActivity$handlePttStop$1.result;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i2 = simultaneousTranslationActivity$handlePttStop$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                yq0Var = (yq0) simultaneousTranslationActivity$handlePttStop$1.L$1;
                simultaneousTranslationActivity = (SimultaneousTranslationActivity) simultaneousTranslationActivity$handlePttStop$1.L$0;
                kotlin.d.b(objWithContext);
            } else if (i2 == 2) {
                yq0Var2 = (yq0) simultaneousTranslationActivity$handlePttStop$1.L$0;
                kotlin.d.b(objWithContext);
                yq0Var = yq0Var2;
                MainCoroutineDispatcher main = Dispatchers.getMain();
                SimultaneousTranslationActivity$handlePttStop$3 simultaneousTranslationActivity$handlePttStop$3 = new SimultaneousTranslationActivity$handlePttStop$3(yq0Var, null);
                simultaneousTranslationActivity$handlePttStop$1.L$0 = null;
                simultaneousTranslationActivity$handlePttStop$1.L$1 = null;
                simultaneousTranslationActivity$handlePttStop$1.label = 3;
                objWithContext = BuildersKt.withContext(main, simultaneousTranslationActivity$handlePttStop$3, simultaneousTranslationActivity$handlePttStop$1);
                if (objWithContext == objD) {
                    return objD;
                }
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.d.b(objWithContext);
            }
            return objWithContext;
        }
        kotlin.d.b(objWithContext);
        MainCoroutineDispatcher main2 = Dispatchers.getMain();
        SimultaneousTranslationActivity$handlePttStop$2 simultaneousTranslationActivity$handlePttStop$2 = new SimultaneousTranslationActivity$handlePttStop$2(this, z, null);
        simultaneousTranslationActivity$handlePttStop$1.L$0 = this;
        simultaneousTranslationActivity$handlePttStop$1.L$1 = yq0Var;
        simultaneousTranslationActivity$handlePttStop$1.label = 1;
        if (BuildersKt.withContext(main2, simultaneousTranslationActivity$handlePttStop$2, simultaneousTranslationActivity$handlePttStop$1) == objD) {
            return objD;
        }
        simultaneousTranslationActivity = this;
        if (simultaneousTranslationActivity.K) {
            SimultaneousTranslator simultaneousTranslator = simultaneousTranslationActivity.r;
            if (simultaneousTranslator == null) {
                p31.t("translator");
                simultaneousTranslator = null;
            }
            if (simultaneousTranslator.u()) {
                simultaneousTranslationActivity$handlePttStop$1.L$0 = yq0Var;
                simultaneousTranslationActivity$handlePttStop$1.L$1 = null;
                simultaneousTranslationActivity$handlePttStop$1.label = 2;
                if (simultaneousTranslationActivity.D2(simultaneousTranslationActivity$handlePttStop$1) == objD) {
                    return objD;
                }
                yq0Var2 = yq0Var;
                yq0Var = yq0Var2;
            }
        }
        MainCoroutineDispatcher main3 = Dispatchers.getMain();
        SimultaneousTranslationActivity$handlePttStop$3 simultaneousTranslationActivity$handlePttStop$4 = new SimultaneousTranslationActivity$handlePttStop$3(yq0Var, null);
        simultaneousTranslationActivity$handlePttStop$1.L$0 = null;
        simultaneousTranslationActivity$handlePttStop$1.L$1 = null;
        simultaneousTranslationActivity$handlePttStop$1.label = 3;
        objWithContext = BuildersKt.withContext(main3, simultaneousTranslationActivity$handlePttStop$4, simultaneousTranslationActivity$handlePttStop$1);
        if (objWithContext == objD) {
            return objD;
        }
        return objWithContext;
    }

    private final void Y2() {
        try {
            if (!this.I || this.P) {
                return;
            }
            Job job = this.N;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.N = null;
            this.O++;
            X2();
            K0();
            Log.d(K(), "已停止当前音频播放");
        } catch (Exception e) {
            Log.e(K(), "停止音频播放失败: " + e.getMessage());
        }
    }

    private final boolean Z1() {
        return q30.a(this, "android.permission.RECORD_AUDIO") == 0;
    }

    private final void Z2(yq0 yq0Var) {
        u2(false, yq0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(SimultaneousTranslationActivity simultaneousTranslationActivity, int i) {
        simultaneousTranslationActivity.U = i == 0;
        Log.d(simultaneousTranslationActivity.K(), "Android TTS init status=" + i + " ready=" + simultaneousTranslationActivity.U);
    }

    static /* synthetic */ void a3(SimultaneousTranslationActivity simultaneousTranslationActivity, yq0 yq0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            yq0Var = null;
        }
        simultaneousTranslationActivity.Z2(yq0Var);
    }

    private final void b2() {
        BuildersKt__Builders_commonKt.launch$default(eb1.a(this), Dispatchers.getIO(), null, new SimultaneousTranslationActivity$initializeTranslator$1(this, null), 2, null);
    }

    private final void b3() {
        String str = this.s;
        if (str == null) {
            p31.t("sourceLanguage");
            str = null;
        }
        String str2 = this.t;
        if (str2 == null) {
            p31.t("targetLanguage");
            str2 = null;
        }
        if (p31.a(str, str2)) {
            ToastUtils.v(getString(R.string.simultaneous_translation_tips), new Object[0]);
        } else {
            if (!e2(str2, str)) {
                ToastUtils.v(getString(R.string.simultaneous_translation_tips2), new Object[0]);
                return;
            }
            if (this.y) {
                a3(this, null, 1, null);
            }
            l1(str, str2);
        }
    }

    private final void c2() {
        this.s = ((l3) I()).N.getText().toString();
        this.t = ((l3) I()).O.getText().toString();
        this.u = new u53();
        RecyclerView recyclerView = ((l3) I()).K;
        u53 u53Var = this.u;
        if (u53Var == null) {
            p31.t("translationAdapter");
            u53Var = null;
        }
        recyclerView.setAdapter(u53Var);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c3(String str, String str2, String str3) {
        gt0 gt0VarA = new ct0().a(((et0.b) ((et0.b) et0.w().k(this.F)).p("qwen-turbo")).U(kotlin.collections.j.m(xi1.a().k("system").j("You are a professional translation engine. Translate the user's text from " + str2 + " to " + str3 + ". Output ONLY the translated text, with no quotes, no explanations, no extra punctuation.").i(), xi1.a().k("user").j(str).i())).V(et0.d.b).T());
        p31.e(gt0VarA, "call(...)");
        gt0VarA.d();
        return Constants.STR_EMPTY;
    }

    private final boolean d2() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.L >= 300) {
            this.M = 0;
            this.L = jCurrentTimeMillis;
            return false;
        }
        this.M++;
        Log.d(K(), "检测到快速点击，当前计数: " + this.M);
        if (this.M < 5) {
            this.L = jCurrentTimeMillis;
            return true;
        }
        Log.d(K(), "连续快速点击超过5次，显示提示");
        BuildersKt__Builders_commonKt.launch$default(eb1.a(this), Dispatchers.getMain(), null, new SimultaneousTranslationActivity$isFastClick$1(this, null), 2, null);
        this.M = 0;
        this.L = jCurrentTimeMillis;
        return false;
    }

    private final void d3(String str, String str2) {
        if (kotlin.text.i.Y(str)) {
            return;
        }
        int i = this.w;
        if (i == -1 || i >= this.v.size()) {
            this.v.add(new v53(str, str2));
            this.w = this.v.size() - 1;
        } else {
            v53 v53Var = (v53) this.v.get(this.w);
            v53Var.c(str);
            v53Var.d(str2);
        }
        u53 u53Var = this.u;
        if (u53Var == null) {
            p31.t("translationAdapter");
            u53Var = null;
        }
        u53Var.setData(this.v);
        ((l3) I()).K.smoothScrollToPosition(this.v.size() - 1);
    }

    private final boolean e2(String str, String str2) {
        return cr2.a.g(str, str2);
    }

    private final void e3(String str) {
        String str2;
        String strB;
        ((l3) I()).N.setText(str);
        this.s = str;
        if (str == null) {
            p31.t("sourceLanguage");
            str2 = null;
        } else {
            str2 = str;
        }
        String str3 = this.t;
        if (str3 == null) {
            p31.t("targetLanguage");
            str3 = null;
        }
        if (e2(str2, str3)) {
            return;
        }
        cr2 cr2Var = cr2.a;
        String strC = cr2Var.c(str);
        String str4 = strC != null ? (String) kotlin.collections.j.I(cr2Var.j(strC)) : null;
        if (str4 == null || (strB = cr2Var.b(str4)) == null) {
            return;
        }
        g3(strB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f2() {
        NetworkCapabilities networkCapabilities;
        Object systemService = getSystemService("connectivity");
        p31.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3);
    }

    private final void f3() {
        A2(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2() {
        Log.i(K(), "音频播放完成，恢复翻译接收");
        X2();
        this.I = false;
        this.N = null;
        if (!this.P && !this.J.isEmpty()) {
            m2();
        } else {
            K0();
            x1();
        }
    }

    private final void g3(String str) {
        ((l3) I()).O.setText(str);
        this.t = str;
        f3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 h2(SimultaneousTranslationActivity simultaneousTranslationActivity) {
        simultaneousTranslationActivity.finish();
        return k83.a;
    }

    private final void h3() {
        l3 l3Var = (l3) I();
        l3Var.I.setVisibility(8);
        l3Var.R.setVisibility(8);
        l3Var.J.setVisibility(0);
    }

    private final void i2() {
        if (this.y && this.K) {
            if (!Z1()) {
                this.V.a("android.permission.RECORD_AUDIO");
                return;
            }
            if (!f2()) {
                T2(this, false, 1, null);
                return;
            }
            Y2();
            x1();
            this.J.clear();
            this.z = true;
            ((l3) I()).M.setImageResource(R.mipmap.home_va_ts_pause);
            ((l3) I()).Q.setVisibility(8);
            ((l3) I()).H.setVisibility(0);
            ((l3) I()).G.setWaveAnimationRunning(true);
            ((l3) I()).S.setWaveAnimationRunning(true);
            H1();
            this.G.mo92trySendJP2dKIU(c.a.a);
        }
    }

    private final void j2() {
        if (this.y) {
            ((l3) I()).H.setVisibility(8);
            ((l3) I()).G.setWaveAnimationRunning(false);
            ((l3) I()).S.setWaveAnimationRunning(false);
            y2();
            v2(this, true, null, 2, null);
        }
    }

    private final void k2(int i, String str) {
        Intent intent = new Intent(this, (Class<?>) SelectLanguageActivity.class);
        intent.putExtra("request_code", i);
        if (str != null) {
            intent.putExtra("source_language", str);
        }
        if (this.y) {
            a3(this, null, 1, null);
        }
        this.W.a(intent);
    }

    private final void l1(final String str, final String str2) {
        ((l3) I()).N.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: cq2
            @Override // java.lang.Runnable
            public final void run() {
                SimultaneousTranslationActivity.m1(this.a, str2);
            }
        }).start();
        ((l3) I()).O.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: dq2
            @Override // java.lang.Runnable
            public final void run() {
                SimultaneousTranslationActivity.n1(this.a, str);
            }
        }).start();
        Log.i(K(), "animateLanguageSwitch: " + getString(R.string.simultaneous_translation_tips3));
    }

    static /* synthetic */ void l2(SimultaneousTranslationActivity simultaneousTranslationActivity, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        simultaneousTranslationActivity.k2(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(SimultaneousTranslationActivity simultaneousTranslationActivity, String str) {
        ((l3) simultaneousTranslationActivity.I()).N.setText(str);
        simultaneousTranslationActivity.s = str;
        ((l3) simultaneousTranslationActivity.I()).N.animate().alpha(1.0f).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m2() {
        if (this.P || this.J.isEmpty() || this.I) {
            return;
        }
        Pair pair = (Pair) this.J.remove(0);
        String str = (String) pair.component1();
        String str2 = (String) pair.component2();
        Log.d(K(), "从队列中播放翻译内容: " + str + " -> " + str2 + ", 剩余: " + this.J.size());
        z2(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(SimultaneousTranslationActivity simultaneousTranslationActivity, String str) {
        ((l3) simultaneousTranslationActivity.I()).O.setText(str);
        simultaneousTranslationActivity.t = str;
        ((l3) simultaneousTranslationActivity.I()).O.animate().alpha(1.0f).setDuration(200L).start();
        A2(simultaneousTranslationActivity, null, 1, null);
    }

    private final void n2(final String str, final String str2) {
        if (kotlin.text.i.Y(str2)) {
            return;
        }
        Log.i(K(), "playTranslationSpeech: " + this.F + " " + str + " " + str2);
        if (zm1.L()) {
            r2(this, str2, str, false, 8, null);
        } else {
            K1(new ar0() { // from class: sq2
                @Override // defpackage.ar0
                public final Object invoke(Object obj) {
                    return SimultaneousTranslationActivity.o2(this.a, str2, str, ((Boolean) obj).booleanValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1(String str) {
        if (str == null || kotlin.text.i.Y(str)) {
            return;
        }
        cr2.a.a(str);
        runOnUiThread(new Runnable() { // from class: eq2
            @Override // java.lang.Runnable
            public final void run() {
                SimultaneousTranslationActivity.p1(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 o2(final SimultaneousTranslationActivity simultaneousTranslationActivity, String str, String str2, boolean z) {
        if (z) {
            r2(simultaneousTranslationActivity, str, str2, false, 8, null);
            return k83.a;
        }
        Log.w(simultaneousTranslationActivity.K(), "经典蓝牙未连接或 A2DP 未就绪，自动降级回退到手机扬声器播放");
        simultaneousTranslationActivity.runOnUiThread(new Runnable() { // from class: tq2
            @Override // java.lang.Runnable
            public final void run() {
                SimultaneousTranslationActivity.p2(this.a);
            }
        });
        q2(simultaneousTranslationActivity, str, str2, true);
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(SimultaneousTranslationActivity simultaneousTranslationActivity) {
        simultaneousTranslationActivity.I1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(SimultaneousTranslationActivity simultaneousTranslationActivity) {
        ToastUtils.v(simultaneousTranslationActivity.getString(R.string.simultaneous_translation_output_fallback_phone), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1() {
        runOnUiThread(new Runnable() { // from class: br2
            @Override // java.lang.Runnable
            public final void run() {
                SimultaneousTranslationActivity.r1(this.a);
            }
        });
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            AudioDeviceInfo audioDeviceInfo = null;
            if (!zm1.L()) {
                this.f399q.setPreferredDevice(null);
                return;
            }
            AudioDeviceInfo[] devices = T1().getDevices(2);
            p31.e(devices, "getDevices(...)");
            for (AudioDeviceInfo audioDeviceInfo2 : devices) {
                if (audioDeviceInfo2.getType() == 2) {
                    audioDeviceInfo = audioDeviceInfo2;
                    break;
                }
            }
            if (audioDeviceInfo == null) {
                Log.w(K(), "No TYPE_BUILTIN_SPEAKER output device found");
            } else {
                if (this.f399q.setPreferredDevice(audioDeviceInfo)) {
                    return;
                }
                Log.w(K(), "setPreferredDevice(speaker) returned false");
            }
        } catch (Exception e) {
            Log.w(K(), "applyPreferredOutputDeviceForCurrentMode: " + e.getMessage());
        }
    }

    private static final void q2(SimultaneousTranslationActivity simultaneousTranslationActivity, String str, String str2, boolean z) {
        simultaneousTranslationActivity.I = true;
        simultaneousTranslationActivity.w2();
        simultaneousTranslationActivity.s1(z);
        Job job = simultaneousTranslationActivity.N;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        long j = simultaneousTranslationActivity.O + 1;
        simultaneousTranslationActivity.O = j;
        simultaneousTranslationActivity.N = BuildersKt__Builders_commonKt.launch$default(eb1.a(simultaneousTranslationActivity), Dispatchers.getIO(), null, new SimultaneousTranslationActivity$playTranslationSpeech$launchPlaybackJob$1(simultaneousTranslationActivity, str, str2, z, j, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(SimultaneousTranslationActivity simultaneousTranslationActivity) {
        ((l3) simultaneousTranslationActivity.I()).O.setCompoundDrawablesRelativeWithIntrinsicBounds(zm1.L() ? R.drawable.ic_phone_black : R.drawable.ic_glasses_black, 0, R.mipmap.home_va_ts_pull_down, 0);
    }

    static /* synthetic */ void r2(SimultaneousTranslationActivity simultaneousTranslationActivity, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        q2(simultaneousTranslationActivity, str, str2, z);
    }

    private final void s1(boolean z) {
        if (this.K) {
            if (z || zm1.L()) {
                SimultaneousTranslator simultaneousTranslator = this.r;
                if (simultaneousTranslator == null) {
                    p31.t("translator");
                    simultaneousTranslator = null;
                }
                simultaneousTranslator.x(true);
            }
        }
    }

    private final void s2(String str) {
        TextToSpeech textToSpeech = this.T;
        String str2 = null;
        if (textToSpeech == null || !this.U) {
            String strK = K();
            String str3 = this.t;
            if (str3 == null) {
                p31.t("targetLanguage");
            } else {
                str2 = str3;
            }
            Log.w(strK, "Android TTS 未就绪，跳过: " + str2);
            return;
        }
        cr2 cr2Var = cr2.a;
        String str4 = this.t;
        if (str4 == null) {
            p31.t("targetLanguage");
            str4 = null;
        }
        String strC = cr2Var.c(str4);
        if (strC == null) {
            return;
        }
        int language = textToSpeech.setLanguage(Locale.forLanguageTag(strC));
        if (language == -2 || language == -1) {
            Log.w(K(), "Android TTS 不支持语言: " + strC + " (result=" + language + ")");
            return;
        }
        Log.i(K(), "Android TTS 播放: " + strC + " " + str);
        long j = this.O;
        StringBuilder sb = new StringBuilder();
        sb.append("tts_");
        sb.append(j);
        textToSpeech.speak(str, 0, null, sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AudioManager t1(SimultaneousTranslationActivity simultaneousTranslationActivity) {
        Object systemService = simultaneousTranslationActivity.getSystemService("audio");
        p31.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        return (AudioManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(SimultaneousTranslationActivity simultaneousTranslationActivity, Boolean bool) {
        if (bool.booleanValue()) {
            simultaneousTranslationActivity.v1();
        } else {
            ToastUtils.v(simultaneousTranslationActivity.getString(R.string.record_audio_permission_denied), new Object[0]);
        }
    }

    private final void u1() {
        try {
            int streamMaxVolume = T1().getStreamMaxVolume(3);
            int streamVolume = T1().getStreamVolume(3);
            Log.d(K(), "STREAM_MUSIC volume: cur=" + streamVolume + " max=" + streamMaxVolume);
            this.S = streamVolume;
            if (streamVolume < streamMaxVolume) {
                T1().setStreamVolume(3, streamMaxVolume, 0);
                int streamVolume2 = T1().getStreamVolume(3);
                if (streamVolume2 < streamMaxVolume) {
                    Log.w(K(), "音量提升被系统阻止: actual=" + streamVolume2 + " target=" + streamMaxVolume + " (OEM限制)");
                } else {
                    Log.i(K(), "STREAM_MUSIC 音量提升: " + streamVolume + " → " + streamMaxVolume);
                }
            }
        } catch (Exception e) {
            Log.w(K(), "boostTranslationStreamVolume: " + e.getMessage());
        }
    }

    private final void u2(boolean z, yq0 yq0Var) {
        this.z = false;
        if (this.K) {
            H1();
            this.G.mo92trySendJP2dKIU(new c.b(z, yq0Var));
            return;
        }
        this.x = false;
        y2();
        ((l3) I()).S.setWaveAnimationRunning(false);
        if (yq0Var != null) {
            yq0Var.invoke();
        }
    }

    private final void v1() {
        if (f2()) {
            J1();
        } else {
            S2(true);
        }
    }

    static /* synthetic */ void v2(SimultaneousTranslationActivity simultaneousTranslationActivity, boolean z, yq0 yq0Var, int i, Object obj) {
        if ((i & 2) != 0) {
            yq0Var = null;
        }
        simultaneousTranslationActivity.u2(z, yq0Var);
    }

    private final void w1() {
        if (Z1()) {
            v1();
        } else {
            this.V.a("android.permission.RECORD_AUDIO");
        }
    }

    private final void w2() {
        if (this.R != null) {
            return;
        }
        AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(3).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(1).build()).build();
        this.R = audioFocusRequestBuild;
        int iRequestAudioFocus = T1().requestAudioFocus(audioFocusRequestBuild);
        Log.d(K(), "requestAudioFocus result=" + iRequestAudioFocus);
        if (iRequestAudioFocus == 1) {
            u1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1() {
        if (this.K) {
            SimultaneousTranslator simultaneousTranslator = this.r;
            if (simultaneousTranslator == null) {
                p31.t("translator");
                simultaneousTranslator = null;
            }
            simultaneousTranslator.x(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x2() {
        y2();
        ((l3) I()).H.setVisibility(8);
        ((l3) I()).G.setWaveAnimationRunning(false);
        ((l3) I()).S.setWaveAnimationRunning(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1(String str, String str2) {
        d3(str, str2);
        this.w = -1;
        if (kotlin.text.i.Y(str)) {
            return;
        }
        this.J.add(new Pair(str, str2));
        if (!this.z) {
            m2();
            return;
        }
        Log.d(K(), "PTT 按住中，翻译结果入队: " + str2 + ", 队列大小: " + this.J.size());
    }

    private final void y2() {
        if (this.y) {
            ((l3) I()).M.setImageResource(R.drawable.ic_mic_white);
            ((l3) I()).Q.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1(String str) {
        SimultaneousTranslator simultaneousTranslator = new SimultaneousTranslator(this, str, new qr0() { // from class: vq2
            @Override // defpackage.qr0
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SimultaneousTranslationActivity.A1(this.a, (String) obj, (String) obj2, (Boolean) obj3, (Boolean) obj4);
            }
        }, new ar0() { // from class: wq2
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return SimultaneousTranslationActivity.C1(this.a, (String) obj);
            }
        }, null, new ar0() { // from class: xq2
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return SimultaneousTranslationActivity.E1(this.a, (String) obj);
            }
        }, 16, null);
        this.r = simultaneousTranslator;
        simultaneousTranslator.v(new ar0() { // from class: yq2
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return SimultaneousTranslationActivity.F1(this.a, ((Float) obj).floatValue());
            }
        });
        this.K = true;
    }

    private final void z2(String str) {
        cr2 cr2Var = cr2.a;
        String str2 = this.t;
        String str3 = null;
        if (str2 == null) {
            p31.t("targetLanguage");
            str2 = null;
        }
        String strL = cr2Var.l(str2);
        if (strL != null) {
            n2(strL, str);
            return;
        }
        if (!kotlin.text.i.Y(str)) {
            s2(str);
            return;
        }
        String strK = K();
        String str4 = this.t;
        if (str4 == null) {
            p31.t("targetLanguage");
        } else {
            str3 = str4;
        }
        Log.d(strK, "当前目标语言不支持 TTS: " + str3);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public int H() {
        return R.color.transparent;
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void N(Bundle bundle) {
        super.N(bundle);
        setTitle(getString(R.string.voice_assistant_simultaneous_translation));
        ((l3) I()).L.getRoot().setBackgroundColor(q30.c(this, R.color.transparent));
        L2();
        this.T = new TextToSpeech(this, new TextToSpeech.OnInitListener() { // from class: ar2
            @Override // android.speech.tts.TextToSpeech.OnInitListener
            public final void onInit(int i) {
                SimultaneousTranslationActivity.a2(this.a, i);
            }
        });
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        super.initData(bundle);
        c2();
        b2();
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
        super.initListener();
        F2();
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        SimultaneousTranslator simultaneousTranslator;
        super.onDestroy();
        Job job = this.N;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.N = null;
        if (this.K) {
            simultaneousTranslator = this.r;
            if (simultaneousTranslator == null) {
                p31.t("translator");
                simultaneousTranslator = null;
            }
        } else {
            simultaneousTranslator = null;
        }
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AnonymousClass1(simultaneousTranslator, null), 2, null);
        X2();
        this.f399q.release();
        TextToSpeech textToSpeech = this.T;
        if (textToSpeech != null) {
            textToSpeech.shutdown();
        }
        this.T = null;
        this.J.clear();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        Z2(new yq0() { // from class: zq2
            @Override // defpackage.yq0
            public final Object invoke() {
                return SimultaneousTranslationActivity.h2(this.a);
            }
        });
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Y2();
        x1();
        this.z = false;
        if (this.K && this.y) {
            if (!this.x) {
                SimultaneousTranslator simultaneousTranslator = this.r;
                if (simultaneousTranslator == null) {
                    p31.t("translator");
                    simultaneousTranslator = null;
                }
                if (!simultaneousTranslator.u()) {
                    return;
                }
            }
            a3(this, null, 1, null);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
