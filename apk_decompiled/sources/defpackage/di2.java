package defpackage;

import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* JADX INFO: loaded from: classes.dex */
public final class di2 {
    private static di2 b;
    private static final RootTelemetryConfiguration c = new RootTelemetryConfiguration(0, false, false, 0, 0);
    private RootTelemetryConfiguration a;

    private di2() {
    }

    public static synchronized di2 a() {
        try {
            if (b == null) {
                b = new di2();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    public final synchronized void b(RootTelemetryConfiguration rootTelemetryConfiguration) {
        try {
            if (rootTelemetryConfiguration == null) {
                this.a = c;
                return;
            }
            RootTelemetryConfiguration rootTelemetryConfiguration2 = this.a;
            if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.J0() < rootTelemetryConfiguration.J0()) {
                this.a = rootTelemetryConfiguration;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
