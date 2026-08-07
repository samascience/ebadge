package defpackage;

import com.jieli.lib.gif.GifError;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class gi0 {
    public static int a(int i, int i2) {
        if (i != 18) {
            if (i == 29) {
                return 13;
            }
            if (i == 20) {
                return 10;
            }
            if (i != 21) {
                switch (i) {
                    case 24:
                        return 34;
                    case 25:
                        return 33;
                    case 26:
                        return 14;
                    default:
                        return 0;
                }
            }
            if (i2 == 7) {
                return 11;
            }
            if (i2 != 8) {
                return i2 != 12 ? 0 : 5;
            }
            return 12;
        }
        switch (i2) {
            case 1:
                return 30;
            case 2:
                return 35;
            case 3:
                return 32;
            case 4:
                return 31;
            case 5:
                return 36;
            case 6:
                return 40;
            case 7:
            case 8:
                return 37;
            case 9:
                return 39;
            case 10:
            case 11:
            case 12:
            case 16:
            case 17:
            case 18:
            case 25:
            case 26:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 36:
            default:
                return 33;
            case 13:
            case 24:
                return 64;
            case 14:
                return 65;
            case 15:
                return GifError.ERR_OP_IN_PROGRESS;
            case 19:
                return 19;
            case 20:
                return ChartCoordinateportAnimator.FAST_ANIMATION_DURATION;
            case 21:
                return 38;
            case 22:
                return GifError.ERR_INVALID_PARAM;
            case 23:
                return 23;
            case 27:
                return 68;
            case 33:
                return 25;
            case 34:
                return 91;
            case 35:
                return 92;
            case 37:
                return 94;
            case 38:
                return 93;
            case 39:
                return 97;
            case 40:
                return 98;
            case 41:
                return 24;
            case 42:
                return 99;
            case 43:
                return 100;
            case 44:
                return 101;
        }
    }
}
