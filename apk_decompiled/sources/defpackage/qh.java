package defpackage;

import android.text.SpannableStringBuilder;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.tencent.connect.common.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class qh {
    static final y13 d;
    private static final String e;
    private static final String f;
    static final qh g;
    static final qh h;
    private final boolean a;
    private final int b;
    private final y13 c;

    public static final class a {
        private boolean a;
        private int b;
        private y13 c;

        public a() {
            c(qh.e(Locale.getDefault()));
        }

        private static qh b(boolean z) {
            return z ? qh.h : qh.g;
        }

        private void c(boolean z) {
            this.a = z;
            this.c = qh.d;
            this.b = 2;
        }

        public qh a() {
            return (this.b == 2 && this.c == qh.d) ? b(this.a) : new qh(this.a, this.b, this.c);
        }
    }

    private static class b {
        private static final byte[] f = new byte[1792];
        private final CharSequence a;
        private final boolean b;
        private final int c;
        private int d;
        private char e;

        static {
            for (int i = 0; i < 1792; i++) {
                f[i] = Character.getDirectionality(i);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.a = charSequence;
            this.b = z;
            this.c = charSequence.length();
        }

        private static byte c(char c) {
            return c < 1792 ? f[c] : Character.getDirectionality(c);
        }

        private byte f() {
            char cCharAt;
            int i = this.d;
            do {
                int i2 = this.d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.a;
                int i3 = i2 - 1;
                this.d = i3;
                cCharAt = charSequence.charAt(i3);
                this.e = cCharAt;
                if (cCharAt == '&') {
                    return AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE;
                }
            } while (cCharAt != ';');
            this.d = i;
            this.e = ';';
            return AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE;
        }

        private byte g() {
            char cCharAt;
            do {
                int i = this.d;
                if (i >= this.c) {
                    return AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE;
                }
                CharSequence charSequence = this.a;
                this.d = i + 1;
                cCharAt = charSequence.charAt(i);
                this.e = cCharAt;
            } while (cCharAt != ';');
            return AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE;
        }

        private byte h() {
            char cCharAt;
            int i = this.d;
            while (true) {
                int i2 = this.d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.a;
                int i3 = i2 - 1;
                this.d = i3;
                char cCharAt2 = charSequence.charAt(i3);
                this.e = cCharAt2;
                if (cCharAt2 == '<') {
                    return AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i4 = this.d;
                        if (i4 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.a;
                        int i5 = i4 - 1;
                        this.d = i5;
                        cCharAt = charSequence2.charAt(i5);
                        this.e = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
            this.d = i;
            this.e = '>';
            return AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE;
        }

        private byte i() {
            char cCharAt;
            int i = this.d;
            while (true) {
                int i2 = this.d;
                if (i2 >= this.c) {
                    this.d = i;
                    this.e = '<';
                    return AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE;
                }
                CharSequence charSequence = this.a;
                this.d = i2 + 1;
                char cCharAt2 = charSequence.charAt(i2);
                this.e = cCharAt2;
                if (cCharAt2 == '>') {
                    return AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i3 = this.d;
                        if (i3 >= this.c) {
                            break;
                        }
                        CharSequence charSequence2 = this.a;
                        this.d = i3 + 1;
                        cCharAt = charSequence2.charAt(i3);
                        this.e = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
        }

        byte a() {
            char cCharAt = this.a.charAt(this.d - 1);
            this.e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.a, this.d);
                this.d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.d--;
            byte bC = c(this.e);
            if (!this.b) {
                return bC;
            }
            char c = this.e;
            if (c == '>') {
                return h();
            }
            return c == ';' ? f() : bC;
        }

        byte b() {
            char cCharAt = this.a.charAt(this.d);
            this.e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.a, this.d);
                this.d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.d++;
            byte bC = c(this.e);
            if (!this.b) {
                return bC;
            }
            char c = this.e;
            if (c == '<') {
                return i();
            }
            return c == '&' ? g() : bC;
        }

        int d() {
            this.d = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.d < this.c && i == 0) {
                byte b = b();
                if (b != 0) {
                    if (b == 1 || b == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (b != 9) {
                        switch (b) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                    default:
                        continue;
                }
                i3--;
            }
            return 0;
        }

        int e() {
            this.d = this.c;
            int i = 0;
            while (true) {
                int i2 = i;
                while (this.d > 0) {
                    byte bA = a();
                    if (bA == 0) {
                        if (i == 0) {
                            return -1;
                        }
                        if (i2 == 0) {
                        }
                    } else if (bA == 1 || bA == 2) {
                        if (i == 0) {
                            return 1;
                        }
                        if (i2 == 0) {
                        }
                    } else if (bA != 9) {
                        switch (bA) {
                            case 14:
                            case 15:
                                if (i2 == i) {
                                    return -1;
                                }
                                i--;
                                break;
                            case 16:
                            case 17:
                                if (i2 == i) {
                                    return 1;
                                }
                                i--;
                                break;
                            case 18:
                                i++;
                                break;
                            default:
                                if (i2 != 0) {
                                }
                                break;
                        }
                    } else {
                        continue;
                    }
                }
                return 0;
            }
        }
    }

    static {
        y13 y13Var = z13.c;
        d = y13Var;
        e = Character.toString((char) 8206);
        f = Character.toString((char) 8207);
        g = new qh(false, 2, y13Var);
        h = new qh(true, 2, y13Var);
    }

    qh(boolean z, int i, y13 y13Var) {
        this.a = z;
        this.b = i;
        this.c = y13Var;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static qh c() {
        return new a().a();
    }

    static boolean e(Locale locale) {
        return h23.a(locale) == 1;
    }

    private String f(CharSequence charSequence, y13 y13Var) {
        boolean zA = y13Var.a(charSequence, 0, charSequence.length());
        if (!this.a && (zA || b(charSequence) == 1)) {
            return e;
        }
        if (this.a) {
            return (!zA || b(charSequence) == -1) ? f : Constants.STR_EMPTY;
        }
        return Constants.STR_EMPTY;
    }

    private String g(CharSequence charSequence, y13 y13Var) {
        boolean zA = y13Var.a(charSequence, 0, charSequence.length());
        if (!this.a && (zA || a(charSequence) == 1)) {
            return e;
        }
        if (this.a) {
            return (!zA || a(charSequence) == -1) ? f : Constants.STR_EMPTY;
        }
        return Constants.STR_EMPTY;
    }

    public boolean d() {
        return (this.b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.c, true);
    }

    public CharSequence i(CharSequence charSequence, y13 y13Var, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean zA = y13Var.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zA ? z13.b : z13.a));
        }
        if (zA != this.a) {
            spannableStringBuilder.append(zA ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) f(charSequence, zA ? z13.b : z13.a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.c, true);
    }

    public String k(String str, y13 y13Var, boolean z) {
        if (str == null) {
            return null;
        }
        return i(str, y13Var, z).toString();
    }
}
