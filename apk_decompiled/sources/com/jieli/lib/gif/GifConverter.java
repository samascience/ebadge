package com.jieli.lib.gif;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.jieli.lib.gif.GifConverter;
import com.jieli.lib.gif.GifError;
import com.jieli.lib.gif.model.GifBin;
import com.jieli.lib.gif.model.GifConvertResult;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class GifConverter {
    public static final int CHIP_701N = 0;
    public static final int CHIP_707N = 1;
    public static final int MODE_HIGH_COMPRESSION_RATE = 2;
    public static final int MODE_LOW_COMPRESSION_RATE = 0;
    public static final int MODE_MEDIUM_COMPRESSION_RATE = 1;
    public static final int MODE_UNKNOWN = -1;
    public static final String d = "GifConverter";
    public static final GifConverter e = new GifConverter();
    public static boolean isLog = false;
    public ExecutorService a;
    public volatile boolean b = false;
    public final Handler c = new Handler(Looper.getMainLooper());

    public interface ResultCallback<T> {
        void onError(int i, String str);

        void onSuccess(T t);
    }

    static {
        try {
            System.loadLibrary("jl_gif");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public GifConverter() {
        a(String.format(Locale.ENGLISH, "[Init] >>> Library name = %s(%d)", getLibVersionName(), Integer.valueOf(getLibVersionCode())));
        a("[Init] >>> " + this);
    }

    public static /* synthetic */ void b(ResultCallback resultCallback, GifConvertResult gifConvertResult) {
        if (resultCallback != null) {
            resultCallback.onError(gifConvertResult.getCode(), gifConvertResult.getMessage());
        }
    }

    public static GifConverter getInstance() {
        return e;
    }

    public static int getLibVersionCode() {
        return 42;
    }

    public static String getLibVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    public GifConvertResult gif2Bin(String str, int i) {
        return gif2Bin(str, i, 0);
    }

    public void gif2BinAsync(String str, int i, ResultCallback<GifBin> resultCallback) {
        gif2BinAsync(str, null, i, resultCallback);
    }

    public native GifConvertResult gifConvert(String str, int i, int i2, boolean z);

    public boolean isConverting() {
        return this.b;
    }

    public final /* synthetic */ void a(String str, int i, int i2, boolean z, final String str2, final ResultCallback resultCallback) {
        final GifConvertResult gifConvertResultGif2Bin = gif2Bin(str, i, i2, z);
        a("[gif2BinAsync] >>> result : " + gifConvertResultGif2Bin);
        if (str2 == null || str2.isEmpty()) {
            this.c.post(new Runnable() { // from class: wt0
                @Override // java.lang.Runnable
                public final void run() {
                    GifConverter.a(resultCallback, gifConvertResultGif2Bin);
                }
            });
        } else if (!gifConvertResultGif2Bin.isSuccess()) {
            this.c.post(new Runnable() { // from class: vt0
                @Override // java.lang.Runnable
                public final void run() {
                    GifConverter.b(resultCallback, gifConvertResultGif2Bin);
                }
            });
        } else {
            final boolean zA = a(gifConvertResultGif2Bin.getGifBin().getData(), str2);
            this.c.post(new Runnable() { // from class: ut0
                @Override // java.lang.Runnable
                public final void run() {
                    GifConverter.a(resultCallback, zA, gifConvertResultGif2Bin, str2);
                }
            });
        }
    }

    public GifConvertResult gif2Bin(String str, int i, int i2) {
        return gif2Bin(str, i, i2, true);
    }

    public void gif2BinAsync(String str, String str2, int i, ResultCallback<GifBin> resultCallback) {
        gif2BinAsync(str, str2, i, 0, resultCallback);
    }

    public GifConvertResult gif2Bin(String str, int i, int i2, boolean z) {
        if (this.b) {
            return new GifConvertResult().setCode(GifError.ERR_OP_IN_PROGRESS).setMessage(GifError.getErrDesc(GifError.ERR_OP_IN_PROGRESS));
        }
        this.b = true;
        if (i >= 0 && i <= 2) {
            GifConvertResult gifConvertResultGifConvert = gifConvert(str, i, i2, z);
            this.b = false;
            a("[gif2Bin] >>> result : " + gifConvertResultGifConvert);
            return gifConvertResultGifConvert;
        }
        return new GifConvertResult().setCode(GifError.ERR_INVALID_PARAM).setMessage("Mode is invalid. mode = " + i);
    }

    public void gif2BinAsync(String str, String str2, int i, int i2, ResultCallback<GifBin> resultCallback) {
        gif2BinAsync(str, str2, i, i2, true, resultCallback);
    }

    public void gif2BinAsync(final String str, final String str2, final int i, final int i2, final boolean z, final ResultCallback<GifBin> resultCallback) {
        if (this.b) {
            if (resultCallback != null) {
                this.c.post(new Runnable() { // from class: xt0
                    @Override // java.lang.Runnable
                    public final void run() {
                        resultCallback.onError(GifError.ERR_OP_IN_PROGRESS, GifError.getErrDesc(GifError.ERR_OP_IN_PROGRESS));
                    }
                });
            }
        } else {
            ExecutorService executorService = this.a;
            if (executorService == null || executorService.isShutdown()) {
                this.a = Executors.newSingleThreadExecutor();
            }
            this.a.submit(new Runnable() { // from class: yt0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(str, i, i2, z, str2, resultCallback);
                }
            });
        }
    }

    public static /* synthetic */ void a(ResultCallback resultCallback, GifConvertResult gifConvertResult) {
        if (resultCallback != null) {
            if (gifConvertResult.isSuccess()) {
                resultCallback.onSuccess(gifConvertResult.getGifBin());
            } else {
                resultCallback.onError(gifConvertResult.getCode(), gifConvertResult.getMessage());
            }
        }
    }

    public static /* synthetic */ void a(ResultCallback resultCallback, boolean z, GifConvertResult gifConvertResult, String str) {
        if (resultCallback != null) {
            if (z) {
                resultCallback.onSuccess(gifConvertResult.getGifBin().setPath(str));
                return;
            }
            resultCallback.onError(GifError.ERR_SAVE_FILE, "Failed to save output file. path = " + str);
        }
    }

    public final void a(String str) {
        if (!isLog || str == null || str.isEmpty()) {
            return;
        }
        Log.i(d, str);
    }

    public final boolean a(byte[] bArr, String str) {
        if (bArr != null && bArr.length != 0 && str != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
