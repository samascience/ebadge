package no.nordicsemi.android.support.v18.scanner;

import defpackage.ek2;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class o extends ek2 {
    private final WeakReference a;

    o(ek2 ek2Var) {
        this.a = new WeakReference(ek2Var);
    }

    ek2 a() {
        return (ek2) this.a.get();
    }

    boolean b() {
        return this.a.get() == null;
    }

    @Override // defpackage.ek2
    public void onBatchScanResults(List list) {
        ek2 ek2Var = (ek2) this.a.get();
        if (ek2Var != null) {
            ek2Var.onBatchScanResults(list);
        }
    }

    @Override // defpackage.ek2
    public void onScanFailed(int i) {
        ek2 ek2Var = (ek2) this.a.get();
        if (ek2Var != null) {
            ek2Var.onScanFailed(i);
        }
    }

    @Override // defpackage.ek2
    public void onScanResult(int i, ScanResult scanResult) {
        ek2 ek2Var = (ek2) this.a.get();
        if (ek2Var != null) {
            ek2Var.onScanResult(i, scanResult);
        }
    }
}
