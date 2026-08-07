package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;

/* JADX INFO: loaded from: classes.dex */
public class z4 implements v92 {
    private final Range a;

    public z4(zs zsVar) {
        this.a = i((Range[]) zsVar.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
    }

    private Range f(Range range) {
        int iIntValue = ((Integer) range.getUpper()).intValue();
        int iIntValue2 = ((Integer) range.getLower()).intValue();
        if (((Integer) range.getUpper()).intValue() >= 1000) {
            iIntValue = ((Integer) range.getUpper()).intValue() / 1000;
        }
        if (((Integer) range.getLower()).intValue() >= 1000) {
            iIntValue2 = ((Integer) range.getLower()).intValue() / 1000;
        }
        return new Range(Integer.valueOf(iIntValue2), Integer.valueOf(iIntValue));
    }

    static boolean h(zs zsVar) {
        Integer num = (Integer) zsVar.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    private Range i(Range[] rangeArr) {
        Range range = null;
        if (rangeArr != null && rangeArr.length != 0) {
            for (Range range2 : rangeArr) {
                Range rangeF = f(range2);
                if (((Integer) rangeF.getUpper()).intValue() == 30 && (range == null || ((Integer) rangeF.getLower()).intValue() < ((Integer) range.getLower()).intValue())) {
                    range = rangeF;
                }
            }
        }
        return range;
    }

    public Range g() {
        return this.a;
    }
}
