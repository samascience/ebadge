package xfkj.fitpro.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes4.dex */
public class DinengaltFontsTextView extends AppCompatTextView {
    private Typeface h;

    public DinengaltFontsTextView(Context context) {
        super(context);
        q(context);
    }

    private void q(Context context) {
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), "fonts/DINENGALT.TTF");
        this.h = typefaceCreateFromAsset;
        setTypeface(typefaceCreateFromAsset);
    }

    public DinengaltFontsTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q(context);
    }
}
