package xfkj.fitpro.ui.viewmodels.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.util.SparseArray;
import androidx.lifecycle.p;
import com.baji.protocol.BajiProtocolManager;
import com.baji.protocol.event.BajiBaseEvent;
import com.baji.protocol.event.DeviceConnectionEvent;
import com.legend.mywatch.sdk.mywatchsdklib.android.enm.BluetoothStatusEnum;
import com.legend.mywatch.sdk.mywatchsdklib.android.model.RecordInfoModel;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.ak;
import defpackage.d63;
import defpackage.ek2;
import defpackage.f82;
import defpackage.ft1;
import defpackage.hg;
import defpackage.im1;
import defpackage.kl;
import defpackage.ng;
import defpackage.ng3;
import defpackage.o00;
import defpackage.o10;
import defpackage.p31;
import defpackage.pv2;
import defpackage.vh0;
import defpackage.zi2;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.j;
import kotlin.collections.u;
import kotlin.text.i;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import no.nordicsemi.android.support.v18.scanner.n;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.objectweb.asm.Opcodes;
import xfkj.fitpro.model.BluetoothDeviceInfo;

/* JADX INFO: loaded from: classes4.dex */
public final class BluetoothScanViewModel extends com.legend.smartwatch.app.base.viewmodel.a {
    private Job F;
    private long G;
    private final a H;
    private final ConnectionState I;
    private final im1 m;
    private final im1 n;
    private final im1 o;
    private final im1 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final im1 f408q;
    private final im1 r;
    private final im1 s;
    private final im1 t;
    private final im1 u;
    private final im1 v;
    private final ConcurrentHashMap w;
    private final long x;
    private final long y;
    private final long z;

    public enum ConnectionState {
        DISCONNECTED,
        CONNECTING,
        CONNECTED,
        CONNECT_FAILED,
        SYNC_COMPLETED;

        private static final /* synthetic */ vh0 $ENTRIES = kotlin.enums.a.a(values());

        public static vh0 getEntries() {
            return $ENTRIES;
        }
    }

    public enum SyncState {
        PENDING,
        SYNCING,
        COMPLETED,
        FAILED;

        private static final /* synthetic */ vh0 $ENTRIES = kotlin.enums.a.a(values());

        public static vh0 getEntries() {
            return $ENTRIES;
        }
    }

    public static final class a extends ek2 {
        a() {
        }

        @Override // defpackage.ek2
        public void onBatchScanResults(List list) {
            p31.f(list, "results");
            BluetoothScanViewModel bluetoothScanViewModel = BluetoothScanViewModel.this;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bluetoothScanViewModel.P((ScanResult) it.next());
            }
        }

        @Override // defpackage.ek2
        public void onScanFailed(int i) {
            BluetoothScanViewModel.this.O(i);
        }

