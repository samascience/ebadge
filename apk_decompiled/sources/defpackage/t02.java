package defpackage;

import android.bluetooth.le.ScanResult;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface t02 {
    default void onBatchScanResults(List list) {
    }

    default void onScanFailed(String str) {
    }

    void onScanResult(ScanResult scanResult);
}
