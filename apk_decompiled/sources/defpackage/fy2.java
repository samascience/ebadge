package defpackage;

import android.media.MediaCodec;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class fy2 {
    private final boolean a;

    public fy2() {
        this.a = ua0.a(jx2.class) != null;
    }

    private int b(DeferrableSurface deferrableSurface) {
        if (deferrableSurface.g() == MediaCodec.class) {
            return 2;
        }
        return deferrableSurface.g() == n52.class ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int c(SessionConfig.e eVar, SessionConfig.e eVar2) {
        return b(eVar.f()) - b(eVar2.f());
    }

    public void d(List list) {
        if (this.a) {
            Collections.sort(list, new Comparator() { // from class: ey2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return this.a.c((SessionConfig.e) obj, (SessionConfig.e) obj2);
                }
            });
        }
    }
}
