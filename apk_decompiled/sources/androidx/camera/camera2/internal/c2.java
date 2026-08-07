package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.util.Size;
import android.view.Display;
import defpackage.hh1;
import defpackage.ir2;
import defpackage.kc0;

/* JADX INFO: loaded from: classes.dex */
public class c2 {
    private static final Size e = new Size(1920, 1080);
    private static final Size f = new Size(320, 240);
    private static final Size g = new Size(640, 480);
    private static final Object h = new Object();
    private static volatile c2 i;
    private final DisplayManager a;
    private volatile Size b = null;
    private final hh1 c = new hh1();
    private final kc0 d = new kc0();

    private c2(Context context) {
        this.a = (DisplayManager) context.getSystemService("display");
    }

    private Size a() {
        Size sizeB = b();
        int width = sizeB.getWidth() * sizeB.getHeight();
        Size size = e;
        if (width > size.getWidth() * size.getHeight()) {
            sizeB = size;
        }
        return this.c.a(sizeB);
    }

    private Size b() {
        Point point = new Point();
        d(false).getRealSize(point);
        Size size = new Size(point.x, point.y);
        if (ir2.d(size, f) && (size = this.d.a()) == null) {
            size = g;
        }
        return size.getHeight() > size.getWidth() ? new Size(size.getHeight(), size.getWidth()) : size;
    }

    public static c2 c(Context context) {
        if (i == null) {
            synchronized (h) {
                try {
                    if (i == null) {
                        i = new c2(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return i;
    }

    private Display e(Display[] displayArr, boolean z) {
        Display display = null;
        int i2 = -1;
        for (Display display2 : displayArr) {
            if (!z || display2.getState() != 1) {
                Point point = new Point();
                display2.getRealSize(point);
                int i3 = point.x;
                int i4 = point.y;
                if (i3 * i4 > i2) {
                    display = display2;
                    i2 = i3 * i4;
                }
            }
        }
        return display;
    }

    public Display d(boolean z) {
        Display[] displays = this.a.getDisplays();
        if (displays.length == 1) {
            return displays[0];
        }
        Display displayE = e(displays, z);
        if (displayE == null && z) {
            displayE = e(displays, false);
        }
        if (displayE != null) {
            return displayE;
        }
        throw new IllegalArgumentException("No display can be found from the input display manager!");
    }

    Size f() {
        if (this.b != null) {
            return this.b;
        }
        this.b = a();
        return this.b;
    }

    void g() {
        this.b = a();
    }
}
