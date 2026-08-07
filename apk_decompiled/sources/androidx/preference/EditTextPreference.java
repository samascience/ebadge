package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import defpackage.c73;

/* JADX INFO: loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    private String Y;

    public interface a {
    }

    public static final class b implements Preference.e {
        private static b a;

        private b() {
        }

        public static b b() {
            if (a == null) {
                a = new b();
            }
            return a;
        }

        @Override // androidx.preference.Preference.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(EditTextPreference editTextPreference) {
            return TextUtils.isEmpty(editTextPreference.z0()) ? editTextPreference.g().getString(R$string.not_set) : editTextPreference.z0();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EditTextPreference, i, i2);
        int i3 = R$styleable.EditTextPreference_useSimpleSummaryProvider;
        if (c73.b(typedArrayObtainStyledAttributes, i3, i3, false)) {
            k0(b.b());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void A0(String str) {
        boolean zN0 = n0();
        this.Y = str;
        W(str);
        boolean zN1 = n0();
        if (zN1 != zN0) {
            G(zN1);
        }
        F();
    }

    @Override // androidx.preference.Preference
    protected Object N(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    protected void Q(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.Q(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.Q(savedState.getSuperState());
        A0(savedState.a);
    }

    @Override // androidx.preference.Preference
    protected Parcelable R() {
        Parcelable parcelableR = super.R();
        if (C()) {
            return parcelableR;
        }
        SavedState savedState = new SavedState(parcelableR);
        savedState.a = z0();
        return savedState;
    }

    @Override // androidx.preference.Preference
    public boolean n0() {
        return TextUtils.isEmpty(this.Y) || super.n0();
    }

    a y0() {
        return null;
    }

    public String z0() {
        return this.Y;
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        String a;

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
            this.a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c73.a(context, R$attr.editTextPreferenceStyle, R.attr.editTextPreferenceStyle));
    }
}
