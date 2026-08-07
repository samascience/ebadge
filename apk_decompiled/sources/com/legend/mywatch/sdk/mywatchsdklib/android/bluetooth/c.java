package com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth;

import com.legend.mywatch.sdk.mywatchsdklib.android.enm.DeviceControlAppEnum;
import com.legend.mywatch.sdk.mywatchsdklib.android.enm.ECGStatus;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.d;
import com.tencent.connect.common.Constants;
import defpackage.b40;
import defpackage.b62;
import defpackage.ba0;
import defpackage.cn1;
import defpackage.da;
import defpackage.dy;
import defpackage.e20;
import defpackage.e5;
import defpackage.e92;
import defpackage.ew0;
import defpackage.ey;
import defpackage.ez;
import defpackage.f13;
import defpackage.f33;
import defpackage.f5;
import defpackage.f92;
import defpackage.fb1;
import defpackage.fy;
import defpackage.g13;
import defpackage.gh3;
import defpackage.gt1;
import defpackage.h13;
import defpackage.ha3;
import defpackage.hh3;
import defpackage.i13;
import defpackage.jy0;
import defpackage.k13;
import defpackage.k33;
import defpackage.kh1;
import defpackage.ks1;
import defpackage.kw0;
import defpackage.l03;
import defpackage.l13;
import defpackage.ld2;
import defpackage.lh1;
import defpackage.lr2;
import defpackage.m62;
import defpackage.mg3;
import defpackage.mh1;
import defpackage.mt0;
import defpackage.my;
import defpackage.n72;
import defpackage.nr2;
import defpackage.o03;
import defpackage.oc0;
import defpackage.og3;
import defpackage.oj1;
import defpackage.oo2;
import defpackage.oy;
import defpackage.p03;
import defpackage.pa0;
import defpackage.pg3;
import defpackage.pk1;
import defpackage.pp;
import defpackage.pr2;
import defpackage.q03;
import defpackage.q2;
import defpackage.qm2;
import defpackage.qn;
import defpackage.rv2;
import defpackage.sg3;
import defpackage.sh0;
import defpackage.tg3;
import defpackage.ts0;
import defpackage.ug3;
import defpackage.us2;
import defpackage.vg3;
import defpackage.vs2;
import defpackage.w90;
import defpackage.wg3;
import defpackage.wh2;
import defpackage.ws2;
import defpackage.x90;
import defpackage.xd0;
import defpackage.xe0;
import defpackage.xy2;
import defpackage.yc1;
import defpackage.yd1;
import defpackage.zi2;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static String h = "ReceiveData";
    static c i;
    private byte[] a;
    private byte[] b;
    a e;
    private String g;
    private byte[] c = new byte[0];
    private byte[] d = new byte[0];
    boolean f = false;

    public interface a {
        byte[] a();

        void b(byte[] bArr);
    }

    public c() {
        i = this;
    }

    private int D(String str) {
        try {
            byte[] bArrG = d.g(str);
            int iB = ks1.b(bArrG);
            yc1.a(h, "hexString:" + d.a(bArrG) + ";code:" + iB);
            return iB;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void E(byte[] bArr) {
        try {
            byte[] bArrK = ks1.k(bArr[0]);
            boolean z = bArrK[0] == 1;
            boolean z2 = bArrK[1] == 1;
            short sF = ks1.f(new byte[]{bArr[1], bArr[2]});
            short sF2 = ks1.f(new byte[]{bArr[3], bArr[4]});
            short sF3 = ks1.f(new byte[]{bArr[5], bArr[6]});
            xd0 xd0Var = new xd0();
            xd0Var.e(z);
            xd0Var.d(z2);
            xd0Var.a(sF / 60.0f);
            xd0Var.c(sF2);
            xd0Var.b(sF3);
            tg3.j(xd0Var);
        } catch (Exception unused) {
        }
    }

    private void F(byte[] bArr) {
        try {
            byte[] bArrK = ks1.k(bArr[0]);
            mt0 mt0Var = new mt0();
            mt0Var.a(bArrK[0] == 1);
            mt0Var.c(bArrK[1] == 1);
            mt0Var.d(bArrK[2] == 1);
            mt0Var.b(bArrK[3] == 1);
            tg3.j(mt0Var);
            yc1.a(h, "parseGestureControl:" + mt0Var);
        } catch (Exception e) {
            yc1.a(h, "parseGestureControl:" + e);
        }
    }

    private void G(byte[] bArr) {
        try {
            byte b = bArr[0];
            int i2 = b + 1;
            String str = new String(Arrays.copyOfRange(bArr, 1, i2));
            yc1.a(h, "led:" + str);
            int i3 = b + 2;
            int i4 = bArr[i2] + i3;
            String str2 = new String(Arrays.copyOfRange(bArr, i3, i4));
            yc1.a(h, "gsensorStr:" + str2);
            byte b2 = bArr[i4];
            int i5 = i4 + 1;
            String str3 = new String(Arrays.copyOfRange(bArr, i5, b2 + i5));
            yc1.a(h, "heart:" + str3);
            ba0 ba0Var = new ba0();
            ba0Var.f(str);
            ba0Var.d(str2);
            ba0Var.e(str3);
            tg3.j(ba0Var);
        } catch (Exception e) {
            e.printStackTrace();
            yc1.a(h, "parse hard info error:" + e);
        }
    }

    private int[] H(byte[] bArr) {
        int[] iArr = new int[2];
        try {
            int length = bArr.length;
            if (length == 1) {
                iArr[0] = bArr[0];
                iArr[1] = 0;
            } else if (length > 1) {
                iArr[0] = bArr[0];
                iArr[1] = bArr[1];
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return iArr;
    }

    private void I(byte[] bArr) {
        try {
            byte b = bArr[0];
            int i2 = b + 1;
            int i3 = b + 2;
            tg3.j(new n72(d.c(Arrays.copyOfRange(bArr, 1, i2)), d.c(Arrays.copyOfRange(bArr, i3, bArr[i2] + i3))));
        } catch (Exception e) {
            yc1.a(h, "parseProductPicInfo:" + e);
        }
    }

    private void J(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            String str = h;
            StringBuilder sb = new StringBuilder();
            sb.append("parseRingAppExtConfig1b: payload too short len=");
            sb.append(bArr == null ? -1 : bArr.length);
            yc1.a(str, sb.toString());
            tg3.j(new wh2(0, 0, false));
            return;
        }
        int i2 = bArr[0] & 255;
        int i3 = bArr[1] & 255;
        yc1.a(h, "parseRingAppExtConfig1b version=0x" + Integer.toHexString(i2) + " flags=0x" + Integer.toHexString(i3));
        tg3.j(new wh2(i2, i3, true));
    }

    private void K(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            String str = h;
            StringBuilder sb = new StringBuilder();
            sb.append("parseSetInfoByKeyCapability1c: payload too short len=");
            sb.append(bArr == null ? -1 : bArr.length);
            yc1.a(str, sb.toString());
            tg3.j(new w90(0, 0, false));
            return;
        }
        int i2 = bArr[0] & 255;
        if (i2 != 1) {
            yc1.a(h, "parseSetInfoByKeyCapability1c: unsupported cap_version=" + i2 + ", ignore");
            tg3.j(new w90(i2, 0, false));
            return;
        }
        int iD = ks1.d(bArr, 2);
        yc1.a(h, "parseSetInfoByKeyCapability1c cap_version=0x01 mask[0]=0x" + Integer.toHexString(iD));
        tg3.j(new w90(i2, iD, true));
    }

    private void L(byte[] bArr) {
        try {
            pr2 pr2Var = new pr2();
            pr2Var.a(bArr[0] == 1);
            pr2Var.c(ks1.k(bArr[1]));
            pr2Var.b(ks1.f(new byte[]{bArr[2], bArr[3]}));
            tg3.j(pr2Var);
        } catch (Exception e) {
            yc1.a(h, "parseSleepWarn exception:" + e);
        }
    }

    private void M(byte[] bArr) {
        tg3.j(new l03(ks1.f(bArr)));
    }

    private void N(byte[] bArr) {
        try {
            tg3.j(new o03(ks1.f(bArr)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void O(byte[] bArr) {
        try {
            yc1.a(h, "parse target stand time:" + d.a(bArr));
            tg3.j(new p03(bArr[0]));
        } catch (Exception e) {
            e.printStackTrace();
            yc1.a(h, "parse target sport time error:" + e.toString());
        }
    }

    private void Q() {
        if (this.a.length < 12) {
            return;
        }
        byte[] bArrQ = q();
        String string = "20";
        for (byte b : pp.a(bArrQ, 0, 6)) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(b < 10 ? "0" + ((int) b) : Byte.valueOf(b));
            string = sb.toString();
        }
        Date dateC = f33.c(string.trim(), cn1.d());
        if (dateC == null) {
            dateC = f33.a();
        }
        tg3.j(new k13(dateC, ks1.n(pp.g(pp.d(pp.a(bArrQ, 6, 10))) / 10.0f, 1)));
    }

    private void R(String str, int i2) {
        byte[] bArrG = d.g(str);
        byte b = bArrG[0];
        byte b2 = bArrG[1];
        byte[] bArrC = da.c(bArrG, 2, bArrG.length);
        byte length = (byte) (bArrC.length / b2);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = i4 + b2;
            byte[] bArrC2 = da.c(bArrC, i4, i5);
            mg3 mg3Var = new mg3();
            mg3Var.d(ks1.p(Integer.parseUnsignedInt(d.a(da.c(bArrC2, 0, 4)), 16)));
            byte[] bArrK = ks1.k(bArrC2[4]);
            mg3Var.c(bArrK[0] == 1);
            mg3Var.a(bArrK[1] == 1);
            mg3Var.b(bArrK[2] == 1);
            if (ez.b(bArrC2) > 7) {
                mg3Var.e(ks1.p(Integer.parseUnsignedInt(d.a(ks1.h(new byte[0], da.c(bArrC2, 5, 8))), 16)));
            }
            arrayList.add(mg3Var);
            yc1.a(h, "parseWatchList watch3:" + mg3Var);
            i3++;
            i4 = i5;
        }
        tg3.j(new pg3(arrayList, i2));
    }

    private void S(String str) {
        tg3.j(new sg3(ks1.e(d.g(str), false)));
    }

    private void T(String str) {
        hh3 hh3Var;
        try {
            byte[] bArrG = d.g(str);
            int i2 = 0;
            byte b = bArrG[0];
            long jP = ks1.p(Integer.parseUnsignedInt(d.a(da.c(bArrG, 1, 5)), 16));
            short sI = ks1.i(bArrG[5]);
            short sI2 = ks1.i(bArrG[6]);
            byte b2 = bArrG[7];
            ArrayList arrayList = new ArrayList();
            int i3 = 8;
            while (i2 < b2) {
                byte b3 = bArrG[i3];
                byte b4 = bArrG[i3 + 1];
                int i4 = i3 + 2;
                int i5 = b4 + i4;
                arrayList.add(new pk1(b3, da.c(bArrG, i4, i5)));
                i2++;
                i3 = i5;
            }
            hh3Var = new hh3(jP, sI, sI2, arrayList, da.c(bArrG, i3, i3 + 3), b);
        } catch (Exception e) {
            yc1.a(h, "parseWatchThemeConfig error:" + e);
            hh3Var = new hh3(e);
        }
        tg3.j(hh3Var);
    }

    private void d0(String str) {
        try {
            tg3.j(new l13(Integer.valueOf(str).intValue()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void f0() {
        String strD = pp.d(q());
        byte bU = U(5);
        yc1.a(h, "第" + ((int) bU) + "表盘响应信息---" + strD);
        switch (bU) {
            case 1:
                gh3.o().N(D(strD));
                break;
            case 2:
                C(strD);
                break;
            case 3:
            case 5:
            case 8:
                R(strD, bU);
                break;
            case 4:
                S(strD);
                break;
            case 6:
                tg3.j(new sh0());
                break;
            case 7:
                T(strD);
                break;
        }
    }

    private void h0(byte b) {
        if (w()) {
            return;
        }
        byte[] bArrQ = q();
        if (b == 4) {
            tg3.j(new og3(ks1.p(Integer.parseUnsignedInt(d.a(da.c(bArrQ, 0, 4)), 16)), bArrQ[4]));
        } else {
            if (b != 5) {
                return;
            }
            byte[] bArrC = da.c(bArrQ, 0, 4);
            tg3.j(new wg3(ks1.p(Integer.parseUnsignedInt(d.a(bArrC), 16)), bArrC.length > 4 ? bArrQ[4] : (byte) 0));
        }
    }

    private byte[] k(byte[] bArr) {
        if (bArr != null && bArr.length >= 9) {
            if ((bArr[0] & 255) != 205) {
                return null;
            }
            byte b = bArr[3];
            byte b2 = bArr[5];
            boolean z = b == 18 && b2 == 46;
            boolean z2 = b == 21 && b2 == 26;
            boolean z3 = b == 38;
            if ((z || z2 || z3) && (((bArr[6] & 255) << 8) | (bArr[7] & 255)) >= 1 && bArr.length >= 9) {
                return Arrays.copyOfRange(bArr, 8, 9);
            }
        }
        return null;
    }

    public static byte[] l(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private String m(String str) {
        String upperCase = str.replaceAll("(.{2})", "$1:").toUpperCase();
        return upperCase.substring(0, upperCase.length() - 1).trim();
    }

    private int n(String str) {
        int iIntValue;
        try {
            iIntValue = Integer.valueOf(str).intValue();
        } catch (NumberFormatException unused) {
            yc1.a(h, "code convert error ");
            iIntValue = 0;
        }
        yc1.a(h, "classicName code:" + iIntValue);
        return iIntValue;
    }

    public static c o() {
        return i;
    }

    private byte[] q() {
        return pp.a(this.a, 8, Integer.valueOf(this.a.length));
    }

    private void r(byte[] bArr) {
        if (bArr == null || bArr.length < 8) {
            String str = h;
            StringBuilder sb = new StringBuilder();
            sb.append("ACK packet too short len=");
            sb.append(bArr != null ? bArr.length : 0);
            yc1.a(str, sb.toString());
            return;
        }
        int i2 = ((bArr[1] & 255) << 8) | (bArr[2] & 255);
        if (i2 < 5) {
            yc1.a(h, "ACK invalid Data length L=" + i2);
            return;
        }
        int i3 = i2 + 3;
        if (bArr.length < i3) {
            yc1.a(h, "ACK incomplete: need " + i3 + " bytes, have " + bArr.length);
            return;
        }
        int i4 = i2 - 5;
        byte b = bArr[3];
        byte b2 = bArr[4];
        byte[] bArrCopyOfRange = i4 > 0 ? Arrays.copyOfRange(bArr, 7, i2 + 2) : null;
        boolean z = bArr[i2 + 2] == 1;
        g(b, b2);
        tg3.j(new q2(b & 255, b2 & 255, z, bArrCopyOfRange));
    }

    private void s(byte b) {
        try {
            if (w()) {
                return;
            }
            byte[] bArrQ = q();
            if (b == 1) {
                yc1.a(h, "factory check");
            } else if (b == 2) {
                yc1.a(h, "factory light leakage");
                if (bArrQ[0] == 3) {
                    fb1 fb1Var = new fb1(ks1.c(da.c(bArrQ, 1, 5)), ks1.c(da.c(bArrQ, 5, 9)));
                    yc1.a(h, "factory light leakage testData:" + fb1Var);
                }
            }
        } catch (Exception e) {
            yc1.a(h, "handleFactory:" + e);
        }
    }

    private void t(byte b) {
        if (w()) {
            return;
        }
        byte[] bArrQ = q();
        if (b == 3) {
            new ts0(ks1.f(new byte[]{bArrQ[0], bArrQ[1]}), ks1.f(new byte[]{bArrQ[2], bArrQ[3]}), ks1.f(new byte[]{bArrQ[4], bArrQ[5]}));
        }
    }

    private void u(byte b) {
        byte[] bArr = this.a;
        if (bArr == null || bArr.length < 8) {
            yc1.a(h, "Preview command response too short");
            return;
        }
        byte b2 = bArr[5];
        byte b3 = bArr[6];
        if (b2 != 0) {
            if (b2 != 1) {
                yc1.a(h, "Unknown preview function module: " + ((int) b2) + " " + ((int) b3));
                return;
            }
            int i2 = (bArr[7] & 255) | ((b3 & 255) << 8);
            if (i2 == 0) {
                yc1.a(h, "Preview end command from device (no payload)");
                b62.t().v();
                return;
            }
            if (i2 != 1 || bArr.length < 9) {
                yc1.a(h, "Invalid preview end command payload length: " + i2 + ", expected: 0 or 1");
                return;
            }
            byte b4 = bArr[8];
            String str = h;
            StringBuilder sb = new StringBuilder();
            sb.append("Preview end command from device, status: ");
            sb.append(b4 == 0 ? "success" : "failed");
            yc1.a(str, sb.toString());
            b62.t().v();
            return;
        }
        int i3 = (bArr[7] & 255) | ((b3 & 255) << 8);
        if (i3 != 5 || bArr.length < 13) {
            yc1.a(h, "Invalid preview start response payload length: " + i3 + ", expected: 5, data length: " + this.a.length);
            return;
        }
        byte b5 = bArr[8];
        int iF = ks1.f(new byte[]{bArr[9], bArr[10]}) & 65535;
        byte[] bArr2 = this.a;
        int iF2 = ks1.f(new byte[]{bArr2[11], bArr2[12]}) & 65535;
        String str2 = h;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Preview start command response, status: ");
        sb2.append(b5 == 0 ? "success" : "failed");
        sb2.append(", screen: ");
        sb2.append(iF);
        sb2.append("x");
        sb2.append(iF2);
        yc1.a(str2, sb2.toString());
        b62 b62VarT = b62.t();
        m62 m62VarU = b62VarT.u();
        if ((m62VarU == null || !m62VarU.p()) && b5 == 0) {
            yc1.a(h, "Device initiated preview start, sending event");
            tg3.j(new pa0(iF, iF2));
        }
        b62VarT.w(b5, iF, iF2);
    }

    private void v(byte b) {
        byte[] bArrQ = q();
        if (b != 1) {
            if (b == 2) {
                tg3.j(new h13(P(bArrQ)));
                return;
            } else {
                if (b != 3) {
                    return;
                }
                tg3.j(new i13(f92.d(bArrQ)));
                return;
            }
        }
        int i2 = 0;
        byte b2 = bArrQ[0];
        byte[] bArrC = da.c(bArrQ, 1, bArrQ.length);
        ArrayList arrayList = new ArrayList();
        int length = bArrC.length / b2;
        while (i2 < b2) {
            int i3 = i2 * length;
            i2++;
            arrayList.add(P(da.c(bArrC, i3, i2 * length)));
        }
        tg3.j(new f13(arrayList));
    }

    private boolean w() {
        return this.f;
    }

    public void C(String str) {
        int i2;
        try {
            byte[] bArrG = d.g(str);
            my myVar = new my();
            myVar.t(ug3.e());
            myVar.z(bArrG[0]);
            myVar.u(bArrG[1]);
            myVar.F(ks1.f(new byte[]{bArrG[2], bArrG[3]}));
            myVar.v(ks1.f(new byte[]{bArrG[4], bArrG[5]}));
            int i3 = bArrG[6];
            byte[] bArr = new byte[i3];
            System.arraycopy(bArrG, 7, bArr, 0, i3);
            myVar.x(new String(bArr));
            int i4 = bArrG[i3 + 7];
            byte[] bArr2 = new byte[i4];
            int i5 = i3 + 8;
            System.arraycopy(bArrG, i5, bArr2, 0, i4);
            myVar.w(new String(bArr2));
            int i6 = i5 + i4;
            if (bArrG.length > i6) {
                myVar.r(bArrG[i6]);
            }
            int i7 = i6 + 1;
            if (bArrG.length > i7) {
                myVar.q(bArrG[i7]);
            }
            int i8 = i6 + 4;
            if (bArrG.length > i8) {
                short sI = ks1.i(bArrG[i6 + 2]);
                short sI2 = ks1.i(bArrG[i6 + 3]);
                short sI3 = ks1.i(bArrG[i8]);
                if (sI == 255) {
                    if (sI - sI2 != sI3) {
                        sI3 = 0;
                    }
                    myVar.C((byte) sI3);
                }
            }
            int i9 = i6 + 5;
            if (bArrG.length > i9) {
                i2 = bArrG[i9];
                if (bArrG.length > i9 + i2) {
                    byte[] bArr3 = new byte[i2];
                    System.arraycopy(bArrG, i6 + 6, bArr3, 0, i2);
                    myVar.s(d.c(bArr3));
                } else {
                    yc1.a(h, "customer code is error");
                }
            } else {
                i2 = 0;
            }
            int i10 = i9 + i2;
            int i11 = i10 + 1;
            if (bArrG.length > i11) {
                myVar.y(bArrG[i11]);
            }
            if (bArrG.length >= i10 + 4) {
                myVar.E((int) ks1.p(ks1.f(new byte[]{bArrG[i10 + 2], bArrG[3 + i10]})));
            }
            if (bArrG.length >= i10 + 6) {
                myVar.D((int) ks1.p(ks1.f(new byte[]{bArrG[4 + i10], bArrG[5 + i10]})));
            }
            if (bArrG.length >= i10 + 10) {
                short sF = ks1.f(new byte[]{bArrG[6 + i10], bArrG[7 + i10]});
                short sF2 = ks1.f(new byte[]{bArrG[i10 + 8], bArrG[i10 + 9]});
                myVar.B(sF);
                myVar.A(sF2);
            }
            yc1.a(h, "==========>>clockInfo:" + myVar);
            tg3.j(new oy(myVar, Constants.STR_EMPTY));
        } catch (Exception e) {
            tg3.j(new oy(null, e.toString()));
        }
    }

    public g13 P(byte[] bArr) {
        byte[] bArr2;
        if (bArr.length < 4) {
            throw new IllegalArgumentException("编码数据的长度必须至少为4字节");
        }
        int i2 = (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 24);
        int i3 = (i2 >> 21) & 2047;
        int i4 = (i2 >> 8) & 8191;
        int i5 = i2 & 255;
        int i6 = bArr.length >= 8 ? (bArr[4] & 255) | ((bArr[5] & 255) << 8) | ((bArr[6] & 255) << 16) | ((bArr[7] & 255) << 24) : 0;
        int i7 = bArr.length >= 9 ? bArr[8] & 255 : 0;
        if (bArr.length > 9) {
            byte[] bArr3 = new byte[bArr.length - 9];
            System.arraycopy(bArr, 9, bArr3, 0, bArr.length - 9);
            bArr2 = bArr3;
        } else {
            bArr2 = null;
        }
        String strReplaceAll = ug3.e().replaceAll(":", Constants.STR_EMPTY);
        return new g13(i3, i4, i5, zi2.e().Y(), strReplaceAll.substring(strReplaceAll.length() - 7), i6, i7, bArr2);
    }

    public byte U(int i2) {
        return this.a[i2];
    }

    public void V(String str) {
        String strL = pp.l(str, 0, 2);
        String strL2 = pp.l(str, 2, 4);
        String strL3 = pp.l(str, 6, 4);
        int iG = pp.g(strL);
        int iG2 = pp.g(strL2);
        int iG3 = pp.g(strL3);
        String str2 = h;
        StringBuilder sb = new StringBuilder();
        sb.append("抬腕开关---");
        sb.append(iG);
        sb.append("---开始时间---");
        sb.append(iG2);
        sb.append("--");
        int i2 = iG2 / 60;
        sb.append(i2);
        sb.append("---结束时间---");
        sb.append(iG3);
        sb.append("---");
        int i3 = iG3 / 60;
        sb.append(i3);
        yc1.a(str2, sb.toString());
        if ((iG == 0 || iG == 1) && i2 >= 0 && i2 <= 23 && i3 >= 0 && i3 <= 23) {
            qn qnVar = new qn();
            qnVar.c(iG == 1);
            qnVar.b(iG2);
            qnVar.a(iG3);
            tg3.j(qnVar);
            yc1.a(h, "------抬腕------ok");
        }
    }

    public void W(String str) {
        String strL = pp.l(str, 0, 2);
        String strL2 = pp.l(str, 2, 4);
        String strL3 = pp.l(str, 6, 4);
        int iG = pp.g(strL);
        int iG2 = pp.g(strL2);
        int iG3 = pp.g(strL3);
        String str2 = h;
        StringBuilder sb = new StringBuilder();
        sb.append("勿扰开关---");
        sb.append(iG);
        sb.append("---开始时间---");
        sb.append(iG2);
        sb.append("--");
        int i2 = iG2 / 60;
        sb.append(i2);
        sb.append("---结束时间---");
        sb.append(iG3);
        sb.append("---");
        int i3 = iG3 / 60;
        sb.append(i3);
        yc1.a(str2, sb.toString());
        if ((iG == 0 || iG == 1) && i2 >= 0 && i2 <= 23 && i3 >= 0 && i3 <= 23) {
            oc0 oc0Var = new oc0();
            oc0Var.b(x(iG + Constants.STR_EMPTY));
            oc0Var.c(iG2);
            oc0Var.a(iG3);
            tg3.j(oc0Var);
            yc1.a(h, "------勿扰------ok");
        }
    }

    public void X(String str) {
        String strL = pp.l(str, 0, 2);
        String strL2 = pp.l(str, 2, 2);
        String strL3 = pp.l(str, 4, 4);
        String strL4 = pp.l(str, 8, 4);
        String strL5 = pp.l(str, 12, 4);
        int iG = pp.g(strL);
        int iG2 = pp.g(strL2);
        int iG3 = pp.g(strL3);
        int iG4 = pp.g(strL4);
        int iG5 = pp.g(strL5);
        String str2 = h;
        StringBuilder sb = new StringBuilder();
        sb.append("心率自动测量开关---");
        sb.append(iG);
        sb.append("--心率辅助睡眠开关---");
        sb.append(iG2);
        sb.append("---心率测量频率---");
        sb.append(iG3);
        sb.append("---开始时间---");
        sb.append(iG4);
        sb.append("--");
        int i2 = iG4 / 60;
        sb.append(i2);
        sb.append("---结束时间---");
        sb.append(iG5);
        sb.append("---");
        int i3 = iG5 / 60;
        sb.append(i3);
        yc1.a(str2, sb.toString());
        if (iG == 0 || iG == 1) {
            if ((iG2 == 0 || iG2 == 1) && i2 >= 0 && i2 <= 23 && i3 >= 0 && i3 <= 23) {
                kw0 kw0Var = new kw0();
                kw0Var.d(x(iG + Constants.STR_EMPTY));
                kw0Var.a(x(iG2 + Constants.STR_EMPTY));
                kw0Var.c(iG3);
                kw0Var.e((long) iG4);
                kw0Var.b((long) iG5);
                tg3.j(kw0Var);
                yc1.a(h, "------心率自动测量------ok");
            }
        }
    }

    public void Y(String str) {
        String strL = pp.l(str, 0, 2);
        String strL2 = pp.l(str, 2, 2);
        pp.l(str, 4, 4);
        String strL3 = pp.l(str, 8, 2);
        String strL4 = pp.l(str, 10, 2);
        String strL5 = pp.l(str, 12, 2);
        String strL6 = pp.l(str, 14, 2);
        int iG = pp.g(strL);
        int iG2 = pp.g(strL2);
        int iG3 = pp.g(strL3);
        int iG4 = pp.g(strL4);
        int iG5 = pp.g(strL5);
        String strH = pp.h(strL6);
        yc1.a(h, "使能开关---" + iG2 + "---午休开关---" + iG + "---久坐时间---" + iG3 + "---开始提醒时间---" + iG4 + "---结束提醒时间---" + iG5 + "---重复为---" + strH);
        if (iG == 0 || iG == 1) {
            if ((iG2 == 0 || iG2 == 1) && iG3 >= 1 && iG3 <= 10 && iG4 >= 0 && iG4 <= 23 && iG5 >= 0 && iG5 <= 23) {
                yd1 yd1Var = new yd1();
                yd1Var.a(iG == 1);
                yd1Var.d(iG2 == 1);
                yd1Var.e(iG3);
                yd1Var.c(iG4);
                yd1Var.b(iG5);
                tg3.j(yd1Var);
                yc1.a(h, "------久坐提醒------ok");
            }
        }
    }

    public void Z(String str) {
        String strL = pp.l(str, 0, 2);
        String strL2 = pp.l(str, 2, 2);
        String strL3 = pp.l(str, 4, 2);
        String strL4 = pp.l(str, 6, 2);
        String strL5 = pp.l(str, 8, 2);
        String strL6 = pp.l(str, 10, 2);
        String strL7 = pp.l(str, 12, 2);
        String strL8 = pp.l(str, 14, 2);
        String strL9 = pp.l(str, 16, 2);
        String strL10 = pp.l(str, 18, 2);
        String strL11 = pp.l(str, 20, 2);
        String strL12 = rv2.i(str) >= 24 ? pp.l(str, 22, 2) : "00";
        yc1.a(h, "开关状态(01开启，00关闭)--来电提醒---" + strL + "---短信推送---" + strL2 + "---微信推送 ---" + strL3 + "---QQ信息推送---" + strL4 + "---FaceBook推送---" + strL5 + "---Twitter推送---" + strL6 + "---Skype推送---" + strL7 + "---Line推送---" + strL8 + "---Watsapp推送---" + strL9 + "---linkedIn推送---" + strL10 + "---KakaoTalk推送---" + strL12);
        if ((strL.equals("00") || strL.equals("01")) && ((strL2.equals("00") || strL2.equals("01")) && ((strL3.equals("00") || strL3.equals("01")) && ((strL4.equals("00") || strL4.equals("01")) && ((strL5.equals("00") || strL5.equals("01")) && ((strL6.equals("00") || strL6.equals("01")) && ((strL7.equals("00") || strL7.equals("01")) && ((strL8.equals("00") || strL8.equals("01")) && ((strL9.equals("00") || strL9.equals("01")) && ((strL10.equals("00") || strL10.equals("01")) && ((strL11.equals("00") || strL11.equals("01")) && (strL12.equals("00") || strL12.equals("01"))))))))))))) {
            oj1 oj1Var = new oj1();
            oj1Var.m(x(strL));
            oj1Var.t(x(strL2));
            oj1Var.w(x(strL3));
            oj1Var.s(x(strL4));
            oj1Var.n(x(strL5));
            oj1Var.v(x(strL6));
            oj1Var.u(x(strL7));
            oj1Var.q(x(strL8));
            oj1Var.x(x(strL9));
            oj1Var.p(x(strL10));
            oj1Var.o(x(strL11));
            oj1Var.r(x(strL12));
            tg3.j(oj1Var);
            yc1.a(h, "开关状态(01开启，00关闭)--来电提醒---ok");
        }
    }

    public void a0(String str) {
        String strL = pp.l(str, 0, 2);
        String strL2 = pp.l(str, 2, 4);
        String strL3 = pp.l(str, 6, 4);
        int iG = pp.g(strL);
        int iG2 = pp.g(strL2);
        int iG3 = pp.g(strL3);
        String str2 = h;
        StringBuilder sb = new StringBuilder();
        sb.append("睡眠开关---");
        sb.append(iG);
        sb.append("---开始时间---");
        sb.append(iG2);
        sb.append("--");
        int i2 = iG2 / 60;
        sb.append(i2);
        sb.append("---结束时间---");
        sb.append(iG3);
        sb.append("---");
        int i3 = iG3 / 60;
        sb.append(i3);
        yc1.a(str2, sb.toString());
        if ((iG == 0 || iG == 1) && i2 >= 0 && i2 <= 23 && i3 >= 0 && i3 <= 23) {
            nr2 nr2Var = new nr2();
            nr2Var.a(iG == 1);
            nr2Var.c(iG2);
            nr2Var.b(iG3);
            tg3.j(nr2Var);
            yc1.a(h, "------睡眠------ok");
        }
    }

    public void b0(String str) {
        int iC = pp.c(pp.h(str));
        yc1.a(h, "运动目标---" + iC);
        if (iC < 1000 || iC > 150000) {
            return;
        }
        tg3.j(new q03(iC));
        yc1.a(h, "------目标步数------ok");
    }

    public void c0(String str) {
        String strL = pp.l(str, 0, 2);
        String strL2 = pp.l(str, 2, 2);
        String strL3 = pp.l(str, 4, 2);
        String strL4 = pp.l(str, 6, 2);
        yc1.a(h, "开关状态(01开启，00关闭)--左右手配对方式---" + strL + "---配对状态---" + strL2 + "---语言类型 ---" + strL3 + "---震动---" + strL4);
        if (strL.equals("00") || strL.equals("01")) {
            if (strL2.equals("00") || strL2.equals("01")) {
                if (strL3.equals("00") || strL3.equals("01")) {
                    if (strL4.equals("00") || strL4.equals("01")) {
                        tg3.j(new ew0(x(strL)));
                        tg3.j(new oo2(x(strL4)));
                        yc1.a(h, "开关状态(01开启，00关闭)--马达开关---ok");
                    }
                }
            }
        }
    }

    public void d() {
        StringBuilder sb;
        String str;
        byte[] bArr = this.a;
        int i2 = 8;
        if (bArr.length >= 8) {
            int i3 = 0;
            if (bArr[0] != -51) {
                return;
            }
            int i4 = 6;
            int iG = pp.g(pp.d(pp.a(bArr, 6, 8)));
            byte[] bArrQ = q();
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            while (i5 < iG / 5) {
                int i6 = i5 * 5;
                String strD = pp.d(pp.a(bArrQ, Integer.valueOf(i6), Integer.valueOf(i6 + 5)));
                String strH = pp.h(strD);
                yc1.a(h, "闹铃数据----ItemValue-" + strD + "--alarms--" + strH);
                String strL = pp.l(strH, i3, i4);
                String strL2 = pp.l(strH, i4, 4);
                String strL3 = pp.l(strH, 10, 5);
                String strL4 = pp.l(strH, 15, 5);
                String strL5 = pp.l(strH, 20, i4);
                String strL6 = pp.l(strH, 32, i2);
                int iC = pp.c(strL) + 2000;
                Integer numValueOf = Integer.valueOf(iC);
                int iC2 = pp.c(strL2);
                Integer numValueOf2 = Integer.valueOf(iC2);
                int iC3 = pp.c(strL3);
                Integer numValueOf3 = Integer.valueOf(iC3);
                int iC4 = pp.c(strL4);
                Integer numValueOf4 = Integer.valueOf(iC4);
                int iC5 = pp.c(strL5);
                Integer numValueOf5 = Integer.valueOf(iC5);
                int i7 = iG;
                byte[] bArr2 = bArrQ;
                if (iC4 < 10) {
                    sb = new StringBuilder();
                    sb.append("0");
                    sb.append(numValueOf4);
                } else {
                    sb = new StringBuilder();
                    sb.append(numValueOf4);
                    sb.append(Constants.STR_EMPTY);
                }
                String string = sb.toString();
                if (iC5 < 10) {
                    str = "0" + numValueOf5;
                } else {
                    str = numValueOf5 + Constants.STR_EMPTY;
                }
                yc1.a(h, "闹铃数据值---years--" + numValueOf + "--month--" + numValueOf2 + "--day--" + numValueOf3 + "--hours--" + string + "--minute--" + str + "--weeks--" + strL6);
                arrayList.add(new e5((long) iC, (long) iC2, (long) iC3, (long) iC4, (long) iC5, 1L, qm2.N(strL6)));
                i5++;
                iG = i7;
                bArrQ = bArr2;
                i3 = 0;
                i2 = 8;
                i4 = 6;
            }
            tg3.j(new f5(arrayList));
        }
    }

    public void e(byte b) {
        switch (b) {
            case 1:
                yc1.a(h, "接收到控制app查找手机命令");
                tg3.j(new x90(DeviceControlAppEnum.FIND_PHONE));
                break;
            case 2:
                yc1.a(h, "接收到控制app拍照命令");
                tg3.j(new x90(DeviceControlAppEnum.TAKE_PHOTO));
                break;
            case 3:
                yc1.a(h, "接收到控制app进入拍照命令");
                tg3.j(new x90(DeviceControlAppEnum.ENTER_REMOTE_CAMERA));
                break;
            case 4:
                yc1.a(h, "接收到控制app退出拍照命令");
                tg3.j(new x90(DeviceControlAppEnum.EXIT_REMOTE_CAMERA));
                break;
            case 5:
            case 8:
                yc1.a(h, "接收到控制app退出心率测量命令");
                tg3.j(new x90(DeviceControlAppEnum.EXIT_HEART_AUTO));
                break;
            case 6:
                yc1.a(h, "接收到控制app退出血压测量命令");
                tg3.j(new x90(DeviceControlAppEnum.EXIT_BLOOD_PRESSURE));
                break;
            case 7:
                yc1.a(h, "hang up phone");
                tg3.j(new x90(DeviceControlAppEnum.HANG_UP));
                break;
            case 9:
                yc1.a(h, "answer phone");
                tg3.j(new x90(DeviceControlAppEnum.ANSWER));
                break;
            case 10:
                yc1.a(h, "switch up");
                tg3.j(new x90(DeviceControlAppEnum.PREVIOUS));
                break;
            case 11:
                yc1.a(h, "switch pause");
                tg3.j(new x90(DeviceControlAppEnum.PLAY_PAUSE));
                break;
            case 12:
                yc1.a(h, "switch down");
                tg3.j(new x90(DeviceControlAppEnum.NEXT));
                break;
            case 13:
                yc1.a(h, "接收到控制app退出血氧测量命令");
                tg3.j(new x90(DeviceControlAppEnum.EXIT_BLOOD_OXYGEN));
                break;
            case 14:
                yc1.a(h, "接收到控制app停止查找手机命令");
                tg3.j(new x90(DeviceControlAppEnum.STOP_FIND_PHONE));
                break;
            case 15:
                yc1.a(h, "同步时间指令");
                zi2.s();
                tg3.j(new x90(DeviceControlAppEnum.SYNCHRONIZE_TIME));
                break;
            case 16:
                yc1.a(h, "get imei");
                tg3.j(new x90(DeviceControlAppEnum.GET_IMEI));
                break;
        }
    }

    public void e0(String str) {
        String strH = pp.h(str);
        String strL = pp.l(strH, 0, 1);
        String strL2 = pp.l(strH, 1, 7);
        String strL3 = pp.l(strH, 8, 9);
        String strL4 = pp.l(strH, 17, 10);
        String strL5 = pp.l(strH, 27, 5);
        int iIntValue = Integer.valueOf(strL).intValue();
        int iC = pp.c(strL2);
        int iC2 = pp.c(strL3);
        int iC3 = pp.c(strL4);
        int iC4 = pp.c(strL5);
        yc1.a(h, "性别---" + iIntValue + "---年龄---" + iC + "---身高---" + iC2 + "---体重---" + iC3 + "---长度单位---" + iC4);
        if ((iIntValue == 0 || iIntValue == 1) && iC >= 6 && iC <= 127 && iC2 >= 100 && iC2 <= 250 && iC3 >= 30 && iC3 <= 180) {
            tg3.j(new ha3(iIntValue, iC, iC2, iC3, iC4));
            yc1.a(h, "------个人信息------ok");
        }
    }

    public void f() {
        byte[] bArr = this.a;
        if (bArr.length < 40 || bArr[0] != -51) {
            return;
        }
        String strD = pp.d(q());
        String strL = pp.l(strD, 2, 8);
        String strL2 = pp.l(strD, 12, 8);
        String strL3 = pp.l(strD, 22, 16);
        String strL4 = pp.l(strD, 40, 20);
        String strL5 = pp.l(strD, 62, 10);
        String strL6 = pp.l(strD, 74, 8);
        String strL7 = pp.l(strD, 84, 10);
        String strL8 = pp.l(strD, 96, 16);
        String strL9 = pp.l(strD, 114, 10);
        yc1.a(h, "第一个人信息---" + strL + "---第二目标步数---" + strL2 + "---第二久坐提醒---" + strL3 + "---第四推送开关---" + strL4 + "---第五睡眠检测开关---" + strL5 + "---第六段---" + strL6 + "---第七翻腕亮屏---" + strL7 + "---第八心率自动测量---" + strL8 + "---第九勿扰模式---" + strL9);
        e0(strL);
        b0(strL2);
        Y(strL3);
        Z(strL4);
        a0(strL5);
        c0(strL6);
        V(strL7);
        X(strL8);
        W(strL9);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean g(byte b, byte b2) {
        yc1.a(h, "接收到命令---commandId---" + ((int) b) + "---commandKey---" + ((int) b2));
        switch (b) {
            case 18:
                i(b2);
                return true;
            case 19:
            case 22:
            case 23:
            case 27:
            case 29:
            case 35:
            case 36:
            case 37:
            case 38:
            default:
                return true;
            case 20:
                yc1.a(h, "解绑手环ACK");
                return true;
            case 21:
                if (b2 == 7) {
                    e20.b = false;
                    e20.c.postDelayed(new Runnable() { // from class: od2
                        @Override // java.lang.Runnable
                        public final void run() {
                            e20.b = true;
                        }
                    }, 15000L);
                    tg3.j(new xy2(true));
                    return true;
                }
                if (b2 == 8) {
                    e20.c.postDelayed(new Runnable() { // from class: pd2
                        @Override // java.lang.Runnable
                        public final void run() {
                            e20.b = true;
                        }
                    }, 1000L);
                    tg3.j(new xy2(false));
                    return true;
                }
                if (b2 == 18) {
                    tg3.j(new xe0(ECGStatus.START.getStatus(), q()[0]));
                    return true;
                }
                if (b2 != 19) {
                    j(b2);
                    return true;
                }
                tg3.j(new xe0(ECGStatus.STOP.getStatus(), q()[0]));
                return true;
            case 24:
                if (b2 == 0) {
                    return false;
                }
                d();
                return true;
            case 25:
                f();
                return true;
            case 26:
                h();
                return true;
            case 28:
                e(b2);
                return true;
            case 30:
                s(b2);
                return true;
            case 31:
                h0(b2);
                return true;
            case 32:
                f0();
                return true;
            case 33:
                t(b2);
                return true;
            case 34:
                v(b2);
                return true;
            case 39:
                u(b2);
                return true;
        }
    }

    public void g0(a aVar, String str) {
        this.e = aVar;
        this.g = str;
        if (aVar != null) {
            this.c = aVar.a();
        }
        byte[] bArr = this.c;
        if (bArr == null || bArr.length == 0) {
            yc1.a(h, "resVal1 is null");
            return;
        }
        this.f = false;
        byte b = bArr[0];
        if (b == -36) {
            yc1.a(h, "resVal1[0] is ack");
            this.f = true;
            this.d = new byte[0];
            byte[] bArr2 = this.c;
            this.a = bArr2;
            r(bArr2);
            return;
        }
        if (b == -51 || bArr.length > 120) {
            this.d = new byte[0];
            this.a = new byte[0];
        }
        byte[] bArr3 = this.d;
        if (bArr3 == null || bArr3.length <= 0) {
            this.d = bArr;
        } else {
            this.d = l(bArr3, bArr);
        }
        int iG = pp.g(pp.d(pp.a(this.d, 1, 3)));
        Integer numValueOf = Integer.valueOf(iG);
        byte[] bArr4 = this.d;
        if (bArr4.length < 3) {
            yc1.a(h, "resVal2 is must greater 3");
            return;
        }
        byte[] bArrA = pp.a(bArr4, 3, Integer.valueOf(this.d.length));
        if (iG != bArrA.length && iG > bArrA.length) {
            e20.b = false;
            yc1.a(h, "收到数据包未完整--总长度-->" + numValueOf + "--接收长度-->" + bArrA.length + "--数据包2-->" + pp.d(this.d) + "--数据包1-->" + pp.d(this.c));
            return;
        }
        byte[] bArr5 = this.d;
        this.a = bArr5;
        this.c = new byte[0];
        this.d = new byte[0];
        if (bArr5[0] != -51 || iG != bArrA.length) {
            yc1.a(h, "收到数据包格式错误--总长度-->" + numValueOf + "--接收长度-->" + bArrA.length + "--数据包2-->" + pp.d(this.d) + "--数据包1-->" + pp.d(this.c));
            this.a = new byte[0];
            return;
        }
        yc1.a(h, "收到完整数据包--------value:" + pp.d(this.a));
        byte bU = U(3);
        byte bU2 = U(5);
        byte[] bArr6 = this.a;
        if (bArr6[0] == -51) {
            byte[] bArrL = ks1.l(pp.c(pp.h(pp.d(new byte[]{bArr6[1], bArr6[2]}))) + 3);
            byte[] bArrX = qm2.x(bU, bU2, new byte[]{bArrL[2], bArrL[3]}, k(this.a));
            this.b = bArrX;
            this.e.b(bArrX);
            yc1.a(h, "收到命令返回--------ack------" + pp.d(this.b));
        }
        if (this.a.length >= 5) {
            e20.c.postDelayed(new Runnable() { // from class: nd2
                @Override // java.lang.Runnable
                public final void run() {
                    e20.b = true;
                }
            }, 800L);
            g(bU, bU2);
            e92.a.a().d(bU, bU2, q());
        } else {
            yc1.a(h, "数据包长度小于5");
            this.c = new byte[0];
            this.d = new byte[0];
            this.a = new byte[0];
        }
    }

    public void h() {
        byte[] bArrQ = q();
        String strD = pp.d(bArrQ);
        byte bU = U(5);
        yc1.a(h, "第" + ((int) bU) + "个人信息---" + strD);
        switch (bU) {
            case 1:
                e0(strD);
                break;
            case 2:
                b0(strD);
                break;
            case 3:
                Y(strD);
                break;
            case 4:
                Z(strD);
                break;
            case 5:
                a0(strD);
                break;
            case 6:
                c0(strD);
                break;
            case 7:
                V(strD);
                break;
            case 8:
                X(strD);
                break;
            case 9:
                W(strD);
                break;
            case 10:
                tg3.j(new dy(m(strD)));
                break;
            case 12:
                tg3.j(new ey(fy.a(n(strD))));
                break;
            case 13:
                int[] iArrH = H(bArrQ);
                tg3.j(new b40(iArrH[0], iArrH[1]));
                break;
            case 14:
                tg3.j(new gt1(pp.a(this.a, 7, Integer.valueOf(this.a.length))));
                break;
            case 15:
                d0(strD);
                break;
            case 16:
                G(bArrQ);
                break;
            case 17:
                N(bArrQ);
                break;
            case 18:
                O(bArrQ);
                break;
            case 19:
                L(bArrQ);
                break;
            case 20:
                tg3.j(new k33(ks1.f(new byte[]{bArrQ[0], bArrQ[1]})));
                break;
            case 21:
                I(bArrQ);
                break;
            case 22:
                M(bArrQ);
                break;
            case 23:
                E(bArrQ);
                break;
            case 24:
                F(bArrQ);
                break;
            case 25:
                tg3.j(new jy0(d.c(bArrQ)));
                break;
            case 27:
                J(bArrQ);
                break;
            case 28:
                K(bArrQ);
                break;
        }
    }

    public void i(byte b) {
        yc1.a(h, "Settings:" + d.a(this.a));
        byte[] bArrQ = this.a.length > 8 ? q() : null;
        if (b == 34) {
            if (w() || bArrQ == null) {
                return;
            }
            N(bArrQ);
            return;
        }
        if (b == 35) {
            if (w() || bArrQ == null) {
                return;
            }
            O(bArrQ);
            return;
        }
        if (b != 39) {
            return;
        }
        yc1.a(h, "settings target cal:" + d.a(this.a));
        if (w()) {
            return;
        }
        M(bArrQ);
    }

    public void j(byte b) {
        Exception exc;
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        String string;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        StringBuilder sb8;
        StringBuilder sb9;
        StringBuilder sb10;
        StringBuilder sb11;
        StringBuilder sb12;
        String str2 = "心率数据-";
        int i2 = 21;
        String str3 = "-";
        try {
            byte[] bArr = this.a;
            if (bArr.length < 8 || bArr[0] != -51) {
                return;
            }
            try {
                if (b < 21) {
                    String strH = pp.h(pp.d(pp.a(bArr, 8, 10)));
                    String strL = pp.l(strH, 1, 6);
                    String strL2 = pp.l(strH, 7, 4);
                    String strL3 = pp.l(strH, 11, 5);
                    Integer numValueOf = Integer.valueOf(pp.c(strL) + 2000);
                    int iC = pp.c(strL2);
                    Integer numValueOf2 = Integer.valueOf(iC);
                    int iC2 = pp.c(strL3);
                    Integer numValueOf3 = Integer.valueOf(iC2);
                    String str4 = Constants.STR_EMPTY;
                    String str5 = "0";
                    String str6 = iC < 10 ? "0" + numValueOf2 : numValueOf2 + Constants.STR_EMPTY;
                    String str7 = iC2 < 10 ? "0" + numValueOf3 : numValueOf3 + Constants.STR_EMPTY;
                    yc1.a(h, "头部解析时间---date---" + numValueOf + "-" + str6 + "-" + str7);
                    String str8 = " ";
                    String str9 = "-->";
                    String str10 = "--secs--";
                    String str11 = ":";
                    String str12 = "--heart:";
                    if (b == 2) {
                        String str13 = str6;
                        String str14 = str7;
                        String str15 = "--minute:";
                        String str16 = "-->";
                        int iG = pp.g(pp.d(pp.a(this.a, 11, 12)));
                        byte[] bArrA = pp.a(this.a, 12, Integer.valueOf(this.a.length));
                        int i3 = 0;
                        while (i3 < iG) {
                            int i4 = i3 * 8;
                            String strD = pp.d(pp.a(bArrA, Integer.valueOf(i4), Integer.valueOf(i4 + 8)));
                            String strH2 = pp.h(strD);
                            String str17 = h;
                            StringBuilder sb13 = new StringBuilder();
                            int i5 = iG;
                            sb13.append("运动返回数据strItme-");
                            sb13.append(i3);
                            sb13.append(str11);
                            sb13.append(strD);
                            sb13.append(str16);
                            sb13.append(strH2);
                            yc1.a(str17, sb13.toString());
                            int iC3 = pp.c(pp.l(strH2, 0, 15));
                            Integer numValueOf4 = Integer.valueOf(iC3);
                            int iC4 = pp.c(pp.l(strH2, 15, 17));
                            Integer numValueOf5 = Integer.valueOf(iC4);
                            byte[] bArr2 = bArrA;
                            String str18 = str16;
                            int iC5 = pp.c(pp.l(strH2, 32, 11));
                            Integer numValueOf6 = Integer.valueOf(iC5);
                            int i6 = i3;
                            int iC6 = pp.c(pp.l(strH2, 43, 2));
                            Integer numValueOf7 = Integer.valueOf(iC6);
                            int iC7 = pp.c(pp.l(strH2, 45, 19));
                            Integer numValueOf8 = Integer.valueOf(iC7);
                            int i7 = iC5 * 60;
                            int iFloor = (int) Math.floor(i7 / 60);
                            int i8 = i7 % 60;
                            if (iFloor < 10) {
                                sb = new StringBuilder();
                                sb.append(str5);
                                sb.append(iFloor);
                            } else {
                                sb = new StringBuilder();
                                sb.append(iFloor);
                                sb.append(Constants.STR_EMPTY);
                            }
                            String string2 = sb.toString();
                            if (i8 < 10) {
                                sb2 = new StringBuilder();
                                sb2.append(str5);
                                sb2.append(i8);
                            } else {
                                sb2 = new StringBuilder();
                                sb2.append(i8);
                                sb2.append(Constants.STR_EMPTY);
                            }
                            String string3 = sb2.toString();
                            StringBuilder sb14 = new StringBuilder();
                            sb14.append(numValueOf);
                            sb14.append("-");
                            String str19 = str5;
                            String str20 = str13;
                            sb14.append(str20);
                            sb14.append("-");
                            str13 = str20;
                            String str21 = str14;
                            sb14.append(str21);
                            sb14.append(" ");
                            sb14.append(string2);
                            sb14.append(str11);
                            sb14.append(string3);
                            str14 = str21;
                            sb14.append(":00");
                            Timestamp timestampValueOf = Timestamp.valueOf(sb14.toString());
                            StringBuilder sb15 = new StringBuilder();
                            String str22 = str11;
                            sb15.append("运动解析数据--hours:");
                            sb15.append(string2);
                            String str23 = str15;
                            sb15.append(str23);
                            sb15.append(string3);
                            sb15.append("--calory:");
                            sb15.append(numValueOf4);
                            sb15.append("--mode:");
                            sb15.append(numValueOf7);
                            sb15.append("--offset:");
                            sb15.append(numValueOf6);
                            sb15.append("--step:");
                            sb15.append(numValueOf8);
                            sb15.append("--min:--distance:");
                            sb15.append(numValueOf5);
                            yc1.a(h, sb15.toString());
                            long time = timestampValueOf.getTime();
                            us2 us2Var = new us2();
                            us2Var.a(iC3);
                            us2Var.d(iC6);
                            us2Var.e(iC7);
                            us2Var.c(iC4);
                            us2Var.b(f33.b(time));
                            tg3.j(us2Var);
                            i3 = i6 + 1;
                            iG = i5;
                            str15 = str23;
                            bArrA = bArr2;
                            str5 = str19;
                            str11 = str22;
                            str16 = str18;
                        }
                    } else if (b == 3) {
                        String str24 = str6;
                        String str25 = str7;
                        String str26 = "-";
                        String str27 = "--minute:";
                        String str28 = " ";
                        Integer num = numValueOf;
                        String str29 = "-->";
                        String str30 = Constants.STR_EMPTY;
                        try {
                            int iG2 = pp.g(pp.d(pp.a(this.a, 11, 12)));
                            byte[] bArrA2 = pp.a(this.a, 12, Integer.valueOf(this.a.length));
                            int i9 = 0;
                            while (i9 < iG2) {
                                int i10 = i9 * 4;
                                String strD2 = pp.d(pp.a(bArrA2, Integer.valueOf(i10), Integer.valueOf(i10 + 4)));
                                String strH3 = pp.h(strD2);
                                String str31 = h;
                                StringBuilder sb16 = new StringBuilder();
                                sb16.append("睡眠数据-");
                                sb16.append(i9);
                                sb16.append(":");
                                sb16.append(strD2);
                                String str32 = str29;
                                sb16.append(str32);
                                sb16.append(strH3);
                                yc1.a(str31, sb16.toString());
                                int iC8 = pp.c(pp.l(strH3, 0, 16));
                                Integer numValueOf9 = Integer.valueOf(iC8);
                                int iC9 = pp.c(pp.l(strH3, 24, 8));
                                Integer numValueOf10 = Integer.valueOf(iC9);
                                int iFloor2 = (int) Math.floor(iC8 / 60);
                                int i11 = iC8 % 60;
                                String str33 = h;
                                StringBuilder sb17 = new StringBuilder();
                                int i12 = iG2;
                                sb17.append("睡眠数据解析--睡眠类型:");
                                sb17.append(numValueOf10);
                                sb17.append("--offset:");
                                sb17.append(numValueOf9);
                                sb17.append("--hours:");
                                sb17.append(iFloor2);
                                sb17.append(str27);
                                sb17.append(i11);
                                yc1.a(str33, sb17.toString());
                                if (iFloor2 < 10) {
                                    string = "0" + iFloor2;
                                    str = str30;
                                } else {
                                    StringBuilder sb18 = new StringBuilder();
                                    sb18.append(iFloor2);
                                    str = str30;
                                    sb18.append(str);
                                    string = sb18.toString();
                                }
                                if (i11 < 10) {
                                    sb3 = new StringBuilder();
                                    sb3.append("0");
                                    sb3.append(i11);
                                } else {
                                    sb3 = new StringBuilder();
                                    sb3.append(i11);
                                    sb3.append(str);
                                }
                                String str34 = string + ":" + sb3.toString();
                                StringBuilder sb19 = new StringBuilder();
                                Integer num2 = num;
                                sb19.append(num2);
                                String str35 = str26;
                                sb19.append(str35);
                                String str36 = str24;
                                sb19.append(str36);
                                sb19.append(str35);
                                String str37 = str25;
                                sb19.append(str37);
                                byte[] bArr3 = bArrA2;
                                String str38 = str28;
                                sb19.append(str38);
                                sb19.append(str34);
                                sb19.append(":00");
                                Timestamp timestampValueOf2 = Timestamp.valueOf(sb19.toString());
                                lr2 lr2Var = new lr2();
                                String str39 = str27;
                                str24 = str36;
                                str25 = str37;
                                lr2Var.a(new Date(timestampValueOf2.getTime()));
                                lr2Var.c(iC9);
                                lr2Var.b(ug3.e());
                                tg3.j(lr2Var);
                                i9++;
                                iG2 = i12;
                                str28 = str38;
                                str29 = str32;
                                str30 = str;
                                num = num2;
                                str26 = str35;
                                bArrA2 = bArr3;
                                str27 = str39;
                            }
                        } catch (Exception e) {
                            exc = e;
                        }
                    } else if (b == 4) {
                        String str40 = "--sec--";
                        String str41 = "心率数据-";
                        String str42 = str6;
                        String str43 = str7;
                        String str44 = "-";
                        String str45 = " ";
                        String str46 = "-->";
                        byte b2 = pp.a(this.a, 11, 12)[0];
                        byte[] bArrA3 = pp.a(this.a, 12, Integer.valueOf(this.a.length));
                        int i13 = 0;
                        while (i13 < b2) {
                            int i14 = i13 * 6;
                            String strD3 = pp.d(pp.a(bArrA3, Integer.valueOf(i14), Integer.valueOf(i14 + 6)));
                            String strH4 = pp.h(strD3);
                            String str47 = h;
                            StringBuilder sb20 = new StringBuilder();
                            byte b3 = b2;
                            String str48 = str41;
                            sb20.append(str48);
                            sb20.append(i13);
                            sb20.append(":");
                            sb20.append(strD3);
                            String str49 = str46;
                            sb20.append(str49);
                            sb20.append(strH4);
                            yc1.a(str47, sb20.toString());
                            int iC10 = pp.c(pp.l(strH4, 0, 32));
                            str41 = str48;
                            Integer numValueOf11 = Integer.valueOf(iC10);
                            byte[] bArr4 = bArrA3;
                            int iC11 = pp.c(pp.l(strH4, 32, 8));
                            Integer numValueOf12 = Integer.valueOf(iC11);
                            str46 = str49;
                            int iC12 = pp.c(pp.l(strH4, 40, 8));
                            int iFloor3 = (int) Math.floor(iC10 / 60);
                            int iFloor4 = (int) Math.floor(iFloor3 / 60);
                            int i15 = iFloor3 % 60;
                            int i16 = (iC10 - (iFloor4 * 3600)) - (i15 * 60);
                            if (i16 < 10) {
                                sb4 = new StringBuilder();
                                sb4.append("0");
                                sb4.append(i16);
                            } else {
                                sb4 = new StringBuilder();
                                sb4.append(i16);
                                sb4.append(str4);
                            }
                            String string4 = sb4.toString();
                            int i17 = i13;
                            if (iFloor4 < 10) {
                                sb5 = new StringBuilder();
                                sb5.append("0");
                                sb5.append(iFloor4);
                            } else {
                                sb5 = new StringBuilder();
                                sb5.append(iFloor4);
                                sb5.append(str4);
                            }
                            String string5 = sb5.toString();
                            if (i15 < 10) {
                                sb6 = new StringBuilder();
                                sb6.append("0");
                                sb6.append(i15);
                            } else {
                                sb6 = new StringBuilder();
                                sb6.append(i15);
                                sb6.append(str4);
                            }
                            String string6 = sb6.toString();
                            StringBuilder sb21 = new StringBuilder();
                            sb21.append(numValueOf);
                            Integer num3 = numValueOf;
                            String str50 = str44;
                            sb21.append(str50);
                            String str51 = str4;
                            String str52 = str42;
                            sb21.append(str52);
                            sb21.append(str50);
                            str42 = str52;
                            String str53 = str43;
                            sb21.append(str53);
                            str43 = str53;
                            String str54 = str45;
                            sb21.append(str54);
                            sb21.append(string5);
                            sb21.append(":");
                            sb21.append(string6);
                            sb21.append(":");
                            sb21.append(string4);
                            String string7 = sb21.toString();
                            String str55 = h;
                            str45 = str54;
                            StringBuilder sb22 = new StringBuilder();
                            sb22.append("心率解析值--hours:");
                            sb22.append(string5);
                            sb22.append("--minute:");
                            sb22.append(string6);
                            String str56 = str40;
                            sb22.append(str56);
                            sb22.append(i16);
                            sb22.append(str12);
                            sb22.append(numValueOf12);
                            sb22.append(str10);
                            sb22.append(numValueOf11);
                            sb22.append("--heartStatus--");
                            sb22.append(iC12);
                            yc1.a(str55, sb22.toString());
                            Timestamp timestampValueOf3 = Timestamp.valueOf(string7);
                            lh1 lh1Var = new lh1();
                            lh1Var.a(new Date(timestampValueOf3.getTime()));
                            lh1Var.b(iC11);
                            lh1Var.c((byte) iC12);
                            tg3.j(lh1Var);
                            str40 = str56;
                            bArrA3 = bArr4;
                            str4 = str51;
                            str44 = str50;
                            numValueOf = num3;
                            i13 = i17 + 1;
                            b2 = b3;
                        }
                    } else if (b == 5) {
                        String str57 = str7;
                        String str58 = "--minute:";
                        String str59 = " ";
                        String str60 = "-->";
                        int iG3 = pp.g(pp.d(pp.a(this.a, 11, 12)));
                        byte[] bArrA4 = pp.a(this.a, 12, Integer.valueOf(this.a.length));
                        int i18 = 0;
                        while (i18 < iG3) {
                            int i19 = i18 * 6;
                            String strD4 = pp.d(pp.a(bArrA4, Integer.valueOf(i19), Integer.valueOf(i19 + 6)));
                            String strH5 = pp.h(strD4);
                            String str61 = h;
                            StringBuilder sb23 = new StringBuilder();
                            sb23.append("血压数据-");
                            sb23.append(i18);
                            sb23.append(":");
                            sb23.append(strD4);
                            String str62 = str60;
                            sb23.append(str62);
                            sb23.append(strH5);
                            yc1.a(str61, sb23.toString());
                            int iC13 = pp.c(pp.l(strH5, 0, 32));
                            int iC14 = pp.c(pp.l(strH5, 32, 8));
                            Integer numValueOf13 = Integer.valueOf(iC14);
                            int i20 = iG3;
                            byte[] bArr5 = bArrA4;
                            int iC15 = pp.c(pp.l(strH5, 40, 8));
                            Integer numValueOf14 = Integer.valueOf(iC15);
                            int i21 = i18;
                            str60 = str62;
                            int iFloor5 = (int) Math.floor(iC13 / 60);
                            int iFloor6 = (int) Math.floor(iFloor5 / 60);
                            int i22 = iFloor5 % 60;
                            int i23 = (iC13 - (iFloor6 * 3600)) - (i22 * 60);
                            if (i23 < 10) {
                                sb7 = new StringBuilder();
                                sb7.append("0");
                                sb7.append(i23);
                            } else {
                                sb7 = new StringBuilder();
                                sb7.append(i23);
                                sb7.append(Constants.STR_EMPTY);
                            }
                            String string8 = sb7.toString();
                            if (iFloor6 < 10) {
                                sb8 = new StringBuilder();
                                sb8.append("0");
                                sb8.append(iFloor6);
                            } else {
                                sb8 = new StringBuilder();
                                sb8.append(iFloor6);
                                sb8.append(Constants.STR_EMPTY);
                            }
                            String string9 = sb8.toString();
                            if (i22 < 10) {
                                sb9 = new StringBuilder();
                                sb9.append("0");
                                sb9.append(i22);
                            } else {
                                sb9 = new StringBuilder();
                                sb9.append(i22);
                                sb9.append(Constants.STR_EMPTY);
                            }
                            String string10 = sb9.toString();
                            StringBuilder sb24 = new StringBuilder();
                            sb24.append(numValueOf);
                            sb24.append(str3);
                            sb24.append(str6);
                            sb24.append(str3);
                            String str63 = str57;
                            sb24.append(str63);
                            str57 = str63;
                            String str64 = str59;
                            sb24.append(str64);
                            sb24.append(string9);
                            sb24.append(":");
                            sb24.append(string10);
                            sb24.append(":");
                            sb24.append(string8);
                            Timestamp timestampValueOf4 = Timestamp.valueOf(sb24.toString());
                            str59 = str64;
                            String str65 = h;
                            String str66 = str6;
                            StringBuilder sb25 = new StringBuilder();
                            sb25.append("血压解析值--hours:");
                            sb25.append(string9);
                            String str67 = str58;
                            sb25.append(str67);
                            sb25.append(string10);
                            sb25.append("--sec:");
                            sb25.append(string8);
                            sb25.append("--血压高值:");
                            sb25.append(numValueOf13);
                            sb25.append("--血压低值:");
                            sb25.append(numValueOf14);
                            yc1.a(str65, sb25.toString());
                            tg3.j(new kh1(new Date(timestampValueOf4.getTime()), iC15, iC14));
                            i18 = i21 + 1;
                            iG3 = i20;
                            str58 = str67;
                            bArrA4 = bArr5;
                            str6 = str66;
                            str3 = str3;
                        }
                    } else if (b == 12) {
                        try {
                            byte[] bArr6 = this.a;
                            if (bArr6.length < 12) {
                                yc1.a(h, "real steps length is short:" + this.a.length);
                                return;
                            }
                            byte[] bArrA5 = pp.a(bArr6, 10, Integer.valueOf(this.a.length));
                            yc1.a(h, "请求获取天总结实时数据--strDayItemValues-->" + pp.d(bArrA5));
                            int iG4 = pp.g(pp.d(pp.a(bArrA5, 0, 4)));
                            Integer numValueOf15 = Integer.valueOf(iG4);
                            int iG5 = pp.g(pp.d(pp.a(bArrA5, 4, 8)));
                            int iG6 = pp.g(pp.d(pp.a(bArrA5, 8, 10)));
                            Integer numValueOf16 = Integer.valueOf(iG6);
                            int iG7 = pp.g(pp.d(pp.a(bArrA5, 10, 12)));
                            int iG8 = pp.g(pp.d(pp.a(bArrA5, 12, 14)));
                            int iG9 = pp.g(pp.d(pp.a(bArrA5, 14, 16)));
                            int iG10 = pp.g(pp.d(pp.a(bArrA5, 16, 18)));
                            pp.g(pp.d(pp.a(bArrA5, 18, 20)));
                            if (iG4 > 100000) {
                                numValueOf15 = 100000;
                            }
                            if (numValueOf15.intValue() < 0) {
                                numValueOf15 = 0;
                            }
                            yc1.a(h, "请求获取天总结实时数据--step-->" + numValueOf15 + "--calory-->" + numValueOf16 + "--distance-->" + (iG5 / 1000.0f) + ";excerciseTime:" + iG10);
                            ld2 ld2Var = new ld2();
                            ld2Var.b(iG5);
                            ld2Var.g(numValueOf15.intValue());
                            ld2Var.a(iG6);
                            ld2Var.e(iG10);
                            ld2Var.f(iG7);
                            ld2Var.c(iG9);
                            ld2Var.d(iG8);
                            tg3.j(ld2Var);
                        } catch (Exception e2) {
                            yc1.a(h, "PBSmartBandCommandIdSportKeyDayDataRecive:" + e2);
                        }
                    } else if (b == 17) {
                        Q();
                    } else if (b == 20) {
                        String str68 = "--sec--";
                        byte b4 = pp.a(this.a, 11, 12)[0];
                        String str69 = "--minute:";
                        byte[] bArrA6 = pp.a(this.a, 12, Integer.valueOf(this.a.length));
                        int i24 = 0;
                        while (i24 < b4) {
                            int i25 = i24 * 5;
                            byte b5 = b4;
                            String strD5 = pp.d(pp.a(bArrA6, Integer.valueOf(i25), Integer.valueOf(i25 + 5)));
                            String strH6 = pp.h(strD5);
                            byte[] bArr7 = bArrA6;
                            yc1.a(h, str2 + i24 + ":" + strD5 + str9 + strH6);
                            int iC16 = pp.c(pp.l(strH6, 0, 32));
                            Integer numValueOf17 = Integer.valueOf(iC16);
                            String str70 = str2;
                            int iC17 = pp.c(pp.l(strH6, 32, 8));
                            Integer numValueOf18 = Integer.valueOf(iC17);
                            int i26 = i24;
                            int iFloor7 = (int) Math.floor((double) (iC16 / 60));
                            int iFloor8 = (int) Math.floor(iFloor7 / 60);
                            int i27 = iFloor7 % 60;
                            int i28 = (iC16 - (iFloor8 * 3600)) - (i27 * 60);
                            if (i28 < 10) {
                                sb10 = new StringBuilder();
                                sb10.append("0");
                                sb10.append(i28);
                            } else {
                                sb10 = new StringBuilder();
                                sb10.append(i28);
                                sb10.append(Constants.STR_EMPTY);
                            }
                            String string11 = sb10.toString();
                            String str71 = str9;
                            if (iFloor8 < 10) {
                                sb11 = new StringBuilder();
                                sb11.append("0");
                                sb11.append(iFloor8);
                            } else {
                                sb11 = new StringBuilder();
                                sb11.append(iFloor8);
                                sb11.append(Constants.STR_EMPTY);
                            }
                            String string12 = sb11.toString();
                            if (i27 < 10) {
                                sb12 = new StringBuilder();
                                sb12.append("0");
                                sb12.append(i27);
                            } else {
                                sb12 = new StringBuilder();
                                sb12.append(i27);
                                sb12.append(Constants.STR_EMPTY);
                            }
                            String string13 = sb12.toString();
                            String str72 = numValueOf + "-" + str6 + "-" + str7 + str8 + string12 + ":" + string13 + ":" + string11;
                            String str73 = h;
                            String str74 = str8;
                            StringBuilder sb26 = new StringBuilder();
                            String str75 = str7;
                            sb26.append("血氧解析值--hours:");
                            sb26.append(string12);
                            String str76 = str69;
                            sb26.append(str76);
                            sb26.append(string13);
                            String str77 = str68;
                            sb26.append(str77);
                            sb26.append(i28);
                            String str78 = str12;
                            sb26.append(str78);
                            sb26.append(numValueOf18);
                            String str79 = str10;
                            sb26.append(str79);
                            sb26.append(numValueOf17);
                            yc1.a(str73, sb26.toString());
                            str68 = str77;
                            str69 = str76;
                            tg3.j(new mh1(new Date(Timestamp.valueOf(str72).getTime()), iC17));
                            i24 = i26 + 1;
                            str12 = str78;
                            str10 = str79;
                            bArrA6 = bArr7;
                            str2 = str70;
                            str9 = str71;
                            str8 = str74;
                            str7 = str75;
                            b4 = b5;
                        }
                    }
                } else {
                    try {
                        if (b == 21) {
                            byte[] bArrQ = q();
                            short length = (short) (bArrQ.length / 20);
                            yc1.a(h, "sports data sportsItemNum:" + ((int) length));
                            int i29 = 0;
                            while (i29 < length) {
                                int i30 = i29 * 21;
                                byte[] bArrA7 = pp.a(bArrQ, Integer.valueOf(i30), Integer.valueOf(i30 + i2));
                                String strH7 = pp.h(pp.d(new byte[]{bArrA7[0], bArrA7[1], bArrA7[2], bArrA7[3]}));
                                Date date = new Date(Timestamp.valueOf(cn1.c(Integer.valueOf(pp.c(pp.l(strH7, 0, 6)) + 2000), Integer.valueOf(pp.c(pp.l(strH7, 6, 4))), Integer.valueOf(pp.c(pp.l(strH7, 10, 5))), Integer.valueOf(pp.c(pp.l(strH7, 15, 5))), Integer.valueOf(pp.c(pp.l(strH7, 20, 6))), Integer.valueOf(pp.c(pp.l(strH7, 26, 6))))).getTime());
                                byte b6 = bArrA7[4];
                                int iB = ks1.b(new byte[]{bArrA7[5], bArrA7[6], bArrA7[7], bArrA7[8]});
                                short sF = ks1.f(new byte[]{bArrA7[9], bArrA7[10]});
                                short sF2 = ks1.f(new byte[]{bArrA7[11], bArrA7[12]});
                                byte b7 = bArrA7[13];
                                short sF3 = ks1.f(new byte[]{bArrA7[14], bArrA7[15]});
                                byte b8 = bArrA7[16];
                                byte b9 = bArrA7[17];
                                byte[] bArr8 = bArrQ;
                                short sF4 = ks1.f(new byte[]{bArrA7[18], bArrA7[19]});
                                vg3 vg3Var = new vg3();
                                vg3Var.b(date);
                                vg3Var.g(b6);
                                vg3Var.c(iB);
                                vg3Var.a(b7);
                                vg3Var.i(sF2);
                                vg3Var.j(sF);
                                vg3Var.h(sF3);
                                vg3Var.f(b8);
                                vg3Var.e(b9);
                                vg3Var.d(sF4);
                                tg3.j(vg3Var);
                                yc1.a(h, "Sports model" + vg3Var);
                                i29++;
                                bArrQ = bArr8;
                                i2 = 21;
                            }
                            return;
                        }
                        if (b == 25) {
                            short sF5 = ks1.f(pp.a(bArr, 8, 10));
                            byte[] bArrA8 = pp.a(this.a, 10, Integer.valueOf(this.a.length));
                            ArrayList arrayList = new ArrayList();
                            for (int i31 = 0; i31 < sF5; i31++) {
                                int i32 = i31 * 6;
                                byte[] bArrA9 = pp.a(bArrA8, Integer.valueOf(i32), Integer.valueOf(i32 + 6));
                                arrayList.add(new vs2(new Date(Timestamp.valueOf(cn1.b(Integer.valueOf(bArrA9[0] + 2000), Integer.valueOf(bArrA9[1]), Integer.valueOf(bArrA9[2]), Integer.valueOf(bArrA9[3]), Integer.valueOf(bArrA9[4]))).getTime()), bArrA9[5]));
                            }
                            tg3.j(new ws2(arrayList));
                            return;
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                return;
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
        }
        exc = e;
        yc1.a(h, "parse exception:" + exc);
    }

    public String p() {
        return this.g;
    }

    public boolean x(String str) {
        return y(str).equals("1");
    }

    public String y(String str) {
        return (str.equals("00") || str == "00") ? "0" : "1";
    }
}
