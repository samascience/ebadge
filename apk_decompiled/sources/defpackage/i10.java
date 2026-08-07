package defpackage;

import android.bluetooth.BluetoothGattCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class i10 {
    private b a;
    private yj e;
    private List f;
    private boolean b = true;
    private String c = "7E400001-B5A3-F393-E0A9-E50E24DCCA9D";
    private long d = 30;
    private boolean g = true;
    private boolean h = false;
    private int i = 30;

    public interface a {
    }

    public interface b {
        void a(String str, String str2);
    }

    public i10 a(BluetoothGattCallback bluetoothGattCallback) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        if (bluetoothGattCallback != null && !this.f.contains(bluetoothGattCallback)) {
            this.f.add(bluetoothGattCallback);
        }
        return this;
    }

    public yj b() {
        return this.e;
    }

    public List c() {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        return this.f;
    }

    public b d() {
        return this.a;
    }

    public String e() {
        return this.c;
    }

    public int f() {
        return this.i;
    }

    public a g() {
        return null;
    }

    public long h() {
        return this.d;
    }

    public boolean i() {
        return this.h;
    }

    public boolean j() {
        return this.g;
    }

    public boolean k() {
        return this.b;
    }

    public i10 l(yj yjVar) {
        this.e = yjVar;
        return this;
    }

    public i10 m(b bVar) {
        this.a = bVar;
        return this;
    }

    public i10 n(int i) {
        this.i = i;
        return this;
    }

    public i10 o(boolean z) {
        this.b = z;
        return this;
    }

    public i10 p(int i) {
        this.d = i;
        return this;
    }
}
