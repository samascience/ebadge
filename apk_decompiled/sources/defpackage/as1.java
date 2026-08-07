package defpackage;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class as1 {
    private static String d;
    private final Context a;
    private final NotificationManager b;
    private static final Object c = new Object();
    private static Set e = new HashSet();
    private static final Object f = new Object();

    static class a {
        static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }
    }

    private as1(Context context) {
        this.a = context;
        this.b = (NotificationManager) context.getSystemService("notification");
    }

    public static as1 d(Context context) {
        return new as1(context);
    }

    public static Set e(Context context) {
        Set set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (c) {
            if (string != null) {
                try {
                    if (!string.equals(d)) {
                        String[] strArrSplit = string.split(":", -1);
                        HashSet hashSet = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        e = hashSet;
                        d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = e;
        }
        return set;
    }

    public boolean a() {
        return a.a(this.b);
    }

    public void b(int i) {
        c(null, i);
    }

    public void c(String str, int i) {
        this.b.cancel(str, i);
    }
}
