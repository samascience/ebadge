package yqy.yichip.yc_lib_ota_3_gen.wristband;

import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import cn.bertsir.zbar.Qr.Config;
import com.baji.protocol.model.ProtocolConstants;
import com.tencent.connect.common.Constants;
import defpackage.cm3;
import defpackage.d33;
import defpackage.fe;
import defpackage.fm3;
import defpackage.gw1;
import defpackage.jm3;
import defpackage.l63;
import defpackage.nm3;
import defpackage.rm3;
import defpackage.tf2;
import defpackage.wp;
import defpackage.wu1;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
public class _3GenBandOtaService extends Service {
    private Context a;
    private fm3 b;
    private fe c;
    private wp d;
    private BluetoothDevice e;
    private rm3 f;
    private nm3 g;
    private nm3 h;
    private nm3 i;
    private Map k;
    private int l;
    private int n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f453q;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    yqy.yichip.yc_lib_ota_3_gen.wristband.a j = null;
    private int m = 0;
    private int r = -1;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;
    private Handler O = new a();
    private Runnable P = new b();
    private gw1 Q = new d();
    private wu1 R = new e();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                _3GenBandOtaService.this.J = true;
                _3GenBandOtaService.this.M = false;
                _3GenBandOtaService.this.N = false;
                _3GenBandOtaService.this.z = Constants.STR_EMPTY;
                _3GenBandOtaService.this.l = 255;
                _3GenBandOtaService.this.y0(Config.Y_DENSITY);
                return;
            }
            if (i == 271) {
                _3GenBandOtaService.this.x0("Normal固件升级...", true, true, true, 0);
                _3GenBandOtaService _3genbandotaservice = _3GenBandOtaService.this;
                _3genbandotaservice.i = _3genbandotaservice.t0(1);
                _3GenBandOtaService _3genbandotaservice2 = _3GenBandOtaService.this;
                _3genbandotaservice2.k = yqy.yichip.yc_lib_ota_3_gen.wristband.a.d(_3genbandotaservice2.s, _3GenBandOtaService.this.i.d(), _3GenBandOtaService.this.i.c(), _3GenBandOtaService.this.o, _3GenBandOtaService.this.p);
                if (_3GenBandOtaService.this.k == null || _3GenBandOtaService.this.k.size() == 0) {
                    _3GenBandOtaService.this.C0("Normal固件升级异常 -- 获取Normal部分数据为空");
                    return;
                } else {
                    _3GenBandOtaService.this.z0(262, "00");
                    return;
                }
            }
            switch (i) {
                case Config.Y_DENSITY /* 257 */:
                    _3GenBandOtaService.this.l = 16;
                    _3GenBandOtaService.this.x0("获取协议版本号...", true, true, true, 0);
                    _3GenBandOtaService.this.B0(jm3.p(), false);
                    break;
                case 258:
                    _3GenBandOtaService.this.l = 32;
                    _3GenBandOtaService.this.x0("获取BuckSize、packetMaxLen...", true, true, true, 0);
                    _3GenBandOtaService.this.B0(jm3.k(), false);
                    break;
                case 259:
                    _3GenBandOtaService.this.l = 48;
                    _3GenBandOtaService.this.x0("获取设备工作模式...", true, true, true, 0);
                    _3GenBandOtaService.this.B0(jm3.r(), false);
                    break;
                default:
                    switch (i) {
                        case 262:
                            _3GenBandOtaService.this.l = 96;
                            _3GenBandOtaService.this.x0("开始升级请求...", true, true, true, 0);
                            _3GenBandOtaService.this.v = (String) message.obj;
                            _3GenBandOtaService _3genbandotaservice3 = _3GenBandOtaService.this;
                            _3genbandotaservice3.B0(jm3.o(_3genbandotaservice3.v), false);
                            break;
                        case 263:
                            if ((_3GenBandOtaService.this.f453q + 1) % ((_3GenBandOtaService.this.o / (_3GenBandOtaService.this.p - 5)) + (_3GenBandOtaService.this.o % (_3GenBandOtaService.this.p + (-5)) > 0 ? 1 : 0)) == 0 || _3GenBandOtaService.this.f453q + 1 == _3GenBandOtaService.this.k.size()) {
                                _3GenBandOtaService.this.l = 128;
                                _3GenBandOtaService.this.B0(jm3.m(_3GenBandOtaService.this.f453q, (String) _3GenBandOtaService.this.k.get(Integer.valueOf(_3GenBandOtaService.this.f453q))), false);
                            } else {
                                _3GenBandOtaService.this.l = 112;
                                _3GenBandOtaService.this.B0(jm3.a(_3GenBandOtaService.this.f453q, (String) _3GenBandOtaService.this.k.get(Integer.valueOf(_3GenBandOtaService.this.f453q))), true);
                            }
                            break;
                        case 264:
                            _3GenBandOtaService.this.l = Opcodes.D2F;
                            _3GenBandOtaService.this.x0("结束升级请求...", true, true, true, 0);
                            _3GenBandOtaService _3genbandotaservice4 = _3GenBandOtaService.this;
                            _3genbandotaservice4.w = _3genbandotaservice4.v;
                            _3GenBandOtaService _3genbandotaservice5 = _3GenBandOtaService.this;
                            _3genbandotaservice5.g = _3genbandotaservice5.w0(_3genbandotaservice5.w);
                            if (_3GenBandOtaService.this.g != null) {
                                String strJ = l63.j(_3GenBandOtaService.this.g.b(), 4);
                                String strJ2 = l63.j(_3GenBandOtaService.this.g.a(), 4);
                                _3GenBandOtaService _3genbandotaservice6 = _3GenBandOtaService.this;
                                _3genbandotaservice6.B0(jm3.n(_3genbandotaservice6.w, strJ, strJ2), false);
                            } else {
                                _3GenBandOtaService.this.C0("升级异常--END 本地固件 checkSum获取失败");
                            }
                            break;
                        case 265:
                            _3GenBandOtaService.this.y0(259);
                            break;
                        case 266:
                            _3GenBandOtaService.H(_3GenBandOtaService.this);
                            int size = (_3GenBandOtaService.this.f453q * 100) / _3GenBandOtaService.this.k.size();
                            if (_3GenBandOtaService.this.f != null) {
                                _3GenBandOtaService.this.f.b(size);
                            }
                            _3GenBandOtaService.this.y0(263);
                            break;
                        case 267:
                            if (!TextUtils.equals(_3GenBandOtaService.this.t, "00")) {
                                _3GenBandOtaService.this.l = 64;
                                _3GenBandOtaService.this.x0("设备切换到Normal模式...", true, true, false, 0);
                                _3GenBandOtaService.this.u = "00";
                                _3GenBandOtaService _3genbandotaservice7 = _3GenBandOtaService.this;
                                _3genbandotaservice7.B0(jm3.q(_3genbandotaservice7.u), false);
                            } else if (!_3GenBandOtaService.this.K) {
                                _3GenBandOtaService.this.r = 0;
                                _3GenBandOtaService _3genbandotaservice8 = _3GenBandOtaService.this;
                                _3genbandotaservice8.h = _3genbandotaservice8.t0(_3genbandotaservice8.r);
                                if (_3GenBandOtaService.this.h != null) {
                                    _3GenBandOtaService.this.x0("本地固件OTA checkSum = " + _3GenBandOtaService.this.h.toString(), true, true, false, 0);
                                    String strJ3 = l63.j(_3GenBandOtaService.this.h.d() - 1, 4);
                                    String strJ4 = l63.j(_3GenBandOtaService.this.h.b(), 4);
                                    String strJ5 = l63.j(_3GenBandOtaService.this.h.a(), 4);
                                    _3GenBandOtaService.this.l = 80;
                                    _3GenBandOtaService.this.x0("获取设备中OTA部分的checkSum...", true, true, false, 0);
                                    _3GenBandOtaService.this.B0(jm3.l(strJ3, strJ4, strJ5), false);
                                } else {
                                    _3GenBandOtaService.this.C0("OTA升级异常--本地固件OTA checkSum获取失败");
                                }
                            } else if (!_3GenBandOtaService.this.L) {
                                _3GenBandOtaService.this.y0(268);
                            } else {
                                _3GenBandOtaService.this.H0(true, "升级成功！");
                            }
                            break;
                        case 268:
                            if (!TextUtils.equals(_3GenBandOtaService.this.t, "01")) {
                                _3GenBandOtaService.this.l = 64;
                                _3GenBandOtaService.this.x0("设备切换到OTA模式...", true, true, false, 0);
                                _3GenBandOtaService.this.u = "01";
                                _3GenBandOtaService _3genbandotaservice9 = _3GenBandOtaService.this;
                                _3genbandotaservice9.B0(jm3.q(_3genbandotaservice9.u), false);
                            } else if (!_3GenBandOtaService.this.L) {
                                _3GenBandOtaService.this.y0(271);
                            } else if (!_3GenBandOtaService.this.K) {
                                _3GenBandOtaService.this.y0(267);
                            } else {
                                _3GenBandOtaService.this.H0(true, "升级成功！");
                            }
                            break;
                        case 269:
                            _3GenBandOtaService.this.x0("OTA固件升级...", true, true, true, 0);
                            _3GenBandOtaService _3genbandotaservice10 = _3GenBandOtaService.this;
                            _3genbandotaservice10.k = yqy.yichip.yc_lib_ota_3_gen.wristband.a.d(_3genbandotaservice10.s, _3GenBandOtaService.this.h.d(), _3GenBandOtaService.this.h.c(), _3GenBandOtaService.this.o, _3GenBandOtaService.this.p);
                            if (_3GenBandOtaService.this.k == null || _3GenBandOtaService.this.k.size() == 0) {
                                _3GenBandOtaService.this.C0("OTA固件升级异常 -- 获取OTA部分数据为空");
                            } else {
                                _3GenBandOtaService.this.z0(262, "01");
                            }
                            break;
                        default:
                            switch (i) {
                                case 513:
                                    tf2 tf2Var = (tf2) message.obj;
                                    if (!tf2Var.i()) {
                                        _3GenBandOtaService.this.C0("获取协议版本号失败：" + tf2Var.u());
                                    } else {
                                        int iD = tf2Var.d();
                                        _3GenBandOtaService.this.x0("协议版本号 protocolVerCode = " + iD, true, true, false, 1);
                                        _3GenBandOtaService.this.y0(258);
                                    }
                                    break;
                                case 514:
                                    tf2 tf2Var2 = (tf2) message.obj;
                                    if (!tf2Var2.i()) {
                                        _3GenBandOtaService.this.C0("获取buckSize、packetMaxLen失败: " + tf2Var2.r());
                                    } else {
                                        _3GenBandOtaService.this.o = tf2Var2.a();
                                        _3GenBandOtaService.this.p = tf2Var2.c();
                                        _3GenBandOtaService.this.x0("buckSize = " + _3GenBandOtaService.this.o + ",packetMaxLen = " + _3GenBandOtaService.this.p, true, true, false, 1);
                                        if (_3GenBandOtaService.this.p <= 20) {
                                            _3GenBandOtaService.this.y0(265);
                                        } else {
                                            _3GenBandOtaService.this.x0("申请MTU = packetMaxLen...", true, true, true, 0);
                                            _3GenBandOtaService _3genbandotaservice11 = _3GenBandOtaService.this;
                                            _3genbandotaservice11.E0(_3genbandotaservice11.p);
                                        }
                                    }
                                    break;
                                case 515:
                                    tf2 tf2Var3 = (tf2) message.obj;
                                    if (!tf2Var3.i()) {
                                        _3GenBandOtaService.this.C0("获取设备工作模式失败；" + tf2Var3.x());
                                    } else {
                                        _3GenBandOtaService.this.t = tf2Var3.h();
                                        _3GenBandOtaService.this.x0("设备工作模式 = " + _3GenBandOtaService.this.t, true, true, false, 1);
                                        _3GenBandOtaService.this.x0("检测升级...", true, true, false, 0);
                                        if (TextUtils.equals(_3GenBandOtaService.this.t, "00")) {
                                            _3GenBandOtaService.this.y0(267);
                                        } else if (TextUtils.equals(_3GenBandOtaService.this.t, "01")) {
                                            _3GenBandOtaService.this.K = true;
                                            _3GenBandOtaService.this.y0(268);
                                        }
                                    }
                                    break;
                                case 516:
                                    tf2 tf2Var4 = (tf2) message.obj;
                                    if (!tf2Var4.i()) {
                                        _3GenBandOtaService.this.C0("命令设备切换工作模式失败；" + tf2Var4.w());
                                    } else if (TextUtils.equals(_3GenBandOtaService.this.u, "01") || TextUtils.equals(_3GenBandOtaService.this.u, "00")) {
                                        _3GenBandOtaService.this.x0("设备切换工作模式成功", true, true, true, 1);
                                        _3GenBandOtaService.this.y0(Config.Y_DENSITY);
                                    }
                                    break;
                                case 517:
                                    tf2 tf2Var5 = (tf2) message.obj;
                                    if (!tf2Var5.i()) {
                                        _3GenBandOtaService.this.C0("获取设备中OTA部分checkSum失败:" + tf2Var5.s());
                                    } else {
                                        long jB = tf2Var5.b();
                                        _3GenBandOtaService.this.x0("flashCheckSumOTAInfo.getCheckSum() = " + _3GenBandOtaService.this.h.a() + ", rcvCheckSumOTA = " + jB, true, true, false, 0);
                                        if (jB != _3GenBandOtaService.this.h.a()) {
                                            _3GenBandOtaService.this.y0(269);
                                        } else {
                                            _3GenBandOtaService.this.K = true;
                                            _3GenBandOtaService.this.y0(268);
                                        }
                                    }
                                    break;
                                default:
                                    switch (i) {
                                        case 519:
                                            tf2 tf2Var6 = (tf2) message.obj;
                                            if (!tf2Var6.i()) {
                                                _3GenBandOtaService.this.C0("升级开始请求失败：" + tf2Var6.v());
                                            } else if (!TextUtils.equals(tf2Var6.e(), _3GenBandOtaService.this.v)) {
                                                _3GenBandOtaService.this.C0("升级开始请求失败：" + tf2Var6.v());
                                            } else {
                                                Log.d("_3GenBandOtaService", "perBuckPacketNum = " + ((_3GenBandOtaService.this.o / _3GenBandOtaService.this.p) + (_3GenBandOtaService.this.o % _3GenBandOtaService.this.p <= 0 ? 0 : 1)) + ",dataMap.size() = " + _3GenBandOtaService.this.k.size());
                                                _3GenBandOtaService.this.x0("开始发送升级数据...", true, true, true, 0);
                                                _3GenBandOtaService.this.x = d33.c();
                                                _3GenBandOtaService.this.f453q = 0;
                                                _3GenBandOtaService.this.y0(263);
                                            }
                                            break;
                                        case 520:
                                            tf2 tf2Var7 = (tf2) message.obj;
                                            if (!tf2Var7.i()) {
                                                _3GenBandOtaService.this.C0("发送升级数据REQ 失败：" + tf2Var7.toString());
                                            } else {
                                                _3GenBandOtaService.H(_3GenBandOtaService.this);
                                                int size2 = (_3GenBandOtaService.this.f453q * 100) / _3GenBandOtaService.this.k.size();
                                                if (_3GenBandOtaService.this.f != null) {
                                                    _3GenBandOtaService.this.f.b(size2);
                                                }
                                                if (_3GenBandOtaService.this.f453q < _3GenBandOtaService.this.k.size()) {
                                                    _3GenBandOtaService.this.y0(263);
                                                } else {
                                                    _3GenBandOtaService.this.y = d33.c();
                                                    _3GenBandOtaService.this.x0("DATA数据发送完毕：curPacketId = " + _3GenBandOtaService.this.f453q + ",DATA包数：sendDataMap.size() = " + _3GenBandOtaService.this.k.size(), true, true, true, 1);
                                                    _3GenBandOtaService.this.y0(264);
                                                }
                                            }
                                            break;
                                        case 521:
                                            tf2 tf2Var8 = (tf2) message.obj;
                                            String strD = d33.d(_3GenBandOtaService.this.x, _3GenBandOtaService.this.y);
                                            if (!tf2Var8.i() || !TextUtils.equals(_3GenBandOtaService.this.w, tf2Var8.e()) || _3GenBandOtaService.this.g.b() != tf2Var8.g() || _3GenBandOtaService.this.g.a() != tf2Var8.f()) {
                                                _3GenBandOtaService.this.x0("升级结束请求 失败：" + tf2Var8.t(), true, true, false, 2);
                                                if (TextUtils.equals(_3GenBandOtaService.this.w, "00")) {
                                                    _3GenBandOtaService.this.L = false;
                                                    _3GenBandOtaService.this.x0("Normal固件升级失败！", true, true, true, 2);
                                                } else if (TextUtils.equals(_3GenBandOtaService.this.w, "01")) {
                                                    _3GenBandOtaService.this.K = false;
                                                    _3GenBandOtaService.this.x0("OTA固件升级失败！", true, true, true, 2);
                                                }
                                                _3GenBandOtaService.this.H0(false, "升级失败！");
                                            } else if (TextUtils.equals(_3GenBandOtaService.this.w, "01")) {
                                                _3GenBandOtaService.this.K = true;
                                                _3GenBandOtaService.this.x0("OTA固件升级完成" + strD + ",升级成功", true, true, true, 1);
                                                if (!_3GenBandOtaService.this.L) {
                                                    _3GenBandOtaService.this.x0("OTA固件升级完成" + strD, true, true, true, 1);
                                                    _3GenBandOtaService.this.y0(Config.Y_DENSITY);
                                                } else {
                                                    _3GenBandOtaService.this.H0(true, "升级成功！");
                                                }
                                            } else if (TextUtils.equals(_3GenBandOtaService.this.w, "00")) {
                                                _3GenBandOtaService.this.L = true;
                                                _3GenBandOtaService.this.x0("Normal固件升级完成" + strD + ",升级成功", true, true, true, 1);
                                                if (!_3GenBandOtaService.this.K) {
                                                    _3GenBandOtaService.this.x0("Normal固件升级完成" + strD, true, true, true, 1);
                                                } else {
                                                    _3GenBandOtaService.this.H0(true, "升级成功！");
                                                }
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (_3GenBandOtaService.this.l != 128) {
                _3GenBandOtaService.this.C0("数据通讯异常-等待回复超时!");
                return;
            }
            byte[] bArrM = jm3.m(_3GenBandOtaService.this.f453q, (String) _3GenBandOtaService.this.k.get(Integer.valueOf(_3GenBandOtaService.this.f453q)));
            _3GenBandOtaService.this.x0("数据确认包回馈超时，重新发送curPacketId = " + _3GenBandOtaService.this.f453q + "数据包，长度 = " + bArrM.length, true, true, true, 2);
            _3GenBandOtaService.this.B0(bArrM, true);
        }
    }

    class c implements Runnable {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            _3GenBandOtaService.this.d.c(this.a);
        }
    }

    class d implements gw1 {
        d() {
        }

        @Override // defpackage.gw1
        public void a() {
        }

        @Override // defpackage.gw1
        public void b() {
            Log.d("_3GenBandOtaService", "扫描结束");
            if (_3GenBandOtaService.this.f != null) {
                _3GenBandOtaService.this.f.c();
            } else {
                Log.e("_3GenBandOtaService", "a3GenOtaServiceActivityListener == null");
            }
        }

        @Override // defpackage.gw1
        public void c(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (_3GenBandOtaService.this.f != null) {
                _3GenBandOtaService.this.f.e(bluetoothDevice, i, bArr);
            } else {
                Log.e("_3GenBandOtaService", "a2GenOtaServiceActivityListener == null");
            }
        }

        @Override // defpackage.gw1
        public void d() {
            Log.e("_3GenBandOtaService", "扫描超时");
            _3GenBandOtaService.this.F0();
            if (_3GenBandOtaService.this.f != null) {
                _3GenBandOtaService.this.f.a();
            } else {
                Log.e("_3GenBandOtaService", "a3GenOtaServiceActivityListener == null");
            }
        }
    }

    class e implements wu1 {
        e() {
        }

        @Override // defpackage.wu1
        public void a(String str) {
            _3GenBandOtaService.this.C0(str);
        }

        @Override // defpackage.wu1
        public void b(String str, int i) {
            if (!_3GenBandOtaService.this.H) {
                _3GenBandOtaService.this.x0("应用未主动申请新MTU，设备主动返回！MTU = " + i, true, true, true, 2);
                return;
            }
            _3GenBandOtaService.this.H = false;
            if (i < _3GenBandOtaService.this.p) {
                _3GenBandOtaService.this.C0("申请的MTU溢出，最大值 = " + i);
                return;
            }
            _3GenBandOtaService.this.x0("申请成功，新的MTU = " + i, true, true, true, 1);
            _3GenBandOtaService.this.y0(265);
        }

        @Override // defpackage.wu1
        public void c() {
            _3GenBandOtaService.this.F = true;
            _3GenBandOtaService.this.x0("连接成功", true, true, true, 1);
            _3GenBandOtaService.this.A0(0, 3000L);
        }

        @Override // defpackage.wu1
        public void d(byte[] bArr) {
            if (_3GenBandOtaService.this.I) {
                String strB = l63.b(bArr);
                _3GenBandOtaService.this.x0("发送数据回调成功，长度" + bArr.length + "-->" + strB, true, true, false, 1);
                _3GenBandOtaService.this.y0(266);
            }
        }

        @Override // defpackage.wu1
        public void e(BluetoothGatt bluetoothGatt) {
        }

        @Override // defpackage.wu1
        public void f(String str, int i) {
            if (i != 133) {
                _3GenBandOtaService.this.F = false;
                _3GenBandOtaService.this.C0(str + "!-- status = " + i);
                return;
            }
            if (_3GenBandOtaService.this.m >= 3) {
                _3GenBandOtaService.this.F = false;
                _3GenBandOtaService.this.C0("连接失败133异常-3次！");
                return;
            }
            _3GenBandOtaService.X(_3GenBandOtaService.this);
            _3GenBandOtaService.this.x0("连接失败133异常！第" + _3GenBandOtaService.this.m + "次重连...", true, true, false, 2);
            _3GenBandOtaService _3genbandotaservice = _3GenBandOtaService.this;
            _3genbandotaservice.u0(_3genbandotaservice.n, _3GenBandOtaService.this.e);
        }

        @Override // defpackage.wu1
        public void g(byte[] bArr, String str) {
            if (!_3GenBandOtaService.this.I) {
                _3GenBandOtaService.this.O.removeCallbacks(_3GenBandOtaService.this.P);
                _3GenBandOtaService.this.C0("数据通讯异常-发送数据回调失败！数据：" + l63.b(bArr));
                return;
            }
            _3GenBandOtaService.this.x0("发送数据回调失败，长度" + bArr.length + "-->" + l63.b(bArr), true, true, true, 2);
        }

        @Override // defpackage.wu1
        public void h(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            byte b = 6;
            String lowerCase = l63.b(bArr).toLowerCase();
            if (bArr.length < 3) {
            }
            _3GenBandOtaService.this.x0("接收数据成功，长度" + bArr.length + "-->" + lowerCase, true, true, false, 1);
            String strSubstring = lowerCase.substring(0, 2);
            String strSubstring2 = lowerCase.substring(4, 6);
            Log.w("_3GenBandOtaService", "otaEvt = " + strSubstring);
            if (_3GenBandOtaService.this.J && TextUtils.equals(strSubstring, "ab")) {
                strSubstring2.hashCode();
                switch (strSubstring2.hashCode()) {
                    case 1567:
                        b = !strSubstring2.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ) ? (byte) -1 : (byte) 0;
                        break;
                    case 1568:
                        b = !strSubstring2.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE) ? (byte) -1 : (byte) 1;
                        break;
                    case 1569:
                        b = !strSubstring2.equals(Constants.VIA_REPORT_TYPE_SET_AVATAR) ? (byte) -1 : (byte) 2;
                        break;
                    case 1570:
                        b = !strSubstring2.equals(Constants.VIA_REPORT_TYPE_JOININ_GROUP) ? (byte) -1 : (byte) 3;
                        break;
                    case 1571:
                        b = !strSubstring2.equals(Constants.VIA_REPORT_TYPE_MAKE_FRIEND) ? (byte) -1 : (byte) 4;
                        break;
                    case 1572:
                        b = !strSubstring2.equals(Constants.VIA_REPORT_TYPE_WPA_STATE) ? (byte) -1 : (byte) 5;
                        break;
                    case 1573:
                    default:
                        b = -1;
                        break;
                    case 1574:
                        if (!strSubstring2.equals(Constants.VIA_REPORT_TYPE_START_GROUP)) {
                            b = -1;
                        }
                        break;
                    case 1575:
                        b = !strSubstring2.equals("18") ? (byte) -1 : (byte) 7;
                        break;
                }
                switch (b) {
                    case 0:
                        if (_3GenBandOtaService.this.l == 16) {
                            _3GenBandOtaService.this.l = 17;
                            _3GenBandOtaService.this.O.removeCallbacks(_3GenBandOtaService.this.P);
                            tf2 tf2VarH = jm3.h(bArr);
                            if (tf2VarH == null) {
                                _3GenBandOtaService.this.C0("获取协议版本号失败");
                            } else {
                                _3GenBandOtaService.this.z0(513, tf2VarH);
                            }
                        }
                        break;
                    case 1:
                        if (_3GenBandOtaService.this.l == 32) {
                            _3GenBandOtaService.this.l = 33;
                            _3GenBandOtaService.this.O.removeCallbacks(_3GenBandOtaService.this.P);
                            tf2 tf2VarC = jm3.c(bArr);
                            if (tf2VarC == null) {
                                _3GenBandOtaService.this.C0("获取BuckSize、packetMaxLen失败");
                            } else {
                                _3GenBandOtaService.this.z0(514, tf2VarC);
                            }
                        }
                        break;
                    case 2:
                        if (_3GenBandOtaService.this.l == 48) {
                            _3GenBandOtaService.this.l = 49;
                            _3GenBandOtaService.this.O.removeCallbacks(_3GenBandOtaService.this.P);
                            tf2 tf2VarJ = jm3.j(bArr);
                            if (tf2VarJ == null) {
                                _3GenBandOtaService.this.C0("获取设备工作模式失败");
                            } else {
                                _3GenBandOtaService.this.z0(515, tf2VarJ);
                            }
                        }
                        break;
                    case 3:
                        if (_3GenBandOtaService.this.l == 64) {
                            _3GenBandOtaService.this.l = 65;
                            _3GenBandOtaService.this.O.removeCallbacks(_3GenBandOtaService.this.P);
                            tf2 tf2VarI = jm3.i(bArr);
                            if (tf2VarI == null) {
                                _3GenBandOtaService.this.C0("切换设备工作模式失败");
                            } else {
                                _3GenBandOtaService.this.z0(516, tf2VarI);
                            }
                        }
                        break;
                    case 4:
                        if (_3GenBandOtaService.this.l == 80) {
                            _3GenBandOtaService.this.l = 81;
                            _3GenBandOtaService.this.O.removeCallbacks(_3GenBandOtaService.this.P);
                            tf2 tf2VarD = jm3.d(bArr);
                            if (tf2VarD == null) {
                                _3GenBandOtaService.this.C0("获取设备的checkSum失败");
                            } else if (_3GenBandOtaService.this.r == 0) {
                                _3GenBandOtaService.this.z0(517, tf2VarD);
                            }
                        }
                        break;
                    case 5:
                        if (_3GenBandOtaService.this.l == 96) {
                            _3GenBandOtaService.this.l = 97;
                            _3GenBandOtaService.this.O.removeCallbacks(_3GenBandOtaService.this.P);
                            tf2 tf2VarG = jm3.g(bArr);
                            if (tf2VarG == null) {
                                _3GenBandOtaService.this.C0("开始升级请求失败");
                            } else {
                                _3GenBandOtaService.this.z0(519, tf2VarG);
                            }
                        }
                        break;
                    case 6:
                        if (_3GenBandOtaService.this.l == 128) {
                            _3GenBandOtaService.this.l = Opcodes.LOR;
                            _3GenBandOtaService.this.O.removeCallbacks(_3GenBandOtaService.this.P);
                            tf2 tf2VarE = jm3.e(bArr);
                            if (tf2VarE == null) {
                                _3GenBandOtaService.this.C0("升级数据确认失败");
                            } else {
                                _3GenBandOtaService.this.z0(520, tf2VarE);
                            }
                        }
                        break;
                    case 7:
                        if (_3GenBandOtaService.this.l == 144) {
                            _3GenBandOtaService.this.l = Opcodes.I2B;
                            _3GenBandOtaService.this.O.removeCallbacks(_3GenBandOtaService.this.P);
                            tf2 tf2VarF = jm3.f(bArr);
                            if (tf2VarF == null) {
                                _3GenBandOtaService.this.C0("结束升级请求失败");
                            } else {
                                _3GenBandOtaService.this.z0(521, tf2VarF);
                            }
                        }
                        break;
                    default:
                        _3GenBandOtaService.this.C0("数据通讯异常-接收到非协议数据包!");
                        break;
                }
            }
        }

        @Override // defpackage.wu1
        public void i(int i) {
            if (!_3GenBandOtaService.this.F) {
                _3GenBandOtaService.this.x0("连接失败!-- status = " + i, true, true, true, 2);
                return;
            }
            _3GenBandOtaService.this.O.removeCallbacks(_3GenBandOtaService.this.P);
            _3GenBandOtaService.this.F = false;
            _3GenBandOtaService.this.e = null;
            if (!_3GenBandOtaService.this.G) {
                _3GenBandOtaService.this.C0("设备异常断开连接！");
                _3GenBandOtaService.this.G0();
                return;
            }
            _3GenBandOtaService.this.G = false;
            if (_3GenBandOtaService.this.J || !_3GenBandOtaService.this.M) {
                _3GenBandOtaService.this.x0("断开连接", true, true, true, 1);
                return;
            }
            _3GenBandOtaService.this.x0("断开连接", true, true, false, 1);
            _3GenBandOtaService _3genbandotaservice = _3GenBandOtaService.this;
            _3genbandotaservice.D0(_3genbandotaservice.N, _3GenBandOtaService.this.z);
        }
    }

    public class f extends Binder {
        private _3GenBandOtaService c;

        public f(_3GenBandOtaService _3genbandotaservice) {
            this.c = _3genbandotaservice;
        }

        public _3GenBandOtaService a() {
            return this.c;
        }
    }

    public _3GenBandOtaService() {
        Log.d("_3GenBandOtaService", "_3GenOtaService()-->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(int i, long j) {
        this.O.sendEmptyMessageDelayed(i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(byte[] bArr, boolean z) {
        if (!this.F) {
            Log.e("_3GenBandOtaService", "sendMsg(): isConnected = false");
            return;
        }
        fe feVar = this.c;
        if (feVar == null) {
            Log.e("_3GenBandOtaService", "sendMsg(): btBluetooth == null");
            return;
        }
        this.I = z;
        boolean zS = feVar.s(bArr);
        String strB = l63.b(bArr);
        if (zS) {
            if (this.I) {
                return;
            }
            this.O.postDelayed(this.P, ProtocolConstants.CONNECTION_TIMEOUT_MS);
            return;
        }
        x0("发送数据" + zS + ": " + strB, true, true, true, 2);
        C0("数据通讯异常-数据发送操作失败！");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(String str) {
        this.l = 255;
        x0(str, true, true, true, 2);
        rm3 rm3Var = this.f;
        if (rm3Var != null) {
            rm3Var.onError(str);
        }
        v0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(boolean z, String str) {
        if (z) {
            x0(str, true, true, true, 1);
            rm3 rm3Var = this.f;
            if (rm3Var != null) {
                rm3Var.onSuccess(str);
                return;
            }
            return;
        }
        x0(str, true, true, true, 2);
        rm3 rm3Var2 = this.f;
        if (rm3Var2 != null) {
            rm3Var2.onError(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(int i) {
        if (!this.F) {
            Log.e("_3GenBandOtaService", "setMTU(): isConnected = false");
            return;
        }
        if (i > 512) {
            C0("申请MTU失败-申请值溢出！");
            return;
        }
        fe feVar = this.c;
        if (feVar == null) {
            Log.e("_3GenBandOtaService", "setMTU(): btBluetooth == null");
            return;
        }
        boolean zT = feVar.t(i);
        Log.e("_3GenBandOtaService", "setMTU(): isSetSuc = " + zT);
        if (zT) {
            this.H = true;
            return;
        }
        x0("申请MTU" + zT + "值: " + i, true, true, true, 2);
        C0("申请MTU失败-申请操作失败！");
    }

    static /* synthetic */ int H(_3GenBandOtaService _3genbandotaservice) {
        int i = _3genbandotaservice.f453q;
        _3genbandotaservice.f453q = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(boolean z, String str) {
        this.N = z;
        this.z = str;
        this.J = false;
        this.M = true;
        this.l = 255;
        v0();
    }

    static /* synthetic */ int X(_3GenBandOtaService _3genbandotaservice) {
        int i = _3genbandotaservice.m;
        _3genbandotaservice.m = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public nm3 t0(int i) {
        if (this.j == null) {
            this.j = new yqy.yichip.yc_lib_ota_3_gen.wristband.a(this.s);
        }
        if (i == 0) {
            return this.j.f();
        }
        if (i == 1) {
            return this.j.e();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int i, BluetoothDevice bluetoothDevice) {
        if (this.c == null) {
            Log.e("_3GenBandOtaService", "connectDevice(): btBluetooth == null");
            return;
        }
        if (this.F) {
            Log.e("_3GenBandOtaService", "connectDevice(): isConnected = true");
            return;
        }
        if (i != 0 && i != 1) {
            x0("connectDevice(): 没有该设备类型！", true, true, true, 2);
            return;
        }
        String[] strArrA = cm3.a(i);
        if (strArrA == null) {
            x0("connectDevice(): uuidArray == null", true, true, true, 2);
        } else {
            this.c.l(strArrA[0], strArrA[1], strArrA[2], bluetoothDevice, 20000L, this.R);
        }
    }

    private void v0() {
        fe feVar = this.c;
        if (feVar == null) {
            Log.e("_3GenBandOtaService", "disConnectDevice(): btBluetooth == null");
        } else {
            if (!this.F) {
                Log.e("_3GenBandOtaService", "disConnectDevice(): isConnected = false");
                return;
            }
            this.G = true;
            feVar.m();
            x0("App主动断开 isAppDisConnect = true", true, true, false, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public nm3 w0(String str) {
        if (TextUtils.equals(str, "01")) {
            return this.h;
        }
        if (TextUtils.equals(str, "00")) {
            return this.i;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(int i) {
        this.O.sendEmptyMessage(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(int i, Object obj) {
        Message message = new Message();
        message.what = i;
        message.obj = obj;
        this.O.sendMessage(message);
    }

    public void F0() {
        if (this.c == null) {
            Log.e("_3GenBandOtaService", "stopScanDevice(): btBluetooth == null");
        } else {
            Log.d("_3GenBandOtaService", "停止扫描...");
            this.c.x();
        }
    }

    public void G0() {
        this.J = false;
        this.N = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.l = 255;
        this.O.removeCallbacks(this.P);
        this.O.removeMessages(Config.Y_DENSITY);
        this.O.removeMessages(258);
        this.O.removeMessages(262);
        this.O.removeMessages(263);
        this.O.removeMessages(264);
        this.O.removeMessages(265);
        this.O.removeMessages(266);
        this.O.removeMessages(267);
        this.O.removeMessages(268);
        this.O.removeMessages(269);
        this.O.removeMessages(271);
        this.O.removeMessages(513);
        this.O.removeMessages(514);
        this.O.removeMessages(515);
        this.O.removeMessages(516);
        this.O.removeMessages(517);
        this.O.removeMessages(519);
        this.O.removeMessages(520);
        this.O.removeMessages(521);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            Log.e("_3GenBandOtaService", "onBind():intent == null");
            return null;
        }
        Log.d("_3GenBandOtaService", "onBind():return * IBinder");
        return new f(this);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("_3GenBandOtaService", "onCreate()-->");
        Context applicationContext = getApplicationContext();
        this.a = applicationContext;
        this.b = new fm3(applicationContext);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d("_3GenBandOtaService", "onDestroy()-->");
        super.onDestroy();
        if (this.F) {
            v0();
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.d("_3GenBandOtaService", "onUnbind()-->");
        return super.onUnbind(intent);
    }

    public void x0(String str, boolean z, boolean z2, boolean z3, int i) {
        wp wpVar;
        rm3 rm3Var;
        if (z2) {
            if (i == 0) {
                Log.d("_3GenBandOtaService", str);
            } else if (i == 1) {
                Log.w("_3GenBandOtaService", str);
            } else if (i == 2) {
                Log.e("_3GenBandOtaService", str);
            } else {
                Log.d("_3GenBandOtaService", str);
            }
        }
        if (z3 && (rm3Var = this.f) != null) {
            rm3Var.d(str, i);
        }
        if (z && (wpVar = this.d) != null && wpVar.b()) {
            new Thread(new c(str)).start();
        }
    }
}
