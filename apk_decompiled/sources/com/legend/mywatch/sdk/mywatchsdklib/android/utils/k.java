package com.legend.mywatch.sdk.mywatchsdklib.android.utils;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.content.Intent;
import com.tencent.connect.common.Constants;
import defpackage.fj2;
import defpackage.i91;
import defpackage.k31;
import defpackage.rv2;
import defpackage.y62;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class k {
    static void a(i.b bVar) {
        j.g.a(bVar);
    }

    static void b(Activity activity) {
        i91.a(activity);
    }

    static List c() {
        return j.g.e();
    }

    static Application d() {
        return j.g.i();
    }

    static String e() {
        return y62.a();
    }

    static File f(String str) {
        return f.a(str);
    }

    static Intent g(String str, boolean z) {
        return k31.b(str, z);
    }

    static Notification h(h.a aVar, i.a aVar2) {
        return h.a(aVar, aVar2);
    }

    static fj2 i() {
        return fj2.a("Utils");
    }

    static Activity j() {
        return j.g.j();
    }

    static void k(Application application) {
        j.g.k(application);
    }

    static boolean l(Activity activity) {
        return a.b(activity);
    }

    static boolean m() {
        return j.g.l();
    }

    static boolean n(File file) {
        return f.b(file);
    }

    static boolean o(Intent intent) {
        return k31.c(intent);
    }

    static boolean p(String str) {
        return rv2.g(str);
    }

    static void q() {
        r(b.f());
    }

    private static void r(Runnable... runnableArr) {
        for (Runnable runnable : runnableArr) {
            ThreadUtils.b().execute(runnable);
        }
    }

    static void s(Runnable runnable) {
        ThreadUtils.e(runnable);
    }

    static void t(Runnable runnable, long j) {
        ThreadUtils.f(runnable, j);
    }

    static String toJson(Object obj) {
        return Constants.STR_EMPTY;
    }

    static void u(Application application) {
        j.g.q(application);
    }
}
