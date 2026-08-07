package defpackage;

import android.content.Context;
import android.util.Log;
import com.baji.protocol.BajiProtocolManager;
import com.baji.protocol.event.BajiBaseEvent;
import com.baji.protocol.event.DeviceConnectionEvent;
import com.baji.protocol.service.SDKEventListener;
import com.blankj.utilcode.util.GsonUtils;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;
import xfkj.fitpro.api.HttpHelper;
import xfkj.fitpro.bluetooth.ClassicBluetoothBondListener;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.model.DeviceHardInfoModel;
import xfkj.fitpro.service.NotifyService;

/* JADX INFO: loaded from: classes4.dex */
public final class zl {
    private static BajiProtocolManager b;
    private static boolean c;
    private static aa0 e;
    private static String f;
    public static final zl a = new zl();
    private static final ExecutorService d = Executors.newSingleThreadExecutor();

    public static final class a implements tn {
        a() {
        }

        @Override // defpackage.tn
        public void g(BajiBaseEvent bajiBaseEvent) {
            p31.f(bajiBaseEvent, "event");
            EventBus.getDefault().post(bajiBaseEvent);
            Log.d("BluetoothProtocolManager", "sendBroadcast SDK事件: " + GsonUtils.toJson(bajiBaseEvent));
        }
    }

    public static final class b implements SDKEventListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(DeviceHardInfoModel deviceHardInfoModel) {
            try {
                DBHelper.insertDeviceHardInfo(deviceHardInfoModel);
                Log.d("BluetoothProtocolManager", "设备硬件信息已保存到数据库: " + deviceHardInfoModel.getDeviceId());
            } catch (Exception e) {
                Log.e("BluetoothProtocolManager", "保存设备硬件信息到数据库失败: " + e.getMessage());
            }
        }

