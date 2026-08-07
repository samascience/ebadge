package defpackage;

import com.google.zxing.DecodeHintType;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class qv2 {
    private static final String a;
    private static final boolean b;

    static {
        String strName = Charset.defaultCharset().name();
        a = strName;
        b = "SJIS".equalsIgnoreCase(strName) || "EUC_JP".equalsIgnoreCase(strName);
    }

    /* JADX WARN: Code duplicated, block: B:71:0x00bc  */
    public static String a(byte[] bArr, Map map) {
        int i;
        byte[] bArr2 = bArr;
        if (map != null) {
            DecodeHintType decodeHintType = DecodeHintType.CHARACTER_SET;
            if (map.containsKey(decodeHintType)) {
                return map.get(decodeHintType).toString();
            }
        }
        int length = bArr2.length;
        boolean z = true;
        int i2 = 0;
        boolean z2 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        boolean z3 = true;
        boolean z4 = true;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i4 < length && (z || z3 || z4)) {
            byte b2 = bArr2[i4];
            int i14 = b2 & 255;
            if (z4) {
                if (i5 <= 0) {
                    i = length;
                    if ((b2 & 128) != 0) {
                        if ((b2 & 64) != 0) {
                            int i15 = i5 + 1;
                            if ((b2 & 32) == 0) {
                                i7++;
                            } else {
                                i15 = i5 + 2;
                                if ((b2 & AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN) == 0) {
                                    i8++;
                                } else {
                                    i5 += 3;
                                    if ((b2 & 8) == 0) {
                                        i9++;
                                    }
                                }
                            }
                            i5 = i15;
                        }
                    }
                } else if ((b2 & 128) != 0) {
                    i5--;
                    i = length;
                } else {
                    i = length;
                }
                z4 = false;
            } else {
                i = length;
            }
            if (z) {
                if (i14 > 127 && i14 < 160) {
                    z = false;
                } else if (i14 > 159 && (i14 < 192 || i14 == 215 || i14 == 247)) {
                    i11++;
                }
            }
            if (z3) {
                if (i6 > 0) {
                    if (i14 < 64 || i14 == 127 || i14 > 252) {
                        z3 = false;
                    } else {
                        i6--;
                    }
                } else if (i14 == 128 || i14 == 160 || i14 > 239) {
                    z3 = false;
                } else if (i14 <= 160 || i14 >= 224) {
                    if (i14 > 127) {
                        i6++;
                        int i16 = i12 + 1;
                        if (i16 > i2) {
                            i2 = i16;
                            i12 = i2;
                        } else {
                            i12 = i16;
                        }
                    } else {
                        i12 = 0;
                    }
                    i13 = 0;
                } else {
                    i3++;
                    int i17 = i13 + 1;
                    if (i17 > i10) {
                        i10 = i17;
                        i13 = i10;
                    } else {
                        i13 = i17;
                    }
                    i12 = 0;
                }
            }
            i4++;
            bArr2 = bArr;
            length = i;
        }
        int i18 = length;
        if (z4 && i5 > 0) {
            z4 = false;
        }
        if (z3 && i6 > 0) {
            z3 = false;
        }
        if (z4 && (z2 || i7 + i8 + i9 > 0)) {
            return "UTF8";
        }
        if (z3 && (b || i10 >= 3 || i2 >= 3)) {
            return "SJIS";
        }
        if (z && z3) {
            return (!(i10 == 2 && i3 == 2) && i11 * 10 < i18) ? "ISO8859_1" : "SJIS";
        }
        if (z) {
            return "ISO8859_1";
        }
        if (z3) {
            return "SJIS";
        }
        return z4 ? "UTF8" : a;
    }
}
