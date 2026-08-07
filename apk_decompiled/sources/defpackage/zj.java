package defpackage;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.util.Log;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.phy.otalib.model.OTAType;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class zj {
    private static String a = "zj";
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[OTAType.values().length];
            a = iArr;
            try {
                iArr[OTAType.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[OTAType.DeviceConnecting.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[OTAType.DeviceConnectFail.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[OTAType.DeviceDisconnected.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[OTAType.ServicesDiscovering.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[OTAType.SLBOTAConfirm.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[OTAType.SBHAppConfirm.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[OTAType.SBHOTAConfirm.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[OTAType.OTAServiceNotFound.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[OTAType.CharacteristicError.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[OTAType.MTUConflict.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[OTAType.SLBDeviceReady.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[OTAType.SBHAppDeviceReady.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[OTAType.SBHOTADeviceReady.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[OTAType.SBHAppOver.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public static boolean A(BluetoothGatt bluetoothGatt, String str) {
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString("5833FF01-9B8B-5191-6142-22A4536EF123"));
        if (service == null) {
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString("5833FF04-9B8B-5191-6142-22A4536EF123"));
        characteristic.setWriteType(1);
        characteristic.setValue(uw0.d(str));
        bluetoothGatt.writeCharacteristic(characteristic);
        return true;
    }

    public static boolean B(BluetoothGatt bluetoothGatt, String str) {
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString("0000FEB3-0000-1000-8000-00805F9B34FB"));
        if (service == null) {
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString("0000FED5-0000-1000-8000-00805F9B34FB"));
        characteristic.setWriteType(2);
        characteristic.setValue(uw0.d(str));
        bluetoothGatt.writeCharacteristic(characteristic);
        return true;
    }

    public static boolean C(BluetoothGatt bluetoothGatt, String str) {
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString("0000FEB3-0000-1000-8000-00805F9B34FB"));
        if (service == null) {
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString("0000FED7-0000-1000-8000-00805F9B34FB"));
        characteristic.setWriteType(1);
        characteristic.setValue(uw0.d(str));
        bluetoothGatt.writeCharacteristic(characteristic);
        return true;
    }

    public static String D(String str, int i) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(Constants.STR_EMPTY);
        for (int i2 = 0; i2 < i - length; i2++) {
            stringBuffer.append("0");
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static String E(String str) {
        String string = Constants.STR_EMPTY;
        for (int i = 0; i < str.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            int i2 = i * 2;
            sb.append(str.substring(i2, i2 + 2));
            sb.append(string);
            string = sb.toString();
        }
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0032  */
    public static int F(String str) {
        String str2;
        if (str == null) {
            return -1;
        }
        if (str.contains(FileUtils.FILE_EXTENSION_SEPARATOR)) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length == 3) {
                str2 = strArrSplit[0] + strArrSplit[1] + strArrSplit[2];
            } else {
                str2 = "0";
            }
        } else {
            str2 = "0";
        }
        return Integer.parseInt(str2);
    }

    public static String a(byte[] bArr, int i, int i2, boolean z) {
        if (bArr == null || bArr.length <= i || i2 <= 0) {
            return Constants.STR_EMPTY;
        }
        int iMin = Math.min(i2, bArr.length - i);
        char[] cArr = new char[iMin * 2];
        for (int i3 = 0; i3 < iMin; i3++) {
            byte b2 = bArr[i + i3];
            int i4 = i3 * 2;
            char[] cArr2 = b;
            cArr[i4] = cArr2[(b2 & 255) >>> 4];
            cArr[i4 + 1] = cArr2[b2 & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS];
        }
        if (!z) {
            return new String(cArr);
        }
        return "0x" + new String(cArr);
    }

    public static int b(byte[] bArr) {
        return bArr.length == 4 ? ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt() : ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort();
    }

    public static int c(int i, byte[] bArr) {
        for (byte b2 : bArr) {
            i ^= b2 << 8;
            for (int i2 = 0; i2 < 8; i2++) {
                i = (32768 & i) != 0 ? (i << 1) ^ 4129 : i << 1;
            }
        }
        return i;
    }

    private static int d(int i, byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = bArr2[i2];
            if (i3 < 0) {
                i3 += 256;
            }
            i ^= i3;
            for (int i4 = 8; i4 != 0; i4--) {
                i = (i & 1) != 0 ? (i >> 1) ^ 40961 : i >> 1;
            }
        }
        return i;
    }

    public static boolean e(String str, String str2) {
        return h(str).equals(str2);
    }

    public static boolean f(BluetoothGatt bluetoothGatt, List list) {
        OTAType oTATypeI = i(list, bluetoothGatt.getDevice().getAddress());
        OTAType oTAType = OTAType.SLBOTAConfirm;
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(oTATypeI == oTAType ? "0000FEB3-0000-1000-8000-00805F9B34FB" : "5833FF01-9B8B-5191-6142-22A4536EF123"));
        if (service == null) {
            Log.e(a, "Enable command notification Failed to get OTA service.");
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(oTATypeI == oTAType ? "0000FED8-0000-1000-8000-00805F9B34FB" : "5833FF03-9B8B-5191-6142-22A4536EF123"));
        if (characteristic == null) {
            Log.e(a, "Enable command notification Failed to get OTA feature.");
            return false;
        }
        if (!bluetoothGatt.setCharacteristicNotification(characteristic, true)) {
            Log.e(a, "Failed to set feature notification.");
            return false;
        }
        BluetoothGattDescriptor descriptor = characteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805F9B34FB"));
        descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        Log.d(a, "Set feature notification, wait for enable callback.");
        return bluetoothGatt.writeDescriptor(descriptor);
    }

    public static byte[] g(byte[] bArr) {
        return Arrays.copyOfRange(bArr, 4, bArr[3] + 4);
    }

    public static String h(String str) {
        return str.substring(0, 15) + String.format("%02X", Integer.valueOf((Integer.valueOf(str.substring(15), 16).intValue() + 1) & 255));
    }

    public static OTAType i(List list, String str) {
        return o(list, str).k();
    }

    private static OTAType j(List list) {
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            String upperCase = ((BluetoothGattCharacteristic) it.next()).getUuid().toString().toUpperCase();
            if (upperCase.equals("0000FED7-0000-1000-8000-00805F9B34FB")) {
                i |= 1;
            } else if (upperCase.equals("0000FED8-0000-1000-8000-00805F9B34FB")) {
                i |= 2;
            } else if (upperCase.equals("0000FED5-0000-1000-8000-00805F9B34FB")) {
                i |= 4;
            } else if (upperCase.equals("5833FF03-9B8B-5191-6142-22A4536EF123")) {
                i2 |= 1;
            } else if (upperCase.equals("5833FF02-9B8B-5191-6142-22A4536EF123")) {
                i2 |= 2;
            } else if (upperCase.equals("5833FF04-9B8B-5191-6142-22A4536EF123")) {
                i2 |= 4;
            }
        }
        if (i == 7 && i2 == 0) {
            return OTAType.SLBOTAConfirm;
        }
        if (i == 0 && i2 == 3) {
            return OTAType.SBHAppConfirm;
        }
        return (i == 0 && i2 == 7) ? OTAType.SBHOTAConfirm : OTAType.CharacteristicError;
    }

    public static OTAType k(OTAType oTAType) {
        int i = a.a[oTAType.ordinal()];
        if (i == 6) {
            return OTAType.SLBDeviceReady;
        }
        if (i != 7) {
            return i != 8 ? OTAType.NotifyEnableError : OTAType.SBHOTADeviceReady;
        }
        return OTAType.SBHAppDeviceReady;
    }

    public static OTAType l(List list) {
        Iterator it = list.iterator();
        int i = 0;
        BluetoothGattService bluetoothGattService = null;
        while (it.hasNext()) {
            BluetoothGattService bluetoothGattService2 = (BluetoothGattService) it.next();
            String upperCase = bluetoothGattService2.getUuid().toString().toUpperCase();
            if ("0000FEB3-0000-1000-8000-00805F9B34FB".equals(upperCase)) {
                i |= 1;
            } else if ("5833FF01-9B8B-5191-6142-22A4536EF123".equals(upperCase)) {
                i |= 2;
            }
            bluetoothGattService = bluetoothGattService2;
        }
        if (i == 0) {
            return OTAType.OTAServiceNotFound;
        }
        if (i != 1 && i != 2) {
            if (i == 3) {
                return OTAType.OTAServiceConfuse;
            }
            return null;
        }
        return j(bluetoothGattService.getCharacteristics());
    }

    public static String m(OTAType oTAType) {
        switch (a.a[oTAType.ordinal()]) {
            case 1:
                return Constants.STR_EMPTY;
            case 2:
                return "连接中...";
            case 3:
                return "连接失败！";
            case 4:
                return "设备连接已经断开！";
            case 5:
                return "连接成功，发现服务中...";
            case 6:
                return "特性确认,SLB升级模式！";
            case 7:
                return "特性确认,SBH App模式！";
            case 8:
                return "特性确认,SBH OTA模式！";
            case 9:
                return "设备缺少OTA的蓝牙服务！";
            case 10:
                return "特性异常!";
            case 11:
                return "不支持该设备:MTUSize不一致！";
            case 12:
                return "特性Enable成功，SLB设备已准备好！";
            case 13:
                return "特性Enable成功，SBH App已准备好！";
            case 14:
                return "特性Enable成功，SBH OTA已准备好！";
            case 15:
                return "App模式结束，等待二次扫描";
            default:
                return "未知状态";
        }
    }

    public static int n(fz1 fz1Var) {
        return d(0, uw0.d(fz1Var.d()));
    }

    public static o02 o(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            o02 o02Var = (o02) it.next();
            if (o02Var.h().equals(str)) {
                return o02Var;
            }
        }
        return null;
    }

    public static String p() {
        StringBuilder sb = new StringBuilder();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 32; i++) {
            sb.append(cArr[secureRandom.nextInt(16)]);
        }
        return String.valueOf(sb);
    }

    public static String q(byte[] bArr) {
        if (bArr.length != 4) {
            return null;
        }
        return Integer.parseInt(uw0.e(new byte[]{bArr[2]})) + FileUtils.FILE_EXTENSION_SEPARATOR + Integer.parseInt(uw0.e(new byte[]{bArr[1]})) + FileUtils.FILE_EXTENSION_SEPARATOR + Integer.parseInt(uw0.e(new byte[]{bArr[0]}));
    }

    public static byte[] r(String str) {
        return s(Integer.parseInt(str, 16));
    }

    public static byte[] s(int i) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(i);
        return byteBufferOrder.array();
    }

    public static String t(int i, long j, String str, int i2, int i3) {
        Log.e(a, "index：" + i + "，flash_addr：" + j + "，run_addr：" + str + "，size：" + i2 + "，checksum：" + i3);
        String strE = E(D(Long.toHexString(j), 8));
        String strE2 = E(D(str, 8));
        String strE3 = E(D(Integer.toHexString(i2), 8));
        String strE4 = E(D(Integer.toHexString(i3), 4));
        String str2 = "02" + D(Integer.toHexString(i), 2) + strE + strE2 + strE3 + strE4;
        Log.e(a, str2);
        return str2;
    }

    public static String u(int i, long j, String str, int i2, String str2) {
        String strE = E(D(Long.toHexString(j), 8));
        String strE2 = E(D(str, 8));
        String strE3 = E(D(Integer.toHexString(i2), 8));
        String strD = D(str2, 8);
        return "02" + D(Integer.toHexString(i), 2) + strE + strE2 + strE3 + strD;
    }

    public static String v(bj2 bj2Var) {
        String strB = ((fz1) bj2Var.c().get(0)).b();
        long j = Long.parseLong(strB, 16) & (-4096);
        long jE = Long.parseLong(strB, 16) & 4095;
        Iterator it = bj2Var.c().iterator();
        while (it.hasNext()) {
            jE += (long) ((fz1) it.next()).e();
        }
        return "05" + E(D(Long.toHexString(j), 8)) + E(D(Long.toHexString((jE + 4095) & (-4096)), 8));
    }

    public static void w(o02 o02Var, bj2 bj2Var) {
        String str = "01" + uw0.c(bj2Var.c().size()) + "00";
        Log.d(a, "分送分区个数：" + o02Var.h());
        z(o02Var.f(), str);
    }

    public static void x(o02 o02Var, bj2 bj2Var, long j) {
        fz1 fz1Var = (fz1) bj2Var.c().get(o02Var.o().e());
        if (285212672 <= Long.parseLong(fz1Var.b(), 16) && Long.parseLong(fz1Var.b(), 16) <= 285736959) {
            j = Long.parseLong(fz1Var.b(), 16);
        }
        if (bj2Var.d().endsWith(".res")) {
            o02Var.o().i(0L);
            j = 0;
        }
        String strT = t(o02Var.o().e(), j, fz1Var.b(), fz1Var.e(), n(fz1Var));
        if (bj2Var.d().endsWith(".hexe16")) {
            List listC = fz1Var.c();
            List list = (List) listC.get(listC.size() - 1);
            String str = (String) list.get(list.size() - 1);
            if (str.length() < 8) {
                str = ((String) list.get(list.size() - 2)) + str;
            }
            strT = u(o02Var.o().e(), j, fz1Var.b(), fz1Var.e(), str.substring(str.length() - 8));
        }
        Log.d(a, "发送分区详细信息：" + strT);
        z(o02Var.f(), strT);
    }

    public static void y(o02 o02Var, bj2 bj2Var) {
        String strV = v(bj2Var);
        Log.d(a, "发送资源详情信息");
        z(o02Var.f(), strV);
    }

    public static boolean z(BluetoothGatt bluetoothGatt, String str) {
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString("5833FF01-9B8B-5191-6142-22A4536EF123"));
        if (service == null) {
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString("5833FF02-9B8B-5191-6142-22A4536EF123"));
        characteristic.setWriteType(2);
        characteristic.setValue(uw0.d(str));
        bluetoothGatt.writeCharacteristic(characteristic);
        return true;
    }
}
