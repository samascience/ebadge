package xfkj.fitpro.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes4.dex */
public class DFPFontsTextView extends AppCompatTextView {
    public DFPFontsTextView(Context context) {
        super(context);
        q(context);
    }

    private void q(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/DFPHaiBaoW12.ttf"));
    }

    public DFPFontsTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q(context);
    }
}
