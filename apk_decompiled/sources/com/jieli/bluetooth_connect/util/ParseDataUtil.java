package com.jieli.bluetooth_connect.util;

import android.text.TextUtils;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import com.jieli.bt.decryption.HashDecryption;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.jieli.jl_rcsp.util.CHexConver;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class ParseDataUtil {
    private static final String TAG = "ParseDataUtil";
    private static final char[] mChars = CHexConver.b.toCharArray();

    public static String hexDataCovetToAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length == 6) {
            for (int i = 0; i < bArr.length; i++) {
                char[] cArr = mChars;
                sb.append(cArr[(bArr[i] & 255) >> 4]);
                sb.append(cArr[bArr[i] & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS]);
                if (i != bArr.length - 1) {
                    sb.append(":");
                }
            }
        }
        return sb.toString();
    }

    public static BleScanMessage isFilterBleDevice(BluetoothOption bluetoothOption, byte[] bArr) {
        char c;
        if (bluetoothOption == null || bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i + 2;
            if (i2 > length) {
                return null;
            }
            int iByteToInt = CHexConverter.byteToInt(bArr[i]);
            if (iByteToInt == 0) {
                i++;
            } else {
                if (iByteToInt < 1 || iByteToInt >= length - i) {
                    return null;
                }
                int i3 = i + 1;
                if (CHexConverter.byteToInt(bArr[i3]) == 255) {
                    if (i3 + iByteToInt > length) {
                        JL_Log.e(TAG, "isFilterBleDevice", "totalLen is error.");
                        return null;
                    }
                    int i4 = iByteToInt - 1;
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i2, bArr2, 0, i4);
                    if (i4 <= 2) {
                        return null;
                    }
                    byte[] bArr3 = new byte[2];
                    System.arraycopy(bArr2, 0, bArr3, 0, 2);
                    int iBytesToInt = CHexConverter.bytesToInt(bArr3[1], bArr3[0]);
                    int i5 = iByteToInt - 3;
                    byte[] bArr4 = new byte[i5];
                    System.arraycopy(bArr2, 2, bArr4, 0, i5);
                    BleScanMessage withOTAFlagFilter = parseWithOTAFlagFilter(bArr2, bluetoothOption.getOtaScanFilterData());
                    if (withOTAFlagFilter == null) {
                        int bleScanStrategy = bluetoothOption.getBleScanStrategy();
                        if (bleScanStrategy != 1) {
                            if (bleScanStrategy == 2) {
                                withOTAFlagFilter = parseBleScanMsg(2, bArr4, bArr2);
                            } else if (bleScanStrategy == 3) {
                                withOTAFlagFilter = parseBleScanMsg(3, bArr4, bArr2);
                                c = 3;
                            }
                            c = 2;
                        } else {
                            withOTAFlagFilter = parseBleScanMsg(3, bArr4, bArr2);
                            if (withOTAFlagFilter == null) {
                                withOTAFlagFilter = parseBleScanMsg(2, bArr4, bArr2);
                                c = 2;
                            } else {
                                c = 3;
                            }
                        }
                        if (withOTAFlagFilter == null) {
                            return null;
                        }
                        if (c == 2) {
                            withOTAFlagFilter.setVid(iBytesToInt);
                            String flagContent = withOTAFlagFilter.getFlagContent();
                            if (TextUtils.isEmpty(flagContent) || !flagContent.equals(bluetoothOption.getScanFilterData())) {
                                return null;
                            }
                        } else if (c != 3) {
                            return null;
                        }
                    }
                    return withOTAFlagFilter;
                }
                i += iByteToInt + 1;
            }
        }
    }

    private static BleScanMessage parseBleScanMsg(int i, byte[] bArr, byte[] bArr2) {
        if (i == 2) {
            return parseWithFlagFilter(bArr);
        }
        if (i != 3) {
            return null;
        }
        return parseWithHashFilter(bArr2);
    }

    public static BleScanMessage parseOTAFlagFilterWithBroad(byte[] bArr, String str) {
        BleScanMessage withOTAFlagFilter = null;
        if (bArr != null && bArr.length > 2) {
            int i = 0;
            while (true) {
                int i2 = i + 2;
                if (i2 <= bArr.length) {
                    int iByteToInt = CHexConverter.byteToInt(bArr[i]);
                    if (iByteToInt != 0) {
                        if (iByteToInt < 1) {
                            break;
                        }
                        int i3 = i + 1;
                        if (i3 + iByteToInt >= bArr.length) {
                            break;
                        }
                        if (CHexConverter.byteToInt(bArr[i3]) == 255) {
                            int i4 = iByteToInt - 1;
                            byte[] bArr2 = new byte[i4];
                            System.arraycopy(bArr, i2, bArr2, 0, i4);
                            withOTAFlagFilter = parseWithOTAFlagFilter(bArr2, str);
                            if (withOTAFlagFilter != null) {
                                break;
                            }
                        }
                        i += iByteToInt + 1;
                    } else {
                        i++;
                    }
                } else {
                    break;
                }
            }
        }
        return withOTAFlagFilter;
    }

    private static BleScanMessage parseTwsADV(byte[] bArr, BleScanMessage bleScanMessage) {
        if (bArr == null || bleScanMessage == null) {
            return null;
        }
        int deviceType = bleScanMessage.getDeviceType();
        if (deviceType != 0) {
            if (deviceType == 1) {
                return parseWithChargingBin(bArr, bleScanMessage);
            }
            if (deviceType != 2) {
                if (deviceType == 3) {
                    return parseWithTwsVer2(bArr, bleScanMessage);
                }
                if (deviceType != 4) {
                    if (deviceType != 5) {
                        return null;
                    }
                    return parseWithWatch(bArr, bleScanMessage);
                }
            }
        }
        return parseWithTwsVer1(bArr, bleScanMessage);
    }

    private static BleScanMessage parseWithChargingBin(byte[] bArr, BleScanMessage bleScanMessage) {
        if (bleScanMessage == null || bleScanMessage.getVersion() > 1 || (bleScanMessage.getVersion() == 0 && bArr.length != 29)) {
            return null;
        }
        if (bArr.length < 16) {
            return null;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.get(new byte[7]);
        byte[] bArr2 = new byte[6];
        ByteBuffer byteBuffer = byteBufferWrap.get(bArr2);
        String strHexDataCovetToAddress = hexDataCovetToAddress(bArr2);
        byte b = byteBuffer.get();
        int i = (b >> 7) & 1;
        int i2 = (b >> 6) & 1;
        int i3 = b & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS;
        byte b2 = byteBuffer.get();
        int i4 = (b2 >> 7) & 1;
        int i5 = b2 & 127;
        byte b3 = byteBuffer.get();
        int i6 = (b3 >> 7) & 1;
        int i7 = b3 & 127;
        byte b4 = byteBuffer.get();
        int i8 = (b4 >> 7) & 1;
        int i9 = b4 & 127;
        int iByteToInt = CHexConverter.byteToInt(byteBuffer.get());
        if (bleScanMessage.getVersion() != 0) {
            byteBuffer.rewind();
            bleScanMessage.setEdrAddr(strHexDataCovetToAddress).setSeq(iByteToInt).setTwsFlag(i).setChargingBinStatus(i2).setAction(i3).setEdrStatus(i3).setLeftCharging(i4 == 1).setLeftDeviceQuantity(i5).setRightCharging(i6 == 1).setRightDeviceQuantity(i7).setDeviceCharging(i8 == 1).setChargingBinQuantity(i9);
            return bleScanMessage;
        }
        int i10 = (byteBuffer.get() >> 7) & 1;
        byte[] bArr3 = new byte[8];
        byteBuffer.get(new byte[2]).get(bArr3).rewind();
        byte[] bArr4 = new byte[16];
        System.arraycopy(bArr, 0, bArr4, 0, 16);
        byte[] bArr5 = {b, b2, b3, b4};
        byte[] bArr6 = new byte[16];
        HashDecryption.decrypt(bArr4, 16, bArr5, 4, bArr6);
        byte[] bArr7 = new byte[8];
        int i11 = 0;
        while (i11 < 8) {
            int i12 = i11 + 1;
            bArr7[i11] = bArr6[i11 + i12];
            i11 = i12;
        }
        if (!Arrays.equals(bArr3, bArr7)) {
            return null;
        }
        bleScanMessage.setEdrAddr(strHexDataCovetToAddress).setSeq(iByteToInt).setTwsFlag(i).setChargingBinStatus(i2).setAction(i3).setEdrStatus(i3).setLeftCharging(i4 == 1).setLeftDeviceQuantity(i5).setRightCharging(i6 == 1).setRightDeviceQuantity(i7).setDeviceCharging(i8 == 1).setChargingBinQuantity(i9).setChargingBinMode(i10).setHash(bArr3);
        return bleScanMessage;
    }

    private static BleScanMessage parseWithFlagFilter(byte[] bArr) {
        int iByteToInt;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = bArr.length;
        BleScanMessage bleScanMessage = null;
        int i = 0;
        while (true) {
            int i2 = i + 2;
            if (i2 > length || (iByteToInt = CHexConverter.byteToInt(bArr[i])) <= 0) {
                break;
            }
            int iByteToInt2 = CHexConverter.byteToInt(bArr[i + 1]);
            int i3 = iByteToInt - 1;
            byte[] bArr2 = new byte[i3];
            if (i3 <= 0 || i3 + i + 2 > length) {
                return null;
            }
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            i += iByteToInt + 1;
            if (bleScanMessage == null) {
                bleScanMessage = new BleScanMessage();
            }
            if (iByteToInt2 != 0) {
                if (iByteToInt2 != 1) {
                    if (iByteToInt2 == 2) {
                        bleScanMessage.setPhoneVirtualAddress(bArr2);
                    } else if (iByteToInt2 != 3) {
                        if (iByteToInt2 == 4 && i3 >= 6) {
                            byte[] bArr3 = new byte[6];
                            System.arraycopy(bArr2, 0, bArr3, 0, 6);
                            bleScanMessage.setEdrAddr(hexDataCovetToAddress(bArr3));
                            if (i3 >= 7) {
                                bleScanMessage.setEdrStatus(CHexConverter.byteToInt(bArr2[6]));
                                if (i3 >= 8) {
                                    byte b = bArr2[7];
                                    int i4 = (b >> 7) & 1;
                                    int i5 = b & 127;
                                    bleScanMessage.setLeftCharging(i4 == 1);
                                    bleScanMessage.setLeftDeviceQuantity(i5);
                                }
                            }
                        }
                    } else if (i3 >= 3) {
                        bleScanMessage.setPid(CHexConverter.bytesToInt(bArr2[1], bArr2[0]));
                        bleScanMessage.setShowDialog(CHexConverter.byteToInt(bArr2[2]) == 1);
                    }
                } else if (i3 == 1) {
                    bleScanMessage.setPairedFlag(CHexConverter.byteToInt(bArr2[0]));
                }
            } else {
                bleScanMessage.setFlagContent(new String(bArr2));
            }
        }
        return bleScanMessage;
    }

    private static BleScanMessage parseWithHashFilter(byte[] bArr) {
        if (bArr != null && bArr.length >= 7) {
            byte[] bArr2 = new byte[2];
            ByteBuffer byteBuffer = ByteBuffer.wrap(bArr).get(bArr2);
            int iBytesToInt = CHexConverter.bytesToInt(bArr2[1], bArr2[0]);
            ByteBuffer byteBuffer2 = byteBuffer.get(bArr2);
            int iBytesToInt2 = CHexConverter.bytesToInt(bArr2[1], bArr2[0]);
            ByteBuffer byteBuffer3 = byteBuffer2.get(bArr2);
            int iBytesToInt3 = CHexConverter.bytesToInt(bArr2[1], bArr2[0]);
            byte b = byteBuffer3.get();
            int i = (b >> 4) & 255;
            BleScanMessage showDialog = new BleScanMessage().setVid(iBytesToInt).setUid(iBytesToInt2).setPid(iBytesToInt3).setDeviceType(i).setVersion(b & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS).setShowDialog(true);
            if (bArr.length > 7) {
                return parseTwsADV(bArr, showDialog);
            }
        }
        return null;
    }

    public static BleScanMessage parseWithOTAFlagFilter(byte[] bArr, String str) {
        if (bArr == null || str == null || str.length() == 0 || bArr.length <= str.getBytes().length + 2) {
            return null;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        short s = byteBufferWrap.getShort();
        byte[] bArr2 = new byte[str.getBytes().length];
        ByteBuffer byteBuffer = byteBufferWrap.get(bArr2);
        if (!Arrays.equals(reverseBuf(bArr2), str.getBytes())) {
            return null;
        }
        int iByteToInt = CHexConverter.byteToInt(byteBuffer.get());
        JL_Log.d(TAG, "parseWithOTAFlagFilter", "version :" + iByteToInt);
        if (iByteToInt == 0) {
            byte[] bArr3 = new byte[6];
            ByteBuffer byteBuffer2 = byteBuffer.get(bArr3);
            String strHexDataCovetToAddress = hexDataCovetToAddress(reverseBuf(bArr3));
            byte[] bArr4 = new byte[byteBuffer2.remaining()];
            byteBuffer2.get(bArr4);
            return new BleScanMessage().setOTA(true).setVid(s).setOtaADVVersion(iByteToInt).setOtaBleAddress(strHexDataCovetToAddress).setOtaADVReserve(bArr4);
        }
        if (iByteToInt != 1) {
            JL_Log.i(TAG, "parseWithOTAFlagFilter", "Not support version : " + iByteToInt);
            return null;
        }
        byte[] bArr5 = new byte[6];
        ByteBuffer byteBuffer3 = byteBuffer.get(bArr5);
        String strHexDataCovetToAddress2 = hexDataCovetToAddress(reverseBuf(bArr5));
        short s2 = byteBuffer3.getShort();
        short s3 = byteBuffer3.getShort();
        byte b = byteBuffer3.get();
        int i = (b >> 4) & 255;
        int i2 = b & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS;
        int iByteToInt2 = CHexConverter.byteToInt(byteBuffer3.get());
        byte[] bArr6 = new byte[byteBuffer3.remaining()];
        byteBuffer3.get(bArr6);
        return new BleScanMessage().setOTA(true).setOtaADVVersion(iByteToInt).setOtaBleAddress(strHexDataCovetToAddress2).setVid(s).setUid(s2).setPid(s3).setDeviceType(i).setVersion(i2).setLeftDeviceQuantity(iByteToInt2).setOtaADVReserve(bArr6);
    }

    private static BleScanMessage parseWithTwsVer1(byte[] bArr, BleScanMessage bleScanMessage) {
        int i;
        if (bArr.length != 29) {
            return null;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.get(new byte[7]);
        byte[] bArr2 = new byte[6];
        ByteBuffer byteBuffer = byteBufferWrap.get(bArr2);
        String strHexDataCovetToAddress = hexDataCovetToAddress(bArr2);
        byte b = byteBuffer.get();
        int iByteToInt = CHexConverter.byteToInt(b);
        byte b2 = byteBuffer.get();
        int i2 = (b2 >> 7) & 1;
        int i3 = b2 & 127;
        byte b3 = byteBuffer.get();
        int i4 = (b3 >> 7) & 1;
        int i5 = b3 & 127;
        byte b4 = byteBuffer.get();
        int i6 = (b4 >> 7) & 1;
        int i7 = b4 & 127;
        int iByteToInt2 = CHexConverter.byteToInt(byteBuffer.get());
        byte b5 = (bleScanMessage.getVersion() == 1 || bleScanMessage.getVersion() == 2) ? byteBuffer.get() : (byte) 0;
        if (bleScanMessage.getVersion() != 1) {
            i = bleScanMessage.getVersion() == 2 ? 2 : 3;
        } else {
            i = 2;
        }
        ByteBuffer byteBuffer2 = byteBuffer.get(new byte[i]);
        byte[] bArr3 = new byte[8];
        byteBuffer2.get(bArr3).rewind();
        byte[] bArr4 = new byte[16];
        System.arraycopy(bArr, 0, bArr4, 0, 16);
        byte[] bArr5 = {b, b2, b3, b4};
        byte[] bArr6 = new byte[16];
        HashDecryption.decrypt(bArr4, 16, bArr5, 4, bArr6);
        byte[] bArr7 = new byte[8];
        int i8 = 0;
        while (i8 < 8) {
            int i9 = i8 + 1;
            bArr7[i8] = bArr6[i8 + i9];
            i8 = i9;
        }
        if (!Arrays.equals(bArr3, bArr7)) {
            return null;
        }
        bleScanMessage.setEdrAddr(strHexDataCovetToAddress).setSeq(iByteToInt2).setAction(iByteToInt).setEdrStatus(iByteToInt).setLeftCharging(i2 == 1).setLeftDeviceQuantity(i3).setRightCharging(i4 == 1).setRightDeviceQuantity(i5).setDeviceCharging(i6 == 1).setChargingBinQuantity(i7).setHash(bArr3);
        if (bleScanMessage.getVersion() == 1) {
            bleScanMessage.setEnableConnect(CHexConverter.checkBitValue(b5, 0)).setSupportChargingCase(CHexConverter.checkBitValue(b5, 1));
            return bleScanMessage;
        }
        if (bleScanMessage.getVersion() != 2) {
            return bleScanMessage;
        }
        bleScanMessage.setConnectWay(CHexConverter.checkBitValue(b5, 0) ? 1 : 0).setSupportChargingCase(CHexConverter.checkBitValue(b5, 1));
        return bleScanMessage;
    }

    private static BleScanMessage parseWithTwsVer2(byte[] bArr, BleScanMessage bleScanMessage) {
        if (bArr.length < 10) {
            return null;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.get(new byte[7]);
        byte b = byteBufferWrap.get();
        int i = (b >> 7) & 1;
        int i2 = b & 127;
        byte b2 = byteBufferWrap.get();
        int i3 = (b2 >> 7) & 1;
        int i4 = b2 & 127;
        byte b3 = byteBufferWrap.get();
        bleScanMessage.setTwsFlag((b3 >> 7) & 1).setMainDevFlag((b3 >> 6) & 1).setEnableConnect(((b3 >> 5) & 1) == 1).setAction(b3 & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS).setLeftCharging(i == 1).setLeftDeviceQuantity(i2).setRightCharging(i3 == 1).setRightDeviceQuantity(i4);
        return bleScanMessage;
    }

    private static BleScanMessage parseWithWatch(byte[] bArr, BleScanMessage bleScanMessage) {
        if (bArr.length < 14) {
            return null;
        }
        byte[] bArr2 = new byte[6];
        System.arraycopy(bArr, 7, bArr2, 0, 6);
        bleScanMessage.setEdrAddr(hexDataCovetToAddress(bArr2));
        int i = bArr[13];
        bleScanMessage.setConnectWay((i >> 7) & 1);
        bleScanMessage.setAction(i & 15);
        return bleScanMessage;
    }

    private static byte[] reverseBuf(byte[] bArr) {
        if (bArr == null || bArr.length <= 1) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[(bArr.length - i) - 1];
        }
        return bArr2;
    }
}
