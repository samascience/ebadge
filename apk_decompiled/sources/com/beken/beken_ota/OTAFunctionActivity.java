package com.beken.beken_ota;

import android.R;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.ContextThemeWrapper;
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
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import defpackage.ci0;
import defpackage.dt1;
import defpackage.e40;
import defpackage.im0;
import defpackage.us1;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class OTAFunctionActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String d0 = "OTAFunctionActivity";
    private long L;
    private byte[] O;
    private Thread P;
    private boolean Q;
    private int T;
    private String X;
    private String Y;
    private String a;
    private String b;
    private Uri c;
    private us1 e;
    private int f;
    private byte l;
    private long m;
    private ProgressBar o;
    private ListView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f218q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private Button v;
    private Button w;
    private Button x;
    private dt1 y;
    private com.beken.beken_ota.ble.a z;
    private HashMap d = null;
    private boolean g = false;
    private boolean h = false;
    private long i = 0;
    private boolean j = false;
    private boolean k = false;
    private boolean n = false;
    private boolean F = true;
    private long G = 0;
    private long H = 0;
    private long I = 0;
    private byte J = 0;
    private byte K = 0;
    private int M = 0;
    private byte[] N = new byte[2162688];
    private final Lock R = new ReentrantLock();
    private final Lock S = new ReentrantLock();
    private int U = 28;
    private Timer V = null;
    private TimerTask W = null;
    private Handler Z = new Handler();
    private Runnable a0 = new a();
    private Runnable b0 = new b();
    private Runnable c0 = new c();

    class a implements Runnable {

        /* JADX INFO: renamed from: com.beken.beken_ota.OTAFunctionActivity$a$a, reason: collision with other inner class name */
        class RunnableC0055a implements Runnable {
            RunnableC0055a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                OTAFunctionActivity.this.u.setText(OTAFunctionActivity.this.Y);
                OTAFunctionActivity.this.o.setProgress((short) (((OTAFunctionActivity.this.L - OTAFunctionActivity.this.H) * 100) / (OTAFunctionActivity.this.i - OTAFunctionActivity.this.H)));
                OTAFunctionActivity.this.t.setText(OTAFunctionActivity.this.X);
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (OTAFunctionActivity.this.Q) {
                int i = OTAFunctionActivity.this.T / 1000;
                OTAFunctionActivity.this.S.lock();
                if (OTAFunctionActivity.this.f != 1) {
                    if (OTAFunctionActivity.this.G - OTAFunctionActivity.this.L > 500) {
                        OTAFunctionActivity.this.L += (OTAFunctionActivity.this.G - OTAFunctionActivity.this.L) / 5;
                        if (OTAFunctionActivity.this.L > OTAFunctionActivity.this.G) {
                            OTAFunctionActivity oTAFunctionActivity = OTAFunctionActivity.this;
                            oTAFunctionActivity.L = oTAFunctionActivity.G;
                        }
                    } else {
                        OTAFunctionActivity oTAFunctionActivity2 = OTAFunctionActivity.this;
                        oTAFunctionActivity2.L = oTAFunctionActivity2.G;
                    }
                    if (OTAFunctionActivity.this.G == OTAFunctionActivity.this.i) {
                        OTAFunctionActivity.this.L += (OTAFunctionActivity.this.G - OTAFunctionActivity.this.L) / 2;
                    }
                } else if (OTAFunctionActivity.this.G - OTAFunctionActivity.this.L > 500) {
                    OTAFunctionActivity.this.L += (OTAFunctionActivity.this.G - OTAFunctionActivity.this.L) / 25;
                    if (OTAFunctionActivity.this.L > OTAFunctionActivity.this.G) {
                        OTAFunctionActivity oTAFunctionActivity3 = OTAFunctionActivity.this;
                        oTAFunctionActivity3.L = oTAFunctionActivity3.G;
                    }
                } else {
                    OTAFunctionActivity oTAFunctionActivity4 = OTAFunctionActivity.this;
                    oTAFunctionActivity4.L = oTAFunctionActivity4.G;
                }
                OTAFunctionActivity.this.S.unlock();
                if (i > 0 && OTAFunctionActivity.this.G - OTAFunctionActivity.this.H > 0) {
                    int i2 = ((int) (OTAFunctionActivity.this.G - OTAFunctionActivity.this.H)) / (i * 1024);
                    float f = ((OTAFunctionActivity.this.i - OTAFunctionActivity.this.H) / (OTAFunctionActivity.this.L - OTAFunctionActivity.this.H)) * i;
                    OTAFunctionActivity oTAFunctionActivity5 = OTAFunctionActivity.this;
                    oTAFunctionActivity5.X = String.format("Size: %d kB   Time: %d/%d s   Rate: %d kB/s", Integer.valueOf(oTAFunctionActivity5.M), Integer.valueOf(i), Integer.valueOf((int) f), Integer.valueOf(i2));
                    OTAFunctionActivity oTAFunctionActivity6 = OTAFunctionActivity.this;
                    oTAFunctionActivity6.Y = String.format("%.2f %%", Float.valueOf(((oTAFunctionActivity6.L - OTAFunctionActivity.this.H) / (OTAFunctionActivity.this.i - OTAFunctionActivity.this.H)) * 100.0f));
                    OTAFunctionActivity.this.runOnUiThread(new RunnableC0055a());
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (OTAFunctionActivity.this.L == OTAFunctionActivity.this.i) {
                    if (OTAFunctionActivity.this.V != null) {
                        OTAFunctionActivity.this.V.cancel();
                        OTAFunctionActivity.this.V.purge();
                    }
                    if (OTAFunctionActivity.this.W != null) {
                        OTAFunctionActivity.this.W.cancel();
                    }
                    OTAFunctionActivity.this.W = null;
                }
            }
            Log.e(OTAFunctionActivity.d0, "done");
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OTAFunctionActivity.this.n = false;
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (OTAFunctionActivity.this.Q) {
                OTAFunctionActivity.this.m0();
            }
        }
    }

    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            OTAFunctionActivity.this.s.setText(Constants.STR_EMPTY);
            OTAFunctionActivity.this.e.b();
            OTAFunctionActivity.this.e.notifyDataSetChanged();
            CheckBox checkBox = (CheckBox) view.getTag();
            checkBox.toggle();
            us1 unused = OTAFunctionActivity.this.e;
            us1.e.put(Integer.valueOf(i), Boolean.valueOf(checkBox.isChecked()));
            String str = im0.b() + WatchConstant.FAT_FS_ROOT + OTAFunctionActivity.this.e.a();
            if (checkBox.isChecked()) {
                OTAFunctionActivity.this.c = Uri.fromFile(new File(str));
                OTAFunctionActivity.this.s.setText(str);
            }
        }
    }

    class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            OTAFunctionActivity.this.finish();
        }
    }

    class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            OTAFunctionActivity.this.finish();
        }
    }

    class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            OTAFunctionActivity.this.finish();
        }
    }

    private class h extends TimerTask {
        private h() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            OTAFunctionActivity.H(OTAFunctionActivity.this, 1000);
        }

        /* synthetic */ h(OTAFunctionActivity oTAFunctionActivity, a aVar) {
            this();
        }
    }

    private void A0() {
        if (this.f == 1) {
            this.z.m(512);
        } else {
            j0(1);
        }
    }

    static /* synthetic */ int H(OTAFunctionActivity oTAFunctionActivity, int i) {
        int i2 = oTAFunctionActivity.T + i;
        oTAFunctionActivity.T = i2;
        return i2;
    }

    private void h0() {
        new File(im0.c());
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        if (getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
            startActivityForResult(intent, 2);
        } else {
            Toast.makeText(this, "install a app first", 0).show();
        }
    }

    private void i0(byte[] bArr) {
        byte b2 = bArr[0];
        if (b2 == 2) {
            r0(bArr);
            return;
        }
        if (b2 == 4) {
            n0(bArr);
            return;
        }
        if (b2 == 6) {
            p0(bArr);
        } else if (b2 == 8) {
            o0(bArr);
        } else {
            if (b2 != 9) {
                return;
            }
            q0(bArr);
        }
    }

    private void j0(int i) {
        if (i == 1) {
            u0();
            return;
        }
        if (i == 3) {
            x0();
            return;
        }
        if (i == 5) {
            v0();
            return;
        }
        if (i == 7) {
            w0();
            return;
        }
        if (i == 10) {
            z0();
        } else if (i != 11) {
            Log.e(d0, "recevice wrong cmdIndex");
        } else {
            y0();
        }
    }

    private boolean k0() {
        if (this.c != null) {
            try {
                InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(this.c);
                byte[] bArr = new byte[2162688];
                this.N = bArr;
                inputStreamOpenInputStream.read(bArr, 0, bArr.length);
                inputStreamOpenInputStream.close();
                StringBuilder sb = new StringBuilder(8);
                for (int i = 0; i < 8; i++) {
                    sb.append(String.format("%02X", Byte.valueOf(this.N[i])));
                }
                Log.e(d0, sb.toString());
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    private void l0() {
        this.d = new HashMap();
        File file = new File(im0.b());
        if (file.listFiles() != null) {
            int length = file.listFiles().length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                File file2 = file.listFiles()[i2];
                im0 im0Var = new im0(file2.toString(), file2.getName());
                if (im0Var.a().endsWith(".bin")) {
                    this.d.put(Integer.valueOf(i), im0Var);
                    i++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        if (this.Q) {
            if (this.k) {
                if (!t0(new byte[]{10, this.K, 0, 0})) {
                    Log.e(d0, "thread send 0x0a fail");
                    return;
                } else {
                    this.k = false;
                    Log.e(d0, "thread send 0x0a success");
                    return;
                }
            }
            long j = this.G;
            long j2 = this.i;
            if (j >= j2) {
                if (this.h) {
                    return;
                }
                this.h = true;
                Log.e(d0, "send to over");
                j0(7);
                return;
            }
            long j3 = this.I;
            int i = ((int) j3) + 8;
            long j4 = 4 + j3;
            this.h = false;
            if (j2 - j < j3) {
                i = ((int) (j2 - j)) + 8;
                j4 = ((int) (j2 - j)) + 4;
            }
            byte[] bArr = new byte[i];
            this.O = bArr;
            int i2 = i - 8;
            System.arraycopy(this.N, (int) j, bArr, 8, i2);
            byte[] bArr2 = this.O;
            bArr2[0] = 5;
            bArr2[1] = this.J;
            bArr2[2] = e40.h(j4);
            this.O[3] = e40.g(j4);
            this.O[4] = e40.a(this.G);
            this.O[5] = e40.b(this.G);
            this.O[6] = e40.c(this.G);
            this.O[7] = e40.d(this.G);
            if (t0(this.O)) {
                this.R.lock();
                if (this.g) {
                    this.g = false;
                } else {
                    this.G += (long) i2;
                }
                this.R.unlock();
                Log.e(d0, "index " + this.G + " " + this.i);
            }
        }
    }

    private void n0(byte[] bArr) {
        StringBuilder sb = new StringBuilder(15);
        for (int i = 0; i < 15; i++) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i])));
        }
        String str = d0;
        Log.e(str, "frameSeq is " + ((int) this.J));
        Log.e(str, sb.toString());
        if (bArr[0] == 4 && bArr[1] == this.J - 1 && bArr[2] == 11 && bArr[3] == 0) {
            if (bArr[4] != 1) {
                if (this.f == 1) {
                    long jE = e40.e(bArr[14], bArr[13]);
                    Log.e(str, "recv data size " + Long.valueOf(jE) + " " + this.U);
                    int i2 = this.U;
                    if (jE < i2 && i2 > 0) {
                        this.I = jE;
                    }
                } else {
                    this.I = e40.e(bArr[14], bArr[13]);
                }
                long jF = e40.f(bArr[8], bArr[7], bArr[6], bArr[5]);
                this.G = jF;
                this.H = jF;
                this.L = jF;
                long jF2 = e40.f(bArr[12], bArr[11], bArr[10], bArr[9]);
                this.M = ((int) jF2) / 1024;
                this.i = jF2 + this.G;
                Log.e(str, "show data new " + this.I + " " + this.G + " " + this.i);
                EventBus.getDefault().post(new ci0(102));
                return;
            }
            Toast.makeText(this, "can not update", 0).show();
        }
        Log.e(str, "error data 2");
    }

    private void o0(byte[] bArr) {
        this.S.lock();
        this.L = this.i;
        this.S.unlock();
        if (bArr[0] != 8 || bArr[1] != this.J - 1 || bArr[2] != 1 || bArr[3] != 0) {
            new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.Theme.Holo.Dialog)).setTitle("FAIL").setMessage("OTA Fail and click to exit").setPositiveButton("ok", new g()).show();
            j0(11);
            Log.e(d0, "error data 3");
            return;
        }
        Log.e(d0, "recv ota done result " + ((int) bArr[4]));
        this.Q = false;
        this.u.setText("100%");
        this.o.setProgress(100);
        if (bArr[4] == 1) {
            new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.Theme.Holo.Dialog)).setTitle("FAIL").setMessage("OTA fail and click to exit").setPositiveButton("ok", new e()).show();
        } else {
            this.j = true;
            new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.Theme.Holo.Dialog)).setTitle("SUCCESS").setMessage("OTA success and click to exit").setPositiveButton("ok", new f()).show();
        }
        j0(11);
    }

    private void p0(byte[] bArr) {
        String str = d0;
        Log.e(str, "recvResendBlock");
        if (bArr[0] == 6 && bArr[2] == 4 && bArr[3] == 0) {
            byte b2 = bArr[1];
            long jF = e40.f(bArr[7], bArr[6], bArr[5], bArr[4]);
            if (b2 == this.l || jF == this.m) {
                this.n = true;
                this.Z.removeCallbacks(this.b0);
                this.Z.postDelayed(this.b0, 7000L);
                return;
            }
            this.R.lock();
            this.g = true;
            this.J = bArr[1];
            long jF2 = e40.f(bArr[7], bArr[6], bArr[5], bArr[4]);
            this.G = jF2;
            this.l = this.J;
            this.m = jF2;
            this.R.unlock();
            Log.e(str, "spp new index " + this.G + " " + ((int) this.J));
            if (this.f == 2) {
                this.y.m();
            }
            this.n = false;
        }
    }

    private void q0(byte[] bArr) {
        String str = d0;
        Log.e(str, "recvUpdataBlockLength");
        if (bArr[0] != 9 || bArr[2] != 2 || bArr[3] != 0) {
            Log.e(str, "error data 4");
            return;
        }
        if (this.f == 1) {
            long jE = e40.e(bArr[5], bArr[4]);
            int i = this.U;
            if (jE < i && i > 0) {
                this.I = jE;
            }
        } else {
            this.I = e40.e(bArr[5], bArr[4]);
        }
        this.K = bArr[1];
        this.k = true;
        EventBus.getDefault().post(new ci0(103));
    }

    private void r0(byte[] bArr) {
        StringBuilder sb = new StringBuilder(11);
        for (int i = 0; i < 11; i++) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i])));
        }
        String str = d0;
        Log.e(str, sb.toString());
        if (bArr[0] != 2 || bArr[1] != this.J - 1 || bArr[2] != 7 || bArr[3] != 0) {
            Log.e(str, "error data 1");
            return;
        }
        byte b2 = bArr[10];
        if (b2 == 1) {
            this.F = true;
            EventBus.getDefault().post(new ci0(101));
        } else if (b2 == 2) {
            this.F = false;
            EventBus.getDefault().post(new ci0(101));
        }
    }

    private boolean t0(byte[] bArr) {
        if (this.f == 2) {
            try {
                Thread.sleep(0L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (this.y.q(bArr)) {
                this.R.lock();
                if (bArr[0] != 10) {
                    this.J = (byte) (this.J + 1);
                }
                this.R.unlock();
                return true;
            }
            if (this.h) {
                this.h = false;
            }
        } else if (this.n && !this.k) {
            Log.e(d0, "pass this one");
        } else {
            if (this.z.l(bArr)) {
                this.R.lock();
                if (bArr[0] != 10) {
                    this.J = (byte) (this.J + 1);
                }
                this.R.unlock();
                Log.e(d0, "write success");
                return true;
            }
            if (this.h) {
                this.h = false;
            }
            try {
                Thread.sleep(5L);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
        return false;
    }

    private void u0() {
        t0(new byte[]{1, this.J, 0, 0});
    }

    private void v0() {
        this.V = new Timer();
        h hVar = new h(this, null);
        this.W = hVar;
        this.V.scheduleAtFixedRate(hVar, 0L, 1000L);
        new Thread(this.a0).start();
        Thread thread = new Thread(this.c0);
        this.P = thread;
        thread.start();
    }

    private void w0() {
        String str = d0;
        Log.e(str, "send done result");
        if (t0(new byte[]{7, this.J, 0, 0})) {
            Log.e(str, "okokokokokoko");
        }
    }

    private void x0() {
        byte[] bArr = new byte[36];
        byte[] bArr2 = new byte[32];
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(this.c);
            if (inputStreamOpenInputStream.available() <= 32) {
                inputStreamOpenInputStream.close();
                Log.e(d0, "wrong data");
                return;
            }
            inputStreamOpenInputStream.read(bArr2, 0, 32);
            inputStreamOpenInputStream.close();
            System.arraycopy(bArr2, 0, bArr, 4, 32);
            bArr[0] = 3;
            bArr[1] = this.J;
            bArr[2] = 32;
            bArr[3] = 0;
            t0(bArr);
        } catch (IOException e2) {
            Log.e(d0, e2.toString());
        }
    }

    private void y0() {
        t0(new byte[]{AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS, this.J, 0, 0});
    }

    private void z0() {
        String str = d0;
        Log.e(str, "sendUpdataBlockLength");
        if (this.P.isAlive()) {
            return;
        }
        Log.e(str, "mThread not alive");
        if (t0(new byte[]{10, this.K, 0, 0})) {
            this.k = false;
            Log.e(str, "send 0x0a success");
        } else {
            Log.e(str, "send 0x0a fail");
            EventBus.getDefault().post(new ci0(103));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2 && i2 == -1) {
            Uri data = intent.getData();
            this.c = data;
            this.s.setText(data.getPath());
            Log.e(d0, this.c.getPath());
            us1 us1Var = this.e;
            if (us1Var != null) {
                us1Var.b();
                this.e.notifyDataSetChanged();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.button_ota_files) {
            h0();
            return;
        }
        if (id == R$id.button_start_ota) {
            this.j = false;
            k0();
            A0();
            this.v.setEnabled(false);
            return;
        }
        if (id == R$id.button_stop_ota) {
            this.y.l();
            this.Q = false;
            this.v.setEnabled(true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_ota);
        Intent intent = getIntent();
        this.b = intent.getStringExtra("DEVICE_ADDRESS");
        this.a = intent.getStringExtra("DEVICE_NAME");
        this.f = intent.getIntExtra("OTA_TYPE", 0);
        String str = d0;
        Log.e(str, "the ota type " + this.f);
        l0();
        this.r = (TextView) findViewById(R$id.ota_activity_device_name_value);
        this.f218q = (TextView) findViewById(R$id.ota_activity_device_address_value);
        this.s = (TextView) findViewById(R$id.ota_activity_filepath);
        this.t = (TextView) findViewById(R$id.ota_activity_update_info);
        this.o = (ProgressBar) findViewById(R$id.ota_activity_update_progress);
        this.x = (Button) findViewById(R$id.button_ota_files);
        this.v = (Button) findViewById(R$id.button_start_ota);
        this.w = (Button) findViewById(R$id.button_stop_ota);
        this.p = (ListView) findViewById(R$id.ota_activity_bin_files_listview);
        this.u = (TextView) findViewById(R$id.textview_progress_value);
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.v.setEnabled(false);
        String str2 = this.a;
        if (str2 != null) {
            this.r.setText(str2);
        }
        String str3 = this.b;
        if (str3 != null) {
            this.f218q.setText(str3);
        }
        us1 us1Var = new us1(this, this.d);
        this.e = us1Var;
        this.p.setAdapter((ListAdapter) us1Var);
        this.p.setOnItemClickListener(new d());
        getWindow().addFlags(128);
        EventBus.getDefault().register(this);
        if (this.f == 2) {
            Log.e(str, "SPP OTA");
            dt1 dt1Var = new dt1(this, this.b);
            this.y = dt1Var;
            dt1Var.k();
        } else {
            Log.e(str, "BLE OTA");
            this.z = new com.beken.beken_ota.ble.a(this, this.b);
        }
        s0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        this.Q = false;
        com.beken.beken_ota.ble.a aVar = this.z;
        if (aVar != null) {
            aVar.k();
            this.z = null;
        }
        dt1 dt1Var = this.y;
        if (dt1Var != null) {
            dt1Var.p();
            this.y = null;
        }
        System.gc();
        Log.e(d0, "call onDestroy");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ci0 ci0Var) {
        int iB = ci0Var.b();
        if (iB == 401) {
            if (this.z != null) {
                this.v.setEnabled(true);
                this.Q = true;
            }
            return;
        }
        switch (iB) {
            case 101:
                j0(3);
                break;
            case 102:
                j0(5);
                break;
            case 103:
                j0(10);
                break;
            case 104:
                j0(7);
                break;
            default:
                switch (iB) {
                    case 201:
                        dt1 dt1Var = this.y;
                        if (dt1Var == null) {
                            Log.e(d0, "mOTASPPFunction is null");
                        } else if (!dt1Var.r()) {
                            this.y.l();
                            finish();
                        } else {
                            this.v.setEnabled(true);
                            this.Q = true;
                        }
                        break;
                    case 202:
                        this.Q = false;
                        if (!this.j) {
                            setResult(202);
                            finish();
                        }
                        break;
                    case 203:
                        Log.e(d0, "recv data");
                        i0(ci0Var.a());
                        break;
                    default:
                        switch (iB) {
                            case 403:
                                Log.e(d0, "ble recv data");
                                i0(ci0Var.a());
                                break;
                            case 404:
                                this.Q = false;
                                if (!this.j) {
                                    setResult(404);
                                    finish();
                                }
                                break;
                            case 405:
                                if (ci0Var.c() > 0) {
                                    int iC = ci0Var.c() - 11;
                                    this.U = iC;
                                    this.I = iC;
                                    Log.e(d0, "change mut " + this.U);
                                }
                                j0(1);
                                break;
                        }
                        break;
                }
                break;
        }
    }

    public void s0() {
        this.t.setText("idle");
        this.o.setProgress(0);
    }
}
