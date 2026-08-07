package defpackage;

import android.util.Range;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.x;
import androidx.camera.video.a;

/* JADX INFO: loaded from: classes.dex */
public final class hb implements jw2 {
    private final String a;
    private final int b;
    private final a c;
    private final kb d;
    private final Timebase e;

    public hb(String str, int i, Timebase timebase, a aVar, kb kbVar) {
        this.a = str;
        this.b = i;
        this.e = timebase;
        this.c = aVar;
        this.d = kbVar;
    }

    @Override // defpackage.jw2
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public fb get() {
        Range rangeB = this.c.b();
        x.a("AudioEncCfgDefaultRslvr", "Using fallback AUDIO bitrate");
        return fb.d().f(this.a).g(this.b).e(this.e).d(this.d.e()).h(this.d.f()).c(eb.h(156000, this.d.e(), 2, this.d.f(), 48000, rangeB)).b();
    }
}
