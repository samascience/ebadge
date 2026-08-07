package defpackage;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class qz2 implements c33 {
    @Override // defpackage.c33
    public long a() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime());
    }

    @Override // defpackage.c33
    public long b() {
        return TimeUnit.NANOSECONDS.toMicros(SystemClock.elapsedRealtimeNanos());
    }
}
