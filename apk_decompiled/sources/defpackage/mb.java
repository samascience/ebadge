package defpackage;

import android.util.Range;
import androidx.camera.core.x;
import androidx.camera.video.a;

/* JADX INFO: loaded from: classes.dex */
public final class mb implements jw2 {
    private final a a;

    public mb(a aVar) {
        this.a = aVar;
    }

    @Override // defpackage.jw2
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public kb get() {
        int i;
        int iF = eb.f(this.a);
        int iG = eb.g(this.a);
        int iC = this.a.c();
        if (iC == -1) {
            x.a("DefAudioResolver", "Using fallback AUDIO channel count: 1");
            iC = 1;
        } else {
            x.a("DefAudioResolver", "Using supplied AUDIO channel count: " + iC);
        }
        Range rangeD = this.a.d();
        if (a.b.equals(rangeD)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Using fallback AUDIO sample rate: ");
            i = 44100;
            sb.append(44100);
            sb.append("Hz");
            x.a("DefAudioResolver", sb.toString());
        } else {
            i = eb.i(rangeD, iC, iG, ((Integer) rangeD.getUpper()).intValue());
            x.a("DefAudioResolver", "Using AUDIO sample rate resolved from AudioSpec: " + i + "Hz");
        }
        return kb.a().d(iF).c(iG).e(iC).f(i).b();
    }
}
