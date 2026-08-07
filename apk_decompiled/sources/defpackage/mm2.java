package defpackage;

import android.R;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.core.graphics.BlendModeCompat;

/* JADX INFO: loaded from: classes3.dex */
public class mm2 extends StateListDrawable {
    private final int a;

    public mm2(Drawable drawable, int i) {
        this.a = i;
        addState(new int[]{R.attr.state_selected}, drawable);
        addState(new int[0], drawable);
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        for (int i : iArr) {
            if (i == 16842913) {
                z = true;
            }
        }
        if (z) {
            super.setColorFilter(bk.a(this.a, BlendModeCompat.SRC_ATOP));
        } else {
            super.clearColorFilter();
        }
        return super.onStateChange(iArr);
    }
}
