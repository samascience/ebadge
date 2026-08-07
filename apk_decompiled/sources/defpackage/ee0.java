package defpackage;

import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes4.dex */
abstract class ee0 {
    public static final long a(long j, DurationUnit durationUnit, DurationUnit durationUnit2) {
        p31.f(durationUnit, "sourceUnit");
        p31.f(durationUnit2, "targetUnit");
        return durationUnit2.getTimeUnit$kotlin_stdlib().convert(j, durationUnit.getTimeUnit$kotlin_stdlib());
    }

    public static final long b(long j, DurationUnit durationUnit, DurationUnit durationUnit2) {
        p31.f(durationUnit, "sourceUnit");
        p31.f(durationUnit2, "targetUnit");
        return durationUnit2.getTimeUnit$kotlin_stdlib().convert(j, durationUnit.getTimeUnit$kotlin_stdlib());
    }
}
