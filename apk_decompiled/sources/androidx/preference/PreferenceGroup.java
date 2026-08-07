package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import defpackage.ap2;
import defpackage.c73;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    final ap2 S;
    private final Handler T;
    private List U;
    private boolean V;
    private int W;
    private boolean X;
    private int Y;
    private final Runnable Z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.S.clear();
            }
        }
    }

    public interface b {
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.S = new ap2();
        this.T = new Handler();
        this.V = true;
        this.W = 0;
        this.X = false;
        this.Y = Integer.MAX_VALUE;
        this.Z = new a();
        this.U = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PreferenceGroup, i, i2);
        int i3 = R$styleable.PreferenceGroup_orderingFromXml;
        this.V = c73.b(typedArrayObtainStyledAttributes, i3, i3, true);
        int i4 = R$styleable.PreferenceGroup_initialExpandedChildrenCount;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            y0(c73.d(typedArrayObtainStyledAttributes, i4, i4, Integer.MAX_VALUE));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void G(boolean z) {
        super.G(z);
        int iW0 = w0();
        for (int i = 0; i < iW0; i++) {
            v0(i).P(this, z);
        }
    }

    @Override // androidx.preference.Preference
    public void I() {
        super.I();
        this.X = true;
        int iW0 = w0();
        for (int i = 0; i < iW0; i++) {
            v0(i).I();
        }
    }

    @Override // androidx.preference.Preference
    public void M() {
        super.M();
        this.X = false;
        int iW0 = w0();
        for (int i = 0; i < iW0; i++) {
            v0(i).M();
        }
    }

    @Override // androidx.preference.Preference
    protected void Q(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.Q(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.Y = savedState.a;
        super.Q(savedState.getSuperState());
    }

    @Override // androidx.preference.Preference
    protected Parcelable R() {
        return new SavedState(super.R(), this.Y);
    }

    @Override // androidx.preference.Preference
    protected void d(Bundle bundle) {
        super.d(bundle);
        int iW0 = w0();
        for (int i = 0; i < iW0; i++) {
            v0(i).d(bundle);
        }
    }

    @Override // androidx.preference.Preference
    protected void e(Bundle bundle) {
        super.e(bundle);
        int iW0 = w0();
        for (int i = 0; i < iW0; i++) {
            v0(i).e(bundle);
        }
    }

    public Preference s0(CharSequence charSequence) {
        Preference preferenceS0;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (TextUtils.equals(m(), charSequence)) {
            return this;
        }
        int iW0 = w0();
        for (int i = 0; i < iW0; i++) {
            Preference preferenceV0 = v0(i);
            if (TextUtils.equals(preferenceV0.m(), charSequence)) {
                return preferenceV0;
            }
            if ((preferenceV0 instanceof PreferenceGroup) && (preferenceS0 = ((PreferenceGroup) preferenceV0).s0(charSequence)) != null) {
                return preferenceS0;
            }
        }
        return null;
    }

    public int t0() {
        return this.Y;
    }

    public b u0() {
        return null;
    }

    public Preference v0(int i) {
        return (Preference) this.U.get(i);
    }

    public int w0() {
        return this.U.size();
    }

    protected boolean x0() {
        return true;
    }

    public void y0(int i) {
        if (i != Integer.MAX_VALUE && !z()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.Y = i;
    }

    void z0() {
        synchronized (this) {
            Collections.sort(this.U);
        }
    }

    static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int a;

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
            this.a = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }

        SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.a = i;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
