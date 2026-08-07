package cn.bertsir.zbar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import cn.bertsir.zbar.Qr.ScanResult;
import cn.bertsir.zbar.Qr.Symbol;
import cn.bertsir.zbar.view.ScanView;
import cn.bertsir.zbar.view.VerticalSeekBar;
import defpackage.a50;
import defpackage.fk2;
import defpackage.o92;
import defpackage.st0;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class QRActivity extends Activity implements View.OnClickListener, SensorEventListener {
    private CameraPreview a;
    private SoundPool b;
    private ScanView c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private FrameLayout i;
    private TextView j;
    private QrConfig k;
    private Uri m;
    private VerticalSeekBar o;
    private AlertDialog p;
    private SensorManager r;
    private Sensor s;
    public final float l = 10.0f;
    private String n = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "cropQr.jpg";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f207q = 1.0f;
    private fk2 t = new b();

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            QRActivity.this.a.setZoom(i / 100.0f);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    class b implements fk2 {
        b() {
        }

        @Override // defpackage.fk2
        public void a(ScanResult scanResult) {
            if (QRActivity.this.k.isPlay_sound()) {
                QRActivity.this.b.play(1, 1.0f, 1.0f, 0, 0, 1.0f);
            }
            if (QRActivity.this.k.isShow_vibrator()) {
                o92.i().l(QRActivity.this.getApplicationContext());
            }
            if (QRActivity.this.a != null) {
                QRActivity.this.a.setFlash(false);
            }
            cn.bertsir.zbar.b.b().c().a(scanResult);
            if (Symbol.looperScan) {
                return;
            }
            QRActivity.this.finish();
        }
    }

    class c implements Runnable {
        final /* synthetic */ String a;

        class a implements Runnable {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ScanResult scanResult = new ScanResult();
                if (!TextUtils.isEmpty(this.a)) {
                    QRActivity.this.e();
                    scanResult.setContent(this.a);
                    scanResult.setType(1);
                    cn.bertsir.zbar.b.b().c().a(scanResult);
                    o92.i().g(QRActivity.this.n);
                    QRActivity.this.finish();
                    return;
                }
                String strF = o92.i().f(c.this.a);
                if (!TextUtils.isEmpty(strF)) {
                    QRActivity.this.e();
                    scanResult.setContent(strF);
                    scanResult.setType(1);
                    cn.bertsir.zbar.b.b().c().a(scanResult);
                    o92.i().g(QRActivity.this.n);
                    QRActivity.this.finish();
                    return;
                }
                try {
                    String strC = o92.i().c(c.this.a);
                    if (TextUtils.isEmpty(strC)) {
                        Toast.makeText(QRActivity.this.getApplicationContext(), "识别失败！", 0).show();
                        QRActivity.this.e();
                    } else {
                        QRActivity.this.e();
                        scanResult.setContent(strC);
                        scanResult.setType(2);
                        cn.bertsir.zbar.b.b().c().a(scanResult);
                        o92.i().g(QRActivity.this.n);
                        QRActivity.this.finish();
                    }
                } catch (Exception e) {
                    Toast.makeText(QRActivity.this.getApplicationContext(), "识别异常！", 0).show();
                    QRActivity.this.e();
                    e.printStackTrace();
                }
            }
        }

        c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TextUtils.isEmpty(this.a)) {
                    Toast.makeText(QRActivity.this.getApplicationContext(), "获取图片失败！", 0).show();
                } else {
                    QRActivity.this.runOnUiThread(new a(o92.i().e(this.a)));
                }
            } catch (Exception unused) {
                Toast.makeText(QRActivity.this.getApplicationContext(), "识别异常！", 0).show();
                QRActivity.this.e();
            }
        }
    }

    private void g() {
        if (o92.i().m()) {
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intent intent = new Intent("android.intent.action.PICK", uri);
            intent.setDataAndType(uri, "image/*");
            startActivityForResult(Intent.createChooser(intent, this.k.getOpen_album_text()), 1);
            return;
        }
        Intent intent2 = new Intent();
        intent2.setAction("android.intent.action.OPEN_DOCUMENT");
        intent2.addCategory("android.intent.category.OPENABLE");
        intent2.setType("image/*");
        startActivityForResult(Intent.createChooser(intent2, this.k.getOpen_album_text()), 1);
    }

    private void i() {
        int screen_orientation = this.k.getSCREEN_ORIENTATION();
        if (screen_orientation == 1) {
            setRequestedOrientation(1);
        } else if (screen_orientation == 2) {
            setRequestedOrientation(0);
        } else if (screen_orientation != 3) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(4);
        }
        Symbol.scanType = this.k.getScan_type();
        Symbol.scanFormat = this.k.getCustombarcodeformat();
        Symbol.is_only_scan_center = this.k.isOnly_center();
        Symbol.is_auto_zoom = this.k.isAuto_zoom();
        Symbol.doubleEngine = this.k.isDouble_engine();
        Symbol.looperScan = this.k.isLoop_scan();
        Symbol.looperWaitTime = this.k.getLoop_wait_time();
        Symbol.screenWidth = o92.i().k(this);
        Symbol.screenHeight = o92.i().j(this);
        if (this.k.isAuto_light()) {
            h();
        }
    }

    private void j() {
        this.a = (CameraPreview) findViewById(R$id.cp);
        SoundPool soundPool = new SoundPool(10, 1, 5);
        this.b = soundPool;
        soundPool.load(this, QrConfig.getDing_path(), 1);
        ScanView scanView = (ScanView) findViewById(R$id.sv);
        this.c = scanView;
        scanView.setType(this.k.getScan_view_type());
        ImageView imageView = (ImageView) findViewById(R$id.mo_scanner_back);
        this.d = imageView;
        imageView.setOnClickListener(this);
        this.d.setImageResource(this.k.getBackImgRes());
        ImageView imageView2 = (ImageView) findViewById(R$id.iv_flash);
        this.e = imageView2;
        imageView2.setOnClickListener(this);
        this.e.setImageResource(this.k.getLightImageRes());
        ImageView imageView3 = (ImageView) findViewById(R$id.iv_album);
        this.f = imageView3;
        imageView3.setOnClickListener(this);
        this.f.setImageResource(this.k.getAblumImageRes());
        this.h = (TextView) findViewById(R$id.tv_title);
        this.i = (FrameLayout) findViewById(R$id.fl_title);
        this.j = (TextView) findViewById(R$id.tv_des);
        this.o = (VerticalSeekBar) findViewById(R$id.vsb_zoom);
        this.f.setVisibility(this.k.isShow_light() ? 0 : 8);
        this.i.setVisibility(this.k.isShow_title() ? 0 : 8);
        this.e.setVisibility(this.k.isShow_light() ? 0 : 8);
        this.f.setVisibility(this.k.isShow_album() ? 0 : 8);
        this.j.setVisibility(this.k.isShow_des() ? 0 : 8);
        this.o.setVisibility(this.k.isShow_zoom() ? 0 : 8);
        this.j.setText(this.k.getDes_text());
        this.h.setText(this.k.getTitle_text());
        this.i.setBackgroundColor(this.k.getTITLE_BACKGROUND_COLOR());
        this.h.setTextColor(this.k.getTITLE_TEXT_COLOR());
        this.c.setCornerColor(this.k.getCORNER_COLOR());
        this.c.setLineSpeed(this.k.getLine_speed());
        this.c.setLineColor(this.k.getLINE_COLOR());
        this.c.setScanLineStyle(this.k.getLine_style());
        l(this.o, this.k.getCORNER_COLOR());
        this.o.setOnSeekBarChangeListener(new a());
    }

    private void k(Uri uri) {
        String strB = st0.b(this, uri);
        TextView textViewM = m();
        this.g = textViewM;
        textViewM.setText("请稍后...");
        new Thread(new c(strB)).start();
    }

    public void e() {
        try {
            AlertDialog alertDialog = this.p;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void f(Uri uri) {
        Uri uri2 = Uri.parse("file:///" + this.n);
        this.m = uri2;
        a50.c(uri, uri2).a().d(this);
    }

    public void h() {
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        this.r = sensorManager;
        if (sensorManager != null) {
            this.s = sensorManager.getDefaultSensor(5);
        }
    }

    public void l(SeekBar seekBar, int i) {
        Drawable thumb = seekBar.getThumb();
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        thumb.setColorFilter(i, mode);
        seekBar.getProgressDrawable().setColorFilter(i, mode);
    }

    public TextView m() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R$style.AlertDialogStyle);
        builder.setCancelable(false);
        View viewInflate = View.inflate(this, R$layout.dialog_loading, null);
        builder.setView(viewInflate);
        ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R$id.pb_loading);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_hint);
        progressBar.setIndeterminateTintList(getColorStateList(R$color.dialog_pro_color));
        AlertDialog alertDialogCreate = builder.create();
        this.p = alertDialogCreate;
        alertDialogCreate.show();
        return textView;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 1) {
                if (i == 6709) {
                    k(this.m);
                }
            } else if (this.k.isNeed_crop()) {
                f(intent.getData());
            } else {
                k(intent.getData());
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.iv_album) {
            g();
            return;
        }
        if (view.getId() == R$id.iv_flash) {
            CameraPreview cameraPreview = this.a;
            if (cameraPreview != null) {
                cameraPreview.f();
                return;
            }
            return;
        }
        if (view.getId() == R$id.mo_scanner_back) {
            setResult(401);
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(67108864);
        this.k = (QrConfig) getIntent().getExtras().get(QrConfig.EXTRA_THIS_CONFIG);
        i();
        setContentView(R$layout.activity_qr);
        j();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        CameraPreview cameraPreview = this.a;
        if (cameraPreview != null) {
            cameraPreview.setFlash(false);
            this.a.i();
        }
        this.b.release();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        CameraPreview cameraPreview = this.a;
        if (cameraPreview != null) {
            cameraPreview.i();
        }
        SensorManager sensorManager = this.r;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this, this.s);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        CameraPreview cameraPreview = this.a;
        if (cameraPreview != null) {
            cameraPreview.setScanCallback(this.t);
            this.a.g();
        }
        SensorManager sensorManager = this.r;
        if (sensorManager != null) {
            sensorManager.registerListener(this, this.s, 3);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.values[0] >= 10.0f || !this.a.e()) {
            return;
        }
        this.a.setFlash(true);
        this.r.unregisterListener(this, this.s);
        this.s = null;
        this.r = null;
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.k.isFinger_zoom()) {
            int action = motionEvent.getAction() & 255;
            if (action != 2) {
                if (action == 5) {
                    this.f207q = o92.i().h(motionEvent);
                }
            } else if (motionEvent.getPointerCount() == 2) {
                float fH = o92.i().h(motionEvent);
                float f = this.f207q;
                if (fH > f) {
                    this.a.d(true);
                } else if (fH < f) {
                    this.a.d(false);
                }
                this.f207q = fH;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
