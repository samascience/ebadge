package com.beken.beken_ota;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.baji.protocol.model.ProtocolConstants;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.n;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import defpackage.ci0;
import defpackage.dt1;
import defpackage.e40;
import defpackage.fz;
import defpackage.g92;
import defpackage.im0;
import defpackage.pv2;
import defpackage.sm1;
import defpackage.us1;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public abstract class OTAAppFunctionActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String o0 = "OTAAppFunctionActivity";
    private Button F;
    private Button G;
    private dt1 H;
    private com.beken.beken_ota.ble.a I;
    private long P;
    private byte[] S;
    private Thread T;
    private boolean U;
    private int X;
    private String b0;
    private String c0;
    private String e;
    private List e0;
    private String f;
    private File f0;
    private Uri g;
    private TextView g0;
    private us1 i;
    private int j;
    private BluetoothAdapter n0;
    private byte p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f217q;
    private ProgressBar s;
    private ListView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private Button z;
    private final String a = "logo_ota.bin";
    private final String b = "picture_ota.bin";
    private final String c = "program_ota.bin";
    private final String d = "tp_ota.bin";
    private HashMap h = null;
    private boolean k = false;
    private boolean l = false;
    private long m = 0;
    private boolean n = false;
    private boolean o = false;
    private boolean r = false;
    private boolean J = true;
    private long K = 0;
    private long L = 0;
    private long M = 0;
    private byte N = 0;
    private byte O = 0;
    private int Q = 0;
    private byte[] R = new byte[2162688];
    private final Lock V = new ReentrantLock();
    private final Lock W = new ReentrantLock();
    private int Y = 28;
    private Timer Z = null;
    private TimerTask a0 = null;
    private Handler d0 = new a();
    private int h0 = 0;
    private Runnable i0 = new b();
    private Runnable j0 = new c();
    private Runnable k0 = new d();
    boolean l0 = false;
    private final BroadcastReceiver m0 = new e();

    class a extends Handler {

        /* JADX INFO: renamed from: com.beken.beken_ota.OTAAppFunctionActivity$a$a, reason: collision with other inner class name */
        class RunnableC0054a implements Runnable {
            RunnableC0054a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                OTAAppFunctionActivity.this.H.k();
            }
        }

        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1000) {
                ToastUtils.u("超时退出");
                OTAAppFunctionActivity.this.finish();
                return;
            }
            if (i == 1001) {
                ToastUtils.u("单个任务超时退出");
                OTAAppFunctionActivity.this.finish();
                return;
            }
            if (i == 1002) {
                Log.e(OTAAppFunctionActivity.o0, "reconnectting");
                if (!OTAAppFunctionActivity.this.H.n()) {
                    Log.e(OTAAppFunctionActivity.o0, "start connect spp");
                    OTAAppFunctionActivity.this.H.k();
                } else if (OTAAppFunctionActivity.this.H.n() && !OTAAppFunctionActivity.this.U) {
                    Log.e(OTAAppFunctionActivity.o0, "reconnect spp");
                    OTAAppFunctionActivity.this.H.l();
                    OTAAppFunctionActivity.this.d0.postDelayed(new RunnableC0054a(), 3000L);
                }
                OTAAppFunctionActivity.this.d0.sendEmptyMessageDelayed(1002, ProtocolConstants.CONNECTION_TIMEOUT_MS);
            }
        }
    }

    class b implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                OTAAppFunctionActivity.this.y.setText(OTAAppFunctionActivity.this.c0);
                OTAAppFunctionActivity.this.s.setProgress((short) (((OTAAppFunctionActivity.this.P - OTAAppFunctionActivity.this.L) * 100) / (OTAAppFunctionActivity.this.m - OTAAppFunctionActivity.this.L)));
                OTAAppFunctionActivity.this.x.setText(OTAAppFunctionActivity.this.b0);
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (OTAAppFunctionActivity.this.U) {
                int i = OTAAppFunctionActivity.this.X / 1000;
                OTAAppFunctionActivity.this.W.lock();
                if (OTAAppFunctionActivity.this.j != 1) {
                    if (OTAAppFunctionActivity.this.K - OTAAppFunctionActivity.this.P > 500) {
                        OTAAppFunctionActivity.this.P += (OTAAppFunctionActivity.this.K - OTAAppFunctionActivity.this.P) / 5;
                        if (OTAAppFunctionActivity.this.P > OTAAppFunctionActivity.this.K) {
                            OTAAppFunctionActivity oTAAppFunctionActivity = OTAAppFunctionActivity.this;
                            oTAAppFunctionActivity.P = oTAAppFunctionActivity.K;
                        }
                    } else {
                        OTAAppFunctionActivity oTAAppFunctionActivity2 = OTAAppFunctionActivity.this;
                        oTAAppFunctionActivity2.P = oTAAppFunctionActivity2.K;
                    }
                    if (OTAAppFunctionActivity.this.K == OTAAppFunctionActivity.this.m) {
                        OTAAppFunctionActivity.this.P += (OTAAppFunctionActivity.this.K - OTAAppFunctionActivity.this.P) / 2;
                    }
                } else if (OTAAppFunctionActivity.this.K - OTAAppFunctionActivity.this.P > 500) {
                    OTAAppFunctionActivity.this.P += (OTAAppFunctionActivity.this.K - OTAAppFunctionActivity.this.P) / 25;
                    if (OTAAppFunctionActivity.this.P > OTAAppFunctionActivity.this.K) {
                        OTAAppFunctionActivity oTAAppFunctionActivity3 = OTAAppFunctionActivity.this;
                        oTAAppFunctionActivity3.P = oTAAppFunctionActivity3.K;
                    }
                } else {
                    OTAAppFunctionActivity oTAAppFunctionActivity4 = OTAAppFunctionActivity.this;
                    oTAAppFunctionActivity4.P = oTAAppFunctionActivity4.K;
                }
                OTAAppFunctionActivity.this.W.unlock();
                if (i > 0 && OTAAppFunctionActivity.this.K - OTAAppFunctionActivity.this.L > 0) {
                    int i2 = ((int) (OTAAppFunctionActivity.this.K - OTAAppFunctionActivity.this.L)) / (i * 1024);
                    float f = ((OTAAppFunctionActivity.this.m - OTAAppFunctionActivity.this.L) / (OTAAppFunctionActivity.this.P - OTAAppFunctionActivity.this.L)) * i;
                    OTAAppFunctionActivity oTAAppFunctionActivity5 = OTAAppFunctionActivity.this;
                    oTAAppFunctionActivity5.b0 = String.format("Size: %d kB   Time: %d/%d s   Rate: %d kB/s", Integer.valueOf(oTAAppFunctionActivity5.Q), Integer.valueOf(i), Integer.valueOf((int) f), Integer.valueOf(i2));
                    OTAAppFunctionActivity oTAAppFunctionActivity6 = OTAAppFunctionActivity.this;
                    oTAAppFunctionActivity6.c0 = String.format("%.2f %%", Float.valueOf(((oTAAppFunctionActivity6.P - OTAAppFunctionActivity.this.L) / (OTAAppFunctionActivity.this.m - OTAAppFunctionActivity.this.L)) * 100.0f));
                    OTAAppFunctionActivity.this.runOnUiThread(new a());
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (OTAAppFunctionActivity.this.P == OTAAppFunctionActivity.this.m) {
                    if (OTAAppFunctionActivity.this.Z != null) {
                        OTAAppFunctionActivity.this.Z.cancel();
                        OTAAppFunctionActivity.this.Z.purge();
                    }
                    if (OTAAppFunctionActivity.this.a0 != null) {
                        OTAAppFunctionActivity.this.a0.cancel();
                    }
                    OTAAppFunctionActivity.this.a0 = null;
                }
            }
            Log.e(OTAAppFunctionActivity.o0, "done");
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OTAAppFunctionActivity.this.r = false;
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (OTAAppFunctionActivity.this.U) {
                OTAAppFunctionActivity.this.y0();
            }
        }
    }

    class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.bluetooth.device.action.FOUND".equals(action)) {
                "android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action);
                return;
            }
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            short shortExtra = intent.getShortExtra("android.bluetooth.device.extra.RSSI", Short.MIN_VALUE);
            Log.e(OTAAppFunctionActivity.o0, "rssi:" + ((int) shortExtra) + ";" + bluetoothDevice.getAddress());
            String name = bluetoothDevice.getName();
            if (bluetoothDevice.getType() == 2) {
                Log.e(OTAAppFunctionActivity.o0, "ble device:" + bluetoothDevice.toString() + ";name:" + name);
                if (OTAAppFunctionActivity.this.H.n()) {
                    Log.e(OTAAppFunctionActivity.o0, "mOTASPPFunction.isConnected()");
                    if (!OTAAppFunctionActivity.this.U) {
                        OTAAppFunctionActivity.this.H.l();
                        OTAAppFunctionActivity.this.H.k();
                        Log.e(OTAAppFunctionActivity.o0, "reconnect spp");
                    }
                    OTAAppFunctionActivity.this.q0(false);
                    return;
                }
                if (!pv2.b(OTAAppFunctionActivity.this.r0(), bluetoothDevice.getAddress())) {
                    Log.e(OTAAppFunctionActivity.o0, "device no match");
                    return;
                }
                OTAAppFunctionActivity oTAAppFunctionActivity = OTAAppFunctionActivity.this;
                if (oTAAppFunctionActivity.l0) {
                    return;
                }
                oTAAppFunctionActivity.l0 = true;
                sm1.d().b(bluetoothDevice.getAddress(), new sm1.b() { // from class: com.beken.beken_ota.a
                });
                OTAAppFunctionActivity.this.q0(false);
            }
        }
    }

    class f implements AdapterView.OnItemClickListener {
        f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            OTAAppFunctionActivity.this.w.setText(Constants.STR_EMPTY);
            OTAAppFunctionActivity.this.i.b();
            OTAAppFunctionActivity.this.i.notifyDataSetChanged();
            CheckBox checkBox = (CheckBox) view.getTag();
            checkBox.toggle();
            us1 unused = OTAAppFunctionActivity.this.i;
            us1.e.put(Integer.valueOf(i), Boolean.valueOf(checkBox.isChecked()));
            String str = im0.b() + WatchConstant.FAT_FS_ROOT + OTAAppFunctionActivity.this.i.a();
            if (checkBox.isChecked()) {
                OTAAppFunctionActivity.this.g = Uri.fromFile(new File(str));
                OTAAppFunctionActivity.this.w.setText(str);
            }
        }
    }

    private class g extends TimerTask {
        private g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            OTAAppFunctionActivity.f0(OTAAppFunctionActivity.this, 1000);
        }

        /* synthetic */ g(OTAAppFunctionActivity oTAAppFunctionActivity, a aVar) {
            this();
        }
    }

    private void A0(byte[] bArr) {
        this.W.lock();
        this.P = this.m;
        this.W.unlock();
        if (bArr[0] != 8 || bArr[1] != this.N - 1 || bArr[2] != 1 || bArr[3] != 0) {
            ToastUtils.s("OTA Fail and click to exit");
            Log.e(o0, "error data 3");
            return;
        }
        Log.e(o0, "recv ota done result " + ((int) bArr[4]));
        this.U = false;
        this.y.setText("100%");
        this.s.setProgress(100);
        this.e0.remove(this.f0);
        this.g0.setText((this.h0 - fz.c(this.e0)) + WatchConstant.FAT_FS_ROOT + this.h0);
        o0(11);
        if (!fz.a(this.e0)) {
            M0();
            return;
        }
        ToastUtils.s("OTA success and click to exit");
        o0(11);
        finish();
    }

    private void B0(byte[] bArr) {
        String str = o0;
        Log.e(str, "recvResendBlock");
        if (bArr[0] == 6 && bArr[2] == 4 && bArr[3] == 0) {
            byte b2 = bArr[1];
            long jF = e40.f(bArr[7], bArr[6], bArr[5], bArr[4]);
            if (b2 == this.p || jF == this.f217q) {
                this.r = true;
                this.d0.removeCallbacks(this.j0);
                this.d0.postDelayed(this.j0, 7000L);
                return;
            }
            this.V.lock();
            this.k = true;
            this.N = bArr[1];
            long jF2 = e40.f(bArr[7], bArr[6], bArr[5], bArr[4]);
            this.K = jF2;
            this.p = this.N;
            this.f217q = jF2;
            this.V.unlock();
            Log.e(str, "spp new index " + this.K + " " + ((int) this.N));
            if (this.j == 2) {
                this.H.m();
            }
            this.r = false;
        }
    }

    private void C0(byte[] bArr) {
        String str = o0;
        Log.e(str, "recvUpdataBlockLength");
        if (bArr[0] != 9 || bArr[2] != 2 || bArr[3] != 0) {
            Log.e(str, "error data 4");
            return;
        }
        if (this.j == 1) {
            long jE = e40.e(bArr[5], bArr[4]);
            int i = this.Y;
            if (jE < i && i > 0) {
                this.M = jE;
            }
        } else {
            this.M = e40.e(bArr[5], bArr[4]);
        }
        this.O = bArr[1];
        this.o = true;
        EventBus.getDefault().post(new ci0(103));
    }

    private void D0(byte[] bArr) {
        StringBuilder sb = new StringBuilder(11);
        for (int i = 0; i < 11; i++) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i])));
        }
        String str = o0;
        Log.e(str, sb.toString());
        if (bArr[0] != 2 || bArr[1] != this.N - 1 || bArr[2] != 7 || bArr[3] != 0) {
            Log.e(str, "error data 1");
            return;
        }
        byte b2 = bArr[10];
        if (b2 == 1) {
            this.J = true;
            EventBus.getDefault().post(new ci0(101));
        } else if (b2 == 2) {
            this.J = false;
            EventBus.getDefault().post(new ci0(101));
            F0(g92.a());
            finish();
        }
    }

    private boolean F0(byte[] bArr) {
        if (this.j == 2) {
            try {
                Thread.sleep(0L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (this.H.q(bArr)) {
                this.V.lock();
                if (bArr[0] != 10) {
                    this.N = (byte) (this.N + 1);
                }
                this.V.unlock();
                return true;
            }
            if (this.l) {
                this.l = false;
            }
        } else if (this.r && !this.o) {
            Log.e(o0, "pass this one");
        } else {
            if (this.I.l(bArr)) {
                this.V.lock();
                if (bArr[0] != 10) {
                    this.N = (byte) (this.N + 1);
                }
                this.V.unlock();
                Log.e(o0, "write success");
                return true;
            }
            if (this.l) {
                this.l = false;
            }
            try {
                Thread.sleep(5L);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
        return false;
    }

    private void G0() {
        F0(new byte[]{1, this.N, 0, 0});
    }

    private void H0() {
        this.Z = new Timer();
        g gVar = new g(this, null);
        this.a0 = gVar;
        this.Z.scheduleAtFixedRate(gVar, 0L, 1000L);
        new Thread(this.i0).start();
        Thread thread = new Thread(this.k0);
        this.T = thread;
        thread.start();
    }

    private void I0() {
        String str = o0;
        Log.e(str, "send done result");
        if (F0(new byte[]{7, this.N, 0, 0})) {
            Log.e(str, "okokokokokoko");
        }
    }

    private void J0() {
        byte[] bArr = new byte[36];
        byte[] bArr2 = new byte[32];
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(this.g);
            if (inputStreamOpenInputStream.available() <= 32) {
                inputStreamOpenInputStream.close();
                Log.e(o0, "wrong data");
                return;
            }
            inputStreamOpenInputStream.read(bArr2, 0, 32);
            inputStreamOpenInputStream.close();
            System.arraycopy(bArr2, 0, bArr, 4, 32);
            bArr[0] = 3;
            bArr[1] = this.N;
            bArr[2] = 32;
            bArr[3] = 0;
            F0(bArr);
        } catch (IOException e2) {
            Log.e(o0, e2.toString());
        }
    }

    private void K0() {
        F0(new byte[]{AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS, this.N, 0, 0});
    }

    private void L0() {
        String str = o0;
        Log.e(str, "sendUpdataBlockLength");
        if (this.T.isAlive()) {
            return;
        }
        Log.e(str, "mThread not alive");
        if (F0(new byte[]{10, this.O, 0, 0})) {
            this.o = false;
            Log.e(str, "send 0x0a success");
        } else {
            Log.e(str, "send 0x0a fail");
            EventBus.getDefault().post(new ci0(103));
        }
    }

    private boolean M0() {
        for (File file : this.e0) {
            if (pv2.b(file.getName(), "program_ota.bin")) {
                this.f0 = file;
                this.g = n.b(file);
                return false;
            }
        }
        for (File file2 : this.e0) {
            if (pv2.b(file2.getName(), "picture_ota.bin")) {
                this.f0 = file2;
                this.g = n.b(file2);
                return false;
            }
        }
        for (File file3 : this.e0) {
            if (pv2.b(file3.getName(), "tp_ota.bin")) {
                this.f0 = file3;
                this.g = n.b(file3);
                return false;
            }
        }
        for (File file4 : this.e0) {
            if (pv2.b(file4.getName(), "logo_ota.bin")) {
                this.f0 = file4;
                this.g = n.b(file4);
                return false;
            }
        }
        return true;
    }

    private void N0() {
        this.n = false;
        w0();
        O0();
        this.z.setEnabled(false);
        this.w.setText(this.g.getPath());
    }

    private void O0() {
        if (this.j == 1) {
            this.I.m(512);
        } else {
            o0(1);
            Log.e(o0, "start ota");
        }
    }

    static /* synthetic */ int f0(OTAAppFunctionActivity oTAAppFunctionActivity, int i) {
        int i2 = oTAAppFunctionActivity.X + i;
        oTAAppFunctionActivity.X = i2;
        return i2;
    }

    private void m0() {
        new File(im0.c());
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        if (getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
            startActivityForResult(intent, 2);
        } else {
            Toast.makeText(this, "install a app first", 0).show();
        }
    }

    private void n0(byte[] bArr) {
        byte b2 = bArr[0];
        if (b2 == 2) {
            D0(bArr);
            return;
        }
        if (b2 == 4) {
            z0(bArr);
            return;
        }
        if (b2 == 6) {
            B0(bArr);
        } else if (b2 == 8) {
            A0(bArr);
        } else {
            if (b2 != 9) {
                return;
            }
            C0(bArr);
        }
    }

    private void o0(int i) {
        if (i == 1) {
            G0();
            return;
        }
        if (i == 3) {
            J0();
            return;
        }
        if (i == 5) {
            H0();
            return;
        }
        if (i == 7) {
            I0();
            return;
        }
        if (i == 10) {
            L0();
        } else if (i != 11) {
            Log.e(o0, "recevice wrong cmdIndex");
        } else {
            K0();
        }
    }

    private static IntentFilter p0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        return intentFilter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(DialogInterface dialogInterface, int i) {
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0() {
        ToastUtils.u("file is empty");
        finish();
    }

    private boolean w0() {
        if (this.g != null) {
            try {
                InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(this.g);
                byte[] bArr = new byte[2162688];
                this.R = bArr;
                inputStreamOpenInputStream.read(bArr, 0, bArr.length);
                inputStreamOpenInputStream.close();
                StringBuilder sb = new StringBuilder(8);
                for (int i = 0; i < 8; i++) {
                    sb.append(String.format("%02X", Byte.valueOf(this.R[i])));
                }
                Log.e(o0, sb.toString());
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    private void x0() {
        this.h = new HashMap();
        File file = new File(im0.b());
        if (file.listFiles() != null) {
            int length = file.listFiles().length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                File file2 = file.listFiles()[i2];
                im0 im0Var = new im0(file2.toString(), file2.getName());
                if (im0Var.a().endsWith(".bin")) {
                    this.h.put(Integer.valueOf(i), im0Var);
                    i++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        if (this.U) {
            if (this.o) {
                if (!F0(new byte[]{10, this.O, 0, 0})) {
                    Log.e(o0, "thread send 0x0a fail");
                    return;
                } else {
                    this.o = false;
                    Log.e(o0, "thread send 0x0a success");
                    return;
                }
            }
            long j = this.K;
            long j2 = this.m;
            if (j >= j2) {
                if (this.l) {
                    return;
                }
                this.l = true;
                Log.e(o0, "send to over");
                o0(7);
                return;
            }
            long j3 = this.M;
            int i = ((int) j3) + 8;
            long j4 = 4 + j3;
            this.l = false;
            if (j2 - j < j3) {
                i = ((int) (j2 - j)) + 8;
                j4 = ((int) (j2 - j)) + 4;
            }
            byte[] bArr = new byte[i];
            this.S = bArr;
            int i2 = i - 8;
            System.arraycopy(this.R, (int) j, bArr, 8, i2);
            byte[] bArr2 = this.S;
            bArr2[0] = 5;
            bArr2[1] = this.N;
            bArr2[2] = e40.h(j4);
            this.S[3] = e40.g(j4);
            this.S[4] = e40.a(this.K);
            this.S[5] = e40.b(this.K);
            this.S[6] = e40.c(this.K);
            this.S[7] = e40.d(this.K);
            if (F0(this.S)) {
                this.V.lock();
                if (this.k) {
                    this.k = false;
                } else {
                    this.K += (long) i2;
                }
                this.V.unlock();
                Log.e(o0, "index " + this.K + " " + this.m);
            }
        }
    }

    private void z0(byte[] bArr) {
        StringBuilder sb = new StringBuilder(15);
        for (int i = 0; i < 15; i++) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i])));
        }
        String str = o0;
        Log.e(str, "frameSeq is " + ((int) this.N));
        Log.e(str, sb.toString());
        if (bArr[0] == 4 && bArr[1] == this.N - 1 && bArr[2] == 11 && bArr[3] == 0) {
            if (bArr[4] != 1) {
                if (this.j == 1) {
                    long jE = e40.e(bArr[14], bArr[13]);
                    Log.e(str, "recv data size " + Long.valueOf(jE) + " " + this.Y);
                    int i2 = this.Y;
                    if (jE < i2 && i2 > 0) {
                        this.M = jE;
                    }
                } else {
                    this.M = e40.e(bArr[14], bArr[13]);
                }
                long jF = e40.f(bArr[8], bArr[7], bArr[6], bArr[5]);
                this.K = jF;
                this.L = jF;
                this.P = jF;
                long jF2 = e40.f(bArr[12], bArr[11], bArr[10], bArr[9]);
                this.Q = ((int) jF2) / 1024;
                this.m = jF2 + this.K;
                Log.e(str, "show data new " + this.M + " " + this.K + " " + this.m);
                EventBus.getDefault().post(new ci0(102));
                return;
            }
            Toast.makeText(this, "can not update", 0).show();
        }
        Log.e(str, "error data 2");
    }

    public void E0() {
        this.x.setText("idle");
        this.s.setProgress(0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2 && i2 == -1) {
            Uri data = intent.getData();
            this.g = data;
            this.w.setText(data.getPath());
            Log.e(o0, this.g.getPath());
            n.e(intent.getData());
            us1 us1Var = this.i;
            if (us1Var != null) {
                us1Var.b();
                this.i.notifyDataSetChanged();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (fz.a(this.e0)) {
            super.onBackPressed();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R$string.warn));
        builder.setMessage(getString(R$string.upgradding_content));
        builder.setNeutralButton(getString(R$string.cancel_txt), (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(getString(R$string.exit), new DialogInterface.OnClickListener() { // from class: ps1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.u0(dialogInterface, i);
            }
        });
        builder.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.button_ota_files) {
            m0();
            return;
        }
        if (id == R$id.button_start_ota) {
            N0();
        } else if (id == R$id.button_stop_ota) {
            this.U = false;
            this.z.setEnabled(true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_muilt_ota);
        Intent intent = getIntent();
        this.f = s0();
        this.e = intent.getStringExtra("DEVICE_NAME");
        this.j = 2;
        Log.e(o0, "the ota type " + this.j);
        x0();
        this.v = (TextView) findViewById(R$id.ota_activity_device_name_value);
        this.u = (TextView) findViewById(R$id.ota_activity_device_address_value);
        this.w = (TextView) findViewById(R$id.ota_activity_filepath);
        this.x = (TextView) findViewById(R$id.ota_activity_update_info);
        this.s = (ProgressBar) findViewById(R$id.ota_activity_update_progress);
        this.G = (Button) findViewById(R$id.button_ota_files);
        this.z = (Button) findViewById(R$id.button_start_ota);
        this.F = (Button) findViewById(R$id.button_stop_ota);
        this.t = (ListView) findViewById(R$id.ota_activity_bin_files_listview);
        this.y = (TextView) findViewById(R$id.textview_progress_value);
        this.g0 = (TextView) findViewById(R$id.tv_total_progress);
        this.z.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.z.setEnabled(false);
        String str = this.e;
        if (str != null) {
            this.v.setText(str);
        }
        String str2 = this.f;
        if (str2 != null) {
            this.u.setText(str2);
        }
        us1 us1Var = new us1(this, this.h);
        this.i = us1Var;
        this.t.setAdapter((ListAdapter) us1Var);
        this.t.setOnItemClickListener(new f());
        getWindow().addFlags(128);
        EventBus.getDefault().register(this);
        this.e0 = t0();
        this.h0 = fz.c(t0());
        if (M0()) {
            this.d0.postDelayed(new Runnable() { // from class: qs1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.v0();
                }
            }, 500L);
        } else {
            this.g0.setText("0/" + this.h0);
            this.w.setText(this.g.getPath());
            dt1 dt1Var = new dt1(this, s0());
            this.H = dt1Var;
            dt1Var.k();
            E0();
            this.n0 = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
            registerReceiver(this.m0, p0());
        }
        this.d0.sendEmptyMessageDelayed(1002, 20000L);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        sm1.d().e();
        unregisterReceiver(this.m0);
        this.d0.removeMessages(1000);
        this.d0.removeMessages(1001);
        this.d0.removeMessages(1002);
        this.U = false;
        com.beken.beken_ota.ble.a aVar = this.I;
        if (aVar != null) {
            aVar.k();
            this.I = null;
        }
        dt1 dt1Var = this.H;
        if (dt1Var != null) {
            dt1Var.p();
            this.H = null;
        }
        System.gc();
        Log.e(o0, "call onDestroy");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ci0 ci0Var) {
        int iB = ci0Var.b();
        if (iB == 401) {
            if (this.I != null) {
                this.z.setEnabled(true);
                this.U = true;
            }
            return;
        }
        switch (iB) {
            case 101:
                o0(3);
                break;
            case 102:
                o0(5);
                break;
            case 103:
                o0(10);
                break;
            case 104:
                o0(7);
                break;
            default:
                switch (iB) {
                    case 201:
                        ToastUtils.s("已连接");
                        this.d0.removeMessages(1000);
                        dt1 dt1Var = this.H;
                        if (dt1Var == null) {
                            Log.e(o0, "mOTASPPFunction is null");
                        } else if (!dt1Var.r()) {
                            this.H.l();
                            finish();
                        } else {
                            this.z.setEnabled(true);
                            this.U = true;
                            N0();
                        }
                        break;
                    case 202:
                        this.U = false;
                        if (!this.n) {
                            setResult(202);
                            ToastUtils.s("已断开");
                        }
                        break;
                    case 203:
                        Log.e(o0, "recv data");
                        n0(ci0Var.a());
                        break;
                    default:
                        switch (iB) {
                            case 403:
                                Log.e(o0, "ble recv data");
                                n0(ci0Var.a());
                                break;
                            case 404:
                                this.U = false;
                                if (!this.n) {
                                    setResult(404);
                                    finish();
                                }
                                break;
                            case 405:
                                if (ci0Var.c() > 0) {
                                    int iC = ci0Var.c() - 11;
                                    this.Y = iC;
                                    this.M = iC;
                                    Log.e(o0, "change mut " + this.Y);
                                }
                                o0(1);
                                break;
                        }
                        break;
                }
                break;
        }
    }

    protected abstract String r0();

    protected abstract String s0();

    protected abstract List t0();
}
