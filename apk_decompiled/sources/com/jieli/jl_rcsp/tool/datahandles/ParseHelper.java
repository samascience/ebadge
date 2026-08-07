package com.jieli.jl_rcsp.tool.datahandles;

import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import com.jieli.bluetooth_connect.constant.BluetoothConstant;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.jieli.jl_rcsp.constant.Command;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.cmdHandler.RcspCmdHandler;
import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.model.parameter.NotifyAdvInfoParam;
import com.jieli.jl_rcsp.model.response.ADVInfoResponse;
import com.jieli.jl_rcsp.model.response.SysInfoResponse;
import com.jieli.jl_rcsp.model.response.TargetInfoResponse;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ParseHelper {
    public static final String a = "ParseHelper";
    public static final char[] b = CHexConver.b.toCharArray();

    public static int a(BluetoothDevice bluetoothDevice) {
        return DeviceStatusManager.getInstance().getMaxCommunicationMtu(bluetoothDevice);
    }

    public static List<ADVInfoResponse.KeySettings> b(byte[] bArr) {
        int i;
        if (bArr == null || bArr.length < 3) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[3];
        int i2 = 0;
        while (i2 < bArr.length && (i = i2 + 3) <= bArr.length) {
            System.arraycopy(bArr, i2, bArr2, 0, 3);
            ADVInfoResponse.KeySettings keySettings = new ADVInfoResponse.KeySettings();
            keySettings.setKeyNum(CHexConver.byteToInt(bArr2[0]));
            keySettings.setAction(CHexConver.byteToInt(bArr2[1]));
            keySettings.setFunction(CHexConver.byteToInt(bArr2[2]));
            arrayList.add(keySettings);
            i2 = i;
        }
        return arrayList;
    }

    public static List<ADVInfoResponse.LedSettings> c(byte[] bArr) {
        int i;
        ArrayList arrayList = null;
        if (bArr != null && bArr.length >= 2) {
            byte[] bArr2 = new byte[2];
            int i2 = 0;
            while (i2 < bArr.length && (i = i2 + 2) <= bArr.length) {
                System.arraycopy(bArr, i2, bArr2, 0, 2);
                ADVInfoResponse.LedSettings ledSettings = new ADVInfoResponse.LedSettings();
                ledSettings.setScene(CHexConver.byteToInt(bArr2[0]));
                ledSettings.setEffect(CHexConver.byteToInt(bArr2[1]));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(ledSettings);
                i2 = i;
            }
        }
        return arrayList;
    }

    public static BasePacket convert2BasePacket(CommandBase commandBase, int i) {
        if (commandBase == null) {
            return null;
        }
        int i2 = 0;
        boolean z = i == 1;
        int type = commandBase.getType();
        if (z && (type == 2 || type == 3)) {
            i2 = 1;
        }
        BasePacket status = new BasePacket().setType(i).setHasResponse(i2).setOpCode(commandBase.getId()).setOpCodeSn(commandBase.getOpCodeSn()).setStatus(commandBase.getStatus());
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

    public static CommandBase convert2Command(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        ICmdHandler iCmdHandler;
        if (basePacket == null) {
            return null;
        }
        Map<Integer, ICmdHandler> validCommandList = Command.getValidCommandList();
        return (validCommandList == null || (iCmdHandler = validCommandList.get(Integer.valueOf(basePacket.getOpCode()))) == null) ? new RcspCmdHandler().parseDataToCmd(bluetoothDevice, basePacket) : iCmdHandler.parseDataToCmd(bluetoothDevice, basePacket);
    }

    public static int convertVersionByString(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        JL_Log.d(a, "convertVersionByString", "version = " + str);
        String[] strArrSplit = str.replace("V", Constants.STR_EMPTY).replace("v", Constants.STR_EMPTY).split("\\.");
        int length = strArrSplit.length;
        int[] iArr = new int[length];
        for (int i = 0; i < strArrSplit.length; i++) {
            String str2 = strArrSplit[i];
            if (TextUtils.isDigitsOnly(str2)) {
                iArr[i] = Integer.parseInt(str2);
            }
        }
        if (length != 4) {
            return 0;
        }
        byte[] booleanArray = CHexConver.getBooleanArray((byte) iArr[0]);
        byte[] booleanArray2 = CHexConver.getBooleanArray((byte) iArr[1]);
        byte[] bArr = new byte[8];
        System.arraycopy(booleanArray, 4, bArr, 0, 4);
        System.arraycopy(booleanArray2, 4, bArr, 4, 4);
        byte bA = (byte) a(bArr);
        byte[] booleanArray3 = CHexConver.getBooleanArray((byte) iArr[2]);
        byte[] booleanArray4 = CHexConver.getBooleanArray((byte) iArr[3]);
        byte[] bArr2 = new byte[8];
        System.arraycopy(booleanArray3, 4, bArr2, 0, 4);
        System.arraycopy(booleanArray4, 4, bArr2, 4, 4);
        byte bA2 = (byte) a(bArr2);
        JL_Log.d(a, "convertVersionByString", "versionCode : 0, heightValue : " + CHexConver.byte2HexStr(bArr, 8) + ", lowValue : " + CHexConver.byte2HexStr(bArr2, 8));
        return CHexConver.bytesToInt(bA, bA2);
    }

    public static List<AttrBean> coverParamDataToAttrBeans(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 1;
            int iByteToInt = CHexConver.byteToInt(bArr[i]);
            if (iByteToInt < 1) {
                return arrayList;
            }
            AttrBean attrBean = new AttrBean();
            int i3 = i + 2;
            attrBean.setType(bArr[i2]);
            int i4 = iByteToInt - 1;
            byte[] bArr2 = new byte[i4];
            if (bArr.length - i3 < i4) {
                return arrayList;
            }
            System.arraycopy(bArr, i3, bArr2, 0, i4);
            attrBean.setAttrData(bArr2);
            i = i3 + i4;
            arrayList.add(attrBean);
        }
        return arrayList;
    }

    public static String hexDataCovetToAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length == 6) {
            for (int i = 0; i < bArr.length; i++) {
                char[] cArr = b;
                sb.append(cArr[(bArr[i] & 255) >> 4]);
                sb.append(cArr[bArr[i] & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS]);
                if (i != bArr.length - 1) {
                    sb.append(":");
                }
            }
        }
        return sb.toString();
    }

    public static byte[] packSendBasePacket(BasePacket basePacket) {
        int i;
        int i2;
        if (basePacket == null) {
            return null;
        }
        int paramLen = basePacket.getParamLen();
        int i3 = paramLen + 4;
        byte[] bArr = new byte[paramLen + 8];
        byte[] bArr2 = new byte[i3];
        byte[] bArr3 = new byte[2];
        bArr3[0] = 0;
        if (basePacket.getType() == 1) {
            bArr3[0] = (byte) (bArr3[0] | 128);
        }
        if (basePacket.getHasResponse() == 1) {
            bArr3[0] = (byte) (bArr3[0] | 64);
        }
        bArr3[1] = (byte) basePacket.getOpCode();
        byte[] bArrInt2byte2 = CHexConver.int2byte2(paramLen);
        byte[] bArr4 = new byte[paramLen];
        byte[] bArr5 = {(byte) basePacket.getStatus()};
        byte[] bArr6 = {(byte) basePacket.getOpCodeSn()};
        if (basePacket.getType() == 1) {
            System.arraycopy(bArr6, 0, bArr4, 0, 1);
            if (basePacket.getOpCode() == 1) {
                System.arraycopy(new byte[]{(byte) basePacket.getXmOpCode()}, 0, bArr4, 1, 1);
                i = 2;
            } else {
                i = 1;
            }
            if (basePacket.getParamData() != null) {
                JL_Log.d(a, "packSendBasePacket", "data len : " + basePacket.getParamData().length + " ,index : " + i + ", paramLen : " + paramLen);
                i2 = paramLen - i;
                if (basePacket.getParamData().length >= i2) {
                    System.arraycopy(basePacket.getParamData(), 0, bArr4, i, i2);
                    i += i2;
                }
            }
        } else {
            System.arraycopy(bArr5, 0, bArr4, 0, 1);
            System.arraycopy(bArr6, 0, bArr4, 1, 1);
            if (basePacket.getOpCode() == 1) {
                System.arraycopy(new byte[]{(byte) basePacket.getXmOpCode()}, 0, bArr4, 2, 1);
                i = 3;
            } else {
                i = 2;
            }
            if (basePacket.getParamData() != null) {
                i2 = paramLen - i;
                System.arraycopy(basePacket.getParamData(), 0, bArr4, i, i2);
                i += i2;
            }
        }
        if (i != paramLen) {
            JL_Log.e(a, "packSendBasePacket", "param data is error. index : " + i + ", paramLen : " + paramLen);
            return null;
        }
        System.arraycopy(bArr3, 0, bArr2, 0, 2);
        System.arraycopy(bArrInt2byte2, 0, bArr2, 2, 2);
        System.arraycopy(bArr4, 0, bArr2, 4, paramLen);
        System.arraycopy(new byte[]{-2, -36, -70}, 0, bArr, 0, 3);
        System.arraycopy(bArr2, 0, bArr, 3, i3);
        System.arraycopy(new byte[]{-17}, 0, bArr, paramLen + 7, 1);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        return byteBufferWrap.array();
    }

    public static void parseADVInfo(BluetoothDevice bluetoothDevice, ADVInfoResponse aDVInfoResponse, BasePacket basePacket) {
        byte[] paramData = basePacket.getParamData();
        if (paramData == null || paramData.length <= 0) {
            return;
        }
        int length = paramData.length;
        int i = 0;
        while (true) {
            int i2 = i + 2;
            if (i2 > length) {
                return;
            }
            int iByteToInt = CHexConver.byteToInt(paramData[i]);
            if (iByteToInt <= 0 || iByteToInt >= a(bluetoothDevice)) {
                JL_Log.e(a, "parseADVInfo", RcspUtil.formatString("data length[%d] over MAX_COMMUNICATION_MTU[%d], cast away", Integer.valueOf(iByteToInt), Integer.valueOf(a(bluetoothDevice))));
                return;
            }
            int iByteToInt2 = CHexConver.byteToInt(paramData[i + 1]);
            int i3 = iByteToInt - 1;
            byte[] bArr = new byte[i3];
            if (i3 > 0 && i3 + i + 2 <= length) {
                System.arraycopy(paramData, i2, bArr, 0, i3);
                i += iByteToInt + 1;
                String str = a;
                JL_Log.d(str, "parseADVInfo", "data : " + CHexConver.byte2HexStr(bArr));
                if (aDVInfoResponse == null) {
                    aDVInfoResponse = new ADVInfoResponse();
                }
                switch (iByteToInt2) {
                    case 0:
                        byte b2 = bArr[0];
                        int i4 = (b2 >> 7) & 1;
                        int i5 = b2 & 127;
                        aDVInfoResponse.setLeftCharging(i4 == 1);
                        aDVInfoResponse.setLeftDeviceQuantity(i5);
                        if (i3 >= 2) {
                            byte b3 = bArr[1];
                            int i6 = (b3 >> 7) & 1;
                            int i7 = b3 & 127;
                            aDVInfoResponse.setRightCharging(i6 == 1);
                            aDVInfoResponse.setRightDeviceQuantity(i7);
                            if (i3 >= 3) {
                                byte b4 = bArr[2];
                                int i8 = (b4 >> 7) & 1;
                                int i9 = b4 & 127;
                                aDVInfoResponse.setDeviceCharging(i8 == 1);
                                aDVInfoResponse.setChargingBinQuantity(i9);
                            }
                        }
                        break;
                    case 1:
                        try {
                            aDVInfoResponse.setDeviceName(new String(bArr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        aDVInfoResponse.setKeySettingsList(b(bArr));
                        break;
                    case 3:
                        aDVInfoResponse.setLedSettingsList(c(bArr));
                        break;
                    case 4:
                        aDVInfoResponse.setMicChannel(CHexConver.byteToInt(bArr[0]));
                        break;
                    case 5:
                        aDVInfoResponse.setWorkModel(CHexConver.byteToInt(bArr[0]));
                        break;
                    case 6:
                        if (i3 >= 6) {
                            int iBytesToInt = CHexConver.bytesToInt(bArr[0], bArr[1]);
                            int iBytesToInt2 = CHexConver.bytesToInt(bArr[2], bArr[3]);
                            int iBytesToInt3 = CHexConver.bytesToInt(bArr[4], bArr[5]);
                            aDVInfoResponse.setVid(iBytesToInt);
                            aDVInfoResponse.setUid(iBytesToInt2);
                            aDVInfoResponse.setPid(iBytesToInt3);
                        }
                        break;
                    case 7:
                    default:
                        JL_Log.w(str, "parseADVInfo", "unknown type : " + iByteToInt2);
                        break;
                    case 8:
                        aDVInfoResponse.setInEarSettings(CHexConver.byteToInt(paramData[0]));
                        break;
                    case 9:
                        try {
                            aDVInfoResponse.setLanguage(new String(bArr));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        break;
                    case 10:
                        if (i3 >= 4) {
                            int iBytesToInt4 = CHexConver.bytesToInt(bArr, 0, 4);
                            ArrayList arrayList = new ArrayList();
                            for (int i10 = 0; i10 < 32; i10++) {
                                if (((iBytesToInt4 >> i10) & 1) == 1) {
                                    arrayList.add(Integer.valueOf(i10));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                byte[] bArr2 = new byte[arrayList.size()];
                                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                                    Integer num = (Integer) arrayList.get(i11);
                                    if (num != null) {
                                        bArr2[i11] = num.byteValue();
                                    }
                                }
                                aDVInfoResponse.setModes(bArr2);
                            }
                        }
                        break;
                }
            } else if (i3 != 0) {
                JL_Log.w(a, "parseADVInfo", "data over limit.");
                return;
            } else {
                JL_Log.w(a, "parseADVInfo", "data is empty.");
                i = i2;
            }
        }
    }

    public static void parseNotifyADVInfo(NotifyAdvInfoParam notifyAdvInfoParam, BasePacket basePacket) {
        byte[] paramData;
        if (basePacket == null || (paramData = basePacket.getParamData()) == null || paramData.length < 18) {
            return;
        }
        byte[] bArr = new byte[2];
        System.arraycopy(paramData, 0, bArr, 0, 2);
        int iBytesToInt = CHexConver.bytesToInt(bArr[0], bArr[1]);
        System.arraycopy(paramData, 2, bArr, 0, 2);
        int iBytesToInt2 = CHexConver.bytesToInt(bArr[0], bArr[1]);
        System.arraycopy(paramData, 4, bArr, 0, 2);
        int iBytesToInt3 = CHexConver.bytesToInt(bArr[0], bArr[1]);
        byte b2 = paramData[6];
        int i = (b2 >> 4) & 255;
        int i2 = b2 & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS;
        byte[] bArr2 = new byte[6];
        System.arraycopy(paramData, 7, bArr2, 0, 6);
        String strHexDataCovetToAddress = hexDataCovetToAddress(bArr2);
        int iByteToInt = CHexConver.byteToInt(paramData[13]);
        byte b3 = paramData[14];
        int i3 = (b3 >> 7) & 1;
        int i4 = b3 & 127;
        byte b4 = paramData[15];
        int i5 = (b4 >> 7) & 1;
        int i6 = b4 & 127;
        byte b5 = paramData[16];
        int i7 = (b5 >> 7) & 1;
        notifyAdvInfoParam.setVid(iBytesToInt).setUid(iBytesToInt2).setPid(iBytesToInt3).setDeviceType(i).setVersion(i2).setEdrAddr(strHexDataCovetToAddress).setAction(iByteToInt).setLeftCharging(i3 == 1).setLeftDeviceQuantity(i4).setRightCharging(i5 == 1).setRightDeviceQuantity(i6).setDeviceCharging(i7 == 1).setChargingBinQuantity(b5 & 127).setSeq(CHexConver.byteToInt(paramData[17]));
    }

    public static void parseSysInfo(SysInfoResponse sysInfoResponse, BasePacket basePacket) {
        byte[] paramData = basePacket.getParamData();
        if (paramData == null || sysInfoResponse == null || paramData.length <= 0) {
            return;
        }
        byte b2 = paramData[0];
        if (paramData.length > 1) {
            int length = paramData.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(paramData, 1, bArr, 0, length);
            List<AttrBean> listCoverParamDataToAttrBeans = coverParamDataToAttrBeans(bArr);
            sysInfoResponse.setFunction(b2);
            sysInfoResponse.setAttrs(listCoverParamDataToAttrBeans);
        }
    }

    public static void parseTargetInfo(BluetoothDevice bluetoothDevice, TargetInfoResponse targetInfoResponse, BasePacket basePacket) {
        String str;
        String str2;
        String str3;
        String str4;
        byte[] paramData = basePacket.getParamData();
        if (paramData != null && paramData.length > 0) {
            int length = paramData.length;
            int i = 0;
            while (true) {
                int i2 = i + 2;
                if (i2 <= length) {
                    int iByteToInt = CHexConver.byteToInt(paramData[i]);
                    if (iByteToInt <= 0 || iByteToInt >= a(bluetoothDevice)) {
                        JL_Log.e(a, "parseTargetInfo", RcspUtil.formatString("data length[%d] over MAX_COMMUNICATION_MTU[%d], cast away", Integer.valueOf(iByteToInt), Integer.valueOf(a(bluetoothDevice))));
                        return;
                    }
                    int iByteToInt2 = CHexConver.byteToInt(paramData[i + 1]);
                    int i3 = iByteToInt - 1;
                    byte[] bArr = new byte[i3];
                    if (i3 > 0 && i3 + i + 2 <= length) {
                        System.arraycopy(paramData, i2, bArr, 0, i3);
                        i2 = iByteToInt + 1 + i;
                        boolean z = true;
                        if (iByteToInt2 == 21) {
                            int iBytesToInt = CHexConver.bytesToInt(bArr);
                            targetInfoResponse.setSupportPackageCrc16((iBytesToInt & 1) == 1).setGetFileByNameWithDev((iBytesToInt & 2) == 2).setContactsTransferBySmallFile((iBytesToInt & 4) == 4);
                        } else if (iByteToInt2 != 31) {
                            switch (iByteToInt2) {
                                case 0:
                                    byte b2 = bArr[0];
                                    targetInfoResponse.setProtocolVersion("V_" + ((b2 >> 4) & 15) + FileUtils.FILE_EXTENSION_SEPARATOR + (b2 & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS));
                                    break;
                                case 1:
                                    if (i3 >= 3) {
                                        targetInfoResponse.setQuantity(CHexConver.byteToInt(bArr[0]));
                                        targetInfoResponse.setVolume(bArr[1]);
                                        targetInfoResponse.setMaxVol(bArr[2]);
                                        if (i3 > 3) {
                                            targetInfoResponse.setSupportVolumeSync((bArr[3] & 1) == 1);
                                        }
                                        if (i3 > 4) {
                                            targetInfoResponse.setLowPowerLimit(CHexConver.byteToInt(bArr[4]));
                                        }
                                    }
                                    break;
                                case 2:
                                    if (i3 >= 6) {
                                        byte[] bArr2 = new byte[6];
                                        System.arraycopy(bArr, 0, bArr2, 0, 6);
                                        targetInfoResponse.setEdrAddr(hexDataCovetToAddress(bArr2));
                                        if (i3 >= 8) {
                                            targetInfoResponse.setEdrProfile(bArr[6]).setEdrStatus(bArr[7]);
                                        }
                                    }
                                    break;
                                case 3:
                                    if (i3 > 8) {
                                        targetInfoResponse.setPlatform(bArr[0]);
                                        try {
                                            str4 = new String(bArr, 1, iByteToInt - 2);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            str4 = null;
                                        }
                                        targetInfoResponse.setLicense(str4);
                                    }
                                    break;
                                case 4:
                                    if (i3 >= 5) {
                                        byte[] bArr3 = new byte[4];
                                        System.arraycopy(bArr, 0, bArr3, 0, 4);
                                        targetInfoResponse.setFunctionMask(CHexConver.bytesToInt(bArr3)).setCurFunction(bArr[4]);
                                        if (i3 > 5) {
                                            byte b3 = bArr[5];
                                            targetInfoResponse.setSupportOfflineShow((b3 & 1) == 1).setSupportUsb((b3 & 2) == 2).setSupportSd0((b3 & 4) == 4).setSupportSd1((b3 & 8) == 8).setHideNetRadio((b3 & AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN) == 16);
                                        }
                                    }
                                    break;
                                case 5:
                                    if (i3 >= 2) {
                                        int iBytesToInt2 = CHexConver.bytesToInt(bArr[0], bArr[1]);
                                        targetInfoResponse.setVersionCode(iBytesToInt2).setVersionName("V_" + ((iBytesToInt2 >> 12) & 15) + FileUtils.FILE_EXTENSION_SEPARATOR + ((iBytesToInt2 >> 8) & 15) + FileUtils.FILE_EXTENSION_SEPARATOR + ((iBytesToInt2 >> 4) & 15) + FileUtils.FILE_EXTENSION_SEPARATOR + (iBytesToInt2 & 15));
                                    }
                                    break;
                                case 6:
                                    targetInfoResponse.setSdkType(CHexConver.byteToInt(bArr[0]));
                                    if (!targetInfoResponse.isSupportVolumeSync()) {
                                        if (targetInfoResponse.getSdkType() != 2 && targetInfoResponse.getSdkType() != 4) {
                                            z = false;
                                        }
                                        targetInfoResponse.setSupportVolumeSync(z);
                                    }
                                    break;
                                case 7:
                                    if (i3 != 2) {
                                        String strReplace = new String(bArr).replace("V", Constants.STR_EMPTY).replace("v", Constants.STR_EMPTY);
                                        targetInfoResponse.setUbootVersionName(strReplace);
                                        char[] charArray = strReplace.replace(FileUtils.FILE_EXTENSION_SEPARATOR, Constants.STR_EMPTY).toCharArray();
                                        if (charArray.length >= 4) {
                                            targetInfoResponse.setUbootVersionCode(CHexConver.bytesToInt(CHexConver.decodeHexChar(charArray[0], charArray[1]), CHexConver.decodeHexChar(charArray[2], charArray[3])));
                                        }
                                    } else {
                                        byte[] booleanArray = CHexConver.getBooleanArray(bArr[0]);
                                        byte[] booleanArray2 = CHexConver.getBooleanArray(bArr[1]);
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
                                        targetInfoResponse.setUbootVersionName(sb.toString());
                                        targetInfoResponse.setUbootVersionCode(CHexConver.bytesToInt(bArr[0], bArr[1]));
                                    }
                                    break;
                                case 8:
                                    targetInfoResponse.setSupportDoubleBackup(CHexConver.byteToInt(bArr[0]) == 1);
                                    if (i3 >= 2) {
                                        targetInfoResponse.setNeedBootLoader(CHexConver.byteToInt(bArr[1]) == 1);
                                        if (i3 >= 3) {
                                            targetInfoResponse.setSingleBackupOtaWay(CHexConver.byteToInt(bArr[2]));
                                        }
                                    }
                                    break;
                                case 9:
                                    targetInfoResponse.setMandatoryUpgradeFlag(CHexConver.byteToInt(bArr[0]));
                                    if (i3 >= 2) {
                                        targetInfoResponse.setRequestOtaFlag(CHexConver.byteToInt(bArr[1]));
                                        if (i3 >= 3) {
                                            targetInfoResponse.setExpandMode(CHexConver.byteToInt(bArr[2]));
                                        }
                                    }
                                    break;
                                case 10:
                                    if (i3 >= 4) {
                                        targetInfoResponse.setVid(BluetoothConstant.JL_VID).setUid(CHexConver.bytesToInt(bArr[0], bArr[1])).setPid(CHexConver.bytesToInt(bArr[2], bArr[3]));
                                        if (i3 >= 6) {
                                            targetInfoResponse.setVid(CHexConver.bytesToInt(bArr[0], bArr[1])).setPid(CHexConver.bytesToInt(bArr[2], bArr[3])).setUid(CHexConver.bytesToInt(bArr[4], bArr[5]));
                                        }
                                    }
                                    break;
                                case 11:
                                    try {
                                        str3 = new String(bArr);
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        str3 = null;
                                    }
                                    targetInfoResponse.setAuthKey(str3);
                                    break;
                                case 12:
                                    try {
                                        str2 = new String(bArr);
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                        str2 = null;
                                    }
                                    targetInfoResponse.setProjectCode(str2);
                                    break;
                                case 13:
                                    if (i3 >= 2) {
                                        int iBytesToInt3 = CHexConver.bytesToInt(bArr[0], bArr[1]);
                                        if (iBytesToInt3 > 0) {
                                            DeviceStatusManager.getInstance().updateDeviceMaxCommunicationMtu(bluetoothDevice, iBytesToInt3);
                                            DeviceStatusManager.getInstance().updateDeviceMaxReceiveMtu(bluetoothDevice, iBytesToInt3);
                                        }
                                        if (i3 >= 4) {
                                            int iBytesToInt4 = CHexConver.bytesToInt(bArr[2], bArr[3]);
                                            if (iBytesToInt3 > 0) {
                                                DeviceStatusManager.getInstance().updateDeviceMaxReceiveMtu(bluetoothDevice, iBytesToInt3);
                                            }
                                            if (iBytesToInt4 > 0) {
                                                DeviceStatusManager.getInstance().updateDeviceMaxCommunicationMtu(bluetoothDevice, iBytesToInt4);
                                            }
                                        }
                                    }
                                    break;
                                case 14:
                                    targetInfoResponse.setAllowConnectFlag(CHexConver.byteToInt(bArr[0]));
                                    break;
                                default:
                                    switch (iByteToInt2) {
                                        case 16:
                                            try {
                                                targetInfoResponse.setName(new String(bArr));
                                            } catch (Exception e4) {
                                                e4.printStackTrace();
                                            }
                                            break;
                                        case 17:
                                            targetInfoResponse.setBleOnly(bArr[0] == 1);
                                            if (i3 > 6) {
                                                byte[] bArr5 = new byte[6];
                                                System.arraycopy(bArr, 1, bArr5, 0, 6);
                                                targetInfoResponse.setBleAddr(hexDataCovetToAddress(bArr5));
                                            }
                                            if (i3 > 7) {
                                                targetInfoResponse.setBLEToSppWay((bArr[7] & 1) == 1);
                                            }
                                            break;
                                        case 18:
                                            byte b4 = bArr[0];
                                            targetInfoResponse.setEmitterStatus((b4 >> 4) & 15).setEmitterSupport((b4 & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS) == 1);
                                            break;
                                        case 19:
                                            targetInfoResponse.setExpandFunc(bArr);
                                            break;
                                    }
                                    break;
                            }
                        } else {
                            try {
                                str = new String(bArr);
                            } catch (Exception e5) {
                                e5.printStackTrace();
                                str = null;
                            }
                            targetInfoResponse.setCustomVersionMsg(str);
                        }
                    } else {
                        if (i3 != 0) {
                            JL_Log.w(a, "parseTargetInfo", "over limit.");
                            return;
                        }
                        JL_Log.w(a, "parseTargetInfo", "dataBuf is empty.");
                    }
                    i = i2;
                }
            }
        }
        JL_Log.w(a, "parseTargetInfo", "end ....... = " + targetInfoResponse);
    }

    public static int setDeviceMaxReceiveMtu(BluetoothDevice bluetoothDevice) {
        return DeviceStatusManager.getInstance().getMaxReceiveMtu(bluetoothDevice);
    }

    public static int a(byte[] bArr) {
        if (bArr == null || bArr.length != 8) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append(b2 & 255);
        }
        try {
            return Integer.valueOf(sb.toString(), 2).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
