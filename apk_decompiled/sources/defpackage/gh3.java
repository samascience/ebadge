package defpackage;

import android.graphics.Color;
import android.util.Log;
import com.baji.protocol.model.ProtocolConstants;
import com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.CommandPool;
import com.legend.mywatch.sdk.mywatchsdklib.android.enm.WatchThemeStyleEnum;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.d;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.e;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.f;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class gh3 {
    private static gh3 J;
    private xg3 F;
    private my H;
    private boolean I;
    private byte[] o;
    int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f338q;
    private r40 t;
    private r40 u;
    private final String a = "WatchTheme3Tools";
    private final int b = 0;
    private final int c = 1;
    private final int d = 2;
    private final int e = 3;
    private final int f = 4;
    private final int g = 5;
    private final int h = 6;
    private final int i = 7;
    private final int j = 8;
    private final int k = 9;
    private final int[] l = {1000, 100000000};
    private final int[] m = {100000000, 200000000};
    private final int n = 0;
    int r = 0;
    int s = 0;
    boolean v = false;
    boolean w = false;
    private final int x = 15000;
    private final int y = 5000;
    private final int z = 15000;
    private final int A = 5000;
    private boolean B = true;
    private boolean C = false;
    private float D = 0.0f;
    List E = new ArrayList();
    private int G = 0;

    public interface a {
        void a(mh3 mh3Var, xg3 xg3Var);

        void b(int i);

        void c();

        void d(xg3 xg3Var);
    }

    public gh3() {
        r40 r40VarC = r40.c();
        this.t = r40VarC;
        r40VarC.f(15000L);
        this.t.d(5000L);
        this.t.g(new r40.c() { // from class: yg3
            @Override // r40.c
            public final void a(long j) {
                this.a.E(j);
            }
        });
        this.t.e(new r40.a() { // from class: zg3
            @Override // r40.a
            public final void onFinish() {
                this.a.F();
            }
        });
        r40 r40VarC2 = r40.c();
        this.u = r40VarC2;
        r40VarC2.f(15000L);
        this.u.d(5000L);
        this.u.g(new r40.c() { // from class: ah3
            @Override // r40.c
            public final void a(long j) {
                this.a.G(j);
            }
        });
        this.u.e(new r40.a() { // from class: bh3
            @Override // r40.a
            public final void onFinish() {
                this.a.H();
            }
        });
    }

    private boolean A() {
        return (!this.I || v(this.F) || y(this.F) || x(this.F)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        this.t.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        this.u.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(long j) {
        if (j <= ProtocolConstants.CONNECTION_TIMEOUT_MS) {
            L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        Log.e("WatchTheme3Tools", "finish timeout");
        U(1001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(long j) {
        if (j <= ProtocolConstants.CONNECTION_TIMEOUT_MS) {
            Log.e("WatchTheme3Tools", "start resend num:" + this.r);
            L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        Log.e("WatchTheme3Tools", "resend finish");
        U(1002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        this.t.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        this.u.h();
    }

    static int K(int i) {
        int i2 = i + 32;
        return i2 % 4096 == 0 ? i2 : ((i2 / 4096) + 1) * 4096;
    }

    private void L() {
        Log.i("WatchTheme3Tools", "读取表盘升级状态。cur mSendNum:" + this.r + ";srcPos:" + this.p);
        if (!this.B) {
            Log.e("WatchTheme3Tools", "不需要读状态");
        } else {
            if (X(qm2.h(), "读取表盘升级状态")) {
                return;
            }
            Log.e("WatchTheme3Tools", "device disconnected readstatus failed");
        }
    }

    private void M() {
        this.C = false;
        l();
        m();
        this.o = null;
        this.p = 0;
        this.f338q = 0;
        this.s = 0;
        this.r = 0;
        this.D = 0.0f;
        this.F = null;
        CommandPool.n(100);
    }

    private void O(byte[] bArr) {
        if (bArr != null) {
            int i = this.r;
            short s = (short) (i + 1);
            byte[] bArrH = ks1.h(ks1.o((short) (i + 1)), bArr);
            if (!X(qm2.e(ks1.h(bArrH, j(bArrH))), "正在升级表盘数据index:" + ((int) s))) {
                Log.e("WatchTheme3Tools", "send file failed");
                return;
            }
            int i2 = this.r;
            this.s = i2;
            this.r = i2 + 1;
        }
    }

    private void P() {
        Log.e("WatchTheme3Tools", "send finish");
        if (X(qm2.f(k()), "发送升级文件完成!")) {
            return;
        }
        Log.e("WatchTheme3Tools", "ble disconnected send finish cmd failed");
    }

    private void Q(xg3 xg3Var, List list) {
        Log.e("WatchTheme3Tools", "start ota watch:" + xg3Var);
        int iH = xg3Var.h();
        byte bA = ks1.a(new byte[]{(byte) ((!xg3Var.k() || xg3Var.b() == 0) ? 0 : 1), x(xg3Var) ? (byte) 1 : (byte) 0, y(xg3Var) ? (byte) 1 : (byte) 0, v(xg3Var) ? (byte) 1 : (byte) 0, z(xg3Var) ? (byte) 1 : (byte) 0, w(xg3Var) ? (byte) 1 : (byte) 0});
        int iB = xg3Var.b();
        byte[] bArr = {(byte) Color.red(iB), (byte) Color.green(iB), (byte) Color.blue(iB)};
        int iS = s();
        byte bR = (byte) r(WatchThemeStyleEnum.BG_STYLE, list);
        byte bR2 = (byte) r(WatchThemeStyleEnum.TIME_STYLE, list);
        byte bR3 = (byte) r(WatchThemeStyleEnum.POINTER_STYLE, list);
        if (bR2 <= 0) {
            bR2 = bR3;
        }
        byte bR4 = (byte) r(WatchThemeStyleEnum.BG_COLOR, list);
        byte[] bArrQ = q(list);
        Log.i("WatchTheme3Tools", "mixStyleConfig:" + d.a(bArrQ));
        if (X(qm2.g(ks1.h(pp.j(iH), new byte[]{(byte) xg3Var.d(), bA}, bArr, pp.j(iS), ks1.h(new byte[]{bR, bR2}, bArrQ, new byte[]{bR4}))), "开始升级表盘")) {
            return;
        }
        Log.e("WatchTheme3Tools", "ble disconnected send failed");
    }

    private void R() {
        if (this.t == null || this.v) {
            return;
        }
        Log.e("WatchTheme3Tools", "startCountDown");
        this.v = true;
        l.a(new Runnable() { // from class: ch3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.I();
            }
        });
    }

    private void T() {
        if (this.u == null || this.w) {
            return;
        }
        Log.e("WatchTheme3Tools", "startResendCountDown");
        this.w = true;
        l.a(new Runnable() { // from class: fh3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.J();
            }
        });
    }

    private void U(int i) {
        V(i, -1);
    }

    private void V(int i, int i2) {
        Log.e("WatchTheme3Tools", "upgrade failed errorCode:" + i);
        a aVarP = p();
        if (B() && aVarP != null) {
            aVarP.a(new mh3(i, i2), this.F);
        }
        M();
    }

    private void W() {
        Log.e("WatchTheme3Tools", "upgrade finish");
        a aVarP = p();
        if (B() && aVarP != null) {
            aVarP.d(this.F);
        }
        M();
    }

    private boolean X(byte[] bArr, String str) {
        if (!zi2.i()) {
            U(1006);
            return false;
        }
        zi2.e().M(bArr, str);
        R();
        return true;
    }

    private void Y() {
        byte[] bArr;
        if (this.o == null || s() == 0) {
            Log.e("WatchTheme3Tools", "write ota failed.file is empty");
            U(1004);
            return;
        }
        int i = this.p;
        this.f338q = i;
        if (i + t() < s()) {
            bArr = new byte[t()];
            System.arraycopy(this.o, this.p, bArr, 0, t());
            O(bArr);
            this.p += t();
        } else {
            int iS = s();
            int i2 = this.p;
            int i3 = iS - i2;
            if (i3 > 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(this.o, i2, bArr2, 0, i3);
                O(bArr2);
                this.p += i3;
                bArr = bArr2;
            } else {
                P();
                bArr = null;
            }
        }
        if (bArr == null || this.o == null) {
            return;
        }
        float length = bArr.length / (s() * 1.0f);
        this.D += length;
        Log.i("WatchTheme3Tools", "single progress:" + length + ";mCurProgress:" + this.D);
        float f = this.D;
        this.D = f <= 1.0f ? f : 1.0f;
        a aVarP = p();
        if (aVarP != null) {
            aVarP.b((int) (this.D * 1000.0f));
        }
    }

    private byte[] j(byte[] bArr) {
        int i = 0;
        for (byte b : bArr) {
            i += (short) (b & 255);
        }
        Log.i("WatchTheme3Tools", "checkCode:" + i);
        return ks1.l(i);
    }

    private byte[] k() {
        int i = 0;
        for (byte b : this.o) {
            i += (short) (b & 255);
        }
        Log.i("WatchTheme3Tools", "sum checkCode:" + i);
        return ks1.h(ks1.l(i));
    }

    private void l() {
        if (this.t == null || !this.v) {
            return;
        }
        Log.e("WatchTheme3Tools", "cancelCountDown");
        this.v = false;
        l.a(new Runnable() { // from class: eh3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.C();
            }
        });
    }

    private void m() {
        if (this.u == null || !this.w) {
            return;
        }
        Log.e("WatchTheme3Tools", "cancelResendCountDown");
        this.w = false;
        l.a(new Runnable() { // from class: dh3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.D();
            }
        });
    }

    private List n(List list) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
        for (Integer num : map.keySet()) {
            List list2 = (List) map.get(num);
            pk1 pk1Var = new pk1(num.intValue(), new byte[ez.b(list2)]);
            Iterator it2 = list2.iterator();
            if (it2.hasNext()) {
                e43.a(it2.next());
                pk1Var.a();
                throw null;
            }
            arrayList.add(pk1Var);
        }
        return arrayList;
    }

    public static gh3 o() {
        if (J == null) {
            J = new gh3();
        }
        return J;
    }

    private a p() {
        if (ez.a(this.E)) {
            return null;
        }
        List list = this.E;
        return (a) list.get(list.size() - 1);
    }

    private byte[] q(List list) {
        List<pk1> listN = n(list);
        byte[] bArrH = ks1.h(new byte[]{(byte) listN.size()});
        for (pk1 pk1Var : listN) {
            int iB = pk1Var.b();
            byte[] bArrA = pk1Var.a();
            bArrH = ks1.h(bArrH, new byte[]{(byte) iB, (byte) bArrA.length}, bArrA);
        }
        return bArrH;
    }

    private int r(WatchThemeStyleEnum watchThemeStyleEnum, List list) {
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return 0;
        }
        e43.a(it.next());
        watchThemeStyleEnum.getType();
        throw null;
    }

    private int t() {
        int i = this.G;
        if (i < 1) {
            return 5000;
        }
        return i;
    }

    private void u(long j) {
        String strValueOf = String.valueOf(j);
        int i = Integer.parseInt(String.valueOf(strValueOf.charAt(1)));
        int i2 = Integer.parseInt(strValueOf.substring(2));
        if (i != 0) {
            return;
        }
        V(1010, i2);
    }

    private boolean v(xg3 xg3Var) {
        return f.c(xg3Var.a());
    }

    private boolean w(xg3 xg3Var) {
        return f.c(xg3Var.c());
    }

    private boolean x(xg3 xg3Var) {
        return f.c(xg3Var.e());
    }

    private boolean y(xg3 xg3Var) {
        return f.c(xg3Var.f());
    }

    private boolean z(xg3 xg3Var) {
        return f.c(xg3Var.i());
    }

    public boolean B() {
        return this.C;
    }

    public void N(int i) {
        Log.i("WatchTheme3Tools", "sendNum:" + this.r + ";responseCode:" + i);
        long jP = ks1.p(i);
        l();
        if (!A() && this.o == null) {
            Log.e("WatchTheme3Tools", "file no exisit");
            U(1004);
            return;
        }
        int[] iArr = this.l;
        int i2 = iArr[0];
        if (jP >= i2 && jP < iArr[1]) {
            long j = jP - ((long) i2);
            int i3 = this.r;
            if (i3 == 0 && j == 0) {
                Log.i("WatchTheme3Tools", "start send file");
                Y();
                return;
            }
            if (j <= this.s || j != i3) {
                Log.e("WatchTheme3Tools", "start resend num no match:" + j + ";mSendNum:" + this.r + ";mLastNum:" + this.s);
                T();
                return;
            }
            Log.i("WatchTheme3Tools", "send success num:" + j + ";mSendNum:" + this.r + ";mLastNum:" + this.s);
            m();
            Y();
            return;
        }
        int[] iArr2 = this.m;
        if (jP >= iArr2[0] && jP < iArr2[1]) {
            u(jP);
            return;
        }
        if (2 == jP) {
            Log.e("WatchTheme3Tools", "update success");
            W();
            return;
        }
        if (1 == jP) {
            Log.e("WatchTheme3Tools", "check failed");
            U(1003);
            return;
        }
        if (3 == jP) {
            U(1008);
            return;
        }
        if (4 == jP) {
            U(1009);
            return;
        }
        if (5 == jP) {
            U(1010);
            return;
        }
        if (6 == jP) {
            U(1011);
            return;
        }
        if (7 == jP) {
            U(1012);
            return;
        }
        if (8 == jP) {
            U(1013);
        } else if (9 == jP) {
            U(1015);
        } else {
            U((int) jP);
        }
    }

    public synchronized void S(xg3 xg3Var, List list, my myVar, boolean z) {
        Log.i("WatchTheme3Tools", "=== 开始表盘升级流程 ===");
        Log.i("WatchTheme3Tools", "表盘ID: " + xg3Var.h());
        Log.i("WatchTheme3Tools", "是否编辑模式: " + z);
        Log.i("WatchTheme3Tools", "表盘路径: " + xg3Var.i());
        Log.i("WatchTheme3Tools", "背景图路径: " + xg3Var.a());
        Log.i("WatchTheme3Tools", "预览图路径: " + xg3Var.e());
        Log.i("WatchTheme3Tools", "缩略图路径: " + xg3Var.f());
        if (this.C) {
            Log.e("WatchTheme3Tools", "正在升级表盘");
            U(1000);
            return;
        }
        this.I = z;
        if (!zi2.i()) {
            Log.e("WatchTheme3Tools", "设备已断开连接");
            U(1006);
            return;
        }
        this.F = xg3Var;
        this.C = true;
        this.H = myVar;
        this.G = myVar.n();
        a aVarP = p();
        if (aVarP != null) {
            aVarP.c();
        }
        CommandPool.n(6);
        Log.i("WatchTheme3Tools", "设置发送间隔: 6ms");
        int i = 0;
        byte[] bArrH = new byte[0];
        this.o = new byte[0];
        Log.i("WatchTheme3Tools", "开始构建文件数据...");
        if (x(xg3Var)) {
            Log.i("WatchTheme3Tools", "处理预览图: " + xg3Var.e());
            byte[] bArrB = e.b(xg3Var.e());
            Log.i("WatchTheme3Tools", "预览图大小: " + bArrB.length + " bytes");
            bArrH = ks1.h(bArrH, pp.j(bArrB.length));
            this.o = ks1.h(this.o, bArrB);
        } else {
            Log.i("WatchTheme3Tools", "无预览图");
        }
        if (y(xg3Var)) {
            Log.i("WatchTheme3Tools", "处理缩略图: " + xg3Var.f());
            byte[] bArrB2 = e.b(xg3Var.f());
            Log.i("WatchTheme3Tools", "缩略图大小: " + bArrB2.length + " bytes");
            bArrH = ks1.h(bArrH, pp.j(bArrB2.length));
            this.o = ks1.h(this.o, bArrB2);
        } else {
            Log.i("WatchTheme3Tools", "无缩略图");
        }
        if (v(xg3Var)) {
            Log.i("WatchTheme3Tools", "处理自定义背景: " + xg3Var.a());
            byte[] bArrB3 = e.b(xg3Var.a());
            Log.i("WatchTheme3Tools", "自定义背景大小: " + bArrB3.length + " bytes");
            bArrH = ks1.h(bArrH, pp.j(bArrB3.length));
            this.o = ks1.h(this.o, bArrB3);
        } else {
            Log.i("WatchTheme3Tools", "无自定义背景");
        }
        if (z(xg3Var)) {
            Log.i("WatchTheme3Tools", "处理表盘文件: " + xg3Var.i());
            byte[] bArrB4 = e.b(xg3Var.i());
            Log.i("WatchTheme3Tools", "表盘文件大小: " + bArrB4.length + " bytes");
            bArrH = ks1.h(bArrH, pp.j(bArrB4.length));
            this.o = ks1.h(this.o, bArrB4);
        } else {
            Log.i("WatchTheme3Tools", "无表盘文件");
        }
        if (w(xg3Var)) {
            Log.i("WatchTheme3Tools", "处理默认表盘背景: " + xg3Var.c());
            byte[] bArrB5 = e.b(xg3Var.c());
            Log.i("WatchTheme3Tools", "默认表盘背景大小: " + bArrB5.length + " bytes");
            bArrH = ks1.h(bArrH, pp.j(bArrB5.length));
            this.o = ks1.h(this.o, bArrB5);
        } else {
            Log.i("WatchTheme3Tools", "无默认表盘背景");
        }
        this.o = ks1.h(bArrH, this.o);
        Log.i("WatchTheme3Tools", "文件头大小: " + bArrH.length + " bytes");
        Log.i("WatchTheme3Tools", "总文件数据大小: " + this.o.length + " bytes");
        if (xg3Var.j()) {
            Log.i("WatchTheme3Tools", "启用4K对齐处理");
            int iK = 0;
            while (i < bArrH.length) {
                int i2 = i + 4;
                iK += K(ks1.b(da.c(bArrH, i, i2)));
                i = i2;
            }
            this.F.n(iK);
            Log.i("WatchTheme3Tools", "4K对齐后文件大小: " + iK + " bytes");
        } else {
            this.F.n(s());
            Log.i("WatchTheme3Tools", "文件大小: " + s() + " bytes");
        }
        if (this.F.g() > 0 || A()) {
            Log.i("WatchTheme3Tools", "开始发送升级指令，文件大小: " + this.F.g() + " bytes");
            Q(xg3Var, list);
        } else {
            Log.e("WatchTheme3Tools", "OTA路径错误，文件大小为0");
            U(1004);
        }
        Log.i("WatchTheme3Tools", "=== 表盘升级流程启动完成 ===");
        Log.i("WatchTheme3Tools", "表盘配置信息: " + xg3Var);
    }

    public void i(a aVar) {
        this.E.add(aVar);
    }

    public int s() {
        return ez.b(this.o);
    }
}