        @Override // com.baji.protocol.service.SDKEventListener
        public void onSDKEvent(ng ngVar) {
            String str;
            if (ngVar instanceof o10) {
                d20.a = e20.d;
                o10 o10Var = (o10) ngVar;
                Log.d("BluetoothProtocolManager", "设备连接状态: " + o10Var.isConnected());
                zm1.b0(o10Var.getMacAddress());
                zm1.S(ug3.d());
                fn2.e(NotifyService.c());
            } else if (ngVar instanceof DeviceConnectionEvent) {
                d20.a = e20.d;
                DeviceConnectionEvent deviceConnectionEvent = (DeviceConnectionEvent) ngVar;
                Log.d("BluetoothProtocolManager", "设备连接状态: " + deviceConnectionEvent.isConnected());
                zm1.b0(deviceConnectionEvent.getMacAddress());
                zm1.S(ug3.d());
                fn2.e(NotifyService.c());
            } else if (ngVar instanceof wr2) {
                wr2 wr2Var = (wr2) ngVar;
                zm1.d0(wr2Var.a());
                Log.d("BluetoothProtocolManager", "设备版本: " + wr2Var.a());
            } else if (ngVar instanceof y90) {
                String strA = ((y90) ngVar).a();
                if (strA == null || strA.length() == 0) {
                    Log.w("BluetoothProtocolManager", "DeviceFeatureEvent 中的设备名字为空");
                } else {
                    boolean zB = v90.b(strA);
                    zm1.c0(zB);
                    aa0 aa0Var = zl.e;
                    if (aa0Var != null && (str = zl.f) != null) {
                        Log.d("BluetoothProtocolManager", "DeviceFeatureEvent 已处理，现在处理缓存的 DeviceFunctionEvent，MAC: " + str);
                        z90.e(aa0Var, str);
                        zl.e = null;
                        zl.f = null;
                    }
                    if (zB) {
                        Log.i("BluetoothProtocolManager", "识别为新版本电子吧唧设备，设备名字: " + strA + ", 版本号: " + v90.a(strA));
                    } else {
                        Log.i("BluetoothProtocolManager", "识别为老版本电子吧唧设备，设备名字: " + strA);
                    }
                }
            } else if (ngVar instanceof aa0) {
                aa0 aa0Var2 = (aa0) ngVar;
                String macAddress = aa0Var2.getMacAddress();
                if (zm1.J()) {
                    z90.e(aa0Var2, macAddress);
                } else {
                    Log.d("BluetoothProtocolManager", "缓存 DeviceFunctionEvent，等待 DeviceFeatureEvent，MAC: " + macAddress);
                    zl.e = aa0Var2;
                    zl.f = macAddress;
                }
                zi2.k();
                zi2.n(qm2.D((byte) 10));
                zi2.n(qm2.D(AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE));
                zi2.l();
                zl.a.k(aa0Var2);
            } else if (ngVar instanceof w90) {
                String strC = ug3.c();
                w90 w90Var = (w90) ngVar;
                boolean z = w90Var.isValid() && w90Var.c();
                if (strC != null && strC.length() != 0) {
                    cu.f(strC, z);
                }
                Log.d("BluetoothProtocolManager", "设备能力0x1C: valid=" + w90Var.isValid() + ", capVersion=" + w90Var.a() + ", mask0=" + Integer.toHexString(w90Var.b()) + ", previewPauseOnRemoteShutter=" + z);
            } else if (ngVar instanceof ba0) {
                final DeviceHardInfoModel deviceHardInfoModel = new DeviceHardInfoModel();
                ba0 ba0Var = (ba0) ngVar;
                deviceHardInfoModel.setDeviceId(ba0Var.getMacAddress());
                deviceHardInfoModel.setLed(ba0Var.c());
                deviceHardInfoModel.setHeart(ba0Var.b());
                deviceHardInfoModel.setGsensor(ba0Var.a());
                zl.d.execute(new Runnable() { // from class: am
                    @Override // java.lang.Runnable
                    public final void run() {
                        zl.b.b(deviceHardInfoModel);
                    }
                });
            } else if (ngVar instanceof dy) {
                zl.a.h((dy) ngVar);
            }
            EventBus.getDefault().post(ngVar);
            Log.d("BluetoothProtocolManager", "SDK事件: " + GsonUtils.toJson(ngVar));
        }
    }

    private zl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(dy dyVar) {
        boolean zN;
        try {
            String strA = dyVar.a();
            if (strA != null && strA.length() != 0) {
                Log.d("BluetoothProtocolManager", "开始检查经典蓝牙配对状态，MAC地址: " + strA);
                try {
                    zN = ak.n(strA);
                } catch (Exception e2) {
                    Log.e("BluetoothProtocolManager", "检查配对状态失败: " + e2.getMessage(), e2);
                    zN = false;
                }
                if (zN) {
                    Log.d("BluetoothProtocolManager", "设备已配对，跳过配对流程，MAC地址: " + strA);
                    return;
                }
                Log.d("BluetoothProtocolManager", "设备未配对，触发配对流程，MAC地址: " + strA);
                l(strA, dyVar.getMacAddress());
                return;
            }
            Log.d("BluetoothProtocolManager", "经典蓝牙MAC地址为空，跳过配对检查");
        } catch (Exception e3) {
            Log.e("BluetoothProtocolManager", "检查并触发蓝牙配对失败: " + e3.getMessage(), e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void k(aa0 aa0Var) {
        try {
            Object objInvokeMethod = aa0Var.invokeMethod("BluetoothProtocolManager", "BluetoothProtocolManager");
            String str = objInvokeMethod != null ? "1" : "0";
            zm1.Y(str);
            Log.d("BluetoothProtocolManager", "天气支持状态: " + str);
            if (objInvokeMethod != null) {
                Log.d("BluetoothProtocolManager", "设备支持天气功能，开始同步天气");
                di0.a(new po2());
                ph3.e();
                HttpHelper.g().j(true);
            } else {
                Log.d("BluetoothProtocolManager", "设备不支持天气功能");
            }
        } catch (Exception e2) {
            Log.e("BluetoothProtocolManager", "处理设备功能事件失败: " + e2.getMessage(), e2);
        }
    }

    private final void l(String str, String str2) {
        try {
            ClassicBluetoothBondListener.g.a().u(str, str2, null);
        } catch (Exception e2) {
            Log.e("BluetoothProtocolManager", "触发蓝牙配对失败: " + e2.getMessage(), e2);
        }
    }

    public final BajiProtocolManager i() {
        return b;
    }

    public final void j(Context context) {
        p31.f(context, "context");
        if (c) {
            return;
        }
        try {
            BajiProtocolManager bajiProtocolManager = new BajiProtocolManager();
            bajiProtocolManager.initialize(context, new a(), null, null, null, new b());
            b = bajiProtocolManager;
            c = true;
            Log.d("BluetoothProtocolManager", "蓝牙协议管理器初始化成功");
        } catch (Exception e2) {
            Log.e("BluetoothProtocolManager", "蓝牙协议管理器初始化失败: " + e2.getMessage());
            c = false;
        }
    }
}
