package defpackage;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.x;
import androidx.camera.video.x0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class lc3 implements jw2 {
    private static final Size g = new Size(1280, 720);
    private static final Range h = new Range(1, 60);
    private final String a;
    private final Timebase b;
    private final x0 c;
    private final Size d;
    private final ie0 e;
    private final Range f;

    public lc3(String str, Timebase timebase, x0 x0Var, Size size, ie0 ie0Var, Range range) {
        this.a = str;
        this.b = timebase;
        this.c = x0Var;
        this.d = size;
        this.e = ie0Var;
        this.f = range;
    }

    private int b() {
        Range range = this.f;
        Range range2 = SurfaceRequest.o;
        int iIntValue = !Objects.equals(range, range2) ? ((Integer) h.clamp((Integer) this.f.getUpper())).intValue() : 30;
        x.a("VidEncCfgDefaultRslvr", String.format("Default resolved frame rate: %dfps. [Expected operating range: %s]", Integer.valueOf(iIntValue), Objects.equals(this.f, range2) ? this.f : "<UNSPECIFIED>"));
        return iIntValue;
    }

    @Override // defpackage.jw2
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public kc3 get() {
        int iB = b();
        x.a("VidEncCfgDefaultRslvr", "Resolved VIDEO frame rate: " + iB + "fps");
        Range rangeC = this.c.c();
        x.a("VidEncCfgDefaultRslvr", "Using fallback VIDEO bitrate");
        int iA = this.e.a();
        int width = this.d.getWidth();
        Size size = g;
        int iE = yb3.e(14000000, iA, 8, iB, 30, width, size.getWidth(), this.d.getHeight(), size.getHeight(), rangeC);
        int iA2 = me0.a(this.a, this.e);
        return kc3.d().h(this.a).g(this.b).j(this.d).b(iE).e(iB).i(iA2).d(yb3.b(this.a, iA2)).a();
    }
}
