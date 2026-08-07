package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import defpackage.ij2;
import defpackage.j91;
import defpackage.kr2;
import defpackage.ml2;
import defpackage.pv2;
import defpackage.qv0;
import defpackage.u71;
import defpackage.v23;
import defpackage.x62;
import defpackage.xf;
import defpackage.yi2;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class q {

    static final class a {
        private String a;
        private LinkedHashMap b = new LinkedHashMap();
        private LinkedHashMap c = new LinkedHashMap();

        a(String str) {
            this.a = str;
        }

        private void b(Map map, String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            int length = 19 - str.length();
            if (length > 0) {
                str = str + "                   ".substring(0, length);
            }
            map.put(str, str2);
        }

        void a(String str, String str2) {
            b(this.b, str, str2);
        }

        public String c() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : this.c.entrySet()) {
                sb.append((String) entry.getKey());
                sb.append(": ");
                sb.append((String) entry.getValue());
                sb.append("\n");
            }
            return sb.toString();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = "************* " + this.a + " Head ****************\n";
            sb.append(str);
            for (Map.Entry entry : this.b.entrySet()) {
                sb.append((String) entry.getKey());
                sb.append(": ");
                sb.append((String) entry.getValue());
                sb.append("\n");
            }
            sb.append("Rom Info           : ");
            sb.append(m.c());
            sb.append("\n");
            sb.append("Device Manufacturer: ");
            sb.append(Build.MANUFACTURER);
            sb.append("\n");
            sb.append("Device Model       : ");
            sb.append(Build.MODEL);
            sb.append("\n");
            sb.append("Android Version    : ");
            sb.append(Build.VERSION.RELEASE);
            sb.append("\n");
            sb.append("Android SDK        : ");
            sb.append(Build.VERSION.SDK_INT);
            sb.append("\n");
            sb.append("App VersionName    : ");
            sb.append(c.i());
            sb.append("\n");
            sb.append("App VersionCode    : ");
            sb.append(c.g());
            sb.append("\n");
            sb.append(c());
            sb.append(str);
            sb.append("\n");
            return sb.toString();
        }
    }

    static boolean A(Activity activity) {
        return com.blankj.utilcode.util.a.i(activity);
    }

    static boolean B() {
        return p.g.q();
    }

    static boolean C(File file) {
        return g.o(file);
    }

    static boolean D() {
        return PermissionUtils.u();
    }

    static boolean E(Intent intent) {
        return h.e(intent);
    }

    static boolean F() {
        return r.a();
    }

    static boolean G() {
        return yi2.a();
    }

    static boolean H(String str) {
        return pv2.g(str);
    }

    static View I(int i) {
        return r.b(i);
    }

    static void J() {
        K(b.f());
    }

    private static void K(Runnable... runnableArr) {
        for (Runnable runnable : runnableArr) {
            ThreadUtils.b().execute(runnable);
        }
    }

    static int L(float f) {
        return kr2.b(f);
    }

    static void M(o.a aVar) {
        p.g.u(aVar);
    }

    static void N(Runnable runnable) {
        ThreadUtils.e(runnable);
    }

    static void O(Runnable runnable, long j) {
        ThreadUtils.f(runnable, j);
    }

    static int P(float f) {
        return kr2.c(f);
    }

    static void Q(Application application) {
        p.g.y(application);
    }

    static Bitmap R(View view) {
        return ImageUtils.g(view);
    }

    static boolean S(String str, InputStream inputStream) {
        return f.b(str, inputStream);
    }

    static boolean T(String str, String str2, boolean z) {
        return f.d(str, str2, z);
    }

    static void a(o.a aVar) {
        p.g.d(aVar);
    }

    static void b(o.c cVar) {
        p.g.f(cVar);
    }

    static boolean c(File file) {
        return g.a(file);
    }

    static boolean d(File file) {
        return g.c(file);
    }

    static int e(float f) {
        return kr2.a(f);
    }

    static void f() {
        com.blankj.utilcode.util.a.a();
    }

    static <T> T fromJson(String str, Type type) {
        return (T) GsonUtils.fromJson(str, type);
    }

    static void g(Activity activity) {
        j91.a(activity);
    }

    static String h(String str, Object... objArr) {
        return pv2.c(str, objArr);
    }

    static String i(String str) {
        return u71.a(str);
    }

    static List j() {
        return p.g.j();
    }

    static int k() {
        return ml2.a();
    }

    static Application l() {
        return p.g.n();
    }

    static String m() {
        return x62.a();
    }

    static File n(String str) {
        return g.l(str);
    }

    static String o(Throwable th) {
        return v23.a(th);
    }

    static qv0 p() {
        return GsonUtils.getGson4LogUtils();
    }

    static Intent q(String str, boolean z) {
        return h.c(str, z);
    }

    static Intent r(String str) {
        return h.d(str);
    }

    static String s(String str) {
        return com.blankj.utilcode.util.a.f(str);
    }

    static int t() {
        return xf.d();
    }

    static String toJson(Object obj) {
        return GsonUtils.toJson(obj);
    }

    static Notification u(k.a aVar, o.b bVar) {
        return k.b(aVar, bVar);
    }

    static ij2 v() {
        return ij2.c("Utils");
    }

    static int w() {
        return xf.e();
    }

    static String x(int i) {
        return pv2.d(i);
    }

    static Activity y() {
        return p.g.o();
    }

    static void z(Application application) {
        p.g.p(application);
    }
}
