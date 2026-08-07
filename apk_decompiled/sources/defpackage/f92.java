package defpackage;

import com.legend.mywatch.sdk.mywatchsdklib.android.utils.d;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class f92 {
    public static final f92 a = new f92();

    private f92() {
    }

    public static final aa0 a(String str) {
        p31.f(str, "deviceFunction");
        yc1.a("ProtocolParserHelper", "deviceFunction:" + str);
        aa0 aa0Var = new aa0();
        String strSubstring = str.substring(0, 1);
        p31.e(strSubstring, "substring(...)");
        aa0Var.l0(p31.a(strSubstring, "1"));
        String strSubstring2 = str.substring(1, 2);
        p31.e(strSubstring2, "substring(...)");
        aa0Var.a0(p31.a(strSubstring2, "1"));
        String strSubstring3 = str.substring(2, 3);
        p31.e(strSubstring3, "substring(...)");
        aa0Var.h0(p31.a(strSubstring3, "1"));
        String strSubstring4 = str.substring(3, 4);
        p31.e(strSubstring4, "substring(...)");
        aa0Var.c0(p31.a(strSubstring4, "1"));
        String strSubstring5 = str.substring(4, 5);
        p31.e(strSubstring5, "substring(...)");
        aa0Var.p0(p31.a(strSubstring5, "1"));
        String strSubstring6 = str.substring(5, 6);
        p31.e(strSubstring6, "substring(...)");
        aa0Var.o0(p31.a(strSubstring6, "0"));
        if (str.length() > 7) {
            String strSubstring7 = str.substring(6, 7);
            p31.e(strSubstring7, "substring(...)");
            aa0Var.e0(p31.a(strSubstring7, "1"));
        } else {
            aa0Var.e0(false);
        }
        if (str.length() > 8) {
            String strSubstring8 = str.substring(8, 9);
            p31.e(strSubstring8, "substring(...)");
            aa0Var.u0(p31.a(strSubstring8, "1"));
        }
        if (str.length() >= 10) {
            String strSubstring9 = str.substring(9, 10);
            p31.e(strSubstring9, "substring(...)");
            aa0Var.s0(p31.a(strSubstring9, "1"));
        } else {
            aa0Var.s0(false);
        }
        if (str.length() >= 11) {
            String strSubstring10 = str.substring(10, 11);
            p31.e(strSubstring10, "substring(...)");
            aa0Var.Y(p31.a(strSubstring10, "1"));
        } else {
            aa0Var.Y(false);
        }
        if (str.length() >= 12) {
            String strSubstring11 = str.substring(11, 12);
            p31.e(strSubstring11, "substring(...)");
            aa0Var.q0(p31.a(strSubstring11, "1"));
        } else {
            aa0Var.q0(false);
        }
        if (str.length() >= 13) {
            String strSubstring12 = str.substring(12, 13);
            p31.e(strSubstring12, "substring(...)");
            aa0Var.r0(p31.a(strSubstring12, "1"));
        } else {
            aa0Var.r0(false);
        }
        if (str.length() >= 14) {
            String strSubstring13 = str.substring(13, 14);
            p31.e(strSubstring13, "substring(...)");
            aa0Var.t0(p31.a(strSubstring13, "1"));
        } else {
            aa0Var.t0(false);
        }
        if (str.length() >= 15) {
            String strSubstring14 = str.substring(14, 15);
            p31.e(strSubstring14, "substring(...)");
            aa0Var.d0(p31.a(strSubstring14, "1"));
        } else {
            aa0Var.d0(false);
        }
        if (str.length() >= 16) {
            String strSubstring15 = str.substring(15, 16);
            p31.e(strSubstring15, "substring(...)");
            aa0Var.k0(p31.a(strSubstring15, "1"));
        } else {
            aa0Var.k0(false);
        }
        if (str.length() >= 17) {
            String strSubstring16 = str.substring(16, 17);
            p31.e(strSubstring16, "substring(...)");
            aa0Var.Z(p31.a(strSubstring16, "1"));
        } else {
            aa0Var.Z(false);
        }
        if (str.length() >= 18) {
            String strSubstring17 = str.substring(17, 18);
            p31.e(strSubstring17, "substring(...)");
            aa0Var.m0(p31.a(strSubstring17, "0"));
        } else {
            aa0Var.m0(true);
        }
        if (str.length() >= 19) {
            String strSubstring18 = str.substring(18, 19);
            p31.e(strSubstring18, "substring(...)");
            aa0Var.g0(p31.a(strSubstring18, "0"));
        } else {
            aa0Var.g0(true);
        }
        if (str.length() >= 20) {
            String strSubstring19 = str.substring(19, 20);
            p31.e(strSubstring19, "substring(...)");
            aa0Var.i0(p31.a(strSubstring19, "1"));
        } else {
            aa0Var.i0(false);
        }
        if (str.length() >= 21) {
            String strSubstring20 = str.substring(20, 21);
            p31.e(strSubstring20, "substring(...)");
            aa0Var.j0(p31.a(strSubstring20, "0"));
        } else {
            aa0Var.j0(true);
        }
        if (str.length() >= 22) {
            String strSubstring21 = str.substring(21, 22);
            p31.e(strSubstring21, "substring(...)");
            aa0Var.f0(p31.a(strSubstring21, "0"));
        } else {
            aa0Var.f0(true);
        }
        if (str.length() >= 23) {
            String strSubstring22 = str.substring(22, 23);
            p31.e(strSubstring22, "substring(...)");
            aa0Var.n0(p31.a(strSubstring22, "0"));
        } else {
            aa0Var.n0(true);
        }
        if (str.length() >= 24) {
            String strSubstring23 = str.substring(23, 24);
            p31.e(strSubstring23, "substring(...)");
            aa0Var.P(p31.a(strSubstring23, "1"));
        } else {
            aa0Var.P(false);
        }
        if (str.length() >= 25) {
            String strSubstring24 = str.substring(24, 25);
            p31.e(strSubstring24, "substring(...)");
            aa0Var.X(p31.a(strSubstring24, "1"));
        } else {
            aa0Var.X(false);
        }
        if (str.length() >= 26) {
            String strSubstring25 = str.substring(25, 26);
            p31.e(strSubstring25, "substring(...)");
            aa0Var.D0(p31.a(strSubstring25, "1"));
        } else {
            aa0Var.D0(false);
        }
        if (str.length() >= 27) {
            String strSubstring26 = str.substring(26, 27);
            p31.e(strSubstring26, "substring(...)");
            aa0Var.R(p31.a(strSubstring26, "1"));
        } else {
            aa0Var.R(false);
        }
        if (str.length() >= 28) {
            String strSubstring27 = str.substring(27, 28);
            p31.e(strSubstring27, "substring(...)");
            byte[] bArrK = ks1.k(Integer.parseInt(strSubstring27));
            aa0Var.w0(bArrK[0] == 1);
            aa0Var.y0(bArrK[1] == 1);
            aa0Var.z0(bArrK[2] == 1);
        }
        if (str.length() >= 29) {
            String strSubstring28 = str.substring(28, 29);
            p31.e(strSubstring28, "substring(...)");
            byte[] bArrK2 = ks1.k(Integer.parseInt(strSubstring28));
            aa0Var.x0(bArrK2[0] == 1);
            aa0Var.v0(bArrK2[1] == 1);
            aa0Var.Q(bArrK2[2] == 1);
        }
        if (str.length() >= 30) {
            String strSubstring29 = str.substring(29, 30);
            p31.e(strSubstring29, "substring(...)");
            byte[] bArrK3 = ks1.k(Integer.parseInt(strSubstring29));
            aa0Var.T(bArrK3[0] == 1);
            aa0Var.b0(bArrK3[1] == 0);
            aa0Var.C0(bArrK3[2] == 1);
        }
        if (str.length() >= 31) {
            String strSubstring30 = str.substring(30, 31);
            p31.e(strSubstring30, "substring(...)");
            byte[] bArrK4 = ks1.k(Integer.parseInt(strSubstring30));
            aa0Var.S(bArrK4[0] == 1);
            aa0Var.V(bArrK4[1] == 1);
            aa0Var.W(bArrK4[2] == 1);
        }
        if (str.length() >= 32) {
            String strSubstring31 = str.substring(31, 32);
            p31.e(strSubstring31, "substring(...)");
            byte[] bArrK5 = ks1.k(Integer.parseInt(strSubstring31));
            aa0Var.U(bArrK5[0] == 1);
            aa0Var.A0(bArrK5[1] == 1);
            aa0Var.B0(bArrK5[2] == 1);
        }
        return aa0Var;
    }

    public static final aa0 b(byte[] bArr) {
        p31.f(bArr, "data");
        String strE = pp.e(bArr);
        p31.c(strE);
        return a(strE);
    }

    public static final j13 c(byte[] bArr) {
        p31.f(bArr, "data");
        if (bArr.length < 6) {
            throw new IllegalArgumentException("data must be greater than 6 bytes");
        }
        return new j13(ks1.j(ks1.g(da.c(bArr, 4, 6))), ks1.c(da.c(bArr, 0, 4)));
    }

    public static final List d(byte[] bArr) {
        p31.f(bArr, "data");
        String str = "parsePrivateTestTempCheckItems data:" + d.a(bArr);
        PrintStream printStream = System.out;
        printStream.println((Object) str);
        int i = 0;
        short sI = ks1.i(bArr[0]);
        printStream.println((Object) ("itemCount:" + ((int) sI)));
        byte[] bArrC = da.c(bArr, 1, bArr.length);
        ArrayList arrayList = new ArrayList();
        while (i < sI) {
            int i2 = i * 6;
            i++;
            byte[] bArrC2 = da.c(bArrC, i2, i * 6);
            p31.c(bArrC2);
            arrayList.add(c(bArrC2));
        }
        return arrayList;
    }
}
