package com.legend.mywatch.sdk.mywatchsdklib.android.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import defpackage.xr1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    public static class a {
        public static final a b = new a(i.a().getPackageName(), i.a().getPackageName(), 3);
        private NotificationChannel a;

        public a(String str, CharSequence charSequence, int i) {
            this.a = new NotificationChannel(str, charSequence, i);
        }

        public NotificationChannel b() {
            return this.a;
        }
    }

    public static Notification a(a aVar, i.a aVar2) {
        ((NotificationManager) i.a().getSystemService("notification")).createNotificationChannel(aVar.b());
        xr1.d dVar = new xr1.d(i.a());
        dVar.f(aVar.a.getId());
        if (aVar2 != null) {
            aVar2.accept(dVar);
        }
        return dVar.b();
    }
}
