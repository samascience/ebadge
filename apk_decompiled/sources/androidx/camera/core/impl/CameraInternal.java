package androidx.camera.core.impl;

import androidx.camera.core.UseCase;
import defpackage.dt;
import defpackage.ut1;
import defpackage.yt;
import defpackage.zr;
import defpackage.zt;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public interface CameraInternal extends zr, UseCase.a {

    public enum State {
        PENDING_OPEN(false),
        OPENING(true),
        OPEN(true),
        CONFIGURED(true),
        CLOSING(true),
        CLOSED(false),
        RELEASING(true),
        RELEASED(false);

        private final boolean mHoldsCameraSlot;

        State(boolean z) {
            this.mHoldsCameraSlot = z;
        }

        boolean holdsCameraSlot() {
            return this.mHoldsCameraSlot;
        }
    }

    @Override // defpackage.zr
    default yt a() {
        return n();
    }

    default boolean b() {
        return a().f() == 0;
    }

    default void e(g gVar) {
    }

    ut1 g();

    CameraControlInternal h();

    default g i() {
        return dt.a();
    }

    default void j(boolean z) {
    }

    void k(Collection collection);

    void l(Collection collection);

    default boolean m() {
        return true;
    }

    zt n();
}
