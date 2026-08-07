package defpackage;

import android.util.Log;
import com.blankj.utilcode.util.j;
import com.tencent.connect.common.Constants;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import org.objectweb.asm.Opcodes;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.model.sportDetails.SportDetailsModel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zm1 {
    private static String a = "is_bingding";
    private static String b = "KEY_DEBUG_MODE";
    private static String c = "KEY_DEVICE_BADGE_MARK_RECOGNIZED";
    private static String d;

    public static long A() {
        return ij2.b().f("updateDateByWeather", 0L);
    }

    public static long B() {
        if (A() == 0) {
            return 999999L;
        }
        return Math.abs(e33.i(A(), e33.f(), 1000));
    }

    public static int C() {
        return rj2.c("weight", 65);
    }

    public static int D() {
        return rj2.c("weight_unit", 1);
    }

    public static boolean E() {
        return ij2.b().a("userProtocol", false);
    }

    public static boolean F() {
        return B() > 7200;
    }

    public static boolean G() {
        return !pv2.h(ug3.c());
    }

    public static boolean H() {
        return ij2.b().a(b, false);
    }

    public static boolean I() {
        try {
            return Integer.valueOf(rj2.d("default_open_call", "0")).intValue() == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean J() {
        return ij2.b().a(c + i(), false);
    }

    public static boolean K() {
        return false;
    }

    public static boolean L() {
        return ij2.b().a("simultaneousTranslationOutputPhone", false);
    }

    public static boolean M() {
        return z90.b(f());
    }

    public static boolean N() {
        return z90.d(f());
    }

    public static boolean O() {
        return z90.c(f());
    }

    public static boolean P() {
        try {
            return Integer.valueOf(rj2.d("show_temp", "0")).intValue() == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean Q() {
        try {
            return Integer.valueOf(rj2.d("show_weather", "0")).intValue() == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean R() {
        try {
            return Integer.valueOf(rj2.d("show_wxsport", "0")).intValue() == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void S(String str) {
        rj2.g("bluetooth_name", str);
    }

    public static void T(String str) {
        ij2.b().n("device_black_list", str);
    }

    public static void U(int i, int i2, int i3) {
        V(i, i2, i3, 0);
    }

    public static void V(int i, int i2, int i3, int i4) {
        Map mapA = z60.a();
        String str = mapA.get("month").toString() + mapA.get("day").toString();
        rj2.g("distance_values" + str, (i / 1000.0f) + Constants.STR_EMPTY);
        rj2.f("calory_values" + str, i3);
        rj2.f("steps_values" + str, i2);
        rj2.f("excercise_time_values" + str, i4);
    }

    public static void W(String str) {
        rj2.g("SOSContract" + f(), str);
    }

    public static void X(String str) {
        ij2.b().n("adv_status", str);
    }

    public static void Y(String str) {
        rj2.g("show_weather", str);
    }

    public static void Z() {
        ij2.b().p("userProtocol", true);
    }

    public static void a(String str, String str2) {
        if (pv2.f(str) || pv2.f(str2)) {
            return;
        }
        ij2.b().n(str.replaceAll(":", Constants.STR_EMPTY), str2);
    }

    public static void a0(boolean z) {
        rj2.f(a, z ? 1 : 0);
    }

    public static void b() {
        d = Constants.STR_EMPTY;
        rj2.b();
    }

    public static void b0(String str) {
        rj2.g("bluetooth_address", str);
        f0(str);
        d = str;
    }

    public static int c() {
        return rj2.c("age", 25);
    }

    public static void c0(boolean z) {
        ij2.b().p(c + i(), z);
        StringBuilder sb = new StringBuilder();
        sb.append("设备标记识别结果已保存: ");
        sb.append(z ? "新版本设备" : "老版本设备");
        sb.append(", MAC: ");
        sb.append(f());
        Log.i("MySPUtils", sb.toString());
    }

    public static int d() {
        int iC = rj2.c("phoneArea", -1);
        int iE = ij2.b().e("phoneArea", -1);
        j.j("=======areaCode1:" + iC + ";areaCode2:" + iE);
        if (iC == 0 || iC == 1) {
            return iC;
        }
        if (iE == 0 || iE == 1) {
            return iE;
        }
        return -1;
    }

    public static void d0(String str) {
        rj2.g("deviceVersion" + i(), str);
    }

    public static String e() {
        return rj2.d("bluetooth_address", Constants.STR_EMPTY);
    }

    public static void e0(int i) {
        rj2.f("height", i);
    }

    public static String f() {
        if (pv2.h(d)) {
            d = e();
        }
        return d;
    }

    public static void f0(String str) {
        if (pv2.h(str)) {
            return;
        }
        ij2.b().n("longMac", str);
    }

    public static String g() {
        return q().split(",")[0];
    }

    public static void g0(boolean z) {
        ij2.b().q("simultaneousTranslationOutputPhone", z, false);
    }

    public static int h() {
        int iC = rj2.c("distance_unit", d20.f);
        return (iC == d20.f || iC == d20.g) ? iC : d20.f;
    }

    public static void h0(boolean z) {
        rj2.f("login_kip", z ? 1 : 0);
    }

    public static String i() {
        String strF = f();
        return pv2.f(strF) ? Constants.STR_EMPTY : strF.replaceAll(":", Constants.STR_EMPTY);
    }

    public static void i0(int i) {
        rj2.f("weight_unit", i);
    }

    public static int j() {
        return rj2.c("gender", 1);
    }

    public static void j0() {
        ij2.b().l("updateDateByWeather", e33.f());
    }

    public static int k() {
        return rj2.c("height", Opcodes.TABLESWITCH);
    }

    public static int l() {
        return rj2.c("height_unit", 1);
    }

    private static int m(Date date) {
        return date.getTime() >= bn1.p(e33.e()).getTime() ? rj2.c(x(date), w()) : rj2.c(x(date), 5000);
    }

    public static String n() {
        String strF = f();
        return pv2.h(strF) ? ij2.b().h("longMac", Constants.STR_EMPTY) : strF;
    }

    public static int o() {
        Map mapA = z60.a();
        return rj2.c("steps_values" + (mapA.get("month").toString() + mapA.get("day").toString()), 0);
    }

    public static String p() {
        return rj2.d("SOSContract" + f(), Constants.STR_EMPTY);
    }

    public static String q() {
        return rj2.d("deviceVersion" + i(), Constants.STR_EMPTY);
    }

    public static int r() {
        return rj2.c("target_cal", 400);
    }

    public static int s() {
        return rj2.c("target_sleep", 8);
    }

    public static int t() {
        return rj2.c("target_sport_time", 30);
    }

    public static int u() {
        return m(e33.e());
    }

    public static int v(Date date) {
        if (e33.n(date)) {
            return m(date);
        }
        SportDetailsModel lastSportDetailsHistory = DBHelper.getLastSportDetailsHistory(date);
        return (lastSportDetailsHistory == null || lastSportDetailsHistory.getTargetSteps() <= 0) ? m(date) : lastSportDetailsHistory.getTargetSteps();
    }

    public static int w() {
        return rj2.c("lastTargetSteps", 5000);
    }

    public static String x(Date date) {
        return e33.c(date, bn1.m()) + "_target_step";
    }

    public static int y() {
        return rj2.c("temp_unit", 0);
    }

    public static String z() {
        String strD = rj2.d("uuid", Constants.STR_EMPTY);
        if (!pv2.f(strD)) {
            return strD;
        }
        String strReplace = UUID.randomUUID().toString().replace("-", Constants.STR_EMPTY);
        rj2.g("uuid", strReplace);
        return strReplace;
    }
}
