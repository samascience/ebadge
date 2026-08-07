package com.jieli.jl_rcsp.util;

import android.text.TextUtils;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.tencent.connect.common.Constants;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class CHexConver {
    public static final String b = "0123456789ABCDEF";
    public static final char[] a = b.toCharArray();

    public static String a(char c) {
        if (c == '0') {
            return "0000";
        }
        if (c == '1') {
            return "0001";
        }
        if (c == '2') {
            return "0010";
        }
        if (c == '3') {
            return "0011";
        }
        if (c == '4') {
            return "0100";
        }
        if (c == '5') {
            return "0101";
        }
        if (c == '6') {
            return "0110";
        }
        if (c == '7') {
            return "0111";
        }
        if (c == '8') {
            return Constants.DEFAULT_UIN;
        }
        if (c == '9') {
            return "1001";
        }
        if (c == 'A' || c == 'a') {
            return "1010";
        }
        if (c == 'B' || c == 'b') {
            return "1011";
        }
        if (c == 'C' || c == 'c') {
            return "1100";
        }
        if (c == 'D' || c == 'd') {
            return "1101";
        }
        if (c == 'E' || c == 'e') {
            return "1110";
        }
        return (c == 'F' || c == 'f') ? "1111" : Constants.STR_EMPTY;
    }

    public static String byte2HexStr(byte[] bArr) {
        return bArr == null ? Constants.STR_EMPTY : byte2HexStr(bArr, bArr.length);
    }

    public static String byte2String(byte[] bArr, int i) {
        if (bArr == null) {
            return Constants.STR_EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(String.valueOf((int) bArr[i2]));
        }
        return sb.toString();
    }

    public static String byteToBit(byte b2) {
        return Constants.STR_EMPTY + ((int) ((byte) ((b2 >> 7) & 1))) + ((int) ((byte) ((b2 >> 6) & 1))) + ((int) ((byte) ((b2 >> 5) & 1))) + ((int) ((byte) ((b2 >> 4) & 1))) + ((int) ((byte) ((b2 >> 3) & 1))) + ((int) ((byte) ((b2 >> 2) & 1))) + ((int) ((byte) ((b2 >> 1) & 1))) + ((int) ((byte) (b2 & 1)));
    }

    public static String byteToHexString(byte b2) {
        return intToHexString(b2 & 255);
    }

    public static int byteToInt(byte b2) {
        return b2 & 255;
    }

    public static int bytesLittleToInt(byte[] bArr, int i, int i2) {
        if (i2 == 4) {
            return (bArr[i] & 255) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
        }
        if (i2 == 2) {
            return bytesToInt(bArr[i + 1], bArr[i]);
        }
        return 0;
    }

    public static int bytesToInt(byte b2, byte b3) {
        return ((b2 & 255) << 8) + (b3 & 255);
    }

    public static long bytesToLong(byte[] bArr, int i, int i2) {
        long j = 0;
        int i3 = 0;
        int i4 = i;
        while (i4 < i + i2) {
            j |= (((long) bArr[i4]) & 255) << (((i2 - 1) - i3) * 8);
            i4++;
            i3++;
        }
        return j;
    }

    public static short bytesToShort(byte b2, byte b3) {
        return (short) bytesToInt(b2, b3);
    }

    public static String bytesToStr(byte[] bArr) {
        return bArr == null ? Constants.STR_EMPTY : hexStr2Str(byte2HexStr(bArr, bArr.length));
    }

    public static boolean checkBitValue(byte b2, int i) {
        return ((b2 >> i) & 1) == 1;
    }

    public static boolean checkHexStr(String str) {
        String upperCase;
        int length;
        if (str == null || (length = (upperCase = str.trim().replace(" ", Constants.STR_EMPTY).toUpperCase(Locale.US)).length()) <= 1 || length % 2 != 0) {
            return false;
        }
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            if (!b.contains(upperCase.substring(i, i2))) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    public static byte decodeBinaryString(String str) {
        if (str == null) {
            return (byte) 0;
        }
        int length = str.length();
        if (length != 4 && length != 8) {
            return (byte) 0;
        }
        int i = (length != 8 || str.charAt(0) == '0') ? Integer.parseInt(str, 2) : Integer.parseInt(str, 2) - 256;
        return (byte) i;
    }

    public static byte decodeHexChar(char c, char c2) {
        String strA = a(c);
        String strA2 = a(c2);
        if (TextUtils.isEmpty(strA)) {
            strA = Constants.STR_EMPTY;
        }
        if (!TextUtils.isEmpty(strA2)) {
            strA = strA + strA2;
        }
        if (TextUtils.isEmpty(strA)) {
            return (byte) 0;
        }
        return decodeBinaryString(strA);
    }

    public static int getBitByPosition(int i, int i2) {
        if (i2 < 0 || i2 >= 32) {
            return 0;
        }
        return (i >> i2) & 1;
    }

    public static byte[] getBooleanArray(byte b2) {
        byte[] bArr = new byte[8];
        for (int i = 7; i >= 0; i--) {
            bArr[i] = (byte) (b2 & 1);
            b2 = (byte) (b2 >> 1);
        }
        return bArr;
    }

    public static byte[] getBooleanArrayBig(byte b2) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) (b2 & 1);
            b2 = (byte) (b2 >> 1);
        }
        return bArr;
    }

    public static String hexDataCovetToAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length == 6) {
            for (int i = 0; i < bArr.length; i++) {
                char[] cArr = a;
                sb.append(cArr[(bArr[i] & 255) >> 4]);
                sb.append(cArr[bArr[i] & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS]);
                if (i != bArr.length - 1) {
                    sb.append(":");
                }
            }
        }
        return sb.toString();
    }

    public static byte[] hexStr2Bytes(String str) {
        if (str == null) {
            return null;
        }
        String upperCase = str.trim().replace(" ", Constants.STR_EMPTY).toUpperCase(Locale.US);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) (Integer.decode("0x" + upperCase.substring(i2, i3) + upperCase.substring(i3, i2 + 2)).intValue() & 255);
        }
        return bArr;
    }

    public static String hexStr2Str(String str) {
        if (str == null) {
            return null;
        }
        String upperCase = str.trim().replace(" ", Constants.STR_EMPTY).toUpperCase(Locale.US);
        char[] charArray = upperCase.toCharArray();
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((b.indexOf(charArray[i2 + 1]) | (b.indexOf(charArray[i2]) << 4)) & 255);
        }
        try {
            return new String(bArr, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Constants.STR_EMPTY;
        }
    }

    public static String int2HexStr(int[] iArr, int i) {
        if (iArr == null) {
            return Constants.STR_EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            char[] cArr = a;
            sb.append(cArr[(((byte) iArr[i2]) & 255) >> 4]);
            sb.append(cArr[((byte) iArr[i2]) & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS]);
        }
        return sb.toString().trim().toUpperCase(Locale.US);
    }

    public static byte[] int2byte2(int i) {
        return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] intToBigBytes(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte intToByte(int i) {
        return (byte) i;
    }

    public static byte[] intToBytes(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static String intToHexString(int i) {
        return String.format(Locale.ENGLISH, "%02x", Integer.valueOf(i));
    }

    public static byte setBitValue(byte b2, int i, boolean z) {
        int i2 = 1 << i;
        return (byte) (z ? b2 | i2 : b2 & (~i2));
    }

    public static byte[] shortToBigBytes(short s) {
        return new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)};
    }

    public static byte[] shortToBytes(short s) {
        return new byte[]{(byte) (s & 255), (byte) ((s >> 8) & 255)};
    }

    public static String str2HexStr(String str) {
        byte[] bytes = null;
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            bytes = str.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (bytes == null) {
            return Constants.STR_EMPTY;
        }
        for (byte b2 : bytes) {
            char[] cArr = a;
            sb.append(cArr[(b2 & 255) >> 4]);
            sb.append(cArr[b2 & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS]);
        }
        return sb.toString().trim();
    }

    public static String strToUnicode(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            String hexString = Integer.toHexString(cCharAt);
            if (cCharAt > 128) {
                sb.append("\\u");
            } else {
                sb.append("\\u00");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String unicodeToString(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length() / 6;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < length) {
            int i2 = i * 6;
            i++;
            String strSubstring = str.substring(i2, i * 6);
            sb.append(new String(Character.toChars(Integer.valueOf(strSubstring.substring(4), 16).intValue() | (Integer.valueOf(strSubstring.substring(2, 4), 16).intValue() << 8))));
        }
        return sb.toString();
    }

    public static int bytesToInt(byte[] bArr, int i, int i2) {
        if (i2 == 4) {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bytesToInt(bArr2);
        }
        if (i2 == 2) {
            return bytesToInt(bArr[i], bArr[i + 1]);
        }
        return 0;
    }

    public static short bytesToShort(byte[] bArr, int i) {
        return (short) bytesToInt(bArr, i, 2);
    }

    public static String byte2HexStr(byte[] bArr, int i) {
        if (bArr == null) {
            return Constants.STR_EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            char[] cArr = a;
            sb.append(cArr[(bArr[i2] & 255) >> 4]);
            sb.append(cArr[bArr[i2] & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS]);
            sb.append(" ");
        }
        return sb.toString().trim().toUpperCase(Locale.US);
    }

    public static int bytesToInt(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return 0;
        }
        return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }
}
