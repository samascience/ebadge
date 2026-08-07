package defpackage;

import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes3.dex */
public final class wy extends nw1 {
    static final int[][] a;

    static {
        int[] iArr = new int[6];
        // fill-array-data instruction
        iArr[0] = 1;
        iArr[1] = 2;
        iArr[2] = 2;
        iArr[3] = 2;
        iArr[4] = 3;
        iArr[5] = 1;
        a = new int[][]{new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, iArr, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    }

    private static int h(uh uhVar, int[] iArr, int i) throws NotFoundException {
        nw1.f(uhVar, i, iArr);
        float f = 0.25f;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = a;
            if (i3 >= iArr2.length) {
                break;
            }
            float fE = nw1.e(iArr, iArr2[i3], 0.7f);
            if (fE < f) {
                i2 = i3;
                f = fE;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int[] i(uh uhVar) throws NotFoundException {
        int iG = uhVar.g();
        int iE = uhVar.e(0);
        int[] iArr = new int[6];
        boolean z = false;
        int i = 0;
        int i2 = iE;
        while (iE < iG) {
            if (uhVar.c(iE) ^ z) {
                iArr[i] = iArr[i] + 1;
            } else {
                if (i == 5) {
                    int i3 = -1;
                    float f = 0.25f;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float fE = nw1.e(iArr, a[i4], 0.7f);
                        if (fE < f) {
                            i3 = i4;
                            f = fE;
                        }
                    }
                    if (i3 >= 0 && uhVar.h(Math.max(0, i2 - ((iE - i2) / 2)), i2, false)) {
                        return new int[]{i2, iE, i3};
                    }
                    i2 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, 4);
                    iArr[4] = 0;
                    iArr[5] = 0;
                    i--;
                } else {
                    i++;
                }
                iArr[i] = 1;
                z = !z;
            }
            iE++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:101:0x015e  */
    /* JADX WARN: Code duplicated, block: B:102:0x0163  */
    /* JADX WARN: Code duplicated, block: B:103:0x016a  */
    /* JADX WARN: Code duplicated, block: B:104:0x016d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0174 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x0176  */
    /* JADX WARN: Code duplicated, block: B:109:0x0178  */
    /* JADX WARN: Code duplicated, block: B:138:0x0187 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:0x0179 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x0059  */
    /* JADX WARN: Code duplicated, block: B:19:0x0069  */
    /* JADX WARN: Code duplicated, block: B:21:0x006d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0078 A[LOOP:1: B:23:0x0076->B:24:0x0078, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x0082  */
    /* JADX WARN: Code duplicated, block: B:29:0x008a  */
    /* JADX WARN: Code duplicated, block: B:31:0x008e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0090  */
    /* JADX WARN: Code duplicated, block: B:33:0x0097  */
    /* JADX WARN: Code duplicated, block: B:35:0x009e A[PHI: r3 r5 r16 r20
      0x009e: PHI (r3v7 boolean) = 
      (r3v1 boolean)
      (r3v1 boolean)
      (r3v1 boolean)
      (r3v1 boolean)
      (r3v1 boolean)
      (r3v1 boolean)
      (r3v14 boolean)
      (r3v15 boolean)
      (r3v16 boolean)
      (r3v17 boolean)
      (r3v1 boolean)
      (r3v1 boolean)
      (r3v1 boolean)
      (r3v1 boolean)
     binds: [B:27:0x0086, B:70:0x010e, B:72:0x0112, B:76:0x011e, B:75:0x011a, B:62:0x00f3, B:57:0x00df, B:56:0x00dc, B:53:0x00d5, B:34:0x009d, B:44:0x00bb, B:46:0x00bf, B:50:0x00cb, B:49:0x00c7] A[DONT_GENERATE, DONT_INLINE]
      0x009e: PHI (r5v11 boolean) = 
      (r5v2 boolean)
      (r5v2 boolean)
      (r5v2 boolean)
      (r5v2 boolean)
      (r5v2 boolean)
      (r5v2 boolean)
      (r5v2 boolean)
      (r5v14 boolean)
      (r5v15 boolean)
      (r5v2 boolean)
      (r5v2 boolean)
      (r5v2 boolean)
      (r5v2 boolean)
      (r5v2 boolean)
     binds: [B:27:0x0086, B:70:0x010e, B:72:0x0112, B:76:0x011e, B:75:0x011a, B:62:0x00f3, B:57:0x00df, B:56:0x00dc, B:53:0x00d5, B:34:0x009d, B:44:0x00bb, B:46:0x00bf, B:50:0x00cb, B:49:0x00c7] A[DONT_GENERATE, DONT_INLINE]
      0x009e: PHI (r16v2 boolean) = 
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v5 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
      (r16v1 boolean)
     binds: [B:27:0x0086, B:70:0x010e, B:72:0x0112, B:76:0x011e, B:75:0x011a, B:62:0x00f3, B:57:0x00df, B:56:0x00dc, B:53:0x00d5, B:34:0x009d, B:44:0x00bb, B:46:0x00bf, B:50:0x00cb, B:49:0x00c7] A[DONT_GENERATE, DONT_INLINE]
      0x009e: PHI (r20v3 boolean) = 
      (r20v2 boolean)
      (r20v9 boolean)
      (r20v9 boolean)
      (r20v9 boolean)
      (r20v9 boolean)
      (r20v11 boolean)
      (r20v14 boolean)
      (r20v15 boolean)
      (r20v16 boolean)
      (r20v2 boolean)
      (r20v17 boolean)
      (r20v17 boolean)
      (r20v17 boolean)
      (r20v17 boolean)
     binds: [B:27:0x0086, B:70:0x010e, B:72:0x0112, B:76:0x011e, B:75:0x011a, B:62:0x00f3, B:57:0x00df, B:56:0x00dc, B:53:0x00d5, B:34:0x009d, B:44:0x00bb, B:46:0x00bf, B:50:0x00cb, B:49:0x00c7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:46:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:53:0x00d5 A[PHI: r20
      0x00d5: PHI (r20v16 boolean) = (r20v9 boolean), (r20v17 boolean) binds: [B:81:0x012d, B:52:0x00d3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:55:0x00da A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:56:0x00dc A[PHI: r20
      0x00dc: PHI (r20v15 boolean) = (r20v9 boolean), (r20v17 boolean) binds: [B:84:0x0132, B:55:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:57:0x00df A[PHI: r20
      0x00df: PHI (r20v14 boolean) = (r20v9 boolean), (r20v9 boolean), (r20v17 boolean), (r20v17 boolean) binds: [B:83:0x0130, B:84:0x0132, B:54:0x00d8, B:55:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e8 A[PHI: r20
      0x00e8: PHI (r20v12 boolean) = (r20v9 boolean), (r20v17 boolean) binds: [B:70:0x010e, B:44:0x00bb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:61:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f3 A[PHI: r20
      0x00f3: PHI (r20v11 boolean) = (r20v9 boolean), (r20v17 boolean) binds: [B:69:0x010c, B:43:0x00b9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:63:0x00f6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x00f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:66:0x0101  */
    /* JADX WARN: Code duplicated, block: B:67:0x0108 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x010a  */
    /* JADX WARN: Code duplicated, block: B:70:0x010e  */
    /* JADX WARN: Code duplicated, block: B:72:0x0112  */
    /* JADX WARN: Code duplicated, block: B:73:0x0114  */
    /* JADX WARN: Code duplicated, block: B:75:0x011a  */
    /* JADX WARN: Code duplicated, block: B:76:0x011e  */
    /* JADX WARN: Code duplicated, block: B:77:0x0125  */
    /* JADX WARN: Code duplicated, block: B:78:0x0127 A[PHI: r10 r20
      0x0127: PHI (r10v7 char) = (r10v5 char), (r10v9 char) binds: [B:96:0x0151, B:77:0x0125] A[DONT_GENERATE, DONT_INLINE]
      0x0127: PHI (r20v8 boolean) = (r20v5 boolean), (r20v9 boolean) binds: [B:96:0x0151, B:77:0x0125] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:80:0x012b  */
    /* JADX WARN: Code duplicated, block: B:81:0x012d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:84:0x0132 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:86:0x0135  */
    /* JADX WARN: Code duplicated, block: B:87:0x0139  */
    /* JADX WARN: Code duplicated, block: B:89:0x013d  */
    /* JADX WARN: Code duplicated, block: B:91:0x0141  */
    /* JADX WARN: Code duplicated, block: B:93:0x014b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x014d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0151  */
    /* JADX WARN: Code duplicated, block: B:98:0x0156  */
    /* JADX WARN: Code duplicated, block: B:99:0x0158  */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:87:0x0139
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.nw1
    public defpackage.kh2 c(int r26, defpackage.uh r27, java.util.Map r28) {
        /*
            Method dump skipped, instruction units count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wy.c(int, uh, java.util.Map):kh2");
    }
}
