package org.libjpegturbo.turbojpeg;

import java.io.Closeable;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes4.dex */
public class TJCompressor implements Closeable {
    private static final String NO_ASSOC_ERROR = "No source image is associated with this instance";
    private long handle = 0;
    private byte[] srcBuf = null;
    private int[] srcBufInt = null;
    private int srcWidth = 0;
    private int srcHeight = 0;
    private int srcX = -1;
    private int srcY = -1;
    private int srcPitch = 0;
    private int srcStride = 0;
    private int srcPixelFormat = -1;
    private YUVImage srcYUVImage = null;
    private int subsamp = -1;
    private int jpegQuality = -1;
    private int compressedSize = 0;
    private int yuvPad = 4;
    private ByteOrder byteOrder = null;

    static {
        TJLoader.load();
    }

    public TJCompressor() throws TJException {
        init();
    }

    private void checkSourceImage() {
        if (this.srcWidth < 1 || this.srcHeight < 1) {
            throw new IllegalStateException(NO_ASSOC_ERROR);
        }
    }

    private void checkSubsampling() {
        if (this.subsamp < 0) {
            throw new IllegalStateException("Subsampling level not set");
        }
    }

    private native int compress(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr2, int i7, int i8, int i9) throws TJException;

    @Deprecated
    private native int compress(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2, int i5, int i6, int i7) throws TJException;

    private native int compress(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr, int i7, int i8, int i9) throws TJException;

    @Deprecated
    private native int compress(int[] iArr, int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6, int i7) throws TJException;

    private native int compressFromYUV(byte[][] bArr, int[] iArr, int i, int[] iArr2, int i2, int i3, byte[] bArr2, int i4, int i5) throws TJException;

    private native void destroy() throws TJException;

    private native void encodeYUV(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, byte[][] bArr2, int[] iArr, int[] iArr2, int i7, int i8) throws TJException;

    @Deprecated
    private native void encodeYUV(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2, int i5, int i6) throws TJException;

    private native void encodeYUV(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, byte[][] bArr, int[] iArr2, int[] iArr3, int i7, int i8) throws TJException;

    @Deprecated
    private native void encodeYUV(int[] iArr, int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6) throws TJException;

    private native void init() throws TJException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws TJException {
        if (this.handle != 0) {
            destroy();
        }
    }

    public void compress(byte[] bArr, int i) throws TJException {
        int i2;
        int i3;
        if (bArr == null || i < 0) {
            throw new IllegalArgumentException("Invalid argument in compress()");
        }
        byte[] bArr2 = this.srcBuf;
        if (bArr2 == null && this.srcBufInt == null && this.srcYUVImage == null) {
            throw new IllegalStateException(NO_ASSOC_ERROR);
        }
        int i4 = this.jpegQuality;
        if (i4 < 0) {
            throw new IllegalStateException("JPEG Quality not set");
        }
        int i5 = this.subsamp;
        if (i5 < 0 && this.srcYUVImage == null) {
            throw new IllegalStateException("Subsampling level not set");
        }
        YUVImage yUVImage = this.srcYUVImage;
        if (yUVImage != null) {
            this.compressedSize = compressFromYUV(yUVImage.getPlanes(), this.srcYUVImage.getOffsets(), this.srcYUVImage.getWidth(), this.srcYUVImage.getStrides(), this.srcYUVImage.getHeight(), this.srcYUVImage.getSubsamp(), bArr, this.jpegQuality, i);
            return;
        }
        if (bArr2 != null) {
            int i6 = this.srcX;
            if (i6 < 0 || (i3 = this.srcY) < 0) {
                this.compressedSize = compress(bArr2, this.srcWidth, this.srcPitch, this.srcHeight, this.srcPixelFormat, bArr, i5, i4, i);
                return;
            } else {
                this.compressedSize = compress(bArr2, i6, i3, this.srcWidth, this.srcPitch, this.srcHeight, this.srcPixelFormat, bArr, i5, i4, i);
                return;
            }
        }
        int[] iArr = this.srcBufInt;
        if (iArr != null) {
            int i7 = this.srcX;
            if (i7 < 0 || (i2 = this.srcY) < 0) {
                this.compressedSize = compress(iArr, this.srcWidth, this.srcStride, this.srcHeight, this.srcPixelFormat, bArr, i5, i4, i);
            } else {
                this.compressedSize = compress(iArr, i7, i2, this.srcWidth, this.srcStride, this.srcHeight, this.srcPixelFormat, bArr, i5, i4, i);
            }
        }
    }

