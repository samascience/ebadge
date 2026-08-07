package com.legend.mywatch.sdk.mywatchsdklib.android.utils;

import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.tencent.connect.common.Constants;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
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

    public static String c(byte[] bArr) {
        return d(bArr, Constants.STR_EMPTY);
    }

    public static String d(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, e(str));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new String(bArr);
        }
    }

    private static String e(String str) {
        return (k.p(str) || !Charset.isSupported(str)) ? Constants.ENC_UTF_8 : str;
    }

    private static int f(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c < 'A' || c > 'F') {
            throw new IllegalArgumentException();
        }
        return c - '7';
    }

    public static byte[] g(String str) {
        if (k.p(str)) {
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
            bArr[i >> 1] = (byte) ((f(charArray[i]) << 4) | f(charArray[i + 1]));
        }
        return bArr;
    }
}
