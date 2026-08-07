package kotlin.collections;

import defpackage.p31;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class g extends f {
    public static List c(Object[] objArr) {
        p31.f(objArr, "<this>");
        List listA = i.a(objArr);
        p31.e(listA, "asList(...)");
        return listA;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        p31.f(bArr, "<this>");
        p31.f(bArr2, "destination");
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    public static int[] e(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        p31.f(iArr, "<this>");
        p31.f(iArr2, "destination");
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
        return iArr2;
    }

    public static long[] f(long[] jArr, long[] jArr2, int i, int i2, int i3) {
        p31.f(jArr, "<this>");
        p31.f(jArr2, "destination");
        System.arraycopy(jArr, i2, jArr2, i, i3 - i2);
        return jArr2;
    }

    public static Object[] g(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        p31.f(objArr, "<this>");
        p31.f(objArr2, "destination");
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
        return objArr2;
    }

    public static /* synthetic */ byte[] h(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return d.d(bArr, bArr2, i, i2, i3);
    }

    public static /* synthetic */ int[] i(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length;
        }
        return d.e(iArr, iArr2, i, i2, i3);
    }

    public static /* synthetic */ Object[] j(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return d.g(objArr, objArr2, i, i2, i3);
    }

    public static byte[] k(byte[] bArr, int i, int i2) {
        p31.f(bArr, "<this>");
        e.b(i2, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2);
        p31.e(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static Object[] l(Object[] objArr, int i, int i2) {
        p31.f(objArr, "<this>");
        e.b(i2, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i, i2);
        p31.e(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static void m(Object[] objArr, Object obj, int i, int i2) {
        p31.f(objArr, "<this>");
        Arrays.fill(objArr, i, i2, obj);
    }

    public static /* synthetic */ void n(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        d.m(objArr, obj, i, i2);
    }

    public static byte[] o(byte[] bArr, byte[] bArr2) {
        p31.f(bArr, "<this>");
        p31.f(bArr2, "elements");
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, bArrCopyOf, length, length2);
        p31.c(bArrCopyOf);
        return bArrCopyOf;
    }

    public static final void p(Object[] objArr, Comparator comparator) {
        p31.f(objArr, "<this>");
        p31.f(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }
}
