package androidx.viewpager2.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c implements ViewPager2.k {
    private final List a = new ArrayList();

    public void a(ViewPager2.k kVar) {
        this.a.add(kVar);
    }

    public void b(ViewPager2.k kVar) {
        this.a.remove(kVar);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.k
    public void transformPage(View view, float f) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((ViewPager2.k) it.next()).transformPage(view, f);
        }
    }
}
