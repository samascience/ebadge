package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes4.dex */
public final class jw0 {
    public static final a c = new a(null);
    private final so a;
    private long b;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public jw0(so soVar) {
        p31.f(soVar, SocialConstants.PARAM_SOURCE);
        this.a = soVar;
        this.b = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public final iw0 a() {
        iw0.a aVar = new iw0.a();
        while (true) {
            String strB = b();
            if (strB.length() == 0) {
                return aVar.e();
            }
            aVar.b(strB);
        }
    }

    public final String b() {
        String strO = this.a.O(this.b);
        this.b -= (long) strO.length();
        return strO;
    }
}
