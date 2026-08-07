package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import lombok.eclipse.Eclipse;

/* JADX INFO: loaded from: classes.dex */
public final class ki1 {
    private final int a;
    private final int b;
    private final Context c;
    private final int d;

    public static final class a {
        static final int i = 1;
        final Context a;
        ActivityManager b;
        c c;
        float e;
        float d = 2.0f;
        float f = 0.4f;
        float g = 0.33f;
        int h = 4194304;

        public a(Context context) {
            this.e = i;
            this.a = context;
            this.b = (ActivityManager) context.getSystemService("activity");
            this.c = new b(context.getResources().getDisplayMetrics());
            if (ki1.e(this.b)) {
                this.e = 0.0f;
            }
        }

        public ki1 a() {
            return new ki1(this);
        }
    }

    private static final class b implements c {
        private final DisplayMetrics a;

        b(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }

        @Override // ki1.c
        public int a() {
            return this.a.heightPixels;
        }

        @Override // ki1.c
        public int b() {
            return this.a.widthPixels;
        }
    }

    interface c {
        int a();

        int b();
    }

    ki1(a aVar) {
        this.c = aVar.a;
        int i = e(aVar.b) ? aVar.h / 2 : aVar.h;
        this.d = i;
        int iC = c(aVar.b, aVar.f, aVar.g);
        float fB = aVar.c.b() * aVar.c.a() * 4;
        int iRound = Math.round(aVar.e * fB);
        int iRound2 = Math.round(fB * aVar.d);
        int i2 = iC - i;
        int i3 = iRound2 + iRound;
        if (i3 <= i2) {
            this.b = iRound2;
            this.a = iRound;
        } else {
            float f = i2;
            float f2 = aVar.e;
            float f3 = aVar.d;
            float f4 = f / (f2 + f3);
            this.b = Math.round(f3 * f4);
            this.a = Math.round(f4 * aVar.e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.b));
            sb.append(", pool size: ");
            sb.append(f(this.a));
            sb.append(", byte array size: ");
            sb.append(f(i));
            sb.append(", memory class limited? ");
            sb.append(i3 > iC);
            sb.append(", max size: ");
            sb.append(f(iC));
            sb.append(", memoryClass: ");
            sb.append(aVar.b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(aVar.b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f, float f2) {
        float memoryClass = activityManager.getMemoryClass() * Eclipse.HasTypeAnnotations;
        if (e(activityManager)) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String f(int i) {
        return Formatter.formatFileSize(this.c, i);
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.a;
    }

    public int d() {
        return this.b;
    }
}
