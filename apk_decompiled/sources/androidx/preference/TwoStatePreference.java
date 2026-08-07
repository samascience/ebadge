package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    protected boolean S;
    private CharSequence T;
    private CharSequence U;
    private boolean V;
    private boolean W;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.preference.Preference
    protected void K() {
        super.K();
        boolean z = !s0();
        if (a(Boolean.valueOf(z))) {
            t0(z);
        }
    }

    @Override // androidx.preference.Preference
    protected Object N(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    @Override // androidx.preference.Preference
    protected void Q(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.Q(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.Q(savedState.getSuperState());
        t0(savedState.a);
    }

    @Override // androidx.preference.Preference
    protected Parcelable R() {
        Parcelable parcelableR = super.R();
        if (C()) {
            return parcelableR;
        }
        SavedState savedState = new SavedState(parcelableR);
        savedState.a = s0();
        return savedState;
    }

    @Override // androidx.preference.Preference
    public boolean n0() {
        boolean z;
        if (this.W) {
            z = this.S;
        } else {
            z = !this.S;
        }
        return z || super.n0();
    }

    public boolean s0() {
        return this.S;
    }

    public void t0(boolean z) {
        boolean z2 = this.S != z;
        if (z2 || !this.V) {
            this.S = z;
            this.V = true;
            U(z);
            if (z2) {
                G(n0());
                F();
            }
        }
    }

    public void u0(boolean z) {
        this.W = z;
    }

    public void v0(CharSequence charSequence) {
        this.U = charSequence;
        if (s0()) {
            return;
        }
        F();
    }

    public void w0(CharSequence charSequence) {
        this.T = charSequence;
        if (s0()) {
            F();
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0030  */
    /* JADX WARN: Code duplicated, block: B:20:0x003a  */
    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:? A[RETURN, SYNTHETIC] */
    protected void x0(View view) {
        boolean z;
        int i;
        CharSequence charSequenceV;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (!this.S || TextUtils.isEmpty(this.T)) {
                if (this.S || TextUtils.isEmpty(this.U)) {
                    z = true;
                } else {
                    textView.setText(this.U);
                }
                if (z) {
                    charSequenceV = v();
                    if (!TextUtils.isEmpty(charSequenceV)) {
                        textView.setText(charSequenceV);
                        z = false;
                    }
                }
                i = z ? 8 : 0;
                if (i != textView.getVisibility()) {
                    textView.setVisibility(i);
                }
            }
            textView.setText(this.T);
            z = false;
            if (z) {
                charSequenceV = v();
                if (!TextUtils.isEmpty(charSequenceV)) {
                    textView.setText(charSequenceV);
                    z = false;
                }
            }
            if (z) {
            }
            if (i != textView.getVisibility()) {
                textView.setVisibility(i);
            }
        }
    }

    protected void y0(d dVar) {
        x0(dVar.a(R.id.summary));
    }

    static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean a;

        static class a implements Parcelable.Creator {
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

        SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt() == 1;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a ? 1 : 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
