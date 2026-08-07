package defpackage;

import java.util.List;
import no.nordicsemi.android.support.v18.scanner.ScanResult;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ek2 {
    static final int NO_ERROR = 0;
    public static final int SCAN_FAILED_ALREADY_STARTED = 1;
    public static final int SCAN_FAILED_APPLICATION_REGISTRATION_FAILED = 2;
    public static final int SCAN_FAILED_FEATURE_UNSUPPORTED = 4;
    public static final int SCAN_FAILED_INTERNAL_ERROR = 3;
    public static final int SCAN_FAILED_OUT_OF_HARDWARE_RESOURCES = 5;
    public static final int SCAN_FAILED_SCANNING_TOO_FREQUENTLY = 6;

    public void onBatchScanResults(List<ScanResult> list) {
    }

    public void onScanFailed(int i) {
    }

    public void onScanResult(int i, ScanResult scanResult) {
    }
}
