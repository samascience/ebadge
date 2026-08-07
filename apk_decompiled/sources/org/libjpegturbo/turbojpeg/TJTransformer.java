package org.libjpegturbo.turbojpeg;

/* JADX INFO: loaded from: classes4.dex */
public class TJTransformer extends TJDecompressor {
    private int[] transformedSizes = null;

    static {
        TJLoader.load();
    }

    public TJTransformer() throws TJException {
        init();
    }

    private native void init() throws TJException;

    public int[] getTransformedSizes() {
        int[] iArr = this.transformedSizes;
        if (iArr != null) {
            return iArr;
        }
        throw new IllegalStateException("No image has been transformed yet");
    }

    public TJTransformer(byte[] bArr) throws TJException {
        init();
        setSourceImage(bArr, bArr.length);
    }

    public TJTransformer(byte[] bArr, int i) throws TJException {
        init();
        setSourceImage(bArr, i);
    }
}
