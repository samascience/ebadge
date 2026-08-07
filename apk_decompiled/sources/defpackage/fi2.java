package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

/* JADX INFO: loaded from: classes.dex */
class fi2 extends gi2 {
    protected fi2(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    @Override // defpackage.gi2
    void c(int i, int i2, int i3, Rect rect, Rect rect2) {
        Gravity.apply(i, i2, i3, rect, rect2, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        g();
        outline.setRoundRect(this.h, b());
    }
}
