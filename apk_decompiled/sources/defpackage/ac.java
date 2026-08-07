package defpackage;

import android.media.AudioTimestamp;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class ac {
    public static int a(int i) {
        return i == 1 ? 16 : 12;
    }

    public static int b(int i) {
        return i == 1 ? 16 : 12;
    }

    public static long c(int i, long j, AudioTimestamp audioTimestamp) {
        b52.b(((long) i) > 0, "sampleRate must be greater than 0.");
        b52.b(j >= 0, "framePosition must be no less than 0.");
        long jD = audioTimestamp.nanoTime + d(j - audioTimestamp.framePosition, i);
        if (jD < 0) {
            return 0L;
        }
        return jD;
    }

    public static long d(long j, int i) {
        long j2 = i;
        b52.b(j2 > 0, "sampleRate must be greater than 0.");
        return (TimeUnit.SECONDS.toNanos(1L) * j) / j2;
    }

    public static long e(long j, int i) {
        long j2 = i;
        b52.b(j2 > 0, "bytesPerFrame must be greater than 0.");
        return j * j2;
    }

    public static int f(int i, int i2) {
        b52.b(i2 > 0, "Invalid channel count: " + i2);
        if (i == 2) {
            return i2 * 2;
        }
        if (i == 3) {
            return i2;
        }
        if (i != 4) {
            if (i == 21) {
                return i2 * 3;
            }
            if (i != 22) {
                throw new IllegalArgumentException("Invalid audio encoding: " + i);
            }
        }
        return i2 * 4;
    }

    public static long g(long j, int i) {
        long j2 = i;
        b52.b(j2 > 0, "bytesPerFrame must be greater than 0.");
        return j / j2;
    }
}
