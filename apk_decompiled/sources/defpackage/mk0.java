package defpackage;

import lombok.javac.Javac;

/* JADX INFO: loaded from: classes.dex */
abstract class mk0 {
    private static final float[] a = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f};

    static float a(boolean z, long j, int i, boolean z2, int i2) {
        if (j == 0) {
            return z ? -0.0f : 0.0f;
        }
        if (!z2) {
            if (-45 > i || i > 38) {
                return Float.NaN;
            }
            return c(z, j, i);
        }
        if (-45 > i2 || i2 > 38) {
            return Float.NaN;
        }
        float fC = c(z, j, i2);
        float fC2 = c(z, j + 1, i2);
        if (Float.isNaN(fC) || fC2 != fC) {
            return Float.NaN;
        }
        return fC;
    }

    static float b(boolean z, long j, int i, boolean z2, int i2) {
        if (j == 0) {
            return z ? -0.0f : 0.0f;
        }
        if (!z2) {
            if (-126 > i || i > 127) {
                return Float.NaN;
            }
            return d(z, j, i);
        }
        if (-126 > i2 || i2 > 127) {
            return Float.NaN;
        }
        float fD = d(z, j, i2);
        float fD2 = d(z, j + 1, i2);
        if (Double.isNaN(fD) || fD2 != fD) {
            return Float.NaN;
        }
        return fD;
    }

    static float c(boolean z, long j, int i) {
        if (-10 <= i && i <= 10 && Long.compareUnsigned(j, 16777215L) <= 0) {
            float f = j;
            float f2 = i < 0 ? f / a[-i] : f * a[i];
            return z ? -f2 : f2;
        }
        int i2 = i + 325;
        long j2 = jk0.a[i2];
        long j3 = ((((long) i) * 217706) >> 16) + 191;
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j);
        long j4 = j << iNumberOfLeadingZeros;
        jk0.b bVarA = jk0.a(j4, j2);
        long j5 = bVarA.b;
        long j6 = bVarA.a;
        if ((j6 & 274877906943L) == 274877906943L && Long.compareUnsigned(j5 + j4, j5) < 0) {
            jk0.b bVarA2 = jk0.a(j4, jk0.b[i2]);
            long j7 = bVarA2.b;
            long j8 = bVarA2.a + j5;
            if (Long.compareUnsigned(j8, j5) < 0) {
                j6++;
            }
            if (j8 + 1 == 0 && (j6 & 549755813887L) == 549755813887L && j7 + ((long) Long.compareUnsigned(j4, j7)) < 0) {
                return Float.NaN;
            }
        }
        long j9 = j6 >>> 63;
        long j10 = j6 >>> ((int) (38 + j9));
        int i3 = iNumberOfLeadingZeros + ((int) (j9 ^ 1));
        long j11 = j6 & 274877906943L;
        if (j11 == 274877906943L || (j11 == 0 && (3 & j10) == 1)) {
            return Float.NaN;
        }
        long j12 = (j10 + 1) >>> 1;
        if (j12 >= Javac.GENERATED_MEMBER) {
            i3--;
            j12 = 8388608;
        }
        long j13 = j12 & (-8388609);
        long j14 = j3 - ((long) i3);
        if (j14 < 1 || j14 > 254) {
            return Float.NaN;
        }
        return Float.intBitsToFloat((int) ((j14 << 23) | j13 | (z ? 2147483648L : 0L)));
    }

    static float d(boolean z, long j, int i) {
        if (j == 0 || i < -180) {
            return z ? -0.0f : 0.0f;
        }
        if (i > 127) {
            return z ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
        }
        if (Long.compareUnsigned(j, 9007199254740991L) > 0) {
            return Float.NaN;
        }
        float fScalb = j * Math.scalb(1.0f, i);
        return z ? -fScalb : fScalb;
    }
}
