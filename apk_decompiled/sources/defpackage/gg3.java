package defpackage;

import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.k;
import androidx.camera.core.impl.n;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class gg3 extends n {
    private final ev2.a c;

    gg3(CameraControlInternal cameraControlInternal, ev2.a aVar) {
        super(cameraControlInternal);
        this.c = aVar;
    }

    private int i(k kVar) {
        Integer num = (Integer) kVar.g().f(k.j, 100);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    private int j(k kVar) {
        Integer num = (Integer) kVar.g().f(k.i, 0);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    @Override // androidx.camera.core.impl.n, androidx.camera.core.impl.CameraControlInternal
    public ub1 b(List list, int i, int i2) {
        b52.b(list.size() == 1, "Only support one capture config.");
        return os0.k(Collections.singletonList(this.c.a(i((k) list.get(0)), j((k) list.get(0)))));
    }
}
