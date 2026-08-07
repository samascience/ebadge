package defpackage;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.baji.network.NetworkManager;
import com.baji.network.config.NetworkConfig;
import com.baji.protocol.BajiProtocolManager;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.e;
import com.blankj.utilcode.util.j;
import com.blankj.utilcode.util.o;
import com.iwellfitness.urllib.ManualUrlConfig;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.open.SocialConstants;
import io.microshow.rxffmpeg.RxFFmpegInvoke;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.collections.u;
import xfkj.fitpro.activity.ota.manager.OTAInitializer;
import xfkj.fitpro.receiver.BluetoothAdapterStateReceiver;
import xfkj.fitpro.service.NotifyService;

/* JADX INFO: loaded from: classes4.dex */
public abstract class hg extends hl1 implements xx0 {
    public static final a d = new a(null);
    private static String e;
    private static int f;
    private static final List g;
    private static Context h;
    public static int i;
    private String a = "MyApplication";
    private BluetoothAdapterStateReceiver b;
    private BajiProtocolManager c;

    public static final class a {

        /* JADX INFO: renamed from: hg$a$a, reason: collision with other inner class name */
        public static final class C0130a implements PermissionUtils.b {
            final /* synthetic */ Context a;

            C0130a(Context context) {
                this.a = context;
            }

            @Override // com.blankj.utilcode.util.PermissionUtils.b
            public void onDenied() {
            }

