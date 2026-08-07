package defpackage;

import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public class dn1 {
    ViewPager a;
    kf1 b;

    public dn1(ViewPager viewPager) {
        this.a = viewPager;
        b();
    }

    private void b() {
        this.b = new kf1(this.a.getContext());
        try {
            Field declaredField = ViewPager.class.getDeclaredField("j");
            declaredField.setAccessible(true);
            declaredField.set(this.a, this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public kf1 a() {
        return this.b;
    }
}
