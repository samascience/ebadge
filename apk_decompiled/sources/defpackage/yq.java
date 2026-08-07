package defpackage;

import android.hardware.camera2.CaptureResult;
import android.os.Build;
import androidx.camera.core.impl.CameraCaptureMetaData$AeMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.x;
import java.nio.BufferUnderflowException;

/* JADX INFO: loaded from: classes.dex */
public class yq implements cs {
    private final vz2 a;
    private final CaptureResult b;

    public yq(vz2 vz2Var, CaptureResult captureResult) {
        this.a = vz2Var;
        this.b = captureResult;
    }

    @Override // defpackage.cs
    public vz2 a() {
        return this.a;
    }

    @Override // defpackage.cs
    public void b(ExifData.b bVar) {
        super.b(bVar);
        try {
            Integer num = (Integer) this.b.get(CaptureResult.JPEG_ORIENTATION);
            if (num != null) {
                bVar.m(num.intValue());
            }
        } catch (BufferUnderflowException unused) {
            x.k("C2CameraCaptureResult", "Failed to get JPEG orientation.");
        }
        Long l = (Long) this.b.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        if (l != null) {
            bVar.f(l.longValue());
        }
        Float f = (Float) this.b.get(CaptureResult.LENS_APERTURE);
        if (f != null) {
            bVar.l(f.floatValue());
        }
        Integer numValueOf = (Integer) this.b.get(CaptureResult.SENSOR_SENSITIVITY);
        if (numValueOf != null) {
            Integer num2 = (Integer) this.b.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST);
            if (num2 != null) {
                numValueOf = Integer.valueOf(numValueOf.intValue() * ((int) (num2.intValue() / 100.0f)));
            }
            bVar.k(numValueOf.intValue());
        }
        Float f2 = (Float) this.b.get(CaptureResult.LENS_FOCAL_LENGTH);
        if (f2 != null) {
            bVar.h(f2.floatValue());
        }
        Integer num3 = (Integer) this.b.get(CaptureResult.CONTROL_AWB_MODE);
        if (num3 != null) {
            ExifData.WhiteBalanceMode whiteBalanceMode = ExifData.WhiteBalanceMode.AUTO;
            if (num3.intValue() == 0) {
                whiteBalanceMode = ExifData.WhiteBalanceMode.MANUAL;
            }
            bVar.n(whiteBalanceMode);
        }
    }

    @Override // defpackage.cs
    public long c() {
        Long l = (Long) this.b.get(CaptureResult.SENSOR_TIMESTAMP);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    @Override // defpackage.cs
    public CameraCaptureMetaData$AwbState d() {
        Integer num = (Integer) this.b.get(CaptureResult.CONTROL_AWB_STATE);
        if (num == null) {
            return CameraCaptureMetaData$AwbState.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return CameraCaptureMetaData$AwbState.INACTIVE;
        }
        if (iIntValue == 1) {
            return CameraCaptureMetaData$AwbState.METERING;
        }
        if (iIntValue == 2) {
            return CameraCaptureMetaData$AwbState.CONVERGED;
        }
        if (iIntValue == 3) {
            return CameraCaptureMetaData$AwbState.LOCKED;
        }
        x.c("C2CameraCaptureResult", "Undefined awb state: " + num);
        return CameraCaptureMetaData$AwbState.UNKNOWN;
    }

    @Override // defpackage.cs
    public CameraCaptureMetaData$FlashState e() {
        Integer num = (Integer) this.b.get(CaptureResult.FLASH_STATE);
        if (num == null) {
            return CameraCaptureMetaData$FlashState.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0 || iIntValue == 1) {
            return CameraCaptureMetaData$FlashState.NONE;
        }
        if (iIntValue == 2) {
            return CameraCaptureMetaData$FlashState.READY;
        }
        if (iIntValue == 3 || iIntValue == 4) {
            return CameraCaptureMetaData$FlashState.FIRED;
        }
        x.c("C2CameraCaptureResult", "Undefined flash state: " + num);
        return CameraCaptureMetaData$FlashState.UNKNOWN;
    }

    @Override // defpackage.cs
    public CameraCaptureMetaData$AwbMode f() {
        Integer num = (Integer) this.b.get(CaptureResult.CONTROL_AWB_MODE);
        if (num == null) {
            return CameraCaptureMetaData$AwbMode.UNKNOWN;
        }
        switch (num.intValue()) {
            case 0:
                return CameraCaptureMetaData$AwbMode.OFF;
            case 1:
                return CameraCaptureMetaData$AwbMode.AUTO;
            case 2:
                return CameraCaptureMetaData$AwbMode.INCANDESCENT;
            case 3:
                return CameraCaptureMetaData$AwbMode.FLUORESCENT;
            case 4:
                return CameraCaptureMetaData$AwbMode.WARM_FLUORESCENT;
            case 5:
                return CameraCaptureMetaData$AwbMode.DAYLIGHT;
            case 6:
                return CameraCaptureMetaData$AwbMode.CLOUDY_DAYLIGHT;
            case 7:
                return CameraCaptureMetaData$AwbMode.TWILIGHT;
            case 8:
                return CameraCaptureMetaData$AwbMode.SHADE;
            default:
                return CameraCaptureMetaData$AwbMode.UNKNOWN;
        }
    }

    @Override // defpackage.cs
    public CameraCaptureMetaData$AfMode g() {
        Integer num = (Integer) this.b.get(CaptureResult.CONTROL_AF_MODE);
        if (num == null) {
            return CameraCaptureMetaData$AfMode.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue != 0) {
            if (iIntValue == 1 || iIntValue == 2) {
                return CameraCaptureMetaData$AfMode.ON_MANUAL_AUTO;
            }
            if (iIntValue == 3 || iIntValue == 4) {
                return CameraCaptureMetaData$AfMode.ON_CONTINUOUS_AUTO;
            }
            if (iIntValue != 5) {
                x.c("C2CameraCaptureResult", "Undefined af mode: " + num);
                return CameraCaptureMetaData$AfMode.UNKNOWN;
            }
        }
        return CameraCaptureMetaData$AfMode.OFF;
    }

    @Override // defpackage.cs
    public CameraCaptureMetaData$AeState h() {
        Integer num = (Integer) this.b.get(CaptureResult.CONTROL_AE_STATE);
        if (num == null) {
            return CameraCaptureMetaData$AeState.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return CameraCaptureMetaData$AeState.INACTIVE;
        }
        if (iIntValue != 1) {
            if (iIntValue == 2) {
                return CameraCaptureMetaData$AeState.CONVERGED;
            }
            if (iIntValue == 3) {
                return CameraCaptureMetaData$AeState.LOCKED;
            }
            if (iIntValue == 4) {
                return CameraCaptureMetaData$AeState.FLASH_REQUIRED;
            }
            if (iIntValue != 5) {
                x.c("C2CameraCaptureResult", "Undefined ae state: " + num);
                return CameraCaptureMetaData$AeState.UNKNOWN;
            }
        }
        return CameraCaptureMetaData$AeState.SEARCHING;
    }

    @Override // defpackage.cs
    public CaptureResult i() {
        return this.b;
    }

    @Override // defpackage.cs
    public CameraCaptureMetaData$AeMode j() {
        Integer num = (Integer) this.b.get(CaptureResult.CONTROL_AE_MODE);
        if (num == null) {
            return CameraCaptureMetaData$AeMode.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return CameraCaptureMetaData$AeMode.OFF;
        }
        if (iIntValue == 1) {
            return CameraCaptureMetaData$AeMode.ON;
        }
        if (iIntValue == 2) {
            return CameraCaptureMetaData$AeMode.ON_AUTO_FLASH;
        }
        if (iIntValue == 3) {
            return CameraCaptureMetaData$AeMode.ON_ALWAYS_FLASH;
        }
        if (iIntValue == 4) {
            return CameraCaptureMetaData$AeMode.ON_AUTO_FLASH_REDEYE;
        }
        if (iIntValue == 5 && Build.VERSION.SDK_INT >= 28) {
            return CameraCaptureMetaData$AeMode.ON_EXTERNAL_FLASH;
        }
        return CameraCaptureMetaData$AeMode.UNKNOWN;
    }

    @Override // defpackage.cs
    public CameraCaptureMetaData$AfState k() {
        Integer num = (Integer) this.b.get(CaptureResult.CONTROL_AF_STATE);
        if (num == null) {
            return CameraCaptureMetaData$AfState.UNKNOWN;
        }
        switch (num.intValue()) {
            case 0:
                return CameraCaptureMetaData$AfState.INACTIVE;
            case 1:
            case 3:
                return CameraCaptureMetaData$AfState.SCANNING;
            case 2:
                return CameraCaptureMetaData$AfState.PASSIVE_FOCUSED;
            case 4:
                return CameraCaptureMetaData$AfState.LOCKED_FOCUSED;
            case 5:
                return CameraCaptureMetaData$AfState.LOCKED_NOT_FOCUSED;
            case 6:
                return CameraCaptureMetaData$AfState.PASSIVE_NOT_FOCUSED;
            default:
                x.c("C2CameraCaptureResult", "Undefined af state: " + num);
                return CameraCaptureMetaData$AfState.UNKNOWN;
        }
    }

    public yq(CaptureResult captureResult) {
        this(vz2.b(), captureResult);
    }
}
