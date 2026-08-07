package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.b;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class us3 {
    private int d;
    private final u9 b = new u9();
    private final v03 c = new v03();
    private boolean e = false;
    private final u9 a = new u9();

    public us3(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.a.put(((b) it.next()).k(), null);
        }
        this.d = this.a.keySet().size();
    }

    public final u03 a() {
        return this.c.a();
    }

    public final void b(qs3 qs3Var, ConnectionResult connectionResult, String str) {
        this.a.put(qs3Var, connectionResult);
        this.b.put(qs3Var, str);
        this.d--;
        if (!connectionResult.J0()) {
            this.e = true;
        }
        if (this.d == 0) {
            if (!this.e) {
                this.c.c(this.b);
            } else {
                this.c.b(new AvailabilityException(this.a));
            }
        }
    }

    public final Set c() {
        return this.a.keySet();
    }
}
