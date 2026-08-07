package com.google.zxing.oned.rss.expanded.decoders;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.jieli.jl_rcsp.constant.Command;
import defpackage.uh;

/* JADX INFO: loaded from: classes3.dex */
final class r {
    private final uh a;
    private final CurrentParsingState b = new CurrentParsingState();
    private final StringBuilder c = new StringBuilder();

    r(uh uhVar) {
        this.a = uhVar;
    }

    private m b(int i) {
        char c;
        int iF = f(i, 5);
        if (iF == 15) {
            return new m(i + 5, '$');
        }
        if (iF >= 5 && iF < 15) {
            return new m(i + 5, (char) (iF + 43));
        }
        int iF2 = f(i, 6);
        if (iF2 >= 32 && iF2 < 58) {
            return new m(i + 6, (char) (iF2 + 33));
        }
        switch (iF2) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = JsonPointer.SEPARATOR;
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + iF2);
        }
        return new m(i + 6, c);
    }

    private m d(int i) throws FormatException {
        int iF = f(i, 5);
        if (iF == 15) {
            return new m(i + 5, '$');
        }
        char c = '+';
        if (iF >= 5 && iF < 15) {
            return new m(i + 5, (char) (iF + 43));
        }
        int iF2 = f(i, 7);
        if (iF2 >= 64 && iF2 < 90) {
            return new m(i + 7, (char) (iF2 + 1));
        }
        if (iF2 >= 90 && iF2 < 116) {
            return new m(i + 7, (char) (iF2 + 7));
        }
        switch (f(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = JsonFactory.DEFAULT_QUOTE_CHAR;
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = '&';
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = '(';
                break;
            case 238:
                c = ')';
                break;
            case 239:
                c = '*';
                break;
            case 240:
                break;
            case Command.CMD_PHONE_NUMBER_PLAY_MODE /* 241 */:
                c = ',';
                break;
            case Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE /* 242 */:
                c = '-';
                break;
            case 243:
                c = '.';
                break;
            case 244:
                c = JsonPointer.SEPARATOR;
                break;
            case 245:
                c = ':';
                break;
            case 246:
                c = ';';
                break;
            case 247:
                c = '<';
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = '>';
                break;
            case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new m(i + 8, c);
    }

    private o e(int i) {
        int i2 = i + 7;
        if (i2 > this.a.g()) {
            int iF = f(i, 4);
            return iF == 0 ? new o(this.a.g(), 10, 10) : new o(this.a.g(), iF - 1, 10);
        }
        int iF2 = f(i, 7) - 8;
        return new o(i2, iF2 / 11, iF2 % 11);
    }

    static int g(uh uhVar, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (uhVar.c(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    private boolean h(int i) {
        int i2 = i + 3;
        if (i2 > this.a.g()) {
            return false;
        }
        while (i < i2) {
            if (this.a.c(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean i(int i) {
        int i2;
        if (i + 1 > this.a.g()) {
            return false;
        }
        for (int i3 = 0; i3 < 5 && (i2 = i3 + i) < this.a.g(); i3++) {
            if (i3 == 2) {
                if (!this.a.c(i + 2)) {
                    return false;
                }
            } else if (this.a.c(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean j(int i) {
        int i2;
        if (i + 1 > this.a.g()) {
            return false;
        }
        for (int i3 = 0; i3 < 4 && (i2 = i3 + i) < this.a.g(); i3++) {
            if (this.a.c(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean k(int i) {
        int iF;
        if (i + 5 > this.a.g()) {
            return false;
        }
        int iF2 = f(i, 5);
        if (iF2 < 5 || iF2 >= 16) {
            return i + 6 <= this.a.g() && (iF = f(i, 6)) >= 16 && iF < 63;
        }
        return true;
    }

    private boolean l(int i) {
        int iF;
        if (i + 5 > this.a.g()) {
            return false;
        }
        int iF2 = f(i, 5);
        if (iF2 >= 5 && iF2 < 16) {
            return true;
        }
        if (i + 7 > this.a.g()) {
            return false;
        }
        int iF3 = f(i, 7);
        if (iF3 < 64 || iF3 >= 116) {
            return i + 8 <= this.a.g() && (iF = f(i, 8)) >= 232 && iF < 253;
        }
        return true;
    }

    private boolean m(int i) {
        if (i + 7 > this.a.g()) {
            return i + 4 <= this.a.g();
        }
        int i2 = i;
        while (true) {
            int i3 = i + 3;
            if (i2 >= i3) {
                return this.a.c(i3);
            }
            if (this.a.c(i2)) {
                return true;
            }
            i2++;
        }
    }

    private l n() {
        while (k(this.b.a())) {
            m mVarB = b(this.b.a());
            this.b.h(mVarB.a());
            if (mVarB.c()) {
                return new l(new n(this.b.a(), this.c.toString()), true);
            }
            this.c.append(mVarB.b());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.g();
        } else if (i(this.b.a())) {
            if (this.b.a() + 5 < this.a.g()) {
                this.b.b(5);
            } else {
                this.b.h(this.a.g());
            }
            this.b.f();
        }
        return new l(false);
    }

    private n o() throws FormatException {
        l lVarQ;
        boolean zB;
        do {
            int iA = this.b.a();
            if (this.b.c()) {
                lVarQ = n();
                zB = lVarQ.b();
            } else if (this.b.d()) {
                lVarQ = p();
                zB = lVarQ.b();
            } else {
                lVarQ = q();
                zB = lVarQ.b();
            }
            if (iA == this.b.a() && !zB) {
                break;
            }
        } while (!zB);
        return lVarQ.a();
    }

    private l p() throws FormatException {
        while (l(this.b.a())) {
            m mVarD = d(this.b.a());
            this.b.h(mVarD.a());
            if (mVarD.c()) {
                return new l(new n(this.b.a(), this.c.toString()), true);
            }
            this.c.append(mVarD.b());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.g();
        } else if (i(this.b.a())) {
            if (this.b.a() + 5 < this.a.g()) {
                this.b.b(5);
            } else {
                this.b.h(this.a.g());
            }
            this.b.e();
        }
        return new l(false);
    }

    private l q() {
        while (m(this.b.a())) {
            o oVarE = e(this.b.a());
            this.b.h(oVarE.a());
            if (oVarE.d()) {
                return new l(oVarE.e() ? new n(this.b.a(), this.c.toString()) : new n(this.b.a(), this.c.toString(), oVarE.c()), true);
            }
            this.c.append(oVarE.b());
            if (oVarE.e()) {
                return new l(new n(this.b.a(), this.c.toString()), true);
            }
            this.c.append(oVarE.c());
        }
        if (j(this.b.a())) {
            this.b.e();
            this.b.b(4);
        }
        return new l(false);
    }

    String a(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            n nVarC = c(i, str);
            String strA = q.a(nVarC.b());
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = nVarC.d() ? String.valueOf(nVarC.c()) : null;
            if (i == nVarC.a()) {
                return sb.toString();
            }
            i = nVarC.a();
            str = strValueOf;
        }
    }

    n c(int i, String str) throws FormatException {
        this.c.setLength(0);
        if (str != null) {
            this.c.append(str);
        }
        this.b.h(i);
        n nVarO = o();
        return (nVarO == null || !nVarO.d()) ? new n(this.b.a(), this.c.toString()) : new n(this.b.a(), this.c.toString(), nVarO.c());
    }

    int f(int i, int i2) {
        return g(this.a, i, i2);
    }
}
