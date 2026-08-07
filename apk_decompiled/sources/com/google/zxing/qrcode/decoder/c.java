package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import defpackage.q70;
import defpackage.qv2;
import defpackage.yh;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
abstract class c {
    private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    static q70 a(byte[] bArr, g gVar, ErrorCorrectionLevel errorCorrectionLevel, Map map) throws FormatException {
        Mode mode;
        yh yhVar = new yh(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i = 1;
        ArrayList arrayList = new ArrayList(1);
        int i2 = -1;
        int iD = -1;
        boolean z = false;
        CharacterSetECI characterSetECIByValue = null;
        while (true) {
            try {
                Mode modeForBits = yhVar.a() < 4 ? Mode.TERMINATOR : Mode.forBits(yhVar.d(4));
                Mode mode2 = Mode.TERMINATOR;
                if (modeForBits == mode2) {
                    mode = modeForBits;
                } else if (modeForBits == Mode.FNC1_FIRST_POSITION || modeForBits == Mode.FNC1_SECOND_POSITION) {
                    mode = modeForBits;
                    z = true;
                } else {
                    if (modeForBits == Mode.STRUCTURED_APPEND) {
                        if (yhVar.a() < 16) {
                            throw FormatException.getFormatInstance();
                        }
                        int iD2 = yhVar.d(8);
                        iD = yhVar.d(8);
                        i2 = iD2;
                    } else if (modeForBits == Mode.ECI) {
                        characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(g(yhVar));
                        if (characterSetECIByValue == null) {
                            throw FormatException.getFormatInstance();
                        }
                    } else if (modeForBits == Mode.HANZI) {
                        int iD3 = yhVar.d(4);
                        int iD4 = yhVar.d(modeForBits.getCharacterCountBits(gVar));
                        if (iD3 == i) {
                            d(yhVar, sb, iD4);
                        }
                    } else {
                        int iD5 = yhVar.d(modeForBits.getCharacterCountBits(gVar));
                        if (modeForBits == Mode.NUMERIC) {
                            f(yhVar, sb, iD5);
                        } else if (modeForBits == Mode.ALPHANUMERIC) {
                            b(yhVar, sb, iD5, z);
                        } else if (modeForBits == Mode.BYTE) {
                            mode = modeForBits;
                            c(yhVar, sb, iD5, characterSetECIByValue, arrayList, map);
                        } else {
                            mode = modeForBits;
                            if (mode != Mode.KANJI) {
                                throw FormatException.getFormatInstance();
                            }
                            e(yhVar, sb, iD5);
                        }
                    }
                    mode = modeForBits;
                }
                if (mode == mode2) {
                    return new q70(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel == null ? null : errorCorrectionLevel.toString(), i2, iD);
                }
                i = 1;
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    private static void b(yh yhVar, StringBuilder sb, int i, boolean z) throws FormatException {
        while (i > 1) {
            if (yhVar.a() < 11) {
                throw FormatException.getFormatInstance();
            }
            int iD = yhVar.d(11);
            sb.append(h(iD / 45));
            sb.append(h(iD % 45));
            i -= 2;
        }
        if (i == 1) {
            if (yhVar.a() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(yhVar.d(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        } else {
                            sb.setCharAt(length, (char) 29);
                        }
                    } else {
                        sb.setCharAt(length, (char) 29);
                    }
                }
            }
        }
    }

    private static void c(yh yhVar, StringBuilder sb, int i, CharacterSetECI characterSetECI, Collection collection, Map map) throws FormatException {
        if ((i << 3) > yhVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) yhVar.d(8);
        }
        try {
            sb.append(new String(bArr, characterSetECI == null ? qv2.a(bArr, map) : characterSetECI.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void d(yh yhVar, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > yhVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iD = yhVar.d(13);
            int i3 = (iD % 96) | ((iD / 96) << 8);
            int i4 = i3 + (i3 < 959 ? 41377 : 42657);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void e(yh yhVar, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > yhVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iD = yhVar.d(13);
            int i3 = (iD % 192) | ((iD / 192) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void f(yh yhVar, StringBuilder sb, int i) throws FormatException {
        while (i >= 3) {
            if (yhVar.a() < 10) {
                throw FormatException.getFormatInstance();
            }
            int iD = yhVar.d(10);
            if (iD >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(iD / 100));
            sb.append(h((iD / 10) % 10));
            sb.append(h(iD % 10));
            i -= 3;
        }
        if (i == 2) {
            if (yhVar.a() < 7) {
                throw FormatException.getFormatInstance();
            }
            int iD2 = yhVar.d(7);
            if (iD2 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(iD2 / 10));
            sb.append(h(iD2 % 10));
            return;
        }
        if (i == 1) {
            if (yhVar.a() < 4) {
                throw FormatException.getFormatInstance();
            }
            int iD3 = yhVar.d(4);
            if (iD3 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(iD3));
        }
    }

    private static int g(yh yhVar) throws FormatException {
        int iD = yhVar.d(8);
        if ((iD & 128) == 0) {
            return iD & 127;
        }
        if ((iD & 192) == 128) {
            return yhVar.d(8) | ((iD & 63) << 8);
        }
        if ((iD & 224) == 192) {
            return yhVar.d(16) | ((iD & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    private static char h(int i) throws FormatException {
        char[] cArr = a;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw FormatException.getFormatInstance();
    }
}
