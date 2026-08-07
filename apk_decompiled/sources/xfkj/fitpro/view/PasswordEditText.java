package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.textfield.TextInputEditText;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.q30;
import org.objectweb.asm.Opcodes;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class PasswordEditText extends TextInputEditText {
    private int i;
    private int j;
    private int k;
    private Drawable l;
    private Drawable m;
    private Drawable n;
    private boolean o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f419q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() <= 0) {
                PasswordEditText.this.o = false;
                PasswordEditText.this.l();
                PasswordEditText.this.o(false);
                return;
            }
            if (PasswordEditText.this.r) {
                PasswordEditText.this.setCompoundDrawables(null, null, null, null);
                PasswordEditText.this.r = false;
                PasswordEditText.this.o(true);
            }
            if (PasswordEditText.this.f419q) {
                return;
            }
            PasswordEditText.this.o(true);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public PasswordEditText(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (this.o) {
            setTransformationMethod(null);
        } else {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        setSelection(selectionStart, selectionEnd);
    }

    private boolean n() {
        return getResources().getConfiguration().getLayoutDirection() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z) {
        if (!z) {
            setCompoundDrawables(this.w ? this.n : null, null, null, null);
            this.f419q = false;
        } else {
            Drawable drawable = this.o ? this.m : this.l;
            this.f419q = true;
            setCompoundDrawablesWithIntrinsicBounds(this.w ? this.n : null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    private void p() {
        this.o = !this.o;
        l();
        o(true);
    }

    public void m(AttributeSet attributeSet, int i) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R$styleable.PasswordEditText, i, 0);
            try {
                this.i = typedArrayObtainStyledAttributes.getResourceId(3, this.i);
                this.j = typedArrayObtainStyledAttributes.getResourceId(2, this.j);
                this.k = typedArrayObtainStyledAttributes.getResourceId(4, this.k);
                this.s = typedArrayObtainStyledAttributes.getBoolean(1, false);
                this.t = typedArrayObtainStyledAttributes.getBoolean(5, false);
                this.u = typedArrayObtainStyledAttributes.getBoolean(0, false);
                this.w = typedArrayObtainStyledAttributes.getBoolean(6, true);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.m = q30.e(getContext(), this.j).mutate();
        this.l = q30.e(getContext(), this.i).mutate();
        this.n = q30.e(getContext(), this.k).mutate();
        if (!this.u) {
            this.m.setAlpha(Opcodes.L2F);
            this.l.setAlpha(96);
        }
        if (this.t) {
            setTypeface(Typeface.DEFAULT);
        }
        this.p = n();
        addTextChangedListener(new a());
        o(true);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f419q = savedState.b();
        this.o = savedState.a();
        l();
        o(this.f419q);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f419q, this.o);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
    
        p();
        r6.setAction(3);
        r5.v = true;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.f419q
            if (r0 != 0) goto L9
            boolean r6 = super.onTouchEvent(r6)
            return r6
        L9:
            android.graphics.drawable.Drawable r0 = r5.l
            android.graphics.Rect r0 = r0.getBounds()
            float r1 = r6.getX()
            int r1 = (int) r1
            int r2 = r5.getRight()
            int r0 = r0.width()
            int r0 = r0 * 2
            int r2 = r2 - r0
            int r2 = r2 + (-50)
            int r0 = r5.getPaddingRight()
            int r2 = r2 - r0
            int r0 = r6.getAction()
            r3 = 3
            r4 = 1
            if (r0 == 0) goto L48
            if (r0 == r4) goto L31
            goto L5d
        L31:
            boolean r0 = r5.v
            if (r0 != 0) goto L3e
            boolean r0 = r5.p
            if (r0 == 0) goto L3c
            if (r1 > r2) goto L5d
            goto L3e
        L3c:
            if (r1 < r2) goto L5d
        L3e:
            r5.p()
            r6.setAction(r3)
            r0 = 0
            r5.v = r0
            goto L5d
        L48:
            boolean r0 = r5.s
            if (r0 == 0) goto L5d
            boolean r0 = r5.p
            if (r0 == 0) goto L53
            if (r1 > r2) goto L5d
            goto L55
        L53:
            if (r1 < r2) goto L5d
        L55:
            r5.p()
            r6.setAction(r3)
            r5.v = r4
        L5d:
            boolean r6 = super.onTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: xfkj.fitpro.view.PasswordEditText.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setError(CharSequence charSequence) {
        super.setError(charSequence);
        this.r = true;
    }

    protected static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private final boolean a;
        private final boolean b;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public boolean a() {
            return this.b;
        }

        public boolean b() {
            return this.a;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.a ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        }

        private SavedState(Parcelable parcelable, boolean z, boolean z2) {
            super(parcelable);
            this.a = z;
            this.b = z2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readByte() != 0;
            this.b = parcel.readByte() != 0;
        }
    }

    public PasswordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = R.drawable.ic_visibility_24dp;
        this.j = R.drawable.ic_visibility_off_24dp;
        this.k = R.mipmap.signin_pd;
        m(attributeSet, 0);
    }

    @Override // android.widget.TextView
    public void setError(CharSequence charSequence, Drawable drawable) {
        super.setError(charSequence, drawable);
        this.r = true;
    }

    public PasswordEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = R.drawable.ic_visibility_24dp;
        this.j = R.drawable.ic_visibility_off_24dp;
        this.k = R.mipmap.signin_pd;
        m(attributeSet, i);
    }
}
