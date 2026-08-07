package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class lz0 {
    private static final Object d = new Object();
    private final Context a;
    private String b;
    private final Map c;

    public lz0(Drawable.Callback callback, String str, kz0 kz0Var, Map map) {
        this.b = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.b;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.b += JsonPointer.SEPARATOR;
            }
        }
        if (callback instanceof View) {
            this.a = ((View) callback).getContext();
            this.c = map;
            e(kz0Var);
        } else {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.c = new HashMap();
            this.a = null;
        }
    }

    private Bitmap c(String str, Bitmap bitmap) {
        synchronized (d) {
            ((le1) this.c.get(str)).d(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        le1 le1Var = (le1) this.c.get(str);
        if (le1Var == null) {
            return null;
        }
        Bitmap bitmapA = le1Var.a();
        if (bitmapA != null) {
            return bitmapA;
        }
        String strB = le1Var.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strB.startsWith("data:") && strB.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strB.substring(strB.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e) {
                Log.w("LOTTIE", "data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.b)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            return c(str, BitmapFactory.decodeStream(this.a.getAssets().open(this.b + strB), null, options));
        } catch (IOException e2) {
            Log.w("LOTTIE", "Unable to open asset.", e2);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.a == null) || this.a.equals(context);
    }

    public void d() {
        synchronized (d) {
            try {
                Iterator it = this.c.entrySet().iterator();
                while (it.hasNext()) {
                    le1 le1Var = (le1) ((Map.Entry) it.next()).getValue();
                    Bitmap bitmapA = le1Var.a();
                    if (bitmapA != null) {
                        bitmapA.recycle();
                        le1Var.d(null);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(kz0 kz0Var) {
    }
}
