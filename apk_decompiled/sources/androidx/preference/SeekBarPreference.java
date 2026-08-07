package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    int S;
    int T;
    private int U;
    private int V;
    boolean W;
    SeekBar X;
    private TextView Y;
    boolean Z;
    private boolean a0;
    boolean b0;
    private SeekBar.OnSeekBarChangeListener c0;
    private View.OnKeyListener d0;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.b0 || !seekBarPreference.W) {
                    seekBarPreference.v0(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.w0(i + seekBarPreference2.T);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.W = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.W = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.T != seekBarPreference.S) {
                seekBarPreference.v0(seekBar);
            }
        }
    }

    class b implements View.OnKeyListener {
        b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.Z && (i == 21 || i == 22)) || i == 23 || i == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.X;
            if (seekBar != null) {
                return seekBar.onKeyDown(i, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.c0 = new a();
        this.d0 = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SeekBarPreference, i, i2);
        this.T = typedArrayObtainStyledAttributes.getInt(R$styleable.SeekBarPreference_min, 0);
        s0(typedArrayObtainStyledAttributes.getInt(R$styleable.SeekBarPreference_android_max, 100));
        t0(typedArrayObtainStyledAttributes.getInt(R$styleable.SeekBarPreference_seekBarIncrement, 0));
        this.Z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SeekBarPreference_adjustable, true);
        this.a0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SeekBarPreference_showSeekBarValue, false);
        this.b0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SeekBarPreference_updatesContinuously, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void u0(int i, boolean z) {
        int i2 = this.T;
        if (i < i2) {
            i = i2;
        }
        int i3 = this.U;
        if (i > i3) {
            i = i3;
        }
        if (i != this.S) {
            this.S = i;
            w0(i);
            V(i);
            if (z) {
                F();
            }
        }
    }

    @Override // androidx.preference.Preference
    public void J(d dVar) {
        super.J(dVar);
        dVar.itemView.setOnKeyListener(this.d0);
        this.X = (SeekBar) dVar.a(R$id.seekbar);
        TextView textView = (TextView) dVar.a(R$id.seekbar_value);
        this.Y = textView;
        if (this.a0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.Y = null;
        }
        SeekBar seekBar = this.X;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.c0);
        this.X.setMax(this.U - this.T);
        int i = this.V;
        if (i != 0) {
            this.X.setKeyProgressIncrement(i);
        } else {
            this.V = this.X.getKeyProgressIncrement();
        }
        this.X.setProgress(this.S - this.T);
        w0(this.S);
        this.X.setEnabled(B());
    }

    @Override // androidx.preference.Preference
    protected Object N(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    @Override // androidx.preference.Preference
    protected void Q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.Q(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.Q(savedState.getSuperState());
        this.S = savedState.a;
        this.T = savedState.b;
        this.U = savedState.c;
        F();
    }

    @Override // androidx.preference.Preference
    protected Parcelable R() {
        Parcelable parcelableR = super.R();
        if (C()) {
            return parcelableR;
        }
        SavedState savedState = new SavedState(parcelableR);
        savedState.a = this.S;
        savedState.b = this.T;
        savedState.c = this.U;
        return savedState;
    }

    public final void s0(int i) {
        int i2 = this.T;
        if (i < i2) {
            i = i2;
        }
        if (i != this.U) {
            this.U = i;
            F();
        }
    }

    public final void t0(int i) {
        if (i != this.V) {
            this.V = Math.min(this.U - this.T, Math.abs(i));
            F();
        }
    }

    void v0(SeekBar seekBar) {
        int progress = this.T + seekBar.getProgress();
        if (progress != this.S) {
            if (a(Integer.valueOf(progress))) {
                u0(progress, false);
            } else {
                seekBar.setProgress(this.S - this.T);
                w0(this.S);
            }
        }
    }

    void w0(int i) {
        TextView textView = this.Y;
        if (textView != null) {
            textView.setText(String.valueOf(i));
        }
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int a;
        int b;
        int c;

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
            this.b = parcel.readInt();
            this.c = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.seekBarPreferenceStyle);
    }
}
