package defpackage;

import android.hardware.camera2.CaptureResult;
import androidx.camera.core.impl.CameraCaptureMetaData$AeMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.camera.core.impl.utils.ExifData;

/* JADX INFO: loaded from: classes.dex */
public interface cs {

    public static final class a implements cs {
        public static cs l() {
            return new a();
        }

        @Override // defpackage.cs
        public vz2 a() {
            return vz2.b();
        }

        @Override // defpackage.cs
        public long c() {
            return -1L;
        }

        @Override // defpackage.cs
        public CameraCaptureMetaData$AwbState d() {
            return CameraCaptureMetaData$AwbState.UNKNOWN;
        }

        @Override // defpackage.cs
        public CameraCaptureMetaData$FlashState e() {
            return CameraCaptureMetaData$FlashState.UNKNOWN;
        }

        @Override // defpackage.cs
        public CameraCaptureMetaData$AwbMode f() {
            return CameraCaptureMetaData$AwbMode.UNKNOWN;
        }

        @Override // defpackage.cs
        public CameraCaptureMetaData$AfMode g() {
            return CameraCaptureMetaData$AfMode.UNKNOWN;
        }

        @Override // defpackage.cs
        public CameraCaptureMetaData$AeState h() {
            return CameraCaptureMetaData$AeState.UNKNOWN;
        }

        @Override // defpackage.cs
        public CameraCaptureMetaData$AeMode j() {
            return CameraCaptureMetaData$AeMode.UNKNOWN;
        }

        @Override // defpackage.cs
        public CameraCaptureMetaData$AfState k() {
            return CameraCaptureMetaData$AfState.UNKNOWN;
        }
    }

    vz2 a();

    default void b(ExifData.b bVar) {
        bVar.g(e());
    }

    long c();

    CameraCaptureMetaData$AwbState d();

    CameraCaptureMetaData$FlashState e();

    CameraCaptureMetaData$AwbMode f();

    CameraCaptureMetaData$AfMode g();

    CameraCaptureMetaData$AeState h();

    default CaptureResult i() {
        return a.l().i();
    }

    CameraCaptureMetaData$AeMode j();

    CameraCaptureMetaData$AfState k();
}
