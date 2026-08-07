package com.luck.picture.lib.compress;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import defpackage.a22;
import defpackage.si;
import defpackage.w21;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes3.dex */
class a {
    private final w21 a;
    private final File b;
    private int c;
    private int d;
    private final boolean e;
    private int f;
    private final boolean g;
    private final Context h;

    a(Context context, w21 w21Var, File file, boolean z, int i, boolean z2) {
        this.b = file;
        this.a = w21Var;
        this.h = context;
        this.e = z;
        this.g = z2;
        this.f = i <= 0 ? 80 : i;
        if (w21Var.d().u() <= 0 || w21Var.d().l() <= 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = 1;
            BitmapFactory.decodeStream(w21Var.open(), null, options);
            this.c = options.outWidth;
            this.d = options.outHeight;
        } else {
            this.c = w21Var.d().u();
            this.d = w21Var.d().l();
        }
        String strI = w21Var.d().z() ? w21Var.d().i() : w21Var.d().q();
        File file2 = new File(strI);
        long length = file2.exists() ? file2.length() : 0L;
        Log.i("CompressEngine", "=== 压缩开始 ===");
        Log.i("CompressEngine", "源文件: " + strI);
        Log.i("CompressEngine", "源文件大小: " + d(length));
        Log.i("CompressEngine", "源图片尺寸: " + this.c + "x" + this.d);
        StringBuilder sb = new StringBuilder();
        sb.append("目标文件: ");
        sb.append(file.getAbsolutePath());
        Log.i("CompressEngine", sb.toString());
        Log.i("CompressEngine", "原始压缩质量: " + this.f);
        Log.i("CompressEngine", "是否裁剪图片: " + w21Var.d().z());
    }

    private int a(int i, int i2) {
        String str;
        int iMax;
        int i3 = i * i2;
        int i4 = this.f;
        if (i3 <= 10000) {
            iMax = Math.max(50, i4 - 30);
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
        Log.i("CompressEngine", "质量调整: " + i + "x" + i2 + " (" + i3 + "像素) -> " + i4 + " -> " + iMax + " [" + str + "]");
        return iMax;
    }

    private int c() {
        int i = this.c;
        int iCeil = 1;
        if (i % 2 == 1) {
            i++;
        }
        this.c = i;
        int i2 = this.d;
        if (i2 % 2 == 1) {
            i2++;
        }
        this.d = i2;
        int iMax = Math.max(i, i2);
        float fMin = Math.min(this.c, this.d) / iMax;
        if (fMin > 1.0f || fMin <= 0.5625d) {
            double d = fMin;
            if (d > 0.5625d || d <= 0.5d) {
                iCeil = (int) Math.ceil(((double) iMax) / (1280.0d / d));
            } else {
                int i3 = iMax / 1280;
                if (i3 != 0) {
                    iCeil = i3;
                }
            }
        } else if (iMax >= 1664) {
            if (iMax < 4990) {
                iCeil = 2;
            } else {
                iCeil = (iMax <= 4990 || iMax >= 10240) ? iMax / 1280 : 4;
            }
        }
        Log.i("CompressEngine", "计算采样率: " + this.c + "x" + this.d + " -> inSampleSize=" + iCeil);
        return iCeil;
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

    File b() throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = c();
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.a.open(), null, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.g && Checker.SINGLE.isJPG(this.a.d().n())) {
            String strI = this.a.d().z() ? this.a.d().i() : this.a.d().q();
            int iC = a22.h(strI) ? si.c(this.a.open()) : si.b(this.h, strI);
            if (iC > 0) {
                bitmapDecodeStream = si.e(bitmapDecodeStream, iC);
            }
        }
        if (bitmapDecodeStream == null) {
            Log.w("CompressEngine", "压缩失败: tagBitmap为null");
            return null;
        }
        int i = this.f;
        if (i <= 0 || i > 100) {
            i = 80;
        }
        this.f = i;
        int width = bitmapDecodeStream.getWidth();
        int height = bitmapDecodeStream.getHeight();
        boolean zHasAlpha = bitmapDecodeStream.hasAlpha();
        Bitmap.CompressFormat compressFormat = (this.e || zHasAlpha) ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        Log.i("CompressEngine", "实际解码尺寸: " + width + "x" + height);
        StringBuilder sb = new StringBuilder();
        sb.append("是否有透明通道: ");
        sb.append(zHasAlpha);
        Log.i("CompressEngine", sb.toString());
        Log.i("CompressEngine", "压缩格式: " + compressFormat);
        int iA = a(width, height);
        long length = this.b.exists() ? this.b.length() : 0L;
        bitmapDecodeStream.compress(compressFormat, iA, byteArrayOutputStream);
        bitmapDecodeStream.recycle();
        FileOutputStream fileOutputStream = new FileOutputStream(this.b);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
        byteArrayOutputStream.close();
        long length2 = this.b.exists() ? this.b.length() : 0L;
        Log.i("CompressEngine", "压缩后文件大小: " + d(length2));
        if (length > 0) {
            Log.i("CompressEngine", "压缩率: " + String.format("%.2f", Double.valueOf((1.0d - (length2 / length)) * 100.0d)) + "%");
        }
        Log.i("CompressEngine", "=== 压缩完成 ===");
        return this.b;
    }
}
