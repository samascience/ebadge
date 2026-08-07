package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class sa3 {
    private static int b;
    private static HashMap a = new HashMap();
    private static boolean c = false;

    static class a implements Runnable {
        final /* synthetic */ Scroller a;
        final /* synthetic */ RecyclerView b;
        final /* synthetic */ CoordinatorLayout c;

        a(Scroller scroller, RecyclerView recyclerView, CoordinatorLayout coordinatorLayout) {
            this.a = scroller;
            this.b = recyclerView;
            this.c = coordinatorLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.computeScrollOffset()) {
                this.b.offsetTopAndBottom(this.a.getCurrY() - this.b.getTop());
                sa3.j(this.b.getTop());
                this.c.p(this.b);
                be3.h0(this.b, this);
            }
        }
    }

    private static int a(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    public static void b() {
        a.clear();
    }

    public static int c() {
        return Calendar.getInstance().get(5);
    }

    public static int d() {
        return Calendar.getInstance().get(2) + 1;
    }

    public static int e(int i, int i2) {
        if (i2 > 12) {
            i++;
            i2 = 1;
        } else if (i2 < 1) {
            i--;
            i2 = 12;
        }
        int[] iArr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            iArr[1] = 29;
        }
        try {
            return iArr[i2 - 1];
        } catch (Exception e) {
            e.getStackTrace();
            return 0;
        }
    }

    public static int f(Context context) {
        return ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public static int g() {
        return Calendar.getInstance().get(1);
    }

    public static boolean h() {
        return c;
    }

    public static int i() {
        return b;
    }

    public static void j(int i) {
        b = i;
    }

    public static int k(View view, int i, int i2, int i3) {
        int top = view.getTop();
        int iA = a(top - i, i2, i3) - top;
        view.offsetTopAndBottom(iA);
        return -iA;
    }

    public static void l(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, int i, int i2) {
        Scroller scroller = new Scroller(coordinatorLayout.getContext());
        int i3 = b;
        scroller.startScroll(0, i3, 0, i - i3, i2);
        be3.h0(recyclerView, new a(scroller, recyclerView, coordinatorLayout));
    }

    public static void m(boolean z) {
        c = z;
    }
}
