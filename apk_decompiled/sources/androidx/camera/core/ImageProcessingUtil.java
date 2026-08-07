package androidx.camera.core;

import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageWriter;
import android.util.Log;
import android.view.Surface;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.v;
import defpackage.b52;
import defpackage.g11;
import defpackage.x01;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class ImageProcessingUtil {
    private static int a;

    enum Result {
        UNKNOWN,
        SUCCESS,
        ERROR_CONVERSION
    }

    static {
        System.loadLibrary("image_processing_util_jni");
    }

    public static boolean c(v vVar) {
        if (!l(vVar)) {
            x.c("ImageProcessingUtil", "Unsupported format for YUV to RGB");
            return false;
        }
        if (d(vVar) != Result.ERROR_CONVERSION) {
            return true;
        }
        x.c("ImageProcessingUtil", "One pixel shift for YUV failure");
        return false;
    }

    private static Result d(v vVar) {
        int width = vVar.getWidth();
        int height = vVar.getHeight();
        int iA = vVar.r()[0].a();
        int iA2 = vVar.r()[1].a();
        int iA3 = vVar.r()[2].a();
        int iC = vVar.r()[0].c();
        int iC2 = vVar.r()[1].c();
        return nativeShiftPixel(vVar.r()[0].b(), iA, vVar.r()[1].b(), iA2, vVar.r()[2].b(), iA3, iC, iC2, width, height, iC, iC2, iC2) != 0 ? Result.ERROR_CONVERSION : Result.SUCCESS;
    }

    public static v e(x01 x01Var, byte[] bArr) {
        b52.a(x01Var.d() == 256);
        b52.g(bArr);
        Surface surfaceA = x01Var.a();
        b52.g(surfaceA);
        if (nativeWriteJpegToSurface(bArr, surfaceA) != 0) {
            x.c("ImageProcessingUtil", "Failed to enqueue JPEG image.");
            return null;
        }
        v vVarC = x01Var.c();
        if (vVarC == null) {
            x.c("ImageProcessingUtil", "Failed to get acquire JPEG image.");
        }
        return vVarC;
    }

    public static Bitmap f(v vVar) {
        if (vVar.q() != 35) {
            throw new IllegalArgumentException("Input image format must be YUV_420_888");
        }
        int width = vVar.getWidth();
        int height = vVar.getHeight();
        int iA = vVar.r()[0].a();
        int iA2 = vVar.r()[1].a();
        int iA3 = vVar.r()[2].a();
        int iC = vVar.r()[0].c();
        int iC2 = vVar.r()[1].c();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(vVar.getWidth(), vVar.getHeight(), Bitmap.Config.ARGB_8888);
        if (nativeConvertAndroid420ToBitmap(vVar.r()[0].b(), iA, vVar.r()[1].b(), iA2, vVar.r()[2].b(), iA3, iC, iC2, bitmapCreateBitmap, bitmapCreateBitmap.getRowBytes(), width, height) == 0) {
            return bitmapCreateBitmap;
        }
        throw new UnsupportedOperationException("YUV to RGB conversion failed");
    }

    public static v g(final v vVar, x01 x01Var, ByteBuffer byteBuffer, int i, boolean z) {
        if (!l(vVar)) {
            x.c("ImageProcessingUtil", "Unsupported format for YUV to RGB");
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!k(i)) {
            x.c("ImageProcessingUtil", "Unsupported rotation degrees for rotate RGB");
            return null;
        }
        if (h(vVar, x01Var.a(), byteBuffer, i, z) == Result.ERROR_CONVERSION) {
            x.c("ImageProcessingUtil", "YUV to RGB conversion failure");
            return null;
        }
        if (Log.isLoggable("MH", 3)) {
            x.a("ImageProcessingUtil", String.format(Locale.US, "Image processing performance profiling, duration: [%d], image count: %d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), Integer.valueOf(a)));
            a++;
        }
        final v vVarC = x01Var.c();
        if (vVarC == null) {
            x.c("ImageProcessingUtil", "YUV to RGB acquireLatestImage failure");
            return null;
        }
        d0 d0Var = new d0(vVarC);
        d0Var.n(new l.a() { // from class: s01
            @Override // androidx.camera.core.l.a
            public final void b(v vVar2) {
                ImageProcessingUtil.m(vVarC, vVar, vVar2);
            }
        });
        return d0Var;
    }

    private static Result h(v vVar, Surface surface, ByteBuffer byteBuffer, int i, boolean z) {
        int width = vVar.getWidth();
        int height = vVar.getHeight();
        int iA = vVar.r()[0].a();
        int iA2 = vVar.r()[1].a();
        int iA3 = vVar.r()[2].a();
        int iC = vVar.r()[0].c();
        int iC2 = vVar.r()[1].c();
        return nativeConvertAndroid420ToABGR(vVar.r()[0].b(), iA, vVar.r()[1].b(), iA2, vVar.r()[2].b(), iA3, iC, iC2, surface, byteBuffer, width, height, z ? iC : 0, z ? iC2 : 0, z ? iC2 : 0, i) != 0 ? Result.ERROR_CONVERSION : Result.SUCCESS;
    }

    public static void i(Bitmap bitmap, ByteBuffer byteBuffer, int i) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, bitmap.getRowBytes(), i, bitmap.getWidth(), bitmap.getHeight(), false);
    }

    public static void j(Bitmap bitmap, ByteBuffer byteBuffer, int i) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, i, bitmap.getRowBytes(), bitmap.getWidth(), bitmap.getHeight(), true);
    }

    private static boolean k(int i) {
        return i == 0 || i == 90 || i == 180 || i == 270;
    }

    private static boolean l(v vVar) {
        return vVar.q() == 35 && vVar.r().length == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(v vVar, v vVar2, v vVar3) {
        if (vVar == null || vVar2 == null) {
            return;
        }
        vVar2.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(v vVar, v vVar2, v vVar3) {
        if (vVar == null || vVar2 == null) {
            return;
        }
        vVar2.close();
    }

    private static native int nativeConvertAndroid420ToABGR(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5, Surface surface, ByteBuffer byteBuffer4, int i6, int i7, int i8, int i9, int i10, int i11);

    private static native int nativeConvertAndroid420ToBitmap(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5, Bitmap bitmap, int i6, int i7, int i8);

    private static native int nativeCopyBetweenByteBufferAndBitmap(Bitmap bitmap, ByteBuffer byteBuffer, int i, int i2, int i3, int i4, boolean z);

    private static native int nativeRotateYUV(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, ByteBuffer byteBuffer4, int i5, int i6, ByteBuffer byteBuffer5, int i7, int i8, ByteBuffer byteBuffer6, int i9, int i10, ByteBuffer byteBuffer7, ByteBuffer byteBuffer8, ByteBuffer byteBuffer9, int i11, int i12, int i13);

    private static native int nativeShiftPixel(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    private static native int nativeWriteJpegToSurface(byte[] bArr, Surface surface);

    public static v o(final v vVar, x01 x01Var, ImageWriter imageWriter, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        if (!l(vVar)) {
            x.c("ImageProcessingUtil", "Unsupported format for rotate YUV");
            return null;
        }
        if (!k(i)) {
            x.c("ImageProcessingUtil", "Unsupported rotation degrees for rotate YUV");
            return null;
        }
        Result result = Result.ERROR_CONVERSION;
        if ((i > 0 ? p(vVar, imageWriter, byteBuffer, byteBuffer2, byteBuffer3, i) : result) == result) {
            x.c("ImageProcessingUtil", "rotate YUV failure");
            return null;
        }
        final v vVarC = x01Var.c();
        if (vVarC == null) {
            x.c("ImageProcessingUtil", "YUV rotation acquireLatestImage failure");
            return null;
        }
        d0 d0Var = new d0(vVarC);
        d0Var.n(new l.a() { // from class: t01
            @Override // androidx.camera.core.l.a
            public final void b(v vVar2) {
                ImageProcessingUtil.n(vVarC, vVar, vVar2);
            }
        });
        return d0Var;
    }

    private static Result p(v vVar, ImageWriter imageWriter, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        int width = vVar.getWidth();
        int height = vVar.getHeight();
        int iA = vVar.r()[0].a();
        int iA2 = vVar.r()[1].a();
        int iA3 = vVar.r()[2].a();
        int iC = vVar.r()[1].c();
        Image imageB = g11.b(imageWriter);
        if (imageB != null && nativeRotateYUV(vVar.r()[0].b(), iA, vVar.r()[1].b(), iA2, vVar.r()[2].b(), iA3, iC, imageB.getPlanes()[0].getBuffer(), imageB.getPlanes()[0].getRowStride(), imageB.getPlanes()[0].getPixelStride(), imageB.getPlanes()[1].getBuffer(), imageB.getPlanes()[1].getRowStride(), imageB.getPlanes()[1].getPixelStride(), imageB.getPlanes()[2].getBuffer(), imageB.getPlanes()[2].getRowStride(), imageB.getPlanes()[2].getPixelStride(), byteBuffer, byteBuffer2, byteBuffer3, width, height, i) == 0) {
            g11.d(imageWriter, imageB);
            return Result.SUCCESS;
        }
        return Result.ERROR_CONVERSION;
    }

    public static boolean q(Surface surface, byte[] bArr) {
        b52.g(bArr);
        b52.g(surface);
        if (nativeWriteJpegToSurface(bArr, surface) == 0) {
            return true;
        }
        x.c("ImageProcessingUtil", "Failed to enqueue JPEG image.");
        return false;
    }
}
