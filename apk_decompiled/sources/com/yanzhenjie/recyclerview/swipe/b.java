package com.yanzhenjie.recyclerview.swipe;

import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes.dex */
abstract class b {
    private int a;
    private View b;
    protected a c = new a();

    public static final class a {
        public int a;
        public int b;
        public boolean c;
    }

    public b(int i, View view) {
        this.a = i;
        this.b = view;
    }

    public abstract void a(OverScroller overScroller, int i, int i2);

    public abstract void b(OverScroller overScroller, int i, int i2);

    public boolean c() {
        View view = this.b;
        return (view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0;
    }

    public abstract a d(int i, int i2);

    public int e() {
        return this.a;
    }

    public View f() {
        return this.b;
    }

    public int g() {
        return this.b.getWidth();
    }

    public abstract boolean h(int i, float f);

    public boolean i(int i) {
        return i == 0 && (-f().getWidth()) * e() != 0;
    }
}
