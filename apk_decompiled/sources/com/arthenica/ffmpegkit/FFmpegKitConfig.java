package com.arthenica.ffmpegkit;

import android.util.Log;
import android.util.SparseArray;
import defpackage.ad1;
import defpackage.e43;
import defpackage.in2;
import defpackage.mi0;
import defpackage.sh2;
import defpackage.vt2;
import defpackage.wt2;
import defpackage.yj0;
import defpackage.za;
import defpackage.zc1;
import defpackage.zj0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class FFmpegKitConfig {
    private static final AtomicInteger a;
    private static Level b;
    private static int c;
    private static final Map d;
    private static final List e;
    private static final Object f;
    private static int g;
    private static ExecutorService h;
    private static ad1 i;
    private static wt2 j;
    private static zj0 k;
    private static final SparseArray l;
    private static final SparseArray m;
    private static LogRedirectionStrategy n;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Level.values().length];
            b = iArr;
            try {
                iArr[Level.AV_LOG_QUIET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Level.AV_LOG_TRACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Level.AV_LOG_DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Level.AV_LOG_INFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[Level.AV_LOG_WARNING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[Level.AV_LOG_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[Level.AV_LOG_FATAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[Level.AV_LOG_PANIC.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[Level.AV_LOG_STDERR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[Level.AV_LOG_VERBOSE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[LogRedirectionStrategy.values().length];
            a = iArr2;
            try {
                iArr2[LogRedirectionStrategy.NEVER_PRINT_LOGS.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[LogRedirectionStrategy.PRINT_LOGS_WHEN_GLOBAL_CALLBACK_NOT_DEFINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[LogRedirectionStrategy.PRINT_LOGS_WHEN_SESSION_CALLBACK_NOT_DEFINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[LogRedirectionStrategy.PRINT_LOGS_WHEN_NO_CALLBACKS_DEFINED.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[LogRedirectionStrategy.ALWAYS_PRINT_LOGS.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    static {
        mi0.b("com.arthenica");
        Log.i("ffmpeg-kit", "Loading ffmpeg-kit.");
        c.f(c.e());
        a = new AtomicInteger(1);
        b = Level.from(c.j());
        g = 10;
        h = Executors.newFixedThreadPool(10);
        c = 10;
        d = new LinkedHashMap<Long, in2>() { // from class: com.arthenica.ffmpegkit.FFmpegKitConfig.1
            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<Long, in2> entry) {
                return size() > FFmpegKitConfig.c;
            }
        };
        e = new LinkedList();
        f = new Object();
        i = null;
        j = null;
        k = null;
        l = new SparseArray();
        m = new SparseArray();
        n = LogRedirectionStrategy.PRINT_LOGS_WHEN_NO_CALLBACKS_DEFINED;
        Log.i("ffmpeg-kit", String.format("Loaded ffmpeg-kit-%s-%s-%s-%s.", c.l(), c.c(), c.m(), c.d()));
    }

    static void b(in2 in2Var) {
        synchronized (f) {
            try {
                Map map = d;
                if (!map.containsKey(Long.valueOf(in2Var.e()))) {
                    map.put(Long.valueOf(in2Var.e()), in2Var);
                    e.add(in2Var);
                    e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String c(String[] strArr) {
        if (strArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (i2 > 0) {
                sb.append(" ");
            }
            sb.append(strArr[i2]);
        }
        return sb.toString();
    }

    public static void d(yj0 yj0Var) {
        yj0Var.p(h.submit(new za(yj0Var)));
    }

    private static native void disableNativeRedirection();

    private static void e() {
        while (true) {
            List list = e;
            if (list.size() <= c) {
                return;
            }
            try {
                in2 in2Var = (in2) list.remove(0);
                if (in2Var != null) {
                    d.remove(Long.valueOf(in2Var.e()));
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }

    private static native void enableNativeRedirection();

    public static void f(yj0 yj0Var) {
        yj0Var.q();
        try {
            yj0Var.f(new sh2(nativeFFmpegExecute(yj0Var.e(), yj0Var.j())));
        } catch (Exception e2) {
            yj0Var.g(e2);
            Log.w("ffmpeg-kit", String.format("FFmpeg execute failed: %s.%s", c(yj0Var.j()), mi0.a(e2)));
        }
    }

    public static String g() {
        return getNativeBuildDate();
    }

    private static native String getNativeBuildDate();

    private static native String getNativeFFmpegVersion();

    static native int getNativeLogLevel();

    private static native String getNativeVersion();

    public static zj0 h() {
        return k;
    }

    public static LogRedirectionStrategy i() {
        return n;
    }

    private static native void ignoreNativeSignal(int i2);

    public static in2 j(long j2) {
        in2 in2Var;
        synchronized (f) {
            in2Var = (in2) d.get(Long.valueOf(j2));
        }
        return in2Var;
    }

    public static String k() {
        return l() ? String.format("%s-lts", getNativeVersion()) : getNativeVersion();
    }

    public static boolean l() {
        return AbiDetect.isNativeLTSBuild();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005a A[PHI: r2
      0x005a: PHI (r2v1 com.arthenica.ffmpegkit.LogRedirectionStrategy) = (r2v0 com.arthenica.ffmpegkit.LogRedirectionStrategy), (r2v4 com.arthenica.ffmpegkit.LogRedirectionStrategy) binds: [B:10:0x002f, B:12:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    private static void log(long j2, int i2, byte[] bArr) {
        boolean z;
        Level levelFrom = Level.from(i2);
        String str = new String(bArr);
        zc1 zc1Var = new zc1(j2, levelFrom, str);
        LogRedirectionStrategy logRedirectionStrategyC = n;
        if ((b != Level.AV_LOG_QUIET || i2 == Level.AV_LOG_STDERR.getValue()) && i2 <= b.getValue()) {
            in2 in2VarJ = j(j2);
            boolean z2 = false;
            if (in2VarJ != null) {
                logRedirectionStrategyC = in2VarJ.c();
                in2VarJ.b(zc1Var);
                if (in2VarJ.d() != null) {
                    try {
                        in2VarJ.d().a(zc1Var);
                    } catch (Exception e2) {
                        Log.e("ffmpeg-kit", String.format("Exception thrown inside session log callback.%s", mi0.a(e2)));
                    }
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            ad1 ad1Var = i;
            if (ad1Var != null) {
                try {
                    ad1Var.a(zc1Var);
                } catch (Exception e3) {
                    Log.e("ffmpeg-kit", String.format("Exception thrown inside global log callback.%s", mi0.a(e3)));
                }
                z2 = true;
            }
            int i3 = a.a[logRedirectionStrategyC.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4 && (z2 || z)) {
                            return;
                        }
                    } else if (z) {
                        return;
                    }
                } else if (z2) {
                    return;
                }
                switch (a.b[levelFrom.ordinal()]) {
                    case 1:
                        break;
                    case 2:
                    case 3:
                        Log.d("ffmpeg-kit", str);
                        break;
                    case 4:
                        Log.i("ffmpeg-kit", str);
                        break;
                    case 5:
                        Log.w("ffmpeg-kit", str);
                        break;
                    case 6:
                    case 7:
                    case 8:
                        Log.e("ffmpeg-kit", str);
                        break;
                    default:
                        Log.v("ffmpeg-kit", str);
                        break;
                }
            }
        }
    }

    public static String[] m(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (i2 < str.length()) {
            Character chValueOf = i2 > 0 ? Character.valueOf(str.charAt(i2 - 1)) : null;
            char cCharAt = str.charAt(i2);
            if (cCharAt == ' ') {
                if (z || z2) {
                    sb.append(cCharAt);
                } else if (sb.length() > 0) {
                    arrayList.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else if (cCharAt != '\'' || (chValueOf != null && chValueOf.charValue() == '\\')) {
                if (cCharAt != '\"' || (chValueOf != null && chValueOf.charValue() == '\\')) {
                    sb.append(cCharAt);
                } else if (z2) {
                    z2 = false;
                } else if (z) {
                    sb.append(cCharAt);
                } else {
                    z2 = true;
                }
            } else if (z) {
                z = false;
            } else if (z2) {
                sb.append(cCharAt);
            } else {
                z = true;
            }
            i2++;
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static native int messagesInTransmit(long j2);

    static native void nativeFFmpegCancel(long j2);

    private static native int nativeFFmpegExecute(long j2, String[] strArr);

    static native int nativeFFprobeExecute(long j2, String[] strArr);

    private static native int registerNewNativeFFmpegPipe(String str);

    private static int safClose(int i2) {
        try {
            e43.a(m.get(i2));
            Log.e("ffmpeg-kit", String.format("SAF fd %d not found.", Integer.valueOf(i2)));
            return 0;
        } catch (Throwable th) {
            Log.e("ffmpeg-kit", String.format("Failed to close SAF fd: %d.%s", Integer.valueOf(i2), mi0.a(th)));
            return 0;
        }
    }

    private static int safOpen(int i2) {
        try {
            e43.a(l.get(i2));
            Log.e("ffmpeg-kit", String.format("SAF id %d not found.", Integer.valueOf(i2)));
            return 0;
        } catch (Throwable th) {
            Log.e("ffmpeg-kit", String.format("Failed to open SAF id: %d.%s", Integer.valueOf(i2), mi0.a(th)));
            return 0;
        }
    }

    private static native int setNativeEnvironmentVariable(String str, String str2);

    private static native void setNativeLogLevel(int i2);

    private static void statistics(long j2, int i2, float f2, float f3, long j3, double d2, double d3, double d4) {
        vt2 vt2Var = new vt2(j2, i2, f2, f3, j3, d2, d3, d4);
        in2 in2VarJ = j(j2);
        if (in2VarJ != null && in2VarJ.a()) {
            yj0 yj0Var = (yj0) in2VarJ;
            yj0Var.t(vt2Var);
            if (yj0Var.y() != null) {
                try {
                    yj0Var.y().a(vt2Var);
                } catch (Exception e2) {
                    Log.e("ffmpeg-kit", String.format("Exception thrown inside session statistics callback.%s", mi0.a(e2)));
                }
            }
        }
        wt2 wt2Var = j;
        if (wt2Var != null) {
            try {
                wt2Var.a(vt2Var);
            } catch (Exception e3) {
                Log.e("ffmpeg-kit", String.format("Exception thrown inside global statistics callback.%s", mi0.a(e3)));
            }
        }
    }
}
