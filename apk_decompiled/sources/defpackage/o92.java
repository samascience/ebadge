package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.WindowManager;
import cn.bertsir.zbar.Qr.Image;
import cn.bertsir.zbar.Qr.ImageScanner;
import cn.bertsir.zbar.Qr.Symbol;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class o92 {
    private static o92 b;
    private Bitmap a;

    private Bitmap a(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        this.a = BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int iMax = Math.max((int) (options.outHeight / 800.0f), (int) (options.outWidth / 800.0f));
        options.inSampleSize = iMax > 0 ? iMax : 1;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeFile(str, options);
    }

    public static o92 i() {
        if (b == null) {
            b = new o92();
        }
        return b;
    }

    private Bitmap o(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    public String b(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        Image image = new Image(width, height, "RGB4");
        image.setData(iArr);
        ImageScanner imageScanner = new ImageScanner();
        imageScanner.setConfig(0, 0, 0);
        imageScanner.setConfig(128, 0, 1);
        imageScanner.setConfig(39, 0, 1);
        imageScanner.setConfig(13, 0, 1);
        imageScanner.setConfig(8, 0, 1);
        imageScanner.setConfig(12, 0, 1);
        imageScanner.setConfig(9, 0, 1);
        String data = null;
        if (imageScanner.scanImage(image.convert("Y800")) != 0) {
            Iterator<Symbol> it = imageScanner.getResults().iterator();
            while (it.hasNext()) {
                data = it.next().getData();
            }
        }
        return data;
    }

    public String c(String str) {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        return bitmapDecodeFile != null ? b(bitmapDecodeFile) : Constants.STR_EMPTY;
    }

    public String d(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        Image image = new Image(width, height, "RGB4");
        image.setData(iArr);
        ImageScanner imageScanner = new ImageScanner();
        imageScanner.setConfig(0, 0, 0);
        imageScanner.setConfig(64, 0, 1);
        String data = null;
        if (imageScanner.scanImage(image.convert("Y800")) != 0) {
            Iterator<Symbol> it = imageScanner.getResults().iterator();
            while (it.hasNext()) {
                data = it.next().getData();
            }
        }
        bitmap.recycle();
        return data;
    }

    public String e(String str) {
        Bitmap bitmapO = o(a(str));
        return bitmapO != null ? d(bitmapO) : Constants.STR_EMPTY;
    }

    public String f(String str) {
        kh2 kh2VarA = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, Constants.ENC_UTF_8);
        Bitmap bitmapA = a(str);
        int[] iArr = new int[bitmapA.getWidth() * bitmapA.getHeight()];
        bitmapA.getPixels(iArr, 0, bitmapA.getWidth(), 0, 0, bitmapA.getWidth(), bitmapA.getHeight());
        try {
            kh2VarA = new n92().a(new th(new uu0(new x92(bitmapA.getWidth(), bitmapA.getHeight(), iArr))), hashtable);
        } catch (ChecksumException | FormatException | NotFoundException unused) {
        }
        return kh2VarA == null ? Constants.STR_EMPTY : kh2VarA.f();
    }

    public boolean g(String str) {
        File file = new File(str);
        return file.exists() && file.isFile() && file.delete();
    }

    public float h(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public int j(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public int k(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    public void l(Context context) {
        ((Vibrator) context.getSystemService("vibrator")).vibrate(new long[]{0, 50, 0, 0}, -1);
    }

    public boolean m() {
        return "xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public boolean n(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }
}
