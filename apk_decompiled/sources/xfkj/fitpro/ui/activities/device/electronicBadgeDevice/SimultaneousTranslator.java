package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.content.Context;
import android.media.AudioRecord;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.alibaba.idst.nui.NativeNui;
import com.tencent.connect.common.Constants;
import defpackage.ar0;
import defpackage.cr2;
import defpackage.k83;
import defpackage.ny0;
import defpackage.p31;
import defpackage.q30;
import defpackage.qr0;
import defpackage.x30;
import defpackage.y70;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
public final class SimultaneousTranslator implements ny0 {
    private final Context a;
    private final String b;
    private final qr0 c;
    private final ar0 d;
    private ar0 e;
    private final ar0 f;
    private final int g;
    private final int h;
    private final int i;
    private AudioRecord j;
    private boolean k;
    private final NativeNui l;
    private boolean m;
    private volatile boolean n;
    private String o;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f400q;
    private boolean r;

    public SimultaneousTranslator(Context context, String str, qr0 qr0Var, ar0 ar0Var, ar0 ar0Var2, ar0 ar0Var3) {
        p31.f(context, "context");
        p31.f(str, "apiKey");
        p31.f(qr0Var, "onResult");
        this.a = context;
        this.b = str;
        this.c = qr0Var;
        this.d = ar0Var;
        this.e = ar0Var2;
        this.f = ar0Var3;
        this.g = 16000;
        int i = (16000 * 40) / 1000;
        this.h = i;
        this.i = i * 4;
        this.l = new NativeNui();
        this.o = Constants.STR_EMPTY;
        this.p = Constants.STR_EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String r(String str) {
        return cr2.a.c(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s() {
        return q30.a(this.a, "android.permission.RECORD_AUDIO") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        Object systemService = this.a.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3);
    }

    public final boolean u() {
        return this.k;
    }

    public final void v(ar0 ar0Var) {
        p31.f(ar0Var, "listener");
        this.e = ar0Var;
    }

    public final void w(boolean z) {
        this.k = z;
    }

    public final void x(boolean z) {
        this.n = z;
    }

    public final Object y(String str, String str2, x30 x30Var) {
        return BuildersKt.withContext(Dispatchers.getIO(), new SimultaneousTranslator$start$2(this, str, str2, null), x30Var);
    }

    public final Object z(x30 x30Var) throws Throwable {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new SimultaneousTranslator$stop$2(this, null), x30Var);
        return objWithContext == kotlin.coroutines.intrinsics.a.d() ? objWithContext : k83.a;
    }

    public /* synthetic */ SimultaneousTranslator(Context context, String str, qr0 qr0Var, ar0 ar0Var, ar0 ar0Var2, ar0 ar0Var3, int i, y70 y70Var) {
        this(context, str, qr0Var, (i & 8) != 0 ? null : ar0Var, (i & 16) != 0 ? null : ar0Var2, (i & 32) != 0 ? null : ar0Var3);
    }
}
