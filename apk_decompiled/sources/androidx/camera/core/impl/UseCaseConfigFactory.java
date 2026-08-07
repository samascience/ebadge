package androidx.camera.core.impl;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface UseCaseConfigFactory {
    public static final UseCaseConfigFactory a = new a();

    public enum CaptureType {
        IMAGE_CAPTURE,
        PREVIEW,
        IMAGE_ANALYSIS,
        VIDEO_CAPTURE,
        STREAM_SHARING,
        METERING_REPEATING
    }

    class a implements UseCaseConfigFactory {
        a() {
        }

        @Override // androidx.camera.core.impl.UseCaseConfigFactory
        public Config a(CaptureType captureType, int i) {
            return null;
        }
    }

    public interface b {
        UseCaseConfigFactory a(Context context);
    }

    Config a(CaptureType captureType, int i);
}
