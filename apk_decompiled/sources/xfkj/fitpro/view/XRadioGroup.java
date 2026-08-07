package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;

/* JADX INFO: loaded from: classes4.dex */
public class XRadioGroup extends LinearLayout {
    private int a;
    private CompoundButton.OnCheckedChangeListener b;
    private boolean c;
    private d d;

    private class a implements CompoundButton.OnCheckedChangeListener {
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (XRadioGroup.this.c) {
                return;
            }
            XRadioGroup.this.c = true;
            if (XRadioGroup.this.a != -1) {
                XRadioGroup xRadioGroup = XRadioGroup.this;
                xRadioGroup.k(xRadioGroup.a, false);
            }
            XRadioGroup.this.c = false;
            XRadioGroup.this.setCheckedId(compoundButton.getId());
        }

        private a() {
        }
    }

    public static class b extends LinearLayout.LayoutParams {
        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            if (typedArray.hasValue(i)) {
                ((LinearLayout.LayoutParams) this).width = typedArray.getLayoutDimension(i, "layout_width");
            } else {
                ((LinearLayout.LayoutParams) this).width = -2;
            }
            if (typedArray.hasValue(i2)) {
                ((LinearLayout.LayoutParams) this).height = typedArray.getLayoutDimension(i2, "layout_height");
            } else {
                ((LinearLayout.LayoutParams) this).height = -2;
            }
        }

        public b(int i, int i2) {
            super(i, i2);
        }
    }

    public interface c {
    }

    private class d implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener a;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            XRadioGroup.this.setListener(view2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            XRadioGroup.this.j(view2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }

        private d() {
        }
    }

    public XRadioGroup(Context context) {
        super(context);
        this.a = -1;
        this.c = false;
        i();
    }

    private void i() {
        this.b = new a();
        d dVar = new d();
        this.d = dVar;
        super.setOnHierarchyChangeListener(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view) {
        if (view instanceof RadioButton) {
            ((RadioButton) view).setOnCheckedChangeListener(null);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                j(viewGroup.getChildAt(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, boolean z) {
        View viewFindViewById = findViewById(i);
        if (viewFindViewById == null || !(viewFindViewById instanceof RadioButton)) {
            return;
        }
        ((RadioButton) viewFindViewById).setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i) {
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListener(View view) {
        if (view instanceof RadioButton) {
            if (view.getId() == -1) {
                view.setId(view.hashCode());
            }
            ((RadioButton) view).setOnCheckedChangeListener(this.b);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                setListener(viewGroup.getChildAt(i));
            }
        }
    }

    private void setViewState(View view) {
        if (!(view instanceof RadioButton)) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    setViewState(viewGroup.getChildAt(i));
                }
                return;
            }
            return;
        }
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            this.c = true;
            int i2 = this.a;
            if (i2 != -1) {
                k(i2, false);
            }
            this.c = false;
            setCheckedId(radioButton.getId());
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        setViewState(view);
        super.addView(view, i, layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return XRadioGroup.class.getName();
    }

    public int getCheckedRadioButtonId() {
        return this.a;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.a;
        if (i != -1) {
            this.c = true;
            k(i, true);
            this.c = false;
            setCheckedId(this.a);
        }
    }

    public void setOnCheckedChangeListener(c cVar) {
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.d.a = onHierarchyChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    public XRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.c = false;
        i();
    }

    public XRadioGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -1;
        this.c = false;
        i();
    }
}
