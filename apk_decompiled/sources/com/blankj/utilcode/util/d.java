package com.blankj.utilcode.util;

import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        return b(bArr, true);
    }

    public static String b(byte[] bArr, boolean z) {
        if (bArr == null) {
            return Constants.STR_EMPTY;
        }
        char[] cArr = z ? a : b;
        int length = bArr.length;
        if (length <= 0) {
            return Constants.STR_EMPTY;
        }
        char[] cArr2 = new char[length << 1];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b2 >> 4) & 15];
            i += 2;
            cArr2[i2] = cArr[b2 & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS];
        }
        return new String(cArr2);
    }

    public static int c(float f) {
        return q.e(f);
    }

    private static int d(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c < 'A' || c > 'F') {
            throw new IllegalArgumentException();
        }
        return c - '7';
    }

    public static byte[] e(String str) {
        if (q.H(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            str = "0" + str;
            length++;
        }
        char[] charArray = str.toUpperCase().toCharArray();
        byte[] bArr = new byte[length >> 1];
        for (int i = 0; i < length; i += 2) {
            bArr[i >> 1] = (byte) ((d(charArray[i]) << 4) | d(charArray[i + 1]));
        }
        return bArr;
    }

    public static int f(float f) {
        return q.L(f);
    }

    public static int g(float f) {
        return q.P(f);
    }
}
