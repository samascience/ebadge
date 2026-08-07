package xfkj.fitpro.utils.bmp;

/* JADX INFO: loaded from: classes4.dex */
public enum BitmapFormat {
    BITMAP_8_BIT_COLOR(8),
    BITMAP_16_BIT_COLOR(16),
    BITMAP_24_BIT_COLOR(24);

    private int value;

    BitmapFormat(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
