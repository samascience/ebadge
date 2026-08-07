package com.jieli.bmp_convert;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class BmpConvert {
    public static final int ERR_FILE_TYPE = -3588;
    public static final int ERR_INVALID_PARAM = -3584;
    public static final int ERR_IN_PROGRESS = -3587;
    public static final int ERR_IO_EXCEPTION = -3586;
    public static final int ERR_NOT_FOUND_FILE = -3585;
    public static final int TYPE_695N_RBG = 0;
    public static final int TYPE_701N_ARGB = 2;
    public static final int TYPE_701N_ARGB_NO_PACK = 4;
    public static final int TYPE_701N_JPEG = 9;
    public static final int TYPE_701N_RGB = 1;
    public static final int TYPE_701N_RGB_NO_PACK = 3;
    public static final int TYPE_707N_ARGB = 6;
    public static final int TYPE_707N_ARGB_NO_PACK = 8;
    public static final int TYPE_707N_RGB = 5;
    public static final int TYPE_707N_RGB_NO_PACK = 7;

    @Deprecated
    public static final int TYPE_BR_23 = 0;

    @Deprecated
    public static final int TYPE_BR_28 = 1;

    @Deprecated
    public static final int TYPE_BR_28_ALPHA = 2;

    @Deprecated
    public static final int TYPE_BR_28_ALPHA_RAW = 4;

    @Deprecated
    public static final int TYPE_BR_28_RAW = 3;
    public static final String d = "BmpConvert";
    public static final int[] e = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static boolean isLog = false;
    public volatile boolean a;
    public ExecutorService b;
    public final Handler c = new Handler(Looper.getMainLooper());

    static {
        try {
            System.loadLibrary("jl_bmp_convert");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public BmpConvert() {
        b("init", String.format(Locale.ENGLISH, "Library name = %s(%d), clazz : %s", getLibVersionName(), Integer.valueOf(getLibVersionCode()), this));
    }

    public static int getLibVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    public static String getLibVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    public final /* synthetic */ void a(final OnConvertListener onConvertListener, final String str, ConvertParam convertParam, int i, final String str2) {
        if (onConvertListener != null) {
            this.c.post(new Runnable() { // from class: ym
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(onConvertListener, str);
                }
            });
        }
        if (convertParam == null) {
            convertParam = new ConvertParam();
        }
        final ConvertResult convertResultBitmapConvertAndCompressBlock = bitmapConvertAndCompressBlock(i, str, str2, convertParam);
        if (onConvertListener != null) {
            this.c.post(new Runnable() { // from class: zm
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(convertResultBitmapConvertAndCompressBlock, onConvertListener, str2);
                }
            });
        }
    }

    public final void b(String str) {
        if (!isLog || str == null || str.isEmpty()) {
            return;
        }
        Log.i(d, str);
    }

    @Deprecated
    public void bitmapConvert(String str, String str2, OnConvertListener onConvertListener) {
        bitmapConvert(0, str, str2, onConvertListener);
    }

    public ConvertResult bitmapConvertAndCompressBlock(int i, String str, String str2) {
        return bitmapConvertAndCompressBlock(i, str, str2, new ConvertParam());
    }

    public int bitmapConvertBlock(int i, String str, String str2) {
        ConvertResult convertResultBitmapConvertAndCompressBlock = bitmapConvertAndCompressBlock(i, str, str2);
        return convertResultBitmapConvertAndCompressBlock == null ? ERR_INVALID_PARAM : convertResultBitmapConvertAndCompressBlock.getResult();
    }

    public native ConvertResult bmpConvert_native(int i, String str, int i2, int i3, String str2, ConvertParam convertParam);

    public boolean isWorking() {
        return this.a;
    }

    public void release() {
        b("release", "clazz : " + this);
        ExecutorService executorService = this.b;
        if (executorService != null && !executorService.isShutdown()) {
            this.b.shutdownNow();
        }
        this.b = null;
        this.a = false;
        this.c.removeCallbacksAndMessages(null);
    }

    public void bitmapConvert(int i, String str, String str2, OnConvertListener onConvertListener) {
        bitmapConvert(i, str, str2, new ConvertParam(), onConvertListener);
    }

    public ConvertResult bitmapConvertAndCompressBlock(int i, String str, String str2, ConvertParam convertParam) {
        File file;
        String str3 = str;
        if (a(i)) {
            b("bitmapConvertAndCompressBlock", "Unknown Type : " + i);
            return new ConvertResult().setAlgorithm(i).setResult(ERR_INVALID_PARAM);
        }
        File file2 = new File(str3);
        if (!file2.exists() || !file2.isFile()) {
            b("bitmapConvertAndCompressBlock", "File not found. path : " + str3);
            return new ConvertResult().setAlgorithm(i).setResult(ERR_NOT_FOUND_FILE);
        }
        if (isWorking()) {
            b("bitmapConvertAndCompressBlock", "Conversion in progress.");
            return new ConvertResult().setAlgorithm(i).setResult(ERR_IN_PROGRESS);
        }
        this.a = true;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str3, options);
        int width = bitmapDecodeFile.getWidth();
        int height = bitmapDecodeFile.getHeight();
        if (i != 9) {
            int i2 = width * height;
            int[] iArr = new int[i2];
            bitmapDecodeFile.getPixels(iArr, 0, width, 0, 0, width, height);
            byte[] bArr = new byte[i2 * 4];
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = i3 << 2;
                int i5 = iArr[i3];
                bArr[i4] = (byte) (i5 & 255);
                bArr[i4 + 1] = (byte) ((i5 >> 8) & 255);
                bArr[i4 + 2] = (byte) ((i5 >> 16) & 255);
                bArr[i4 + 3] = (byte) ((i5 >> 24) & 255);
            }
            str3 = str3.substring(0, str3.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR)) + ".bin";
            file = new File(str3);
            try {
                if (file.exists() && !file.delete()) {
                    b("bitmapConvertAndCompressBlock", "Failed to delete file. path : " + str3);
                }
                if (!file.createNewFile()) {
                    b("bitmapConvertAndCompressBlock", "Failed to create new file. path : " + str3);
                    this.a = false;
                    return new ConvertResult().setAlgorithm(i).setResult(ERR_IO_EXCEPTION);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str3);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
                b("bitmapConvertAndCompressBlock", "IOException : " + e2);
                this.a = false;
                return new ConvertResult().setAlgorithm(i).setResult(ERR_IO_EXCEPTION);
            }
        } else {
            if (!a(file2.getName())) {
                b("bitmapConvertAndCompressBlock", "It's not a JPG image.");
                return new ConvertResult().setAlgorithm(i).setResult(ERR_FILE_TYPE);
            }
            file = null;
        }
        File file3 = file;
        ConvertResult convertResultBmpConvert_native = bmpConvert_native(i, str3, width, height, str2, convertParam);
        b("bitmapConvertAndCompressBlock", "result : " + convertResultBmpConvert_native);
        if (convertResultBmpConvert_native.isConvertSuccess() && file3 != null && file3.exists() && !file3.delete()) {
            b("bitmapConvertAndCompressBlock", "Failed to delete cache file. path : " + str3);
        }
        this.a = false;
        return convertResultBmpConvert_native;
    }

    public final void b(String str, String str2) {
        b(a(str, str2));
    }

    public void bitmapConvert(final int i, final String str, final String str2, final ConvertParam convertParam, final OnConvertListener onConvertListener) {
        ExecutorService executorService = this.b;
        if (executorService == null || executorService.isShutdown()) {
            this.b = Executors.newSingleThreadExecutor();
        }
        this.b.submit(new Runnable() { // from class: xm
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(onConvertListener, str, convertParam, i, str2);
            }
        });
    }

    public final /* synthetic */ void a(OnConvertListener onConvertListener, String str) {
        b("bitmapConvert", "start");
        onConvertListener.onStart(str);
    }

    public final /* synthetic */ void a(ConvertResult convertResult, OnConvertListener onConvertListener, String str) {
        b("bitmapConvert", "end ... " + convertResult);
        if (convertResult.isConvertSuccess()) {
            onConvertListener.onStop(true, str);
        } else {
            onConvertListener.onStop(false, (String) null);
        }
        onConvertListener.onStop(convertResult, str);
    }

    public final boolean a(int i) {
        for (int i2 : e) {
            if (i2 == i) {
                return false;
            }
        }
        return true;
    }

    public final boolean a(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith(".jpg") || str.endsWith(".JPG") || str.endsWith(".jpeg") || str.endsWith(".JPEG");
    }

    public final String a(String str, String str2) {
        return String.format(Locale.ENGLISH, "[%s]\t%s", str, str2);
    }
}
