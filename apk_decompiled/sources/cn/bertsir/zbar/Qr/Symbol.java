package cn.bertsir.zbar.Qr;

/* JADX INFO: loaded from: classes.dex */
public class Symbol {
    public static final int CODABAR = 38;
    public static final int CODE128 = 128;
    public static final int CODE39 = 39;
    public static final int CODE93 = 93;
    public static final int DATABAR = 34;
    public static final int DATABAR_EXP = 35;
    public static final int EAN13 = 13;
    public static final int EAN8 = 8;
    public static final int I25 = 25;
    public static final int ISBN10 = 10;
    public static final int ISBN13 = 14;
    public static final int NONE = 0;
    public static final int PARTIAL = 1;
    public static final int PDF417 = 57;
    public static final int QRCODE = 64;
    public static final int UPCA = 12;
    public static final int UPCE = 9;
    public static int cropHeight = 0;
    public static int cropWidth = 0;
    public static int cropX = 0;
    public static int cropY = 0;
    public static boolean doubleEngine = false;
    public static boolean is_auto_zoom = false;
    public static boolean is_only_scan_center = false;
    public static boolean looperScan = false;
    public static int looperWaitTime;
    public static int scanFormat;
    public static int scanType;
    public static int screenHeight;
    public static int screenWidth;
    private long peer;
    private int type;

    static {
        System.loadLibrary("zbar");
        init();
    }

    Symbol(long j) {
        this.peer = j;
    }

    private native void destroy(long j);

    private native long getComponents(long j);

    private native int getLocationSize(long j);

    private native int getLocationX(long j, int i);

    private native int getLocationY(long j, int i);

    private native int getType(long j);

    private static native void init();

    public synchronized void destroy() {
        long j = this.peer;
        if (j != 0) {
            destroy(j);
            this.peer = 0L;
        }
    }

    protected void finalize() {
        destroy();
    }

    public int[] getBounds() {
        int locationSize = getLocationSize(this.peer);
        if (locationSize <= 0) {
            return null;
        }
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < locationSize; i5++) {
            int locationX = getLocationX(this.peer, i5);
            if (i4 > locationX) {
                i4 = locationX;
            }
            if (i < locationX) {
                i = locationX;
            }
            int locationY = getLocationY(this.peer, i5);
            if (i2 > locationY) {
                i2 = locationY;
            }
            if (i3 < locationY) {
                i3 = locationY;
            }
        }
        return new int[]{i4, i2, i - i4, i3 - i2};
    }

    public SymbolSet getComponents() {
        return new SymbolSet(getComponents(this.peer));
    }

    public native int getConfigMask();

    public native int getCount();

    public native String getData();

    public native byte[] getDataBytes();

    public int[] getLocationPoint(int i) {
        return new int[]{getLocationX(this.peer, i), getLocationY(this.peer, i)};
    }

    public native int getModifierMask();

    public native int getOrientation();

    public native int getQuality();

    public int getType() {
        if (this.type == 0) {
            this.type = getType(this.peer);
        }
        return this.type;
    }

    native long next();
}
