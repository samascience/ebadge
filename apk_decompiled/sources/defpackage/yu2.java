package defpackage;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;

/* JADX INFO: loaded from: classes.dex */
abstract class yu2 implements wu2.a {
    final StreamConfigurationMap a;

    static class a {
        static Size[] a(StreamConfigurationMap streamConfigurationMap, int i) {
            return streamConfigurationMap.getHighResolutionOutputSizes(i);
        }
    }

    yu2(StreamConfigurationMap streamConfigurationMap) {
        this.a = streamConfigurationMap;
    }

    @Override // wu2.a
    public StreamConfigurationMap a() {
        return this.a;
    }

    @Override // wu2.a
    public Size[] b(int i) {
        return a.a(this.a, i);
    }

    @Override // wu2.a
    public int[] d() {
        return this.a.getOutputFormats();
    }
}