            @Override // com.blankj.utilcode.util.PermissionUtils.b
            public void onGranted() {
                hg.d.h(this.a);
            }
        }

        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public static /* synthetic */ void c(a aVar, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = 1;
            }
            aVar.b(str, str2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(Context context) {
            Intent intent = new Intent(context, (Class<?>) NotifyService.class);
            intent.addFlags(268435456);
            hn2.c(intent);
            NotifyService.o(context);
        }

        public final void a(String str, String str2) {
            p31.f(str2, SocialConstants.PARAM_SEND_MSG);
            c(this, str, str2, 0, 4, null);
        }

        public final void b(String str, String str2, int i) {
            p31.f(str2, SocialConstants.PARAM_SEND_MSG);
            if (i == 1) {
                Log.e(str, str2);
                j.k(str, str2);
            } else {
                Log.i(str, str2);
                j.u(str, str2);
            }
            if (zm1.H()) {
                tj2.c(str2);
            }
        }

        public final void e(Map map) {
            p31.f(map, "map");
            if (map.containsKey("what")) {
                map.put("packageName", com.blankj.utilcode.util.c.f());
                Intent intent = new Intent();
                intent.setAction(String.valueOf(map.get("action")));
                Bundle bundle = new Bundle();
                bundle.putSerializable("Datas", (Serializable) map);
                intent.putExtras(bundle);
                Context contextF = f();
                p31.c(contextF);
                contextF.sendBroadcast(intent);
            }
        }

        public final Context f() {
            return hg.h;
        }

        public final void g() {
            String strF = com.blankj.utilcode.util.c.f();
            p31.e(strF, "getAppPackageName(...)");
            Context contextF = f();
            p31.c(contextF);
            Object systemService = contextF.getSystemService("notification");
            p31.d(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationChannel notificationChannel = ((NotificationManager) systemService).getNotificationChannel(strF);
            if (notificationChannel == null || notificationChannel.getImportance() != 0) {
                return;
            }
            Intent intent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
            Context contextF2 = f();
            p31.c(contextF2);
            intent.putExtra("android.provider.extra.APP_PACKAGE", contextF2.getPackageName());
            intent.putExtra("android.provider.extra.CHANNEL_ID", notificationChannel.getId());
            intent.setFlags(268435456);
            Context contextF3 = f();
            p31.c(contextF3);
            contextF3.startActivity(intent);
        }

        public final void i(Context context) {
            p31.f(context, "context");
            if (!hn2.a(NotifyService.class) || NotifyService.c() == null) {
                if (Build.VERSION.SDK_INT >= 34) {
                    PermissionUtils.y("android.permission.FOREGROUND_SERVICE_CONNECTED_DEVICE").m(new C0130a(context)).z();
                } else {
                    h(context);
                }
            }
        }

        private a() {
        }
    }

    public static final class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Activity activity, View view) {
            activity.onBackPressed();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            p31.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            p31.f(activity, "activity");
            activity.getIntent().removeExtra("isInitToolbar");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            p31.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            p31.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            p31.f(activity, "activity");
            p31.f(bundle, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(final Activity activity) {
            p31.f(activity, "activity");
            hg.f++;
            if (!com.blankj.utilcode.util.c.k()) {
                hg.this.h();
            }
            if (!activity.getIntent().getBooleanExtra("isInitToolbar", false)) {
                activity.getIntent().putExtra("isInitToolbar", true);
                if (activity.findViewById(R.id.toolbar) != null) {
                    if (activity instanceof AppCompatActivity) {
                        AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
                        appCompatActivity.setSupportActionBar((Toolbar) appCompatActivity.findViewById(R.id.toolbar));
                        androidx.appcompat.app.a supportActionBar = appCompatActivity.getSupportActionBar();
                        p31.c(supportActionBar);
                        supportActionBar.t(false);
                    } else {
                        activity.setActionBar((android.widget.Toolbar) activity.findViewById(R.id.toolbar));
                        ActionBar actionBar = activity.getActionBar();
                        p31.c(actionBar);
                        actionBar.setDisplayShowTitleEnabled(false);
                    }
                }
                if (activity.findViewById(R.id.toolbar_title) != null) {
                    View viewFindViewById = activity.findViewById(R.id.toolbar_title);
                    p31.d(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
                    ((TextView) viewFindViewById).setText(activity.getTitle());
                }
            }
            if (activity.findViewById(R.id.toolbar_back) != null) {
                activity.findViewById(R.id.toolbar_back).setOnClickListener(new View.OnClickListener() { // from class: ig
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        hg.b.b(activity, view);
                    }
                });
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            p31.f(activity, "activity");
            hg.f--;
            if (hg.f == 0) {
                hg.this.A();
            }
        }
    }

    public static final class c implements o.c {
        c() {
        }

        @Override // com.blankj.utilcode.util.o.c
        public void a(Activity activity) {
            p31.f(activity, "activity");
            Log.i(hg.this.m(), "initBackgroundCallBack onForeground");
            tj2.b("*************************The APP has entered the foreground***************************");
            hg.this.h();
            zi2.h();
        }

        @Override // com.blankj.utilcode.util.o.c
        public void b(Activity activity) {
            p31.f(activity, "activity");
            Log.i(hg.this.m(), "initBackgroundCallBack onBackground");
            tj2.b("*************************The APP has exit the background***************************");
        }
    }

    public static final class d implements ManualUrlConfig.Provider {
        d() {
        }

        @Override // com.iwellfitness.urllib.ManualUrlConfig.Provider
        public String getDeviceVersion() {
            String strQ = zm1.q();
            p31.e(strQ, "getSrcDeviceVersion(...)");
            return strQ;
        }

        @Override // com.iwellfitness.urllib.ManualUrlConfig.Provider
        public String getPackageName() {
            return hg.this.getPackageName();
        }

        @Override // com.iwellfitness.urllib.ManualUrlConfig.Provider
        public boolean shouldShowAdv() {
            return zm1.K();
        }
    }

    static {
        List listSynchronizedList = Collections.synchronizedList(new LinkedList());
        p31.e(listSynchronizedList, "synchronizedList(...)");
        g = listSynchronizedList;
        i = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        d20.e = false;
        D(false);
        a aVar = d;
        Context context = h;
        p31.c(context);
        aVar.i(context);
        rj2.f("has_wirte_log", 1);
    }

    public static final void B() {
        d.g();
    }

    private final void C() {
        if (this.b != null) {
            return;
        }
        this.b = new BluetoothAdapterStateReceiver();
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.b, intentFilter, 4);
        } else {
            registerReceiver(this.b, intentFilter);
        }
    }

    public static final void E(Context context) {
        d.i(context);
    }

    public static final void b(String str, String str2) {
        d.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        a aVar = d;
        a.c(aVar, this.a, "back2App-------true------" + d20.a, 0, 4, null);
        D(true);
        if (rj2.c("has_wirte_log", 0) == 1) {
            rj2.f("has_wirte_log", 0);
            Context context = h;
            p31.c(context);
            aVar.i(context);
        }
    }

