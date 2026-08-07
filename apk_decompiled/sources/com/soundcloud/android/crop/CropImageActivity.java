package com.soundcloud.android.crop;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public class CropImageActivity extends com.soundcloud.android.crop.d {
    private final Handler b = new Handler();
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private Uri h;
    private Uri i;
    private boolean j;
    private int k;
    private com.soundcloud.android.crop.e l;
    private CropImageView m;
    private HighlightView n;

    class a implements com.soundcloud.android.crop.b.c {
        a() {
        }

        @Override // com.soundcloud.android.crop.b.c
        public void a(Bitmap bitmap) {
            bitmap.recycle();
            System.gc();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CropImageActivity.this.setResult(0);
            CropImageActivity.this.finish();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            CropImageActivity.this.s();
        }
    }

    class d implements Runnable {

        class a implements Runnable {
            final /* synthetic */ CountDownLatch a;

            a(CountDownLatch countDownLatch) {
                this.a = countDownLatch;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (CropImageActivity.this.m.getScale() == 1.0f) {
                    CropImageActivity.this.m.b();
                }
                this.a.countDown();
            }
        }

        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            CropImageActivity.this.b.post(new a(countDownLatch));
            try {
                countDownLatch.await();
                new g(CropImageActivity.this, null).b();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class e implements Runnable {
        final /* synthetic */ Bitmap a;

        e(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageActivity.this.u(this.a);
        }
    }

    class f implements Runnable {
        final /* synthetic */ Bitmap a;

        f(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageActivity.this.m.e();
            this.a.recycle();
        }
    }

    private class g {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.c();
                CropImageActivity.this.m.invalidate();
                if (CropImageActivity.this.m.l.size() == 1) {
                    CropImageActivity cropImageActivity = CropImageActivity.this;
                    cropImageActivity.n = (HighlightView) cropImageActivity.m.l.get(0);
                    CropImageActivity.this.n.q(true);
                }
            }
        }

        private g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            int i;
            if (CropImageActivity.this.l == null) {
                return;
            }
            HighlightView highlightView = new HighlightView(CropImageActivity.this.m);
            int iE = CropImageActivity.this.l.e();
            int iB = CropImageActivity.this.l.b();
            boolean z = false;
            Rect rect = new Rect(0, 0, iE, iB);
            int iMin = (Math.min(iE, iB) * 4) / 5;
            if (CropImageActivity.this.c == 0 || CropImageActivity.this.d == 0) {
                i = iMin;
            } else if (CropImageActivity.this.c > CropImageActivity.this.d) {
                i = (CropImageActivity.this.d * iMin) / CropImageActivity.this.c;
            } else {
                i = iMin;
                iMin = (CropImageActivity.this.c * iMin) / CropImageActivity.this.d;
            }
            int i2 = (iE - iMin) / 2;
            int i3 = (iB - i) / 2;
            RectF rectF = new RectF(i2, i3, i2 + iMin, i3 + i);
            Matrix unrotatedMatrix = CropImageActivity.this.m.getUnrotatedMatrix();
            if (CropImageActivity.this.c != 0 && CropImageActivity.this.d != 0) {
                z = true;
            }
            highlightView.s(unrotatedMatrix, rect, rectF, z);
            CropImageActivity.this.m.r(highlightView);
        }

        public void b() {
            CropImageActivity.this.b.post(new a());
        }

        /* synthetic */ g(CropImageActivity cropImageActivity, a aVar) {
            this();
        }
    }

    private int l(Uri uri) throws Throwable {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            try {
                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                com.soundcloud.android.crop.a.a(inputStreamOpenInputStream);
                int iO = o();
                while (true) {
                    if (options.outHeight / i <= iO && options.outWidth / i <= iO) {
                        return i;
                    }
                    i <<= 1;
                }
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                com.soundcloud.android.crop.a.a(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void m() {
        this.m.e();
        com.soundcloud.android.crop.e eVar = this.l;
        if (eVar != null) {
            eVar.g();
        }
        System.gc();
    }

    private Bitmap n(Rect rect, int i, int i2) throws Throwable {
        OutOfMemoryError outOfMemoryError;
        IOException iOException;
        Rect rect2;
        m();
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(this.h);
                try {
                    BitmapRegionDecoder bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                    int width = bitmapRegionDecoderNewInstance.getWidth();
                    int height = bitmapRegionDecoderNewInstance.getHeight();
                    if (this.g != 0) {
                        Matrix matrix = new Matrix();
                        matrix.setRotate(-this.g);
                        RectF rectF = new RectF();
                        matrix.mapRect(rectF, new RectF(rect));
                        rectF.offset(rectF.left < 0.0f ? width : 0.0f, rectF.top < 0.0f ? height : 0.0f);
                        rect2 = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    } else {
                        rect2 = rect;
                    }
                    try {
                        Bitmap bitmapDecodeRegion = bitmapRegionDecoderNewInstance.decodeRegion(rect2, new BitmapFactory.Options());
                        if (rect2.width() > i || rect2.height() > i2) {
                            Matrix matrix2 = new Matrix();
                            matrix2.postScale(i / rect2.width(), i2 / rect2.height());
                            bitmapDecodeRegion = Bitmap.createBitmap(bitmapDecodeRegion, 0, 0, bitmapDecodeRegion.getWidth(), bitmapDecodeRegion.getHeight(), matrix2, true);
                        }
                        com.soundcloud.android.crop.a.a(inputStreamOpenInputStream);
                        return bitmapDecodeRegion;
                    } catch (IllegalArgumentException e2) {
                        throw new IllegalArgumentException("Rectangle " + rect2 + " is outside of the image (" + width + "," + height + "," + this.g + ")", e2);
                    }
                } catch (IOException e3) {
                    iOException = e3;
                    inputStream = inputStreamOpenInputStream;
                    com.soundcloud.android.crop.c.a("Error cropping image: " + iOException.getMessage(), iOException);
                    v(iOException);
                    com.soundcloud.android.crop.a.a(inputStream);
                    return null;
                } catch (OutOfMemoryError e4) {
                    outOfMemoryError = e4;
                    inputStream = inputStreamOpenInputStream;
                    com.soundcloud.android.crop.c.a("OOM cropping image: " + outOfMemoryError.getMessage(), outOfMemoryError);
                    v(outOfMemoryError);
                    com.soundcloud.android.crop.a.a(inputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamOpenInputStream;
                    com.soundcloud.android.crop.a.a(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            iOException = e5;
        } catch (OutOfMemoryError e6) {
            outOfMemoryError = e6;
        }
    }

    private int o() {
        int iP = p();
        if (iP == 0) {
            return 2048;
        }
        return Math.min(iP, 4096);
    }

    private int p() {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        return iArr[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private void r() throws Throwable {
        Throwable th;
        InputStream inputStreamOpenInputStream;
        OutOfMemoryError e2;
        IOException e3;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.c = extras.getInt("aspect_x");
            this.d = extras.getInt("aspect_y");
            this.e = extras.getInt("max_x");
            this.f = extras.getInt("max_y");
            this.i = (Uri) extras.getParcelable("output");
        }
        Uri data = intent.getData();
        this.h = data;
        if (data != null) {
            ContentResolver contentResolver = getContentResolver();
            ?? r1 = this.h;
            this.g = com.soundcloud.android.crop.a.c(com.soundcloud.android.crop.a.d(this, contentResolver, r1));
            try {
                try {
                    this.k = l(this.h);
                    inputStreamOpenInputStream = getContentResolver().openInputStream(this.h);
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = this.k;
                        this.l = new com.soundcloud.android.crop.e(BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options), this.g);
                        r1 = inputStreamOpenInputStream;
                    } catch (IOException e4) {
                        e3 = e4;
                        com.soundcloud.android.crop.c.a("Error reading image: " + e3.getMessage(), e3);
                        v(e3);
                        r1 = inputStreamOpenInputStream;
                    } catch (OutOfMemoryError e5) {
                        e2 = e5;
                        com.soundcloud.android.crop.c.a("OOM reading image: " + e2.getMessage(), e2);
                        v(e2);
                        r1 = inputStreamOpenInputStream;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.soundcloud.android.crop.a.a(r1);
                    throw th;
                }
            } catch (IOException e6) {
                inputStreamOpenInputStream = null;
                e3 = e6;
            } catch (OutOfMemoryError e7) {
                inputStreamOpenInputStream = null;
                e2 = e7;
            } catch (Throwable th3) {
                r1 = 0;
                th = th3;
                com.soundcloud.android.crop.a.a(r1);
                throw th;
            }
            com.soundcloud.android.crop.a.a(r1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() throws Throwable {
        int i;
        HighlightView highlightView = this.n;
        if (highlightView == null || this.j) {
            return;
        }
        this.j = true;
        Rect rectI = highlightView.i(this.k);
        int iWidth = rectI.width();
        int iHeight = rectI.height();
        int i2 = this.e;
        if (i2 > 0 && (i = this.f) > 0 && (iWidth > i2 || iHeight > i)) {
            float f2 = iWidth / iHeight;
            if (i2 / i > f2) {
                iWidth = (int) ((i * f2) + 0.5f);
                iHeight = i;
            } else {
                iHeight = (int) ((i2 / f2) + 0.5f);
                iWidth = i2;
            }
        }
        try {
            Bitmap bitmapN = n(rectI, iWidth, iHeight);
            if (bitmapN != null) {
                this.m.n(new com.soundcloud.android.crop.e(bitmapN, this.g), true);
                this.m.b();
                this.m.l.clear();
            }
            t(bitmapN);
        } catch (IllegalArgumentException e2) {
            v(e2);
            finish();
        }
    }

    private void t(Bitmap bitmap) {
        if (bitmap != null) {
            com.soundcloud.android.crop.a.g(this, null, getResources().getString(R$string.crop__saving), new e(bitmap), this.b);
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Bitmap bitmap) {
        if (this.i != null) {
            OutputStream outputStreamOpenOutputStream = null;
            try {
                try {
                    outputStreamOpenOutputStream = getContentResolver().openOutputStream(this.i);
                    if (outputStreamOpenOutputStream != null) {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStreamOpenOutputStream);
                    }
                } catch (IOException e2) {
                    v(e2);
                    com.soundcloud.android.crop.c.a("Cannot open file: " + this.i, e2);
                }
                com.soundcloud.android.crop.a.a(outputStreamOpenOutputStream);
                com.soundcloud.android.crop.a.b(com.soundcloud.android.crop.a.d(this, getContentResolver(), this.h), com.soundcloud.android.crop.a.d(this, getContentResolver(), this.i));
                w(this.i);
            } catch (Throwable th) {
                com.soundcloud.android.crop.a.a(outputStreamOpenOutputStream);
                throw th;
            }
        }
        this.b.post(new f(bitmap));
        finish();
    }

    private void v(Throwable th) {
        setResult(404, new Intent().putExtra("error", th));
    }

    private void w(Uri uri) {
        setResult(-1, new Intent().putExtra("output", uri));
    }

    private void x() {
        setContentView(R$layout.crop__activity_crop);
        CropImageView cropImageView = (CropImageView) findViewById(R$id.crop_image);
        this.m = cropImageView;
        cropImageView.n = this;
        cropImageView.setRecycler(new a());
        findViewById(R$id.btn_cancel).setOnClickListener(new b());
        findViewById(R$id.btn_done).setOnClickListener(new c());
    }

    private void y() {
        requestWindowFeature(1);
        getWindow().clearFlags(67108864);
    }

    private void z() {
        if (isFinishing()) {
            return;
        }
        this.m.n(this.l, true);
        com.soundcloud.android.crop.a.g(this, null, getResources().getString(R$string.crop__wait), new d(), this.b);
    }

    @Override // com.soundcloud.android.crop.d
    public /* bridge */ /* synthetic */ void a(com.soundcloud.android.crop.d.b bVar) {
        super.a(bVar);
    }

    @Override // com.soundcloud.android.crop.d
    public /* bridge */ /* synthetic */ void b(com.soundcloud.android.crop.d.b bVar) {
        super.b(bVar);
    }

    @Override // com.soundcloud.android.crop.d, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        y();
        x();
        r();
        if (this.l == null) {
            finish();
        } else {
            z();
        }
    }

    @Override // com.soundcloud.android.crop.d, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.soundcloud.android.crop.e eVar = this.l;
        if (eVar != null) {
            eVar.g();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return false;
    }

    public boolean q() {
        return this.j;
    }
}
