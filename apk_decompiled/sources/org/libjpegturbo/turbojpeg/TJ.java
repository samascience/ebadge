package org.libjpegturbo.turbojpeg;

/* JADX INFO: loaded from: classes4.dex */
public final class TJ {
    public static final int CS_CMYK = 3;
    public static final int CS_GRAY = 2;
    public static final int CS_RGB = 0;
    public static final int CS_YCCK = 4;
    public static final int CS_YCbCr = 1;
    public static final int ERR_FATAL = 1;
    public static final int ERR_WARNING = 0;
    public static final int FLAG_ACCURATEDCT = 4096;
    public static final int FLAG_BOTTOMUP = 2;
    public static final int FLAG_FASTDCT = 2048;
    public static final int FLAG_FASTUPSAMPLE = 256;

    @Deprecated
    public static final int FLAG_FORCEMMX = 8;

    @Deprecated
    public static final int FLAG_FORCESSE = 16;

    @Deprecated
    public static final int FLAG_FORCESSE2 = 32;

    @Deprecated
    public static final int FLAG_FORCESSE3 = 128;
    public static final int FLAG_LIMITSCANS = 32768;
    public static final int FLAG_PROGRESSIVE = 16384;
    public static final int FLAG_STOPONWARNING = 8192;
    public static final int NUMCS = 5;
    public static final int NUMERR = 2;
    public static final int NUMPF = 12;
    public static final int NUMSAMP = 6;
    public static final int PF_ABGR = 9;
    public static final int PF_ARGB = 10;
    public static final int PF_BGR = 1;
    public static final int PF_BGRA = 8;
    public static final int PF_BGRX = 3;
    public static final int PF_CMYK = 11;
    public static final int PF_GRAY = 6;
    public static final int PF_RGB = 0;
    public static final int PF_RGBA = 7;
    public static final int PF_RGBX = 2;
    public static final int PF_XBGR = 4;
    public static final int PF_XRGB = 5;
    public static final int SAMP_411 = 5;
    public static final int SAMP_420 = 2;
    public static final int SAMP_422 = 1;
    public static final int SAMP_440 = 4;
    public static final int SAMP_444 = 0;
    public static final int SAMP_GRAY = 3;
    private static final int[] MCU_WIDTH = {8, 16, 16, 8, 8, 32};
    private static final int[] MCU_HEIGHT = {8, 8, 16, 8, 16, 8};
    private static final int[] PIXEL_SIZE = {3, 3, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4};
    private static final int[] RED_OFFSET = {0, 2, 0, 2, 3, 1, -1, 0, 2, 3, 1, -1};
    private static final int[] GREEN_OFFSET = {1, 1, 1, 1, 2, 2, -1, 1, 1, 2, 2, -1};
    private static final int[] BLUE_OFFSET = {2, 0, 2, 0, 1, 3, -1, 2, 0, 1, 3, -1};
    private static final int[] ALPHA_OFFSET = {-1, -1, -1, -1, -1, -1, -1, 3, 3, 0, 0, -1};

    static {
        TJLoader.load();
    }

    private TJ() {
    }

    public static native int bufSize(int i, int i2, int i3);

    @Deprecated
    public static native int bufSizeYUV(int i, int i2, int i3);

    public static native int bufSizeYUV(int i, int i2, int i3, int i4);

    private static void checkPixelFormat(int i) {
        if (i < 0 || i >= 12) {
            throw new IllegalArgumentException("Invalid pixel format");
        }
    }

    private static void checkSubsampling(int i) {
        if (i < 0 || i >= 6) {
            throw new IllegalArgumentException("Invalid subsampling type");
        }
    }

    public static int getAlphaOffset(int i) {
        checkPixelFormat(i);
        return ALPHA_OFFSET[i];
    }

    public static int getBlueOffset(int i) {
        checkPixelFormat(i);
        return BLUE_OFFSET[i];
    }

    public static int getGreenOffset(int i) {
        checkPixelFormat(i);
        return GREEN_OFFSET[i];
    }

    public static int getMCUHeight(int i) {
        checkSubsampling(i);
        return MCU_HEIGHT[i];
    }

    public static int getMCUWidth(int i) {
        checkSubsampling(i);
        return MCU_WIDTH[i];
    }

    public static int getPixelSize(int i) {
        checkPixelFormat(i);
        return PIXEL_SIZE[i];
    }

    public static int getRedOffset(int i) {
        checkPixelFormat(i);
        return RED_OFFSET[i];
    }

    public static native TJScalingFactor[] getScalingFactors();

    public static native int planeHeight(int i, int i2, int i3);

    public static native int planeSizeYUV(int i, int i2, int i3, int i4, int i5);

    public static native int planeWidth(int i, int i2, int i3);
}
