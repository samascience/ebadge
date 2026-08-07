package com.legend.mywatch.sdk.realtimepreview.image;

import android.graphics.Bitmap;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PreviewImageProcessor {
    private static CompressionEngine a = CompressionEngine.LIBJPEG_TURBO;

    public enum CompressionEngine {
        LIBJPEG_TURBO
    }

    public static byte[] a(Bitmap bitmap, int i, int i2) {
        if (bitmap != null) {
            return b(bitmap, i, i2);
        }
        throw new IllegalArgumentException("Bitmap cannot be null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static byte[] b(Bitmap bitmap, int i, int i2) throws Throwable {
        Bitmap bitmapC;
        Bitmap bitmap2 = 0;
        try {
            try {
                bitmapC = c(bitmap, i, i2);
                try {
                    byte[] bArrCompressBitmap = TurboJpegCompressor.compressBitmap(bitmapC, 15);
                    if (bArrCompressBitmap != null) {
                        Log.d("PreviewImageProcessor", "Image processed with libjpeg-turbo, size: " + bArrCompressBitmap.length + " bytes");
                    } else {
                        Log.e("PreviewImageProcessor", "TurboJpegCompressor.compressBitmap failed");
                    }
                    if (bitmapC != bitmap && bitmapC != null && !bitmapC.isRecycled()) {
                        bitmapC.recycle();
                    }
                    return bArrCompressBitmap;
                } catch (Exception e) {
                    e = e;
                    Log.e("PreviewImageProcessor", "Error processing image with libjpeg-turbo", e);
                    if (bitmapC != bitmap && bitmapC != null && !bitmapC.isRecycled()) {
                        bitmapC.recycle();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bitmap2 = i;
                if (bitmap2 != bitmap && bitmap2 != 0 && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bitmapC = null;
        } catch (Throwable th2) {
            th = th2;
            if (bitmap2 != bitmap) {
                bitmap2.recycle();
            }
            throw th;
        }
    }

    private static Bitmap c(Bitmap bitmap, int i, int i2) {
        return (bitmap.getWidth() == i && bitmap.getHeight() == i2) ? bitmap : Bitmap.createScaledBitmap(bitmap, i, i2, true);
    }
}
