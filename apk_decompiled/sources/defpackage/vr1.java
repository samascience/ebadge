package defpackage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import com.blankj.utilcode.util.c;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class vr1 {
    public static final String c = c.f() + ".CHANNEL_ID";
    private final Context a;
    private final NotificationManager b;

    public vr1(Context context) {
        this.a = context;
        this.b = (NotificationManager) context.getSystemService("notification");
    }

    private void b() {
        NotificationChannel notificationChannel = new NotificationChannel(c, pv2.d(R.string.app_name), 2);
        notificationChannel.setDescription(pv2.d(R.string.app_name));
        this.b.createNotificationChannel(notificationChannel);
    }

    private boolean c() {
        return this.b.getNotificationChannel(c) != null;
    }

    private boolean d() {
        return !c();
    }

    public Notification a() {
        if (d()) {
            b();
        }
        return new xr1.d(this.a, c).q(R.mipmap.ic_launcher).j("upload data").n(true).u(1).b();
    }
}
