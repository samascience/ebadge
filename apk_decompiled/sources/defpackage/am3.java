package defpackage;

import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.v;

/* JADX INFO: loaded from: classes.dex */
public final class am3 extends x9 {
    public am3(int i, xh2.a aVar) {
        super(i, aVar);
    }

    private boolean d(n01 n01Var) {
        cs csVarA = es.a(n01Var);
        return (csVarA.k() == CameraCaptureMetaData$AfState.LOCKED_FOCUSED || csVarA.k() == CameraCaptureMetaData$AfState.PASSIVE_FOCUSED) && csVarA.h() == CameraCaptureMetaData$AeState.CONVERGED && csVarA.d() == CameraCaptureMetaData$AwbState.CONVERGED;
    }

    @Override // defpackage.x9, defpackage.xh2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(v vVar) {
        if (d(vVar.h0())) {
            super.b(vVar);
        } else {
            this.d.a(vVar);
        }
    }
}
