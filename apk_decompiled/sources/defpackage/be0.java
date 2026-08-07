package defpackage;

import kotlin.text.i;
import kotlin.time.DurationUnit;
import lombok.javac.Javac;

/* JADX INFO: loaded from: classes4.dex */
public abstract class be0 implements Comparable {
    public static final a a = new a(null);
    private static final long b = e(0);
    private static final long c = de0.e(4611686018427387903L);
    private static final long d = de0.e(-4611686018427387903L);

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final long a() {
            return be0.c;
        }

        public final long b() {
            return be0.b;
        }

        private a() {
        }
    }

    private static final void c(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String strH0 = i.h0(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = strH0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (strH0.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (z || i6 >= 3) {
                sb.append((CharSequence) strH0, 0, ((i4 + 3) / 3) * 3);
                p31.e(sb, "append(...)");
            } else {
                sb.append((CharSequence) strH0, 0, i6);
                p31.e(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    public static int d(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return p31.h(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return v(j) ? -i : i;
    }

    public static long e(long j) {
        if (ce0.a()) {
            if (t(j)) {
                long jQ = q(j);
                if (-4611686018426999999L > jQ || jQ >= 4611686018427000000L) {
                    throw new AssertionError(q(j) + " ns is out of nanoseconds range");
                }
            } else {
                long jQ2 = q(j);
                if (-4611686018427387903L > jQ2 || jQ2 >= Javac.SEALED) {
                    throw new AssertionError(q(j) + " ms is out of milliseconds range");
                }
                long jQ3 = q(j);
                if (-4611686018426L <= jQ3 && jQ3 < 4611686018427L) {
                    throw new AssertionError(q(j) + " ms is denormalized");
                }
            }
        }
        return j;
    }

    public static final long f(long j) {
        return v(j) ? y(j) : j;
    }

    public static final int g(long j) {
        if (u(j)) {
            return 0;
        }
        return (int) (i(j) % ((long) 24));
    }

    public static final long h(long j) {
        return w(j, DurationUnit.DAYS);
    }

    public static final long i(long j) {
        return w(j, DurationUnit.HOURS);
    }

    public static final long j(long j) {
        return (s(j) && r(j)) ? q(j) : w(j, DurationUnit.MILLISECONDS);
    }

    public static final long k(long j) {
        return w(j, DurationUnit.MINUTES);
    }

    public static final long l(long j) {
        return w(j, DurationUnit.SECONDS);
    }

    public static final int m(long j) {
        if (u(j)) {
            return 0;
        }
        return (int) (k(j) % ((long) 60));
    }

    public static final int n(long j) {
        if (u(j)) {
            return 0;
        }
        return (int) (s(j) ? de0.g(q(j) % ((long) 1000)) : q(j) % ((long) 1000000000));
    }

    public static final int o(long j) {
        if (u(j)) {
            return 0;
        }
        return (int) (l(j) % ((long) 60));
    }

    private static final DurationUnit p(long j) {
        return t(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    private static final long q(long j) {
        return j >> 1;
    }

    public static final boolean r(long j) {
        return !u(j);
    }

    private static final boolean s(long j) {
        return (((int) j) & 1) == 1;
    }

    private static final boolean t(long j) {
        return (((int) j) & 1) == 0;
    }

    public static final boolean u(long j) {
        return j == c || j == d;
    }

    public static final boolean v(long j) {
        return j < 0;
    }

    public static final long w(long j, DurationUnit durationUnit) {
        p31.f(durationUnit, "unit");
        if (j == c) {
            return Long.MAX_VALUE;
        }
        if (j == d) {
            return Long.MIN_VALUE;
        }
        return ee0.a(q(j), p(j), durationUnit);
    }

    public static String x(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == c) {
            return "Infinity";
        }
        if (j == d) {
            return "-Infinity";
        }
        boolean zV = v(j);
        StringBuilder sb = new StringBuilder();
        if (zV) {
            sb.append('-');
        }
        long jF = f(j);
        long jH = h(jF);
        int iG = g(jF);
        int iM = m(jF);
        int iO = o(jF);
        int iN = n(jF);
        int i = 0;
        boolean z = jH != 0;
        boolean z2 = iG != 0;
        boolean z3 = iM != 0;
        boolean z4 = (iO == 0 && iN == 0) ? false : true;
        if (z) {
            sb.append(jH);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iG);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (iO != 0 || z || z2 || z3) {
                c(j, sb, iO, iN, 9, "s", false);
            } else if (iN >= 1000000) {
                c(j, sb, iN / 1000000, iN % 1000000, 6, "ms", false);
            } else if (iN >= 1000) {
                c(j, sb, iN / 1000, iN % 1000, 3, "us", false);
            } else {
                sb.append(iN);
                sb.append("ns");
            }
            i = i4;
        }
        if (zV && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    public static final long y(long j) {
        return de0.d(-q(j), ((int) j) & 1);
    }
}
