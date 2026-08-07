package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import defpackage.pv1;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class k extends ContentObserver {
    private ArrayList a;
    private Application b;
    private boolean c;

    private static class b {
        private static final k a = new k();
    }

    static k a() {
        return b.a;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:54:? A[RETURN, SYNTHETIC] */
    void b(Application application) {
        Uri uriFor;
        Uri uriFor2;
        this.b = application;
        if (application == null || application.getContentResolver() == null || this.c) {
            return;
        }
        Uri uriFor3 = null;
        if (!OSUtils.isHuaWei() && !OSUtils.isEMUI()) {
            if (OSUtils.isXiaoMi() || OSUtils.isMIUI()) {
                uriFor = Settings.Global.getUriFor("force_fsg_nav_bar");
                uriFor2 = null;
                uriFor3 = Settings.Global.getUriFor("hide_gesture_line");
            } else if (OSUtils.isVivo() || OSUtils.isFuntouchOrOriginOs()) {
                uriFor = Settings.Secure.getUriFor("navigation_gesture_on");
            } else if (OSUtils.isOppo() || OSUtils.isColorOs()) {
                uriFor = Settings.Secure.getUriFor("hide_navigationbar_enable");
            } else if (!OSUtils.isSamsung()) {
                uriFor = Settings.Secure.getUriFor("navigation_mode");
            } else if (Settings.Global.getInt(this.b.getContentResolver(), "navigationbar_hide_bar_enabled", -1) == -1) {
                uriFor = Settings.Global.getUriFor("navigation_bar_gesture_while_hidden");
                uriFor3 = Settings.Global.getUriFor("navigation_bar_gesture_detail_type");
                uriFor2 = Settings.Global.getUriFor("navigation_bar_gesture_hint");
            } else {
                uriFor = Settings.Global.getUriFor("navigationbar_hide_bar_enabled");
            }
            if (uriFor != null) {
                this.b.getContentResolver().registerContentObserver(uriFor, true, this);
                this.c = true;
            }
            if (uriFor3 != null) {
                this.b.getContentResolver().registerContentObserver(uriFor3, true, this);
            }
            if (uriFor2 != null) {
                this.b.getContentResolver().registerContentObserver(uriFor2, true, this);
            }
        }
        uriFor = !OSUtils.isEMUI3_x() ? Settings.Global.getUriFor("navigationbar_is_min") : Settings.System.getUriFor("navigationbar_is_min");
        uriFor2 = null;
        if (uriFor != null) {
            this.b.getContentResolver().registerContentObserver(uriFor, true, this);
            this.c = true;
        }
        if (uriFor3 != null) {
            this.b.getContentResolver().registerContentObserver(uriFor3, true, this);
        }
        if (uriFor2 != null) {
            this.b.getContentResolver().registerContentObserver(uriFor2, true, this);
        }
    }

    void c(pv1 pv1Var) {
        ArrayList arrayList;
        if (pv1Var == null || (arrayList = this.a) == null) {
            return;
        }
        arrayList.remove(pv1Var);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        ArrayList arrayList = this.a;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        g.a aVarA = g.a(this.b);
        boolean z2 = true;
        if (aVarA.a && (!aVarA.b || com.gyf.immersionbar.a.f(this.b) <= 0)) {
            z2 = false;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((pv1) it.next()).a(z2, aVarA.c);
        }
    }

    private k() {
        super(new Handler(Looper.getMainLooper()));
        this.c = false;
    }
}
