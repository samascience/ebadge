package androidx.preference;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import defpackage.db1;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceDialogFragmentCompat extends DialogFragment implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private DialogPreference f198q;
    private CharSequence r;
    private CharSequence s;
    private CharSequence t;
    private CharSequence u;
    private int v;
    private BitmapDrawable w;
    private int x;

    private void T(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog E(Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.x = -2;
        androidx.appcompat.app.b.a aVarL = new androidx.appcompat.app.b.a(activity).t(this.r).g(this.w).p(this.s, this).l(this.t, this);
        View viewQ = Q(activity);
        if (viewQ != null) {
            P(viewQ);
            aVarL.u(viewQ);
        } else {
            aVarL.i(this.u);
        }
        S(aVarL);
        androidx.appcompat.app.b bVarA = aVarL.a();
        if (O()) {
            T(bVarA);
        }
        return bVarA;
    }

    public DialogPreference N() {
        if (this.f198q == null) {
            this.f198q = (DialogPreference) ((DialogPreference.a) getTargetFragment()).d(getArguments().getString("key"));
        }
        return this.f198q;
    }

    protected boolean O() {
        return false;
    }

    protected void P(View view) {
        int i;
        View viewFindViewById = view.findViewById(R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.u;
            if (TextUtils.isEmpty(charSequence)) {
                i = 8;
            } else {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i = 0;
            }
            if (viewFindViewById.getVisibility() != i) {
                viewFindViewById.setVisibility(i);
            }
        }
    }

    protected View Q(Context context) {
        int i = this.v;
        if (i == 0) {
            return null;
        }
        return getLayoutInflater().inflate(i, (ViewGroup) null);
    }

    public abstract void R(boolean z);

    protected void S(androidx.appcompat.app.b.a aVar) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.x = i;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        db1 targetFragment = getTargetFragment();
        if (!(targetFragment instanceof DialogPreference.a)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.a aVar = (DialogPreference.a) targetFragment;
        String string = getArguments().getString("key");
        if (bundle != null) {
            this.r = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.s = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.t = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.u = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.v = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.w = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) aVar.d(string);
        this.f198q = dialogPreference;
        this.r = dialogPreference.v0();
        this.s = this.f198q.x0();
        this.t = this.f198q.w0();
        this.u = this.f198q.u0();
        this.v = this.f198q.t0();
        Drawable drawableS0 = this.f198q.s0();
        if (drawableS0 == null || (drawableS0 instanceof BitmapDrawable)) {
            this.w = (BitmapDrawable) drawableS0;
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableS0.getIntrinsicWidth(), drawableS0.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableS0.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableS0.draw(canvas);
        this.w = new BitmapDrawable(getResources(), bitmapCreateBitmap);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        R(this.x == -1);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.r);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.s);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.t);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.u);
        bundle.putInt("PreferenceDialogFragment.layout", this.v);
        BitmapDrawable bitmapDrawable = this.w;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }
}
