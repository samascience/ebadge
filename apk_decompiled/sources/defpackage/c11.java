package defpackage;

import android.content.Context;
import com.previewlibrary.R$dimen;

/* JADX INFO: loaded from: classes.dex */
public abstract class c11 {
    public static int a(Context context) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.yms_dimens_50_0_px);
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : dimensionPixelSize;
    }
}
