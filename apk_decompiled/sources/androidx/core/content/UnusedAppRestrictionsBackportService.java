package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.uy0;
import defpackage.vy0;
import defpackage.w83;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {
    private vy0.a a = new a();

    class a extends vy0.a {
        a() {
        }

        @Override // defpackage.vy0
        public void j(uy0 uy0Var) {
            if (uy0Var == null) {
                return;
            }
            UnusedAppRestrictionsBackportService.this.a(new w83(uy0Var));
        }
    }

    protected abstract void a(w83 w83Var);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.a;
    }
}
