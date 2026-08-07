package androidx.camera.core.internal.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.c;
import androidx.camera.core.v;
import androidx.camera.core.x;
import defpackage.b52;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class ImageUtil {
    public static Rect a(Size size, Rational rational) {
        int i;
        if (!h(rational)) {
            x.k("ImageUtil", "Invalid view ratio.");
            return null;
        }
        int width = size.getWidth();
        int height = size.getHeight();
        float f = width;
        float f2 = height;
        float f3 = f / f2;
        int numerator = rational.getNumerator();
        int denominator = rational.getDenominator();
        int i2 = 0;
        if (rational.floatValue() > f3) {
            int iRound = Math.round((f / numerator) * denominator);
            i = (height - iRound) / 2;
            height = iRound;
        } else {
            int iRound2 = Math.round((f2 / denominator) * numerator);
            int i3 = (width - iRound2) / 2;
            width = iRound2;
            i = 0;
            i2 = i3;
        }
        return new Rect(i2, i, width + i2, height + i);
    }

    public static Bitmap b(v vVar) {
        int iQ = vVar.q();
        if (iQ == 1) {
            return d(vVar);
        }
        if (iQ == 35) {
            return ImageProcessingUtil.f(vVar);
        }
        if (iQ == 256 || iQ == 4101) {
            return c(vVar);
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + vVar.q() + ", only ImageFormat.YUV_420_888 and PixelFormat.RGBA_8888 are supported");
    }

    private static Bitmap c(v vVar) {
        byte[] bArrJ = j(vVar);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrJ, 0, bArrJ.length, null);
        if (bitmapDecodeByteArray != null) {
            return bitmapDecodeByteArray;
        }
        throw new UnsupportedOperationException("Decode jpeg byte array failed");
    }

    private static Bitmap d(v vVar) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(vVar.getWidth(), vVar.getHeight(), Bitmap.Config.ARGB_8888);
        vVar.r()[0].b().rewind();
        ImageProcessingUtil.j(bitmapCreateBitmap, vVar.r()[0].b(), vVar.r()[0].a());
        return bitmapCreateBitmap;
    }

    public static ByteBuffer e(Bitmap bitmap) {
        b52.b(bitmap.getConfig() == Bitmap.Config.ARGB_8888, "Only accept Bitmap with ARGB_8888 format for now.");
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bitmap.getAllocationByteCount());
        ImageProcessingUtil.i(bitmap, byteBufferAllocateDirect, bitmap.getRowBytes());
        byteBufferAllocateDirect.rewind();
        return byteBufferAllocateDirect;
    }

    public static Rational f(int i, Rational rational) {
        return (i == 90 || i == 270) ? g(rational) : new Rational(rational.getNumerator(), rational.getDenominator());
    }

    private static Rational g(Rational rational) {
        return rational == null ? rational : new Rational(rational.getDenominator(), rational.getNumerator());
    }

    public static boolean h(Rational rational) {
        return (rational == null || rational.floatValue() <= 0.0f || rational.isNaN()) ? false : true;
    }

    public static boolean i(int i) {
        return i == 256 || i == 4101;
    }

    public static byte[] j(v vVar) {
        if (!i(vVar.q())) {
            throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + vVar.q());
        }
        ByteBuffer byteBufferB = vVar.r()[0].b();
        byte[] bArr = new byte[byteBufferB.capacity()];
        byteBufferB.rewind();
        byteBufferB.get(bArr);
        return bArr;
    }

    public static Bitmap k(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static byte[] l(v vVar, Rect rect, int i, int i2) throws CodecFailedException {
        if (vVar.q() != 35) {
            throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + vVar.q());
        }
        YuvImage yuvImage = new YuvImage(m(vVar), 17, vVar.getWidth(), vVar.getHeight(), null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        c cVar = new c(byteArrayOutputStream, ExifData.b(vVar, i2));
        if (rect == null) {
            rect = new Rect(0, 0, vVar.getWidth(), vVar.getHeight());
        }
        if (yuvImage.compressToJpeg(rect, i, cVar)) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new CodecFailedException("YuvImage failed to encode jpeg.", CodecFailedException.FailureType.ENCODE_FAILED);
    }

    public static byte[] m(v vVar) {
        v.a aVar = vVar.r()[0];
        v.a aVar2 = vVar.r()[1];
        v.a aVar3 = vVar.r()[2];
        ByteBuffer byteBufferB = aVar.b();
        ByteBuffer byteBufferB2 = aVar2.b();
        ByteBuffer byteBufferB3 = aVar3.b();
        byteBufferB.rewind();
        byteBufferB2.rewind();
        byteBufferB3.rewind();
        int iRemaining = byteBufferB.remaining();
        byte[] bArr = new byte[((vVar.getWidth() * vVar.getHeight()) / 2) + iRemaining];
        int width = 0;
        for (int i = 0; i < vVar.getHeight(); i++) {
            byteBufferB.get(bArr, width, vVar.getWidth());
            width += vVar.getWidth();
            byteBufferB.position(Math.min(iRemaining, (byteBufferB.position() - vVar.getWidth()) + aVar.a()));
        }
        int height = vVar.getHeight() / 2;
        int width2 = vVar.getWidth() / 2;
        int iA = aVar3.a();
        int iA2 = aVar2.a();
        int iC = aVar3.c();
        int iC2 = aVar2.c();
        byte[] bArr2 = new byte[iA];
        byte[] bArr3 = new byte[iA2];
        for (int i2 = 0; i2 < height; i2++) {
            byteBufferB3.get(bArr2, 0, Math.min(iA, byteBufferB3.remaining()));
            byteBufferB2.get(bArr3, 0, Math.min(iA2, byteBufferB2.remaining()));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < width2; i5++) {
                int i6 = width + 1;
                bArr[width] = bArr2[i3];
                width += 2;
                bArr[i6] = bArr3[i4];
                i3 += iC;
                i4 += iC2;
            }
        }
        return bArr;
    }

    public static final class CodecFailedException extends Exception {
        private final FailureType mFailureType;

        public enum FailureType {
            ENCODE_FAILED,
            DECODE_FAILED,
            UNKNOWN
        }

        CodecFailedException(String str) {
            super(str);
            this.mFailureType = FailureType.UNKNOWN;
        }

        public FailureType getFailureType() {
            return this.mFailureType;
        }

        CodecFailedException(String str, FailureType failureType) {
            super(str);
            this.mFailureType = failureType;
        }
    }
}
