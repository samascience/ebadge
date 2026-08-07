package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class f extends ViewPager2.i {
    private final LinearLayoutManager a;
    private ViewPager2.k b;

    f(LinearLayoutManager linearLayoutManager) {
        this.a = linearLayoutManager;
    }

    ViewPager2.k a() {
        return this.b;
    }

    void b(ViewPager2.k kVar) {
        this.b = kVar;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageScrolled(int i, float f, int i2) {
        if (this.b == null) {
            return;
        }
        float f2 = -f;
        for (int i3 = 0; i3 < this.a.getChildCount(); i3++) {
            View childAt = this.a.getChildAt(i3);
            if (childAt == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.a.getChildCount())));
            }
            this.b.transformPage(childAt, (this.a.getPosition(childAt) - i) + f2);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageSelected(int i) {
    }
}
