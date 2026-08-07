package defpackage;

import android.media.CamcorderProfile;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class ih0 {
    public static eh0 a(CamcorderProfile camcorderProfile) {
        return eh0.b.h(camcorderProfile.duration, camcorderProfile.fileFormat, b(camcorderProfile), c(camcorderProfile));
    }

    private static List b(CamcorderProfile camcorderProfile) {
        ArrayList arrayList = new ArrayList();
        int i = camcorderProfile.audioCodec;
        arrayList.add(eh0.a.a(i, eh0.e(i), camcorderProfile.audioBitRate, camcorderProfile.audioSampleRate, camcorderProfile.audioChannels, eh0.f(camcorderProfile.audioCodec)));
        return arrayList;
    }

    private static List c(CamcorderProfile camcorderProfile) {
        ArrayList arrayList = new ArrayList();
        int i = camcorderProfile.videoCodec;
        arrayList.add(eh0.c.a(i, eh0.g(i), camcorderProfile.videoBitRate, camcorderProfile.videoFrameRate, camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight, -1, 8, 0, 0));
        return arrayList;
    }
}
