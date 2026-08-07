package defpackage;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.os.Build;
import androidx.camera.core.x;

/* JADX INFO: loaded from: classes.dex */
public abstract class fh0 {
    public static eh0 a(CamcorderProfile camcorderProfile) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            x.k("EncoderProfilesProxyCompat", "Should use from(EncoderProfiles) on API " + i + "instead. CamcorderProfile is deprecated on API 31.");
        }
        return ih0.a(camcorderProfile);
    }

    public static eh0 b(EncoderProfiles encoderProfiles) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            return hh0.a(encoderProfiles);
        }
        if (i >= 31) {
            return gh0.a(encoderProfiles);
        }
        throw new RuntimeException("Unable to call from(EncoderProfiles) on API " + i + ". Version 31 or higher required.");
    }
}
