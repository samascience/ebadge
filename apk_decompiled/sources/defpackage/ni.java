package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.util.Log;
import android.view.WindowManager;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ni {
    public static int a(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0) {
            return 2;
        }
        if (i == i3 && i2 == i4) {
            return 2;
        }
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            while (true) {
                if (i2 / i5 <= i4 && i / i5 <= i3) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int iSqrt = (int) Math.sqrt(Math.pow(point.x, 2.0d) + Math.pow(point.y, 2.0d));
        Canvas canvas = new Canvas();
        int iMin = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
        if (iMin > 0) {
            iSqrt = Math.min(iSqrt, iMin);
        }
        int iB = gf0.b();
        if (iB > 0) {
            iSqrt = Math.min(iSqrt, iB);
        }
        Log.d("BitmapLoadUtils", "maxBitmapSize: " + iSqrt);
        return iSqrt;
    }

    public static void c(Closeable closeable) {
        if (closeable instanceof Closeable) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void d(Context context, Uri uri, Uri uri2, int i, int i2, int i3, int i4, li liVar) {
        new mi(context, uri, uri2, i, i2, i3, i4, liVar).executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
    }

    public static int e(int i) {
        switch (i) {
            case 3:
            case 4:
                return Opcodes.GETFIELD;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int f(int i) {
        return (i == 2 || i == 7 || i == 4 || i == 5) ? -1 : 1;
    }

    public static int g(Context context, Uri uri) {
        try {
            InputStream inputStreamA = y02.a(context, uri);
            if (inputStreamA == null) {
                return 0;
            }
            return new l01(inputStreamA).c();
        } catch (IOException e) {
            Log.e("BitmapLoadUtils", "getExifOrientation: " + uri.toString(), e);
            return 0;
        }
    }

    public static Bitmap h(Bitmap bitmap, Matrix matrix) {
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return !bitmap.sameAs(bitmapCreateBitmap) ? bitmapCreateBitmap : bitmap;
        } catch (OutOfMemoryError e) {
            Log.e("BitmapLoadUtils", "transformBitmap: ", e);
            return bitmap;
        }
    }
}
