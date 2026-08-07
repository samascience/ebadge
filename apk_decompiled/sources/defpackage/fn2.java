package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.blankj.utilcode.util.c;
import com.blankj.utilcode.util.k;
import com.blankj.utilcode.util.o;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.receiver.NotificationClickReceiver;

/* JADX INFO: loaded from: classes4.dex */
public abstract class fn2 {
    private static int a = -1;

    private static PendingIntent b(Service service, Intent intent) {
        return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(service, 0, intent, 201326592) : PendingIntent.getBroadcast(service, 0, intent, 134217728);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Service service, Intent intent, String str, String str2, xr1.d dVar) {
        dVar.j(str).i(str2).q(c.b()).e(true).t(new long[]{0}).h(b(service, intent));
    }

    public static void d(final Service service) {
        final String str;
        if (service == null) {
            return;
        }
        try {
            String str2 = pv2.d(R.string.today_steps) + ":" + zm1.o();
            String str3 = pv2.d(R.string.target_steps) + ":" + zm1.u();
            final String strD = d20.a == 1 ? pv2.d(R.string.connected) : pv2.d(R.string.unconnected);
            if (zm1.o() > 0) {
                str = strD + "\n" + str2 + "," + str3;
            } else {
                str = strD;
            }
            final Intent intent = new Intent(o.a(), (Class<?>) NotificationClickReceiver.class);
            intent.setAction("CLICK_NOTIFICATION");
            Notification notificationB = k.b(k.a.b, new o.b() { // from class: en2
                @Override // com.blankj.utilcode.util.o.b
                public final void accept(Object obj) {
                    fn2.c(service, intent, strD, str, (xr1.d) obj);
                }
            });
            if (Build.VERSION.SDK_INT >= 34) {
                service.startForeground(1221, notificationB, 16);
            } else {
                service.startForeground(1221, notificationB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(Service service) {
        if (a == d20.a) {
            Log.i("MyNotificationUtils", "status same");
            return;
        }
        Log.i("MyNotificationUtils", "startNotify");
        d(service);
        a = d20.a;
    }
}
