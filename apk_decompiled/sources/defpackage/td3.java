package defpackage;

import android.os.Build;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.x;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public class td3 {
    private final c33 a;
    private final Timebase b;
    private final bv c;
    private long d = -1;
    private Timebase e;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Timebase.values().length];
            a = iArr;
            try {
                iArr[Timebase.REALTIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Timebase.UPTIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public td3(c33 c33Var, Timebase timebase, bv bvVar) {
        this.a = c33Var;
        this.b = timebase;
        this.c = bvVar;
    }

    private long a() {
        long j = Long.MAX_VALUE;
        long j2 = 0;
        for (int i = 0; i < 3; i++) {
            long jA = this.a.a();
            long jB = this.a.b();
            long jA2 = this.a.a();
            long j3 = jA2 - jA;
            if (i == 0 || j3 < j) {
                j2 = jB - ((jA + jA2) >> 1);
                j = j3;
            }
        }
        return Math.max(0L, j2);
    }

    private boolean c() {
        return this.a.b() - this.a.a() > 3000000;
    }

    private boolean d(long j) {
        return Math.abs(j - this.a.b()) < Math.abs(j - this.a.a());
    }

    private Timebase e(long j) {
        boolean z;
        String str;
        if (this.c != null) {
            x.k("VideoTimebaseConverter", "CameraUseInconsistentTimebaseQuirk is enabled");
            z = false;
        } else {
            if (!c()) {
                return this.b;
            }
            z = true;
        }
        Timebase timebase = d(j) ? Timebase.REALTIME : Timebase.UPTIME;
        if (!z || timebase == this.b) {
            x.a("VideoTimebaseConverter", "Detect input timebase = " + timebase);
        } else {
            int i = Build.VERSION.SDK_INT;
            if (i >= 31) {
                str = ", SOC: " + Build.SOC_MODEL;
            } else {
                str = Constants.STR_EMPTY;
            }
            x.c("VideoTimebaseConverter", String.format("Detected camera timebase inconsistent. Please file an issue at https://issuetracker.google.com/issues/new?component=618491&template=1257717 with this error message [Manufacturer: %s, Model: %s, Hardware: %s, API Level: %d%s].\nCamera timebase is inconsistent. The timebase reported by the camera is %s, but the actual timebase contained in the frame is detected as %s.", Build.MANUFACTURER, Build.MODEL, Build.HARDWARE, Integer.valueOf(i), str, this.b, timebase));
        }
        return timebase;
    }

    public long b(long j) {
        if (this.e == null) {
            this.e = e(j);
        }
        int i = a.a[this.e.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return j;
            }
            throw new AssertionError("Unknown timebase: " + this.e);
        }
        if (this.d == -1) {
            this.d = a();
            x.a("VideoTimebaseConverter", "mUptimeToRealtimeOffsetUs = " + this.d);
        }
        return j - this.d;
    }
}
