package defpackage;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;

/* JADX INFO: loaded from: classes.dex */
class xu2 extends yu2 {
    xu2(StreamConfigurationMap streamConfigurationMap) {
        super(streamConfigurationMap);
    }

    @Override // wu2.a
    public Size[] c(int i) {
        return this.a.getOutputSizes(i);
    }
}
