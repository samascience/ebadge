package org.libjpegturbo.turbojpeg;

/* JADX INFO: loaded from: classes4.dex */
public class YUVImage {
    private static final String NO_ASSOC_ERROR = "No image data is associated with this instance";
    protected long handle = 0;
    protected byte[][] yuvPlanes = null;
    protected int[] yuvOffsets = null;
    protected int[] yuvStrides = null;
    protected int yuvPad = 0;
    protected int yuvWidth = 0;
    protected int yuvHeight = 0;
    protected int yuvSubsamp = -1;

    public YUVImage(int i, int[] iArr, int i2, int i3) {
        setBuf(null, null, i, iArr, i2, i3, true);
    }

    private static int pad(int i, int i2) {
        return ((i + i2) - 1) & (~(i2 - 1));
    }

    public byte[] getBuf() {
        int i;
        if (this.yuvPlanes == null || (i = this.yuvSubsamp) < 0 || i >= 6) {
            throw new IllegalStateException(NO_ASSOC_ERROR);
        }
        int i2 = i == 3 ? 1 : 3;
        for (int i3 = 1; i3 < i2; i3++) {
            byte[][] bArr = this.yuvPlanes;
            if (bArr[i3] != bArr[0]) {
                throw new IllegalStateException("Image is not stored in a unified buffer");
            }
        }
        return this.yuvPlanes[0];
    }

    public int getHeight() {
        int i = this.yuvHeight;
        if (i >= 1) {
            return i;
        }
        throw new IllegalStateException(NO_ASSOC_ERROR);
    }

    public int[] getOffsets() {
        int[] iArr = this.yuvOffsets;
        if (iArr != null) {
            return iArr;
        }
        throw new IllegalStateException(NO_ASSOC_ERROR);
    }

    public int getPad() {
        if (this.yuvPlanes == null) {
            throw new IllegalStateException(NO_ASSOC_ERROR);
        }
        int i = this.yuvPad;
        if (i < 1 || ((i - 1) & i) != 0) {
            throw new IllegalStateException("Image is not stored in a unified buffer");
        }
        return i;
    }

    public byte[][] getPlanes() {
        byte[][] bArr = this.yuvPlanes;
        if (bArr != null) {
            return bArr;
        }
        throw new IllegalStateException(NO_ASSOC_ERROR);
    }

    public int getSize() {
        int i;
        if (this.yuvPlanes == null || (i = this.yuvSubsamp) < 0 || i >= 6) {
            throw new IllegalStateException(NO_ASSOC_ERROR);
        }
        int i2 = i == 3 ? 1 : 3;
        if (this.yuvPad < 1) {
            throw new IllegalStateException("Image is not stored in a unified buffer");
        }
        for (int i3 = 1; i3 < i2; i3++) {
            byte[][] bArr = this.yuvPlanes;
            if (bArr[i3] != bArr[0]) {
                throw new IllegalStateException("Image is not stored in a unified buffer");
            }
        }
        return TJ.bufSizeYUV(this.yuvWidth, this.yuvPad, this.yuvHeight, this.yuvSubsamp);
    }

    public int[] getStrides() {
        int[] iArr = this.yuvStrides;
        if (iArr != null) {
            return iArr;
        }
        throw new IllegalStateException(NO_ASSOC_ERROR);
    }

    public int getSubsamp() {
        int i = this.yuvSubsamp;
        if (i < 0 || i >= 6) {
            throw new IllegalStateException(NO_ASSOC_ERROR);
        }
        return i;
    }

    public int getWidth() {
        int i = this.yuvWidth;
        if (i >= 1) {
            return i;
        }
        throw new IllegalStateException(NO_ASSOC_ERROR);
    }

    public void setBuf(byte[][] bArr, int[] iArr, int i, int[] iArr2, int i2, int i3) {
        setBuf(bArr, iArr, i, iArr2, i2, i3, false);
    }

