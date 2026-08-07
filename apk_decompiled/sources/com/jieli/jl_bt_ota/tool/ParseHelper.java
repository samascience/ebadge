package com.jieli.jl_bt_ota.tool;

import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import com.jieli.jl_bt_ota.constant.Command;
import com.jieli.jl_bt_ota.interfaces.command.ICmdHandler;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.cmdHandler.RcspCmdHandler;
import com.jieli.jl_bt_ota.model.parameter.tws.NotifyAdvInfoParam;
import com.jieli.jl_bt_ota.model.response.TargetInfoResponse;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.jieli.jl_rcsp.util.CHexConver;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ParseHelper {
    private static final String a = "ParseHelper";
    private static final byte b = -2;
    private static final byte c = -36;
    private static final byte d = -70;
    private static final byte e = -17;
    private static byte[] g;
    private static final byte[] f = {-2, -36, -70};
    private static int h = 0;
    private static final char[] i = CHexConver.b.toCharArray();

    private static int a(byte[] bArr, int i2, int i3) {
        int length = bArr.length;
        while (i2 < length) {
            if (bArr[i2] == -2) {
                int i4 = length - i2;
                byte[] bArr2 = f;
                if (i4 < bArr2.length) {
                    b(bArr, i2, i4);
                    return -1;
                }
                int length2 = bArr2.length;
                byte[] bArr3 = new byte[length2];
                System.arraycopy(bArr, i2, bArr3, 0, length2);
                if (!Arrays.equals(bArr3, bArr2)) {
                    continue;
                } else {
                    if (i4 <= bArr2.length + 4) {
                        b(bArr, i2, i4);
                        return -1;
                    }
                    int length3 = bArr2.length + i2;
                    byte[] bArr4 = new byte[2];
                    System.arraycopy(bArr, length3 + 2, bArr4, 0, 2);
                    int iBytesToInt = com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bArr4[0], bArr4[1]);
                    if (iBytesToInt > i3 - 8) {
                        JL_Log.e(a, "findPacketData", CommonUtil.formatString("data length[%d] over MAX_RECEIVE_MTU[%d], cast away", Integer.valueOf(iBytesToInt), Integer.valueOf(i3)));
                    } else {
                        if (i4 <= bArr2.length + 4 + iBytesToInt) {
                            int i5 = length - length3;
                            byte[] bArr5 = new byte[i5];
                            System.arraycopy(bArr, length3, bArr5, 0, i5);
                            int iA = a(bArr5, 0, i3);
                            String str = a;
                            JL_Log.i(str, "findPacketData", "check left data, index = " + iA);
                            if (iA < bArr2.length) {
                                b(bArr, i2, i4);
                                return -1;
                            }
                            int i6 = length3 + iA;
                            JL_Log.w(str, "findPacketData", "found headIndex = " + i6);
                            return i6;
                        }
                        if (bArr[length3 + 4 + iBytesToInt] == -17) {
                            return length3;
                        }
                    }
                    i2 = length3 - 1;
                }
            }
            i2++;
        }
        return -1;
    }

    private static byte[] b(byte[] bArr) {
        int length = bArr.length;
        int i2 = h;
        if (i2 <= 0) {
            return (byte[]) bArr.clone();
        }
        byte[] bArr2 = new byte[i2 + length];
        System.arraycopy(g, 0, bArr2, 0, i2);
        System.arraycopy(bArr, 0, bArr2, h, length);
        h = 0;
        return bArr2;
    }

    private static BasePacket c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i2 = 4;
        if (bArr.length < 4) {
            return null;
        }
        byte[] booleanArrayBig = com.jieli.jl_bt_ota.util.CHexConver.getBooleanArrayBig(bArr[0]);
        int iByteToInt = com.jieli.jl_bt_ota.util.CHexConver.byteToInt(bArr[1]);
        int iBytesToInt = com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bArr, 2, 2);
        BasePacket basePacket = new BasePacket();
        int iByteToInt2 = com.jieli.jl_bt_ota.util.CHexConver.byteToInt(booleanArrayBig[7]);
        int iByteToInt3 = com.jieli.jl_bt_ota.util.CHexConver.byteToInt(booleanArrayBig[6]);
        basePacket.setType(iByteToInt2);
        basePacket.setHasResponse(iByteToInt3);
        basePacket.setOpCode(iByteToInt);
        basePacket.setParamLen(iBytesToInt);
        if (iBytesToInt > 0) {
            if (iByteToInt2 == 0) {
                basePacket.setStatus(com.jieli.jl_bt_ota.util.CHexConver.byteToInt(bArr[4]));
                i2 = 5;
            }
            basePacket.setOpCodeSn(com.jieli.jl_bt_ota.util.CHexConver.byteToInt(bArr[i2]));
            int i3 = i2 + 1;
            if (iByteToInt == 1) {
                basePacket.setXmOpCode(com.jieli.jl_bt_ota.util.CHexConver.byteToInt(bArr[i3]));
                i3 = i2 + 2;
            }
            int i4 = iBytesToInt - (i3 - 4);
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i3, bArr2, 0, i4);
            basePacket.setParamData(bArr2);
            JL_Log.d(a, "parsePacketData", CommonUtil.formatString("packet type : %d, opCode : %d, sn :%d", Integer.valueOf(basePacket.getType()), Integer.valueOf(basePacket.getOpCode()), Integer.valueOf(basePacket.getOpCodeSn())));
        }
        return basePacket;
    }

    public static BasePacket convert2BasePacket(CommandBase commandBase, int i2) {
        if (commandBase == null) {
            return null;
        }
        int i3 = 0;
        boolean z = i2 == 1;
        int type = commandBase.getType();
        if (z && (type == 2 || type == 3)) {
            i3 = 1;
        }
        BasePacket status = new BasePacket().setType(i2).setHasResponse(i3).setOpCode(commandBase.getId()).setOpCodeSn(commandBase.getOpCodeSn()).setStatus(commandBase.getStatus());
        int length = z ? 1 : 2;
        if (commandBase.getParam() != null) {
            if (status.getOpCode() == 1) {
                status.setXmOpCode(commandBase.getParam().getXmOpCode());
                length++;
            }
            byte[] paramData = commandBase.getParam().getParamData();
            if (paramData != null && paramData.length > 0) {
                status.setParamData(paramData);
                length += paramData.length;
            }
        }
        status.setParamLen(length);
        return status;
    }

    public static CommandBase convert2Command(BasePacket basePacket, CommandBase commandBase) {
        if (basePacket == null) {
            return null;
        }
        CommandBase commandBaseA = a(basePacket, commandBase);
        return commandBaseA != null ? commandBaseA : new RcspCmdHandler().parseDataToCmd(basePacket, commandBase);
    }

    public static int convertVersionByString(String str) {
        if (!TextUtils.isEmpty(str)) {
            JL_Log.i(a, "convertVersionByString", "version = " + str);
            String[] strArrSplit = str.replace("V", Constants.STR_EMPTY).replace("v", Constants.STR_EMPTY).split("\\.");
            int length = strArrSplit.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                String str2 = strArrSplit[i2];
                if (TextUtils.isDigitsOnly(str2)) {
                    iArr[i2] = Integer.parseInt(str2);
                }
            }
            if (length == 4) {
                byte[] booleanArray = com.jieli.jl_bt_ota.util.CHexConver.getBooleanArray((byte) iArr[0]);
                byte[] booleanArray2 = com.jieli.jl_bt_ota.util.CHexConver.getBooleanArray((byte) iArr[1]);
                byte[] bArr = new byte[8];
                System.arraycopy(booleanArray, 4, bArr, 0, 4);
                System.arraycopy(booleanArray2, 4, bArr, 4, 4);
                byte bA = (byte) a(bArr);
                byte[] booleanArray3 = com.jieli.jl_bt_ota.util.CHexConver.getBooleanArray((byte) iArr[2]);
                byte[] booleanArray4 = com.jieli.jl_bt_ota.util.CHexConver.getBooleanArray((byte) iArr[3]);
                byte[] bArr2 = new byte[8];
                System.arraycopy(booleanArray3, 4, bArr2, 0, 4);
                System.arraycopy(booleanArray4, 4, bArr2, 4, 4);
                byte bA2 = (byte) a(bArr2);
                JL_Log.i(a, "convertVersionByString", "versionCode : 0, heightValue : " + com.jieli.jl_bt_ota.util.CHexConver.byte2HexStr(bArr) + ", lowValue : " + com.jieli.jl_bt_ota.util.CHexConver.byte2HexStr(bArr2));
                return com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bA, bA2);
            }
        }
        return 0;
    }

    public static ArrayList<BasePacket> findPacketData(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
        return findPacketData(i2, bArr);
    }

    public static String hexDataCovetToAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length == 6) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                char[] cArr = i;
                sb.append(cArr[(bArr[i2] & 255) >> 4]);
                sb.append(cArr[bArr[i2] & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS]);
                if (i2 != bArr.length - 1) {
                    sb.append(":");
                }
            }
        }
        return sb.toString();
    }

    public static byte[] packSendBasePacket(BasePacket basePacket) {
        int i2;
        int i3;
        if (basePacket == null) {
            return null;
        }
        int paramLen = basePacket.getParamLen();
        int i4 = paramLen + 4;
        byte[] bArr = new byte[paramLen + 8];
        byte[] bArr2 = new byte[i4];
        byte[] bArr3 = new byte[2];
        if (basePacket.getType() == 1) {
            bArr3[0] = (byte) (bArr3[0] | 128);
        }
        if (basePacket.getHasResponse() == 1) {
            bArr3[0] = (byte) (bArr3[0] | 64);
        }
        bArr3[1] = (byte) basePacket.getOpCode();
        byte[] bArrInt2byte2 = com.jieli.jl_bt_ota.util.CHexConver.int2byte2(paramLen);
        byte[] bArr4 = new byte[paramLen];
        byte[] bArr5 = {(byte) basePacket.getStatus()};
        byte[] bArr6 = {(byte) basePacket.getOpCodeSn()};
        if (basePacket.getType() == 1) {
            System.arraycopy(bArr6, 0, bArr4, 0, 1);
            if (basePacket.getOpCode() == 1) {
                System.arraycopy(new byte[]{(byte) basePacket.getXmOpCode()}, 0, bArr4, 1, 1);
                i2 = 2;
            } else {
                i2 = 1;
            }
            if (basePacket.getParamData() != null && basePacket.getParamData().length >= (i3 = paramLen - i2)) {
                System.arraycopy(basePacket.getParamData(), 0, bArr4, i2, i3);
                i2 += i3;
            }
        } else {
            System.arraycopy(bArr5, 0, bArr4, 0, 1);
            System.arraycopy(bArr6, 0, bArr4, 1, 1);
            if (basePacket.getOpCode() == 1) {
                System.arraycopy(new byte[]{(byte) basePacket.getXmOpCode()}, 0, bArr4, 2, 1);
                i2 = 3;
            } else {
                i2 = 2;
            }
            if (basePacket.getParamData() != null) {
                i3 = paramLen - i2;
                System.arraycopy(basePacket.getParamData(), 0, bArr4, i2, i3);
                i2 += i3;
            }
        }
        if (i2 != paramLen) {
            JL_Log.e(a, "packSendBasePacket", "param data is error. index : " + i2 + ", paramLen : " + paramLen);
            return null;
        }
        System.arraycopy(bArr3, 0, bArr2, 0, 2);
        System.arraycopy(bArrInt2byte2, 0, bArr2, 2, 2);
        System.arraycopy(bArr4, 0, bArr2, 4, paramLen);
        System.arraycopy(new byte[]{-2, -36, -70}, 0, bArr, 0, 3);
        System.arraycopy(bArr2, 0, bArr, 3, i4);
        System.arraycopy(new byte[]{-17}, 0, bArr, paramLen + 7, 1);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        return byteBufferWrap.array();
    }

    public static void parseNotifyADVInfo(NotifyAdvInfoParam notifyAdvInfoParam, BasePacket basePacket) {
        byte[] paramData;
        if (basePacket == null || (paramData = basePacket.getParamData()) == null || paramData.length < 18) {
            return;
        }
        byte[] bArr = new byte[2];
        System.arraycopy(paramData, 0, bArr, 0, 2);
        int iBytesToInt = com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bArr[0], bArr[1]);
        System.arraycopy(paramData, 2, bArr, 0, 2);
        int iBytesToInt2 = com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bArr[0], bArr[1]);
        System.arraycopy(paramData, 4, bArr, 0, 2);
        int iBytesToInt3 = com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bArr[0], bArr[1]);
        byte b2 = paramData[6];
        int i2 = (b2 >> 4) & 255;
        int i3 = b2 & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS;
        byte[] bArr2 = new byte[6];
        System.arraycopy(paramData, 7, bArr2, 0, 6);
        String strHexDataCovetToAddress = hexDataCovetToAddress(bArr2);
        int iByteToInt = com.jieli.jl_bt_ota.util.CHexConver.byteToInt(paramData[13]);
        byte b3 = paramData[14];
        int i4 = (b3 >> 7) & 1;
        int i5 = b3 & 127;
        byte b4 = paramData[15];
        int i6 = (b4 >> 7) & 1;
        int i7 = b4 & 127;
        byte b5 = paramData[16];
        int i8 = (b5 >> 7) & 1;
        notifyAdvInfoParam.setVid(iBytesToInt).setUid(iBytesToInt2).setPid(iBytesToInt3).setDeviceType(i2).setVersion(i3).setEdrAddr(strHexDataCovetToAddress).setAction(iByteToInt).setLeftCharging(i4 == 1).setLeftDeviceQuantity(i5).setRightCharging(i6 == 1).setRightDeviceQuantity(i7).setDeviceCharging(i8 == 1).setChargingBinQuantity(b5 & 127).setSeq(com.jieli.jl_bt_ota.util.CHexConver.byteToInt(paramData[17]));
    }

    public static void parseTargetInfo(TargetInfoResponse targetInfoResponse, BasePacket basePacket) {
        String str;
        String str2;
        int iBytesToInt;
        byte[] paramData = basePacket.getParamData();
        if (paramData == null || paramData.length <= 0) {
            return;
        }
        int length = paramData.length;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 2;
            if (i3 > length) {
                JL_Log.i(a, "parseTargetInfo", Constants.STR_EMPTY + targetInfoResponse);
                return;
            }
            int iByteToInt = com.jieli.jl_bt_ota.util.CHexConver.byteToInt(paramData[i2]);
            if (iByteToInt <= 0 || iByteToInt >= length) {
                JL_Log.e(a, "parseTargetInfo", CommonUtil.formatString("data length[%d] over paramDataLen[%d], cast away", Integer.valueOf(iByteToInt), Integer.valueOf(length)));
                return;
            }
            int iByteToInt2 = com.jieli.jl_bt_ota.util.CHexConver.byteToInt(paramData[i2 + 1]);
            int i4 = iByteToInt - 1;
            byte[] bArr = new byte[i4];
            if (i4 > 0 && i4 + i2 + 2 <= length) {
                System.arraycopy(paramData, i3, bArr, 0, i4);
                i3 = i2 + iByteToInt + 1;
                JL_Log.d(a, "parseTargetInfo", "type= " + iByteToInt2 + "\t data=" + com.jieli.jl_bt_ota.util.CHexConver.byte2HexStr(bArr, i4));
                if (iByteToInt2 == 0) {
                    byte b2 = bArr[0];
                    targetInfoResponse.setProtocolVersion("V_" + ((b2 >> 4) & 15) + FileUtils.FILE_EXTENSION_SEPARATOR + (b2 & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS));
                } else if (iByteToInt2 != 1) {
                    if (iByteToInt2 != 2) {
                        if (iByteToInt2 == 16) {
                            try {
                                targetInfoResponse.setName(new String(bArr));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else if (iByteToInt2 == 17) {
                            targetInfoResponse.setBleOnly(bArr[0] == 1);
                            if (i4 > 6) {
                                byte[] bArr2 = new byte[6];
                                System.arraycopy(bArr, 1, bArr2, 0, 6);
                                targetInfoResponse.setBleAddr(hexDataCovetToAddress(bArr2));
                            }
                        } else if (iByteToInt2 == 19) {
                            byte b3 = bArr[0];
                            targetInfoResponse.setSupportMD5((b3 & 1) == 1).setGameMode(((b3 >> 1) & 1) == 1);
                        } else if (iByteToInt2 != 31) {
                            switch (iByteToInt2) {
                                case 4:
                                    if (i4 >= 5) {
                                        byte[] bArr3 = new byte[4];
                                        System.arraycopy(bArr, 0, bArr3, 0, 4);
                                        targetInfoResponse.setFunctionMask(com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bArr3)).setCurFunction(bArr[4]);
                                    }
                                    break;
                                case 5:
                                    if (i4 >= 2) {
                                        int iBytesToInt2 = com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bArr[0], bArr[1]);
                                        targetInfoResponse.setVersionCode(iBytesToInt2).setVersionName("V_" + ((iBytesToInt2 >> 12) & 15) + FileUtils.FILE_EXTENSION_SEPARATOR + ((iBytesToInt2 >> 8) & 15) + FileUtils.FILE_EXTENSION_SEPARATOR + ((iBytesToInt2 >> 4) & 15) + FileUtils.FILE_EXTENSION_SEPARATOR + (iBytesToInt2 & 15));
                                    }
                                    break;
                                case 6:
                                    targetInfoResponse.setSdkType(com.jieli.jl_bt_ota.util.CHexConver.byteToInt(bArr[0]));
                                    break;
                                case 7:
                                    if (i4 != 2) {
                                        String strReplace = new String(bArr).replace("V", Constants.STR_EMPTY).replace("v", Constants.STR_EMPTY);
                                        targetInfoResponse.setUbootVersionName(strReplace);
                                        char[] charArray = strReplace.replace(FileUtils.FILE_EXTENSION_SEPARATOR, Constants.STR_EMPTY).toCharArray();
                                        if (charArray.length >= 4) {
                                            targetInfoResponse.setUbootVersionCode(com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(com.jieli.jl_bt_ota.util.CHexConver.decodeHexChar(charArray[0], charArray[1]), com.jieli.jl_bt_ota.util.CHexConver.decodeHexChar(charArray[2], charArray[3])));
                                        }
                                    } else {
                                        byte[] booleanArray = com.jieli.jl_bt_ota.util.CHexConver.getBooleanArray(bArr[0]);
                                        byte[] booleanArray2 = com.jieli.jl_bt_ota.util.CHexConver.getBooleanArray(bArr[1]);
                                        StringBuilder sb = new StringBuilder();
                                        byte[] bArr4 = new byte[8];
                                        System.arraycopy(booleanArray, 0, bArr4, 4, 4);
                                        sb.append(a(bArr4));
                                        sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                                        System.arraycopy(booleanArray, 4, bArr4, 4, 4);
                                        sb.append(a(bArr4));
                                        sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                                        System.arraycopy(booleanArray2, 0, bArr4, 4, 4);
                                        sb.append(a(bArr4));
                                        sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                                        System.arraycopy(booleanArray2, 4, bArr4, 4, 4);
                                        sb.append(a(bArr4));
                                        targetInfoResponse.setUbootVersionName(sb.toString()).setUbootVersionCode(com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bArr[0], bArr[1]));
                                    }
                                    break;
                                case 8:
                                    targetInfoResponse.setSupportDoubleBackup(com.jieli.jl_bt_ota.util.CHexConver.byteToInt(bArr[0]) == 1);
                                    if (i4 >= 2) {
                                        targetInfoResponse.setNeedBootLoader(com.jieli.jl_bt_ota.util.CHexConver.byteToInt(bArr[1]) == 1);
                                    }
                                    if (i4 >= 3) {
                                        targetInfoResponse.setSingleBackupOtaWay(com.jieli.jl_bt_ota.util.CHexConver.byteToInt(bArr[2]));
                                    }
                                    break;
                                case 9:
                                    targetInfoResponse.setMandatoryUpgradeFlag(com.jieli.jl_bt_ota.util.CHexConver.byteToInt(bArr[0]));
                                    if (i4 >= 2) {
                                        targetInfoResponse.setRequestOtaFlag(com.jieli.jl_bt_ota.util.CHexConver.byteToInt(bArr[1]));
                                    }
                                    if (i4 >= 3) {
                                        targetInfoResponse.setExpandMode(com.jieli.jl_bt_ota.util.CHexConver.byteToInt(bArr[2]));
                                    }
                                    break;
                                case 10:
                                    if (i4 >= 4) {
                                        targetInfoResponse.setVid(com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bArr[0], bArr[1])).setPid(com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bArr[2], bArr[3]));
                                        if (i4 < 6) {
                                            targetInfoResponse.setUid(targetInfoResponse.getVid());
                                        } else {
                                            targetInfoResponse.setUid(com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bArr[4], bArr[5]));
                                        }
                                    }
                                    break;
                                case 11:
                                    try {
                                        str2 = new String(bArr);
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                        str2 = null;
                                    }
                                    targetInfoResponse.setAuthKey(str2);
                                    break;
                                case 12:
                                    try {
                                        str = new String(bArr);
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                        str = null;
                                    }
                                    targetInfoResponse.setProjectCode(str);
                                    break;
                                case 13:
                                    if (i4 >= 2) {
                                        int iBytesToInt3 = com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bArr[0], bArr[1]);
                                        if (iBytesToInt3 > 0) {
                                            targetInfoResponse.setCommunicationMtu(iBytesToInt3).setReceiveMtu(iBytesToInt3);
                                        }
                                        if (i4 >= 4 && (iBytesToInt = com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bArr[2], bArr[3])) > 0) {
                                            targetInfoResponse.setReceiveMtu(iBytesToInt3);
                                            targetInfoResponse.setCommunicationMtu(iBytesToInt);
                                        }
                                    }
                                    break;
                                case 14:
                                    targetInfoResponse.setAllowConnectFlag(com.jieli.jl_bt_ota.util.CHexConver.byteToInt(bArr[0]));
                                    break;
                            }
                        } else {
                            try {
                                targetInfoResponse.setCustomVersionMsg(new String(bArr));
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                    } else if (i4 >= 6) {
                        byte[] bArr5 = new byte[6];
                        System.arraycopy(bArr, 0, bArr5, 0, 6);
                        targetInfoResponse.setEdrAddr(hexDataCovetToAddress(bArr5));
                        if (i4 >= 8) {
                            targetInfoResponse.setEdrProfile(bArr[6]).setEdrStatus(bArr[7]);
                        }
                    }
                } else if (i4 >= 3) {
                    targetInfoResponse.setQuantity(com.jieli.jl_bt_ota.util.CHexConver.byteToInt(bArr[0])).setVolume(bArr[1]).setMaxVol(bArr[2]);
                    if (i4 > 4) {
                        targetInfoResponse.setLowPowerLimit(com.jieli.jl_bt_ota.util.CHexConver.byteToInt(bArr[4]));
                    }
                }
            } else {
                if (i4 != 0) {
                    JL_Log.w(a, "parseTargetInfo", "over limit.");
                    return;
                }
                JL_Log.w(a, "parseTargetInfo", "dataBuf is empty.");
            }
            i2 = i3;
        }
    }

    public static ArrayList<BasePacket> findPacketData(int i2, byte[] bArr) {
        if (i2 == 0 || bArr == null || bArr.length == 0) {
            return null;
        }
        ArrayList<BasePacket> arrayList = new ArrayList<>();
        byte[] bArrB = b(bArr);
        int length = bArrB.length;
        JL_Log.d(a, "findPacketData", "data : " + com.jieli.jl_bt_ota.util.CHexConver.byte2HexStr(bArrB));
        int i3 = 0;
        while (i3 < length) {
            int iA = a(bArrB, i3, i2);
            if (iA < f.length) {
                JL_Log.w(a, "findPacketData", "not find head data : ");
                return arrayList;
            }
            JL_Log.i(a, "findPacketData", "prefixIndex = " + iA);
            int iBytesToInt = com.jieli.jl_bt_ota.util.CHexConver.bytesToInt(bArrB, iA + 2, 2);
            int i4 = iBytesToInt + 4;
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArrB, iA, bArr2, 0, i4);
            BasePacket basePacketC = c(bArr2);
            if (basePacketC != null) {
                arrayList.add(basePacketC);
            }
            i3 = iA + 4 + iBytesToInt + 1;
        }
        return arrayList;
    }

    private static void b(byte[] bArr, int i2, int i3) {
        if (bArr == null || bArr.length <= 0 || i2 < 0 || i3 <= 0 || i2 + i3 > bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[i3];
        g = bArr2;
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        h = i3;
    }

    private static CommandBase a(BasePacket basePacket, CommandBase commandBase) {
        Map<Integer, ICmdHandler> validCommandList;
        ICmdHandler iCmdHandler;
        if (basePacket == null || (validCommandList = Command.getValidCommandList()) == null || (iCmdHandler = validCommandList.get(Integer.valueOf(basePacket.getOpCode()))) == null) {
            return null;
        }
        return iCmdHandler.parseDataToCmd(basePacket, commandBase);
    }

    private static int a(byte[] bArr) {
        if (bArr != null && bArr.length == 8) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                sb.append(b2 & 255);
            }
            try {
                return Integer.valueOf(sb.toString(), 2).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }
}
