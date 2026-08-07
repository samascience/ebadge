package defpackage;

import android.media.session.MediaSessionManager;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class th1 {
    uh1 a;

    public th1(String str, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.a = new xh1(str, i, i2);
        } else {
            this.a = new yh1(str, i, i2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof th1) {
            return this.a.equals(((th1) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public th1(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.a = new xh1(remoteUserInfo);
    }
}
