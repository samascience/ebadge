package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public abstract class si {
    public static int a(int i, int i2) {
        if (i % 2 == 1) {
            i++;
        }
        if (i2 % 2 == 1) {
            i2++;
        }
        int iMax = Math.max(i, i2);
        float fMin = Math.min(i, i2) / iMax;
        if (fMin > 1.0f || fMin <= 0.5625d) {
            double d = fMin;
            if (d > 0.5625d || d <= 0.5d) {
                return (int) Math.ceil(((double) iMax) / (1280.0d / d));
            }
            int i3 = iMax / 1280;
            if (i3 == 0) {
                return 1;
            }
            return i3;
        }
        if (iMax < 1664) {
            return 1;
        }
        if (iMax < 4990) {
            return 2;
        }
        if (iMax <= 4990 || iMax >= 10240) {
            return iMax / 1280;
        }
        return 4;
    }

    public static int b(Context context, String str) {
        dj0 dj0Var;
        InputStream inputStreamA = null;
        try {
            try {
                if (a22.h(str)) {
                    inputStreamA = y02.a(context, Uri.parse(str));
                    dj0Var = new dj0(inputStreamA);
                } else {
                    dj0Var = new dj0(str);
                }
                int iO = dj0Var.o("Orientation", 1);
                if (iO == 3) {
                    s12.a(inputStreamA);
                    return Opcodes.GETFIELD;
                }
                if (iO == 6) {
                    s12.a(inputStreamA);
                    return 90;
                }
                if (iO != 8) {
                    s12.a(inputStreamA);
                    return 0;
                }
                s12.a(inputStreamA);
                return 270;
            } catch (Exception e) {
                e.printStackTrace();
                s12.a(inputStreamA);
                return 0;
            }
        } catch (Throwable th) {
            s12.a(inputStreamA);
            throw th;
        }
    }

    public static int c(InputStream inputStream) {
        try {
            int iO = new dj0(inputStream).o("Orientation", 1);
            if (iO == 3) {
                return Opcodes.GETFIELD;
            }
            if (iO != 6) {
                return iO != 8 ? 0 : 270;
            }
            return 90;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void d(Context context, boolean z, String str) throws Throwable {
        if (z) {
            try {
                int iB = b(context, str);
                if (iB > 0) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    File file = new File(str);
                    Bitmap bitmapE = e(BitmapFactory.decodeFile(file.getAbsolutePath(), options), iB);
                    if (bitmapE != null) {
                        f(bitmapE, file);
                        bitmapE.recycle();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Bitmap e(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static void f(Bitmap bitmap, File file) throws Throwable {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    s12.a(bufferedOutputStream2);
                } catch (Exception e) {
                    e = e;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    s12.a(bufferedOutputStream);
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    s12.a(bufferedOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Bitmap g(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        matrix.postRotate(width > height ? 90.0f : 0.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
