package defpackage;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.x;
import androidx.camera.video.x0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class mc3 implements jw2 {
    private final String a;
    private final Timebase b;
    private final x0 c;
    private final Size d;
    private final eh0.c e;
    private final ie0 f;
    private final Range g;

    public mc3(String str, Timebase timebase, x0 x0Var, Size size, eh0.c cVar, ie0 ie0Var, Range range) {
        this.a = str;
        this.b = timebase;
        this.c = x0Var;
        this.d = size;
        this.e = cVar;
        this.f = ie0Var;
        this.g = range;
    }

    private int b() {
        int iF = this.e.f();
        Range range = this.g;
        Range range2 = SurfaceRequest.o;
        int iIntValue = !Objects.equals(range, range2) ? ((Integer) this.g.clamp(Integer.valueOf(iF))).intValue() : iF;
        x.a("VidEncVdPrflRslvr", String.format("Resolved frame rate %dfps [Video profile frame rate: %dfps, Expected operating range: %s]", Integer.valueOf(iIntValue), Integer.valueOf(iF), Objects.equals(this.g, range2) ? this.g : "<UNSPECIFIED>"));
        return iIntValue;
    }

    @Override // defpackage.jw2
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public kc3 get() {
        int iB = b();
        x.a("VidEncVdPrflRslvr", "Resolved VIDEO frame rate: " + iB + "fps");
        Range rangeC = this.c.c();
        x.a("VidEncVdPrflRslvr", "Using resolved VIDEO bitrate from EncoderProfiles");
        int iE = yb3.e(this.e.c(), this.f.a(), this.e.b(), iB, this.e.f(), this.d.getWidth(), this.e.k(), this.d.getHeight(), this.e.h(), rangeC);
        int iJ = this.e.j();
        return kc3.d().h(this.a).g(this.b).j(this.d).b(iE).e(iB).i(iJ).d(yb3.b(this.a, iJ)).a();
    }
}