    private void setBuf(byte[][] bArr, int[] iArr, int i, int[] iArr2, int i2, int i3, boolean z) {
        int i4;
        if (bArr != null || z) {
            if (i >= 1 && i2 >= 1 && i3 >= 0 && i3 < 6) {
                int i5 = i3 != 3 ? 3 : 1;
                if ((bArr != null && bArr.length != i5) || ((iArr != null && iArr.length != i5) || (iArr2 != null && iArr2.length != i5))) {
                    throw new IllegalArgumentException("YUVImage::setBuf(): planes, offsets, or strides array is the wrong size");
                }
                if (bArr == null) {
                    bArr = new byte[i5][];
                }
                if (iArr == null) {
                    iArr = new int[i5];
                }
                if (iArr2 == null) {
                    iArr2 = new int[i5];
                }
                for (int i6 = 0; i6 < i5; i6++) {
                    int iPlaneWidth = TJ.planeWidth(i6, i, i3);
                    int iPlaneHeight = TJ.planeHeight(i6, i2, i3);
                    int iPlaneSizeYUV = TJ.planeSizeYUV(i6, i, iArr2[i6], i2, i3);
                    if (iArr2[i6] == 0) {
                        iArr2[i6] = iPlaneWidth;
                    }
                    if (z) {
                        int i7 = iArr2[i6];
                        if (i7 < iPlaneWidth) {
                            throw new IllegalArgumentException("Stride must be >= plane width when allocating a new YUV image");
                        }
                        bArr[i6] = new byte[i7 * iPlaneHeight];
                    }
                    byte[] bArr2 = bArr[i6];
                    if (bArr2 == null || (i4 = iArr[i6]) < 0) {
                        throw new IllegalArgumentException("Invalid argument in YUVImage::setBuf()");
                    }
                    if (iArr2[i6] < 0 && (i4 - iPlaneSizeYUV) + iPlaneWidth < 0) {
                        throw new IllegalArgumentException("Stride for plane " + i6 + " would cause memory to be accessed below plane boundary");
                    }
                    if (bArr2.length < i4 + iPlaneSizeYUV) {
                        throw new IllegalArgumentException("Image plane " + i6 + " is not large enough");
                    }
                }
                this.yuvPlanes = bArr;
                this.yuvOffsets = iArr;
                this.yuvWidth = i;
                this.yuvStrides = iArr2;
                this.yuvHeight = i2;
                this.yuvSubsamp = i3;
                return;
            }
        }
        throw new IllegalArgumentException("Invalid argument in YUVImage::setBuf()");
    }

    public YUVImage(int i, int i2, int i3, int i4) {
        setBuf(new byte[TJ.bufSizeYUV(i, i2, i3, i4)], i, i2, i3, i4);
    }

    public YUVImage(byte[][] bArr, int[] iArr, int i, int[] iArr2, int i2, int i3) {
        setBuf(bArr, iArr, i, iArr2, i2, i3, false);
    }

    public void setBuf(byte[] bArr, int i, int i2, int i3, int i4) {
        if (bArr != null && i >= 1 && i2 >= 1 && ((i2 - 1) & i2) == 0 && i3 >= 1 && i4 >= 0 && i4 < 6) {
            if (bArr.length >= TJ.bufSizeYUV(i, i2, i3, i4)) {
                int i5 = i4 == 3 ? 1 : 3;
                byte[][] bArr2 = new byte[i5][];
                int[] iArr = new int[i5];
                int[] iArr2 = new int[i5];
                bArr2[0] = bArr;
                iArr[0] = pad(TJ.planeWidth(0, i, i4), i2);
                if (i4 != 3) {
                    int iPad = pad(TJ.planeWidth(1, i, i4), i2);
                    iArr[2] = iPad;
                    iArr[1] = iPad;
                    bArr2[2] = bArr;
                    bArr2[1] = bArr;
                    int iPlaneHeight = iArr2[0] + (iArr[0] * TJ.planeHeight(0, i3, i4));
                    iArr2[1] = iPlaneHeight;
                    iArr2[2] = iPlaneHeight + (iArr[1] * TJ.planeHeight(1, i3, i4));
                }
                this.yuvPad = i2;
                setBuf(bArr2, iArr2, i, iArr, i3, i4);
                return;
            }
            throw new IllegalArgumentException("YUV image buffer is not large enough");
        }
        throw new IllegalArgumentException("Invalid argument in YUVImage::setBuf()");
    }

    public YUVImage(byte[] bArr, int i, int i2, int i3, int i4) {
        setBuf(bArr, i, i2, i3, i4);
    }
}
