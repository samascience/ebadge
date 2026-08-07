package defpackage;

import androidx.camera.core.impl.CameraCaptureMetaData$AeMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;

/* JADX INFO: loaded from: classes.dex */
public class fg3 implements cs {
    private final cs a;
    private final vz2 b;
    private final long c;

    public fg3(vz2 vz2Var, cs csVar) {
        this(csVar, vz2Var, -1L);
    }

    @Override // defpackage.cs
    public vz2 a() {
        return this.b;
    }

    @Override // defpackage.cs
    public long c() {
        cs csVar = this.a;
        if (csVar != null) {
            return csVar.c();
        }
        long j = this.c;
        if (j != -1) {
            return j;
        }
        throw new IllegalStateException("No timestamp is available.");
    }

    @Override // defpackage.cs
    public CameraCaptureMetaData$AwbState d() {
        cs csVar = this.a;
        return csVar != null ? csVar.d() : CameraCaptureMetaData$AwbState.UNKNOWN;
    }

    @Override // defpackage.cs
    public CameraCaptureMetaData$FlashState e() {
        cs csVar = this.a;
        return csVar != null ? csVar.e() : CameraCaptureMetaData$FlashState.UNKNOWN;
    }

    @Override // defpackage.cs
    public CameraCaptureMetaData$AwbMode f() {
        cs csVar = this.a;
        return csVar != null ? csVar.f() : CameraCaptureMetaData$AwbMode.UNKNOWN;
    }

    @Override // defpackage.cs
    public CameraCaptureMetaData$AfMode g() {
        cs csVar = this.a;
        return csVar != null ? csVar.g() : CameraCaptureMetaData$AfMode.UNKNOWN;
    }

    @Override // defpackage.cs
    public CameraCaptureMetaData$AeState h() {
        cs csVar = this.a;
        return csVar != null ? csVar.h() : CameraCaptureMetaData$AeState.UNKNOWN;
    }

    @Override // defpackage.cs
    public CameraCaptureMetaData$AeMode j() {
        cs csVar = this.a;
        return csVar != null ? csVar.j() : CameraCaptureMetaData$AeMode.UNKNOWN;
    }

    @Override // defpackage.cs
    public CameraCaptureMetaData$AfState k() {
        cs csVar = this.a;
        return csVar != null ? csVar.k() : CameraCaptureMetaData$AfState.UNKNOWN;
    }

    public fg3(vz2 vz2Var, long j) {
        this(null, vz2Var, j);
    }

    private fg3(cs csVar, vz2 vz2Var, long j) {
        this.a = csVar;
        this.b = vz2Var;
        this.c = j;
    }
}
