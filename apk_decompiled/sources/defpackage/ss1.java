package defpackage;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.baji.protocol.model.ProtocolConstants;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.phy.otalib.model.ConnectState;
import com.phy.otalib.model.OTAType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ss1 {
    public static final String b = "ss1";
    private static volatile ss1 c;
    private static Context d;
    private static List e;
    private static b g;
    private static BluetoothLeScanner h;
    private static boolean i;
    private static rs1 j;
    private static String l;
    private static boolean m;
    private static dj2 n;
    private static bj2 o;
    private static String r;
    private static String s;
    public static Context t;
    private final s02 a;
    private static final List f = new ArrayList();
    private static int k = 0;
    private static int p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static int f383q = 0;
    private static final ScanCallback u = new a();

    class a extends ScanCallback {
        a() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
            String deviceName = scanResult.getScanRecord().getDeviceName();
            if (deviceName == null || deviceName.isEmpty() || ss1.e == null) {
                return;
            }
            for (o02 o02Var : ss1.e) {
                if (zj.e(o02Var.h(), scanResult.getDevice().getAddress()) && o02Var.k() == OTAType.SBHAppOver) {
                    o02Var.v(scanResult.getDevice());
                    o02Var.G(deviceName);
                    o02Var.B(scanResult.getDevice().getAddress());
                    if (o02Var.k().ordinal() >= OTAType.OTAComplete.ordinal()) {
                        break;
                    }
                    o02Var.E(OTAType.SBHOTAChangeComplete);
                    ss1.p++;
                    Log.e(ss1.b, "扫描到并更新了设备地址：" + o02Var.h() + "，Num：" + ss1.p);
                    break;
                }
            }
            if (ss1.p == ss1.e.size() - ss1.f383q) {
                Log.e(ss1.b, "completeChangeOTA: 开始OTA");
                ss1.p = 0;
                ss1.V();
                ss1.U();
            }
        }
    }

    public static class b extends BluetoothGattCallback {
        private String a;
        private String b;
        private boolean c;

        class a extends HandlerThread {
            final /* synthetic */ o02 a;
            final /* synthetic */ String b;
            final /* synthetic */ BluetoothGatt c;

            /* JADX INFO: renamed from: ss1$b$a$a, reason: collision with other inner class name */
            class CountDownTimerC0169a extends CountDownTimer {
                CountDownTimerC0169a(long j, long j2) {
                    super(j, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    a.this.a.I(false);
                    if (a.this.b.equals("enableListener") && a.this.a.k() == OTAType.SLBOTAConfirm) {
                        ss1.X(a.this.a.h(), OTAType.Reconnection, "重新连接");
                    }
                    a aVar = a.this;
                    b.this.onConnectionStateChange(aVar.c, 0, 0);
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    a.this.a.I(true);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, o02 o02Var, String str2, BluetoothGatt bluetoothGatt) {
                super(str);
                this.a = o02Var;
                this.b = str2;
                this.c = bluetoothGatt;
            }

            @Override // android.os.HandlerThread
            protected void onLooperPrepared() {
                this.a.C(new CountDownTimerC0169a(ProtocolConstants.CONNECTION_TIMEOUT_MS, 1000L));
                this.a.i().start();
            }
        }

        /* JADX INFO: renamed from: ss1$b$b, reason: collision with other inner class name */
        class HandlerThreadC0170b extends HandlerThread {
            final /* synthetic */ BluetoothGatt a;
            final /* synthetic */ long b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            HandlerThreadC0170b(String str, BluetoothGatt bluetoothGatt, long j) {
                super(str);
                this.a = bluetoothGatt;
                this.b = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b(BluetoothGatt bluetoothGatt) {
                bluetoothGatt.disconnect();
                quitSafely();
            }

            @Override // android.os.HandlerThread
            protected void onLooperPrepared() {
                Handler handler = new Handler();
                final BluetoothGatt bluetoothGatt = this.a;
                handler.postDelayed(new Runnable() { // from class: ts1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b(bluetoothGatt);
                    }
                }, this.b);
            }
        }

        private void b(BluetoothGatt bluetoothGatt, long j) {
            new HandlerThreadC0170b("DelayedDisconnectThread", bluetoothGatt, j).start();
        }

        private void c(int i, o02 o02Var) {
            OTAType oTATypeK = o02Var.k();
            OTAType oTAType = OTAType.SBHOTAConfirm;
            if (oTATypeK == oTAType || o02Var.k() == OTAType.SLBOTAConfirm) {
                if (ss1.k != 0) {
                    if (ss1.k != i) {
                        ss1.X(o02Var.h(), OTAType.MTUConflict, "不支持该设备:MTUSize不一致！");
                        return;
                    }
                    return;
                }
                ss1.k = i;
                if (o02Var.k() == oTAType && ss1.o == null && ss1.l != null) {
                    Log.d(ss1.b, "handleMtu: OTA第一个设备进行文件分割");
                    ss1.o = bn0.a(ss1.l, ss1.k);
                }
            }
        }

        private void d(BluetoothGatt bluetoothGatt) {
            this.c = true;
            o02 o02VarO = zj.o(ss1.e, bluetoothGatt.getDevice().getAddress());
            if ("0087".equals(this.b)) {
                o02VarO.o().f(o02VarO.o().a() + 1);
                o02VarO.o().g(0);
                if (o02VarO.o().a() < ((fz1) ss1.o.c().get(o02VarO.o().e())).c().size()) {
                    o02VarO.o().h((List) ((fz1) ss1.o.c().get(o02VarO.o().e())).c().get(o02VarO.o().a()));
                    zj.A(o02VarO.f(), (String) o02VarO.o().c().get(o02VarO.o().b()));
                    return;
                }
                return;
            }
            if ("0085".equals(this.b)) {
                o02VarO.o().j(o02VarO.o().e() + 1);
                o02VarO.o().f(0);
                if (o02VarO.o().e() < ss1.o.c().size()) {
                    if (ss1.o.d().endsWith(".hex16") || ss1.o.d().endsWith(".hex") || ss1.o.d().endsWith(".hexe") || ss1.o.d().endsWith("hexe16")) {
                        fz1 fz1Var = (fz1) ss1.o.c().get(o02VarO.o().e() - 1);
                        if (285212672 > Long.parseLong(fz1Var.b(), 16) || Long.parseLong(fz1Var.b(), 16) > 285736959) {
                            if (ss1.o.d().endsWith("hexe16")) {
                                o02VarO.o().i(o02VarO.o().d() + ((long) fz1Var.e()) + 4);
                            } else {
                                o02VarO.o().i(o02VarO.o().d() + ((long) fz1Var.e()) + 8);
                            }
                        }
                    }
                    zj.x(o02VarO, ss1.o, o02VarO.o().d());
                    return;
                }
                return;
            }
            if ("0083".equals(this.b)) {
                zj.z(bluetoothGatt, "04");
                ss1.X(o02VarO.h(), OTAType.OTAComplete, "升级完成，等待断开");
                return;
            }
            if ("6887".equals(this.b)) {
                Log.d(ss1.b, "handleSbhChanged: 6887");
                return;
            }
            if ("0081".equals(this.b) || "0084".equals(this.b) || "0089".equals(this.b)) {
                Log.d(ss1.b, "handleSbhChanged: 0081 || 0084 || 0089 result: " + this.b);
                return;
            }
            if (this.b.length() == 34 && this.b.startsWith("71")) {
                o02VarO.y(this.b.substring(2));
                return;
            }
            if (this.b.length() == 34 && (this.b.startsWith("72") || this.b.startsWith("73") || this.b.startsWith("8B") || this.b.startsWith("8C") || this.b.startsWith("8D"))) {
                Log.d(ss1.b, "加密OTA中间处理");
                return;
            }
            Log.e(ss1.b, "error:" + this.b);
            if (o02VarO.c() < 4) {
                bluetoothGatt.disconnect();
            } else {
                ss1.X(o02VarO.h(), OTAType.OTAResponseError, "OTA响应错误");
            }
        }

        private void e(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String upperCase = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
            o02 o02VarO = zj.o(ss1.e, bluetoothGatt.getDevice().getAddress());
            if (this.a.equals("0102") || this.a.equals("0103")) {
                b(bluetoothGatt, 400L);
                ss1.X(o02VarO.h(), OTAType.SBHAppOver, "App模式结束，等待二次扫描");
            }
            if (o02VarO.o() == null) {
                return;
            }
            if (!upperCase.equals("5833FF02-9B8B-5191-6142-22A4536EF123")) {
                if (upperCase.equals("5833FF04-9B8B-5191-6142-22A4536EF123")) {
                    o02VarO.x(o02VarO.d() + bluetoothGattCharacteristic.getValue().length);
                    o02VarO.F((o02VarO.d() * 100.0f) / o02VarO.r());
                    ss1.Y(o02VarO.h(), (int) o02VarO.l());
                    o02VarO.o().g(o02VarO.o().b() + 1);
                    if (o02VarO.o().b() < o02VarO.o().c().size()) {
                        zj.A(o02VarO.f(), (String) o02VarO.o().c().get(o02VarO.o().b()));
                        return;
                    }
                    return;
                }
                return;
            }
            String str = this.b;
            if (str == null) {
                Log.e(ss1.b, "receiveData is null");
                return;
            }
            if (str.equals("0081") && this.c) {
                if (ss1.l.endsWith(".res")) {
                    zj.y(o02VarO, ss1.o);
                } else {
                    zj.x(o02VarO, ss1.o, o02VarO.o().d());
                    o02VarO.o().f(0);
                }
            } else if (this.b.equals("0084") && this.c) {
                o02VarO.o().g(0);
                o02VarO.o().h((List) ((fz1) ss1.o.c().get(o02VarO.o().e())).c().get(o02VarO.o().a()));
                zj.A(o02VarO.f(), (String) o02VarO.o().c().get(o02VarO.o().b()));
            } else if ("0089".equals(this.b)) {
                zj.x(o02VarO, ss1.o, o02VarO.o().d());
                o02VarO.o().f(0);
            }
            String str2 = this.b;
            if (str2 != null && str2.length() == 34 && this.b.startsWith("71")) {
                o02VarO.y(this.b.substring(2));
                zj.z(o02VarO.f(), "06" + ss1.s);
            } else {
                String str3 = this.b;
                if (str3 != null && str3.length() == 34 && this.b.startsWith("72")) {
                    String strA = g.a(o02VarO.e(), ss1.r);
                    if (this.b.substring(2).equals(strA)) {
                        String strC = g.c(g.c(strA, ss1.s), ss1.r);
                        zj.z(o02VarO.f(), "07" + strC);
                    } else {
                        Log.e(ss1.b, "responseSecurity: AES encryption verification failed");
                    }
                } else {
                    String str4 = this.b;
                    if (str4 != null && str4.length() == 34 && this.b.startsWith("73")) {
                        zj.z(o02VarO.f(), "0102");
                        this.b = "0102";
                    } else {
                        String str5 = this.b;
                        if (str5 != null && str5.length() == 34 && this.b.startsWith("8B")) {
                            o02VarO.y(this.b.substring(2));
                            zj.z(o02VarO.f(), "07" + ss1.s);
                        } else {
                            String str6 = this.b;
                            if (str6 != null && str6.length() == 34 && this.b.startsWith("8C")) {
                                String strA2 = g.a(o02VarO.e(), ss1.r);
                                if (this.b.substring(2).equals(strA2)) {
                                    String strC2 = g.c(g.c(strA2, ss1.s), ss1.r);
                                    zj.z(o02VarO.f(), "08" + strC2);
                                } else {
                                    Log.e(ss1.b, "responseSecurity: AES encryption verification failed");
                                }
                            } else {
                                String str7 = this.b;
                                if (str7 != null && str7.length() == 34 && this.b.startsWith("8D")) {
                                    zj.w(o02VarO, ss1.o);
                                } else if ("0102".equals(this.b) || "0103".equals(this.b)) {
                                    Log.e(ss1.b, "收到0102断开连接");
                                    bluetoothGatt.disconnect();
                                } else if ("04".equals(this.a)) {
                                    Log.e(ss1.b, "04写入成功");
                                }
                            }
                        }
                    }
                }
            }
            this.c = false;
        }

        private void f(BluetoothGatt bluetoothGatt, byte[] bArr) {
            o02 o02VarO = zj.o(ss1.e, bluetoothGatt.getDevice().getAddress());
            if (o02VarO.p().a() == o02VarO.p().b().size() || o02VarO.p().a() == 16) {
                byte b = bArr[1];
                if (b == 33) {
                    k(o02VarO, bArr);
                } else if (b == 38) {
                    g(o02VarO, bArr);
                } else if (b == 35) {
                    i(o02VarO, bArr);
                } else if (b == 36) {
                    j(o02VarO, bArr);
                }
            }
            o02VarO.p().j(bArr);
        }

        private void g(o02 o02Var, byte[] bArr) {
            if (1 == zj.g(bArr)[0]) {
                ss1.X(o02Var.h(), OTAType.OTAComplete, "升级完成，等待断开");
                o02Var.f().disconnect();
            } else {
                Log.e(ss1.b, "固件检查失败");
                ss1.X(o02Var.h(), OTAType.FirmwareCheckFailed, "固件检查失败");
                ss1.X(o02Var.h(), OTAType.Reconnection, "准备重连");
                o02Var.f().disconnect();
            }
        }

        private void h(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String upperCase = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
            o02 o02VarO = zj.o(ss1.e, bluetoothGatt.getDevice().getAddress());
            byte[] value = bluetoothGattCharacteristic.getValue();
            byte[] bArrE = o02VarO.p().e();
            if (!upperCase.equals("0000FED5-0000-1000-8000-00805F9B34FB")) {
                if (upperCase.equals("0000FED7-0000-1000-8000-00805F9B34FB") && value[1] == 47 && o02VarO.p().a() < o02VarO.p().b().size()) {
                    zj.C(o02VarO.f(), (String) o02VarO.p().b().get(o02VarO.p().a()));
                    o02VarO.p().f(o02VarO.p().a() + 1);
                    return;
                }
                return;
            }
            byte b = value[1];
            if (b == 32) {
                o02VarO.p().f(o02VarO.p().a() + 1);
                Log.d(ss1.b, "确认0x20写入成功 ：" + o02VarO.p().a());
                if (bArrE != null && bArrE[1] == 33) {
                    k(o02VarO, bArrE);
                    return;
                }
                return;
            }
            if (b == 34) {
                o02VarO.p().f(o02VarO.p().a() + 1);
                Log.d(ss1.b, "确认0x22写入成功 ：" + o02VarO.p().a());
                if (bArrE[1] == 35) {
                    i(o02VarO, bArrE);
                    return;
                }
                return;
            }
            if (b == 47 && bArrE[1] == 36) {
                j(o02VarO, bArrE);
                return;
            }
            if (b == 37) {
                o02VarO.p().f(o02VarO.p().a() + 1);
                Log.d(ss1.b, "确认0x25写入成功 ：" + o02VarO.p().a());
                if (bArrE[1] == 38) {
                    g(o02VarO, bArrE);
                }
            }
        }

        private void i(o02 o02Var, byte[] bArr) {
            byte[] bArrG = zj.g(bArr);
            byte b = bArrG[0];
            int iB = zj.b(Arrays.copyOfRange(bArrG, 1, 5));
            o02Var.p().i((bArrG[5] & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS) + 1);
            String str = ss1.b;
            Log.i(str, "onUpgradeRequest: " + String.format("upgradeFlag:%d, last:%08x, packetSize:%d", Integer.valueOf(b), Integer.valueOf(iB), Integer.valueOf(o02Var.p().d())));
            if (b != 1) {
                ss1.X(o02Var.h(), o02Var.k(), "不能升级");
                return;
            }
            ss1.X(o02Var.h(), o02Var.k(), "开始升级");
            ss1.z(o02Var, 47, ss1.A(iB, o02Var.p().d() * (ss1.k - 7)));
            String str2 = (String) o02Var.p().b().get(o02Var.p().a());
            Log.e(str, "第一条，size：" + o02Var.p().b().size() + "，index：" + o02Var.p().a() + "，开始写数据: " + str2);
            zj.C(o02Var.f(), str2);
            Log.e(str, "index + 1");
            o02Var.p().f(o02Var.p().a() + 1);
        }

        private void j(o02 o02Var, byte[] bArr) {
            int iB = zj.b(Arrays.copyOfRange(zj.g(bArr), 1, 5));
            if (iB < ss1.n.a().length) {
                ss1.z(o02Var, 47, ss1.A(iB, o02Var.p().d() * (ss1.k - 7)));
                String str = (String) o02Var.p().b().get(o02Var.p().a());
                Log.e(ss1.b, "收到0x24之后，第一条，size：" + o02Var.p().b().size() + "，index：" + o02Var.p().a() + "，开始写数据: " + str);
                zj.C(o02Var.f(), str);
                o02Var.p().f(o02Var.p().a() + 1);
            } else {
                ss1.z(o02Var, 37, new byte[]{1});
                zj.B(o02Var.f(), (String) o02Var.p().b().get(o02Var.p().a()));
            }
            int length = (iB * 100) / ss1.n.a().length;
            o02Var.F(length);
            ss1.Y(o02Var.h(), length);
        }

        private void k(o02 o02Var, byte[] bArr) {
            byte[] bArrG = zj.g(bArr);
            int iF = zj.F(zj.q(new byte[]{bArrG[1], bArrG[2], bArrG[3], 0}));
            ss1.X(o02Var.h(), o02Var.k(), "设备固件版本: " + String.format(Locale.getDefault(), "%d", Integer.valueOf(iF)));
            if (ss1.n.a().length <= 0) {
                return;
            }
            int iC = zj.c(65535, ss1.n.a());
            byte[] bArr2 = new byte[12];
            if (ss1.n.b() == null) {
                bArr2[0] = 0;
                System.arraycopy(zj.s(0), 0, bArr2, 1, 4);
            } else {
                bArr2[0] = 1;
                System.arraycopy(zj.r(ss1.n.b()), 0, bArr2, 1, 4);
            }
            System.arraycopy(zj.s(ss1.n.a().length), 0, bArr2, 5, 4);
            System.arraycopy(zj.s(iC), 0, bArr2, 9, 2);
            bArr2[11] = 0;
            ss1.z(o02Var, 34, bArr2);
            zj.B(o02Var.f(), (String) o02Var.p().b().get(o02Var.p().a()));
        }

        public void a(String str, o02 o02Var, BluetoothGatt bluetoothGatt) {
            o02Var.z(bluetoothGatt);
            o02Var.M(new a(str, o02Var, str, bluetoothGatt));
            o02Var.q().start();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            bluetoothGatt.getDevice().getAddress();
            this.b = uw0.e(bluetoothGattCharacteristic.getValue());
            String upperCase = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
            if ("5833FF03-9B8B-5191-6142-22A4536EF123".equals(upperCase)) {
                d(bluetoothGatt);
            } else if ("0000FED8-0000-1000-8000-00805F9B34FB".equals(upperCase)) {
                f(bluetoothGatt, bluetoothGattCharacteristic.getValue());
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            bluetoothGatt.getDevice().getAddress();
            this.a = uw0.e(bluetoothGattCharacteristic.getValue());
            String upperCase = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
            upperCase.hashCode();
            switch (upperCase) {
                case "5833FF02-9B8B-5191-6142-22A4536EF123":
                case "5833FF04-9B8B-5191-6142-22A4536EF123":
                    e(bluetoothGatt, bluetoothGattCharacteristic);
                    break;
                case "0000FED5-0000-1000-8000-00805F9B34FB":
                case "0000FED7-0000-1000-8000-00805F9B34FB":
                    h(bluetoothGatt, bluetoothGattCharacteristic);
                    break;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            String address = bluetoothGatt.getDevice().getAddress();
            if (i2 == 2) {
                for (o02 o02Var : ss1.e) {
                    if (o02Var.h().equals(address)) {
                        o02Var.u(ConnectState.CONNECTED);
                        o02Var.z(bluetoothGatt);
                        o02Var.i().cancel();
                        o02Var.q().quitSafely();
                        break;
                    }
                }
                ss1.X(address, OTAType.ServicesDiscovering, "连接成功，发现服务中...");
                bluetoothGatt.discoverServices();
                return;
            }
            if (i2 == 0) {
                Log.d(ss1.b, "断开连接：" + address);
                bluetoothGatt.close();
                if (ss1.e == null) {
                    return;
                }
                for (o02 o02Var2 : ss1.e) {
                    if (o02Var2.h().equals(address)) {
                        o02Var2.u(ConnectState.DISCONNECTED);
                        if (o02Var2.s()) {
                            o02Var2.I(false);
                            o02Var2.i().cancel();
                            o02Var2.q().quitSafely();
                        }
                        if (o02Var2.k() != OTAType.SBHAppOver) {
                            OTAType oTATypeK = o02Var2.k();
                            OTAType oTAType = OTAType.OTAComplete;
                            if (oTATypeK != oTAType) {
                                if (o02Var2.k().ordinal() <= oTAType.ordinal()) {
                                    if (o02Var2.c() >= 4) {
                                        ss1.X(address, OTAType.DeviceConnectFail, "无法连接设备！");
                                        break;
                                    } else {
                                        o02Var2.w(o02Var2.c() + 1);
                                        ss1.X(address, OTAType.Reconnection, "准备重连");
                                        break;
                                    }
                                }
                                Log.i(ss1.b, "设备本身异常情况" + o02Var2.k());
                                break;
                            }
                            Log.i(ss1.b, "升级成功断开");
                            ss1.Z(o02Var2);
                            break;
                        }
                        Log.d(ss1.b, "切换OTA断开");
                        break;
                    }
                }
                Log.e(ss1.b, "remove: " + address);
                ss1.f.remove(address);
                ss1.y();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            String address = bluetoothGatt.getDevice().getAddress();
            if (!"00002902-0000-1000-8000-00805F9B34FB".equalsIgnoreCase(bluetoothGattDescriptor.getUuid().toString())) {
                Log.d(ss1.b, "onDescriptorWrite: onReady Failed");
                return;
            }
            if (i != 0) {
                Log.e(ss1.b, "Enable异常断开连接");
                bluetoothGatt.disconnect();
                return;
            }
            o02 o02VarO = zj.o(ss1.e, address);
            if (o02VarO.s()) {
                o02VarO.I(false);
                o02VarO.i().cancel();
                o02VarO.q().quitSafely();
            }
            OTAType oTATypeK = zj.k(o02VarO.k());
            ss1.X(address, oTATypeK, zj.m(oTATypeK));
            if (ss1.m) {
                if (oTATypeK == OTAType.SBHAppDeviceReady) {
                    ss1.Q(o02VarO);
                } else if (oTATypeK == OTAType.SLBDeviceReady) {
                    ss1.S(o02VarO);
                } else if (oTATypeK == OTAType.SBHOTADeviceReady) {
                    ss1.R(o02VarO);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            String address = bluetoothGatt.getDevice().getAddress();
            if (i2 != 0) {
                Log.e(ss1.b, "修改MTU异常断开连接");
                bluetoothGatt.disconnect();
                return;
            }
            o02 o02VarO = zj.o(ss1.e, bluetoothGatt.getDevice().getAddress());
            c(i, o02VarO);
            if (zj.f(bluetoothGatt, ss1.e)) {
                a("enableListener", o02VarO, bluetoothGatt);
                return;
            }
            Log.e(ss1.b, "enable失败断连: " + address);
            ss1.X(address, OTAType.Reconnection, "Enable失败，重新连接");
            bluetoothGatt.disconnect();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i != 0) {
                Log.e(ss1.b, "发现服务异常断开连接");
                bluetoothGatt.disconnect();
                return;
            }
            OTAType oTATypeL = zj.l(bluetoothGatt.getServices());
            ss1.X(bluetoothGatt.getDevice().getAddress(), oTATypeL, zj.m(oTATypeL));
            if (oTATypeL.ordinal() < OTAType.OTAComplete.ordinal()) {
                bluetoothGatt.requestMtu(517);
            } else {
                bluetoothGatt.disconnect();
            }
        }
    }

    public ss1(Context context) {
        d = context;
        g = new b();
        h = ((BluetoothManager) d.getSystemService("bluetooth")).getAdapter().getBluetoothLeScanner();
        this.a = s02.b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] A(int i2, int i3) {
        return Arrays.copyOfRange(n.a(), i2, Math.min(n.a().length - i2, i3) + i2);
    }

    public static ss1 C(Context context) {
        if (c == null) {
            synchronized (ss1.class) {
                try {
                    if (c == null) {
                        c = new ss1(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public static void G(o02 o02Var) {
        String str;
        if (f.size() < 6) {
            String strH = o02Var.h();
            OTAType oTATypeK = o02Var.k();
            if (m) {
                str = "第 " + o02Var.c() + " 次重连中...";
            } else {
                str = "重新连接中...";
            }
            X(strH, oTATypeK, str);
            w(o02Var);
        }
    }

    private static void H(o02 o02Var) {
        if (o02Var.o() != null) {
            o02Var.K(new aj2(0, 0, 0));
            o02Var.o().h(new ArrayList());
            o02Var.o().g(0);
            o02Var.F(0.0f);
            o02Var.x(0.0f);
        }
        if (o02Var.p() != null) {
            o02Var.L(new cj2(0, 0, new ArrayList(), 0));
            o02Var.F(0.0f);
        }
        Log.d(b, "updateProcess: set " + o02Var.l());
    }

    private static void P() {
        Log.d(b, "二次扫描");
        if (i) {
            return;
        }
        i = true;
        h.startScan(u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(o02 o02Var) {
        String str;
        if (l.endsWith(".res")) {
            str = "0103";
        } else if (l.endsWith(".hex") || l.endsWith(".hex16")) {
            str = "0102";
        } else {
            if (l.endsWith(".hexe16")) {
                if (o02Var.o() == null) {
                    o02Var.K(new aj2(0, 0, 0));
                }
                s = zj.p();
                String str2 = "05" + g.c(s, r);
                X(o02Var.h(), o02Var.k(), "开始密钥校验");
                zj.z(o02Var.f(), str2);
                return;
            }
            str = null;
        }
        zj.z(o02Var.f(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void R(o02 o02Var) {
        Log.d(b, "开始Single Bank OTA升级，address：" + o02Var.h());
        o02Var.N((float) o.b());
        if (o02Var.o() == null) {
            o02Var.K(new aj2(0, 0, 0));
        }
        if (!l.endsWith(".hexe16")) {
            zj.w(o02Var, o);
            return;
        }
        s = zj.p();
        zj.z(o02Var.f(), "06" + g.c(s, r));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S(o02 o02Var) {
        if (o02Var.p() == null) {
            o02Var.L(new cj2(0, 0, new ArrayList(), 0));
        }
        z(o02Var, 32, new byte[]{0});
        String str = (String) o02Var.p().b().get(o02Var.p().a());
        X(o02Var.h(), o02Var.k(), "获取固件版本");
        zj.B(o02Var.f(), str);
    }

    public static void U() {
        List list = e;
        if (list == null || list.size() == 0) {
            Log.d(b, "没有升级设备");
            return;
        }
        if (l == null) {
            Log.d(b, "没有升级文件");
            return;
        }
        m = true;
        for (o02 o02Var : e) {
            if (o02Var.k() == OTAType.SLBDeviceReady && l.endsWith(".bin")) {
                S(o02Var);
            } else if (o02Var.k() == OTAType.SBHAppDeviceReady && (l.endsWith(".hex") || l.endsWith(".hex16") || l.endsWith(".res") || l.endsWith(".hexe16"))) {
                Q(o02Var);
            } else if (o02Var.k() == OTAType.SBHOTADeviceReady && (l.endsWith(".hex") || l.endsWith(".hex16") || l.endsWith(".res") || l.endsWith(".hexe16"))) {
                R(o02Var);
            } else {
                List list2 = f;
                if (list2.size() == 6) {
                    Log.d(b, "达到最大连接数量");
                    return;
                } else if (o02Var.a() == ConnectState.NOT_CONNECTED || o02Var.a() == ConnectState.DISCONNECTED) {
                    if (list2.size() < 6) {
                        x(o02Var);
                        if (list2.size() == 6) {
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V() {
        if (i) {
            i = false;
            h.stopScan(u);
        }
    }

    public static void X(String str, OTAType oTAType, String str2) {
        Log.i(b, "address: " + str + "，otaType：" + oTAType + "，msg：" + str2);
        List list = e;
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < e.size(); i2++) {
            if (((o02) e.get(i2)).h().equals(str)) {
                ((o02) e.get(i2)).E(oTAType);
                ((o02) e.get(i2)).D(str2);
                rs1 rs1Var = j;
                if (rs1Var != null) {
                    rs1Var.e(i2);
                    return;
                }
                return;
            }
        }
    }

    public static void Y(String str, int i2) {
        Log.e(b, "updateProcess: " + i2 + "% " + str);
        List list = e;
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i3 = 0; i3 < e.size(); i3++) {
            if (((o02) e.get(i3)).h().equals(str)) {
                ((o02) e.get(i3)).E(OTAType.OnOTAUpgrade);
                rs1 rs1Var = j;
                if (rs1Var != null) {
                    rs1Var.onProgress(i3, i2);
                    return;
                }
                return;
            }
        }
    }

    public static void Z(o02 o02Var) {
        List list = e;
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < e.size(); i2++) {
            if (((o02) e.get(i2)).h().equals(o02Var.h())) {
                rs1 rs1Var = j;
                if (rs1Var != null) {
                    rs1Var.k(i2, o02Var);
                    return;
                }
                return;
            }
        }
    }

    private static void w(o02 o02Var) {
        String str = b;
        StringBuilder sb = new StringBuilder();
        sb.append("连接设备数量：");
        List list = f;
        sb.append(list.size());
        Log.d(str, sb.toString());
        list.add(o02Var.h());
        o02Var.u(ConnectState.CONNECTING);
        g.a("connectingListener", o02Var, mb3.a() ? o02Var.b().connectGatt(d, false, g, 2, 2) : o02Var.b().connectGatt(d, false, g));
    }

    public static void x(o02 o02Var) {
        if (f.size() < 6) {
            X(o02Var.h(), OTAType.DeviceConnecting, "连接中...");
            w(o02Var);
        }
    }

    public static void y() {
        f383q = 0;
        if (e == null) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < e.size(); i3++) {
            o02 o02Var = (o02) e.get(i3);
            if (o02Var.k().ordinal() > OTAType.OTAComplete.ordinal()) {
                f383q++;
            }
            if (o02Var.k() == OTAType.None) {
                Log.d(b, "正常连接");
                X(o02Var.h(), OTAType.DeviceConnecting, "第" + o02Var.c() + "次连接");
                x(o02Var);
                return;
            }
            if (o02Var.k() == OTAType.Reconnection && o02Var.c() <= 4) {
                if (m) {
                    H(o02Var);
                    Log.e(b, "异常断开后，第" + o02Var.c() + "次连接");
                }
                G(o02Var);
                return;
            }
            if (o02Var.k() == OTAType.SBHAppOver) {
                i2++;
                Log.e(b, "满足条件的设备: " + i2);
            } else if (o02Var.k() == OTAType.SBHOTAChangeComplete) {
                X(o02Var.h(), OTAType.DeviceConnecting, "第" + o02Var.c() + "次连接");
                x(o02Var);
            }
        }
        if (e.size() == 0 || i2 != e.size() - f383q || e.size() == f383q) {
            return;
        }
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(o02 o02Var, int i2, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        int i3 = k;
        int i4 = i3 - 3;
        int i5 = i3 - 7;
        int length = bArr.length > 0 ? (bArr.length / i5) + (bArr.length % i5 > 0 ? 1 : 0) : 1;
        int length2 = (length * 4) + bArr.length;
        byte[] bArr2 = new byte[length2];
        Log.d(b, String.format("Total segments : %d, Total data length: %d", Integer.valueOf(length), Integer.valueOf(length2)));
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 * i5;
            int iMin = Math.min(bArr.length - i7, i5);
            int i8 = i6 * i4;
            bArr2[i8] = (byte) (o02Var.p().c() & 15);
            bArr2[i8 + 1] = (byte) i2;
            bArr2[i8 + 2] = (byte) ((((length - 1) & 15) << 4) | (i6 & 15));
            bArr2[i8 + 3] = (byte) iMin;
            if (bArr.length > 0) {
                System.arraycopy(bArr, i7, bArr2, i8 + 4, iMin);
            }
            o02Var.p().h(o02Var.p().c() + 1);
            o02Var.p().h(o02Var.p().c() % 16);
            arrayList.add(zj.a(bArr2, i8, i4, false));
        }
        o02Var.p().f(0);
        o02Var.p().g(arrayList);
    }

    public List B() {
        return e;
    }

    public boolean D() {
        return this.a.h();
    }

    public boolean E() {
        return m;
    }

    public void F(String str) {
        if (str == null) {
            Log.e(b, "filePath is Null!!!");
            return;
        }
        l = str;
        if (str.endsWith(".bin")) {
            n = bn0.b(str);
            return;
        }
        if (k == 0) {
            return;
        }
        Log.d(b, "parseFile: " + k);
        o = bn0.a(str, k);
    }

    public void I(Context context) {
        t = context;
    }

    public void J(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            o02 o02Var = (o02) it.next();
            o02Var.E(OTAType.None);
            o02Var.u(ConnectState.NOT_CONNECTED);
        }
        e = list;
    }

    public void K(List list) {
        J(list);
        if (list.size() > 0) {
            x((o02) list.get(0));
        }
    }

    public void L(String str) {
        r = str;
    }

    public void M(rs1 rs1Var) {
        j = rs1Var;
    }

    public void N(t02 t02Var) {
        this.a.i(t02Var);
    }

    public void O(boolean z) {
        m = z;
        k = 0;
        f383q = 0;
        p = 0;
        r = null;
        s = null;
        l = null;
        o = null;
        n = null;
        e = null;
    }

    public void T() {
        this.a.j();
    }

    public void W() {
        this.a.k();
    }

    public void u() {
        if (f.size() > 0) {
            for (int i2 = 0; i2 < e.size(); i2++) {
                if (((String) f.get(0)).equals(((o02) e.get(i2)).h())) {
                    ((o02) e.get(i2)).f().disconnect();
                }
            }
        }
        e.clear();
    }

    public void v() {
        for (int i2 = 0; i2 < f.size(); i2++) {
            for (int i3 = 0; i3 < e.size(); i3++) {
                if (((String) f.get(i2)).equals(((o02) e.get(i3)).h())) {
                    Log.e(b, "取消升级断开连接");
                    ((o02) e.get(i3)).f().disconnect();
                }
            }
        }
        e.clear();
        O(false);
    }
}
