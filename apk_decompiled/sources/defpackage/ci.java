package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes3.dex */
public class ci extends AsyncTask {
    private final WeakReference a;
    private Bitmap b;
    private final RectF c;
    private final RectF d;
    private float e;
    private float f;
    private final int g;
    private final int h;
    private Bitmap.CompressFormat i;
    private final int j;
    private final String k;
    private final String l;
    private final bi m;
    private int n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f206q;

    public ci(Context context, Bitmap bitmap, a11 a11Var, c50 c50Var, bi biVar) {
        this.a = new WeakReference(context);
        this.b = bitmap;
        this.c = a11Var.a();
        this.d = a11Var.c();
        this.e = a11Var.d();
        this.f = a11Var.b();
        this.g = c50Var.e();
        this.h = c50Var.f();
        this.i = c50Var.a();
        this.j = c50Var.b();
        this.k = c50Var.c();
        this.l = c50Var.d();
        this.m = biVar;
    }

    private int a(int i, int i2) {
        String str;
        int iMax;
        int i3 = i * i2;
        int i4 = this.j;
        if (i3 <= 2500) {
            iMax = 40;
            str = "极小图片(≤50x50)";
        } else if (i3 <= 10000) {
            iMax = 50;
            str = "小图片(≤100x100)";
        } else if (i3 <= 40000) {
            iMax = Math.max(60, i4 - 20);
            str = "中小图片(≤200x200)";
        } else if (i3 <= 160000) {
            iMax = Math.max(70, i4 - 10);
            str = "中等图片(≤400x400)";
        } else {
            str = "大图片(>400x400)";
            iMax = i4;
        }
        Log.i("BitmapCropTask", "质量调整: " + i + "x" + i2 + " (" + i3 + "像素) -> " + i4 + " -> " + iMax + " [" + str + "]");
        return iMax;
    }

