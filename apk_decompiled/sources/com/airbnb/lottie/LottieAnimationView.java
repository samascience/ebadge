package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.cp2;
import defpackage.d91;
import defpackage.e43;
import defpackage.fe1;
import defpackage.he1;
import defpackage.io0;
import defpackage.je1;
import defpackage.kz0;
import defpackage.me1;
import defpackage.ne1;
import defpackage.o91;
import defpackage.pe1;
import defpackage.re1;
import defpackage.vz1;
import defpackage.x13;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final String o = "LottieAnimationView";
    private final me1 d;
    private final me1 e;
    private final je1 f;
    private String g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private Set l;
    private pe1 m;
    private fe1 n;

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        String a;
        int b;
        float c;
        boolean d;
        String e;
        int f;
        int g;

        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.d ? 1 : 0);
            parcel.writeString(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
            this.c = parcel.readFloat();
            this.d = parcel.readInt() == 1;
            this.e = parcel.readString();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }
    }

    class a implements me1 {
        a() {
        }

        @Override // defpackage.me1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(fe1 fe1Var) {
            LottieAnimationView.this.setComposition(fe1Var);
        }
    }

    class b implements me1 {
        b() {
        }

        @Override // defpackage.me1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            throw new IllegalStateException("Unable to parse composition", th);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.d = new a();
        this.e = new b();
        this.f = new je1();
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = new HashSet();
        i(null);
    }

    private void e() {
        pe1 pe1Var = this.m;
        if (pe1Var != null) {
            pe1Var.m(this.d);
            this.m.l(this.e);
        }
    }

    private void f() {
        this.n = null;
        this.f.f();
    }

    private void h() {
        setLayerType((this.k && this.f.B()) ? 2 : 1, null);
    }

    private void i(AttributeSet attributeSet) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.LottieAnimationView);
        if (!isInEditMode()) {
            int i = R$styleable.LottieAnimationView_lottie_rawRes;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i);
            int i2 = R$styleable.LottieAnimationView_lottie_fileName;
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(i2);
            int i3 = R$styleable.LottieAnimationView_lottie_url;
            boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(i3);
            if (zHasValue && zHasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (zHasValue) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(i, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (zHasValue2) {
                String string2 = typedArrayObtainStyledAttributes.getString(i2);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(i3)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.i = true;
            this.j = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_loop, false)) {
            this.f.Q(-1);
        }
        int i4 = R$styleable.LottieAnimationView_lottie_repeatMode;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(i4, 1));
        }
        int i5 = R$styleable.LottieAnimationView_lottie_repeatCount;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(i5, -1));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(R$styleable.LottieAnimationView_lottie_progress, 0.0f));
        g(typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        int i6 = R$styleable.LottieAnimationView_lottie_colorFilter;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            c(new d91("**"), ne1.x, new re1(new cp2(typedArrayObtainStyledAttributes.getColor(i6, 0))));
        }
        int i7 = R$styleable.LottieAnimationView_lottie_scale;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            this.f.S(typedArrayObtainStyledAttributes.getFloat(i7, 1.0f));
        }
        typedArrayObtainStyledAttributes.recycle();
        h();
    }

    private void o(Drawable drawable, boolean z) {
        if (z && drawable != this.f) {
            l();
        }
        e();
        super.setImageDrawable(drawable);
    }

    private void setCompositionTask(pe1 pe1Var) {
        f();
        e();
        this.m = pe1Var.h(this.d).g(this.e);
    }

    public void c(d91 d91Var, Object obj, re1 re1Var) {
        this.f.c(d91Var, obj, re1Var);
    }

    public void d() {
        this.f.e();
        h();
    }

    public void g(boolean z) {
        this.f.g(z);
    }

    public fe1 getComposition() {
        return this.n;
    }

    public long getDuration() {
        fe1 fe1Var = this.n;
        if (fe1Var != null) {
            return (long) fe1Var.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f.m();
    }

    public String getImageAssetsFolder() {
        return this.f.p();
    }

    public float getMaxFrame() {
        return this.f.q();
    }

    public float getMinFrame() {
        return this.f.s();
    }

    public vz1 getPerformanceTracker() {
        return this.f.t();
    }

    public float getProgress() {
        return this.f.u();
    }

    public int getRepeatCount() {
        return this.f.v();
    }

    public int getRepeatMode() {
        return this.f.w();
    }

    public float getScale() {
        return this.f.x();
    }

    public float getSpeed() {
        return this.f.y();
    }

    public boolean getUseHardwareAcceleration() {
        return this.k;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        je1 je1Var = this.f;
        if (drawable2 == je1Var) {
            super.invalidateDrawable(je1Var);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean j() {
        return this.f.B();
    }

    public void k() {
        this.f.C();
        h();
    }

    void l() {
        this.f.D();
    }

    public void m(JsonReader jsonReader, String str) {
        setCompositionTask(he1.h(jsonReader, str));
    }

    public void n(String str, String str2) {
        m(new JsonReader(new StringReader(str)), str2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.j && this.i) {
            k();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (j()) {
            d();
            this.i = true;
        }
        l();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.a;
        this.g = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.g);
        }
        int i = savedState.b;
        this.h = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.c);
        if (savedState.d) {
            k();
        }
        this.f.J(savedState.e);
        setRepeatMode(savedState.f);
        setRepeatCount(savedState.g);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.g;
        savedState.b = this.h;
        savedState.c = this.f.u();
        savedState.d = this.f.B();
        savedState.e = this.f.p();
        savedState.f = this.f.w();
        savedState.g = this.f.v();
        return savedState;
    }

    public void setAnimation(int i) {
        this.h = i;
        this.g = null;
        setCompositionTask(he1.l(getContext(), i));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        n(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(he1.n(getContext(), str));
    }

    public void setComposition(fe1 fe1Var) {
        if (o91.a) {
            Log.v(o, "Set Composition \n" + fe1Var);
        }
        this.f.setCallback(this);
        this.n = fe1Var;
        boolean zF = this.f.F(fe1Var);
        h();
        if (getDrawable() != this.f || zF) {
            setImageDrawable(null);
            setImageDrawable(this.f);
            requestLayout();
            Iterator it = this.l.iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
    }

    public void setFontAssetDelegate(io0 io0Var) {
        this.f.G(io0Var);
    }

    public void setFrame(int i) {
        this.f.H(i);
    }

    public void setImageAssetDelegate(kz0 kz0Var) {
        this.f.I(kz0Var);
    }

    public void setImageAssetsFolder(String str) {
        this.f.J(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        l();
        e();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        o(drawable, true);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        l();
        e();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.f.K(i);
    }

    public void setMaxProgress(float f) {
        this.f.L(f);
    }

    public void setMinFrame(int i) {
        this.f.M(i);
    }

    public void setMinProgress(float f) {
        this.f.N(f);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f.O(z);
    }

    public void setProgress(float f) {
        this.f.P(f);
    }

    public void setRepeatCount(int i) {
        this.f.Q(i);
    }

    public void setRepeatMode(int i) {
        this.f.R(i);
    }

    public void setScale(float f) {
        this.f.S(f);
        if (getDrawable() == this.f) {
            o(null, false);
            o(this.f, false);
        }
    }

    public void setSpeed(float f) {
        this.f.T(f);
    }

    public void setTextDelegate(x13 x13Var) {
        this.f.U(x13Var);
    }

    public void setAnimation(String str) {
        this.g = str;
        this.h = 0;
        setCompositionTask(he1.d(getContext(), str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new a();
        this.e = new b();
        this.f = new je1();
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = new HashSet();
        i(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new a();
        this.e = new b();
        this.f = new je1();
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = new HashSet();
        i(attributeSet);
    }
}
