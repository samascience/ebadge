package defpackage;

import android.app.ActivityManager;
import android.content.Intent;
import com.blankj.utilcode.util.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class hn2 {
    public static boolean a(Class cls) {
        return b(cls.getName());
    }

    public static boolean b(String str) {
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) o.a().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            if (runningServices != null && runningServices.size() != 0) {
                Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().service.getClassName())) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void c(Intent intent) {
        try {
            intent.setFlags(32);
            o.a().startForegroundService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(Class cls) {
        c(new Intent(o.a(), (Class<?>) cls));
    }
}
