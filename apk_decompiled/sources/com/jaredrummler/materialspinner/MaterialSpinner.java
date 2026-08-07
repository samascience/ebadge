package com.jaredrummler.materialspinner;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.connect.common.Constants;
import defpackage.wg1;
import defpackage.xg1;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialSpinner extends TextView {
    private xg1 a;
    private PopupWindow b;
    private ListView c;
    private Drawable d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f279q;
    private int r;
    private int s;
    private String t;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (i >= MaterialSpinner.this.i && i < MaterialSpinner.this.a.getCount() && MaterialSpinner.this.a.c().size() != 1 && TextUtils.isEmpty(MaterialSpinner.this.t)) {
                i++;
            }
            MaterialSpinner.this.i = i;
            MaterialSpinner.this.f = false;
            Object objA = MaterialSpinner.this.a.a(i);
            MaterialSpinner.this.a.f(i);
            MaterialSpinner materialSpinner = MaterialSpinner.this;
            materialSpinner.setTextColor(materialSpinner.n);
            MaterialSpinner.this.setText(objA.toString());
            MaterialSpinner.this.o();
            MaterialSpinner.h(MaterialSpinner.this);
        }
    }

    class b implements PopupWindow.OnDismissListener {
        b() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (MaterialSpinner.this.f) {
                MaterialSpinner.i(MaterialSpinner.this);
            }
            if (MaterialSpinner.this.e) {
                return;
            }
            MaterialSpinner.this.l(false);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialSpinner.this.p();
        }
    }

    public interface d {
    }

    public interface e {
    }

    public MaterialSpinner(Context context) {
        super(context);
        q(context, null);
    }

    private Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    static /* synthetic */ d h(MaterialSpinner materialSpinner) {
        materialSpinner.getClass();
        return null;
    }

    static /* synthetic */ e i(MaterialSpinner materialSpinner) {
        materialSpinner.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z) {
        ObjectAnimator.ofInt(this.d, "level", z ? 0 : 10000, z ? 10000 : 0).start();
    }

    private int m() {
        if (this.a == null) {
            return -2;
        }
        float dimension = getResources().getDimension(R$dimen.ms__item_height);
        float count = this.a.getCount() * dimension;
        int i = this.g;
        if (i > 0 && count > i) {
            return i;
        }
        int i2 = this.h;
        if (i2 != -1 && i2 != -2 && i2 <= count) {
            return i2;
        }
        if (count == 0.0f && this.a.c().size() == 1) {
            return (int) dimension;
        }
        return -2;
    }

    private boolean n() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return isLaidOut();
    }

    private void q(Context context, AttributeSet attributeSet) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialSpinner);
        int defaultColor = getTextColors().getDefaultColor();
        boolean zC = com.jaredrummler.materialspinner.b.c(context);
        Resources resources = getResources();
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R$dimen.ms__padding_top);
        if (zC) {
            dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.ms__padding_left);
            dimensionPixelSize = dimensionPixelSize3;
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.ms__padding_left);
            dimensionPixelSize2 = dimensionPixelSize3;
        }
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R$dimen.ms__popup_padding_left);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(R$dimen.ms__popup_padding_top);
        try {
            this.j = typedArrayObtainStyledAttributes.getColor(R$styleable.MaterialSpinner_ms_background_color, -1);
            this.k = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialSpinner_ms_background_selector, 0);
            this.n = typedArrayObtainStyledAttributes.getColor(R$styleable.MaterialSpinner_ms_text_color, defaultColor);
            this.o = typedArrayObtainStyledAttributes.getColor(R$styleable.MaterialSpinner_ms_hint_color, defaultColor);
            this.l = typedArrayObtainStyledAttributes.getColor(R$styleable.MaterialSpinner_ms_arrow_tint, this.n);
            this.e = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MaterialSpinner_ms_hide_arrow, false);
            int i = R$styleable.MaterialSpinner_ms_hint;
            this.t = typedArrayObtainStyledAttributes.getString(i) == null ? Constants.STR_EMPTY : typedArrayObtainStyledAttributes.getString(i);
            this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialSpinner_ms_dropdown_max_height, 0);
            this.h = typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.MaterialSpinner_ms_dropdown_height, -2);
            int dimensionPixelSize6 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialSpinner_ms_padding_top, dimensionPixelSize3);
            int dimensionPixelSize7 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialSpinner_ms_padding_left, dimensionPixelSize);
            int dimensionPixelSize8 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialSpinner_ms_padding_bottom, dimensionPixelSize3);
            int dimensionPixelSize9 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialSpinner_ms_padding_right, dimensionPixelSize2);
            this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialSpinner_ms_popup_padding_top, dimensionPixelSize5);
            this.f279q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialSpinner_ms_popup_padding_left, dimensionPixelSize4);
            this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialSpinner_ms_popup_padding_bottom, dimensionPixelSize5);
            this.s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialSpinner_ms_popup_padding_right, dimensionPixelSize4);
            this.m = com.jaredrummler.materialspinner.b.d(this.l, 0.8f);
            typedArrayObtainStyledAttributes.recycle();
            this.f = true;
            setGravity(8388627);
            setClickable(true);
            setPadding(dimensionPixelSize7, dimensionPixelSize6, dimensionPixelSize9, dimensionPixelSize8);
            setBackgroundResource(R$drawable.ms__selector);
            if (zC) {
                setLayoutDirection(1);
                setTextDirection(4);
            }
            if (!this.e) {
                Drawable drawableMutate = com.jaredrummler.materialspinner.b.b(context, R$drawable.ms__arrow).mutate();
                this.d = drawableMutate;
                drawableMutate.setColorFilter(this.l, PorterDuff.Mode.SRC_IN);
                Drawable[] compoundDrawables = getCompoundDrawables();
                if (zC) {
                    compoundDrawables[0] = this.d;
                } else {
                    compoundDrawables[2] = this.d;
                }
                setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
            }
            ListView listView = new ListView(context);
            this.c = listView;
            listView.setId(getId());
            this.c.setDivider(null);
            this.c.setItemsCanFocus(true);
            this.c.setOnItemClickListener(new a());
            PopupWindow popupWindow = new PopupWindow(context);
            this.b = popupWindow;
            popupWindow.setContentView(this.c);
            this.b.setOutsideTouchable(true);
            this.b.setFocusable(true);
            this.b.setElevation(16.0f);
            this.b.setBackgroundDrawable(com.jaredrummler.materialspinner.b.b(context, R$drawable.ms__drawable));
            int i2 = this.j;
            if (i2 != -1) {
                setBackgroundColor(i2);
            } else {
                int i3 = this.k;
                if (i3 != 0) {
                    setBackgroundResource(i3);
                }
            }
            int i4 = this.n;
            if (i4 != defaultColor) {
                setTextColor(i4);
            }
            this.b.setOnDismissListener(new b());
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void setAdapterInternal(xg1 xg1Var) {
        boolean z = this.c.getAdapter() != null;
        xg1Var.h(true ^ TextUtils.isEmpty(this.t));
        this.c.setAdapter((ListAdapter) xg1Var);
        if (this.i >= xg1Var.getCount()) {
            this.i = 0;
        }
        if (xg1Var.c().size() <= 0) {
            setText(Constants.STR_EMPTY);
        } else if (!this.f || TextUtils.isEmpty(this.t)) {
            setTextColor(this.n);
            setText(xg1Var.a(this.i).toString());
        } else {
            setText(this.t);
            setHintColor(this.o);
        }
        if (z) {
            this.b.setHeight(m());
        }
    }

    public <T> List<T> getItems() {
        xg1 xg1Var = this.a;
        if (xg1Var == null) {
            return null;
        }
        return xg1Var.c();
    }

    public ListView getListView() {
        return this.c;
    }

    public PopupWindow getPopupWindow() {
        return this.b;
    }

    public int getSelectedIndex() {
        return this.i;
    }

    public void o() {
        if (!this.e) {
            l(false);
        }
        this.b.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.b.setWidth(View.MeasureSpec.getSize(i));
        this.b.setHeight(m());
        if (this.a == null) {
            super.onMeasure(i, i2);
            return;
        }
        CharSequence text = getText();
        String string = text.toString();
        for (int i3 = 0; i3 < this.a.getCount(); i3++) {
            String strB = this.a.b(i3);
            if (strB.length() > string.length()) {
                string = strB;
            }
        }
        setText(string);
        super.onMeasure(i, i2);
        setText(text);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.i = bundle.getInt("selected_index");
            boolean z = bundle.getBoolean("nothing_selected");
            this.f = z;
            if (this.a != null) {
                if (!z || TextUtils.isEmpty(this.t)) {
                    setTextColor(this.n);
                    setText(this.a.a(this.i).toString());
                } else {
                    setHintColor(this.o);
                    setText(this.t);
                }
                this.a.f(this.i);
            }
            if (bundle.getBoolean("is_popup_showing") && this.b != null) {
                post(new c());
            }
            parcelable = bundle.getParcelable("state");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("state", super.onSaveInstanceState());
        bundle.putInt("selected_index", this.i);
        bundle.putBoolean("nothing_selected", this.f);
        PopupWindow popupWindow = this.b;
        if (popupWindow != null) {
            bundle.putBoolean("is_popup_showing", popupWindow.isShowing());
            o();
        } else {
            bundle.putBoolean("is_popup_showing", false);
        }
        return bundle;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && isEnabled() && isClickable()) {
            if (this.b.isShowing()) {
                o();
            } else {
                p();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p() {
        if (n()) {
            if (!this.e) {
                l(true);
            }
            this.f = true;
            this.b.showAsDropDown(this);
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        xg1 xg1VarJ = new com.jaredrummler.materialspinner.a(getContext(), listAdapter).i(this.f279q, this.p, this.s, this.r).g(this.k).j(this.n);
        this.a = xg1VarJ;
        setAdapterInternal(xg1VarJ);
    }

    public void setArrowColor(int i) {
        this.l = i;
        this.m = com.jaredrummler.materialspinner.b.d(i, 0.8f);
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setColorFilter(this.l, PorterDuff.Mode.SRC_IN);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.j = i;
        Drawable background = getBackground();
        if (background instanceof StateListDrawable) {
            try {
                Method declaredMethod = StateListDrawable.class.getDeclaredMethod("getStateDrawable", Integer.TYPE);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                int[] iArr = {com.jaredrummler.materialspinner.b.a(i, 0.85f), i};
                for (int i2 = 0; i2 < 2; i2++) {
                    ((ColorDrawable) declaredMethod.invoke(background, Integer.valueOf(i2))).setColor(iArr[i2]);
                }
            } catch (Exception e2) {
                Log.e("MaterialSpinner", "Error setting background color", e2);
            }
        } else if (background != null) {
            background.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
        this.b.getBackground().setColorFilter(i, PorterDuff.Mode.SRC_IN);
    }

    public void setDropdownHeight(int i) {
        this.h = i;
        this.b.setHeight(m());
    }

    public void setDropdownMaxHeight(int i) {
        this.g = i;
        this.b.setHeight(m());
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setColorFilter(z ? this.l : this.m, PorterDuff.Mode.SRC_IN);
        }
    }

    public void setHintColor(int i) {
        this.o = i;
        super.setTextColor(i);
    }

    public <T> void setItems(T... tArr) {
        setItems(Arrays.asList(tArr));
    }

    public void setOnItemSelectedListener(d dVar) {
    }

    public void setOnNothingSelectedListener(e eVar) {
    }

    public void setSelectedIndex(int i) {
        xg1 xg1Var = this.a;
        if (xg1Var != null) {
            if (i < 0 || i > xg1Var.getCount()) {
                throw new IllegalArgumentException("Position must be lower than adapter count!");
            }
            this.a.f(i);
            this.i = i;
            setText(this.a.a(i).toString());
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        this.n = i;
        xg1 xg1Var = this.a;
        if (xg1Var != null) {
            xg1Var.j(i);
            this.a.notifyDataSetChanged();
        }
        super.setTextColor(i);
    }

    public <T> void setItems(List<T> list) {
        xg1 xg1VarJ = new wg1(getContext(), list).i(this.f279q, this.p, this.s, this.r).g(this.k).j(this.n);
        this.a = xg1VarJ;
        setAdapterInternal(xg1VarJ);
    }

    public MaterialSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q(context, attributeSet);
    }

    public MaterialSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        q(context, attributeSet);
    }

    public <T> void setAdapter(wg1 wg1Var) {
        this.a = wg1Var;
        wg1Var.j(this.n);
        this.a.g(this.k);
        this.a.i(this.f279q, this.p, this.s, this.r);
        setAdapterInternal(wg1Var);
    }
}