    private boolean b() throws Throwable {
        if (this.g > 0 && this.h > 0) {
            float fWidth = this.c.width() / this.e;
            float fHeight = this.c.height() / this.e;
            int i = this.g;
            if (fWidth > i || fHeight > this.h) {
                float fMin = Math.min(i / fWidth, this.h / fHeight);
                Bitmap bitmap = this.b;
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * fMin), Math.round(this.b.getHeight() * fMin), false);
                Bitmap bitmap2 = this.b;
                if (bitmap2 != bitmapCreateScaledBitmap) {
                    bitmap2.recycle();
                }
                this.b = bitmapCreateScaledBitmap;
                this.e /= fMin;
            }
        }
        if (this.f != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.f, this.b.getWidth() / 2, this.b.getHeight() / 2);
            Bitmap bitmap3 = this.b;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.b.getHeight(), matrix, true);
            Bitmap bitmap4 = this.b;
            if (bitmap4 != bitmapCreateBitmap) {
                bitmap4.recycle();
            }
            this.b = bitmapCreateBitmap;
        }
        this.p = Math.round((this.c.left - this.d.left) / this.e);
        this.f206q = Math.round((this.c.top - this.d.top) / this.e);
        this.n = Math.round(this.c.width() / this.e);
        this.o = Math.round(this.c.height() / this.e);
        File file = new File(this.k);
        long length = file.exists() ? file.length() : 0L;
        Log.i("BitmapCropTask", "=== 裁剪开始 ===");
        Log.i("BitmapCropTask", "输入文件: " + this.k);
        Log.i("BitmapCropTask", "输入文件大小: " + d(length));
        Log.i("BitmapCropTask", "原始图片尺寸: " + this.b.getWidth() + "x" + this.b.getHeight());
        Log.i("BitmapCropTask", "裁剪尺寸: " + this.n + "x" + this.o);
        StringBuilder sb = new StringBuilder();
        sb.append("压缩格式: ");
        sb.append(this.i);
        Log.i("BitmapCropTask", sb.toString());
        Log.i("BitmapCropTask", "原始压缩质量: " + this.j);
        boolean zH = h(this.n, this.o);
        Log.i("BitmapCropTask", "Should crop: " + zH);
        if (!zH) {
            if (ol2.a() && a22.h(this.k)) {
                s12.v(w9.c().d(e().getContentResolver(), Uri.parse(this.k)), new FileOutputStream(this.l));
            } else {
                s12.b(this.k, this.l);
            }
            return false;
        }
        dj0 dj0Var = (ol2.a() && a22.h(this.k)) ? new dj0(w9.c().d(e().getContentResolver(), Uri.parse(this.k))) : new dj0(this.k);
        g(Bitmap.createBitmap(this.b, this.p, this.f206q, this.n, this.o), this.n, this.o);
        if (!this.i.equals(Bitmap.CompressFormat.JPEG)) {
            return true;
        }
        l01.b(dj0Var, this.n, this.o, this.l);
        return true;
    }

    private String d(long j) {
        if (j <= 0) {
            return "0 B";
        }
        String[] strArr = {"B", "KB", "MB", "GB"};
        double d = j;
        int i = 0;
        while (d >= 1024.0d && i < 3) {
            d /= 1024.0d;
            i++;
        }
        return new DecimalFormat("#.##").format(d) + " " + strArr[i];
    }

    private Context e() {
        return (Context) this.a.get();
    }

    private void g(Bitmap bitmap, int i, int i2) {
        Context contextE = e();
        if (contextE == null) {
            return;
        }
        OutputStream outputStreamB = null;
        try {
            File file = new File(this.l);
            long length = file.exists() ? file.length() : 0L;
            if (file.exists()) {
                Log.i("BitmapCropTask", "删除旧输出文件: " + file.delete() + ", 旧文件大小: " + d(length));
            }
            outputStreamB = y02.b(contextE, Uri.fromFile(file));
            if (bitmap.hasAlpha()) {
                Bitmap.CompressFormat compressFormat = this.i;
                Bitmap.CompressFormat compressFormat2 = Bitmap.CompressFormat.PNG;
                if (!compressFormat.equals(compressFormat2)) {
                    this.i = compressFormat2;
                    Log.i("BitmapCropTask", "检测到透明通道，切换为PNG格式");
                }
            }
            int iA = a(i, i2);
            Log.i("BitmapCropTask", "调整后的压缩质量: " + iA + " (原始: " + this.j + ")");
            Log.i("BitmapCropTask", "Bitmap信息: " + bitmap.getWidth() + "x" + bitmap.getHeight() + ", 格式: " + this.i + ", 有透明通道: " + bitmap.hasAlpha());
            boolean zCompress = bitmap.compress(this.i, iA, outputStreamB);
            StringBuilder sb = new StringBuilder();
            sb.append("压缩结果: ");
            sb.append(zCompress);
            Log.i("BitmapCropTask", sb.toString());
            if (outputStreamB != null) {
                try {
                    outputStreamB.flush();
                } catch (IOException e) {
                    Log.e("BitmapCropTask", "刷新输出流失败", e);
                }
            }
            bitmap.recycle();
            long length2 = file.exists() ? file.length() : 0L;
            Log.i("BitmapCropTask", "输出文件: " + this.l);
            Log.i("BitmapCropTask", "输出文件大小: " + d(length2));
            if (length > 0) {
                Log.i("BitmapCropTask", "压缩率: " + String.format("%.2f", Double.valueOf((1.0d - (length2 / length)) * 100.0d)) + "%");
            } else {
                Log.i("BitmapCropTask", "新文件，无法计算压缩率");
            }
            int i3 = i * i2;
            Log.i("BitmapCropTask", "理论文件大小: " + d((long) (((double) ((this.i == Bitmap.CompressFormat.PNG ? 4 : 1) * i3)) * (((double) iA) / 100.0d))) + " (像素数: " + i3 + ")");
            Log.i("BitmapCropTask", "=== 裁剪完成 ===");
            ni.c(outputStreamB);
        } catch (Throwable th) {
            ni.c(outputStreamB);
            throw th;
        }
    }

    private boolean h(int i, int i2) {
        int iRound = Math.round(Math.max(i, i2) / 1000.0f) + 1;
        if (this.g > 0 && this.h > 0) {
            return true;
        }
        float f = iRound;
        return Math.abs(this.c.left - this.d.left) > f || Math.abs(this.c.top - this.d.top) > f || Math.abs(this.c.bottom - this.d.bottom) > f || Math.abs(this.c.right - this.d.right) > f || this.f != 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Throwable doInBackground(Void... voidArr) {
        Bitmap bitmap = this.b;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.d.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            b();
            this.b = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Throwable th) {
        bi biVar = this.m;
        if (biVar != null) {
            if (th != null) {
                biVar.b(th);
            } else {
                this.m.a(Uri.fromFile(new File(this.l)), this.p, this.f206q, this.n, this.o);
            }
        }
    }
}
