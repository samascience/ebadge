package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class g extends RecyclerView.OnScrollListener {
    private ViewPager2.i a;
    private final ViewPager2 b;
    private final RecyclerView c;
    private final LinearLayoutManager d;
    private int e;
    private int f;
    private a g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    private static final class a {
        int a;
        float b;
        int c;

        a() {
        }

        void a() {
            this.a = -1;
            this.b = 0.0f;
            this.c = 0;
        }
    }

    g(ViewPager2 viewPager2) {
        this.b = viewPager2;
        RecyclerView recyclerView = viewPager2.j;
        this.c = recyclerView;
        this.d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.g = new a();
        l();
    }

    private void a(int i, float f, int i2) {
        ViewPager2.i iVar = this.a;
        if (iVar != null) {
            iVar.onPageScrolled(i, f, i2);
        }
    }

    private void b(int i) {
        ViewPager2.i iVar = this.a;
        if (iVar != null) {
            iVar.onPageSelected(i);
        }
    }

    private void c(int i) {
        if ((this.e == 3 && this.f == 0) || this.f == i) {
            return;
        }
        this.f = i;
        ViewPager2.i iVar = this.a;
        if (iVar != null) {
            iVar.onPageScrollStateChanged(i);
        }
    }

    private int d() {
        return this.d.findFirstVisibleItemPosition();
    }

    private boolean i() {
        int i = this.e;
        return i == 1 || i == 4;
    }

    private void l() {
        this.e = 0;
        this.f = 0;
        this.g.a();
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.k = false;
        this.m = false;
        this.l = false;
    }

    private void n(boolean z) {
        this.m = z;
        this.e = z ? 4 : 1;
        int i = this.i;
        if (i != -1) {
            this.h = i;
            this.i = -1;
        } else if (this.h == -1) {
            this.h = d();
        }
        c(1);
    }

    private void o() {
        int top;
        a aVar = this.g;
        int iFindFirstVisibleItemPosition = this.d.findFirstVisibleItemPosition();
        aVar.a = iFindFirstVisibleItemPosition;
        if (iFindFirstVisibleItemPosition == -1) {
            aVar.a();
            return;
        }
        View viewFindViewByPosition = this.d.findViewByPosition(iFindFirstVisibleItemPosition);
        if (viewFindViewByPosition == null) {
            aVar.a();
            return;
        }
        int leftDecorationWidth = this.d.getLeftDecorationWidth(viewFindViewByPosition);
        int rightDecorationWidth = this.d.getRightDecorationWidth(viewFindViewByPosition);
        int topDecorationHeight = this.d.getTopDecorationHeight(viewFindViewByPosition);
        int bottomDecorationHeight = this.d.getBottomDecorationHeight(viewFindViewByPosition);
        ViewGroup.LayoutParams layoutParams = viewFindViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = viewFindViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = viewFindViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.d.getOrientation() == 0) {
            top = (viewFindViewByPosition.getLeft() - leftDecorationWidth) - this.c.getPaddingLeft();
            if (this.b.f()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewFindViewByPosition.getTop() - topDecorationHeight) - this.c.getPaddingTop();
        }
        int i = -top;
        aVar.c = i;
        if (i >= 0) {
            aVar.b = height == 0 ? 0.0f : i / height;
        } else {
            if (!new androidx.viewpager2.widget.a(this.d).d()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    double e() {
        o();
        a aVar = this.g;
        return ((double) aVar.a) + ((double) aVar.b);
    }

    int f() {
        return this.f;
    }

    boolean g() {
        return this.m;
    }

    boolean h() {
        return this.f == 0;
    }

    void j() {
        this.l = true;
    }

    void k(int i, boolean z) {
        this.e = z ? 2 : 3;
        this.m = false;
        boolean z2 = this.i != i;
        this.i = i;
        c(2);
        if (z2) {
            b(i);
        }
    }

    void m(ViewPager2.i iVar) {
        this.a = iVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (!(this.e == 1 && this.f == 1) && i == 1) {
            n(false);
            return;
        }
        if (i() && i == 2) {
            if (this.k) {
                c(2);
                this.j = true;
                return;
            }
            return;
        }
        if (i() && i == 0) {
            o();
            if (this.k) {
                a aVar = this.g;
                if (aVar.c == 0) {
                    int i2 = this.h;
                    int i3 = aVar.a;
                    if (i2 != i3) {
                        b(i3);
                    }
                }
            } else {
                int i4 = this.g.a;
                if (i4 != -1) {
                    a(i4, 0.0f, 0);
                }
            }
            c(0);
            l();
        }
        if (this.e == 2 && i == 0 && this.l) {
            o();
            a aVar2 = this.g;
            if (aVar2.c == 0) {
                int i5 = this.i;
                int i6 = aVar2.a;
                if (i5 != i6) {
                    if (i6 == -1) {
                        i6 = 0;
                    }
                    b(i6);
                }
                c(0);
                l();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001f  */
    /* JADX WARN: Code duplicated, block: B:14:0x0025  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        a aVar;
        int i3;
        this.k = true;
        o();
        if (this.j) {
            this.j = false;
            if (i2 > 0) {
                aVar = this.g;
                if (aVar.c != 0) {
                    i3 = aVar.a + 1;
                } else {
                    i3 = this.g.a;
                }
            } else {
                if (i2 == 0) {
                    if ((i < 0) == this.b.f()) {
                        aVar = this.g;
                        if (aVar.c != 0) {
                            i3 = aVar.a + 1;
                        }
                    }
                }
                i3 = this.g.a;
            }
            this.i = i3;
            if (this.h != i3) {
                b(i3);
            }
        } else if (this.e == 0) {
            int i4 = this.g.a;
            if (i4 == -1) {
                i4 = 0;
            }
            b(i4);
        }
        a aVar2 = this.g;
        int i5 = aVar2.a;
        if (i5 == -1) {
            i5 = 0;
        }
        a(i5, aVar2.b, aVar2.c);
        a aVar3 = this.g;
        int i6 = aVar3.a;
        int i7 = this.i;
        if ((i6 == i7 || i7 == -1) && aVar3.c == 0 && this.f != 1) {
            c(0);
            l();
        }
    }
}
