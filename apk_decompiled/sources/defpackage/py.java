package defpackage;

import android.util.Log;
import com.blankj.utilcode.util.GsonUtils;
import com.legend.mywatch.sdk.mywatchsdklib.android.enm.BluetoothStatusEnum;
import java.util.List;
import kotlin.collections.j;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.model.sever.body.ClockDialInfoBody;

/* JADX INFO: loaded from: classes4.dex */
public final class py {
    public static final py a = new py();
    private static boolean b;
    private static List c;

    private py() {
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001d A[Catch: Exception -> 0x001b, TRY_LEAVE, TryCatch #0 {Exception -> 0x001b, blocks: (B:3:0x0002, B:5:0x000d, B:10:0x0015, B:13:0x001d), top: B:18:0x0002 }] */
    private final void d() {
        try {
            Log.d("ClockDialInfoManager", "发送读取表盘信息命令");
            byte[] bArrD = zi2.d();
            if (bArrD == null) {
                Log.e("ClockDialInfoManager", "获取表盘信息命令失败");
            } else {
                if (bArrD.length == 0) {
                    Log.e("ClockDialInfoManager", "获取表盘信息命令失败");
                } else {
                    Log.d("ClockDialInfoManager", "表盘信息读取命令已发送");
                }
            }
        } catch (Exception e) {
            Log.e("ClockDialInfoManager", "读取表盘信息失败: " + e.getMessage(), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001d A[Catch: Exception -> 0x001b, TRY_LEAVE, TryCatch #0 {Exception -> 0x001b, blocks: (B:3:0x0002, B:5:0x000d, B:10:0x0015, B:13:0x001d), top: B:18:0x0002 }] */
    private final void e() {
        try {
            Log.d("ClockDialInfoManager", "发送读取表盘列表命令");
            byte[] bArrF = zi2.f();
            if (bArrF == null) {
                Log.e("ClockDialInfoManager", "获取表盘列表命令失败");
            } else {
                if (bArrF.length == 0) {
                    Log.e("ClockDialInfoManager", "获取表盘列表命令失败");
                } else {
                    Log.d("ClockDialInfoManager", "表盘列表读取命令已发送");
                }
            }
        } catch (Exception e) {
            Log.e("ClockDialInfoManager", "读取表盘列表失败: " + e.getMessage(), e);
        }
    }

    private final void g(ClockDialInfoBody clockDialInfoBody) {
        try {
            String strF = zm1.f();
            p31.c(strF);
            if (strF.length() > 0) {
                clockDialInfoBody.setDevId(strF);
            }
            DBHelper.saveClockDialInfo(clockDialInfoBody);
            Log.d("ClockDialInfoManager", "表盘信息已保存到数据库");
            Log.d("ClockDialInfoManager", "设备ID: " + clockDialInfoBody.getDevId());
            Log.d("ClockDialInfoManager", "主板型号: " + clockDialInfoBody.getMainModel());
            Log.d("ClockDialInfoManager", "整机型号: " + clockDialInfoBody.getMchModel());
            Log.d("ClockDialInfoManager", "屏幕类型: " + clockDialInfoBody.getScreenType());
            Log.d("ClockDialInfoManager", "屏幕尺寸: " + ((int) clockDialInfoBody.getWidth()) + "x" + ((int) clockDialInfoBody.getHeight()));
            int pictureNums = clockDialInfoBody.getPictureNums();
            StringBuilder sb = new StringBuilder();
            sb.append("表盘数量: ");
            sb.append(pictureNums);
            Log.d("ClockDialInfoManager", sb.toString());
            Log.d("ClockDialInfoManager", "表盘版本: " + clockDialInfoBody.getWatchThemeVersion());
        } catch (Exception e) {
            Log.e("ClockDialInfoManager", "保存表盘信息到数据库失败: " + e.getMessage(), e);
        }
    }

    private final void h(List list) {
        try {
            c = list;
            Log.d("ClockDialInfoManager", "表盘列表已保存到内存，共 " + list.size() + " 个表盘");
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    j.s();
                }
                Log.d("ClockDialInfoManager", "表盘 " + i + ": " + obj);
                i = i2;
            }
        } catch (Exception e) {
            Log.e("ClockDialInfoManager", "保存表盘列表到内存失败: " + e.getMessage(), e);
        }
    }

    public final ClockDialInfoBody a() {
        try {
            return DBHelper.getClockDialInfo();
        } catch (Exception e) {
            Log.e("ClockDialInfoManager", "获取表盘信息失败: " + e.getMessage(), e);
            return null;
        }
    }

    public final boolean b() {
        String devId;
        try {
            ClockDialInfoBody clockDialInfo = DBHelper.getClockDialInfo();
            return (clockDialInfo == null || (devId = clockDialInfo.getDevId()) == null || devId.length() == 0) ? false : true;
        } catch (Exception e) {
            Log.e("ClockDialInfoManager", "检查表盘信息失败: " + e.getMessage(), e);
            return false;
        }
    }

    public final void c() {
        if (b) {
            return;
        }
        EventBus.getDefault().register(this);
        b = true;
        Log.d("ClockDialInfoManager", "表盘信息管理器已初始化");
    }

    public final void f() {
        Log.d("ClockDialInfoManager", "手动请求读取表盘信息");
        d();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onClockDialInfoEvent(oy oyVar) {
        p31.f(oyVar, "event");
        if (oyVar.a() == null) {
            Log.w("ClockDialInfoManager", "表盘信息为空，错误信息: " + oyVar.b());
            return;
        }
        Log.d("ClockDialInfoManager", "收到表盘信息，开始转换并存储到数据库");
        try {
            ny nyVar = ny.a;
            my myVarA = oyVar.a();
            p31.e(myVarA, "getBody(...)");
            g(nyVar.a(myVarA));
            Log.d("ClockDialInfoManager", "表盘信息保存完成，开始获取表盘列表");
            e();
            k83 k83Var = k83.a;
        } catch (Exception e) {
            Log.e("ClockDialInfoManager", "转换表盘信息失败: " + e.getMessage(), e);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onConnectStatusEvent(o10 o10Var) {
        p31.f(o10Var, "event");
        int iA = o10Var.a();
        if (iA == BluetoothStatusEnum.CONNECTED.getValue()) {
            Log.d("ClockDialInfoManager", "设备连接成功，等待设备功能事件");
        } else if (iA == BluetoothStatusEnum.DISCONNECT.getValue()) {
            Log.d("ClockDialInfoManager", "设备断开连接");
        } else if (iA == BluetoothStatusEnum.CONNECT_FAILED.getValue()) {
            Log.d("ClockDialInfoManager", "设备连接失败");
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onDeviceFunctionEvent(aa0 aa0Var) {
        p31.f(aa0Var, "event");
        Log.d("ClockDialInfoManager", "收到设备功能事件，开始读取表盘信息");
        d();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onWatchThemeListEvent(pg3 pg3Var) {
        p31.f(pg3Var, "event");
        try {
            Log.d("ClockDialInfoManager", "收到表盘列表事件: " + GsonUtils.toJson(pg3Var));
            List listA = pg3Var.a();
            p31.c(listA);
            if (listA.isEmpty()) {
                Log.w("ClockDialInfoManager", "表盘列表为空");
            } else {
                Log.d("ClockDialInfoManager", "收到表盘列表，开始存储到数据库，共 " + listA.size() + " 个表盘");
                h(listA);
            }
        } catch (Exception e) {
            Log.e("ClockDialInfoManager", "处理表盘列表事件失败: " + e.getMessage(), e);
        }
    }
}
