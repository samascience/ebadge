package com.google.zxing.datamatrix.decoder;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.zxing.FormatException;
import defpackage.q70;
import defpackage.yh;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
abstract class DecodedBitStreamParser {
    private static final char[] a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] b;
    private static final char[] c;
    private static final char[] d;
    private static final char[] e;

    private enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Mode.values().length];
            a = iArr;
            try {
                iArr[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        char[] cArr = {'!', JsonFactory.DEFAULT_QUOTE_CHAR, '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', JsonPointer.SEPARATOR, ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        b = cArr;
        c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        d = cArr;
        e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};
    }

    static q70 a(byte[] bArr) throws FormatException {
        yh yhVar = new yh(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        Mode modeC = Mode.ASCII_ENCODE;
        do {
            Mode mode = Mode.ASCII_ENCODE;
            if (modeC == mode) {
                modeC = c(yhVar, sb, sb2);
            } else {
                int i = a.a[modeC.ordinal()];
                if (i == 1) {
                    e(yhVar, sb);
                } else if (i == 2) {
                    g(yhVar, sb);
                } else if (i == 3) {
                    b(yhVar, sb);
                } else if (i == 4) {
                    f(yhVar, sb);
                } else {
                    if (i != 5) {
                        throw FormatException.getFormatInstance();
                    }
                    d(yhVar, sb, arrayList);
                }
                modeC = mode;
            }
            if (modeC == Mode.PAD_ENCODE) {
                break;
            }
        } while (yhVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String string = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new q70(bArr, string, arrayList, null);
    }

    private static void b(yh yhVar, StringBuilder sb) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        while (yhVar.a() != 8 && (iD = yhVar.d(8)) != 254) {
            h(iD, yhVar.d(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    sb.append('\r');
                } else if (i2 == 1) {
                    sb.append('*');
                } else if (i2 == 2) {
                    sb.append('>');
                } else if (i2 == 3) {
                    sb.append(' ');
                } else if (i2 < 14) {
                    sb.append((char) (i2 + 44));
                } else {
                    if (i2 >= 40) {
                        throw FormatException.getFormatInstance();
                    }
                    sb.append((char) (i2 + 51));
                }
            }
            if (yhVar.a() <= 0) {
                return;
            }
        }
    }

    private static Mode c(yh yhVar, StringBuilder sb, StringBuilder sb2) throws FormatException {
        boolean z = false;
        do {
            int iD = yhVar.d(8);
            if (iD == 0) {
                throw FormatException.getFormatInstance();
            }
            if (iD <= 128) {
                if (z) {
                    iD += 128;
                }
                sb.append((char) (iD - 1));
                return Mode.ASCII_ENCODE;
            }
            if (iD == 129) {
                return Mode.PAD_ENCODE;
            }
            if (iD <= 229) {
                int i = iD - 130;
                if (i < 10) {
                    sb.append('0');
                }
                sb.append(i);
            } else {
                if (iD == 230) {
                    return Mode.C40_ENCODE;
                }
                if (iD == 231) {
                    return Mode.BASE256_ENCODE;
                }
                if (iD == 232) {
                    sb.append((char) 29);
                } else if (iD != 233 && iD != 234) {
                    if (iD == 235) {
                        z = true;
                    } else if (iD == 236) {
                        sb.append("[)>\u001e05\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else if (iD == 237) {
                        sb.append("[)>\u001e06\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else {
                        if (iD == 238) {
                            return Mode.ANSIX12_ENCODE;
                        }
                        if (iD == 239) {
                            return Mode.TEXT_ENCODE;
                        }
                        if (iD == 240) {
                            return Mode.EDIFACT_ENCODE;
                        }
                        if (iD != 241 && iD >= 242 && (iD != 254 || yhVar.a() != 0)) {
                            throw FormatException.getFormatInstance();
                        }
                    }
                }
            }
        } while (yhVar.a() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void d(yh yhVar, StringBuilder sb, Collection collection) throws FormatException {
        int iC = yhVar.c();
        int i = iC + 2;
        int i2 = i(yhVar.d(8), iC + 1);
        if (i2 == 0) {
            i2 = yhVar.a() / 8;
        } else if (i2 >= 250) {
            i2 = ((i2 - 249) * ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + i(yhVar.d(8), i);
            i = iC + 3;
        }
        if (i2 < 0) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            if (yhVar.a() < 8) {
                throw FormatException.getFormatInstance();
            }
            bArr[i3] = (byte) i(yhVar.d(8), i);
            i3++;
            i++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException("Platform does not support required encoding: " + e2);
        }
    }

    private static void e(yh yhVar, StringBuilder sb) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (yhVar.a() != 8 && (iD = yhVar.d(8)) != 254) {
            h(iD, yhVar.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            char[] cArr = b;
                            if (i3 < cArr.length) {
                                char c2 = cArr[i3];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i3 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i3 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z = true;
                            }
                        } else {
                            if (i != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            if (z) {
                                sb.append((char) (i3 + 224));
                                z = false;
                            } else {
                                sb.append((char) (i3 + 96));
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i3 + 128));
                        z = false;
                    } else {
                        sb.append((char) i3);
                    }
                    i = 0;
                } else if (i3 < 3) {
                    i = i3 + 1;
                } else {
                    char[] cArr2 = a;
                    if (i3 >= cArr2.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c3 = cArr2[i3];
                    if (z) {
                        sb.append((char) (c3 + 128));
                        z = false;
                    } else {
                        sb.append(c3);
                    }
                }
            }
            if (yhVar.a() <= 0) {
                return;
            }
        }
    }

    private static void f(yh yhVar, StringBuilder sb) {
        while (yhVar.a() > 16) {
            for (int i = 0; i < 4; i++) {
                int iD = yhVar.d(6);
                if (iD == 31) {
                    int iB = 8 - yhVar.b();
                    if (iB != 8) {
                        yhVar.d(iB);
                        return;
                    }
                    return;
                }
                if ((iD & 32) == 0) {
                    iD |= 64;
                }
                sb.append((char) iD);
            }
            if (yhVar.a() <= 0) {
                return;
            }
        }
    }

    private static void g(yh yhVar, StringBuilder sb) throws FormatException {
        int iD;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (yhVar.a() != 8 && (iD = yhVar.d(8)) != 254) {
            h(iD, yhVar.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            char[] cArr = d;
                            if (i3 < cArr.length) {
                                char c2 = cArr[i3];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i3 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i3 != 30) {
                                    throw FormatException.getFormatInstance();
                                }
                                z = true;
                            }
                        } else {
                            if (i != 3) {
                                throw FormatException.getFormatInstance();
                            }
                            char[] cArr2 = e;
                            if (i3 >= cArr2.length) {
                                throw FormatException.getFormatInstance();
                            }
                            char c3 = cArr2[i3];
                            if (z) {
                                sb.append((char) (c3 + 128));
                                z = false;
                            } else {
                                sb.append(c3);
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i3 + 128));
                        z = false;
                    } else {
                        sb.append((char) i3);
                    }
                    i = 0;
                } else if (i3 < 3) {
                    i = i3 + 1;
                } else {
                    char[] cArr3 = c;
                    if (i3 >= cArr3.length) {
                        throw FormatException.getFormatInstance();
                    }
                    char c4 = cArr3[i3];
                    if (z) {
                        sb.append((char) (c4 + 128));
                        z = false;
                    } else {
                        sb.append(c4);
                    }
                }
            }
            if (yhVar.a() <= 0) {
                return;
            }
        }
    }

    private static void h(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static int i(int i, int i2) {
        int i3 = i - (((i2 * Opcodes.FCMPL) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
