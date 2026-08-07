package defpackage;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.core.graphics.BlendModeCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class bk {

    static class a {
        static ColorFilter a(int i, Object obj) {
            return new BlendModeColorFilter(i, (BlendMode) obj);
        }
    }

    public static ColorFilter a(int i, BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object objA = ck.b.a(blendModeCompat);
            if (objA != null) {
                return a.a(i, objA);
            }
            return null;
        }
        PorterDuff.Mode modeA = ck.a(blendModeCompat);
        if (modeA != null) {
            return new PorterDuffColorFilter(i, modeA);
        }
        return null;
    }
}
