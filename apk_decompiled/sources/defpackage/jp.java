package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class jp implements ug2 {
    private static final a f = new a();
    private static final b g = new b();
    private final Context a;
    private final List b;
    private final b c;
    private final a d;
    private final tt0 e;

    static class a {
        a() {
        }

        zt0 a(zt0.a aVar, iu0 iu0Var, ByteBuffer byteBuffer, int i) {
            return new ot2(aVar, iu0Var, byteBuffer, i);
        }
    }

    static class b {
        private final Queue a = na3.e(0);

        b() {
        }

        synchronized ju0 a(ByteBuffer byteBuffer) {
            ju0 ju0Var;
            try {
                ju0Var = (ju0) this.a.poll();
                if (ju0Var == null) {
                    ju0Var = new ju0();
                }
            } catch (Throwable th) {
                throw th;
            }
            return ju0Var.p(byteBuffer);
        }

        synchronized void b(ju0 ju0Var) {
            ju0Var.a();
            this.a.offer(ju0Var);
        }
    }

    public jp(Context context, List list, oi oiVar, v9 v9Var) {
        this(context, list, oiVar, v9Var, g, f);
    }

    private du0 c(ByteBuffer byteBuffer, int i, int i2, ju0 ju0Var, rx1 rx1Var) {
        long jB = cd1.b();
        try {
            iu0 iu0VarC = ju0Var.c();
            if (iu0VarC.b() > 0 && iu0VarC.c() == 0) {
                Bitmap.Config config = rx1Var.a(ku0.a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                zt0 zt0VarA = this.d.a(this.e, iu0VarC, byteBuffer, e(iu0VarC, i, i2));
                zt0VarA.e(config);
                zt0VarA.b();
                Bitmap bitmapA = zt0VarA.a();
                if (bitmapA == null) {
                    return null;
                }
                return new du0(new au0(this.a, zt0VarA, q83.a(), i, i2, bitmapA));
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + cd1.a(jB));
            }
        }
    }

    private static int e(iu0 iu0Var, int i, int i2) {
        int iMin = Math.min(iu0Var.a() / i2, iu0Var.d() / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + iu0Var.d() + "x" + iu0Var.a() + "]");
        }
        return iMax;
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public du0 b(ByteBuffer byteBuffer, int i, int i2, rx1 rx1Var) {
        ju0 ju0VarA = this.c.a(byteBuffer);
        try {
            return c(byteBuffer, i, i2, ju0VarA, rx1Var);
        } finally {
            this.c.b(ju0VarA);
        }
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(ByteBuffer byteBuffer, rx1 rx1Var) {
        return !((Boolean) rx1Var.a(ku0.b)).booleanValue() && com.bumptech.glide.load.a.f(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    jp(Context context, List list, oi oiVar, v9 v9Var, b bVar, a aVar) {
        this.a = context.getApplicationContext();
        this.b = list;
        this.d = aVar;
        this.e = new tt0(oiVar, v9Var);
        this.c = bVar;
    }
}
