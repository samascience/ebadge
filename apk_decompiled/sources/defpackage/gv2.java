package defpackage;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.u;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class gv2 implements d0, r, p23 {
    static final Config.a J = Config.a.a("camerax.core.streamSharing.captureTypes", List.class);
    private final u I;

    gv2(u uVar) {
        this.I = uVar;
    }

    public List Y() {
        return (List) a(J);
    }

    @Override // androidx.camera.core.impl.w
    public Config n() {
        return this.I;
    }
}
