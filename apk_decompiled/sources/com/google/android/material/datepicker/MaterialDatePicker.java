package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import defpackage.be3;
import defpackage.df0;
import defpackage.e43;
import defpackage.gg1;
import defpackage.hw1;
import defpackage.mu1;
import defpackage.nf3;
import defpackage.tg1;
import defpackage.v8;
import defpackage.y21;
import defpackage.zi3;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    static final Object Z = "CONFIRM_BUTTON_TAG";
    static final Object a0 = "CANCEL_BUTTON_TAG";
    static final Object b0 = "TOGGLE_BUTTON_TAG";
    private int F;
    private CharSequence G;
    private boolean H;
    private int I;
    private int J;
    private CharSequence K;
    private int L;
    private CharSequence M;
    private int N;
    private CharSequence O;
    private int P;
    private CharSequence Q;
    private TextView R;
    private TextView S;
    private CheckableImageButton T;
    private tg1 U;
    private Button V;
    private boolean W;
    private CharSequence X;
    private CharSequence Y;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final LinkedHashSet f257q = new LinkedHashSet();
    private final LinkedHashSet r = new LinkedHashSet();
    private final LinkedHashSet s = new LinkedHashSet();
    private final LinkedHashSet t = new LinkedHashSet();
    private int u;
    private DateSelector v;
    private j w;
    private CalendarConstraints x;
    private DayViewDecorator y;
    private MaterialCalendar z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialDatePicker.this.f257q.iterator();
            if (!it.hasNext()) {
                MaterialDatePicker.this.y();
            } else {
                e43.a(it.next());
                MaterialDatePicker.this.Z();
                throw null;
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialDatePicker.this.r.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            MaterialDatePicker.this.y();
        }
    }

    class c implements mu1 {
        final /* synthetic */ int a;
        final /* synthetic */ View b;
        final /* synthetic */ int c;

        c(int i, View view, int i2) {
            this.a = i;
            this.b = view;
            this.c = i2;
        }

        @Override // defpackage.mu1
        public zi3 a(View view, zi3 zi3Var) {
            int i = zi3Var.f(zi3.l.d()).b;
            if (this.a >= 0) {
                this.b.getLayoutParams().height = this.a + i;
                View view2 = this.b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.b;
            view3.setPadding(view3.getPaddingLeft(), this.c + i, this.b.getPaddingRight(), this.b.getPaddingBottom());
            return zi3Var;
        }
    }

    class d extends hw1 {
        d() {
        }

        @Override // defpackage.hw1
        public void a() {
            MaterialDatePicker.this.V.setEnabled(false);
        }

        @Override // defpackage.hw1
        public void b(Object obj) {
            MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
            materialDatePicker.i0(materialDatePicker.X());
            MaterialDatePicker.this.V.setEnabled(MaterialDatePicker.this.U().m0());
        }
    }

    private static Drawable S(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, v8.b(context, R$drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], v8.b(context, R$drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private void T(Window window) {
        if (this.W) {
            return;
        }
        View viewFindViewById = requireView().findViewById(R$id.fullscreen_header);
        df0.a(window, true, nf3.h(viewFindViewById), null);
        be3.E0(viewFindViewById, new c(viewFindViewById.getLayoutParams().height, viewFindViewById, viewFindViewById.getPaddingTop()));
        this.W = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateSelector U() {
        if (this.v == null) {
            this.v = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.v;
    }

    private static CharSequence V(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] strArrSplit = TextUtils.split(String.valueOf(charSequence), "\n");
        return strArrSplit.length > 1 ? strArrSplit[0] : charSequence;
    }

    private String W() {
        return U().e0(requireContext());
    }

    private static int Y(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        int i = Month.d().d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width) * i) + ((i - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding));
    }

    private int a0(Context context) {
        int i = this.u;
        return i != 0 ? i : U().j0(context);
    }

    private void b0(Context context) {
        this.T.setTag(b0);
        this.T.setImageDrawable(S(context));
        this.T.setChecked(this.I != 0);
        be3.p0(this.T, null);
        k0(this.T);
        this.T.setOnClickListener(new View.OnClickListener() { // from class: pg1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.f0(view);
            }
        });
    }

    static boolean c0(Context context) {
        return g0(context, R.attr.windowFullscreen);
    }

    private boolean d0() {
        return getResources().getConfiguration().orientation == 2;
    }

    static boolean e0(Context context) {
        return g0(context, R$attr.nestedScrollable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(View view) {
        this.V.setEnabled(U().m0());
        this.T.toggle();
        this.I = this.I == 1 ? 0 : 1;
        k0(this.T);
        h0();
    }

    static boolean g0(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(gg1.d(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    private void h0() {
        int iA0 = a0(requireContext());
        MaterialCalendar materialCalendarN = MaterialCalendar.N(U(), iA0, this.x, this.y);
        this.z = materialCalendarN;
        j jVarX = materialCalendarN;
        if (this.I == 1) {
            jVarX = MaterialTextInputPicker.x(U(), iA0, this.x);
        }
        this.w = jVarX;
        j0();
        i0(X());
        androidx.fragment.app.m mVarP = getChildFragmentManager().p();
        mVarP.p(R$id.mtrl_calendar_frame, this.w);
        mVarP.j();
        this.w.v(new d());
    }

    private void j0() {
        this.R.setText((this.I == 1 && d0()) ? this.Y : this.X);
    }

    private void k0(CheckableImageButton checkableImageButton) {
        this.T.setContentDescription(this.I == 1 ? checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog E(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), a0(requireContext()));
        Context context = dialog.getContext();
        this.H = c0(context);
        int i = R$attr.materialCalendarStyle;
        int i2 = R$style.Widget_MaterialComponents_MaterialCalendar;
        this.U = new tg1(context, null, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.MaterialCalendar, i, i2);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.MaterialCalendar_backgroundTint, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.U.Q(context);
        this.U.b0(ColorStateList.valueOf(color));
        this.U.a0(be3.v(dialog.getWindow().getDecorView()));
        return dialog;
    }

    public String X() {
        return U().y(getContext());
    }

    public final Object Z() {
        return U().w0();
    }

    void i0(String str) {
        this.S.setContentDescription(W());
        this.S.setText(str);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.s.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.u = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.v = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.x = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.y = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.F = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.G = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.I = bundle.getInt("INPUT_MODE_KEY");
        this.J = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.K = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.L = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.M = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.N = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.O = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.P = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.Q = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.G;
        if (text == null) {
            text = requireContext().getResources().getText(this.F);
        }
        this.X = text;
        this.Y = V(text);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.H ? R$layout.mtrl_picker_fullscreen : R$layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        DayViewDecorator dayViewDecorator = this.y;
        if (dayViewDecorator != null) {
            dayViewDecorator.h(context);
        }
        if (this.H) {
            viewInflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(Y(context), -2));
        } else {
            viewInflate.findViewById(R$id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(Y(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(R$id.mtrl_picker_header_selection_text);
        this.S = textView;
        be3.r0(textView, 1);
        this.T = (CheckableImageButton) viewInflate.findViewById(R$id.mtrl_picker_header_toggle);
        this.R = (TextView) viewInflate.findViewById(R$id.mtrl_picker_title_text);
        b0(context);
        this.V = (Button) viewInflate.findViewById(R$id.confirm_button);
        if (U().m0()) {
            this.V.setEnabled(true);
        } else {
            this.V.setEnabled(false);
        }
        this.V.setTag(Z);
        CharSequence charSequence = this.K;
        if (charSequence != null) {
            this.V.setText(charSequence);
        } else {
            int i = this.J;
            if (i != 0) {
                this.V.setText(i);
            }
        }
        CharSequence charSequence2 = this.M;
        if (charSequence2 != null) {
            this.V.setContentDescription(charSequence2);
        } else if (this.L != 0) {
            this.V.setContentDescription(getContext().getResources().getText(this.L));
        }
        this.V.setOnClickListener(new a());
        Button button = (Button) viewInflate.findViewById(R$id.cancel_button);
        button.setTag(a0);
        CharSequence charSequence3 = this.O;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i2 = this.N;
            if (i2 != 0) {
                button.setText(i2);
            }
        }
        CharSequence charSequence4 = this.Q;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.P != 0) {
            button.setContentDescription(getContext().getResources().getText(this.P));
        }
        button.setOnClickListener(new b());
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.t.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.u);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.v);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.x);
        MaterialCalendar materialCalendar = this.z;
        Month monthI = materialCalendar == null ? null : materialCalendar.I();
        if (monthI != null) {
            bVar.b(monthI.f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.y);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.F);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.G);
        bundle.putInt("INPUT_MODE_KEY", this.I);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.J);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.K);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.L);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.M);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.N);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.O);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.P);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.Q);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = I().getWindow();
        if (this.H) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.U);
            T(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.U, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new y21(I(), rect));
        }
        h0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.w.w();
        super.onStop();
    }
}
