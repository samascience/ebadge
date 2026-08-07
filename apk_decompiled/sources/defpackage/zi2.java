package defpackage;

import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.a;
import com.legend.mywatch.sdk.mywatchsdklib.android.enm.BluetoothStatusEnum;
import com.legend.mywatch.sdk.mywatchsdklib.android.excepion.InitSDKException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zi2 {
    public static void a(String str) {
        e().A0(str);
    }

    public static void b() {
        e().B();
    }

    public static byte[] c() {
        return o(qm2.C(true), "寻找手环");
    }

    public static byte[] d() {
        return o(qm2.d(), "获取表盘信息");
    }

    public static a e() {
        a aVar = e20.a;
        if (aVar != null) {
            return aVar;
        }
        throw new InitSDKException();
    }

    public static byte[] f() {
        return n(qm2.i());
    }

    public static byte[] g() {
        return o(qm2.D(AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN), "获取硬件信息");
    }

    public static byte[] h() {
        return o(qm2.I(true), "app请求获取天总结实时数据");
    }

    public static boolean i() {
        return e20.d == BluetoothStatusEnum.CONNECTED.getValue();
    }

    public static byte[] j() {
        return n(qm2.j());
    }

    public static void k() {
        if (i()) {
            e().r0();
        }
    }

    public static byte[] l() {
        return o(qm2.D((byte) 28), "获取设备能力位图(0x1C)");
    }

    public static byte[] m() {
        return o(qm2.v(), "重置手环");
    }

    public static byte[] n(byte[] bArr) {
        return o(bArr, "自定义命令");
    }

    public static byte[] o(byte[] bArr, String str) {
        if (i()) {
            e().K(bArr, str);
        }
        return bArr;
    }

    public static byte[] p(boolean z) {
        return o(qm2.K(z), "进入前台:" + z);
    }

    public static byte[] q(int i) {
        return o(qm2.F(i), "设置目标步数");
    }

    public static byte[] r(int i, int i2, int i3, int i4, int i5) {
        return o(qm2.H(i, i2, i3, i4, i5), "设置用户个人信息");
    }

    public static byte[] s() {
        return o(qm2.G(), "设置系统时间");
    }

    public static byte[] t() {
        ug3.a();
        return o(qm2.m(false), "解绑手环");
    }
}
