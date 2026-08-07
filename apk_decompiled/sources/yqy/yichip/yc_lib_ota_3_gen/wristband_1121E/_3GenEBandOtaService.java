package yqy.yichip.yc_lib_ota_3_gen.wristband_1121E;

import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import cn.bertsir.zbar.Qr.Config;
import com.baji.protocol.model.ProtocolConstants;
import com.tencent.connect.common.Constants;
import defpackage.d33;
import defpackage.dm3;
import defpackage.fe;
import defpackage.fm3;
import defpackage.gm3;
import defpackage.gw1;
import defpackage.jm3;
import defpackage.l63;
import defpackage.nm3;
import defpackage.rm3;
import defpackage.tf2;
import defpackage.wp;
import defpackage.wu1;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
public class _3GenEBandOtaService extends Service {
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private Context a;
    private fm3 b;
    private fe c;
    private wp d;
    private BluetoothDevice e;
    private rm3 f;
    private nm3 g;
    private nm3 h;
    private nm3 i;
    private nm3 j;
    private nm3 k;
    private nm3 l;
    private Map n;
    private int o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f455q;
    private int r;
    private int s;
    private int t;
    private String v;
    private String w;
    private int x;
    private String y;
    private String z;
    yqy.yichip.yc_lib_ota_3_gen.wristband_1121E.a m = null;
    private int p = 0;
    private int u = -1;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    private boolean R = false;
    private boolean S = false;
    private boolean T = false;
    private boolean U = false;
    private boolean V = false;
    private int W = 0;
    private Handler X = new a(Looper.myLooper());
    private Runnable Y = new b();
    private gw1 Z = new d();
    private wu1 a0 = new e();

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                if (_3GenEBandOtaService.this.K) {
                    _3GenEBandOtaService.this.O = true;
                    _3GenEBandOtaService.this.U = false;
                    _3GenEBandOtaService.this.V = false;
                    _3GenEBandOtaService.this.J = Constants.STR_EMPTY;
                    _3GenEBandOtaService.this.o = 255;
                    _3GenEBandOtaService.this.Q0(Config.Y_DENSITY);
                    return;
                }
                return;
            }
            switch (i) {
                case Config.Y_DENSITY /* 257 */:
                    _3GenEBandOtaService.this.o = 16;
                    _3GenEBandOtaService.this.O0("获取协议版本号...", true, true, true, 0);
                    _3GenEBandOtaService.this.T0(jm3.p(), false);
                    break;
                case 258:
                    _3GenEBandOtaService.this.o = 32;
                    _3GenEBandOtaService.this.O0("获取BuckSize、packetMaxLen...", true, true, true, 0);
                    _3GenEBandOtaService.this.T0(jm3.k(), false);
                    break;
                case 259:
                    _3GenEBandOtaService.this.o = 48;
                    _3GenEBandOtaService.this.O0("获取设备工作模式...", true, true, true, 0);
                    _3GenEBandOtaService.this.T0(jm3.r(), false);
                    break;
                default:
                    switch (i) {
                        case 262:
                            _3GenEBandOtaService.this.o = 96;
                            _3GenEBandOtaService.this.O0("开始升级请求...", true, true, true, 0);
                            _3GenEBandOtaService.this.F = (String) message.obj;
                            _3GenEBandOtaService _3genebandotaservice = _3GenEBandOtaService.this;
                            _3genebandotaservice.T0(jm3.o(_3genebandotaservice.F), false);
                            break;
                        case 263:
                            if ((_3GenEBandOtaService.this.t + 1) % ((_3GenEBandOtaService.this.r / (_3GenEBandOtaService.this.s - 5)) + (_3GenEBandOtaService.this.r % (_3GenEBandOtaService.this.s + (-5)) > 0 ? 1 : 0)) == 0 || _3GenEBandOtaService.this.t + 1 == _3GenEBandOtaService.this.n.size()) {
                                _3GenEBandOtaService.this.o = 128;
                                _3GenEBandOtaService.this.T0(jm3.m(_3GenEBandOtaService.this.t, (String) _3GenEBandOtaService.this.n.get(Integer.valueOf(_3GenEBandOtaService.this.t))), false);
                            } else {
                                _3GenEBandOtaService.this.o = 112;
                                _3GenEBandOtaService.this.T0(jm3.a(_3GenEBandOtaService.this.t, (String) _3GenEBandOtaService.this.n.get(Integer.valueOf(_3GenEBandOtaService.this.t))), true);
                            }
                            break;
                        case 264:
                            _3GenEBandOtaService.this.o = Opcodes.D2F;
                            _3GenEBandOtaService.this.O0("结束升级请求...", true, true, true, 0);
                            _3GenEBandOtaService _3genebandotaservice2 = _3GenEBandOtaService.this;
                            _3genebandotaservice2.G = _3genebandotaservice2.F;
                            _3GenEBandOtaService _3genebandotaservice3 = _3GenEBandOtaService.this;
                            _3genebandotaservice3.g = _3genebandotaservice3.M0(_3genebandotaservice3.G);
                            if (_3GenEBandOtaService.this.g != null) {
                                String strJ = l63.j(_3GenEBandOtaService.this.g.b(), 4);
                                String strJ2 = l63.j(_3GenEBandOtaService.this.g.a(), 4);
                                _3GenEBandOtaService _3genebandotaservice4 = _3GenEBandOtaService.this;
                                _3genebandotaservice4.T0(jm3.n(_3genebandotaservice4.G, strJ, strJ2), false);
                            } else {
                                _3GenEBandOtaService.this.U0("升级异常--END 本地固件 checkSum获取失败");
                            }
                            break;
                        case 265:
                            _3GenEBandOtaService.this.Q0(259);
                            break;
                        case 266:
                            _3GenEBandOtaService.Z(_3GenEBandOtaService.this);
                            int size = (_3GenEBandOtaService.this.t * 100) / _3GenEBandOtaService.this.n.size();
                            if (_3GenEBandOtaService.this.f != null) {
                                _3GenEBandOtaService.this.f.b(size);
                            }
                            _3GenEBandOtaService.this.Q0(263);
                            break;
                        case 267:
                            if (!TextUtils.equals(_3GenEBandOtaService.this.y, "00")) {
                                _3GenEBandOtaService.this.o = 64;
                                _3GenEBandOtaService.this.O0("设备切换到Normal模式...", true, true, false, 0);
                                _3GenEBandOtaService.this.z = "00";
                                _3GenEBandOtaService _3genebandotaservice5 = _3GenEBandOtaService.this;
                                _3genebandotaservice5.T0(jm3.q(_3genebandotaservice5.z), false);
                            } else if (!_3GenEBandOtaService.this.P) {
                                _3GenEBandOtaService.this.u = 0;
                                _3GenEBandOtaService _3genebandotaservice6 = _3GenEBandOtaService.this;
                                _3genebandotaservice6.h = _3genebandotaservice6.H0(_3genebandotaservice6.u);
                                if (_3GenEBandOtaService.this.h != null) {
                                    _3GenEBandOtaService.this.O0("本地固件OTA checkSum = " + _3GenEBandOtaService.this.h.toString(), true, true, false, 0);
                                    String strJ3 = l63.j(_3GenEBandOtaService.this.h.d() - 1, 4);
                                    String strJ4 = l63.j(_3GenEBandOtaService.this.h.b(), 4);
                                    String strJ5 = l63.j(_3GenEBandOtaService.this.h.a(), 4);
                                    _3GenEBandOtaService.this.o = 80;
                                    _3GenEBandOtaService.this.O0("获取设备中OTA部分的checkSum...", true, true, false, 0);
                                    _3GenEBandOtaService.this.T0(jm3.l(strJ3, strJ4, strJ5), false);
                                } else {
                                    _3GenEBandOtaService.this.U0("OTA升级异常--本地固件OTA checkSum获取失败");
                                }
                            } else if (!_3GenEBandOtaService.this.Q) {
                                _3GenEBandOtaService.this.Q0(268);
                            } else {
                                _3GenEBandOtaService.this.b1(true, "升级成功！");
                            }
                            break;
                        case 268:
                            if (!TextUtils.equals(_3GenEBandOtaService.this.y, "01")) {
                                _3GenEBandOtaService.this.o = 64;
                                _3GenEBandOtaService.this.O0("设备切换到OTA模式...", true, true, false, 0);
                                _3GenEBandOtaService.this.W = 0;
                                _3GenEBandOtaService.this.z = "01";
                                _3GenEBandOtaService _3genebandotaservice7 = _3GenEBandOtaService.this;
                                _3genebandotaservice7.T0(jm3.q(_3genebandotaservice7.z), false);
                            } else if (!_3GenEBandOtaService.this.Q) {
                                _3GenEBandOtaService.this.Q0(272);
                            } else if (!_3GenEBandOtaService.this.P) {
                                _3GenEBandOtaService.this.Q0(267);
                            } else {
                                _3GenEBandOtaService.this.b1(true, "升级成功！");
                            }
                            break;
                        case 269:
                            _3GenEBandOtaService.this.O0("OTA固件升级...", true, true, true, 0);
                            _3GenEBandOtaService _3genebandotaservice8 = _3GenEBandOtaService.this;
                            _3genebandotaservice8.n = yqy.yichip.yc_lib_ota_3_gen.wristband_1121E.a.j(_3genebandotaservice8.v, _3GenEBandOtaService.this.h.d(), _3GenEBandOtaService.this.h.c(), _3GenEBandOtaService.this.r, _3GenEBandOtaService.this.s);
                            if (_3GenEBandOtaService.this.n == null || _3GenEBandOtaService.this.n.size() == 0) {
                                _3GenEBandOtaService.this.U0("OTA固件升级异常 -- 获取OTA部分数据为空");
                            } else {
                                _3GenEBandOtaService.this.R0(262, "01");
                            }
                            break;
                        default:
                            switch (i) {
                                case 271:
                                    _3GenEBandOtaService.this.O0("Normal固件升级...", true, true, true, 0);
                                    _3GenEBandOtaService _3genebandotaservice9 = _3GenEBandOtaService.this;
                                    _3genebandotaservice9.i = _3genebandotaservice9.H0(1);
                                    _3GenEBandOtaService _3genebandotaservice10 = _3GenEBandOtaService.this;
                                    _3genebandotaservice10.n = yqy.yichip.yc_lib_ota_3_gen.wristband_1121E.a.j(_3genebandotaservice10.v, _3GenEBandOtaService.this.i.d(), _3GenEBandOtaService.this.i.c(), _3GenEBandOtaService.this.r, _3GenEBandOtaService.this.s);
                                    if (_3GenEBandOtaService.this.n == null || _3GenEBandOtaService.this.n.size() == 0) {
                                        _3GenEBandOtaService.this.U0("Normal固件升级异常 -- 获取Normal部分数据为空");
                                    } else {
                                        _3GenEBandOtaService.this.R0(262, "00");
                                    }
                                    break;
                                case 272:
                                    if (_3GenEBandOtaService.this.R && _3GenEBandOtaService.this.S && _3GenEBandOtaService.this.T) {
                                        _3GenEBandOtaService.this.Q0(271);
                                    } else if (!_3GenEBandOtaService.this.R) {
                                        _3GenEBandOtaService.this.K0(2);
                                    } else if (!_3GenEBandOtaService.this.T) {
                                        _3GenEBandOtaService.this.K0(4);
                                    } else {
                                        _3GenEBandOtaService.this.K0(3);
                                    }
                                    break;
                                case 273:
                                    _3GenEBandOtaService.this.O0("Beep升级...", true, true, true, 0);
                                    _3GenEBandOtaService _3genebandotaservice11 = _3GenEBandOtaService.this;
                                    _3genebandotaservice11.n = yqy.yichip.yc_lib_ota_3_gen.wristband_1121E.a.j(_3genebandotaservice11.v, _3GenEBandOtaService.this.j.d(), _3GenEBandOtaService.this.j.c(), _3GenEBandOtaService.this.r, _3GenEBandOtaService.this.s);
                                    if (_3GenEBandOtaService.this.n == null || _3GenEBandOtaService.this.n.size() == 0) {
                                        _3GenEBandOtaService.this.U0("Beep升级异常 -- 获取Beep部分数据为空");
                                    } else {
                                        _3GenEBandOtaService.this.R0(262, "02");
                                    }
                                    break;
                                case 274:
                                    _3GenEBandOtaService.this.O0("UI Icon升级...", true, true, true, 0);
                                    _3GenEBandOtaService _3genebandotaservice12 = _3GenEBandOtaService.this;
                                    _3genebandotaservice12.n = yqy.yichip.yc_lib_ota_3_gen.wristband_1121E.a.j(_3genebandotaservice12.v, _3GenEBandOtaService.this.k.d(), _3GenEBandOtaService.this.k.c(), _3GenEBandOtaService.this.r, _3GenEBandOtaService.this.s);
                                    if (_3GenEBandOtaService.this.n == null || _3GenEBandOtaService.this.n.size() == 0) {
                                        _3GenEBandOtaService.this.U0("UI Icon升级异常 -- 获取UI Icon部分数据为空");
                                    } else {
                                        _3GenEBandOtaService.this.R0(262, "03");
                                    }
                                    break;
                                case 275:
                                    _3GenEBandOtaService.this.O0("Font升级...", true, true, true, 0);
                                    _3GenEBandOtaService _3genebandotaservice13 = _3GenEBandOtaService.this;
                                    _3genebandotaservice13.n = yqy.yichip.yc_lib_ota_3_gen.wristband_1121E.a.j(_3genebandotaservice13.v, _3GenEBandOtaService.this.l.d(), _3GenEBandOtaService.this.l.c(), _3GenEBandOtaService.this.r, _3GenEBandOtaService.this.s);
                                    if (_3GenEBandOtaService.this.n == null || _3GenEBandOtaService.this.n.size() == 0) {
                                        _3GenEBandOtaService.this.U0("Font升级异常 -- 获取Font部分数据为空");
                                    } else {
                                        _3GenEBandOtaService.this.R0(262, "04");
                                    }
                                    break;
                                default:
                                    switch (i) {
                                        case 513:
                                            tf2 tf2Var = (tf2) message.obj;
                                            if (!tf2Var.i()) {
                                                _3GenEBandOtaService.this.U0("获取协议版本号失败：" + tf2Var.u());
                                            } else {
                                                _3GenEBandOtaService.this.x = tf2Var.d();
                                                _3GenEBandOtaService.this.O0("协议版本号 protocolVerCode = " + _3GenEBandOtaService.this.x, true, true, false, 1);
                                                _3GenEBandOtaService.this.Q0(258);
                                            }
                                            break;
                                        case 514:
                                            tf2 tf2Var2 = (tf2) message.obj;
                                            if (!tf2Var2.i()) {
                                                _3GenEBandOtaService.this.U0("获取buckSize、packetMaxLen失败: " + tf2Var2.r());
                                            } else {
                                                _3GenEBandOtaService.this.r = tf2Var2.a();
                                                _3GenEBandOtaService.this.s = tf2Var2.c();
                                                _3GenEBandOtaService.this.O0("buckSize = " + _3GenEBandOtaService.this.r + ",packetMaxLen = " + _3GenEBandOtaService.this.s, true, true, false, 1);
                                                if (_3GenEBandOtaService.this.s <= 20) {
                                                    _3GenEBandOtaService.this.Q0(265);
                                                } else {
                                                    _3GenEBandOtaService.this.O0("申请MTU = packetMaxLen...", true, true, true, 0);
                                                    _3GenEBandOtaService _3genebandotaservice14 = _3GenEBandOtaService.this;
                                                    _3genebandotaservice14.X0(_3genebandotaservice14.s);
                                                }
                                            }
                                            break;
                                        case 515:
                                            tf2 tf2Var3 = (tf2) message.obj;
                                            if (!tf2Var3.i()) {
                                                _3GenEBandOtaService.this.U0("获取设备工作模式失败；" + tf2Var3.x());
                                            } else {
                                                _3GenEBandOtaService.this.y = tf2Var3.h();
                                                _3GenEBandOtaService.this.O0("设备工作模式 = " + _3GenEBandOtaService.this.y, true, true, false, 1);
                                                _3GenEBandOtaService.this.O0("检测升级...", true, true, false, 0);
                                                if (TextUtils.equals(_3GenEBandOtaService.this.y, "00")) {
                                                    _3GenEBandOtaService.this.Q0(267);
                                                } else if (TextUtils.equals(_3GenEBandOtaService.this.y, "01")) {
                                                    _3GenEBandOtaService.this.P = true;
                                                    _3GenEBandOtaService.this.Q0(268);
                                                }
                                            }
                                            break;
                                        case 516:
                                            tf2 tf2Var4 = (tf2) message.obj;
                                            if (!tf2Var4.i()) {
                                                _3GenEBandOtaService.this.U0("命令设备切换工作模式失败；" + tf2Var4.w());
                                            } else if (TextUtils.equals(_3GenEBandOtaService.this.z, "01") || TextUtils.equals(_3GenEBandOtaService.this.z, "00")) {
                                                _3GenEBandOtaService.this.O0("设备切换工作模式成功", true, true, true, 1);
                                                _3GenEBandOtaService.this.Q0(Config.Y_DENSITY);
                                            }
                                            break;
                                        case 517:
                                            tf2 tf2Var5 = (tf2) message.obj;
                                            if (!tf2Var5.i()) {
                                                _3GenEBandOtaService.this.U0("获取设备中OTA部分checkSum失败:" + tf2Var5.s());
                                            } else {
                                                long jB = tf2Var5.b();
                                                _3GenEBandOtaService.this.O0("flashCheckSumOTAInfo.getCheckSum() = " + _3GenEBandOtaService.this.h.a() + ", rcvCheckSumOTA = " + jB, true, true, false, 0);
                                                if (jB != _3GenEBandOtaService.this.h.a()) {
                                                    _3GenEBandOtaService.this.Q0(269);
                                                } else {
                                                    _3GenEBandOtaService.this.P = true;
                                                    _3GenEBandOtaService.this.Q0(268);
                                                }
                                            }
                                            break;
                                        default:
                                            switch (i) {
                                                case 519:
                                                    tf2 tf2Var6 = (tf2) message.obj;
                                                    if (!tf2Var6.i()) {
                                                        _3GenEBandOtaService.this.U0("升级开始请求失败：" + tf2Var6.v());
                                                    } else if (!TextUtils.equals(tf2Var6.e(), _3GenEBandOtaService.this.F)) {
                                                        _3GenEBandOtaService.this.U0("升级开始请求失败：" + tf2Var6.v());
                                                    } else {
                                                        Log.d("_3GenEBandOtaService", "perBuckPacketNum = " + ((_3GenEBandOtaService.this.r / _3GenEBandOtaService.this.s) + (_3GenEBandOtaService.this.r % _3GenEBandOtaService.this.s <= 0 ? 0 : 1)) + ",dataMap.size() = " + _3GenEBandOtaService.this.n.size());
                                                        _3GenEBandOtaService.this.O0("开始发送升级数据...", true, true, true, 0);
                                                        _3GenEBandOtaService.this.H = d33.c();
                                                        _3GenEBandOtaService.this.t = 0;
                                                        _3GenEBandOtaService.this.Q0(263);
                                                    }
                                                    break;
                                                case 520:
                                                    tf2 tf2Var7 = (tf2) message.obj;
                                                    if (!tf2Var7.i()) {
                                                        _3GenEBandOtaService.this.U0("发送升级数据REQ 失败：" + tf2Var7.toString());
                                                    } else {
                                                        _3GenEBandOtaService.Z(_3GenEBandOtaService.this);
                                                        int size2 = (_3GenEBandOtaService.this.t * 100) / _3GenEBandOtaService.this.n.size();
                                                        if (_3GenEBandOtaService.this.f != null) {
                                                            _3GenEBandOtaService.this.f.b(size2);
                                                        }
                                                        if (_3GenEBandOtaService.this.t < _3GenEBandOtaService.this.n.size()) {
                                                            _3GenEBandOtaService.this.Q0(263);
                                                        } else {
                                                            _3GenEBandOtaService.this.I = d33.c();
                                                            _3GenEBandOtaService.this.O0("DATA数据发送完毕：curPacketId = " + _3GenEBandOtaService.this.t + ",DATA包数：sendDataMap.size() = " + _3GenEBandOtaService.this.n.size(), true, true, true, 1);
                                                            _3GenEBandOtaService.this.Q0(264);
                                                        }
                                                    }
                                                    break;
                                                case 521:
                                                    tf2 tf2Var8 = (tf2) message.obj;
                                                    String strD = d33.d(_3GenEBandOtaService.this.H, _3GenEBandOtaService.this.I);
                                                    if (!tf2Var8.i() || !TextUtils.equals(_3GenEBandOtaService.this.G, tf2Var8.e()) || _3GenEBandOtaService.this.g.b() != tf2Var8.g() || _3GenEBandOtaService.this.g.a() != tf2Var8.f()) {
                                                        _3GenEBandOtaService.this.O0("升级结束请求 失败：" + tf2Var8.t(), true, true, false, 2);
                                                        if (TextUtils.equals(_3GenEBandOtaService.this.G, "00")) {
                                                            _3GenEBandOtaService.this.Q = false;
                                                            _3GenEBandOtaService.this.O0("Normal固件升级失败！", true, true, true, 2);
                                                        } else if (TextUtils.equals(_3GenEBandOtaService.this.G, "01")) {
                                                            _3GenEBandOtaService.this.P = false;
                                                            _3GenEBandOtaService.this.O0("OTA固件升级失败！", true, true, true, 2);
                                                        } else if (TextUtils.equals(_3GenEBandOtaService.this.G, "02")) {
                                                            _3GenEBandOtaService.this.R = false;
                                                            _3GenEBandOtaService.this.O0("Beep升级失败！", true, true, true, 2);
                                                        } else if (TextUtils.equals(_3GenEBandOtaService.this.G, "03")) {
                                                            _3GenEBandOtaService.this.S = false;
                                                            _3GenEBandOtaService.this.O0("UI Icon升级失败！", true, true, true, 2);
                                                        } else if (TextUtils.equals(_3GenEBandOtaService.this.G, "04")) {
                                                            _3GenEBandOtaService.this.T = false;
                                                            _3GenEBandOtaService.this.O0("Font升级失败！", true, true, true, 2);
                                                        }
                                                        _3GenEBandOtaService.this.b1(false, "升级失败！");
                                                    } else if (TextUtils.equals(_3GenEBandOtaService.this.G, "01")) {
                                                        _3GenEBandOtaService.this.P = true;
                                                        _3GenEBandOtaService.this.O0("OTA固件升级完成" + strD + ",升级成功", true, true, true, 1);
                                                        if (!_3GenEBandOtaService.this.Q) {
                                                            _3GenEBandOtaService.this.O0("OTA固件升级完成" + strD, true, true, true, 1);
                                                            _3GenEBandOtaService.this.Q0(Config.Y_DENSITY);
                                                        } else {
                                                            _3GenEBandOtaService.this.b1(true, "升级成功！");
                                                        }
                                                    } else if (TextUtils.equals(_3GenEBandOtaService.this.G, "00")) {
                                                        _3GenEBandOtaService.this.Q = true;
                                                        _3GenEBandOtaService.this.O0("Normal固件升级完成" + strD + ",升级成功", true, true, true, 1);
                                                        if (!_3GenEBandOtaService.this.P) {
                                                            _3GenEBandOtaService.this.O0("Normal固件升级完成" + strD, true, true, true, 1);
                                                        } else {
                                                            _3GenEBandOtaService.this.b1(true, "升级成功！");
                                                        }
                                                    } else if (TextUtils.equals(_3GenEBandOtaService.this.G, "02")) {
                                                        _3GenEBandOtaService.this.R = true;
                                                        _3GenEBandOtaService.this.O0("Beep 升级完成" + strD + ",升级成功", true, true, true, 1);
                                                        _3GenEBandOtaService.this.Q0(272);
                                                    } else if (TextUtils.equals(_3GenEBandOtaService.this.G, "03")) {
                                                        _3GenEBandOtaService.this.S = true;
                                                        _3GenEBandOtaService.this.O0("UI Icon 升级完成" + strD + ",升级成功", true, true, true, 1);
                                                        _3GenEBandOtaService.this.Q0(272);
                                                    } else if (TextUtils.equals(_3GenEBandOtaService.this.G, "04")) {
                                                        _3GenEBandOtaService.this.T = true;
                                                        _3GenEBandOtaService.this.O0("Font 升级完成" + strD + ",升级成功", true, true, true, 1);
                                                        _3GenEBandOtaService.this.Q0(272);
                                                    }
                                                    break;
                                                case 522:
                                                    tf2 tf2Var9 = (tf2) message.obj;
                                                    if (!tf2Var9.i()) {
                                                        _3GenEBandOtaService.this.U0("获取设备中Beep部分checkSum失败:" + tf2Var9.s());
                                                    } else {
                                                        long jB2 = tf2Var9.b();
                                                        _3GenEBandOtaService.this.O0("flashCheckSumBeepInfo.getCheckSum() = " + _3GenEBandOtaService.this.j.a() + ", rcvCheckSumBeep = " + jB2, true, true, false, 0);
                                                        if (jB2 != _3GenEBandOtaService.this.j.a()) {
                                                            _3GenEBandOtaService.this.Q0(273);
                                                        } else {
                                                            _3GenEBandOtaService.this.R = true;
                                                            _3GenEBandOtaService.this.Q0(272);
                                                        }
                                                    }
                                                    break;
                                                case 523:
                                                    tf2 tf2Var10 = (tf2) message.obj;
                                                    if (!tf2Var10.i()) {
                                                        _3GenEBandOtaService.this.U0("获取设备中UI Icon部分checkSum失败:" + tf2Var10.s());
                                                    } else {
                                                        long jB3 = tf2Var10.b();
                                                        _3GenEBandOtaService.this.O0("flashCheckSumUIIconInfo.getCheckSum() = " + _3GenEBandOtaService.this.k.a() + ", rcvCheckSumUIIcon = " + jB3, true, true, false, 0);
                                                        if (jB3 != _3GenEBandOtaService.this.k.a()) {
                                                            _3GenEBandOtaService.this.Q0(274);
                                                        } else {
                                                            _3GenEBandOtaService.this.S = true;
                                                            _3GenEBandOtaService.this.Q0(272);
                                                        }
                                                    }
                                                    break;
                                                case 524:
                                                    tf2 tf2Var11 = (tf2) message.obj;
                                                    if (!tf2Var11.i()) {
                                                        _3GenEBandOtaService.this.U0("获取设备中Font部分checkSum失败:" + tf2Var11.s());
                                                    } else {
                                                        long jB4 = tf2Var11.b();
                                                        _3GenEBandOtaService.this.O0("flashCheckSumFontInfo.getCheckSum() = " + _3GenEBandOtaService.this.l.a() + ", rcvCheckSumFont = " + jB4, true, true, false, 0);
                                                        if (jB4 != _3GenEBandOtaService.this.l.a()) {
                                                            _3GenEBandOtaService.this.Q0(275);
                                                        } else {
                                                            _3GenEBandOtaService.this.T = true;
                                                            _3GenEBandOtaService.this.Q0(272);
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
                    break;
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (_3GenEBandOtaService.this.o != 128) {
                if (_3GenEBandOtaService.this.o != 16) {
                    _3GenEBandOtaService.this.U0("数据通讯异常-等待回复超时!");
                    return;
                } else if (_3GenEBandOtaService.this.W < 2) {
                    _3GenEBandOtaService.this.U0("数据通讯异常-等待回复超时!");
                    return;
                } else {
                    _3GenEBandOtaService.this.O0("设备'切换到OTA模式'存在问题，导致'获取协议版本号'回复超时，现重新发起'获取协议版本号...'", true, true, false, 2);
                    _3GenEBandOtaService.this.Q0(Config.Y_DENSITY);
                    return;
                }
            }
            byte[] bArrM = jm3.m(_3GenEBandOtaService.this.t, (String) _3GenEBandOtaService.this.n.get(Integer.valueOf(_3GenEBandOtaService.this.t)));
            _3GenEBandOtaService.this.O0("数据确认包回馈超时，重新发送curPacketId = " + _3GenEBandOtaService.this.t + "数据包，长度 = " + bArrM.length, true, true, true, 2);
            _3GenEBandOtaService.this.T0(bArrM, true);
        }
    }

    class c implements Runnable {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            _3GenEBandOtaService.this.d.c(this.a);
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
            Log.d("_3GenEBandOtaService", "扫描结束");
            if (_3GenEBandOtaService.this.f != null) {
                _3GenEBandOtaService.this.f.c();
            } else {
                Log.e("_3GenEBandOtaService", "a3GenOtaServiceActivityListener == null");
            }
        }

        @Override // defpackage.gw1
        public void c(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (_3GenEBandOtaService.this.f != null) {
                _3GenEBandOtaService.this.f.e(bluetoothDevice, i, bArr);
            } else {
                Log.e("_3GenEBandOtaService", "a2GenOtaServiceActivityListener == null");
            }
        }

        @Override // defpackage.gw1
        public void d() {
            Log.e("_3GenEBandOtaService", "扫描超时");
            _3GenEBandOtaService.this.Z0();
            if (_3GenEBandOtaService.this.f != null) {
                _3GenEBandOtaService.this.f.a();
            } else {
                Log.e("_3GenEBandOtaService", "a3GenOtaServiceActivityListener == null");
            }
        }
    }

    class e implements wu1 {
        e() {
        }

        @Override // defpackage.wu1
        public void a(String str) {
            _3GenEBandOtaService.this.U0(str);
        }

        @Override // defpackage.wu1
        public void b(String str, int i) {
            if (!_3GenEBandOtaService.this.M) {
                _3GenEBandOtaService.this.O0("应用未主动申请新MTU，设备主动返回！MTU = " + i, true, true, true, 2);
                return;
            }
            _3GenEBandOtaService.this.M = false;
            if (i < _3GenEBandOtaService.this.s) {
                _3GenEBandOtaService.this.U0("申请的MTU溢出，最大值 = " + i);
                return;
            }
            _3GenEBandOtaService.this.O0("申请成功，新的MTU = " + i, true, true, true, 1);
            _3GenEBandOtaService.this.Q0(265);
        }

        @Override // defpackage.wu1
        public void c() {
            _3GenEBandOtaService.this.K = true;
            _3GenEBandOtaService.this.O0("连接成功", true, true, true, 1);
            _3GenEBandOtaService.this.S0(0, 3000L);
        }

        @Override // defpackage.wu1
        public void d(byte[] bArr) {
            if (_3GenEBandOtaService.this.N) {
                String strB = l63.b(bArr);
                _3GenEBandOtaService.this.O0("发送数据回调成功，长度" + bArr.length + "-->" + strB, true, true, false, 1);
                _3GenEBandOtaService.this.Q0(266);
            }
        }

        @Override // defpackage.wu1
        public void e(BluetoothGatt bluetoothGatt) {
        }

        @Override // defpackage.wu1
        public void f(String str, int i) {
            if (i != 133) {
                _3GenEBandOtaService.this.K = false;
                _3GenEBandOtaService.this.U0(str + "!-- status = " + i);
                return;
            }
            if (_3GenEBandOtaService.this.p >= 3) {
                _3GenEBandOtaService.this.K = false;
                _3GenEBandOtaService.this.U0("连接失败133异常-3次！");
                return;
            }
            _3GenEBandOtaService.n0(_3GenEBandOtaService.this);
            _3GenEBandOtaService.this.O0("连接失败133异常！第" + _3GenEBandOtaService.this.p + "次重连...", true, true, false, 2);
            _3GenEBandOtaService _3genebandotaservice = _3GenEBandOtaService.this;
            _3genebandotaservice.I0(_3genebandotaservice.f455q, _3GenEBandOtaService.this.e);
        }

        @Override // defpackage.wu1
        public void g(byte[] bArr, String str) {
            if (!_3GenEBandOtaService.this.N) {
                _3GenEBandOtaService.this.X.removeCallbacks(_3GenEBandOtaService.this.Y);
                _3GenEBandOtaService.this.U0("数据通讯异常-发送数据回调失败！数据：" + l63.b(bArr));
                return;
            }
            _3GenEBandOtaService.this.O0("发送数据回调失败，长度" + bArr.length + "-->" + l63.b(bArr), true, true, true, 2);
        }

        @Override // defpackage.wu1
        public void h(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            byte b = 6;
            String lowerCase = l63.b(bArr).toLowerCase();
            if (bArr.length < 3) {
            }
            _3GenEBandOtaService.this.O0("接收数据成功，长度" + bArr.length + "-->" + lowerCase, true, true, false, 1);
            if (TextUtils.equals(lowerCase.toLowerCase(), "ab0013")) {
                _3GenEBandOtaService.this.W++;
            }
            String strSubstring = lowerCase.substring(0, 2);
            String strSubstring2 = lowerCase.substring(4, 6);
            Log.w("_3GenEBandOtaService", "otaEvt = " + strSubstring);
            if (_3GenEBandOtaService.this.O && TextUtils.equals(strSubstring, "ab")) {
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
                        if (_3GenEBandOtaService.this.o != 16) {
                            _3GenEBandOtaService.this.O0("非当前请求指令的回复evt，继续等待回复...", true, true, false, 2);
                        } else {
                            _3GenEBandOtaService.this.o = 17;
                            _3GenEBandOtaService.this.X.removeCallbacks(_3GenEBandOtaService.this.Y);
                            tf2 tf2VarH = jm3.h(bArr);
                            if (tf2VarH == null) {
                                _3GenEBandOtaService.this.U0("获取协议版本号失败");
                            } else {
                                _3GenEBandOtaService.this.R0(513, tf2VarH);
                            }
                        }
                        break;
                    case 1:
                        if (_3GenEBandOtaService.this.o != 32) {
                            _3GenEBandOtaService.this.O0("非当前请求指令的回复evt，继续等待回复...", true, true, false, 2);
                        } else {
                            _3GenEBandOtaService.this.o = 33;
                            _3GenEBandOtaService.this.X.removeCallbacks(_3GenEBandOtaService.this.Y);
                            tf2 tf2VarC = jm3.c(bArr);
                            if (tf2VarC == null) {
                                _3GenEBandOtaService.this.U0("获取BuckSize、packetMaxLen失败");
                            } else {
                                _3GenEBandOtaService.this.R0(514, tf2VarC);
                            }
                        }
                        break;
                    case 2:
                        if (_3GenEBandOtaService.this.o != 48) {
                            _3GenEBandOtaService.this.O0("非当前请求指令的回复evt，继续等待回复...", true, true, false, 2);
                        } else {
                            _3GenEBandOtaService.this.o = 49;
                            _3GenEBandOtaService.this.X.removeCallbacks(_3GenEBandOtaService.this.Y);
                            tf2 tf2VarJ = jm3.j(bArr);
                            if (tf2VarJ == null) {
                                _3GenEBandOtaService.this.U0("获取设备工作模式失败");
                            } else {
                                _3GenEBandOtaService.this.R0(515, tf2VarJ);
                            }
                        }
                        break;
                    case 3:
                        if (_3GenEBandOtaService.this.o != 64) {
                            _3GenEBandOtaService.this.O0("非当前请求指令的回复evt，继续等待回复...", true, true, false, 2);
                        } else {
                            _3GenEBandOtaService.this.o = 65;
                            _3GenEBandOtaService.this.X.removeCallbacks(_3GenEBandOtaService.this.Y);
                            tf2 tf2VarI = jm3.i(bArr);
                            if (tf2VarI == null) {
                                _3GenEBandOtaService.this.U0("切换设备工作模式失败");
                            } else {
                                _3GenEBandOtaService.this.R0(516, tf2VarI);
                            }
                        }
                        break;
                    case 4:
                        if (_3GenEBandOtaService.this.o != 80) {
                            _3GenEBandOtaService.this.O0("非当前请求指令的回复evt，继续等待回复...", true, true, false, 2);
                        } else {
                            _3GenEBandOtaService.this.o = 81;
                            _3GenEBandOtaService.this.X.removeCallbacks(_3GenEBandOtaService.this.Y);
                            tf2 tf2VarD = jm3.d(bArr);
                            if (tf2VarD == null) {
                                _3GenEBandOtaService.this.U0("获取设备的checkSum失败");
                            } else if (_3GenEBandOtaService.this.u == 0) {
                                _3GenEBandOtaService.this.R0(517, tf2VarD);
                            } else if (_3GenEBandOtaService.this.u == 2) {
                                _3GenEBandOtaService.this.R0(522, tf2VarD);
                            } else if (_3GenEBandOtaService.this.u == 3) {
                                _3GenEBandOtaService.this.R0(523, tf2VarD);
                            } else if (_3GenEBandOtaService.this.u == 4) {
                                _3GenEBandOtaService.this.R0(524, tf2VarD);
                            }
                        }
                        break;
                    case 5:
                        if (_3GenEBandOtaService.this.o != 96) {
                            _3GenEBandOtaService.this.O0("非当前请求指令的回复evt，继续等待回复...", true, true, false, 2);
                        } else {
                            _3GenEBandOtaService.this.o = 97;
                            _3GenEBandOtaService.this.X.removeCallbacks(_3GenEBandOtaService.this.Y);
                            tf2 tf2VarG = jm3.g(bArr);
                            if (tf2VarG == null) {
                                _3GenEBandOtaService.this.U0("开始升级请求失败");
                            } else {
                                _3GenEBandOtaService.this.R0(519, tf2VarG);
                            }
                        }
                        break;
                    case 6:
                        if (_3GenEBandOtaService.this.o != 128) {
                            _3GenEBandOtaService.this.O0("非当前请求指令的回复evt，继续等待回复...", true, true, false, 2);
                        } else {
                            _3GenEBandOtaService.this.o = Opcodes.LOR;
                            _3GenEBandOtaService.this.X.removeCallbacks(_3GenEBandOtaService.this.Y);
                            tf2 tf2VarE = jm3.e(bArr);
                            if (tf2VarE == null) {
                                _3GenEBandOtaService.this.U0("升级数据确认失败");
                            } else {
                                _3GenEBandOtaService.this.R0(520, tf2VarE);
                            }
                        }
                        break;
                    case 7:
                        if (_3GenEBandOtaService.this.o != 144) {
                            _3GenEBandOtaService.this.O0("非当前请求指令的回复evt，继续等待回复...", true, true, false, 2);
                        } else {
                            _3GenEBandOtaService.this.o = Opcodes.I2B;
                            _3GenEBandOtaService.this.X.removeCallbacks(_3GenEBandOtaService.this.Y);
                            tf2 tf2VarF = jm3.f(bArr);
                            if (tf2VarF == null) {
                                _3GenEBandOtaService.this.U0("结束升级请求失败");
                            } else {
                                _3GenEBandOtaService.this.R0(521, tf2VarF);
                            }
                        }
                        break;
                    default:
                        _3GenEBandOtaService.this.U0("数据通讯异常-接收到非协议数据包!");
                        break;
                }
            }
        }

        @Override // defpackage.wu1
        public void i(int i) {
            if (!_3GenEBandOtaService.this.K) {
                _3GenEBandOtaService.this.O0("连接失败!-- status = " + i, true, true, true, 2);
                return;
            }
            _3GenEBandOtaService.this.X.removeCallbacks(_3GenEBandOtaService.this.Y);
            _3GenEBandOtaService.this.K = false;
            _3GenEBandOtaService.this.e = null;
            if (!_3GenEBandOtaService.this.L) {
                _3GenEBandOtaService.this.U0("设备异常断开连接！");
                _3GenEBandOtaService.this.a1();
                return;
            }
            _3GenEBandOtaService.this.L = false;
            if (_3GenEBandOtaService.this.O || !_3GenEBandOtaService.this.U) {
                _3GenEBandOtaService.this.O0("断开连接", true, true, true, 1);
                return;
            }
            _3GenEBandOtaService.this.O0("断开连接", true, true, false, 1);
            _3GenEBandOtaService _3genebandotaservice = _3GenEBandOtaService.this;
            _3genebandotaservice.V0(_3genebandotaservice.V, _3GenEBandOtaService.this.J);
        }
    }

    public class f extends Binder {
        private _3GenEBandOtaService c;

        public f(_3GenEBandOtaService _3genebandotaservice) {
            this.c = _3genebandotaservice;
        }

        public _3GenEBandOtaService a() {
            return this.c;
        }
    }

    public _3GenEBandOtaService() {
        Log.d("_3GenEBandOtaService", "_3GenEBandOtaService()-->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public nm3 H0(int i) {
        if (this.m == null) {
            O0("== 解析固件各部分--开始 ==", true, true, false, 0);
            this.m = new yqy.yichip.yc_lib_ota_3_gen.wristband_1121E.a(this.v, this.x);
            O0("== 解析固件各部分--结束 ==", true, true, false, 0);
            O0(this.m.y() + "\n" + this.m.x() + "\n" + this.m.w() + "\n", true, false, false, 0);
        }
        if (i == 0) {
            return this.m.o();
        }
        if (i == 1) {
            return this.m.m();
        }
        if (i == 2) {
            return this.m.h();
        }
        if (i == 3) {
            return this.m.q();
        }
        if (i == 4) {
            return this.m.k();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(int i, BluetoothDevice bluetoothDevice) {
        if (this.c == null) {
            Log.e("_3GenEBandOtaService", "connectDevice(): btBluetooth == null");
            return;
        }
        if (this.K) {
            Log.e("_3GenEBandOtaService", "connectDevice(): isConnected = true");
            return;
        }
        if (i != 0 && i != 1) {
            O0("connectDevice(): 没有该设备类型！", true, true, true, 2);
            return;
        }
        String[] strArrA = gm3.a(i);
        if (strArrA == null) {
            O0("connectDevice(): uuidArray == null", true, true, true, 2);
        } else {
            this.c.l(strArrA[0], strArrA[1], strArrA[2], bluetoothDevice, 20000L, this.a0);
        }
    }

    private void J0() {
        fe feVar = this.c;
        if (feVar == null) {
            Log.e("_3GenEBandOtaService", "disConnectDevice(): btBluetooth == null");
        } else {
            if (!this.K) {
                Log.e("_3GenEBandOtaService", "disConnectDevice(): isConnected = false");
                return;
            }
            this.L = true;
            feVar.m();
            O0("App主动断开 isAppDisConnect = true", true, true, false, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(int i) {
        String str;
        this.u = i;
        nm3 nm3VarH0 = H0(i);
        if (i == 2) {
            this.j = nm3VarH0;
        } else if (i == 3) {
            this.k = nm3VarH0;
        } else if (i == 4) {
            this.l = nm3VarH0;
        } else {
            nm3VarH0 = null;
        }
        if (i == 2) {
            str = "Beep";
        } else if (i == 3) {
            str = "UI Icon";
        } else {
            str = i == 4 ? "Font" : "未知部分";
        }
        if (nm3VarH0 == null) {
            U0("本地固件" + str + "部分 checkSum获取失败");
            return;
        }
        O0("本地固件" + str + "部分 checkSum = " + nm3VarH0.toString(), true, true, true, 0);
        String strJ = l63.j(nm3VarH0.d() - 1, 4);
        String strJ2 = l63.j(nm3VarH0.b(), 4);
        String strJ3 = l63.j(nm3VarH0.a(), 4);
        this.o = 80;
        O0("获取设备中" + str + "部分的checkSum…", true, true, true, 0);
        T0(jm3.l(strJ, strJ2, strJ3), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public nm3 M0(String str) {
        if (TextUtils.equals(str, "01")) {
            return this.h;
        }
        if (TextUtils.equals(str, "00")) {
            return this.i;
        }
        if (TextUtils.equals(str, "02")) {
            return this.j;
        }
        if (TextUtils.equals(str, "03")) {
            return this.k;
        }
        if (TextUtils.equals(str, "04")) {
            return this.l;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(int i) {
        this.X.sendEmptyMessage(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(int i, Object obj) {
        Message message = new Message();
        message.what = i;
        message.obj = obj;
        this.X.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(int i, long j) {
        this.X.sendEmptyMessageDelayed(i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(byte[] bArr, boolean z) {
        if (!this.K) {
            Log.e("_3GenEBandOtaService", "sendMsg(): isConnected = false");
            return;
        }
        fe feVar = this.c;
        if (feVar == null) {
            Log.e("_3GenEBandOtaService", "sendMsg(): btBluetooth == null");
            return;
        }
        this.N = z;
        boolean zS = feVar.s(bArr);
        String strB = l63.b(bArr);
        if (zS) {
            if (this.N) {
                return;
            }
            this.X.postDelayed(this.Y, ProtocolConstants.CONNECTION_TIMEOUT_MS);
            return;
        }
        O0("发送数据" + zS + ": " + strB, true, true, true, 2);
        U0("数据通讯异常-数据发送操作失败！");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(String str) {
        this.o = 255;
        O0(str, true, true, true, 2);
        rm3 rm3Var = this.f;
        if (rm3Var != null) {
            rm3Var.onError(str);
        }
        J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(boolean z, String str) {
        if (z) {
            O0(str, true, true, true, 1);
            rm3 rm3Var = this.f;
            if (rm3Var != null) {
                rm3Var.onSuccess(str);
                return;
            }
            return;
        }
        O0(str, true, true, true, 2);
        rm3 rm3Var2 = this.f;
        if (rm3Var2 != null) {
            rm3Var2.onError(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(int i) {
        if (!this.K) {
            Log.e("_3GenEBandOtaService", "setMTU(): isConnected = false");
            return;
        }
        if (i > 512) {
            U0("申请MTU失败-申请值溢出！");
            return;
        }
        fe feVar = this.c;
        if (feVar == null) {
            Log.e("_3GenEBandOtaService", "setMTU(): btBluetooth == null");
            return;
        }
        boolean zT = feVar.t(i);
        Log.e("_3GenEBandOtaService", "setMTU(): isSetSuc = " + zT);
        if (zT) {
            this.M = true;
            return;
        }
        O0("申请MTU" + zT + "值: " + i, true, true, true, 2);
        U0("申请MTU失败-申请操作失败！");
    }

    static /* synthetic */ int Z(_3GenEBandOtaService _3genebandotaservice) {
        int i = _3genebandotaservice.t;
        _3genebandotaservice.t = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(boolean z, String str) {
        this.V = z;
        this.J = str;
        this.O = false;
        this.U = true;
        this.o = 255;
        J0();
    }

    static /* synthetic */ int n0(_3GenEBandOtaService _3genebandotaservice) {
        int i = _3genebandotaservice.p;
        _3genebandotaservice.p = i + 1;
        return i;
    }

    public List L0() {
        if (this.c != null) {
            Log.d("_3GenEBandOtaService", "获取已配对的设备列表...");
            return this.c.o();
        }
        Log.e("_3GenEBandOtaService", "getBondedDevices(): btBluetooth == null");
        return null;
    }

    public void N0(boolean z) {
        Log.d("_3GenEBandOtaService", "初始化蓝牙，isBle = " + z);
        fe feVarP = fe.p();
        this.c = feVarP;
        feVarP.q(getApplicationContext(), z);
    }

    public void O0(String str, boolean z, boolean z2, boolean z3, int i) {
        wp wpVar;
        rm3 rm3Var;
        if (z2) {
            if (i == 0) {
                Log.d("_3GenEBandOtaService", str);
            } else if (i == 1) {
                Log.w("_3GenEBandOtaService", str);
            } else if (i == 2) {
                Log.e("_3GenEBandOtaService", str);
            } else {
                Log.d("_3GenEBandOtaService", str);
            }
        }
        if (z3 && (rm3Var = this.f) != null) {
            rm3Var.d(str, i);
        }
        if (z && (wpVar = this.d) != null && wpVar.b()) {
            new Thread(new c(str)).start();
        }
    }

    public void P0() {
        if (this.c == null) {
            Log.e("_3GenEBandOtaService", "scanDevice(): btBluetooth == null");
        } else {
            Log.d("_3GenEBandOtaService", "开始扫描...");
            this.c.n(this.Z, 5000L);
        }
    }

    public void W0(rm3 rm3Var) {
        this.f = rm3Var;
    }

    public void Y0(String str, int i, BluetoothDevice bluetoothDevice) {
        this.v = str;
        this.f455q = i;
        this.e = bluetoothDevice;
        String strB = d33.b();
        this.w = strB;
        this.b.a(strB);
        wp wpVar = new wp();
        this.d = wpVar;
        boolean zA = wpVar.a(dm3.a, this.w, 1);
        this.d.d(zA);
        if (!zA) {
            U0("log缓存文件创建失败！");
            return;
        }
        this.m = null;
        this.p = 0;
        this.L = false;
        this.K = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        O0("connectDevice(): 连接设备：deviceType = " + i + "，" + bluetoothDevice.getName() + "-->" + bluetoothDevice.getAddress(), true, true, true, 0);
        I0(i, this.e);
    }

    public void Z0() {
        if (this.c == null) {
            Log.e("_3GenEBandOtaService", "stopScanDevice(): btBluetooth == null");
        } else {
            Log.d("_3GenEBandOtaService", "停止扫描...");
            this.c.x();
        }
    }

    public void a1() {
        this.O = false;
        this.V = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.o = 255;
        this.X.removeCallbacks(this.Y);
        this.X.removeMessages(Config.Y_DENSITY);
        this.X.removeMessages(258);
        this.X.removeMessages(262);
        this.X.removeMessages(263);
        this.X.removeMessages(264);
        this.X.removeMessages(265);
        this.X.removeMessages(266);
        this.X.removeMessages(267);
        this.X.removeMessages(268);
        this.X.removeMessages(269);
        this.X.removeMessages(272);
        this.X.removeMessages(271);
        this.X.removeMessages(273);
        this.X.removeMessages(274);
        this.X.removeMessages(275);
        this.X.removeMessages(513);
        this.X.removeMessages(514);
        this.X.removeMessages(515);
        this.X.removeMessages(516);
        this.X.removeMessages(517);
        this.X.removeMessages(522);
        this.X.removeMessages(523);
        this.X.removeMessages(524);
        this.X.removeMessages(519);
        this.X.removeMessages(520);
        this.X.removeMessages(521);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            Log.e("_3GenEBandOtaService", "onBind():intent == null");
            return null;
        }
        Log.d("_3GenEBandOtaService", "onBind():return * IBinder");
        return new f(this);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("_3GenEBandOtaService", "onCreate()-->");
        Context applicationContext = getApplicationContext();
        this.a = applicationContext;
        this.b = new fm3(applicationContext);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d("_3GenEBandOtaService", "onDestroy()-->");
        super.onDestroy();
        if (this.K) {
            J0();
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.d("_3GenEBandOtaService", "onUnbind()-->");
        return super.onUnbind(intent);
    }
}
