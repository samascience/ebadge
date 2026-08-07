package com.jieli.jl_bt_ota.tool;

import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.util.CHexConver;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class RcspParser {
    private final String a = RcspParser.class.getSimpleName();
    private final ByteArrayOutputStream b = new ByteArrayOutputStream();
    private final byte[] c = {-2, -36, -70};

    private byte[] a(byte[] bArr) {
        int length = bArr.length;
        byte[] byteArray = this.b.toByteArray();
        int length2 = byteArray.length;
        if (length2 <= 0) {
            return (byte[]) bArr.clone();
        }
        byte[] bArr2 = new byte[length2 + length];
        System.arraycopy(byteArray, 0, bArr2, 0, length2);
        System.arraycopy(bArr, 0, bArr2, length2, length);
        this.b.reset();
        return bArr2;
    }

    private BasePacket b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i = 4;
        if (bArr.length < 4) {
            return null;
        }
        byte[] booleanArrayBig = CHexConver.getBooleanArrayBig(bArr[0]);
        int iByteToInt = CHexConver.byteToInt(bArr[1]);
        int iBytesToInt = CHexConver.bytesToInt(bArr, 2, 2);
        BasePacket basePacket = new BasePacket();
        int iByteToInt2 = CHexConver.byteToInt(booleanArrayBig[7]);
        int iByteToInt3 = CHexConver.byteToInt(booleanArrayBig[6]);
        basePacket.setType(iByteToInt2);
        basePacket.setHasResponse(iByteToInt3);
        basePacket.setOpCode(iByteToInt);
        basePacket.setParamLen(iBytesToInt);
        if (iBytesToInt > 0) {
            if (iByteToInt2 == 0) {
                basePacket.setStatus(CHexConver.byteToInt(bArr[4]));
                i = 5;
            }
            basePacket.setOpCodeSn(CHexConver.byteToInt(bArr[i]));
            int i2 = i + 1;
            if (iByteToInt == 1) {
                basePacket.setXmOpCode(CHexConver.byteToInt(bArr[i2]));
                i2 = i + 2;
            }
            int i3 = iBytesToInt - (i2 - 4);
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            basePacket.setParamData(bArr2);
            JL_Log.d(this.a, CommonUtil.formatString("-parsePacketData- packet type : %d, opCode : %d, sn :%d", Integer.valueOf(basePacket.getType()), Integer.valueOf(basePacket.getOpCode()), Integer.valueOf(basePacket.getOpCodeSn())));
        }
        return basePacket;
    }

    public ArrayList<BasePacket> findPacketData(int i, byte[] bArr) {
        if (i == 0 || bArr == null || bArr.length == 0) {
            return null;
        }
        ArrayList<BasePacket> arrayList = new ArrayList<>();
        byte[] bArrA = a(bArr);
        int length = bArrA.length;
        JL_Log.i(this.a, "-findPacketData- mtu = " + i);
        int i2 = 0;
        while (i2 < length) {
            int iA = a(bArrA, i2, i);
            if (iA < this.c.length) {
                JL_Log.w(this.a, "-findPacketData- not find head data : ");
                return arrayList;
            }
            int iBytesToInt = CHexConver.bytesToInt(bArrA, iA + 2, 2);
            JL_Log.i(this.a, "-findPacketData- prefixIndex = " + iA + ", paramLen = " + iBytesToInt);
            int i3 = iBytesToInt + 4;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArrA, iA, bArr2, 0, i3);
            BasePacket basePacketB = b(bArr2);
            if (basePacketB != null) {
                arrayList.add(basePacketB);
            }
            i2 = iA + 4 + iBytesToInt + 1;
        }
        return arrayList;
    }

    public void release() {
        this.b.reset();
    }

    private int a(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        while (i < length) {
            if (bArr[i] == -2) {
                int i3 = length - i;
                byte[] bArr2 = this.c;
                if (i3 < bArr2.length) {
                    b(bArr, i, i3);
                    return -1;
                }
                int length2 = bArr2.length;
                byte[] bArr3 = new byte[length2];
                System.arraycopy(bArr, i, bArr3, 0, length2);
                if (Arrays.equals(bArr3, this.c)) {
                    byte[] bArr4 = this.c;
                    if (i3 <= bArr4.length + 4) {
                        b(bArr, i, i3);
                        return -1;
                    }
                    int length3 = bArr4.length + i;
                    byte[] bArr5 = new byte[2];
                    System.arraycopy(bArr, length3 + 2, bArr5, 0, 2);
                    int iBytesToInt = CHexConver.bytesToInt(bArr5[0], bArr5[1]);
                    if (iBytesToInt > i2 - 8) {
                        JL_Log.e(this.a, CommonUtil.formatString("findPacketData :: data length[%d] over MAX_RECEIVE_MTU[%d], cast away", Integer.valueOf(iBytesToInt), Integer.valueOf(i2)));
                    } else {
                        if (i3 <= this.c.length + 4 + iBytesToInt) {
                            b(bArr, i, i3);
                            return -1;
                        }
                        if (bArr[length3 + 4 + iBytesToInt] == -17) {
                            return length3;
                        }
                    }
                    i = length3 - 1;
                } else {
                    continue;
                }
            }
            i++;
        }
        return -1;
    }

    private void b(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr == null || bArr.length <= 0 || i < 0 || i2 <= 0 || (i3 = i2 + i) > bArr.length) {
            return;
        }
        try {
            this.b.write(Arrays.copyOfRange(bArr, i, i3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
