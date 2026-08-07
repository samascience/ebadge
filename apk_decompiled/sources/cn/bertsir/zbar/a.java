package cn.bertsir.zbar;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.bertsir.zbar.Qr.Config;
import cn.bertsir.zbar.Qr.Image;
import cn.bertsir.zbar.Qr.ImageScanner;
import cn.bertsir.zbar.Qr.ScanResult;
import cn.bertsir.zbar.Qr.Symbol;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.datamatrix.detector.Detector;
import defpackage.fk2;
import defpackage.jl1;
import defpackage.kh2;
import defpackage.n92;
import defpackage.nh2;
import defpackage.o92;
import defpackage.q32;
import defpackage.th;
import defpackage.wx0;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
class a implements Camera.PreviewCallback {
    private ImageScanner b;
    private Handler c;
    private fk2 d;
    private Image f;
    private int g;
    private int h;
    private Camera.Size i;
    private byte[] j;
    private Camera k;
    private Context l;
    private ExecutorService a = Executors.newSingleThreadExecutor();
    private boolean e = true;
    private long m = 0;
    private jl1 n = new jl1();
    private Runnable o = new b();

    /* JADX INFO: renamed from: cn.bertsir.zbar.a$a, reason: collision with other inner class name */
    class HandlerC0048a extends Handler {
        HandlerC0048a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.d != null) {
                a.this.d.a((ScanResult) message.obj);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Symbol.is_auto_zoom && Symbol.scanType == 1 && o92.i().n(a.this.l)) {
                if (Symbol.is_only_scan_center && (Symbol.cropX == 0 || Symbol.cropY == 0 || a.this.g == 0 || a.this.h == 0)) {
                    return;
                }
                try {
                    nh2[] nh2VarArrB = new Detector(new th(new wx0(new q32(a.this.j, a.this.i.width, a.this.i.height, Symbol.cropX, Symbol.cropY, a.this.g, a.this.h, true))).a()).c().b();
                    float fC = nh2VarArrB[0].c();
                    float fD = nh2VarArrB[0].d();
                    float fC2 = fC - nh2VarArrB[1].c();
                    float fD2 = fD - nh2VarArrB[1].d();
                    int iSqrt = (int) Math.sqrt((Math.abs(fC2) * Math.abs(fC2)) + (Math.abs(fD2) * Math.abs(fD2)));
                    if (iSqrt < a.this.g / 4 && iSqrt > 10) {
                        a aVar = a.this;
                        aVar.n(aVar.k);
                    }
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
            }
            String str = null;
            int type = -1;
            if (a.this.b.scanImage(a.this.f) != 0) {
                for (Symbol symbol : a.this.b.getResults()) {
                    String data = symbol.getData();
                    type = symbol.getType();
                    str = data;
                }
            }
            if (TextUtils.isEmpty(str)) {
                if (!Symbol.doubleEngine) {
                    a.this.e = true;
                    return;
                } else {
                    a aVar2 = a.this;
                    aVar2.o(aVar2.j, a.this.i.width, a.this.i.height);
                    return;
                }
            }
            ScanResult scanResult = new ScanResult();
            scanResult.setContent(str);
            scanResult.setType(type == 64 ? 1 : 2);
            Message messageObtainMessage = a.this.c.obtainMessage();
            messageObtainMessage.obj = scanResult;
            messageObtainMessage.sendToTarget();
            a.this.m = System.currentTimeMillis();
            if (Symbol.looperScan) {
                a.this.e = true;
            }
        }
    }

    a(Context context) {
        this.l = context;
        ImageScanner imageScanner = new ImageScanner();
        this.b = imageScanner;
        int i = Symbol.scanType;
        if (i == 1) {
            imageScanner.setConfig(0, 0, 0);
            this.b.setConfig(64, 0, 1);
        } else if (i == 2) {
            imageScanner.setConfig(0, 0, 0);
            this.b.setConfig(128, 0, 1);
            this.b.setConfig(39, 0, 1);
            this.b.setConfig(13, 0, 1);
            this.b.setConfig(8, 0, 1);
            this.b.setConfig(12, 0, 1);
            this.b.setConfig(9, 0, 1);
            this.b.setConfig(9, 0, 1);
        } else if (i != 3 && i == 4) {
            imageScanner.setConfig(0, 0, 0);
            this.b.setConfig(Symbol.scanFormat, 0, 1);
        } else {
            imageScanner.setConfig(0, 256, 3);
            this.b.setConfig(0, Config.Y_DENSITY, 3);
        }
        this.c = new HandlerC0048a(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        q32 q32Var = new q32(bArr2, i2, i, 0, 0, i2, i, true);
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, "utf-8");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new n92());
        hashtable.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
        this.n.e(hashtable);
        try {
            try {
                kh2 kh2VarD = this.n.d(new th(new wx0(q32Var)));
                String string = kh2VarD.toString();
                BarcodeFormat barcodeFormatB = kh2VarD.b();
                if (TextUtils.isEmpty(string)) {
                    this.e = true;
                } else {
                    ScanResult scanResult = new ScanResult();
                    scanResult.setContent(string);
                    scanResult.setType(barcodeFormatB == BarcodeFormat.QR_CODE ? 1 : 2);
                    Message messageObtainMessage = this.c.obtainMessage();
                    messageObtainMessage.obj = scanResult;
                    messageObtainMessage.sendToTarget();
                    this.m = System.currentTimeMillis();
                    if (Symbol.looperScan) {
                        this.e = true;
                    }
                }
            } catch (ReaderException unused) {
                this.e = true;
            }
        } finally {
            this.n.b();
        }
    }

    public void n(Camera camera) {
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported() && parameters.getMaxZoom() != 0 && parameters.getZoom() + 10 <= parameters.getMaxZoom()) {
                parameters.setZoom(parameters.getZoom() + 10);
                camera.setParameters(parameters);
            }
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.e) {
            this.e = false;
            this.j = bArr;
            this.k = camera;
            this.i = camera.getParameters().getPreviewSize();
            Camera.Size size = this.i;
            Image image = new Image(size.width, size.height, "Y800");
            this.f = image;
            image.setData(bArr);
            if (Symbol.is_only_scan_center) {
                float f = Symbol.cropWidth;
                Camera.Size size2 = this.i;
                int i = size2.height;
                int i2 = (int) (f * (i / Symbol.screenWidth));
                this.g = i2;
                float f2 = Symbol.cropHeight;
                int i3 = size2.width;
                int i4 = (int) (f2 * (i3 / Symbol.screenHeight));
                this.h = i4;
                Symbol.cropX = (i3 / 2) - (i4 / 2);
                Symbol.cropY = (i / 2) - (i2 / 2);
                this.f.setCrop(Symbol.cropX, Symbol.cropY, i4, i2);
            } else {
                Symbol.cropX = 0;
                Symbol.cropY = 0;
                Camera.Size size3 = this.i;
                this.g = size3.width;
                this.h = size3.height;
            }
            if (!Symbol.looperScan || System.currentTimeMillis() - this.m >= Symbol.looperWaitTime) {
                this.a.execute(this.o);
            } else {
                this.e = true;
            }
        }
    }

    void p() {
        this.e = true;
    }

    void q() {
        this.e = false;
    }

    void r(fk2 fk2Var) {
        this.d = fk2Var;
    }
}
