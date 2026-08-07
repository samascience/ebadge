package defpackage;

import com.baji.protocol.model.ProtocolConstants;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.tencent.connect.common.Constants;
import com.tencent.open.apireq.BaseResp;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class qm2 {
    public static byte[] A(oj1 oj1Var) {
        return t(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, (byte) 7, pp.i(o(oj1Var.a()) + o(oj1Var.h()) + o(oj1Var.k()) + o(oj1Var.g()) + o(oj1Var.b()) + o(oj1Var.j()) + o(oj1Var.i()) + o(oj1Var.e()) + o(oj1Var.l()) + o(oj1Var.d()) + o(oj1Var.c()) + o(oj1Var.f())));
    }

    public static byte[] B(boolean z) {
        return a(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE, z ? (byte) 1 : (byte) 0);
    }

    public static byte[] C(boolean z) {
        return a(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS, z ? (byte) 1 : (byte) 0);
    }

    public static byte[] D(byte b) {
        return p((byte) 26, b);
    }

    public static byte[] E(int i) {
        return a(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, (byte) 21, (byte) i);
    }

    public static byte[] F(int i) {
        return t(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, (byte) 3, pp.j(i));
    }

    public static byte[] G() {
        Map mapA = a70.a();
        Integer numValueOf = Integer.valueOf(mapA.get("year").toString());
        Integer numValueOf2 = Integer.valueOf(mapA.get("month").toString());
        Integer numValueOf3 = Integer.valueOf(mapA.get("day").toString());
        Integer numValueOf4 = Integer.valueOf(mapA.get("hour").toString());
        Integer numValueOf5 = Integer.valueOf(mapA.get("minute").toString());
        int iIntValue = Integer.valueOf(mapA.get("second").toString()).intValue() | ((numValueOf.intValue() + BaseResp.CODE_ERROR_PARAMS) << 26) | (numValueOf2.intValue() << 22) | (numValueOf3.intValue() << 17) | (numValueOf4.intValue() << 12) | (numValueOf5.intValue() << 6);
        return t(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, (byte) 1, new byte[]{(byte) (iIntValue >> 24), (byte) (iIntValue >> 16), (byte) (iIntValue >> 8), (byte) iIntValue});
    }

    public static byte[] H(int i, int i2, int i3, int i4, int i5) {
        int i6 = (i << 31) | (i2 << 24) | (i3 << 15) | (i4 << 5) | i5;
        return t(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, (byte) 4, new byte[]{(byte) (i6 >> 24), (byte) (i6 >> 16), (byte) (i6 >> 8), (byte) i6});
    }

    public static byte[] I(boolean z) {
        return a((byte) 21, AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE, z ? (byte) 1 : (byte) 0);
    }

    public static byte[] J(byte[] bArr) {
        return t(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD, bArr);
    }

    public static byte[] K(boolean z) {
        return a((byte) 21, (byte) 6, z ? (byte) 1 : (byte) 0);
    }

    public static byte[] L(byte[] bArr) {
        return t(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, (byte) 32, bArr);
    }

    public static boolean M(byte[] bArr) {
        int i;
        return bArr != null && bArr.length >= 9 && (bArr[0] & 255) == 220 && (i = ((bArr[1] & 255) << 8) | (bArr[2] & 255)) == 6 && bArr.length == i + 3 && bArr[3] == 38 && (bArr[4] & 255) == 2 && (bArr[7] & 255) == 2 && (bArr[8] & 255) == 1;
    }

    public static byte[] N(String str) {
        String[] strArrSplit = str.split(Constants.STR_EMPTY);
        byte[] bArr = new byte[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            bArr[i] = Byte.parseByte(strArrSplit[i]);
        }
        return bArr;
    }

    public static byte[] a(byte b, byte b2, byte b3) {
        return new byte[]{ProtocolConstants.PACKET_START_MARKER, 0, 6, b, 1, b2, 0, 1, b3};
    }

    public static byte[] b(boolean z, int i, int i2) {
        String strB = Constants.STR_EMPTY;
        String strB2 = i <= 255 ? pp.b(i >> 8) : Constants.STR_EMPTY;
        if (i2 <= 255) {
            strB = pp.b(i2 >> 8);
        }
        return t(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, (byte) 9, pp.i(pp.b(z ? 1 : 0) + strB2 + pp.b(i) + strB + pp.b(i2)));
    }

    public static byte[] c(byte[] bArr) {
        return t(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, (byte) 23, bArr);
    }

    public static byte[] d() {
        return u(2);
    }

    public static byte[] e(byte[] bArr) {
        return t((byte) 31, (byte) 1, bArr);
    }

    public static byte[] f(byte[] bArr) {
        return t((byte) 31, (byte) 3, bArr);
    }

    public static byte[] g(byte[] bArr) {
        return t((byte) 31, (byte) 2, bArr);
    }

    public static byte[] h() {
        return u(1);
    }

    public static byte[] i() {
        return p((byte) 32, (byte) 3);
    }

    public static byte[] j() {
        return p((byte) 32, (byte) 4);
    }

    public static byte[] k() {
        return p((byte) 33, (byte) 1);
    }

    public static byte[] l() {
        return p((byte) 33, (byte) 2);
    }

    public static byte[] m(boolean z) {
        return z ? new byte[]{ProtocolConstants.PACKET_START_MARKER, 0, 2, AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD, 1} : new byte[]{ProtocolConstants.PACKET_START_MARKER, 0, 2, 20, 1};
    }

    public static Integer n() {
        return 8;
    }

    private static String o(boolean z) {
        return pp.b(z ? 1 : 0);
    }

    public static byte[] p(byte b, byte b2) {
        Integer numN = n();
        byte[] bArr = new byte[numN.intValue()];
        bArr[0] = ProtocolConstants.PACKET_START_MARKER;
        byte[] bArrJ = pp.j(numN.intValue() - 3);
        System.arraycopy(bArrJ, 2, bArr, 1, bArrJ.length - 2);
        bArr[3] = b;
        bArr[4] = 1;
        bArr[5] = b2;
        return bArr;
    }

    public static byte[] q(byte b) {
        return t(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, (byte) 44, new byte[]{b});
    }

    public static byte[] r() {
        return a(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, (byte) 10, (byte) 2);
    }

    public static byte[] s() {
        return t(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, (byte) -1, new byte[]{1});
    }

    public static byte[] t(byte b, byte b2, byte[] bArr) {
        int iIntValue = n().intValue() + bArr.length;
        byte[] bArr2 = new byte[iIntValue];
        bArr2[0] = ProtocolConstants.PACKET_START_MARKER;
        byte[] bArrJ = pp.j(iIntValue - 3);
        System.arraycopy(bArrJ, 2, bArr2, 1, bArrJ.length - 2);
        bArr2[3] = b;
        bArr2[4] = 1;
        bArr2[5] = b2;
        byte[] bArrJ2 = pp.j(bArr.length);
        System.arraycopy(bArrJ2, 2, bArr2, 6, bArrJ2.length - 2);
        System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
        return bArr2;
    }

    public static byte[] u(int i) {
        return p((byte) 32, (byte) i);
    }

    public static byte[] v() {
        return new byte[]{ProtocolConstants.PACKET_START_MARKER, 0, 2, 29, 1};
    }

    public static byte[] w(byte b, byte b2, byte[] bArr) {
        return new byte[]{-36, 0, 5, b, b2, bArr[0], bArr[1], 1};
    }

    public static byte[] x(byte b, byte b2, byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length == 0) {
            return w(b, b2, bArr);
        }
        int length = bArr2.length;
        int i = length + 5;
        byte[] bArr3 = new byte[length + 8];
        bArr3[0] = -36;
        bArr3[1] = (byte) ((i >> 8) & 255);
        bArr3[2] = (byte) (i & 255);
        bArr3[3] = b;
        bArr3[4] = b2;
        bArr3[5] = bArr[0];
        bArr3[6] = bArr[1];
        System.arraycopy(bArr2, 0, bArr3, 7, length);
        bArr3[7 + length] = 1;
        return bArr3;
    }

    public static byte[] y(byte[] bArr) {
        return t(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, (byte) 41, bArr);
    }

    public static byte[] z(int i, byte[] bArr) {
        return t(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN, i == 1 ? (byte) 18 : AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_FREQ, bArr);
    }
}
