package defpackage;

import kotlin.text.a;

/* JADX INFO: loaded from: classes4.dex */
public abstract class u83 {
    public static final int a(long j, long j2) {
        return p31.h(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    public static final String b(long j, int i) {
        if (j >= 0) {
            String string = Long.toString(j, a.a(i));
            p31.e(string, "toString(...)");
            return string;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j3, a.a(i));
        p31.e(string2, "toString(...)");
        sb.append(string2);
        String string3 = Long.toString(j4, a.a(i));
        p31.e(string3, "toString(...)");
        sb.append(string3);
        return sb.toString();
    }
}