    public void encodeYUV(YUVImage yUVImage, int i) throws TJException {
        if (yUVImage == null || i < 0) {
            throw new IllegalArgumentException("Invalid argument in encodeYUV()");
        }
        if (this.srcBuf == null && this.srcBufInt == null) {
            throw new IllegalStateException(NO_ASSOC_ERROR);
        }
        if (this.srcYUVImage != null) {
            throw new IllegalStateException("Source image is not correct type");
        }
        checkSubsampling();
        if (this.srcWidth != yUVImage.getWidth() || this.srcHeight != yUVImage.getHeight()) {
            throw new IllegalStateException("Destination image is the wrong size");
        }
        int[] iArr = this.srcBufInt;
        if (iArr != null) {
            encodeYUV(iArr, this.srcX, this.srcY, this.srcWidth, this.srcStride, this.srcHeight, this.srcPixelFormat, yUVImage.getPlanes(), yUVImage.getOffsets(), yUVImage.getStrides(), yUVImage.getSubsamp(), i);
        } else {
            encodeYUV(this.srcBuf, this.srcX, this.srcY, this.srcWidth, this.srcPitch, this.srcHeight, this.srcPixelFormat, yUVImage.getPlanes(), yUVImage.getOffsets(), yUVImage.getStrides(), yUVImage.getSubsamp(), i);
        }
        this.compressedSize = 0;
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } catch (TJException unused) {
        } finally {
            super.finalize();
        }
    }

    public int getCompressedSize() {
        return this.compressedSize;
    }

    public void setJPEGQuality(int i) {
        if (i < 1 || i > 100) {
            throw new IllegalArgumentException("Invalid argument in setJPEGQuality()");
        }
        this.jpegQuality = i;
    }

    public void setSourceImage(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) throws TJException {
        if (this.handle == 0) {
            init();
        }
        if (bArr == null || i < 0 || i2 < 0 || i3 < 1 || i5 < 1 || i4 < 0 || i6 < 0 || i6 >= 12) {
            throw new IllegalArgumentException("Invalid argument in setSourceImage()");
        }
        this.srcBuf = bArr;
        this.srcWidth = i3;
        if (i4 == 0) {
            this.srcPitch = i3 * TJ.getPixelSize(i6);
        } else {
            this.srcPitch = i4;
        }
        this.srcHeight = i5;
        this.srcPixelFormat = i6;
        this.srcX = i;
        this.srcY = i2;
        this.srcBufInt = null;
        this.srcYUVImage = null;
    }

    public void setSubsamp(int i) {
        if (i < 0 || i >= 6) {
            throw new IllegalArgumentException("Invalid argument in setSubsamp()");
        }
        this.subsamp = i;
    }

    @Deprecated
    public void setSourceImage(byte[] bArr, int i, int i2, int i3, int i4) throws TJException {
        setSourceImage(bArr, 0, 0, i, i2, i3, i4);
        this.srcY = -1;
        this.srcX = -1;
    }

    public void setSourceImage(YUVImage yUVImage) throws TJException {
        if (this.handle == 0) {
            init();
        }
        if (yUVImage != null) {
            this.srcYUVImage = yUVImage;
            this.srcBuf = null;
            this.srcBufInt = null;
            return;
        }
        throw new IllegalArgumentException("Invalid argument in setSourceImage()");
    }

    public TJCompressor(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) throws TJException {
        setSourceImage(bArr, i, i2, i3, i4, i5, i6);
    }

    @Deprecated
    public void encodeYUV(byte[] bArr, int i) throws TJException {
        if (bArr != null) {
            checkSourceImage();
            checkSubsampling();
            encodeYUV(new YUVImage(bArr, this.srcWidth, 4, this.srcHeight, this.subsamp), i);
            return;
        }
        throw new IllegalArgumentException("Invalid argument in encodeYUV()");
    }

    public byte[] compress(int i) throws TJException {
        byte[] bArr;
        YUVImage yUVImage = this.srcYUVImage;
        if (yUVImage != null) {
            bArr = new byte[TJ.bufSize(yUVImage.getWidth(), this.srcYUVImage.getHeight(), this.srcYUVImage.getSubsamp())];
        } else {
            checkSourceImage();
            bArr = new byte[TJ.bufSize(this.srcWidth, this.srcHeight, this.subsamp)];
        }
        compress(bArr, i);
        return bArr;
    }

    public YUVImage encodeYUV(int i, int i2) throws TJException {
        checkSourceImage();
        checkSubsampling();
        if (i >= 1 && ((i - 1) & i) == 0) {
            YUVImage yUVImage = new YUVImage(this.srcWidth, i, this.srcHeight, this.subsamp);
            encodeYUV(yUVImage, i2);
            return yUVImage;
        }
        throw new IllegalStateException("Invalid argument in encodeYUV()");
    }

    public YUVImage encodeYUV(int[] iArr, int i) throws TJException {
        checkSourceImage();
        checkSubsampling();
        YUVImage yUVImage = new YUVImage(this.srcWidth, iArr, this.srcHeight, this.subsamp);
        encodeYUV(yUVImage, i);
        return yUVImage;
    }

    @Deprecated
    public byte[] encodeYUV(int i) throws TJException {
        checkSourceImage();
        checkSubsampling();
        YUVImage yUVImage = new YUVImage(this.srcWidth, 4, this.srcHeight, this.subsamp);
        encodeYUV(yUVImage, i);
        return yUVImage.getBuf();
    }

    @Deprecated
    public TJCompressor(byte[] bArr, int i, int i2, int i3, int i4) throws TJException {
        setSourceImage(bArr, i, i2, i3, i4);
    }
}
