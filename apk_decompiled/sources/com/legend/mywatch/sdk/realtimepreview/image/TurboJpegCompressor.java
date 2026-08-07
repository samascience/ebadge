package com.legend.mywatch.sdk.realtimepreview.image;

import android.graphics.Bitmap;
import android.util.Log;
import org.libjpegturbo.turbojpeg.TJCompressor;
import org.libjpegturbo.turbojpeg.TJDecompressor;
import org.libjpegturbo.turbojpeg.TJException;

/* JADX INFO: loaded from: classes3.dex */
public class TurboJpegCompressor {
    private static final String TAG = "TurboJpegCompressor";

    public static class RgbData {
        public int height;
        public byte[] rgbData;
        public int width;

        public RgbData(byte[] bArr, int i, int i2) {
            this.rgbData = bArr;
            this.width = i;
            this.height = i2;
        }
    }

    public static byte[] compressBitmap(Bitmap bitmap, int i) {
        if (bitmap == null) {
            Log.e(TAG, "Bitmap is null");
            return null;
        }
        if (!bitmap.isRecycled()) {
            return compressBitmap(bitmap, new CompressConfig(i));
        }
        Log.e(TAG, "Bitmap is recycled");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:? A[SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0045: MOVE (r10 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:15:0x0044 */
    public static byte[] compressRgb(byte[] bArr, int i, int i2, int i3) throws Throwable {
        Throwable th;
        TJCompressor tJCompressor;
        AutoCloseable autoCloseable;
        AutoCloseable autoCloseable2 = null;
        if (bArr == null || i <= 0 || i2 <= 0) {
            Log.e(TAG, "Invalid parameters for compressRgb");
            return null;
        }
        CompressConfig compressConfig = new CompressConfig(i3);
        try {
            try {
                tJCompressor = new TJCompressor();
                try {
                    tJCompressor.setSourceImage(bArr, 0, 0, i, i * 3, i2, 0);
                    tJCompressor.setJPEGQuality(i3);
                    tJCompressor.setSubsamp(compressConfig.getMappedSubsample());
                    byte[] bArrCompress = tJCompressor.compress(0);
                    int compressedSize = tJCompressor.getCompressedSize();
                    if (compressedSize < bArrCompress.length) {
                        byte[] bArr2 = new byte[compressedSize];
                        System.arraycopy(bArrCompress, 0, bArr2, 0, compressedSize);
                        bArrCompress = bArr2;
                    }
                    try {
                        tJCompressor.close();
                    } catch (TJException e) {
                        Log.e(TAG, "Error closing compressor", e);
                    }
                    return bArrCompress;
                } catch (TJException e2) {
                    e = e2;
                    Log.e(TAG, "TJException during RGB compression: " + e.getMessage(), e);
                    if (tJCompressor != null) {
                        try {
                            tJCompressor.close();
                        } catch (TJException e3) {
                            Log.e(TAG, "Error closing compressor", e3);
                        }
                    }
                    return null;
                } catch (Exception e4) {
                    e = e4;
                    Log.e(TAG, "Error compressing RGB data", e);
                    if (tJCompressor != null) {
                        try {
                            tJCompressor.close();
                        } catch (TJException e5) {
                            Log.e(TAG, "Error closing compressor", e5);
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                autoCloseable2 = autoCloseable;
                if (autoCloseable2 != null) {
                    throw th;
                }
                try {
                    autoCloseable2.close();
                    throw th;
                } catch (TJException e6) {
                    Log.e(TAG, "Error closing compressor", e6);
                    throw th;
                }
            }
        } catch (TJException e7) {
            e = e7;
            tJCompressor = null;
        } catch (Exception e8) {
            e = e8;
            tJCompressor = null;
        } catch (Throwable th3) {
            th = th3;
            if (autoCloseable2 != null) {
                throw th;
            }
            autoCloseable2.close();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [org.libjpegturbo.turbojpeg.TJDecompressor] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    public static RgbData decompressJpeg(byte[] bArr) throws Throwable {
        TJDecompressor tJDecompressor;
        ?? r1 = 0;
        if (bArr != null) {
            ?? length = bArr.length;
            try {
                if (length != 0) {
                    try {
                        tJDecompressor = new TJDecompressor(bArr, bArr.length);
                        try {
                            int width = tJDecompressor.getWidth();
                            RgbData rgbData = new RgbData(tJDecompressor.decompress(0, width * 3, 0, 0, 0), width, tJDecompressor.getHeight());
                            try {
                                tJDecompressor.close();
                            } catch (TJException e) {
                                Log.e(TAG, "Error closing decompressor", e);
                            }
                            return rgbData;
                        } catch (TJException e2) {
                            e = e2;
                            Log.e(TAG, "TJException during decompression: " + e.getMessage(), e);
                            if (tJDecompressor != null) {
                                try {
                                    tJDecompressor.close();
                                } catch (TJException e3) {
                                    Log.e(TAG, "Error closing decompressor", e3);
                                }
                            }
                            return null;
                        } catch (Exception e4) {
                            e = e4;
                            Log.e(TAG, "Error decompressing JPEG", e);
                            if (tJDecompressor != null) {
                                try {
                                    tJDecompressor.close();
                                } catch (TJException e5) {
                                    Log.e(TAG, "Error closing decompressor", e5);
                                }
                            }
                            return null;
                        }
                    } catch (TJException e6) {
                        e = e6;
                        tJDecompressor = null;
                    } catch (Exception e7) {
                        e = e7;
                        tJDecompressor = null;
                    } catch (Throwable th) {
                        th = th;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (TJException e8) {
                                Log.e(TAG, "Error closing decompressor", e8);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = length;
            }
        }
        Log.e(TAG, "JPEG data is null or empty");
        return null;
    }

    public static String getVersion() {
        return "2.1.0 (AAR)";
    }

    private static byte[] intArrayToRgb(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 3];
        for (int i = 0; i < iArr.length; i++) {
            int i2 = iArr[i];
            int i3 = i * 3;
            bArr[i3] = (byte) ((i2 >> 16) & 255);
            bArr[i3 + 1] = (byte) ((i2 >> 8) & 255);
            bArr[i3 + 2] = (byte) (i2 & 255);
        }
        return bArr;
    }

    public static class CompressConfig {
        private int pixelFormat;
        private int quality;
        private int subsample;

        public CompressConfig() {
            this.quality = 85;
            this.subsample = 0;
            this.pixelFormat = 0;
        }

        private int mapPixelFormat(int i) {
            switch (i) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                default:
                    return 0;
            }
        }

        private int mapSubsample(int i) {
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    i2 = 3;
                    if (i != 3) {
                        return 0;
                    }
                }
            }
            return i2;
        }

        public int getMappedPixelFormat() {
            return mapPixelFormat(this.pixelFormat);
        }

        public int getMappedSubsample() {
            return mapSubsample(this.subsample);
        }

        public int getPixelFormat() {
            return this.pixelFormat;
        }

        public int getQuality() {
            return this.quality;
        }

        public int getSubsample() {
            return this.subsample;
        }

        public void setPixelFormat(int i) {
            this.pixelFormat = i;
        }

        public void setQuality(int i) {
            this.quality = Math.max(1, Math.min(100, i));
        }

        public void setSubsample(int i) {
            this.subsample = i;
        }

        public CompressConfig(int i) {
            this.subsample = 0;
            this.pixelFormat = 0;
            this.quality = i;
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [org.libjpegturbo.turbojpeg.TJCompressor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public static byte[] compressBitmap(Bitmap bitmap, CompressConfig compressConfig) throws Throwable {
        TJCompressor tJCompressor;
        ?? r1 = 0;
        if (bitmap == null) {
            Log.e(TAG, "Bitmap is null");
            return null;
        }
        if (bitmap.isRecycled()) {
            Log.e(TAG, "Bitmap is recycled");
            return null;
        }
        if (compressConfig == null) {
            compressConfig = new CompressConfig();
        }
        try {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int[] iArr = new int[width * height];
                bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                byte[] bArrIntArrayToRgb = intArrayToRgb(iArr);
                tJCompressor = new TJCompressor();
                try {
                    tJCompressor.setSourceImage(bArrIntArrayToRgb, 0, 0, width, width * 3, height, 0);
                    tJCompressor.setJPEGQuality(compressConfig.getQuality());
                    tJCompressor.setSubsamp(compressConfig.getMappedSubsample());
                    byte[] bArrCompress = tJCompressor.compress(0);
                    int compressedSize = tJCompressor.getCompressedSize();
                    if (compressedSize < bArrCompress.length) {
                        byte[] bArr = new byte[compressedSize];
                        System.arraycopy(bArrCompress, 0, bArr, 0, compressedSize);
                        bArrCompress = bArr;
                    }
                    if (bArrCompress.length > 0) {
                        Log.d(TAG, "Compressed: " + width + "x" + height + " -> " + bArrCompress.length + " bytes, quality=" + compressConfig.getQuality());
                    } else {
                        Log.e(TAG, "Compression failed: result is null or empty");
                    }
                    try {
                        tJCompressor.close();
                    } catch (TJException e) {
                        Log.e(TAG, "Error closing compressor", e);
                    }
                    return bArrCompress;
                } catch (TJException e2) {
                    e = e2;
                    Log.e(TAG, "TJException during compression: " + e.getMessage(), e);
                    if (tJCompressor != null) {
                        try {
                            tJCompressor.close();
                        } catch (TJException e3) {
                            Log.e(TAG, "Error closing compressor", e3);
                        }
                    }
                    return null;
                } catch (Exception e4) {
                    e = e4;
                    Log.e(TAG, "Error compressing bitmap", e);
                    if (tJCompressor != null) {
                        try {
                            tJCompressor.close();
                        } catch (TJException e5) {
                            Log.e(TAG, "Error closing compressor", e5);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r1 = bitmap;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (TJException e6) {
                        Log.e(TAG, "Error closing compressor", e6);
                    }
                }
                throw th;
            }
        } catch (TJException e7) {
            e = e7;
            tJCompressor = null;
        } catch (Exception e8) {
            e = e8;
            tJCompressor = null;
        } catch (Throwable th2) {
            th = th2;
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }
}
