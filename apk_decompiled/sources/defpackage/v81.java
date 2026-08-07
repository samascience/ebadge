package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import com.blankj.utilcode.util.a;
import com.blankj.utilcode.util.c;
import com.blankj.utilcode.util.h;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public abstract class v81 {
    public static String a() {
        String strA = db0.a();
        if (strA == null) {
            strA = Constants.STR_EMPTY;
        }
        return strA.toLowerCase();
    }

    public static void b(Context context) {
        try {
            v(context, "com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
        } catch (Exception unused) {
            v(context, "com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity");
        }
    }

    public static void c(Context context) {
        try {
            if (k()) {
                b(context);
            } else if (s()) {
                j(context);
            } else if (o()) {
                f(context);
            } else if (r()) {
                i(context);
            } else if (n()) {
                e(context);
            } else if (p()) {
                g(context);
            } else if (q()) {
                h(context);
            } else if (m()) {
                d(context);
            } else {
                a.n(h.b(c.f()));
            }
        } catch (Exception unused) {
            a.n(h.b(c.f()));
        }
    }

    public static void d(Context context) {
        v(context, "com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity");
    }

    public static void e(Context context) {
        u(context, "com.meizu.safe");
    }

    public static void f(Context context) {
        try {
            try {
                try {
                    u(context, "com.coloros.phonemanager");
                } catch (Exception unused) {
                    u(context, "com.coloros.oppoguardelf");
                }
            } catch (Exception unused2) {
                u(context, "com.oppo.safe");
            }
        } catch (Exception unused3) {
            u(context, "com.coloros.safecenter");
        }
    }

    public static void g(Context context) {
        try {
            u(context, "com.samsung.android.sm_cn");
        } catch (Exception unused) {
            u(context, "com.samsung.android.sm");
        }
    }

    public static void h(Context context) {
        u(context, "com.smartisanos.security");
    }

    public static void i(Context context) {
        u(context, "com.iqoo.secure");
    }

    public static void j(Context context) {
        v(context, "com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity");
    }

    public static boolean k() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase().equals("huawei") || str.toLowerCase().equals("honor");
    }

    public static boolean l(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            return powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
        }
        return false;
    }

    public static boolean m() {
        return a().equals("letv");
    }

    public static boolean n() {
        return a().equals("meizu");
    }

    public static boolean o() {
        return a().equals("oppo");
    }

    public static boolean p() {
        return a().equals("samsung");
    }

    public static boolean q() {
        return a().equals("smartisan");
    }

    public static boolean r() {
        return a().equals("vivo");
    }

    public static boolean s() {
        return a().equals("xiaomi");
    }

    public static void t(Context context) {
        try {
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void u(Context context, String str) {
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str));
    }

    public static void v(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}
