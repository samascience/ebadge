package defpackage;

import android.util.Range;
import androidx.camera.core.x;
import androidx.camera.video.a;

/* JADX INFO: loaded from: classes.dex */
public final class lb implements jw2 {
    private final a a;
    private final eh0.a b;

    public lb(a aVar, eh0.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // defpackage.jw2
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public kb get() {
        int iF = eb.f(this.a);
        int iG = eb.g(this.a);
        int iC = this.a.c();
        Range rangeD = this.a.d();
        int iC2 = this.b.c();
        if (iC == -1) {
            x.a("AudioSrcAdPrflRslvr", "Resolved AUDIO channel count from AudioProfile: " + iC2);
            iC = iC2;
        } else {
            x.a("AudioSrcAdPrflRslvr", "Media spec AUDIO channel count overrides AudioProfile [AudioProfile channel count: " + iC2 + ", Resolved Channel Count: " + iC + "]");
        }
        int iG2 = this.b.g();
        int i = eb.i(rangeD, iC, iG, iG2);
        x.a("AudioSrcAdPrflRslvr", "Using resolved AUDIO sample rate or nearest supported from AudioProfile: " + i + "Hz. [AudioProfile sample rate: " + iG2 + "Hz]");
        return kb.a().d(iF).c(iG).e(iC).f(i).b();
    }
}
