package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public interface uy0 extends IInterface {
    public static final String a = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace('$', '.');

    public static abstract class a extends Binder implements uy0 {

        /* JADX INFO: renamed from: uy0$a$a, reason: collision with other inner class name */
        private static class C0175a implements uy0 {
            private IBinder c;

            C0175a(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }
        }

        public static uy0 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(uy0.a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof uy0)) ? new C0175a(iBinder) : (uy0) iInterfaceQueryLocalInterface;
        }
    }
}
