package com.google.android.material.timepicker;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import defpackage.be3;
import defpackage.t1;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
class TimePickerView extends ConstraintLayout {
    private final ClockHandView F;
    private final ClockFaceView G;
    private final MaterialButtonToggleGroup H;
    private final View.OnClickListener I;
    private e J;
    private f K;
    private d L;
    private final Chip y;
    private final Chip z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TimePickerView.this.K != null) {
                TimePickerView.this.K.f(((Integer) view.getTag(R$id.selection_type)).intValue());
            }
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            d dVar = TimePickerView.this.L;
            if (dVar == null) {
                return false;
            }
            dVar.h();
            return true;
        }
    }

    class c implements View.OnTouchListener {
        final /* synthetic */ GestureDetector a;

        c(GestureDetector gestureDetector) {
            this.a = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    interface d {
        void h();
    }

    interface e {
        void e(int i);
    }

    interface f {
        void f(int i);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
        e eVar;
        if (z && (eVar = this.J) != null) {
            eVar.e(i == R$id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    private void R() {
        Chip chip = this.y;
        int i = R$id.selection_type;
        chip.setTag(i, 12);
        this.z.setTag(i, 10);
        this.y.setOnClickListener(this.I);
        this.z.setOnClickListener(this.I);
        this.y.setAccessibilityClassName("android.view.View");
        this.z.setAccessibilityClassName("android.view.View");
    }

    private void T() {
        c cVar = new c(new GestureDetector(getContext(), new b()));
        this.y.setOnTouchListener(cVar);
        this.z.setOnTouchListener(cVar);
    }

    private void V(Chip chip, boolean z) {
        chip.setChecked(z);
        be3.r0(chip, z ? 2 : 0);
    }

    public void E(ClockHandView.c cVar) {
        this.F.b(cVar);
    }

    int F() {
        return this.G.O();
    }

    public void H(int i) {
        V(this.y, i == 12);
        V(this.z, i == 10);
    }

    public void I(boolean z) {
        this.F.n(z);
    }

    void J(int i) {
        this.G.S(i);
    }

    public void K(float f2, boolean z) {
        this.F.r(f2, z);
    }

    public void L(t1 t1Var) {
        be3.p0(this.y, t1Var);
    }

    public void M(t1 t1Var) {
        be3.p0(this.z, t1Var);
    }

    public void N(ClockHandView.b bVar) {
        this.F.u(bVar);
    }

    void O(d dVar) {
        this.L = dVar;
    }

    void P(e eVar) {
        this.J = eVar;
    }

    void Q(f fVar) {
        this.K = fVar;
    }

    public void S(String[] strArr, int i) {
        this.G.T(strArr, i);
    }

    public void U() {
        this.H.setVisibility(0);
    }

    public void W(int i, int i2, int i3) {
        this.H.e(i == 1 ? R$id.material_clock_period_pm_button : R$id.material_clock_period_am_button);
        Locale locale = getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(i3));
        String str2 = String.format(locale, "%02d", Integer.valueOf(i2));
        if (!TextUtils.equals(this.y.getText(), str)) {
            this.y.setText(str);
        }
        if (TextUtils.equals(this.z.getText(), str2)) {
            return;
        }
        this.z.setText(str2);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            this.z.sendAccessibilityEvent(8);
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.I = new a();
        LayoutInflater.from(context).inflate(R$layout.material_timepicker, this);
        this.G = (ClockFaceView) findViewById(R$id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.H = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new MaterialButtonToggleGroup.d() { // from class: com.google.android.material.timepicker.k
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.d
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i2, boolean z) {
                this.a.G(materialButtonToggleGroup2, i2, z);
            }
        });
        this.y = (Chip) findViewById(R$id.material_minute_tv);
        this.z = (Chip) findViewById(R$id.material_hour_tv);
        this.F = (ClockHandView) findViewById(R$id.material_clock_hand);
        T();
        R();
    }
}
