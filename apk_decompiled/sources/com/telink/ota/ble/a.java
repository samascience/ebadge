package com.telink.ota.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import com.telink.ota.fundation.StatusCode;
import defpackage.ab3;
import defpackage.ga;
import defpackage.vx1;
import defpackage.wx1;
import defpackage.xx1;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.telink.ota.ble.c {
    private final wx1 A;
    private final c B;
    private final d C;
    private b D;
    private boolean E;
    private boolean F;
    private int G;
    private xx1 H;

    public interface b {
        void onConnectionStateChange(a aVar, int i);

        void onOtaProgressUpdate(int i);

        void onOtaStateChanged(a aVar, StatusCode statusCode);
    }

    private final class c implements Command.a {
        private c() {
        }

        @Override // com.telink.ota.ble.Command.a
        public void a(com.telink.ota.ble.c cVar, Command command, Object obj) {
            if (a.this.E) {
                if (command.f.equals(4)) {
                    vx1.a("read response: " + ga.a((byte[]) obj, "-"));
                    return;
                }
                if (command.f.equals(5)) {
                    a.this.i0();
                    return;
                }
                if (command.f.equals(7)) {
                    a.this.f0(0);
                    return;
                }
                if (command.f.equals(8)) {
                    a.this.e0();
                    a.this.k0();
                    a.this.a0();
                } else {
                    if (command.f.equals(3)) {
                        a.this.h0();
                        return;
                    }
                    if (command.f.equals(1)) {
                        if (a.this.m0()) {
                            return;
                        }
                        a.this.f0(0);
                    } else if (command.f.equals(2)) {
                        a.this.f0(0);
                    }
                }
            }
        }

        @Override // com.telink.ota.ble.Command.a
        public void b(com.telink.ota.ble.c cVar, Command command, String str) {
            if (a.this.E) {
                vx1.a("error packet : " + command.f + " errorMsg : " + str);
                if (!command.f.equals(8)) {
                    a.this.e0();
                    a.this.b0(StatusCode.FAIL_PACKET_SENT_ERR);
                } else {
                    a.this.e0();
                    a.this.k0();
                    a.this.a0();
                }
            }
        }

        @Override // com.telink.ota.ble.Command.a
        public boolean c(com.telink.ota.ble.c cVar, Command command) {
            if (!a.this.E) {
                return false;
            }
            vx1.a("timeout : " + ga.a(command.e, ":"));
            if (command.f.equals(8)) {
                a.this.e0();
                a.this.k0();
                a.this.a0();
            } else {
                a.this.e0();
                a.this.b0(StatusCode.FAIL_PACKET_SENT_TIMEOUT);
            }
            return false;
        }
    }

    private class d implements Runnable {
        private d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.e0();
            a.this.b0(StatusCode.FAIL_FLOW_TIMEOUT);
        }
    }

    public a(Context context) {
        super(context);
        this.A = new wx1();
        this.B = new c();
        this.C = new d();
        this.E = false;
        this.F = true;
        this.G = 30;
    }

    private UUID W() {
        xx1 xx1Var = this.H;
        return (xx1Var == null || xx1Var.a() == null) ? ab3.b : this.H.a();
    }

    private UUID Y() {
        xx1 xx1Var = this.H;
        return (xx1Var == null || xx1Var.e() == null) ? ab3.a : this.H.e();
    }

    private BluetoothGattService Z(UUID uuid) {
        List<BluetoothGattService> list = this.f312q;
        if (list == null) {
            return null;
        }
        for (BluetoothGattService bluetoothGattService : list) {
            if (bluetoothGattService.getUuid().equals(uuid)) {
                return bluetoothGattService;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        this.E = false;
        this.g.removeCallbacksAndMessages(null);
        this.A.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f0(int i) {
        boolean z = false;
        if (this.A.j()) {
            Command commandA = Command.a();
            commandA.a = Y();
            commandA.b = W();
            commandA.d = Command.CommandType.WRITE_NO_RESPONSE;
            commandA.e = this.A.f();
            if (this.A.l()) {
                commandA.f = 3;
                z = true;
            } else {
                commandA.f = 1;
            }
            commandA.g = i;
            L(this.B, commandA);
            k0();
        }
        return z;
    }

    private void g0() {
        d0();
        Command commandA = Command.a();
        commandA.a = Y();
        commandA.b = W();
        commandA.d = Command.CommandType.WRITE_NO_RESPONSE;
        commandA.f = 5;
        commandA.e = new byte[]{0, -1};
        L(this.B, commandA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        Command commandA = Command.a();
        commandA.a = Y();
        commandA.b = W();
        commandA.d = Command.CommandType.WRITE_NO_RESPONSE;
        commandA.f = 8;
        int iE = this.A.e();
        int i = ~iE;
        byte[] bArr = {2, -1, (byte) (iE & 255), (byte) ((iE >> 8) & 255), (byte) (i & 255), (byte) ((i >> 8) & 255), 0, 0};
        this.A.c(bArr, this.A.b(bArr));
        commandA.e = bArr;
        L(this.B, commandA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        Command commandA = Command.a();
        commandA.a = Y();
        commandA.b = W();
        commandA.d = Command.CommandType.WRITE_NO_RESPONSE;
        commandA.f = 7;
        commandA.e = new byte[]{1, -1};
        L(this.B, commandA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        if (this.A.k()) {
            c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m0() {
        int iD = this.H.d();
        if (iD <= 0) {
            return false;
        }
        int i = iD * 16;
        int iG = this.A.g() * 16;
        vx1.b("ota onCommandSampled byte length : " + iG);
        if (iG <= 0 || iG % i != 0) {
            return false;
        }
        vx1.b("onCommandSampled ota read packet " + this.A.g());
        Command commandA = Command.a();
        commandA.a = Y();
        commandA.b = W();
        commandA.d = Command.CommandType.READ;
        commandA.f = 2;
        L(this.B, commandA);
        return true;
    }

    @Override // com.telink.ota.ble.c
    protected void A() {
        super.A();
        if (this.x.get()) {
            m();
            return;
        }
        if (this.E) {
            b0(StatusCode.FAIL_CONNECTION_INTERRUPT);
        }
        e0();
        b bVar = this.D;
        if (bVar != null) {
            bVar.onConnectionStateChange(this, 0);
        }
    }

    @Override // com.telink.ota.ble.c
    protected void B() {
    }

    @Override // com.telink.ota.ble.c
    protected void C(byte[] bArr, UUID uuid, UUID uuid2, Object obj) {
        super.C(bArr, uuid, uuid2, obj);
    }

    @Override // com.telink.ota.ble.c
    protected void D(List list) {
        super.D(list);
        b bVar = this.D;
        if (bVar != null) {
            bVar.onConnectionStateChange(this, 2);
        }
    }

    public void V(boolean z) {
        this.D = null;
        e0();
        f();
        if (z) {
            u();
        }
    }

    public int X() {
        return this.A.i();
    }

    protected void a0() {
        this.E = false;
        b bVar = this.D;
        if (bVar != null) {
            bVar.onOtaStateChanged(this, StatusCode.SUCCESS);
        }
    }

    protected void b0(StatusCode statusCode) {
        b bVar = this.D;
        if (bVar != null) {
            bVar.onOtaStateChanged(this, statusCode);
        }
    }

    protected void c0() {
        b bVar = this.D;
        if (bVar != null) {
            bVar.onOtaProgressUpdate(X());
        }
    }

    protected void d0() {
        b bVar = this.D;
        if (bVar != null) {
            bVar.onOtaStateChanged(this, StatusCode.STARTED);
        }
    }

    public void j0(b bVar) {
        this.D = bVar;
    }

    public void l0(xx1 xx1Var) {
        if (this.E) {
            b0(StatusCode.BUSY);
            return;
        }
        if (!x()) {
            b0(StatusCode.FAIL_UNCONNECTED);
            return;
        }
        this.H = xx1Var;
        if (n0()) {
            e0();
            this.E = true;
            this.A.m(xx1Var.b());
            this.g.postDelayed(this.C, xx1Var.c());
            g0();
        }
    }

    @Override // com.telink.ota.ble.c
    public void n(BluetoothDevice bluetoothDevice) {
        b bVar = this.D;
        if (bVar != null) {
            bVar.onConnectionStateChange(this, 1);
        }
        super.n(bluetoothDevice);
    }

    public boolean n0() {
        xx1 xx1Var = this.H;
        if (xx1Var == null || xx1Var.b() == null) {
            b0(StatusCode.FAIL_PARAMS_ERR);
            return false;
        }
        BluetoothGattService bluetoothGattServiceZ = Z(Y());
        if (bluetoothGattServiceZ == null) {
            b0(StatusCode.FAIL_SERVICE_NOT_FOUND);
            return false;
        }
        if (bluetoothGattServiceZ.getCharacteristic(W()) != null) {
            return true;
        }
        b0(StatusCode.FAIL_CHARACTERISTIC_NOT_FOUND);
        return false;
    }

    @Override // com.telink.ota.ble.c
    protected void y() {
        super.y();
    }

    @Override // com.telink.ota.ble.c
    protected void z() {
    }
}
