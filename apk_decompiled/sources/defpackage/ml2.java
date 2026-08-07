package defpackage;

import android.graphics.Point;
import android.view.WindowManager;
import com.blankj.utilcode.util.o;

/* JADX INFO: loaded from: classes.dex */
public abstract class ml2 {
    public static int a() {
        WindowManager windowManager = (WindowManager) o.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static int b() {
        WindowManager windowManager = (WindowManager) o.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public static int c() {
        WindowManager windowManager = (WindowManager) o.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    public static boolean d() {
        return o.a().getResources().getConfiguration().orientation == 1;
    }
}
