package defpackage;

import androidx.camera.core.impl.Timebase;
import androidx.camera.core.x;
import androidx.camera.video.a;

/* JADX INFO: loaded from: classes.dex */
public final class gb implements jw2 {
    private final String a;
    private final Timebase b;
    private final int c;
    private final a d;
    private final kb e;
    private final eh0.a f;

    public gb(String str, int i, Timebase timebase, a aVar, kb kbVar, eh0.a aVar2) {
        this.a = str;
        this.c = i;
        this.b = timebase;
        this.d = aVar;
        this.e = kbVar;
        this.f = aVar2;
    }

    @Override // defpackage.jw2
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public fb get() {
        x.a("AudioEncAdPrflRslvr", "Using resolved AUDIO bitrate from AudioProfile");
        return fb.d().f(this.a).g(this.c).e(this.b).d(this.e.e()).h(this.e.f()).c(eb.h(this.f.b(), this.e.e(), this.f.c(), this.e.f(), this.f.g(), this.d.b())).b();
    }
}
