package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class xr1 {

    public static class a {
        final Bundle a;
        private IconCompat b;
        private final ve2[] c;
        private final ve2[] d;
        private boolean e;
        boolean f;
        private final int g;
        private final boolean h;
        public int i;
        public CharSequence j;
        public PendingIntent k;
        private boolean l;

        public a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.a(null, Constants.STR_EMPTY, i) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.k;
        }

        public boolean b() {
            return this.e;
        }

        public Bundle c() {
            return this.a;
        }

        public IconCompat d() {
            int i;
            if (this.b == null && (i = this.i) != 0) {
                this.b = IconCompat.a(null, Constants.STR_EMPTY, i);
            }
            return this.b;
        }

        public ve2[] e() {
            return this.c;
        }

        public int f() {
            return this.g;
        }

        public boolean g() {
            return this.f;
        }

        public CharSequence h() {
            return this.j;
        }

        public boolean i() {
            return this.l;
        }

        public boolean j() {
            return this.h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, ve2[] ve2VarArr, ve2[] ve2VarArr2, boolean z, int i, boolean z2, boolean z3, boolean z4) {
            this.f = true;
            this.b = iconCompat;
            if (iconCompat != null && iconCompat.d() == 2) {
                this.i = iconCompat.b();
            }
            this.j = d.d(charSequence);
            this.k = pendingIntent;
            this.a = bundle == null ? new Bundle() : bundle;
            this.c = ve2VarArr;
            this.d = ve2VarArr2;
            this.e = z;
            this.g = i;
            this.f = z2;
            this.h = z3;
            this.l = z4;
        }
    }

    public static class b extends e {
        private CharSequence e;

        @Override // xr1.e
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // xr1.e
        public void b(wr1 wr1Var) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(wr1Var.a()).setBigContentTitle(this.b).bigText(this.e);
            if (this.d) {
                bigTextStyleBigText.setSummaryText(this.c);
            }
        }

        @Override // xr1.e
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public b h(CharSequence charSequence) {
            this.e = d.d(charSequence);
            return this;
        }
    }

    public static final class c {
        public static Notification.BubbleMetadata a(c cVar) {
            return null;
        }
    }

    public static abstract class e {
        protected d a;
        CharSequence b;
        CharSequence c;
        boolean d = false;

        public void a(Bundle bundle) {
            if (this.d) {
                bundle.putCharSequence("android.summaryText", this.c);
            }
            CharSequence charSequence = this.b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strC = c();
            if (strC != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strC);
            }
        }

        public abstract void b(wr1 wr1Var);

        protected abstract String c();

        public RemoteViews d(wr1 wr1Var) {
            return null;
        }

        public RemoteViews e(wr1 wr1Var) {
            return null;
        }

        public RemoteViews f(wr1 wr1Var) {
            return null;
        }

        public void g(d dVar) {
            if (this.a != dVar) {
                this.a = dVar;
                if (dVar != null) {
                    dVar.r(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }

    public static class d {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        long N;
        int O;
        int P;
        boolean Q;
        Notification R;
        boolean S;
        Object T;
        public ArrayList U;
        public Context a;
        public ArrayList b;
        public ArrayList c;
        ArrayList d;
        CharSequence e;
        CharSequence f;
        PendingIntent g;
        PendingIntent h;
        RemoteViews i;
        IconCompat j;
        CharSequence k;
        int l;
        int m;
        boolean n;
        boolean o;
        e p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        CharSequence f445q;
        CharSequence r;
        CharSequence[] s;
        int t;
        int u;
        boolean v;
        String w;
        boolean x;
        String y;
        boolean z;

        public d(Context context, String str) {
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.d = new ArrayList();
            this.n = true;
            this.z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.O = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.R = notification;
            this.a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.m = 0;
            this.U = new ArrayList();
            this.Q = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void k(int i, boolean z) {
            if (z) {
                Notification notification = this.R;
                notification.flags = i | notification.flags;
            } else {
                Notification notification2 = this.R;
                notification2.flags = (~i) & notification2.flags;
            }
        }

        public d a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.b.add(new a(i, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new yr1(this).c();
        }

        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public d e(boolean z) {
            k(16, z);
            return this;
        }

        public d f(String str) {
            this.K = str;
            return this;
        }

        public d g(int i) {
            this.E = i;
            return this;
        }

        public d h(PendingIntent pendingIntent) {
            this.g = pendingIntent;
            return this;
        }

        public d i(CharSequence charSequence) {
            this.f = d(charSequence);
            return this;
        }

        public d j(CharSequence charSequence) {
            this.e = d(charSequence);
            return this;
        }

        public d l(boolean z) {
            this.z = z;
            return this;
        }

        public d m(boolean z) {
            k(2, z);
            return this;
        }

        public d n(boolean z) {
            k(8, z);
            return this;
        }

        public d o(int i) {
            this.m = i;
            return this;
        }

        public d p(int i, int i2, boolean z) {
            this.t = i;
            this.u = i2;
            this.v = z;
            return this;
        }

        public d q(int i) {
            this.R.icon = i;
            return this;
        }

        public d r(e eVar) {
            if (this.p != eVar) {
                this.p = eVar;
                if (eVar != null) {
                    eVar.g(this);
                }
            }
            return this;
        }

        public d s(CharSequence charSequence) {
            this.R.tickerText = d(charSequence);
            return this;
        }

        public d t(long[] jArr) {
            this.R.vibrate = jArr;
            return this;
        }

        public d u(int i) {
            this.F = i;
            return this;
        }

        public d v(long j) {
            this.R.when = j;
            return this;
        }

        public d(Context context) {
            this(context, null);
        }
    }
}
