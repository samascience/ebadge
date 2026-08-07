package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final boolean g;
    public static final boolean h;
    private static final File i;
    private static volatile b j;
    private static volatile int k;
    private final int b;
    private final int c;
    private int d;
    private boolean e = true;
    private final AtomicBoolean f = new AtomicBoolean(false);
    private final boolean a = f();

    static {
        g = Build.VERSION.SDK_INT < 29;
        h = true;
        i = new File("/proc/self/fd");
        k = -1;
    }

    b() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = BluetoothConstant.RECEIVE_OTA_CMD_TIMEOUT;
            this.c = 0;
        } else {
            this.b = 700;
            this.c = 128;
        }
    }

    private boolean a() {
        return g && !this.f.get();
    }

    public static b b() {
        if (j == null) {
            synchronized (b.class) {
                try {
                    if (j == null) {
                        j = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return j;
    }

    private int c() {
        return k != -1 ? k : this.b;
    }

    private synchronized boolean d() {
        try {
            boolean z = true;
            int i2 = this.d + 1;
            this.d = i2;
            if (i2 >= 50) {
                this.d = 0;
                int length = i.list().length;
                long jC = c();
                if (length >= jC) {
                    z = false;
                }
                this.e = z;
                if (!z && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + jC);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.e;
    }

    private static boolean f() {
        return (g() || h()) ? false : true;
    }

    private static boolean g() {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        Iterator it = Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play").iterator();
        while (it.hasNext()) {
            if (Build.MODEL.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean h() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        return Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL);
    }

    public boolean e(int i2, int i3, boolean z, boolean z2) {
        if (!z) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!this.a) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by device model");
            }
            return false;
        }
        if (!h) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (a()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z2) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        int i4 = this.c;
        if (i2 < i4) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because width is too small");
            }
            return false;
        }
        if (i3 < i4) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because height is too small");
            }
            return false;
        }
        if (d()) {
            return true;
        }
        if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
        }
        return false;
    }

    boolean i(int i2, int i3, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean zE = e(i2, i3, z, z2);
        if (zE) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zE;
    }
}
