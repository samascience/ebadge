package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import defpackage.be3;
import defpackage.gg1;
import defpackage.tg1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialTimePicker extends DialogFragment implements TimePickerView.d {
    private int F;
    private CharSequence H;
    private CharSequence J;
    private CharSequence L;
    private MaterialButton M;
    private Button N;
    private TimeModel P;
    private TimePickerView u;
    private ViewStub v;
    private f w;
    private j x;
    private g y;
    private int z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Set f276q = new LinkedHashSet();
    private final Set r = new LinkedHashSet();
    private final Set s = new LinkedHashSet();
    private final Set t = new LinkedHashSet();
    private int G = 0;
    private int I = 0;
    private int K = 0;
    private int O = 0;
    private int Q = 0;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialTimePicker.this.f276q.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            MaterialTimePicker.this.y();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialTimePicker.this.r.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            MaterialTimePicker.this.y();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.O = materialTimePicker.O == 0 ? 1 : 0;
            MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
            materialTimePicker2.a0(materialTimePicker2.M);
        }
    }

    private Pair U(int i) {
        if (i == 0) {
            return new Pair(Integer.valueOf(this.z), Integer.valueOf(R$string.material_timepicker_text_input_mode_description));
        }
        if (i == 1) {
            return new Pair(Integer.valueOf(this.F), Integer.valueOf(R$string.material_timepicker_clock_mode_description));
        }
        throw new IllegalArgumentException("no icon for mode: " + i);
    }

    private int V() {
        int i = this.Q;
        if (i != 0) {
            return i;
        }
        TypedValue typedValueA = gg1.a(requireContext(), R$attr.materialTimePickerTheme);
        if (typedValueA == null) {
            return 0;
        }
        return typedValueA.data;
    }

    private g W(int i, TimePickerView timePickerView, ViewStub viewStub) {
        if (i != 0) {
            if (this.x == null) {
                this.x = new j((LinearLayout) viewStub.inflate(), this.P);
            }
            this.x.h();
            return this.x;
        }
        f fVar = this.w;
        if (fVar == null) {
            fVar = new f(timePickerView, this.P);
        }
        this.w = fVar;
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X() {
        g gVar = this.y;
        if (gVar instanceof j) {
            ((j) gVar).l();
        }
    }

    private void Y(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        TimeModel timeModel = (TimeModel) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
        this.P = timeModel;
        if (timeModel == null) {
            this.P = new TimeModel();
        }
        this.O = bundle.getInt("TIME_PICKER_INPUT_MODE", this.P.c != 1 ? 0 : 1);
        this.G = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
        this.H = bundle.getCharSequence("TIME_PICKER_TITLE_TEXT");
        this.I = bundle.getInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", 0);
        this.J = bundle.getCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT");
        this.K = bundle.getInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", 0);
        this.L = bundle.getCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT");
        this.Q = bundle.getInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", 0);
    }

    private void Z() {
        Button button = this.N;
        if (button != null) {
            button.setVisibility(D() ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(MaterialButton materialButton) {
        if (materialButton == null || this.u == null || this.v == null) {
            return;
        }
        g gVar = this.y;
        if (gVar != null) {
            gVar.g();
        }
        g gVarW = W(this.O, this.u, this.v);
        this.y = gVarW;
        gVarW.b();
        this.y.c();
        Pair pairU = U(this.O);
        materialButton.setIconResource(((Integer) pairU.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) pairU.second).intValue()));
        materialButton.sendAccessibilityEvent(4);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog E(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), V());
        Context context = dialog.getContext();
        int i = R$attr.materialTimePickerStyle;
        int i2 = R$style.Widget_MaterialComponents_TimePicker;
        tg1 tg1Var = new tg1(context, null, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.MaterialTimePicker, i, i2);
        this.F = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialTimePicker_clockIcon, 0);
        this.z = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialTimePicker_keyboardIcon, 0);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.MaterialTimePicker_backgroundTint, 0);
        typedArrayObtainStyledAttributes.recycle();
        tg1Var.Q(context);
        tg1Var.b0(ColorStateList.valueOf(color));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(tg1Var);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        tg1Var.a0(be3.v(window.getDecorView()));
        return dialog;
    }

    @Override // com.google.android.material.timepicker.TimePickerView.d
    public void h() {
        this.O = 1;
        a0(this.M);
        this.x.l();
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
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        Y(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R$layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R$id.material_timepicker_view);
        this.u = timePickerView;
        timePickerView.O(this);
        this.v = (ViewStub) viewGroup2.findViewById(R$id.material_textinput_timepicker);
        this.M = (MaterialButton) viewGroup2.findViewById(R$id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R$id.header_title);
        int i = this.G;
        if (i != 0) {
            textView.setText(i);
        } else if (!TextUtils.isEmpty(this.H)) {
            textView.setText(this.H);
        }
        a0(this.M);
        Button button = (Button) viewGroup2.findViewById(R$id.material_timepicker_ok_button);
        button.setOnClickListener(new a());
        int i2 = this.I;
        if (i2 != 0) {
            button.setText(i2);
        } else if (!TextUtils.isEmpty(this.J)) {
            button.setText(this.J);
        }
        Button button2 = (Button) viewGroup2.findViewById(R$id.material_timepicker_cancel_button);
        this.N = button2;
        button2.setOnClickListener(new b());
        int i3 = this.K;
        if (i3 != 0) {
            this.N.setText(i3);
        } else if (!TextUtils.isEmpty(this.L)) {
            this.N.setText(this.L);
        }
        Z();
        this.M.setOnClickListener(new c());
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.y = null;
        this.w = null;
        this.x = null;
        TimePickerView timePickerView = this.u;
        if (timePickerView != null) {
            timePickerView.O(null);
            this.u = null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.t.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.P);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.O);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.G);
        bundle.putCharSequence("TIME_PICKER_TITLE_TEXT", this.H);
        bundle.putInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", this.I);
        bundle.putCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT", this.J);
        bundle.putInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", this.K);
        bundle.putCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT", this.L);
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", this.Q);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.y instanceof j) {
            view.postDelayed(new Runnable() { // from class: zg1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.X();
                }
            }, 100L);
        }
    }
}
