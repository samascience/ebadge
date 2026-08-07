package pl.droidsonroids.gif;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes4.dex */
public class GifImageButton extends ImageButton {
    private boolean a;

    public GifImageButton(Context context) {
        super(context);
    }

    private void a(d.a aVar) {
        this.a = aVar.a;
        int i = aVar.c;
        if (i > 0) {
            super.setImageResource(i);
        }
        int i2 = aVar.d;
        if (i2 > 0) {
            super.setBackgroundResource(i2);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        gifViewSavedState.a(getDrawable(), 0);
        gifViewSavedState.a(getBackground(), 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new GifViewSavedState(super.onSaveInstanceState(), this.a ? getDrawable() : null, this.a ? getBackground() : null);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (d.e(this, false, i)) {
            return;
        }
        super.setBackgroundResource(i);
    }

    public void setFreezesAnimation(boolean z) {
        this.a = z;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (d.e(this, true, i)) {
            return;
        }
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (d.d(this, uri)) {
            return;
        }
        super.setImageURI(uri);
    }

    public GifImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(d.c(this, attributeSet, 0, 0));
    }

    public GifImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(d.c(this, attributeSet, i, 0));
    }
}
