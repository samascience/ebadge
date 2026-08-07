package defpackage;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public interface py0 extends IInterface {

    public static abstract class a extends qt3 implements py0 {
        public a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static py0 b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return iInterfaceQueryLocalInterface instanceof py0 ? (py0) iInterfaceQueryLocalInterface : new rt3(iBinder);
        }
    }
}
