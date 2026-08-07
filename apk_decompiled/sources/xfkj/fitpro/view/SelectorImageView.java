package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class SelectorImageView extends AppCompatImageView {
    private final String d;
    private int e;

    public SelectorImageView(Context context) {
        this(context, null);
    }

    private void c(AttributeSet attributeSet) {
        setClickable(true);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SelectorImageView);
        this.e = typedArrayObtainStyledAttributes.getColor(0, getResources().getColor(R.color.primaryColor));
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setFilterColor(int i) {
        this.e = i;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        Drawable background = getDrawable() == null ? getBackground() : getDrawable();
        if (background != null) {
            if (z) {
                background.setColorFilter(this.e, PorterDuff.Mode.MULTIPLY);
            } else {
                background.clearColorFilter();
            }
        }
    }

    public SelectorImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = "SelectorImageView";
        c(attributeSet);
    }
}
