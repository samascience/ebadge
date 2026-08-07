package org.libjpegturbo.turbojpeg;

import java.io.Closeable;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes4.dex */
public class TJDecompressor implements Closeable {
    private static final String NO_ASSOC_ERROR = "No JPEG image is associated with this instance";
    protected long handle = 0;
    protected byte[] jpegBuf = null;
    protected int jpegBufSize = 0;
    protected YUVImage yuvImage = null;
    protected int jpegWidth = 0;
    protected int jpegHeight = 0;
    protected int jpegSubsamp = -1;
    protected int jpegColorspace = -1;
    private ByteOrder byteOrder = null;

    static {
        TJLoader.load();
    }

    public TJDecompressor() throws TJException {
        init();
    }

    private native void decodeYUV(byte[][] bArr, int[] iArr, int[] iArr2, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws TJException;

    private native void decodeYUV(byte[][] bArr, int[] iArr, int[] iArr2, int i, int[] iArr3, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws TJException;

    @Deprecated
    private native void decompress(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6) throws TJException;

    private native void decompress(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws TJException;

    @Deprecated
    private native void decompress(byte[] bArr, int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) throws TJException;

    private native void decompress(byte[] bArr, int i, int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws TJException;

    private native void decompressHeader(byte[] bArr, int i) throws TJException;

    @Deprecated
    private native void decompressToYUV(byte[] bArr, int i, byte[] bArr2, int i2) throws TJException;

    private native void decompressToYUV(byte[] bArr, int i, byte[][] bArr2, int[] iArr, int i2, int[] iArr2, int i3, int i4) throws TJException;

    private native void destroy() throws TJException;

    private native void init() throws TJException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws TJException {
        if (this.handle != 0) {
            destroy();
        }
    }

    public void decompress(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) throws TJException {
        YUVImage yUVImage;
        byte[] bArr2 = this.jpegBuf;
        if (bArr2 == null && this.yuvImage == null) {
            throw new IllegalStateException(NO_ASSOC_ERROR);
        }
        if (bArr == null || i < 0 || i2 < 0 || i4 < 0 || (((yUVImage = this.yuvImage) != null && (i3 < 0 || i5 < 0)) || i6 < 0 || i6 >= 12 || i7 < 0)) {
            throw new IllegalArgumentException("Invalid argument in decompress()");
        }
        if (yUVImage != null) {
            decodeYUV(yUVImage.getPlanes(), this.yuvImage.getOffsets(), this.yuvImage.getStrides(), this.yuvImage.getSubsamp(), bArr, i, i2, this.yuvImage.getWidth(), i4, this.yuvImage.getHeight(), i6, i7);
        } else if (i > 0 || i2 > 0) {
            decompress(bArr2, this.jpegBufSize, bArr, i, i2, i3, i4, i5, i6, i7);
        } else {
            decompress(bArr2, this.jpegBufSize, bArr, i3, i4, i5, i6, i7);
        }
    }

    public void decompressToYUV(YUVImage yUVImage, int i) throws TJException {
        if (this.jpegBuf == null) {
            throw new IllegalStateException(NO_ASSOC_ERROR);
        }
        if (yUVImage == null || i < 0) {
            throw new IllegalArgumentException("Invalid argument in decompressToYUV()");
        }
        int scaledWidth = getScaledWidth(yUVImage.getWidth(), yUVImage.getHeight());
        int scaledHeight = getScaledHeight(yUVImage.getWidth(), yUVImage.getHeight());
        if (scaledWidth != yUVImage.getWidth() || scaledHeight != yUVImage.getHeight()) {
            throw new IllegalArgumentException("YUVImage dimensions do not match one of the scaled image sizes that TurboJPEG is capable of generating.");
        }
        if (this.jpegSubsamp != yUVImage.getSubsamp()) {
            throw new IllegalArgumentException("YUVImage subsampling level does not match that of the JPEG image");
        }
        decompressToYUV(this.jpegBuf, this.jpegBufSize, yUVImage.getPlanes(), yUVImage.getOffsets(), yUVImage.getWidth(), yUVImage.getStrides(), yUVImage.getHeight(), i);
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } catch (TJException unused) {
        } finally {
            super.finalize();
        }
    }

    public int getColorspace() {
        if (this.yuvImage != null) {
            return 1;
        }
        int i = this.jpegColorspace;
        if (i < 0) {
            throw new IllegalStateException(NO_ASSOC_ERROR);
        }
        if (i < 5) {
            return i;
        }
        throw new IllegalStateException("JPEG header information is invalid");
    }

    public int getHeight() {
        YUVImage yUVImage = this.yuvImage;
        if (yUVImage != null) {
            return yUVImage.getHeight();
        }
        int i = this.jpegHeight;
        if (i >= 1) {
            return i;
        }
        throw new IllegalStateException(NO_ASSOC_ERROR);
    }

    public byte[] getJPEGBuf() {
        byte[] bArr = this.jpegBuf;
        if (bArr != null) {
            return bArr;
        }
        throw new IllegalStateException(NO_ASSOC_ERROR);
    }

    public int getJPEGSize() {
        int i = this.jpegBufSize;
        if (i >= 1) {
            return i;
        }
        throw new IllegalStateException(NO_ASSOC_ERROR);
    }

    public int getScaledHeight(int i, int i2) {
        if (this.jpegWidth < 1 || this.jpegHeight < 1) {
            throw new IllegalStateException(NO_ASSOC_ERROR);
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Invalid argument in getScaledHeight()");
        }
        TJScalingFactor[] scalingFactors = TJ.getScalingFactors();
        if (i == 0) {
            i = this.jpegWidth;
        }
        if (i2 == 0) {
            i2 = this.jpegHeight;
        }
        int scaled = this.jpegWidth;
        int scaled2 = this.jpegHeight;
        for (int i3 = 0; i3 < scalingFactors.length; i3++) {
            scaled = scalingFactors[i3].getScaled(this.jpegWidth);
            scaled2 = scalingFactors[i3].getScaled(this.jpegHeight);
            if (scaled <= i && scaled2 <= i2) {
                break;
            }
        }
        if (scaled > i || scaled2 > i2) {
            throw new IllegalArgumentException("Could not scale down to desired image dimensions");
        }
        return scaled2;
    }

    public int getScaledWidth(int i, int i2) {
        if (this.jpegWidth < 1 || this.jpegHeight < 1) {
            throw new IllegalStateException(NO_ASSOC_ERROR);
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Invalid argument in getScaledWidth()");
        }
        TJScalingFactor[] scalingFactors = TJ.getScalingFactors();
        if (i == 0) {
            i = this.jpegWidth;
        }
        if (i2 == 0) {
            i2 = this.jpegHeight;
        }
        int scaled = this.jpegWidth;
        int scaled2 = this.jpegHeight;
        for (int i3 = 0; i3 < scalingFactors.length; i3++) {
            scaled = scalingFactors[i3].getScaled(this.jpegWidth);
            scaled2 = scalingFactors[i3].getScaled(this.jpegHeight);
            if (scaled <= i && scaled2 <= i2) {
                break;
            }
        }
        if (scaled > i || scaled2 > i2) {
            throw new IllegalArgumentException("Could not scale down to desired image dimensions");
        }
        return scaled;
    }

    public int getSubsamp() {
        YUVImage yUVImage = this.yuvImage;
        if (yUVImage != null) {
            return yUVImage.getSubsamp();
        }
        int i = this.jpegSubsamp;
        if (i < 0) {
            throw new IllegalStateException(NO_ASSOC_ERROR);
        }
        if (i < 6) {
            return i;
        }
        throw new IllegalStateException("JPEG header information is invalid");
    }

    public int getWidth() {
        YUVImage yUVImage = this.yuvImage;
        if (yUVImage != null) {
            return yUVImage.getWidth();
        }
        int i = this.jpegWidth;
        if (i >= 1) {
            return i;
        }
        throw new IllegalStateException(NO_ASSOC_ERROR);
    }

    @Deprecated
    public void setJPEGImage(byte[] bArr, int i) throws TJException {
        setSourceImage(bArr, i);
    }

    public void setSourceImage(byte[] bArr, int i) throws TJException {
        if (bArr == null || i < 1) {
            throw new IllegalArgumentException("Invalid argument in setSourceImage()");
        }
        this.jpegBuf = bArr;
        this.jpegBufSize = i;
        decompressHeader(bArr, i);
        this.yuvImage = null;
    }

    public void setSourceImage(YUVImage yUVImage) {
        if (yUVImage != null) {
            this.yuvImage = yUVImage;
            this.jpegBuf = null;
            this.jpegBufSize = 0;
            return;
        }
        throw new IllegalArgumentException("Invalid argument in setSourceImage()");
    }

    @Deprecated
    public void decompress(byte[] bArr, int i, int i2, int i3, int i4, int i5) throws TJException {
        decompress(bArr, 0, 0, i, i2, i3, i4, i5);
    }

    public TJDecompressor(byte[] bArr) throws TJException {
        init();
        setSourceImage(bArr, bArr.length);
    }

    public byte[] decompress(int i, int i2, int i3, int i4, int i5) throws TJException {
        if (i2 >= 0 && ((this.yuvImage != null || (i >= 0 && i3 >= 0)) && i4 >= 0 && i4 < 12 && i5 >= 0)) {
            int pixelSize = TJ.getPixelSize(i4);
            int scaledWidth = getScaledWidth(i, i3);
            int scaledHeight = getScaledHeight(i, i3);
            if (i2 == 0) {
                i2 = scaledWidth * pixelSize;
            }
            int i6 = i2;
            byte[] bArr = new byte[scaledHeight * i6];
            decompress(bArr, i, i6, i3, i4, i5);
            return bArr;
        }
        throw new IllegalArgumentException("Invalid argument in decompress()");
    }

    public void decompress(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) throws TJException {
        YUVImage yUVImage;
        byte[] bArr = this.jpegBuf;
        if (bArr == null && this.yuvImage == null) {
            throw new IllegalStateException(NO_ASSOC_ERROR);
        }
        if (iArr == null || i < 0 || i2 < 0 || i4 < 0 || (((yUVImage = this.yuvImage) != null && (i3 < 0 || i5 < 0)) || i6 < 0 || i6 >= 12 || i7 < 0)) {
            throw new IllegalArgumentException("Invalid argument in decompress()");
        }
        if (yUVImage != null) {
            decodeYUV(yUVImage.getPlanes(), this.yuvImage.getOffsets(), this.yuvImage.getStrides(), this.yuvImage.getSubsamp(), iArr, i, i2, this.yuvImage.getWidth(), i4, this.yuvImage.getHeight(), i6, i7);
        } else {
            decompress(bArr, this.jpegBufSize, iArr, i, i2, i3, i4, i5, i6, i7);
        }
    }

    @Deprecated
    public void decompressToYUV(byte[] bArr, int i) throws TJException {
        decompressToYUV(new YUVImage(bArr, this.jpegWidth, 4, this.jpegHeight, this.jpegSubsamp), i);
    }

    public YUVImage decompressToYUV(int i, int[] iArr, int i2, int i3) throws TJException {
        int i4;
        if (i3 >= 0) {
            if (this.jpegWidth < 1 || this.jpegHeight < 1 || (i4 = this.jpegSubsamp) < 0) {
                throw new IllegalStateException(NO_ASSOC_ERROR);
            }
            if (i4 < 6) {
                if (this.yuvImage == null) {
                    YUVImage yUVImage = new YUVImage(getScaledWidth(i, i2), (int[]) null, getScaledHeight(i, i2), this.jpegSubsamp);
                    decompressToYUV(yUVImage, i3);
                    return yUVImage;
                }
                throw new IllegalStateException("Source image is the wrong type");
            }
            throw new IllegalStateException("JPEG header information is invalid");
        }
        throw new IllegalArgumentException("Invalid argument in decompressToYUV()");
    }

    public TJDecompressor(byte[] bArr, int i) throws TJException {
        init();
        setSourceImage(bArr, i);
    }

    public YUVImage decompressToYUV(int i, int i2, int i3, int i4) throws TJException {
        int i5;
        if (i4 >= 0) {
            if (this.jpegWidth < 1 || this.jpegHeight < 1 || (i5 = this.jpegSubsamp) < 0) {
                throw new IllegalStateException(NO_ASSOC_ERROR);
            }
            if (i5 < 6) {
                if (this.yuvImage == null) {
                    YUVImage yUVImage = new YUVImage(getScaledWidth(i, i3), i2, getScaledHeight(i, i3), this.jpegSubsamp);
                    decompressToYUV(yUVImage, i4);
                    return yUVImage;
                }
                throw new IllegalStateException("Source image is the wrong type");
            }
            throw new IllegalStateException("JPEG header information is invalid");
        }
        throw new IllegalArgumentException("Invalid argument in decompressToYUV()");
    }

    public TJDecompressor(YUVImage yUVImage) throws TJException {
        init();
        setSourceImage(yUVImage);
    }

    @Deprecated
    public byte[] decompressToYUV(int i) throws TJException {
        YUVImage yUVImage = new YUVImage(this.jpegWidth, 4, this.jpegHeight, this.jpegSubsamp);
        decompressToYUV(yUVImage, i);
        return yUVImage.getBuf();
    }
}
