package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.material.R$dimen;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import defpackage.o23;
import defpackage.qd0;
import defpackage.sg1;
import defpackage.t13;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class BadgeState {
    private final State a;
    private final State b;
    final float c;
    final float d;
    final float e;
    final float f;
    final float g;
    final float h;
    final int i;
    final int j;
    int k;

    BadgeState(Context context, int i, int i2, int i3, State state) {
        State state2 = new State();
        this.b = state2;
        state = state == null ? new State() : state;
        if (i != 0) {
            state.a = i;
        }
        TypedArray typedArrayA = a(context, state.a, i2, i3);
        Resources resources = context.getResources();
        this.c = typedArrayA.getDimensionPixelSize(R$styleable.Badge_badgeRadius, -1);
        this.i = context.getResources().getDimensionPixelSize(R$dimen.mtrl_badge_horizontal_edge_offset);
        this.j = context.getResources().getDimensionPixelSize(R$dimen.mtrl_badge_text_horizontal_edge_offset);
        this.d = typedArrayA.getDimensionPixelSize(R$styleable.Badge_badgeWithTextRadius, -1);
        int i4 = R$styleable.Badge_badgeWidth;
        int i5 = R$dimen.m3_badge_size;
        this.e = typedArrayA.getDimension(i4, resources.getDimension(i5));
        int i6 = R$styleable.Badge_badgeWithTextWidth;
        int i7 = R$dimen.m3_badge_with_text_size;
        this.g = typedArrayA.getDimension(i6, resources.getDimension(i7));
        this.f = typedArrayA.getDimension(R$styleable.Badge_badgeHeight, resources.getDimension(i5));
        this.h = typedArrayA.getDimension(R$styleable.Badge_badgeWithTextHeight, resources.getDimension(i7));
        boolean z = true;
        this.k = typedArrayA.getInt(R$styleable.Badge_offsetAlignmentMode, 1);
        state2.i = state.i == -2 ? 255 : state.i;
        if (state.k != -2) {
            state2.k = state.k;
        } else {
            int i8 = R$styleable.Badge_number;
            if (typedArrayA.hasValue(i8)) {
                state2.k = typedArrayA.getInt(i8, 0);
            } else {
                state2.k = -1;
            }
        }
        if (state.j != null) {
            state2.j = state.j;
        } else {
            int i9 = R$styleable.Badge_badgeText;
            if (typedArrayA.hasValue(i9)) {
                state2.j = typedArrayA.getString(i9);
            }
        }
        state2.o = state.o;
        state2.p = state.p == null ? context.getString(R$string.mtrl_badge_numberless_content_description) : state.p;
        state2.f247q = state.f247q == 0 ? R$plurals.mtrl_badge_content_description : state.f247q;
        state2.r = state.r == 0 ? R$string.mtrl_exceed_max_badge_number_content_description : state.r;
        if (state.t != null && !state.t.booleanValue()) {
            z = false;
        }
        state2.t = Boolean.valueOf(z);
        state2.l = state.l == -2 ? typedArrayA.getInt(R$styleable.Badge_maxCharacterCount, -2) : state.l;
        state2.m = state.m == -2 ? typedArrayA.getInt(R$styleable.Badge_maxNumber, -2) : state.m;
        state2.e = Integer.valueOf(state.e == null ? typedArrayA.getResourceId(R$styleable.Badge_badgeShapeAppearance, R$style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : state.e.intValue());
        state2.f = Integer.valueOf(state.f == null ? typedArrayA.getResourceId(R$styleable.Badge_badgeShapeAppearanceOverlay, 0) : state.f.intValue());
        state2.g = Integer.valueOf(state.g == null ? typedArrayA.getResourceId(R$styleable.Badge_badgeWithTextShapeAppearance, R$style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : state.g.intValue());
        state2.h = Integer.valueOf(state.h == null ? typedArrayA.getResourceId(R$styleable.Badge_badgeWithTextShapeAppearanceOverlay, 0) : state.h.intValue());
        state2.b = Integer.valueOf(state.b == null ? H(context, typedArrayA, R$styleable.Badge_backgroundColor) : state.b.intValue());
        state2.d = Integer.valueOf(state.d == null ? typedArrayA.getResourceId(R$styleable.Badge_badgeTextAppearance, R$style.TextAppearance_MaterialComponents_Badge) : state.d.intValue());
        if (state.c != null) {
            state2.c = state.c;
        } else {
            int i10 = R$styleable.Badge_badgeTextColor;
            if (typedArrayA.hasValue(i10)) {
                state2.c = Integer.valueOf(H(context, typedArrayA, i10));
            } else {
                state2.c = Integer.valueOf(new t13(context, state2.d.intValue()).i().getDefaultColor());
            }
        }
        state2.s = Integer.valueOf(state.s == null ? typedArrayA.getInt(R$styleable.Badge_badgeGravity, 8388661) : state.s.intValue());
        state2.u = Integer.valueOf(state.u == null ? typedArrayA.getDimensionPixelSize(R$styleable.Badge_badgeWidePadding, resources.getDimensionPixelSize(R$dimen.mtrl_badge_long_text_horizontal_padding)) : state.u.intValue());
        state2.v = Integer.valueOf(state.v == null ? typedArrayA.getDimensionPixelSize(R$styleable.Badge_badgeVerticalPadding, resources.getDimensionPixelSize(R$dimen.m3_badge_with_text_vertical_padding)) : state.v.intValue());
        state2.w = Integer.valueOf(state.w == null ? typedArrayA.getDimensionPixelOffset(R$styleable.Badge_horizontalOffset, 0) : state.w.intValue());
        state2.x = Integer.valueOf(state.x == null ? typedArrayA.getDimensionPixelOffset(R$styleable.Badge_verticalOffset, 0) : state.x.intValue());
        state2.y = Integer.valueOf(state.y == null ? typedArrayA.getDimensionPixelOffset(R$styleable.Badge_horizontalOffsetWithText, state2.w.intValue()) : state.y.intValue());
        state2.z = Integer.valueOf(state.z == null ? typedArrayA.getDimensionPixelOffset(R$styleable.Badge_verticalOffsetWithText, state2.x.intValue()) : state.z.intValue());
        state2.H = Integer.valueOf(state.H == null ? typedArrayA.getDimensionPixelOffset(R$styleable.Badge_largeFontVerticalOffsetAdjustment, 0) : state.H.intValue());
        state2.F = Integer.valueOf(state.F == null ? 0 : state.F.intValue());
        state2.G = Integer.valueOf(state.G == null ? 0 : state.G.intValue());
        state2.I = Boolean.valueOf(state.I == null ? typedArrayA.getBoolean(R$styleable.Badge_autoAdjustToWithinGrandparentBounds, false) : state.I.booleanValue());
        typedArrayA.recycle();
        if (state.n == null) {
            state2.n = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            state2.n = state.n;
        }
        this.a = state;
    }

    private static int H(Context context, TypedArray typedArray, int i) {
        return sg1.a(context, typedArray, i).getDefaultColor();
    }

    private TypedArray a(Context context, int i, int i2, int i3) {
        AttributeSet attributeSet;
        int styleAttribute;
        if (i != 0) {
            AttributeSet attributeSetK = qd0.k(context, i, "badge");
            styleAttribute = attributeSetK.getStyleAttribute();
            attributeSet = attributeSetK;
        } else {
            attributeSet = null;
            styleAttribute = 0;
        }
        return o23.i(context, attributeSet, R$styleable.Badge, i2, styleAttribute == 0 ? i3 : styleAttribute, new int[0]);
    }

    int A() {
        return this.b.d.intValue();
    }

    int B() {
        return this.b.z.intValue();
    }

    int C() {
        return this.b.x.intValue();
    }

    boolean D() {
        return this.b.k != -1;
    }

    boolean E() {
        return this.b.j != null;
    }

    boolean F() {
        return this.b.I.booleanValue();
    }

    boolean G() {
        return this.b.t.booleanValue();
    }

    void I(int i) {
        this.a.i = i;
        this.b.i = i;
    }

    int b() {
        return this.b.F.intValue();
    }

    int c() {
        return this.b.G.intValue();
    }

    int d() {
        return this.b.i;
    }

    int e() {
        return this.b.b.intValue();
    }

    int f() {
        return this.b.s.intValue();
    }

    int g() {
        return this.b.u.intValue();
    }

    int h() {
        return this.b.f.intValue();
    }

    int i() {
        return this.b.e.intValue();
    }

    int j() {
        return this.b.c.intValue();
    }

    int k() {
        return this.b.v.intValue();
    }

    int l() {
        return this.b.h.intValue();
    }

    int m() {
        return this.b.g.intValue();
    }

    int n() {
        return this.b.r;
    }

    CharSequence o() {
        return this.b.o;
    }

    CharSequence p() {
        return this.b.p;
    }

    int q() {
        return this.b.f247q;
    }

    int r() {
        return this.b.y.intValue();
    }

    int s() {
        return this.b.w.intValue();
    }

    int t() {
        return this.b.H.intValue();
    }

    int u() {
        return this.b.l;
    }

    int v() {
        return this.b.m;
    }

    int w() {
        return this.b.k;
    }

    Locale x() {
        return this.b.n;
    }

    State y() {
        return this.a;
    }

    String z() {
        return this.b.j;
    }

    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new a();
        private Integer F;
        private Integer G;
        private Integer H;
        private Boolean I;
        private int a;
        private Integer b;
        private Integer c;
        private Integer d;
        private Integer e;
        private Integer f;
        private Integer g;
        private Integer h;
        private int i;
        private String j;
        private int k;
        private int l;
        private int m;
        private Locale n;
        private CharSequence o;
        private CharSequence p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f247q;
        private int r;
        private Integer s;
        private Boolean t;
        private Integer u;
        private Integer v;
        private Integer w;
        private Integer x;
        private Integer y;
        private Integer z;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public State createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public State[] newArray(int i) {
                return new State[i];
            }
        }

        public State() {
            this.i = 255;
            this.k = -2;
            this.l = -2;
            this.m = -2;
            this.t = Boolean.TRUE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeSerializable(this.b);
            parcel.writeSerializable(this.c);
            parcel.writeSerializable(this.d);
            parcel.writeSerializable(this.e);
            parcel.writeSerializable(this.f);
            parcel.writeSerializable(this.g);
            parcel.writeSerializable(this.h);
            parcel.writeInt(this.i);
            parcel.writeString(this.j);
            parcel.writeInt(this.k);
            parcel.writeInt(this.l);
            parcel.writeInt(this.m);
            CharSequence charSequence = this.o;
            parcel.writeString(charSequence != null ? charSequence.toString() : null);
            CharSequence charSequence2 = this.p;
            parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
            parcel.writeInt(this.f247q);
            parcel.writeSerializable(this.s);
            parcel.writeSerializable(this.u);
            parcel.writeSerializable(this.v);
            parcel.writeSerializable(this.w);
            parcel.writeSerializable(this.x);
            parcel.writeSerializable(this.y);
            parcel.writeSerializable(this.z);
            parcel.writeSerializable(this.H);
            parcel.writeSerializable(this.F);
            parcel.writeSerializable(this.G);
            parcel.writeSerializable(this.t);
            parcel.writeSerializable(this.n);
            parcel.writeSerializable(this.I);
        }

        State(Parcel parcel) {
            this.i = 255;
            this.k = -2;
            this.l = -2;
            this.m = -2;
            this.t = Boolean.TRUE;
            this.a = parcel.readInt();
            this.b = (Integer) parcel.readSerializable();
            this.c = (Integer) parcel.readSerializable();
            this.d = (Integer) parcel.readSerializable();
            this.e = (Integer) parcel.readSerializable();
            this.f = (Integer) parcel.readSerializable();
            this.g = (Integer) parcel.readSerializable();
            this.h = (Integer) parcel.readSerializable();
            this.i = parcel.readInt();
            this.j = parcel.readString();
            this.k = parcel.readInt();
            this.l = parcel.readInt();
            this.m = parcel.readInt();
            this.o = parcel.readString();
            this.p = parcel.readString();
            this.f247q = parcel.readInt();
            this.s = (Integer) parcel.readSerializable();
            this.u = (Integer) parcel.readSerializable();
            this.v = (Integer) parcel.readSerializable();
            this.w = (Integer) parcel.readSerializable();
            this.x = (Integer) parcel.readSerializable();
            this.y = (Integer) parcel.readSerializable();
            this.z = (Integer) parcel.readSerializable();
            this.H = (Integer) parcel.readSerializable();
            this.F = (Integer) parcel.readSerializable();
            this.G = (Integer) parcel.readSerializable();
            this.t = (Boolean) parcel.readSerializable();
            this.n = (Locale) parcel.readSerializable();
            this.I = (Boolean) parcel.readSerializable();
        }
    }
}
