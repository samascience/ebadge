package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.connect.common.Constants;
import defpackage.c73;

/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    private CharSequence[] Y;
    private CharSequence[] Z;
    private String a0;
    private String b0;
    private boolean c0;

    public static final class a implements Preference.e {
        private static a a;

        private a() {
        }

        public static a b() {
            if (a == null) {
                a = new a();
            }
            return a;
        }

        @Override // androidx.preference.Preference.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.A0()) ? listPreference.g().getString(R$string.not_set) : listPreference.A0();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPreference, i, i2);
        this.Y = c73.o(typedArrayObtainStyledAttributes, R$styleable.ListPreference_entries, R$styleable.ListPreference_android_entries);
        this.Z = c73.o(typedArrayObtainStyledAttributes, R$styleable.ListPreference_entryValues, R$styleable.ListPreference_android_entryValues);
        int i3 = R$styleable.ListPreference_useSimpleSummaryProvider;
        if (c73.b(typedArrayObtainStyledAttributes, i3, i3, false)) {
            k0(a.b());
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.Preference, i, i2);
        this.b0 = c73.m(typedArrayObtainStyledAttributes2, R$styleable.Preference_summary, R$styleable.Preference_android_summary);
        typedArrayObtainStyledAttributes2.recycle();
    }

    private int D0() {
        return y0(this.a0);
    }

    public CharSequence A0() {
        CharSequence[] charSequenceArr;
        int iD0 = D0();
        if (iD0 < 0 || (charSequenceArr = this.Y) == null) {
            return null;
        }
        return charSequenceArr[iD0];
    }

    public CharSequence[] B0() {
        return this.Z;
    }

    public String C0() {
        return this.a0;
    }

    public void E0(String str) {
        boolean zEquals = TextUtils.equals(this.a0, str);
        if (zEquals && this.c0) {
            return;
        }
        this.a0 = str;
        this.c0 = true;
        W(str);
        if (zEquals) {
            return;
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
        E0(savedState.a);
    }

    @Override // androidx.preference.Preference
    protected Parcelable R() {
        Parcelable parcelableR = super.R();
        if (C()) {
            return parcelableR;
        }
        SavedState savedState = new SavedState(parcelableR);
        savedState.a = C0();
        return savedState;
    }

    @Override // androidx.preference.Preference
    public CharSequence v() {
        if (w() != null) {
            return w().a(this);
        }
        CharSequence charSequenceA0 = A0();
        CharSequence charSequenceV = super.v();
        String str = this.b0;
        if (str == null) {
            return charSequenceV;
        }
        if (charSequenceA0 == null) {
            charSequenceA0 = Constants.STR_EMPTY;
        }
        String str2 = String.format(str, charSequenceA0);
        if (TextUtils.equals(str2, charSequenceV)) {
            return charSequenceV;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return str2;
    }

    public int y0(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.Z) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.Z[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] z0() {
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

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c73.a(context, R$attr.dialogPreferenceStyle, R.attr.dialogPreferenceStyle));
    }
}
