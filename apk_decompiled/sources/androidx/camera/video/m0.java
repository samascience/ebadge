package androidx.camera.video;

import android.util.Size;
import defpackage.ie0;
import defpackage.vd3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface m0 {
    public static final m0 a = new a();

    class a implements m0 {
        a() {
        }

        @Override // androidx.camera.video.m0
        public List c(ie0 ie0Var) {
            return new ArrayList();
        }
    }

    default vd3 a(Size size, ie0 ie0Var) {
        return null;
    }

    default s b(Size size, ie0 ie0Var) {
        return s.g;
    }

    List c(ie0 ie0Var);

    default vd3 d(s sVar, ie0 ie0Var) {
        return null;
    }
}
