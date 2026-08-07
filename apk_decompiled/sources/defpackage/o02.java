package defpackage;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.CountDownTimer;
import android.os.HandlerThread;
import com.phy.otalib.model.ConnectState;
import com.phy.otalib.model.OTAType;

/* JADX INFO: loaded from: classes.dex */
public class o02 {
    private String a;
    private String b;
    private int c;
    private long d;
    private boolean e;
    private BluetoothDevice f;
    private BluetoothGatt g;
    private OTAType h;
    private String i;
    private ConnectState j;
    private int k;
    private aj2 l;
    private cj2 m;
    private float n;
    private float o;
    private float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f365q;
    private HandlerThread r;
    private CountDownTimer s;
    private boolean t;

    public o02(ScanResult scanResult) {
        this.a = "Unknown device";
        this.f = scanResult.getDevice();
        ScanRecord scanRecord = scanResult.getScanRecord();
        if (scanRecord != null && scanRecord.getDeviceName() != null && !scanRecord.getDeviceName().isEmpty()) {
            this.a = scanRecord.getDeviceName();
        }
        this.b = this.f.getAddress();
        this.c = scanResult.getRssi();
        this.d = System.currentTimeMillis();
    }

    public void A(long j) {
        this.d = j;
    }

    public void B(String str) {
        this.b = str;
    }

    public void C(CountDownTimer countDownTimer) {
        this.s = countDownTimer;
    }

    public void D(String str) {
        this.i = str;
    }

    public void E(OTAType oTAType) {
        this.h = oTAType;
    }

    public void F(float f) {
        this.p = f;
    }

    public void G(String str) {
        this.a = str;
    }

    public void H(int i) {
        this.c = i;
    }

    public void I(boolean z) {
        this.t = z;
    }

    public void J(boolean z) {
        this.e = z;
    }

    public void K(aj2 aj2Var) {
        this.l = aj2Var;
    }

    public void L(cj2 cj2Var) {
        this.m = cj2Var;
    }

    public void M(HandlerThread handlerThread) {
        this.r = handlerThread;
    }

    public void N(float f) {
        this.n = f;
    }

    public ConnectState a() {
        return this.j;
    }

    public BluetoothDevice b() {
        return this.f;
    }

    public int c() {
        return this.k;
    }

    public float d() {
        return this.o;
    }

    public String e() {
        return this.f365q;
    }

    public BluetoothGatt f() {
        return this.g;
    }

    public long g() {
        return this.d;
    }

    public String h() {
        return this.b;
    }

    public CountDownTimer i() {
        return this.s;
    }

    public String j() {
        return this.i;
    }

    public OTAType k() {
        return this.h;
    }

    public float l() {
        return this.p;
    }

    public String m() {
        return this.a;
    }

    public int n() {
        return this.c;
    }

    public aj2 o() {
        return this.l;
    }

    public cj2 p() {
        return this.m;
    }

    public HandlerThread q() {
        return this.r;
    }

    public float r() {
        return this.n;
    }

    public boolean s() {
        return this.t;
    }

    public boolean t() {
        return this.e;
    }

    public void u(ConnectState connectState) {
        this.j = connectState;
    }

    public void v(BluetoothDevice bluetoothDevice) {
        this.f = bluetoothDevice;
    }

    public void w(int i) {
        this.k = i;
    }

    public void x(float f) {
        this.o = f;
    }

    public void y(String str) {
        this.f365q = str;
    }

    public void z(BluetoothGatt bluetoothGatt) {
        this.g = bluetoothGatt;
    }

    public o02(String str, String str2, int i, long j, BluetoothDevice bluetoothDevice) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = j;
        this.f = bluetoothDevice;
    }
}
