package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButton;
import defpackage.az1;
import defpackage.be3;
import defpackage.hw1;
import defpackage.m2;
import defpackage.t1;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialCalendar<S> extends com.google.android.material.datepicker.j {
    static final Object o = "MONTHS_VIEW_GROUP_TAG";
    static final Object p = "NAVIGATION_PREV_TAG";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final Object f256q = "NAVIGATION_NEXT_TAG";
    static final Object r = "SELECTOR_TOGGLE_TAG";
    private int b;
    private DateSelector c;
    private CalendarConstraints d;
    private DayViewDecorator e;
    private Month f;
    private CalendarSelector g;
    private com.google.android.material.datepicker.b h;
    private RecyclerView i;
    private RecyclerView j;
    private View k;
    private View l;
    private View m;
    private View n;

    enum CalendarSelector {
        DAY,
        YEAR
    }

    class a implements View.OnClickListener {
        final /* synthetic */ com.google.android.material.datepicker.i a;

        a(com.google.android.material.datepicker.i iVar) {
            this.a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iFindLastVisibleItemPosition = MaterialCalendar.this.M().findLastVisibleItemPosition() - 1;
            if (iFindLastVisibleItemPosition >= 0) {
                MaterialCalendar.this.P(this.a.d(iFindLastVisibleItemPosition));
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.this.j.smoothScrollToPosition(this.a);
        }
    }

    class c extends t1 {
        c() {
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            super.onInitializeAccessibilityNodeInfo(view, m2Var);
            m2Var.l0(null);
        }
    }

    class d extends com.google.android.material.datepicker.k {
        final /* synthetic */ int a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.a = i2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            if (this.a == 0) {
                iArr[0] = MaterialCalendar.this.j.getWidth();
                iArr[1] = MaterialCalendar.this.j.getWidth();
            } else {
                iArr[0] = MaterialCalendar.this.j.getHeight();
                iArr[1] = MaterialCalendar.this.j.getHeight();
            }
        }
    }

    class e implements l {
        e() {
        }

        @Override // com.google.android.material.datepicker.MaterialCalendar.l
        public void a(long j) {
            if (MaterialCalendar.this.d.g().k0(j)) {
                MaterialCalendar.this.c.A0(j);
                Iterator it = MaterialCalendar.this.a.iterator();
                while (it.hasNext()) {
                    ((hw1) it.next()).b(MaterialCalendar.this.c.w0());
                }
                MaterialCalendar.this.j.getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.this.i != null) {
                    MaterialCalendar.this.i.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    class f extends t1 {
        f() {
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            super.onInitializeAccessibilityNodeInfo(view, m2Var);
            m2Var.G0(false);
        }
    }

    class g extends RecyclerView.ItemDecoration {
        private final Calendar a = m.m();
        private final Calendar b = m.m();

        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if ((recyclerView.getAdapter() instanceof n) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                n nVar = (n) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (az1 az1Var : MaterialCalendar.this.c.C()) {
                    Object obj = az1Var.a;
                    if (obj != null && az1Var.b != null) {
                        this.a.setTimeInMillis(((Long) obj).longValue());
                        this.b.setTimeInMillis(((Long) az1Var.b).longValue());
                        int iE = nVar.e(this.a.get(1));
                        int iE2 = nVar.e(this.b.get(1));
                        View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iE);
                        View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(iE2);
                        int spanCount = iE / gridLayoutManager.getSpanCount();
                        int spanCount2 = iE2 / gridLayoutManager.getSpanCount();
                        int i = spanCount;
                        while (i <= spanCount2) {
                            View viewFindViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i);
                            if (viewFindViewByPosition3 != null) {
                                canvas.drawRect((i != spanCount || viewFindViewByPosition == null) ? 0 : viewFindViewByPosition.getLeft() + (viewFindViewByPosition.getWidth() / 2), viewFindViewByPosition3.getTop() + MaterialCalendar.this.h.d.c(), (i != spanCount2 || viewFindViewByPosition2 == null) ? recyclerView.getWidth() : viewFindViewByPosition2.getLeft() + (viewFindViewByPosition2.getWidth() / 2), viewFindViewByPosition3.getBottom() - MaterialCalendar.this.h.d.b(), MaterialCalendar.this.h.h);
                            }
                            i++;
                        }
                    }
                }
            }
        }
    }

    class h extends t1 {
        h() {
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            super.onInitializeAccessibilityNodeInfo(view, m2Var);
            m2Var.u0(MaterialCalendar.this.n.getVisibility() == 0 ? MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_year_selection) : MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_day_selection));
        }
    }

    class i extends RecyclerView.OnScrollListener {
        final /* synthetic */ com.google.android.material.datepicker.i a;
        final /* synthetic */ MaterialButton b;

        i(com.google.android.material.datepicker.i iVar, MaterialButton materialButton) {
            this.a = iVar;
            this.b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                recyclerView.announceForAccessibility(this.b.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int iFindFirstVisibleItemPosition = i < 0 ? MaterialCalendar.this.M().findFirstVisibleItemPosition() : MaterialCalendar.this.M().findLastVisibleItemPosition();
            MaterialCalendar.this.f = this.a.d(iFindFirstVisibleItemPosition);
            this.b.setText(this.a.e(iFindFirstVisibleItemPosition));
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialCalendar.this.S();
        }
    }

    class k implements View.OnClickListener {
        final /* synthetic */ com.google.android.material.datepicker.i a;

        k(com.google.android.material.datepicker.i iVar) {
            this.a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iFindFirstVisibleItemPosition = MaterialCalendar.this.M().findFirstVisibleItemPosition() + 1;
            if (iFindFirstVisibleItemPosition < MaterialCalendar.this.j.getAdapter().getItemCount()) {
                MaterialCalendar.this.P(this.a.d(iFindFirstVisibleItemPosition));
            }
        }
    }

    interface l {
        void a(long j);
    }

    private void E(View view, com.google.android.material.datepicker.i iVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.month_navigation_fragment_toggle);
        materialButton.setTag(r);
        be3.p0(materialButton, new h());
        View viewFindViewById = view.findViewById(R$id.month_navigation_previous);
        this.k = viewFindViewById;
        viewFindViewById.setTag(p);
        View viewFindViewById2 = view.findViewById(R$id.month_navigation_next);
        this.l = viewFindViewById2;
        viewFindViewById2.setTag(f256q);
        this.m = view.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.n = view.findViewById(R$id.mtrl_calendar_day_selector_frame);
        Q(CalendarSelector.DAY);
        materialButton.setText(this.f.h());
        this.j.addOnScrollListener(new i(iVar, materialButton));
        materialButton.setOnClickListener(new j());
        this.l.setOnClickListener(new k(iVar));
        this.k.setOnClickListener(new a(iVar));
    }

    private RecyclerView.ItemDecoration F() {
        return new g();
    }

    static int K(Context context) {
        return context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height);
    }

    private static int L(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height);
        int i2 = com.google.android.material.datepicker.h.g;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding);
    }

    public static MaterialCalendar N(DateSelector dateSelector, int i2, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        MaterialCalendar materialCalendar = new MaterialCalendar();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.k());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    private void O(int i2) {
        this.j.post(new b(i2));
    }

    private void R() {
        be3.p0(this.j, new f());
    }

    CalendarConstraints G() {
        return this.d;
    }

    com.google.android.material.datepicker.b H() {
        return this.h;
    }

    Month I() {
        return this.f;
    }

    public DateSelector J() {
        return this.c;
    }

    LinearLayoutManager M() {
        return (LinearLayoutManager) this.j.getLayoutManager();
    }

    void P(Month month) {
        com.google.android.material.datepicker.i iVar = (com.google.android.material.datepicker.i) this.j.getAdapter();
        int iF = iVar.f(month);
        int iF2 = iF - iVar.f(this.f);
        boolean z = Math.abs(iF2) > 3;
        boolean z2 = iF2 > 0;
        this.f = month;
        if (z && z2) {
            this.j.scrollToPosition(iF - 3);
            O(iF);
        } else if (!z) {
            O(iF);
        } else {
            this.j.scrollToPosition(iF + 3);
            O(iF);
        }
    }

    void Q(CalendarSelector calendarSelector) {
        this.g = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.i.getLayoutManager().scrollToPosition(((n) this.i.getAdapter()).e(this.f.c));
            this.m.setVisibility(0);
            this.n.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            return;
        }
        if (calendarSelector == CalendarSelector.DAY) {
            this.m.setVisibility(8);
            this.n.setVisibility(0);
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            P(this.f);
        }
    }

    void S() {
        CalendarSelector calendarSelector = this.g;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            Q(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            Q(calendarSelector2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.b = bundle.getInt("THEME_RES_ID_KEY");
        this.c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.e = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.b);
        this.h = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month monthL = this.d.l();
        if (MaterialDatePicker.c0(contextThemeWrapper)) {
            i2 = R$layout.mtrl_calendar_vertical;
            i3 = 1;
        } else {
            i2 = R$layout.mtrl_calendar_horizontal;
            i3 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i2, viewGroup, false);
        viewInflate.setMinimumHeight(L(requireContext()));
        GridView gridView = (GridView) viewInflate.findViewById(R$id.mtrl_calendar_days_of_week);
        be3.p0(gridView, new c());
        int i4 = this.d.i();
        gridView.setAdapter((ListAdapter) (i4 > 0 ? new com.google.android.material.datepicker.g(i4) : new com.google.android.material.datepicker.g()));
        gridView.setNumColumns(monthL.d);
        gridView.setEnabled(false);
        this.j = (RecyclerView) viewInflate.findViewById(R$id.mtrl_calendar_months);
        this.j.setLayoutManager(new d(getContext(), i3, false, i3));
        this.j.setTag(o);
        com.google.android.material.datepicker.i iVar = new com.google.android.material.datepicker.i(contextThemeWrapper, this.c, this.d, this.e, new e());
        this.j.setAdapter(iVar);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.i = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.i.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.i.setAdapter(new n(this));
            this.i.addItemDecoration(F());
        }
        if (viewInflate.findViewById(R$id.month_navigation_fragment_toggle) != null) {
            E(viewInflate, iVar);
        }
        if (!MaterialDatePicker.c0(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.j);
        }
        this.j.scrollToPosition(iVar.f(this.f));
        R();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.d);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.e);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f);
    }

    @Override // com.google.android.material.datepicker.j
    public boolean v(hw1 hw1Var) {
        return super.v(hw1Var);
    }
}
