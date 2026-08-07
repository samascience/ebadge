package defpackage;

import androidx.camera.core.impl.UseCaseConfigFactory;

/* JADX INFO: loaded from: classes.dex */
public abstract class n13 {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[UseCaseConfigFactory.CaptureType.values().length];
            a = iArr;
            try {
                iArr[UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[UseCaseConfigFactory.CaptureType.STREAM_SHARING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[UseCaseConfigFactory.CaptureType.PREVIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static int a(UseCaseConfigFactory.CaptureType captureType, int i) {
        int i2 = a.a[captureType.ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? 1 : 3;
        }
        return i == 2 ? 5 : 2;
    }

    public static int b(UseCaseConfigFactory.CaptureType captureType, int i) {
        int i2 = a.a[captureType.ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? 1 : 3;
        }
        return i == 2 ? 5 : 1;
    }
}
