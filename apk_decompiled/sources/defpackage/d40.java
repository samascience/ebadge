package defpackage;

import androidx.camera.core.impl.CameraCaptureMetaData$AeMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.x;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class d40 {
    private static final Set a = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData$AfState.PASSIVE_FOCUSED, CameraCaptureMetaData$AfState.PASSIVE_NOT_FOCUSED, CameraCaptureMetaData$AfState.LOCKED_FOCUSED, CameraCaptureMetaData$AfState.LOCKED_NOT_FOCUSED));
    private static final Set b = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData$AwbState.CONVERGED, CameraCaptureMetaData$AwbState.UNKNOWN));
    private static final Set c;
    private static final Set d;

    static {
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState = CameraCaptureMetaData$AeState.CONVERGED;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState2 = CameraCaptureMetaData$AeState.FLASH_REQUIRED;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState3 = CameraCaptureMetaData$AeState.UNKNOWN;
        Set setUnmodifiableSet = Collections.unmodifiableSet(EnumSet.of(cameraCaptureMetaData$AeState, cameraCaptureMetaData$AeState2, cameraCaptureMetaData$AeState3));
        c = setUnmodifiableSet;
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) setUnmodifiableSet);
        enumSetCopyOf.remove(cameraCaptureMetaData$AeState2);
        enumSetCopyOf.remove(cameraCaptureMetaData$AeState3);
        d = Collections.unmodifiableSet(enumSetCopyOf);
    }

    public static boolean a(cs csVar, boolean z) {
        boolean z2 = csVar.g() == CameraCaptureMetaData$AfMode.OFF || csVar.g() == CameraCaptureMetaData$AfMode.UNKNOWN || a.contains(csVar.k());
        boolean z3 = csVar.j() == CameraCaptureMetaData$AeMode.OFF;
        boolean z4 = !z ? !(z3 || c.contains(csVar.h())) : !(z3 || d.contains(csVar.h()));
        boolean z5 = csVar.f() == CameraCaptureMetaData$AwbMode.OFF || b.contains(csVar.d());
        x.a("ConvergenceUtils", "checkCaptureResult, AE=" + csVar.h() + " AF =" + csVar.k() + " AWB=" + csVar.d());
        return z2 && z4 && z5;
    }
}
