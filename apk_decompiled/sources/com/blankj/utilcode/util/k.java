package com.blankj.utilcode.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import defpackage.as1;
import defpackage.xr1;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    public static class a {
        public static final a b = new a(o.a().getPackageName(), o.a().getPackageName(), 3);
        private NotificationChannel a;

        public a(String str, CharSequence charSequence, int i) {
            this.a = new NotificationChannel(str, charSequence, i);
        }

        public NotificationChannel b() {
            return this.a;
        }
    }

    public static void a(int i) {
        as1.d(o.a()).b(i);
    }

    public static Notification b(a aVar, o.b bVar) {
        ((NotificationManager) o.a().getSystemService("notification")).createNotificationChannel(aVar.b());
        xr1.d dVar = new xr1.d(o.a());
        dVar.f(aVar.a.getId());
        if (bVar != null) {
            bVar.accept(dVar);
        }
        return dVar.b();
    }
}
