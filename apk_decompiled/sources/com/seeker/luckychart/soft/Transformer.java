package com.seeker.luckychart.soft;

import android.graphics.Rect;
import com.seeker.luckychart.model.Coordinateport;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transformer {
    private Coordinateport visibleCoorport = new Coordinateport();
    private Rect dataContentRect = new Rect();

    public float computeRawX(int i) {
        return this.dataContentRect.left + ((i - this.visibleCoorport.left) * (this.dataContentRect.width() / this.visibleCoorport.width()));
    }

    public float computeRawY(float f) {
        return this.dataContentRect.bottom - ((f - this.visibleCoorport.bottom) * (this.dataContentRect.height() / this.visibleCoorport.height()));
    }

    public boolean needDraw(float f, float f2) {
        if (f != f2) {
            return true;
        }
        Rect rect = this.dataContentRect;
        return (f == ((float) rect.top) || f == ((float) rect.bottom)) ? false : true;
    }

    public final void setDataContentRect(int i, int i2, int i3, int i4) {
        this.dataContentRect.set(i, i2, i3, i4);
    }

    public final void setVisibleCoorport(float f, float f2, float f3, float f4) {
        this.visibleCoorport.set(f, f2, f3, f4);
    }
}
