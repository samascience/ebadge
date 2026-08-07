package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import defpackage.m42;
import defpackage.qo2;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class v implements qo2 {
    private static Method L;
    private static Method M;
    private Runnable F;
    final Handler G;
    private final Rect H;
    private Rect I;
    private boolean J;
    PopupWindow K;
    private Context a;
    private ListAdapter b;
    t c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private boolean m;
    private boolean n;
    int o;
    private View p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f145q;
    private DataSetObserver r;
    private View s;
    private Drawable t;
    private AdapterView.OnItemClickListener u;
    private AdapterView.OnItemSelectedListener v;
    final i w;
    private final h x;
    private final g y;
    private final e z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewT = v.this.t();
            if (viewT == null || viewT.getWindowToken() == null) {
                return;
            }
            v.this.b();
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            t tVar;
            if (i == -1 || (tVar = v.this.c) == null) {
                return;
            }
            tVar.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    static class c {
        static int a(PopupWindow popupWindow, View view, int i, boolean z) {
            return popupWindow.getMaxAvailableHeight(view, i, z);
        }
    }

    static class d {
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void b(PopupWindow popupWindow, boolean z) {
            popupWindow.setIsClippedToScreen(z);
        }
    }

    private class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.r();
        }
    }

    private class f extends DataSetObserver {
        f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (v.this.a()) {
                v.this.b();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            v.this.dismiss();
        }
    }

    private class g implements AbsListView.OnScrollListener {
        g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || v.this.A() || v.this.K.getContentView() == null) {
                return;
            }
            v vVar = v.this;
            vVar.G.removeCallbacks(vVar.w);
            v.this.w.run();
        }
    }

    private class h implements View.OnTouchListener {
        h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = v.this.K) != null && popupWindow.isShowing() && x >= 0 && x < v.this.K.getWidth() && y >= 0 && y < v.this.K.getHeight()) {
                v vVar = v.this;
                vVar.G.postDelayed(vVar.w, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            v vVar2 = v.this;
            vVar2.G.removeCallbacks(vVar2.w);
            return false;
        }
    }

    private class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t tVar = v.this.c;
            if (tVar == null || !tVar.isAttachedToWindow() || v.this.c.getCount() <= v.this.c.getChildCount()) {
                return;
            }
            int childCount = v.this.c.getChildCount();
            v vVar = v.this;
            if (childCount <= vVar.o) {
                vVar.K.setInputMethodMode(2);
                v.this.b();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                L = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                M = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public v(Context context) {
        this(context, null, R$attr.listPopupWindowStyle);
    }

    private void C() {
        View view = this.p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.p);
            }
        }
    }

    private void O(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            d.b(this.K, z);
            return;
        }
        Method method = L;
        if (method != null) {
            try {
                method.invoke(this.K, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int q() {
        int measuredHeight;
        int i2;
        int iMakeMeasureSpec;
        View view;
        int i3;
        if (this.c == null) {
            Context context = this.a;
            this.F = new a();
            t tVarS = s(context, !this.J);
            this.c = tVarS;
            Drawable drawable = this.t;
            if (drawable != null) {
                tVarS.setSelector(drawable);
            }
            this.c.setAdapter(this.b);
            this.c.setOnItemClickListener(this.u);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new b());
            this.c.setOnScrollListener(this.y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.v;
            if (onItemSelectedListener != null) {
                this.c.setOnItemSelectedListener(onItemSelectedListener);
            }
            t tVar = this.c;
            View view2 = this.p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.f145q;
                if (i4 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(tVar, layoutParams);
                } else if (i4 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f145q);
                } else {
                    linearLayout.addView(tVar, layoutParams);
                    linearLayout.addView(view2);
                }
                int i5 = this.e;
                if (i5 >= 0) {
                    i3 = Integer.MIN_VALUE;
                } else {
                    i5 = 0;
                    i3 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = tVar;
            }
            this.K.setContentView(view);
        } else {
            View view3 = this.p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.K.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            Rect rect = this.H;
            int i6 = rect.top;
            i2 = rect.bottom + i6;
            if (!this.i) {
                this.g = -i6;
            }
        } else {
            this.H.setEmpty();
            i2 = 0;
        }
        int iU = u(t(), this.g, this.K.getInputMethodMode() == 2);
        if (this.m || this.d == -1) {
            return iU + i2;
        }
        int i7 = this.e;
        if (i7 == -2) {
            int i8 = this.a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.H;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i7 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        } else {
            int i9 = this.a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.H;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect3.left + rect3.right), 1073741824);
        }
        int iD = this.c.d(iMakeMeasureSpec, 0, -1, iU - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i2 + this.c.getPaddingTop() + this.c.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    private int u(View view, int i2, boolean z) {
        return c.a(this.K, view, i2, z);
    }

    public boolean A() {
        return this.K.getInputMethodMode() == 2;
    }

    public boolean B() {
        return this.J;
    }

    public void D(View view) {
        this.s = view;
    }

    public void E(int i2) {
        this.K.setAnimationStyle(i2);
    }

    public void F(int i2) {
        Drawable background = this.K.getBackground();
        if (background == null) {
            R(i2);
            return;
        }
        background.getPadding(this.H);
        Rect rect = this.H;
        this.e = rect.left + rect.right + i2;
    }

    public void G(int i2) {
        this.l = i2;
    }

    public void H(Rect rect) {
        this.I = rect != null ? new Rect(rect) : null;
    }

    public void I(int i2) {
        this.K.setInputMethodMode(i2);
    }

    public void J(boolean z) {
        this.J = z;
        this.K.setFocusable(z);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.K.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.u = onItemClickListener;
    }

    public void M(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.v = onItemSelectedListener;
    }

    public void N(boolean z) {
        this.k = true;
        this.j = z;
    }

    public void P(int i2) {
        this.f145q = i2;
    }

    public void Q(int i2) {
        t tVar = this.c;
        if (!a() || tVar == null) {
            return;
        }
        tVar.setListSelectionHidden(false);
        tVar.setSelection(i2);
        if (tVar.getChoiceMode() != 0) {
            tVar.setItemChecked(i2, true);
        }
    }

    public void R(int i2) {
        this.e = i2;
    }

    @Override // defpackage.qo2
    public boolean a() {
        return this.K.isShowing();
    }

    @Override // defpackage.qo2
    public void b() {
        int iQ = q();
        boolean zA = A();
        m42.b(this.K, this.h);
        if (this.K.isShowing()) {
            if (t().isAttachedToWindow()) {
                int width = this.e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = t().getWidth();
                }
                int i2 = this.d;
                if (i2 == -1) {
                    if (!zA) {
                        iQ = -1;
                    }
                    if (zA) {
                        this.K.setWidth(this.e == -1 ? -1 : 0);
                        this.K.setHeight(0);
                    } else {
                        this.K.setWidth(this.e == -1 ? -1 : 0);
                        this.K.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    iQ = i2;
                }
                this.K.setOutsideTouchable((this.n || this.m) ? false : true);
                this.K.update(t(), this.f, this.g, width < 0 ? -1 : width, iQ < 0 ? -1 : iQ);
                return;
            }
            return;
        }
        int width2 = this.e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = t().getWidth();
        }
        int i3 = this.d;
        if (i3 == -1) {
            iQ = -1;
        } else if (i3 != -2) {
            iQ = i3;
        }
        this.K.setWidth(width2);
        this.K.setHeight(iQ);
        O(true);
        this.K.setOutsideTouchable((this.n || this.m) ? false : true);
        this.K.setTouchInterceptor(this.x);
        if (this.k) {
            m42.a(this.K, this.j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = M;
            if (method != null) {
                try {
                    method.invoke(this.K, this.I);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            d.a(this.K, this.I);
        }
        m42.c(this.K, t(), this.f, this.g, this.l);
        this.c.setSelection(-1);
        if (!this.J || this.c.isInTouchMode()) {
            r();
        }
        if (this.J) {
            return;
        }
        this.G.post(this.z);
    }

    public void c(Drawable drawable) {
        this.K.setBackgroundDrawable(drawable);
    }

    public int d() {
        return this.f;
    }

    @Override // defpackage.qo2
    public void dismiss() {
        this.K.dismiss();
        C();
        this.K.setContentView(null);
        this.c = null;
        this.G.removeCallbacks(this.w);
    }

    public void f(int i2) {
        this.f = i2;
    }

    public Drawable i() {
        return this.K.getBackground();
    }

    @Override // defpackage.qo2
    public ListView k() {
        return this.c;
    }

    public void l(int i2) {
        this.g = i2;
        this.i = true;
    }

    public int o() {
        if (this.i) {
            return this.g;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.r;
        if (dataSetObserver == null) {
            this.r = new f();
        } else {
            ListAdapter listAdapter2 = this.b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.r);
        }
        t tVar = this.c;
        if (tVar != null) {
            tVar.setAdapter(this.b);
        }
    }

    public void r() {
        t tVar = this.c;
        if (tVar != null) {
            tVar.setListSelectionHidden(true);
            tVar.requestLayout();
        }
    }

    t s(Context context, boolean z) {
        return new t(context, z);
    }

    public View t() {
        return this.s;
    }

    public Object v() {
        if (a()) {
            return this.c.getSelectedItem();
        }
        return null;
    }

    public long w() {
        if (a()) {
            return this.c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int x() {
        if (a()) {
            return this.c.getSelectedItemPosition();
        }
        return -1;
    }

    public View y() {
        if (a()) {
            return this.c.getSelectedView();
        }
        return null;
    }

    public int z() {
        return this.e;
    }

    public v(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public v(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.d = -2;
        this.e = -2;
        this.h = 1002;
        this.l = 0;
        this.m = false;
        this.n = false;
        this.o = Integer.MAX_VALUE;
        this.f145q = 0;
        this.w = new i();
        this.x = new h();
        this.y = new g();
        this.z = new e();
        this.H = new Rect();
        this.a = context;
        this.G = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i2, i3);
        this.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        l lVar = new l(context, attributeSet, i2, i3);
        this.K = lVar;
        lVar.setInputMethodMode(1);
    }
}