    private final void i() {
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(objInvoke, true);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static final Context l() {
        return d.f();
    }

    private final void n() {
        registerActivityLifecycleCallbacks(new b());
    }

    private final void o() {
        com.blankj.utilcode.util.c.m(new c());
    }

    private final void p() {
        try {
            zl zlVar = zl.a;
            zlVar.j(this);
            this.c = zlVar.i();
            a.c(d, this.a, "baji-protocol模块初始化成功", 0, 4, null);
        } catch (Exception e2) {
            a.c(d, this.a, "baji-protocol模块初始化失败: " + e2.getMessage(), 0, 4, null);
        }
    }

    private final void r() {
        try {
            py.a.c();
            a.c(d, this.a, "表盘信息管理器初始化成功", 0, 4, null);
        } catch (Exception e2) {
            a.c(d, this.a, "表盘信息管理器初始化失败: " + e2.getMessage(), 0, 4, null);
        }
    }

    private final void s() {
        if (x62.e()) {
            bm.a(new bm.a() { // from class: gg
            });
        }
    }

    private final void t() {
        j.p().E(false).y(false).B("FitPro").D(true).C(true).z(rz1.j()).F(7).A(4).x(true);
    }

    private final void v() {
    }

    private final void w() {
        try {
            NetworkManager.initialize$default(NetworkManager.Companion.getInstance(), "https://hiapi.jusonsmart.com/", null, false, NetworkConfig.DEFAULT_LOG_LEVEL, u.g(d63.a("User-Agent", "ElectronicBadge/1.0.0"), d63.a("Accept", "application/json")), 2, null);
            a.c(d, this.a, "network-module模块初始化成功", 0, 4, null);
        } catch (Exception e2) {
            a.c(d, this.a, "network-module模块初始化失败: " + e2.getMessage(), 0, 4, null);
        }
    }

    private final void x() {
        try {
            RxFFmpegInvoke.a().setDebug(false);
            a.c(d, this.a, "RxFFmpeg模块初始化成功", 0, 4, null);
        } catch (Exception e2) {
            a.c(d, this.a, "RxFFmpeg模块初始化失败: " + e2.getMessage(), 0, 4, null);
        }
    }

    public final void D(boolean z) {
        String str = z ? "前台" : "后台";
        String str2 = z ? "开启" : "关闭";
        BajiProtocolManager bajiProtocolManagerK = k();
        if (bajiProtocolManagerK != null) {
            byte[] bArrK = qm2.K(z);
            p31.e(bArrK, "getTurnOnRealTimeStep(...)");
            bajiProtocolManagerK.sendDataToDevice(bArrK, "进入" + str + "获取实时步数开关:" + str2 + z);
        }
    }

    @Override // defpackage.xx0
    public b32 a() {
        return new c32();
    }

    public final String j() {
        String string = getString(R.string.app_name);
        p31.e(string, "getString(...)");
        return string;
    }

    public final BajiProtocolManager k() {
        return this.c;
    }

    protected final String m() {
        return this.a;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        h = this;
        z();
        e = j();
        rj2.a(this);
        if (rj2.e()) {
            a.c(d, "提醒", "sharedPreferences未被创建！", 0, 4, null);
        }
        rj2.f("language", 0);
        d20.b = zm1.H();
        d20.d = new Handler();
        d20.e = true;
        i();
        v();
        s();
    }

    @Override // android.app.Application
    public void onTerminate() {
        BluetoothAdapterStateReceiver bluetoothAdapterStateReceiver = this.b;
        if (bluetoothAdapterStateReceiver != null) {
            try {
                unregisterReceiver(bluetoothAdapterStateReceiver);
            } catch (Exception e2) {
                Log.w(this.a, "unregister BluetoothAdapterStateReceiver: " + e2.getMessage());
            }
            this.b = null;
        }
        super.onTerminate();
    }

    public final void q() {
        if (zm1.E()) {
            p();
            r();
            n();
            OTAInitializer.initialize(this);
            bu.d(this);
            C();
        }
    }

    protected final void u() {
        ManualUrlConfig.init(new d());
    }

    protected abstract void y();

    public final void z() {
        if (zm1.E()) {
            o.b(this);
            t();
            e.c(rz1.e());
            x();
            q();
            w();
            int iD = zm1.d();
            if (ij2.b().e("phoneArea", -1) == -1 && iD != -1) {
                ij2.b().j("phoneArea", iD);
            }
            o();
            androidx.multidex.a.k(this);
            ss0.f().g();
            y();
        }
    }
}
