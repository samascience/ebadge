package com.gyf.immersionbar;

import android.R;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes3.dex */
class f implements ViewTreeObserver.OnGlobalLayoutListener {
    private h a;
    private Window b;
    private View c;
    private View d;
    private View e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;

    f(h hVar) {
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.a = hVar;
        Window windowD = hVar.D();
        this.b = windowD;
        View decorView = windowD.getDecorView();
        this.c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(R.id.content);
        if (hVar.L()) {
            Fragment fragmentC = hVar.C();
            if (fragmentC != null) {
                this.e = fragmentC.getView();
            } else {
                android.app.Fragment fragmentV = hVar.v();
                if (fragmentV != null) {
                    this.e = fragmentV.getView();
                }
            }
        } else {
            View childAt = frameLayout.getChildAt(0);
            this.e = childAt;
            if (childAt != null && (childAt instanceof DrawerLayout)) {
                this.e = ((DrawerLayout) childAt).getChildAt(0);
            }
        }
        View view = this.e;
        if (view != null) {
            this.f = view.getPaddingLeft();
            this.g = this.e.getPaddingTop();
            this.h = this.e.getPaddingRight();
            this.i = this.e.getPaddingBottom();
        }
        View view2 = this.e;
        this.d = view2 != null ? view2 : frameLayout;
    }

    void a() {
        if (this.k) {
            this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.k = false;
        }
    }

    void b() {
        if (this.k) {
            if (this.e != null) {
                this.d.setPadding(this.f, this.g, this.h, this.i);
            } else {
                this.d.setPadding(this.a.x(), this.a.z(), this.a.y(), this.a.w());
            }
        }
    }

    void c(int i) {
        this.b.setSoftInputMode(i);
        if (this.k) {
            return;
        }
        this.c.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.k = true;
    }

    void d() {
        this.j = 0;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        h hVar = this.a;
        if (hVar == null || hVar.u() == null || !this.a.u().K) {
            return;
        }
        a aVarT = this.a.t();
        int iD = aVarT.m() ? aVarT.d() : aVarT.g();
        Rect rect = new Rect();
        this.c.getWindowVisibleDisplayFrame(rect);
        int height = this.d.getHeight() - rect.bottom;
        if (height != this.j) {
            this.j = height;
            int i = 0;
            int i2 = 1;
            if (h.f(this.b.getDecorView().findViewById(R.id.content))) {
                if (height - iD > iD) {
                    i = i2;
                }
            } else if (this.e != null) {
                if (this.a.u().J) {
                    height += this.a.r() + aVarT.j();
                }
                if (this.a.u().y) {
                    height += aVarT.j();
                }
                if (height > iD) {
                    i = height + this.i;
                } else {
                    i2 = 0;
                }
                this.d.setPadding(this.f, this.g, this.h, i);
                i = i2;
            } else {
                int iW = this.a.w();
                int i3 = height - iD;
                if (i3 > iD) {
                    iW = i3 + iD;
                    i = 1;
                }
                this.d.setPadding(this.a.x(), this.a.z(), this.a.y(), iW);
            }
            this.a.u().getClass();
            if (i == 0 && this.a.u().j != BarHide.FLAG_SHOW_BAR) {
                this.a.W();
            }
            if (i == 0) {
                this.a.k();
            }
        }
    }
}
