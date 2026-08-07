package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import defpackage.m42;

/* JADX INFO: loaded from: classes.dex */
class l extends PopupWindow {
    private static final boolean b = false;
    private boolean a;

    public l(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        e0 e0VarV = e0.v(context, attributeSet, R$styleable.PopupWindow, i, i2);
        int i3 = R$styleable.PopupWindow_overlapAnchor;
        if (e0VarV.s(i3)) {
            b(e0VarV.a(i3, false));
        }
        setBackgroundDrawable(e0VarV.g(R$styleable.PopupWindow_android_popupBackground));
        e0VarV.x();
    }

    private void b(boolean z) {
        if (b) {
            this.a = z;
        } else {
            m42.a(this, z);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (b && this.a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        if (b && this.a) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (b && this.a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }
}
