package yqy.yichip.yc_lib_ota_3_gen;

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
import defpackage.d33;
import defpackage.fe;
import defpackage.gw1;
import defpackage.im3;
import defpackage.jm3;
import defpackage.l63;
import defpackage.nm3;
import defpackage.qm3;
import defpackage.rm3;
import defpackage.tf2;
import defpackage.wp;
import defpackage.wu1;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
public class _3GenOtaService extends Service {
    private String F;
    private String G;
    private String H;
    private Context a;
    private qm3 b;
    private fe c;
    private wp d;
    private BluetoothDevice e;
    private rm3 f;
    private nm3 g;
    private nm3 h;
    private nm3 i;
    private nm3 j;
    private Map l;
    private int m;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f451q;
    private int r;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    yqy.yichip.yc_lib_ota_3_gen.a k = null;
    private int n = 0;
    private int s = -1;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    private boolean R = false;
    private Handler S = new a();
    private Runnable T = new b();
    private gw1 U = new d();
    private wu1 V = new e();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                _3GenOtaService.this.M = true;
                _3GenOtaService.this.Q = false;
                _3GenOtaService.this.R = false;
                _3GenOtaService.this.F = Constants.STR_EMPTY;
                _3GenOtaService.this.m = 255;
                _3GenOtaService.this.E0(Config.Y_DENSITY);
                return;
            }
            switch (i) {
                case Config.Y_DENSITY /* 257 */:
                    _3GenOtaService.this.m = 16;
                    _3GenOtaService.this.D0("获取协议版本号...", true, true, true, 0);
                    _3GenOtaService.this.H0(jm3.p(), false);
                    break;
                case 258:
                    _3GenOtaService.this.m = 32;
                    _3GenOtaService.this.D0("获取BuckSize、packetMaxLen...", true, true, true, 0);
                    _3GenOtaService.this.H0(jm3.k(), false);
                    break;
                case 259:
                    _3GenOtaService.this.m = 48;
                    _3GenOtaService.this.D0("获取设备工作模式...", true, true, true, 0);
                    _3GenOtaService.this.H0(jm3.r(), false);
                    break;
                default:
                    switch (i) {
                        case 262:
                            _3GenOtaService.this.m = 96;
                            _3GenOtaService.this.D0("开始升级请求...", true, true, true, 0);
                            _3GenOtaService.this.w = (String) message.obj;
                            _3GenOtaService _3genotaservice = _3GenOtaService.this;
                            _3genotaservice.H0(jm3.o(_3genotaservice.w), false);
                            break;
                        case 263:
                            if ((_3GenOtaService.this.r + 1) % ((_3GenOtaService.this.p / (_3GenOtaService.this.f451q - 5)) + (_3GenOtaService.this.p % (_3GenOtaService.this.f451q + (-5)) > 0 ? 1 : 0)) == 0 || _3GenOtaService.this.r + 1 == _3GenOtaService.this.l.size()) {
                                _3GenOtaService.this.m = 128;
                                _3GenOtaService.this.H0(jm3.m(_3GenOtaService.this.r, (String) _3GenOtaService.this.l.get(Integer.valueOf(_3GenOtaService.this.r))), false);
                            } else {
                                _3GenOtaService.this.m = 112;
                                _3GenOtaService.this.H0(jm3.a(_3GenOtaService.this.r, (String) _3GenOtaService.this.l.get(Integer.valueOf(_3GenOtaService.this.r))), true);
                            }
                            break;
                        case 264:
                            _3GenOtaService.this.m = Opcodes.D2F;
                            _3GenOtaService.this.D0("结束升级请求...", true, true, true, 0);
                            _3GenOtaService _3genotaservice2 = _3GenOtaService.this;
                            _3genotaservice2.x = _3genotaservice2.w;
                            _3GenOtaService _3genotaservice3 = _3GenOtaService.this;
                            _3genotaservice3.g = _3genotaservice3.C0(_3genotaservice3.x);
                            if (_3GenOtaService.this.g != null) {
                                String strJ = l63.j(_3GenOtaService.this.g.b(), 4);
                                String strJ2 = l63.j(_3GenOtaService.this.g.a(), 4);
                                _3GenOtaService _3genotaservice4 = _3GenOtaService.this;
                                _3genotaservice4.H0(jm3.n(_3genotaservice4.x, strJ, strJ2), false);
                            } else {
                                _3GenOtaService.this.I0("升级异常--END 本地固件 checkSum获取失败");
                            }
                            break;
                        case 265:
                            _3GenOtaService.this.E0(259);
                            break;
                        case 266:
                            _3GenOtaService.L(_3GenOtaService.this);
                            int size = (_3GenOtaService.this.r * 100) / _3GenOtaService.this.l.size();
                            if (_3GenOtaService.this.f != null) {
                                _3GenOtaService.this.f.b(size);
                            }
                            _3GenOtaService.this.E0(263);
                            break;
                        case 267:
                            if (!TextUtils.equals(_3GenOtaService.this.u, "00")) {
                                _3GenOtaService.this.m = 64;
                                _3GenOtaService.this.D0("设备切换到Normal模式...", true, true, false, 0);
                                _3GenOtaService.this.v = "00";
                                _3GenOtaService _3genotaservice5 = _3GenOtaService.this;
                                _3genotaservice5.H0(jm3.q(_3genotaservice5.v), false);
                            } else if (!_3GenOtaService.this.N) {
                                _3GenOtaService.this.s = 0;
                                _3GenOtaService _3genotaservice6 = _3GenOtaService.this;
                                _3genotaservice6.h = _3genotaservice6.z0(_3genotaservice6.s);
                                if (_3GenOtaService.this.h != null) {
                                    _3GenOtaService.this.D0("本地固件OTA checkSum = " + _3GenOtaService.this.h.toString(), true, true, false, 0);
                                    String strJ3 = l63.j(_3GenOtaService.this.h.d() - 1, 4);
                                    String strJ4 = l63.j(_3GenOtaService.this.h.b(), 4);
                                    String strJ5 = l63.j(_3GenOtaService.this.h.a(), 4);
                                    _3GenOtaService.this.m = 80;
                                    _3GenOtaService.this.D0("获取设备中OTA部分的checkSum...", true, true, false, 0);
                                    _3GenOtaService.this.H0(jm3.l(strJ3, strJ4, strJ5), false);
                                } else {
                                    _3GenOtaService.this.I0("OTA升级异常--本地固件OTA checkSum获取失败");
                                }
                            } else if (!_3GenOtaService.this.O) {
                                _3GenOtaService.this.E0(268);
                            } else {
                                _3GenOtaService.this.N0(true, "升级成功！");
                            }
                            break;
                        case 268:
                            if (!TextUtils.equals(_3GenOtaService.this.u, "01")) {
                                _3GenOtaService.this.m = 64;
                                _3GenOtaService.this.D0("设备切换到OTA模式...", true, true, false, 0);
                                _3GenOtaService.this.v = "01";
                                _3GenOtaService _3genotaservice7 = _3GenOtaService.this;
                                _3genotaservice7.H0(jm3.q(_3genotaservice7.v), false);
                            } else if (!_3GenOtaService.this.O) {
                                _3GenOtaService.this.E0(270);
                            } else if (!_3GenOtaService.this.N) {
                                _3GenOtaService.this.E0(267);
                            } else {
                                _3GenOtaService.this.N0(true, "升级成功！");
                            }
                            break;
                        case 269:
                            _3GenOtaService.this.D0("OTA固件升级...", true, true, true, 0);
                            _3GenOtaService _3genotaservice8 = _3GenOtaService.this;
                            _3genotaservice8.l = yqy.yichip.yc_lib_ota_3_gen.a.e(_3genotaservice8.t, _3GenOtaService.this.h.d(), _3GenOtaService.this.h.c(), _3GenOtaService.this.p, _3GenOtaService.this.f451q);
                            if (_3GenOtaService.this.l == null || _3GenOtaService.this.l.size() == 0) {
                                _3GenOtaService.this.I0("OTA固件升级异常 -- 获取OTA部分数据为空");
                            } else {
                                _3GenOtaService.this.F0(262, "01");
                            }
                            break;
                        case 270:
                            if (!_3GenOtaService.this.P) {
                                _3GenOtaService.this.s = 2;
                                _3GenOtaService _3genotaservice9 = _3GenOtaService.this;
                                _3genotaservice9.j = _3genotaservice9.z0(_3genotaservice9.s);
                                if (_3GenOtaService.this.j != null) {
                                    _3GenOtaService.this.D0("本地固件提示音 checkSum = " + _3GenOtaService.this.j.toString(), true, true, false, 0);
                                    String strJ6 = l63.j(_3GenOtaService.this.j.d() - 1, 4);
                                    String strJ7 = l63.j(_3GenOtaService.this.j.b(), 4);
                                    String strJ8 = l63.j(_3GenOtaService.this.j.a(), 4);
                                    _3GenOtaService.this.m = 80;
                                    _3GenOtaService.this.D0("获取设备中提示音部分的checkSum...", true, true, false, 0);
                                    _3GenOtaService.this.H0(jm3.l(strJ6, strJ7, strJ8), false);
                                } else {
                                    _3GenOtaService.this.I0("提示音升级异常--本地固件提示音 checkSum获取失败");
                                }
                            } else {
                                _3GenOtaService.this.E0(271);
                            }
                            break;
                        case 271:
                            _3GenOtaService.this.D0("Normal固件升级...", true, true, true, 0);
                            _3GenOtaService _3genotaservice10 = _3GenOtaService.this;
                            _3genotaservice10.i = _3genotaservice10.z0(1);
                            _3GenOtaService _3genotaservice11 = _3GenOtaService.this;
                            _3genotaservice11.l = yqy.yichip.yc_lib_ota_3_gen.a.e(_3genotaservice11.t, _3GenOtaService.this.i.d(), _3GenOtaService.this.i.c(), _3GenOtaService.this.p, _3GenOtaService.this.f451q);
                            if (_3GenOtaService.this.l == null || _3GenOtaService.this.l.size() == 0) {
                                _3GenOtaService.this.I0("Normal固件升级异常 -- 获取Normal部分数据为空");
                            } else {
                                _3GenOtaService.this.F0(262, "00");
                            }
                            break;
                        case 272:
                            _3GenOtaService.this.D0("提示音升级...", true, true, true, 0);
                            _3GenOtaService _3genotaservice12 = _3GenOtaService.this;
                            _3genotaservice12.l = yqy.yichip.yc_lib_ota_3_gen.a.e(_3genotaservice12.t, _3GenOtaService.this.j.d(), _3GenOtaService.this.j.c(), _3GenOtaService.this.p, _3GenOtaService.this.f451q);
                            if (_3GenOtaService.this.l == null || _3GenOtaService.this.l.size() == 0) {
                                _3GenOtaService.this.I0("提示音升级异常 -- 获取Beep部分数据为空");
                            } else {
                                _3GenOtaService.this.F0(262, "02");
                            }
                            break;
                        default:
                            switch (i) {
                                case 513:
                                    tf2 tf2Var = (tf2) message.obj;
                                    if (!tf2Var.i()) {
                                        _3GenOtaService.this.I0("获取协议版本号失败：" + tf2Var.u());
                                    } else {
                                        int iD = tf2Var.d();
                                        _3GenOtaService.this.D0("协议版本号 protocolVerCode = " + iD, true, true, false, 1);
                                        _3GenOtaService.this.E0(258);
                                    }
                                    break;
                                case 514:
                                    tf2 tf2Var2 = (tf2) message.obj;
                                    if (!tf2Var2.i()) {
                                        _3GenOtaService.this.I0("获取buckSize、packetMaxLen失败: " + tf2Var2.r());
                                    } else {
                                        _3GenOtaService.this.p = tf2Var2.a();
                                        _3GenOtaService.this.f451q = tf2Var2.c();
                                        _3GenOtaService.this.D0("buckSize = " + _3GenOtaService.this.p + ",packetMaxLen = " + _3GenOtaService.this.f451q, true, true, false, 1);
                                        if (_3GenOtaService.this.f451q <= 20) {
                                            _3GenOtaService.this.E0(265);
                                        } else {
                                            _3GenOtaService.this.D0("申请MTU = packetMaxLen...", true, true, true, 0);
                                            _3GenOtaService _3genotaservice13 = _3GenOtaService.this;
                                            _3genotaservice13.K0(_3genotaservice13.f451q);
                                        }
                                    }
                                    break;
                                case 515:
                                    tf2 tf2Var3 = (tf2) message.obj;
                                    if (!tf2Var3.i()) {
                                        _3GenOtaService.this.I0("获取设备工作模式失败；" + tf2Var3.x());
                                    } else {
                                        _3GenOtaService.this.u = tf2Var3.h();
                                        _3GenOtaService.this.D0("设备工作模式 = " + _3GenOtaService.this.u, true, true, false, 1);
                                        _3GenOtaService.this.D0("检测升级...", true, true, false, 0);
                                        if (TextUtils.equals(_3GenOtaService.this.u, "00")) {
                                            _3GenOtaService.this.E0(267);
                                        } else if (TextUtils.equals(_3GenOtaService.this.u, "01")) {
                                            _3GenOtaService.this.N = true;
                                            _3GenOtaService.this.E0(268);
                                        }
                                    }
                                    break;
                                case 516:
                                    tf2 tf2Var4 = (tf2) message.obj;
                                    if (!tf2Var4.i()) {
                                        _3GenOtaService.this.I0("命令设备切换工作模式失败；" + tf2Var4.w());
                                    } else if (TextUtils.equals(_3GenOtaService.this.v, "01") || TextUtils.equals(_3GenOtaService.this.v, "00")) {
                                        _3GenOtaService.this.D0("设备切换工作模式成功", true, true, true, 1);
                                        _3GenOtaService.this.E0(Config.Y_DENSITY);
                                    }
                                    break;
                                case 517:
                                    tf2 tf2Var5 = (tf2) message.obj;
                                    if (!tf2Var5.i()) {
                                        _3GenOtaService.this.I0("获取设备中OTA部分checkSum失败:" + tf2Var5.s());
                                    } else {
                                        long jB = tf2Var5.b();
                                        _3GenOtaService.this.D0("flashCheckSumOTAInfo.getCheckSum() = " + _3GenOtaService.this.h.a() + ", rcvCheckSumOTA = " + jB, true, true, false, 0);
                                        if (jB != _3GenOtaService.this.h.a()) {
                                            _3GenOtaService.this.E0(269);
                                        } else {
                                            _3GenOtaService.this.N = true;
                                            _3GenOtaService.this.E0(268);
                                        }
                                    }
                                    break;
                                case 518:
                                    tf2 tf2Var6 = (tf2) message.obj;
                                    if (!tf2Var6.i()) {
                                        _3GenOtaService.this.I0("获取设备中提示音部分checkSum失败:" + tf2Var6.s());
                                    } else {
                                        long jB2 = tf2Var6.b();
                                        _3GenOtaService.this.D0("flashCheckSumBeepInfo.getCheckSum() = " + _3GenOtaService.this.j.a() + ", rcvCheckSumBeep = " + jB2, true, true, false, 0);
                                        if (jB2 != _3GenOtaService.this.j.a()) {
                                            _3GenOtaService.this.E0(272);
                                        } else {
                                            _3GenOtaService.this.P = true;
                                            _3GenOtaService.this.E0(271);
                                        }
                                    }
                                    break;
                                case 519:
                                    tf2 tf2Var7 = (tf2) message.obj;
                                    if (!tf2Var7.i()) {
                                        _3GenOtaService.this.I0("升级开始请求失败：" + tf2Var7.v());
                                    } else if (!TextUtils.equals(tf2Var7.e(), _3GenOtaService.this.w)) {
                                        _3GenOtaService.this.I0("升级开始请求失败：" + tf2Var7.v());
                                    } else {
                                        Log.d("_3GenOtaService", "perBuckPacketNum = " + ((_3GenOtaService.this.p / _3GenOtaService.this.f451q) + (_3GenOtaService.this.p % _3GenOtaService.this.f451q <= 0 ? 0 : 1)) + ",dataMap.size() = " + _3GenOtaService.this.l.size());
                                        _3GenOtaService.this.D0("开始发送升级数据...", true, true, true, 0);
                                        _3GenOtaService.this.y = d33.c();
                                        _3GenOtaService.this.r = 0;
                                        _3GenOtaService.this.E0(263);
                                    }
                                    break;
                                case 520:
                                    tf2 tf2Var8 = (tf2) message.obj;
                                    if (!tf2Var8.i()) {
                                        _3GenOtaService.this.I0("发送升级数据REQ 失败：" + tf2Var8.toString());
                                    } else {
                                        _3GenOtaService.L(_3GenOtaService.this);
                                        int size2 = (_3GenOtaService.this.r * 100) / _3GenOtaService.this.l.size();
                                        if (_3GenOtaService.this.f != null) {
                                            _3GenOtaService.this.f.b(size2);
                                        }
                                        if (_3GenOtaService.this.r < _3GenOtaService.this.l.size()) {
                                            _3GenOtaService.this.E0(263);
                                        } else {
                                            _3GenOtaService.this.z = d33.c();
                                            _3GenOtaService.this.D0("DATA数据发送完毕：curPacketId = " + _3GenOtaService.this.r + ",DATA包数：sendDataMap.size() = " + _3GenOtaService.this.l.size(), true, true, true, 1);
                                            _3GenOtaService.this.E0(264);
                                        }
                                    }
                                    break;
                                case 521:
                                    tf2 tf2Var9 = (tf2) message.obj;
                                    String strD = d33.d(_3GenOtaService.this.y, _3GenOtaService.this.z);
                                    if (!tf2Var9.i() || !TextUtils.equals(_3GenOtaService.this.x, tf2Var9.e()) || _3GenOtaService.this.g.b() != tf2Var9.g() || _3GenOtaService.this.g.a() != tf2Var9.f()) {
                                        _3GenOtaService.this.D0("升级结束请求 失败：" + tf2Var9.t(), true, true, false, 2);
                                        if (TextUtils.equals(_3GenOtaService.this.x, "00")) {
                                            _3GenOtaService.this.O = false;
                                            _3GenOtaService.this.D0("Normal固件升级失败！", true, true, true, 2);
                                        } else if (TextUtils.equals(_3GenOtaService.this.x, "01")) {
                                            _3GenOtaService.this.N = false;
                                            _3GenOtaService.this.D0("OTA固件升级失败！", true, true, true, 2);
                                        } else if (TextUtils.equals(_3GenOtaService.this.x, "02")) {
                                            _3GenOtaService.this.P = false;
                                            _3GenOtaService.this.D0("提示音升级失败！", true, true, true, 2);
                                        }
                                        _3GenOtaService.this.N0(false, "升级失败！");
                                    } else if (TextUtils.equals(_3GenOtaService.this.x, "01")) {
                                        _3GenOtaService.this.G = strD;
                                        _3GenOtaService.this.N = true;
                                        _3GenOtaService.this.D0("OTA固件升级完成" + strD + ",升级成功", true, true, true, 1);
                                        if (!_3GenOtaService.this.O) {
                                            _3GenOtaService.this.D0("OTA固件升级完成" + strD, true, true, true, 1);
                                            _3GenOtaService.this.E0(Config.Y_DENSITY);
                                        } else {
                                            _3GenOtaService.this.N0(true, "升级成功！");
                                        }
                                    } else if (TextUtils.equals(_3GenOtaService.this.x, "02")) {
                                        _3GenOtaService.this.P = true;
                                        _3GenOtaService.this.D0("提示音升级完成" + strD, true, true, true, 1);
                                        _3GenOtaService.this.E0(271);
                                    } else if (TextUtils.equals(_3GenOtaService.this.x, "00")) {
                                        _3GenOtaService.this.H = strD;
                                        _3GenOtaService.this.O = true;
                                        _3GenOtaService.this.D0("Normal固件升级完成" + strD + ",升级成功", true, true, true, 1);
                                        if (!_3GenOtaService.this.N) {
                                            _3GenOtaService.this.D0("Normal固件升级完成" + strD, true, true, true, 1);
                                        } else {
                                            _3GenOtaService.this.N0(true, "升级成功！");
                                        }
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
            if (_3GenOtaService.this.m != 128) {
                _3GenOtaService.this.I0("数据通讯异常-等待回复超时!");
                return;
            }
            byte[] bArrM = jm3.m(_3GenOtaService.this.r, (String) _3GenOtaService.this.l.get(Integer.valueOf(_3GenOtaService.this.r)));
            _3GenOtaService.this.D0("数据确认包回馈超时，重新发送curPacketId = " + _3GenOtaService.this.r + "数据包，长度 = " + bArrM.length, true, true, true, 2);
            _3GenOtaService.this.H0(bArrM, true);
        }
    }

    class c implements Runnable {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            _3GenOtaService.this.d.c(this.a);
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
            Log.d("_3GenOtaService", "扫描结束");
            if (_3GenOtaService.this.f != null) {
                _3GenOtaService.this.f.c();
            } else {
                Log.e("_3GenOtaService", "a3GenOtaServiceActivityListener == null");
            }
        }

        @Override // defpackage.gw1
        public void c(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (_3GenOtaService.this.f != null) {
                _3GenOtaService.this.f.e(bluetoothDevice, i, bArr);
            } else {
                Log.e("_3GenOtaService", "a2GenOtaServiceActivityListener == null");
            }
        }

        @Override // defpackage.gw1
        public void d() {
            Log.e("_3GenOtaService", "扫描超时");
            _3GenOtaService.this.L0();
            if (_3GenOtaService.this.f != null) {
                _3GenOtaService.this.f.a();
            } else {
                Log.e("_3GenOtaService", "a3GenOtaServiceActivityListener == null");
            }
        }
    }

    class e implements wu1 {
        e() {
        }

        @Override // defpackage.wu1
        public void a(String str) {
            _3GenOtaService.this.I0(str);
        }

        @Override // defpackage.wu1
        public void b(String str, int i) {
            if (!_3GenOtaService.this.K) {
                _3GenOtaService.this.D0("应用未主动申请新MTU，设备主动返回！MTU = " + i, true, true, true, 2);
                return;
            }
            _3GenOtaService.this.K = false;
            if (i < _3GenOtaService.this.f451q) {
                _3GenOtaService.this.I0("申请的MTU溢出，最大值 = " + i);
                return;
            }
            _3GenOtaService.this.D0("申请成功，新的MTU = " + i, true, true, true, 1);
            _3GenOtaService.this.E0(265);
        }

        @Override // defpackage.wu1
        public void c() {
            _3GenOtaService.this.I = true;
            _3GenOtaService.this.D0("连接成功", true, true, true, 1);
            _3GenOtaService.this.G0(0, 3000L);
        }

        @Override // defpackage.wu1
        public void d(byte[] bArr) {
            if (_3GenOtaService.this.L) {
                _3GenOtaService.this.E0(266);
            }
        }

        @Override // defpackage.wu1
        public void e(BluetoothGatt bluetoothGatt) {
        }

        @Override // defpackage.wu1
        public void f(String str, int i) {
            if (i != 133) {
                _3GenOtaService.this.I = false;
                _3GenOtaService.this.I0(str + "!-- status = " + i);
                return;
            }
            if (_3GenOtaService.this.n >= 3) {
                _3GenOtaService.this.I = false;
                _3GenOtaService.this.I0("连接失败133异常-3次！");
                return;
            }
            _3GenOtaService.d0(_3GenOtaService.this);
            _3GenOtaService.this.D0("连接失败133异常！第" + _3GenOtaService.this.n + "次重连...", true, true, false, 2);
            _3GenOtaService _3genotaservice = _3GenOtaService.this;
            _3genotaservice.A0(_3genotaservice.o, _3GenOtaService.this.e);
        }

        @Override // defpackage.wu1
        public void g(byte[] bArr, String str) {
            if (!_3GenOtaService.this.L) {
                _3GenOtaService.this.S.removeCallbacks(_3GenOtaService.this.T);
                _3GenOtaService.this.I0("数据通讯异常-发送数据回调失败！数据：" + l63.b(bArr));
                return;
            }
            _3GenOtaService.this.D0("发送数据回调失败，长度" + bArr.length + "-->" + l63.b(bArr), true, true, true, 2);
        }

        @Override // defpackage.wu1
        public void h(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            String lowerCase = l63.b(bArr).toLowerCase();
            _3GenOtaService.this.D0("接收数据成功，长度" + bArr.length + "-->" + lowerCase, true, true, false, 1);
            byte b = 0;
            String strSubstring = lowerCase.substring(0, 2);
            String strSubstring2 = lowerCase.substring(4, 6);
            Log.w("_3GenOtaService", "otaEvt = " + strSubstring);
            if (_3GenOtaService.this.M && TextUtils.equals(strSubstring, "ab")) {
                strSubstring2.hashCode();
                switch (strSubstring2.hashCode()) {
                    case 1567:
                        if (!strSubstring2.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)) {
                            b = -1;
                        }
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
                        b = !strSubstring2.equals(Constants.VIA_REPORT_TYPE_START_GROUP) ? (byte) -1 : (byte) 6;
                        break;
                    case 1575:
                        b = !strSubstring2.equals("18") ? (byte) -1 : (byte) 7;
                        break;
                }
                switch (b) {
                    case 0:
                        if (_3GenOtaService.this.m == 16) {
                            _3GenOtaService.this.m = 17;
                            _3GenOtaService.this.S.removeCallbacks(_3GenOtaService.this.T);
                            tf2 tf2VarH = jm3.h(bArr);
                            if (tf2VarH == null) {
                                _3GenOtaService.this.I0("获取协议版本号失败");
                            } else {
                                _3GenOtaService.this.F0(513, tf2VarH);
                            }
                        }
                        break;
                    case 1:
                        if (_3GenOtaService.this.m == 32) {
                            _3GenOtaService.this.m = 33;
                            _3GenOtaService.this.S.removeCallbacks(_3GenOtaService.this.T);
                            tf2 tf2VarC = jm3.c(bArr);
                            if (tf2VarC == null) {
                                _3GenOtaService.this.I0("获取BuckSize、packetMaxLen失败");
                            } else {
                                _3GenOtaService.this.F0(514, tf2VarC);
                            }
                        }
                        break;
                    case 2:
                        if (_3GenOtaService.this.m == 48) {
                            _3GenOtaService.this.m = 49;
                            _3GenOtaService.this.S.removeCallbacks(_3GenOtaService.this.T);
                            tf2 tf2VarJ = jm3.j(bArr);
                            if (tf2VarJ == null) {
                                _3GenOtaService.this.I0("获取设备工作模式失败");
                            } else {
                                _3GenOtaService.this.F0(515, tf2VarJ);
                            }
                        }
                        break;
                    case 3:
                        if (_3GenOtaService.this.m == 64) {
                            _3GenOtaService.this.m = 65;
                            _3GenOtaService.this.S.removeCallbacks(_3GenOtaService.this.T);
                            tf2 tf2VarI = jm3.i(bArr);
                            if (tf2VarI == null) {
                                _3GenOtaService.this.I0("切换设备工作模式失败");
                            } else {
                                _3GenOtaService.this.F0(516, tf2VarI);
                            }
                        }
                        break;
                    case 4:
                        if (_3GenOtaService.this.m == 80) {
                            _3GenOtaService.this.m = 81;
                            _3GenOtaService.this.S.removeCallbacks(_3GenOtaService.this.T);
                            tf2 tf2VarD = jm3.d(bArr);
                            if (tf2VarD == null) {
                                _3GenOtaService.this.I0("获取设备的checkSum失败");
                            } else if (_3GenOtaService.this.s == 0) {
                                _3GenOtaService.this.F0(517, tf2VarD);
                            } else if (_3GenOtaService.this.s == 2) {
                                _3GenOtaService.this.F0(518, tf2VarD);
                            }
                        }
                        break;
                    case 5:
                        if (_3GenOtaService.this.m == 96) {
                            _3GenOtaService.this.m = 97;
                            _3GenOtaService.this.S.removeCallbacks(_3GenOtaService.this.T);
                            tf2 tf2VarG = jm3.g(bArr);
                            if (tf2VarG == null) {
                                _3GenOtaService.this.I0("开始升级请求失败");
                            } else {
                                _3GenOtaService.this.F0(519, tf2VarG);
                            }
                        }
                        break;
                    case 6:
                        if (_3GenOtaService.this.m == 128) {
                            _3GenOtaService.this.m = Opcodes.LOR;
                            _3GenOtaService.this.S.removeCallbacks(_3GenOtaService.this.T);
                            tf2 tf2VarE = jm3.e(bArr);
                            if (tf2VarE == null) {
                                _3GenOtaService.this.I0("升级数据确认失败");
                            } else {
                                _3GenOtaService.this.F0(520, tf2VarE);
                            }
                        }
                        break;
                    case 7:
                        if (_3GenOtaService.this.m == 144) {
                            _3GenOtaService.this.m = Opcodes.I2B;
                            _3GenOtaService.this.S.removeCallbacks(_3GenOtaService.this.T);
                            tf2 tf2VarF = jm3.f(bArr);
                            if (tf2VarF == null) {
                                _3GenOtaService.this.I0("结束升级请求失败");
                            } else {
                                _3GenOtaService.this.F0(521, tf2VarF);
                            }
                        }
                        break;
                    default:
                        _3GenOtaService.this.I0("数据通讯异常-接收到非协议数据包!");
                        break;
                }
            }
        }

        @Override // defpackage.wu1
        public void i(int i) {
            if (!_3GenOtaService.this.I) {
                _3GenOtaService.this.D0("连接失败!-- status = " + i, true, true, true, 2);
                return;
            }
            _3GenOtaService.this.S.removeCallbacks(_3GenOtaService.this.T);
            _3GenOtaService.this.I = false;
            _3GenOtaService.this.e = null;
            if (!_3GenOtaService.this.J) {
                _3GenOtaService.this.I0("设备异常断开连接！");
                _3GenOtaService.this.M0();
                return;
            }
            _3GenOtaService.this.J = false;
            if (_3GenOtaService.this.M || !_3GenOtaService.this.Q) {
                _3GenOtaService.this.D0("断开连接", true, true, true, 1);
                return;
            }
            _3GenOtaService.this.D0("断开连接", true, true, false, 1);
            _3GenOtaService _3genotaservice = _3GenOtaService.this;
            _3genotaservice.J0(_3genotaservice.R, _3GenOtaService.this.F);
        }
    }

    public class f extends Binder {
        private _3GenOtaService c;

        public f(_3GenOtaService _3genotaservice) {
            this.c = _3genotaservice;
        }
    }

    public _3GenOtaService() {
        Log.d("_3GenOtaService", "_3GenOtaService()-->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(int i, BluetoothDevice bluetoothDevice) {
        if (this.c == null) {
            Log.e("_3GenOtaService", "connectDevice(): btBluetooth == null");
            return;
        }
        if (this.I) {
            Log.e("_3GenOtaService", "connectDevice(): isConnected = true");
            return;
        }
        if (i != 0 && i != 1) {
            D0("connectDevice(): 没有该设备类型！", true, true, true, 2);
            return;
        }
        String[] strArrA = im3.a(i);
        if (strArrA == null) {
            D0("connectDevice(): uuidArray == null", true, true, true, 2);
        } else {
            this.c.l(strArrA[0], strArrA[1], strArrA[2], bluetoothDevice, 20000L, this.V);
        }
    }

    private void B0() {
        fe feVar = this.c;
        if (feVar == null) {
            Log.e("_3GenOtaService", "disConnectDevice(): btBluetooth == null");
        } else {
            if (!this.I) {
                Log.e("_3GenOtaService", "disConnectDevice(): isConnected = false");
                return;
            }
            this.J = true;
            feVar.m();
            D0("App主动断开 isAppDisConnect = true", true, true, false, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public nm3 C0(String str) {
        if (TextUtils.equals(str, "01")) {
            return this.h;
        }
        if (TextUtils.equals(str, "00")) {
            return this.i;
        }
        if (TextUtils.equals(str, "02")) {
            return this.j;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(int i) {
        this.S.sendEmptyMessage(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(int i, Object obj) {
        Message message = new Message();
        message.what = i;
        message.obj = obj;
        this.S.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(int i, long j) {
        this.S.sendEmptyMessageDelayed(i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(byte[] bArr, boolean z) {
        if (!this.I) {
            Log.e("_3GenOtaService", "sendMsg(): isConnected = false");
            return;
        }
        fe feVar = this.c;
        if (feVar == null) {
            Log.e("_3GenOtaService", "sendMsg(): btBluetooth == null");
            return;
        }
        this.L = z;
        boolean zS = feVar.s(bArr);
        String strB = l63.b(bArr);
        if (zS) {
            if (this.L) {
                return;
            }
            this.S.postDelayed(this.T, ProtocolConstants.CONNECTION_TIMEOUT_MS);
            return;
        }
        D0("发送数据" + zS + ": " + strB, true, true, true, 2);
        I0("数据通讯异常-数据发送操作失败！");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(String str) {
        this.m = 255;
        D0(str, true, true, true, 2);
        rm3 rm3Var = this.f;
        if (rm3Var != null) {
            rm3Var.onError(str);
        }
        B0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(boolean z, String str) {
        if (z) {
            D0(str, true, true, true, 1);
            rm3 rm3Var = this.f;
            if (rm3Var != null) {
                rm3Var.onSuccess(str);
                return;
            }
            return;
        }
        D0(str, true, true, true, 2);
        rm3 rm3Var2 = this.f;
        if (rm3Var2 != null) {
            rm3Var2.onError(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(int i) {
        if (!this.I) {
            Log.e("_3GenOtaService", "setMTU(): isConnected = false");
            return;
        }
        if (i > 512) {
            I0("申请MTU失败-申请值溢出！");
            return;
        }
        fe feVar = this.c;
        if (feVar == null) {
            Log.e("_3GenOtaService", "setMTU(): btBluetooth == null");
            return;
        }
        boolean zT = feVar.t(i);
        Log.e("_3GenOtaService", "setMTU(): isSetSuc = " + zT);
        if (zT) {
            this.K = true;
            return;
        }
        D0("申请MTU" + zT + "值: " + i, true, true, true, 2);
        I0("申请MTU失败-申请操作失败！");
    }

    static /* synthetic */ int L(_3GenOtaService _3genotaservice) {
        int i = _3genotaservice.r;
        _3genotaservice.r = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(boolean z, String str) {
        this.R = z;
        this.F = str;
        this.M = false;
        this.Q = true;
        this.m = 255;
        B0();
    }

    static /* synthetic */ int d0(_3GenOtaService _3genotaservice) {
        int i = _3genotaservice.n;
        _3genotaservice.n = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public nm3 z0(int i) {
        if (this.k == null) {
            this.k = new yqy.yichip.yc_lib_ota_3_gen.a(this.t);
        }
        if (i == 0) {
            return this.k.g();
        }
        if (i == 1) {
            return this.k.f();
        }
        if (i == 2) {
            return this.k.h();
        }
        return null;
    }

    public void D0(String str, boolean z, boolean z2, boolean z3, int i) {
        wp wpVar;
        rm3 rm3Var;
        if (z2) {
            if (i == 0) {
                Log.d("_3GenOtaService", str);
            } else if (i == 1) {
                Log.w("_3GenOtaService", str);
            } else if (i == 2) {
                Log.e("_3GenOtaService", str);
            } else {
                Log.d("_3GenOtaService", str);
            }
        }
        if (z3 && (rm3Var = this.f) != null) {
            rm3Var.d(str, i);
        }
        if (z && (wpVar = this.d) != null && wpVar.b()) {
            new Thread(new c(str)).start();
        }
    }

    public void L0() {
        if (this.c == null) {
            Log.e("_3GenOtaService", "stopScanDevice(): btBluetooth == null");
        } else {
            Log.d("_3GenOtaService", "停止扫描...");
            this.c.x();
        }
    }

    public void M0() {
        this.M = false;
        this.R = false;
        this.N = false;
        this.P = false;
        this.O = false;
        this.Q = false;
        this.G = null;
        this.H = null;
        this.m = 255;
        this.S.removeCallbacks(this.T);
        this.S.removeMessages(Config.Y_DENSITY);
        this.S.removeMessages(258);
        this.S.removeMessages(262);
        this.S.removeMessages(263);
        this.S.removeMessages(264);
        this.S.removeMessages(265);
        this.S.removeMessages(266);
        this.S.removeMessages(267);
        this.S.removeMessages(268);
        this.S.removeMessages(269);
        this.S.removeMessages(270);
        this.S.removeMessages(271);
        this.S.removeMessages(272);
        this.S.removeMessages(513);
        this.S.removeMessages(514);
        this.S.removeMessages(515);
        this.S.removeMessages(516);
        this.S.removeMessages(517);
        this.S.removeMessages(518);
        this.S.removeMessages(519);
        this.S.removeMessages(520);
        this.S.removeMessages(521);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            Log.e("_3GenOtaService", "onBind():intent == null");
            return null;
        }
        Log.d("_3GenOtaService", "onBind():return * IBinder");
        return new f(this);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("_3GenOtaService", "onCreate()-->");
        Context applicationContext = getApplicationContext();
        this.a = applicationContext;
        this.b = new qm3(applicationContext);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d("_3GenOtaService", "onDestroy()-->");
        super.onDestroy();
        if (this.I) {
            B0();
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.d("_3GenOtaService", "onUnbind()-->");
        return super.onUnbind(intent);
    }
}
