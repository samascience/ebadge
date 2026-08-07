package defpackage;

import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes4.dex */
public abstract class de0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long d(long j, int i) {
        return be0.e((j << 1) + ((long) i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long e(long j) {
        return be0.e((j << 1) + 1);
    }

    private static final long f(long j) {
        return be0.e(j << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long g(long j) {
        return j * ((long) 1000000);
    }

    public static final long h(long j, DurationUnit durationUnit) {
        p31.f(durationUnit, "unit");
        DurationUnit durationUnit2 = DurationUnit.NANOSECONDS;
        long jB = ee0.b(4611686018426999999L, durationUnit2, durationUnit);
        return ((-jB) > j || j > jB) ? e(ga2.h(ee0.a(j, durationUnit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L)) : f(ee0.b(j, durationUnit, durationUnit2));
    }
}