        @Override // defpackage.ek2
        public void onScanResult(int i, ScanResult scanResult) {
            p31.f(scanResult, "result");
            BluetoothScanViewModel.this.i("扫描结果: " + scanResult.a().getName() + " " + scanResult.a().getAddress() + " " + scanResult.b());
            BluetoothScanViewModel.this.P(scanResult);
        }
    }

    public static final class b implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return o00.a(Integer.valueOf(((BluetoothDeviceInfo) obj2).getRssi()), Integer.valueOf(((BluetoothDeviceInfo) obj).getRssi()));
        }
    }

    public BluetoothScanViewModel() {
        im1 im1Var = new im1();
        Boolean bool = Boolean.FALSE;
        im1Var.o(bool);
        this.m = im1Var;
        im1 im1Var2 = new im1();
        im1Var2.o(bool);
        this.n = im1Var2;
        im1 im1Var3 = new im1();
        im1Var3.o(j.j());
        this.o = im1Var3;
        im1 im1Var4 = new im1();
        im1Var4.o(ConnectionState.DISCONNECTED);
        this.p = im1Var4;
        this.f408q = new im1();
        im1 im1Var5 = new im1();
        SyncState syncState = SyncState.PENDING;
        im1Var5.o(u.g(d63.a("connection", syncState), d63.a("time", syncState), d63.a("uinfo", syncState), d63.a("step", syncState)));
        this.r = im1Var5;
        this.s = new im1();
        this.t = new im1();
        this.u = new im1();
        im1 im1Var6 = new im1();
        im1Var6.o(bool);
        this.v = im1Var6;
        this.w = new ConcurrentHashMap();
        this.x = 15L;
        this.y = 30L;
        this.z = 2000L;
        a aVar = new a();
        this.H = aVar;
        this.I = ConnectionState.CONNECTING;
        ft1.a.d(aVar);
    }

    private final String J(int i, Object... objArr) {
        String strE = pv2.e(i, Arrays.copyOf(objArr, objArr.length));
        p31.e(strE, "getString(...)");
        return strE;
    }

    private final void L(BajiBaseEvent bajiBaseEvent) {
        if (!(bajiBaseEvent instanceof DeviceConnectionEvent)) {
            i("收到baji-protocol事件: " + (bajiBaseEvent != null ? bajiBaseEvent.getClass().getSimpleName() : null));
            return;
        }
        DeviceConnectionEvent deviceConnectionEvent = (DeviceConnectionEvent) bajiBaseEvent;
        i("收到设备连接事件: " + deviceConnectionEvent.isConnected());
        if (!deviceConnectionEvent.isConnected()) {
            this.p.o(ConnectionState.DISCONNECTED);
            this.s.o(null);
            return;
        }
        this.p.o(ConnectionState.CONNECTED);
        BluetoothDeviceInfo bluetoothDeviceInfo = (BluetoothDeviceInfo) this.s.f();
        if (bluetoothDeviceInfo != null) {
            i0(this, bluetoothDeviceInfo.getAddress(), true, false, 4, null);
        }
    }

    private final void N(ng ngVar) {
        BluetoothDeviceInfo bluetoothDeviceInfo;
        if (!(ngVar instanceof o10)) {
            i("收到其他事件: " + (ngVar != null ? ngVar.getClass().getSimpleName() : null));
            return;
        }
        o10 o10Var = (o10) ngVar;
        int iA = o10Var.a();
        if (iA == BluetoothStatusEnum.CONNECTED.getValue()) {
            this.p.o(ConnectionState.CONNECTED);
            String macAddress = o10Var.getMacAddress();
            if (macAddress != null && (bluetoothDeviceInfo = (BluetoothDeviceInfo) this.w.get(macAddress)) != null) {
                this.s.o(bluetoothDeviceInfo);
                h0(macAddress, true, false);
            }
            i("设备连接成功");
            zi2.k();
            b0();
            return;
        }
        if (iA == BluetoothStatusEnum.CONNECTING.getValue()) {
            this.p.o(ConnectionState.CONNECTING);
            i("正在连接设备...");
            return;
        }
        if (iA == BluetoothStatusEnum.DISCONNECT.getValue()) {
            this.p.o(ConnectionState.DISCONNECTED);
            Collection collectionValues = this.w.values();
            p31.e(collectionValues, "<get-values>(...)");
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                h0(((BluetoothDeviceInfo) it.next()).getAddress(), false, false);
            }
            this.s.o(null);
            i("设备已断开连接");
            return;
        }
        if (iA != BluetoothStatusEnum.CONNECT_FAILED.getValue()) {
            i("连接状态: " + o10Var.a());
            return;
        }
        this.p.o(ConnectionState.CONNECT_FAILED);
        Collection<BluetoothDeviceInfo> collectionValues2 = this.w.values();
        p31.e(collectionValues2, "<get-values>(...)");
        for (BluetoothDeviceInfo bluetoothDeviceInfo2 : collectionValues2) {
            if (bluetoothDeviceInfo2.isConnecting()) {
                i0(this, bluetoothDeviceInfo2.getAddress(), false, false, 2, null);
            }
        }
        i("设备连接失败");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(int i) {
        String strJ;
        if (i == 1) {
            strJ = J(R.string.scan_failed_already_started, new Object[0]);
        } else if (i == 2) {
            strJ = J(R.string.scan_failed_app_registration, new Object[0]);
        } else if (i != 3) {
            strJ = i != 4 ? J(R.string.scan_failed_unknown_error, Integer.valueOf(i)) : J(R.string.scan_failed_ble_unsupported, new Object[0]);
        } else {
            strJ = J(R.string.scan_failed_internal_error, new Object[0]);
        }
        com.legend.smartwatch.app.base.viewmodel.a.k(this, "扫描失败: " + strJ, null, 2, null);
        this.f408q.o(strJ);
        this.m.o(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(ScanResult scanResult) {
        String name;
        n nVarC = scanResult.c();
        SparseArray sparseArrayD = nVarC != null ? nVarC.d() : null;
        if (!ng3.a.a(sparseArrayD, 43521, false)) {
            i("过滤非目标设备: " + scanResult.a().getName() + " (" + scanResult.a().getAddress() + ")");
            return;
        }
        RecordInfoModel recordInfoModelB = kl.a.b(sparseArrayD != null ? (byte[]) sparseArrayD.valueAt(0) : null);
        if (recordInfoModelB == null || recordInfoModelB.b() != 3) {
            i("过滤非电子吧唧设备: " + scanResult.a().getName() + " (" + scanResult.a().getAddress() + ") 设备类型: " + (recordInfoModelB != null ? Integer.valueOf(recordInfoModelB.b()) : null));
            return;
        }
        BluetoothDeviceInfo bluetoothDeviceInfoFromScanResult = BluetoothDeviceInfo.Companion.fromScanResult(scanResult);
        if (!bluetoothDeviceInfoFromScanResult.isValidDevice() || (name = bluetoothDeviceInfoFromScanResult.getName()) == null || i.Y(name) || p31.a(bluetoothDeviceInfoFromScanResult.getName(), "未知设备")) {
            return;
        }
        BluetoothDeviceInfo bluetoothDeviceInfo = (BluetoothDeviceInfo) this.w.get(bluetoothDeviceInfoFromScanResult.getAddress());
        this.w.put(bluetoothDeviceInfoFromScanResult.getAddress(), bluetoothDeviceInfoFromScanResult);
        if (bluetoothDeviceInfo == null || !p31.a(bluetoothDeviceInfo.getName(), bluetoothDeviceInfoFromScanResult.getName()) || Math.abs(bluetoothDeviceInfo.getRssi() - bluetoothDeviceInfoFromScanResult.getRssi()) > 5) {
            k0();
            i("发现电子吧唧设备: " + bluetoothDeviceInfoFromScanResult.getDisplayName() + " (" + bluetoothDeviceInfoFromScanResult.getAddress() + ") RSSI: " + bluetoothDeviceInfoFromScanResult.getRssi() + " 版本: " + recordInfoModelB.c() + " 电量: " + recordInfoModelB.a() + "%");
        }
    }

    private final String V(String str) {
        try {
            List listY0 = i.y0(str, new String[]{"m="}, false, 0, 6, null);
            if (listY0.size() < 2) {
                com.legend.smartwatch.app.base.viewmodel.a.k(this, "二维码内容格式错误，无法分割m=标识符", null, 2, null);
                return null;
            }
            String upperCase = (String) listY0.get(1);
            i("提取的MAC部分: " + upperCase);
            int i = 0;
            if (!i.M(upperCase, ":", false, 2, null)) {
                StringBuilder sb = new StringBuilder();
                int iB = f82.b(0, upperCase.length() - 1, 2);
                if (iB >= 0) {
                    while (true) {
                        if (i + 1 < upperCase.length()) {
                            int i2 = i + 2;
                            String strSubstring = upperCase.substring(i, i2);
                            p31.e(strSubstring, "substring(...)");
                            sb.append(strSubstring);
                            if (i2 < upperCase.length()) {
                                sb.append(":");
                            }
                        }
                        if (i == iB) {
                            break;
                        }
                        i += 2;
                    }
                }
                String string = sb.toString();
                p31.e(string, "toString(...)");
                upperCase = string.toUpperCase(Locale.ROOT);
                p31.e(upperCase, "toUpperCase(...)");
            }
            i("格式化后的MAC地址: " + upperCase);
            return upperCase;
        } catch (Exception e) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this, "解析MAC地址时发生异常: " + e.getMessage(), null, 2, null);
            return null;
        }
    }

    private final void Y() {
        Map mapF = (Map) this.r.f();
        if (mapF == null) {
            mapF = u.f();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(u.c(mapF.size()));
        Iterator it = mapF.entrySet().iterator();
        while (it.hasNext()) {
            linkedHashMap.put(((Map.Entry) it.next()).getKey(), SyncState.PENDING);
        }
        Map mapP = u.p(linkedHashMap);
        mapP.put("connection", SyncState.COMPLETED);
        this.r.o(mapP);
        this.p.o(ConnectionState.CONNECTING);
    }

    private final void b0() {
        i("开始数据同步流程");
        Y();
        BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new BluetoothScanViewModel$startDataSync$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        i("开始同步目标步数");
        l0("step", SyncState.SYNCING);
        try {
            zi2.q(10000);
            i("已发送目标步数数据");
            BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new BluetoothScanViewModel$syncTargetSteps$1(this, null), 3, null);
        } catch (Exception e) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this, "同步目标步数失败: " + e.getMessage(), null, 2, null);
            l0("step", SyncState.FAILED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        i("开始同步时间");
        l0("time", SyncState.SYNCING);
        try {
            zi2.s();
            i("已发送时间同步数据");
            BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new BluetoothScanViewModel$syncTime$1(this, null), 3, null);
        } catch (Exception e) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this, "同步时间失败: " + e.getMessage(), null, 2, null);
            l0("time", SyncState.FAILED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        i("开始同步用户个人信息");
        l0("uinfo", SyncState.SYNCING);
        try {
            zi2.r(1, 25, Opcodes.DRETURN, 70, 1);
            i("已发送用户个人信息数据");
            BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new BluetoothScanViewModel$syncUserInfo$1(this, null), 3, null);
        } catch (Exception e) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this, "同步用户个人信息失败: " + e.getMessage(), null, 2, null);
            l0("uinfo", SyncState.FAILED);
        }
    }

    private final void h0(String str, boolean z, boolean z2) {
        BluetoothDeviceInfo bluetoothDeviceInfo = (BluetoothDeviceInfo) this.w.get(str);
        if (bluetoothDeviceInfo != null) {
            this.w.put(str, BluetoothDeviceInfo.copy$default(bluetoothDeviceInfo, null, null, 0, z, z2, 0L, 39, null));
            j0();
        }
    }

    static /* synthetic */ void i0(BluetoothScanViewModel bluetoothScanViewModel, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        bluetoothScanViewModel.h0(str, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        Collection collectionValues = this.w.values();
        p31.e(collectionValues, "<get-values>(...)");
        this.o.o(j.X(j.U(collectionValues, new b())));
        this.G = System.currentTimeMillis();
    }

    private final void k0() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.G;
        if (j >= this.z) {
            j0();
            this.G = jCurrentTimeMillis;
            return;
        }
        Job job = this.F;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.F = BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new BluetoothScanViewModel$updateDeviceListWithDebounce$1(this.z - j, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(String str, SyncState syncState) {
        Map mapF = (Map) this.r.f();
        if (mapF == null) {
            mapF = u.f();
        }
        Map mapP = u.p(mapF);
        mapP.put(str, syncState);
        this.r.o(mapP);
        i("同步状态更新: " + str + " -> " + syncState);
    }

    public final void A() {
        this.t.o(null);
        this.u.o(null);
        this.v.o(Boolean.FALSE);
    }

    public final void B(BluetoothDeviceInfo bluetoothDeviceInfo) {
        p31.f(bluetoothDeviceInfo, "deviceInfo");
        Object objF = this.p.f();
        ConnectionState connectionState = ConnectionState.CONNECTING;
        if (objF == connectionState) {
            l(J(R.string.connecting_other_device_warning, new Object[0]));
            return;
        }
        i("开始连接设备: " + bluetoothDeviceInfo.getDisplayName() + " (" + bluetoothDeviceInfo.getAddress() + ")");
        if (p31.a(this.m.f(), Boolean.TRUE)) {
            i("连接设备时停止扫描");
            d0();
        }
        this.p.o(connectionState);
        i0(this, bluetoothDeviceInfo.getAddress(), false, true, 2, null);
        BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new BluetoothScanViewModel$connectDevice$1(this, bluetoothDeviceInfo, null), 3, null);
        try {
            Context contextF = hg.d.f();
            hg hgVar = contextF instanceof hg ? (hg) contextF : null;
            BajiProtocolManager bajiProtocolManagerK = hgVar != null ? hgVar.k() : null;
            if (bajiProtocolManagerK != null) {
                bajiProtocolManagerK.connectDevice(bluetoothDeviceInfo.getAddress());
                i("已调用baji-protocol连接方法");
                return;
            }
            com.legend.smartwatch.app.base.viewmodel.a.k(this, J(R.string.baji_protocol_manager_not_initialized, new Object[0]), null, 2, null);
            this.p.o(ConnectionState.CONNECT_FAILED);
            try {
                i0(this, bluetoothDeviceInfo.getAddress(), false, false, 2, null);
            } catch (Exception e) {
                e = e;
                com.legend.smartwatch.app.base.viewmodel.a.k(this, "连接设备失败: " + e.getMessage(), 0, 2, r6);
                this.p.o(ConnectionState.CONNECT_FAILED);
                i0(this, bluetoothDeviceInfo.getAddress(), false, false, 2, null);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public final void C() {
        if (this.p.f() == ConnectionState.DISCONNECTED) {
            l(J(R.string.no_connected_device_warning, new Object[0]));
            return;
        }
        i("断开设备连接");
        try {
            Context contextF = hg.d.f();
            hg hgVar = contextF instanceof hg ? (hg) contextF : null;
            BajiProtocolManager bajiProtocolManagerK = hgVar != null ? hgVar.k() : null;
            if (bajiProtocolManagerK == null) {
                com.legend.smartwatch.app.base.viewmodel.a.k(this, J(R.string.baji_protocol_manager_not_initialized, new Object[0]), null, 2, null);
            } else {
                bajiProtocolManagerK.disconnectDevice();
                i("已调用baji-protocol断开连接方法");
            }
        } catch (Exception e) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this, "断开连接失败: " + e.getMessage(), null, 2, null);
        }
    }

    public final ConnectionState D() {
        return this.I;
    }

    public final im1 E() {
        return this.s;
    }

    public final im1 F() {
        return this.p;
    }

    public final im1 G() {
        return this.o;
    }

    public final im1 H() {
        return this.u;
    }

    public final im1 I() {
        return this.f408q;
    }

    public final im1 K() {
        return this.r;
    }

    public final void M(String str) {
        Object next;
        if (str == null || i.Y(str)) {
            this.u.o(J(R.string.not_found_device, new Object[0]));
            return;
        }
        i("二维码扫描结果: " + str);
        this.t.o(str);
        this.u.o(null);
        if (!i.M(str, "m=", false, 2, null)) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this, "二维码不包含m=标识符", null, 2, null);
            this.u.o(J(R.string.not_found_device, new Object[0]));
            return;
        }
        String strV = V(str);
        if (strV == null || i.Y(strV)) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this, "无法解析MAC地址", null, 2, null);
            this.u.o(J(R.string.not_found_device, new Object[0]));
            return;
        }
        i("解析到的MAC地址: " + strV);
        if (!BluetoothAdapter.checkBluetoothAddress(strV)) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this, "MAC地址格式无效: " + strV, null, 2, null);
            this.u.o(J(R.string.not_found_device, new Object[0]));
            return;
        }
        List listJ = (List) this.o.f();
        if (listJ == null) {
            listJ = j.j();
        }
        Iterator it = listJ.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!i.v(((BluetoothDeviceInfo) next).getAddress(), strV, true));
        BluetoothDeviceInfo bluetoothDeviceInfo = (BluetoothDeviceInfo) next;
        if (bluetoothDeviceInfo == null) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this, "设备列表中未找到匹配的MAC地址: " + strV, null, 2, null);
            this.u.o(J(R.string.not_found_device, new Object[0]));
            return;
        }
        i("找到匹配设备: " + bluetoothDeviceInfo.getDisplayName());
        B(bluetoothDeviceInfo);
    }

    public final boolean Q() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    public final im1 R() {
        return this.n;
    }

    public final im1 S() {
        return this.v;
    }

    public final im1 T() {
        return this.m;
    }

    public final void U() {
        i("所有数据同步完成，准备退出页面");
        this.p.o(ConnectionState.SYNC_COMPLETED);
    }

    public final void W() {
        Object objF = this.m.f();
        Boolean bool = Boolean.TRUE;
        if (!p31.a(objF, bool) || p31.a(this.n.f(), bool)) {
            return;
        }
        i("暂停扫描蓝牙设备");
        this.m.o(Boolean.FALSE);
        this.n.o(bool);
        ft1.a.b();
    }

    public final void X() {
        if (p31.a(this.m.f(), Boolean.TRUE)) {
            i("刷新设备列表，停止当前扫描");
            d0();
        }
        BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new BluetoothScanViewModel$refreshDeviceList$1(this, null), 3, null);
    }

    public final void Z() {
        Object objF = this.n.f();
        Boolean bool = Boolean.TRUE;
        if (p31.a(objF, bool)) {
            i("恢复扫描蓝牙设备");
            this.m.o(bool);
            this.n.o(Boolean.FALSE);
            ft1.a.c();
        }
    }

    public final void a0(boolean z) {
        this.v.o(Boolean.valueOf(z));
    }

    public final void c0() {
        Object objF = this.m.f();
        Boolean bool = Boolean.TRUE;
        if (p31.a(objF, bool)) {
            i(J(R.string.scan_already_in_progress, new Object[0]));
            return;
        }
        if (!ak.j()) {
            this.f408q.o(J(R.string.bluetooth_not_enabled_error, new Object[0]));
            return;
        }
        i("开始扫描蓝牙设备");
        this.m.o(bool);
        this.n.o(Boolean.FALSE);
        this.f408q.o(null);
        this.w.clear();
        j0();
        ft1.a.e();
        BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new BluetoothScanViewModel$startScan$1(this, null), 3, null);
    }

    @Override // com.legend.smartwatch.app.base.viewmodel.a, androidx.lifecycle.o
    protected void d() {
        super.d();
        Job job = this.F;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        d0();
        ft1.a.f();
    }

    public final void d0() {
        if (p31.a(this.m.f(), Boolean.TRUE)) {
            i("停止扫描蓝牙设备");
            im1 im1Var = this.m;
            Boolean bool = Boolean.FALSE;
            im1Var.o(bool);
            this.n.o(bool);
            ft1.a.f();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onBajiProtocolEvent(BajiBaseEvent bajiBaseEvent) {
        L(bajiBaseEvent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onSDKEvent(ng ngVar) {
        N(ngVar);
    }

    public final boolean z() {
        if (ak.j()) {
            this.u.o(null);
            return true;
        }
        this.u.o(J(R.string.bluetooth_not_enabled_error, new Object[0]));
        return false;
    }
}
