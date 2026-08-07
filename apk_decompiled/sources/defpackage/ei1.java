package defpackage;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;

/* JADX INFO: loaded from: classes.dex */
public class ei1 implements rk1 {
    private final Context a;

    public static class a implements sk1 {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new ei1(this.a);
        }
    }

    public ei1(Context context) {
        this.a = context.getApplicationContext();
    }

    private boolean e(rx1 rx1Var) {
        Long l = (Long) rx1Var.a(VideoDecoder.d);
        return l != null && l.longValue() == -1;
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rk1.a b(Uri uri, int i, int i2, rx1 rx1Var) {
        if (ci1.d(i, i2) && e(rx1Var)) {
            return new rk1.a(new nt1(uri), y23.g(this.a, uri));
        }
        return null;
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return ci1.c(uri);
    }
}
