package defpackage;

import android.media.session.MediaSessionManager;

/* JADX INFO: loaded from: classes.dex */
final class xh1 implements uh1 {
    final MediaSessionManager.RemoteUserInfo a;

    xh1(String str, int i, int i2) {
        this.a = wh1.a(str, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof xh1) {
            return this.a.equals(((xh1) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return tt1.b(this.a);
    }

    xh1(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.a = remoteUserInfo;
    }
}
